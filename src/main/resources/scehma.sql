CREATE TABLE flight_master (
    flight_id INT AUTO_INCREMENT PRIMARY KEY,
    flight_number VARCHAR NOT NULL,
    flight_name VARCHAR NOT NULL
);

CREATE TABLE flight_details (
    route_id INT AUTO_INCREMENT PRIMARY KEY,
    flight_id INT,
    route_source VARCHAR,
    route_destination VARCHAR,
    timing VARCHAR,
    amount DECIMAL(10, 2),
    created_on DATE,
    modified_on DATE,
    created_by VARCHAR,
    modified_by VARCHAR,
    FOREIGN KEY (flight_id) REFERENCES flight_master(flight_id)
);