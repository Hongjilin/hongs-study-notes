# -----------------------==(NODE陆)==------------------------

#  Redis+Mysql数据库安装以及使用 =>Day_7_25

## 一.Redis(远程字典服务)

### 	1.Redis的特点:

1)工作的时候用的是以内存作为储存媒介,支持持久化

###     2.Redis的优点:

###### 				1.速度快

>    ​	(1) 因为数据存在内存中，类似于 HashMap ，HashMap 的优势就是查找和操作的时间复杂度都是O (1) 。
>    (2) Redis 本质上是一个 Key-Value 类型的内存数据库，很像Memcached ，整个数据库统统加载在内存当中进行操作，定期通过**异步操作**把数据库数据 flush 到硬盘上进行保存。fork子进程持久化。
>    (3) 因为是纯内存操作，Redis 的性能非常出色，每秒可以处理超过 10 万次读写操作，是已知性能最快的 Key-Value 数据库。

###### 				2.支持丰富数据类型: String ，List，Set，Sorted Set，Hash 。

>    Redis 的出色之处不仅仅是性能，Redis 最大的魅力是支持保存多种数据结构，此外单个 Value 的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能

###### 				3.丰富的特性

>    订阅发布 Pub / Sub 功能
>    Key 过期策略
>    事务
>    支持多个 DB
>    计数

###### 				4.持久化存储

>    Redis 提供 RDB 和 AOF 两种数据的持久化存储方案，解决内存数据库最担心的万一 Redis 挂掉，数据会消失掉。

### 		3.Redis的缺点:

>    1.由于 Redis 是内存数据库，所以，单台机器，存储的数据量，跟机器本身的内存大小。虽然 Redis 本身有Key 过期策略，但是还是需要提前预估和节约内存。如果内存增长过快，需要定期删除数据。
>
>    2.redis是单线程的，单台服务器无法充分利用多核服务器的CPU

### 4.Redis -window 64bit 版本的使用=>

##### 		1.安装:免安装

##### 		2.使用:

###### 			1.双击redis-server.exe

>    Q: 如果启动报错建议查看错误日志(最难的bug,最难的是除了bug,没有bug)
>
>    *           eg:没有找到配置文件
>    *           解决措施:基于cmd运行下面命令来解决(显卡的指定配置0)
>    *           redis-server.exe redis.window-service.conf(解释:指定以后面那个位置)

###### 			2.redis-cli.exe双击(客户端测试时候使用)

###### 			3.熟练掌握两个命令: set key value   ,   get key

### 5.实际操作(基于node来连接redis)=>

###### 	   1.安装node 的redis 的依赖包, npm install redis

###### 		2.熟练调度redis的基本api

###### 		3.登陆成功后将用户的信息存储在redis里头,取而代之不用session

###### 		4.每次获取用户具体的信息的时候不走数据库,直接走redis



### 6.redisUtil(封装工具包)=>

```js
const redis = require('redis');
const client = redis.createClient(6379, 'localhost');
// const client = redis.createClient();
//获取当前db中所有的key
// function getdbnamelist(){
//     // 相当于命令（keys *）, 返回list，包含当前db所有key的名字
//     client.keys('*',function(err,val){
//         console.log(val);
//         //callback(val);
//     });
// }

/**
 * 设置键值
 * @param dbNum 库号
 * @param key 键
 * @param value 值
 * @param expire 过期时间（单位：秒，可为空，为空则不过期）
 */
let set =  (key,value,expire,dbNum) => {
    if (typeof(value)=='object') {
        value=JSON.stringify(value)
    }
    
    console.log(`[redis]set key=${key}  value=${value}  expire=${expire}  dbNum=${dbNum}`)
    if (!dbNum) {
        dbNum = 0
    }
    return  new Promise((resolve, reject) => {
        client.select(dbNum,function (err) {//设置库
            if (err){
                console.error('redis set 选库失败：'+err)
                // throw new Error('redis set 选库失败：'+err);
            }else {
                client.set(key,value,function (err,result) {//设置值
                    if (err){
                        console.error('redis插入失败：'+err)
                        // throw new Error('redis插入失败：'+err);
                    } else {
                        if (!isNaN(expire) && expire>0){
                            client.expire(key, parseInt(expire));//设置过期时间
                        }
                        resolve(result);
                    }
                })
            }

        })
    })
};

/**
 * 获取缓存
 * @param key
 * @param dbNum
 * @return {Promise<*>}
 */
let get = async (key, dbNum) => {
    console.log(`[redis]get key=${key} dbNum=${dbNum}`)
    if (!dbNum) {
        dbNum = 0
    }
    return   new Promise((resolve, reject) => {
        client.select(dbNum, function (err) {//链接库
            if (err){
                console.error('redis set 选库失败：'+err)
                // throw new Error('redis get 选库失败：'+err);
            }else {
                client.get(key, function (err,result) {//获取值
                    if (err){
                        console.error('redis读取失败：'+err)
                        // throw new Error('redis get 获取失败：'+err);
                    } else {
                        resolve(result);
                    }
                })
            }
        })
    })

};

module.exports = {
    get,
    set,
    // getays
}
```

## 二.Mysql(关系型数据库管理系统)

### 1.安装Mysql准备工作

>    选择引擎（innoDB(支持十五，通常我们会使用innoDB) Myisam Memory(内存数据库)）
>    选择编码    （一定要用UTF-8）
>    mysql
>    版本：目前使用5.7版本
>    安装（服务端）：
>    安装（客户端）：
>    REPL(mysql -u 用户名 -p 回车 再输入密码)
>    NAVICATE (破解)
>    NAVITOR (功能比较齐全，需自己下载)

### 2.mysql的运行原理:

	> 分析器
	       优化器
	       执行器(缓存)

### 3.实际操作=>

###### 			1.实现客户端连接数据库

###### 			2.基于客户端完成一张表的创建和配置过程

###### 			3.基于客户端完成mysql语法的基本讲解

###### 			4.NODE来操作数据库=>

>     4.1下载mysql的包
>       	  4.2实现node操作mysql的api
>        	 4.3实现用户注册-用户信息入库保存
>             4.4实现用户登录-根据数据库用户信息验证合法性
>       	 4.5实现获取当前用户的全部信息的功能

### 4.数据类型

##### 	1.js基础数据类型

>    Boolean
>    Number
>    Undefined
>    Object
>    String
>    Function

##### 	2.数据库基本数据类型

>    tinyint  =>boolean
>    int    =>int
>    varchar(length->长度参数）)  =>String
>    mediumtext  ==>长文本
>    datetime=> 时间Date类型
>

### 	5.数据库自动填入创建时间

```
//在时间戳那个数据默认中输入，表示自动填入时间
		CURRENT_TIMESTAMP
```

### 6.Mysql入门

###### 	1.mysql入门教学-概念

>数据库=》excel
>
>表 =》sheet
>
>字段=》字段
>
>主键 =》如果某个字段是逐渐，那么要求该字段的内容不能为空且不重复
>
>非空=》要求这个字段不嫩为空

2.mysql入门教学-基础数据库语句=>

```数据库
创建数据库：create database db_name character set utf8;
删除数据库：drop database db_name;
切换数据库：use dbname
创建表：create table student(id int primary key comment'这里写注释',name varchar(20),sex char(1) ,address varchar(20));
删除表：drop table tb_name1,tb_name2;
写入数据：全字段写入
insert into student values(001,'刘亦菲','女','湖北武汉'),(002,'杨幂','女','北京')；
写入数据：可选字段写入，其他字段自增或有默认值
insert into student(name,address) values('刘亦菲','湖北'),('杨幂',,'北京'),('刘诗诗','北京');
删除数据：delete from tbname where 条件，只删数据，不删结构
delete from student where id=003;
修改数据：update student set key=value,key2=value2 where 条件
update student set address='湖北' where id=001;
查看数据：select 字段1，字段2，.. from tbname；
select * from student;
查看表的结构：desc tbname；
修改表名：alter table tb_name rename to tb_name_new;
修改字段(包括名称，类型，约束)：alter table tb_name change column_name column_name_new 数据类型 约束;
例：alter table student change sex 性别 char(1) not null default '女';
修改字段类型：alter table tb_name modify column_name 修改后的字段类型；
添加字段：alter table 表名 add 字段名 数据类型 约束 字段位置(first,或者after xxx);
例：alter table tb_name add column_name decimal not null after cno;第一个则用first
删除字段：alter table tb_name drop column_name；
修改字段的默认值：alter table tb_name alter column_name set Default 666;
删除字段的默认值：alter table tb_name alter column_name drop Default;
查看建表命令：show create table tbname；内含表的编码格式
修改数据库编码格式：alter database <数据库名> character set utf8;
修改表的编码格式：alter table 表名 convert to character set utf8;
//笔记记载
查询用户信息
获取 id为1并且account为a的用户信息
SELECT * FROM `user` a WHERE id = 1 AND account = 'a'
获取到的信息分页  第几个开始，每页的个数
SELECT * FROM `user` LIMIT 1,2
//根据密码分组
SELECT COUNT(1), pwd FROM `user` GROUP BY pwd
//左连接
SELECT a.name AS '用户名', b.name AS '课程' FROM `user` a LEFT JOIN lesson b ON a.id=b.user_id
//更新修改
UPDATE `user` SET pwd='1231' WHERE id ='1'
```

### 7.mysqlUtil(数据库工具包)=>

```js
// 操作数据库模块 扫地僧 2019年5月30日19:58:46
var mysql = require('mysql');
let logPrefix=mysql
var pool = mysql.createPool({
    host     : 'localhost',
    user     : 'root',
    password : 'root',
    port     : '3306',
    database : 'xunke725'//数据库名称
});

/**
 * 增删改查 通用组件  同步写法
 *
 * @param sql 增删改查sql 含占位符
 * @param params 跟占位符顺序匹配的参数数组，要求跟sql的占位符数量一样多
 */
let exec =  function (sql,params) {
    // 返回一个 Promise
        return  new Promise((resolve, reject) => {
            pool.getConnection(function (err, connection) {
                if (err) {
                    console.error(err)
                } else {
                    //query执行sql语句
                    connection.query(sql, params, (err, results) => {

                        if (err) {
                            console.error(err)
                          //  reject(err)
                        } else {
                            console.log(`${logPrefix}result : ${JSON.stringify(results)}`);
                            resolve(results)
                        }
                        // 结束会话 释放链接
                        connection.release()
                    })
                }
            })
        })
}

/**
 * 将所有的参数格式化成数组 参数是可变参数（可变参数在函数声明的时候不写）
 * @returns {Array}
 */
let formatParams = function () {
    var array = [];

    //js中有个变量arguments,可以访问所有传入的值
    for(var i = 0, l = arguments.length; i < l; i++){
        array.push(arguments[i]);
    }
    return array;
}
module.exports = {exec, formatParams};
```

## 三.问题以及解决:

#### 	1.控制台报错Error: Expected "payload" to be a plain object

​			1.问题出现场景

```js
//sign第一个参数必须是对象 ```````````!!!!!!!!!!!!!!!!!重点
//犯的错误:传入第一个参数其实并没有转化好导致报错
resp.send(jwtUtils.sign({id:loginSuss[0].id},global.globalKey,3600))
```

​			2)解决方式

```js
拦截器,传入参数错误
*错误代码：
var token = jwt.sign(user, 'app.get(superSecret)',
解决代码：
var token = jwt.sign(user.toJSON(), ‘app.get(superSecret)’,
```

#### 2.控制台报错Uncaught TypeError: Cannot read property 'setItem' of undefined

1)问题出现场景

```js
//localStorage写成localstorage导致变成声明一个window变量
window.localstorage.setItem("token",result);
```

2)解决方式

```js
//登陆成功后写入localStorage的token ~~~~~!!!!!!!!S未大写
window.localStorage.setItem("token",result);
```

#### 3.由于将登录以外的路径拦截 导致图片验证码以及其他的都无效且不显示

1)问题出现场景

```js
//检查路由 决定是否拦截,``````````~~~~~~~~!!!!!犯的错误:将除了登陆外的全部拦截了
if (path.startsWith('/users/login')) {next();}
```

2)解决方式

```js
//此处我将所有user的路径暂时都放出来
if (path.startsWith('/users/login')||path.startsWith('/user')) {  next();}
```

##### 4.Promise+await+async的使用相关问题

1)问题出现场景

```js
let login= (req,resp)=>{
    let loginSuss=  mysqlUtil.exec(loginSql,mysqlUtil.formatParams(name))
    }
```

2)解决

mysqlUtil.exec()内是一个Promise,需要await异步转同步,否出得到的返回值将会是一个挂起的Promise对象

加完后要在外部login函数上加async,将整体转为异步方法,内部由await也必须加上这个

```js
let login=async (req,resp)=>{
let loginSuss= await mysqlUtil.exec(loginSql,mysqlUtil.formatParams(name))
}
```