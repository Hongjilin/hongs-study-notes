# #说明

>该模块封装于2020疫情学习前端基础知识期间,
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin)
>转载请注明出处。

# 一、jsonP概念 -`2020`

>1)JSONP 是什么?
>
>​	JSONP(JSON with Padding)，是一个非官方的跨域解决方案，纯粹凭借程序员的聪明 才智开发出来，只支持 get 请求。
>
>2)JSONP 怎么工作的？
>
>​	在网页有一些标签天生具有跨域能力，比如：img link iframe script。 JSONP 就是利用 script 标签的跨域能力来发送请求的。

### Ⅰ-jsonP的使用

```js
   // 1. 动态的创建一个 script 标签------------------------------------------------------------
    var script = document.createElement("script");
	//2. 设置 script 的 src， 设置回调函数
    script.src = "http://localhost:3000/testAJAX?callback=abc";
    function abc(data) {
      alert(data.name);
    };
   // 3. 将 script 添加到 body 中
    document.body.appendChild(script);

   // 4. 服务器中路由的处理------------------------------------------------------
    router.get("/testAJAX", function (req, res) {
      console.log("收到请求");
      var callback = req.query.callback;
      var obj = {
        ame: "孙悟空",
        age: 18
      }
      res.send(callback + "(" + JSON.stringify(obj) + ")");
    });
```

### Ⅱ-jQuery发送jsonP请求

```js
//前端代码-----------------------------------------------------------------------------------
$('button').eq(0).click(function () {
  $.getJSON('http://127.0.0.1:8000/jquery-jsonp-server?callback=?', function (data) {
    $('#result').html(`
                名称: ${data.name}<br>
                校区: ${data.city}
            `)
  });
});

//服务端代码-----------------------------------------------------------
app.all('/jquery-jsonp-server', (request, response) => {
  // response.send('console.log("hello jsonp")');
  const data = {
    name: '尚硅谷',
    city: ['北京', '上海', '深圳']
  };
  //将数据转化为字符串
  let str = JSON.stringify(data);
  //接收 callback 参数
  let cb = request.query.callback;

  //返回结果
  response.end(`${cb}(${str})`);
});
```

# 二、我自己开发封装的jsonP插件

>1、代价:需要前后端联动
>2、精髓:自动的由插件生成方法名,并在当前的页面动态的生成函数,然后再生成的函数里头调用用户预留的回调函数
>3、插件：自动化的去模拟基于script去实现跨域请求的过程（对用户来说是黑盒子）
>4、参数拼接：url已经是带参的。和不带参的
>5、id优化 额可以添加一个容器来管理id

## 代码示例

> > 1、前端调用测试封装好的jsonP代码
>
> ```js
> //测试调用函数
>     let test=function () {
>         jsonP.req({
>             url:"http://localhost:3000/jsonpx",
>             data:{
>                 a:"111"
>             },
>             callback:function (result) {
>                 alert("成功"+result)
>             }
>         })
>     }
> ```
>
> > 2、服务端测试代码
>
> ```js
> router.get('/jsonpx', async function (req, resp, next) {
>     let callback=req.query.callback;
>     let data=req.query.a;
>     if (!data){
>         resp.send(`${callback}('洪jl:我是服务端代码')`)
>     }
>     resp.send(`${callback}('洪jl:我是服务端代码`+data+`')`)
> })
> ```
>
> > 3、封装原生代码
>
> ```js
> <script>
>     /**author:@hongjilin
>      * 1.声明一个jsonP插件对象
>      * 作用：隔开作用域
>      */
>     let jsonP = {};
> 
>     /**
>      *2.在插件对象中创建两个名字备用符数组
>      */
>     jsonP.char = {
>         Number: '0123456789',
>         Letter: 'qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM'
>     }
>     /**
>      * 通过随机数抽取备用字符数组库拼凑函数id
>      * @param charLen
>      * @param numLen
>      */
>     jsonP.newFunId = function (charLen, numLen) {
>         let id = '';
>         for (let i = 0; i < charLen; i++) {
>             id += this.char.Letter.charAt(Math.random() * 52)
>         }
>         for (let j = 0; j < numLen; j++) {
>             id += Math.floor(Math.random() * 10);
>         }
>         return id;
>     }
>     /**
>      * 拼接路径
>      * @param url
>      * @param key
>      * @param value
>      */
>     jsonP.jointUrl = function (url, key, value) {
>         if (url && key && value) {
>             let sign = "&"
>             //如果是第一次
>             if (url.indexOf('?') == -1) {
>                 sign = '?'
>             }
> 
>             url += sign + key + "=" + value
>         }
>         return url;
>     }
>     /**
>      封装err属性方便
>      */
>     jsonP.err = function (msg) {
>         console.error(msg)
>     }
> 
>     /**
>      * 发送请求函数
>      * @param options
>      */
>     jsonP.req = function (options) {
>         let jsonId={};
>         //1.生成方法名
>         jsonId.funId = this.newFunId(4,8);
>         let Userurl = options.url;
>         let Userdata = options.data;
>         if (!options) {
>             this.err("输入不能空")
>             return;
>         } else if (!Userurl) {
>             this.err("url不能空")
>             return;
>         } else if (!Userdata) {
>             //如果没有data,初始化
>             Userdata = {};
>         }
>         //将函数名赋值给userdata的回调函数属性中
>         Userdata.callback = jsonId.funId;
>         for (let key in Userdata) {
>             Userurl = this.jointUrl(Userurl, key, Userdata[key])
>         }
>         let script = document.createElement('script');
>         script.setAttribute("id" , jsonId.funId);
>         script.setAttribute("src" , Userurl);
>         //动态生成函数
>         let callback=function (result) {
>             console.log("xxxxxxx")
>             //业务逻辑回调
>             if (options.callback){
>                 try {
>                     options.callback(result)
>                 }catch (e) {
>                     this.err(e.message)
>                 }
>             }
>             //善后
>             let tmp=document.getElementById(jsonId.funId)
>             tmp.parentNode.removeChild(tmp);
>             eval(jsonId.funId+'=null')
>         }
>         eval("window."+jsonId.funId+"=function(result){ callback(result) }")
>         document.head.appendChild(script)
> 
>     }
> </script>
> ```
>
> 