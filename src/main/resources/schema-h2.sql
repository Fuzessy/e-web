
DROP TABLE IF EXISTS folyamat_csoport_fcs;
CREATE TABLE folyamat_csoport_fcs
(
    fcs_id   INT AUTO_INCREMENT PRIMARY KEY,
    fcs_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS folyamat_fo;
CREATE TABLE folyamat_fo
(
    fo_id   INT AUTO_INCREMENT PRIMARY KEY,
    fo_kod VARCHAR(50) NOT NULL,
    fcs_id  VARCHAR(250) NOT NULL,
    fo_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS tanulo_tan;
CREATE TABLE TANULO_TAN
(
    TAN_ID              INT AUTO_INCREMENT PRIMARY KEY,
    TAN_CSALADI_NEV     VARCHAR(250) NOT NULL,
    TAN_KERESZTNEV      VARCHAR(250) NOT NULL
);


DROP TABLE IF EXISTS DOLGOZO_DOL;
CREATE TABLE DOLGOZO_DOL
(
    DOL_ID              INT AUTO_INCREMENT PRIMARY KEY,
    DOL_CSALADI_NEV     VARCHAR(250) NOT NULL,
    DOL_KERESZTNEV      VARCHAR(250) NOT NULL,
    DOL_BEOSZTAS        VARCHAR(64) NOT NULL
);


DROP TABLE IF EXISTS OVI_CSOPORT_OCS;
CREATE TABLE OVI_CSOPORT_OCS
(
    OCS_ID              INT AUTO_INCREMENT PRIMARY KEY,
    OCS_CSOPORT_NEV     VARCHAR(250) NOT NULL,
    OCS_VEZETO_DOL_ID          INT NOT NULL
);


DROP TABLE IF EXISTS OVI_CSOPORT_TANULO_CST;
CREATE TABLE OVI_CSOPORT_TANULO_CST
(
    CST_ID          INT AUTO_INCREMENT PRIMARY KEY,
    CST_CSOPORT_ID  INT NOT NULL,
    CST_TANUO_ID    INT NOT NULL
);

/*
    TANULO_ROGZITES
    -----------------> ADATOK_ROGZITESE -------------> ROGZITETT

*/
