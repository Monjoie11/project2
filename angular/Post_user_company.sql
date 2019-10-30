SET search_path TO proj2;
SHOW search_path;


create table users(
	email text,
	pw text,
	firstname text,
	lastname text,
	phone text,
	company text,
	bio text,
	resume text,
	post text,
	rating numeric(1,1),
	accesslevel text,
	worktype text,
	primary key(email)

);

create table posts(
	status text,
	postingemail text references users(email),
	acceptingemail text references users(email),
	affiliatedco text,
	postedtime timestamp,
	starttime timestamp,
	endtime timestamp	
);

create table companies(
	email text,
	companyname text,
	pass text,
	accesscode text,
	rating numeric(1,1)
);