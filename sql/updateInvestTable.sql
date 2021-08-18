use conygre;
UPDATE investment i SET i.name = "AAPL" WHERE i.name = "Apple Inc"; 

UPDATE investment i SET i.portfolio = "Bond" where i.id >= 11 and i.id <= 13;
UPDATE investment i SET i.portfolio = "ETF" where i.id >= 14 and i.id <= 16;

UPDATE investment i SET i.name = "MSFT" WHERE i.name = "Saul Goodman"; 
UPDATE investment i SET i.name = "TSLA" WHERE i.name = "Stock options"; 
UPDATE investment i SET i.name = "JPM" WHERE i.id = 9 or i.id = 19;
UPDATE investment i SET i.category = "Technology" WHERE i.name = "AAPL" or i.name = "MSFT" or i.name = "TSLA"  ; 
UPDATE investment i SET i.category = "Finance" WHERE i.name = "JPM";

INSERT INTO investment (id, name, category, portfolio, amount, last_update_time, user_id) VALUES
(21, 'PYPL', 'Business Services', 'Stock', 16231.00, '2020-02-29 09-26-32', 1),
(22, 'NVDA', 'Technology', 'Stock', 2291.90, '2020-03-16 16-01-45', 1),
(23, 'SQ', 'Technology', 'Stock', 53165.79, '2020-04-30 16-48-03', 1),
(24, 'DIDI', 'Technology', 'Stock', 16838.00, '2020-05-13 11-46-32', 1),
(25, 'PFE', 'Healthcare', 'Stock', 90472.35, '2020-06-09 10-49-18', 1),
(26, 'AMC', 'Communication', 'Stock', 455191.03, '2020-06-09 10-49-20', 1),

(27, 'SQ', 'Technology', 'Stock', 31715.00, '2020-02-29 09-26-32', 2),
(28, 'PYPL', 'Business Services', 'Stock', 75001.96, '2020-03-16 16-01-45', 2),
(29, 'NVDA', 'Technology', 'Stock', 67543.88, '2020-04-30 16-48-03', 2),
(30, 'DIDI', 'Technology', 'Stock', 33000.67, '2020-05-13 11-46-32', 2),
(31, 'PFE', 'Healthcare', 'Stock', 76543.00, '2020-07-23 13-31-13', 2),
(32, 'AMC', 'Communication', 'Stock', 8876.90, '2020-08-16 14-07-03', 2);

CREATE TABLE net_worth_history  (		
                                         id INT AUTO_INCREMENT,
                                         user_id INT,
                                         net_worth INT,
                                         date DATE,
                                         PRIMARY KEY (id),
                                         CONSTRAINT fk_net_worth_history_user_id FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE cash_history  (		
                                         id INT AUTO_INCREMENT,
                                         user_id INT,
                                         cash INT,
                                         date DATE,
                                         PRIMARY KEY (id),
                                         CONSTRAINT fk_cash_history_user_id FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE investment_history  (		
                                         id INT AUTO_INCREMENT,
                                         user_id INT,
                                         investment INT,
                                         date DATE,
                                         PRIMARY KEY (id),
                                         CONSTRAINT fk_investment_history_user_id FOREIGN KEY (user_id) REFERENCES user(id)
);

delimiter $$
create procedure net_worth_history_procedure()
begin
DECLARE done INT DEFAULT 0;
DECLARE c_id INT DEFAULT -999;
DECLARE c_cash_amount INT DEFAULT 0;
DECLARE c_investment_amount INT DEFAULT 0;
DECLARE cursor_user_id CURSOR FOR SELECT id FROM user;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
OPEN cursor_user_id;
  loop_through_rows: LOOP
	FETCH cursor_user_id INTO c_id;
    IF done = 1 THEN
            LEAVE loop_through_rows;
	END IF;
    select sum(amount) into c_cash_amount from cash where user_id = c_id and DATE(last_update_time) < DATE(now());
    select sum(amount) into c_investment_amount from investment where user_id = c_id and DATE(last_update_time) < DATE(now());
	insert into net_worth_history(user_id, net_worth, date) values (c_id, c_cash_amount + c_investment_amount, now());
    set c_cash_amount = 0;
    set c_investment_amount = 0;
  END LOOP;
CLOSE cursor_user_id;
end$$

delimiter $$
create procedure cash_history_procedure()
begin
DECLARE done INT DEFAULT 0;
DECLARE c_id INT DEFAULT -999;
DECLARE c_cash_amount INT DEFAULT 0;
DECLARE cursor_user_id CURSOR FOR SELECT id FROM user;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
OPEN cursor_user_id;
  loop_through_rows: LOOP
	FETCH cursor_user_id INTO c_id;
    IF done = 1 THEN
            LEAVE loop_through_rows;
	END IF;
    select sum(amount) into c_cash_amount from cash where user_id = c_id and DATE(last_update_time) < DATE(now());
	insert into cash_history(user_id, cash, date) values (c_id, c_cash_amount, now());
    set c_cash_amount = 0;
  END LOOP;
CLOSE cursor_user_id;
end$$

delimiter $$
create procedure investment_history_procedure()
begin
DECLARE done INT DEFAULT 0;
DECLARE c_id INT DEFAULT -999;
DECLARE c_investment_amount INT DEFAULT 0;
DECLARE cursor_user_id CURSOR FOR SELECT id FROM user;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
OPEN cursor_user_id;
  loop_through_rows: LOOP
	FETCH cursor_user_id INTO c_id;
    IF done = 1 THEN
            LEAVE loop_through_rows;
	END IF;
    select sum(amount) into c_investment_amount from cash where user_id = c_id and DATE(last_update_time) < DATE(now());
	insert into investment_history(user_id, investment, date) values (c_id, c_investment_amount, now());
    set c_investment_amount = 0;
  END LOOP;
CLOSE cursor_user_id;
end$$

CREATE EVENT `net_worth_history_event`
ON SCHEDULE EVERY 1 DAY STARTS '2021-08-19 00:00:00'
ON COMPLETION NOT PRESERVE
ENABLE
DO call net_worth_history_procedure();

CREATE EVENT `cash_history_event`
ON SCHEDULE EVERY 1 DAY STARTS '2021-08-19 00:00:00'
ON COMPLETION NOT PRESERVE
ENABLE
DO call cash_history_procedure();

CREATE EVENT `investment_history_event`
ON SCHEDULE EVERY 1 DAY STARTS '2021-08-19 00:00:00'
ON COMPLETION NOT PRESERVE
ENABLE
DO call investment_history_procedure();

call net_worth_history_procedure();
call cash_history_procedure();
call investment_history_procedure();
