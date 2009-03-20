CREATE OR REPLACE FUNCTION hasard() RETURNS BOOLEAN AS $$
DECLARE
    -- declarations
BEGIN
    RETURN random() <= 0.80;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION dé() RETURNS INTEGER AS $$

BEGIN
	RETURN round((random()*2)+1);
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION fini() RETURNS BOOLEAN AS $$
DECLARE

	nb int;

BEGIN
	SELECT COUNT(*) INTO nb FROM troll WHERE vie <= 0;
	RETURN nb >= 1;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION bonus_attaque(varchar) RETURNS INTEGER AS $$
DECLARE
	n_troll ALIAS FOR $1;
	nb int;
BEGIN

	SELECT arme.bonusattaque INTO nb FROM arme, sad, troll WHERE troll.id_equip_arme = arme.id_objet AND troll.nom = n_troll ;
	IF nb IS NULL THEN
		nb := 0;
	END IF;
		
	RETURN nb;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION bonus_degats(varchar) RETURNS INTEGER AS $$
DECLARE
	n_troll ALIAS FOR $1;
	nb int;
BEGIN

	SELECT arme.bonusdegat INTO nb FROM arme, sad, troll WHERE troll.id_equip_arme = arme.id_objet AND troll.nom = n_troll; 
	IF nb IS NULL THEN
		nb := 0;
	END IF;
	RETURN nb;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION bonus_esquive(varchar) RETURNS INTEGER AS $$
DECLARE
	n_troll ALIAS FOR $1;
	nb int;
BEGIN

	SELECT arme.bonusesquive INTO nb FROM  arme, sad, troll WHERE troll.id_equip_arme = arme.id_objet AND troll.nom = n_troll; 
	IF nb IS NULL THEN
		nb := 0;
	END IF;
	RETURN nb;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION combat(varchar,varchar) RETURNS INTEGER AS $$ 
-- RETURN : x = nb pts infligés, -1 = attaque esquivée
DECLARE

	attaquant ALIAS FOR $1;
	defenseur ALIAS FOR $2;
	pts_att int;
	pts_esq int;
	pts_deg int;
BEGIN
	SELECT attaque INTO pts_att FROM troll WHERE troll.nom = attaquant;
	SELECT esquive INTO pts_esq FROM troll WHERE troll.nom = defenseur;
	SELECT degats INTO pts_deg FROM troll WHERE troll.nom = attaquant;

	pts_att := pts_att * dé() + bonus_attaque(attaquant);
	pts_esq := pts_esq * dé() + bonus_esquive(defenseur);
	pts_deg := pts_deg * dé() + bonus_degats(attaquant);

	IF pts_att > pts_esq THEN
		UPDATE troll SET vie = troll.vie - pts_deg WHERE nom = defenseur;
		RETURN pts_deg;
	ELSE
		RETURN -1;
	END IF;

END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION distance(varchar,varchar) RETURNS INTEGER AS $$
DECLARE
	troll1 ALIAS FOR $1;
	troll2 ALIAS FOR $2;
	
	x1 int;
	y1 int;
	x2 int;
	y2 int;
BEGIN
	SELECT x INTO x1 FROM troll WHERE nom = troll1; 
	SELECT y INTO y1 FROM troll WHERE nom = troll1;
	SELECT x INTO x2 FROM troll WHERE nom = troll2;
	SELECT y INTO y2 FROM troll WHERE nom = troll2;

	x1 := x1 - x2;
	y1 := y1 - y2;
	IF x1 < 0 THEN
		x1 := x1 * -1;
	END IF;
	IF y1 < 0 THEN
		y1 := y1 * -1;
	END IF;

	RETURN round(sqrt(x1*x1+y1*y1));

END;
$$ LANGUAGE plpgsql;



CREATE OR REPLACE FUNCTION portee(varchar) RETURNS BOOLEAN AS $$
DECLARE
	troll_n ALIAS FOR $1;
	troll2 varchar;
BEGIN
	SELECT nom INTO troll2 FROM troll WHERE nom != troll_n;
	RETURN (distance(troll_n,troll2)<=(SELECT portee FROM arme, troll WHERE arme.id_objet = troll.id_equip_arme AND troll.nom = troll_n));
END;
$$ LANGUAGE plpgsql;



CREATE OR REPLACE FUNCTION deplacement(varchar,integer,integer, integer) RETURNS BOOLEAN AS $$
DECLARE
	troll_n ALIAS FOR $1;
	x_d ALIAS FOR $2;
	y_d ALIAS FOR $3;
	prix ALIAS FOR $4;
	
BEGIN
	UPDATE troll SET pa = pa - prix WHERE nom = troll_n;
	IF (hasard()) THEN
		UPDATE troll SET x = x_d WHERE nom = troll_n;
		UPDATE troll SET y = y_d WHERE nom = troll_n;
		RETURN true;
	ELSE
		RETURN false;
	END IF;

END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION maj_potions() RETURNS VOID AS $$
DECLARE
pot potion%ROWTYPE;
BEGIN
	UPDATE potion SET duree = duree - 1 WHERE use = 1;
	
	FOR pot IN
		SELECT * FROM potion WHERE duree = 0
	LOOP
		UPDATE troll SET attaque = attaque - pot.bonusattaque, degats = degats - pot.bonusdegat,
			esquive = esquive - pot.bonusesquive WHERE troll.nom = sad.nomtroll AND sad.id_objet = pot.id_objet;
		DELETE FROM sad WHERE id_objet = pot.id_objet;
		DELETE FROM potion WHERE id_objet = pot.id_objet;
	END LOOP;
	
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION ramasser(integer,integer,varchar) RETURNS INTEGER AS $$
DECLARE
	r integer;
BEGIN
	UPDATE troll SET pa = pa - 1 WHERE nom = $3;
	SELECT id_objet INTO r FROM cell WHERE x = $1 AND y = $2;
	IF r IS NULL THEN
		RETURN 0;
	ELSE
		RETURN r;
	END IF;
END;
$$ LANGUAGE plpgsql;


