# #此文件为方便gitee网站观阅使用专门创建

> 此笔记文件于某一时间复制至此,容易存在更新不及时问题,建议观看同级目录下的笔记文件
>
> 由于此笔记篇幅过长,防止Gitee上点开加载时间过久,所以只截取了上方`ES6-ES11系统学习笔记`部分笔记的部分知识点至此,方便网站阅读概览,完整内容请看具体笔记

------

# #说明

>本笔记是本人`ES6-ES11系统学习笔记`,将ES系列全部梳理一遍,包括新特性等
>
>观阅或查阅的资料:[[阮一峰的ES6文档](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记/ES6资料文档摘录)]、[[`尚硅谷Web前端ES6教程, 涵盖ES6-ES11`](https://www.bilibili.com/video/BV1uK411H7on?share_source=copy_web)]、[[`JowayYoung的1.5万字概括ES6全部特性(已更新ES2020)`](https://juejin.cn/user/2330620350432110)]
>
>笔记中每部分都会首先给出[`概括总结`],总结概括此部分知识点,然后再于下方给出`部分常用重点`知识点详解
>
>必要的预备前置知识点:  [JavaScript基础以及进阶知识点](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记) -->其中 [ 进阶 ] 笔记部分需要重点掌握
>
>除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、 **[ReactHooks笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ReactHooks笔记)** 、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了

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

## 5、数值的拓展

### Ⅰ- 概括总结

> **二进制表示法**：`0b或0B开头`表示二进制(`0bXX`或`0BXX`)
>
> **八进制表示法**：`0o或0O开头`表示二进制(`0oXX`或`0OXX`)
>
>**指数运算符**:其实这是`ES2016` 新增的 ,指数运算符（`**`）。 -->详见下方
>
> **Number.EPSILON**：数值最小精度
>
> **Number.MIN_SAFE_INTEGER**：最小安全数值(`-2^53`)
>
> **Number.MAX_SAFE_INTEGER**：最大安全数值(`2^53`)
>
> **Number.parseInt()**：返回转换值的整数部分
>
> **Number.parseFloat()**：返回转换值的浮点数部分
>
> **Number.isFinite()**：是否为有限数值
>
> **Number.isNaN()**：是否为NaN
>
> **Number.isInteger()**：是否为整数
>
> **Number.isSafeInteger()**：是否在数值安全范围内
>
> **Math.trunc()**：返回数值整数部分
>
> **Math.sign()**：返回数值类型(`正数1`、`负数-1`、`零0`)
>
> **Math.cbrt()**：返回数值立方根
>
> **Math.clz32()**：返回数值的32位无符号整数形式
>
> **Math.imul()**：返回两个数值相乘
>
> **Math.fround()**：返回数值的32位单精度浮点数形式
>
> **Math.hypot()**：返回所有数值平方和的平方根
>
> **Math.expm1()**：返回`e^n - 1`
>
> **Math.log1p()**：返回`1 + n`的自然对数(`Math.log(1 + n)`)
>
> **Math.log10()**：返回以10为底的n的对数
>
> **Math.log2()**：返回以2为底的n的对数
>
> **Math.sinh()**：返回n的双曲正弦
>
> **Math.cosh()**：返回n的双曲余弦
>
> **Math.tanh()**：返回n的双曲正切
>
> **Math.asinh()**：返回n的反双曲正弦
>
> **Math.acosh()**：返回n的反双曲余弦
>
> **Math.atanh()**：返回n的反双曲正切

### Ⅱ - 指数运算符

>ES2016 新增了一个指数运算符（`**`）。
>
>```javascript
>2 ** 2 // 4
>2 ** 3 // 8
>```
>
>这个运算符的一个特点是右结合, 而不是常见的左结合。多个指数运算符连用时, 是从最右边开始计算的。
>
>```javascript
>// 相当于 2 ** (3 ** 2)
>2 ** 3 ** 2
>// 512
>```
>
>上面代码中, 首先计算的是第二个指数运算符, 而不是第一个。
>
>指数运算符可以与等号结合, 形成一个新的赋值运算符（`**=`）。
>
>```javascript
>let a = 1.5;
>a **= 2;
>// 等同于 a = a * a;
>
>let b = 4;
>b **= 3;
>// 等同于 b = b * b * b;
>```
>

## 6、函数的拓展 (`重点`)

> `对于JS来说函数部分是重中之重的基础`,相对而言篇幅占比也会较大

### Ⅰ- 概括总结

>> **Ⅰ- 参数默认值**：为函数参数指定默认值
>
> - 形式：`function Func(x = 1, y = 2) {}`
> - 参数赋值：惰性求值(函数调用后才求值)
> - 参数位置：尾参数
> - 参数作用域：函数作用域
> - 声明方式：默认声明, 不能用`const`或`let`再次声明
> - length：返回没有指定默认值的参数个数
> - 与解构赋值默认值结合：`function Func({ x = 1, y = 2 } = {}) {}`
> - 应用
>   1. 指定某个参数不得省略, 省略即抛出错误：`function Func(x = throwMissing()) {}`
>   2. 将参数默认值设为`undefined`, 表明此参数可省略：`Func(undefined, 1)`
>
>> **Ⅱ - 箭头函数(=>)**：函数简写  -->`重点`
>
> - 无参数：`() => {}`
> - 单个参数：`x => {}`
> - 多个参数：`(x, y) => {}`
> - 解构参数：`({x, y}) => {}`
> - 嵌套使用：** `部署管道机制` ** -->不懂的详见下方
> - this指向固定化
>   - 并非因为内部有绑定 [ this ] 的机制, 而是根本没有自己的 [ this ] , 导致内部的 [ this ] 就是外层代码块的 [ this ] 
>   - 因为没有 [ this ] , 因此不能用作构造函数
>
>> **Ⅲ - rest/spread参数(...)**：返回函数多余参数
>
> - 形式：以数组的形式存在, 之后不能再有其他参数
> - 作用：代替`Arguments对象`
> - length：返回没有指定默认值的参数个数但不包括`rest/spread参数`
>
>> **Ⅳ - 严格模式**：在严格条件下运行JS
>
> - 应用：只要函数参数使用默认值、解构赋值、扩展运算符, 那么函数内部就不能显式设定为严格模式
>
>> **Ⅴ - name属性**：返回函数的函数名
>
> - 将匿名函数赋值给变量：`空字符串`(**ES5**)、`变量名`(**ES6**)
> - 将具名函数赋值给变量：`函数名`(**ES5和ES6**)
> - bind返回的函数：`bound 函数名`(**ES5和ES6**)
> - Function构造函数返回的函数实例：`anonymous`(**ES5和ES6**)
>
>> **Ⅵ - 尾调用优化**：只保留内层函数的调用帧
>
> - 尾调用
>   - 定义：某个函数的最后一步是调用另一个函数
>   - 形式：`function f(x) { return g(x); }`
> - 尾递归
>   - 定义：函数尾调用自身
>   - 作用：只要使用尾递归就不会发生栈溢出, 相对节省内存
>   - 实现：把所有用到的内部变量改写成函数的参数并使用参数默认值
>
>> **Ⅶ - 箭头函数常见误区的正解**
>
>1. 函数体内的 [ this ] 是`定义时所在的对象`而不是`使用时所在的对象`
>2. 可让 [ this ] 指向固定化, 这种特性很有利于封装回调函数
>3. 不可当作`构造函数`, 因此箭头函数不可使用`new命令`
>4. 不可使用`yield命令`, 因此箭头函数不能用作`Generator函数`
>5. 不可使用`Arguments对象`, 此对象在函数体内不存在(可用`rest/spread参数`代替)
>6. 返回对象时必须在对象外面加上括号

### Ⅱ - 函数参数的默认值

#### ①  基本用法

>ES6 之前, 不能直接为函数的参数指定默认值, 只能采用变通的方法。
>
>```javascript
>function log(x, y) {
>  y = y || 'World'; //[或],当y为undefined时,将其赋值
>  console.log(x, y);
>}
>log('Hello') // Hello World
>log('Hello', 'China') // Hello China
>log('Hello', '') // Hello World  -->参数`y`等于空字符, 结果被改为默认值
>```
>
>上面代码检查函数`log`的参数`y`有没有赋值, 如果没有, 则指定默认值为`World`。这种写法的缺点在于, 如果参数`y`赋值了, 但是对应的布尔值为`false`, 则该赋值不起作用。就像上面代码的最后一行, 参数`y`等于空字符, 结果被改为默认值。
>
>为了避免这个问题, 通常需要先判断一下参数`y`是否被赋值, 如果没有, 再等于默认值。
>
>```javascript
>if (typeof y === 'undefined') {  y = 'World'; }
>```
>
>ES6 允许为函数的参数设置默认值, 即直接写在参数定义的后面。
>
>```javascript
>function log(x, y = 'World') {  console.log(x, y);}
>log('Hello') // Hello World
>log('Hello', 'China') // Hello China
>log('Hello', '') // Hello
>```
>
>可以看到 , ES6 的写法比 ES5 简洁许多, 而且非常自然。下面是另一个例子。
>
>```javascript
>function Point(x = 0, y = 0) {
>  this.x = x;
>  this.y = y;
>}
>const p = new Point();
>p // { x: 0, y: 0 }
>```
>
>除了简洁 , ES6 的写法还有两个好处：
>
>- 首先, 阅读代码的人, 可以立刻意识到哪些参数是可以省略的, 不用查看函数体或文档；
>- 其次, 有利于将来的代码优化, 即使未来的版本在对外接口中, 彻底拿掉这个参数, 也不会导致以前的代码无法运行。
>
>参数变量是默认声明的, 所以不能用`let`或`const`再次声明,否则会报错。
>
>```javascript
>function foo(x = 5) {
>  let x = 1; // error
>  const x = 2; // error
>}
>```
>
>`使用参数默认值时, 函数不能有同名参数`。
>
>```javascript
>// 不报错
>function foo(x, x, y) {}
>
>// 报错
>function foo(x, x, y = 1) {}
>// SyntaxError: Duplicate parameter name not allowed in this context
>```
>
>另外, 一个容易忽略的地方是, 参数默认值不是传值的, 而是每次都重新计算默认值表达式的值。也就是说, 参数默认值是惰性求值的。
>
>```javascript
>let x = 99;
>function foo(p = x + 1) { console.log(p);}
>foo() // 100
>foo() // 100
>x = 100;
>foo() // 101
>```
>
>上面代码中, 参数`p`的默认值是`x + 1`。这时, 每次调用函数`foo`, 都会重新计算`x + 1`, 而不是默认`p`等于 100。

#### ② 与解构赋值默认值结合使用

>参数默认值可以与解构赋值的默认值, 结合起来使用。
>
>```javascript
>function foo({x, y = 5}) { console.log(x, y);}
>foo({}) // undefined 5
>foo({x: 1}) // 1 5
>foo({x: 1, y: 2}) // 1 2
>foo() // TypeError: Cannot read property 'x' of undefined
>```
>
>上面代码只使用了对象的解构赋值默认值, 没有使用函数参数的默认值。只有当函数`foo`的参数是一个对象时, 变量`x`和`y`才会通过解构赋值生成。如果函数`foo`调用时没提供参数, 变量`x`和`y`就不会生成, 从而报错。通过提供函数参数的默认值, 就可以避免这种情况。
>
>```javascript
>function foo({x, y = 5} = {}){console.log(x, y);}
>foo() // undefined 5
>```
>
>上面代码指定, 如果没有提供参数, 函数`foo`的参数默认为一个空对象。
>
>下面是另一个解构赋值默认值的例子。
>
>```javascript
>function fetch(url, { body = '', method = 'GET', headers = {} }) {
>console.log(method);
>  }
>
>fetch('http://example.com', {})
>// "GET"
>
>fetch('http://example.com')
>// 报错
>```
>
>上面代码中, 如果函数`fetch`的第二个参数是一个对象, 就可以为它的三个属性设置默认值。这种写法不能省略第二个参数, 如果结合函数参数的默认值, 就可以省略第二个参数。这时, 就出现了双重默认值。
>
>```javascript
>function fetch(url, { body = '', method = 'GET', headers = {} } = {}) {
>console.log(method);
>  }
>
>fetch('http://example.com')
>// "GET"
>```
>
>上面代码中, 函数`fetch`没有第二个参数时, 函数参数的默认值就会生效, 然后才是解构赋值的默认值生效, 变量`method`才会取到默认值`GET`。
>
>作为练习, 请问下面两种写法有什么差别？
>
>```javascript
>// 写法一
>function m1({x = 0, y = 0} = {}) { return [x, y]; }
>
>  // 写法二
>function m2({x, y} = { x: 0, y: 0 }) { return [x, y]; }
>```
>
>上面两种写法都对函数的参数设定了默认值, 区别是写法一函数参数的默认值是空对象, 但是设置了对象解构赋值的默认值；写法二函数参数的默认值是一个有具体属性的对象, 但是没有设置对象解构赋值的默认值。
>  
>```javascript
>// 函数没有参数的情况
>m1() // [0, 0]
>m2() // [0, 0]
>
>// x 和 y 都有值的情况
>m1({x: 3, y: 8}) // [3, 8]
>m2({x: 3, y: 8}) // [3, 8]
>
>// x 有值 , y 无值的情况
>m1({x: 3}) // [3, 0]
>m2({x: 3}) // [3, undefined]
>
>// x 和 y 都无值的情况
>m1({}) // [0, 0];
>m2({}) // [undefined, undefined]
>
>m1({z: 3}) // [0, 0]
>m2({z: 3}) // [undefined, undefined]
>```
>

#### ③  参数默认值的位置

>通常情况下, 定义了默认值的参数, 应该是函数的尾参数。因为这样比较容易看出来, 到底省略了哪些参数。如果非尾部的参数设置默认值, 实际上这个参数是没法省略的。
>
>```javascript
>// 例一
>function f(x = 1, y) { return [x, y];}
>
>f() // [1, undefined]
>f(2) // [2, undefined]
>f(, 1) // 报错
>f(undefined, 1) // [1, 1]
>
>// 例二
>function f(x, y = 5, z) { return [x, y, z];}
>
>f() // [undefined, 5, undefined]
>f(1) // [1, 5, undefined]
>f(1, ,2) // 报错
>f(1, undefined, 2) // [1, 5, 2]
>```
>
>上面代码中, 有默认值的参数都不是尾参数。这时, 无法只省略该参数, 而不省略它后面的参数, 除非显式输入`undefined`。
>
>如果传入`undefined`, 将触发该参数等于默认值, `null`则没有这个效果。
>
>```javascript
>function foo(x = 5, y = 6) { console.log(x, y); }
>foo(undefined, null)
>// 5 null
>```
>
>上面代码中, `x`参数对应`undefined`, 结果触发了默认值, `y`参数等于`null`, 就没有触发默认值。

#### ④ 函数的 length 属性

>指定了默认值以后, 函数的`length`属性, 将返回没有指定默认值的参数个数。也就是说, `指定了默认值后 , length属性将失真`。
>
>```javascript
>(function (a) {}).length // 1
>(function (a = 5) {}).length // 0
>(function (a, b, c = 5) {}).length // 2
>```
>
>上面代码中, [ length ]属性的返回值, 等于函数的参数个数减去指定了默认值的参数个数。比如, 上面最后一个函数, 定义了 3 个参数, 其中有一个参数`c`指定了默认值, 因此[ length ]属性等于`3`减去`1`, 最后得到`2`。
>
>这是因为`length`属性的含义是, 该函数预期传入的参数个数。某个参数指定默认值以后, 预期传入的参数个数就不包括这个参数了。同理, 后文的 rest 参数也不会计入[ length ]属性。
>
>```javascript
>(function(...args) {}).length // 0
>```
>
>如果设置了`默认值的参数不是尾参数`, 那么[ length ]属性也不再计入后面的参数了。
>
>```javascript
>(function (a = 0, b, c) {}).length // 0
>(function (a, b = 1, c) {}).length // 1
>```
>

#### ⑤  作用域

>一旦设置了参数的默认值, 函数进行声明初始化时, 参数会形成一个单独的作用域（context）。等到初始化结束, 这个作用域就会消失。这种语法行为, 在不设置参数默认值时, 是不会出现的。
>
>```javascript
>var x = 1;
>function f(x, y = x) { console.log(y); }
>f(2) // 2
>```
>
>上面代码中, 参数`y`的默认值等于变量`x`。调用函数 [ f ] 时, 参数形成一个单独的作用域。在这个作用域里面, 默认值变量`x`指向第一个参数`x`, 而不是全局变量`x`, 所以输出是`2`。
>
>再看下面的例子。
>
>```javascript
>let x = 1;
>function f(y = x) {
>  let x = 2;
>  console.log(y);
>}
>f() // 1
>```
>
>上面代码中, 函数 [ f ] 调用时, 参数`y = x`形成一个单独的作用域。这个作用域里面, 变量`x`本身没有定义, 所以指向外层的全局变量`x`。函数调用时, 函数体内部的局部变量`x`影响不到默认值变量`x`。
>
>如果此时, 全局变量`x`不存在, 就会报错。
>
>```javascript
>function f(y = x) {
>  let x = 2;
>  console.log(y);
>}
>f() // ReferenceError: x is not defined
>```
>
>下面这样写, 也会报错。
>
>```javascript
>var x = 1;
>function foo(x = x) {
>  // ...
>}
>foo() // ReferenceError: x is not defined
>```
>
>上面代码中, 参数`x = x`形成一个单独作用域。实际执行的是`let x = x`, 由于暂时性死区的原因, 这行代码会报错”x 未定义“。
>
>如果参数的默认值是一个函数, 该函数的作用域也遵守这个规则。请看下面的例子。
>
>```javascript
>let foo = 'outer';
>
>function bar(func = () => foo) {
>  let foo = 'inner';
>  console.log(func());
>}
>
>bar(); // outer
>```
>
>上面代码中, 函数`bar`的参数`func`的默认值是一个匿名函数, 返回值为变量`foo`。函数参数形成的单独作用域里面, 并没有定义变量`foo`, 所以`foo`指向外层的全局变量`foo`, 因此输出`outer`。
>
>如果写成下面这样, 就会报错。
>
>```javascript
>function bar(func = () => foo) {
>  let foo = 'inner';
>  console.log(func());
>}
>
>bar() // ReferenceError: foo is not defined
>```
>
>上面代码中, 匿名函数里面的`foo`指向函数外层, 但是函数外层并没有声明变量`foo`, 所以就报错了。
>
>下面是一个更复杂的例子。
>
>```javascript
>var x = 1;
>function foo(x, y = function() { x = 2; }) {
>  var x = 3;
>  y();
>  console.log(x);
>}
>
>foo() // 3
>//x == 1
>```
>
>上面代码中, 函数`foo`的参数形成一个单独作用域。这个作用域里面, 首先声明了变量`x`, 然后声明了变量`y`, `y`的默认值是一个匿名函数。这个匿名函数内部的变量`x`, 指向同一个作用域的第一个参数`x`。函数`foo`内部又声明了一个内部变量`x`, 该变量与第一个参数`x`由于不是同一个作用域, 所以不是同一个变量, 因此执行`y`后, 内部变量`x`和外部全局变量`x`的值都没变。
>
>如果将`var x = 3`的`var`去除, 函数`foo`的内部变量`x`就指向第一个参数`x`, 与匿名函数内部的`x`是一致的, 所以最后输出的就是`2`, 而外层的全局变量`x`依然不受影响。
>
>```javascript
>var x = 1;
>function foo(x, y = function() { x = 2; }) {
>  x = 3;
>  y();
>  console.log(x);
>}
>
>foo() // 2
>//x== 1
>```

#### ⑥ 应用

>利用参数默认值, 可以指定某一个参数不得省略, 如果省略就抛出一个错误。
>
>```javascript
>function throwIfMissing() { throw new Error('Missing parameter'); }
>
>function foo(mustBeProvided = throwIfMissing()) {  return mustBeProvided; }
>
>foo()
>// Error: Missing parameter
>```
>
>上面代码的`foo`函数, 如果调用的时候没有参数, 就会调用默认值`throwIfMissing`函数, 从而抛出一个错误。
>
>从上面代码还可以看到, 参数`mustBeProvided`的默认值等于`throwIfMissing`函数的运行结果（注意函数名`throwIfMissing`之后有一对圆括号）, 这表明参数的默认值不是在定义时执行, 而是在运行时执行。如果参数已经赋值, 默认值中的函数就不会运行。
>
>另外, 可以将参数默认值设为`undefined`, 表明这个参数是可以省略的。
>
>```javascript
>function foo(optional = undefined) { ··· }
>```
>

### Ⅲ - 箭头函数 (`重点`)

> ES6最常见用法,这个必须要会

#### ① 基本用法

>ES6 允许使用“箭头”（`=>`）定义函数。
>
>```javascript
>var f = v => v;
>
>// 等同于
>var f = function (v) {
>  return v;
>};
>```
>
>如果箭头函数不需要参数或需要多个参数, 就使用一个圆括号代表参数部分。
>
>```javascript
>var f = () => 5;
>// 等同于
>var f = function () { return 5 };
>
>var sum = (num1, num2) => num1 + num2;
>// 等同于
>var sum = function(num1, num2) {
>  return num1 + num2;
>};
>```
>
>如果箭头函数的代码块部分多于一条语句, 就要使用大括号将它们括起来, 并且使用`return`语句返回。
>
>```javascript
>var sum = (num1, num2) => { return num1 + num2; }
>```
>
>`由于大括号被解释为代码块, 所以如果箭头函数直接返回一个对象, 必须在对象外面加上括号, 否则会报错`。
>
>```javascript
>// 报错
>let getTempItem = id => { id: id, name: "Temp" };
>
>// 不报错
>let getTempItem = id => ({ id: id, name: "Temp" });
>```
>
>下面是一种特殊情况, 虽然可以运行, 但会得到错误的结果。
>
>```javascript
>let foo = () => { a: 1 };
>foo() // undefined
>```
>
>上面代码中, 原始意图是返回一个对象`{ a: 1 }`, 但是由于引擎认为大括号是代码块, 所以执行了一行语句`a: 1`。这时, `a`可以被解释为语句的标签, 因此实际执行的语句是`1;`, 然后函数就结束了, 没有返回值。
>
>如果箭头函数只有一行语句, 且不需要返回值, 可以采用下面的写法, 就不用写大括号了。
>
>```javascript
>let fn = () => void doesNotReturn();
>```
>
>箭头函数可以与变量解构结合使用。
>
>```javascript
>const full = ({ first, last }) => first + ' ' + last;
>
>// 等同于
>function full(person) {
>  return person.first + ' ' + person.last;
>}
>```
>
>箭头函数使得表达更加简洁。
>
>```javascript
>const isEven = n => n % 2 === 0; //类型 boolean
>const square = n => n * n;  //类型 number
>```
>
>上面代码只用了两行, 就定义了两个简单的工具函数。如果不用箭头函数, 可能就要占用多行, 而且还不如现在这样写醒目。
>
>箭头函数的一个用处是简化回调函数。
>
>```javascript
>// 正常函数写法
>[1,2,3].map(function (x) {
>  return x * x;
>});
>
>// 箭头函数写法
>[1,2,3].map(x => x * x);
>```
>
>另一个例子是
>
>```javascript
>// 正常函数写法
>var result = values.sort(function (a, b) {
>  return a - b;
>});
>
>// 箭头函数写法
>var result = values.sort((a, b) => a - b);
>```
>
>下面是 rest 参数与箭头函数结合的例子(`个人觉得很好用`)。
>
>```javascript
>const numbers = (...nums) => nums;
>
>numbers(1, 2, 3, 4, 5)
>// [1,2,3,4,5]
>
>const headAndTail = (head, ...tail) => [head, tail];
>
>headAndTail(1, 2, 3, 4, 5)
>// [1,[2,3,4,5]]
>```
>

#### ② 使用注意点

>箭头函数有几个使用注意点。
>
>（1）函数体内的 [ this ] 对象, 就是定义时所在的对象, 而不是使用时所在的对象。
>
>（2）不可以当作构造函数, 也就是说, 不可以使用`new`命令, 否则会抛出一个错误。
>
>（3）不可以使用`arguments`对象, 该对象在函数体内不存在。如果要用, `可以用 rest 参数代替`。
>
>（4）不可以使用`yield`命令, 因此箭头函数`不能用作 Generator 函数`。-->此类型函数在后方知识点会给出详解
>
>> 以下是详解举栗
>
>上面四点中, 第一点尤其值得注意。`[this]对象的指向是可变的, 但是在箭头函数中, 它是固定的`。
>
>```javascript
>function foo() {
>setTimeout(() => {
>console.log('id:', this.id);
>}, 100);
>}
>
>var id = 21;
>
>foo.call({ id: 42 }); // id: 42
>```
>
>上面代码中, `setTimeout()`的参数是一个箭头函数, 这个箭头函数的定义生效是在`foo`函数生成时, 而它的真正执行要等到 100 毫秒后。如果是普通函数, 执行时 [ this ] 应该指向全局对象`window`, 这时应该输出`21`。但是, 箭头函数导致 [ this ] 总是指向函数定义生效时所在的对象（本例是`{id: 42}`）, 所以打印出来的是`42`。
>
>箭头函数可以让`setTimeout`里面的 [ this ] , 绑定定义时所在的作用域, 而不是指向运行时所在的作用域。下面是另一个例子。
>
>```javascript
>function Timer() {
>this.s1 = 0;
>this.s2 = 0;
>// 箭头函数
>setInterval(() => this.s1++, 1000);
>// 普通函数
>setInterval(function () {
>this.s2++;
>}, 1000);
>}
>
>var timer = new Timer();
>
>setTimeout(() => console.log('s1: ', timer.s1), 3100);
>setTimeout(() => console.log('s2: ', timer.s2), 3100);
>// s1: 3
>// s2: 0
>```
>
>上面代码中, `Timer`函数内部设置了两个定时器, 分别使用了箭头函数和普通函数。前者的 [ this ] 绑定定义时所在的作用域（即`Timer`函数）, 后者的 [ this ] 指向运行时所在的作用域（即全局对象）。所以, 3100 毫秒之后, `timer.s1`被更新了 3 次, 而`timer.s2`一次都没更新。
>
>`箭头函数可以让[this指向]固定化, 这种特性很有利于封装回调函数`。下面是一个例子 , DOM 事件的回调函数封装在一个对象里面。
>
>```javascript
>var handler = {
>id: '123456',
>
>init: function() {
>document.addEventListener('click',
> event => this.doSomething(event.type), false);
>},
>
>doSomething: function(type) {
>console.log('Handling ' + type  + ' for ' + this.id);
>}
>};
>```
>
>上面代码的`init`方法中, 使用了箭头函数, 这导致这个箭头函数里面的 [ this ] , 总是指向`handler`对象。否则, 回调函数运行时, `this.doSomething`这一行会报错, 因为此时 [ this ] 指向`document`对象。
>
> [ this ] 指向的固定化, 并不是因为箭头函数内部有绑定 [ this ] 的机制, 实际原因是箭头函数根本没有自己的 [ this ] , 导致内部的 [ this ] 就是外层代码块的 [ this ] 。正是因为它没有 [ this ] , 所以也就不能用作构造函数。
>
>所以, 箭头函数转成 ES5 的代码如下。
>
>```javascript
>// ES6
>function foo() {
>setTimeout(() => {
>console.log('id:', this.id);
>}, 100);
>}
>
>// ES5
>function foo() {
>var _this = this;
>
>setTimeout(function () {
>console.log('id:', _this.id);
>}, 100);
>}
>```
>
>上面代码中, 转换后的 ES5 版本清楚地说明了, 箭头函数里面根本没有自己的 [ this ] , 而是引用外层的 [ this ] 。
>
>请问下面的代码之中有几个 [ this ] ？
>
>```javascript
>function foo() {
>return () => {
>return () => {
> return () => {
>   console.log('id:', this.id);
> };
>};
>};
>}
>
>var f = foo.call({id: 1});
>
>var t1 = f.call({id: 2})()(); // id: 1
>var t2 = f().call({id: 3})(); // id: 1
>var t3 = f()().call({id: 4}); // id: 1
>```
>
>上面代码之中, 只有一个 [ this ] , 就是函数`foo`的 [ this ] , 所以`t1`、`t2`、`t3`都输出同样的结果。因为所有的内层函数都是箭头函数, 都没有自己的 [ this ] , 它们的 [ this ] 其实都是最外层`foo`函数的 [ this ] 。
>
>除了 [ this ] , 以下三个变量在箭头函数之中也是不存在的, 指向外层函数的对应变量：`arguments`、`super`、`new.target`。
>
>```javascript
>function foo() {
>setTimeout(() => {
>console.log('args:', arguments);
>}, 100);
>}
>
>foo(2, 4, 6, 8)
>// args: [2, 4, 6, 8]
>```
>
>上面代码中, 箭头函数内部的变量`arguments`, 其实是函数`foo`的`arguments`变量。
>
>另外, 由于箭头函数没有自己的 [ this ] , 所以当然也就不能用`call()`、`apply()`、`bind()`这些方法去改变 [ this ] 的指向。
>
>```javascript
>(function() {
>return [
>(() => this.x).bind({ x: 'inner' })()
>];
>}).call({ x: 'outer' });
>// ['outer']
>```
>
>上面代码中, 箭头函数没有自己的 [ this ] , 所以`bind`方法无效, 内部的 [ this ] 指向外部的 [ this ] 。
>
>长期以来 , JavaScript 语言的 [ this ] 对象一直是一个令人头痛的问题, 在对象方法中使用 [ this ] , 必须非常小心。`箭头函数'绑定[this]', 很大程度上解决了这个困扰。`

#### ③ 不适用场合

>由于箭头函数使得 [ this ] 从“动态”变成“静态”, 下面两个场合不应该使用箭头函数。
>
>第一个场合是定义对象的方法, 且该方法内部包括 [ this ] 。
>
>>```javascript
>>const cat = {
>>  lives: 9,
>>  jumps: () => { this.lives--;}
>>}
>>```
>>
>>上面代码中, `cat.jumps()`方法是一个箭头函数, 这是错误的。调用`cat.jumps()`时, 如果是普通函数, 该方法内部的 [ this ] 指向`cat`；如果写成上面那样的箭头函数, 使得 [ this ] 指向全局对象, 因此不会得到预期结果。这是`因为对象不构成单独的作用域`, 导致`jumps`箭头函数定义时的作用域就是全局作用域。
>
>第二个场合是需要动态 [ this ] 的时候, 也不应使用箭头函数。
>
>>```javascript
>>var button = document.getElementById('press');
>>button.addEventListener('click', () => {
>>  this.classList.toggle('on');
>>});
>>```
>>
>>上面代码运行时, 点击按钮会报错, 因为`button`的监听函数是一个箭头函数, 导致里面的 [ this ] 就是全局对象。如果改成普通函数,  [ this ] 就会动态指向被点击的按钮对象。
>
>另外, 如果函数体很复杂, 有许多行, 或者函数内部有大量的读写操作, 不单纯是为了计算值, 这时也不应该使用箭头函数, 而是要使用普通函数, 这样可以提高代码可读性

#### ④ 嵌套的箭头函数

>箭头函数内部, 还可以再使用箭头函数。下面是一个 ES5 语法的多重嵌套函数。
>
>```javascript
>function insert(value) {
>  return {into: function (array) {
>    return {after: function (afterValue) {
>      array.splice(array.indexOf(afterValue) + 1, 0, value);
>      return array;
>    }};
>  }};
>}
>
>insert(2).into([1, 3]).after(1); //[1, 2, 3]
>```
>
>上面这个函数, 可以使用箭头函数改写。
>
>```javascript
>let insert = (value) => ({into: (array) => ({after: (afterValue) => {
>  array.splice(array.indexOf(afterValue) + 1, 0, value);
>  return array;
>}})});
>
>insert(2).into([1, 3]).after(1); //[1, 2, 3]
>```
>

##### a) 部署管道机制 (pipeline)

>下面是一个部署管道机制 (pipeline)的例子 : `即前一个函数的输出是后一个函数的输入`。
>
>```javascript
>const pipeline = (...funcs) =>
>  val => funcs.reduce((a, b) => b(a), val);
>
>const plus1 = a => a + 1;
>const mult2 = a => a * 2;
>const addThenMult = pipeline(plus1, mult2);
>
>addThenMult(5)
>// 12
>```
>
>如果觉得上面的写法可读性比较差, 也可以采用下面的写法。
>
>```javascript
>const plus1 = a => a + 1;
>const mult2 = a => a * 2;
>
>mult2(plus1(5))
>// 12
>```
>
>箭头函数还有一个功能, 就是可以很方便地改写 λ 演算。
>
>```javascript
>// λ演算的写法
>fix = λf.(λx.f(λv.x(x)(v)))(λx.f(λv.x(x)(v)))
>
>// ES6的写法
>var fix = f => (x => f(v => x(x)(v)))
>               (x => f(v => x(x)(v)));
>```
>
>上面两种写法, 几乎是一一对应的。由于 λ 演算对于计算机科学非常重要, 这使得我们可以用 ES6 作为替代工具, 探索计算机科学。

##### b) 高阶函数

>在我的理解中,实际上高阶函数本质上就与  [ 部署管道机制 ] 殊途同归,此处列出是为了更好做对比,防止以后遇到混淆
>
>所谓高阶函数:`就是一个函数就可以接收另一个函数作为参数, 或者是返回一个函数`-->常见的高阶函数有map、reduce、filter、sort等
>
>  ```js
>var ADD =function add(a) {
> return function(b) { return a+b }
>}
> 调用：ADD(2)(3)即可获得结果
>  ```
>
>> map
>
>  ```js
>map接受一个函数作为参数, 不改变原来的数组, 只是返回一个全新的数组
>var arr = [1,2,3,4,5]
> var arr1 = arr.map(item => item = 2)// 输出[1,1,1,1,1]
>  ```
>
>> reduce
>
>  ```js
>reduce也是返回一个全新的数组。reduce接受一个函数作为参数, 这个函数要有两个形参, 代表数组中的前两项 , reduce会将这个函数的结果与数组中的第三项再次组成这个函数的两个形参以此类推进行累积操作
>var arr = [1,2,3,4,5]
>var arr2 = arr.reduce((a,b)=> a+b)
>console.log(arr2) // 15
>  ```
>
>> filter
>
>  ```js
>filter返回过滤后的数组。filter也接收一个函数作为参数, 这个函数将作用于数组中的每个元素, 根据该函数每次执行后返回的布尔值来保留结果, 如果是true就保留, 如果是false就过滤掉（这点与map要区分）
>var arr = [1,2,3,4,5]
> var arr3 = arr.filter(item => item % 2 == 0)
>console.log(arr3)// [2,4]
>  ```

##### c) 函数柯里化

>此处列出是因为此知识点常与箭头函数搭配使用,而很多同学其实有在用却都不懂这个概念(大多数教程都不会刻意去普及概念),所以我觉得在此处列出,会对很多同学有所帮助,也能形成关联性更强的知识体系
>
>> 截取自网上的正解图例
>
>  ![image-20210415161137977](ES6及后续版本学习笔记中的图片/image-20210415161137977.png)
>
>> 关键就是`理解柯里化`, 其实可以把它理解成, 柯里化后, `将第一个参数变量存在函数里面了(闭包)`, 然后本来需要n个参数的函数可以变成只需要剩下的（n - 1个）参数就可以调用, 比如
>
>  ```js
>let add = x => y => x + y
>let add2 = add(2)
>------------ 一般调用 ------------------------
>//本来完成 add 这个操作, 应该是这样调用
>let add = (x, y) => x + y
>add(2,3)
>------------- 柯里化后调用  ---------------------
>// 而现在 add2 函数完成同样操作只需要一个参数, 这在函数式编程中广泛应用。
>let add = x => y => x + y
>let add2 = add(2)
>//详细解释一下, 就是 add2 函数 等价于 有了 x 这个闭包变量的 y => x + y 函数,并且此时 x = 2 , 所以此时调用
>add2(3) === 2 + 3
>  ```

##### d) 从 ES6 高阶箭头函数理解函数柯里化以及 [ 部署管道机制 ]

>1. 首先看到了这样的一个例子：
>
>  ```js
>let add = a => b => a + b
>  ```
>
>2. 以上是一个很简单的相加函数, 把它转化成 ES5 的写法如下
>
>  ```js
>function add(a) {
>      return function(b) { return a + b }
>}
>var add3 = add(3) //add3表示一个指向函数的变量 可以当成函数调用名来用
>add3(4) === 3 + 4 //true
>  ```
>
>3. 再简化一下, 可以写成如下形式：
>
>  ```js
>let add = function(a) {
>    var param = a;
>    var innerFun = function(b) { return param + b; }
>    return innerFun;
>}
>  ```
>
>4. 虽然好像没什么意义, 但是很显然上述使用了闭包, 而且该函数的返回值是一个函数。其实, 这就是`高阶函数的定义：以函数为参数或者返回值是函数的函数。`
>
>  ![image-20210415160945789](ES6及后续版本学习笔记中的图片/image-20210415160945789.png) 

### Ⅳ - rest 参数 (`常用`)

>ES6 引入 rest 参数（形式为`...变量名`）, 用于获取函数的多余参数, 这样就不需要使用`arguments`对象了。rest 参数搭配的变量是一个数组, 该变量将多余的参数放入数组中。
>
>```javascript
>function add(...values) {
>  let sum = 0;
>  for (var val of values) {
>    sum += val;
>  }
>  return sum;
>}
>
>add(2, 5, 3) // 10
>```
>
>上面代码的`add`函数是一个求和函数, 利用 rest 参数, 可以向该函数传入任意数目的参数。
>
>下面是一个 rest 参数代替`arguments`变量的例子。
>
>```javascript
>// arguments变量的写法
>function sortNumbers() {
>  return Array.prototype.slice.call(arguments).sort();
>}
>
>// rest参数的写法
>const sortNumbers = (...numbers) => numbers.sort();
>```
>
>上面代码的两种写法, 比较后可以发现 , rest 参数的写法更自然也更简洁。
>
>`arguments`对象不是数组, 而是一个类似数组的对象。所以为了使用数组的方法, 必须使用`Array.prototype.slice.call`先将其转为数组。`rest 参数就不存在这个问题, 它就是一个真正的数组, 数组特有的方法都可以使用`。下面是一个利用 rest 参数改写数组`push`方法的例子。
>
>```javascript
>function push(array, ...items) {
>  items.forEach(function(item) {
>    array.push(item);
>    console.log(item);
>  });
>}
>
>var a = [];
>push(a, 1, 2, 3)
>```
>
>注意 , rest 参数之后不能再有其他参数（即只能是最后一个参数）, 否则会报错。
>
>```javascript
>// 报错
>function f(a, ...b, c) {
>  // ...
>}
>```
>
>函数的`length`属性, 不包括 rest 参数。
>
>```javascript
>(function(a) {}).length  // 1
>(function(...a) {}).length  // 0
>(function(a, ...b) {}).length  // 1
>```
>

### Ⅴ - 严格模式

>从 ES5 开始, 函数内部可以设定为严格模式。
>
>```javascript
>function doSomething(a, b) {
>  'use strict';
>  // code
>}
>```
>
>ES2016 做了一点修改, `规定只要函数参数使用了默认值、解构赋值、或者扩展运算符, 那么函数内部就不能显式设定为严格模式, 否则会报错`。
>
>```javascript
>// 报错
>function doSomething(a, b = a) {
>  'use strict';
>  // code
>}
>
>// 报错
>const doSomething = function ({a, b}) {
>  'use strict';
>  // code
>};
>
>// 报错
>const doSomething = (...a) => {
>  'use strict';
>  // code
>};
>
>const obj = {
>  // 报错
>  doSomething({a, b}) {
>    'use strict';
>    // code
>  }
>};
>```
>
>这样规定的原因是, 函数内部的严格模式, 同时适用于函数体和函数参数。但是, 函数执行的时候, 先执行函数参数, 然后再执行函数体。这样就有一个不合理的地方, 只有从函数体之中, 才能知道参数是否应该以严格模式执行, 但是参数却应该先于函数体执行。
>
>```javascript
>// 报错
>function doSomething(value = 070) {
>  'use strict';
>  return value;
>}
>```
>
>上面代码中, 参数`value`的默认值是八进制数`070`, 但是严格模式下不能用前缀`0`表示八进制, 所以应该报错。但是实际上 , JavaScript 引擎会先成功执行`value = 070`, 然后进入函数体内部, 发现需要用严格模式执行, 这时才会报错。
>
>虽然可以先解析函数体代码, 再执行参数代码, 但是这样无疑就增加了复杂性。因此, 标准索性禁止了这种用法, 只要参数使用了默认值、解构赋值、或者扩展运算符, 就不能显式指定严格模式。
>
>两种方法可以规避这种限制。第一种是设定全局性的严格模式, 这是合法的。
>
>```javascript
>'use strict';
>
>function doSomething(a, b = a) {
>  // code
>}
>```
>
>第二种是把函数包在一个无参数的立即执行函数里面。
>
>```javascript
>const doSomething = (function () {
>  'use strict';
>  return function(value = 42) {
>    return value;
>  };
>}());
>```
>

### Ⅵ - name 属性

>函数的`name`属性, 返回该函数的函数名。
>
>```javascript
>function foo() {}
>foo.name // "foo"
>```
>
>这个属性早就被浏览器广泛支持, 但是直到 ES6 , 才将其写入了标准。
>
>需要注意的是 , ES6 对这个属性的行为做出了一些修改。如果将一个匿名函数赋值给一个变量 , ES5 的`name`属性, 会返回空字符串, 而 ES6 的`name`属性会返回实际的函数名。
>
>```javascript
>var f = function () {};
>
>// ES5
>f.name // ""
>
>// ES6
>f.name // "f"
>```
>
>上面代码中, 变量 [ f ] 等于一个匿名函数 , ES5 和 ES6 的`name`属性返回的值不一样。
>
>如果将一个具名函数赋值给一个变量, 则 ES5 和 ES6 的`name`属性都返回这个具名函数原本的名字。
>
>```javascript
>const bar = function baz() {};
>
>// ES5
>bar.name // "baz"
>
>// ES6
>bar.name // "baz"
>```
>
>`Function`构造函数返回的函数实例, `name`属性的值为`anonymous`。
>
>```javascript
>(new Function).name // "anonymous"
>```
>
>`bind`返回的函数, `name`属性值会加上`bound`前缀。
>
>```javascript
>function foo() {};
>foo.bind({}).name // "bound foo"
>
>(function(){}).bind({}).name // "bound "
>```
>

### Ⅶ - 尾调用优化

> 此处如果看不懂可以暂时跳过或者粗略看下,此部分一般情况不会用到:
>
> 尾调用优化默认关闭,各大浏览器（除了`safari`）根本就没部署尾调用优化；

#### ① 什么是尾调用?

>尾调用（Tail Call）是函数式编程的一个重要概念, 本身非常简单, 一句话就能说清楚, 就是指某个函数的最后一步是调用另一个函数。
>
>```javascript
>function f(x){
>  return g(x);
>}
>```
>
>上面代码中, 函数 [ f ] 的最后一步是调用函数 [ g ] , 这就叫尾调用。
>
>以下三种情况, 都不属于尾调用。
>
>```javascript
>// 情况一
>function f(x){
>  let y = g(x);
>  return y;
>}
>
>// 情况二
>function f(x){
>  return g(x) + 1;
>}
>
>// 情况三
>function f(x){
>  g(x);
>}
>```
>
>上面代码中, 情况一是调用函数 [ g ] 之后, 还有赋值操作, 所以不属于尾调用, 即使语义完全一样。情况二也属于调用后还有操作, 即使写在一行内。`情况三等同于下面的代码`。
>
>```javascript
>function f(x){
>  g(x);
>  return undefined;
>}
>```
>
>`尾调用不一定出现在函数尾部, 只要是最后一步操作即可`。
>
>```javascript
>function f(x) {
>  if (x > 0) {
>    return m(x)
>  }
>  return n(x);
>}
>```
>
>上面代码中, 函数`m`和`n`都属于尾调用, 因为它们都是函数 [ f ] 的最后一步操作

#### ② 尾调用优化

>尾调用之所以与其他调用不同, 就在于它的特殊的调用位置。
>
>我们知道, `函数调用会在内存形成一个'调用记录', 又称 [调用帧 (call frame)]`, 保存调用位置和内部变量等信息。如果在函数 [ A ] 的内部调用函数 [ B ] , 那么在 [ A ] 的调用帧上方, 还会形成一个 [ B ] 的调用帧。等到 [ B ] 运行结束, 将结果返回到 [ A ] ,  [ B ] 的调用帧才会消失。如果函数 [ B ] 内部还调用函数 [ C ] , 那就还有一个 [ C ] 的调用帧, 以此类推。`所有的调用帧, 就形成一个[调用栈 (call stack)]`。
>
>尾调用由于是函数的最后一步操作, 所以不需要保留外层函数的调用帧, 因为调用位置、内部变量等信息都不会再用到了, `只要直接用内层函数的调用帧, 取代外层函数的调用帧就可以了`。
>
>```javascript
>function f() {
>  let m = 1;
>  let n = 2;
>  return g(m + n);
>}
>f();
>
>// 等同于
>function f() { return g(3);}
>f();
>
>// 等同于
>g(3);
>```
>
>上面代码中, 如果函数 [ g ] 不是尾调用, 函数 [  f  ] 就需要保存内部变量`m`和`n`的值、 [ g ] 的调用位置等信息。但由于调用 [ g ] 之后, 函数 [ `f` ] 就结束了, 所以执行到最后一步, 完全可以删除`f(x)`的调用帧, 只保留`g(3)`的调用帧。
>
>`这就叫做[尾调用优化 (Tail call optimization)]`:即只保留内层函数的调用帧。如果所有函数都是尾调用, 那么完全可以做到每次执行时, 调用帧只有一项, 这将大大节省内存。这就是“尾调用优化”的意义。
>
>注意, 只有不再用到外层函数的内部变量, 内层函数的调用帧才会取代外层函数的调用帧, 否则就无法进行“尾调用优化”。
>
>```javascript
>function addOne(a){
>  var one = 1;
>  function inner(b){
>    return b + one;
>  }
>  return inner(a);
>}
>```
>
>上面的函数不会进行尾调用优化, 因为内层函数`inner`用到了外层函数`addOne`的内部变量`one`。

#### ③ 尾递归

>函数调用自身, 称为递归。如果尾调用自身, 就称为尾递归。
>
>`递归非常耗费内存`, 因为需要同时保存成千上百个调用帧, 很容易发生[ 栈溢出错误 (stack overflow)]。`但对于尾递归来说, 由于只存在一个调用帧, 所以永远不会发生'栈溢出'错误`。
>
>```javascript
>function factorial(n) {
>  if (n === 1) return 1;
>  return n * factorial(n - 1);
>}
>
>factorial(5) // 120
>```
>
>上面代码是一个阶乘函数, 计算`n`的阶乘, 最多需要保存`n`个调用记录, 复杂度 O(n) 。
>
>如果改写成尾递归, 只保留一个调用记录, 复杂度 O(1) 。
>
>```javascript
>function factorial(n, total) {
>  if (n === 1) return total;
>  return factorial(n - 1, n * total);
>}
>
>factorial(5, 1) // 120
>```
>
>还有一个比较著名的例子, 就是计算 Fibonacci 数列, 也能充分说明尾递归优化的重要性。
>
>非尾递归的 Fibonacci 数列实现如下。
>
>```javascript
>function Fibonacci (n) {
>  if ( n <= 1 ) {return 1};
>  return Fibonacci(n - 1) + Fibonacci(n - 2);
>}
>
>Fibonacci(10) // 89
>Fibonacci(100) // 超时
>Fibonacci(500) // 超时
>```
>
>尾递归优化过的 Fibonacci 数列实现如下。
>
>```javascript
>function Fibonacci2 (n , ac1 = 1 , ac2 = 1) {
>  if( n <= 1 ) {return ac2};
>  return Fibonacci2 (n - 1, ac2, ac1 + ac2);
>}
>
>Fibonacci2(100) // 573147844013817200000
>Fibonacci2(1000) // 7.0330367711422765e+208
>Fibonacci2(10000) // Infinity
>```
>
>由此可见, [ 尾调用优化 ]对递归操作意义重大, 所以一些函数式编程语言将其写入了语言规格。ES6 亦是如此, 第一次明确规定, 所有 ECMAScript 的实现, 都必须部署 [ 尾调用优化 ]。这就是说, `ES6 中只要使用尾递归, 就不会发生栈溢出 (或者层层递归造成的超时), 相对节省内存`。

#### ④ 递归函数的改写

>尾递归的实现, 往往需要改写递归函数, 确保最后一步只调用自身。做到这一点的方法, 就是把所有用到的内部变量改写成函数的参数。比如上面的例子, 阶乘函数 factorial 需要用到一个中间变量`total`, 那就把这个中间变量改写成函数的参数。这样做的缺点就是不太直观, 第一眼很难看出来 : 为什么计算`5`的阶乘, 需要传入两个参数`5`和`1`？
>
>两个方法可以解决这个问题。方法一是在尾递归函数之外, 再提供一个正常形式的函数。
>
>```javascript
>function tailFactorial(n, total) {
>  if (n === 1) return total;
>  return tailFactorial(n - 1, n * total);
>}
>
>function factorial(n) { return tailFactorial(n, 1); }
>
>factorial(5) // 120
>```
>
>上面代码通过一个正常形式的阶乘函数`factorial`, 调用尾递归函数`tailFactorial`, 看起来就正常多了。
>
>函数式编程有一个概念, 叫做`柯里化 (currying)`, 意思是将多参数的函数转换成单参数的形式。这里也可以使用柯里化。-->不懂的看上方[④ 嵌套的箭头函数中的函数柯里化](#④ 嵌套的箭头函数 ) 
>
>```javascript
>function currying(fn, n) {
>  return function (m) {
>    return fn.call(this, m, n);
>  };
>}
>
>function tailFactorial(n, total) {
>  if (n === 1) return total;
>  return tailFactorial(n - 1, n * total);
>}
>
>const factorial = currying(tailFactorial, 1);
>
>factorial(5) // 120
>```
>
>上面代码通过柯里化, 将尾递归函数`tailFactorial`变为只接受一个参数的`factorial`。
>
>第二种方法就简单多了, 就是采用 ES6 的函数默认值。
>
>```javascript
>function factorial(n, total = 1) {
>  if (n === 1) return total;
>  return factorial(n - 1, n * total);
>}
>
>factorial(5) // 120
>```
>
>上面代码中, 参数`total`有默认值`1`, 所以调用时不用提供这个值。
>
>总结一下, 递归本质上是一种循环操作。纯粹的函数式编程语言没有循环操作命令, 所有的循环都用递归实现, 这就是为什么尾递归对这些语言极其重要。对于其他支持“尾调用优化”的语言（比如 Lua , ES6）, `只需要知道循环可以用递归代替, 而一旦使用递归, 就最好使用尾递归`。

#### ⑤ 严格模式

>`ES6 的尾调用优化只在严格模式下开启, 正常模式是无效的`。
>
>这是因为在正常模式下, 函数内部有两个变量, 可以跟踪函数的调用栈。
>
>- `func.arguments`：返回调用时函数的参数。
>- `func.caller`：返回调用当前函数的那个函数。
>
>尾调用优化发生时, 函数的调用栈会改写, 因此上面两个变量就会失真。严格模式禁用这两个变量, 所以尾调用模式仅在严格模式下生效。
>
>```javascript
>function restricted() {
>  'use strict';
>  restricted.caller;    // 报错
>  restricted.arguments; // 报错
>}
>restricted();
>```
>

#### ⑥ 利用 循环 替换 尾递归 优化的实现

>尾递归优化只在严格模式下生效, 那么正常模式下, 或者那些不支持该功能的环境中, 有没有办法也使用尾递归优化呢？回答是可以的, 就是自己实现尾递归优化。
>
>它的原理非常简单。尾递归之所以需要优化, 原因是调用栈太多, 造成溢出, 那么只要减少调用栈, 就不会溢出。怎么做可以减少调用栈呢？`就是采用 [循环] 换掉 [递归]`。
>
>下面是一个正常的递归函数。
>
>```javascript
>function sum(x, y) {
>  if (y > 0) return sum(x + 1, y - 1);
>   else  return x;
>}
>
>sum(1, 100000)
>// Uncaught RangeError: Maximum call stack size exceeded(…)
>// 未捕获的RangeError:最大调用堆栈大小超过(…)  
>```
>
>上面代码中, `sum`是一个递归函数, 参数`x`是需要累加的值, 参数`y`控制递归次数。一旦指定`sum`递归 100000 次, 就会报错, 提示超出调用栈的最大次数。
>

##### a)  蹦床函数

>蹦床函数（trampoline）可以将递归执行转为循环执行。
>
>```javascript
>function trampoline(f) {
>  while (f && f instanceof Function) { f = f();}
>  return f;
>}
>```
>
>上面就是蹦床函数的一个实现, 它接受一个函数`f`作为参数。只要`f`执行后返回一个函数, 就继续执行。
>
>注意:`这里是返回一个函数, 然后执行该函数, 而不是函数里面调用函数, 这样就避免了递归执行, 从而就消除了调用栈过大的问题`。
>
>然后, 要做的就是将原来的递归函数, 改写为每一步返回另一个函数。
>
>```javascript
>function sum(x, y) {
>  if (y > 0)  return sum.bind(null, x + 1, y - 1);
>   else return x;
>}
>```
>
>上面代码中, `sum`函数的每次执行, 都会返回自身的另一个版本。
>
>现在, 使用蹦床函数执行`sum`, 就不会发生调用栈溢出。
>
>```javascript
>trampoline(sum(1, 100000))
>// 100001
>```
>

##### b) 真正的尾递归优化

>蹦床函数并不是真正的尾递归优化, 下面的实现才是。
>
>```javascript
>function tco(f) {
>  var value;
>  var active = false;
>  var accumulated = [];
>
>  return function accumulator() {
>    accumulated.push(arguments);
>    if (!active) {
>      active = true;
>      while (accumulated.length) {
>        value = f.apply(this, accumulated.shift());
>      }
>      active = false;
>      return value;
>    }
>  };
>}
>
>var sum = tco(function(x, y) {
>  if (y > 0) return sum(x + 1, y - 1)
>  else return x
>});
>
>sum(1, 100000)
>// 100001
>```
>
>上面代码中, `tco`函数是尾递归优化的实现, 它的奥妙就在于状态变量`active`。默认情况下, 这个变量是不激活的。一旦进入尾递归优化的过程, 这个变量就激活了。然后, 每一轮递归`sum`返回的都是`undefined`, 所以就避免了递归执行；而`accumulated`数组存放每一轮`sum`执行的参数, 总是有值的, 这就保证了`accumulator`函数内部的`while`循环总是会执行。这样就很巧妙地将“递归”改成了“循环”, 而后一轮的参数会取代前一轮的参数, 保证了调用栈只有一层。

#### ⑦ 尾调用优化默认关闭

>看到这想必一定很好奇, 既然尾调用优化如此高效, 为何都默认关闭了这个特性呢？答案分为两方面：
>
>1. ** `隐式优化问题` **: 由于引擎消除尾递归是隐式的, 函数是否符合尾调用而被消除了尾递归很难被程序员自己辨别；
>2. ** `调用栈丢失问题` **: 尾调用优化要求除掉尾调用执行时的调用堆栈, 这将导致执行流中的堆栈信息丢失。
>
>Chrome下使用尾递归写法的方法依旧出现调用栈溢出的原因在于：
>
>1. 直接原因： 各大浏览器（除了`safari`）根本就没部署尾调用优化；
>2. 根本原因： 尾调用优化依旧有隐式优化和调用栈丢失的问题；
>
>既然尾调用优化是默认关闭的, 是不是说尾调用没什么用了呢？
>
>> 其实不然, 尾调用是函数式编程一个重要的概念, 合理的应用尾调用可以大大提高我们代码的可读性和可维护性, 相比带来的一点性能损失, 写更优雅更易读的代码更为的重要

# `更多笔记看上方对应具体知识点笔记`
