
-----------------------------------------------------------------------------
-- troll
-----------------------------------------------------------------------------
DROP TABLE troll CASCADE;



CREATE TABLE troll
(
    nom VARCHAR(128) NOT NULL,
    attaque INTEGER,
    degats INTEGER,
    vie INTEGER,
    esquive INTEGER,
    pa INTEGER,
    x INTEGER NOT NULL,
    y INTEGER NOT NULL,
    id_equip_arme INTEGER,
    id_equip_protect INTEGER,
    PRIMARY KEY (nom)
);

COMMENT ON TABLE troll IS 'Troll_s_';

COMMENT ON COLUMN troll.nom IS 'Nom du troll';
COMMENT ON COLUMN troll.attaque IS 'Points d'attaque';
COMMENT ON COLUMN troll.degats IS 'Points de degat';
COMMENT ON COLUMN troll.vie IS 'Points de vie';
COMMENT ON COLUMN troll.esquive IS 'Points d'esquive';
COMMENT ON COLUMN troll.pa IS 'Points d'action';
COMMENT ON COLUMN troll.x IS 'absisse_case';
COMMENT ON COLUMN troll.y IS 'ordonne_case';
COMMENT ON COLUMN troll.id_equip_arme IS 'id de l'arme Ã©quipÃ©e';
COMMENT ON COLUMN troll.id_equip_protect IS 'id de la protection Ã©quipÃ©e';


-----------------------------------------------------------------------------
-- map
-----------------------------------------------------------------------------
DROP TABLE map CASCADE;



CREATE TABLE map
(
    x INTEGER NOT NULL,
    y INTEGER NOT NULL,
    nom VARCHAR(128) NOT NULL,
    PRIMARY KEY (x,y)
);

COMMENT ON TABLE map IS 'Infos sur la carte';

COMMENT ON COLUMN map.x IS 'taille en x';
COMMENT ON COLUMN map.y IS 'taille en y';
COMMENT ON COLUMN map.nom IS 'nom de la map';


-----------------------------------------------------------------------------
-- cell
-----------------------------------------------------------------------------
DROP TABLE cell CASCADE;



CREATE TABLE cell
(
    x INTEGER NOT NULL,
    y INTEGER NOT NULL,
    id_objet INTEGER NOT NULL,
    PRIMARY KEY (x,y)
);

COMMENT ON TABLE cell IS 'Cell_s_';

COMMENT ON COLUMN cell.x IS 'absisse_case';
COMMENT ON COLUMN cell.y IS 'ordonne_case';
COMMENT ON COLUMN cell.id_objet IS 'id_de_l_objet';


-----------------------------------------------------------------------------
-- objet
-----------------------------------------------------------------------------
DROP TABLE objet CASCADE;
DROP SEQUENCE objet_SEQ;


CREATE SEQUENCE objet_SEQ INCREMENT BY 1 START WITH 1 NO MAXVALUE NO CYCLE;

CREATE TABLE objet
(
    id INTEGER NOT NULL,
    truc VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

COMMENT ON TABLE objet IS 'Objets';

COMMENT ON COLUMN objet.id IS 'id_de_l_objet';
COMMENT ON COLUMN objet.truc IS 'truc';


-----------------------------------------------------------------------------
-- arme
-----------------------------------------------------------------------------
DROP TABLE arme CASCADE;



CREATE TABLE arme
(
    id_objet INTEGER NOT NULL,
    nom VARCHAR(128) NOT NULL,
    bonusAttaque INTEGER NOT NULL,
    bonusDegat INTEGER NOT NULL,
    bonusEsquive INTEGER NOT NULL,
    portee INTEGER,
    PRIMARY KEY (id_objet)
);

COMMENT ON TABLE arme IS 'Armes';

COMMENT ON COLUMN arme.id_objet IS 'identifiant_objet_de_l_arme';
COMMENT ON COLUMN arme.nom IS 'nom_de_l_arme';
COMMENT ON COLUMN arme.bonusAttaque IS 'bonus_attaque_de_l_arme';
COMMENT ON COLUMN arme.bonusDegat IS 'bonus_degat_de_l_arme';
COMMENT ON COLUMN arme.bonusEsquive IS 'bonus_esquive_de_l_arme';
COMMENT ON COLUMN arme.portee IS 'portee_de_l_arme';


-----------------------------------------------------------------------------
-- potion
-----------------------------------------------------------------------------
DROP TABLE potion CASCADE;



CREATE TABLE potion
(
    id_objet INTEGER NOT NULL,
    nom VARCHAR(128) NOT NULL,
    bonusAttaque INTEGER NOT NULL,
    bonusDegat INTEGER NOT NULL,
    bonusEsquive INTEGER NOT NULL,
    bonusVie INTEGER NOT NULL,
    duree INTEGER NOT NULL,
    use INT2,
    PRIMARY KEY (id_objet)
);

COMMENT ON TABLE potion IS 'Potions';

COMMENT ON COLUMN potion.id_objet IS 'identifiant_objet_de_la_potion';
COMMENT ON COLUMN potion.nom IS 'nom_de_la_potion';
COMMENT ON COLUMN potion.bonusAttaque IS 'bonus_attaque_de_la_potion';
COMMENT ON COLUMN potion.bonusDegat IS 'bonus_degat_de_la_potion';
COMMENT ON COLUMN potion.bonusEsquive IS 'bonus_esquive_de_la_potion';
COMMENT ON COLUMN potion.bonusVie IS 'bonus_vie_de_la_potion';
COMMENT ON COLUMN potion.duree IS 'duree_de_la_potion';
COMMENT ON COLUMN potion.use IS 'Si vrai, potion utilisÃ©e Ã  l'instant t';


-----------------------------------------------------------------------------
-- sad
-----------------------------------------------------------------------------
DROP TABLE sad CASCADE;



CREATE TABLE sad
(
    nomTroll VARCHAR(128) NOT NULL,
    id_Objet INTEGER NOT NULL,
    PRIMARY KEY (nomTroll,id_Objet)
);

COMMENT ON TABLE sad IS 'Sac_a_Dos';

COMMENT ON COLUMN sad.nomTroll IS 'nom_du_troll';
COMMENT ON COLUMN sad.id_Objet IS 'id_objet';


----------------------------------------------------------------------
-- sad
----------------------------------------------------------------------



----------------------------------------------------------------------
-- troll
----------------------------------------------------------------------



----------------------------------------------------------------------
-- map
----------------------------------------------------------------------


ALTER TABLE cell
    ADD CONSTRAINT cell_FK_1 FOREIGN KEY (id_objet)
    REFERENCES objet (id)
;

----------------------------------------------------------------------
-- cell
----------------------------------------------------------------------



----------------------------------------------------------------------
-- objet
----------------------------------------------------------------------


ALTER TABLE arme
    ADD CONSTRAINT arme_FK_1 FOREIGN KEY (id_objet)
    REFERENCES objet (id)
;

----------------------------------------------------------------------
-- arme
----------------------------------------------------------------------


ALTER TABLE potion
    ADD CONSTRAINT potion_FK_1 FOREIGN KEY (id_objet)
    REFERENCES objet (id)
;

----------------------------------------------------------------------
-- potion
----------------------------------------------------------------------


ALTER TABLE sad
    ADD CONSTRAINT sad_FK_1 FOREIGN KEY (nomTroll)
    REFERENCES troll (nom)
;
ALTER TABLE sad
    ADD CONSTRAINT sad_FK_2 FOREIGN KEY (id_Objet)
    REFERENCES objet (id)
;
