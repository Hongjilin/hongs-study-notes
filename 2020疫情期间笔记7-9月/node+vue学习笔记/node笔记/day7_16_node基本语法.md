



------



# -----------------------==(NODE壹)==-------------------------

# **NODE基本语法=>Day7_16**

## 一,node入门基础知识与语法

##### 	1.node官网API文档

​		http://nodejs.cn/api/  

##### 	2.控制台 启动node项目代码

```
  npm run start
```

#####     3.JS能做与不能做的事情:

   		①js能做:操作css  操作dom 执行常规函数方法 前后端通信

​			②js不能做:不能链接数据库操作文件系统

#####     4.node async(异步) api基础知识点:

​		① 同步是请求与相应同步在一起,异步是不在一起

​		② 回调函数的至少有一个形参,而且在第一个位置,而且是error

#####     5.阻塞非阻塞区别 :

​       ①单线程阻塞,多线程非阻塞

## 二.基于命令行的实行生成express

` 1、npm install express-generator -g`
` 2、express 项目名称 // 表示在当前目录下生成一个项目`

## 三.常用基础代码操作

##### 1. 引用包

`const mypackage= require('./mypachage');`

##### 2.文件操作

```js
//①写入
fs.writeFile('./fs.txt','Hong',(e)=>{
    //错误优先原则
    if (e){
        console.error(e);return ;
    }console.log("成功");
    //同步fs.writeFileSync('./fs.txt',new Date())
})
```

```js
//②读取
fs.readFile('./fs.txt',(e,data)=>{
    if (e){
        console.error(e);return ;
    }console.log(data.toString());
})
```

##### 3.同步异常捕获

```js
try {
    let data=fs.readFileSync('./fs.txt')
    console.log("成功");
    console.log(data.toString());
}catch (e) {
    console.error('出错');
}
```

##### 4.路径函数

```js
const  path=require('path');
//参数中...是可选参数(任意)
console.log(path.join('a','../b','c'))
console.log(path.basename('./fs.txt'));
console.log(path.dirname('f./fs.txt'));
console.log(path.extname('./fs.txt'));*/
//获取当前目录路径
console.log(__dirname);
//获取当前目录文件路径,包括当前路径
console.log(__filename);
```

##### 5.美化日志=>(在bin包中的www替换onListening)

```js
var fs = require('fs');
function getPackageJson() {
    // console.log('----------------------1.开始读取package.json')
    var _packageJson = fs.readFileSync('./package.json')
    // console.log('----------------------读取package.json文件完毕')
    return JSON.parse(_packageJson)
}
function onListening() {
    var addr = server.address();
    var bind = typeof addr === 'string'
        ? 'pipe ' + addr
        : 'port ' + addr.port;
    console.log(`
#    _____                     .___
#  _/ ____\\  ____    ____    __| _/  ____
#  \\   __\\  /    \\  /  _ \\  / __ | _/ __ \\
#   |  |   |   |  \\(  <_> )/ /_/ | \\  ___/
#   |__|   |___|  / \\____/ \\____ |  \\___  >
#               \\/              \\/      \\/
=============================================
fnode :: (v0.0.1RELEASE)
        `)
    console.log(`[SYSTERM]${getPackageJson().name}应用启动中...`);
    console.log(`[SYSTERM]应用部署在${bind}`);
}
```

##### 6.node热更新=>(package.json中修改)

```js
"scripts": {
  "start": "nodemon ./bin/www"
},
```

##### 7.app.js可改部分

1.引用路由 可改

```js
*var usersRouter = require('./routes/users');
```

2.路由注册

```js
app.use('/users', usersRouter);
```

## 四.补充注意点

##### 1.为什么要把所有静态资源（html文件，或者css之类）指定放置到与入口文件index.js同级的public文件夹下?

-     要把所有静态资源（html文件，或者css之类）指定放置到与入口文件index.js同级的public文件夹下

    -     index.js的app.use()函数也指定了public文件夹作为存放静态资源的路径。故sendFile()函数自动从public文件夹里寻找html

    ```
    var express = require('express');
    var app = express();
    var path = require('path');
    //加载静态资源
    app.use(express.static(path.join(__dirname, 'public')));
    
    app.get('/', function(req, res) {
        res.sendFile('/index.html');
    });
    app.listen(8080);
    ```

    -    index.js在package.json中被指定为入口文件（相当于C语言的 main.cpp）=>不放在一个包实现方法

    ```
    var express = require('express');
    var app = express();
    var path = require('path');
    
    //app.use(express.static(path.join(__dirname, 'public')));
    
    app.get('/', function(req, res) {
        //res.send('hello!');
        res.sendFile(__dirname + '/index.html');
    });
    ```


​    

##### 2.global为全局变量