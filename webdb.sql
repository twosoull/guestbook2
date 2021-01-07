/***Drop*************/
DROP TABLE guestbook;
DROP SEQUENCE seq_guestbook_no;

/***CREATE***********/
CREATE TABLE guestbook(
    no number(10),
    name varchar2(80),
    password varchar2(20),
    content varchar2(2000),
    reg_date date,
    primary key(no)
);

CREATE SEQUENCE seq_guestbook_no
INCREMENT BY 1
START WITH 1;

/***SELECT***********/
SELECT no,
       name, 
       password,
       content,
       reg_date
FROM guestbook;

/***INSERT***********/

INSERT INTO guestbook
values(SEQ_GUESTBOOK_NO.nextval,'이정재','1234','오우오우',sysdate);
commit;
rollback;
/***UPDATE***********/
UPDATE guestbook
SET name = '이영훈'
WHERE no = 1;
commit;
rollback;
/***DELETE***********/
DELETE guestbook
WHERE password = 1234
and no = 1;
commit;
rollback;
/***like*************/
SELECT no,
       name, 
       password,
       content,
       reg_date
FROM guestbook
where password like '1234';