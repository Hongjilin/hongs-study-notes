# #此文件为方便gitee网站观阅使用专门创建

> 此笔记文件于某一时间截取复制至此,容易存在更新不及时问题,建议观看同级目录下的笔记文件
>
> 只截取了上方`高频面试题(偏向Vue)`部分笔记的部分知识点至此,方便网站阅读
>
> `这阶段笔记目录题目都刷一遍,起码实习生阶段面试去大部分公司都可以过`
>
> 整理时间是`2020年11月~2021年3月`



> 该笔记是本人整理的面向vue技术栈的实习生面试笔记(本人遇到的或者是面试过程、学习过程觉得会问的),进行分享,有需要的小伙伴应该可以得到帮助
>
> 这个时间段vue3.0还刚发布,所以该知识点未收录
>
> 本人笔记地址分享:[`全部笔记`](https://gitee.com/hongjilin/hongs-study-notes)、[`前端学习笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0)、[`数据结构与算法学习笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E7%AE%97%E6%B3%95%E5%8F%8A%E8%AF%BE%E7%A8%8B%E5%9F%BA%E7%A1%80%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95)、[`LeetCode笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E7%AE%97%E6%B3%95%E5%8F%8A%E8%AF%BE%E7%A8%8B%E5%9F%BA%E7%A1%80%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95/LeetCode)
>
> ​											整理时间:2020/10

# 一、HTML

## 1.各个浏览器兼容性问题的解决?

1. hack   ==> [hack详解](https://blog.csdn.net/Clara_G/article/details/87809582)
2. 常见兼容性问题以及相应解决  ==>[详情](https://blog.csdn.net/wanmeiyinyue315/article/details/79654984)

## 2.响应式解决方案

1. rem布局(主要解决方案Flexible)
2. 百分比布局
3. rem+less
4. boostrap等框架

## 3.html5新标签特性的使用

1. audio、 video(MP4要 h264格式才可以)、 localStorage 、canvas、svg等新标签
2. 新标签兼容性  ==>**①创建js+css**、**②html5shiv**、**③respond.js **  ==>[详情](https://blog.csdn.net/jeft_hai/article/details/82317780)





# 二、JS之ES6

## 1.**Promise ** ==>[详解](https://www.jb51.net/article/171977.htm)  

### 1.1、Promise是什么?

> Promise是异步编程的一种解决方案，它是一个容器，里面保存着某个未来才会结束的事件的结果。它有三种状态(pending进行中,fulfilled已成功,rejected已失败)，只有异步操作的结果才能决定当前的状态，不受外界因素的影响。而一旦状态改变，就不会再变，也就是状态凝固了（resolved），任何时候都可以得到这个结果。

### 1.2、Promise的缺点?

1. 无法取消Promise,一旦创建他就会立即执行,无法中途取消
2. 如果不设置回调函数,Promise内部抛出的错误,不会反应到外部
3. 当处于Pending状态时,无法得知目前进展到哪一个阶段(刚刚开始还是即将结束)

### 	1.3、Promise作用:

>    ###### 用来解决回调地狱问题，但是只是简单的改变格式，并没有彻底解决上面的问题真正要解决上述问题，一定要利用promise再加上await和async关键字实现异步传同步

###     1.4、Promise运行=>

```js
//new的时候方法体就立刻运行
new Promise(function (resolve,reject){//业务代码}）
```

###    1.5、Promise的参数解释=>

1. resolve:表示方法体里头执行成功之后的回调函数
2. reject:表示方法体里头出错后的回调函数
3. Function(函数):支持多层嵌套的回调函数作为方法体内容



##     2.Promise+await+async=>`重`

#### 							1)Promise==>异步

#### 							2)await==>异步转同步

1. await 可以理解为是 async wait 的简写。await 必须出现在 async 函数内部，不能单独使用。
2. await 后面可以跟任何的JS 表达式。虽然说 await 可以等很多类型的东西，但是它最主要的意图是用来等待 Promise 对象的状态被 resolved。如果await的是 promise对象会造成异步函数停止执行并且等待 promise 的解决,如果等的是正常的表达式则立即执行。

#### 							3)async==>同步转异步

1. 方法体内部的某个表达式使用await修饰，那么这个方法体所属方法必须要用async修饰所以使用awit方法会自动升级为异步方法



## 3.箭头函数

### 1.箭头函数注意点

1、函数体内的this对象就是定义时所在的对象，而不是使用时所在对象；`重`

2、不可以当作构造函数使用，也就是不能用new命令实例化一个对象，否则会抛出一个错误；

3、不可以使用arguments([详](https://www.cnblogs.com/zhupengcheng/p/11601352.html))对象，该对象在函数体内不存在，如果要用的话，可以用rest参数代替；

4、不可以使用yield([详](https://www.jianshu.com/p/36c74e4ca9eb))命令，箭头函数不能用作Generator函数

### 2.箭头函数和匿名函数区别(作用时间区别)

1. 正常情况下this指向window
2. 箭头函数是编译(解析)时 ==> 编译时指向当前this指向
3. 匿名函数是进行(运行)时==> 全局环境指向window   function



# 三、jQuery

## 1、jquery `:first-child` 和 `first` 有什么区别？

##### :first 只匹配一个元素

> 只会选择第一个 li（john）

##### :first-child

> 在每个 ul 中查找第一个 li

## 2、jQuery 的实现原理

```js
(function(window, undefined) {})(window);
```

jQuery 利⽤ JS 函数作⽤域的特性，采⽤⽴即调⽤表达式包裹了⾃身，解决命名空间和变量污染问题

```js
window.jQuery = window.$ = jQuery;
```

在闭包当中将 jQuery 和 $ 绑定到 window 上，从⽽将 jQuery 和 $ 暴露为全局变量

## 3、谈一下 jQuery 中的 bind(),live(),delegate(),on() 的区别？

>- 1、.bind() 是直接绑定在元素上
>- 2、.live() 则是通过冒泡的方式来绑定到元素上的。更适合列表类型的，绑定到 document DOM 节点上。和。bind() 的优势是支持动态数据。
>- 3、.delegate() 则是更精确的小范围使用事件代理，性能优于。live()
>- 4、.on() 则是最新的 1.9 版本整合了之前的三种方式的新事件绑定机制

## 4、JQ入口函数意义=>

-   入口函数,通常使用和window.onload一样的功效

-   区别:在jquery文件加载后,同时当前的window下面已经有了$和jq对象后,才开始运行



# 四、请求响应、跨域、HTTP

## 1.HTTP请求:是一种规则，无状态，无记忆：

###  1.1、HTTP请求过程

>（1）建立TCP连接
>
>（2）web浏览器向web服务器发送请求指令
>
>（3）web浏览器发送请求头信息
>
>（4）web服务器应答
>
>（5）web服务器发送应答头信息
>
>（6）web服务器向浏览器发送数据
>
>（7）web服务器关闭TCP连接

### 1.2、HTTP请求的4个组成部分：

>  a、HTTP请求方法或者动作(GET/POST)
>
>   b、正在请求的URL
>
>   c、请求头，包含客户环境信息、身份信息等
>
>   d、请求体（正文），包含客户提交的查询字符串信息、表单信息

### 1.3、HTTP响应的三个组成部分：

>  a、一个数字和文字组成的转态码。作用：显示请求是否成功
>
> ​    b、响应头，包含服务器类型、日期、内容类型、长度等
>
> ​    c、响应体，即响应正文，字符串、HTML等 

 

## 2.数据传输简单基础原理=>(服务端,浏览器,POST,GET)

##### 	1. 浏览器访问原理=>

-    协议=>ip=>端口=>uri

##### 	2. 服务端(前端)数据传输过程=>

-   控制层=>逻辑层=>数据层=>后端(数据持久层)

##### 	3. GET与POST区别:=>

*   GET是进行明文传递,POST非明文请求数据放在请求体中

  ​    

## 3.状态码大致意义

>* 4xx开头 ==>是客户端错误,
>* 5xx开头 ==> 服务端问题,
>* 200ok成功，表示用户请求被正确接收、理解和处理，如200
>* 3开头 =>做定向使用  如nginx请求转发 再如303前端使用重定向



## 4.请求响应与跨域概念

#####   1.req:request（请求对象）=>

-     代表,所有跟请求有关的东西都在req对象里头,包括请求参数 请求头 请求头 cookie

##### 2.res:response（响应对象）=>

-   所有响应客户端的东西都在res里头,包括相应参数,响应头(跨域处理就是在这)

##### 3.跨域请求的本质与原理=>

-   当一个请求url的协议、域名、端口三者之间任意一个与当前页面url不同即为跨域

-   请求本质是成功的,但是浏览器判断本次请求不安全



## 5.解决跨域的方法`重`

1. nginx（反向代理）

2. jsonP（json padding）/  fetchJsonP  ==>

   > 封装概念:自动的由插件生成方法名,并在当前的页面动态的生成函数
   > 然后再生成的函数里头调用用户预留的回调函数

3. fetch cors

4. node/服务端设置请求头

## 6.resp.send注意事项

1.  ##### 每个完整的请求,一定要以resp.send来结束请求,强调结束请求,而不是以resp.send结束代码

2.  #####  如果请求结束了,也想让逻辑代码结束,那么一定要以return结束



# 五、webpack(概念理解)

## webpack作用:`重`

>   基于webpack *我们可以实现*
>
>   ​      *1. 高阶语法转低阶语法*
>
>   ​      *2. 模块化语法*
>
>   ​      *3. 图片打包和压缩*
>
>   ​      *4. css html js 压缩包*
>
>   ​      *5.方便构建和打包 vue,react等框架的项目*

##1、谈谈你对webpack的看法

> WebPack 是⼀个模块打包⼯具，你可以使⽤ WebPack 管理你的模块依赖，并编绎输出模 块们所需的静态⽂件。它能够很好地管理、打包 Web 开发中所⽤到的 HTML 、 Javascript 、 CSS 以及各种静态⽂件（图⽚、字体等），让开发过程更加⾼效。对于 不同类型的资源， webpack 有对应的模块加载器。 webpack 模块打包器会分析模块间的 依赖关系，最后 ⽣成了优化且合并后的静态资源

## 2、webpack 打包体积 优化思路

>- 提取第三⽅库或通过引⽤外部⽂件的⽅式引⼊第三⽅库
>- 代码压缩插件 UglifyJsPlugin
>- 服务器启⽤gzip压缩
>- 按需加载资源⽂件 require.ensure
>- 优化 devtool 中的 source-map
>- 剥离 css ⽂件，单独打包
>- 去除不必要插件，通常就是开发环境与⽣产环境⽤同⼀套配置⽂件导致

## 3、webpack 打包效率

>- 开发环境采⽤增量构建，启⽤热更新
>- 开发环境不做⽆意义的⼯作如提取 css 计算⽂件hash等
>- 配置 devtool
>- 选择合适的 loader
>- 个别 loader 开启 cache 如 babel-loader
>- 第三⽅库采⽤引⼊⽅式
>- 提取公共代码
>- 优化构建时的搜索路径 指明需要构建⽬录及不需要构建⽬录
>- 模块化引⼊需要的部分

## 4、webpack搭建顺序:(理解,最好讲得出大概)

#### 1、生成配置文件并且修改

> (1.1)生成package.json文件并且创建webpack.config.js配置文件

> (1.2)修改package.json文件-->优化命令 调用时使用 npm run dev打包

#### 2、完成export打包配置

```js
       webpack 要打包的目标文件  --mode development
```

#### 3、完成打包html时更新导入路径

> (3.1)安装依赖 html-webpack-plugin

> (3.2)在webpack.config.js 配置文件修改

```js
const HtmlWebpackPlugin = require('html-webpack-plugin');
```

#### 4、css,scss文件打包

```js
  npm i style-loader  css-loader  //并在配置文件做出相应修改		
```

```js
 npm i sass-loader      npm i  node-sass
//如果安装出错,使用下面命令安装
npm install yarn -g
yarn config set sass-binary-site http://npm.taobao.org/mirrors/node-sass
```

```js
 {	//配置文件修改
         test:/\.scss$/,
         use:["style-loader","css-loader","sass-loader"]
     }
```

#### 5、自动删除打包后残存js

>安装clean依赖

```js
 npm i  clean-webpack-plugin
```

```js
 const {CleanWebpackPlugin} =require('clean-webpack-plugin')
 //配置清除包,修改配置文件
 new CleanWebpackPlugin(),
```

#### 6、热更新

```js
yarn add webpack-dev-server
```

```js
   devServer:{//热更新配置
        port:80,
        contentBase:__dirname+"/hong"
    },
```

#### 7、打包多个js和html文件(饱汉式,饿汉式子=)

> 1.一个页面可选多js(饱汉)
>
> 2.一个页面多个js(饿汉式)

```js
 此处修改配置文件   entry: {  index: './index.js',//   hong:'./a.js' },
chunks:['index']//指定打包的key,与entry绑定
excludeChunks:['a'] //指定除了某个之外
```

#### 8、打包image和css里头的img

>注意 : 并没有笼统的讲是图片  因为图片的引入的媒介不一样,那么处理的方式不一样

```js
 file-loader =>css里头的background-image:url('./hong.png')
    html-loader => html 里头的<img src="./hong.png">
    yarn add html-loader file-loader
```






# 六、VUE原理

## 概念了解(理解就好)

### 1.MVVM相关概念

>1)model:模型 数据 data methods
>
> 2) view：视图 页面 容器里头的元素
>  view-model 视图和模型的衔接桥梁 vue的实例 vm帮助我们完成了根据我们制定的绑定关系做数据或者页面的渲染
>
>  3) vm：所以vue的实例一般取名为vm。 ==>view-model 

#### 2.我想定义多个vue实例可以吗？

  	>答案：可以的，但是只在h5里头，我们才有机会定义多个vue实例。
  	>
  	>​	spa应用里头是没有机会定义多个vue实例的：
  	>   	 取而代之：用具备自己作用域的组件来实现多个vue实例。  		

### 2.常见的几种指令：`重点理解,最好背`

###### 	1. v-cloak 解决页面闪烁问题

> {{}} 插值表达式(并不是指令)

###### 	2. v-text  类比jQuery里头的text()

###### 	3. v-html  类比jQuery里头的html()

###### 	4. v-on: 事件名称 ==>(绑定事件)

	>@click   v-on: 用@来代替

```html
<button type="button" @click="add" >添加</button>
<input type="text" v-model="condition" placeholder="请输入搜索的内容" @keydown.13="search()">
```

###### 	5. v-bind:属性名称=>(绑定元素)

> 实现对元素的属性的绑定

```html
原生的js：document.getElementById('id').setAttribute(属性名，属性值)
jQuery: $('#id').attr(属性名，属性值) $('#id').attr({属性1：属性值1，属性2：属性值2})
vue:
    <h1 v-bind:yibin="msg">绑定了title属性，鼠标悬浮过来看看</h1>
    缩写：v-bind:属性名  ==》 :属性名  相当于是去掉了v-bind
```

###### 	6. v-for  直接在html里头做数组循环

> 可以对数字、数组、对象等进行循环遍历

```html
<h1 v-for="(item, index) in arr" v-text="item"></h1>
item: 表示遍历过程的每一项元素 元素可能是简单地数据类型也可能是复杂的数据类型
index: 表示遍历过程的每一项元素的下标
v-for的作用域：向内，即所有的子元素都可以共享item index arr三个变量
缩写：（即舍弃index） v-for="item in arr"
计数：
v-for="count in 100"
```

###### 7. v-show 条件渲染、条件显示

> v-show 条件渲染、条件显式 实现display的效果 =>v-show(false）==display:none
>
> ```html
> 通常让一个元素显式、隐藏(display:none; visibility: hidden)
> 原生的js：style
> jQuery: css
> vue : v-show v-if
> <h1 v-for="count in 5" v-text="count" v-show="false"></h1>
> ```

###### 	8. v-if    条件分支显式 

> 条件分支显式 效果等同于v-show 但是性能和安全跟v-show不一样
> v-else-if       v-else
>
> ```html
> <h1 v-if="a < 1"> 我是小于1</h1>
> <h1 v-else-if="a == 1"> 我是等于1</h1>
> <h1 v-else> 我是大于1</h1>
> ```

###### 	9. v-model 数据双向绑定

> 绑定：
> 	1.单向绑定: 将数据绑定到元素上 （数据与元素绑定与之的区别：在于方向，前者的方向是从数据到元素，后者是双向的，即可以从元素到数据也可以从数据到元素）
> 2.双向绑定：就是既可以将数据绑定到元素上，也可以将元素上的值绑定到数据上（所以双向绑定仅仅适用于表单类的标签）==>即数据改变页面元素值改变，元素值改变时数据也改变

```html
<input v-model="formData.name" placeholder="请输入用户名">
<input type="password" v-model="formData.pwd" placeholder="请输入密码">
```

###### 	10. style 和 class 的绑定（不算指令）

​	1）style==> 抽象出来：它是一个对象

```html
 <h1 :style="{color:'red'}">style</h1>
    可以单独把{color:'red'}抽取到data里头
```

​	2) class ==>抽象出来：它是一个数组array

```html
<h1 :class="['c1','c2']">class隶书</h1>
    可以单独把['类名1','类名2']抽取出来
```



###### eg: v-if  与 v-show 的区别：

>1、 v-if在false的时候连同代码都从文档流移除掉。
>v-show在false的时候，元素还在，只是样式变成了display:none
>
>2、 v-if:性能更差，安全性更高 通常用于涉密的场景
>v-show:性能更优，但是安全性更低 通常用于需要频繁在显式于隐藏之间切换的场景（比如：菜单）
>但是通常，v-if和v-show我们是混用的。



### 3.项目包与文件讲解

#### 1.babel.config.js

> 有ES6 7高阶语法库和低阶语法库,可以将高阶语法转换成低阶语法

#### 2.vue.config.js

> 创建vue.config.js来覆盖之前自带的配置

##### (2.1)发布时去掉.map

```js
module.exports={
    devServer:{
        port:80
    },
    //如果是发布的去掉.map
 productionSourceMap: process.env.NODE_ENV === 'production' ? false : true  
}
```

#### 3.src中的assets

> 是被引用的静态

#### 4.main.js

> 入口文件,相当于app.js

#### 5. App.vue

> 根组件

#### 6. components

> 子组件包

### 3.vue-cli 3.x 的 views 和 components有什么区别？

> 1. components是小组件
> 2. containers是容器级组件
> 3. views是页面级组件
> 4. 也就是说，views是页面级组件，components是小组件，小组件可被引用在views中，一般views组件不被复用【containers是容器级组件（根据	项目大小决定是否使用）】
> 5. 从组件大小级别区分 components - （containers）- views



## 1. 谈一下你对 Vue.js 的 MVVM 原理的理解`重点`

### 传统MVC

传统的`MVC`指的是

- M是指业务模型，Model（模型）
- V是指用户界面，View（视图）
- C则是控制器，Controller（控制器）

使用MVC的目的是将M和V的实现代码分离，从而使同一个程序可以使用不同的表现形式。

### MVVM

MVVM 是 Model-View-ViewModel 的缩写

- Model 代表数据模型，也可以在 Model 中定义数据修改和操作的业务逻辑。
- View 代表 UI 组件，它负责将数据模型转化成 UI 展现出来。
- ViewModel 监听模型数据的改变和控制视图⾏为、处理⽤户交互，简单理解就是⼀个同步View 和 Model 的对象，连接 Model 和 View

传统的前端会将数据手动渲染到页面上,`MVVM`模式不需要用户手动操作`dom`元素；

将数据绑定到`viewModel`层上，会自动将数据渲染到页面中，视图变化会通知`viewModel层`更新数据。

`ViewModel`就是我们`MVVM`模式中的桥梁.

## 2.请说一下Vue.js响应式数据的原理?

>1. 核心点:`Object.defineProperty`
>2. 默认`Vue`在初始化数据时，会给`data`中的属性使用`Object.defineProperty`重新定义所有属性,当页面取到对应属性时。会进行依赖收集（收集当前组件的watcher） 如果属性发生变化会通知相关依赖进行更新操作

## 3. `nextTick`作用与实现原理?

>nextTick 可以让我们在下次 DOM 更新循环结束之后执⾏延迟回调，⽤于获 得更新后的 DOM
>
>理解:(**宏任务**和**微任务**) 异步方法
>
>`nextTick`方法主要是使用了**宏任务**和**微任务**,定义了一个异步方法.多次调用`nextTick` 会将方法存入队列中，通过这个异步方法清空当前队列。
>
>所以这个`nextTick`方法就是异步方法

## 4.Vue中模板编译原理

> 将`template`转化成`render`函数

## 5.简述`Vue`中`diff`算法原理`?`

>- 1.先同级比较，在比较子节点
>- 2.先判断一方有儿子一方没儿子的情况
>- 3.比较都有儿子的情况
>- 4.递归比较子节点
>
>diff 算法首先要明确一个概念就是 diff 的对象是虚拟DOM（virtual dom），更新真实 DOM 是 diff 算法的结果









# 七、VUE组件相关

## 1、 `Vue`组件的生命周期概念 `重点※`

总共分为8个阶段创建前/后，载⼊前/后，更新前/后，销毁前/后

- **创建前/后**： 在 beforeCreate 阶段， vue 实例的挂载元素 el 和数据对象 data 都为undefined ，还未初始化。在 created 阶段， vue 实例的数据对象 data 有了，el还 没有
- **载⼊前/后**：在 beforeMount 阶段， vue 实例的 $el 和 data 都初始化了，但还是挂载之前为虚拟的 dom 节点， data.message 还未替换。在 mounted 阶段， vue 实例挂载完成， data.message 成功渲染。
- **更新前/后**：当 data 变化时，会触发 beforeUpdate 和 updated ⽅法
- **销毁前/后**：在执⾏ destroy ⽅法后，对 data 的改变不会再触发周期函数，说明此时 vue 实例已经解除了事件监听以及和 dom 的绑定，但是 dom 结构依然存在

#### 要掌握每个生命周期什么时候被调用

- `beforeCreate` 在实例初始化之后，数据观测(data observer) 之前被调用。
- `created` 实例已经创建完成之后被调用。在这一步，实例已完成以下的配置：数据观测(data observer)，属性和方法的运算， watch/event 事件回调。这里没有$el
- `beforeMount` 在挂载开始之前被调用：相关的 render 函数首次被调用。
- `mounted` el 被新创建的 `vm.$el` 替换，并挂载到实例上去之后调用该钩子。
- `beforeUpdate` 数据更新时调用，发生在虚拟 DOM 重新渲染和打补丁之前。
- `updated` 由于数据更改导致的虚拟 DOM 重新渲染和打补丁，在这之后会调用该钩子。
- `beforeDestroy` 实例销毁之前调用。在这一步，实例仍然完全可用。
- `destroyed` `Vue` 实例销毁后调用。调用后，`Vue` 实例指示的所有东西都会解绑定，所有的事件监听器会被移除，所有的子实例也会被销毁。 该钩子在服务器端渲染期间不被调用。

#### 要掌握每个生命周期内部可以做什么事

- `created` 实例已经创建完成，因为它是最早触发的原因可以进行一些数据，资源的请求。
- `mounted` 实例已经挂载完成，可以进行一些DOM操作
- `beforeUpdate` 可以在这个钩子中进一步地更改状态，这不会触发附加的重渲染过程。
- `updated` 可以执行依赖于 DOM 的操作。然而在大多数情况下，你应该避免在此期间更改状态，因为这可能会导致更新无限循环。 该钩子在服务器端渲染期间不被调用。
- `destroyed` 可以执行一些优化操作,清空定时器，解除绑定事件

## 2、 生命周期引申的问题`重点`

### 什么是vue⽣命周期？

答： Vue 实例从创建到销毁的过程，就是⽣命周期。从开始创建、初始化数据、编译模板、挂载Dom→渲染、更新→渲染、销毁等⼀系列过程，称之为 Vue 的⽣命周期。

### vue⽣命周期的作⽤是什么？

答：它的⽣命周期中有多个事件钩⼦，让我们在控制整个Vue实例的过程时更容易形成好的 逻辑。

### vue⽣命周期总共有⼏个阶段？

答：它可以总共分为 8 个阶段：创建前/后、载⼊前/后、更新前/后、销毁前/销毁后。

### 第⼀次⻚⾯加载会触发哪⼏个钩⼦？

答：会触发下⾯这⼏个 beforeCreate 、 created 、 beforeMount 、 mounted 。

### DOM 渲染在哪个周期中就已经完成？

答： DOM 渲染在 mounted 中就已经完成了



## 3、描述组件渲染和更新过程

> 渲染组件时，会通过`Vue.extend`方法构建子组件的构造函数，并进行实例化。最终手动调用`$mount()`进行挂载。更新组件时会进行`patchVnode`流程.核心就是diff算法



## 4、组件中的 `data`为什么是一个函数?`?`

同一个组件被复用多次，会创建多个实例。

这些实例用的是同一个构造函数，如果`data`是一个对象的话。那么所有组件都共享了同一个对象。为了保证组件的数据独立性要求每个组件必须通过`data`函数返回一个对象作为组件的状态。



## 5、`Vue`父子组件生命周期调用顺序`?`

### 加载渲染过程

```js
父beforeCreate` -> `父created` -> `父beforeMount` -> `子beforeCreate` -> `子created` -> `子beforeMount` -> `子mounted` -> `父mounted
父亲创建好后进行渲染准备,然后子组件创建渲染完成后,父组件才进行渲染
```

### 子组件更新过程

```js
父beforeUpdate` -> `子beforeUpdate` -> `子updated` -> `父updated
父亲准备更新->子组件准备更新以及进行更新  ->父亲更新
```

### 父组件更新过程

```js
父beforeUpdate` -> `父updated
```

## 6、`Vue`组件如何通信以及有哪些方式?`重点※`

> 单向数据流

- 父子间通信 父->子通过`props`、子-> 父`$on、$emit`
- 获取父子组件实例的方式`$parent、$children`
- 在父组件中提供数据子组件进行消费 `Provide、inject`
- `Ref`获取实例的方式调用组件的属性或者方法
- `Event Bus` 实现跨组件通信
- `Vuex`状态管理实现通信

## 7、为什么要使用异步组件？

> 如果组件功能多打包出的结果会变大，我可以采用异步的方式来加载组件。主要依赖`import()`这个语法，可以实现文件的分割加载。

## 8、Vue.js 怎么快速定位哪个组件出现性能问题

> ⽤ timeline ⼯具。 ⼤意是通过 timeline 来查看每个函数的调⽤时常，定位出哪个函数的问题，从⽽能判断哪个组件出了问题

## 9、`Vue-Router`中导航守卫有哪些？

> 完整的导航解析流程  了解
>
> 1. 导航被触发。
> 2. 在失活的组件里调用离开守卫。
> 3. 调用全局的 `beforeEach` 守卫。
> 4. 在重用的组件里调用 `beforeRouteUpdate` 守卫 (2.2+)。
> 5. 在路由配置里调用 `beforeEnter`。
> 6. 解析异步路由组件。
> 7. 在被激活的组件里调用 `beforeRouteEnter`。
> 8. 调用全局的 `beforeResolve` 守卫 (2.5+)。
> 9. 导航被确认。
> 10. 调用全局的 `afterEach` 钩子。
> 11. 触发 DOM 更新。
> 12. 用创建好的实例调用 `beforeRouteEnter` 守卫中传给 `next` 的回调函数



# 八、VUE基础问题

## 1、Vue.js 路由的钩⼦函数`?`

⾸⻚可以控制导航跳转， beforeEach ， afterEach 等，⼀般⽤于⻚⾯ title 的修改。⼀些需要登录才能调整⻚⾯的重定向功能。

- beforeEach 主要有3个参数 to ， from ， next 。
- to ： route 即将进⼊的⽬标路由对象。
- from ： route 当前导航正要离开的路由。
- next ： function ⼀定要调⽤该⽅法 resolve 这个钩⼦。执⾏效果依赖n ext ⽅法的调⽤参数。可以控制⽹⻚的跳转



## 2、Vue.js $route 和 $router 的区别`重点`

- $route 是“路由信息对象”，包括 path ， params ， hash ， query ，fullPath ， matched ， name 等路由信息参数。
- ⽽ $router 是“路由实例”对象包括了路由的跳转⽅法，钩⼦函数等



## 3、Vue.js 如何让CSS只在当前组件中起作⽤?

> 将当前组件的 `<style>` 修改为 `<style scoped>`

## 4、Vue.js `<keep-alive></keep-alive>` 的作⽤是什么?(从缓存中快速渲染)`重点※`

`包裹动态组件时，会缓存不活动的组件实例,主要⽤于保留 组件状态或避免重新渲染

⽐如有⼀个列表和⼀个详情，那么⽤户就会经常执⾏打开详情=>返回列表=> 打开详情…这样的话列表和详情都是⼀个频率很⾼的⻚⾯，那么就可以对列表 组件使⽤ `进⾏缓存，这样⽤户每次返回列表的 时候，都能从缓存中快速渲染，⽽不是重新渲染

## 5、Vue.js 指令v-el的作⽤是什么?

> 提供⼀个在⻚⾯上已存在的 DOM 元素作为 Vue 实例的挂载⽬标.可以是 CSS 选择器，也可以是⼀个 HTMLElement 实例,

## 6、在 Vue.js 中使⽤插件的步骤

>- 采⽤ ES6 的 import … from … 语法或 CommonJS 的 require() ⽅法引⼊插件
>- 使⽤全局⽅法 Vue.use( plugin ) 使⽤插件,可以传⼊⼀个选项对象 Vue.use(MyPlugin, { someOption: true })

## 7、Vue.js 的优点是什么？

>- 低耦合。视图（ View ）可以独⽴于 Model 变化和修改，⼀个 ViewModel 可以绑定到不同的 “View” 上，当View变化的时候Model可以不变，当 Model 变化的时候 View 也可以不变
>- 可重⽤性。你可以把⼀些视图逻辑放在⼀个 ViewModel ⾥⾯，让很多 view 重⽤这段视图逻辑
>- 可测试。界⾯素来是⽐较难于测试的，⽽现在测试可以针对 ViewModel 来写

## 8、Vue.js 路由之间跳转？`重点`

声明式（标签跳转）

```js
<router-link :to="index">
```

编程式（ js跳转）

```js
router.push('index')
```

## 9、Vue.js computed 实现

> 建⽴与其他属性（如： data 、 Store ）的联系；
>
> 属性改变后，通知计算属性重新计算
>
> 实现时，主要如下
>
> 初始化 data ， 使⽤ Object.defineProperty 把这些属性全部转为getter/setter 。
>
> 初始化 computed , 遍历 computed ⾥的每个属性，每个 computed 属性都是⼀个watch 实例。每个属性提供的函数作为属性的 getter ，使⽤Object.defineProperty 转化。
>
> Object.defineProperty getter 依赖收集。⽤于依赖发⽣变化时，触发属性重新计 算。
>
> 若出现当前 computed 计算属性嵌套其他 computed 计算属性时，先进⾏其他的依赖收 集

## 10、Vue.js 组件中 data 什么时候可以使⽤对象`重点`

组件复⽤时所有组件实例都会共享 data ，如果 data 是对象的话，就会造成⼀个组件 修改 data 以后会影响到其他所有组件，所以需要将 data 写成函数，每次⽤到就调⽤ ⼀次函数获得新的数据。

当我们使⽤ new Vue() 的⽅式的时候，⽆论我们将 data 设置为对象还是函数都是可 以的，因为 new Vue() 的⽅式是⽣成⼀个根组件，该组件不会复⽤，也就不存在共享 data 的情况了

# 九、VUE深入理解(加分部分,答不出应该也没问题)

## 1、`Vue`中是如何检测数组变化??

>- 使用函数劫持的方式，重写了数组的方法
>- `Vue`将`data`中的数组，进行了原型链重写。指向了自己定义的数组原型方法，这样当调用数组`api`时，可以通知依赖更新.如果数组中包含着引用类型。会对数组中的引用类型再次进行监控

## 2、为什么`V-for`和`v-if`不能连用`?`

> `v-for`会比`v-if`的优先级高一些,如果连用的话会把`v-if`给每个元素都添加一下,会造成性能问题

## 3、`Vue`中`v-if`和`v-show`的区别

>- `v-if`如果条件不成立不会渲染当前指令所在节点的`dom`元素
>- `v-show`只是切换当前`dom`的显示或者隐藏

## 4、`Vue`中`Computed`的特点

- 默认`computed`也是一个`watcher`是具备缓存的，只要当依赖的属性发生变化时才会更新视图

## 5、`Watch`中的`deep:true` 是如何实现的

- 当用户指定了`watch`中的deep属性为`true`时，如果当前监控的值是数组类型。会对对象中的每一项进行求值，此时会将当前`watcher`存入到对应属性的依赖中，这样数组中对象发生变化时也会通知数据更新

## 6、谈谈你对 Vue.js 中 keep-alive 的了解

> keep-alive`可以实现组件的缓存，当组件切换时不会对当前组件进行卸载,常用的2个属性`include`/`exclude`,2个生命周期`activated`,`deactivated

## 7、`Vue`中`v-html`会导致哪些问题?

- 可能会导致`xss`攻击
- `v-html`会替换掉标签内部的子元素

## 8、实现`hash`路由和`history`路由`?`

- `onhashchange`
- `history.pushState`
- **hash 模式**：在浏览器中符号 “#” ，#以及#后⾯的字符称之为 hash ，⽤ window.location.hash 读取。特点： hash 虽然在 URL 中，但不被包括在 HTTP 请求中；⽤来指导浏览器动作，对服务端安全⽆⽤， hash 不会重加载⻚⾯。
- **history 模式**：h istory 采⽤ HTML5 的新特性；且提供了两个新⽅法：pushState() ， replaceState() 可以对浏览器历史记录栈进⾏修改，以及 popState 事件的监听到状态变更

## 9、何时需要使用`beforeDestroy(销毁)`

- 可能在当前页面中使用了`$on`方法，那需要在组件销毁前解绑。
- 清除自己定义的定时器
- 解除事件的绑定 `scroll mousemove ....`

# 十一、VUEX ([详](https://www.jianshu.com/p/2e5973fe1223))

## 1、vuex是什么？怎么使⽤？哪种功能场景使⽤它？`重点`

- 只⽤来读取的状态集中放在 store 中； 改变状态的⽅式是提交 mutations ，这是个同步的事物； 异步逻辑应该封装在 action 中。
- 在 main.js 引⼊ store ，注⼊。新建了⼀个⽬录 store ， … export
- 场景有：单⻚应⽤中，组件之间的状态、⾳乐播放、登录状态、加⼊购物⻋
- state ： Vuex 使⽤单⼀状态树,即每个应⽤将仅仅包含⼀个 store 实例，但单⼀状态
- 树和模块化并不冲突。存放的数据状态，不可以直接修改⾥⾯的数据。
- mutations ： mutations 定义的⽅法动态修改 Vuex 的 store 中的状态或数据
- getters ：类似 vue 的计算属性，主要⽤来过滤⼀些数据。
- action ： actions 可以理解为通过将 mutations ⾥⾯处⾥数据的⽅法变成可异步的处理数据的⽅法，简单的说就是异步操作数据。 view 层通过 store.dispath 来分发 action
- modules ：项⽬特别复杂的时候，可以让每⼀个模块拥有⾃⼰的 state 、mutation 、 action 、 getters ，使得结构⾮常清晰，⽅便管理

## 2、`action` 和 `mutation`区别

- `mutation`是同步更新数据(内部会进行是否为异步方式更新数据的检测)
- `action` 异步操作，可以获取数据后调佣`mutation`提交最终数据



# `Vue3.0`你知道有哪些改进?

- `Vue3`采用了TS来编写
- 支持 `Composition API`
- `Vue3`中响应式数据原理改成`proxy`
- `vdom`的对比算法更新，只更新`vdom`的绑定了动态数据的部分

# `babel`原理

>1. ES6、7 代码输⼊ ->
>2. babylon 进⾏解析 ->
>3. 得到 AST （抽象语法树）->
>4. plugin ⽤b abel-traverse 对 AST 树进⾏遍历转译 ->
>5. 得到新的 AST 树->
>6. ⽤ babel-generator 通过 AST 树⽣成 ES5 代码
>
>本质就是编译器，当代码转为字符串⽣成 AST ，对 AST 进⾏转变最后再⽣成新的代码
>
>分为三步：词法分析⽣成 Token ，语法分析⽣成 AST ，遍历 AST ，根据插件变换相应的节点，最后把 AST 转换为代码

# `Node.js`的应⽤场景

>- 特点：
>  - 1、它是⼀个 Javascript 运⾏环境
>  - 2、依赖于 Chrome V8 引擎进⾏代码解释
>  - 3、事件驱动
>  - 4、⾮阻塞 I/O
>  - 5、单进程，单线程
>- 优点：
>  - ⾼并发（最重要的优点）
>- 缺点：
>  - 1、只⽀持单核 CPU ，不能充分利⽤ CPU
>  - 2、可靠性低，⼀旦代码某个环节崩溃，整个系统都崩溃

# `React`和`Vue`区别

##### 1.监听数据变化的实现原理不同

> Vue通过 getter/setter以及一些函数的劫持，能精确知道数据变化。
>
> React默认是通过比较引用的方式（diff）进行的，如果不优化可能导致大量不必要的VDOM的重新渲染。为什么React不精确监听数据变化呢？这是因为Vue和React设计理念上的区别，Vue使用的是可变数据，而React更强调数据的不可变，两者没有好坏之分，Vue更加简单，而React构建大型应用的时候更加鲁棒。

##### 2.数据流的不同

##### 3.组件通信的区别

# 十二、Bootstrap(稍微看看就行)

## 1、什么是Bootstrap？以及为什么要使⽤Bootstrap？

>Bootstrap 是⼀个⽤于快速开发 Web 应⽤程序和⽹站的前端框架。
>
>Bootstrap 是基于 HTML 、 CSS 、 JAVASCRIPT 的
>
>Bootstrap 具有移动设备优先、浏览器⽀持良好、容易上⼿、响应式设计等优点，所以Bootstrap 被⼴泛应⽤

## 2、什么是Bootstrap⽹格系统`重点`

> Bootstrap 包含了⼀个响应式的、移动设备优先的、不固定的⽹格系统，可 以随着设备或视⼝⼤⼩的增加⽽适当地扩展到 12 列。它包含了⽤于简单的 布局选项的预定义类，也包含了⽤于⽣成更多语义布局的功能强⼤的混合类

响应式⽹格系统随着屏幕或视⼝（ viewport ）尺⼨的增加，系统会⾃动分为最多`` 12 `列。



## 3、Bootstrap ⽹格系统列与列之间的间隙宽度是多少`?`

> 间隙宽度为 30px （⼀个列的每边分别是 15px ）



## 4、Bootstrap 如果需要在⼀个标题的旁边创建副标题，可以怎样操作

> 在元素两旁添加 `<small>` ，或者添加 .small 的 class

## 5、⽤Bootstrap，如何设置⽂字的对⻬⽅式？

>- class=“text-center” 设置居中⽂本
>- class=“text-right” 设置向右对⻬⽂本
>- class=“text-left” 设置向左对⻬⽂本

## 6、Bootstrap如何设置响应式表格？

> 增加 class=“table-responsive”

## 7、使⽤Bootstrap创建垂直表单的基本步骤？

> （1）向⽗ `<form>` 元素添加 role=“form” ；
>
> （2）把标签和控件放在⼀个带有 class=“form-group” 的 `<div>` 中，这是获取最佳间距 所必需的；
>
> （3）向所有的⽂本元素 `<input>` 、 `<textarea>` 、 `<select>` 添加 class=“form- control”

## 8、使⽤Bootstrap创建⽔平表单的基本步骤？

> （1）向⽗ `<form>` 元素添加 class=“form-horizontal” ；
>
> （2）把标签和控件放在⼀个带有 class=“form-group” 的`<div>` 中；
>
> （3）向标签添加 class=“control-label”

## 9、使⽤Bootstrap如何创建表单控件的帮助⽂本？

> 增加 class=“help-block” 的 span 标签或 p 标签。

## 10、使⽤Bootstrap激活或禁⽤按钮要如何操作？

>- 激活按钮：给按钮增加 .active 的 class
>- 禁⽤按钮：给按钮增加 disabled=“disabled” 的属性

## 11、Bootstrap如何制作按钮组？以及⽔平按钮组和垂直按钮组的优先级？

> （1）⽤ class=“btn-group” 的 `<div>` 去包裹按钮组； class=“btn-group- vertical” 可设置垂直按钮组。
>
> （2） btn-group 的优先级⾼于 btn-group-vertical 的优先级。







1.异步解决问题

2.前端语义化

3.对于前端的了解

> 发展历程  前端能做什么

4.响应式原理

5.你为什么做前端









