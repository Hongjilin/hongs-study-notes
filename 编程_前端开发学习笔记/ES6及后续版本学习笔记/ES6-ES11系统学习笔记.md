# #说明

>本笔记是本人`ES6-ES11系统学习笔记`,将ES系列全部梳理一遍,包括新特性等
>
>观阅或查阅的资料:[[`尚硅谷Web前端ES6教程，涵盖ES6-ES11`](https://www.bilibili.com/video/BV1uK411H7on?share_source=copy_web)]、[阮一峰的ES6文档](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记/ES6资料文档摘录)
>
>除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、 **[ReactHooks笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ReactHooks笔记)** 、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了

# #目录

>[TOC]

# 一、ECMAScript引出

## 1、什么是 ECMA和ECMAScript

>`ECMA`（European Computer Manufacturers Association）中文名称为欧洲计算机制 造商协会，这个组织的目标是评估、开发和认可电信和计算机标准。1994 年后该 组织改名为 Ecma 国际。
>
>`ECMAScript` 是由 Ecma 国际通过 ECMA-262 标准化的脚本程序设计语言。

## 2、ECMA-262

>Ecma 国际制定了许多标准，而 ECMA-262 只是其中的一个，所有标准列表查看 -->[点我传送](https://www.ecma-international.org/publications-and-standards/standards/)

### Ⅰ-ECMA-262 历史

>ECMA-262（ECMAScript）历史版本查看网址: -->[点我传送](https://www.ecma-international.org/publications-and-standards/standards/ecma-262/)
>
>| 版数      | 年份               | 内容                                                         |
>| --------- | ------------------ | ------------------------------------------------------------ |
>| 第 1 版   | 1997 年            | 制定了语言的基本语法                                         |
>| 第 2 版   | 1998 年            | 较小改动                                                     |
>| 第 3 版   | 1999 年            | 引入正则、异常处理、格式化输出等。IE 开始支持                |
>| 第 4 版   | 2007 年            | 过于激进，未发布                                             |
>| 第 5 版   | 2009 年            | 引入严格模式、JSON，扩展对象、数组、原型、字符串、日期方法   |
>| `第 6 版` | `2015 年`          | 模块化、面向对象语法、 Promise、箭头函数、let、 const、数组解构赋值等等<br />因为发布内容很多,堪称里程碑,所以我们目前通常主要学这个 |
>| 第 7 版   | 2016 年            | 幂运算符、数组扩展、 Async/await 关键字                      |
>| 第 8 版   | 2017 年            | Async/await、字符串扩展                                      |
>| 第 9 版   | 2018 年            | 对象解构赋值、正则扩展                                       |
>| 第 10 版  | 2019 年            | 扩展对象、数组方法                                           |
>| ES.next   | 动态指向下一个版本 | `后续学到我会进行补充`                                       |
>
>`注：从 ES6 开始，每年发布一个版本，版本号比年份最后一位大 1`

### Ⅱ-谁在维护 ECMA-262

>TC39（Technical Committee 39）是推进 ECMAScript 发展的委员会。其会员都是公司（`其中主要是浏览器厂商`:有苹果、谷歌、微软、因特尔等）。TC39 定期 召开会议，会议由会员公司的代表与特邀专家出席

## 3、为什么要重点学习 ES6

>* ES6 的版本变动内容最多，具有里程碑意义
>* ES6 加入许多新的语法特性，编程实现更简单、高效
>* ES6 是前端发展趋势，就业必备技能

## 4、ES6 兼容性

>可以查看gitHub上的这个图-->[点我传送](http://kangax.github.io/compat-table/es6/)

# 二、ECMASript 6 新特性

> 想要查看更详细的ES6,可以看阮一峰的ES6文档,本人当初对其进行了摘录放至此处方便查阅-->**[ES6资料文档摘录](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记/ES6资料文档摘录)** ,当然此笔记中也会对其内容有所摘录梳理
>
> 此处ES6部分笔记主要为:`查看教程时笔记+查阅的资料博客整合摘录+个人心得体会`,以及在相当一段工作时间中觉得常用或者是需要重点学习的理解整合

## 1、let和const命令、作用域

> 注意:`不存在变量提升`
>
> `var`命令会发生“变量提升”现象，即变量可以在声明之前使用，值为`undefined`。这种现象多多少少是有些奇怪的，按照一般的逻辑，变量应该在声明语句之后才可以使用。
>
> 为了纠正这种现象，`let`、`const`命令改变了语法行为，它所声明的变量一定要在声明后使用，否则报错

### Ⅰ-let关键字命令

>let 关键字用来声明变量，使用 let 声明的变量有几个特点： 
>
>- 不允许重复声明 
>- 块级作用域 
>- 不存在变量提升 
>- 不影响作用域链
>
>应用场景：声明重复赋值的变量时可以用这个,如果你不是要求很高的话,基本上都能用let进行声明(var声明的可以都用这个替代了)

### Ⅱ-const关键字命令

>const 关键字用来声明常量，const 声明有以下特点:
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
>> `const`实际上保证的，`并不是变量的值不得改动，而是变量指向的那个内存地址所保存的数据不得改动`。
>>
>> 对于简单类型的数据（数值、字符串、布尔值），值就保存在变量指向的那个内存地址，因此等同于常量。但对于复合类型的数据（主要是对象和数组），变量指向的内存地址，保存的只是一个指向实际数据的指针，`const`只能保证这个指针是固定的（即总是指向另一个固定的地址），至于它指向的数据结构是不是可变的，就完全不能控制了。因此，将一个对象声明为常量必须非常小心。
>
>应用场景：声明对象类型、确定不会再次赋值的变量使用 const，其他的可以用let

### Ⅲ-ES6 声明变量的六种方法

>ES5 只有两种声明变量的方法：`var`命令和`function`命令。ES6 除了添加`let`和`const`命令，后面还会提到，另外两种声明变量的方法：`import`命令和`class`命令。所以，ES6 一共有 6 种声明变量的方法。

### Ⅳ-块级作用域

#### ① 为什么需要块级作用域？

>ES5 只有全局作用域和函数作用域，没有块级作用域，这带来很多不合理的场景。
>
>第一种场景，内层变量可能会覆盖外层变量。
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
>上面代码的原意是，`if`代码块的外部使用外层的`tmp`变量，内部使用内层的`tmp`变量。但是，函数`f`执行后，输出结果为`undefined`，原因在于变量提升，导致内层的`tmp`变量覆盖了外层的`tmp`变量。
>
>第二种场景，用来计数的循环变量泄露为全局变量。
>
>```javascript
>var s = 'hello';
>for (var i = 0; i < s.length; i++) { console.log(s[i]);}
>console.log(i); // 5
>```
>
>上面代码中，变量`i`只用来控制循环，但是循环结束后，它并没有消失，泄露成了全局变量。

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
>上面的函数有两个代码块，都声明了变量`n`，运行后输出 5。这表示外层代码块不受内层代码块的影响。如果两次都使用`var`定义变量`n`，最后输出的值才是 10。
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
>上面代码使用了一个五层的块级作用域，每一层都是一个单独的作用域。`第四层作用域无法读取第五层作用域的内部变量`。
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
>块级作用域的出现，实际上使得获得广泛应用的匿名立即执行函数表达式（匿名 IIFE）不再必要了。-->[对于IIFE不懂的可以看本人JS进阶笔记,点我跳转](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/HTML+CSS+JS%E5%9F%BA%E7%A1%80%E7%AC%94%E8%AE%B0/JavaScript%E7%AC%94%E8%AE%B0#-%E5%B8%B8%E8%A7%81%E7%9A%84%E5%9B%9E%E8%B0%83%E5%87%BD%E6%95%B0)
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
>ES5 规定，函数只能在顶层作用域和函数作用域之中声明，不能在块级作用域声明。
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
>上面两种函数声明，根据 ES5 的规定都是非法的。
>
>但是，浏览器没有遵守这个规定，为了兼容以前的旧代码，还是支持在块级作用域之中声明函数，因此上面两种情况实际都能运行，不会报错。
>
>ES6 引入了块级作用域，明确允许在块级作用域之中声明函数。ES6 规定，块级作用域之中，函数声明语句的行为类似于`let`，在块级作用域之外不可引用。
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
>上面代码在 ES5 中运行，会得到“I am inside!”，因为在`if`内声明的函数`f`会被提升到函数头部，实际运行的代码如下。
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
>ES6 就完全不一样了，理论上会得到“I am outside!”。因为块级作用域内声明的函数类似于`let`，对作用域之外没有影响。但是，如果你真的在 ES6 浏览器中运行一下上面的代码，是会报错的，这是为什么呢？
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
>上面的代码在 ES6 浏览器中，都会报错。
>
>原来，如果改变了块级作用域内声明的函数的处理规则，显然会对老代码产生很大影响。为了减轻因此产生的不兼容问题，ES6 在[附录 B](http://www.ecma-international.org/ecma-262/6.0/index.html#sec-block-level-function-declarations-web-legacy-compatibility-semantics)里面规定，浏览器的实现可以不遵守上面的规定，有自己的[行为方式](http://stackoverflow.com/questions/31419897/what-are-the-precise-semantics-of-block-level-functions-in-es6)。
>
>- 允许在块级作用域内声明函数。
>- 函数声明类似于`var`，即会提升到全局作用域或函数作用域的头部。
>- 同时，函数声明还会提升到所在的块级作用域的头部。
>
>注意，上面三条规则只对 ES6 的浏览器实现有效，其他环境的实现不用遵守，还是将块级作用域的函数声明当作`let`处理。
>
>根据这三条规则，浏览器的 ES6 环境中，块级作用域内声明的函数，行为类似于`var`声明的变量。上面的例子实际运行的代码如下。
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
>考虑到环境导致的行为差异太大，应该避免在块级作用域内声明函数。如果确实需要，也应该写成函数表达式，而不是函数声明语句。
>
>```javascript
>// 块级作用域内部的函数声明语句，建议不要使用
>{
>  let a = 'secret';
>  function f() {  return a; }
>}
>
>// 块级作用域内部，优先使用函数表达式
>{
>  let a = 'secret';
>  let f = function () {
>    return a;
>  };
>}
>```
>
>另外，还有一个需要注意的地方。ES6 的块级作用域必须有大括号，如果没有大括号，JavaScript 引擎就认为不存在块级作用域。
>
>```javascript
>// 第一种写法，报错
>if (true) let x = 1;
>
>// 第二种写法，不报错
>if (true) {
>  let x = 1;
>}
>```
>
>上面代码中，第一种写法没有大括号，所以不存在块级作用域，而`let`只能出现在当前作用域的顶层，所以报错。第二种写法有大括号，所以块级作用域成立。
>
>函数声明也是如此，严格模式下，函数只能声明在当前作用域的顶层。
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



## 2、赋值解构

>ES6 允许按照一定模式，`从数组和对象中提取值，对变量进行赋值`，这被称为解构（Destructuring）。
>
>本质上，这种写法属于“`模式匹配`”，只要等号两边的模式相同，左边的变量就会被赋予对应的值

### Ⅰ-基本用法

#### ① 基本用法举例

>以前，为变量赋值，只能直接指定值。
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
>上面代码表示，可以从数组中提取值，按照对应位置，对变量赋值。
>
>本质上，这种写法属于“模式匹配”，只要等号两边的模式相同，左边的变量就会被赋予对应的值。下面是一些使用嵌套数组进行解构的例子。
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
>如果解构不成功，变量的值就等于`undefined`。
>
>```javascript
>let [foo] = [];
>let [bar, foo] = [1];
>```
>
>以上两种情况都属于解构不成功，`foo`的值都会等于`undefined`。
>
>另一种情况是不完全解构，即等号左边的模式，只匹配一部分的等号右边的数组。这种情况下，解构依然可以成功。
>
>```javascript
>let [x, y] = [1, 2, 3];//x : 1  y : 2 
>let [a, [b], d] = [1, [2, 3], 4];//a : 1 b : 2 d : 4
>```
>
>上面两个例子，都属于不完全解构，但是可以成功。
>
>如果等号的右边不是数组（或者严格地说，不是可遍历的结构，参见《Iterator》一章），那么将会报错。
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
>上面的语句都会报错，因为等号右边的值，要么转为对象以后不具备 Iterator 接口（前五个表达式），要么本身就不具备 Iterator 接口（最后一个表达式）。
>
>`对于 Set 结构，也可以使用数组的解构赋值`。
>
>```javascript
>let [x, y, z] = new Set(['a', 'b', 'c']);
>x // "a"
>```
>
>事实上，只要某种数据结构具有 Iterator 接口，都可以采用数组形式的解构赋值。
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
>上面代码中，`fibs`是一个 Generator 函数（详见《Generator 函数》），原生具有 Iterator 接口。解构赋值会依次从这个接口获取值。

#### ② 默认值

>解构赋值允许指定默认值。
>
>```javascript
>let [foo = true] = [];//foo = true
>let [x, y = 'b'] = ['a']; // x='a', y='b'
>let [x, y = 'b'] = ['a', undefined]; // x='a', y='b'
>```
>
>注意，ES6 内部使用严格相等运算符（`===`），判断一个位置是否有值。所以，只有当一个数组成员严格等于`undefined`，默认值才会生效。
>
>```javascript
>let [x = 1] = [undefined];//x = 1
>let [x = 1] = [null];//x = null
>```
>
>上面代码中，如果一个数组成员是`null`，默认值就不会生效，因为`null`不严格等于`undefined`。
>
>如果默认值是一个表达式，那么这个表达式是惰性求值的，即只有在用到的时候，才会求值。
>
>```javascript
>function f() { console.log('aaa');}
>let [x = f()] = [1];
>```
>
>上面代码中，因为`x`能取到值，所以函数`f`根本不会执行。上面的代码其实等价于下面的代码。
>
>```javascript
>let x;
>if ([1] === undefined) { x = f()} 
>else { x = [1]; }
>```
>
>默认值可以引用解构赋值的其他变量，但该变量必须已经声明。
>
>```javascript
>let [x = 1, y = x] = [];     // x=1; y=1
>let [x = 1, y = x] = [2];    // x=2; y=2
>let [x = 1, y = x] = [1, 2]; // x=1; y=2
>let [x = y, y = 1] = [];     // ReferenceError: y is not defined
>```
>
>上面最后一个表达式之所以会报错，是因为`x`用`y`做默认值时，`y`还没有声明。

### Ⅱ-对象的赋值解构

> `此处应用的非常多`,需要多查阅

#### ① 基本用法

>解构不仅可以用于数组，还可以用于对象。
>
>```javascript
>let { foo, bar } = { foo: 'aaa', bar: 'bbb' };//foo = "aaa"; bar = "bbb"
>```
>
>对象的解构与数组有一个重要的不同。`数组的元素是按次序排列的，变量的取值由它的位置决定；而对象的属性没有次序，变量必须与属性同名，才能取到正确的值`
>
>```javascript
>let { bar, foo } = { foo: 'aaa', bar: 'bbb' };//foo = "aaa" ; bar = "bbb"
>let { baz } = { foo: 'aaa', bar: 'bbb' };//baz = undefined
>```
>
>上面代码的第一个例子，等号左边的两个变量的次序，与等号右边两个同名属性的次序不一致，但是对取值完全没有影响。第二个例子的变量没有对应的同名属性，导致取不到值，最后等于`undefined`。
>
>如果解构失败，变量的值等于`undefined`。
>
>```javascript
>let {foo} = {bar: 'baz'};//foo = undefined
>```
>
>上面代码中，等号右边的对象没有`foo`属性，所以变量`foo`取不到值，所以等于`undefined`。
>
>对象的解构赋值，可以很方便地将现有对象的方法，赋值到某个变量。
>
>```javascript
>// 例一
>let { log, sin, cos } = Math;
>// 例二
>const { log } = console;
>log('hello') // hello
>```
>
>上面代码的例一将`Math`对象的对数、正弦、余弦三个方法，赋值到对应的变量上，使用起来就会方便很多。例二将`console.log`赋值到`log`变量。
>
>如果变量名与属性名不一致，必须写成下面这样-->`取别名`
>
>```javascript
>let { foo: baz } = { foo: 'aaa', bar: 'bbb' };//baz = "aaa"
>
>let obj = { first: 'hello', last: 'world' };
>let { first: f, last: l } = obj;//f = 'hello' ; l = 'world'
>```
>
>这实际上说明，对象的解构赋值是下面形式的简写（详见《对象的扩展》）。
>
>```javascript
>let { foo: foo, bar: bar } = { foo: 'aaa', bar: 'bbb' };
>```
>
>也就是说，对象的解构赋值的内部机制，是先找到同名属性，然后再赋给对应的变量。真正被赋值的是后者，而不是前者。
>
>```javascript
>let { foo: baz } = { foo: 'aaa', bar: 'bbb' };
>//baz = "aaa";
>//foo = error: foo is not defined
>```
>
>上面代码中，`foo`是匹配的模式，`baz`才是变量。真正被赋值的是变量`baz`，而不是模式`foo`。
>
>与数组一样，解构也可以用于嵌套结构的对象。
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
>注意，这时`p`是模式，不是变量，因此不会被赋值。如果`p`也要作为变量赋值，可以写成下面这样。
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
>上面代码有三次解构赋值，分别是对`loc`、`start`、`line`三个属性的解构赋值。注意，最后一次对`line`属性的解构赋值之中，只有`line`是变量，`loc`和`start`都是模式，不是变量。
>
>下面是嵌套赋值的例子。-->`注意:外部包着一层()`:
>
>```javascript
>let obj = {};
>let arr = [];
>({ foo: obj.prop, bar: arr[0] } = { foo: 123, bar: true });
>//因为 JavaScript 引擎会将`{x}`理解成一个代码块，从而发生语法错误。`只有不将大括号写在行首`，避免 JavaScript 将其解释为代码块，才能解决这个问题。
>//obj == {prop:123}
>//arr == [true]
>```
>
>如果解构模式是嵌套的对象，而且子对象所在的父属性不存在，那么将会报错。
>
>```javascript
>// 报错
>let {foo: {bar}} = {baz: 'baz'};
>```
>
>上面代码中，等号左边对象的`foo`属性，对应一个子对象。该子对象的`bar`属性，解构时会报错。原因很简单，因为`foo`这时等于`undefined`，再取子属性就会报错。
>
>注意，对象的解构赋值可以取到继承的属性。
>
>```javascript
>const obj1 = {};
>const obj2 = { foo: 'bar' };
>Object.setPrototypeOf(obj1, obj2);//Object.setPrototypeOf() 方法设置一个指定的对象的原型 ( 即, 内部[[Prototype]]属性）到另一个对象或  null
>const { foo } = obj1;
>foo // "bar"
>```
>
>上面代码中，对象`obj1`的原型对象是`obj2`。`foo`属性不是`obj1`自身的属性，而是继承自`obj2`的属性，解构赋值可以取到这个属性。
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
>默认值生效的条件是，对象的属性值严格等于`undefined`。
>
>```javascript
>var {x = 3} = {x: undefined};//x == 3
>var {x = 3} = {x: null};//x == null
>```
>
>上面代码中，属性`x`等于`null`，因为`null`与`undefined`不严格相等，所以是个有效的赋值，导致默认值`3`不会生效。-->[原因上面讲过](#② 默认值)

#### ③ 注意点

>（1）如果要将一个已经声明的变量用于解构赋值，必须非常小心。
>
>```javascript
>// 错误的写法
>let x;
>{x} = {x: 1};
>// SyntaxError: syntax error
>```
>
>上面代码的写法会报错，因为 JavaScript 引擎会将`{x}`理解成一个代码块，从而发生语法错误。`只有不将大括号写在行首`，避免 JavaScript 将其解释为代码块，才能解决这个问题。
>
>```javascript
>// 正确的写法
>let x;
>({x} = {x: 1});
>```
>
>上面代码将整个解构赋值语句，`放在一个圆括号里面，就可以正确执行`。关于圆括号与解构赋值的关系，参见下文。
>
>（2）解构赋值允许等号左边的模式之中，不放置任何变量名。因此，可以写出非常古怪的赋值表达式。
>
>```javascript
>({} = [true, false]);
>({} = 'abc');
>({} = []);
>```
>
>上面的表达式虽然毫无意义，但是语法是合法的，可以执行。
>
>（3）`由于数组本质是特殊的对象，因此可以对数组进行对象属性的解构`。
>
>```javascript
>let arr = [1, 2, 3];
>let {0 : first, [arr.length - 1] : last} = arr;
>//first == 1
>//last == 3
>```
>
>上面代码对数组进行对象解构。数组`arr`的`0`键对应的值是`1`，`[arr.length - 1]`就是`2`键，对应的值是`3`。方括号这种写法，属于“属性名表达式”（详见《对象的扩展》）。
