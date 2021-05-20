# #说明

>操作mysql数据库工具包 
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin)
>转载请注明出处。

# 一、数据库链接与操作工具包-`2020`

>该模块封装于2020疫情本人撰写 [nodejs+vue搭建校园疫情防控系统实战项目(全栈项目)](https://www.bilibili.com/video/BV1Z54y1y79p?share_source=copy_web)项目期间,主要用于Nodejs项目链接数据库与操作
>
>操作数据库模块 [hongjilin](https://gitee.com/hongjilin) 2020年7月29日
>
>当时编程习惯还不是很好,如类名命名规范等,可以自行更正

## 1、类方式声明与使用

### Ⅰ-工具包代码

>该声明方式好处在于,多次调用时我可以用类与继承的方式进行调用,非常方便
>
>```js
>/**操作数据库模块 author [洪吉林] 2020年7月29日*/
>----------------------------------------------------------------------------              
>const  mysql=require('mysql')
>const  pool=mysql.createPool({ 
>    host:'localhost',
>    user:'root',
>    password:'root',
>    port:'3306',
>    database:'vue_store' //数据库名
>
>})
>/**
> * 封装一个数据库模型基类
> * @type {module.Model}
> */
>module.exports=class  Model {
>    /**
>     * 通用的查询方法
>     * @param sql 要执行的sql语句
>     * @param params  给sql语句的占位符进行赋值的参数数组
>     */
>    static  query(sql,params){
>        return new Promise((resolve ,reject)=>{
>            pool.getConnection(function (err,connection) {
>                if (err){
>                    console.error(err)
>                    connection.release()
>                }else{
>                    //query执行sql语句
>                    connection.query(sql, params,(err,results)=>{
>                        if (err){
>                            console.error(err)
>                            reject(err)
>                        }else{
>                            resolve(results)
>                        }
>                        //结束会话,释放连接
>                        connection.release()
>                    })
>                }
>                
>            })
>        })
>    }
>    //此处主要是外部传入参数格式转换
>    static formatParams(){
>        let array=[]
>        for (let i=0,l=arguments.length;i<l;i++){
>            array.push(arguments[i]);
>        }
>        return array
>    }
>}
>
>```

### Ⅱ-使用示例

>使用继承的方式,可以通过`this`的方式进行直接调用
>
>```js
>module.exports = class student_mod extends require('./model') {
>   static LoginUserByid(id,password,type){
>        type=Number(type)
>        return new Promise((resolve ,reject)=>{
>            let sql="select * from user where binary id='"+id+"' and password='"+password+"' and type= "+type
>            console.log(sql)
>            this.query(sql).then(result=>{
>                resolve(result)
>            }).catch(err=>{
>                reject('登录失败')
>            })
>        })
>}
>    /**
>     * 已读转未读
>     * @param u_id
>     * @param n_id
>     */
>    static goweiduMod(u_id, n_id) {
>        u_id = Number(u_id)
>        n_id = Number(n_id)
>        return new Promise((resolve, reject) => {
>            let sql = "delete from `read` where u_id = ? and n_id = ? "
>            this.query(sql, this.formatParams(u_id, n_id)).then(result => {
>                resolve("已读转未读成功")
>            }).catch(err => {
>                reject("已读转未读失败")
>            })
>        })
>    }
>    static gethealthNowDayPageTotal(newDate, lastDate) {
>        return new Promise((resolve, reject) => {
>            let sql = "select count(1) as count  from health where createtime between ? and ?"
>            this.query(sql, this.formatParams(newDate, lastDate)).then(result => {
>                resolve(result)
>            }).catch(err => {
>                reject(err)
>            })
>        })
>    }
>}
>```

## 2、函数声明方式

>直接以函数的方式调用即可
>
>```js
>// 操作数据库模块  mysqlUtils.js 工具包代码
>var mysql = require('mysql');
>let logPrefix=mysql
>var pool = mysql.createPool({
>host     : 'localhost',
>user     : 'root',
>password : 'root',
>port     : '3306',
>database : 'xxx'
>});
>
>/**
>* 增删改查 通用组件  同步写法
>*
>* @param sql 增删改查sql 含占位符
>* @param params 跟占位符顺序匹配的参数数组，要求跟sql的占位符数量一样多
>*/
>let exec =  function (sql,params) {
>   // 返回一个 Promise
>       return  new Promise((resolve, reject) => {
>           pool.getConnection(function (err, connection) {
>               if (err) {
>                   console.error(err)
>               } else {
>
>
>                   //query执行sql语句
>                   connection.query(sql, params, (err, results) => {
>
>                       if (err) {
>                           console.error(err)
>                         //  reject(err)
>                       } else {
>                           console.log(`${logPrefix}result : ${JSON.stringify(results)}`);
>                           resolve(results)
>                       }
>                       // 结束会话 释放链接
>                       connection.release()
>                   })
>
>
>               }
>           })
>       })
>}
>
>/**
>* 将所有的参数格式化成数组 参数是可变参数（可变参数在函数声明的时候不写）
>* @returns {Array}
>*/
>let formatParams = function () {
>   var array = [];
>   //js中有个变量arguments,可以访问所有传入的值
>   for(var i = 0, l = arguments.length; i < l; i++){
>       array.push(arguments[i]);
>   }
>   return array;
>}
>module.exports = {exec, formatParams};
>
>```
>
>