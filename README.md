# Loganyra

架构如下：
    主线调用链：controller -> service -> dao -> JPA -> database_driver -> database
    支线：
        1.启动后任务：①打印信息②视情况初始化数据库表
        2.出现事件后任务
