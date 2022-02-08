/* I. CREATE TABLES */

-- faculty (Khoa trong trường)
create table faculty (
	id number primary key,
	name nvarchar2(30) not null
);

-- subject (Môn học)
create table subject(
	id number primary key,
	name nvarchar2(100) not null,
	lesson_quantity number(2,0) not null -- tổng số tiết học
);

-- student (Sinh viên)
create table student (
	id number primary key,
	name nvarchar2(30) not null,
	gender nvarchar2(10) not null, -- giới tính
	birthday date not null,
	hometown nvarchar2(100) not null, -- quê quán
	scholarship number, -- học bổng
	faculty_id number not null constraint faculty_id references faculty(id) -- mã khoa
);

-- exam management (Bảng điểm)
create table exam_management(
	id number primary key,
	student_id number not null constraint student_id references student(id),
	subject_id number not null constraint subject_id references subject(id),
	number_of_exam_taking number not null, -- số lần thi (thi trên 1 lần được gọi là thi lại) 
	mark number(4,2) not null -- điểm
);



/*================================================*/

/* II. INSERT SAMPLE DATA */

-- subject
insert into subject (id, name, lesson_quantity) values (1, n'Cơ sở dữ liệu', 45);
insert into subject values (2, n'Trí tuệ nhân tạo', 45);
insert into subject values (3, n'Truyền tin', 45);
insert into subject values (4, n'Đồ họa', 60);
insert into subject values (5, n'Văn phạm', 45);


-- faculty
insert into faculty values (1, n'Anh - Văn');
insert into faculty values (2, n'Tin học');
insert into faculty values (3, n'Triết học');
insert into faculty values (4, n'Vật lý');


-- student
insert into student values (1, n'Nguyễn Thị Hải', n'Nữ', to_date('19900223', 'YYYYMMDD'), n'Hà Nội', 130000, 2);
insert into student values (2, n'Trần Văn Chính', n'Nam', to_date('19921224', 'YYYYMMDD'), n'Bình Định', 150000, 4);
insert into student values (3, n'Lê Thu Yến', n'Nữ', to_date('19900221', 'YYYYMMDD'), n'TP HCM', 150000, 2);
insert into student values (4, n'Lê Hải Yến', n'Nữ', to_date('19900221', 'YYYYMMDD'), n'TP HCM', 170000, 2);
insert into student values (5, n'Trần Anh Tuấn', n'Nam', to_date('19901220', 'YYYYMMDD'), n'Hà Nội', 180000, 1);
insert into student values (6, n'Trần Thanh Mai', n'Nữ', to_date('19910812', 'YYYYMMDD'), n'Hải Phòng', null, 3);
insert into student values (7, n'Trần Thị Thu Thủy', n'Nữ', to_date('19910102', 'YYYYMMDD'), n'Hải Phòng', 10000, 1);


DELETE student;
DELETE subject;
DELETE faculty;
DELETE exam_management;
-- exam_management
insert into exam_management values (1, 1, 1, 1, 3);
insert into exam_management values (2, 1, 1, 2, 6);
insert into exam_management values (3, 1, 2, 2, 6);
insert into exam_management values (4, 1, 3, 1, 5);
insert into exam_management values (5, 2, 1, 1, 4.5);
insert into exam_management values (6, 2, 1, 2, 7);
insert into exam_management values (7, 2, 3, 1, 10);
insert into exam_management values (8, 2, 5, 1, 9);
insert into exam_management values (9, 3, 1, 1, 2);
insert into exam_management values (10, 3, 1, 2, 5);
insert into exam_management values (11, 3, 3, 1, 2.5);
insert into exam_management values (12, 3, 3, 2, 4);
insert into exam_management values (13, 4, 5, 2, 10);
insert into exam_management values (14, 5, 1, 1, 7);
insert into exam_management values (15, 5, 3, 1, 2.5);
insert into exam_management values (16, 5, 3, 2, 5);
insert into exam_management values (17, 6, 2, 1, 6);
insert into exam_management values (18, 6, 4, 1, 10);

 /********* A. BASIC QUERY *********/
 -- 1. Liệt kê danh sách sinh viên sắp xếp theo thứ tự:
--      a. id tăng dần
SELECT * 

FROM STUDENT ORDER BY ID ASC;

--      b. giới tính
SELECT * 

FROM STUDENT ORDER BY GENDER ASC;
--      c. ngày sinh TĂNG DẦN và học bổng GIẢM DẦN
SELECT * 

FROM STUDENT ORDER BY BIRTHDAY ASC;

-- 2. Môn học có tên bắt đầu bằng chữ 'T'
SELECT * FROM SUBJECT

WHERE NAME LIKE 'T%';

-- 3. Sinh viên có chữ cái cuối cùng trong tên là 'i'
SELECT * FROM STUDENT

WHERE NAME LIKE '%i';

-- 4. Những khoa có ký tự thứ hai của tên khoa có chứa chữ 'n'
SELECT * FROM FACULTY

WHERE NAME LIKE '_n%';

-- 5. Sinh viên trong tên có từ 'Thị'
SELECT * FROM STUDENT

WHERE NAME LIKE n'%Thị%';

-- 6. Sinh viên có ký tự đầu tiên của tên nằm trong khoảng từ 'a' đến 'm', sắp xếp theo họ tên sinh viên
SELECT * FROM STUDENT

WHERE (SUBSTR(NAME,1,1) BETWEEN 'A' AND 'M')

ORDER BY NAME;

-- 7. Sinh viên có học bổng lớn hơn 100000, sắp xếp theo mã khoa giảm dần
SELECT * 

FROM STUDENT

WHERE SCHOLARSHIP > 100000;

-- 8. Sinh viên có học bổng từ 150000 trở lên và sinh ở Hà Nội
SELECT * 

FROM STUDENT

WHERE SCHOLARSHIP >= 150000 AND HOMETOWN = n'Hà Nội';

-- 9. Những sinh viên có ngày sinh từ ngày 01/01/1991 đến ngày 05/06/1992
SELECT * 

FROM STUDENT

WHERE BIRTHDAY BETWEEN '01/JAN/1991' AND '05/JUN/1992';

-- 10. Những sinh viên có học bổng từ 80000 đến 150000
SELECT * 

FROM STUDENT

WHERE SCHOLARSHIP BETWEEN 80000 AND 150000;

-- 11. Những môn học có số tiết lớn hơn 30 và nhỏ hơn 45
SELECT * FROM SUBJECT

WHERE LESSON_QUANTITY BETWEEN 30 AND 44;

/********* B. CALCULATION QUERY *********/

-- 1. Cho biết thông tin về mức học bổng của các sinh viên, gồm: Mã sinh viên, Giới tính, Mã 
		-- khoa, Mức học bổng. Trong đó, mức học bổng sẽ hiển thị là “Học bổng cao” nếu giá trị 
		-- của học bổng lớn hơn 500,000 và ngược lại hiển thị là “Mức trung bình”.
SELECT ID,GENDER, FACULTY_ID,
        CASE WHEN SCHOLARSHIP > 500000
        THEN n'Học bổng cao' 
        ELSE n'Mức trung bình' 
        END AS Muc_hoc_bong  
FROM STUDENT; 
        
-- 2. Tính tổng số sinh viên của toàn trường
SELECT COUNT(id) AS So_hoc_sinh 

FROM STUDENT;

-- 3. Tính tổng số sinh viên nam và tổng số sinh viên nữ.
SELECT GENDER, COUNT(ID) AS So_hoc_sinh 

FROM STUDENT

GROUP BY GENDER;

-- 4. Tính tổng số sinh viên từng khoa
SELECT FACULTY_ID, COUNT(ID) AS So_hoc_sinh 

FROM STUDENT

GROUP BY FACULTY_ID;

-- 5. Tính tổng số sinh viên của từng môn học
SELECT SUBJECT_ID,COUNT(STUDENT_ID) AS So_hoc_sinh 

FROM EXAM_MANAGEMENT

GROUP BY SUBJECT_ID;

-- 6. Tính số lượng môn học mà sinh viên đã học
SELECT STUDENT_ID,COUNT(SUBJECT_ID) AS So_mon_hoc 

FROM EXAM_MANAGEMENT

GROUP BY STUDENT_ID;

-- 7. Tổng số học bổng của mỗi khoa	
SELECT FACULTY_ID,COUNT(SCHOLARSHIP) AS So_luong 

FROM STUDENT

GROUP BY FACULTY_ID;

-- 8. Cho biết học bổng cao nhất của mỗi khoa
SELECT FACULTY_ID,MAX(SCHOLARSHIP) AS Max_scholarship 

FROM STUDENT

GROUP BY FACULTY_ID;

-- 9. Cho biết tổng số sinh viên nam và tổng số sinh viên nữ của mỗi khoa
SELECT FACULTY_ID,

COUNT(CASE WHEN GENDER ='Nam' THEN 'X' END) AS So_luong_sv_nam,

COUNT(CASE WHEN GENDER =n'Nữ' THEN 'X' END) AS So_luong_sv_nu

FROM STUDENT

GROUP BY FACULTY_ID;

-- 10. Cho biết số lượng sinh viên theo từng độ tuổi
SELECT TRUNC(months_between(sysdate, BIRTHDAY) / 12) AS AGE,COUNT(ID) AS So_luong

FROM STUDENT

GROUP BY TRUNC(months_between(sysdate, BIRTHDAY) / 12);

-- 11. Cho biết những nơi nào có ít nhất 2 sinh viên đang theo học tại trường
SELECT HOMETOWN 

FROM STUDENT

GROUP BY HOMETOWN

HAVING COUNT(ID)>=2;

-- 12. Cho biết những sinh viên thi lại ít nhất 2 lần
SELECT STUDENT_ID

FROM EXAM_MANAGEMENT 

GROUP BY STUDENT_ID

HAVING COUNT(CASE WHEN NUMBER_OF_EXAM_TAKING >= 2 THEN 'X' END) >=2;

-- 13. Cho biết những sinh viên nam có điểm trung bình lần 1 trên 7.0 
SELECT EXAM_MANAGEMENT.STUDENT_ID, AVG(MARK) AS DTB, GENDER

FROM EXAM_MANAGEMENT, STUDENT

WHERE EXAM_MANAGEMENT.STUDENT_ID=STUDENT.ID AND NUMBER_OF_EXAM_TAKING = 1

GROUP BY EXAM_MANAGEMENT.STUDENT_ID, GENDER

HAVING AVG(MARK)>7.0 AND GENDER=N'Nam';

-- 14. Cho biết danh sách các sinh viên rớt ít nhất 2 môn ở lần thi 1 (rớt môn là điểm thi của môn không quá 4 điểm)
SELECT EXAM_MANAGEMENT.STUDENT_ID,STUDENT.NAME 

FROM EXAM_MANAGEMENT, STUDENT

WHERE EXAM_MANAGEMENT.STUDENT_ID = STUDENT.ID AND NUMBER_OF_EXAM_TAKING = 1 AND MARK <= 4

GROUP BY STUDENT_ID,STUDENT.NAME

HAVING COUNT(STUDENT_ID)>=2;

-- 15. Cho biết danh sách những khoa có nhiều hơn 2 sinh viên nam
SELECT FACULTY_ID,FACULTY.NAME 

FROM FACULTY,STUDENT

WHERE STUDENT.FACULTY_ID = FACULTY.ID

GROUP BY FACULTY_ID,FACULTY.NAME

HAVING COUNT(CASE WHEN GENDER ='Nam' THEN 'X' END)>=2;

-- 16. Cho biết những khoa có 2 sinh viên đạt học bổng từ 200000 đến 300000
SELECT FACULTY_ID,FACULTY.NAME 

FROM FACULTY,STUDENT

WHERE STUDENT.FACULTY_ID = FACULTY.ID

GROUP BY FACULTY_ID,FACULTY.NAME

HAVING COUNT(CASE WHEN SCHOLARSHIP BETWEEN 200000 AND 300000 THEN 'X' END)>=2;

-- 17. Cho biết sinh viên nào có học bổng cao nhất
SELECT * FROM STUDENT
WHERE SCHOLARSHIP = (SELECT MAX(SCHOLARSHIP) FROM STUDENT);
-------------------------------------------------------------------

/********* C. DATE/TIME QUERY *********/

-- 1. Sinh viên có nơi sinh ở Hà Nội và sinh vào tháng 02
SELECT * 

FROM STUDENT

WHERE HOMETOWN = n'Hà Nội' AND TO_CHAR(STUDENT.BIRTHDAY, 'MM')='02';

-- 2. Sinh viên có tuổi lớn hơn 20
SELECT *

FROM STUDENT

WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, BIRTHDAY) / 12) > 20;

-- 3. Sinh viên sinh vào mùa xuân năm 1990
SELECT *

FROM STUDENT

WHERE TO_CHAR(STUDENT.BIRTHDAY, 'YYYY')=1990 AND (TO_CHAR(STUDENT.BIRTHDAY, 'MM')>=1 AND TO_CHAR(STUDENT.BIRTHDAY, 'MM')<=3);
-------------------------------------------------------------------


/********* D. JOIN QUERY *********/

-- 1. Danh sách các sinh viên của khoa ANH VĂN và khoa VẬT LÝ
SELECT STUDENT.ID,STUDENT.NAME, FACULTY.NAME AS FACULTY_NAME

FROM STUDENT INNER JOIN FACULTY ON STUDENT.FACULTY_ID = FACULTY.ID

WHERE FACULTY.NAME = N'Anh - Văn' OR FACULTY.NAME = N'Vật lý';

-- 2. Những sinh viên nam của khoa ANH VĂN và khoa TIN HỌC
SELECT STUDENT.ID,STUDENT.NAME, FACULTY.NAME AS FACULTY_NAME

FROM STUDENT INNER JOIN FACULTY ON STUDENT.FACULTY_ID = FACULTY.ID

WHERE FACULTY.NAME = N'Anh - Văn' OR FACULTY.NAME = N'Tin Học' AND GENDER = 'Nam';

-- 3. Cho biết sinh viên nào có điểm thi lần 1 môn cơ sở dữ liệu cao nhất
SELECT STUDENT.ID,STUDENT.NAME, SUBJECT.NAME, MAX(MARK)

FROM STUDENT INNER JOIN EXAM_MANAGEMENT ON STUDENT.ID = EXAM_MANAGEMENT.STUDENT_ID 

INNER JOIN SUBJECT ON  EXAM_MANAGEMENT.SUBJECT_ID = SUBJECT.ID 

WHERE NUMBER_OF_EXAM_TAKING = 1 AND EXAM_MANAGEMENT.SUBJECT_ID = 1

AND MARK = (SELECT MAX(MARK) FROM EXAM_MANAGEMENT EM,SUBJECT SJ

WHERE EM.SUBJECT_ID=SJ.ID AND EM.SUBJECT_ID = 1)

GROUP BY STUDENT.ID,STUDENT.NAME,SUBJECT.NAME;

-- 4. Cho biết sinh viên khoa anh văn có tuổi lớn nhất.
SELECT STUDENT.NAME AS STUDENT_NAME, BIRTHDAY,FACULTY_ID

FROM STUDENT

WHERE BIRTHDAY=

(SELECT MIN(BIRTHDAY)FROM STUDENT WHERE FACULTY_ID = 1);

-- 5. Cho biết khoa nào có đông sinh viên nhất
SELECT FACULTY.NAME, COUNT(STUDENT.ID) AS SO_SV

FROM FACULTY INNER JOIN STUDENT ON FACULTY.ID = STUDENT.FACULTY_ID


GROUP BY FACULTY.NAME

HAVING COUNT(FACULTY.NAME)>=ALL

(SELECT COUNT(STUDENT.ID)FROM STUDENT GROUP BY FACULTY_ID);

-- 6. Cho biết khoa nào có đông nữ nhất
SELECT F.ID,F.NAME, COUNT(S.GENDER)

FROM FACULTY F INNER JOIN STUDENT S ON f.id = S.FACULTY_ID

WHERE GENDER = N'Nữ'

GROUP BY F.ID,F.NAME

HAVING COUNT(GENDER) >= ALL

(SELECT COUNT(ID) FROM STUDENT WHERE GENDER=N'Nữ' GROUP BY FACULTY_ID);

-- 7. Cho biết những sinh viên đạt điểm cao nhất trong từng môn
SELECT EM.SUBJECT_ID,EM.STUDENT_ID,MARK

FROM EXAM_MANAGEMENT EM, 

(SELECT SUBJECT_ID, MAX(MARK) AS maxdiem

FROM EXAM_MANAGEMENT

GROUP BY SUBJECT_ID) DIEM

WHERE EM.SUBJECT_ID = DIEM.SUBJECT_ID AND MARK=DIEM.maxdiem

ORDER BY SUBJECT_ID;

-- 8. Cho biết những khoa không có sinh viên học
SELECT * FROM FACULTY

WHERE NOT EXISTS

(SELECT DISTINCT F.ID,F.NAME

FROM FACULTY F LEFT OUTER JOIN STUDENT S ON (F.ID = S.FACULTY_ID)

WHERE F.ID = S.FACULTY_ID);

-- 9. Cho biết sinh viên chưa thi môn cơ sở dữ liệu
SELECT * FROM STUDENT

WHERE ID NOT IN

(SELECT DISTINCT STUDENT_ID 

FROM EXAM_MANAGEMENT

WHERE SUBJECT_ID = 1);

-- 10. Cho biết sinh viên nào không thi lần 1 mà có dự thi lần 2
SELECT STUDENT_ID

FROM EXAM_MANAGEMENT EM

WHERE NUMBER_OF_EXAM_TAKING = 2 AND NOT EXISTS

(SELECT *

FROM EXAM_MANAGEMENT

WHERE NUMBER_OF_EXAM_TAKING=1 AND STUDENT_ID=EM.STUDENT_ID);
