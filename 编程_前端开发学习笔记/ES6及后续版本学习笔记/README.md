# #此文件为方便gitee网站观阅使用专门创建

> 此笔记文件于某一时间复制至此,容易存在更新不及时问题,建议观看同级目录下的笔记文件
>
> 由于此笔记篇幅过长,防止Gitee上点开加载时间过久,所以只截取了上方`ES全系列详细学习笔记`部分笔记的部分知识点至此,方便网站阅读概览,完整内容请看具体笔记
>
> * **ES全系列详细学习笔记** : 是所有ES系列笔记总集,也是`最全面的笔记`,第一时间也会更新至此笔记中,当然篇幅很大,十几万字!
> * **其他零散笔记**: 即目录中零散知识点笔记,相对碎片化,类似于**ES全系列详细学习笔记**的拆解,方便快速查找到相关知识点,相对而言更新没有那么具有实时性
>
> 除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[数据结构与算法](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_算法及课程基础学习笔记/数据结构与算法)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[编程_后台服务端学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记)** 、**[Java](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Java)** 、**[Nodejs](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Nodejs)** 、**[JavaScript笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记)**、**[ES6及后续版本学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记)** 、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了

------

# #说明

>本笔记是本人`ES全系统详细学习笔记`,将ES系列全部梳理一遍,包括新特性等
>
>观阅或查阅的资料:[[阮一峰的ES6文档](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记/ES6资料文档摘录)]、[[`尚硅谷Web前端ES6教程, 涵盖ES6-ES11`](https://www.bilibili.com/video/BV1uK411H7on?share_source=copy_web)]、[[`JowayYoung的1.5万字概括ES6全部特性(已更新ES2020)`](https://juejin.cn/user/2330620350432110)]
>
>笔记中每部分都会首先给出[`概括总结`],总结概括此部分知识点,然后再于下方给出`部分常用重点`知识点详解
>
>必要的预备前置知识点:  [JavaScript基础以及进阶知识点](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记) -->其中 [ 进阶 ] 笔记部分需要重点掌握

# #目录

>[TOC]

# 一、ECMAScript引出

> JS基础要会再看这个,不然容易造成基础不牢的后果,此部分`类似JS语法糖`,请相信我不会害你的
>
> 必要的预备前置知识点:  [JavaScript基础以及进阶知识点](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记) -->其中 [ 进阶 ] 笔记部分需要重点掌握

## 1、什么是 ECMA和ECMAScript

>`ECMA`（European Computer Manufacturers Association）中文名称为欧洲计算机制 造商协会, 这个组织的目标是评估、开发和认可电信和计算机标准。1994 年后该 组织改名为 Ecma 国际。
>
>`ECMAScript` 是由 Ecma 国际通过 ECMA-262 标准化的脚本程序设计语言。

## 2、ECMA-262

>Ecma 国际制定了许多标准, 而 ECMA-262 只是其中的一个, 所有标准列表查看 -->[点我传送](https://www.ecma-international.org/publications-and-standards/standards/)

### Ⅰ-ECMA-262 历史

>ECMA-262（ECMAScript）历史版本查看网址: -->[点我传送](https://www.ecma-international.org/publications-and-standards/standards/ecma-262/)
>
>|   版数    |        年份        | 内容                                                         |
>| :-------: | :----------------: | ------------------------------------------------------------ |
>|  第 1 版  |      1997 年       | 制定了语言的基本语法                                         |
>|  第 2 版  |      1998 年       | 较小改动                                                     |
>|  第 3 版  |      1999 年       | 引入正则、异常处理、格式化输出等。IE 开始支持                |
>|  第 4 版  |      2007 年       | 过于激进, 未发布                                             |
>|  第 5 版  |      2009 年       | 引入严格模式、JSON , 扩展对象、数组、原型、字符串、日期方法  |
>| `第 6 版` |     `2015 年`      | 模块化、面向对象语法、 Promise、箭头函数、let、 const、数组解构赋值等等<br />因为发布内容很多,堪称里程碑,所以我们目前通常主要学这个 |
>|  第 7 版  |      2016 年       | 幂运算符、数组扩展、 Async/await 关键字                      |
>|  第 8 版  |      2017 年       | Async/await、字符串扩展                                      |
>|  第 9 版  |      2018 年       | 对象解构赋值、正则扩展                                       |
>| 第 10 版  |      2019 年       | 扩展对象、数组方法                                           |
>|  ES.next  | 动态指向下一个版本 | `后续学到我会进行补充`                                       |
>
>`注：从 ES6 开始, 每年发布一个版本, 版本号比年份最后一位大 1`
>
>所以有些文章上提到的`ES7`(实质上是`ES2016`)、`ES8`(实质上是`ES2017`)、`ES9`(实质上是`ES2018`)、`ES10`(实质上是`ES2019`)、`ES11`(实质上是`ES2020`), 实质上都是一些不规范的概念。从ES1到ES6 , 每个标准都是花了好几年甚至十多年才制定下来, 你一个ES6到ES7 , ES7到ES8 , 才用了一年, 按照这样的定义下去, 那不是很快就ES20了。用正确的概念来说ES6目前涵盖了**ES2015**、**ES2016**、**ES2017**、**ES2018**、**ES2019**、**ES2020**。

### Ⅱ-谁在维护 ECMA-262

>TC39（Technical Committee 39）是推进 ECMAScript 发展的委员会。其会员都是公司（`其中主要是浏览器厂商`:有苹果、谷歌、微软、因特尔等）。TC39 定期 召开会议, 会议由会员公司的代表与特邀专家出席

## 3、为什么要重点学习 ES6

>* ES6 的版本变动内容最多, 具有里程碑意义
>* ES6 加入许多新的语法特性, 编程实现更简单、高效
>* ES6 是前端发展趋势, 就业必备技能
>* 实际上ES系列的知识点基本上都要掌握,才能写出逼格更高的代码:dog:

## 4、ES6 兼容性

>可以查看gitHub上的这个图-->[点我传送](http://kangax.github.io/compat-table/es6/)

# 二、ECMASript 6 新特性

> 想要查看更权威的官方ES6文档,可以看阮一峰的ES6文档,本人当初对其进行了摘录放至此处方便查阅-->**[ES6资料文档摘录](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记/ES6资料文档摘录)** 
>
> 此处ES6部分笔记主要为:`查阅的资料博客整合摘录`,加上学习ES6时笔记、个人心得体会以及在相当一段工作时间中觉得常用或者是需要重点学习的理解整合

## 1、ES6更新的内容概括

>**表达式**：声明、解构赋值
>
>**内置对象**：字符串扩展、数值扩展、对象扩展、数组扩展、函数扩展、正则扩展、Symbol、Set、Map、Proxy、Reflect
>
>**语句与运算**：Class、Module、Iterator
>
>**异步编程**：Promise、Generator、Async

## 2、let和const命令、作用域

> 注意:`不存在变量提升`
>
> `var`命令会发生“变量提升”现象, 即变量可以在声明之前使用, 值为`undefined`。这种现象多多少少是有些奇怪的, 按照一般的逻辑, 变量应该在声明语句之后才可以使用。
>
> 为了纠正这种现象, `let`、`const`命令改变了语法行为, 它所声明的变量一定要在声明后使用, 否则报错

### Ⅰ-概括与总结

>> 声明
>
>-  **const命令**：声明常量
>-  **let命令**：声明变量
>
>> 作用
>
>1. 作用域
>   - **全局作用域**
>   - **函数作用域**：`function() {}`
>   - **块级作用域**：`{}`
>2. 作用范围
>   - `var命令`在全局代码中执行
>   - `const命令`和`let命令`只能在代码块中执行
>3. 赋值使用
>   - `const命令`声明常量后必须立马赋值
>   - `let命令`声明变量后可立马赋值或使用时赋值
>4. 声明方法：`var`、`const`、`let`、`function`、`class`、`import`
>
>> 重点难点
>
>- 不允许重复声明
>- 未定义就使用会报错：`const命令`和`let命令`不存在变量提升
>- 暂时性死区：在代码块内使用`const命令`和`let命令`声明变量之前, 该变量都不可用
>
>下一节为赋值解构的概括总结  -->[点我传送](#3、赋值解构)

### Ⅱ-let关键字命令

>let 关键字用来声明变量, 使用 let 声明的变量有几个特点： 
>
>- 不允许重复声明 
>- 块级作用域 
>- 不存在变量提升 
>- 不影响作用域链
>
>应用场景：声明重复赋值的变量时可以用这个,如果你不是要求很高的话,基本上都能用let进行声明(var声明的可以都用这个替代了)

### Ⅲ-const关键字命令

>const 关键字用来声明常量 , const 声明有以下特点:
>
>- 不允许重复声明 
>- `值不允许修改`
>- 不存在变量提升 
>- 块级作用域 
>- 声明必须赋初始值
>- 标识符一般为大写
>
>注意: `对象属性修改和数组元素变化不会触发 const 错误` 
>
>> `const`实际上保证的, `并不是变量的值不得改动, 而是变量指向的那个内存地址所保存的数据不得改动`。
>>
>> 对于简单类型的数据（数值、字符串、布尔值）, 值就保存在变量指向的那个内存地址, 因此等同于常量。但对于复合类型的数据（主要是对象和数组）, 变量指向的内存地址, 保存的只是一个指向实际数据的指针, `const`只能保证这个指针是固定的（即总是指向另一个固定的地址）, 至于它指向的数据结构是不是可变的, 就完全不能控制了。因此, 将一个对象声明为常量必须非常小心。
>
>应用场景：声明对象类型、确定不会再次赋值的变量使用 const , 其他的可以用let

### Ⅳ-ES6 声明变量的六种方法

>ES5 只有两种声明变量的方法：`var`命令和`function`命令。ES6 除了添加`let`和`const`命令, 后面还会提到, 另外两种声明变量的方法：`import`命令和`class`命令。所以 , ES6 一共有 6 种声明变量的方法。

### Ⅴ-块级作用域

#### ① 为什么需要块级作用域？

>ES5 只有全局作用域和函数作用域, 没有块级作用域, 这带来很多不合理的场景。
>
>第一种场景, 内层变量可能会覆盖外层变量。
>
>```javascript
>var tmp = new Date();
>
>function f() {
>  console.log(tmp);
>  if (false) { var tmp = 'hello world'; }
>}
>
>f(); // undefined
>```
>
>上面代码的原意是, `if`代码块的外部使用外层的`tmp`变量, 内部使用内层的`tmp`变量。但是, 函数 [ `f` ] 执行后, 输出结果为`undefined`, 原因在于变量提升, 导致内层的`tmp`变量覆盖了外层的`tmp`变量。
>
>第二种场景, 用来计数的循环变量泄露为全局变量。
>
>```javascript
>var s = 'hello';
>for (var i = 0; i < s.length; i++) { console.log(s[i]);}
>console.log(i); // 5
>```
>
>上面代码中, 变量`i`只用来控制循环, 但是循环结束后, 它并没有消失, 泄露成了全局变量。

#### ② ES6 的块级作用域

>`let`实际上为 JavaScript 新增了块级作用域。
>
>```javascript
>function f1() {
>  let n = 5;
>  if (true) { let n = 10; }
>  console.log(n); // 5
>}
>```
>
>上面的函数有两个代码块, 都声明了变量`n`, 运行后输出 5。这表示外层代码块不受内层代码块的影响。如果两次都使用`var`定义变量`n`, 最后输出的值才是 10。
>
>ES6 允许块级作用域的任意嵌套。
>
>```javascript
>{{{{
>  {let insane = 'Hello World'}
>  console.log(insane); // 报错 因为外层不能取到内层数据
>}}}};
>```
>
>上面代码使用了一个五层的块级作用域, 每一层都是一个单独的作用域。`第四层作用域无法读取第五层作用域的内部变量`。
>
>内层作用域可以定义外层作用域的同名变量。
>
>```javascript
>{{{{
>  let insane = 'Hello World';
>  {let insane = 'Hello World'}
>}}}};
>```
>
>块级作用域的出现, 实际上使得获得广泛应用的匿名立即执行函数表达式（匿名 IIFE）不再必要了。-->[对于IIFE不懂的可以看本人JS进阶笔记,点我跳转](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/HTML+CSS+JS%E5%9F%BA%E7%A1%80%E7%AC%94%E8%AE%B0/JavaScript%E7%AC%94%E8%AE%B0#-%E5%B8%B8%E8%A7%81%E7%9A%84%E5%9B%9E%E8%B0%83%E5%87%BD%E6%95%B0)
>
>```javascript
>// IIFE 写法
>(function () {
>  var tmp = ...;
>  ...
>}());
>
>// 块级作用域写法
>{
>  let tmp = ...;
>  ...
>}
>```
>

#### ③ 块级作用域与函数声明

>函数能不能在块级作用域之中声明？这是一个相当令人混淆的问题。
>
>ES5 规定, 函数只能在顶层作用域和函数作用域之中声明, 不能在块级作用域声明。
>
>```javascript
>// 情况一
>if (true) {
>  function f() {}
>}
>
>// 情况二
>try {
>  function f() {}
>} catch(e) {
>  // ...
>}
>```
>
>上面两种函数声明, 根据 ES5 的规定都是非法的。
>
>但是, 浏览器没有遵守这个规定, 为了兼容以前的旧代码, 还是支持在块级作用域之中声明函数, 因此上面两种情况实际都能运行, 不会报错。
>
>ES6 引入了块级作用域, 明确允许在块级作用域之中声明函数。ES6 规定, 块级作用域之中, 函数声明语句的行为类似于`let`, 在块级作用域之外不可引用。
>
>```javascript
>function f() { console.log('I am outside!'); }
>(function () {
>     // 重复声明一次函数f
>  if (false) { function f() { console.log('I am inside!'); }}
>  f();
>}());
>```
>
>上面代码在 ES5 中运行, 会得到“I am inside!”, 因为在`if`内声明的函数 [ f ] 会被提升到函数头部, 实际运行的代码如下。
>
>```javascript
>// ES5 环境
>function f() { console.log('I am outside!'); }
>(function () {
>  function f() { console.log('I am inside!'); }
>  if (false) {}
>  f();
>}());
>```
>
>ES6 就完全不一样了, 理论上会得到“I am outside!”。因为块级作用域内声明的函数类似于`let`, 对作用域之外没有影响。但是, 如果你真的在 ES6 浏览器中运行一下上面的代码, 是会报错的, 这是为什么呢？
>
>```javascript
>// 浏览器的 ES6 环境
>function f() { console.log('I am outside!'); }
>(function () {
>     // 重复声明一次函数f
>  if (false) { function f() { console.log('I am inside!'); } }
>  f();
>}());
>// Uncaught TypeError: f is not a function
>```
>
>上面的代码在 ES6 浏览器中, 都会报错。
>
>原来, 如果改变了块级作用域内声明的函数的处理规则, 显然会对老代码产生很大影响。为了减轻因此产生的不兼容问题 , ES6 在[附录 B](http://www.ecma-international.org/ecma-262/6.0/index.html#sec-block-level-function-declarations-web-legacy-compatibility-semantics)里面规定, 浏览器的实现可以不遵守上面的规定, 有自己的[行为方式](http://stackoverflow.com/questions/31419897/what-are-the-precise-semantics-of-block-level-functions-in-es6)。
>
>- 允许在块级作用域内声明函数。
>- 函数声明类似于`var`, 即会提升到全局作用域或函数作用域的头部。
>- 同时, 函数声明还会提升到所在的块级作用域的头部。
>
>注意, 上面三条规则只对 ES6 的浏览器实现有效, 其他环境的实现不用遵守, 还是将块级作用域的函数声明当作`let`处理。
>
>根据这三条规则, 浏览器的 ES6 环境中, 块级作用域内声明的函数, 行为类似于`var`声明的变量。上面的例子实际运行的代码如下。
>
>```javascript
>// 浏览器的 ES6 环境
>function f() { console.log('I am outside!'); }
>(function () {
>  var f = undefined;
>  if (false) { function f() { console.log('I am inside!'); }}
>  f();
>}());
>// Uncaught TypeError: f is not a function
>```
>
>考虑到环境导致的行为差异太大, 应该避免在块级作用域内声明函数。如果确实需要, 也应该写成函数表达式, 而不是函数声明语句。
>
>```javascript
>// 块级作用域内部的函数声明语句, 建议不要使用
>{
>  let a = 'secret';
>  function f() {  return a; }
>}
>
>// 块级作用域内部, 优先使用函数表达式
>{
>  let a = 'secret';
>  let f = function () {
>    return a;
>  };
>}
>```
>
>另外, 还有一个需要注意的地方。ES6 的块级作用域必须有大括号, 如果没有大括号 , JavaScript 引擎就认为不存在块级作用域。
>
>```javascript
>// 第一种写法, 报错
>if (true) let x = 1;
>
>// 第二种写法, 不报错
>if (true) {
>  let x = 1;
>}
>```
>
>上面代码中, 第一种写法没有大括号, 所以不存在块级作用域, 而`let`只能出现在当前作用域的顶层, 所以报错。第二种写法有大括号, 所以块级作用域成立。
>
>函数声明也是如此, 严格模式下, 函数只能声明在当前作用域的顶层。
>
>```javascript
>// 不报错
>'use strict';
>if (true) {
>  function f() {}
>}
>
>// 报错
>'use strict';
>if (true)
>  function f() {}
>```
>



## 3、赋值解构

>ES6 允许按照一定模式, `从数组和对象中提取值, 对变量进行赋值`, 这被称为解构（Destructuring）。
>
>本质上, 这种写法属于“`模式匹配`”, 只要等号两边的模式相同, 左边的变量就会被赋予对应的值

### Ⅰ-概括总结

>1.  **字符串解构**：`const [a, b, c, d, e] = "hello"`
>2.  **数值解构**：`const { toString: s } = 123`
>3.  **布尔解构**：`const { toString: b } = true`
>4. **对象解构**
>   - 形式：`const { x, y } = { x: 1, y: 2 }`
>   - 默认：`const { x, y = 2 } = { x: 1 }`
>   - 改名：`const { x, y: z } = { x: 1, y: 2 }`
>5. **数组解构**
>   - 规则：数据结构具有`Iterator接口`可采用数组形式的解构赋值
>   - 形式：`const [x, y] = [1, 2]`
>   - 默认：`const [x, y = 2] = [1]`
>6. **函数参数解构**
>   - 数组解构：`function Func([x = 0, y = 1]) {}`
>   - 对象解构：`function Func({ x = 0, y = 1 } = {}) {}`
>
>> `应用场景` 
>
>- 交换变量值：`[x, y] = [y, x]`
>- 返回函数多个值：`const [x, y, z] = Func()`
>- 定义函数参数：`Func([1, 2])`
>- 提取JSON数据：`const { name, version } = packageJson`
>- 定义函数参数默认值：`function Func({ x = 1, y = 2 } = {}) {}`
>- 遍历Map结构：`for (let [k, v] of Map) {}`
>- 输入模块指定属性和方法：`const { readFile, writeFile } = require("fs")`
>
>>  ** `重点难点` **
>
>- 匹配模式：只要等号两边的模式相同, 左边的变量就会被赋予对应的值
>- 解构赋值规则：只要等号右边的值不是对象或数组, 就先将其转为对象
>- 解构默认值生效条件：属性值严格等于`undefined`
>- 解构遵循匹配模式
>- 解构不成功时变量的值等于`undefined`
>- `undefined`和`null`无法转为对象, 因此无法进行解构
>
>下一节为字符串的拓展概括  -->[点我传送](#4、字符串的拓展)

### Ⅱ-基本用法

#### ① 基本用法举例

>以前, 为变量赋值, 只能直接指定值。
>
>```javascript
>let a = 1;
>let b = 2;
>let c = 3;
>```
>
>ES6 允许写成下面这样。
>
>```javascript
>let [a, b, c] = [1, 2, 3];
>```
>
>上面代码表示, 可以从数组中提取值, 按照对应位置, 对变量赋值。
>
>本质上, 这种写法属于“模式匹配”, 只要等号两边的模式相同, 左边的变量就会被赋予对应的值。下面是一些使用嵌套数组进行解构的例子。
>
>```javascript
>let [foo, [[bar], baz]] = [1, [[2], 3]];//foo : 1 bar : 2 baz : 3
>
>let [ , , third] = ["foo", "bar", "baz"];//third : "baz"
>
>let [x, , y] = [1, 2, 3];//x : 1 y : 3
>
>let [head, ...tail] = [1, 2, 3, 4];//head : 1 tail : [2, 3, 4]
>
>let [x, y, ...z] = ['a'];//x : "a" y : undefined z : []
>```
>
>如果解构不成功, 变量的值就等于`undefined`。
>
>```javascript
>let [foo] = [];
>let [bar, foo] = [1];
>```
>
>以上两种情况都属于解构不成功, `foo`的值都会等于`undefined`。
>
>另一种情况是不完全解构, 即等号左边的模式, 只匹配一部分的等号右边的数组。这种情况下, 解构依然可以成功。
>
>```javascript
>let [x, y] = [1, 2, 3];//x : 1  y : 2 
>let [a, [b], d] = [1, [2, 3], 4];//a : 1 b : 2 d : 4
>```
>
>上面两个例子, 都属于不完全解构, 但是可以成功。
>
>如果等号的右边不是数组（或者严格地说, 不是可遍历的结构, 参见《Iterator》一章）, 那么将会报错。
>
>```javascript
>// 报错
>let [foo] = 1;
>let [foo] = false;
>let [foo] = NaN;
>let [foo] = undefined;
>let [foo] = null;
>let [foo] = {};
>```
>
>上面的语句都会报错, 因为等号右边的值, 要么转为对象以后不具备 Iterator 接口（前五个表达式）, 要么本身就不具备 Iterator 接口（最后一个表达式）。
>
>`对于 Set 结构, 也可以使用数组的解构赋值`。
>
>```javascript
>let [x, y, z] = new Set(['a', 'b', 'c']);
>x // "a"
>```
>
>事实上, 只要某种数据结构具有 Iterator 接口, 都可以采用数组形式的解构赋值。
>
>```javascript
>function* fibs() {
>  let a = 0;
>  let b = 1;
>  while (true) {
>    yield a;
>    [a, b] = [b, a + b];
>  }
>}
>
>let [first, second, third, fourth, fifth, sixth] = fibs();
>sixth // 5
>```
>
>上面代码中, `fibs`是一个 Generator 函数（详见《Generator 函数》）, 原生具有 Iterator 接口。解构赋值会依次从这个接口获取值。

#### ② 默认值

>解构赋值允许指定默认值。
>
>```javascript
>let [foo = true] = [];//foo = true
>let [x, y = 'b'] = ['a']; // x='a', y='b'
>let [x, y = 'b'] = ['a', undefined]; // x='a', y='b'
>```
>
>注意 , ES6 内部使用严格相等运算符（`===`）, 判断一个位置是否有值。所以, 只有当一个数组成员严格等于`undefined`, 默认值才会生效。
>
>```javascript
>let [x = 1] = [undefined];//x = 1
>let [x = 1] = [null];//x = null
>```
>
>上面代码中, 如果一个数组成员是`null`, 默认值就不会生效, 因为`null`不严格等于`undefined`。
>
>如果默认值是一个表达式, 那么这个表达式是惰性求值的, 即只有在用到的时候, 才会求值。
>
>```javascript
>function f() { console.log('aaa');}
>let [x = f()] = [1];
>```
>
>上面代码中, 因为`x`能取到值, 所以函数 [ f ] 根本不会执行。上面的代码其实等价于下面的代码。
>
>```javascript
>let x;
>if ([1] === undefined) { x = f()} 
>else { x = [1]; }
>```
>
>默认值可以引用解构赋值的其他变量, 但该变量必须已经声明。
>
>```javascript
>let [x = 1, y = x] = [];     // x=1; y=1
>let [x = 1, y = x] = [2];    // x=2; y=2
>let [x = 1, y = x] = [1, 2]; // x=1; y=2
>let [x = y, y = 1] = [];     // ReferenceError: y is not defined
>```
>
>上面最后一个表达式之所以会报错, 是因为`x`用`y`做默认值时, `y`还没有声明。

#### ③ ES6小知识点:`连续赋值解构`+重命名

>此写法也是本人常用写法,挺好用的
>
>```js
>let obj = {a:{b:1}}
>const {a} = obj; //传统解构赋值
>const {a:{b}} = obj; //连续解构赋值
>const {a:{b:value}} = obj; //连续解构赋值+重命名
>```

### Ⅲ-对象的赋值解构

> `此处应用的非常多`,需要多查阅

#### ① 基本用法

>解构不仅可以用于数组, 还可以用于对象。
>
>```javascript
>let { foo, bar } = { foo: 'aaa', bar: 'bbb' };//foo = "aaa"; bar = "bbb"
>```
>
>对象的解构与数组有一个重要的不同。`数组的元素是按次序排列的, 变量的取值由它的位置决定；而对象的属性没有次序, 变量必须与属性同名, 才能取到正确的值`
>
>```javascript
>let { bar, foo } = { foo: 'aaa', bar: 'bbb' };//foo = "aaa" ; bar = "bbb"
>let { baz } = { foo: 'aaa', bar: 'bbb' };//baz = undefined
>```
>
>上面代码的第一个例子, 等号左边的两个变量的次序, 与等号右边两个同名属性的次序不一致, 但是对取值完全没有影响。第二个例子的变量没有对应的同名属性, 导致取不到值, 最后等于`undefined`。
>
>如果解构失败, 变量的值等于`undefined`。
>
>```javascript
>let {foo} = {bar: 'baz'};//foo = undefined
>```
>
>上面代码中, 等号右边的对象没有`foo`属性, 所以变量`foo`取不到值, 所以等于`undefined`。
>
>对象的解构赋值, 可以很方便地将现有对象的方法, 赋值到某个变量。
>
>```javascript
>// 例一
>let { log, sin, cos } = Math;
>// 例二
>const { log } = console;
>log('hello') // hello
>```
>
>上面代码的例一将`Math`对象的对数、正弦、余弦三个方法, 赋值到对应的变量上, 使用起来就会方便很多。例二将`console.log`赋值到`log`变量。
>
>如果变量名与属性名不一致, 必须写成下面这样-->`取别名`
>
>```javascript
>let { foo: baz } = { foo: 'aaa', bar: 'bbb' };//baz = "aaa"
>
>let obj = { first: 'hello', last: 'world' };
>let { first: f, last: l } = obj;//f = 'hello' ; l = 'world'
>```
>
>这实际上说明, 对象的解构赋值是下面形式的简写（详见《对象的扩展》）。
>
>```javascript
>let { foo: foo, bar: bar } = { foo: 'aaa', bar: 'bbb' };
>```
>
>也就是说, 对象的解构赋值的内部机制, 是先找到同名属性, 然后再赋给对应的变量。真正被赋值的是后者, 而不是前者。
>
>```javascript
>let { foo: baz } = { foo: 'aaa', bar: 'bbb' };
>//baz = "aaa";
>//foo = error: foo is not defined
>```
>
>上面代码中, `foo`是匹配的模式, `baz`才是变量。真正被赋值的是变量`baz`, 而不是模式`foo`。
>
>与数组一样, 解构也可以用于嵌套结构的对象。
>
>```javascript
>let obj = {
>  p: ['Hello', { y: 'World' }]
>};
>
>let { p: [x, { y }] } = obj;
>//x == "Hello"
>//y == "World"
>```
>
>注意, 这时`p`是模式, 不是变量, 因此不会被赋值。如果`p`也要作为变量赋值, 可以写成下面这样。
>
>```javascript
>let obj = {
>  p: [ 'Hello', { y: 'World' }]
>};
>
>let { p, p: [x, { y }] } = obj;
>//x == "Hello"
>//y == "World"
>//p == ["Hello", {y: "World"}]
>```
>
>下面是另一个例子。
>
>```javascript
>const node = {
>  loc: { 
>      start: { line: 1, column: 5 }
>  }
>};
>
>let { loc, loc: { start }, loc: { start: { line }} } = node;
>//line == 1
>//loc  == Object {start: Object}
>//start == Object {line: 1, column: 5}
>```
>
>上面代码有三次解构赋值, 分别是对`loc`、`start`、`line`三个属性的解构赋值。注意, 最后一次对`line`属性的解构赋值之中, 只有`line`是变量, `loc`和`start`都是模式, 不是变量。
>
>下面是嵌套赋值的例子。-->`注意:外部包着一层()`:
>
>```javascript
>let obj = {};
>let arr = [];
>({ foo: obj.prop, bar: arr[0] } = { foo: 123, bar: true });
>//因为 JavaScript 引擎会将`{x}`理解成一个代码块, 从而发生语法错误。`只有不将大括号写在行首`, 避免 JavaScript 将其解释为代码块, 才能解决这个问题。
>//obj == {prop:123}
>//arr == [true]
>```
>
>如果解构模式是嵌套的对象, 而且子对象所在的父属性不存在, 那么将会报错。
>
>```javascript
>// 报错
>let {foo: {bar}} = {baz: 'baz'};
>```
>
>上面代码中, 等号左边对象的`foo`属性, 对应一个子对象。该子对象的`bar`属性, 解构时会报错。原因很简单, 因为`foo`这时等于`undefined`, 再取子属性就会报错。
>
>注意, 对象的解构赋值可以取到继承的属性。
>
>```javascript
>const obj1 = {};
>const obj2 = { foo: 'bar' };
>Object.setPrototypeOf(obj1, obj2);//Object.setPrototypeOf() 方法设置一个指定的对象的原型 ( 即, 内部[[Prototype]]属性）到另一个对象或  null
>const { foo } = obj1;
>foo // "bar"
>```
>
>上面代码中, 对象`obj1`的原型对象是`obj2`。`foo`属性不是`obj1`自身的属性, 而是继承自`obj2`的属性, 解构赋值可以取到这个属性。
>
>注:`Object.setPrototypeOf()`详解,不知道此方法的同学们看这里 -->[点我传送](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/setPrototypeOf)

#### ② 默认值

>对象的解构也可以指定默认值。
>
>```javascript
>var {x = 3} = {};//x == 3
>var {x, y = 5} = {x: 1};
>//x == 1
>//y == 5
>var {x: y = 3} = {};//y == 3
>var {x: y = 3} = {x: 5};//y == 5
>var { message: msg = 'Something went wrong' } = {};//msg == "Something went wrong"
>```
>
>默认值生效的条件是, 对象的属性值严格等于`undefined`。
>
>```javascript
>var {x = 3} = {x: undefined};//x == 3
>var {x = 3} = {x: null};//x == null
>```
>
>上面代码中, 属性`x`等于`null`, 因为`null`与`undefined`不严格相等, 所以是个有效的赋值, 导致默认值`3`不会生效。-->[原因上面讲过](#② 默认值)

#### ③ 注意点

>（1）如果要将一个已经声明的变量用于解构赋值, 必须非常小心。
>
>```javascript
>// 错误的写法
>let x;
>{x} = {x: 1};
>// SyntaxError: syntax error
>```
>
>上面代码的写法会报错, 因为 JavaScript 引擎会将`{x}`理解成一个代码块, 从而发生语法错误。`只有不将大括号写在行首`, 避免 JavaScript 将其解释为代码块, 才能解决这个问题。
>
>```javascript
>// 正确的写法
>let x;
>({x} = {x: 1});
>```
>
>上面代码将整个解构赋值语句, `放在一个圆括号里面, 就可以正确执行`。关于圆括号与解构赋值的关系, 参见下文。
>
>（2）解构赋值允许等号左边的模式之中, 不放置任何变量名。因此, 可以写出非常古怪的赋值表达式。
>
>```javascript
>({} = [true, false]);
>({} = 'abc');
>({} = []);
>```
>
>上面的表达式虽然毫无意义, 但是语法是合法的, 可以执行。
>
>（3）`由于数组本质是特殊的对象, 因此可以对数组进行对象属性的解构`。
>
>```javascript
>let arr = [1, 2, 3];
>let {0 : first, [arr.length - 1] : last} = arr;
>//first == 1
>//last == 3
>```
>
>上面代码对数组进行对象解构。数组`arr`的`0`键对应的值是`1`, `[arr.length - 1]`就是`2`键, 对应的值是`3`。方括号这种写法, 属于“属性名表达式”（详见《对象的扩展》）。

### Ⅳ-字符串的赋值结构

>字符串也可以解构赋值。这是因为此时, 字符串被转换成了一个类似数组的对象。
>
>```javascript
>const [a, b, c, d, e] = 'hello';
>//a == "h" ;b  == "e" ; c == "l" ; d == "l" ;e == "o"
>```
>
>类似数组的对象都有一个`length`属性, 因此还可以对这个属性解构赋值。
>
>```javascript
>let {length : len} = 'hello';//len == 5
>```
>

### Ⅴ-数值和布尔值的解构赋值

>解构赋值时, 如果等号右边是数值和布尔值, 则会先转为对象。
>
>```javascript
>let {toString: s} = 123;
>s === Number.prototype.toString // true
>
>let {toString: s} = true;
>s === Boolean.prototype.toString // true
>```
>
>上面代码中, 数值和布尔值的包装对象都有`toString`属性, 因此变量`s`都能取到值。
>
>解构赋值的规则是, 只要等号右边的值不是对象或数组, 就先将其转为对象。由于`undefined`和`null`无法转为对象, 所以对它们进行解构赋值, 都会报错。
>
>```javascript
>let { prop: x } = undefined; // TypeError
>let { prop: y } = null; // TypeError
>```
>


### Ⅵ-函数参数的解构赋值

>函数的参数也可以使用解构赋值。
>
>```javascript
>function add([x, y]){ return x + y; }
>add([1, 2]); // 3
>```
>
>上面代码中, 函数`add`的参数表面上是一个数组, 但在传入参数的那一刻, 数组参数就被解构成变量`x`和`y`。对于函数内部的代码来说, 它们能感受到的参数就是`x`和`y`。
>
>下面是另一个例子。
>
>```javascript
>[[1, 2], [3, 4]].map(([a, b]) => a + b);
>// [ 3, 7 ]
>```
>
>函数参数的解构也可以使用默认值。
>
>```javascript
>function move({x = 0, y = 0} = {}) {  return [x, y];}
>move({x: 3, y: 8}); // [3, 8]
>move({x: 3}); // [3, 0]
>move({}); // [0, 0]
>move(); // [0, 0]
>```
>
>上面代码中, 函数`move`的参数是一个对象, 通过对这个对象进行解构, 得到变量`x`和`y`的值。如果解构失败, `x`和`y`等于默认值。
>
>注意, 下面的写法会得到不一样的结果。
>
>```javascript
>function move({x, y} = { x: 0, y: 0 }) {
>return [x, y];
>}
>
>move({x: 3, y: 8}); // [3, 8]
>move({x: 3}); // [3, undefined]
>move({}); // [undefined, undefined]
>move(); // [0, 0]
>```
>
>上面代码是为函数`move`的参数指定默认值, 而不是为变量`x`和`y`指定默认值, 所以会得到与前一种写法不同的结果。
>
>`undefined`就会触发函数参数的默认值。
>
>```javascript
>[1, undefined, 3].map((x = 'yes') => x);
>// [ 1, 'yes', 3 ]
>```
>

### Ⅶ-圆括号问题

>解构赋值虽然很方便, 但是解析起来并不容易。对于编译器来说, `一个式子到底是模式, 还是表达式`, 没有办法从一开始就知道, 必须解析到（或解析不到）等号才能知道。
>
>由此带来的问题是, 如果模式中出现圆括号怎么处理。ES6 的规则是, 只要有可能导致解构的歧义, 就不得使用圆括号。
>
>但是, 这条规则实际上不那么容易辨别, 处理起来相当麻烦。因此, 建议只要有可能, 就不要在模式中放置圆括号。

#### ① 不能使用圆括号的情况

>以下三种解构赋值不得使用圆括号。
>
>（1）`变量声明`语句
>
>```javascript
>// 全部报错
>let [(a)] = [1];
>let {x: (c)} = {};
>let ({x: c}) = {};
>let {(x: c)} = {};
>let {(x): c} = {};
>let { o: ({ p: p }) } = { o: { p: 2 } };
>```
>
>上面 6 个语句都会报错, `因为它们都是变量声明语句`, 模式不能使用圆括号。
>
>（2）函数参数
>
>函数参数也属于变量声明, 因此不能带有圆括号。
>
>```javascript
>// 报错
>function f([(z)]) { return z; }
>// 报错
>function f([z,(x)]) { return x; }
>```
>
>（3）赋值语句的模式
>
>```javascript
>// 全部报错
>({ p: a }) = { p: 42 };
>([a]) = [5];
>```
>
>上面代码将整个模式放在圆括号之中, 导致报错。
>
>```javascript
>// 报错
>[({ p: a }), { x: c }] = [{}, {}];
>```
>
>上面代码将一部分模式放在圆括号之中, 导致报错。

#### ② 可以使用圆括号的情况

>可以使用圆括号的情况只有一种：赋值语句的非模式部分, 可以使用圆括号。
>
>```javascript
>[(b)] = [3]; // 正确
>({ p: (d) } = {}); // 正确
>[(parseInt.prop)] = [3]; // 正确
>```
>
>上面三行语句都可以正确执行, 因为`首先它们都是赋值语句, 而不是声明语句`；其次它们的圆括号都不属于模式的一部分。第一行语句中, 模式是取数组的第一个成员, 跟圆括号无关；第二行语句中, 模式是`p`, 而不是`d`；第三行语句与第一行语句的性质一致。

### Ⅷ-具体应用场景举例

>变量的解构赋值用途很多

#### ① 交换变量的值

>```javascript
>let x = 1;
>let y = 2;
>[x, y] = [y, x];
>```
>
>上面代码交换变量`x`和`y`的值, 这样的写法不仅简洁, 而且易读, 语义非常清晰。

#### ② 从函数返回多个值

>函数只能返回一个值, 如果要返回多个值, 只能将它们放在数组或对象里返回。有了解构赋值, 取出这些值就非常方便。
>
>```javascript
>// 返回一个数组
>function example() {  return [1, 2, 3]; }
>let [a, b, c] = example();
>
>// 返回一个对象
>function example() {
>  return { foo: 1,bar: 2};
>}
>let { foo, bar } = example();
>```
>

#### ③ 函数参数的定义

>解构赋值可以方便地将一组参数与变量名对应起来。
>
>```javascript
>// 参数是一组有次序的值
>function f([x, y, z]) { ... }
>f([1, 2, 3]);
>
>// 参数是一组无次序的值
>function f({x, y, z}) { ... }
>f({z: 3, y: 2, x: 1});
>```
>

#### ④  提取 JSON 数据

>解构赋值对提取 JSON 对象中的数据, 尤其有用。
>
>```javascript
>let jsonData = {
>  id: 42,
>  status: "OK",
>  data: [867, 5309]
>};
>let { id, status, data: number } = jsonData;
>console.log(id, status, number);
>// 42, "OK", [867, 5309]
>```
>
>上面代码可以快速提取 JSON 数据的值。

#### ⑤  函数参数的默认值

>```javascript
>jQuery.ajax = function (url, {
>  async = true,
>  beforeSend = function () {},
>  cache = true,
>  complete = function () {},
>  crossDomain = false,
>  global = true,
>  // ... more config
>} = {}) {
>  // ... do stuff
>};
>```
>
>指定参数的默认值, 就避免了在函数体内部再写`var foo = config.foo || 'default foo';`这样的语句。

#### ⑥ 遍历 Map 结构

>任何部署了 Iterator 接口的对象, 都可以用`for...of`循环遍历。Map 结构原生支持 Iterator 接口, 配合变量的解构赋值, 获取键名和键值就非常方便。
>
>```javascript
>const map = new Map();
>map.set('first', 'hello');
>map.set('second', 'world');
>
>for (let [key, value] of map) {
>  console.log(key + " is " + value);
>}
>// first is hello
>// second is world
>```
>
>如果只想获取键名, 或者只想获取键值, 可以写成下面这样。
>
>```javascript
>// 获取键名
>for (let [key] of map) {
>  // ...
>}
>// 获取键值
>for (let [,value] of map) {
>  // ...
>}
>```
>

#### ⑦ 输入模块的指定方法

>加载模块时, 往往需要指定输入哪些方法。解构赋值使得输入语句非常清晰。
>
>```javascript
>const { SourceMapConsumer, SourceNode } = require("source-map");
>```

## 4、字符串的拓展

### Ⅰ-概括总结

>-  **Unicode表示法**：`大括号包含`表示Unicode字符(`\u{0xXX}`或`\u{0XXX}`)
>-  **字符串遍历**：可通过`for-of`遍历字符串
>-  **字符串模板**：可单行可多行可插入变量的增强版字符串
>-  **标签模板**：函数参数的特殊调用
>-  **String.raw()**：返回把字符串所有变量替换且对斜杠进行转义的结果
>-  **String.fromCodePoint()**：返回码点对应字符
>-  **codePointAt()**：返回字符对应码点(`String.fromCodePoint()`的逆操作)
>-  **normalize()**：把字符的不同表示方法统一为同样形式, 返回`新字符串`(Unicode正规化)
>-  **repeat()**：把字符串重复n次, 返回`新字符串`
>-  **matchAll()**：返回正则表达式在字符串的所有匹配
>-  **includes()**：是否存在指定字符串
>-  **startsWith()**：是否存在字符串头部指定字符串
>-  **endsWith()**：是否存在字符串尾部指定字符串
>
>- 以上扩展方法均可作用于由`4个字节储存`的`Unicode字符`上

### Ⅱ-模板字符串

> 模板字符串（template string）是增强版的字符串, 用反引号[ `  ]标识。它可以当作普通字符串使用, 也可以用来定义多行字符串, 或者在字符串中嵌入变量。
>
> 嵌入变量使用[`${变量名}`]:如果大括号中的值不是字符串, 将按照一般的规则转为字符串。比如, 大括号中是一个对象, 将默认调用对象的`toString`方法。如果大括号内部是一个字符串, 将会原样输出。

#### ① 字符串中可以出现换行符

>字符串中可以出现换行符:如果使用模板字符串表示多行字符串, 所有的空格和缩进都会被保留在输出之中。
>
>```js
>//代码中, 所有模板字符串的空格和换行, 都是被保留的, 比如`<ul>`标签前面会有一个换行。如果你不想要这个换行, 可以使用`trim`方法消除它。
>$('#list').html(`
><ul>
>  <li>first</li>
>  <li>second</li>
></ul>
>`.trim());
>```

#### ② 可以使用 ${xxx} 形式输出变量

>```js
>function authorize(user, action) {
>  if (!user.hasPrivilege(action)) {
>    throw new Error(
>      // 传统写法为
>      // 'User '
>      // + user.name
>      // + ' is not authorized to do '
>      // + action
>      // + '.'
>      `User ${user.name} is not authorized to do ${action}.`);
>  }
>}
>```

#### ③ 大括号内部可以放入任意的 JavaScript 表达式

>括号内部可以放入任意的 JavaScript 表达式, 可以进行运算, 以及引用对象属性。
>
>```js
>let x = 1;
>let y = 2;
>`${x} + ${y} = ${x + y}`// "1 + 2 = 3"
>`${x} + ${y * 2} = ${x + y * 2}`// "1 + 4 = 5"
>let obj = {x: 1, y: 2};
>`${obj.x + obj.y}`// "3"
>```

#### ④ 模板字符串之中还能调用函数。

>```js
>function fn() {  return "Hello World";}
>`foo ${fn()} bar`
>// foo Hello World bar
>```

#### ⑤ 字符串嵌套

>```js
>const tmpl = addrs => `
>  <table>
>  ${addrs.map(addr => `
>    <tr><td>${addr.first}</td></tr>
>    <tr><td>${addr.last}</td></tr>
>  `).join('')}
>  </table>
>`;
>```
>
>上面代码中, 模板字符串的变量之中, 又嵌入了另一个模板字符串, 使用方法如下。
>
>```javascript
>const data = [
>    { first: '<Jane>', last: 'Bond' },
>    { first: 'Lars', last: '<Croft>' },
>];
>console.log(tmpl(data));
>/**下面是打印结果
><table>
>   <tr><td><Jane></td></tr>
>  <tr><td>Bond</td></tr>
>
>   <tr><td>Lars</td></tr>
>   <tr><td><Croft></td></tr>
>
></table>
>*/
>```
>
>如果需要引用模板字符串本身, 在需要时执行, 可以写成函数。
>
>```javascript
>let func = (name) => `Hello ${name}!`;
>func('Jack') // "Hello Jack!"
>```
>
>上面代码中, 模板字符串写成了一个函数的返回值。执行这个函数, 就相当于执行这个模板字符串了。

### Ⅲ-标签模板

> 模板字符串的功能, 不仅仅是上面这些。它可以紧跟在一个函数名后面, 该函数将被调用来处理这个模板字符串。这被称为“`标签模板`”功能（tagged template`）。  -->反正我是很少用到,可阅读性较差
>
> ```js
> alert`hello`
> // 等同于
> alert(['hello'])
> ```

#### ① 简单实例

>标签模板其实不是模板, 而是函数调用的一种特殊形式。`[标签]指的就是函数`, 紧跟在后面的模板字符串就是它的参数。
>
>但是, 如果模板字符里面有变量, 就不是简单的调用了, 而是会将模板字符串先处理成多个参数, 再调用函数。
>
>```javascript
>let a = 5;
>let b = 10;
>
>tag`Hello ${ a + b } world ${ a * b }`;
>// 等同于
>tag(['Hello ', ' world ',  ' '  ], 15, 50);
>```
>
>上面代码中, 模板字符串前面有一个标识名`tag`, 它是一个函数。整个表达式的返回值, 就是`tag`函数处理模板字符串后的返回值。
>
>函数`tag`依次会接收到多个参数。
>
>```javascript
>function tag(stringArr, value1, value2){
>  // ...
>}
>// 等同于
>function tag(stringArr, ...values){
>  // ...
>}
>```
>
>`tag`函数的第一个参数是一个数组, `该数组的成员是模板字符串中那些没有变量替换的部分`, 也就是说, 变量替换只发生在数组的第一个成员与第二个成员之间、第二个成员与第三个成员之间, 以此类推。
>
>`tag`函数的其他参数, 都是模板字符串各个变量被替换后的值。由于本例中, 模板字符串含有两个变量, 因此`tag`会接受到`value1`和`value2`两个参数。
>
>`tag`函数所有参数的实际值如下。
>
>- 第一个参数：`['Hello ', ' world ', '']`
>- 第二个参数: 15
>- 第三个参数：50
>
>也就是说, `tag`函数实际上以下面的形式调用。
>
>```javascript
>tag(['Hello ', ' world ', ''], 15, 50)
>```
>
>我们可以按照需要编写`tag`函数的代码。下面是`tag`函数的一种写法, 以及运行结果。
>
>```javascript
>let a = 5;
>let b = 10;
>
>function tag(s, v1, v2) {
>  console.log(s[0]);
>  console.log(s[1]);
>  console.log(s[2]);
>  console.log(v1);
>  console.log(v2);
>
>  return "OK";
>}
>
>tag`Hello ${ a + b } world ${ a * b}`;
>// "Hello "
>// " world "
>// ""
>// 15
>// 50
>// "OK"
>```
>

#### ② 稍微复杂的栗子

>```javascript
>let total = 30;
>let msg = passthru`The total is ${total} (${total*1.05} with tax)`;
>
>function passthru(literals) {
>  let result = '';
>  let i = 0;
>while (i < literals.length) {
>  result += literals[i++];
>    if (i < arguments.length) {
>     result += arguments[i];
>     }
>    }
>  return result;
>}
>  
>msg // "The total is 30 (31.5 with tax)"
>```
>
>上面这个例子展示了, 如何将各个参数按照原来的位置拼合回去。
>
>`passthru`函数采用 rest 参数的写法如下。
>
>```javascript
>function passthru(literals, ...values) {
>let output = "";
>let index;
>  for (index = 0; index < values.length; index++) {
>  output += literals[index] + values[index];
>  }
>    output += literals[index]
>  return output;
>}
>  ```
>  
>“标签模板”的一个重要应用, 就是过滤 HTML 字符串, 防止用户输入恶意内容。
>
>```javascript
>let message =
>SaferHTML`<p>${sender} has sent you a message.</p>`;
>
>function SaferHTML(templateData) {
>  let s = templateData[0];
>for (let i = 1; i < arguments.length; i++) {
>let arg = String(arguments[i]);
>  
>  // Escape special characters in the substitution.
>    s += arg.replace(/&/g, "&amp;")
>       .replace(/</g, "&lt;")
>           .replace(/>/g, "&gt;");
>    
>     // Don't escape special characters in the template.
>     s += templateData[i];
>}
>    return s;
>    }
>  ```
>  
>上面代码中, `sender`变量往往是用户提供的, 经过`SaferHTML`函数处理, 里面的特殊字符都会被转义。
>
>```js
>let sender = '<script>alert("abc")</script>'; // 恶意代码
>let message = SaferHTML`<p>${sender} has sent you a message.</p>`;
>
>message
>// <p>&lt;script&gt;alert("abc")&lt;/script&gt; has sent you a message.</p>
>```

#### ③ 用作多语言转换（国际化处理）

>标签模板的另一个应用, 就是多语言转换（国际化处理）。
>
>```javascript
>i18n`Welcome to ${siteName}, you are visitor number ${visitorNumber}!`
>// "欢迎访问xxx , 您是第xxxx位访问者！"
>```
>
>模板字符串本身并不能取代 Mustache 之类的模板库, 因为没有条件判断和循环处理功能, 但是通过标签函数, 你可以自己添加这些功能。
>
>```javascript
>// 下面的hashTemplate函数
>// 是一个自定义的模板处理函数
>let libraryHtml = hashTemplate`
>  <ul>
>    #for book in ${myBooks}
>      <li><i>#{book.title}</i> by #{book.author}</li>
>    #end
>  </ul>
>`;
>```
>
>除此之外, 你甚至可以使用标签模板, 在 JavaScript 语言之中嵌入其他语言。
>
>```javascript
>jsx`
>  <div>
>    <input
>      ref='input'
>      onChange='${this.handleChange}'
>      defaultValue='${this.state.value}' />
>      ${this.state.value}
>   </div>
>`
>```
>
>上面的代码通过`jsx`函数, 将一个 DOM 字符串转为 React 对象。
>
>下面则是一个假想的例子, 通过`java`函数, 在 JavaScript 代码之中运行 Java 代码。
>
>```javascript
>java`
>class HelloWorldApp {
>  public static void main(String[] args) {
>    System.out.println("Hello World!"); // Display the string.
>  }
>}
>`
>HelloWorldApp.main();
>```
>
>模板处理函数的第一个参数（模板字符串数组）, 还有一个`raw`属性。
>
>```javascript
>console.log`123`
>// ["123", raw: Array[1]]
>```
>
>上面代码中, `console.log`接受的参数, 实际上是一个数组。该数组有一个`raw`属性, 保存的是转义后的原字符串。
>
>请看下面的例子。
>
>```javascript
>tag`First line\nSecond line`
>
>function tag(strings) {
>  console.log(strings.raw[0]);
>  // strings.raw[0] 为 "First line\\nSecond line"
>  // 打印输出 "First line\nSecond line"
>}
>```
>
>上面代码中, `tag`函数的第一个参数`strings`, 有一个`raw`属性, 也指向一个数组。该数组的成员与`strings`数组完全一致。比如, `strings`数组是`["First line\nSecond line"]`, 那么`strings.raw`数组就是`["First line\\nSecond line"]`。两者唯一的区别, 就是字符串里面的斜杠都被转义了。比如 , strings.raw 数组会将`\n`视为`\\`和`n`两个字符, 而不是换行符。这是为了方便取得转义之前的原始模板而设计的。

# `更多笔记看上方对应具体知识点笔记`

> ES系列笔记过大,防止gitee网站上进入加载时间过长,只截取小部分,建议下载后阅读,本笔记完整版本应接近8W字
