-- Write SQl Queries here  for Creating table as per models
-- Scheme
CREATE TABLE category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         price DOUBLE NOT NULL,
                         description TEXT,
                         imageURL VARCHAR(255),
                         category_id INT NOT NULL,
                         FOREIGN KEY (category_id) REFERENCES category(id)
);
