
USE test;

CREATE TABLE Employees (employeeId INT NOT NULL AUTO_INCREMENT,
        firstName varchar(30), lastName varchar(30),
        PRIMARY KEY(employeeId));
        
INSERT INTO Employees (firstName, lastName) VALUES
             ('John', 'Average');

INSERT INTO Employees (firstName, lastName) VALUES
             ('Anne', 'Frank');