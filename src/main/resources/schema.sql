create table Department (
	departmentId identity,
	departmentName varchar(255) unique not null,
	departmentEmail varchar(255) not null
);
INSERT INTO Department (departmentName,departmentEmail) VALUES ('Production','production@poet.com');
INSERT INTO Department (departmentName,departmentEmail) VALUES ('Research and Development','r&d@poet.com');
INSERT INTO Department (departmentName,departmentEmail) VALUES ('Marketing','marketing@poet.com');
INSERT INTO Department (departmentName,departmentEmail) VALUES ('Human Resource Management','hr@poet.com');
INSERT INTO Department (departmentName,departmentEmail) VALUES ('Accounting and Finance','accounting@poet.com');
create table Employee(
	id identity,
	name varchar(255) unique not null ,
	jobTitle varchar(255) not null,
	department int not null,
	email varchar(255) unique not null,
	dataofBirth date,
	salary long not null,
	FOREIGN KEY (department) REFERENCES  Department(departmentId )
);
INSERT INTO Employee(name, jobTitle, department, email, salary) VALUES ('ahmed','Software',2,'ahmed@poet.com',2321);
INSERT INTO Employee(name, jobTitle, department, email, salary) VALUES ('hossam','Software',2,'hossam@poet.com',2321);
INSERT INTO Employee(name, jobTitle, department, email, salary) VALUES ('kariem','Software',2,'kariem@poet.com',2321);