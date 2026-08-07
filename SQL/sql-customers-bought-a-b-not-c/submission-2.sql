

select distinct c.customer_id , c.customer_name

from customers c

where c.customer_id  in (select customer_id from orders where product_name in ('A') ) 
and c.customer_id  in (select customer_id from orders where product_name in ('B') ) 
and c.customer_id not in (select customer_id from orders where product_name = 'C' )
order by customer_name

