# 一、报错与解决

## Ⅰ-解除输入的安全模式

>1. 报错:`You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.000 sec`
>
>2. 这是因为MySql运行在safe-updates模式下，该模式会导致非主键条件下`无法执行update或者delete命令`。
>
>   1. show variables like ‘SQL_SAFE_UPDATES’;查看开关状态。
>
>   2. 执行命令SET SQL_SAFE_UPDATES = 0;修改下数据库模式
>
>      ![image-20210512185116624](Mysql使用笔记中的图片/image-20210512185116624.png)
>
>3. 至此可以正常修改了