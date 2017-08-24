set pages 0
set linesize 200
set echo off
set heads off
set verify off
set feedback off

-------------------------------------------
-- RUN as Sys                            --
-------------------------------------------
spool create_reports_schema_result

accept sys_password prompt "Enter SYS ADMIN Password: "

select to_char(sysdate, 'yyyy-mm-dd  hh24:mi:ss') from dual;

prompt 'Connecting to SYS User..'
conn sys/&sys_password as sysdba

create user activitidb identified by activitidb;
grant connect, resource, dba to activitidb;

prompt 'Connecting to Person db..'
conn activitidb/activitidb

create table person(id number, userName varchar(20), age number, email varchar(50), taskId varchar(200));

CREATE SEQUENCE person_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

select to_char(sysdate, 'yyyy-mm-dd  hh24:mi:ss') from dual;

spool off