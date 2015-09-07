CREATE TABLE test.`trips` (
	`Id` INT(11) NOT NULL AUTO_INCREMENT,
	`Client_Id` INT(11) NULL DEFAULT NULL,
	`Driver_Id` INT(11) NULL DEFAULT NULL,
	`City_Id` INT(11) NULL DEFAULT NULL,
	`Status` ENUM('completed','cancelled_by_driver','cancelled_by_client') NULL DEFAULT NULL,
	`Request_at` DATE NULL DEFAULT NULL,
	PRIMARY KEY (`Id`)
)
COMMENT='Leetcode \'Trips and Uses'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=11;

CREATE TABLE test.`users` (
	`User_Id` INT(11) NOT NULL AUTO_INCREMENT,
	`Banned` VARCHAR(50) NULL DEFAULT NULL,
	`Role` ENUM('client','driver','partner') NULL DEFAULT NULL,
	PRIMARY KEY (`User_Id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=14;

-- Users Table Data
insert into test.users (User_Id, Banned, Role) values(1   ,'No'   ,'client' );
insert into test.users (User_Id, Banned, Role) values(2   ,'Yes'  ,'client' );
insert into test.users (User_Id, Banned, Role) values(3   ,'No'   ,'client' );
insert into test.users (User_Id, Banned, Role) values(4   ,'No'   ,'client' );
insert into test.users (User_Id, Banned, Role) values(10  ,'No'   ,'driver' );
insert into test.users (User_Id, Banned, Role) values(11  ,'No'   ,'driver' );
insert into test.users (User_Id, Banned, Role) values(12  ,'No'   ,'driver' );
insert into test.users (User_Id, Banned, Role) values(13  ,'No'   ,'driver' );

-- Trips Table Data
insert into test.trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at) values(1  ,  1   ,   10  ,    1   ,     'completed'      , '2013-10-01');
insert into test.trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at) values(2  ,  2   ,   11  ,    1   , 'cancelled_by_driver', '2013-10-01');
insert into test.trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at) values(3  ,  3   ,   12  ,    6   ,     'completed'      , '2013-10-01');
insert into test.trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at) values(4  ,  4   ,   13  ,    6   , 'cancelled_by_client', '2013-10-01');
insert into test.trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at) values(5  ,  1   ,   10  ,    1   ,     'completed'      , '2013-10-02');
insert into test.trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at) values(6  ,  2   ,   11  ,    6   ,     'completed'      , '2013-10-02');
insert into test.trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at) values(7  ,  3   ,   12  ,    6   ,     'completed'      , '2013-10-02');
insert into test.trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at) values(8  ,  2   ,   12  ,    12  ,     'completed'      , '2013-10-03');
insert into test.trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at) values(9  ,  3   ,   10  ,    12  ,     'completed'      , '2013-10-03');
insert into test.trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at) values(10 ,  4   ,   13  ,    12  , 'cancelled_by_driver', '2013-10-03');


-- Solution
use test;
select Request_at as Day, count(Id) / day_request.DaySum as 'Cancellation Rate'
from
  trips trips
  left join users on trips.Client_Id = users.User_Id
  left join (
              select Request_at as Day, count(1) as DaySum
              from trips
              where Request_at between '2013-10-01' and '2013-10-03' group by Request_at
            ) as day_request on trips.Request_at = day_request.Day

where users.Banned = 'No' and Request_at between '2013-10-01' and '2013-10-03' group by Request_at;

-- Tools For Check
  -- Unbanned Count
  select Request_at as Day, count(Id)
  from
    trips
    left join users on trips.Client_Id = users.User_Id
  where users.Banned = 'No' and Request_at between '2013-10-01' and '2013-10-03' group by Request_at;

  -- Day Sum
  select Request_at as Day, count(1) as DaySum
  from trips
  where Request_at between '2013-10-01' and '2013-10-03' group by Request_at;