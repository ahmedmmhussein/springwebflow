create table Department (
	departmentId identity,
	departmentName varchar(255) unique not null
);
INSERT INTO Department (departmentName) VALUES ('Production');
INSERT INTO Department (departmentName) VALUES ('Research and Development');
INSERT INTO Department (departmentName) VALUES ('Marketing');
INSERT INTO Department (departmentName) VALUES ('Human Resource Management');
INSERT INTO Department (departmentName) VALUES ('Accounting and Finance');
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