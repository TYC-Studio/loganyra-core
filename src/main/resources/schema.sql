CREATE TABLE IF NOT EXISTS `logs` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Log ID',
    `app_name` VARCHAR(255) NOT NULL COMMENT 'App name',
    `content` LONGTEXT NOT NULL COMMENT 'Log content',
    `created_time` DATETIME NOT NULL COMMENT 'Creation time',
    PRIMARY KEY (`id`),
    INDEX `idx_logs_created_time` (`created_time`)
) DEFAULT CHARSET=utf8mb4;