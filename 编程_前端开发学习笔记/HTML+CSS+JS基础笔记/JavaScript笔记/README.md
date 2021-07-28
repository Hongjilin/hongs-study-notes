# #此文件为方便gitee网站观阅使用专门创建

> 此笔记文件于某一时间截取复制至此,容易存在更新不及时问题,建议观看同级目录下的笔记文件
>
> 截取了上方了`A_JavaScript进阶学习笔记`的部分知识点至此,方便网站阅读										                     

# #说明

> 此笔记为JavaScript进阶学习笔记,会对之前javaScript基础做一次梳理,并进行对于其进阶知识进行学习与记录
>
> 借阅以及参照学习资料:B站尚硅谷的[`尚硅谷JavaScript高级教程(javascript实战进阶)`](https://www.bilibili.com/video/BV14s411E7qf?share_source=copy_web)、黑马程序员的[[JavaScript基础语法](https://www.bilibili.com/video/BV1ux411d75J?share_source=copy_web)];印记中文的[`现在JavaScript教程`](https://zh.javascript.info/); CSDN的[Free Joe的JS执行过程与执行上下文（栈）](https://blog.csdn.net/wangfeijiu);FunDebug的[我从来不理解 JavaScript 闭包，直到有人这样向我解释它...](https://blog.fundebug.com/2019/02/12/understand-javascript-closure/)
>
> 此笔记为实习工作半年后发觉之前学习JavaScript不够系统全面,或者说当初只是囫囵吞枣,首先并没有系统学习javaScript,其次没有较为深入的学习进阶知识,只是知道`怎么做,而不知道为什么`(当然这也符合本人学习节奏,先`know how`再`know why`)
>
> 本人[全部笔记地址分享](https://gitee.com/hongjilin/hongs-study-notes),亦是持续更新笔记
>
> ​											                     		--始于2021年7月 `更新中`~~

# 一、javaScript基础总结

> 基础部分可以看本人`javaScript初学笔记`

## 1、数据类型相关知识点

### Ⅰ-基本(值)类型

>1. String: 任意字符串
>2. Number: 任意的数字
>3. boolean: true/false
>4. undefined: undefined
>5. null: null  -->使用`typeof`时返回`object`
>6. [symbol](https://developer.mozilla.org/zh-CN/docs/Glossary/Symbol) ([ECMAScript](https://developer.mozilla.org/zh-CN/docs/Glossary/ECMAScript) 2016新增)。 -->Symbol 是 [基本数据类型](https://developer.mozilla.org/zh-CN/docs/Glossary/Primitive) 的一种，[`Symbol`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Symbol) 对象是 Symbol原始值的[封装 (en-US)](https://developer.mozilla.org/en-US/docs/Glossary/Wrapper) 。
>7. [bigint](https://developer.mozilla.org/zh-CN/docs/Glossary/BigInt)，  -->**BigInt** 是一种数字类型的数据，它可以表示任意精度格式的整数。

### Ⅱ-对象(引用)类型

>1. Object: 任意对象
>2. Function: 一种特别的`对象`(可以执行)  --内部包含可运行的代码
>3. Array: 一种特别的`对象`(`key`为数值下标属性, 内部数据是有序的)

### Ⅲ-判断方法

#### ①*` typeof`*

>**`typeof`** 操作符返回一个`字符串`，表示未经计算的操作数的类型。
>
>* 可以判断: undefined/ 数值 / 字符串 / 布尔值 / function
>
>* 不能判断: null与object  object与array
>
>* `注意`: 运行`console.log(typeof undefined)`时,得到的的也是一个`字符串,同时为小写!!`--> `'undefined'`
>
>* 代码示例
>
>  ```js
>    // typeof返回数据类型的字符串表达
>    var a
>    
>    //注意:typeof返回的是字符串
>    console.log(a, typeof a, typeof a==='undefined',a===undefined )  // undefined 'undefined' true true
>    console.log(undefined === 'undefined') //false
>    a = 4
>    console.log(typeof a==='number') //true
>    a = 'hongjilin'
>    console.log(typeof a==='string') //true
>    console.log(typeof a==='String') //false  -->注意,返回的类型为小写
>    a = true
>    console.log(typeof a==='boolean') //true
>    a = null
>    console.log(typeof a, a===null) // 'object'  true
>   let b={}
>    console.log(typeof b,typeof null, '-------') // 'object' 'object'  -->所以Typeof不能判断null与object
>  ```

#### ②*`instanceof`*(判断实例方法)

>- `专门判断对象`的具体类型
>
>- **`instanceof`** **运算符**用于检测构造函数的 `prototype` 属性是否出现在某个实例对象的原型链上。
>
>- 代码示例:
>
>  ```js
>    var b1 = {
>      b2: [1, 'abc', console.log],
>   //可以简化成 b3:()=>()=> 'hongjilin'  -->高阶函数相关知识
>      b3: function () {
>        return  () =>{  return   'hongjilin'}
>      }
>    }
>   /**使用instanceof进行对象判断*/
>    console.log(b1 instanceof Object, b1 instanceof Array) // true  false
>    console.log(b1.b2 instanceof Array, b1.b2 instanceof Object) // true true
>    console.log(b1.b3 instanceof Function, b1.b3 instanceof Object) // true true
>  
>    /**使用typeof进行对象中某属性的判断*/
>   console.log(typeof b1.b2, typeof null) // 'object' 'object'  
>    console.log(typeof b1.b3==='function') // true
>    console.log(typeof b1.b2[2]==='function') //true
>  
>    /**调用对象与数组中某函数示例*/
>    b1.b2[2]('调用console.log打印hongjilin')    //调用console.log打印hongjilin
>    console.log(b1.b3()()) // hongjilin
>  ```

#### ③*`===`*

>具体可以看 MDN的[JavaScript中的相等性判断](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Equality_comparisons_and_sameness)
>
>可以判断: undefined, null
>
>简而言之，在比较两件事情时，`双等号将执行类型转换`;` 三等号将进行相同的比较，而不进行类型转换` (如果类型不同, 只是总会返回 false )

### Ⅳ-相关问题引出

#### ① *undefined与null的区别?*

>* undefined代表定义未赋值
>
>* nulll定义并赋值了, 只是值为null
>
>* 代码示例
>
>  ```js
>    var a
>    console.log(a)  // undefined
>    a = null
>    console.log(a) // null
>  ```

#### ② *什么时候给变量赋值为null呢?*

>* 初始赋值, 表明将要赋值为对象,`可以用做约定俗成的占位符`
>
>* 结束前, 让对象成为垃圾对象(被垃圾回收器回收)
>
>* 代码示例
>
>  ```js
>    //起始,可以用做约定俗成的占位符
>    var b = null  // 初始赋值为null, 表明将要赋值为对象
>    //确定对象就赋值
>    b = ['atguigu', 12]
>    //最后在不使用的时候,将其引用置空,就可以释放b这个对象占用的内存      ---当没有引用指向它的对象称为垃圾对象
>    b = null // 让b指向的对象成为垃圾对象(被垃圾回收器回收)
>  ```

#### ③ *严格区别变量类型与数据类型?*

>* 数据的类型
>  * 基本类型
>  * 对象类型
>* 变量的类型(变量内存值的类型)
>  * 基本类型: 保存就是`基本类型`的数据
>  * 引用类型: 保存的是地址值(对象类型)

### Ⅴ-补充知识点:

#### ①符串对比*`>`、`<`*以及*`charCodeAt()`*方法

>1. Javascript字符串在进行大于(小于)比较时，会根据第一个不同的字符的ascii值码进行比较，当数字(number)与字符串(string)进行比较大小时，会强制的将数字(number)转换成字符串(string)然后再进行比较
>
>   ```js
>   (function(){
>       console.log('13'>'3'); // 输出：false
>       console.log(5>'6');  // 输出： false
>       console.log('d'>'ABDC') // 输出： true
>       console.log(19>'ssf') // 输出 false
>       console.log('A'>'abcdef') // 输出 false
>   })()
>   ```
>
>2. 手动转换为ascii后相减,用正负数表示大小
>
>   ```tsx
>   sorter={(a:string,b:string)=> a.charCodeAt()-b.charCodeAt()}
>   ```



## 2、数据,变量, 内存的理解

### Ⅰ-什么是数据?

>1. 存储在内存中代表特定信息的'东西', 本质上是0101...
>2. 数据的特点: `可传递`, `可运算`    -->let a=0;b=a 🔜体现可传递
>3. 一切皆数据
>4. 内存中所有操作的目标: 数据
>  * 算术运算
>  * 逻辑运算
>  * 赋值
>  * 运行函数

### Ⅱ-什么是内存?

>1. 内存条通电后产生的可储存数据的空间(临时的)
>
>   ![image-20210630191828124](JavaScript笔记中的图片/image-20210630191828124.png) 
>
>2. 内存产生和死亡: 内存条(电路版)==>通电==>产生内存空间==>存储数据==>处理数据==>断电==>内存空间和数据都消失
>
>3. 一块小内存的2个数据
>   * 内部存储的数据
>   * 地址值
>
>4. 内存分类
>  * 栈: 全局变量/局部变量
>  * 堆: 对象
>  * <img src="JavaScript笔记中的图片/image-20210630192130518.png" alt="image-20210630192130518" style="zoom:50%;" />  

### Ⅲ-什么是变量?

>* 可变化的量, 由变量名和变量值组成
>* 每个变量都对应的一块小内存, 变量名用来查找对应的内存, 变量值就是内存中保存的数据
>
>ps:变量`obj.xx`-->`.`相当于拿着地址找到后面对应的内存,所以只有当我变量中存的是地址,才可以用`.`

### Ⅳ-内存,数据, 变量三者之间的关系

>* 内存用来存储数据的空间
>* 变量是内存的标识

### Ⅴ-相关问题引出

#### ① *关于赋值和内存的问题*

>let a = xxx, a内存中到底保存的是什么?
>
>* xxx是基本数据, 保存的就是这个数据
>* xxx是对象, 保存的是对象的地址值
>* xxx是一个变量, 保存的xxx的内存内容(可能是基本数据, 也可能是地址值)

#### ② *关于引用变量赋值问题*

>* 2个引用变量指向同一个对象, 通过一个变量修改对象内部数据, 另一个变量看到的是修改之后的数据
>
>* 2个引用变量指向同一个对象, 让其中一个引用变量指向另一个对象, 另一引用变量依然指向前一个对象
>
>* 代码示例:
>
>  ```js
>    let a = {age: 12}
>  //此时是将a指向的地址值赋值给B,所以B此时也指向{age:12}这个内存
>    let b = a
>  //此时重新创建了一个内存并让a指向它,所以此处a指向的是{name:'hong'},而b指向仍是刚开始的指向{age:12}
>    a = {name: 'hong'}
>  //此时a与b指向的内存已经不一样了,所以修改互不影响
>    b.age = 14
>    console.log(b.age, a.name, a.age) // 14 hong undefined
>    //此时其实已经重新创建了一个内存{age:15},并且将其地址赋值覆盖给a
>  //实际上传进来的obj也是拿着其key对应的地址值找内存,此时
>    const fn2=(obj) => obj = {age: 15}
>    fn2(a)
>    console.log(a.age) //15
>  ```

#### ③ *在js调用函数时传递变量参数时, 是值传递还是引用传递*

>* 理解1: 都是值(基本/地址值)传递
>
>  * 所以实际上传进function中的参数也是拿着其存着的地址值找内存
>
>    ```js
>    //传进来的obj存储的是a中存的地址值,所以obj==a(因为他们地址值一致,指向一致)
>      let a = {name: 'hong'}
>      const fn2=(obj) => obj = {age: 15}
>      fn2(a)
>      console.log(a.age) //15
>    ```
>
>* 理解2: 可能是值传递, 也可能是引用传递(地址值)

#### ④ *JS引擎如何管理内存?*

>1. 内存生命周期
>  * 分配小内存空间, 得到它的使用权
>  * 存储数据, 可以反复进行操作
>  * 释放小内存空间
>2. 释放内存
>  * 局部变量: 函数执行完自动释放
>  * 对象: 成为垃圾对象==>垃圾回收器回收
>
>```js
>  var a = 3
>  var obj = {name:"hong"}
>  obj = undefined ||null  //此时,obj没有被释放,但是之前声明的`{name:"hong"}`由于没有人指向它,会在后面你某个时刻被垃圾回收器回收
> 
>function fn () { var b = {}}
>  fn() // b是自动释放, b所指向的对象是在后面的某个时刻由垃圾回收器回收
>```

## 3、对象

### Ⅰ-对象的概念

#### ① *什么是对象?*

>* 多个数据的封装体
>* 用来保存多个数据的容器
>* 一个对象代表现实中的一个事物

#### ② *为什么要用对象?*

>* 统一管理多个数据

#### ③ *对象的组成*

>* 属性: 属性名(字符串)和属性值(任意)组成
>* 方法: 一种特别的属性(属性值是函数)

### Ⅱ-如何访问对象内部数据?

>* `.属性名`: 编码简单, 有时不能用
>* `['属性名']`: 编码麻烦, 能通用

### Ⅲ-什么时候必须使用`['属性名']`的方式?

>1. 属性名包含特殊字符: `-` `空格`
>2. 属性名不确定
>
>```js
>  var p = {}
>  //1. 给p对象添加一个属性: content type: text/json
>  // p.content-type = 'text/json' //不能用
>  p['content-type'] = 'text/json'
>  console.log(p['content-type'])
>
>  //2. 属性名不确定
>  var propName = 'myAge'
>  var value = 18
>  // p.propName = value //不能用
>  p[propName] = value
>  console.log(p[propName])
>```

## 4、函数

### Ⅰ-函数的概念

#### ① *什么是函数*

>  * 实现特定功能的n条语句的封装体
>  * 只有函数是可以执行的, 其它类型的数据不能执行

#### ② *为什么要用函数?*

>* 提高代码复用
>* 便于阅读交流

#### ③ *如何定义函数?*

>* 函数声明
>
>* 表达式
>
>  ```js
>    function fn1 () { console.log('fn1()' )//函数声明
>                     
>    const fn2 = ()=> console.log('fn2()')  //表达式
>  ```

### Ⅱ-如何调用(执行)函数

>1. test(): 直接调用
>
>2. obj.test(): 通过对象调用
>
>3. new test(): new调用
>
>4. `test.call/apply(obj)`: 临时让test成为obj的方法进行调用
>
>   * ![image-20210705185535337](A_JavaScript进阶学习笔记中的图片/image-20210705185535337.png)  
>
>5. 代码示例
>
>   ```js
>     var obj = {}
>     //此处不能使用箭头函数,因为箭头函数会改变this指向
>     function test2 () {
>       this.xxx = 'hongjilin'
>     }
>     // obj.test2()  不能直接, 根本就没有
>     test2.call(obj)  // 可以让一个函数成为指定任意对象的方法进行调用
>     console.log(obj.xxx)
>   
>   ```

### Ⅲ-回调函数

#### ① *什么函数才是回调函数?*

>- 你定义的
>- 你没有调
>- 但最终它执行了(在某个时刻或某个条件下)

#### ② *常见的回调函数?*

>* dom事件回调函数 ==>发生事件的dom元素
>* 定时器回调函数 ===>window
>* ajax请求回调函数(后面讲)
>* 生命周期回调函数(后面讲)
>
>```js
>   // dom事件回调函数
>  document.getElementById('btn').onclick = function () {alert(this.innerHTML)}
>  // 定时器回调函数
>  setTimeout(function () {   alert('到点了'+this)}, 2000)
>```

### Ⅳ-IIFE (自调用函数)

>1. 全称: `Immediately-Invoked Function Expression` 自调用函数
>
>2. 作用:
>
>     * 隐藏实现
>     * 不会污染外部(一般指全局)命名空间
>     * 用它来编码js模块
>
>3. 代码示例
>
>   ```js
>     (function () { //匿名函数自调用
>       var a = 3
>       console.log(a + 3)
>     })()
>     console.log(a) // a is not defined
>   
>     //此处前方为何要一个`;`-->因为自调用函数外部有一个()包裹,可能与前方以()结尾的代码被一起认为是函数调用
>     //不加分号可能会被认为这样 console.log(a)(IIFE)
>     ;(function () {//不会污染外部(全局)命名空间-->举例
>       let a = 1;
>       function test () { console.log(++a) } //声明一个局部函数test
>       window.$ = function () {  return {test: test} }// 向外暴露一个全局函数
>     })()
>    test ()  //test is not defined
>     $().test() // 1. $是一个函数 2. $执行后返回的是一个对象
>   ```

### Ⅴ-函数中的this

#### ① *this是什么?*

>* 任何函数本质上都是通过某个对象来调用的,如果没有直接指定就是window
>* 所有函数内部都有一个变量this
>* 它的值是`调用函数的当前对象`

#### ② *如何确定this的值?*

>* test(): window
>* p.test(): p
>* new test(): 新创建的对象
>* p.call(obj): obj

#### ③ *代码举例详解*

>```js
>  function Person(color) {
>    console.log(this)
>    this.color = color;
>    this.getColor = function () {
>      console.log(this)
>      return this.color;
>    };
>    this.setColor = function (color) {
>      console.log(this)
>      this.color = color;
>    };
>  }
>
>  Person("red"); //this是谁? window
>
>  const p = new Person("yello"); //this是谁? p
>
>  p.getColor(); //this是谁? p
>
>  const obj = {};
>  //调用call会改变this指向-->让我的p函数成为`obj`的临时方法进行调用
>  p.setColor.call(obj, "black"); //this是谁? obj
>
>  const test = p.setColor;
>  test(); //this是谁? window  -->因为直接调用了
>
>  function fun1() {
>    function fun2() {  console.log(this); }
>    fun2(); //this是谁? window
>  }
> fun1();//调用fun1
>```

## 5、关于语句分号

>1. js一条语句的后面可以不加分号
>2. 是否加分号是编码风格问题, 没有应该不应该，只有你自己喜欢不喜欢
>3. 在下面2种情况下不加分号会有问题
>  * `小括号开头的前一条语句`
>  * `中方括号开头的前一条语句`
>4. 解决办法: 在行首加分号
>5. 强有力的例子: vue.js库
>6. 知乎热议: https://www.zhihu.com/question/20298345

------



# 二、函数高级

## 1、原型与原型链

### Ⅰ-原型 [prototype]

>1. 函数的`prototype`属性
>  * 每个函数都有一个prototype属性, 它默认指向一个Object空对象(即称为: 原型对象)
>  * 原型对象中有一个属性constructor, 它指向函数对象
>  * ![image-20210714201049312](A_JavaScript进阶学习笔记中的图片/image-20210714201049312.png)
>2. 给原型对象添加属性(`一般都是方法`)
>  * 作用: 函数的所有实例对象自动拥有原型中的属性(方法)
>
>3. 代码示例
>
>   ```js
>   
>     // 每个函数都有一个prototype属性, 它默认指向一个Object空对象(即称为: 原型对象)
>     console.log(Date.prototype, typeof Date.prototype)
>     function Fun () { }
>     console.log(Fun.prototype)  // 默认指向一个Object空对象(没有我们的属性)
>   
>     // 原型对象中有一个属性constructor, 它指向函数对象
>     console.log(Date.prototype.constructor===Date)
>     console.log(Fun.prototype.constructor===Fun)
>   
>     //给原型对象添加属性(一般是方法) ===>实例对象可以访问
>     Fun.prototype.test = function () { console.log('test()') }
>     var fun = new Fun()
>     fun.test()
>   ```

### Ⅱ-显式原型与隐式原型

>1. 每个函数function都有一个`prototype`，即`显式`原型(属性)
>
>2. 每个实例对象都有一个[`__ proto __`]，可称为`隐式`原型(属性)
>
>3. 对象的隐式原型的值为其对应构造函数的显式原型的值
>
>4. 内存结构
>
>   ![image-20210714203043314](A_JavaScript进阶学习笔记中的图片/image-20210714203043314.png) 
>
>5. 总结:
>  * 函数的[`prototype`]属性: 在定义函数时自动添加的, 默认值是一个空Object对象
>  * 对象的[`__ proto __`]属性: 创建对象时自动添加的, `默认值为构造函数的prototype属性值`
>  * 程序员能直接操作显式原型, 但不能直接操作隐式原型(ES6之前)
>
>6. 代码示例:
>
>   ```js
>     //定义构造函数
>     function Fn() {
>      // 内部默认执行语句: this.prototype = {}
>       }
>     // 1. 每个函数function都有一个prototype，即显式原型属性, 默认指向一个空的Object对象
>     console.log(Fn.prototype)
>     // 2. 每个实例对象都有一个__proto__，可称为隐式原型
>     //创建实例对象
>     var fn = new Fn()  // 内部默认执行语句: this.__proto__ = Fn.prototype
>     console.log(fn.__proto__)
>     // 3. 对象的隐式原型的值为其对应构造函数的显式原型的值
>     console.log(Fn.prototype===fn.__proto__) // true
>     //给原型添加方法
>     Fn.prototype.test = function () {
>       console.log('test()')
>     }
>     //通过实例调用原型的方法
>     fn.test()
>   ```



### Ⅲ-原型链

#### ① *原型链*

>1. 原型链
>  * 访问一个对象的属性时，
>    * 先在自身属性中查找，找到返回
>    * 如果没有, 再沿着[`__ proto __`]这条链向上查找, 找到返回
>    * 如果最终没找到, 返回undefined
>    * ![image-20210714210912653](A_JavaScript进阶学习笔记中的图片/image-20210714210912653.png)
>  * 别名: 隐式原型链
>  * 作用: 查找对象的属性(方法) 

#### ②*构造函数/原型/实例对象的关系(图解)*

>1. ```js
>     var o1 = new Object();
>     var o2 = {};
> 
>
>   ![image-20210714212928432](A_JavaScript进阶学习笔记中的图片/image-20210714212928432.png) 
>
>2. ```js
>     function Foo(){  }
> 
>  ![image-20210714212945164](A_JavaScript进阶学习笔记中的图片/image-20210714212945164.png) 
> 
>   ps:所有函数的[`__ proto __`]都是一样的

#### ③ *属性问题*

>- 读取对象的属性值时: 会自动到原型链中查找
>
>- 设置对象的属性值时: 不会查找原型链, 如果当前对象中没有此属性, 直接添加此属性并设置其值
>
>- 方法一般定义在原型中, 属性一般通过构造函数定义在对象本身上
>
>- 代码示例
>
>  ```js
>    function Fn() { }
>    Fn.prototype.a = 'xxx'
>    var fn1 = new Fn()
>    console.log(fn1.a, fn1) //xxx Fn{}
>  
>    var fn2 = new Fn()
>    fn2.a = 'yyy'
>    console.log(fn1.a, fn2.a, fn2) //xxx yyy  Fn{a: "yyy"}
>  
>    function Person(name, age) {
>      this.name = name
>      this.age = age
>    }
>    Person.prototype.setName = function (name) {
>      this.name = name
>    }
>    var p1 = new Person('Tom', 12)
>    p1.setName('Bob')
>    console.log(p1)  //Person {name: "Bob", age: 12}
>  
>    var p2 = new Person('Jack', 12)
>    p2.setName('Cat')
>    console.log(p2) //Person {name: "Cat", age: 12}
>    console.log(p1.__proto__===p2.__proto__) // true   -->所以方法一般定义在原型中
>  ```

### Ⅳ-instanceof

>1. instanceof是如何判断的?
>  * 表达式: A instanceof B
>  * 如果B函数的显式原型对象在A对象的原型链上, 返回true, 否则返回false
>2. Function是通过new自己产生的实例
>
>```js
>  /*
>  案例1
>   */
>  function Foo() {  }
>  var f1 = new Foo()
>  console.log(f1 instanceof Foo) // true
>  console.log(f1 instanceof Object) // true
>
>  /*
>  案例2
>   */
>  console.log(Object instanceof Function) // true
>  console.log(Object instanceof Object) // true
>  console.log(Function instanceof Function) // true
>  console.log(Function instanceof Object) // true
>
>  function Foo() {}
>  console.log(Object instanceof  Foo) // false
>```
>

### Ⅴ-相关面试题

>测试题1:
>
>```js
>  /*
>  测试题1
>   */
>  function A () {}
>  A.prototype.n = 1
>  let b = new A()
>  A.prototype = { n: 2, m: 3}
>  let c = new A()
>  console.log(b.n, b.m, c.n, c.m) // 1 undefined 2 3
>```
>
>测试题2:原理看[②*构造函数/原型/实例对象的关系(图解)*](#②*构造函数/原型/实例对象的关系(图解)*)
>
>```js
>  /*
>   测试题2
>   */
>  function F (){}
>  Object.prototype.a = function(){
>    console.log('a()')
>  }
>  Function.prototype.b = function(){
>    console.log('b()')
>  }
>  
>  let f = new F()
>  f.a() //a()
>  f.b() //f.b is not a function -->找不到
>  F.a() //a()
>  F.b() //b()
>
>  console.log(f)
>  console.log(Object.prototype)
>  console.log(Function.prototype)
>```
>
>结果图例
>
>![image-20210723173855550](A_JavaScript进阶学习笔记中的图片/image-20210723173855550.png)



## 2、执行上下文与执行上下文栈

> > 当代码在 JavaScript 中运行时，执行代码的环境非常重要，并将概括为以下几点：
> >
> > **全局代码**——第一次执行代码的默认环境。
> >
> > **函数代码**——当执行流进入函数体时。
> >
> > (…) —— 我们当作 执行上下文 是当前代码执行的一个环境与范围。
>
> 换句话说，当我们启动程序时，我们从全局执行上下文中开始。一些变量是在全局执行上下文中声明的。我们称之为全局变量。当程序调用一个函数时，会发生什么?
>
> 以下几个步骤：
>
> - JavaScript 创建一个新的执行上下文，我们叫作本地执行上下文。
> - 这个本地执行上下文将有它自己的一组变量，这些变量将是这个执行上下文的本地变量。
> - 新的执行上下文被推到到执行堆栈中。可以将执行堆栈看作是一种保存程序在其执行中的位置的容器。
>
> 函数什么时候结束?当它遇到一个 return 语句或一个结束括号}。
>
> 当一个函数结束时，会发生以下情况:
>
> - 这个本地执行上下文从执行堆栈中弹出。
> - 函数将返回值返回调用上下文。调用上下文是调用这个本地的执行上下文，它可以是全局执行上下文，也可以是另外一个本地的执行上下文。这取决于调用执行上下文来处理此时的返回值，返回的值可以是一个对象、一个数组、一个函数、一个布尔值等等，如果函数没有 return 语句，则返回 undefined。
> - 这个本地执行上下文被销毁，销毁是很重要，这个本地执行上下文中声明的所有变量都将被删除，不在有变量，这个就是为什么 称为本地执行上下文中自有的变量。
>
> 此图出于CSDN的[Free Joe](https://blog.csdn.net/wangfeijiu)
>
> <img src="A_JavaScript进阶学习笔记中的图片/image-20210723181727823.png" alt="image-20210723181727823" style="zoom:80%;" /> 

### Ⅰ-变量提升与函数提升

>1. 变量声明提升
>  * 通过var定义(声明)的变量, 在定义语句之前就可以访问到
>  * 值: undefined
>2. 函数声明提升
>  * 通过function声明的函数, 在之前就可以直接调用
>  * 值: 函数定义(对象)
>3. 引出一个问题: 变量提升和函数提升是如何产生的?
>
>```jsx
> /*
>  面试题 : 输出 undefined
>   */
>  var a = 3
>  function fn () {
>    console.log(a)
>    var a = 4 //变量提升
>  }
>  fn()  //undefined
>'--------------------------------------------'
>  console.log(b) //undefined  变量提升
>  fn2() //可调用  函数提升
>  // fn3() //不能  变量提升
>  var b = 3
>  function fn2() {  console.log('fn2()') }
>  var fn3 = function () { console.log('fn3()') }
>```

### Ⅱ-执行上下文

>1. 代码分类(位置)
>  * 全局代码
>  * 函数(局部)代码
>2. 全局执行上下文
>  * 在执行全局代码前将window确定为全局执行上下文
>  * 对全局数据进行预处理
>    * var定义的全局变量==>undefined, 添加为window的属性
>    * function声明的全局函数==>赋值(fun), 添加为window的方法
>    * this==>赋值(window)
>  * 开始执行全局代码
>3. 函数执行上下文
>  * 在调用函数, 准备执行函数体之前, 创建对应的函数执行上下文对象(虚拟的, 存在于栈中)
>  * 对局部数据进行预处理
>    * 形参变量==>赋值(实参)==>添加为执行上下文的属性
>    * `arguments`==>赋值(实参列表), 添加为执行上下文的属性 -->[不懂的同学看这里](https://developer.mozilla.org/zh-CN/docs/orphaned/Web/JavaScript/Reference/Functions/arguments)
>    * var定义的局部变量==>undefined, 添加为执行上下文的属性
>    * function声明的函数 ==>赋值(fun), 添加为执行上下文的方法
>    * this==>赋值(调用函数的对象)
>  * 开始执行函数体代码

### Ⅲ-执行上下文栈

>1. 在全局代码执行前, JS引擎就会创建一个栈来存储管理所有的执行上下文对象
>2. 在全局执行上下文(window)确定后, 将其添加到栈中(压栈)-->`所以栈底百分百是[window]`
>3. 在函数执行上下文创建后, 将其添加到栈中(压栈)
>4. 在当前函数执行完后,将栈顶的对象移除(出栈)
>5. 当所有的代码执行完后, 栈中只剩下window
>6. `上下文栈数==函数调用数+1`
>
>```js
>//1. 进入全局执行上下文
>var a = 10
> var bar = function (x) {
>    var b = 5
>    foo(x + b)   //3. 进入foo执行上下文           
>  }
>  var foo = function (y) {
>    var c = 5
>    console.log(a + c + y)
>  }
>  bar(10) //2. 进入bar函数执行上下文
>```
>
>![image-20210723183046182](A_JavaScript进阶学习笔记中的图片/image-20210723183046182.png)![image-20210723183056336](A_JavaScript进阶学习笔记中的图片/image-20210723183056336.png)
>
>举个栗子:  
>
>```js
>//栗子
><!--
>1. 依次输出什么?
>  gb: undefined
>  fb: 1
>  fb: 2
>  fb: 3
>  fe: 3
>  fe: 2
>  fe: 1
>  ge: 1
>2. 整个过程中产生了几个执行上下文?  5
>-->
><script type="text/javascript">
>  console.log('gb: '+ i)
>  var i = 1
>  foo(1)
>  function foo(i) {
>    if (i == 4) {
>      return
>    }
>    console.log('fb:' + i)
>    foo(i + 1) //递归调用: 在函数内部调用自己
>    console.log('fe:' + i) //出栈 所以会 3 2 1这样的结果
>  }
>  console.log('ge: ' + i)
></script>
>```
>
>

### Ⅳ-相关面试题

>`函数提升优先级高于变量提升,且不会被变量声明覆盖,但是会被变量赋值覆盖`
>
>```js
>/*
> 测试题1:  先执行变量提升, 再执行函数提升
> 
> */
>function a() {}
>var a
>console.log(typeof a) // 'function'
>
>
>/*
> 测试题2:
> */
>if (!(b in window)) {
>  var b = 1
>}
>console.log(b) // undefined
>
>/*
> 测试题3:
> */
>var c = 1
>function c(c) {
>  console.log(c)
>  var c = 3 //与此行无关
>}
>c(2) // 报错  c is not a function
>```

## 3、作用域与作用域链

### Ⅰ-作用域

>1. 理解
>  * 就是一块"地盘", 一个代码段所在的区域
>  * 它是静态的(相对于上下文对象), 在编写代码时就确定了
>2. 分类
>  * 全局作用域
>  * 函数作用域
>  * 没有块作用域(ES6有了)   -->(java语言也有)
>3. 作用
>  * 隔离变量，不同作用域下同名变量不会有冲突
>
>```js
>/*  //没块作用域
>  if(true) { var c = 3 }
>  console.log(c)
>  */
>  var a = 10,
>    b = 20
>  function fn(x) {
>    var a = 100, c = 300;
>    console.log('fn()', a, b, c, x) //100 20 300 10
>    function bar(x) {
>      var a = 1000, d = 400
>      console.log('bar()', a, b, c, d, x)
>    }
>    bar(100)//1000 20 300 400 100
>    bar(200)//1000 20 300 400 200
>  }
>  fn(10)
>```

### Ⅱ-作用域与执行上下文的区别与联系

>1. 区别1:
> * 全局作用域之外，每个函数都会创建自己的作用域，`作用域在函数定义时就已经确定了。而不是在函数调用时`
> * 全局执行上下文环境是在全局作用域确定之后, js代码马上执行之前创建
> * 函数执行上下文是在调用函数时, 函数体代码执行之前创建
>2. 区别2:
> * 作用域是静态的, 只要函数定义好了就一直存在, 且不会再变化
> * 执行上下文是动态的, 调用函数时创建, 函数调用结束时就会自动释放
>3. 联系:
> * 执行上下文(对象)是从属于所在的作用域
> * 全局上下文环境==>全局作用域
> * 函数上下文环境==>对应的函数使用域
>
>![image-20210727141319410](A_JavaScript进阶学习笔记中的图片/image-20210727141319410.png)

### Ⅲ-作用域链

>1. 理解
>  * 多个上下级关系的作用域形成的链, 它的方向是从下向上的(从内到外)
>  * 查找变量时就是沿着作用域链来查找的
>2. 查找一个变量的查找规则
>  * 在当前作用域下的执行上下文中查找对应的属性, 如果有直接返回, 否则进入2
>  * 在上一级作用域的执行上下文中查找对应的属性, 如果有直接返回, 否则进入3
>  * 再次执行2的相同操作, 直到全局作用域, 如果还找不到就抛出找不到的异常
>
>```js
> var a = 1
>  function fn1() {
>    var b = 2
>    function fn2() {
>      var c = 3
>      console.log(c)
>      console.log(b)
>      console.log(a)
>      console.log(d)
>    }
>    fn2()
>  }
>  fn1()
>```

### Ⅳ-相关面试题

#### ① `作用域在函数定义时就已经确定了。而不是在函数调用时`

>作用域1:`作用域在函数定义时就已经确定了。而不是在函数调用时`
>
>```js
>  var x = 10;
>  function fn() { console.log(x); }
>  function show(f) {
>    var x = 20;
>    f();
>  }
>  show(fn); //输出10
>```
>
>![image-20210726192714660](A_JavaScript进阶学习笔记中的图片/image-20210726192714660.png)

#### ② 对象变量不能产生局部作用域

>```js
>var fn = function () {
>  console.log(fn)
>}
>fn()
>
>var obj = { //对象变量不能产生局部作用域,所以会找到全局去,导致报错
>  fn2: function () {
>   console.log(fn2)
>   //console.log(this.fn2)
>  }
>}
>obj.fn2()
>```

## 4、闭包预备知识点梳理

> 在进入闭包之前,你要确保上面知识点你能掌握.你不确定 ? 噢好吧,那你就跟着我看下这部分梳理(如果懂得直接跳过即可)

#### ① 举个栗子分析执行上下文

>在讨论闭包之前，让我们看下下方的代码(建议先只看代码自己头脑风暴再看笔记中的描述),也算是对上面知识点的梳理回顾：
>
>```js
>1: let a = 3
>2: function addTwo(x) {
>3:  let ret = x + 2
>4:   return ret
>5:  }
>6: let b = addTwo(a)
>7: console.log(b)
>```
>
>为了理解 JavaScript 引擎是如何工作的，让我们详细分析一下：
>
>1. 在第 1 行，我们在全局执行上下文中声明了一个新变量 a，并将赋值为 3。
>2. 接下来就变得棘手了，第 2 行到第 5 行实际上是在一起的。这里发生了什么?
>   - 我们在全局执行上下文中声明了一个名为`addTwo`的新变量,我们给它分配了什么?  -->`一个函数定义`。
>   - 两个括号{}之间的任何内容都被分配给`addTwo`，`函数内部的代码没有被求值，没有被执行，只是存储在一个变量中以备将来使用`。
>3. 现在我们在第 6 行。
>   - 它看起来很简单，但是这里有很多东西需要拆开分析。首先，我们在全局执行上下文中声明一个新变量，并将其标记为[`b`]，`变量一经声明，其值即为 undefined`。
>   - 接下来，仍然在第 6 行，我们看到一个赋值操作符。我们准备给变量`b`赋一个新值，接下来我们看到一个函数被调用。`当您看到一个变量后面跟着一个圆括号(…)时，这就是调用函数的信号`，接着，每个函数都返回一些东西(值、对象或 undefined)，无论从函数返回什么，都将赋值给变量`b`。
>4. 但是首先我们需要调用标记为`addTwo`的函数。JavaScript 将在其全局执行上下文内存中查找名为`addTwo`的变量。噢，它找到了一个，它是在[`步骤 2(或第 2 - 5 行)中定义`]的。变量[`addTwo`]包含一个函数定义。
>   - 注意:`变量[a]作为参数传递给函数`。
>   - JavaScript 在全局执行上下文内存中搜索变量`a`，找到它，发现它的值是 3，并将数字 3 作为参数传递给函数，准备好执行函数。
>5. 现在执行上下文将切换,创建了一个新的本地执行上下文，我们将其命名为[“`addTwo 执行上下文`”，`执行上下文被推送到调用堆栈上`。在 addTwo 执行上下文中，我们要做的第一件事是什么?
>   - 你可能会说，“在 addTwo 执行上下文中声明了一个新的变量 ret”，`这是不对的`。
>   - `正确的答案是`:我们需要先看函数的参数。`在 addTwo 执行上下文中声明一个新的变量[x]`，因为值 3 是作为参数传递的，所以变量 x 被赋值为 3。		
>   - 下一步才是在 addTwo 执行上下文中声明一个新的变量`ret`。它的值被设置为 undefined(第三行)。
>6. 仍然是第 3 行，需要执行一个相加操作。
>   - 首先我们需要`x`的值，JavaScript 会寻找一个变量`x`，它会首先在`addTwo`执行上下文中寻找，找到了一个值为 3。第二个操作数是数字 2。两个相加结果为 5 就被分配给变量`ret`。
>7. 第 4 行，我们返回变量`ret`的内容，在 addTwo 执行上下文中查找，找到值为 5，返回，函数结束。
>8. 第 4 - 5 行，函数结束。
>   - `addTwo 执行上下文被销毁`，变量`x`和`ret`被消去了，它们已经不存在了。`addTwo 执行上下文从调用堆栈中弹出`，返回值返回给调用上下文，在这种情况下，调用上下文是全局执行上下文，因为函数`addTwo` 是从全局执行上下文调用的。
>9. 现在我们继续第 4 步的内容，返回值 5 被分配给变量`b`，`此时实际上程序仍然在第 6 行`(盗梦空间既视感:dog:)
>10. 在第 7 行，`b`的值 5 被打印到控制台了。
>
>对于一个非常简单的程序，这是一个非常冗长的解释，我们甚至还没有涉及闭包。但肯定会涉及的，不过首先我们得绕一两个弯。

#### ② 举个栗子分析词法作用域

>这里想说明，我们在函数执行上下文中有变量，在全局执行上下文中有变量。JavaScript 的一个复杂之处在于它如何查找变量，如果在函数执行上下文中找不到变量，它将在调用上下文中寻找它，如果在它的调用上下文中没有找到，就一直往上一级，直到它在全局执行上下文中查找为止。(如果最后找不到，它就是 undefined)。
>
>```js
>1: let val1 = 2
>2: function multiplyThis(n) {
>3:   let ret = n * val1
>4:    return ret
>5: }
>6: let multiplied = multiplyThis(6)
>7: console.log('example of scope:', multiplied)
>```
>
>下面列出向个步骤来解释一下（如果你已经熟悉了，请跳过）：
>
>1. 在全局执行上下文中声明一个新的变量`val1`，并将其赋值为 2。
>2. 行 2 - 5，声明一个新的变量 `multiplyThis`，并给它分配一个函数定义。
>3. 第六行，声明一个在全局执行上下文 `multiplied` 新变量。
>4. 从全局执行上下文内存中查找变量`multiplyThis`，并将其作为函数执行，传递数字 6 作为参数。
>   - 新函数调用(创建新执行上下文），创建一个新的 `multiplyThis` 函数执行上下文。
>   - 在 `multiplyThis` 执行上下文中，`声明一个变量 n 并将其赋值为 6`  -->声明后才会进入函数体内部执行
>5. 执行函数回到第 3 行。
>   - 在`multiplyThis`执行上下文中，声明一个变量`ret`。
>   - 继续第 3 行。对两个操作数 n 和 val1 进行乘法运算.在`multiplyThis`执行上下文中查找变量 `n`。
>     - 我们在步骤 6 中声明了它,它的内容是数字 6。在`multiplyThis`执行上下文中查找变量`val1`。
>     - `multiplyThis`执行上下文没有一个标记为 val1 的变量。`我们向调用上下文查找，调用上下文是全局执行上下文，在全局执行上下文中`寻找 [`val1`]。哦，是的、在那儿，它在步骤 1 中定义，数值是 2。
>   - 继续第 3 行。将两个操作数相乘并将其赋值给`ret`变量，6 * 2 = 12，ret 现在值为 12。
>6. 返回`ret`变量，销毁`multiplyThis`执行上下文及其变量 `ret` 和 `n` 。变量 `val1` 没有被销毁，因为它是全局执行上下文的一部分。
>7. 回到第 6 行。在调用上下文中，数字 12 赋值给 `multiplied` 的变量。
>8. 最后在第 7 行，我们在控制台中打印 `multiplied` 变量的值
>
>在这个例子中，我们需要记住一个函数可以访问在它的调用上下文中定义的变量，这个就是**词法作用域（Lexical scope）**。

#### ③ 返回函数的函数[`高阶函数`]

>在第一个例子中，函数`addTwo`返回一个数字。请记住，函数可以返回任何东西。让我们看一个返回函数的函数示例，因为这对于下方理解闭包非常重要。看栗子：
>
>```js
>1: let val = 7
>2: function createAdder() {
>3:   function addNumbers(a, b) {
>4:     let ret = a + b
>5:     return ret
>6:   }
>7:   return addNumbers
>8: }
>9: let adder = createAdder()
>10: let sum = adder(val, 8)
>11: console.log('example of function returning a function: ', sum)
>```
>
>让我们回到分步分解：
>
>1. 第一行。我们在全局执行上下文中声明一个变量`val`并赋值为 7。
>2. 行 2 - 8。我们在全局执行上下文中声明了一个名为 `createAdder` 的变量，并为其分配了一个函数定义。
>   - 内部的第 3 至 7 行描述了上述函数定义，和以前一样，在这一点上，我们没有直接讨论这个函数。我们只是将函数定义存储到[`createAdder`]变量中。
>3. 第 9 行。
>   - 我们在全局执行上下文中声明了一个名为 `adder` 的新变量，暂时，值为 undefined
>   - 我们看到括号()，我们需要执行或调用一个函数，查找全局执行上下文的内存并查找名为`createAdder` 的变量，它是在步骤 2 中创建的。好吧，我们调用它。
>4. 调用函数时，执行到第 2 行。
>   - 创建一个新的`createAdder`执行上下文。我们可以在`createAdder`的执行上下文中创建自有变量。js 引擎将`createAdder`的上下文添加到调用堆栈。这个函数没有参数，让我们`直接跳到它的主体部分`.
>5. 第 3 - 6 行(执行到主体函数中)。
>   - 我们有一个新的函数声明，我们在`createAdder`执行上下文中创建一个变量 addNumbers。这很重要，`addnumber`只存在于`createAdder`执行上下文中。我们将函数定义存储在名为 `addNumbers` 的自有变量中。
>   - 在第 7 行，我们返回变量`addNumbers`的内容。js 引擎查找一个名为`addNumbers`的变量并找到它，这是一个函数定义。好的，函数可以返回任何东西，包括函数定义。我们返`addNumbers`的定义。第 4 行和第 5 行括号之间的内容构成该函数定义。
>6. [return addNumbers]时，`createAdder`执行上下文将被销毁。`addNumbers` 变量不再存在。但`addNumbers`函数定义仍然存在，`因为它返回并赋值给了 adder 变量`。   
>   - `此处很重要`!!!此时的[`adder=createAdder()`]实际上它的值是[`addNumbers`]的函数定义而不是[`createAdder`]了,adder现在是一个匿名函数--这里有点绕,要确定理解
>7. 第 10 行。我们在全局执行上下文中定义了一个新的变量 `sum`，先赋值为 undefined;
>   - 接下来我们需要执行一个函数。哪个函数?
>     - 是名为`adder`变量中定义的函数。我们在全局执行上下文中查找它，果然找到了它，这个函数有两个参数。
>     - 让我们查找这两个参数，第一个是我们在步骤 1 中定义的变量`val`，它表示数字 7，第二个是数字 8。
>   - 现在我们要执行这个函数，函数定义概述在第 3-5 行，`因为这个函数是匿名`，为了方便理解，我们暂且叫它`adder`吧。这时创建一个`adder`函数执行上下文，在`adder`执行上下文中创建了两个新变量 `a` 和 `b`。它们分别被赋值为 7 和 8，因为这些是我们在上一步传递给函数的参数。
>8. 执行回到第 4 行。
>   - 在`adder`执行上下文中声明了一个名为`ret`的新变量,
>   - 将变量`a`的内容和变量`b`的内容相加得 15 并赋给 ret 变量。
>9. `ret`变量从该函数返回。这个匿名函数执行上下文被销毁，从调用堆栈中删除，变量`a`、`b`和`ret`不再存在。
>10. 返回值被分配给我们在步骤 9 中定义的`sum`变量。
>11. 我们将`sum`的值打印到控制台。
>
>如预期，控制台将打印 15。我们在这里确实经历了很多困难，我想在这里说明几点。首先，函数定义可以存储在变量中，函数定义在程序调用之前是不可见的。其次，每次调用函数时，都会(临时)创建一个本地执行上下文。当函数完成时，执行上下文将消失。函数在遇到 return 或右括号}时执行完成。

##### `高阶函数是什么?`

>所谓高阶函数，就是一个函数就可以接收另一个函数作为参数，或者是返回一个函数-->常见的高阶函数有map、reduce、filter、sort等
>
>  ```js
>var ADD =function add(a) {
> return function(b) {
>  return a+b
> }
>}
> 调用：ADD(2)(3)即可获得结果
>  ```
>
>1. map
>
>   - ```js
>     //
>     map接受一个函数作为参数，不改变原来的数组，只是返回一个全新的数组
>     var arr = [1,2,3,4,5]
>     var arr1 = arr.map(item => item = 2)// 输出[1,1,1,1,1]
>     ```
>
>2. reduce
>
>   - ```js
>     //
>     reduce也是返回一个全新的数组。reduce接受一个函数作为参数，这个函数要有两个形参，代表数组中的前两项，reduce会将这个函数的结果与数组中的第三项再次组成这个函数的两个形参以此类推进行累积操作
>     var arr = [1,2,3,4,5]
>     var arr2 = arr.reduce((a,b)=> a+b)
>     console.log(arr2) // 15
>     ```
>
>3. filter
>
>   - ```js
>     //
>     filter返回过滤后的数组。filter也接收一个函数作为参数，这个函数将作用于数组中的每个元素，根据该函数每次执行后返回的布尔值来保留结果，如果是true就保留，如果是false就过滤掉（这点与map要区分）
>     var arr = [1,2,3,4,5]
>      var arr3 = arr.filter(item => item % 2 == 0)
>     console.log(arr3)// [2,4]
>     ```

## 5、闭包

>一个函数和对其周围状态（**lexical environment，词法环境**）的引用捆绑在一起（或者说函数被引用包围），这样的组合就是**闭包**（**closure**）。也就是说，闭包让你可以在一个内层函数中访问到其外层函数的作用域。在 JavaScript 中，每当创建一个函数，闭包就会在函数创建的同时被创建出来。
>
>本来闭包部分是看`尚硅谷`的教学视频,当时那位老师在此部分讲解的让我觉得并没特别清晰(在刚开始时没讲到重点,导致难以理解,但是在后面有提到就懂了),所以我自己看完后再去翻阅许多关于闭包的资料进行自学,随后将其梳理整合并加以自己感悟记录于此

### Ⅰ-引出闭包概念

#### ① 错误场景

>需求: `点击某个按钮, 提示"点击的是第n个按钮"`
>
>```html
><button>测试1</button>
><button>测试2</button>
><button>测试3</button>
><!--
>需求: 点击某个按钮, 提示"点击的是第n个按钮"
>-->
><script type="text/javascript">
>  var btns = document.getElementsByTagName('button')
>  //注意[btns]不是一个数组,它是一个伪数组
>  //每次获取[btns.length]其实都是需要进行计算的(因为它是伪数组)
>  //所以为了性能更好,在此处赋值,就只需要计算一次
>  for (var i = 0,length=btns.length; i < length; i++) {
>    var btn = btns[i]
>    btn.onclick = function () {  //遍历加监听
>      alert('第'+(i+1)+'个')     //结果 全是[4]
>    }
>  }
></script>    
>```
>
>此处错误是,直接修改并使用全局变量[`i`],导致for循环结束后,所有点击按钮绑定的弹窗值都是[`i+1`]
>
>随后调用时,都会找到[`i`]这个变量,但是此时i==3,所以所有结果都是4
>
>![image-20210727143351376](A_JavaScript进阶学习笔记中的图片/image-20210727143351376.png) 

#### ② 将变量挂载到自身来解决

>解决方式:将btn所对应的下标保存在btn上
>
>```js
><button>测试1</button>
><button>测试2</button>
><button>测试3</button>
><!--
>需求: 点击某个按钮, 提示"点击的是第n个按钮"
>-->
><script type="text/javascript">
>  var btns = document.getElementsByTagName('button')
>  for (var i = 0,length=btns.length; i < length; i++) {
>    var btn = btns[i]
>    //将btn所对应的下标保存在btn上
>    btn.index = i
>    btn.onclick = function () {  //遍历加监听
>      alert('第'+(i+1)+'个')     //结果 全是[4]
>    }
>  }
></script>    
>```
>
>将其放在自己的身上,需要时自己找自己拿,这样就能解决
>
>![image-20210727143824641](A_JavaScript进阶学习笔记中的图片/image-20210727143824641.png)

#### ③ 利用闭包

>利用闭包知识点解决,引出下方知识点,不懂的可以带着疑问继续往下看
>
>```js
><body>
><button>测试1</button>
><button>测试2</button>
><button>测试3</button>
>
><script type="text/javascript">
>  //利用闭包
>  for (var i = 0,length=btns.length; i < length; i++) {
>     //此处的j是局部的,它将传入的[i]存入局部的[j]中,这样就能实现效果 
>    (function (j) {
>      var btn = btns[j]
>      btn.onclick = function () {
>        alert('第'+(j+1)+'个')
>      }
>    })(i)
>  }
></script>  
></body>
>```
>
>![image-20210727143824641](A_JavaScript进阶学习笔记中的图片/image-20210727143824641.png)

### Ⅱ-举个闭包栗子分析理解

> 按照上方 [`4`]代码举例分析流程的方式 来尝试理解`闭包`概念
>
> 提前给出一个闭包栗子进行分析,先看看发生什么,再去看它的概念进行印证,相信我,你会有种拨开迷雾的感受

#### ① 按照正常逻辑理解

>先说,此部分不是按照闭包机制进行理解,所以中途发觉不对(`肯定有地方不对劲`)请勿钻牛角尖,主要用作后方对照
>
>```js
>1: function createCounter() {
>2:   let counter = 0
>3:   const myFunction = function() {
>4:     counter = counter + 1
>5:     return counter
>6:   }
>7:   return myFunction
>8: }
>9: const increment = createCounter()
>10: const c1 = increment()
>11: const c2 = increment()
>12: const c3 = increment()
>13: console.log('example increment', c1, c2, c3)
>```
>
>现在，我们已经从前几个示例中掌握了它的诀窍，让我们按照预期的方式快速执行它：  (`错误的流程理解,故意按照正常的逻辑流程走,做印证`)
>
>1. 行 1 - 8。我们在全局执行上下文中创建了一个新的变量`createCounter`，并赋值了一个的函数定义。
>2. 第 9 行。
>   - 我们在全局执行上下文中声明了一个名为`increment`的新变量。
>   - 我们需要调用`createCounter`函数并将其返回值赋给`increment`变量。
>3. 返回执行 行 1 - 8。调用函数，创建新的本地执行上下文。
>   - 第 2 行。在本地执行上下文中，声明一个名为`counter`的新变量并赋值为 0;
>   - 行 3 - 6。声明一个名为`myFunction`的新变量，变量在本地执行上下文中声明,变量的内容是为第 4 行和第 5 行所定义。
>   - 第 7 行。返回`myFunction`变量的内容，删除本地执行上下文。变量`myFunction`和`counter`不再存在。此时控制权回到了调用上下文。
>4. 再次回到 第 9 行
>   - 在调用上下文(全局执行上下文)中，`createCounter`返回的值赋给了`increment`，变量`increment`现在包含一个函数定义内容为`createCounter`返回的函数。
>   - 它不再标记为`myFunction`，但它的定义是相同的。在全局上下文中，它是的标记为 `labeledincrement`。
>5. 第 10 行。声明一个新变量(c1)。
>   - 继续第 10 行。查找`increment`变量，它是一个函数并调用它。它包含前面返回的函数定义，如第 4-5 行所定义的。
>   - 创建一个新的执行上下文。没有参数。开始执行函数。
>6. 回到 第 4 行。
>   - counter=counter + 1。在本地执行上下文中查找`counter`变量。
>   - 我们只是创建了那个上下文，从来没有声明任何局部变量。让我们看看全局执行上下文。这里也没有`counter`变量。
>   - Javascript 会将其计算为 counter = undefined + 1，声明一个标记为`counter`的新局部变量，并将其赋值为 number 1，`因为 undefined 被当作值为 0。`    -->此处是错误的哦,别钻牛角尖,正确的理解在下方,此处是做错误对比
>7. 第 5 行。我们变量`counter`的值(1)，我们销毁本地执行上下文和`counter`变量。
>8. 回到第 10 行。返回值(1)被赋给 c1。
>9. 第 11 行。重复步骤 10-14，c2 也被赋值为 1。
>10. 第 12 行。重复步骤 10-14，c3 也被赋值为 1。
>11. 第 13 行。我们打印变量 c1 c2 和 c3 的内容。
>
>你自己试试，看看会发生什么。你会将注意到，`它并不像从我上面的解释中所期望的那样记录 1,1,1。而是记录 1,2,3`。这个是为什么?

#### ②正确的理解

>不知怎么滴，`increment`函数记住了那个`cunter`的值。这是怎么回事?
>
>>1. counter是全局执行上下文的一部分吗? 
>>   - 尝试 console.log(counter)，得到undefined的结果,显然不是这样的。
>>2. 也许，当你调用increment时，它会以某种方式返回它创建的函数(createCounter)?
>>   - 这怎么可能呢?变量increment包含函数定义，而不是函数的来源，显然也不是这样的。
>>3. 所以一定有另一种机制。**闭包**，我们终于找到了，丢失的那块。
>>   -  **-`它是这样工作的，无论何时声明新函数并将其赋值给变量，都要存储函数定义和闭包。闭包包含在函数创建时作用域中的所有变量，它类似于背包。函数定义附带一个小背包，它的包中存储了函数定义创建时作用域中的所有变` **
>
>**所以我们上面的解释都是错的，让我们再试一次，但是这次是正确的**
>
>```js
>1: function createCounter() {
>2:   let counter = 0
>3:   const myFunction = function() {
>4:     counter = counter + 1
>5:     return counter
>6:   }
>7:   return myFunction
>8: }
>9: const increment = createCounter()
>10: const c1 = increment()
>11: const c2 = increment()
>12: const c3 = increment()
>13: console.log('example increment', c1, c2, c3)
>```
>
>1. 同上，第`1-8`行。我们在全局执行上下文中创建了一个新的变量`createCounter`，它得到了指定的函数定义。
>2. 同上，第`9`行。
>  - 我们在全局执行上下文中声明了一个名为`increment`的新变量。
>  - 我们需要调用`createCounter`函数并将其返回值赋给`increment`变量。
>3. 同上，第`1-8`行。调用函数，创建新的本地执行上下文。
>  - 第`2`行。在本地执行上下文中，声明一个名为`counter`的新变量并赋值为 `0` 。
>  - 第`3-6`行。声明一个名为`myFunction`的新变量，变量在本地执行上下文中声明,变量的内容是另一个函数定义。如第`4`行和第`5`行所定义，现在我们还创建了一个闭包，并将其作为函数定义的一部分。闭包包含作用域中的变量，在本例中是变量`counter`(值为`0`)。
>  - 第`7`行。返回`myFunction`变量的内容,删除本地执行上下文。`myFunction`和`counter`不再存在。控制权交给了调用上下文，我们返回函数定义和它的闭包，闭包中包含了创建它时在作用域内的变量。
>4. 回到第`9`行。
>  - 在调用上下文(全局执行上下文)中，`createCounter`返回的值被指定为`increment`
>  - 变量`increment`现在包含一个函数定义(和闭包),由createCounter返回的函数定义,它不再标记为`myFunction`，但它的定义是相同的,在全局上下文中，称为`increment`。
>5. 第`10`行。声明一个新变量`c1`。
>  - 继续第`10`行。查找变量`increment`，它是一个函数，调用它。它包含前面返回的函数定义,如第`4-5`行所定义的。(`它还有一个带有变量的闭包`)。
>  - 创建一个新的执行上下文，没有参数，开始执行函数。
>6. 第`4`行。[`counter = counter + 1`]，寻找变量 [`counter`]，`在查找本地或全局执行上下文之前，让我们检查一下闭包`，瞧，闭包包含一个名为[`counter`]的变量，其值为`0`。在第`4`行表达式之后，它的值被设置为`1`。它再次被储存在闭包里，闭包现在包含值为`1`的变量 [`counter`]。
>7. 第`5`行。我们返回`counter的值`，销毁本地执行上下文。
>8. 回到第`10`行。返回值`1`被赋给变量`c1`。
>9. 第`11`行。我们重复步骤`10-14`。这一次，在闭包中此时变量`counter`的值是1。它在第`12`行设置的，它的值被递增并以`2`的形式存储在递增函数的闭包中,`c2`被赋值为`2`。
>10. 第`12`行。重复步骤`10-14`行,`c3`被赋值为3。
>11. 第13行。我们打印变量`c1 c2`和`c3`的值。
>
>** `你此时可能会问，是否有任何函数具有闭包，甚至是在全局范围内创建的函数?` **
>
>>答案是肯定的。在全局作用域中创建的函数创建闭包，但是由于这些函数是在全局作用域中创建的，所以它们可以访问全局作用域中的所有变量，闭包的概念并不重要。
>
>>但当函数返回函数时，闭包的概念就变得更加重要了。返回的函数可以访问不属于全局作用域的变量，但它们仅存在于其闭包中。

### Ⅲ-常见的闭包

#### ① 将函数作为另一个函数的返回值

>```js
>// 1. 将函数作为另一个函数的返回值
>  function fn1() {
>    var a = 2
>    function fn2() {
>      a++
>      console.log(a)
>    }
>    return fn2
>  }
>  var f = fn1()
>  f() // 3
>  f() // 4
>```

#### ② 将函数作为实参传递给另一个函数调用

>```js
>// 2. 将函数作为实参传递给另一个函数调用
>  function showDelay(msg, time) {
>    setTimeout(function () {
>      alert(msg)
>    }, time)
>  }
>  showDelay('atguigu', 2000)
>```

#### ③ 高阶函数与柯里化

>有时候闭包在你甚至没有注意到它的时候就会出现，你可能已经看到了我们称为部分应用程序的示例
>
>当然如果你还不理解的话可以,可以完整的多看几次本笔记闭包知识点部分,或者结合上方[ `Ⅱ-举个闭包栗子分析理解` ](#Ⅱ-举个闭包栗子分析理解)进行理解

##### 1、从 ES6 高阶箭头函数理解函数柯里化(`运用到闭包`)

>1. 首先看到了这样的一个例子：
>
>  ```js
>let add = a => b => a + b
>  ```
>
>2. 以上是一个很简单的相加函数，把它转化成 ES5 的写法如下
>
>  ```js
>function add(a) {
>      return function(b) {
>          return a + b
>      }
>  }
>  var add3 = add(3) //add3表示一个指向函数的变量 可以当成函数调用名来用
>  add3(4) === 3 + 4 //true
>  ```
>
>3. 再简化一下，可以写成如下形式：
>
>  ```js
>let add = function(a) {
>    var param = a;
>    var innerFun = function(b) {
>        return param + b;
>    }
>    return innerFun;
>}
>  ```
>
>4. 虽然好像没什么意义，但是很显然上述使用了[`闭包`]，而且该函数的返回值是一个函数。其实，这就是`高阶函数的定义：以函数为参数或者返回值是函数的函数。`
>
>  ![image-20210415160945789](A_JavaScript进阶学习笔记中的图片/image-20210415160945789.png)

##### 2、柯里化

>1. 图例:
>
>  ![image-20210415161137977](A_JavaScript进阶学习笔记中的图片/image-20210415161137977.png)
>
>2. 关键就是`理解柯里化`，其实可以把它理解成，柯里化后，`将第一个参数变量存在函数里面了(闭包)`，然后本来需要n个参数的函数可以变成只需要剩下的（n - 1个）参数就可以调用，比如
>
>  ```js
>let add = x => y => x + y
>let add2 = add(2)
>-*----------------------------------
>本来完成 add 这个操作，应该是这样调用
>let add = (x, y) => x + y
>add(2,3)
>----------------------------------
>1. 而现在 add2 函数完成同样操作只需要一个参数，这在函数式编程中广泛应用。
>let add = x => y => x + y
>let add2 = add(2)
>2.详细解释一下，就是 add2 函数 等价于 有了 x 这个闭包变量的 y => x + y 函数,并且此时 x = 2，所以此时调用
>add2(3) === 2 + 3
>  ```

##### 4、总结

>1. 如果是`a => b => c => {xxx}`这种多次柯里化的,如何理解?
>
>  理解:前` n - 1 `次调用，其实是提前将参数传递进去，并没有调用最内层函数体，最后一次调用才会调用最内层函数体，并返回最内层函数体的返回值
>
>2. 结合上文可知，这里的多个连续箭头（无论俩个箭头函数三个及以上）函数连在一起 就是在柯里化。所以连续箭头函数就是多次柯里化函数的 es6 写法。
>
>3. `调用特点`:let test = a => b => c => {xxx}
>
>  比如对于上面的 `test` 函数，它有 3 个箭头， 这个函数要被调用 3 次 `test(a)(b)(c)`，前两次调用只是在传递参数，只有最后依次调用才会返回 `{xxx}` 代码段的返回值，并且在 `{xxx}` 代码段中可以调用 a,b,c

### Ⅳ-闭包的作用

>1. 使用函数内部的变量在函数执行完后, 仍然存活在内存中(延长了局部变量的生命周期)
>2. 让函数外部可以操作(读写)到函数内部的数据(变量/函数)
>
>问题:
>    1. 函数执行完后, 函数内部声明的局部变量是否还存在? 
>         -  一般是不存在, 存在于闭中的变量才可能存在
>    2. 在函数外部能直接访问函数内部的局部变量吗? 
>         - 不能, 但我们可以通过闭包让外部操作它

### Ⅴ-闭包的生命周期

>1. 产生: 在嵌套内部函数定义执行完时就产生了(不是在调用)
>2. 死亡: 在嵌套的内部函数成为垃圾对象时
>   - 即没有人指向它时死亡,通常置为[`null`],当然指向其他也行,但不安全(容易污染变量)
>
>```js
>//闭包的生命周期
>function fn1() {
>    //此时闭包就已经产生了(函数提升,实际上[fn2]提升到了第一行, 内部函数对象已经创建了)
>    var a = 2
>    function fn2 () { //如果时[let fn2=function(){}],那么在这行才会产生闭包
>      a++
>      console.log(a)
>    }
>    return fn2
>  }
>  var f = fn1()
>  f() // 3
>  f() // 4
>  f = null //闭包死亡(包含闭包的函数对象成为垃圾对象)
>```

### Ⅵ-闭包的应用

>闭包的应用 : 定义JS模块
>  * 具有特定功能的js文件
>  * 将所有的数据和功能都封装在一个函数内部(私有的)
>  * 只向外暴露一个包信n个方法的对象或函数
>  * 模块的使用者, 只需要通过模块暴露的对象调用方法来实现对应的功能
>
>1. 模块定义:
>
>   - ```js
>     //myModule.js
>     function myModule() {
>       //私有数据
>       var msg = 'My atguigu'
>       //操作数据的函数
>       function doSomething() {
>         console.log('doSomething() '+msg.toUpperCase())
>       }
>       function doOtherthing () {
>         console.log('doOtherthing() '+msg.toLowerCase())
>       }
>                 
>       //向外暴露对象(给外部使用的方法)
>       return {
>         doSomething: doSomething,
>         doOtherthing: doOtherthing
>       }
>     }
>                 
>     -----------------------------------------------------------------
>     // myModule2.js   
>     (function () {
>       //私有数据
>       var msg = 'My atguigu'
>       //操作数据的函数
>       function doSomething() {
>         console.log('doSomething() '+msg.toUpperCase())
>       }
>       function doOtherthing () {
>         console.log('doOtherthing() '+msg.toLowerCase())
>       }
>                 
>       //向外暴露对象(给外部使用的方法)
>       window.myModule2 = {
>         doSomething: doSomething,
>         doOtherthing: doOtherthing
>       }
>     })()    
>                     
>     ```
>
>2. 模块调用
>
>   - ```js
>     //调用示例
>     ------------  模块调用1 --------------------------------------------
>     <script type="text/javascript" src="myModule.js"></script>
>     <script type="text/javascript">
>       var module = myModule()
>       module.doSomething()
>       module.doOtherthing()
>     </script>
>     ------------  模块调用2 --------------------------------------------
>     <script type="text/javascript" src="myModule2.js"></script>
>     <script type="text/javascript">
>       myModule2.doSomething()
>       myModule2.doOtherthing()
>     </script>
>     ```

### Ⅶ-闭包的缺点及解决

>1. 缺点:
>  * 函数执行完后, 函数内的局部变量没有释放, 占用内存时间会变长
>  * 容易造成内存泄露
>2. 解决:
>  * 能不用闭包就不用
>
>  * 及时释放
>
>  * ```js
>    function fn1() {
>      var arr = new Array(100000)
>      function fn2() {
>        console.log(arr.length)
>      }
>      return fn2
>    }
>    var f = fn1()
>    f()
>    f = null //让内部函数成为垃圾对象-->回收闭包
>    ```
>
>我还有一个解决方式,调用时直接`f()()`直接运行调用即可-->匿名函数,用完自动就销毁了
>
>![image-20210727191229838](A_JavaScript进阶学习笔记中的图片/image-20210727191229838.png)

### Ⅷ-内存溢出与内存泄露

>1. 内存溢出
>  * 一种程序运行出现的错误
>  * 当程序运行需要的内存超过了剩余的内存时, 就出抛出内存溢出的错误
>2. 内存泄露
>  * 占用的内存没有及时释放
>  * `内存泄露积累多了就容易导致内存溢出`
>  * 常见的内存泄露:
>    * 意外的全局变量
>    * 没有及时清理的计时器或回调函数
>    * 闭包
>
>```js
><script type="text/javascript">
>  // 1. 内存溢出
>  var obj = {}
>  for (var i = 0; i < 10000; i++) {
>    obj[i] = new Array(10000000)
>    console.log('-----')
>  }
>
>  // 2. 内存泄露
>    // 意外的全局变量
>  function fn() {
>    a = new Array(10000000)  //不使用var let const去承接
>    console.log(a)
>  }
>  fn()
>
>   // 没有及时清理的计时器或回调函数
>  var intervalId = setInterval(function () { //启动循环定时器后不清理
>    console.log('----')
>  }, 1000)
>
>  // clearInterval(intervalId)
>
>    // 闭包
>  function fn1() {
>    var a = 4
>    function fn2() {
>      console.log(++a)
>    }
>    return fn2
>  }
>  var f = fn1()
>  f()
>  // f = null
>
></script>
>```
>
>不使用let const var等去声明,实际上是挂载到[`window`]上的,所以导致内存泄露![image-20210727193110329](A_JavaScript进阶学习笔记中的图片/image-20210727193110329.png)

### Ⅸ-相关面试题1

>```js
>//代码片段一  -->没有产生闭包:因为内部函数没有调用外部变量
>var name = "The Window";
>var object = {
>  name : "My Object",
>  getNameFunc : function(){
>    return function(){
>      return this.name;
>    };
>  }
>};
>alert(object.getNameFunc()());  //?  the window
>//函数体的this是window
>
>//代码片段二
>var name2 = "The Window";
>var object2 = {
>  name2 : "My Object",
>  getNameFunc : function(){
>  //此处的this指向是[getNameFunc],他是对象中的属性,所以this指向就是object
>    var that = this;
>    return function(){
>      //此处用的是保存的  that
>      return that.name2;
>    };
>  }
>};
>alert(object2.getNameFunc()()); //?  my object
>```
>
>1. 代码片段一:
>   - 函数体的`this`指向是[`window`]
>   - 没有产生闭包:因为内部函数没有调用外部变量
>2. 代码片段二为何指向是对象?
>   - this指向是调用它的[`getNameFunc`],他是对象中的属性,所以this指向就是object
>   - 产生了闭包

### Ⅹ-相关面试题2:

>```js
>function fun(n,o) {
>  console.log(o)
>  return {
>    fun:function(m){
>      return fun(m,n)
>    }
>  }
>}
>var a = fun(0) //undefined
>a.fun(1)  //0
>a.fun(2)  //0	
>a.fun(3)  //0
>
>var b = fun(0).fun(1).fun(2).fun(3) //undefined 0 1 2
>
>var c = fun(0).fun(1) //undefined  0
>c.fun(2)//1 -->经过上方定义后 n固定为1
>c.fun(3)//1 -->此处是陷阱!!!  一直没有改到n,所以一直是1
>```

# 三、面向对象高级

> 此部分要求你对前方[函数高级部分的1、原型与原型链](#1、原型与原型链)比较熟悉,如果掌握不够好理解会相对困难

## 1、对象创建模式

### Ⅰ-Object构造函数模式

>方式一: Object构造函数模式
>
> * 套路: 先创建空Object对象, 再动态添加属性/方法
> * 适用场景: 起始时不确定对象内部数据
> * 问题: 语句太多
>
>```js
>/*一个人: name:"Tom", age: 12*/
>// 先创建空Object对象
> var p = new Object()
> p = {} //此时内部数据是不确定的
> // 再动态添加属性/方法
> p.name = 'Tom'
> p.age = 12
> p.setName = function (name) {
>   this.name = name
> }
>
> //测试
> console.log(p.name, p.age)
> p.setName('Bob')
> console.log(p.name, p.age)
>```

### Ⅱ-对象字面量模式

>方式二: 对象字面量模式
>
>  * 套路: 使用{}创建对象, 同时指定属性/方法
>  * 适用场景: 起始时对象内部数据是确定的
>  * 问题: 如果创建多个对象, 有重复代码
>
>```js
>//对象字面量模式
>var p = {
>    name: 'Tom',
>    age: 12,
>    setName: function (name) {
>      this.name = name
>    }
>  }
>  //测试
>  console.log(p.name, p.age)
>  p.setName('JACK')
>  console.log(p.name, p.age)
>
>  var p2 = {  //如果创建多个对象代码很重复
>    name: 'Bob',
>    age: 13,
>    setName: function (name) {
>      this.name = name
>    }
>  }
>```

### Ⅲ-工厂模式

>方式三: 工厂模式
>
>  * 套路: 通过工厂函数动态创建对象并返回
>  * 适用场景: 需要创建多个对象
>  * 问题: `对象没有一个具体的类型`, 都是Object类型
>
>```js
>//返回一个对象的函数===>工厂函数
>function createPerson(name, age) { 
>  var obj = {
>    name: name,
>    age: age,
>    setName: function (name) {
>      this.name = name
>    }
>  }
>  return obj
>}
>
>// 创建2个人
>var p1 = createPerson('Tom', 12)
>var p2 = createPerson('Bob', 13)
>
>// p1/p2是Object类型
>
>function createStudent(name, price) {
>  var obj = {
>    name: name,
>    price: price
>  }
>  return obj
>}
>var s = createStudent('张三', 12000)
>// s也是Object
>```

### Ⅳ-自定义构造函数模式

>方式四: 自定义构造函数模式
>
>  * 套路: 自定义构造函数, 通过new创建对象
>  * 适用场景: 需要创建多个`类型确定`的对象,与上方工厂模式有所对比
>  * 问题: 每个对象都有相同的数据, 浪费内存
>
>```js
>//定义类型
>function Person(name, age) {
>  this.name = name
>  this.age = age
>  this.setName = function (name) {
>    this.name = name
>  }
>}
>var p1 = new Person('Tom', 12)
>p1.setName('Jack')
>console.log(p1.name, p1.age)
>console.log(p1 instanceof Person)
>
>function Student (name, price) {
>  this.name = name
>  this.price = price
>}
>var s = new Student('Bob', 13000)
>console.log(s instanceof Student)
>
>var p2 = new Person('JACK', 23)
>console.log(p1, p2)
>```

### Ⅴ-构造函数+原型的组合模式

>方式六: 构造函数+原型的组合模式-->`最好用这个写法`
>
>  * 套路: 自定义构造函数, 属性在函数中初始化, 方法添加到原型上
>  * 适用场景: 需要`创建多个类型确定`的对象
>  * 放在原型上可以节省空间(只需要加载一遍方法)
>
>```js
>//在构造函数中只初始化一般函数
>function Person(name, age) { 
>  this.name = name
>  this.age = age
>}
>Person.prototype.setName = function (name) {
>  this.name = name
>}
>
>var p1 = new Person('Tom', 23)
>var p2 = new Person('Jack', 24)
>console.log(p1, p2)
>```

## 2、继承模式

### Ⅰ-原型链继承

>方式1: 原型链继承
>
>   1. 套路
>        - 定义父类型构造函数
>        - 给父类型的原型添加方法
>        - 定义子类型的构造函数
>        - 创建父类型的对象赋值给子类型的原型
>        - `将子类型原型的构造属性设置为子类型`-->此处有疑惑的可以看本笔记[函数高级部分的1、原型与原型链](#1、原型与原型链)或者直接看下方本人给出的补充
>        - 给子类型原型添加方法
>        - 创建子类型的对象: 可以调用父类型的方法
>   2. 关键
>        - `子类型的原型为父类型的一个实例对象`
>
>```js
>//父类型
>function Supper() {
> this.supProp = '父亲的原型链'
>}
>//给父类型的原型上增加一个[showSupperProp]方法,打印自身subProp
>Supper.prototype.showSupperProp = function () {
> console.log(this.supProp)
>}
>
>//子类型
>function Sub() {
> this.subProp = '儿子的原型链'
>}
>
>// 子类型的原型为父类型的一个实例对象
>Sub.prototype = new Supper()
>// 让子类型的原型的constructor指向子类型
>// 如果不加,其构造函数找的[`new Supper()`]时从顶层Object继承来的构造函数,指向[`Supper()`]
>Sub.prototype.constructor = Sub
>//给子类型的原型上增加一个[showSubProp]方法,打印自身subProp
>Sub.prototype.showSubProp = function () {
> console.log(this.subProp)
>}
>
>var sub = new Sub()
>
>sub.showSupperProp() //父亲的原型链
>sub.showSubProp() //儿子的原型链
>console.log(sub)  
>/**
>Sub {subProp: "儿子的原型链"}
>subProp: "儿子的原型链"
>__proto__: Supper
>constructor: ƒ Sub()
>showSubProp: ƒ ()
>supProp: "父亲的原型链"
>__proto__: Object
>*/
>```

#### ① 示例图

>`注意`:此图中没有体现[`constructor构造函数 `],会在下方构造函数补充处指出
>
>![image-20210728101320606](A_JavaScript进阶学习笔记中的图片/image-20210728101320606.png)

#### ② 构造函数补充

>对于代码中[`Sub.prototype.constructor = Sub`]是否有疑惑?
>
>如果不加,其构造函数找的[`new Supper()`]是从顶层Object继承来的构造函数,指向[`Supper()`],虽然如果你不加这句话,大体上使用是不受影响的,但是你有一个属性指向是错误的,如果在大型项目中万一万一哪里再调用到了呢?
>
>1. 这里可以补充一下constructor 的概念：
>   - `constructor 我们称为构造函数，因为它指回构造函数本身`
>   - 其作用是让某个构造函数产生的 所有实例对象（比如f） 能够找到他的构造函数（比如Fun），用法就是f.constructor
>2. 此时实例对象里没有constructor 这个属性，于是沿着原型链往上找到Fun.prototype 里的constructor，并指向Fun 函数本身
>   - constructor本就存在于原型中,指向构造函数,成为子对象后，如果该原型链中的constructor在自身没有而是在父原型中找到,所以指向父类的构造函数
>3. 由于这里的继承是直接改了构造函数的prototype 的指向，所以在 sub的原型链中，Sub.prototype 没有constructor 属性，反而是看到了一个super 实例
>4. 这就让sub 实例的constructor 无法使用了。为了他还能用，就在那个super 实例中手动加了一个constructor 属性，且指向Sub 函数看到了一个super 实例

### Ⅱ-借用构造函数继承(假的)

>方式2: 借用构造函数继承(假的)
>1. 套路:
>     - 定义父类型构造函数
>     - 定义子类型构造函数
>     - 在子类型构造函数中调用父类型构造
>2. 关键:
>     - `在子类型构造函数中通用call()调用父类型构造函数`
>3. 作用:
>   - 能借用父类中的构造方法,但是不灵活
>
>```js
>function Person(name, age) {
>  this.name = name
>  this.age = age
>}
>function Student(name, age, price) {
>   //此处利用call(),将 [Student]的this传递给Person构造函数
>  Person.call(this, name, age)  // 相当于: this.Person(name, age)
>  /*this.name = name
>  this.age = age*/
>  this.price = price
>}
>
>var s = new Student('Tom', 20, 14000)
>console.log(s.name, s.age, s.price)
>```
>
>[`Person`]中的this是动态变化的,在[`Student`]中利用[`Person.call(this, name, age)`]改变了其this指向,所以可以实现此效果

### Ⅲ-组合继承

>方式3: 原型链+借用构造函数的组合继承
>1. 利用原型链实现对父类型对象的方法继承
>2. 利用super()借用父类型构建函数初始化相同属性
>
>```js
>function Person(name, age) {
>  this.name = name
>  this.age = age
>}
>Person.prototype.setName = function (name) {
>  this.name = name
>}
>
>function Student(name, age, price) {
>  Person.call(this, name, age)  // 为了得到属性
>  this.price = price
>}
>Student.prototype = new Person() // 为了能看到父类型的方法
>Student.prototype.constructor = Student //修正constructor属性
>Student.prototype.setPrice = function (price) {
>  this.price = price
>}
>
>var s = new Student('Tom', 24, 15000)
>s.setName('Bob')
>s.setPrice(16000)
>console.log(s.name, s.age, s.price)
>```





































