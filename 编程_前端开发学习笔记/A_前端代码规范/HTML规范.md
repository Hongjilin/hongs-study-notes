## #说明

>此笔记是 HTML规范
>
>查阅参考的资料:基于 [W3C](http://www.w3.org/)、[苹果开发者](https://developer.apple.com/)等官方文档; [W3Cschool的HTML规范](https://www.w3cschool.cn/wematy/wematy-glx43bs6.html); 思否的[HTML编码规范](https://segmentfault.com/a/1190000002465212);博客园的[html代码规范](https://www.cnblogs.com/zhuzhenwei918/p/6099740.html);习整理而成,仅本人记录学习
>
>除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[数据结构与算法](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_算法及课程基础学习笔记/数据结构与算法)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[编程_后台服务端学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记)** 、**[Java](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Java)** 、**[Nodejs](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Nodejs)** 、**[JavaScript笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记)**、**[编程工具使用笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端工具使用笔记)** 、**[ES6及后续版本学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记)** 、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了

## HTML 代码规范

> 很多 Web 开发人员对 HTML 的代码规范知之甚少。
>
> 在2000年至2010年，许多Web开发人员从 HTML 转换到 XHTML,使用 XHTML 开发人员逐渐养成了比较好的 HTML 编写规范。
>
> 而针对于 HTML5 ，我们应该形成比较好的代码规范，以下提供了几种规范的建议

## Ⅰ - HTML整体结构

### 1、 DOCTYPE 声明

>一个 DOCTYPE 必须包含以下部分，并严格按照顺序出现：
>
>1. 一个 ASCII 字符串 “`<!DOCTYPE>`” ，大小写不敏感
>2. 一个或多个空白字符
>3. 一个 ASCII 字符串” `html` ”，大小写不敏感
>4. 一个可选的历史遗留的 DOCTYPE 字符串 （[DOCTYPE legacy string](http://www.w3.org/TR/2014/REC-html5-20141028/syntax.html#doctype-legacy-string)），或者一个可选的已过时但被允许的 DOCTYPE 字符串 （[obsolete permitted DOCTYPE string](http://www.w3.org/TR/2014/REC-html5-20141028/syntax.html#obsolete-permitted-doctype-string)） 字符串
>5. 一个或多个空白字符
>6. 一个编码为 U+003E 的字符 “`>`”

### 2、**HTML基础代码块**

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

### 3、**HTML代码结构和视觉顺序基本保持一致**

>1. 按照从上之下，从左到右的视觉顺序书写HTML结构。
>2. 有时候**为了便于搜索引擎抓取**,我们也会将重要内容在HTML结构顺序上提前，因为搜索引擎抓取网页内容是自上而下的，所以将重要内容在HTML结构顺序上提前可便于抓取重要的内容
>3. 不要使用table布局，现在基本上被淘汰了，而应该代之以div来布局，方便控制。

### 4、**结构、表现、行为三者分类，避免内联**

>- 使用link引入外部css文件到head中。**注意：一般我们不使用@import来引入外部css文件**
>- 使用script将js文件引入，并置于body底部，这时js文件会最后加载，html会最先加载，用户体验会更好。（注意：并不是所有的js文件都要放置于body的底部，如当我们需要使用js文件动态修改meta元素内容时，需要将js文件引入到head标签中)

### 5、**保持良好的树形结构**

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

>　1. 一个标签上引用的className不要过多，越少越好。
> 　2. 对于一个语义化的内部标签，应该尽量避免使用className

## Ⅱ - HTML代码格式

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

### 2、关闭所有 HTML 元素

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