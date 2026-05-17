INSERT INTO `logs` (`app_name`, `content`, `created_time`) VALUES
    ('user-service', 'User login successful: username=admin, ip=192.168.1.100', NOW()),
    ('order-service', 'Order processed successfully: orderId=ORD-12345, amount=199.99', NOW());