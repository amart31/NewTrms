create sequence employee_seq
increment by 1
minvalue 0
start with 4;


create sequence form_seq
increment by 1
minvalue 0
start with 0;

create sequence optional_info_seq
increment by 1
minvalue 0
start with 0;


drop table if exists trms_employees cascade;

create table trms_employees(
employee_id integer primary key,
username varchar(25),
employee_password varchar(40) not null,
--email_address varchar(40),         --delete this??
direct_supervisor_id integer,
department varchar(10),
pending_reimbursement numeric(10,2) default 0.00,
awarded_reimbursement numeric(10,2) default 0.00,
department_head bool default false,
benefits_coordinator bool default false
);


insert into trms_employees (employee_id, username, employee_password, department,direct_supervisor_id) values (1, 'andy', '123','thisdep',2);


create table trms_forms(
form_id integer primary key,
employee_id integer not null,
direct_supervisor_id integer not null,
submit_date date not null, --integer or date??
submit_time time not null,
event_location varchar(40) not null,
description varchar(40) not null,
event_cost numeric(10,2),
grading_format integer not null,
type_of_event varchar(40) not null,
justification varchar(40) not null,
department varchar(10) not null,
grade_type integer not null, --this can be grade or present, pull from a reference table
grade numeric(3,2),
urgent bool default false,
direct_supervisor_approved bool default false,
department_head_approved bool default false,
benefits_coordinator_approved bool default false,
final_confirmation bool default false,
denied boolean default false
);


drop table if exists trms_forms  cascade;
-- optional info will be stored in a folder on server side
-- this only saves the names of the files
create table trms_optional_info(
info_id integer primary key,
form_id integer not null,
info_name varchar(40) -- this would be for pdf, png,, jpeg, txt or doc files
);


create table grading_formats(
format_id integer primary key,
grade_format varchar(33),
grade boolean
);

--------------------------------------------


