INSERT INTO flight_master (flight_number, flight_name) VALUES ('6E', 'Indigo Airlines');
INSERT INTO flight_master (flight_number, flight_name) VALUES ('7A', 'Vistara Airlines');
INSERT INTO flight_master (flight_number, flight_name) VALUES ('8B', 'Air India Airlines');
INSERT INTO flight_master (flight_number, flight_name) VALUES ('5P', 'Go First Airlines');



INSERT INTO flight_details (flight_id, route_source, route_destination, timing, amount, created_on, modified_on, created_by, modified_by) 
VALUES (1, 'Nagpur', 'Pune', '01:00', 5000, '2024-10-19', '2024-10-19', 'admin', 'admin');

INSERT INTO flight_details (flight_id, route_source, route_destination, timing, amount, created_on, modified_on, created_by, modified_by) 
VALUES (1, 'Pune', 'Nagpur', '02:00', 6000, '2024-10-19', '2024-10-19', 'admin', 'admin');

INSERT INTO flight_details (flight_id, route_source, route_destination, timing, amount, created_on, modified_on, created_by, modified_by) 
VALUES (2, 'Mumbai', 'Delhi', '03:00', 8000, '2024-10-19', '2024-10-19', 'admin', 'admin');

INSERT INTO flight_details (flight_id, route_source, route_destination, timing, amount, created_on, modified_on, created_by, modified_by) 
VALUES (2, 'Delhi', 'Mumbai', '04:00', 4000, '2024-10-19', '2024-10-19', 'admin', 'admin');

INSERT INTO flight_details (flight_id, route_source, route_destination, timing, amount, created_on, modified_on, created_by, modified_by) 
VALUES (3, 'Pune', 'Bengaluru', '05:00', 3000, '2024-10-19', '2024-10-19', 'admin', 'admin');

INSERT INTO flight_details (flight_id, route_source, route_destination, timing, amount, created_on, modified_on, created_by, modified_by) 
VALUES (3, 'Bengaluru', 'Pune', '06:00', 9000, '2024-10-19', '2024-10-19', 'admin', 'admin');

INSERT INTO flight_details (flight_id, route_source, route_destination, timing, amount, created_on, modified_on, created_by, modified_by) 
VALUES (4, 'Mumbai', 'Kochi', '07:00', 7500, '2024-10-19', '2024-10-19', 'admin', 'admin');