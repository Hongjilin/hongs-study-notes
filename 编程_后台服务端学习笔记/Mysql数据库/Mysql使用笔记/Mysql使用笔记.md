# 一、报错与解决

## Ⅰ-解除输入的安全模式

>1. 报错:`You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.000 sec`
>
>2. 这是因为MySql运行在safe-updates模式下，该模式会导致非主键条件下`无法执行update或者delete命令`。
>
>  1. show variables like ‘SQL_SAFE_UPDATES’;查看开关状态。
>
>  2. 执行命令SET SQL_SAFE_UPDATES = 0;修改下数据库模式
>
>     ![image-20210512185116624](Mysql使用笔记中的图片/image-20210512185116624.png)
>
>3. 至此可以正常修改了



## Ⅱ-忘记密码 修改密码

>1. 报错:`ERROR 1045 (28000): Access denied for user 'root'@'localhost' (using password: YES)`,后面这个也可能是`password:NO`
>
>2. 出现场景,这个问题总是在`Mysql8.0`版本出现,我们班很多同学都出现了这个问题,包括命名密码正确,但是就是无法读取链接数据库,这时就需要修改密码
>
>3. 此处给出一个个人觉得最简单的方法:
>
>   1. 打开`服务`,找到``Mysql`服务,双击打开
>   2. 如果`MysqlId`在运行,需要先关闭
>   3. 直接在`登录`中修改密码
>   4. 重启服务
>
>   ![image-20210524173910554](Mysql%E4%BD%BF%E7%94%A8%E7%AC%94%E8%AE%B0%E4%B8%AD%E7%9A%84%E5%9B%BE%E7%89%87/image-20210524173910554.png)
>
>   























