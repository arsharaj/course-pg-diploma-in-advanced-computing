/*
-- 1. Drop the existing database if present
-- 2. Create a new database
-- 3. Use this database
*/

drop database if exists swapkart;
create database swapkart;
use swapkart;

/*
-- 1. Create state table
-- 2. Insert values into this table
*/
create table state
(
    state_id int primary key,
    state_name varchar(25)
);
insert into state values
(01, 'Andhra Pradesh'),
(02, 'Arunachal Pradesh'),
(03, 'Assam'),
(04, 'Bihar'),
(05, 'Chhattisgarh'),
(06, 'Goa'),
(07, 'Gujarat'),
(08, 'Haryana'),
(09, 'Himachal Pradesh'),
(10, 'Jammu and Kashmir'),
(11, 'Jharkhand'),
(12, 'Karnataka'),
(13, 'Kerala'),
(14, 'Madhya Pradesh'),
(15, 'Maharashtra'),
(16, 'Manipur'),
(17, 'Meghalaya'),
(18, 'Mizoram'),
(19, 'Nagaland'),
(20, 'Odisha'),
(21, 'Punjab'),
(22, 'Rajasthan'),
(23, 'Sikkim'),
(24, 'Tamil Nadu'),
(25, 'Telangana'),
(26, 'Tripura'),
(27, 'Uttar Pradesh'),
(28, 'Uttarakhand'),
(29, 'West Bengal'),
(30, 'Union Territory');

/*
-- 1. Create the city table
-- 2. Insert into city table
*/
create table city
(
    city_id int primary key,
    city_name varchar(30),
    state_id int,
    foreign key (state_id) references state(state_id)
);
insert into city values
(01, 'Vishakhapatnam', 01),
(02, 'Vijayawada', 01),
(03, 'Guntur', 01),
(04, 'Nellore', 01),
(05, 'Kurnool', 01),
(06, 'Bordumsa', 02),
(07, 'Bubang', 02),
(08, 'Gandhigram', 02),
(09, 'Jairampur', 02),
(10, 'Kharsang', 02),
(11, 'Guwahati', 03),
(12, 'Silchar', 03),
(13, 'Jorhat', 03),
(14, 'Bongaigaon', 03),
(15, 'Tinsukia', 03),
(16, 'Patna', 04),
(17, 'Gaya', 04),
(18, 'Bhagalpur', 04),
(19, 'Muzaffarpur', 04),
(20, 'Bihar Sharif', 04),
(21, 'Raipur', 05),
(22, 'Bhilai', 05),
(23, 'Bilaspur', 05),
(24, 'Korba', 05),
(25, 'Rajnandgaon', 05),
(26, 'Panaji', 06),
(27, 'Bicholim', 06),
(28, 'Margao', 06),
(29, 'Curchorem', 06),
(30, 'Mapusa', 06),
(31, 'Ahmedabad', 07),
(32, 'Surat', 07),
(33, 'Vadodara', 07),
(34, 'Rajkot', 07),
(35, 'Bhavnagar', 07),
(36, 'Faridabad', 08),
(37, 'Gurugram', 08),
(38, 'Panipat', 08),
(39, 'Ambala', 08),
(40, 'Yamunanagar', 08),
(41, 'Shimla', 09),
(42, 'Dharamsala', 09),
(43, 'Solan', 09),
(44, 'Mandi', 09),
(45, 'Palampur', 09),
(46, 'Jammu', 10),
(47, 'Anantnag', 10),
(48, 'Badgam', 10),
(49, 'Bandipora', 10),
(50, 'Baramulla', 10),
(51, 'Jamshedpur', 11),
(52, 'Dhanbad', 11),
(53, 'Ranchi', 11),
(54, 'Bokaro Steel City ', 11),
(55, 'Deoghar', 11),
(56, 'Bangalore', 12),
(57, 'Mysore', 12),
(58, 'Hubballi-Dharwad', 12),
(59, 'Mangalore', 12),
(60, 'Belagavi', 12),
(61, 'Thiruvananthapuram', 13),
(62, 'Kozhikode', 13),
(63, 'Kochi', 13),
(64, 'Kollam', 13),
(65, 'Thrissur', 13),
(66, 'Indore', 14),
(67, 'Bhopal', 14),
(68, 'Jabalpur', 14),
(69, 'Gwalior', 14),
(70, 'Ujjain', 14),
(71, 'Mumbai', 15),
(72, 'Pune', 15),
(73, 'Nagpur', 15),
(74, 'Thane', 15),
(75, 'Pimpri-Chinchwad', 15),
(76, 'Imphal', 16),
(77, 'Thoubal', 16),
(78, 'Kakching', 16),
(79, 'Ukhrul', 16),
(80, 'Lilong', 16),
(81, 'Shillong', 17),
(82, 'Tura', 17),
(83, 'Mawlai', 17),
(84, 'Nongthymmai', 17),
(85, 'Madanriting', 17),
(86, 'Aizawl', 18),
(87, 'Lunglei', 18),
(88, 'Champhai', 18),
(89, 'Saiha', 18),
(90, 'Kolasib', 18),
(91, 'Dimapur', 19),
(92, 'Kohima', 19),
(93, 'Tuensang', 19),
(94, 'Mokokchung', 19),
(95, 'Wokha', 19),
(96, 'Bhubaneswar', 20),
(97, 'Cuttack', 20),
(98, 'Rourkela', 20),
(99, 'Berhampur', 20),
(100, 'Sambalpur', 20),
(101, 'Ludhiana', 21),
(102, 'Amritsar', 21),
(103, 'Jalandhar', 21),
(104, 'Patiala', 21),
(105, 'Bathinda', 21),
(106, 'Jaipur', 22),
(107, 'Jodhpur', 22),
(108, 'Kota', 22),
(109, 'Bikaner', 22),
(110, 'Bhiwadi', 22),
(111, 'Gangtok', 23),
(112, 'Namchi', 23),
(113, 'Rangpo', 23),
(114, 'Jorethang', 23),
(115, 'Rhenak', 23),
(116, 'Chennai', 24),
(117, 'Kanchipuram', 24),
(118, 'Vellore', 24),
(119, 'Thiruvallur', 24),
(120, 'Salem', 24),
(121, 'Hyderabad', 25),
(122, 'Warangal', 25),
(123, 'Nizamabad', 25),
(124, 'Karimnagar', 25),
(125, 'Ramagundam', 25),
(126, 'Agartala', 26),
(127, 'Dharmanagar', 26),
(128, 'Udaipur', 26),
(129, 'Kailasahar', 26),
(130, 'Bishalgarh', 26),
(131, 'Lucknow', 27),
(132, 'Kanpur', 27),
(133, 'Ghaziabad', 27),
(134, 'Agra', 27),
(135, 'Meerut', 27),
(136, 'Dehradun', 28),
(137, 'Haridwar', 28),
(138, 'Rudrapur', 28),
(139, 'Kashipur', 28),
(140, 'Roorkee', 28),
(141, 'Kolkata' , 29),
(142, 'Howrah', 29),
(143, 'Durgapur', 29),
(144, 'Asansol', 29),
(145, 'Siliguri', 29),
(146, 'Puducherry', 30),
(147, 'Lakshadweep', 30),
(148, 'Delhi', 30),
(149, 'Chandigarh', 30),
(150, 'Dadra and Nagar Haveli', 30),
(151, 'Andaman and Nicobar Islands', 30);

/*
-- 1. Create the user table
-- 2. Insert some dummy users
*/
create table user
(
    user_id int primary key auto_increment,
    first_name varchar(20),
    last_name varchar(20),
    email_id varchar(50),
    password varchar(12),
    mobile bigint,
    rating int,
    city_id int,
    foreign key (city_id) references city(city_id)
);
insert into user values
(default, "Arsharaj", "Chauhan", "arsh@gmail.com", "arsh", 1234567890, 5, 3),
(default, "Rahul", "Singh", "rahul@yahoo.com", "rahul", 9876543212, 4, 1),
(default, "John", "Doe", "john@gmail.com", "john", 7831332145, 6, 2),
(default, "Sam", "Wilson", "sam@hotmail.com", "sam", 3210034113, 2, 6);

/*
-- 1. Create the category table
-- 2. Insert into category table
*/
create table category 
(
    category_id int primary key,
    category_name varchar(15),
    constraint check_category_length check (length(category_name) <= 15)
);
insert into category values 
(1, "Electronics"),
(2, "Fashion"),
(3, "Sports"),
(4, "Fitness"),
(5, "Household"),
(6, "Books");

/*
-- 1. Create the user product table
*/
create table user_product
(
    product_id int auto_increment unique,
    product_name varchar(25),
    product_description varchar(150),
    product_brand varchar(50),
    price int,
    first_image blob,
    second_image blob,
    third_image blob,
    posted_date date,
    category_id int,
    user_id int,
    primary key (product_id, user_id),
    foreign key (category_id) references category(category_id),
    foreign key (user_id) references user(user_id),
    constraint check_price check (price > 0)
);

/*
-- 1. Create universal product table
-- 2. Create a trigger that would automatically add the entry to universal product
--    when a new entry is added into user product table
*/
create table universal_product
(
    universal_product_id int primary key auto_increment,
    product_id int,
    foreign key (product_id) references user_product(product_id)
);

/*
-- 1. Insert some dummy user product entries
*/
alter table user_product drop column first_image;
alter table user_product drop column second_image;
alter table user_product drop column third_image;
insert into user_product values (default, "Fan", "Black", "Usha", 2300, "2023-11-10", 1, 2);
insert into user_product values (default, "Shirt", "White Shirt", "Polo", 300, "2021-01-10", 2, 1);
insert into user_product values (default, "Pant", "White Pant", "Levis", 500, "2020-03-10", 2, 4);
insert into user_product values (default, "Bat", "Spartan", "Spartan", 2000, "2022-04-10", 3, 4);
insert into user_product values (default, "Panchtantra", "Kids will love it", "", 100, "2023-5-10", 6, 2);
insert into user_product values (default, "Jar", "Glass jar", "Hawkins", 1000, "2023-12-10", 5, 3);
