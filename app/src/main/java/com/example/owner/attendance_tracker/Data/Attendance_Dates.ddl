CREATE TABLE ATTENDANCE_DATES (
     date_id INT NOT NULL AUTO_INCREMENT,
     icvk_id INT NOT NULL,
     attendance_date DATE NOT NULL,
     PRIMARY KEY (date_id),
     FOREIGN KEY (icvk_id) REFERENCES ICVK_GROUPS (icvk_id)
);