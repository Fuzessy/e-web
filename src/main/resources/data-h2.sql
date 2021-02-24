
insert into FOLYAMAT_CSOPORT_FCS (fcs_id, fcs_name) values (1, 'Dolgozók');
insert into FOLYAMAT_CSOPORT_FCS (fcs_id, fcs_name) values (2, 'Tanulók');

INSERT INTO PUBLIC.FOLYAMAT_FO (FO_ID, FCS_ID, FO_KOD, FO_NAME) VALUES (1, 1, 'DOLGOZO_ROGZITES', 'Dolgozó rögzítése');
INSERT INTO PUBLIC.FOLYAMAT_FO (FO_ID, FCS_ID, FO_KOD, FO_NAME)VALUES (2, 1, 'DOLGOZO_MODOSITAS','Dolgozó adatainak módosítása');

INSERT INTO PUBLIC.FOLYAMAT_FO (FO_ID, FCS_ID, FO_KOD, FO_NAME) VALUES (3, 2, 'TANULO_ROGZITES', 'Tanuló felvétele');
INSERT INTO PUBLIC.FOLYAMAT_FO (FO_ID, FCS_ID, FO_KOD, FO_NAME)VALUES (4, 2, 'TANULO_CSOPORTHOZ_RENDELES','Tanulo csoporthoz rendelés');



INSERT INTO PUBLIC.TANULO_TAN (TAN_ID, TAN_CSALADI_NEV, TAN_KERESZTNEV) values (1,'FÜZESI', 'OLIVÉR');
INSERT INTO PUBLIC.TANULO_TAN (TAN_ID, TAN_CSALADI_NEV, TAN_KERESZTNEV) values (2,'FÜZESI', 'MARCELL');
INSERT INTO PUBLIC.TANULO_TAN (TAN_ID, TAN_CSALADI_NEV, TAN_KERESZTNEV) values (3,'MICI', 'MACI');
INSERT INTO PUBLIC.DOLGOZO_DOL (DOL_ID, DOL_CSALADI_NEV, DOL_KERESZTNEV, DOL_BEOSZTAS) values (1,'FÜZESI', 'ZSOLT','UDVARI BOHÓC');
INSERT INTO PUBLIC.DOLGOZO_DOL (DOL_ID, DOL_CSALADI_NEV, DOL_KERESZTNEV, DOL_BEOSZTAS) values (2,'ECSERI', 'BARBARA','ÓVÓNÉNI');

INSERT INTO PUBLIC.OVI_CSOPORT_OCS (OCS_ID, OCS_CSOPORT_NEV, OCS_VEZETO_DOL_ID) VALUES (1,'ALMA CSOPORT',1);
INSERT INTO PUBLIC.OVI_CSOPORT_OCS (OCS_ID, OCS_CSOPORT_NEV, OCS_VEZETO_DOL_ID) VALUES (2,'BANÁN CSOPORT',2);

INSERT INTO PUBLIC.OVI_CSOPORT_TANULO_CST (CST_ID, CST_CSOPORT_ID, CST_TANUO_ID) VALUES (1, 1, 1);
INSERT INTO PUBLIC.OVI_CSOPORT_TANULO_CST (CST_ID, CST_CSOPORT_ID, CST_TANUO_ID) VALUES (2, 2, 2);
INSERT INTO PUBLIC.OVI_CSOPORT_TANULO_CST (CST_ID, CST_CSOPORT_ID, CST_TANUO_ID) VALUES (3, 1, 3);