drop table if exists user;
drop table if exists main_menu;
drop table if exists sub_menu;
drop table if exists page;
drop table if exists post;

CREATE  TABLE user (
  id INT(11) IDENTITY PRIMARY KEY,
  username VARCHAR(45),
  password VARCHAR(45) NOT NULL ,
  admin BIT NOT NULL,
);


CREATE TABLE page (
  page_title VARCHAR(50) PRIMARY KEY,
  page_subtitle VARCHAR(100) NULL 
);

CREATE TABLE post (
	id INT(11) IDENTITY PRIMARY KEY,
	title VARCHAR(350),
	text VARCHAR(15000),
	user VARCHAR(45) NOT NULL,
    page VARCHAR(45) NOT NULL,
	FOREIGN KEY (user) REFERENCES user (username),
	FOREIGN KEY (page) REFERENCES page (page_title)
);

CREATE TABLE main_menu(
  id INT(11) IDENTITY PRIMARY KEY,
  label VARCHAR(50) NOT NULL,
  page VARCHAR(45) NOT NULL,
  FOREIGN KEY (page) REFERENCES page (page_title)
);

CREATE TABLE sub_menu(
  id INT(11) IDENTITY PRIMARY KEY,
  label VARCHAR(50) NOT NULL,
  main_menu VARCHAR(45) NOT NULL,
  page VARCHAR(45) NOT NULL,
  FOREIGN KEY (main_menu) REFERENCES main_menu (label),
  FOREIGN KEY (page) REFERENCES page (page_title)
);



  