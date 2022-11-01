-- Gerado por Oracle SQL Developer Data Modeler 21.1.0.092.1221
--   em:        2021-05-17 20:36:08 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE t_alimentacao (
    cd_alimento                VARCHAR2(30) NOT NULL,
    nm_alimento                VARCHAR2(50) NOT NULL,
    qt_caloria                 NUMBER(8, 6),
    t_atividades_cd_atividade  VARCHAR2(10) NOT NULL
);

ALTER TABLE t_alimentacao ADD CONSTRAINT t_alimentacao_pk PRIMARY KEY ( cd_alimento );

CREATE TABLE t_atividades (
    cd_atividade  VARCHAR2(10) NOT NULL,
    nm_atividade  VARCHAR2(50) NOT NULL,
    at_historico  VARCHAR2(30),
    cd_usuário    VARCHAR2(40) NOT NULL
);

ALTER TABLE t_atividades ADD CONSTRAINT t_atividades_pk PRIMARY KEY ( cd_atividade );

CREATE TABLE t_exercicio (
    cd_exercicio               NUMBER(4) NOT NULL,
    qt_tempo                   VARCHAR2(20) NOT NULL,
    nv_dificuldade             VARCHAR2(20) NOT NULL,
    t_atividades_cd_atividade  VARCHAR2(10) NOT NULL
);

ALTER TABLE t_exercicio ADD CONSTRAINT t_exercicio_pk PRIMARY KEY ( cd_exercicio );

CREATE TABLE t_foto (
    cd_foto                        VARCHAR2(50) NOT NULL,
    ft_descrição                   VARCHAR2(50),
    ft_like                        NUMBER(8),
    ft_comentario                  VARCHAR2(500),
    t_perfil_t_usuario_cd_usuário  VARCHAR2(40) NOT NULL
);

ALTER TABLE t_foto ADD CONSTRAINT t_foto_pk PRIMARY KEY ( cd_foto );

CREATE TABLE t_leitura (
    cd_livro                   VARCHAR2(10) NOT NULL,
    nm_livro                   VARCHAR2(40) NOT NULL,
    dt_inicio_leitura          VARCHAR2(10),
    dt_fim_leitura             VARCHAR2(10),
    t_atividades_cd_atividade  VARCHAR2(10) NOT NULL
);

ALTER TABLE t_leitura ADD CONSTRAINT t_leitura_pk PRIMARY KEY ( cd_livro );

CREATE TABLE t_perfil (
    t_usuario_cd_usuário  VARCHAR2(40) NOT NULL,
    us_peso               NUMBER(5, 3),
    us_altura             NUMBER(3, 1),
    us_idade              NUMBER(3),
    us_video              BLOB
);

ALTER TABLE t_perfil ADD CONSTRAINT t_perfil_pk PRIMARY KEY ( t_usuario_cd_usuário );

CREATE TABLE t_usuario (
    cd_usuário     VARCHAR2(40) NOT NULL,
    nm_usuário     VARCHAR2(50) NOT NULL,
    dt_nascimento  NUMBER(8) NOT NULL,
    ed_email       VARCHAR2(50) NOT NULL
);

ALTER TABLE t_usuario ADD CONSTRAINT t_usuario_pk PRIMARY KEY ( cd_usuário );

CREATE TABLE t_video (
    cd_video                       VARCHAR2(50) NOT NULL,
    vd_descrição                   VARCHAR2(50),
    vd_like                        NUMBER(8),
    vd_comentario                  VARCHAR2(500),
    t_perfil_t_usuario_cd_usuário  VARCHAR2(40) NOT NULL
);

ALTER TABLE t_video ADD CONSTRAINT t_video_pk PRIMARY KEY ( cd_video );

ALTER TABLE t_alimentacao
    ADD CONSTRAINT t_alimentacao_t_atividades_fk FOREIGN KEY ( t_atividades_cd_atividade )
        REFERENCES t_atividades ( cd_atividade );

ALTER TABLE t_atividades
    ADD CONSTRAINT t_atividades_t_perfil_fk FOREIGN KEY ( cd_usuário )
        REFERENCES t_perfil ( t_usuario_cd_usuário );

ALTER TABLE t_exercicio
    ADD CONSTRAINT t_exercicio_t_atividades_fk FOREIGN KEY ( t_atividades_cd_atividade )
        REFERENCES t_atividades ( cd_atividade );

ALTER TABLE t_foto
    ADD CONSTRAINT t_foto_t_perfil_fk FOREIGN KEY ( t_perfil_t_usuario_cd_usuário )
        REFERENCES t_perfil ( t_usuario_cd_usuário );

ALTER TABLE t_leitura
    ADD CONSTRAINT t_leitura_t_atividades_fk FOREIGN KEY ( t_atividades_cd_atividade )
        REFERENCES t_atividades ( cd_atividade );

ALTER TABLE t_perfil
    ADD CONSTRAINT t_perfil_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuário )
        REFERENCES t_usuario ( cd_usuário );

ALTER TABLE t_video
    ADD CONSTRAINT t_video_t_perfil_fk FOREIGN KEY ( t_perfil_t_usuario_cd_usuário )
        REFERENCES t_perfil ( t_usuario_cd_usuário );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             0
-- ALTER TABLE                             15
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
