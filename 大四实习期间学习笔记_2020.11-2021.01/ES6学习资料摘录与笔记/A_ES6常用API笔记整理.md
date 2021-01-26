## 一、字符串的新增方法

### 1.1、JSON.stringify() 

> **作用是将 JavaScript 对象转换为 JSON 字符串**

### 1.2、JSON.parse()

> ***JSON.parse()将字符串c还原成对象a***

### 1.3、String.fromCodePoint()

> 可以识别大于`0xFFFF`的字符，弥补了`String.fromCharCode()`方法的不足

### 1.4、codePointAt()

> 能够正确处理 4 个字节储存的字符，返回一个字符的码点。

### 1.5、String.raw()

> 该方法返回一个斜杠都被转义（即斜杠前面再加一个斜杠）的字符串，往往用于模板字符串的处理方法。

### 1.6、includes(), startsWith(), endsWith()

>- **includes()**：返回布尔值，表示是否找到了参数字符串。
>- **startsWith()**：返回布尔值，表示参数字符串是否在原字符串的头部。
>- **endsWith()**：返回布尔值，表示参数字符串是否在原字符串的尾部。

```javascript
let s = 'Hello world!';
s.startsWith('Hello') // true
s.endsWith('!') // true
s.includes('o') // true
```

### 1.7、repeat()

> `repeat`方法返回一个新字符串，表示将原字符串重复`n`次。

```javascript
'x'.repeat(3) // "xxx"
'hello'.repeat(2) // "hellohello"
'na'.repeat(0) // ""
'na'.repeat(2.9) // "nana"
```

### 1.8、padStart()，padEnd()

> `adStart()`用于头部补全，`padEnd()`用于尾部补全。

```javascript
'x'.padStart(5, 'ab') // 'ababx'
'x'.padStart(4, 'ab') // 'abax'
'x'.padEnd(5, 'ab') // 'xabab'
'x'.padEnd(4, 'ab') // 'xaba'
```

### 1.9、trimStart()，trimEnd()

> `trimStart()`消除字符串头部的空格，`trimEnd()`消除尾部的空格。它们返回的都是新字符串，不会修改原始字符串。

```javascript
const s = '  abc  ';

s.trim() // "abc"
s.trimStart() // "abc  "
s.trimEnd() // "  abc
```

### 1.10、replaceAll()

> 替换所有匹配

```javascript
'aabbcc'.replaceAll('b', '_')
// 'aa__cc'
```

## 二、数值的拓展方法

### 2.1、Number.isFinite(), Number.isNaN()

> `Number.isFinite()`用来检查一个数值是否为`有限的（finite）`，即不是Infinity 注意，如果参数类型不是数值，Number.isFinite一律返回false。
>
> `Number.isNaN()`用来检查一个值是否为`NaN`。

```javascript
Number.isFinite(0.8); // true
Number.isFinite(NaN); // false
Number.isFinite(Infinity); // false
Number.isFinite(-Infinity); // false
Number.isFinite('foo'); // false

Number.isNaN(NaN) // true
Number.isNaN(15) // false
Number.isNaN('15') // false
```



### 2.2、Number.parseInt(), Number.parseFloat()

> 全局方法`parseInt()`和`parseFloat()`，移植到`Number`对象上面，行为完全保持不变。

```javascript
// ES6的写法
Number.parseInt('12.34') // 12
Number.parseFloat('123.45#') // 123.45
```

### 2.3、Number.isInteger()

> `Number.isInteger()`用来判断一个数值是否为整数。

```javascript
Number.isInteger(25) // true
Number.isInteger(25.1) // false
```



### 2.4、Math 对象的扩展

#### ①Math.trunc()

> `Math.trunc`方法用于去除一个数的小数部分，返回整数部分。

```javascript
Math.trunc(4.1) // 4
Math.trunc(4.9) // 4
Math.trunc(-4.1) // -4
```

#### ②Math.sign()

> `Math.sign`方法用来判断一个数到底是正数、负数、还是零。对于非数值，会先将其转换为数值。

```javascript
Math.sign(-5) // -1
Math.sign(5) // +1
Math.sign(0) // +0
Math.sign(-0) // -0
Math.sign(NaN) // NaN
```

#### ③Math.cbrt()

> `Math.cbrt()`方法用于计算一个数的立方根。

```javascript
Math.cbrt(-1) // -1
Math.cbrt(0)  // 0
Math.cbrt(1)  // 1
Math.cbrt(2)  // 1.2599210498948732
```

#### ④Math.imul()

> `Math.imul`方法返回两个数以 32 位带符号整数形式相乘的结果，返回的也是一个 32 位的带符号整数。

```javascript
Math.imul(2, 4)   // 8
Math.imul(-1, 8)  // -8
Math.imul(-2, -2) // 4
```

#### ⑤Math.fround()

> `Math.fround`方法返回一个数的32位单精度浮点数形式。

```javascript
Math.fround(0)   // 0
Math.fround(1)   // 1
Math.fround(2 ** 24 - 1)   // 16777215
```

## 三、数组的拓展方法

### 3.1、Array.from()

> `Array.from`方法用于将两类对象转为真正的数组：类似数组的对象（array-like object）和可遍历（iterable）的对象（包括 ES6 新增的数据结构 Set 和 Map）

`Array.from`还可以接受第二个参数，作用类似于数组的`map`方法，用来对每个元素进行处理，将处理后的值放入返回的数组。

```javascript
Array.from([1, 2, 3], (x) => x * x)
// [1, 4, 9]

let spans = document.querySelectorAll('span.name');
// Array.from()
let names2 = Array.from(spans, s => s.textContent)
```

### 3.2、Array.of()

> `Array.of`方法用于将一组值，转换为数组。
>
> `Array`方法没有参数、一个参数、三个参数时，返回结果都不一样。只有当参数个数不少于 2 个时，`Array()`才会返回由参数组成的新数组。参数个数只有一个时，实际上是指定数组的长度。
>
> `Array.of`基本上可以用来替代`Array()`或`new Array()`，并且不存在由于参数不同而导致的重载。它的行为非常统一。

```javascript
Array.of() // []
Array.of(undefined) // [undefined]
Array.of(1) // [1]
Array.of(1, 2) // [1, 2]
```

### 3.3、copyWithin()

> 数组实例的`copyWithin()`方法，在当前数组内部，将指定位置的成员复制到其他位置（会覆盖原有成员），然后返回当前数组。也就是说，使用这个方法，会修改当前数组。
>
> 它接受三个参数。
>
> - target（必需）：从该位置开始替换数据。如果为负值，表示倒数。
> - start（可选）：从该位置开始读取数据，默认为 0。如果为负值，表示从末尾开始计算。
> - end（可选）：到该位置前停止读取数据，默认等于数组长度。如果为负值，表示从末尾开始计算。

```javascript
// 将3号位复制到0号位
[1, 2, 3, 4, 5].copyWithin(0, 3, 4)
// [4, 2, 3, 4, 5]

// -2相当于3号位，-1相当于4号位
[1, 2, 3, 4, 5].copyWithin(0, -2, -1)
// [4, 2, 3, 4, 5]

// 将3号位复制到0号位
[].copyWithin.call({length: 5, 3: 1}, 0, 3)
// {0: 1, 3: 1, length: 5}
```

### 3.4、find() 和 findIndex()

> 数组实例的`find`方法，用于找出第一个符合条件的数组成员。它的参数是一个回调函数，所有数组成员依次执行该回调函数，直到找出第一个返回值为`true`的成员，然后返回该成员。如果没有符合条件的成员，则返回`undefined`。
>
> `find`方法的回调函数可以接受三个参数，依次为当前的值、当前的位置和原数组。
>
> 数组实例的`findIndex`方法的用法与`find`方法非常类似，返回第一个符合条件的数组成员的位置，如果所有成员都不符合条件，则返回`-1`。

```javascript
[1, 4, -5, 10].find((n) => n < 0)
// -5
[NaN].findIndex(y => Object.is(NaN, y))
// 0
```

### 3.5、fill()

>`fill`方法用于空数组的初始化非常方便。数组中已有的元素，会被全部抹去。
>
>`fill`方法还可以接受第二个和第三个参数，用于指定填充的起始位置和结束位置。

```javascript
['a', 'b', 'c'].fill(7)
// [7, 7, 7]

new Array(3).fill(7)
// [7, 7, 7]

['a', 'b', 'c'].fill(7, 1, 2)
// ['a', 7, 'c']
```

### 3.6、entries()，keys() 和 values()

> `keys()`是对键名的遍历、`values()`是对键值的遍历，`entries()`是对键值对的遍历。

```javascript
for (let index of ['a', 'b'].keys()) {
  console.log(index);
}
// 0
// 1

for (let elem of ['a', 'b'].values()) {
  console.log(elem);
}
// 'a'
// 'b'

for (let [index, elem] of ['a', 'b'].entries()) {
  console.log(index, elem);
}
// 0 "a"
// 1 "b"
```

### 3.7、flat()，flatMap()

>`flat()`方法将子数组的成员取出来，添加在原来的位置。
>
>`flat()`默认只会“拉平”一层，如果想要“拉平”多层的嵌套数组，可以将`flat()`方法的参数写成一个整数，表示想要拉平的层数，默认为1。

```javascript
[1, 2, [3, [4, 5]]].flat()
// [1, 2, 3, [4, 5]]

[1, 2, [3, [4, 5]]].flat(2)
// [1, 2, 3, 4, 5]
```

> `flatMap()`方法对原数组的每个成员执行一个函数（相当于执行`Array.prototype.map()`），然后对返回值组成的数组执行`flat()`方法。该方法返回一个新数组，不改变原数组。
>
> `flatMap()`只能展开一层数组

```javascript
// 相当于 [[2, 4], [3, 6], [4, 8]].flat()
[2, 3, 4].flatMap((x) => [x, x * 2])
// [2, 4, 3, 6, 4, 8]
```

### 3.8、reverse（）

> 将数组元素反转，但是会对原来数组直接进行改变

```js
aw.reverse()
(5) [2, 3, 4, 5, 8]
aw.reverse()
(5) [8, 5, 4, 3, 2]
```

### 3.9、过滤器 filter()

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
//对象的用法
let data={a:1,b:2,c:3,d:4}
let data1=Object.keys(data).filter((value)=>{
return data[value]>2
})
data1 -->(2) ["c", "d"]
//数组的用法
let arr=[1,2,3,4,5,6,7,8,9,10]
let arr1=arr.filter((value)=>{
return value%2==0
})
arr1 -->(5) [2, 4, 6, 8, 10]
```



## 四、对象的新增方法

### 4.1、Object.is()

> 比较两个值是否相等(`NaN有效`)

### 4.2、Object.assign()

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

### 4.3、Object.getOwnPropertyDescriptors()

> `Object.getOwnPropertyDescriptors()`方法返回一个对象，所有原对象的属性名都是该对象的属性名，对应的属性值就是该属性的描述对象。

```javascript
Object.getOwnPropertyDescriptors(obj)
```

### 4.4、`__proto__`属性，Object.setPrototypeOf()，Object.getPrototypeOf()

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

### 4.5、Object.keys()，Object.values()，Object.entries() 

>`keys()`是对键名的遍历、`values()`是对键值的遍历，`entries()`是对键值对的遍历

### 4.6、Object.fromEntries()

> `Object.fromEntries()`方法是`Object.entries()`的逆操作，用于将一个键值对数组转为对象。

```javascript
Object.fromEntries([
  ['foo', 'bar'],
  ['baz', 42]
])
// { foo: "bar", baz: 42 }
```



## 五、常见用法与示例整理

### 5.1、`解构赋值`

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

### 5.2、`Set、Map方面问题`

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



### 5.3、`let、const相关`

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

### 5.4、`数组相关问题`

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
let name = Symbol(‘name‘)；
let product = {
　　[name]："洗衣机"，
　　"price":799
}；
Reflect.ownKeys(product)；
```



-







