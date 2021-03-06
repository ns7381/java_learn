--创建一个员工基本信息表
CREATE TABLE IF NOT EXISTS `EMPLOYEES`(
   `EMPLOYEE_ID` INT UNSIGNED AUTO_INCREMENT,
   `FIRST_NAME` VARCHAR(100) NOT NULL,
   `LAST_NAME` VARCHAR(40) NOT NULL,
   `EMAIL` VARCHAR(40) NOT NULL,
   `SALARY` float(8,2),
   PRIMARY KEY ( `EMPLOYEE_ID` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--添加数据
	insert into EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, SALARY)
	values (100, 'Steven', 'King', 'SKING', 24000.00);
	
	insert into EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, SALARY)
	values (101, 'Neena', 'Kochhar', 'NKOCHHAR', 17000.00);
	
	insert into EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, SALARY)
	values (102, 'Lex', 'De Haan', 'LDEHAAN', 17000.00);
	
	insert into EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, SALARY)
	values (103, 'Alexander', 'Hunold', 'AHUNOLD', 9000.00);
	
	insert into EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, SALARY)
	values (104, 'Bruce', 'Ernst', 'BERNST', 6000.00);
	
	insert into EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, SALARY)
	values (105, 'David', 'Austin', 'DAUSTIN', 4800.00);
	
	insert into EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, SALARY)
	values (106, 'Valli', 'Pataballa', 'VPATABAL', 4800.00);
	
	insert into EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, SALARY)
	values (107, 'Diana', 'Lorentz', 'DLORENTZ', 4200.00);    