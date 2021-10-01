-- 함수: 문자열 함수

-- upper

select upper('buSan'), upper('busan'), upper('Douzone');
select upper(first_name) from employees;


-- lower

select lower('buSan'), lower('busan'), lower('Douzone');
select lower(first_name) from employees;

-- substring

select substring("Hello World", 3, 2);
-- ex)1989년에 입사한 사원들의 이름, 입사일 출력
select first_name, hire_date
from employees
where hire_date = substring(hire_date, 1, 4);

-- lpad(오른쪽 정렬), rpad
select lpad('1234', 10, '-');
select rpad('1234', 10, '-');

-- ex) 직원들의 월급을 오른쪽 정렬(빈공간은 *)
select lpad(salary, 10, '*') from salaries;

-- trim, ltrim, rtrim
select concat('---',ltrim('	hello	'), '---'),
	concat('---',rtrim('	hello	'), '---'),
    concat('---',trim(both 'x' from 'xxhelloxx'), '---');
