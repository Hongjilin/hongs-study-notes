>本人笔记地址分享:[`全部笔记`](https://gitee.com/hongjilin/hongs-study-notes)、[`Vue学习笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/Vue%E7%AC%94%E8%AE%B0%E6%95%B4%E5%90%88)
>
>该笔记为本人初入前端时学习笔记,记录的时VUE2.x知识点.

# #目录

>[TOC]

# -----------------------==(VUE壹)==-------------------------

# VUE的初步认识=>Day8_6

## 一.什么叫做VUE?

> vue主流的前端三大框架之一 : react  vue  angular

## 二.VUE的概念

> vue是一个构建用户界面的框架(库),它的目标是通过尽可能简单的api实现响应的数据绑定和组合的视图集合 vue自身不是一个全能框架的核心是只关注视图层,因此它非常容易学习，非常容易与其它库或已有项目整合 vue在与相关工具和支持库一起使用时, 也能完美地驱动复杂的单页应用,在之后的课程中,我们会配合webpack来使用

## 三.vue的特点

### 	3.1)响应的数据绑定/响应式编程

> 保持状态和数据的同步

> Vue.js 的核心是一个响应的数据绑定系统，它让数据与 DOM 保持同步非常简单。在使用 jQuery 手工操作 DOM时，我们的代码常常是命令式的、重复的与易错的。 Vue.js 拥抱数据驱动的视图概念。通俗地讲，它意味着我们在普通 HTML 模板中使用特殊的语法将 DOM“绑定”到底层数据。一旦创建了绑定，DOM 将与数据保持同步。 每当修改了数据，DOM 便相应地更新。这样我们应用中的逻辑就几乎都是直接修改数据了，不必与 DOM更新搅在一起。这让我们的代码更容易撰写、理解与维护。

### 		3.2)组件化

> 组件（Component）是 Vue.js 最强大的功能之一。组件可以扩展 HTML 元素，封装可重用的代码。 在较高层面上，组件是自定义元素， Vue.js 的编译器为它添加特殊功能。在有些情况下，组件也可以是原生 HTML 元素的形式，以 is 特性扩展。

### 		3.3)局部刷新应用到了极致

## 四.vue的编码

###### 	4.1)基础指令解释

>   基于H5的形式了解
>    v-xxxx
>    表示vue指令,只有vue才会认识
>    指令: vue指令   还有自定义指令
>    指令值:是一个表达式,是一个被引号括起来的表达式(单引号也可以是双引号)
>
>       1.  v-cloak  解决页面闪烁问题
>           [v-cloak]{ display: none; }
>     2.  {{}} 插值表达式
>     3.  v-text 类比jQ里的text()
>     4.  v-html 类比htm的html()

###### 	4.2)vue简单搭建代码过程

```
<!--1.引包-->
<script src="vue-2.4.0.js"></script>
```

```
<!--html端-->
<!--2.创建vue容器-->
<!--3.指定容器的标识符.支持id和class 建议统一使用-->
<div id="a" style="font-size:50px"></div>
<button id="zanting">暂停</button>
</body>
```

```
//js端
/!*4.创建vue实例  * *!/
    var vm =new Vue({
        // 5.指定容器元素, 容器:就是vue的实例的作用域
        el:'#app',  //vm这个实例的容器是页面上id为app的标签
        //6.添加data属性,data是vm实例的数据仓库,所有的变量都在data里头定义
        data:{
            //仓库里头添加变量msg,变量值为hello world
            msg:'hellow world',
            msg1:'<h1>hellow world</h1>',
        },method:{
            alert:function (msg) {
                alert("")
            } }
    })
```



------



# -----------------------==(VUE贰)==-------------------------

# Vue原生指令、MVVM解释=>Day8_8



## 一.指令的概念:

>  表示vue的指令 只有vue才会认识
>   指令：vue指令 还有自定义指令
>   指令值：是一个表达式，是一个被引号括起来的表达式（单引号也可以是双引号）

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
> 	1.单向绑定: 将数据绑定到元素上 （数据与元素绑定与之的区别：在于方向，前者的方向是从数据到元素，后者是双向的，即可以从元素到数据也可以从数据到元素）
>  2.双向绑定：就是既可以将数据绑定到元素上，也可以将元素上的值绑定到数据上（所以双向绑定仅仅适用于表单类的标签）==>即数据改变页面元素值改变，元素值改变时数据也改变

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



## 三.MVVM解释

	1)model:模型 数据 data methods

  view：视图 页面 容器里头的元素
  view-model 视图和模型的衔接桥梁 vue的实例 vm帮助我们完成了根据我们制定的绑定关系做数据或者页面的渲染

   2) vm：所以vue的实例一般取名为vm。 ==>view-model 

  3)老师：我想定义多个vue实例可以吗？
  答案：可以的，在h5里头，我们才有机会定义多个vue实例。
  spa应用里头是没有机会定义多个vue实例的：
    取而代之：用具备自己作用域的组件来实现多个vue实例。



------



# -----------------------==(VUE叁)==-------------------------

# 过滤器、键盘修饰符、自定义指令、生命周期=>Day8_8笔记总结

## 一.过滤器

#### 1.全局过滤器:

> 相当于是Prototype
>
> ```
> 原型变量：是所有的这一类型的实例共享，任意一个实例改变这个变量，所有的实例的这个变量会同步发生变更，所以通常protype只用来定义常量或者方法
> 构造函数里头的成员变量：是实例所独有的
> ```

###### 	1.1)定义

```js
  /*** 全局范围来定义*/
    Vue.filter('formatDate', function(value, pattern = 'yyyy-MM-dd'){
        return value.format(pattern)
    })
```

###### 	1.2)使用：

> ① |表示管道符用来表示我即将使用过滤器 formatDate的第一个参数固定就是管道符前面的值
>
> ② 全局和局部都有的情况，那么优先调用局部的

```html
<h1>{{date}}</h1>
<h1>{{date|formatDate}}</h1>
<h1>{{date|formatDate('yyyy-MM-dd hh:mm:ss S')}}</h1>
```

#### 2.局部过滤器:

> 局部：filters 跟el data methods是同级别的属性

```js
filters:{
    //   日期格式过滤器
    formatDate (value, pattern = 'yyyy-MM-dd') {
        return value.format(pattern);
     }},
```

## 二.键盘修饰符

##### 	1.概念与作用:

>相当于是event.keycode来绑定按键事件
>onclick onscroll ondblclick 都是鼠标事件....
>keyup keydown keypress(keydown + keyup)
>键盘修饰符是给上述三类key做绑定用的。

##### 	2.定义键盘修饰符:

```js
//键盘修饰符定义  定义回车并且去f2别名
Vue.config.keyCodes.f2 = 113;
```

##### 	3.使用

```html
<input @keyup.f2="test('回车事件')">
```

## 三.自定义指令

>原生指令 就是由vue提供的指令
>自定义指令 用户自己定义的指令

#### 	1. 三种指令定义方式与区别:

###### 		3.1) bind : 

> 最早发生的是bind 绑定关系发生在内存中

```js
bind:function(el){// 表示绑定的时候就起作用
    // 不需要强制要求dom已经显示在页面的场景 // 绑定class style},
```

###### 		3.2) inserted : 

>绑定好之后的结构，插入到文档流，这个时候是inserted

```js
inserted: function(el){// 表示被vue绑定关系之后的视图第一次插入到文档流中起作用
    // 一般是需要dom已经显示在页面而非内存的场景使用},
```

###### 		3.2) updated : 

> 绑定关系的m v发生变更了，会引起updated

```js
updated: function(el){// 表示每次v层变或者m层变，都会起作用}
```

#### 2.全局指令与局部指令的定义与使用

###### 	2.1) 全局指令 => directive

```js
Vue.directive('focus',{
    /*** 插入时候生效
    * @param el 表示被指令作用的元素 dom对象 */
    inserted: function(el){
        el.focus() }})	
```

###### 	2.2) 局部指令 => directives 

###### 	2.3)指令的使用

```html
v-+指令的名称==>v-focus
<h1 v-color="'green'">bind</h1>
```

## 四.生命周期

##### 4.1)Vue四个生命周期

> 下述四个生命周期都没有xx中的过程，是因为本身在每个生命周期阶段xx中，表示的是vue正在执行的过程，那么如果这个时候穿插进来用户主观的行为，会破坏当前正在执行的任务

```js
beforeCreate: function(){	//   创建前
  console.log('beforeCreate,date:' +  this.date)
},
created: function(){// 创建后
    console.log('created,date:' +  this.date)
},
beforeMount: function(){//渲染前
    console.log('beforeMout')
},
mounted: function(){// 渲染后
    console.log('mounted')
},
beforeUpdate: function(){// 更新前
    console.log('beforeUpdate')
},
updated: function(){//  更新后
    console.log('updated')
},
beforeDestroy: function(){//    销毁前
    console.log('beforeDestroy, date' + this.date)
},
destroyed: function(){// 销毁后
    console.log('destroyed' + this)
}
```

##### 4.2)Vue生命周期图

<img src="../../../AppData/Roaming/Typora/typora-user-images/image-20200808193539283.png" alt="image-20200808193539283" style="zoom: 200%;" />	



------



# -----------------------==(VUE肆_1_)==-------------------------

# JSONP封装=>day8_9

## 一、JSONP

##### 	1.jsonp概念与封装注意点:

> 代价:需要前后端联动
> 精髓:自动的由插件生成方法名,并在当前的页面动态的生成函数
>    然后再生成的函数里头调用用户预留的回调函数
> 插件：自动化的去模拟基于script去实现跨域请求的过程（对用户来说是黑盒子）
> 参数拼接：url已经是带参的。和不带参的
> id优化 额可以添加一个容器来管理id

##### 2.自己封装的jsonp

###### 2.1)js代码

```js
<script>
    /**
     * 1.声明一个jsonP插件对象
     * 作用：隔开作用域
     */
    let jsonP = {};

    /**
     *2.在插件对象中创建两个名字备用符数组
     */
    jsonP.char = {
        Number: '0123456789',
        Letter: 'qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM'
    }
    /**
     * 通过随机数抽取备用字符数组库拼凑函数id
     * @param charLen
     * @param numLen
     */
    jsonP.newFunId = function (charLen, numLen) {
        let id = '';
        for (let i = 0; i < charLen; i++) {
            id += this.char.Letter.charAt(Math.random() * 52)
        }
        for (let j = 0; j < numLen; j++) {
            id += Math.floor(Math.random() * 10);
        }
        return id;
    }
    /**
     * 拼接路径
     * @param url
     * @param key
     * @param value
     */
    jsonP.jointUrl = function (url, key, value) {
        if (url && key && value) {
            let sign = "&"
            //如果是第一次
            if (url.indexOf('?') == -1) {
                sign = '?'
            }

            url += sign + key + "=" + value
        }
        return url;
    }
    /**
     封装err属性方便
     */
    jsonP.err = function (msg) {
        console.error(msg)
    }

    /**
     * 发送请求函数
     * @param options
     */
    jsonP.req = function (options) {
        let jsonId={};
        //1.生成方法名
        jsonId.funId = this.newFunId(4,8);
        let Userurl = options.url;
        let Userdata = options.data;
        if (!options) {
            this.err("输入不能空")
            return;
        } else if (!Userurl) {
            this.err("url不能空")
            return;
        } else if (!Userdata) {
            //如果没有data,初始化
            Userdata = {};
        }
        //将函数名赋值给userdata的回调函数属性中
        Userdata.callback = jsonId.funId;
        for (let key in Userdata) {
            Userurl = this.jointUrl(Userurl, key, Userdata[key])
        }
        let script = document.createElement('script');
        script.setAttribute("id" , jsonId.funId);
        script.setAttribute("src" , Userurl);
        //动态生成函数
        let callback=function (result) {
            console.log("xxxxxxx")
            //业务逻辑回调
            if (options.callback){
                try {
                    options.callback(result)
                }catch (e) {
                    this.err(e.message)
                }
            }
            //善后
            let tmp=document.getElementById(jsonId.funId)
            tmp.parentNode.removeChild(tmp);
            eval(jsonId.funId+'=null')
        }
        eval("window."+jsonId.funId+"=function(result){ callback(result) }")
        document.head.appendChild(script)

    }
		//测试调用函数
    let test=function () {
        jsonP.req({
            url:"http://localhost:3000/jsonpx",
            data:{
                a:"111"
            },
            callback:function (result) {
                alert("成功"+result)
            }
        })
    }
</script>
```

###### 2.2)服务端测试代码

```js
router.get('/jsonpx', async function (req, resp, next) {
    let callback=req.query.callback;
    let data=req.query.a;
    if (!data){
        resp.send(`${callback}('洪吉林:我是服务端代码')`)
    }
    resp.send(`${callback}('洪吉林:我是服务端代码`+data+`')`)
})
```





# -----------------------==(VUE肆_2_)==-------------------------

# animate、动画钩子函数、列表动画=>day8_9~10

## 一、自定义过渡动画

##### 1.1)代码示例

```html
/* 可以设置不同的进入和离开动画 */
/* 设置持续时间和动画函数 */
.hongjilin-enter-active {
  transition: all .3s ease;
}
.hongjilin-leave-active {
  transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
//离场动画
.hongjilin-enter, .hongjilin-leave-to
/* .hongjilin-leave-active for below version 2.1.8 */ {
  transform: translateX(10px);
  opacity: 0;
}
```

```html
<div id="example-1">
  <button @click="show = !show">
    Toggle render
  </button>
  <!--取别名类名-->
  <transition name="hongjilin">
    <p v-if="show">hello</p>
  </transition>
</div>
new Vue({
  el: '#example-1',
  data: {
    show: true
  }
})
```

## 二、animate动画库的使用

##### 	2.1)导入animate.css文件

```html
<link rel="stylesheet" href="animate.css">
```

##### 	2.2)animate动画使用

>1.enter-active-class="指定进入的时候绑定的动画类名"
>2.leave-active-class="指定离开的时候绑定的动画类名"
> 注意:如果元素默认就是显示的,那么第一次不会触发动画,如果想第一次就触发动画.可以再添加一个appear属性	

```html
<transition enter-active-class="animated fadeInRight "
leave-active-class=" animated  fadeOutRight"
            appear>
    <h1 v-show="flag1">动起来！</h1>
</transition>
```

##### 2.3)animate官网

> https://animate.style/

##### (2.4)mode  in-out先进后出 out-in先出后进

```html
   <transition appear mode='out-in'>
            <!-- :is后面跟的是变量,通过变量来指定组件 -->
            <component :is="jilin"></component>
          </transition>
```



## 三.钩子动画函数

##### 	3.1)代码解析：

```html
   <div>
   <button type="button" @click="flag=!flag">快跑</button>
      <!-- 定义js的钩子函数 -->
<transition
    @before-enter="beforeEnter"
    @enter="enter"
    @after-enter="afterEnter"
>
 <div v-show="show" style="width:100px;height:100px;border-radius: 50px;background-color: red;"></div>
</transition>
        </div>



```

```js
let vm = new Vue({
    el: "#app",
    data: {
        flag: false,
    },
    methods: {
        // el 表示要执行动画的那个DOM元素, 是原生的 js DOM 对象
        beforeEnter(el) {
            // 设置动画开始之前的初始位置
            el.style.transform = "translate(0, 0)"
        },
        enter(el, done) {
            // 刷新动画效果
            el.offsetWidth;
            // 动画完成后的样式
            el.style.transform = "translate(550px, 350px)";
            // 动画的持续时间
            el.style.transition = "all 3s ease";
            // done 其实是 afterEnter() 的引用
            done();
        },
        afterEnter(el) {
            // 动画完成之后调用
            this.flag = !this.flag
        }
    }
})
```

## 四.列表动画

```html
<!DOCTYPE html>
<html lang="en">
<head>
</html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<script src="./lib/vue-2.4.0.js"></script>

<style>
  /* 列表项样式 */
  li{
    border: 1px dashed #999;
    margin:5px;
    line-height: 35px;
    padding-left: 5px;
    font-size: 12px;
    width:100%;
  }
  /* 鼠标列表项悬停效果 */
  li:hover{
    background-color: grey;
    transition: all 0.8s ease;
  }
  /* transition渐变出入场必写基础项 */
  .v-enter,.v-leave-to{
    opacity: 0;
    transform:translateY(80px);
  }
  .v-enter-active,.v-leave-active{
    transition: all 0.6s ease;
  }

 /* transition 在删除列表项的同时，使剩余未删除项可同步移动对原位置填充*/
  .v-move{
    transition:all 0.6s ease;
  }
  .v-leave-active{
    position: absolute;
  }
 
</style>
</head>

<body>
  <div id="app">
    <div>
      <label>
        Id: 
        <input type="text" v-model="id">
      </label>

      <label>
        Name: 
        <input type="text" v-model="name">
      </label>

      <input type="button" value="添加" @click="add">
    </div>

    <!-- 列表项必须用transition-group代替transition包围 -->
    <!-- appear属性实现列表项入场式效果，必须写上否则入场没效果 -->
    <!-- tag属性如果不设置，则默认为span -->
    <transition-group appear tag="ul">
      <li v-for="(item,i) in list" :key="item.id" @click="del(i)">
        {{item.id}}---{{item.name}}
      </li>
    </transition-group>
  </div>

  <script>
    var vm=new Vue({
      el:'#app',
      data:{
        id:'',
        name:'',
        //[]不是{}
        list:[
        {id:1,name:'ess'},
          {id:2,name:'red'},
          {id:3,name:'rdne'},
          {id:4,name:'dnje'}
        ]
      },
      methods:{
        add(){
          this.list.push({id:this.id,name:this.name})
          this.id=this.name=''
        },
        del(i){
          this.list.splice(i,1)
        }
      }
    })
  </script>
</body>
</html>
```



# -----------------------==(VUE伍)==-------------------------

# webpack安装与使用

## 一.webpack作用:

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

## 二.webpack安装需要的依赖

```js
 1.webpack
 2.webpack-cli
npm i webpack webpack-cli -g //最好全局安装,这样可以才可以使用命令行,其他的依赖最好局部
npm install html-webpack-plugin //重新打包我们的html,同时注入我们生成的js文件,文件名已经生成的文件的路径由配置决定
 npm i style-loader css-loader// 每次新增依赖需要重新link
```

## 三.webpack搭建顺序:

##### 1、优化命令使用

>  1)nom run 命令*           2)打包的命令靠过去 -->nom run 命令*
>
>  3)webpack.config.js+npm项目*   npm init -y ->生成package.json 修改*
>
>  *创建wenpack.config.js文件*
>
>  4) .json文件里头只能存储标准的json对象*
>
>   ① 有key 有value  *② key必须是带双引号的字符串*
>
>   *③ 不能出现除key 与 value之外的字符 注释,多余的符号*

###### (1.1)生成package.json文件并且创建webpack.config.js配置文件

```js
1.npm init -y // 生成package.json 用于优化命令行
2.在项目根目录创建webpack.config.js文件 这是配置文件
```

###### (1.2)修改package.json文件-->优化命令 调用时使用 npm run dev打包

```json
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "dev": "webpack --mode development",
    "build": "webpack --mode production",
    "link": "npm link webpack --save-dev"
  }
```

##### 2、完成export打包配置

```js
      //默认会去打包 项目根目录下的src下的inex.html  默认打包之后 dist main.js
      //  webpack --mode production   //开发 进行压缩可读性差
 		//		 webpack --mode development   //未压缩 需要指定打包文件用下面那行命令
        webpack 要打包的目标文件  --mode development
     //   牛刀小试:export的错误就没了
```

##### 3、完成打包html时更新导入路径

###### (3.1)安装依赖 html-webpack-plugin 

```js
  npm install html-webpack-plugin  		//并在配置文件做出相应修改
```

###### (3.2)在webpack.config.js 配置文件修改

```js
const HtmlWebpackPlugin = require('html-webpack-plugin');
```

##### 4、css文件打包

###### (4.1)安装css依赖文件

```js
   npm i style-loader  css-loader  //并在配置文件做出相应修改
```

##### 5、scss文件打包

###### (5.1)安装scss依赖文件

```js
 npm i sass-loader      npm i  node-sass
//如果安装出错,使用下面命令安装
npm install yarn -g
yarn config set sass-binary-site http://npm.taobao.org/mirrors/node-sass
```

###### (5.2)配置文件修改

```js
  {
         test:/\.scss$/,
         use:["style-loader","css-loader","sass-loader"]
     }
```



##### 6、自动删除打包后残存js

###### (6.1)安装clean依赖

```
  npm i  clean-webpack-plugin
```

###### (6.2)解释

> 新版本跟旧版本的使用不一样
>
> 新版本的构造器通过解构赋值得到
>
> 新版本的实例不需要指定参数.默认就是hong下面

###### (6.3)修改配置文件

```js
 const {CleanWebpackPlugin} =require('clean-webpack-plugin')
 //配置清除包
 new CleanWebpackPlugin(),
```

#####  7、热更新

###### (7.1)安装热更新

```js
 yarn add webpack-dev-server
```

###### (7.2)配置文件修改

```js
    //热更新配置
    devServer:{
        port:80,
        contentBase:__dirname+"/hong"
    },
```

###### (7.3)package文件修改

```js
  "dev": "webpack-dev-server",
```

##### 8、打包多个js和html文件

> 业务驱动       单页面 单js 多个页面 多个js
>
> html-webpack-plugin ==>解决多个html问题    
>
> 升级entry -->js   升级output -->js

```js
    配合升级entry
    1.一个页面多个js(饿汉式)
       此处修改配置文件   entry: {  index: './index.js',//   hong:'./a.js' },
 2.一个页面可选多js(饱汉)
//指定打包的key,与entry绑定
chunks:['index']
 //指定除了某个之外
excludeChunks:['a']
```



##### 9、打包image和css里头的img

> 注意 : 并没有笼统的讲是图片
>
> 因为图片的引入的媒介不一样,那么处理的方式不一样

###### (9.1)下载依赖

```js
     file-loader =>css里头的background-image:url('./hong.png')
        html-loader => html 里头的<img src="./hong.png">
        yarn add html-loader file-loader
```

##### 10、最终配置文件 webpack.config.js示例与解释

```js
const HtmlWebpackPlugin = require('html-webpack-plugin');

const {CleanWebpackPlugin} =require('clean-webpack-plugin')

module.exports={
    //热更新配置
    devServer:{
      //端口
        port:80,
      //打包到哪个路径
        contentBase:__dirname+"/hong"
    },
    //配置入口,以当前文件目录作为开始目录
    entry: {
      //别名:要打包的js
      index: './index.js',
      hong:'./a.js'
    },

    output:{
        //配置打包的目录和文件名字
        path: __dirname + '/hong',
        filename:'[name]_[hash:9].js'
    } ,
    //s使用插件
    plugins:[
      
        //配置清除包
        new CleanWebpackPlugin(),
        new HtmlWebpackPlugin({
            //用来指定模板
            template:'./index.html',
            //文件名 再热更新后通过这个访问
            filename:'hongjilin.html',
            //当指定模板后,模板优先,没有指定的时候才生效
            title:'大家嗨起来',
         /*   minify:{ 这个命令会压缩html
            // /取出src后面的空格,
            // //    collapseWhitespace:'true'
             },*/
            //指定打包的key,与entry绑定
            // chunks:['index']
            //指定除了某个之外的js打包
            excludeChunks:['a']
        }),
        //打包第二个页面
        new HtmlWebpackPlugin({
            //用来指定模板
            template:'./copy.html',
            //文件名 再热更新后通过这个访问
            filename:'copyweb.html',
            //当指定模板后,模板优先,没有指定的时候才生效
            title:'大家起来',
            excludeChunks:['index']
        })
    ],
    
    module:{
        rules:[
            {       //规定什么文件使用这个规则
                   test:/\.css$/,
                   //使用什么加载器
                   use:['style-loader','css-loader'] 
            },
                 {
                    test:/\.scss$/,
                    use:["style-loader","css-loader","sass-loader"]
                 },
                 {  //图片打包
                     test: /\.png|jpe?g|gif|bmp|svg$/,
                     use:[
                         {
                             loader:'file-loader',
                             options:{
                               //[ext]是图片标准后缀名
                                 name:'[name]_[hash:9].[ext]',
                               //指定输出地址
                                 outputPath:'./images/'
                             }
                         }
                     ]
                 },
                 {
                     test:/\.(html)$/,
                     use:{
                         loader:'html-loader',
                     }
                 }
        ]
    },

}
```

##### 11、package文件修改

```js
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    //"dev": "webpack-dev-server", 使用热更新  文件内不能注释
     "dev": "webpack --mode development",
    "build": "webpack --mode production",
    "link": "npm link webpack --save-dev"
  },
```

## 四.webpack打包时报错与解决

##### (1)无法加载文件 D:\nodejs\node_global\webpack.ps1，因为在此系统上禁止运行脚本。

```js
 问题解决:
通过vs code 运行webpack进行打包时，报错webpack : 无法加载文件 D:\nodejs\node_global\webpack.ps1，因为在此系统上禁止运行脚本。
解决方案：
以管理员身份运行vs code
执行：get-ExecutionPolicy，显示Restricted，表示状态是禁止的
执行：set-ExecutionPolicy RemoteSigned
这时再执行get-ExecutionPolicy，就显示RemoteSigned
```

##### (2)*出现问题了:被打包的文件的方法或者变量没办法直接被页面访问*

>  2.1)webpack打包的精髓:局部作用域
>
>  *2.2)js的代码只能主动去操作html反之不行*
>
>  *2.3)这个思想跟vue很像*

##### (3) 注入时候出现找不到webpack错误

> 因为webpack我们是全局安装,所以先运行 npm run link生成webpack快捷键,使得我们能找到webpack
>
> 再运行  "dev": "webpack --mode development",运行

##### (4)运行报错 json-bett.....错误

> 这是因为安装了局部还有全局的webpack
>
> 卸载全部webpack再重新安装
>
> npm remove webpack -g

##### (5)ERROR in ./index.js

> ERROR in ./index.jsModule not found: Error: Can't resolve 'sass-loader' in 'E:\fyVSCode\XK_VUE\VUE_webpack' @ ./index.js 2:0-21
>
> 缺少下载 sass-loader 





## 伍.创建新项目

```js
yarn add webpack-dev-server
yarn add clean-webpack-plugin
yarn add html-webpack-plugin
npm i css-loader style-loader sass-loader
yarn add node-sass
yarn add file-loader
yarn add html-loader
yarn add html-loader
------------------------------------------------------------------
 "clean-webpack-plugin": "^3.0.0",
    "css-loader": "^4.2.1",
    "html-loader": "^1.1.0",
    "html-webpack-plugin": "^4.3.0",
    "node-sass": "^4.14.1",
    "sass-loader": "^9.0.3",
    "style-loader": "^1.2.1",
    "webpack-dev-server": "^3.11.0"
```

# -----------------------==(VUE陆)==-------------------------

# 组件代码示例=>day8_14

## 一、什么是组件

>组件的出现就是为了拆分Vue实例的代码量,能够让我们以不同的组件.来划分不同的功能模块,需要什么功能,就调用相应的功能模块

  

## 二、组件使用

### 1.创建组件模板

##### (1.1)template模板不能创建在容器中

```html
   <!-- template最好不要在容器里面 -->
    <template id="login">
      <!--template的根容器只能有一个  -->
        <div>
          <h1 v-text="kh" @click="say()"></h1>
          <!-- 绑定 -->
          <h1 @click="$emit('hong',1,2,3,4)">惦记我调用父亲方法</h1>
          <h1 @click="$emit('dier',1,2,3,4)">惦记我调用第二份父亲方法</h1>
        </div>
    </template>
```

### 2.组件注册

> 组件约等于实例，在实例中声明则是局部组件，这个组件只能在这个实例中使用

```js
    //进行定义组件 局部组件
    components:{
      //定义时候驼峰,使用时变-
        'login':{
       	   //这里绑的是组件模板中的id
            template:'#login',
            //绑定父组件传来的值 -->这里定义的对应vm实例中的<login :kh='msg' ref="first"></login>   
              //即组件想要调用实例的data属性使用这个
            props:['kh'],
            data() {
                return {
                    msg:111
                }
            },
            methods:{
                say(){
                    alert(11111)
                },
                sonfun(){
                    alert('我是儿子方法')
                }
            }
        },
        'regist':{
            template:'#regist',
            data() {
                return {
                    msg:222
                }
            },
            methods:{
                say(){
                    alert("我是子组件")
                }
            }
        }
    }
```

## 三、组件切换

>(1)v-if   (2)v-show  (3)component :is    组件切换的三种方法

##### （3.1）v-if进行隐藏显示

```html
      <!-- 通过v-if进行隐藏显示 -->
         <login v-if='flag'></login>
          <regist v-else></regist>
          <button type="button" @mouseover="flag=true" @mouseout='flag=false'>钱钱钱</button>
```



##### （3.2)component :is进行切换

```html
   <!-- mode  in-out先进后出 out-in先出后进  -->
          <transition appear mode='out-in'>
            <!-- :is后面跟的是vm变量,通过vm变量的来指定组件 -->
            <component :is="jilin"></component>
          </transition>
```

##### (3.3)vmjs代码示例

```js
window.vm=new Vue({
    el:'#app',
    data:{
        flag:false,
        jilin:'login'
    },
    //进行定义组件
    components:{
        'login':{
            template:'#login',
            props:['kh'],
    }
})
```



## 四、父子组件互相使用传值

> 组件和实例之间是有独立的作用域 组件的方法和变量在实例中是不能用的,反之亦可



### (4.1)父类(vm)调用子组件的方法(\$children)($refs）

> 组件要用实例的参数或者要调用实例的方法组件时以标签的形式进行复用  
>
> (1)父亲调用儿子,必须先拿到儿子的句柄 $children  
>
> ​	根据句柄来调用方法根据数组存储,缺点是多组件的情况下不灵活
>
> (2)通过$ref来获取子组件
>
> ​    根据json对象的格式来存储

##### (4.1.1) 前端两种调用方式代码示例(父亲调用儿子方法)

```html
						<!--sonfun是组件内定义的方法 -->
          <h1 @click='$children[0].sonfun()'>点击调用儿子1</h1>
          <h1 @click='$refs.first.sonfun()'>点击调用儿子</h1>
-------------------------------------------------------------------------------------
						<!--使用ref需要先定义ref属性，之后使用￥refs的时候就通过这个Key进行查找 -->
         <login :kh='msg' ref="first"></login>   
         <login :kh='msg' ref="second"></login>  
```

##### (4.1.2) js中的定义

```js
 'login':{
            template:'#login',
            methods:{
                son(){  alert('我是儿子方法')}
            }     }
```

### (4.2)子组件调用父类(vm)的方法(\$emit) --同时父类通过这个调用儿子方法

##### (4.2.1)模板定义与调用前端代码示例  

> 通过在父类绑定自定义事件,再由\$emit进行绑定点击事件之类的

```html
   <!-- 子组件调用vm  -->
<div id="app">
    <login :kh='msg' ref="second" @hong='fater' @dier='fater2'></login>   
  </div>
-------------------------------------------------------------------------------
<template id="login">
        <div>
          <!-- 绑定容器中绑定的事件 -->
          <h1 @click="$emit('hong',1,2,3,4)">惦记我调用父亲方法</h1>
          <h1 @click="$emit('dier',1,2,3,4)">惦记我调用第二份父亲方法</h1>
        </div>
    </template>
```

##### (4.2.2)js部分代码示例

```js
window.vm=new Vue({
  //父类方法
    methods: {
        fater(...son){
            alert("我是父亲"+son);
        },
        fater2(...son){
            alert("我是第二份父亲"+son);
        },
    },
	  //组件注册
    components:{
        'login':{   xxxx  }
     },  
})
```

### (4.3)子组件使用父类(vm)的data值(props)

##### (4.3.1)前端代码示例

>:kh='msg' 其中msg是父类中的data值 

```html
 <!-- :kh='msg' 其中msg是父类中的 -->
 <!-- 通过:bind绑定父类的值到子组件的kh,然后在js中用props承接 -->
<login :kh='msg' ref="first"></login>   
 <login :kh='msg' ref="second" @hong='fater' @dier='fater2'></login>  
--------------------------------------------------------------------------
	<!-- 这时候kh相当于调用时的msg-->
   <template id="login"> <div>
          <h1 v-text="kh" @click="say()"></h1>
          </div>
    </template>
```

##### (4.3.2)js代码示例

```js
window.vm=new Vue({
    el:'#app',
    data:{
        msg:"hello world",
    },
    components:{
        'login':{
            template:'#login',
          //子类要用父类的值都在这里有体现
            props:['kh'],
    }
})
```

## 五.\$refs

> 是实例和所有组件共享的一个变量
>
> 通过this可以直接调用

##### 使用

> 1)无需通过v-bind指令进行绑定,只要想普通的标签的属性那样使用即可
>
> 2)属性值eg:refValue即后续我们要找的唯一标识
>
> 3)this.$refs.refValue拿到的是我们的组件
>
> ​	3-1)普通标签
>
> ​	3-2)组件的标签



## 六、全局组件

```js
/**全局定义路由     */
Vue.component('father',fater)
```





## 七、所有代码



```html
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div id="app">
        <!-- <transition-group appear tag="ul">
            <li v-for="(item,i) in list" :key="item" @click="del(i)">
              {{item}}
            </li>
          </transition-group> -->
          <!-- 同过v-if进行隐藏显示 -->
          <!--
             <login v-if='flag'></login>  
          <regist v-else></regist>
          <button type="button" @mouseover="flag=true" @mouseout='flag=false'>钱钱钱</button> -->
          <button type="button" @mouseover="jilin='login'" @mouseout='jilin="regist"'>钱钱钱</button>
      
          <!-- mode  in-out先进后出 out-in先出后进  -->
          <transition appear mode='out-in'>
            <!-- :is后面跟的是变量,通过变量来指定组件 -->
            <component :is="jilin"></component>
          </transition>

          <h1 @click='$children[0].son()'>点击调用儿子1</h1>
          <h1 @click='$refs.first.son()'>点击调用儿子</h1>

         <login :kh='msg' ref="first"></login>   
         <login :kh='msg' ref="second" @hong='fater' @dier='fater2'></login>   

        </div>

    <!-- template最好不要在容器里面 -->
    <template id="login">
      <!--template的根容器只能有一个  -->
        <div>
          <h1 v-text="kh" @click="say()"></h1>
          <!-- 绑定 -->
          <h1 @click="$emit('hong',1,2,3,4)">惦记我调用父亲方法</h1>
          <h1 @click="$emit('dier',1,2,3,4)">惦记我调用第二份父亲方法</h1>
        </div>
    </template>
    <!-- template最好不要在容器里面 -->
    <template id="regist">
      <!--template的根容器只能有一个  -->
        <div>
          <h1 v-text="msg" @click="say()"></h1>
          <h1>zzz</h1>
          <h1>zzz</h1>
        </div>
    </template>

</body>
<script>
  function get(_this){
    alert(_this)
  }
</script>

</html>
```

###### 8_14路由器前代码

```js
import Vue from '../lib/vue-2.4.0' 
import './index.scss'
window.vm=new Vue({
    el:'#app',
    data:{
        msg:"hello world",
        list:[
            1,2,3,4,5
        ],
        flag:false,
        jilin:'login'
    },
    methods: {
        del(index){
            this.list.splice(index,1)
        },
        fater(...son){
            alert("我是父亲"+son);
        },
        fater2(...son){
            alert("我是第二份父亲"+son);
        },
    },
    //进行定义组件
    components:{
        'login':{
            template:'#login',
            //绑定父组件传来的值
            props:['kh'],
            data() {
                return {
                    msg:111
                }
            },
            methods:{
                say(){
                    alert(11111)
                },
                son(){
                    alert('我是儿子方法')
                }
            }

        },
        'regist':{
            template:'#regist',
            data() {
                return {
                    msg:222
                }
            },
            methods:{
                say(){
                    alert("我是子组件")
                }
            }
        }
    }
})
```

# -----------------------==(VUE柒)==-------------------------

# 路由=>day8_15

## 一、回顾与技术栈梳理

>  1.node-路由
>
>  ​    指向当前应用的某个具体资源的路径
>
>  2.express
>
>   两层路由
>
>  ​    app.js 具体的某个router文件
>
>  3. sequelize orm的框架
>
>  ​      持久层 特别容易特别方便
>
>  ​      model 创建是手动的
>
>  ​      sequelize-auto 快捷工具 model全自动生成
>
>  ​        持久层只剩下调用api
>
>  4. 升级pxpress成koa2
>
>  ​      ctx 
>
>  ​      单层路由,允许在单层路由里定义多级路由
>
>  ​	5.一阶段a标签定位到页面的某个位置
>
>  ​      Bootstrap

## 二、前端路由的概念

>​    vue 当作是页面显示的工具
>
>1. 锚点
>
>​      \#xxxx -->称为hash值
>
>2. 服务端的路由
>
>​      定位服务端的唯一的资源
>
>3. 前端的路由
>
>​      页面并没有跳转也不会刷新.知识基于url+#hash
>
>​        定位到页面上的唯一的一个资源
>
>​        ==>vue里头其实就是定位到某个具体的组件
>
>​        ==>vue-router
>
> (3.1)  hash值不一样,只会定义到页面上某个具体的内容(a标签)
>
>  (3.2) 大前提: vue环境下,hash值变了,会让某个具体的组件显示出来,而且
>
>​        同时会隐藏掉当前的组件

## 三、vue中router与router与route区别

### 1.$route对象

$route对象表示当前的路由信息，包含了当前 URL 解析得到的信息。包含当前的路径，参数，query对象等。

>1.$route.path**   字符串，对应当前路由的路径，总是解析为绝对路径，如"/foo/bar"。
>
>2.$route.params**   一个 key/value 对象，包含了 动态片段 和 全匹配片段，   如果没有路由参数，就是一个空对象。
>
>3.$route.query**   一个 key/value 对象，表示 URL 查询参数。   例如，对于路径 /foo?user=1，则有$route.query.user == 1，   如果没有查询参数，则是个空对象。
>
>4.$route.hash**   当前路由的hash值 (不带#) ，如果没有 hash 值，则为空字符串。锚点*
>
>5.$route.fullPath**   完成解析后的 URL，包含查询参数和hash的完整路径。
>
>6.$route.matched**   数组，包含当前匹配的路径中所包含的所有片段所对应的配置参数对象。
>
>7.$route.name  当前路径名字
>
>8.$route.meta 路由元信息
>
>\```
>
>route object 出现在多个地方:
>
>组件内的 this.route和route和route watcher 回调（监测变化处理）;
>
>router.match(location) 的返回值
>
>scrollBehavior 方法的参数
>
>导航钩子的参数：
>
>router.beforeEach((to,from, next)=>{//to 和from都是 路由信息对象,后面使用路由的钩子函数就容易理解了})

![](route%E5%AF%B9%E8%B1%A1.webp)

### 2.$router对象

> $router对象是全局路由的实例，是router构造方法的实例。

##### (2.1)push

```js
1.字符串this.$router.push('home')

\2. 对象this.$router.push({path:'home'})

\3. 命名的路由this.$router.push({name:'user',params:{userId:123}})

4.带查询参数，变成 /register?plan=123this.$router.push({path:'register',query:{plan:'123'}})

push方法其实和<router-link :to="...">是等同的。
注意：push方法的跳转会向 history 栈添加一个新的记录，当我们点击浏览器的返回按钮时可以看到之前的页面。
```

##### (2.2)go

```js
 页面路由跳转 
前进或者后退this.$router.go(-1) // 后退
```

##### (2.3)replace

```js
push方法会向 history 栈添加一个新的记录，而replace方法是替换当前的页面，
不会向 history 栈添加一个新的记录
// 一般使用replace来做404页面
this.$router.replace('/')
配置路由时path有时候会加 '/' 有时候不加,以'/'开头的会被当作根路径，就不会一直嵌套之前的路径。
```

![](router.webp)

### 3.区别

>#### $router
>
>$router是去全局的一个路由实例(全局变量),
>
>1. `this.$router.push({path: '/login'}); // 路由跳转, 向 history 中增加一条记录`
>2. `this.$router.go(-1); // 路由前进(正数)或者后退(负数), 0刷新当前页面`
>3. `this.$router.replace({path: '/login'}); // 在 history记录中替换当前路径, 不记录.`
>
>#### $route
>
>\$router是一个跳转的路由对象(局部变量), 每一个路由都有自己的route, route中记录了当前路由的跳转的name, path, params, query;
>	获取的时候, `this.$route.path, this.$route.query`$router

## 四、路由(vue-router)使用

##### (4.1)引包并使用

```js
 引包 import VueRouter from '../lib/vue-router-3.0.1' 
 Vue.use(VueRouter)
```

##### (4.2)配置routes

>1. path  2.component 3.redirect 4.挂载路由 5.创建组件占位符(html) router-view
>2. 代码示例见后面

## 五、router-link的使用

>1. 默认会被渲染成a标签的锚点形式:可以更改路由-hash
>
> 可以通过指定tag属性,更改router-link渲染城的标签的格式
>
> 此时router-link可以更改hash,是基于编程式导航(js)
>
>2.编程式导航:
>
>​     是比router-link更常用的一种改变路由地址的方式
>
>3. $router 路由对象
>
>4. 前进 forward(n)  2.后退 back(n)  3.go(n) 4.n>0后退  5. 跳转
>
>5. $route hash对象

##### (5.1)代码示例

```html
   <div>  <!-- 使用路由 tag可以渲染成变得标签格式,实际上是帮我们绑定事件 -->
          <router-link tag="div" to="/login" >登录</router-link>
          <router-link to="/res" >注册</router-link>
          <router-link to="/xxx" >异常演示</router-link>
          <!-- 直接使用a标签要加#  -->
          <a href="#/login"> 是</a>
        </div>
```

## 六、路由带参

#### (6.1)怎么传?

##### a.restful风格 以占位符的形式

```js
  当路由变为xxx的时候要显示的式xx组件,同时要给这个组件传n个参数
​    1)restful风格 以占位符的形式,但是每个占位符参与路由筛选的过程
​       http://localhost/#/1/2/3  
​       /1/2/3  即是参数也是路由规则
​       path:"/:a/:b" 就必须完全匹配才能找到的
```

##### b.查询字符串的方式

```js
  2)查询字符串的方式,跟传统的url地址传参的形式一样,参数包括
​      问号在内的字符串式不参与路由筛选的过程
​    http://localhost/login?x=1
​    其中?x=1不属于路由配置path ,只有login是path要筛选的
```

#### (6.2)怎么取?

##### a.\$route --> 以$开头的组件与实例通用

```js
   查询字符串 
       http://localhost/hongjilin.html?a=11#/login/1/2?a=111
        fullPath: "/login/1/2?a=111"
        hash: ""
        matched: [{…}]
        meta: {}
        name: undefined
        params: {0: "/login/1/2"}
         path: "/login/1/2"
        query: {a: "111"}
//vm.$route.query....
```

##### (6.3)具体代码示例

###### 1.query方式传参数

```js
this.$router.push({path: '/user', query: {id: '27001'}});
// 获取参数方式:
this.is = this.$route.query.id;

```

###### 2.params 方式传递参数

```js
this.$router.push({name: 'user', params: {id: '27001'}});
// 获取参数方式
this.id = this.$route.params.id;
-------------------------------------------------------------------------------------------------
需要注意的是使用params传参的时候, 路由配置必须按照以下方式来配置, name属性必须有, path后面必须写上传递的参数名, 这样才能保证刷新页面的时候, 参数不会被丢失.
{
	path:'/user/:id',
	name: 'user',
	component: (resolve) => { require(['../components/user/index.vue'], resolve)}
},
```

## 七、路由器嵌套

##### 1.前端template代码示例

```html
 <transition mode='out-in'>
        <router-view>

        </router-view>
      </transition>
---------------------------------------------------------------------
<!-- template最好不要在容器里面 -->
<template id="father">
        <div style="background-color: aquamarine;">
           <h1>我是父亲</h1>
           <router-view></router-view>   
        </div>
    </template>
```

##### 2.js端代码示例以及注意事项

```js
   {
            path:'/father',
            component:fater,
            children:[
                {//如果加了/ 代表不能是father/regist 而是直接根目录到regist
                    path:'regist', //father(只显示父亲) //father/regist(在显示父亲的之后再显示儿子)
                    //定义的组件
                    component:res,
                }
            ]
        },
```

## 八、全部代码示例

### 1.前端html

```html
  <div id="app">
      <transition mode='out-in'>
        <router-view>
        </router-view>
      </transition>
        <div>
          <!-- 使用路由 -->
          <router-link tag="div" to="/login" >登录</router-link>
          <router-link to="/res" >注册</router-link>
          <router-link to="/xxx" >异常演示</router-link>
          <!-- 直接使用a标签要加#  -->
          <a href="#/login"> 是</a>
        </div>
     </div>
 <div>--------------------------------------------------------</div>

<!-- template最好不要在容器里面 -->
<template id="father">
        <div style="background-color: aquamarine;">
           <h1>我是父亲</h1>
           <router-view></router-view>   
        </div>
    </template>

    <template id="login">
        <div>
          <!-- 绑定 -->
          <h1 @click="$emit('hong',1,2,3,4)">login</h1>
          <h1 @click="$emit('dier',1,2,3,4)">惦记我调用第二份父亲方法</h1>
        </div>
    </template>
    <template id="login1">
        <div>
          <h1 @click="$emit('hong',1,2,3,4)">login</h1>
          <h1 @click="$emit('dier',1,2,3,4)">sss</h1>
        </div>
    </template>


    <template id="regist">
        <div>
          <h1>注册</h1>
          <h1>zzz</h1>
        </div>
    </template>

    <!-- template最好不要在容器里面 -->
    <template id="error">
      <!--template的根容器只能有一个  -->
        <div>
          <!-- <h1 v-text="msg" @click="say()"></h1> -->
          <h1>错误找不到</h1>
          <h1>zzz</h1>
        </div>
    </template>
```

### 2.路由代码示例

```js
import Vue from '../lib/vue-2.4.0' 
import './index.scss'
import VueRouter from '../lib/vue-router-3.0.1' 
//通过import需要通过use进行挂载
Vue.use(VueRouter)

const login={
    template:'#login',
    data() {  return {   msg:222  } },
    methods:{ say(){alert("我是xxx") }}
}
const res={
        template:'#regist'
}
const fater={
        template:'#father'
}
const error={
    template:"#error"
}

//使用路由的时候将所有组件注册放出来定义
//必须在实例的作用域内
const  router = new VueRouter({
    //路由匹配从上到下,匹配到一个不匹配
    routes:[
        {
            path:'/',
            //重定向到/login
            redirect:'/login'
        },
        {
            path:'/login',
            //定义的组件
            component:login,
        },
        {//这是嵌套组件
            path:'/father',
            component:fater,
            children:[
                {//如果加了/ 代表不能是father/regist 而是直接根目录到regist
                    path:'regist', //father(只显示父亲) //father/regist(在显示父亲的之后再显示儿子)
                    //定义的组件
                    component:res,
                }
            ]
        },
        
        {   //最后找不到的
            path:'*',
            component:error
        }
    ]

})


window.vm=new Vue({
    el:'#app',
    data:{
        msg:"hello world",
        list:[
            1,2,3,4,5
        ],
        flag:false,
        jilin:'login'
    },
    //将定义的路由挂载上来,key与value相同可以缺省
    router,
    methods: {
        del(index){
            this.list.splice(index,1)
        },
        fater(...son){
            alert("我是父亲"+son);
        },
        fater2(...son){
            alert("我是第二份父亲"+son);
        },
    },
    components:{
        // res
      //再外面定义后可以直接引入
    }

})
```

# -----------------------==(VUE捌_1)==-------------------------

# watch属性与 computed计算属性

## 一、 复习与未来技术栈

> 未来一周技术栈自学(koa2+sequelize)
>
> h2+vue vue编程的一些个性化操作 .vue
>
> 不是所有的公司都是用.vue文件去开发vue项目
>
> ​    就是vue mvvm
>
> ​    e.keycode==13
>
> 1.事件修饰符
>
> ​    ==> event.preventStop
>
> ​    -->@click.stop="阻止冒泡"
>
> ​    a标签==>click hre
>
> 2.路由
>
> computed
>
> watch
>
> 3.vue-cli
>
> ​    vue
>
> ​    vue-router
>
> ​    vuex
>
> 4.axios
>
> 5. element-ui
>
> 6. mui(移动端开发的组件+流应用环境)
>
>    报表 v-chars
>
>    数字 v-count
>
>    常见的vue的项目模板介绍

## 二、watch属性

### 1.说明

>`watch`属性，可以监听`data`中指定数据的变化，然后可以触发这个`watch`对象中对应的处理函数。
>监听的数据名作为`watch`对象的属性名，指向对应的处理函数
>
>处理函数参数：
>
>- 参数一，newVal，新数据。
>- 参数二，oldVal，旧数据



### 2.监听变量

```js
   watch:{
                firstName(newVal,oldVal){
                    console.log('监视到了firstName的变化');
                    this.fullName = newVal+"-"+this.lastName;
                },}
```



### 3.监听路由

> 想要监听路由的改变，即`<router-view></router-view>`的改变，但它身上没有什么事件，则只能使用`watch`监听路由地址的改变

```js
   watch:{ //监听路由
        '$route.query'(nv,ov){
            alert(JSON.stringify(nv))
        }}
```

## 三、计算属性

> 定义的时候是方法,使用的时候是变量

```js
   //计算属性 定义的时候s是方法,使用的时候用属性
    computed: {
        result(){
            return 'this.first+this.second'
        }
    },
-------------------------------------------
 <h1 v-text='result'></h1>		//调用
```

## 四、比较computed和methods以及wetch里头的方法

| 比较来源 | 使用方法a                                           | 总结                          |
| -------- | --------------------------------------------------- | ----------------------------- |
| methods  | a(事件) a(变量,给的是方法不会运行) a()(结果值)      | 可以是变量也可以是方法        |
| computed | a(不能绑给事件) a(变量,没有方法) a(变量,直接结果值) | 定义是方法,使用是变量         |
| watch    | 方法名就是已存在的变量名 方法名不能被当作函数调用   | 方法是主动调用的,非被动调用的 |

## 五、比较computed和watch的使用

| 比较来源 | 使用的变量                                                   |
| -------- | ------------------------------------------------------------ |
| computed | 方法体内部引用变量(能监听多个变量),被引用的变量发生改变,会重新出发计算 |
| watch    | 只能监听一个变量                                             |



## 六、props data computed methods 里头的变量或者方法必须互斥





# -----------------------==(VUE捌_2)==-------------------------

# Vue-cli的安装与使用==>day8_16

>  它其实就是一个webpack +h5 +vue

## 一、安装前提

###### (1.1) 查看是否装过vue-cli

```js
npm list vue-cli -g  //vue 2.9版本

npm list @vue/cli -g查看	//  3.x版本
```

###### (1.2) 如果有删除 

```js
npm r vue-cli -g
```

## 二、下载

> vue-cli 4.3.1(不要用yarn,否侧list时查找不到)

```js
  安装 npm i @vue/cli@4.3.1 -g
```

## 三、命令行创建项目

###### 1.创建

```js
  vue create 项目名称
```

###### 2.选项

![](vue%E7%AC%94%E8%AE%B0%E5%9B%BE%E7%89%87/vuecli%E5%91%BD%E4%BB%A4%E8%A1%8C%E5%88%9B%E5%BB%BA.png)

###### 3.修改

> 如果要更改镜像下载,进入当前用户的vuere文件修改

# -----------------------==(VUE玖)==-------------------------

# vue初步讲解

## 一.项目包与文件讲解

### 1.babel.config.js

> 有ES6 7高阶语法库和低阶语法库,可以将高阶语法转换成低阶语法

### 2.vue.config.js

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

### 3.src中的assets

> 是被引用的静态

### 4.main.js

> 入口文件,相当于app.js

## 二、安装Express 插件(vscode插件) 

> 测试发布

##### (2.1)  使用自己的注册表修改文件(放在桌面运行,要修改路径)-->.reg文件

```reg
Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\*\shell\VSCode]
@="Open with Code"
"Icon"="E:\\VScode\\Microsoft VS Code\\Code.exe"

[HKEY_CLASSES_ROOT\*\shell\VSCode\command]
@="\"E:\\VScode\\Microsoft VS Code\\Code.exe\" \"%1\""

Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\Directory\shell\VSCode]
@="Open with Code"
"Icon"="E:\\VScode\\Microsoft VS Code\\Code.exe"

[HKEY_CLASSES_ROOT\Directory\shell\VSCode\command]
@="\"E:\\VScode\\Microsoft VS Code\\Code.exe\" \"%V\""

Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\Directory\Background\shell\VSCode]
@="Open with Code"
"Icon"="E:\\VScode\\Microsoft VS Code\\Code.exe"

[HKEY_CLASSES_ROOT\Directory\Background\shell\VSCode\command]
@="\"E:\\VScode\\Microsoft VS Code\\Code.exe\" \"%V\""
```

##### (2.2)使用

```js
 ctrl + shift +p
Epess Hot Curent Wrspac with Random or Number and Open in Bover
```

##### (2.3)关闭

```js
 关闭时候一定要通过 Stop express
```

## 三. (.VUE)文件讲解

#### (3.1)App.vue

> 根组件

#### (3.2) components

> 子组件包

## 四、vue-cli 3.x 的 views 和 components有什么区别？

> 1. components是小组件
>    2.containers是容器级组件
>    3.views是页面级组件
>
>    4.也就是说，views是页面级组件，components是小组件，小组件可被引用在views中，一般views组件不被复用【containers是容器级组件（根据	项目大小决定是否使用）】
>
>    5.从组件大小级别区分 components - （containers）- views







## 五、[vue-cli@3.0的vue.config.js最基本配置]

```js
const path = require('path')
module.exports = {
  // 基本路径
  publicPath: process.env.NODE_ENV === 'production'
    ? ''
    : '/',
  // 输出文件目录
  outputDir: process.env.NODE_ENV === 'production' ? 'dist' : 'devdist',
  // eslint-loader 是否在保存的时候检查
  lintOnSave: true,
  /**
   * webpack配置,see https://github.com/vuejs/vue-cli/blob/dev/docs/webpack.md
   **/
  chainWebpack: (config) => {
    // 修复HMR
    config.resolve.symlinks(true)
    const types = ['vue-modules', 'vue', 'normal-modules', 'normal']
    types.forEach(type => addStyleResource(config.module.rule('stylus').oneOf(type)))
  },
  configureWebpack: (config) => {
    config.resolve = { // 配置解析别名
      extensions: ['.js', '.json', '.vue'],
      alias: {
        '@': path.resolve(__dirname, './src'),
        'components': path.resolve(__dirname, './src/components'),
        'common': path.resolve(__dirname, './src/common'),
        'api': path.resolve(__dirname, './src/api'),
        'router': path.resolve(__dirname, './src/router'),
        'views': path.resolve(__dirname, './src/views'),
        'data': path.resolve(__dirname, './src/data'),
        'public': path.resolve(__dirname, 'public')
      }
    }
  },
  // 生产环境是否生成 sourceMap 文件
  productionSourceMap: false,
  // css相关配置
  css: {
    // 是否使用css分离插件 ExtractTextPlugin
    // extract: true,
    // 开启 CSS source maps?
    sourceMap: false,
    // css预设器配置项
    loaderOptions: {},
    // 启用 CSS modules for all css / pre-processor files.
    requireModuleExtension: false
  },
  // use thread-loader for babel & TS in production build
  // enabled by default if the machine has more than 1 cores
  parallel: require('os').cpus().length > 1,
  /**
   *  PWA 插件相关配置,see https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-pwa
   */
  pwa: {},
  // webpack-dev-server 相关配置
  devServer: {
    open: true, // 编译完成是否打开网页
    host: '0.0.0.0', // 指定使用地址，默认localhost,0.0.0.0代表可以被外界访问
    port: 8080, // 访问端口
    https: false, // 编译失败时刷新页面
    hot: true, // 开启热加载
    hotOnly: false,
    proxy: null, // 设置代理
    overlay: { // 全屏模式下是否显示脚本错误
      warnings: true,
      errors: true
    },
    before: app => {
    }
  },
  /**
   * 第三方插件配置
   */
  pluginOptions: {}
}

// 全局导入样式
function addStyleResource (rule) {
  rule.use('style-resource')
    .loader('style-resources-loader')
    .options({
      patterns: [
        path.resolve(__dirname, './src/common/stylus/index.styl')
      ]
    })
}
```









# -----------------------==(VUE拾)==-------------------------

# export、import、style、render、@自定义路径变量=>day8_18~19

## 一、 导出export

### 1. *export default* 

> *一个js里头只能用一次,且只能导出一个对象或者变量*



### 2.*export {}*

> *可以用多次,每次可以导出多个,导出的不是对象*

## 二、导入import 

### (3.1)export default导入

```js
 import 变量名 from 'js文件'
 变量名=导出的对象
```

### (3.2)*export {}*导入

```js
      类比结构赋值
                 import {变量名1(必须跟export里头的变量一样),变量名2} from 'js文件'
                可以给变量取别名 变量名 as 新的名字 
```

### (3.3)*import css*

> *直接把css的内容引进来*

### (3.4) *import html*

> *直接把内容引进来*

### (3.5) *import js*

> *引进来 export default export{}*

### (3.6)*import vue*

> 引进来的时一个vue组件对象*

## 三、*组件为何可以相互引用*

 *核心原理源于import vue文件 ,会将vue文件的三部曲转换成vue的组件对象*上的组件对象即

>  *1) template标签创建组件*
>
>  2) let login ={*
>
>  ​            *temolate:'#login'*
>
>  ​            *data:.....*
>
>  ​          *}*
>
>  3)*然后通过 components: { login}按需注册*

## 四、Style样式

### (4.1) *scoped 局部生效的原理*

>  *让style里头的css选择器对应的元素共同添加一个唯一的属性标识*

### (4.2)  *lang 指定语言*

>  *如果没有指定相应类型的语种,在低版本的vue-cli与h5中会报错*   



## 五、Main.js中的 *render* 

> *将一个组件完全的替代掉index.html里头的容器标签*
>
> *替代的原理:*
>
> ​         *根据el指定的容器来进行替代*
>
> ​          旧版本在2.9.6里头仍然时使用el*
>
> ​          *只不过更新的版本使用的时$mount替代el*

### (5.1)*与router-view的区别:*

> *router-view 只是占位符,并不会消失*

### (5.2)rander: h =>h(APP)演变

```js
演变 :rander:function (h) {
                    return h(APP)
                }
                rander(h) {
                    return h(APP)
                }
                rander: (h) =>{
                    return h(APP)
                }
                rander: h =>{
                    return h(APP)
                }
                当函数体的代码只有一行return的代码,那么大括号和return可以省略
                rander : h =>h(APP)
                 =>返回一个渲染后的结果
```

### (5.3)h的含义:

> *h是一个draw的函数 vue提供的*
>
> ​          *为什么是一个函数:*
>
> ​            *因为h(APP),假如不是函数肯定不能带括号*



## 六、router

>*考虑到router里头在未来的业务拓展的场景*
>
>​      *路由可能会很多 可能会出现子路由的情况**所以借用export/import模块化编程*
>
>​      *-->高内聚低耦合的应用实例*
>
>​        *eg:内聚 :相同功能的聚集在一起   *耦合:不同功能强绑定*









# -----------------------==(VUE拾壹)==-------------------------

# VUEX=day8_19

## 一、VUEX初认知

> *是vue提供的一个跨组件的缓存的组件      *像是服务端的redis*

### (1.1) *如何工作:*

> *与redis基本相同,但它是全局的,因此可以定义方法供全局调用,拿来操作缓存用的*

### (1.2) *什么地方用到*

*在vue-cli的store里存储*

> *数据需要在多个组件(页面)间共享的数据*
>
> 比如token 用户信息 window.localStorage*

### (1.3) *@/store进行引用*

>​     *@是什么?*
>
>​             *是vue定义的路径变量*
>
>​            *为什么定义?*
>
>​            *代码位置变了 引用路径不用变*
>
>​            *因为我们引用的方法是通过相对路径,所以只要使用绝对路径,那么不管他怎么便*
>
>​           *都可以找到*

## 二、自定义vue路径变量

```js
const path = require("path");
module.exports={
    devServer:{
        port:80
    },
    //如果是发布的去掉.map
 productionSourceMap: process.env.NODE_ENV === 'production' ? false : true,
    configureWebpack: (config) => {
        config.resolve = { // 配置解析别名
          extensions: ['.js', '.json', '.vue'],
          alias: {
            '@': path.resolve(__dirname, './src'),
            'components': path.resolve(__dirname, './src/components'),
            'common': path.resolve(__dirname, './src/common'),
            'api': path.resolve(__dirname, './src/api'),
            'router': path.resolve(__dirname, './src/router'),
            'views': path.resolve(__dirname, './src/views'),
            'data': path.resolve(__dirname, './src/data'),
            'public': path.resolve(__dirname, 'public'),
            'static': path.resolve(__dirname, 'static'),
          }
        }
      },
}
```

## 三、为什么用VUEX

> *1. 因为组件之间,兄弟组件和父子组件之间需要传递,我们是同过绑定的方式进行传值*
>
> ​            *但是如果没有父子关系,传值十分麻烦*
>
> *2.考虑使用redis*
>
> 3.*共享数据区域:所有的组件包括实例都可以直接访问的一块数据区域*
>
> ​    *特点:*
>
> ​		牵一发而动全身 A=> a=1 <= B C D (a=1)*
>
> ​            *B=> a=2 <= A C D (a=2)*

## 四、UVEX使用

### 1.在main.js中注册

```js
import Vue from 'vue'
import App from './App.vue'
import router from './router'
//注册
import store from './store'

window.vm= new Vue({
  //注册
  store,
}).$mount('#app')
//我们指定了替代#app标签
```

### 2.在store文件下的index.js注册与定义

```js
import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    a:1,
    b:2
  },
  mutations: {
    setA(state,...value){
      console.log(value)
      state.a=value
    }
  },
  getters:{
    //state不是我们定义的实参,是vue给我们的
   getA:state=> state.a
  },
})
```

#### (2.1) *state  变量存储的容器*

#### (2.2) *getters 定义用来获取state的值的方法,避免直接获取state*

####  (2.3)*mutations 定义用来操作state的值的方法,避免直接操作state*



### 3.使用

#### (3.1)script导入

```js
<script>
//mapState与mapMutations对应store下面的mutations与state
import {mapState,mapMutations} from 'vuex'
export default {
methods:{
  //后面是别名 前面才是store中定义的setA
  ...mapMutations({setA:'setA'})
      // ...mapMutations(['setA'])
}
  ,computed:{
    // ...mapState({a:'a',b:'b'})
    ...mapState(['a','b'])
  }
}
</script>
```

#### (3.2)组件中直接使用

```html
<template>
  <div id="app">
    <fieldset>
      <legend>VUEX</legend>
      <!-- $代表某些实例 -->
      {{$store.state}}
      {{$store.getters.getA}}
     <button type="button" @click="$store.commit('setA',{a:1,a:2})">修改X</button>
     <button type="button" @click='setA(Date.now())'>修改X1</button>
     <!-- <button type="button" @click="$store.commit('setA',{a:1,a:2})">修改X1</button> -->
    </fieldset>

    <router-view/>
  </div>
</template>

```









# Element-ui

>  *饿了么出品* 
>
>  ​    *针对web ui框架 (包含多个常用的组件)*
>
>  ​    不像bootstrap(不是框架) 只是一个简单的代码段

## 一、 安装

####  安装

 *建议使用yarn安装,速度会快几十倍*

>  *局部安装(是依赖)*

```shell
npm i element-ui 
```

#### CDN

目前可以通过 [unpkg.com/element-ui](https://unpkg.com/element-ui/) 获取到最新版本的资源，在页面上引入 js 和 css 文件即可开始使用。

```html
<!-- 引入样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<!-- 引入组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
```

## 二、引用

> *1. 完全引用 开发时候建议 避免上生产(替代方案:cdn)*
>
> *2. 按需引用 上生产(大大减少小dist的体积)*

你可以引入整个 Element，或是根据需要仅引入部分组件。我们先介绍如何引入完整的 Element。

#### 1.完整引入

在 main.js 中写入以下内容：

```javascript
import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';

Vue.use(ElementUI);

new Vue({
  el: '#app',
  render: h => h(App)
});
```

> 以上代码便完成了 Element 的引入。需要注意的是，样式文件需要单独引入。

#### 2.按需引入

借助 [babel-plugin-component](https://github.com/QingWei-Li/babel-plugin-component)，我们可以只引入需要的组件，以达到减小项目体积的目的。

首先，安装 babel-plugin-component：

```bash
npm install babel-plugin-component -D
```

然后，将 .babelrc 修改为：

```json
{
  "presets": [["es2015", { "modules": false }]],
  "plugins": [
    [
      "component",
      {
        "libraryName": "element-ui",
        "styleLibraryName": "theme-chalk"
      }
    ]
  ]
}
```

接下来，如果你只希望引入部分组件，比如 Button 和 Select，那么需要在 main.js 中写入以下内容：

```javascript
import Vue from 'vue';
import { Button, Select } from 'element-ui';
import App from './App.vue';

Vue.component(Button.name, Button);
Vue.component(Select.name, Select);
/* 或写为
 * Vue.use(Button)
 * Vue.use(Select)
 */

new Vue({
  el: '#app',
  render: h => h(App)
});
```

#### 3.全局配置

在引入 Element 时，可以传入一个全局配置对象。该对象目前支持 `size` 与 `zIndex` 字段。`size` 用于改变组件的默认尺寸，`zIndex` 设置弹框的初始 z-index（默认值：2000）。按照引入 Element 的方式，具体操作如下：

完整引入 Element：

```js
import Vue from 'vue';
import Element from 'element-ui';
Vue.use(Element, { size: 'small', zIndex: 3000 });
```

按需引入 Element：

```js
import Vue from 'vue';
import { Button } from 'element-ui';

Vue.prototype.$ELEMENT = { size: 'small', zIndex: 3000 };
Vue.use(Button);
```

> 按照以上设置，项目中所有拥有 `size` 属性的组件的默认尺寸均为 'small'，弹框的初始 z-index 为 3000。

###  

## 洪吉林day2020_8_20笔记





















