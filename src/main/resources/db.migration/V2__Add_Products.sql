INSERT INTO category (id, title) VALUES
                                     (1, 'Electronics'),
                                     (2, 'Clothes - Men'),
                                     (3, 'Clothes - Women'),
                                     (4, 'Clothes - Kids'),
                                     (5, 'Kitchenware');

INSERT INTO product (title, price, description, imageURL, category_id, is_deleted) VALUES
-- Electronics
('Phone 1', 29999.99, 'Latest smartphone with 128GB storage', 'http://example.com/phone1.jpg', 1, 0),
('Laptop 1', 59999.99, 'High-performance laptop with 16GB RAM', 'http://example.com/laptop1.jpg', 1, 0),
('TV 1', 39999.99, 'Smart TV with 4K resolution', 'http://example.com/tv1.jpg', 1, 0),
('Speakers 1', 1999.99, 'Bluetooth speakers with great sound quality', 'http://example.com/speakers1.jpg', 1, 0),
-- Clothes (Men's)
('Men Shirt 1', 999.99, 'Stylish men\'s shirt', 'http://example.com/menshirt1.jpg', 2, 0),
('Men Pants 1', 1299.99, 'Comfortable men\'s pants', 'http://example.com/menpants1.jpg', 2, 0),
-- Clothes (Women’s)
('Women Dress 1', 1499.99, 'Elegant women\'s dress', 'http://example.com/womendress1.jpg', 3, 0),
('Women Blouse 1', 899.99, 'Chic women\'s blouse', 'http://example.com/womenblouse1.jpg', 3, 0),
-- Clothes (Kids’)
('Kids T-shirt 1', 499.99, 'Cute kids\' t-shirt', 'http://example.com/kidstshirt1.jpg', 4, 0),
('Kids Shorts 1', 599.99, 'Comfortable kids\' shorts', 'http://example.com/kidsshorts1.jpg', 4, 0),
-- Kitchenware
('Pan 1', 799.99, 'Non-stick pan', 'http://example.com/pan1.jpg', 5, 0),
('Knife Set 1', 1299.99, 'Stainless steel knife set', 'http://example.com/knifeset1.jpg', 5, 0),
-- Electronics (Continued)
('Phone 2', 34999.99, 'Smartphone with 256GB storage', 'http://example.com/phone2.jpg', 1, 0),
('Laptop 2', 69999.99, 'Gaming laptop with 32GB RAM', 'http://example.com/laptop2.jpg', 1, 0),
('TV 2', 44999.99, 'OLED TV with 8K resolution', 'http://example.com/tv2.jpg', 1, 0),
('Speakers 2', 2999.99, 'High-fidelity Bluetooth speakers', 'http://example.com/speakers2.jpg', 1, 0),
-- Clothes (Men's Continued)
('Men Jacket 1', 2499.99, 'Stylish men\'s jacket', 'http://example.com/menjacket1.jpg', 2, 0),
('Men Shoes 1', 1999.99, 'Comfortable men\'s shoes', 'http://example.com/menshoes1.jpg', 2, 0),
-- Kitchenware (Continued)
('Blender 1', 2299.99, 'High-power kitchen blender', 'http://example.com/blender1.jpg', 5, 0),
('Toaster 1', 1199.99, 'Multi-functional toaster', 'http://example.com/toaster1.jpg', 5,