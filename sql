
# customers
# +----+--------+------+------------+-------+
# | id | name   | sex  | birthday   | state |
# +----+--------+------+------------+-------+
# |  1 | Janice | m    | 1990-05-12 | VA    |
# |  2 | WANG   | f    | 1991-05-12 | DC    |
# |  3 | CAO    | m    | 1988-05-12 | NY    |
# |  4 | Li     | f    | 1995-05-12 | CA    |
# |  5 | MA     | f    | 1996-05-12 | NY    |
# |  6 | HUI    | m    | 1993-05-12 | MD    |
# +----+--------+------+------------+-------+
# Sales
# +----+----------+---------+-------+------------+-------------+-------+
# | id | store_id | item_id | store | order_date | customer_id | price |
# +----+----------+---------+-------+------------+-------------+-------+
# |  1 |        1 |       1 | VA    | 2014-10-28 |           1 |   100 |
# |  2 |        2 |       1 | NY    | 2014-07-20 |           2 |   200 |
# |  3 |        3 |       3 | DC    | 2014-05-12 |           2 |   100 |
# |  4 |        3 |       2 | DC    | 2015-05-12 |           3 |   300 |
# |  5 |        3 |       3 | DC    | 2015-05-12 |           4 |   100 |
# |  6 |        4 |       1 | DC    | 2015-05-12 |           5 |   200 |
# |  7 |        4 |       2 | DC    | 2004-05-11 |           1 |   200 |
# +----+----------+---------+-------+------------+-------------+-------+


SQL

http://www.wxhaowen.com/article_18a045d352d34e5ab7f32042fa2c40a0.shtml

https://dwbi.org/database/sql/72-top-20-sql-interview-questions-with-answers

http://a4academics.com/interview-questions/53-database-and-sql/397-top-100-database-sql-interview-questions-and-answers-examples-queries?showall=&limitstart=


http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=277560&highlight=facebook%2Bdata%2Bengineer

http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=171669&highlight=facebook%2Bdata%2Bengineer

http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=200022&highlight=facebook%2Bdata%2Bengineer

http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=287033&highlight=facebook%2Bdata%2Bengineer


https://leetcode.com/problems/first-unique-character-in-a-string/description/

https://leetcode.com/problems/flatten-nested-list-iterator/description/

https://leetcode.com/problems/repeated-substring-pattern/description/


ONE SECTION
https://coderpad.io/ENPTCNC2
- for each store show the % difference in sales between 2014 and 2015
SELECT t1.store_id,IFNULL(ROUND((total_15 - total_14)/(total_15+total_14),2),0.00) AS difference
FROM
(
SELECT store_id,SUM(price) AS total_14
FROM sales
WHERE YEAR(order_date) = 2014
GROUP BY store_id
HAVING total_14 != 0) AS t1
JOIN
(SELECT store_id,SUM(price) AS total_15
FROM sales
WHERE YEAR(order_date) = 2015
GROUP BY store_id
HAVING total_15 != 0) AS t2
ON t1.store_id = t2.store_id
- % of all customers that have purchases at least 1 product
	select sum(
case 
when exists(select 1 from sales s where s.customer_id = c.customer_id) then 1 
else 0 
end) /count(*) 
from customers c;

SELECT (SUM(CASE i i
                WHEN customer_id IS NULL THEN 0
                ELSE 1
           END))/COUNT(T.name) AS rate
FROM(
  SELECT DISTINCT name,customer_id
  FROM customers c 
  LEFT JOIN sales s ON c.id = s.customer_id
  ) AS T 
- list all the customers that live in a state, ordered by the number of unique products they bought
SELECT state,name,num_nuique
FROM
(SELECT DISTINCT id, name,state
FROM customers) AS t1
JOIN
(SELECT customer_id,count(distinct item_id) AS num_nuique
FROM sales
GROUP BY customer_id) t2
ON t1.id = t2.customer_id
GROUP BY state,name,num_nuique
ORDER BY state,num_nuique DESC

- Find the earliest born and last born customers, by gender, who have bought at least 1 product
SELECT name,sex,birthday
FROM(
(SELECT name,sex,birthday 
FROM(
  SELECT DISTINCT name,sex,birthday
  FROM customers c
  JOIN sales s ON c.id = s.customer_id) AS t
WHERE sex = 'm'
ORDER BY birthday DESC
LIMIT 1)
  
UNION ALL
(SELECT name,sex,birthday 
FROM(
  SELECT DISTINCT name,sex,birthday
  FROM customers c
  JOIN sales s ON c.id = s.customer_id) AS t
WHERE sex = 'm'
ORDER BY birthday 
LIMIT 1)
  ) AS t

-Return min and max age of male/female who bought a product
(SELECT Name,sex,birthday AS young
FROM (
   SELECT DISTINCT name,sex,birthday
   FROM customers c
   JOIN sales s ON c.id = s.customer_id
) AS t
WHERE sex = 'm'
ORDER BY birthday DESC
LIMIT 1) 
    	
-Count the number of stores in a state with grand total ? 25000 sq feet

-Get the states with more the than 100000 population
SELECT states
 	FROM country
	WHERE population >= 100000
-Count the number of products which sold more than 10 units
	SELECT COUNT(*) 
	FROM products
	GROUP BY products
	HAVING COUNT(*) >= 10
-Get youngest customer who bought at least 1 product
(SELECT Name,sex,birthday AS young
FROM (
   SELECT DISTINCT name,sex,birthday
   FROM customers c
   JOIN sales s ON c.id = s.customer_id
) AS t
WHERE sex = 'm'
ORDER BY birthday DESC
LIMIT 1) 

-Get the areas from which we have the products sold
SELECT *
FROM (
  SELECT store
  FROM sales
  GROUP BY store
  HAVING COUNT(order_date) > 0
) AS t
- Delete all duplicates from a table in one query
	DELETE n1 FROM names n1, names n2 WHERE n1.id < n2.id AND n1.name = n2.name



























- Perform a merge-sort with SQL only
-Given a series of tables; write the SQL code you would need to count subpopulations through joins
-The success ratio of sending messages given sent and receive table
Unknown 

What are the states with a total of x amount of square feet?

How many unique world are in the provided string?

Find the max no from the given set of elements in an array (without using max function)


Find the minimum absolute difference between the set of elements of an array. 

Select a PCT of Male customer over all  

Select OR, CA where the total sqft at least 26000  

Show gender, min birthday and max birthdate where a customer bought at least one product  

Create DDL (table and foreign keys) for several tables in a provided ERD. ERD contains at least one many to many relationship.
 
Recursively parse a string for a pattern that can be either 1 or 2 characters long.  
 
Given full authority to "make it work", import a large data set with duplicates into a warehouse while meeting the requirements of a business intelligence designer for query speed. 
 
Query a many to many relationship while not violating the grain of a fact table.  
 
 
 
3分介绍
很简单的题一定自己联谊下敲 程序。 . visit 1point3acres.com for more.
 
sql   
1。how many states that have stores  more than 25000 area sqft  ---    group by state having sum
 SE 
sadfa. 鍥磋鎴戜滑@1point 3 acres
2.  count of unique prods that customers buy including 0s. count(distinct) customers left join sales,  group by customer_id,  fn, ln  order by          .  mysql has isnull  probably,  I used case when for null cases . from: 1point3acres.com/bbs 
3. Percentage of customers who has at least 1 product 
select sum(case when exists(select 1 from sales s where s.customer_id = c.customer_id) then 1 else 0 end) /count(*) 
from customers c; 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
 
coding 
1.        Uniq words in sentence
2.        做flat list: giving [1,2,[3,4,[5,6]], 7] ==> [1,2,3,4,5,6,7]
3.        Count substr in string 
Forgot a couple,  but very easy compared with SDE questions.
 
SELECT COUNT(states)
FROM(
	SELECT states
FROM country
GROUP BY states
HAVING SUM(*)  > 25000
) AS T
 
 
SQL Interview QUESTION:
JAVA

- implement count_words(input_str) function which returns number of words from the input string (hint the edge cases they provide means you have to implement it manually)
- implement count_substr(input_str, sub_str) function which returns the number of times the sub_str occurs in the input_str.
-Count distinct words in a sentence
-Count the number of times a word appear in a sentence using a Hash Map
-Return tuples of a list, matching each item to another item
-Count the number of times a substring appear in a string
-Count the number of unique words in a sequence?
-Print the part of the array of numbers
-Check the substring in the string
-Question on exceptions
-Count the number of words in a sentence.
-Count the frequency of words from the list and store the results in a hash map.
-Write a function return max in Python  
-Write a function return Median in Python
-Given a number and a array. Python code to find sum of any 2 numbers in a list is equal to a given number.


-Count distinct words in a sentence
-Count the number of times a word appear in a sentence using a Hash Map
-Return tuples of a list, matching each item to another item
-Count the number of times a substring appear in a string

1) Print Max element of a given list
2) Print median of a given list
3) Print the first non recurring element in a list
4) Print the most recurring element in a list
5) Greatest common Factor
SELECT id, COUNT(*) num FROM 
    (SELECT requester_id AS id FROM request_accepted
    UNION ALL 
    SELECT accepter_id AS id FROM request_accepted) AS temp
GROUP BY id
Having COUNT(*) >= ALl(
    SELECT COUNT(*) num
    FROM 
        (SELECT requester_id AS id FROM request_accepted
        UNION ALL 
        SELECT accepter_id AS id FROM request_accepted) AS temp
    GROUP BY id)

SELECT id, COUNT(*) num
FROM 
(SELECT requester_id AS id FROM request_accepted
UNION ALL 
SELECT accepter_id AS id FROM request_accepted) AS temp
GROUP BY id
ORDER BY num DESC
LIMIT 1

coding 
1.        Uniq words in sentence
2.        做flat list: giving [1,2,[3,4,[5,6]], 7] ==> [1,2,3,4,5,6,7]
3.        Count substr in string -google 1point3acres
Forgot a couple,  but very easy compared with SDE questions.s
 
 
reate table employees
(
  id            int AUTO_INCREMENT,
  first_name    varchar(255),
  last_name     varchar(255),
  salary        int,
  department_id int,
 
  primary key(id),
  key(department_id)
);
 
insert into employees
  (first_name, last_name, salary, department_id)
values
  ('John',   'Smith',     20000, 1),
  ('Ava',    'Muffinson', 10000, 5),
  ('Cailin', 'Ninson',    30000, 2),
  ('Mike',   'Peterson',  20000, 2),
  ('Ian',    'Peterson',  80000, 2),
  ('John',   'Mills',     50000, 3);
 
create table projects
(
  id            int AUTO_INCREMENT,
  title         varchar(255),
  start_date    date,
  end_date      date,
  budget        int,
 
  primary key(id)
);
 
insert into projects
  (title, start_date, end_date, budget)
values
  ('Build a cool site',        '2011-10-28', '2012-01-26', 1000000),
  ('Update TPS Reports',       '2011-07-20', '2011-10-28',  100000),
  ('Design 3 New Silly Walks', '2009-05-11', '2009-08-19',     100);
 
create table departments
(
  id            int auto_increment,
  name          varchar(255),
 
  primary key(id)
);
 
insert into departments
  (name)
values
  ('Reporting'),
  ('Engineering'),
  ('Marketing'),
  ('Biz Dev'),
  ('Silly Walks');
 
create table employees_projects
(
  project_id    int,
  employee_id   int,
 
  key(project_id),
  key(employee_id)
);
 
insert into employees_projects
  (project_id, employee_id)
values
  (2, 1),
  (3, 2),
  (1, 3),
  (1, 4),
  (1, 5);
 
 
 
 

