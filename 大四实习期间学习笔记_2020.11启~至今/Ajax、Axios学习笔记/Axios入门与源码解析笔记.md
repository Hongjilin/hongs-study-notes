# #说明

>本笔记为`尚硅谷axios入门与源码解析`的学习笔记
>
>该课程主要讲述 axios的API、源码分析、模拟实现重要功能
>
>课程预备知识点: `HTTP` ajax promise  
>
>`ps`:大学时候的课程一定要好好学,不然迟早要还的,留下了不学无术的眼泪:cry:
>
>仅供本人`洪`学习使用
>
>​												记录时间: 2021-3-15晚启

## 预备工具

>1. 作为一个前端开发工程师，在后端还没有ready的时候，不可避免的要使用mock的数据。很多时候，我们并不想使用简单的静态数据，而是希望自己起一个本地的mock-server来完全模拟请求以及请求回来的过程。json-server是一个很好的可以替我们完成这一工作的工具。我们只需要提供一个json文件，或者写几行简单的js脚本就可以模拟出RESTful API的接口。
>2. 安装json-server
>    `npm install -g json-server`
>3. 创建db.json
>    在一个文件夹下新建一个db.json文件
>
>```json
>{
> "posts": [
>   { "id": 1, "title": "json-server", "author": "typicode" }
> ],
> "comments": [
>   { "id": 1, "body": "some comment", "postId": 1 }
> ],
> "profile": { "name": "typicode" }
>}
>```
>
>4. 启动json-server
>    在当前文件夹下输入如下命令：`json-server db.json`
>5. [文档](https://github.com/typicode/json-server)

# 一、Axios的理解与使用

## Ⅰ-axios 是什么?

>1. 前端最流行的 ajax 请求库 
>2. react/vue 官方都推荐使用 axios 发 ajax 请求 
>3. 文档: https://github.com/axios/axios

## Ⅱ-axios 特点

>1. 基于 xhr + promise 的异步 ajax 请求库 
>2. 浏览器端/node 端都可以使用 
>3. 支持请求／响应拦截器 
>4. 支持请求取消 
>5. 请求/响应数据转换 
>6. 批量发送多个请求

## Ⅲ-axios 常用语法

>1. axios(config): `通用/最本质`的发任意类型请求的方式 
>2. axios(url[, config]): 可以只指定 url 发 get 请求 
>3. axios.request(config): 等同于 axios(config) 
>4. axios.get(url[, config]): 发 get 请求 
>5. axios.delete(url[, config]): 发 delete 请求 
>6. axios.post(url[, data, config]): 发 post 请求
>7. axios.put(url[, data, config]): 发 put 请求 
>8. axios.defaults.xxx: 请求的默认全局配置 
>9. axios.interceptors.request.use(): 添加请求拦截器 
>10. axios.interceptors.response.use(): 添加响应拦截器 
>11. axios.create([config]): 创建一个新的 axios(它没有下面的功能) 
>12. axios.Cancel(): 用于创建取消请求的错误对象 
>13. axios.CancelToken(): 用于创建取消请求的 token 对象 
>14. axios.isCancel(): 是否是一个取消请求的错误 
>15. axios.all(promises): 用于批量执行多个异步请求 
>16. axios.spread(): 用来指定接收所有成功数据的回调函数的方法

## Ⅳ-原理图

![image-20210318135249629](C:\Users\Administrator\Desktop\笔记\笔记中图片\Axios系统学习笔记原理图.png)



## Ⅴ-难点语法的理解和使用

### 1、axios.create(config) 

>1. 根据指定配置创建一个新的 axios, 也就就每个新 axios 都有自己的配置 
>
>2. 新 axios 只是没有取消请求和批量发请求的方法, 其它所有语法都是一致的 
>
>3. 为什么要设计这个语法?
>
>   (1) 需求: 项目中有部分接口需要的配置与另一部分接口需要的配置不太一样, 如何处理 
>
>   (2) 解决: 创建 2 个新 axios, 每个都有自己特有的配置, 分别应用到不同要 求的接口请求中
>
>```js
>  //创建实例对象  /getJoke
>    const duanzi = axios.create({
>      baseURL: 'https://api.apiopen.top',
>      timeout: 2000
>    });
>    const onather = axios.create({
>      baseURL: 'https://b.com',
>      timeout: 2000
>    });
>    //这里  duanzi 与 axios 对象的功能几近是一样的
>    // duanzi({
>    //     url: '/getJoke',
>    // }).then(response => {
>    //     console.log(response);
>    // });
>    duanzi.get('/getJoke').then(response => {
>      console.log(response.data)
>    })
>```



### 2、拦截器函数/ajax 请求/请求的回调函数的调用顺序

>1. 说明: 调用 axios()并不是立即发送 ajax 请求, 而是需要经历一个较长的流程 
>2. 流程: 请求拦截器2 => 请求拦截器1 => 发ajax请求 => 响应拦截器1 => 响应拦截器 2 => 请求的回调 
>3. 注意: 此流程是通过 promise 串连起来的, 请求拦截器传递的是 config, 响应 拦截器传递的是 response
>
>```js
>  <script>
>    // Promise
>    // 设置请求拦截器  config 配置对象
>    axios.interceptors.request.use(function (config) {
>      console.log('请求拦截器 成功 - 1号');
>      //修改 config 中的参数
>      config.params = {
>        a: 100
>      };
>
>      return config;
>    }, function (error) {
>      console.log('请求拦截器 失败 - 1号');
>      return Promise.reject(error);
>    });
>
>    axios.interceptors.request.use(function (config) {
>      console.log('请求拦截器 成功 - 2号');
>      //修改 config 中的参数
>      config.timeout = 2000;
>      return config;
>    }, function (error) {
>      console.log('请求拦截器 失败 - 2号');
>      return Promise.reject(error);
>    });
>
>    // 设置响应拦截器
>    axios.interceptors.response.use(function (response) {
>      console.log('响应拦截器 成功 1号');
>      return response.data;
>      // return response;
>    }, function (error) {
>      console.log('响应拦截器 失败 1号')
>      return Promise.reject(error);
>    });
>
>    axios.interceptors.response.use(function (response) {
>      console.log('响应拦截器 成功 2号')
>      return response;
>    }, function (error) {
>      console.log('响应拦截器 失败 2号')
>      return Promise.reject(error);
>    });
>
>    //发送请求
>    axios({
>      method: 'GET',
>      url: 'http://localhost:3000/posts'
>    }).then(response => {
>      console.log('自定义回调处理成功的结果');
>      console.log(response);
>    });
>  </script>
>```



### 3、取消请求

>1. 基本流程 配置 cancelToken 对象 
>   1. 缓存用于取消请求的 cancel 函数 
>   2. 在后面特定时机调用 cancel 函数取消请求 
>   3. 在错误回调中判断如果 error 是 cancel, 做相应处理
>2. 实现功能 点击按钮, 取消某个正在请求中的请求,
>   1. 实现功能 点击按钮, 取消某个正在请求中的请求
>
>```js
>  <script>
>    //获取按钮
>    const btns = document.querySelectorAll('button');
>    //2.声明全局变量
>    let cancel = null;
>    //发送请求
>    btns[0].onclick = function () {
>      //检测上一次的请求是否已经完成
>      if (cancel !== null) {
>        //取消上一次的请求
>        cancel();
>      }
>      axios({
>        method: 'GET',
>        url: 'http://localhost:3000/posts',
>        //1. 添加配置对象的属性
>        cancelToken: new axios.CancelToken(function (c) {
>          //3. 将 c 的值赋值给 cancel
>          cancel = c;
>        })
>      }).then(response => {
>        console.log(response);
>        //将 cancel 的值初始化
>        cancel = null;
>      })
>    }
>
>    //绑定第二个事件取消请求
>    btns[1].onclick = function () {cancel(); }
>  </script>
>```



## Ⅵ-默认配置

>```js
> //默认配置
>        axios.defaults.method = 'GET';//设置默认的请求类型为 GET
>        axios.defaults.baseURL = 'http://localhost:3000';//设置基础 URL
>        axios.defaults.params = {id:100};
>        axios.defaults.timeout = 3000;//
>
>        btns[0].onclick = function(){
>            axios({
>                url: '/posts'
>            }).then(response => {
>                console.log(response);
>            })
>        }
>```



# 二、Axios源码解析





















