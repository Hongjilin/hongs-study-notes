

------



# -----------------------==(VUE贰)==-------------------------

# Vue原生指令、MVVM解释=>Day8_8



## 一.指令的概念:

>  表示vue的指令 只有vue才会认识
>     指令：vue指令 还有自定义指令
>     指令值：是一个表达式，是一个被引号括起来的表达式（单引号也可以是双引号）

## 二.常见的几种指令：

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
>  	1.单向绑定: 将数据绑定到元素上 （数据与元素绑定与之的区别：在于方向，前者的方向是从数据到元素，后者是双向的，即可以从元素到数据也可以从数据到元素）
>     2.双向绑定：就是既可以将数据绑定到元素上，也可以将元素上的值绑定到数据上（所以双向绑定仅仅适用于表单类的标签）==>即数据改变页面元素值改变，元素值改变时数据也改变

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
>    v-show在false的时候，元素还在，只是样式变成了display:none
>
>2、 v-if:性能更差，安全性更高 通常用于涉密的场景
>    v-show:性能更优，但是安全性更低 通常用于需要频繁在显式于隐藏之间切换的场景（比如：菜单）
>    但是通常，v-if和v-show我们是混用的。



## 三.MVVM解释

	1)model:模型 数据 data methods
  view：视图 页面 容器里头的元素
  view-model 视图和模型的衔接桥梁 vue的实例 vm帮助我们完成了根据我们制定的绑定关系做数据或者页面的渲染

   2) vm：所以vue的实例一般取名为vm。 ==>view-model 

  3)老师：我想定义多个vue实例可以吗？
  答案：可以的，在h5里头，我们才有机会定义多个vue实例。
  spa应用里头是没有机会定义多个vue实例的：
    取而代之：用具备自己作用域的组件来实现多个vue实例。