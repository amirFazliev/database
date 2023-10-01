select date, customer_id, product_name, amount
from homework.ORDERS
         join homework.CUSTOMERS on homework.CUSTOMERS.id = homework.ORDERS.customer_id
where homework.CUSTOMERS.name = :name;
