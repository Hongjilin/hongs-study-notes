

## #说明

>本人整理这个Vue专项练习不只是为了刷面试题,更是为了能熟练复习或巩固知识点,所以题目中有时会详细的列出相应知识点
>
>不过通常也会给出一个简答版本回答
>
>除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[数据结构与算法](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_算法及课程基础学习笔记/数据结构与算法)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[编程_后台服务端学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记)** 、**[Java](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Java)** 、**[Nodejs](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Nodejs)** 、**[JavaScript笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记)**、**[编程工具使用笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端工具使用笔记)** 、**[前端代码规范](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端代码规范)** 、**[Git学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Git学习笔记)** 、**[ES6及后续版本学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记)** 、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了





## 1、React与Vue的区别是什么?

### 简答:

>###### 相同点
>
>>* 都有组件化思想
>>* 都支持服务器端渲染
>>* 都有 虚拟DOM
>>* 数据驱动视图
>>* 现在的数据流都是单向数据流
>>* 都有支持native方案: Vue的week、React的 React native
>>* 都有自己的构建工具: Vue的vue-cli、React的 Create React App
>
>###### 区别:
>
>>* 监听数据变化实现的原理不同: Vue2使用**defineProperty**、Vue3使用**Proxy**,而React使用的是**比较引用(diff)**实现的
>>* 数据变化实现的原理不同: React使用的是 **不可变数据** ,Vue使用的是 **可变数据**
>>* 组件间通信方式的不同: React中我们通过 **回调函数** 来进行通信的 ,而Vue中 **子传父** 通过 **事件与回调函数** 两种方法
>>* diff算法的不同: React中主要通过 **diff** 队列保存需要更新哪些DOM,得到patch树,再通过统一操作批量更新DOM; Vue中使用双向指针,边对比边更新DOM



### Ⅰ - 监听数据变化的实现原理不同

>**Vue**
>
>-  Vue2.x主要通过 getter、setter 以及 **defineProperty** 进行数据劫持,能精确知道数据变化
>- Vue3.x主要通过 **Proxy** 进行数据数据的劫持
>
>**React**
>
>* React 默认是通过 比较引用(**diff**) 进行的,如果不优化可能导致大量不必要的 真实DOM 重新渲染
>
>**为什么React不精确地进行数据变化?**
>
>>* 实际上这是Vue与React地设计理念上的区别:Vue使用的是`可变数据`,而React更强调数据的`不可变`
>>* 二者没用好坏之分: Vue更加简单 , 而React构建大型应用的时候更加健壮

### Ⅱ - 数据流 (`现在相同`)

>> ###### **实际上在V1.X中使用的是双向数据流,但是从V2.X开始已经不鼓励组件对自己的props进行修改**
>
>React中一直是单向数据流, 称之为 **onChange/setState** 模式.

### Ⅲ - 但是数据绑定不同

>> ###### **Vue是双向绑定 而 React是单向绑定**
>
>在 **Vue** 中主要由三个部分组成: Model、View、 ViewModel组成. 其中 **View** 和 **Model** 不能直接进行通信, 它们通过 ViewModel 进行通信
>
>###### Vue中: 
>
>* 当 **Model** 部分数据发生改变时,由于Vue中的 `Data Binding` 将底层数据和DOM进行了绑定,ViewModel 会通知 View层更新视图
>* 当 视图层View 数据发生变化时也会同步更新到Model中
>* View 和 Model 之间的同步完全是自动的,不需要人为地操作DOM,所以叫双向绑定
>
>###### React中
>
>* react中虽然 model 和view 之间需要 setState 去手动刷新渲染 view ,所以叫单向绑定
>* React的官方文档说他是V层，这一点是对的，如果问他到底是属于MVC还是MVP还是MVVM，答案其实是他并不是任何一个,如果所有的逻辑写在组件内部，让VC和VM贴的更近，那就是MVVM

### Ⅳ - 组件通信的区别

>###### Vue中有三种方式可以实现组件通信:
>
>1. 父组件通过 Props 向子组件传递数据或者回调(虽然可以,因为有双向数据绑定,所以虽然可以传回调,一般我们只传数据)
>2. 子组件通过 事件 向父组件发送消息
>3. 通过 Vue2.x 新增的 Provide/inject 来实现父组件向子组件注入数据,可以跨越多个层级
>
>###### React中也有对应的三种方式: 
>
>1. 父组件可以通过 **props** 向子组件传递数据或者回调
>2. 子组件通过 **回调函数** 向父组件发送消息
>3. 可以通过 **context** 进行跨层的通信,这其实和 **Vue中的Provide/inject** 起到的作用差不多
>
>> * React 本身并不支持自定义事件,而Vue中 **子传父** 中传递信息有两种方式: 回调与事件
>> * 但VUE更倾向于使用事件,而React只能使用回调**
>

### Ⅴ - 模板渲染方式的不同

>**在表层上,模板的语法不同:** 
>
>>React是通过 **JSX** 渲染模板,而**Vue** 是通过一种拓展的HTML语法进行渲染,但其实这只是表面现象,毕竟React并不依赖于**JSX**,只能说相性好
>
>**在深层上,模板的原理不同,这才是他们本质的区别**
>
>>* React 是组件JS代码中,通过 **原生JS** 模板中的常见语法: 如插值、条件、循环等,更加存粹更加原生
>>* 而Vue是在和组件JS代码中分离的单独模板中 , **通过指令来实现的**,如:条件语法需要用 `v-if` 实现,这点回将HTML弄得很乱
>
>**举个栗子说明React这样做的好处**
>
>>* React中的 **render** 函数是支持闭包特性的,所以我们 **import** 的组件在render中可以直接调用. 
>>* 但是在Vue中,由于模板中使用的数据都必须挂载在 **this** 上进行一次中转,所以我们 import 一个组件之后.还需要再 **components** 中再声明一下,这样虽然显得很奇怪但却又是不得不这样的做法

### Ⅵ - 渲染过程(diff算法的不同)的不同

>**Vue**可以更快地计算出 **虚拟 DOM** 的差异.这是由于它在渲染过程中会跟踪每一个组件的依赖关系,不需要重新渲染整个组件树
>
>**React** 在应用的状态被改变时,全部 **子组件** 全部都会重新渲染. 通过 `shouldComponentUpdate` 这个声明周期方法可以进行控制; 但Vue将此视为默认的优化
>
>* 如果应用中交互复杂,需要处理大量的UI变化,那么使用 **虚拟 DOM** 是一个好主意
>* 但如果更新元素并不频繁,那么性能可能还不如直接操作 DOM

### Ⅶ - 框架本质不同

>Vue本质是 **MVVM** 框架,由 **MVC** 发展而来: **最大特点双向绑定**
>
>React是前端组件化框架,由后端组件化发展而来: 特点是 **状态驱动视图**
>
>> **State** --> **View** --> **New State** --> **New View**

### Ⅷ - Redux 与 Vuex 的区别

#### ① 表面上

>从表面上说,store注入和使用方式有一些区别:
>
>* 在 **Vuex** 中, `$store` 被直接注入到了组件实例中,因此可以比较灵活的使用: `dispatch`、`commit`提交更新,通过`mapState` 或者直接通过 `this.$store`来读取数据
>* 在 **Redux** 中, 我们每一个组件都需要显式地使用`connect` 将需要地将 `props` 和 `dispatch` 链接起来
>* 另外,Vuex更灵活一些,组件中既可以使用`dispatch action`,也可以使用 `commit updates`
>* 而**Redux** 中只能进行`dispacth`,不能直接调用 `reducer` 进行修改

#### ② 实现原理上

>最大的区别是两点:
>
>1. **Redux** 使用的是不可变数据,而 **Vuex** 的数据是可变的
>  - 因此Redux每次都是用新的 **State** 替换旧的 **State** ,而 Vuex 可以直接修改
>2. Redux在检测数据变化的时候,是通过 **diff算法** 进行差异比较, 而Vuex则是与Vue一样都是通过 **getter/setter** 来进行比较的
>
>这两点是因为React与Vue的设计理念不同
>
>>* React更偏向于构建文顶大型的应用,非常的科班化
>>* 相比之下Vue更偏向于简单迅速地解决问题,更灵活. 也不那么严格遵循条条框框
>>* 因此就会给人一种大型项目用React, 小型项目用Vue的感觉

## 2、React与Vue的特点或亮点是什么?

>曾经看过Vue作者的尤雨溪的一段话(大体上是这么说的):'
>
>* **做框架的时候我们也很纠结,到底是定制内容少一点好还是定制多一点好?**
>* **如果定制少了:很多人不知道一些情况怎么处理,所以他就乱来,代码写得乱七八糟并且性能也差,然后他就会觉得你的框架没做好**
>* **但当大家经验越来越丰富的时候,反而会希望受到框架的限制越来越少:因为随着经验的增加,大家都知道了各种场景下应该怎么处理与优化自己的代码-->限制越少,自我发挥的空间就越大!!**'
>
>> ###### 最终我们看到,Vue的选择居于 **React** 与 **angular** 之间,框架自身的语法比 **React** 多些又比 **Angular** 少一些
>>
>> 正是因为选择的不同,所以呈现出来的写法与思考方式就一定会存在差异,不论优劣,肯定会导致不同的偏好,但都是能降低简化我们的开发成本
>
>###### 1. React的简单在于
>
>>* 它的核心API其实非常少.所以我们会看到很多地方说React实际上只是一个 "**UI库**",并不是一个完整的框架.
>>* 他只是告诉我们 **如何创建组件** 以及 **组件间如何进行数据传递* **
>>* 甚至于创建组件的方式正是使用 ES6 的 class 方法(当然现在出了Hooks写法,这个暂且不论)
>>* 因此开发中React的使用对于 **ES6** 的语法依赖非常高,因为React本身就没多少强限制的语法.
>>* 我们只要掌握组件中的 `props`、`state`、`ref`、`生命周期`,就好像没什么其他的额外知识点,就连如果想要在jsx模板中进行遍历渲染,还得使用原生的 **map** 方法
>>* 而react的高阶组件理解后发现,其实就是JavaScript函数式编程中涉及到的思维方式
>
>所以在我看来React最大的特点就是简单并且与原生JavaScript非常接近 --> 即给开发者带来的束缚非常少,一个功能的实现,如果你知道使用原生JS怎么实现,那么你用React就能更轻松的知道怎么实现
>
>**弊端**:自然是当你经验缺乏时,写出来的页面性能可能非常差且有很多多余的渲染
>
>###### 2.  Vue的简单在于
>
>>* Vue提供的能力则更多一些,这些便捷的能力可以让初学者感到非常的幸福,因为很多效果只需要一些简单的代码就能实现
>>* 给出了很多语法糖与语法限制
>>* 而这些语法限制在某种程度上降低了我们的开发成本、提高了开发效率,这就是很多人认为Vue更加简单易学的原因吧
>>* 从学习的难易程度上来说:React之所以更难上手主要原因不是在React本身,而是它丰富的生态全,就是因为它足够简单,所以我们需要掌握的react组件就需要更多,这种情况常在我涉猎不广的时候出现,很多时候你没见过就是不知道组件可以这样使用
>
>React已经在函数式编程的道路上走了很远,Vue也在模板渲染的道路上走了很远(vue3也支持函数式编程),没有优劣之分
>
>不过我仍然更加喜欢React,但只是因为它更接近于ES6原生语法

------



## 3、对Vue组件化的理解

>组件化是Vue的精髓,Vue应用就是用一个个组件构成的,Vue的组件化涉及到的内容非常多
>
>你可以从下面几点进行阐述

### Ⅰ - 定义与优点

> * **定义:**组件是 **可复用的Vue实例**,准确来讲它们是 `Vue.Component`的实例,继承自Vue
> * **优点:** 从上面案例可以看出组件化可以增加代码的 **复用性、可维护性**和 **可测试性**

### Ⅱ - 使用场景(什么时候使用组件?)

>* **通用组件:** 实现最基础的功能,具有通用性、复用性. 如: 按钮组件、输入框组件、布局组件等
>* **业务组件:** 它们完成具体业务,具有一定的复用性. 例如: 登录组件、轮播图组件等
>* **页面组件:** 组织应用各部分独立内容,需要时再不同页面组件间切换. 如: 列表页、详情页

### Ⅲ - 如何使用组件

>* 定义：Vue.component()，components选项，sfc
>* 分类：有状态组件，functional，abstract
>* 通信：props，$emit()/$on()，provide/inject，$children/$parent/$root/$attrs/$listeners
>* 内容分发：`<slot>`，`<template>`，v-slot
>* 使用及优化：is，keep-alive，异步组件

### Ⅳ - 组件的本质

>###### Vue中的组件经历如下过程
>
>`组件配置(也就是我们编程的内容)`===Vue帮我们做的===>`VueComponent实例` ==> `render()`  ==>`虚拟DOM` ==>`dom`
>
>**所以组件的本质就是产生虚拟DOM**







