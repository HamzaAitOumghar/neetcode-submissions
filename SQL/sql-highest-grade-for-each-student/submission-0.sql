-- Write your query below


select student_id, exam_id , score

from (

select  student_id , exam_id , score , row_number() over(partition by student_id order by score desc , exam_id asc) as rn
from exam_results


) with_row

where rn=1
ORDER BY student_id;
;




