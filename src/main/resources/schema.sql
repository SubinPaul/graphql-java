DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `street` varchar(100) NOT NULL,
                           `city` varchar(45) NOT NULL,
                           PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `first_name` varchar(50) NOT NULL,
                           `last_name` varchar(50) DEFAULT NULL,
                           `email` varchar(30) DEFAULT NULL,
                           `address_id` int(11) DEFAULT NULL,
                           PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `subject_name` varchar(45) DEFAULT NULL,
                           `marks_obtained` double DEFAULT NULL,
                           `student_id` int(11) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
)

