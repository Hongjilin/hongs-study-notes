## #说明

>截至目前,市场上前端主流仍是axios 不论是react还是vue或是其他,大部分首推都是使用axios
>
>**但这是为什么呢?**
>
>* 换做以前的我就只会说因为axios用的人多啊.但实际上这回答更像是一种 **强辩**
>* 直到我看到一位前辈在 [Alita社区群](https://github.com/alitajs/alita) 中回答为何 **umi4** 要考虑将支持fetch改为支持axios,并给出了相应理由及文章; 我便觉得有必要学习一下并梳理出来
>* 当然本文写于2021年,就以此时的版本进行分析
>
>查阅参考的资料 : [Axios 或 fetch()：你应该使用哪个？](https://blog.logrocket.com/axios-or-fetch-api/)



## 1、ajax

>本身是针对MVC的编程,不符合现在前端MVVM的浪潮
>
>基于原生的XHR开发,XHR本身的架构不够清晰,已经有了fetch的替代方案

## 2、fetch

>fetch号称是AJAX的替代品,是在ES6出现的,使用了ES6中Promise对象
>
>fetch的代码结构笔记ajax简单多了,但`fetch不是ajax的进一步封装,而是原生js,没有使用XMLHttpRequest对象`
>
>###### 优点:
>
>>* 符合关注分离: 没有将输入、输出和用事件来跟踪的状态混杂在一个对象里
>>* 更加底层,提供的API丰富,是更好更方便的写法
>>* 脱离了XHR,是ES规范里新的实现方式
>
>###### 缺点
>
>>* fetch只对网络请求报错,对400、500都当成成功的请求,需要封装去处理
>>* fetch默认不会带cookie,需要添加配置项
>>* fetch不支持 abort(中止) 、不支持超时控制,使用`setTimeout`及`Promise.reject`实现的超时控制并不能阻止请求过程继续在后台运行,造成了量的浪费
>>* fetch不能原生检测请求的进度,而XHR可以

## 3、axios

>Axios是一个基于promise的HTTP库,可以在浏览器和Nodejs中使用
>
>###### 特性
>
>>* 从浏览器中创建`XMLHttpRequests`
>>* 从Node.js中创建http请求
>>* 支持Promise API
>>* 拦截请求和响应
>>* 转换请求数据和响应数据
>>* 取消请求
>>* 自动转换JSON数据
>>* 客户端支持防御XSRF
>
>`XSRF`: 跨站请求攻击，简单地说，是攻击者通过一些技术手段欺骗用户的浏览器去访问一个自己曾经认证过的网站并运行一些操作（如发邮件，发消息，甚至财产操作如转账和购买商品）。由于浏览器曾经认证过，所以被访问的网站会认为是真正的用户操作而去运行。这利用了web中用户身份验证的一个漏洞：**简单的身份验证只能保证请求是发自某个用户的浏览器，却不能保证请求本身是用户自愿发出的**。

### 优缺点

>* 从Nodejs创建http请求
>* 支持Promise API
>* 客户端支持防止CSRF
>* 提供了一些并发请求的接口



## 4、为什么比起 fetch 更倾向于选择 Axios

>实际上具体内容可以看这篇文章  -->  [Axios 或 fetch()：你应该使用哪个？](https://blog.logrocket.com/axios-or-fetch-api/)
>
>这里主要是对前辈的说的知识点进行一次梳理摘录

### `Ⅰ` - 浏览器兼容方面

> * Axios支持IE11及以上
> * Fetch默认不支持IE,加补丁后支持IE10及以上 

### Ⅱ - 请求超时

>* Axios配置 timeout 选项即可
>* Fetch可以做但是有些麻烦,传 `AbortController` 到 `signal` 选项，然后调 `.abort()` 实现 Promise 报错
>
>```js
>const controller = new AbortController();
>const options = {
>  method: 'POST',
>  signal: controller.signal,
>  body: JSON.stringify({
>    firstName: 'hong',
>    lastName: '努力学习的汪'
>  })
>};  
>const promise = fetch('/login', options);
>const timeoutId = setTimeout(() => controller.abort(), 5000);
>
>promise
>  .then(response => {/*  处理响应 */})
>  .catch(error => console.error('timeout exceeded'));
>```
>
>在上面代码中
>
>* 我们使用`AbortController.AbortController()`构造函数创建一个`AbortController`对象，
>* 该构造函数允许我们稍后中止请求。 
>* `signal`是`AbortController`的只读属性，提供了与请求通信或中止请求的方法。
>*  如果服务器在四秒内没有响应，就会调用`controller.abort()`，并终止操作。  

### Ⅲ - 请求取消

>比如用户离开屏幕或者组件时会需要取消请求
>
>* Axios 支持,但是是基于已经撤回的提案 --> [tc39/proposal-cancelable-promises](https://github.com/tc39/proposal-cancelable-promises) 实现的
>* fetch不支持请求取消

### Ⅳ - JSON结果转换

>* Axios自动转换
>* Fetch需要多一步 :`then(res=>res.json())`
>
>```js
>// axios
>axios.get('https://gitee.com/hongjilin')
>  .then(response => {
>    console.log(response.data);
>  }, error => {
>    console.log(error);
>  });
>
>// fetch()
>fetch('https://gitee.com/hongjilin')
>  .then(response => response.json())    // 额外多了一步
>  .then(data => {
>    console.log(data) 
>  })
>  .catch(error => console.error(error));
>```

### Ⅴ - 拦截器

>* Axios支持request和respone的拦截: 请求拦截可以用于日志和权限等; 响应拦截可以用于格式化等
>* Fetch不支持,但可以通过复写Fetch函数勉强实现

### Ⅵ - CSRF保护

>* Axios内置支持
>* Fetch不支持

### Ⅶ - 上传下载的进度条

>都能实现
>
>* Axios可以通过 `FileReader`来读 `res.data` 实现,更为简单
>* Fetch 通过 `ReadableStream` 也能做,但是麻烦些

### Ⅷ - 生态

>* Axios拥有很多拓展:包括测试、日志、缓存等,生态更好
>* Fetch比较少

### Ⅸ - SSR

>* Axios支持Node直接使用
>* Fetch需要借助 [matthew-andrews/isomorphic-fetch](https://github.com/matthew-andrews/isomorphic-fetch) 或 [node-fetch/node-fetch](https://github.com/node-fetch/node-fetch) 这两个插件库使用