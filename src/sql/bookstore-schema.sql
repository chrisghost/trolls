
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
    PRIMARY KEY (nom)
);

COMMENT ON TABLE troll IS 'Troll_s_';

COMMENT ON COLUMN troll.nom IS 'Nom du troll';
COMMENT ON COLUMN troll.attaque IS 'Points d'attaque';
COMMENT ON COLUMN troll.degats IS 'Points de degat';
COMMENT ON COLUMN troll.vie IS 'Points de vie';
COMMENT ON COLUMN troll.esquive IS 'Points d'esquive';
COMMENT ON COLUMN troll.pa IS 'Points d'action';


----------------------------------------------------------------------
-- troll
----------------------------------------------------------------------


