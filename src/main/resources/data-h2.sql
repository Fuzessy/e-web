
insert into FOLYAMAT_CSOPORT_FCS (fcs_id, fcs_name) values (1, 'Dolgozók');
insert into FOLYAMAT_CSOPORT_FCS (fcs_id, fcs_name) values (2, 'Tanulók');

INSERT INTO PUBLIC.FOLYAMAT_FO (FO_ID, FCS_ID, FO_CODE, FO_NAME) VALUES (1, 1, 'DOLGOZO_ROGZITES', 'Dolgozó rögzítése');
INSERT INTO PUBLIC.FOLYAMAT_FO (FO_ID, FCS_ID, FO_CODE, FO_NAME)VALUES (2, 1, 'DOLGOZO_MODOSITAS','Dolgozó adatainak módosítása');

INSERT INTO PUBLIC.FOLYAMAT_FO (FO_ID, FCS_ID, FO_CODE, FO_NAME) VALUES (3, 2, 'TANULO_ROGZITES', 'Tanuló felvétele');
INSERT INTO PUBLIC.FOLYAMAT_FO (FO_ID, FCS_ID, FO_CODE, FO_NAME)VALUES (4, 2, 'TANULO_CSOPORTHOZ_RENDELES','Tanulo csoporthoz rendelés');
INSERT INTO PUBLIC.FOLYAMAT_FO (FO_ID, FCS_ID, FO_CODE, FO_NAME)VALUES (5, 2, 'TANULO_CSOPORTJANAK_MODOSITASA_KERELEMRE','Tanuló áthelyezése kérelemre');

/*
    TANULO_CSOPORTJANAK_MODOSITASA_KERELEMRE

    TANULO_KIJELOLES ----> CSOPORT_VALASZTAS ----> JOVAHAGYASRA_VAR -------> JOVAHAGYVA
                                    I                     I
                                    I                     V
                                    +--------------> ELUTASITVA

    TANULO_KIJELOLES   - Tanuló kiválasztása áthelyezésre
    CSOPORT_VALASZTAS  - Csoport választás
    JOVAHAGYASRA_VAR   - Jóváhagyásra vár
    ELUTASITVA          - Áthelyezés elutasítása
    JOVAHAGYVA          - Áthelyezés jóváhagyása

*/

INSERT INTO state_st (st_id, fo_id, st_code, st_description) VALUES ( 1, 5, 'TANULO_KIJELOLES', 'Tanuló kiválasztása áthelyezésre');
INSERT INTO state_st (st_id, fo_id, st_code, st_description) VALUES ( 2, 5, 'CSOPORT_VALASZTAS', 'Csoport választás');
INSERT INTO state_st (st_id, fo_id, st_code, st_description) VALUES ( 3, 5, 'JOVAHAGYASRA_VAR', 'Jóváhagyásra vár');
INSERT INTO state_st (st_id, fo_id, st_code, st_description) VALUES ( 4, 5, 'ELUTASITVA', 'Áthelyezés elutasítása');
INSERT INTO state_st (st_id, fo_id, st_code, st_description) VALUES ( 5, 5, 'JOVAHAGYVA', 'Áthelyezés jóváhagyása');

INSERT INTO TRANSITION_TR (tr_id, st_id_from, st_id_to, st_name) VALUES ( 1, 1, 2, 'Csoport választás' );
INSERT INTO TRANSITION_TR (tr_id, st_id_from, st_id_to, st_name) VALUES ( 2, 2, 3, 'Átadás jóváhagyásra' );
INSERT INTO TRANSITION_TR (tr_id, st_id_from, st_id_to, st_name) VALUES ( 3, 3, 4, 'Elutasítás' );
INSERT INTO TRANSITION_TR (tr_id, st_id_from, st_id_to, st_name) VALUES ( 4, 2, 4, 'Elutasítás' );
INSERT INTO TRANSITION_TR (tr_id, st_id_from, st_id_to, st_name) VALUES ( 5, 3, 5, 'Jóváhagyás' );


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
