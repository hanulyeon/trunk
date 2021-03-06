-- @HyperData Web Server 1.0 @Meta DB @Drop Meta

-- MODEL Table Drop SQL
DROP TABLE MODEL
/
-- MODEL_ID_SEQ Sequence Drop SQL
DROP SEQUENCE MODEL_ID_SEQ
/
-- PROJECT_ID_SEQ Sequence Drop SQL
DROP SEQUENCE PROJECT_ID_SEQ
/
-- PROJECT Table Drop SQL
DROP TABLE PROJECT
/

-- OLAP META TABLE DROP SQL
ALTER TABLE OLAP_MODEL_INFO
DROP CONSTRAINT FK_OLAP_MODEL_INFO
/

ALTER TABLE OLAP_MODEL_PARAM
DROP CONSTRAINT FK_OLAP_MODEL_PARAM
/

ALTER TABLE OLAP_CUBE_INFO
DROP CONSTRAINT FK_OLAP_CUBE_INFO
/

ALTER TABLE OLAP_CUBE_FACT_PARAM
DROP CONSTRAINT FK_OLAP_CUBE_FACT_PARAM
/

ALTER TABLE OLAP_CUBE_MEASURE_PARAM
DROP CONSTRAINT FK_OLAP_CUBE_MEASURE_PARAM
/

ALTER TABLE OLAP_CUBE_DIM_PARAM
DROP CONSTRAINT FK_OLAP_CUBE_DIM_PARAM
/

DROP TABLE OLAP_PROJECT_INFO
/

DROP SEQUENCE OLAP_PROJECT_INFO_ID_SEQ
/

DROP TABLE OLAP_MODEL_INFO
/

DROP SEQUENCE OLAP_MODEL_INFO_ID_SEQ
/

DROP TABLE OLAP_MODEL_PARAM
/


DROP SEQUENCE OLAP_CUBE_INFO_ID_SEQ
/

DROP TABLE OLAP_CUBE_INFO
/

DROP TABLE OLAP_CUBE_FACT_PARAM
/

DROP TABLE OLAP_CUBE_DIM_PARAM
/

DROP TABLE OLAP_CUBE_MEASURE_PARAM
/

DROP TABLE FACT_TABLE_INFO
/

DROP SEQUENCE FACT_TABLE_INFO_ID_SEQ
/

DROP TABLE DIM_TABLE_INFO
/

DROP SEQUENCE DIM_TABLE_INFO_ID_SEQ
/



