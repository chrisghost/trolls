CREATE OR REPLACE FUNCTION hasard() RETURNS BOOLEAN AS $$
DECLARE
    -- declarations
BEGIN
    RETURN random() >= 0.80;
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

	SELECT SUM(potion.bonusattaque) INTO nb FROM potion, sad WHERE sad.id_objet = potion.id_objet AND sad.nomtroll = n_troll AND potion.use = 1;
	RETURN nb;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION bonus_degats(varchar) RETURNS INTEGER AS $$
DECLARE
	n_troll ALIAS FOR $1;
	nb int;
BEGIN

	SELECT SUM(potion.bonusdegat) INTO nb FROM potion, sad WHERE sad.id_objet = potion.id_objet AND sad.nomtroll = n_troll AND potion.use = 1;
	RETURN nb;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION bonus_esquive(varchar) RETURNS INTEGER AS $$
DECLARE
	n_troll ALIAS FOR $1;
	nb int;
BEGIN

	SELECT SUM(potion.bonusesquive) INTO nb FROM potion, sad WHERE sad.id_objet = potion.id_objet AND sad.nomtroll = n_troll AND potion.use = 1;
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

