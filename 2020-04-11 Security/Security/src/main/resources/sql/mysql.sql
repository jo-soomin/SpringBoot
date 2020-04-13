CREATE TABLE USERT(

	USERNAME VARCHAR2(100) PRIMARY KEY,
    PASSWORD VARCHAR2(100) NOT NULL,
    ENABLED BOOLEAN NOT NULL,
    AUTHORITY VARCHAR2(100) NOT NULL
    
)

INSERT INTO USERT VALUES ('guest', '$2a$12$CE46deartnl2hW2BHZaH5.ncw0ZBy5bSLvZEJAS8Dyvpj8TPcilY2', TRUE,'GUEST');
INSERT INTO USERT VALUES ('admin', '$2a$12$CE46deartnl2hW2BHZaH5.ncw0ZBy5bSLvZEJAS8Dyvpj8TPcilY2', TRUE,'ADMIN');

SELECT * FROM USERT

CREATE TABLE USERBOARD(
 	USERNAME  VARCHAR(100) NOT NULL,
 	TITLE VARCHAR(500) NOT NULL,
 	CONTENT VARCHAR(1000) NOT NULL,
 	CONSTRAINT FK_USERBOARD_USERNAME FOREIGN KEY(USERNAME) REFERENCES USERT(USERNAME)
);


SELECT * FROM USERBOARD;