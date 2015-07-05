CREATE TABLE STUDENT (
     roll_num INT NOT NULL AUTO_INCREMENT,
     icvk_id INT NOT NULL,
     name VARCHAR(50) NOT NULL,
     date_of_joining DATE NOT NULL,
     age INT,
     apt_num INT,
     guardian_name VARCHAR(50),
     PRIMARY KEY (roll_num),
     INDEX (icvk_id, roll_num),
     FOREIGN KEY (icvk_id) REFERENCES ICVK_GROUPS (icvk_id)
);


insert into STUDENT (icvk_id, name, date_of_joining, age, apt_num, guardian_name)
values
(1,'test1','2015-01-01',4,10,'parent1'),
(1,'test2','2015-01-01',5,11,'parent2'),
(1,'test3','2015-01-01',6,12,'parent3'),
(1,'test4','2015-01-01',7,11,'parent4'),
(1,'test5','2015-01-01',8,10,'parent5'),
(1,'test6','2015-01-01',9,11,'parent2')