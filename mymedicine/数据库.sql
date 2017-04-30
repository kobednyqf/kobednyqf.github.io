create table medicine(
medicine_id int not null auto_increment, 
medicine_name varchar(30),
medicine_detail varchar(100),
medicine_cata varchar(10),
primary key (medicine_id)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table store(
store_id  int not null auto_increment, 
medicine_id int,
number int,
place varchar(30),
active_time varchar(30),
inactive_time varchar(30),
price float,
status varchar(10),
primary key (store_id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table sale(
sale_id  int not null auto_increment, 
store_id int,
number int, 
create_time  timestamp not null default current_timestamp,
primary key (sale_id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table user(
username varchar(30),
password varchar(30)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;