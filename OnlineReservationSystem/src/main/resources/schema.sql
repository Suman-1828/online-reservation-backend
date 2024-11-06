INSERT INTO users (username, password, role) VALUES ('john_doe', 'root', 'USER');

INSERT INTO reservations (user_id, train_number, train_name, class_type, date_of_journey, from_place, to_place, pnr_number) 
VALUES 
(1, '12345', 'Express Train', 'AC', '2024-12-01', 'CityA', 'CityB', 'PNR12345');
