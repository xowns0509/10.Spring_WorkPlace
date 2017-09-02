
create table employees (
username varchar2(30),
password varchar2(30),
enabled varchar2(5)
);

create table roles(
username varchar2(30),
role varchar2(20)
);

insert into employees values('javaman', '1111','1');

insert into employees values('xman', '9999','1');


insert into roles values('javaman', 'Admin');
insert into roles values('javaman', 'User');
insert into roles values('xman', 'User');
commit;