select uuid, datediff('Millisecond', starttime, stoptime) from operations order by starttime desc;

select * from memes;

call public.fn_slow(666);

call sp_slow(5000);

select * from (values(1, fn_slow(3000)));

select * from table();

-- Uses standart java delay
create procedure sp_slow(in delay bigint)
LANGUAGE JAVA DETERMINISTIC no sql
EXTERNAL NAME 'CLASSPATH:java.lang.Thread.sleep';

-- delays query

create function fn_slow(in delay integer)
returns integer
reads sql data
begin atomic
	call sp_slow(delay);
	return delay;
end;

truncate table operations;