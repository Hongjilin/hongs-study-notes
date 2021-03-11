# #说明

>该笔记为观看`尚硅谷Web前端Promise教程从入门到精通（2021抢先版）`与`尚硅谷Promise教程(promise前端进阶必学)`两个课程视频以及参考其课件整理而成
>
>仅本人洪用作Promise知识点补缺及系统学习记录使用	
>
>此部分知识为学习axios预备知识,预备知识链:ajax --> promise --> axios --> react/vue
>
>​										记录时间:2021-3-10晚启

# 一、Promise的理解与使用

>1、概念:
>
>​	Promise是`异步编程的一种解决方案`，比传统的解决方案——回调函数和事件——更合理和更强大。所谓Promise，简单说就是一个容器，里面保存着某个未来才会结束的事件（通常是一个异步操作）的结果。
>
>通俗讲，`Promise是一个许诺、承诺`,是对未来事情的承诺，承诺不一定能完成，但是无论是否能完成都会有一个结果。
>
>​	Pending  正在做。。。
>
>​	Resolved 完成这个承诺
>
>​	Rejected 这个承诺没有完成，失败了
>
>​	Promise 用来预定一个不一定能完成的任务，要么成功，要么失败
>
>​	在具体的程序中具体的体现，通常用来封装一个异步任务，提供承诺结果
>
>Promise 是异步编程的一种解决方案，`主要用来解决回调地狱的问题，可以有效的减少回调嵌套`。真正解决需要`配合async/await`
>
>2、特点:
>
>​	(1)对象的状态不受外界影响。Promise对象代表一个异步操作，有三种状态：Pending（进行中）、Resolved（已完成，又称Fulfilled）和Rejected（已失败）。只有异步操作的结果，可以决定当前是哪一种状态，任何其他操作都无法改变这个状态。
>
>​	(2)一旦状态改变，就不会再变，任何时候都可以得到这个结果。Promise对象的状态改变，只有两种可能：从Pending变为Resolved和从Pending变为Rejected。只要这两种情况发生，状态就凝固了，不会再变了，会一直保持这个结果。就算改变已经发生了，你再对Promise对象添加回调函数，也会立即得到这个结果。
>
>3、缺点:
>
>​	(1)无法取消Promise，一旦新建它就会立即执行，无法中途取消。和一般的对象不一样，无需调用。
>
>​	(2)如果不设置回调函数，Promise内部抛出的错误，不会反应到外部。
>
>​	(3)当处于Pending状态时，无法得知目前进展到哪一个阶段（刚刚开始还是即将完成）

------

## 1、Promise是什么?

#### Ⅰ-理解

>1. 抽象表达:  
>
>​	1) Promise 是一门新的技术(ES6 规范) 
>
>​	2)Promise 是 JS 中`进行异步编程`的新解决方案 备注：旧方案是单纯使用回调函数
>
>2. 具体表达: 
>
>   1) 从语法上来说: Promise 是一个`构造函数`
>
>   2) 从功能上来说: promise 对象用来封装一个异步操作并可以获取其成功/ 失败的结果值

#### Ⅱ-promise 的状态

##### 	a) promise 的状态

>实例对象中的一个属性 『PromiseState』
>
>* pending  未决定的
>* resolved / fullfilled  成功
>* rejected  失败

##### 	b) promise 的状态改变

>1. pending 变为 resolved 
>
>2. pending 变为 rejected
>
>   说明: `只有这 2 种`, 且一个 promise 对象`只能改变一次` 无论变为成功还是失败, 都会有一个结果数据 成功的结果数据一般称为 value, 失败的结果数据一般称为 reason

#### Ⅲ-promise的基本流程

>![image-20210311093756594](C:\Users\Administrator\Desktop\笔记\笔记中图片\Promise系统学习_promise工作流程.png)

#### Ⅳ-promise的基本使用

###### 1.使用 promise 封装基于定时器的异步

```js
<script >
  function doDelay(time) {
    // 1. 创建 promise 对象(pending 状态), 指定执行器函数
    return new Promise((resolve, reject) => {
      // 2. 在执行器函数中启动异步任务
      console.log('启动异步任务')
      setTimeout(() => {
        console.log('延迟任务开始执行...')
        const time = Date.now() // 假设: 时间为奇数代表成功, 为偶数代表失败
        if (time % 2 === 1) { // 成功了
          // 3. 1. 如果成功了, 调用 resolve()并传入成功的 value
          resolve('成功的数据 ' + time)
        } else { // 失败了
          // 3.2. 如果失败了, 调用 reject()并传入失败的 reason
          reject('失败的数据 ' + time)
        }
      }, time)
    })
  }
const promise = doDelay(2000)
promise.then(// promise 指定成功或失败的回调函数来获取成功的 vlaue 或失败的 reason
    value => {// 成功的回调函数 onResolved, 得到成功的 vlaue
      console.log('成功的 value: ', value)
    },
    reason => { // 失败的回调函数 onRejected, 得到失败的 reason
      console.log('失败的 reason: ', reason)
    },
  ) <
  /script>
```

###### 2.使用 promise 封装 ajax 异步请求

```js
<script >
  /*
  可复用的发 ajax 请求的函数: xhr + promise
  */
  function promiseAjax(url) {
    return new Promise((resolve, reject) => {
      const xhr = new XMLHttpRequest()
      xhr.onreadystatechange = () => {
        if (xhr.readyState !== 4) return
        const {
          status,
          response
        } = xhr
        // 请求成功, 调用 resolve(value)
        if (status >= 200 && status < 300) {
          resolve(JSON.parse(response))
        } else { // 请求失败, 调用 reject(reason)
          reject(new Error('请求失败: status: ' + status))
        }
      }
      xhr.open("GET", url)
      xhr.send()
    })
  }
promiseAjax('https://api.apiopen.top2/getJoke?page=1&count=2&type=vid
    eo ')
    .then(
      data => {
        console.log('显示成功数据', data)
      },
      error => {
        alert(error.message)
      }
    ) </script>
```

###### 3.fs模块使用Promise

```js
const fs = require('fs');

//回调函数 形式----------------------------------------------------
 fs.readFile('./resource/content.txt', (err, data) => {
     // 如果出错 则抛出错误
     if(err)  throw err;
     //输出文件内容
     console.log(data.toString());
 });

//Promise 形式-----------------------------------------------------------
/**
 * 封装一个函数 mineReadFile 读取文件内容
 * 参数:  path  文件路径
 * 返回:  promise 对象
 */
function mineReadFile(path){
    return new Promise((resolve, reject) => {
        //读取文件
        require('fs').readFile(path, (err, data) =>{
            //判断
            if(err) reject(err);
            //成功
            resolve(data);
        });
    });
}

mineReadFile('./resource/content.txt')
.then(value=>{
    //输出文件内容
    console.log(value.toString());
}, reason=>{
    console.log(reason);
});

```

###### 4.异常穿透

> 可以在每个then()的第二个回调函数中进行err处理,也可以利用异常穿透特性,到最后用`catch`去承接统一处理,两者一起用时,前者会生效(因为err已经将其处理,就不会再往下穿透)而走不到后面的catch
>
> 在每个.then()中我可以将数据再次传出给下一个then()

```js
mineReadFile('./11.txt').then(result=>{
  console.log(result.toString())
  return result
},err=>console.log(err))
.then(data=>console.log(data,"2222222"))
.catch(err=>console.log("这是catch的"))
```

###### 5.`util.promisify方法`

>可以将函数直接变成promise的封装方式,不用再去手动封装

```js
//引入 util 模块
const util = require('util');
//引入 fs 模块
const fs = require('fs');
//返回一个新的函数
let mineReadFile = util.promisify(fs.readFile);

mineReadFile('./resource/content.txt').then(value => {
  console.log(value.toString());
});
```

------



## 2、为什么要用Promise?

### Ⅰ-指定回调函数的方式更加灵活

>1. 旧的: 必须在启动异步任务前指定 
>2. promise: 启动异步任务 => 返回promie对象 => 给promise对象绑定回调函 数(甚至可以在异步任务结束后指定/多个)

### Ⅱ-支持链式调用, 可以解决回调地狱问题

##### 	1、什么是回调地狱

>回调函数嵌套调用, 外部回调函数异步执行的结果是嵌套的回调执行的条件
>
><img src="C:\Users\Administrator\Desktop\笔记\笔记中图片\Promise系统学习_回调地狱.jpg" alt="回调地狱"  />

##### 	2、回调地狱的缺点?

>不便于阅读 不便于异常处理

##### 	3、解决方案?

> promise `链式调用`,
>
> 用来解决回调地狱问题，但是`只是简单的改变格式`，并没有彻底解决上面的问题真正要解决上述问题，一定要利用promise再加上await和async关键字实现异步传同步

##### 	4、终极解决方案?

> promise +async/await

------



## 3、Promise中的常用API

#### 	Ⅰ- Promise 构造函数: Promise (excutor) {}

>(1) executor 函数: 执行器 (resolve, reject) => {}
>
>(2) resolve 函数: 内部定义成功时我们调用的函数 value => {} 
>
>(3) reject 函数: 内部定义失败时我们调用的函数 reason => {} 
>
>说明: executor 会在 Promise 内部立即`同步调用`,异步操作在执行器中执行,换话说Promise支持同步也支持异步操作

#### 	Ⅱ-Promise.prototype.then 方法: (onResolved, onRejected) => {}

>(1) onResolved 函数: 成功的回调函数 (value) => {} 
>
>(2) onRejected 函数: 失败的回调函数 (reason) => {} 
>
>说明: 指定用于得到成功 value 的成功回调和用于得到失败 reason 的失败回调 返回一个新的 promise 对象

#### 	 Ⅲ-Promise.prototype.catch 方法: (onRejected) => {}

>(1) onRejected 函数: 失败的回调函数 (reason) => {}
>
>说明: then()的语法糖, 相当于: then(undefined, onRejected)
>
>(2) 异常穿透使用:当运行到最后,没被处理的所有异常错误都会进入这个方法的回调函数中	

#### 	Ⅳ-Promise.resolve 方法: (value) => {}

>(1) value: 成功的数据或 promise 对象 
>
>说明: 返回一个成功/失败的 promise 对象,直接改变promise状态
>
>```js
>	let p3 = Promise.reject(new Promise((resolve, reject) => {  resolve('OK'); }));      
>	console.log(p3);
>```

#### 	Ⅴ-Promise.reject 方法: (reason) => {}

>(1) reason: 失败的原因 
>
>说明: 返回一个失败的 promise 对象,直接改变promise状态,`代码示例同上`

#### Ⅵ-Promise.all 方法: (promises) => {}

>promises: 包含 n 个 promise 的数组 
>
>说明: 返回一个新的 promise, 只有所有的 promise `都成功才成功`, 只要有一 个失败了就直接失败
>
>```js
>  		let p1 = new Promise((resolve, reject) => { resolve('OK');  })
>        let p2 = Promise.reject('Error');
>        let p3 = Promise.resolve('Oh Yeah')
>        const result = Promise.all([p1, p2, p3]);
>  		 console.log(result);
>```

#### Ⅶ-Promise.race 方法: (promises) => {}

>(1) promises: 包含 n 个 promise 的数组 
>
>说明: 返回一个新的 promise, `第一个完成`的 promise 的结果状态就是最终的结果状态,
>
>如p1延时,开启了异步,内部正常是同步进行,所以`p2>p3>p1`,结果是`P2`
>
>```js
>  let p1 = new Promise((resolve, reject) => {
>      setTimeout(() => {
>        resolve('OK');
>      }, 1000);
>    })
>    let p2 = Promise.resolve('Success');
>    let p3 = Promise.resolve('Oh Yeah');
>    //调用
>    const result = Promise.race([p1, p2, p3]);
>    console.log(result);
>```

------



## 4、Promise的几个关键问题

#### Ⅰ-如何改变 promise 的状态?

>(1) resolve(value): 如果当前是 pending 就会变为 resolved 
>
>(2) reject(reason): 如果当前是 pending 就会变为 rejected 
>
>(3) 抛出异常: 如果当前是 pending 就会变为 rejected

#### Ⅱ-一个 promise 指定多个成功/失败回调函数, 都会调用吗?

>当 promise `改变为对应状态时`都会调用,改变状态后,多个回调函数都会调用,并不会自动停止
>
>```js
> let p = new Promise((resolve, reject) => {  resolve('OK');});
>        ///指定回调 - 1
>        p.then(value => {  console.log(value); });
>        //指定回调 - 2
>        p.then(value => { alert(value);});
>```

#### Ⅲ- 改变 promise 状态和指定回调函数谁先谁后?

>(1) 都有可能, 正常情况下是先指定回调再改变状态, 但也可以先改状态再指定回调 
>
>​	先指定回调再改变状态(`异步`):先指定回调--> 再改变状态 -->改变状态后才进入异步队列执行回调函数
>
>​	先改状态再指定回调(`同步`):改变状态 -->指定回调 `并马上执行`回调
>
>(2) 如何先改状态再`指定`回调?   -->注意:指定并不是执行
>
>​	① 在执行器中直接调用 resolve()/reject() -->即,不使用定时器等方法,执行器内直接同步操作 
>
>​	② 延迟更长时间才调用 then() 	-->即,在`.then()`这个方法外再包一层例如延时器这种方法
>
>(3) 什么时候才能得到数据? 
>
>​	① 如果先指定的回调, 那当状态发生改变时, 回调函数就会调用, 得到数据 
>
>​	② 如果先改变的状态, 那当指定回调时, 回调函数就会调用, 得到数据
>
>```js
>    let p = new Promise((resolve, reject) => {
>      //异步写法,这样写会先指定回调,再改变状态
>      setTimeout(() => {resolve('OK'); }, 1000);
>      //这是同步写法,这样写会先改变状态,再指定回调
>      resolve('OK'); 
>    });
>    p.then(value => {console.log(value);}, reason => {})
>```

#### Ⅳ-promise.then()返回的新 promise 的结果状态由什么决定?

>(1) 简单表达: 由 then()指定的回调函数执行的结果决定 
>
>(2) 详细表达: 
>
>​	① 如果抛出异常, 新 promise 变为 rejected, reason 为抛出的异常 
>
>​	② 如果返回的是非 promise 的任意值, 新 promise 变为 resolved, value 为返回的值 
>
>​	③ 如果返回的是另一个新 promise, 此 promise 的结果就会成为新 promise 的结果
>
>```js
>  let p = new Promise((resolve, reject) => {
>      resolve('ok');
>    });
>    //执行 then 方法
>    let result = p.then(value => {
>      console.log(value);
>      // 1. 抛出错误 ,变为 rejected
>      throw '出了问题';
>      // 2. 返回结果是非 Promise 类型的对象,新 promise 变为 resolved
>      return 521;
>      // 3. 返回结果是 Promise 对象,此 promise 的结果就会成为新 promise 的结果
>      return new Promise((resolve, reject) => {
>        // resolve('success');
>        reject('error');
>      });
>    }, reason => {
>      console.warn(reason);
>    });
>```

#### Ⅴ- promise 如何串连多个操作任务?

>(1) promise 的 then()返回一个新的 promise, 可以开成 then()的链式调用 
>
>(2) 通过 then 的链式调用串连多个同步/异步任务,这样就能用`then()`将多个同步或异步操作串联成一个同步队列
>
>```js
> <script>
>   let p = new Promise((resolve, reject) => { setTimeout(() => {resolve('OK'); }, 1000); });
>   p.then(value => {return new Promise((resolve, reject) => { resolve("success"); });})
>    .then(value => {console.log(value);})
>    .then(value => { console.log(value);})
>  </script>
>```

#### Ⅵ-promise 异常传透?

>(1) 当使用 promise 的 then 链式调用时, 可以在最后指定失败的回调,  
>
>(2) 前面任何操作出了异常, 都会传到最后失败的回调中处理
>
>注:可以在每个then()的第二个回调函数中进行err处理,也可以利用异常穿透特性,到最后用`catch`去承接统一处理,两者一起用时,前者会生效(因为err已经将其处理,就不会再往下穿透)而走不到后面的catch

#### Ⅶ- 中断 promise 链?

>在`关键问题2`中,可以得知,当promise状态改变时,他的链式调用都会生效,那如果我们有这个一个实际需求:我们有5个then(),但其中有条件判断,如当我符合或者不符合第三个then条件时,要直接中断链式调用,不再走下面的then,该如何?
>
>(1) 当使用 promise 的 then 链式调用时, 在中间中断, 不再调用后面的回调函数 
>
>(2) 办法: 在回调函数中返回一个 `pendding` 状态的`promise 对象`
>
>```js
> <script>
>    let p = new Promise((resolve, reject) => {setTimeout(() => { resolve('OK');}, 1000);});
>    p.then(value => {return new Promise(() => {});})//有且只有这一个方式
>    .then(value => { console.log(222);})
>    .then(value => { console.log(333);})
>    .catch(reason => {console.warn(reason);});
>  </script>
>```



