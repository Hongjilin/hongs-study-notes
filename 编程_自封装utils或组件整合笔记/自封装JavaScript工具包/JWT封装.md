# #说明

>什么是JWT?
>
>Json web token (JWT),该token被设计为紧凑且安全的。JWT的声明一般被用来在身份提供者和服务提供者间传递被认证的用户身份信息，以便于从资源服务器获取资源，也可以增加一些额外的其它业务逻辑所必须的声明信息，该token也可直接被用于认证，也可被加密。
>
>该模块封装于2020疫情本人撰写 [nodejs+vue搭建校园疫情防控系统实战项目(全栈项目)](https://www.bilibili.com/video/BV1Z54y1y79p?share_source=copy_web)项目期间,主要用于用户数据的加密传输,并用于替代`session`与`cookie`,当时编程习惯还不是很好,如类名命名规范等,可以自行更正
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin)
>转载请注明出处。

# Ⅰ-工具包代码 -`2020`

>```js
>// 安全拦截器
>const jwt = require("jsonwebtoken");
>/**
> * 验证权限
> * @param token
> * @param secretkey 秘钥
> * @param success
> * @param error
> */
>function verify (token,secretkey,success,error){
>    jwt.verify(token,secretkey,function(err,decode){
>        if(err){
>            if (error)  error(err);
>        }else{
>            if (success) success(decode);
>        }
>    })
>}
>
>/**
> * 签名
> * @param load 载荷 json对象 存储存在
> * @param secretkey 秘钥
> * @param expiresIn 过期时间 秒
> * @returns {number | PromiseLike<ArrayBuffer>}
> */
>function sign (load,secretkey,expiresIn) {
>    var token = jwt.sign(load,secretkey,{expiresIn: expiresIn});
>    return token;
>}
>
>/**异步转同步
> * 这个再app.js路由调用中已经转换过一次,所以不用重复转换
> * @param token
> * @param secretkey
> * @returns {Promise<any>}
> */
> function   verifysync (token,secretkey){
>    return   new Promise((resolve,reject)=>{
>        jwt.verify(token,secretkey,function(err,decode){
>            if (err) {
>                console.log(err.message);
>                resolve({err:'error',msg:'会话已过期'})
>            }else{
>                console.log("解密成功")
>                resolve(decode)
>            }
>        })
>
>    })
>
>}
>
>module.exports = {verify,sign,verifysync};
>
>
>/*//使用解密   此部分为测试封装成功与否的数据
>let user={id:111,name:'user',password:123456};
>/!*
>//q清空密码
>delete user.password;
>let token=sign(user,'123456',10);*!/
>//解密
>let token=sign(user,'123456',10);
>verify(token,"123456",function (user) {
>    console.log(user);
>},function (err) {
>    console.error(err)
>    }
>)
>console.log(token);*/
>
>
>/*verify(token,'123456',function (user) {
>    console.log(user)
>},function (err) {
>    console.error(err);
>})*/
>
>```

# Ⅱ-使用示例

>导入工具包,调用函数即可
>
>```js
>const  jwtUtil=require('../utils/jwtUtils')
>module.exports=class users_dao extends  require('../model/users_mod'){
>    /**
>     * 登录  ---加密示例
>     * @param req
>     * @param resp
>     * @returns {Promise<void>}
>     * @constructor
>     */
>    static  async Login(req,resp){
>        let body= req.body
>        let loginData= await  this.LoginUser(body.username,body.password,body.type)
>        // let loginData= await  this.LoginUserByid(body.username,body.password,body.type)
>        //如果获取到了登录用户信息则登陆成功
>        if (loginData.length!=0){
>            let jwt_token= jwtUtil.sign({...loginData},global.globalKey,3600)
>            resp.send({loginData,jwt_token})
>        }else  resp.status(500).send("用户名或者账号输入错误")
>    }
>
>    /**
>     * 根据token解析成用户信息     --解密示例
>     * @param req
>     * @param resp
>     */
>    static async getUserDataByToken(req,resp){
>        let result=await jwtUtil.verifysync(req.query.token,global.globalKey)
>        resp.send(result)
>    }
>
>}
>```