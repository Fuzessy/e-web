DROP TABLE IF EXISTS transition_tr;
DROP TABLE IF EXISTS state_st;
DROP TABLE IF EXISTS folyamat_fo;
DROP TABLE IF EXISTS folyamat_csoport_fcs;

DROP TABLE IF EXISTS ovi_csoport_tanulo_cst;
DROP TABLE IF EXISTS ovi_csoport_ocs;

DROP TABLE IF EXISTS folyamat_csoport_fcs;
CREATE TABLE folyamat_csoport_fcs
(
    fcs_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    fcs_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS folyamat_fo;
CREATE TABLE folyamat_fo
(
    fo_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    fo_code VARCHAR(50) NOT NULL,
    fcs_id  VARCHAR(250) NOT NULL,
    fo_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS state_st;
CREATE TABLE state_st
(
    st_id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    fo_id           BIGINT NOT NULL,
    st_code         VARCHAR(50) NOT NULL,
    st_description  VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS transition_tr;
CREATE TABLE transition_tr
(
    tr_id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    st_id_from      BIGINT NOT NULL,
    st_id_to        BIGINT NOT NULL,
    st_name         VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS tanulo_tan;
CREATE TABLE tanulo_tan
(
    tan_id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    tan_csaladi_nev     VARCHAR(250) NOT NULL,
    tan_keresztnev      VARCHAR(250) NOT NULL
);


DROP TABLE IF EXISTS dolgozo_dol;
CREATE TABLE dolgozo_dol
(
    dol_id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    dol_csaladi_nev     VARCHAR(250) NOT NULL,
    dol_keresztnev      VARCHAR(250) NOT NULL,
    dol_beosztas        VARCHAR(64) NOT NULL
);


DROP TABLE IF EXISTS ovi_csoport_ocs;
CREATE TABLE ovi_csoport_ocs
(
    ocs_id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    ocs_csoport_nev     VARCHAR(250) NOT NULL,
    ocs_vezeto_dol_id   BIGINT not null
);


DROP TABLE IF EXISTS ovi_csoport_tanulo_cst;
CREATE TABLE ovi_csoport_tanulo_cst
(
    cst_id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    cst_csoport_id  BIGINT NOT NULL,
    cst_tanuo_id    BIGINT NOT NULL
);


ALTER TABLE folyamat_fo ADD CONSTRAINT fk_fo_fcs_id FOREIGN KEY (fcs_id) REFERENCES folyamat_csoport_fcs(fcs_id);
ALTER TABLE state_st ADD CONSTRAINT fk_st_fo_id FOREIGN KEY (fo_id) REFERENCES folyamat_fo(fo_id);
ALTER TABLE transition_tr ADD CONSTRAINT fk_tr_st_id_from FOREIGN KEY (st_id_from) REFERENCES state_st(st_id);
ALTER TABLE transition_tr ADD CONSTRAINT fk_tr_st_id_to FOREIGN KEY (st_id_to) REFERENCES state_st(st_id);

ALTER TABLE ovi_csoport_ocs ADD CONSTRAINT fk_ocs_vezeto_dol_id FOREIGN KEY (ocs_vezeto_dol_id) REFERENCES dolgozo_dol(dol_id);


ALTER TABLE ovi_csoport_tanulo_cst ADD CONSTRAINT fk_cst_csoport_id FOREIGN KEY (cst_csoport_id) REFERENCES ovi_csoport_ocs(ocs_id);
ALTER TABLE ovi_csoport_tanulo_cst ADD CONSTRAINT fk_cst_tanuo_id FOREIGN KEY (cst_tanuo_id) REFERENCES tanulo_tan(tan_id);
