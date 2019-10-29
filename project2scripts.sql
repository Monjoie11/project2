create table companies(
	email text,
	company_name text primary key,
	pass text,
	access_code text,
	rating numeric(1,1)
);

create table users(
	email text,
	password text,
	first_name text,
	lastname text,
	phone text,
	company text,
	bio text,
	resume text,
	post text,
	rating numeric(1,1),
	access_level text,
	work_type text,
	primary key(email),
	foreign key (company) references companies(company_name)

);

create table posts(
	post_id serial primary key,
	status text,
	posting_email text,
	accepting_email text unique,
	affiliated_company text,
	posted_time timestamp,
	start_time timestamp,
	end_time timestamp,
	foreign key (posting_email) references users(email),
	foreign key (affiliated_company) references companies(company_name)
);

ALTER TABLE users
        ADD FOREIGN KEY (email) REFERENCES posts(accepting_email)
                DEFERRABLE INITIALLY DEFERRED;
 
ALTER TABLE posts 
        ADD FOREIGN KEY (accepting_email) REFERENCES users(email)
                DEFERRABLE INITIALLY DEFERRED;




drop table companies;
drop table posts;
drop table users;