CREATE TABLE IF NOT EXISTS Restaurant(
    id NVARCHAR(36),
    name NVARCHAR(100) UNIQUE NOT NULL ,
    isActive BIT default 1,
    createdBy VARCHAR(36),
    updatedBy VARCHAR(36),
    createdDT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedDT DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_Restaurant PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS City(
    id INT NOT NULL ,
    name VARCHAR(100) NOT NULL,
    createdBy VARCHAR(36),
    updatedBy VARCHAR(36),
    createdDT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedDT DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_City PRIMARY KEY(id)
 );


CREATE TABLE IF NOT EXISTS State(
    id   INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(10) NOT NULL,
    createdBy VARCHAR(36),
    updatedBy VARCHAR(36),
    createdDT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedDT DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_State PRIMARY KEY(id)
 );
CREATE TABLE IF NOT EXISTS Country(
    id   INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(10) NOT NULL,
    createdBy VARCHAR(36),
    updatedBy VARCHAR(36),
    createdDT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedDT DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_Country PRIMARY KEY(id)
  );

CREATE TABLE IF NOT EXISTS Address(
    id NVARCHAR(36),
    restaurantId NVARCHAR(36) NOT NULL,
    addressLine1 NVARCHAR(100) NOT NULL,
    addressLine2 NVARCHAR(100),
    street       NVARCHAR(100),
    landmark     NVARCHAR (100),
    cityId       INT NOT NULL,
    stateId      INT NOT NULL,
    countryId    INT NOT NULL,
    createdBy VARCHAR(36),
    updatedBy VARCHAR(36),
    createdDT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedDT DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_Address   PRIMARY KEY(id),
    CONSTRAINT FK_cityId    FOREIGN KEY (cityId) references City(id),
    CONSTRAINT FK_stateId   FOREIGN KEY (stateId) references State(id),
    CONSTRAINT FK_countryId FOREIGN KEY (countryId) references Country(id),
    FOREIGN KEY (restaurantId) references Restaurant(id)
);