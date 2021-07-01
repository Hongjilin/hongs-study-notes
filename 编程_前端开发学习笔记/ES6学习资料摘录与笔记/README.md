# #此文件为方便gitee网站观阅使用专门创建

> 此笔记文件于某一时间复制至此,容易存在更新不及时问题,建议观看同级目录下的笔记文件
>
> 只截取了上方`A_ES6知识补充与所遇问题`部分笔记的部分知识点至此,方便网站阅读

>此笔记是查阅及整理完es6常用api笔记后的补充笔记,也是后续会进行补充的笔记
>
>将记录开发过程或者学习过程遇到的需要补充的知识点或者没遇过的值得mark的场景及解决
>
>本人笔记地址分享:[`全部笔记`](https://gitee.com/hongjilin/hongs-study-notes)

# #目录

>[TOC]

# A_ES6知识补充与所遇问题

## 一、实践过程补充知识点

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
>    var arr1 = arr.map(item => item = 2)// 输出[1,1,1,1,1]
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
>   ![image-20210415160945789](A_ES6知识补充与所遇问题中的图片/image-20210415160945789.png)

#### 3、柯里化

>1. 图例:
>
>   ![image-20210415161137977](A_ES6知识补充与所遇问题中的图片/image-20210415161137977.png)
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



## 二、Proxy模拟实现Vue的双向绑定

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



## 三、问题与解决

### Ⅰ-`import`动态导入图片时报错

>1. 问题一:使用`import a from "@/img/"+url`时报错
>
>  解决:使用const a = require(`@/img/${文件名}${后缀名}`)
>
>2. 问题而:问题一解决后用`require后发现出现警告`
>
>  解决:拼接时将后缀名用写死的方式拼接
>
>  ```js
>requImg = require(`@/img/${url}.png)
>  ```

