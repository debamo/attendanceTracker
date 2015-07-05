CREATE TABLE ABSENT_STUDENTS (
     roll_num INT NOT NULL,
     date_id INT NOT NULL,
     FOREIGN KEY (roll_num) REFERENCES STUDENT (roll_num),
     FOREIGN KEY (date_id) REFERENCES ATTENDANCE_DATES (date_id)
);