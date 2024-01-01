CREATE TABLE IF NOT EXISTS Restaurant(
    id BIGINT(100) AUTO_INCREMENT ,
    name VARCHAR(100) NOT NULL,
    isActive bit default 1,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Address(
    id BIGINT(100) AUTO_INCREMENT ,
    restaurantId BIGINT(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (restaurantId) references Restaurant(id)
);
