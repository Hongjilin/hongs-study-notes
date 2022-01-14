### #说明

>此笔记将记录一些Vue框架使用技巧,可以帮助我们更快更好的构建Vue应用

## 1、**使用`$parent`子组件访问父组件数据**或方法

### Ⅰ - 子组件访问父组件数据

>一般我从子组件访问父组件数据,是通过`props`传入,但如果你不想经历传递props的麻烦,或需要传给子组件的数据多,那么我们可以尝试用`$parent`这个API直接从父组件快速获取一个值
>
>```js
>//父组件
>data(){
>    return{
>        msg:'这是父组件的值'
>    }
>}
>//子组件中调用
>test(){
>    console.log(this.$parent.msg)//这是父组件的值
>}
>```

### Ⅱ - 用`$parent`调用父组件的自定义方法

>如果你用`$parent`调用父组件的自定义方法也是可以的,但是在使用UI组件时可能会出现无法使用`this.$parent`直接调用父组件方法的问题。例如:
>
>```vue
>//父组件
><Tabs value="name">
>    <TabPane label="名字" name="name">                    
>        <TextTag  @setText="setText"/>                    
>    </TabPane>
></Tabs>
>
>//子组件TextTag中
>methids:{
>	test(){
>		this.$parent.setText() //报错,提示方法未定义
>	}
>}
>```
>
>所以一般这种子组件调用父组件的还是可以是用`$emit`

## 2、在模板语法中多使用JS的高级功能

> 我们在指令`v-directives`中很容易忘记我们仍可以在我们的模板中访问纯JS的高级功能,实际上我们可以在里面尽可能地引用上ES系列知识点简化代码

### Ⅰ - 问题举例:简化你的 :class 和 v-if

>当我们有一个需求,当我们满足某几个条件时,我们的`class`或者`显隐v-if`要进行切换:
>
>```vue
><!-- 当名字等于这三个时,我们要进行类名的切换 -->
><div 
>   :class=" name==='hong' || name==='jelyn' || name==='努力学习的汪' ? 'show-class':'' "
>>                               
></div>
>```
>
>###### 然后你可能会这样简化它,但这样绝对不是最好的写法:
>
>```vue
><!-- 当名字等于这三个时,我们要进行类名的切换 -->
><div 
>  :class="{ 
>     'show-class':
>     name==='hong'
>     || name==='jelyn' 
>     || name==='努力学习的汪' 
>     }"
>>                               
></div>
>```

### Ⅱ- 简化

>可以利用`includes`方法:用来判断一个数组是否包含一个指定的值，如果是返回 true，否则false
>
>###### 这不仅更具可读性，而且以后也更容易扩展
>
>```vue
><!-- 当名字等于这三个时,我们要进行类名的切换 -->
><div 
>  :class="{ 
>     'show-class':['hong','jelyn','努力学习的汪'].includes(name)
>        }"
>>                               
></div>
>```

## 3、**[路由/页面]更改时滚动到顶部**

>当我们页面更改时(如路由跳转),Vue会保持在页面的当前位置,这有时会很有用,但也有些问题:
>
>> 如果我们向下滚动一个长的列表页,然后转到另外一个页面,滚动条将位于新页面的底部,而不是期望的顶部,这个问题该怎么解决呢?
>
>解决这个问题很简单。只需在 `app.js` 文件中添加一个 `watch`--> 在每次路由更改后触发滚动到顶部
>
>```js
>// App.vue
>watch: {
>    $route() {
>      window.scrollTo(0, 0)
>    }
>  },
>```

## 4、**对 DRY 代码使用全局实用方法**

### Ⅰ - 什么是 `DRY`?

>DRY 原则来自于《Pragmatic Programmer》即《务实的程序员》这本书。DRY 是英文 Don’t Repeat Yourself 的缩写，从字面上理解就是不要重复你的代码，但是作者其实说的是知识，更准确的定义是”每一份知识都必须在系统中拥有单一的，无歧义的，权威的代表“
>
>代码原则中的 DRY 原则，要求程序员挤干代码的水分，每一份知识都在系统中只有单一的，无歧义的，权威的代表，方法 (method) 不要过长，分割业务逻辑，尽量重用我们的代码片段。

### Ⅱ- 可以尝试创建`utils.js`

>几乎每个Vue项目中都会有一些在多个地方复用的逻辑,例如一个字段的映射渲染(0->'男',1-->'女')这样.为了保持我们代码的`DRY`和`可管理`
>
>* 我们应该创建一个单独的`utils.js`文件来保存这个经常复用的逻辑并能从任何地方访问
>* 你可能会觉得用`Vuex`很合适这种情况,但除非你需要将方法的结果存在`state`中,否则它真的不适合这种情况
>* 一般来说现在基本都会有这个概念

## 5、**检测用户是在桌面还是移动设备上**

>这里曾看到一篇文章,觉得很不错,便记录下来
>
>* 他推荐使用 `npm i vue-mobile-detection --save` 安装 `vue-mobile-detection`
>* 随后在`App.vue`文件中添加一个`mounted()`钩子,钩子中可以往`Vuex`或者`localstorage`中存储该用户使用的平台值
>* 之后就可以在所有需要用到这个数据的地方引用即可

### Ⅰ - Vuex示例

>如果你使用的是Vuex,你可以为上面的 `$store.commit` 创建一个mutation，将值设置为 state，然后使用 getter 访问应用程序中任何地方的平台值。
>
>```js
>//app.vue 
>mounted() {
>    this.$isMobile()
>      ? this.$store.commit('setPlatform', 'mobile')
>      : this.$store.commit('setPlatform', 'desktop')
>  },
>```

### Ⅱ - localStorage示例

>如果你使用`localStorage`进行存储,可以按照下面的代码示例
>
>```js
>//app.vue
>const currentPlatform = this.$isMobile() ? ‘mobile’ : ‘desktop’
>localStorage.setItem('platform', currentPlatform)
>
>//在需要使用的组件处
>const currentPlatform = localStorage.getItem(‘platform’)
>```

## 6、**当用户按下 回车(ENTER) 时关注下一个表单输入**

>使用下面代码:用户在关注此输入框时按下 Enter 键，则会将光标焦点设置到以下输入框
>
>```vue
><input 
> type="text"
> @keyup.enter="$event.target.nextElementSibling.focus()"
>/>
>```

## 7、**动态刷新（重新加载）特定组件**

### Ⅰ - 刷新特定组件

>有许多边缘情况需要重新加载组件而不影响它所在页面的其余部分。
>
>你有时需要强制它使用新属性刷新，或者因为你使用的包在传递新属性时没有按预期更新
>
>```vue
><template>
>  <component-to-re-render :key="reloadMe" />
></template>
>
><script>
>export default { 
>  data() { 
>    return { 
>      reloadMe: 0, 
>    }
>  }; 
>
>  methods: { 
>    forceRerender() { this.reloadMe += 1; } 
>  } 
>}
></script>
>```

### Ⅱ - 重新加载某个页面

>但是也有点弊端,可能会造成短时间'白屏'
>
>```js
>// 直接刷新页面,相当于直接按 `F5`
>window.location.reload()
>// 重新进入此路由
>this.$router.go(0)
>```

### Ⅲ - 不刷新页面情况下刷新数据

>如果你不想要直接调用`window.location.reload()`,因为它会造成白屏现象(因为模拟我们的f5),重新加载资源
>
>那么你可以看我单独写的另外一篇文章,篇幅较长,此处给出链接,可以实现不刷新页面直接刷新数据的效果(不会产生白屏)
>
>[vue实现不刷新页面情况下刷新数据实现方案笔记](https://gitee.com/hongjilin/hongs-study-notes/blob/master/编程_前端开发学习笔记/Vue笔记整合/vue实现不刷新页面情况下刷新数据.md)

