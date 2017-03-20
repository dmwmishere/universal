select uuid, datediff('Millisecond', starttime, stoptime) from operations order by starttime desc;

truncate table operations;