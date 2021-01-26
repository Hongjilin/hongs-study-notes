

------



# -----------------------==(NODE伍)==-------------------------

# Promise+await+async概念及简单应用=>Day7_23

##  一.Promise

##### 	1.Promise作用:

>    ###### 用来解决回调地狱问题，但是只是简单的改变格式，并没有彻底解决上面的问题真正要解决上述问题，一定要利用promise再加上await和async关键字实现异步传同步

#####     2.Promise运行=>

```js
//new的时候方法体就立刻运行
new Promise(function (resolve,reject){//业务代码}）
```

#####    3.Promise的参数解释=>

1. resolve:表示方法体里头执行成功之后的回调函数

 	2. reject:表示方法体里头出错后的回调函数
 	3. Function(函数):支持多层嵌套的回调函数作为方法体内容

#####     

##     二.Promise+await+async=>

##### 							1)Promise==>异步

##### 							2)await==>异步转同步

​			1.await 可以理解为是 async wait 的简写。await 必须出现在 async 函数内部，不能单独使用。

​			2.await 后面可以跟任何的JS 表达式。虽然说 await 可以等很多类型的东西，但是它最主要的意图是用来等待 						Promise 对象的状态被 resolved。如果await的是 promise对象会造成异步函数停止执行并且等待 promise 的						解决,如果等的是正常的表达式则立即执行。

##### 							3)async==>同步转异步

1.    方法体内部的某个表达式使用await修饰，那么这个方法体所属方法必须要用async修饰所以使用awit方法会自动升级为异步方法