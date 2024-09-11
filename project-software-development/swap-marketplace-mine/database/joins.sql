-- Fetch all the details from all the required tables and then do the specific operations over them.
-- Add the where clause as per requirement.
select * from user join user_product on user.user_id = user_product.user_id join category on user_product.category_id = category.category_id;
