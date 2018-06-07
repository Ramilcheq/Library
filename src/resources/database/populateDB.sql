Use test;

DROP TABLE IF EXISTS book;
CREATE TABLE book(
	id INT(11) NOT NULL AUTO_INCREMENT,
    title VARCHAR(100),
    description VARCHAR(100),
    author VARCHAR(100),
    isbn VARCHAR(20),
    printYear INT(11),
    readAlready TINYINT(1) DEFAULT '0',
    PRIMARY KEY (id))
    ENGINE InnoDB
    DEFAULT CHARACTER SET = utf8; 

INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book01', 'Description01', 'Author01', 'ISBN01', '1990');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book02', 'Description02', 'Author02', 'ISBN02', '1991');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book03', 'Description03', 'Author03', 'ISBN03', '1992');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book04', 'Description04', 'Author04', 'ISBN04', '1993');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book05', 'Description05', 'Author05', 'ISBN05', '1994');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book06', 'Description06', 'Author06', 'ISBN06', '1995');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book07', 'Description07', 'Author07', 'ISBN07', '1996');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book08', 'Description08', 'Author08', 'ISBN08', '1997');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book09', 'Description09', 'Author09', 'ISBN09', '1998');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book10', 'Description10', 'Author10', 'ISBN10', '1999');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book11', 'Description11', 'Author11', 'ISBN11', '2000');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book12', 'Description12', 'Author12', 'ISBN12', '2001');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book13', 'Description13', 'Author13', 'ISBN13', '2002');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book14', 'Description14', 'Author14', 'ISBN14', '2003');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book15', 'Description15', 'Author15', 'ISBN15', '2004');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book16', 'Description16', 'Author16', 'ISBN16', '2005');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book17', 'Description17', 'Author17', 'ISBN17', '2006');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book18', 'Description18', 'Author18', 'ISBN18', '2007');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book19', 'Description19', 'Author19', 'ISBN19', '2008');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book20', 'Description20', 'Author20', 'ISBN20', '2009');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book21', 'Description21', 'Author21', 'ISBN21', '2010');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book22', 'Description22', 'Author22', 'ISBN22', '2011');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book23', 'Description23', 'Author23', 'ISBN23', '2012');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book24', 'Description24', 'Author24', 'ISBN24', '2013');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book25', 'Description25', 'Author25', 'ISBN25', '2014');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book26', 'Description26', 'Author26', 'ISBN26', '2015');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book27', 'Description27', 'Author27', 'ISBN27', '2016');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book28', 'Description28', 'Author28', 'ISBN28', '2017');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book29', 'Description29', 'Author29', 'ISBN29', '2018');
INSERT INTO book (title, description, author, isbn, printYear) VALUES ('Book30', 'Description30', 'Author30', 'ISBN30', '2019');