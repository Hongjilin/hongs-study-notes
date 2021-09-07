# 一、DOM操作相关

## Ⅰ- 单选题

### 1、获取页面 某标签 数量

>在开发中, 通常都是使用h标签来定义文本中的标题, 若想要知道文本中共有多少个标题主题文档, 该如何实现（   ）
>
>```js
>//a
>var hele=document.getElementByTagName('h1');
>alert(hele.length);
>//b
>var hele=document.getElementsByTagName('h1');
>alert(hele.length);
>//c
>var hele=getElementsByTagName('h1');
>alert(hele.length);
>//d
>var hele=getElementByTagName('h1');
>alert(hele.length);
>```
>
>##### 解析
>
>1. A和B之间的区别在Element和Elements。因为返回的是集合, 所以必然是Elements。
>
>2. 记住ID具有唯一性所以只能返回element, className、Name、TagName都是可以重复的所以需要返回elements就行了
>
>3. 各个方法:
>
>  >- document.getElementById();
>  >
>  >- document.getElementsByTagName();
>  >
>  >- document.getElementsByName();
>  >
>  >- document.getElementsByClassName();
>  >
>  >- 除了ById是Element, 其余都是Elements
>
>- 所以选第二个

### 2、对class为test的div对象设置红色背景

>以下代码中,为class为test的div对象设置红色背景的正确js代码为(    )
>
>```js
><div class="test"></div>    
>//以下是选项
>document.getElementsByClassName("test").style.backgroundColor="red";
>document.getElementsByClassName("test")[0].style.backgroundColor="red";
>document.getElementsByClassName("test")[0].style.background-color="red";
>document.getElementsByClassName("test").style.background-color="red";
>```
>
>##### 知识点梳理
>
>>- getElementsByClassName返回的是一个节点列表,是数组类型
>>- 在js里面添加的属性名使用驼峰法，在css里面使用连接线 除了id和query 其他返回的都是节点列表
>
>##### 答案解析:
>
>>![image-20210903104214887](JavaScript专项练习中的图片/image-20210903104214887.png)
>
>1. 第一个错误是因为,getElementsByClassName得到的是一个数组集合,即便它只有一个结果
>2. 第三个错误是因为在js里面添加的属性名使用驼峰法，在css里面使用连接线 除了id和query 其他返回的都是节点列表
>3. 第四个错误是因为犯了上面两个错误
>4. 所以选第二个

### 3、获取表单的select选中值

>```html
>//如何获取下面表单 select ;  域的选择部分的文本？()
><form name="a">
><select name="a" size="1" id=”obj”>
><option value="a">1</option>
><option value="b">2</option>
><option value="c">3</option>
></select>
></form> 
>//以下是四个选项
>obj.options[obj.selectedIndex].text
>obj.options[obj.selectedIndex].value
>obj. value
>obj.text
>```
>
>##### 知识点梳理:
>
>> 此题主要还是考察细心,注意题中说的是 **文本** ,而不是取 **value**
>
>##### 答案解析:
>
>>**文本**指的是1 选择a ; 如果要获取option里面的**value** 选择b
>>
>>```js
>>window.onload=function(){
>>//首先获得下拉框节点对象
>>const obj = document.querySelector('#obj');
>>//1. 如何获得当前选中的值
>>const value = obj.value;
>>//2. 如何获得该下拉框所有option的节点对象
>>const options = obj.options;  //注意:得到的options是一个对象数组
>>//3. 如何获得第几个option的value值?比如我要获取第一个,可以这样:
>>const firstValue = options[0].value;
>>//4. 如何获取第几个options的文本内容?比如我获取第一个,可以这样:
>>const firstText = options[0].text;
>>//5. 如何获得当前选中的option的索引?
>>const selectIndex = obj.selectIndex;
>>//6. 如何获得当前选中option的文本内容?  2中得到了所有options、5中得到选中的索引、结合4可以得到答案
>>const selectedText = options[selectIndex].text;    
>>}
>>```
>

## Ⅱ - 不定项选择

### 1、在一个块元素中，存在了很多的行元素，现在要求，将这些行元素中，只要有显示“叮咚”的行元素全部删除

>```js
>$("span").detach("叮咚");
>$("p").detach("叮咚");
>$("div").detach("叮咚");
>$("em").detach("叮咚");
>```
>
>##### 知识点梳理
>
>>本题主要考察你对于行内元素与块级元素的分类记忆
>>
>>* 行内元素(包括行内块级):
>>
>>  ![image-20210907112535399](JavaScript专项练习中的图片/image-20210907112535399.png) 
>>
>>* 块级元素:
>>
>>  ![image-20210907112510430](JavaScript专项练习中的图片/image-20210907112510430.png) 
>
>##### 答案解析:
>
>> * P、div标签是块级元素,所以错
>> * 答案选择AD

# 二、正则相关

> 如果对于此部分知识点相对薄弱的同学可以看我正则笔记 --> **[正则表达式学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/正则表达式学习笔记)** 

## Ⅰ - 单选题

### 1、请选择下方代码运行结果

>以下代码执行后, result 的值是：
>
>```js
>let result = "66handsome努力学习的汪2021学习".match(/\d+\w*/g)
>//下面为选项
>[&quot;66&quot;]
>[&quot;2021&quot;]
>[&quot;66handsome&quot;,2021&quot;]
>[&quot;66handsome努力学习的汪2021学习&quot;]
>[&quot;66&quot;, &quot;2021&quot;]
>```
>
>##### 知识点梳理:
>
>1. match() 方法可在字符串内检索指定的值, 或找到一个或多个正则表达式的匹配
>
>2. 字符转义知识点: **& quot;**  === "" 其实就是双引号的文字表记
>
>3. |  正则  |                             定义                             |
>     | :----: | :----------------------------------------------------------: |
>     |   \d   |                   匹配一个数字,等价于[0-9]                   |
>     |   \w   |         匹配字母、数字或者下划线,等价于 [A-Za-z0-9_]         |
>     | **\W** | **上面不是大写的,别认错了**:匹配**非**word(数字、字母),与上方小写的相反 |
>     |   +    |               匹配前面一个表达式 1 次或者多次                |
>     |   *    |                 匹配前一个表达式 0 次或多次                  |
>     |   /g   |                           全局匹配                           |
>
>##### 答案解析:
>
>>![image-20210903105900665](JavaScript专项练习中的图片/image-20210903105900665.png)
>
>所以选第三个

### 2、 以下代码页面输出结果为（   ）

>```js
>var str1=new RegExp("e");
>document.write(str1.exec("hello"));
>//下方是选项
>e
>null
>TRUE
>其他几项都不对
>```
>
>##### 知识点梳理:
>
>>  - **exec()** 方法用于检索字符串中的正则表达式的匹配, 如果字符串中有匹配的值返回该匹配值构成的数组 
>>  - exec中，hello匹配成功"e"，document.write将数组转换为字符串e
>
>##### 答案解析
>
>1. 返回值:返回一个数组, 其中存放匹配的结果。如果未找到匹配, 则返回值为 null。
>
>>所以"e".exec("hello")中,"e"是正则表达式, "hello"是检索的字符串。在"hello"字符串中, 能够匹配到"e"。因此document.write("e"); 最后结果为e。
>
>2. 说明
>
>>exec() 方法的功能非常强大, 它是一个通用的方法, 而且使用起来也比 test() 方法以及支持正则表达式的 String 对象的方法更为复杂。
>>如果 exec() 找到了匹配的文本, 则返回一个结果数组。否则返回 null。此数组的第 0 个元素是与正则表达式相匹配的文本, 第 1 个元素是与 RegExpObject 的第 1 个子表达式相匹配的文本（如果有的话）, 第 2 个元素是与 RegExpObject 的第 2 个子表达式相匹配的文本（如果有的话）, 以此类推。除了数组元素和 length 属性之外, exec() 方法还返回两个属性。index 属性声明的是匹配文本的第一个字符的位置。input 属性则存放的是被检索的字符串 string。我们可以看得出, 在调用非全局的 RegExp 对象的 exec() 方法时, 返回的数组与调用方法 String.match() 返回的数组是相同的。
>>但是, 当 RegExpObject 是一个全局正则表达式时, exec() 的行为就稍微复杂一些。它会在 RegExpObject 的 lastIndex 属性指定的字符处开始检索字符串 string。当 exec() 找到了与表达式相匹配的文本时, 在匹配后, 它将把 RegExpObject 的 lastIndex 属性设置为匹配文本的最后一个字符的下一个位置。这就是说, 您可以通过反复调用 exec() 方法来遍历字符串中的所有匹配文本。当 exec() 再也找不到匹配的文本时, 它将返回 null, 并把 lastIndex 属性重置为 0。
>
>3. 所以页面输出结果为 e

# 三、变量相关

## Ⅰ- 单选题

### 1、关于对变量的说法，错误的是？

>```js
>一般使用 var key; 的形式声明
>由于javascript的动态特性，常常直接采取 key= val; 的形式 声明与赋值
>若声明而未对变量赋值，该变量的值为undefined
>var carname="Volvo";var carname;顺序执行后，carname的值依然为Volvo
>```
>
>##### 答案解析:
>
>>- 解释第一、二选项: javascript 一般使用var key = val；的声明与赋值，声明变量的时候也要用var key； 如果不用var关键字，声明的就是全局变量，一般不要这么做；
>>- 解释第三、四选项：(变量声明提升)JS代码执行时候，先扫一遍JS代码，进行JS变量定义，定义时候不赋值(undefined)，结束完成后，开始执行JS代码，当执行到赋值语句的时候，开始给变量赋值。
>>- 所以第二项错误

### 2、以下代码执行后，控制台的输出是：

>```js
>var a = 10;
>function a(){}
>console.log(typeof a)
>//以下是选项
>&quot;number&quot;
>&quot;object&quot;
>&quot;function&quot;
>&quot;undefined&quot;
>```
>
>##### 知识点梳理:
>
>* 字符转义知识点: **& quot;**  === "" 其实就是双引号的文字表记
>* 函数提升大于变量提升，变量提升会提升到除函数声明的后面；
>
>##### 答案解析:
>
>>以下给出实际解析后代码
>>
>>```js
>>var a = function (){} //函数提升,优先级高于变量提升,所以即便在变量后面声明,仍然顶在变量前方
>>var a;    //这边不是因为什么之后重声明才变为number，是因为变量赋值才变的
>>a = 10;   //如果有多个var a ,那a的类型最后就会是最后赋值操作的参数类型。  
>>console.log(typeof a)
>>```
>>
>>所以可以明显知道,答案会是number

## Ⅱ - 不定项选择题

### 1、下列哪些是javascript原始数据类型。

>```js
>String
>Null
>Undefined
>Object
>Boolean
>Number
>```
>
>##### 知识点梳理
>
>1. **原始(基础)类型: ==>  unn ssbb**
>
>>  - undefined
>>  - null
>>  - Number
>>  - String
>>  - Symbol : ES6 系列新增
>>  - Boolean
>>  - Bigint : ES2020 系列：新增基本数据类型 BigInt
>
>2. **内置类型（Built-in)**
>
>>Undefined Null  Number String  Symbol Bigint  Boolean **Object**
>
>3. **对象(引用)类型 ==> 所以对象比较特殊**
>
>>  - Object: 任意对象
>>  - Function: 一种特别的`对象`(可以执行)  -->内部包含可运行的代码
>>  - Array: 一种特别的`对象`(`key`为数值下标属性, 内部数据是有序的)
>
>4. **原始值**
>
>>  - 除 Object 以外的所有类型都是不可变的（值本身无法被改变）。
>>  - 例如，与 C 语言不同，JavaScript 中字符串是不可变的
>>  - 译注：如，JavaScript 中对字符串的操作一定返回了一个新字符串，原始字符串并没有被改变）。我们称这些类型的值为“原始值”
>
>5. **原始类型和对象类型的区别，总结起来就是**：
>
>>| 类型       | 原始类型 | 对象类型     |
>>| ---------- | -------- | ------------ |
>>| 值         | 不可改变 | 可以改变     |
>>| 属性和方法 | 不能添加 | 能添加       |
>>| 存储值     | 值       | 地址（指针） |
>>| 比较       | 值的比较 | 地址的比较   |
>
>##### 答案解析
>
>>除了Oject,其他的全选

# 四、运算符、类型转换 相关

> 此部分相关知识点不懂得可以尝试百度 [ js Operators logical ] 关键词了解详情

## Ⅰ- 单选题

### 1、下面代码结果分别是什么?

>```js
>console.log(([])?true:false); 
>console.log(([]==false?true:false)); 
>console.log(({}==false)?true:false) 
>//下面是选项
>false true true
>true true true
>true false true
>true true false
>```
>
>##### 知识点梳理:
>
>>此题考察类型转换，三元运算符先**分清是非**，再决定今后该走哪条路，“==”运算符比较 会 **"更喜欢"** 用Number类型来进行比较
>>
>>1. **== 运算符（两个操作数的类型不相同时）**
>>   - 如果一个值是null，另一个值是undefined，则它们相等
>>   - 如果一个值是数字，另一个值是字符串，先将字符串转换为数学，然后使用转换后的值进行比较。
>>   - 如果其中一个值是true，则将其转换为1再进行比较。如果其中的一个值是false，则将其转换为0再进行比较。
>>   - 如果一个值是对象，另一个值是数字或字符串，则将对象转换为原始值，再进行比较。
>>2. **对象到数字的转换**
>>   - 如果对象具有valueOf()方法，后者返回一个原始值，则JavaScript将这个原始值转换为数字（如果需要的话）并返回一个数字。
>>   - 否则，如果对象具有toString()方法，后者返回一个原始值，则JavaScript将其转换并返回。（对象的toString()方法返回一个字符串直接量（之前所说的原始值），JavaScript将这个字符串转换为数字类型，并返回这个数字）。
>>   - 否则，JavaScript抛出一个类型错误异常。
>>3. **空数组转换为数字0**
>>   - 数组继承了默认的valueOf()方法，这个方法返回一个对象而不是一个原始值，因此，数组到数学的转换则调用toString()方法。空数组转换为空字符串，空字符串转换为数字0.
>
>##### 答案解析
>
>```js
>console.log(Boolean([])); //true
>console.log(Number([])); //0
>console.log(Number({})); // NaN
>console.log(Number(false)); //0
>//所以题目可以这样转换
>console.log(([])?true:fasle);// => console.log((true)?true:false);
>console.log([]==false?true:false); // => console.log(0==0?true:false);
>console.log(({}==false)?true:false); // => console.log((NaN==0)?true:false);
>```
>
>![image-20210906101415830](JavaScript专项练习中的图片/image-20210906101415830.png) 

### 2、以下哪个表达式的值为true？

>```js
>'1' === 1
>isNaN(1/0)
>1 in [1]
>1 && 2 > 1
>```
>
>##### 知识点梳理
>
>- 考查函数的优先级  -->  [可以点我传送](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Operator_Precedence)
>
>- `isNaN()` 函数用来确定一个值是否为[NaN](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/NaN) 
>
>- 考察对于逻辑符 “&&”和‘||’ 的理解:
>
>  ![image-20210906135057894](JavaScript专项练习中的图片/image-20210906135057894.png) 
>
>##### 答案解析
>
>1. A选项，'1'是字符串string，1是数字number。类型不一样，===下比较返回false。
>
>2. B选项。
>
>  >- 任何数值除以0都会导致错误而终止程序执行。但是在 JavaScript 中，**会返回出特殊的值**，因此不会影响程序的执行。
>  >- 比0大的数除以0，则会得到无穷大，所以 js 用 `Infinity` 来显示出来。
>  >- 也就是1/0得到的是Infinity。isNaN(1/0)返回的是false。但是isNaN(0/0)返回的就是true
>
>3. C选项。
>
>  >- in操作符，对于数组属性需要指定数字形式的**索引值**来表示数组的属性名称（固有属性除外，如length）。
>  >- 所以说在这里，1 in [1]并不是表示数字1在不在数组里。而是表示数组中含不含有1这个索引index值。
>  >- 数组长度为1，所以只含有的index值为0，这个表达式返回fasle。
>
>4. D选项。
>
>  > * 1 && 2 > 1，先判断右边的表达式，2>1返回true。1 && true返回的结果也是true。

### 3、以下Js程序的输出是什么（）

>```js
>var a="undefined";
>var b="false";
>var c="";
>function assert(aVar){
>   if(aVar) alert(true);
>   else  alert(false);
>  }
>assert(a);
>assert(b);
>assert(c);
>//以下是选项
>true，true，true
>true，true，false
>false，false，true
>false，false，false
>```
>
>##### 知识点梳理:
>
>- `if(condition)`  的condition求值结果若非布尔值，ECMAScript会自动调用Boolean()转换函数将结果转换为布尔值。转换规则为：
>
>  > | 数据类型  | 转换为true     | 转换为false |
>  > | --------- | -------------- | ----------- |
>  > | boolean   | true           | false       |
>  > | String    | 任何非空字符串 | 空字符串    |
>  > | Number    | 任何非零数字值 | 0和NaN      |
>  > | Object    | 任何对象       | null        |
>  > | Undefined |                | undefined   |
>
>- JavaScript里面的六种假值：false、0、''''、undefined、null、NaN
>
>##### 答案解析:
>
>> 此题会错应该主要就是被误导了,题中 "undefined","false" 是字符串!!!
>>
>> 变量abc都是字符串型的变量，而不是真正的undefined和false，在判断里都会被认为是真值，显示true，只有空串为false
>>
>> 所以选择B



## Ⅱ- 不定项选择题

### 1、 以下哪些表达式的值为 0 ？

>```js
>(()=>{}).length
>1 & 2
>+[]
>[1,2,-3].reduce((a, b) => a - b, 0) //第一个参数是累加器,第二个参数是当前传入值
>```
>
>##### 知识点梳理
>
>> `reduce()` 方法对数组中每个元素执行一个由您提供的**reducer**函数（升序执行），将其结果汇总为单个返回值。
>
>##### 答案解析
>
>1. (()=>{}).length; 获取方法形参个数，形参为0  
>
>2. 1=0001 2=0010 按位与运算，同为1才为1，否则返回0  
>
>3. +[] 隐式类型转换，因为[]是对象，所以 toPrimitive -> valueOf -> toString为 ' ' -> Number("") ==0   结果就是+''===0  
>
>4. reduce对数组中的每个元素执行一个reducer函数(升序执行)，将其结果汇总为单个返回值。a为累计器累计回调的返回值，b为数组的每一项元素，传入初始值0->0-(1)->(-1)-2->(-3)-(-3)->0
>
>   - reduce接受2个参数，回调函数和初始值。在[1,2,-3].reduce((a,b)=>a-b,0)中，回调函数为(a,b)=>a-b，初始值为0，那么进行回调的过程如下：
>
>   - | 回调次数   | previousValue     | currentValue | currentIndex | array    | 运算过程    | 返回值 |
>     | :--------- | ----------------- | ------------ | ------------ | -------- | :---------- | :----- |
>     | 第一次回调 | 0（设置的初始值） | 1            | 0            | [1,2,-3] | 0-1         | -1     |
>     | 第二次回调 | -1                | 2            | 1            | [1,2,-3] | (0-1)-2     | -3     |
>     | 第三次回调 | -3                | -3           | 2            | [1,2,-3] | ((0-1)-2)-3 | 0      |

# 五、API方法理解相关

> 此部分主要还是靠死记硬背了

## Ⅰ- 单选题

### 1、 下列代码中 hasOwnProperty 的作用是？

>```js
>var obj={}
>obj.hasOwnProperty("val")
>//下面是选项
>判断obj对象是否具有val属性
>判断obj对象是否具有val的值
>判断obj的原型对象是否具有val的属性
>判断obj的原型对象是否具有val的值
>```
>
>##### 知识点梳理
>
>>**[hasOwnProperty](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/hasOwnProperty)：** 是用来判断一个对象是否有你给出名称的属性或对象。不过需要注意的是，此方法无法检查该对象的原型链中是否具有该属性，该属性必须是对象本身的一个成员。
>
>>**isPrototypeOf :** 是用来判断要检查其原型链的对象是否存在于指定对象实例中，是则返回true，否则返回false。
>
>##### 答案解析
>
>> 选择A

### 2、在 javascript 中，用于阻止默认事件的默认操作的方法是:

>```js
>stopDeafault()
>stopPropagation()
>preventPropagation()
>preventDefaultEven()
>preventDefault()
>```
>
>##### 知识点梳理
>
>下面三个事件都是事件对象的方法：
>
>- `stopPropagation()` 阻止事件冒泡。 这个事件不会阻止定义在元素上的其他事件。 
>- `stopImmediatePropagation()` 会彻底的阻止事件， 在其之后的绑定在元素上的其他监听事件都不会触发
>- `preventDefault()` 阻止事件的默认动作，例如a链接的跳转，在a链接跳转中，需要先对a链接绑定点击事件，然后在a链接的事件对象中调用该方法即可。
>
>##### 答案解析
>
>> E

# 六、this指向相关

> 此处知识点不懂的可以看本人 [JS进阶笔记函数的this部分](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/HTML+CSS+JS%E5%9F%BA%E7%A1%80%E7%AC%94%E8%AE%B0/JavaScript%E7%AC%94%E8%AE%B0#%E2%85%A4-%E5%87%BD%E6%95%B0%E4%B8%AD%E7%9A%84this),本人给出了详细的笔记梳理

## Ⅰ- 单选题

>```js
>var user = {
>count : 1,
>getCount: function(){
>return this.count;
>}
>}
>var func = user.getCount
>console.log(func())
>//以下是选项
>this.count
>1
>报错
>undefined
>```
>
>##### 知识点梳理
>
>1. 调用对象未声明的属性会返回 undefined
>
>   >   ```js
>   >   const user={};
>   >   console.log(user.name);//undefined
>   >   ```
>
>2. 使用未赋值只声明的基本数据类型会返回 undefined
>
>   >   ```js
>   >   const one;
>   >   console.log(one);//undefined
>   >   ```
>
>3. 使用未声明的变量会报错
>
>   >   ```js
>   >   console.log(two);// Uncaught ReferenceError: two is not defined
>   >   ```
>
>4. this对象在运行的时候是基于 **函数执行的环境** 绑定的：在全局环境中this等于window，而函数被作为某个对象的方法调用时，this等于那个对象。
>
>##### 答案解析
>
>1. 在本题中，this指向的是window,window对象已经自动被浏览器声明了，只是还没有声明count属性，所以也是undifned
>
>2. 可能有小伙伴会问:这个this不是应该指向user吗？想问下为啥指向window呢？
>
>  >因为func=user.getCount只是保存了getCount函数，并没有执行，该函数是在console里面执行，func()就相当于user.getCount()，一看是像user调用，其实func()就相当于一个全局的函数，实际上是window.func() ,也就是window.user.getCount()  
>
>3. 综上所述可以得知,结果为undefined

## Ⅱ - 不定项选择

### 1、下面this对象的理解正确的是 ()

>```js
>在不改变this指向的前提下，this总是指向函数的直接调用者
>如果有new关键字，this指向new出来的那个对象
>this总是指向函数的非间接调用者
>IE中attachEvent中的this总是指向全局对象Window
>```
>
>##### 答案解析:
>
>1. A选项可能有同学提出一个疑惑:那我如果在对象方法中声明一个箭头函数,那即便我用这个对象的实例去调用,指向仍是window怎么是对的?
>
>   >这里需要澄清一个事情: 箭头函数原则上是没有this的，我们口中的this只是一种解释原型链的东西，但是官方是没有this的，所以，这二者怎么能相提并论呢？所以这种情况是不考虑进来的
>   >
>   >![image-20210907111644631](JavaScript专项练习中的图片/image-20210907111644631.png)
>   >
>   >如果对于此处仍有疑虑的同学,可以看本人   [JS进阶笔记函数的this部分](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/HTML+CSS+JS%E5%9F%BA%E7%A1%80%E7%AC%94%E8%AE%B0/JavaScript%E7%AC%94%E8%AE%B0#%E2%85%A4-%E5%87%BD%E6%95%B0%E4%B8%AD%E7%9A%84this),我会在此处给出详细记录解释
>
>2. 有new关键字指的就是构造函数生成的实例,所以是对的
>
>3. C选项错在 ”**总是**“，apply,call就可以改变this指向
>
>4. D选项: Window.attachEvent就是window调用,所以指向就是window
>
>5. 所以选择ABD

# 七、拓充知识点

## Ⅰ- 单选题

### 1、白屏时间first paint和可交互时间dom ready的关系是？

>```js
>先触发first paint ，后触发dom ready
>先触发dom ready，后触发first paint
>一起触发
>没关系
>```
>
>##### 知识点梳理
>
>页面的性能指标详解：
>
>* 白屏时间（first Paint Time）——用户从打开页面开始到页面开始有东西呈现为止
>* 首屏时间——用户浏览器首屏内所有内容都呈现出来所花费的时间
>* 用户可操作时间(dom Interactive)——用户可以进行正常的点击、输入等操作，默认可以统计domready时间，因为通常会在这时候绑定事件操作
>* 总下载时间——页面所有资源都加载完成并呈现出来所花的时间，即页面 onload 的时间
>
>##### 答案解析
>
>两者的触发时间可以认为是一致的，没有明确的先后顺序。
>
>- 这里的dom ready指的是dom元素都已经被解析。只有dom树渲染完毕后，才会有元素，不然就会一片空白，而影响dom ready的因素也有很多，才会有那么多的性能化策略。
>- 另一方面，在解析script时，dom加载会被阻塞。假如在dom加载之前出现alert提示框，在关闭提示框之前，页面都是一片空白。
>
>本人刚开始选择是D,但答案是A,查阅了下解析之类的也没啥靠谱的回答,只能盲推可能是在DOM加载时已经是白屏了,所以先白屏,后dom ready

### Ⅱ - 下面的语言中哪些语言是动态语言(  )

>```js
>C
>JavaScript
>C++
>CSS
>Java
>Objective-C
>```
>
>##### 知识点梳理:
>
>* 动态类型语言（弱类型语言）：
>
>  > 动态类型语言是指在运行期间才去做数据类型检查的语言，也就是说，在用动态类型的语言编程时，永远也不用给任何变量指定数据类型，该语言会在你第一次赋值给变量时，在内部将数据类型记录下来。Python 和 Ruby 就是一种典型的动态类型语言，其他的各种脚本语言如 JavaScript 也属于动态类型语言。 
>
>* 静态类型语言（强类型语言）：
>
>  > 静态类型语言与动态类型语言刚好相反，它的数据类型是在编译其间检查的，也就是说在写程序时要声明所有变量的数据类型，C/C++ 是静态类型语言的典型代表，其他的静态类型语言还有 C#、JAVA 等。
>
>##### 答案解析:
>
>> css是一种**层叠样式表**,所以不算
>>
>> 答案只有JavaScript.    









