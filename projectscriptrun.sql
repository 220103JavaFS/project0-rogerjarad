

--Roger Gaulke script

DROP TABLE IF EXISTS accounts; 
DROP TABLE IF EXISTS bank_account; 
CREATE EXTENSION pgcrypto;




CREATE TABLE bank_account(
	id SERIAL PRIMARY KEY,
	account_number INTEGER,
	account_balance INTEGER

);


CREATE TABLE accounts ( 
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR (50),
	username VARCHAR (50),
	password VARCHAR (500),
	account_Type VARCHAR (10),
	bday VARCHAR (50),
	bank_account_id INT REFERENCES bank_account (id),
	UNIQUE(bank_account_id)
	);



INSERT INTO accounts (
	first_name,
	last_name,
	username,
	password,
	account_Type,
	bday)
	VALUES ('bob', 'john', 'bob@gmail.com', crypt('bob1',gen_salt('bf')),'Manager', '01/01/1985'),
	('Tom', 'lin', 'tom@gmail.com', 'tom1', 'Manager', '5/23/1990');





INSERT INTO bank_account(
	account_number,
	account_balance)
	VALUES ('1234', '50000'),('4332', '100000');




CREATE PROCEDURE trade(
	sent int,
	recive int,
	amount double prescision
)
LANGUAGE plsgsql
AS $$
BEGIN
	UPDATE bank_account SET account_balance = account_balance - amount WHERE bank_account_id - sender_id;
	UPDATE bankaccount SET account_balance = account_balance + amount WHERE bank_account_id = receiver_id;

	COMMIT;
END;$$

CALL trade (3000);




