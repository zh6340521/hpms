项目技术人员应此处描述一些项目基本信息，及注意事项：

* 1，使用的技术介绍

* 2，主要功能

* 3，配置信息

a，编译整个项目

mvn clean install -Dmaven.test.skip=true

b，本地数据库需要创建表空间及用户

CREATE BIGFILE TABLESPACE tbs_perm_hpms
    DATAFILE 'tbs_perm_hpms.dat'
    SIZE 10M
    AUTOEXTEND ON;  
    
CREATE TEMPORARY TABLESPACE tbs_temp_hpms
    TEMPFILE 'tbs_temp_hpms.dbf'
    SIZE 5M
    AUTOEXTEND ON;  
    
CREATE USER hpms
    IDENTIFIED BY hpms
    DEFAULT TABLESPACE tbs_perm_hpms
    TEMPORARY TABLESPACE tbs_temp_hpms
    QUOTA 20M on tbs_perm_hpms;
    
GRANT create session TO hpms;
GRANT create table TO hpms;
GRANT create view TO hpms;
GRANT create any trigger TO hpms;
GRANT create any procedure TO hpms;
GRANT create sequence TO hpms;
GRANT create synonym TO hpms;

c，初始化本地数据库

mvn process-resources -D skipLiquibaseRun=false -D db.driver=oracle.jdbc.driver.OracleDriver -D db.url=jdbc:oracle:thin:@localhost:1521:DEV -Ddb.user=hpms -Ddb.password=hpms


