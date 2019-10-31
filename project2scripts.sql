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
	post_id integer,
	rating numeric(1,1),
	access_level text,
	work_type text,
	primary key(email)
);



ALTER TABLE users 
ADD CONSTRAINT constraint_fkey FOREIGN KEY (post_id) REFERENCES posts(post_id);

foreign key (post_id) references posts(post_id)

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

              
create table company_user(
company_name text,
email text,
foreign key (company_name) references companies(company_name),
foreign key (email) references users(email)
);



alter table posts add column post_content text;



drop table companies, posts, users;
drop table posts;
drop table users;
drop table company_user;