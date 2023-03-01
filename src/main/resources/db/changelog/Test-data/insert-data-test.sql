INSERT INTO `manager` (`id`, `first_name`, `last_name`, `status`)
VALUES (1, 'Donald', 'Tramp', 1),
       (2, 'Olaf', 'Scholz', 1),
       (3, 'Manuel', 'Makron', 1),
       (4, 'Piter', 'Pen', 2),
       (5, 'Lion', 'King', 3);


INSERT INTO `client` (`id`, `manager_id`, `status`, `tax_code`, `first_name`, `last_name`, `email`, `address`, `phone`)
VALUES ('81cf3044-b1cd-11ed-8545-08979887bb18', 1, 1, '8254547854875', 'Bon', 'Jovi',
        'bonjovi@gmail.com', 'California, Lenina 1', '000118882744'),
       ('4c35d4b3-b7d3-11ed-8545-08979887bb18', 2, 1, '8254798798798', 'Elon', 'Mask',
        'mask@gmail.com',
        'Florida, 1Maya 5', '000678565555');
INSERT INTO `account` (`id`, `client_id`, `name`, `type`, `status`, `balance`, `currency_code`)
VALUES ('b8ed7c33-b1cd-11ed-8545-08979887bb78', '81cf3044-b1cd-11ed-8545-08979887bb18', 'First', 1, 1, 100.00, 1),
       ('e5655ad4-b1cd-11ed-8545-08979887bb18', '80cf3044-b1cd-11ed-8545-08979887bb18', 'Second', 2, 1, 2000.00, 2);

INSERT INTO `transaction` (`id`, `debit_account_id`, `credit_account_id`, `type`, `amount`, `description`)
VALUES ('39820e01-b1ce-11ed-8545-08979887bb18', 'e7655ad4-b1cd-11ed-8545-08979887bb18', 'b8ed7c33-b1cd-11ed-8545-08979887bb18', 1, 100, 'first transaction'),
       ('f42cf7fa-b1d9-11ed-8545-08979887bb18', 'e5655ad4-b1cd-11ed-8545-08979887bb18', '5e938b24-b1d5-11ed-8545-08979887bb18', 1, 1000, 'transaction 2');

INSERT INTO `product` (`manager_id`, `name`, `status`, `currency_code`, `interest_rate`, `limit`)
VALUES (1, 'Deposit', 1, 1, 15, 1000000),
       (2, 'Credit', 1, 1, 5, 10000);

INSERT INTO agreement (account_id, product_id, interest_rate, status, sum)
VALUES ('b8ed7c33-b1cd-11ed-8545-08979887bb18', 1, 15, 1, 10000),
       ('72c98cd7-b1d5-11ed-8545-08979887bb18', 6, 12, 1, 10000);
