/**Run these as root**/
CREATE USER 'monitor'@'%' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON `monitor`.* TO 'monitor'@'%' WITH GRANT OPTION;

grant all on `monitor`.* to 'monitor'@'%';

//Run this as  monitor
create database monitor
