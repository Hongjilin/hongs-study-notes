## #说明

>查阅参考的资料:基于 [W3C](http://www.w3.org/)、[苹果开发者](https://developer.apple.com/)等官方文档; [W3Cschool的HTML规范](https://www.w3cschool.cn/wematy/wematy-glx43bs6.html); 思否的[HTML编码规范](https://segmentfault.com/a/1190000002465212);博客园的[html代码规范](https://www.cnblogs.com/zhuzhenwei918/p/6099740.html);[W3C XHTML 1.0 / CSS 国际标准通关秘诀](http://www.wfuyu.com/htmlcss/5320.html);学习整理而成,仅本人记录学习
>
>除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[数据结构与算法](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_算法及课程基础学习笔记/数据结构与算法)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[编程_后台服务端学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记)** 、**[Java](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Java)** 、**[Nodejs](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Nodejs)** 、**[JavaScript笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记)**、**[编程工具使用笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端工具使用笔记)** 、**[前端代码规范](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端代码规范)** 、**[Git学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Git学习笔记)** 、**[ES6及后续版本学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记)** 、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了

## HTML 代码规范

> 很多 Web 开发人员对 HTML 的代码规范知之甚少。
>
> 在2000年至2010年，许多Web开发人员从 HTML 转换到 XHTML,使用 XHTML 开发人员逐渐养成了比较好的 HTML 编写规范。
>
> 而针对于 HTML5 ，我们应该形成比较好的代码规范，以下提供了几种规范的建议

## **Ⅰ - HTML整体结构**

### 1、 DOCTYPE 声明

>一个 DOCTYPE 必须包含以下部分，并严格按照顺序出现：
>
>1. 一个 ASCII 字符串 “`<!DOCTYPE>`” ，大小写不敏感
>2. 一个或多个空白字符
>3. 一个 ASCII 字符串” `html` ”，大小写不敏感
>4. 一个可选的历史遗留的 DOCTYPE 字符串 （[DOCTYPE legacy string](http://www.w3.org/TR/2014/REC-html5-20141028/syntax.html#doctype-legacy-string)），或者一个可选的已过时但被允许的 DOCTYPE 字符串 （[obsolete permitted DOCTYPE string](http://www.w3.org/TR/2014/REC-html5-20141028/syntax.html#obsolete-permitted-doctype-string)） 字符串
>5. 一个或多个空白字符
>6. 一个编码为 U+003E 的字符 “`>`”

### 2、HTML基础代码块

>1. 文件应以`<!DOCTYPE.....>`首行顶格开始，这句话告诉浏览器这是一个什么文件，通常会使用`<!DOCTYPE html>`。
>2. 必须在head元素内部的meta标签内声明文档的字符编码charset, 如：`<meta charset="UTF-8">`，这句代码告诉浏览器应该此HTML文件使用的字符集是什么，如果不加此行代码，那么在浏览器中可能显示为乱码
>3.  页面的title是极为重要的不可缺少的一项。通常用我们编辑器快捷键就能得到(VSCode中敲 `!`号后按tab 就能补全得到)
>
>```html
><!DOCTYPE html>
><html lang="en">
><head>
>  <meta charset="UTF-8">
>  <meta name="viewport" content="width=device-width, initial-scale=1.0">
>  <title>Document</title>
></head>
><body>
>  
></body>
></html>
>```

### 3、HTML代码结构和视觉顺序基本保持一致

>1. 按照从上之下，从左到右的视觉顺序书写HTML结构。
>2. 有时候**为了便于搜索引擎抓取**,我们也会将重要内容在HTML结构顺序上提前，因为搜索引擎抓取网页内容是自上而下的，所以将重要内容在HTML结构顺序上提前可便于抓取重要的内容
>3. 不要使用table布局，现在基本上被淘汰了，而应该代之以div来布局，方便控制。

### 4、结构、表现、行为三者分类，避免内联

>- 使用link引入外部css文件到head中。**注意：一般我们不使用@import来引入外部css文件**
>- 使用script将js文件引入，并置于body底部，这时js文件会最后加载，html会最先加载，用户体验会更好。（注意：并不是所有的js文件都要放置于body的底部，如当我们需要使用js文件动态修改meta元素内容时，需要将js文件引入到head标签中)

### 5、保持良好的树形结构

>* 每一个块级元素都另起一行，每一行都是用tab缩进对齐。**如果不是块级元素，比如几个行内元素，我们把他写在一行即可。**注意：html、 head、 body ，其他的大都正常缩进
>* 当然，我们也可以在大的模块之间用空行空开，在模块内不要使用多余的空行,下面为实例
>
>```html
><!DOCTYPE html>
><html lang="en">
>
><head>
>  <meta charset="UTF-8">
>  <meta name="viewport" content="width=device-width, initial-scale=1.0">
>  <title>努力学习的汪</title>
></head>
>
><body>
>  <h1>HTML整体结构规范</h1>
>  <div>
>    <span>行内元素</span><span>写在一行</span>
>    <div>
>      <p>这是一个段落</p>
>    </div>
>  </div>
></body>
>
></html>
>```

### 6、关于使用className的小细节

>　　1. 一个标签上引用的className不要过多，越少越好。
>　　2. 对于一个语义化的内部标签，应该尽量避免使用className

------



## **Ⅱ - HTML代码格式**

### 1、使用小写元素名

>HTML5 元素名可以使用大写和小写字母。推荐使用小写字母：
>
>>- 混合了大小写的风格是非常糟糕的。
>>- 开发人员通常使用小写 (类似 XHTML)。
>>- 小写风格看起来更加清爽。
>>- 小写字母容易编写。
>
>```html
><!-- 不推荐  -->
><SECTION>
> <p>这是一个段落。</p>
></SECTION>
>
><!-- 非常糟  -->
><Section>
> <p>这是一个段落。</p>
></SECTION>
>
><!-- 推荐的  -->
><section>
>  <p>这是一个段落。</p>
></section>
>```

### 2、建议关闭所有 HTML 元素

>在 HTML5 中, 你不一定要关闭所有元素 (例如 `<p>`元素)，但我们建议每个元素都要添加关闭标签。
>
>```html
><!-- 不推荐  -->
><section>
>  <p>这是一个段落。
>  <p>这是一个段落。
></section>
>
><!-- 推荐的  -->
><section>
>  <p>这是一个段落。</p>
>  <p>这是一个段落。</p>
></section>
>```
>
>如果是空的标签,也建议要自闭合
>
>```html
><meta charset="utf-8">
>//自闭合,建议这么写
><meta charset="utf-8" />
>```

### 3、使用小写属性名

>HTML5 属性名允许使用大写和小写字母。我们推荐使用小写字母属性名:
>
>>- 同时使用大写写是非常不好的习惯。
>>- 开发人员通常使用小写 (类似 XHTML)。
>>- 小写风格看起来更加清爽。
>>- 小写字母容易编写。
>
>```html
><!-- 不推荐  -->
><div CLASS="menu">
>    
><!-- 推荐的  -->
><div class="menu">
>```

### 4、属性值

>HTML5 属性值可以不用引号。但我们推荐使用引号:
>
>>- 如果属性值含有空格需要使用引号。
>>- 混合风格不推荐的，建议统一风格。
>>- 属性值使用引号易于阅读。
>
>```html
><!-- 以下实例属性值包含空格，没有使用引号，所以不能起作用  -->
><table class=table striped>
>    
><!-- 以下使用了双引号，是正确的  -->
><table class="table striped">
>```

### 5、图片属性

>* 图片通常使用 [alt 属性](https://www.w3cschool.cn/htmltags/att-img-alt.html)。 在图片不能显示时，它能替代图片显示。
>* 定义好图片的尺寸，在加载时可以预留指定空间，减少闪烁。
>
>```html
><img src="html5.png" alt="HTML5" style="width:100px;height:100px">
>```

### 6、= 号前后少用空格和等号

>等号前后可以使用空格。但我们推荐少用空格 (**与JS不同**)
>
>```html
><!-- 不推荐  -->
><link rel = "stylesheet" href = "styles.css">
>
><!-- 推荐的  -->
><link rel="stylesheet" href="styles.css">
>```

### 7、避免一行代码过长

>使用 HTML 编辑器，左右滚动代码是不方便的。
>
>每行代码尽量少于 80 个字符。

### 8、空行和缩进

>* 不要无缘无故添加空行
>* 为每个逻辑功能块添加空行，这样更易于阅读。
>* 缩进使用两个空格，不建议使用 **TAB**。
>* 比较短的代码间不要使用不必要的空行和缩进。
>
>> ###### 不推荐的:可以看到多余的空行会导致我们阅读困难
>
>```html
><body>
>  <h1>HTML整体结构规范</h1>
>    
>  <div>
>    <span>行内</span><span>好好学习</span>
>      
>    <div>
>      <p>这是一个段落</p>
>    </div>
>      
>  </div>
>  
>  <div>
>    <ul>
>      <li>努力学习的汪</li>
>      <li>hongjilin</li>
>      <li>新生代农民工</li>
>    </ul>
>  </div>
></body>
>```
>
>> ###### 推荐的
>
>```html
><body>
>  <h1>HTML整体结构规范</h1>
>  <div>
>    <span>行内</span><span>好好学习</span>
>    <div>
>      <p>这是一个段落</p>
>    </div>
>  </div>
> <!-- 下方因为是列表,不同功能块,所以也可以加空行,不加也可,建议不加(除非大的功能块)  -->   
>  <div>   
>    <ul>
>      <li>努力学习的汪</li>
>      <li>hongjilin</li>
>      <li>新生代农民工</li>
>    </ul>
>  </div>
></body>
>```

### 9、省略 `<html> `和 `<body>` ?

>在标准 HTML5 中， `<html>` 和 `<body>` 标签是可以省略的。
>
>```html
><!-- 以下 HTML5 文档是正确的-->   
><!DOCTYPE html>
><head>
>  <title>页面标题</title>
></head>
><h1>这是一个标题</h1>
><p>这是一个段落。</p>
>```
>
>> ###### 但是**不推荐省略 `<html>` 和 `<body>` 标签。**
>
>* <html> 元素是文档的根元素，用于描述页面的语言
>* 声明语言是为了方便屏幕阅读器及搜索引擎。
>* 省略 `<html>` 或 `<body>` 在 DOM 和 XML 软件中会崩溃。
>* 省略 `<body>` 在旧版浏览器 (IE9)会发生错误。
>
>> ###### 在标准 HTML5 中， `<head>`标签是可以省略的,但是同样建议不省略
>
>默认情况下，浏览器会将 `<body>` 之前的内容添加到一个默认的 `<head>` 元素上。

### 10、元数据

>HTML5 中 `<title>` 元素是必须的，标题名描述了页面的主题:
>
>```html
><title>努力学习的汪的HTML规范代码示范</title>
>```
>
>标题和语言可以让搜索引擎很快了解你页面的主题:
>
>```html
><!DOCTYPE html>
><html lang="zh">
><head>
>  <meta charset="UTF-8">
>  <title>努力学习的汪的HTML规范代码示范</title>
></head>
>```

### 11、样式表 --> css

>- 将左花括号与选择器放在同一行。
>- 左花括号与选择器间添加一个空格。
>- 使用两个空格来缩进。
>- 冒号与属性值之间添加一个空格。
>- **逗号和符号之后使用一个空格**。这个基本是约定俗成的了
>- 每个属性与值结尾都要使用符号。
>- 只有属性值包含空格时才使用引号。
>- 右花括号放在新的一行。
>- 每行最多 80 个字符。
>
>> ###### 短的规则可以写成一行:
>
>```css
>p.into {font-family: Verdana; font-size: 16em;}
>```
>
>> ###### 长的规则可以写成多行:
>
>```css
>body {
>  background-color: lightgrey;
>  font-family: "Arial Black", Helvetica, sans-serif;
>  font-size: 16em;
>  color: black;
>}
>```

### 12、使用小写文件名

>* 大多 Web 服务器 (Apache, Unix) 对大小写敏感：london.jpg 不能通过 London.jpg 访问。
>* 其他 Web 服务器 (Microsoft, IIS) 对大小写不敏感：london.jpg 可以通过 London.jpg 或 london.jpg 访问。
>* 你必须保持统一的风格，我们建议统一使用小写的文件名。

### 13、文件扩展名

>* HTML 文件后缀可以是 **.html** (或 **.htm**)。
>* CSS 文件后缀是 **.css** 。
>* JavaScript 文件后缀是 **.js** 。

### 14、.htm 和 .html 的区别

>.htm 和 .html 的扩展名文件本质上是没有区别的。浏览器和 Web 服务器都会把它们当作 HTML 文件来处理。
>
>> ###### 大体上区别在于：
>
>* .htm 应用在早期 DOS 系统，系统现在后缀只能有三个字符。
>* 在 Unix 系统中后缀没有特别限制，一般用 .html。
>
>> ###### 技术上的区别
>
>* 如果一个 URL 没有指定文件名 (如 //www.w3cschool.cn/css/), 服务器会返回默认的文件名。
>* 通常默认文件名为 index.html, index.htm, default.html, 和 default.htm。
>* 如果服务器只配置了 "index.html" 作为默认文件，你必须将文件命名为 "index.html", 而不是 "index.htm"。
>* 但是，通常服务器可以设置多个默认文件，你可以根据需要设置默认文件吗。
>* 不管怎样，HTML 完整的后缀是 ".html"。

### 语法总结与补充

>- 用两个空格来代替制表符（tab） – 这是唯一能保证在所有环境下获得一致展现的方法。
>- 嵌套元素应当缩进一次（即两个空格）。
>- 对于属性的定义，**尽量使用双引号，不要使用单引号**。
>- 不要在自闭合（self-closing）元素的尾部添加斜线 – [HTML5 规范](http://dev.w3.org/html5/spec-author-view/syntax.html#syntax-start-tag)中明确说明这是可选的。
>- 不要省略可选的结束标签（closing tag）（例如，`</li>` 或 `</body>`）。
>
>```html
><!DOCTYPE html>
><html>
>
><head>
>  <title>主页</title>
></head>
>
><body>
>  <img src="./hong.png" alt="努力学习的汪的头像">
>  <h1 class="hello world">你好!阿汪</h1>
></body>
>
></html>
>```
>
>

------



## **Ⅲ - HTML 注释规范**

> 这个注释规范每个团队都不一样的,主要团队能互相看得懂即可,这里列举我看到的觉得比较好的规范

### 1、遵循标准

>HTML注释规范写法应该遵循以下标准：
>
>- 必须以4个有序字符开始：编码为 U+003C LESS-THAN SIGN 的小于号, 编码为 U+0021 EXCLAMATION MARK 的感叹号, 编码为 U+002D HYPHEN-MINUS 横线, 编码为 U+002D HYPHEN-MINUS横线 ，即 “<!–”
>- 在此之后是注释内容，注释的内容有以下限制：不能以单个 “>” (U+003E) 字符开始不能以由 “-“（U+002D HYPHEN-MINUS）和 ”>” (U+003E) 组合的字符开始，即 “->”不能包含两个连续的 U+002D HYPHEN-MINUS 字符，即 “–”不能以一个 U+002D HYPHEN-MINUS 字符结束，即 “-”
>- 必须以3个有序字符结束：U+002D HYPHEN-MINUS, U+002D HYPHEN-MINUS, U+003E GREATER-THAN SIGN，即 “–>”
>
>> ###### 标准写法
>
>```html
><!-- 这是一个正确的注释 -->
>```
>
>> ###### 错误的写法
>
>```html
><!-->这是一个错误的注释 -->
><!--->这是第二个错误的注释-->
><!--这是--第三个--错误注释-->
><!--这是第四个错误注释--->
>```

### 2、长注释

>比较长的评论可以在 `<!-- 和 -->` 中分行写：
>
>```html
><!--
>  从前有个新生代农民工,他非常努力学习,同时又是一个单身狗
>  所以他叫 努力学习的汪 ~~
>-->
>```
>
>长评论第一个字符缩进两个空格，更易于阅读。

### 3、单行注释

>* 一般用于简单的描述，如某些状态描述、属性描述等
>* 本人觉得比较好的习惯就是: 注释内容前后各一个空格字符，注释位于要注释代码的上面，单独占一行
>
>```html
><!-- Comment Text -->
><div>...</div>
>```
>
>> ###### 不推荐
>
>```html
><div>...</div><!-- Comment Text --> 
>```

### 4、模块注释

>* 一般用于描述模块的名称以及模块开始与结束的位置
>* 注释内容前后各一个空格字符，`<!-- S Comment Text -->` 表示模块开始
>* `<!-- E Comment Text -->` 表示模块结束，模块与模块之间相隔一行
>
>> ###### 推荐写法
>
>```html
><!-- S 模块A -->   
><div class="mod_a">
>    ...
></div>
><!-- E 模块 A -->
>    
><!-- S 模块 B -->   
><div class="mod_b">
>    ...
></div>
><!-- E 模块 B -->
>```
>
>> ###### 不推荐写法
>
>```html
><!-- S 模块 A -->
><div class="mod_a">
>    ...
></div>
><!-- E 模块 A -->
><!-- S 模块 B -->   
><div class="mod_b">
>    ...
></div>
><!-- E 模块 B -->
>```

### 5、嵌套模块注释

>当模块注释内再出现模块注释的时候，为了突出主要模块，嵌套模块不再使用 `S/E` 而是用`/`
>
>```html
><!-- S Comment Text -->
><!-- E Comment Text -->
>换成下面这样
><!-- /Comment Text -->
>```
>
>>###### 注释写在模块结尾标签底部，单独一行。
>
>```html
><!-- S Comment Text A -->
><div class="mod_a">
>    <div class="mod_b">
>        ...
>    </div>
>    <!-- /mod_b -->
>        
>    <div class="mod_c">
>        ...
>    </div>
>    <!-- /mod_c -->   
></div>
><!-- E Comment Text A -->
>```

## **Ⅳ - 实用为王**

>尽量遵循 HTML 标准和语义，但是不要以牺牲实用性为代价。任何时候都要尽量使用最少的标签并保持最小的复杂度。

### 1、属性顺序

>HTML 属性建议按照以下给出的顺序依次排列，确保代码的易读性
>
>- class
>- id, name
>- data-*
>- src, for, type, href
>- title, alt
>- aria-*, role
>
>class 用于标识高度可复用组件，因此应该排在首位。id 用于标识具体组件，应当谨慎使用（例如，页面内的书签），因此排在第二位。
>
>```html
><a class="..." id="..." data-modal="toggle" href="https://gitee.com/hongjilin">
>  点我跳转
></a>
>
><input class="form-control" type="text">
>
><img src="..." alt="...">
>```

### 2、布尔（boolean）型属性

>布尔型属性可以在声明时不赋值。XHTML 规范要求为其赋值，但是 HTML5 规范不需要。
>
>>* 元素的布尔型属性如果有值，就是 true，如果没有值，就是 false。
>>* **如果一定**要为其赋值的话，请参考 WhatWG 规范：
>>* 如果属性存在，其值必须是空字符串或 […] 属性的规范名称，并且不要再收尾添加空白符。
>
>简单来说就是不用赋值
>
>```html
><input type="text" disabled>
>
><input type="checkbox" value="1" checked>
>
><select>
>  <option value="1" selected>1</option>
></select>
>```

### 3、减少标签的数量

>编写 HTML 代码时，尽量避免多余的父元素。很多时候，这需要迭代和重构来实现。请看下面的案例
>
>```html
><!-- 并不怎么好的写法 -->
><span class="avatar">
>  <img src="...">
></span>
>
><!-- 更好的写法 -->
><img class="avatar" src="...">
>```

------



## **Ⅴ - W3C XHTML1.0标准需要留意的几个问题**

> 前面说了那么多,也不知道看进去了多少. 光说不练假把式,看看下方几个问题你说出几个,也权当是巩固一下知识点

### 1、在 `<div class=hong>My name is 努力学习的汪!</div>` 这段语句中有什么错误？

>```html
><div class=hong>My name is 努力学习的汪!</div>
>```
>
>**标点符号问题**: 其实也是大家最容易忽略的文艺,实际上就是引号忘了加形成了这个错误.虽然很多浏览器在不加引号的情况加仍然能正确识别渲染.但是想要通过眼里的W3C XHTML国际标准是不可能的 
>
>> ###### 请大家记住等号后面一定要接引号,下面给出正确写法
>
>```html
><div class="hong">My name is 努力学习的汪!</div>
>```

### 2、在 `<SPAN class="hong">My name is 努力学习的汪!</SPAN>`这段语句中有什么错误？

>```html
><SPAN class="hong">My name is 努力学习的汪!</SPAN>
>```
>
>**大小写问题**: 这与第一个问题是一样的,都是容易忽略的细节误问题. 
>
>>###### 上面说过,**尽量使用小写的元素名**,下面给出正确写法
>
>```html
><span class="hong">My name is 努力学习的汪!</span>
>```

### 3、在` <p>How are you?</p><br><p>I'm fine, thanks.</p> `这段语句中有什么错误？

>```html
><p>How are you?</p><br><p>I'm fine, thanks.</p>
>```
>
>　`<br />`标签问题。对于强制换行标签`<br />`来说，很多老手都分不清它和`<br>`的区别

#### a) 知识点补充: `<br />`与` <br> or </br> `的区别

>* 在早先发布的html规范中`<br>`/`<hr>`/`<img>`等标记元素是无需“封闭自身”的
>* 这就造成了html规范本身的不严谨，所以后来参考了更规范的XML语言的语法推出了`xhtml`。
>* 在xhtml中所有类似br这样的孤立标签都需要自行封闭，具体的做法就是在标签名字的后面跟个“/”，例如`<br />`，因此，是没有`</br>`这个写法的。
>* 从逻辑上讲`<br />`=`<br>`...`</br>`，这样做的目的是为了尽量减少网页的代码量，同时保持逻辑严谨。

#### b) 知识点补充:**HTML 与 XHTML 之间的差异**

>* 在 HTML 中，`<br>` 标签没有结束标签。
>* 在 XHTML 中，`<br>` 标签必须被正确地关闭，比如这样：`<br />`。
>* 同时所有浏览器都支持 `<br>` 标签。因为这是旧版本的写法,虽然不建议了,但仍需要兼容

#### c) 正确写法

>```html
><p>How are you?</p><br/><p>I'm fine, thanks.</p>
>```

### 4、 `<h1>~hey~~努力学习的汪~~</h1>` 这段语句中有什么错误？

>```html
><h1>~hey~~努力学习的汪~~</h1>
>```
>
>留意标签结束后面接的标点符号，很多标签结束后都不能接特殊标点符号，比如这里的"~"波浪号，那怎样用才对呢？
>
>* 那就使用ISO Latin-1字符集（ISO Latin-1 Character Set），在这里，查找到“~”波浪号绝对应的字符集十进制编码是~，
>* 然后就用这个十进制编码代替~波浪号，记住最后的分号不能丢。
>* 在ISO Latin-1字符集中以已命名实体（Named entity）最优先，十进制编码（Decimal code）其次
>* 也就是说，一个符号在同时有十进制编码和已命名实体的时候，优先选用已命名实体而不使用十进制编码。

### 5、 在` <form id="999hong"></form>` 这段语句中有什么错误？

>```html
><form id="999hong"></form>
>```
>
>留意id和class特殊情况。W3C XHTML1.0 标准中规定，在id或class中，第一个字符是不能是数字的，必须是字母
>
>```html
><form id="hong999"></form>
>```

### 6、在 `<img src="logo.png"> `这段语句中有什么错误？

>```html
><img src="logo.png">
>```
>
>`<img>`标签留意。W3C XHTML1.0 标准中规定，在`<img>`标签中，必须包括 **alt** 元素
>
>```html
><img src="logo.png" alt="hong的图片">
>```

### 7、在`<script language="JavaScript">` 这段语句中有什么错误？

>```html
><script language="JavaScript">
>```
>
>* `<script>`标签留意: W3C XHTML1.0 标准中规定，在`<script>`标签中，必须包括type元素。
>* 同时建议要闭合
>
>```html
><script language="JavaScript" type="text/javascript"></script>
>```

### 8、在`<div><h1>My name is 努力学习的汪!</div></h1> `这段语句中有什么错误？

>留意标签开始结束顺序对应嵌套关系,不要乱了
>
>```html
><div><h1>My name is 努力学习的汪!</h1></div>
>```

### 9、其他

>* 留意特殊套装:比如：`<dl><dd><ul><li>`等一些特殊标签，套装顺序中缺一不可。必须按照顺序将`<dl><dd><ul><li>`四个标签写完全。类似的还有许多。
>* 留意未打开标签。所谓未打开来自于W3C检测，这类错误显示的错误是 is not open，翻译过来也就是未打开的意思。如果按照中文的意思来理解就是有首无尾或者有尾无首。通常这种错误出现的缘由都是由于有一段代码在修正的时候被删除，而没有顾及到绝对较远的结束或者开始标签。