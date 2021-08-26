>本笔记是ES系列知识点笔记梳理与本人新的体会,当然记录最多的应该还是`ES6`部分知识点,因为也是最常用的
>
>ES6相关材料摘录本人放至隔壁`[ES6资料文档摘录]目录中` ,此处是本人看阮一峰老师写的ES6相关材料时摘录下来的 -->**[点我传送](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记/ES6资料文档摘录)** 
>
>本人笔记地址分享:[全部笔记](https://gitee.com/hongjilin/hongs-study-notes)、**[ES6资料文档摘录](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记/ES6资料文档摘录)** 
>

# #目录

>[TOC]

# ES系列知识补充与应用实践

# 一、实践过程补充知识点

### Ⅰ-ES6小知识点:`连续赋值解构`+重命名

>```js
>	let obj = {a:{b:1}}
>	const {a} = obj; //传统解构赋值
>	const {a:{b}} = obj; //连续解构赋值
>	const {a:{b:value}} = obj; //连续解构赋值+重命名
>```

### Ⅱ-多个连续箭头函数-`高阶箭头函数、柯里化`

#### 1、`高阶函数`

>1. 所谓高阶函数，就是一个函数就可以接收另一个函数作为参数，或者是返回一个函数-->常见的高阶函数有map、reduce、filter、sort等
>
>   ```js
>   var ADD =function add(a) {
>    return function(b) {
>     return a+b
>    }
>   }
>    调用：ADD(2)(3)即可获得结果
>   ```
>
>2. map
>
>   ```js
>   map接受一个函数作为参数，不改变原来的数组，只是返回一个全新的数组
>   var arr = [1,2,3,4,5]
>    var arr1 = arr.map(item => item = 2)// 输出[2, 2, 2, 2, 2]
>   ```
>
>3. reduce
>
>   ```js
>   reduce也是返回一个全新的数组。reduce接受一个函数作为参数，这个函数要有两个形参，代表数组中的前两项，reduce会将这个函数的结果与数组中的第三项再次组成这个函数的两个形参以此类推进行累积操作
>   var arr = [1,2,3,4,5]
>   var arr2 = arr.reduce((a,b)=> a+b)
>   console.log(arr2) // 15
>   ```
>
>4. filter
>
>   ```js
>   filter返回过滤后的数组。filter也接收一个函数作为参数，这个函数将作用于数组中的每个元素，根据该函数每次执行后返回的布尔值来保留结果，如果是true就保留，如果是false就过滤掉（这点与map要区分）
>   var arr = [1,2,3,4,5]
>    var arr3 = arr.filter(item => item % 2 == 0)
>   console.log(arr3)// [2,4]
>   ```

#### 2、从 ES6 高阶箭头函数理解函数柯里化

>1. 首先看到了这样的一个例子：
>
>   ```js
>   let add = a => b => a + b
>   ```
>
>2. 以上是一个很简单的相加函数，把它转化成 ES5 的写法如下
>
>   ```js
>   function add(a) {
>       return function(b) {
>           return a + b
>       }
>   }
>    
>   var add3 = add(3) //add3表示一个指向函数的变量 可以当成函数调用名来用
>   add3(4) === 3 + 4 //true
>   ```
>
>3. 再简化一下，可以写成如下形式：
>
>   ```js
>   let add = function(a) {
>       var param = a;
>       var innerFun = function(b) {
>           return param + b;
>       }
>       return innerFun;
>   }
>   ```
>
>4. 虽然好像没什么意义，但是很显然上述使用了闭包，而且该函数的返回值是一个函数。其实，这就是`高阶函数的定义：以函数为参数或者返回值是函数的函数。`
>
>   ![image-20210415160945789](ES6及后续版本学习笔记中的图片/image-20210415160945789.png)

#### 3、柯里化

>1. 图例:
>
>   ![image-20210415161137977](ES6及后续版本学习笔记中的图片/image-20210415161137977.png)
>
>2. 关键就是`理解柯里化`，其实可以把它理解成，柯里化后，`将第一个参数变量存在函数里面了(闭包)`，然后本来需要n个参数的函数可以变成只需要剩下的（n - 1个）参数就可以调用，比如
>
>   ```js
>   let add = x => y => x + y
>   let add2 = add(2)
>   -*----------------------------------
>   本来完成 add 这个操作，应该是这样调用
>   let add = (x, y) => x + y
>   add(2,3)
>   ----------------------------------
>   1. 而现在 add2 函数完成同样操作只需要一个参数，这在函数式编程中广泛应用。
>   let add = x => y => x + y
>   let add2 = add(2)
>   2.详细解释一下，就是 add2 函数 等价于 有了 x 这个闭包变量的 y => x + y 函数,并且此时 x = 2，所以此时调用
>   add2(3) === 2 + 3
>   ```

#### 4、总结

>1. 如果是`a => b => c => {xxx}`这种多次柯里化的,如何理解
>
>   理解:前` n - 1 `次调用，其实是提前将参数传递进去，并没有调用最内层函数体，最后一次调用才会调用最内层函数体，并返回最内层函数体的返回值
>
>2. 结合上文可知，这里的多个连续箭头（无论俩个箭头函数三个及以上）函数连在一起 就是在柯里化。所以连续箭头函数就是多次柯里化函数的 es6 写法。
>
>3. `调用特点`:let test = a => b => c => {xxx}
>
>   比如对于上面的 `test` 函数，它有 3 个箭头， 这个函数要被调用 3 次 `test(a)(b)(c)`，前两次调用只是在传递参数，只有最后依次调用才会返回 `{xxx}` 代码段的返回值，并且在 `{xxx}` 代码段中可以调用 a,b,c



### Ⅲ- Array.filter(Boolean)

>ECMAScirpt5 中 ***Array*** 类中的 ***filter*** 方法使用目的是移除所有的 *”false“* 类型元素 *(**`false`**, **`null`**, **`undefined`**, **`0`**, **`NaN`** or **an empty string**)*：
>
>Boolean 是一个函数，它会对遍历数组中的元素，并根据元素的真假类型，对应返回 true 或 false.
>
>```tsx
>const a=[1,2,"b",0,{},"",NaN,3,undefined,null,5];
>let b=a.filter(Boolean); // [1,2,"b",{},3,5]
>
>this.menus = this.menuRouterConfig.filter(Boolean);//可以用作路由处理,将不符合权限的部分置为空,再通过此函数进行筛选
>```

### Ⅳ-取别名

>1. 代码场景:当你在同一代码块中取两个对象的同一属性使用时(特别是赋值解构场景下)
>2. 示例代码
>
>  ```js
>  const obj1={a:1,b:2};
>  const obj2={a:'努力学习的汪',c:'hongjilin'}
>  //一般来说,如果我们只要取两个对象中的[a]属性值的时候,我们会用赋值解构方式,这样写更方便
>  const { a } = obj1
>  const { a } = obj2 //但是a已经声明了,会报错!!!
>  //那如何避免上述问题呢?取别名就是一个很好的方式
>  const { a } = obj1
>  const {a:name} = obj2 
>  //此时name就是obj2中的a属性了
>console.log(a,name)//1 努力学习的汪
>  ```







# 二、Proxy模拟实现Vue的双向绑定

> 更多`Proxy`相关知识点(摘录)  -->[点我传送](https://gitee.com/hongjilin/hongs-study-notes/blob/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/ES6%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99%E6%91%98%E5%BD%95%E4%B8%8E%E7%AC%94%E8%AE%B0/13%E3%80%81Es6_Proxy_%E9%87%8D%E8%A6%81.md)
>
> `Proxy`就像一个代理器,当有人对目标对象进行处理(set、has、get 等等操作)的时候它会首先经过它，这时我们可以使用代码进行处理，此时`Proxy`相当于一个中介或者叫代理人,它经常被用于代理模式中,可以做字段验证、缓存代理、访问控制等等。
>
> 此处我自己用Proxy实现Vue的双向绑定

### 1.`Object.defineProperty`

>众所周知，`vue`使用了`Object.defineProperty`来做数据劫持，它是利用劫持对象的访问器,在属性值发生变化时我们可以获取变化,从而进行进一步操作
>
>```js
>const obj = { a: 1 }
>Object.defineProperty(obj, 'a', {
>get: function() {
>console.log('get val')
>},
>set: function(newVal) {
>console.log('set val:' + newVal)
>}
>})
>```

### 2.与`Object.defineProperty`相比，`Proxy`的优势

>1. 数组作为特殊的对象，但Object.defineProperty无法监听数组变化。
>
>2. Object.defineProperty只能劫持对象的属性,因此我们需要对每个对象的每个属性进行遍历，如果属性值也是对象那么需要深度遍历,显然能劫持一个完整的对象是更好的选择。
>
>3. Proxy 有多达 13 种拦截方法,不限于apply、ownKeys、deleteProperty、has等等是Object.defineProperty不具备的。
>
>4. Proxy返回的是一个新对象,我们可以只操作新的对象达到目的,而Object.defineProperty只能遍历对象属性直接修改
>
>5. Proxy作为新标准将受到浏览器厂商重点持续的性能优化

### 3. 手写双向绑定代码

>1. 简单实现双向绑定
>
>  ```js
>  --------------------  html  ----------------------------
>    <input id="input_el" oninput="inputHandle(this)" type="text">
>    <br />
>    <div id="show_el"></div>
>  -------------------  js ------------------------------
>  <script>
>    proxy_bind = (traget) => {
>      return new Proxy(traget, {
>        get(obj, name) {
>          console.log("获取")
>          //如果传入的key并没有,则赋初始值
>          if (!obj[name]) obj[name] = ""
>          //根据传入的key进行相应属性返回
>          return obj[name]
>        },
>        //拦截的对象,拦截对象的值,传入要修改的值,(第四个参数通常不用,返回整个Proxy对象)
>        set(obj, name, val) {
>          console.log("写入")
>          obj[name] = val
>          //将输入狂内容即修改的proxy对象属性渲染到页面节点上
>          document.querySelector("#show_el").innerHTML = obj[name]
>          return;
>        }
>      })
>    }
>    inputHandle = (e) => {
>      //将输入框的值赋值给proxy对象的value属性上，此处触发proxy的`set（）`
>      obj_bind.value = e.value
>    }
>
>    let obj = {
>      a: "2",
>      b: 3,
>      value: "默认值"
>    }
>    let obj_bind = proxy_bind(obj)
>    //自闭合，如果前面没有加分号 会导致压缩式合并到前面去就会报错，以防万一加分号，此处触发proxy的`get（）`
>    ;
>    (function () {
>      document.querySelector("#show_el").innerHTML = obj_bind.value
>      document.querySelector("#input_el").value = obj_bind.value
>    })()
>  </script>
>  ```
>
>2. 模拟vue实现完整双向绑定实现
>
>  ```js
>  --------------------  html  ----------------------------
>  <div>
>    <p>请输入:</p>
>    <input type="text" id="input">
>    <p id="p"></p>
>  </div>
>  -------------------  js ------------------------------
>  class Watcher {
>    constructor(vm, key, callback) {
>      this.vm = vm
>      this.callback = callback
>      this.key = key // 被订阅的数据
>      this.val = this.get() // 维护更新之前的数据
>      vm.$data = this.createProxy(vm.$data)
>    }
>
>    update(newVal) {
>      this.callback(newVal)
>    }
>    get() {
>      const val = this.vm.$data[this.key]
>      return val
>    }
>    createProxy(data) {
>      let _this = this
>      let handler = {
>        get(target, property) {
>          return Reflect.get(target, property)
>        },
>        set(target, property, value) {
>          let res = null
>          if (target[property] != value) {
>            const isOk = Reflect.set(target, property, value)
>            if (_this.key === property) {
>              // 同一层级
>              res = value
>            } else {
>              res = _this.get()
>              console.log(res)
>            }
>            _this.callback(res)
>            return isOk
>          }
>        }
>      }
>
>      return toDeepProxy(data, handler)
>
>      function toDeepProxy(object, handler) {
>        if (!isPureObject(object)) addSubProxy(object, handler)
>        return new Proxy(object, handler)
>
>        function addSubProxy(object, handler) {
>          for (let prop in object) {
>            if (typeof object[prop] == 'object') {
>              if (!isPureObject(object[prop])) addSubProxy(object[prop], handler)
>              object[prop] = new Proxy(object[prop], handler)
>            }
>          }
>          object = new Proxy(object, handler)
>        }
>
>        function isPureObject(object) {
>          if (typeof object !== 'object') {
>            return false
>          } else {
>            for (let prop in object) {
>              if (typeof object[prop] == 'object') {
>                return false
>              }
>            }
>          }
>          return true
>        }
>      }
>    }
>  }
>
>  class Vue {
>    constructor(data) {
>      // 将所有data最外层属性代理到实例上
>      this.$data = data
>      Object.keys(data).forEach(key => this.$proxy(key))
>    }
>    $watch(key, cb) {
>      new Watcher(this, key, cb)
>    }
>    $proxy(key) {
>      Reflect.defineProperty(this, key, {
>        configurable: true,
>        enumerable: true,
>        get: () => this.$data[key],
>        set: val => {
>          this._data[key] = val
>        }
>      })
>    }
>  }
>
>  const p = document.getElementById('p')
>  const input = document.getElementById('input')
>
>  const data = new Vue({ text: { a: '' } })
>
>  input.addEventListener('keyup', function(e) {
>    data.text.a = e.target.value
>  })
>
>  data.$watch('text', content => p.innerHTML = content.a)
>
>  ```



# 三、问题与解决

### Ⅰ-`import`动态导入图片时报错

>1. 问题一:使用`import a from "@/img/"+url`时报错
>
>   解决:使用const a = require(`@/img/${文件名}${后缀名}`)
>
>2. 问题而:问题一解决后用`require后发现出现警告`
>
>   解决:拼接时将后缀名用写死的方式拼接
>
>   ```js
>   requImg = require(`@/img/${url}.png)
>   ```

# 四、ES6常用知识点梳理

## Ⅰ-常见用法与示例整理

### 1、`解构赋值`

#### ①、 使用结构赋值，实现两个变量的值的交换（编程题）。

```javascript
let a = 1;
let b = 2;
[a,b] = [b,a]
123
```

------

#### ②、使用解构赋值，完成函数的参数默认值（编程题）。

```javascript
let test = (name='tom')=>{
    console.log(name);
}
test();//tom
```

### 2、`Set、Map方面问题`

#### ①、关于Set结构，阅读下面的代码，回答问题。（代码阅读题）。

```javascript
let s = new Set();
s.add([1]);
s.add([1]);
console.log(s.size);
1234
```

> **问：打印出来的size的值是多少？**
>
> 答：2，两个[1]定义的是两个不同的数组，在内存中的存储地址不同，所以是不同的值

#### ②、关于Map结构，阅读下面的代码，回答问题。（代码阅读题）

```javascript
let map = new Map();
map.set([1],"ES6系列");
let con = map.get([1]);
console.log(con);
1234
```

> **>问：打印出来的变量con的值是多少，为什么？**
>
> 答：undefined。因为set的时候用的数组[1]和get的时候用的数组[1]是分别两个不同的数组，只不过它们元素都是1。它们是分别定义的两个数组，并不是同一个值。
> 如果想达到预期的效果，你要保证get的时候和set的时候用同一个数组。比如：

```javascript
let map = new Map();
let arr = [1];
map.set(arr,"ES6系列");
let con = map.get(arr);
console.log(con); //ES6系列
```

#### ③、代码阅读

```js
var str='abstract';
console.log(new Set([...str]).size);
//6  重复的无法加入
```



### 3、`let、const相关`

#### ①赋值问题

> let赋值将new一个新的地址给let变量，改变引用，每次赋值都是。 
>
> 如果不改变引用  使用obj.xx的方式  或者是arr.push等

```js
①
const c={c:1}; let d=c  
d.c=2  //c={c:2} d={c:2}
②
//当d没有赋值（=）时候 赋值的是引用,   赋值则是直接给新的地址
const c={c:1} ; let d=c; d={c:10}
d.c=8  //c={c:2} d={c:10}
③
//const不能改变的是它的引用，而不是引用上的值
const q= {a:12}  
q={a:13}  //报错  不能重新赋值
q.a=13		//｛a:13｝ 成功
④
const a   //报错   const声明的时候必须初始化赋值
```

### 4、`数组相关问题`

#### ①reverse（）数组反转

> 会对数组直接进行改变

```js
aw.reverse()
(5) [2, 3, 4, 5, 8]
aw.reverse()
(5) [8, 5, 4, 3, 2]
```

5.5、`symbol相关`

①**设计一个对象，键名的类型至少包含一个symbol类型，并且实现遍历所有key。（编程题）**

```js
let name = Symbol(‘name‘)；let product = {　　[name]："洗衣机"，　　"price":799}；Reflect.ownKeys(product)；
```





## Ⅱ-字符串的新增方法

### 1、JSON.stringify() 

> **作用是将 JavaScript 对象转换为 JSON 字符串**

### 2、JSON.parse()

> ***JSON.parse()将字符串c还原成对象a***

### 3、String.fromCodePoint()

> 可以识别大于`0xFFFF`的字符，弥补了`String.fromCharCode()`方法的不足

### 4、codePointAt()

> 能够正确处理 4 个字节储存的字符，返回一个字符的码点。

### 5、String.raw()

> 该方法返回一个斜杠都被转义（即斜杠前面再加一个斜杠）的字符串，往往用于模板字符串的处理方法。

### 6、includes(), startsWith(), endsWith()

>- **includes()**：返回布尔值，表示是否找到了参数字符串。
>- **startsWith()**：返回布尔值，表示参数字符串是否在原字符串的头部。
>- **endsWith()**：返回布尔值，表示参数字符串是否在原字符串的尾部。

```javascript
let s = 'Hello world!';s.startsWith('Hello') // trues.endsWith('!') // trues.includes('o') // true
```

### 7、repeat()

> `repeat`方法返回一个新字符串，表示将原字符串重复`n`次。

```javascript
'x'.repeat(3) // "xxx"'hello'.repeat(2) // "hellohello"'na'.repeat(0) // ""'na'.repeat(2.9) // "nana"
```

### 8、padStart()，padEnd()

> `adStart()`用于头部补全，`padEnd()`用于尾部补全。

```javascript
'x'.padStart(5, 'ab') // 'ababx''x'.padStart(4, 'ab') // 'abax''x'.padEnd(5, 'ab') // 'xabab''x'.padEnd(4, 'ab') // 'xaba'
```

### 9、trimStart()，trimEnd()

> `trimStart()`消除字符串头部的空格，`trimEnd()`消除尾部的空格。它们返回的都是新字符串，不会修改原始字符串。

```javascript
const s = '  abc  ';s.trim() // "abc"s.trimStart() // "abc  "s.trimEnd() // "  abc
```

### 10、replaceAll()

> 替换所有匹配

```javascript
'aabbcc'.replaceAll('b', '_')// 'aa__cc'
```

## Ⅲ-数值的拓展方法

### 1、Number.isFinite(), Number.isNaN()

> `Number.isFinite()`用来检查一个数值是否为`有限的（finite）`，即不是Infinity 注意，如果参数类型不是数值，Number.isFinite一律返回false。
>
> `Number.isNaN()`用来检查一个值是否为`NaN`。

```javascript
Number.isFinite(0.8); // trueNumber.isFinite(NaN); // falseNumber.isFinite(Infinity); // falseNumber.isFinite(-Infinity); // falseNumber.isFinite('foo'); // falseNumber.isNaN(NaN) // trueNumber.isNaN(15) // falseNumber.isNaN('15') // false
```



### 2、Number.parseInt(), Number.parseFloat()

> 全局方法`parseInt()`和`parseFloat()`，移植到`Number`对象上面，行为完全保持不变。

```javascript
// ES6的写法Number.parseInt('12.34') // 12Number.parseFloat('123.45#') // 123.45
```

### 3、Number.isInteger()

> `Number.isInteger()`用来判断一个数值是否为整数。

```javascript
Number.isInteger(25) // trueNumber.isInteger(25.1) // false
```



### 4、Math 对象的扩展

#### ①Math.trunc()

> `Math.trunc`方法用于去除一个数的小数部分，返回整数部分。

```javascript
Math.trunc(4.1) // 4Math.trunc(4.9) // 4Math.trunc(-4.1) // -4
```

#### ②Math.sign()

> `Math.sign`方法用来判断一个数到底是正数、负数、还是零。对于非数值，会先将其转换为数值。

```javascript
Math.sign(-5) // -1Math.sign(5) // +1Math.sign(0) // +0Math.sign(-0) // -0Math.sign(NaN) // NaN
```

#### ③Math.cbrt()

> `Math.cbrt()`方法用于计算一个数的立方根。

```javascript
Math.cbrt(-1) // -1Math.cbrt(0)  // 0Math.cbrt(1)  // 1Math.cbrt(2)  // 1.2599210498948732
```

#### ④Math.imul()

> `Math.imul`方法返回两个数以 32 位带符号整数形式相乘的结果，返回的也是一个 32 位的带符号整数。

```javascript
Math.imul(2, 4)   // 8Math.imul(-1, 8)  // -8Math.imul(-2, -2) // 4
```

#### ⑤Math.fround()

> `Math.fround`方法返回一个数的32位单精度浮点数形式。

```javascript
Math.fround(0)   // 0Math.fround(1)   // 1Math.fround(2 ** 24 - 1)   // 16777215
```

## Ⅳ-数组的拓展方法

### 1、Array.from()

> `Array.from`方法用于将两类对象转为真正的数组：类似数组的对象（array-like object）和可遍历（iterable）的对象（包括 ES6 新增的数据结构 Set 和 Map）

`Array.from`还可以接受第二个参数，作用类似于数组的`map`方法，用来对每个元素进行处理，将处理后的值放入返回的数组。

```javascript
Array.from([1, 2, 3], (x) => x * x)// [1, 4, 9]let spans = document.querySelectorAll('span.name');// Array.from()let names2 = Array.from(spans, s => s.textContent)
```

### 2、Array.of()

> `Array.of`方法用于将一组值，转换为数组。
>
> `Array`方法没有参数、一个参数、三个参数时，返回结果都不一样。只有当参数个数不少于 2 个时，`Array()`才会返回由参数组成的新数组。参数个数只有一个时，实际上是指定数组的长度。
>
> `Array.of`基本上可以用来替代`Array()`或`new Array()`，并且不存在由于参数不同而导致的重载。它的行为非常统一。

```javascript
Array.of() // []Array.of(undefined) // [undefined]Array.of(1) // [1]Array.of(1, 2) // [1, 2]
```

### 3、copyWithin()

> 数组实例的`copyWithin()`方法，在当前数组内部，将指定位置的成员复制到其他位置（会覆盖原有成员），然后返回当前数组。也就是说，使用这个方法，会修改当前数组。
>
> 它接受三个参数。
>
> - target（必需）：从该位置开始替换数据。如果为负值，表示倒数。
> - start（可选）：从该位置开始读取数据，默认为 0。如果为负值，表示从末尾开始计算。
> - end（可选）：到该位置前停止读取数据，默认等于数组长度。如果为负值，表示从末尾开始计算。

```javascript
// 将3号位复制到0号位[1, 2, 3, 4, 5].copyWithin(0, 3, 4)// [4, 2, 3, 4, 5]// -2相当于3号位，-1相当于4号位[1, 2, 3, 4, 5].copyWithin(0, -2, -1)// [4, 2, 3, 4, 5]// 将3号位复制到0号位[].copyWithin.call({length: 5, 3: 1}, 0, 3)// {0: 1, 3: 1, length: 5}
```

### 4、find() 和 findIndex()

> 数组实例的`find`方法，用于找出第一个符合条件的数组成员。它的参数是一个回调函数，所有数组成员依次执行该回调函数，直到找出第一个返回值为`true`的成员，然后返回该成员。如果没有符合条件的成员，则返回`undefined`。
>
> `find`方法的回调函数可以接受三个参数，依次为当前的值、当前的位置和原数组。
>
> 数组实例的`findIndex`方法的用法与`find`方法非常类似，返回第一个符合条件的数组成员的位置，如果所有成员都不符合条件，则返回`-1`。

```javascript
[1, 4, -5, 10].find((n) => n < 0)// -5[NaN].findIndex(y => Object.is(NaN, y))// 0
```

### 5、fill()

>`fill`方法用于空数组的初始化非常方便。数组中已有的元素，会被全部抹去。
>
>`fill`方法还可以接受第二个和第三个参数，用于指定填充的起始位置和结束位置。

```javascript
['a', 'b', 'c'].fill(7)// [7, 7, 7]new Array(3).fill(7)// [7, 7, 7]['a', 'b', 'c'].fill(7, 1, 2)// ['a', 7, 'c']
```

### 6、entries()，keys() 和 values()

> `keys()`是对键名的遍历、`values()`是对键值的遍历，`entries()`是对键值对的遍历。

```javascript
for (let index of ['a', 'b'].keys()) {  console.log(index);}// 0// 1for (let elem of ['a', 'b'].values()) {  console.log(elem);}// 'a'// 'b'for (let [index, elem] of ['a', 'b'].entries()) {  console.log(index, elem);}// 0 "a"// 1 "b"
```

### 7、flat()，flatMap()

>`flat()`方法将子数组的成员取出来，添加在原来的位置。
>
>`flat()`默认只会“拉平”一层，如果想要“拉平”多层的嵌套数组，可以将`flat()`方法的参数写成一个整数，表示想要拉平的层数，默认为1。

```javascript
[1, 2, [3, [4, 5]]].flat()// [1, 2, 3, [4, 5]][1, 2, [3, [4, 5]]].flat(2)// [1, 2, 3, 4, 5]
```

> `flatMap()`方法对原数组的每个成员执行一个函数（相当于执行`Array.prototype.map()`），然后对返回值组成的数组执行`flat()`方法。该方法返回一个新数组，不改变原数组。
>
> `flatMap()`只能展开一层数组

```javascript
// 相当于 [[2, 4], [3, 6], [4, 8]].flat()[2, 3, 4].flatMap((x) => [x, x * 2])// [2, 4, 3, 6, 4, 8]
```

### 8、reverse（）

> 将数组元素反转，但是会对原来数组直接进行改变

```js
aw.reverse()(5) [2, 3, 4, 5, 8]aw.reverse()(5) [8, 5, 4, 3, 2]
```

### 9、过滤器 filter()

>**用法**
>
>xxx.filter(function(currentValue,index,arr), thisValue)
>
>**function可接收参数**
>
>function(currentValue, index,arr)
>
>①currentValue:必须。当前元素的值
>
>②index:可选。当前元素的索引值
>
>③arr:可选。当前元素属于的数组对象

```js
//对象的用法let data={a:1,b:2,c:3,d:4}let data1=Object.keys(data).filter((value)=>{return data[value]>2})data1 -->(2) ["c", "d"]//数组的用法let arr=[1,2,3,4,5,6,7,8,9,10]let arr1=arr.filter((value)=>{return value%2==0})arr1 -->(5) [2, 4, 6, 8, 10]
```



## Ⅴ-对象的新增方法

### 1、Object.is()

> 比较两个值是否相等(`NaN有效`)

### 2、Object.assign()

> `Object.assign()`方法用于对象的合并，将源对象（source）的所有可枚举属性，复制到目标对象（target）。
>
> `Object.assign()`方法的第一个参数是目标对象，后面的参数都是源对象。
>
> 注意，如果目标对象与源对象有同名属性，或多个源对象有同名属性，则后面的属性会覆盖前面的属性。
>
> `Object.assign()`方法实行的是浅拷贝，而不是深拷贝。也就是说，如果源对象某个属性的值是对象，那么目标对象拷贝得到的是这个对象的引用。

```javascript
const target = { a: 1 };
const source1 = { b: 2 };
const source2 = { c: 3 };

Object.assign(target, source1, source2);
target // {a:1, b:2, c:3}
```

### 3、Object.getOwnPropertyDescriptors()

> `Object.getOwnPropertyDescriptors()`方法返回一个对象，所有原对象的属性名都是该对象的属性名，对应的属性值就是该属性的描述对象。

```javascript
Object.getOwnPropertyDescriptors(obj)
```

### 4、`__proto__`属性，Object.setPrototypeOf()，Object.getPrototypeOf()

#### ①、Object.setPrototypeOf()

> `Object.setPrototypeOf`方法的作用与`__proto__`相同，用来设置一个对象的原型对象（prototype），返回参数对象本身。它是 ES6 正式推荐的设置原型对象的方法。

```javascript
// 格式
Object.setPrototypeOf(object, prototype)

// 用法
const o = Object.setPrototypeOf({}, null);
```

#### ②、Object.getPrototypeOf()

> 该方法与`Object.setPrototypeOf`方法配套，用于读取一个对象的原型对象。

```javascript
Object.getPrototypeOf(obj);
```

### 5、Object.keys()，Object.values()，Object.entries() 

>`keys()`是对键名的遍历、`values()`是对键值的遍历，`entries()`是对键值对的遍历

### 6、Object.fromEntries()

> `Object.fromEntries()`方法是`Object.entries()`的逆操作，用于将一个键值对数组转为对象。

```javascript
Object.fromEntries([
  ['foo', 'bar'],
  ['baz', 42]
])
// { foo: "bar", baz: 42 }
```

