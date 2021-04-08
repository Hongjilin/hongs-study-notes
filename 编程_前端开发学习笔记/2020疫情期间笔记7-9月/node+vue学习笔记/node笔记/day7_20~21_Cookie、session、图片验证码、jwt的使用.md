



------



# -----------------------==(NODE叁)==-------------------------

# Cookie、session、图片验证码、jwt的使用、跨域设置=>Day7_20~21

## 一.response.cookie和request.cookie的区别

##### 1.范围特点使用语法各不相同

```
response.cookie：
```

1.  操作过的Cookie，所有方法获取到的都是被更新过的值，也就是说Response.Cookies是修改所有容器中的Cookie的值。   
2.  用于在客户端写入cookie值。若指定的cookie不存在，则创建它。若存在，则将自动进行更新。结果返回给客户端浏览器。   

3.  Response.Cookies(CookieName)[(key)|.attribute]=value。这里的CookiesName是指定的Cookie的名称，如果指定了Key，则该Cookie就是一个字典，Attribute属性包括Domain，Expires，HasKeys，Path，Secure。

```
request.cookie：
```

1.  创建的Cookie只能用于后台不能用于HTML的前台。
2.  设置cookie的最大有效期为30天，然后通过Response回送cookie到浏览器。
3.  Request.Cookies使用语法：Request.Cookies(cookie)[(key)|.attribute]。

## 二.Cookie代码示范

```js
/**
 * 设置cookie
 */
function setCookie(name, value, seconds) {
    console.log('进入setCookie逻辑函数')
    seconds = seconds || 0;   //conds有值就直接赋值，没有为0，这个根php不一样。
    var expires = "";
    // cookies随浏览器关闭而失效的方法:
    //     如果不设置Expires的属性那么Cookie的存活时间就是在关闭浏览器的时候。
    if (seconds != 0 ) {      //设置cookie生存时间
        var date = new Date();
        date.setTime(date.getTime()+(seconds*1000));
        expires = "; expires="+date.toGMTString();
    }
    document.cookie = name+"="+escape(value)+expires+"; path=/";   //转码并赋值
}

/**
 * 读取cookie
 */
function getCookie(name) {
    console.log('进入getCookie逻辑函数');
    var nameEQ = name + '='
    var ca = document.cookie.split(';') // 把cookie分割成组
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i] // 取得字符串
        while (c.charAt(0) == ' ') { // 判断一下字符串有没有前导空格
            c = c.substring(1, c.length) // 有的话，从第二位开始取
        }
        if (c.indexOf(nameEQ) == 0) { // 如果含有我们要的name
            return unescape(c.substring(nameEQ.length, c.length)) // 解码并截取我们要值
        }
    }
    return false
}

/**
 * 检查cookie
 * @param c_name
 * @return {boolean}
 */
function checkCookie(c_name) {
    username = getCookie(c_name);
    console.log(username);
    if (username != null && username != "") {
        return true;
    }
    else {
        return false;
    }
}

/**
 * 清除cookie
 * @param name
 */
function clearCookie(name) {
    setCookie(name, "", -1);
}
```

## 三.Cookie生命周期

如果要立马失效时间要设置为-1,设置为0为本次浏览器关闭结束生命周期

  如果不设置Expires的属性那么Cookie的存活时间就是在关闭浏览器的时候。

## 四.session使用

###### 		1.session的概念=>

​			会话（生命周期：通常是浏览器关了，session就没了，不同的浏览器有不同的session，永久不冲突）

###### 		2.session的应用--》

​			用来存储会话级别的变量：令牌的解密秘钥等，当前登录的用户的信息（可以给数据拾释压）

###### 		3.session的使用--》区别于之前我们使用cookie的用法:

   1.    ###### cookie的用法：前后端共享的变量区域

	   				1. 获取cookie:由请求对象来实现
	                                                				2.  操作cookie：包括增删改 由响应对象来实现

				2. ###### session的用法：只能服务端操作，仅仅是存在在服务端
			
					1.  获取由请求对象来获取
					2.  操作由请求对象来操作

	

###### 4.原理解答=>

就是当访问一个页面的时候给浏览器创建一个独一无二的号码，也给同时创建的session赋予同样的号码。这样就可以在打开同一个网站的第二个页面时获取到第一个页面中session保留下来的对应信息（理解：当访问第二个页面时将号码同时传递到第二个页面。找到对应的session。）。这个号码也叫sessionID，session的ID号码，session的独一无二号码。


###### 5.session安装语句

```
 npm install express-session
```

###### 6.配置中间件=>app.js

注意 :设置在var app = express();之后,路由之前

```js
//设置在var app = express();之后
//引入session
const session=require('express-session')
//配置中间件 maxAge单位为ms
app.use(session({
    secret: "keyboard cat",
    resave: false,
    saveUninitialized: true,
    //maxAge:最多可以存活多久
    cookie: ('name', 'value',{maxAge:  5*60*1000,secure: false})
}));
```

###### 7.express-session使用

```js
// 设置session
req.session.username="张三"

//获取session
req.session.username

//重新设置cookie的过期时间为1s
req.session.cookie.maxAge=1000;

//销毁session
req.session.destroy(function(err){

})
```

## 五.图片验证码实现

###### 1.svg安装

```
npm install svg-captcha
```

###### 2.图片验证码代码

①前端页面代码

```html
<fieldset >
    <legend>验证码
    </legend>
    <img src="http://localhost:3000/users/getCaptcha" alt="">
    <input  id="capText">
    <button type="button" onclick="captachaValid()">验证</button>
</fieldset>
```

②运行函数

```js
function captachaValid(){
    future.ajax({
        url:'/users/captachaValid',
        type:'get',
        data:{
            captcha:$('#capText').val()
        },success:function (result) {
            alert('验证成功')
        }
    })
}
```

③路由文件中(routes/users)

```js
var svgCaptcha = require('svg-captcha');
router.get('/getCaptcha', function(req, res, next) {
  var captcha = svgCaptcha.create({
    // 翻转颜色
    inverse: false,
    // 字体大小
    fontSize: 36,
    // 噪声线条数
    noise: 2,
    // 宽度
    width: 80,
    // 高度
    height: 30,
  });
  // 保存到session,忽略大小写
  req.session.captcha = captcha.text.toLowerCase();
  console.log(req.session.captcha); //0xtg 生成的验证码
  //设置什么格式返回前端,默认text格式
  res.setHeader('Content-Type', 'image/svg+xml');
  //将此数据转成字符串写入传到前端,并且.write并不会结束请求可以多次调用
  res.write(String(captcha.data));
  res.end()
})
```

###### 3.验证码使用实操

1. 安装npm install svg-captcha

2. 直接使用captcha的api

3. 直接根据captcha生成的对象做解析

4. 幅度段返回验证码之前需要缓存验证码的内容(共后续验证用)

5.  完成验证码的点击刷新功能

	```html
	 <img src="http://192.168.0.151:3000/users/getCaptcha" onclick="javascript:this.setAttribute('src','http://192.168.0.151:3000/users/getCaptcha?v='+new Date().getTime())">
	```

	```js
	//根据token不同生成不同验证码
	obj.setAttribute('src','http://localhost:3000/users/getCaptcha?v='+new Date().getTime()+"&token="+window.localStorage.token)
	```

## 六.拦截器=>jwt

##### 1.jwt安装

```
npm install jsonwebtoken
```

##### 2.jwt的相关api=>

###### 	a.jwtUtils

```js
// 安全拦截器
const jwt = require("jsonwebtoken");
/**
 * 验证权限
 * @param token
 * @param secretkey 秘钥
 * @param success
 * @param error
 */
function verify (token,secretkey,success,error){
    jwt.verify(token,secretkey,function(err,decode){
        if(err){
            if (error) {
                error(err);
            }
        }else{
            if (success) {
                success(decode);
            }
        }
    })
}

/**
 * 签名
 * @param load 载荷 json对象 存储存在
 * @param secretkey 秘钥
 * @param expiresIn 过期时间 秒
 * @returns {number | PromiseLike<ArrayBuffer>}
 */
function sign (load,secretkey,expiresIn) {
    var token = jwt.sign(load,secretkey,{expiresIn: expiresIn});
    return token;
}

/**异步转同步
 * 这个再app.js路由调用中已经转换过一次,所以不用重复转换
 * @param token
 * @param secretkey
 * @returns {Promise<any>}
 */
 function   verifysync (token,secretkey){
    return   new Promise((resolve,reject)=>{
        jwt.verify(token,secretkey,function(err,decode){
            if (err) {
                console.log(err.message);
                resolve({err:'error',msg:'会话已过期'})
            }else{
                console.log("解密成功")
                resolve(decode)
            }
        })

    })

}

module.exports = {verify,sign,verifysync};


/*//使用解密
let user={id:111,name:'user',password:123456};
/!*
//q清空密码
delete user.password;
let token=sign(user,'123456',10);*!/
//解密
let token=sign(user,'123456',10);
verify(token,"123456",function (user) {
    console.log(user);
},function (err) {
    console.error(err)
    }
)
console.log(token);*/


/*verify(token,'123456',function (user) {
    console.log(user)
},function (err) {
    console.error(err);
})*/



```

###### 	b.拦截器中间件=>

```js
//拦截器中间件,原本
app.use(function(req,resp,next){
    log.debug(req.path);
    if(req.path !='/mine.html' && req.path !='/user/login' && req.path !='/user/register'){
        let token = req.headers.token;
        safeInterceptor.verify(token,global.secretKey,function(user){
            req.headers.sessionData = user;
            next();
        },function(err){
            next();
        })
    }else{
        next();
    }
})


/**
 * 全系统允许跨域处理 这段配置要再new出express实例的时候就要设置了，放在所有的api前面，不然没有效果
 */
app.all("*",function(req,res,next){
    //设置允许跨域的域名，*代表允许任意域名跨域
    res.header("Access-Control-Allow-Origin","*");
    //允许的header类型
    res.header("Access-Control-Allow-Headers","*");
    //跨域允许的请求方式
    res.header("Access-Control-Allow-Methods","*");
    if (req.method.toLowerCase() == 'options')
        res.send(200);  //让options尝试请求快速结束
    else
        next();
});

```

```js
/**
 * 拦截器中间件,登陆功能时修改使用的
 */
/**
 * 拦截器中间件
 */
app.use(async function(req,resp,next){
    let path = req.path;
    console.log(path)
    if (path.startsWith("/users")) {
        if (path.startsWith("/users/login") || path.startsWith("/users/regist") || path.startsWith("/users/getCaptcha")|| path.startsWith("/users/captchaValid")) {
            console.log("放行users")
            next()
            return
        }
console.log("拦截")
        let token= await redisUtils.get("jwt_token")
        console.log(token)
        let result = await jwtUtil.verifysync(token, global.globalKey)
        if (result.err) {
            jwtAtert(resp)
            return
        } else {
            req.headers.session = result
            next();
            return
        }
    }

    if (path.startsWith("/article")) {
        if (path.startsWith("/article/img") || path.startsWith("/article/getDetails")) {
            console.log("放行文章")
            next()
            return
        }
        console.log("拦截")
        let token= await redisUtils.get("jwt_token")
        console.log(token)
        let result = await jwtUtil.verifysync(token, global.globalKey)

        if (result.err) {
            jwtAtert(resp)
            return
        } else {
            req.headers.session = result
            next();
            return
        }
    }

    if (path.startsWith("/")) {
        if (path.startsWith("/setEM")) {
            let token= await redisUtils.get("jwt_token")
            console.log(token)
            let result = await jwtUtil.verifysync(token, global.globalKey)
            if (result.err) {
                jwtAtert(resp)
                return
            } else {
                req.headers.session = result
                next();
                return
            }
        }else{
            console.log("放行根目录")
            next()
            return
        }

    }
    next();

})
function jwtAtert(resp){
    resp.status(500).send('您未登录,将跳转登陆页面')
}
```

##### 3.前后端分离的场景=>

当前用户的身份如果以明文传输,很容易故意被模仿,所以 需要对用户的身份进行加密传输
          加密传输的方式:
                        1)https
                        2)rsa 非对称加密
                        3)aes 对称密钥
                        4)jwt json web token: 目前比较流行的

##### 4.jwt的作用=>

```
用来加密门票用的.
加密:1)被加密 2)用什么加密(加盐)
简单版的:密钥共用,但是被加密的东西不一样
```

##### 5.实际操作=>

1.   在用户登录成功之后使用jwt对用户的基本信息进行加密(注意要提出密码属性)
2.   加密之后,将token返回到前端,存储到localStorage
3.   每次请求,在请求发送之前,将localStorage里头的令牌,当作请求头一起发送
4.   服务端针对需要验权(鉴权)的api进行定制化拦截(前置拦截器)
5.   将拦截下来的req里头的令牌取出来,并做解密错做
     1.      解密成功:将解密出来的对象,即用户的基本信息对象,并将该基本信息对象存到请求头里去(单线程变量-用时间换空间)
     2.   解密失败:请求结束并报错(会话已经过期,请重新登录,前端的表现通常时直接重定向到登录页面)
6.   执行业务代码,如果执行的过程需要用到用户信息,那么不要再从数据库里头去查询数据,直接从请求捞就行了

## 问题:

##### 1.为何在字符串中转义不出变量

​	问题代码位置=>console.log('会话ID:${req.sessionID}');=>test/users.js=>26  

​	问题分析=>用错符号,应用模板符号

​	问题解决=>使用``而不能用''

##### 2.为什么在后台代码test/users中调用不了public中的自定义(CookieUti.js)js包中的函数?

​	问题代码位置=>test/users.js=>35

​	问题分析=>在后台代码test/users中调用静态资源中的文件,导致调用错误

​    原理剖析=>本质上node是后台代码,其中包括bin/www , routes/users.js||index.js ,node_modules  ,app.js , 

​						package.json都是后台文件, 而public其实是单独的静态文件,它与后台文件是通过共享port端口进行数								据传输,而不能相互调用

​						

