-- /Applications/XAMPP/xamppfiles/bin/mysql -u root < <path-to-sql-file> 

DROP DATABASE Brokerage;

CREATE DATABASE Brokerage;

use Brokerage;

CREATE TABLE Properties(
	PropertyID INT PRIMARY KEY,
	AgentName VARCHAR(255) NOT NULL,
	AskingPrice INT NOT NULL,
	Region VARCHAR(255) NOT NULL,
	Type VARCHAR(255) NOT NULL,
	ClosingDate DATE NOT NULL
);

INSERT INTO Properties(PropertyID,AgentName,AskingPrice,Region,Type,ClosingDate) VALUES(1,'Alex',1000,'London','Condo','2023-08-31');
INSERT INTO Properties(PropertyID,AgentName,AskingPrice,Region,Type,ClosingDate) VALUES(2,'Kiki',2000,'North York','House','2023-08-29');
INSERT INTO Properties(PropertyID,AgentName,AskingPrice,Region,Type,ClosingDate) VALUES(3,'Ajax',1050,'Waterloo','Condo','2023-08-15');
INSERT INTO Properties(PropertyID,AgentName,AskingPrice,Region,Type,ClosingDate) VALUES(4,'Mallesh',6000,'Toronto','Appartment','2023-09-25');
INSERT INTO Properties(PropertyID,AgentName,AskingPrice,Region,Type,ClosingDate) VALUES(5,'Loki',3500,'Toronto','Basement','2023-09-10');