/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/

DROP DATABASE IF EXISTS ProjectManager;
CREATE DATABASE ProjectManager;
USE ProjectManager;

/*============================== CREATE TABLE =======================================*/
/*======================================================================================*/

-- create table 1: Department  id, FullName, Email, Password



CREATE TABLE `User`(
	UserID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName 	VARCHAR(50) UNIQUE KEY NOT NULL,
    Email 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `Password`	VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6),
    `Role`		ENUM('Employee', 'Manager'),
    ExpInYear 	TINYINT UNSIGNED,
    ProSkill	ENUM('Java', 'Dev', 'Test', 'SQL')
);


/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

INSERT INTO `User`  (FullName, 			Email,				 `Password`,			`Role`,				ExpInYear, 			ProSkill		) 
VALUES
					(N'Nguyễn Văn A',	'mynt2407@gmail.com',  'Mynguyen123',			'Employee', null, 'Dev'	),
					(N'Nguyễn Văn B',	'duynn03@gmail.com',   'duyNguyen',				'Manager', 3, null	),
                    (N'Nguyễn Văn C',	'hungmanh@gmail.com',  'hunGmanh1',				'Employee', null, 'Dev'	),
                    (N'Trần Thị A',		'nhung@gmail.com', 		'nhungtOng',			'Manager', 5, null	),
                    (N'Trần Thị B',		'kimoanh@gmail.com',    'tran.kim',		    	'Employee', null, 'Dev'	),
                    (N'Lê Văn Tám',      'vantam.le@gmail.com', 	 'abc123',	           		'Manager', 7, null	);


CREATE TABLE `Project`(
	ProjectID 	TINYINT UNSIGNED NOT NULL,
	TeamSize 	TINYINT UNSIGNED NOT NULL,
    UserID 		TINYINT UNSIGNED,
    FOREIGN KEY(UserID) REFERENCES User(UserID),
    PRIMARY KEY (ProjectID,UserID)
    
);

INSERT INTO `Project`  (ProjectID, TeamSize, UserID) 
VALUES  (1,2,1),
		(1,2,2),
        (2,2,3),
        (2,2,4),
        (3,2,5),
        (3,2,6);

SELECT * From User
INNER JOIN
Project ON Project.UserID = User.UserID
WHERE Project.ProjectID = 1
						
                              
                    
                    
