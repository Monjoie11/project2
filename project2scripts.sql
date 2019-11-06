create table companies(
	email text,
	company_name text primary key,
	pass text,
	access_code text  unique,
	rating real,
	link text,
	access_level text
);

create table users(
	email text,
	password text,
	first_name text,
	lastname text,
	phone text,
	bio text,
	resume text,
	post_id integer,
	rating real,
	access_level text,
	work_type text,
	primary key(email)
);

create table posts(
	post_id serial primary key,
	status text,
	posting_email text,
	accepting_email text,
	referenced_company text,
	posted_time text,
	start_time text,
	end_time text,
	post_content text,
	foreign key (posting_email) references users(email),
	foreign key (referenced_company) references companies(company_name),
	foreign key (accepting_email) references users(email)
);


alter table companies add column access_level text;

UPDATE companies
SET access_level = 'OPEN'
where company_name = 'company name 1';

UPDATE companies
SET access_level = 'OPEN'
where company_name = 'company name 2';

UPDATE companies
SET access_level = 'OPEN'
where company_name = 'company name 3';

UPDATE companies
SET access_level = 'AFFILIATED'
where company_name = 'company name 4';

UPDATE companies
SET access_level = 'AFFILIATED'
where company_name = 'company name 5';



alter table companies drop column access_level;

alter table users drop column company;

alter table posts add column post_content text;

ALTER TABLE users 
ADD CONSTRAINT constraint_fkey FOREIGN KEY (post_id) REFERENCES posts(post_id);

alter table posts rename column affiliated_company to referenced_company;

alter table posts rename column post_conent to post_content;

ALTER TABLE public.users drop CONSTRAINT constraint_fkey; 

ALTER TABLE public.posts ADD CONSTRAINT posts_accepting_email_fkey FOREIGN KEY (accepting_email) REFERENCES users(email);

foreign key (post_id) references posts(post_id)




CREATE UNIQUE INDEX CONCURRENTLY access_code_index1 
on companies (access_code);

ALTER TABLE companies
ADD CONSTRAINT unique_access_code
UNIQUE USING INDEX access_code_index1;

ALTER TABLE public.posts drop CONSTRAINT posts_accepting_email_key;

alter table users drop column post_id;

              
create table company_user(
company_name text,
email text,
foreign key (company_name) references companies(company_name),
foreign key (email) references users(email)
);

insert into companies(email, company_name, pass, access_code, rating,	link)
values('test1@test.com', 'company name 1', 'password1', 'axess1', 5.0, 'www.bobsburgers');

insert into companies(email, company_name, pass, access_code, rating,	link)
values('test2@test.com', 'company name 2', 'password2', 'axess2', 4.0, 'www.bobsbugers');

insert into companies(email, company_name, pass, access_code, rating,	link)
values('test3@test.com', 'company name 3', 'password3', 'axess3', 3.0, 'www.bubsburgers');

insert into companies(email, company_name, pass, access_code, rating,	link)
values('test4@test.com', 'company name 4', 'password4', 'axess4', 2.0, 'www.bibsborgers');

insert into companies(email, company_name, pass, access_code, rating,	link)
values('test5@test.com', 'company name 5', 'password5', 'axess5', 1.0, 'www.buggers');

insert into users(email, password, first_name, lastname, phone,	bio, resume, post_id, rating, access_level,	work_type)
values('user1@email.com', 'password1', 'first1', 'last1', '123-4567', 'once upon a time there was a waiter', 'FRONTHOUSE', null, 5.0, 'OPEN', 'FRONTHOUSE');

insert into users(email, password, first_name, lastname, phone,	bio, resume, post_id, rating, access_level,	work_type)
values('user2@email.com', 'password2', 'first2', 'last2', '123-4567', 'once upon a time there was a waiter', 'FRONTHOUSE', null, 5.0, 'OPEN', 'FRONTHOUSE');

insert into users(email, password, first_name, lastname, phone,	bio, resume, post_id, rating, access_level,	work_type)
values('user3@email.com', 'password3', 'first3', 'last3', '123-4567', 'once upon a time there was a waiter', 'FRONTHOUSE', null, 5.0, 'OPEN', 'FRONTHOUSE');

insert into users(email, password, first_name, lastname, phone,	bio, resume, post_id, rating, access_level,	work_type)
values('user4@email.com', 'password4', 'first4', 'last4', '123-4567', 'once upon a time there was a waiter', 'FRONTHOUSE', null, 2.0, 'AFFILIATED', 'FRONTHOUSE');

insert into users(email, password, first_name, lastname, phone,	bio, resume, post_id, rating, access_level,	work_type)
values('user5@email.com', 'password5', 'first5', 'last5', '123-4567', 'once upon a time there was a waiter', 'FRONTHOUSE', null, 3.0, 'AFFILIATED', 'FRONTHOUSE');

insert into posts(status, posting_email, accepting_email, referenced_company, posted_time, start_time, end_time, post_content)
values('PENDING', 'user4@email.com', null, 'company name 4', '11/5/2019, 11:49:36 AM', '11/10/2016, 10:00:00 AM', '11/10/2016, 10:00:00 AM', 'really insightful content');

insert into posts(status, posting_email, accepting_email, referenced_company, posted_time, start_time, end_time, post_content)
values('PENDING', 'user4@email.com', null, 'company name 4', '11/5/2019, 3:30:36 PM', '11/10/2016, 2:00:00 PM', '11/10/2016, 6:00:00 AM', 'really insightful content');

insert into posts(status, posting_email, accepting_email, referenced_company, posted_time, start_time, end_time, post_content)
values('PENDING', 'user4@email.com', null, 'company name 4', '11/5/2019, 3:30:36 PM', '11/10/2016, 2:00:00 PM', '11/10/2016, 6:00:00 AM', 'really insightful content');

insert into posts(status, posting_email, accepting_email, referenced_company, posted_time, start_time, end_time, post_content)
values('PENDING', 'user5@email.com', null, 'company name 5', '11/7/2019, 3:30:36 PM', '11/11/2016, 6:00:00 PM', '11/10/2016, 10:00:00 PM', 'really insightful content');

insert into posts(status, posting_email, accepting_email, referenced_company, posted_time, start_time, end_time, post_content)
values('PENDING', 'user5@email.com', null, 'company name 5', '11/8/2019, 5:30:36 PM', '11/12/2016, 6:00:00 PM', '11/12/2016, 10:00:00 PM', 'really insightful content');
















truncate table companies, posts, users cascade;

drop table companies, posts, users cascade;
drop table posts;
drop table users;
drop table company_user;