use conygre;
CREATE TABLE user (
                      id INT AUTO_INCREMENT,
                      first_name VARCHAR(50),
                      last_name VARCHAR(50),
                      net_worth double,
                      PRIMARY KEY (id)
);
INSERT INTO user (id, first_name, last_name, net_worth) VALUES
(1, 'Cindy', 'Zhang', '2317371.00'),
(2, 'Kevin', 'Wu', '5855678.37');
CREATE TABLE cash  (
                       id INT AUTO_INCREMENT,
                       name VARCHAR(150),
                       category VARCHAR(150),
                       amount double,
                       last_update_time DATETIME,
                       user_id INT,
                       PRIMARY KEY (id),
                       CONSTRAINT fk_cash_user_user_id FOREIGN KEY (user_id) REFERENCES user(id)
);
INSERT INTO cash (id, name, category, amount, last_update_time, user_id) VALUES
(1, 'Fidelity Cash', 'Cash Management', '2291.90', '2019-07-13 11-47-12', 1),
(2, 'Wells Fargo', 'Checking', '309.13', '2019-03-02 15-21-08', 1),
(3, 'Wells Fargo', 'Saving', '2000.67', '2019-10-08 10-07-54', 1),
(4, 'Fidelity Cash', 'Cash Management', '3345.96', '2019-11-26 12-32-16', 2),
(5, 'Wells Fargo', 'Checking', '450.77', '2019-12-28 14-07-13', 2),
(6, 'Wells Fargo', 'Saving', '7230.78', '2020-02-14 13-00-09', 2);
CREATE TABLE investment  (
                             id INT AUTO_INCREMENT,
                             name VARCHAR(150),
                             category VARCHAR(150),
                             portfolio VARCHAR(20),
                             amount double,
                             last_update_time DATETIME,
                             user_id INT,
                             PRIMARY KEY (id),
                             CONSTRAINT fk_investment_user_user_id FOREIGN KEY (user_id) REFERENCES user(id)
);
INSERT INTO investment (id, name, category, portfolio, amount, last_update_time, user_id) VALUES
(1, 'Beneke Fabricators', 'Skyler White 401K', 'Bond', 16231.00, '2020-02-29 09-26-32', 1),
(2, 'Fidelity Cash', 'Cash Management', 'Bond', 2291.90, '2020-03-16 16-01-45', 1),
(3, 'Fidelity', 'Fidelity Brokerage', 'Bond', 53165.79, '2020-04-30 16-48-03', 1),
(4, 'Madrigal Electromotive', 'Skyler White 401K', 'ETF', 16838.00, '2020-05-13 11-46-32', 1),
(5, 'Pershing', 'IRA 1', 'ETF', 90472.35, '2020-06-09 10-49-18', 1),
(6, 'Pershing', 'IRA 2', 'ETF', 455191.03, '2020-06-09 10-49-20', 1),
(7, 'Saul Goodman', 'Saul Goodman 401K', 'Stock', 31715.00, '2020-02-29 09-26-32', 1),
(8, 'Stock options', 'Pandora', 'Stock', 75001.96, '2020-03-16 16-01-45', 1),
(9, 'Stock options', 'Pandora', 'Stock', 67543.88, '2020-04-30 16-48-03', 1),
(10, 'Apple Inc', 'Taxable', 'Stock', 33000.67, '2020-05-13 11-46-32', 1),
(11, 'Beneke Fabricators', 'Skyler White 401K', 'Stock', 76543.00, '2020-07-23 13-31-13', 2),
(12, 'Fidelity Cash', 'Cash Management', 'Stock', 8876.90, '2020-08-16 14-07-03', 2),
(13, 'Fidelity', 'Fidelity Brokerage', 'Stock', 9987.79, '2020-09-17 09-34-16', 2),
(14, 'Madrigal Electromotive', 'Skyler White 401K', 'Stock', 3345.00, '2020-10-20 16-12-59', 2),
(15, 'Pershing', 'IRA 1', 'Stock', 9998.35, '2020-11-12 10-37-16', 2),
(16, 'Pershing', 'IRA 2', 'Stock', 6665.03, '2021-01-11 10-54-11', 2),
(17, 'Saul Goodman', 'Saul Goodman 401K', 'Stock', 35745.00, '2021-01-11 10-54-13', 2),
(18, 'Stock options', 'Pandora', 'Stock', 90876.96, '2021-02-09 15-17-08', 2),
(19, 'Stock options', 'Pandora', 'Stock', 22235.88, '2021-03-23 11-56-01', 2),
(20, 'Apple Inc', 'Taxable', 'Stock', 45786.67, '2021-05-04 09-01-17', 2);
CREATE TABLE cash_transcation  (
                                   id INT AUTO_INCREMENT,
                                   cash_id INT,
                                   amount INT,
                                   time DATETIME,
                                   PRIMARY KEY (id),
                                   CONSTRAINT fk_investment_cash_cash_id FOREIGN KEY (cash_id) REFERENCES cash(id)
);
CREATE TABLE investment_transcation  (
                                         id INT AUTO_INCREMENT,
                                         investment_id INT,
                                         amount INT,
                                         time DATETIME,
                                         PRIMARY KEY (id),
                                         CONSTRAINT fk_investment_investment_investment_id FOREIGN KEY (investment_id) REFERENCES investment(id)
);
INSERT INTO cash_transcation (id, cash_id, amount, time) VALUES
(1, 1, 333.24, '2021-06-21 13-36-12'),
(2, 2, 456.31, '2021-07-16 14-04-37'),
(3, 5, 22.11, '2021-07-26 12-48-11'),
(4, 6, 200.00, '2021-07-26 09-16-38'),
(5, 4, 100.00, '2021-07-08 13-11-26'),
(6, 3, 199.45, '2021-05-31 09-18-17'),
(7, 2, 24.15, '2021-04-17 16-28-11'),
(8, 2, 25.14, '2020-11-01 09-12-47'),
(9, 3, 125.33, '2020-12-03 16-34-08'),
(10, 4, 89.97, '2020-12-05 15-14-44');
INSERT INTO investment_transcation (id, investment_id, amount, time) VALUES
(1, 1, 27.24, '2021-06-21 13-36-12'),
(2, 12, 234.31, '2021-07-16 14-04-37'),
(3, 15, 10.11, '2021-07-26 12-48-11'),
(4, 6, 260.00, '2021-07-26 09-16-38'),
(5, 14, 145.00, '2021-07-08 13-11-26'),
(6, 3, 298.45, '2021-05-31 09-18-17'),
(7, 2, 19.15, '2021-04-17 16-28-11'),
(8, 20, 245.14, '2020-11-01 09-12-47'),
(9, 3, 300.33, '2020-12-03 16-34-08'),
(10, 4, 28.97, '2020-12-05 15-14-44');


