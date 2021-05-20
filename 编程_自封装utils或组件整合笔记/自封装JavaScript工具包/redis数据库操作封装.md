# #说明

>操作redis数据库工具包 
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin)
>转载请注明出处。



# 一、redis数据库的简单存取操作封装 -`2020`

>该模块封装于2020疫情本人撰写 [nodejs+vue搭建校园疫情防控系统实战项目(全栈项目)](https://www.bilibili.com/video/BV1Z54y1y79p?share_source=copy_web)项目期间,主要用于Nodejs项目链接数据库与操作
>
>操作redis数据库模块 [hongjilin](https://gitee.com/hongjilin) 2020年7月29日
>
>当时编程习惯还不是很好,如类名命名规范等,可以自行更正

## Ⅰ-代码

>```js
>const redis = require('redis');
>const client = redis.createClient(6379, 'localhost');
>// const client = redis.createClient();
>//获取当前db中所有的key
>// function getdbnamelist(){
>//     // 相当于命令（keys *）, 返回list，包含当前db所有key的名字
>//     client.keys('*',function(err,val){
>//         console.log(val);
>//         //callback(val);
>//     });
>// }
>
>/**
> * 设置键值
> * @param dbNum 库号
> * @param key 键
> * @param value 值
> * @param expire 过期时间（单位：秒，可为空，为空则不过期）
> */
>let set =  (key,value,expire,dbNum) => {
>    if (typeof(value)=='object') {
>        value=JSON.stringify(value)
>    }
>    
>    console.log(`[redis]set key=${key}  value=${value}  expire=${expire}  dbNum=${dbNum}`)
>    if (!dbNum) {
>        dbNum = 0
>    }
>    return  new Promise((resolve, reject) => {
>        client.select(dbNum,function (err) {//设置库
>            if (err){
>                console.error('redis set 选库失败：'+err)
>                // throw new Error('redis set 选库失败：'+err);
>            }else {
>                client.set(key,value,function (err,result) {//设置值
>                    if (err){
>                        console.error('redis插入失败：'+err)
>                        // throw new Error('redis插入失败：'+err);
>                    } else {
>                        if (!isNaN(expire) && expire>0){
>                            client.expire(key, parseInt(expire));//设置过期时间
>                        }
>                        resolve(result);
>                    }
>                })
>            }
>
>        })
>    })
>};
>
>/**
> * 获取缓存
> * @param key
> * @param dbNum
> * @return {Promise<*>}
> */
>let get = async (key, dbNum) => {
>    console.log(`[redis]get key=${key} dbNum=${dbNum}`)
>    if (!dbNum) {
>        dbNum = 0
>    }
>    return   new Promise((resolve, reject) => {
>        client.select(dbNum, function (err) {//链接库
>            if (err){
>                console.error('redis set 选库失败：'+err)
>                // throw new Error('redis get 选库失败：'+err);
>            }else {
>                client.get(key, function (err,result) {//获取值
>                    if (err){
>                        console.error('redis读取失败：'+err)
>                        // throw new Error('redis get 获取失败：'+err);
>                    } else {
>                        resolve(result);
>                    }
>                })
>            }
>        })
>    })
>
>};
>/*let getays=(key,dbNum)=>{
> return   client.select(dbNum, function (err) {//链接库
>        if (err){
>            console.error('redis set 选库失败：'+err)
>            // throw new Error('redis get 选库失败：'+err);
>        }else {
>            client.get(key, function (err,result) {//获取值
>                if (err){
>                    console.error('redis读取失败：'+err)
>                    // throw new Error('redis get 获取失败：'+err);
>                } else {
>                    console.log("result")
>                    console.log(result)
>                    console.log("出去了")
>                    resolve(result);
>                }
>            })
>        }
>    })
>}*/
>module.exports = {
>    get,
>    set,
>    // getays
>}
>```

## Ⅱ-简单使用实例

>```js
>const  redisUtils=require('../utils/redisUtils') 
>redisUtils.set("xlsxData",JSON.stringify(obj),3600)  //存
>
>let xlsxData=await redisUtils.get("xlsxData") //取
>```