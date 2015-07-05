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