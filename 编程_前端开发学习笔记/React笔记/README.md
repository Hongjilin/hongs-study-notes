# #此文件为方便gitee网站观阅使用专门创建

> 此笔记文件于某一时间截取复制至此,容易存在更新不及时问题,建议观看同级目录下的笔记文件
>
> 截取了上方了`A_React系统学习笔记`的部分知识点至此,方便网站阅读
>
> 本人的React学习笔记分类(也是对应本人技术成长路程):[[`想快速入门看这部分`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React基础补充学习笔记)]、[[`想对React基础系统全面进行学习的同学看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/Scss%E7%AC%94%E8%AE%B0)]、[[`对基础学习完成且有了一定开发经验,想尝试解析源码的看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React深入学习与源码解析笔记)]
>
> 除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)**、 **[ReactHooks笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ReactHooks笔记)** 、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了

# #说明

>React资料整合,推荐查阅`A_React系统学习笔记.md`,此部分是本人较系统的梳理
>

## #本笔记目录索引

>#####  **[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)** 
>
>1. **[React基础快速入门学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React基础补充学习笔记)** 
>
> > 此部分是本人刚接触React时对于其基础的学习笔记,相较而言不够系统,但是能快速入门,看完基本就能简单的使用react了 
> >
> > 该笔记学自B站`jspang`的react教程视频 与 作者:胡子大哈的小书资料 整理而成 --[点我传送]( http://huziketang.com/books/react/lesson5 )
> >
> > [`想快速入门看这部分`]
>
>2. [A_React系统学习笔记.md](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/Scss%E7%AC%94%E8%AE%B0)
>
> > 本笔记为本人`洪`系统学习React阶段笔记-观看`尚硅谷2021版React技术全家桶全套完整版` 整理而成 ,
> >
> > 同时也是在 **[React基础快速入门学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React基础补充学习笔记)** 的基础上进行的一次梳理学习,推荐朋友直接看这份
> >
> > [`想对React基础系统全面进行学习的同学看这里`]
>
>3. **[ReactHooks笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ReactHooks笔记)** 
>
> > 本笔记收录在本人隔壁ReactHooks笔记中,此处做一个索引
>
>4. **[React深入学习与源码解析笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React深入学习与源码解析笔记)**
>
>  > 本笔记为本人`洪`深入学习React并尝试阅读理解React源码所记录笔记 
>  >
>  > 里面有本人对于React基础的理解总结以及源码阅读解析
>  >
>  > [`对基础学习完成且有了一定开发经验`]

------



# React系统学习笔记

# Ⅰ-React基础知识与概念

> React相对于vue来说学习成本更高，或者说需要的基础知识更多，需要有一些预备知识点支撑
>
> 1. webpack相关知识
> 2. axios相关知识
> 3. js基础与es6相关知识

## 一、React简介

>1. 官网链接:[中文官网](https://react.docschina.org/)
>2. 介绍描述
>   1. 用于动态构建用户界面的JavaScript(只关注视图)
>   2. 由Facebook开源

### 1、React的特点

>1. 声明式编程
>
>2. 组件化编程
>
>3. React Native编写原生应用 
>
>   *React Native (简称RN)是Facebook于2015年4月开源的跨平台移动应用开发框架，是Facebook早先开源的JS框架 React 在原生移动应用平台的衍生产物*
>
>4. 高效 (优秀的Diffing算法)

### 2、React高效的原因

>1. 使用虚拟(virtual)DOM,不总是直接操作页面真实DON
>2. DOM Diffing算法,最小化页面重绘
>3. `注意`：React并不会提高渲染速度,反而可能会增加渲染时间,真正高效的原因是它能有效`减少渲染次数`

### 3、创建虚拟DOM的两种方式

#### 	Ⅰ- js创建虚拟DOM(`不推荐`)

```js
//1.创建虚拟DOM,创建嵌套格式的doms
const VDOM=React.createElement('h1',{id:'title'},React.createElement('span',{},'hello,React'))
//2.渲染虚拟DOM到页面
ReactDOM.render(VDOM,docoment.getElementById('test'))
```

#### 	Ⅱ -jsx创建虚拟DOM

```jsx
//1.创建虚拟DOM
	const VDOM = (  /* 此处一定不要写引号，因为不是字符串 */
    	<h1 id="title">
			<span>Hello,React</span>
		</h1>
	)
//2.渲染虚拟DOM到页面
	ReactDOM.render(VDOM,document.getElementById('test'))

//3.打印真实DOM与虚拟DOM,这一步不是jsx创建虚拟dom必须，我只是为了方便查阅
	const TDOM = document.getElementById('demo')
    console.log('虚拟DOM',VDOM);
	console.log('真实DOM',TDOM);
```

> 可以看到，上下两种方式，明显`jsx`的写法更符合我们的习惯,当出现多重嵌套时,js创建方法会使我们编程出现很大麻烦
>
> 但是jsx其实也只是帮我们做了一层编译,当我们写完jsx代码后,最终我们的代码也会被编译成js的书写方式

### 4、关于虚拟DOM

>1. 本质时Object类型的对象(一般对象)
>2. 虚拟DOM比较'轻',真实DOM比较'重',因为虚拟DOM是React内部在用,无需真实DOM上那么多的属性(只有React需要的属性)
>3. 虚拟DOM最终会被React转化为真实DOM,呈现在页面上

## 二、jsx语法规则

>JSX是一种JavaScript的语法扩展、是一种嵌入式的类似XML的语法,常应用于React架构中,但也不仅限于此.应该说JSX因React框架而流行,但也存在其他的实现.只要你够厉害,甚至能在单片机上实现(当然你要自己写出它的实现方式)

### 1、规则

>1. 定义虚拟DOM时,不要写引号
>2. 标签中混入JS表达式时要用{}
>3. 样式的类名指定不要用class,要用className
>4. 内联样式,要用style={{key:value}}的形式(`双{}代表对象,单{}代表表达式`)去写
>5. 只有一个跟标签(整个虚拟DOM在外层有且仅有一个容器包裹)
>6. 标签必须闭合
>7. 标签首字母
>
>   若`小写字母开头`,则将该标签转为html中同名元素,若html中无该标签对应的同名元素,则`报错`
>
>   若`大写字母开头`,ract就去渲染对应组件,若组件没有定义,则`报错`

### 2、区分【js语句(代码)】与【js表达式】

>1. 表达式:一个表达式会产生一个值,可以放在任何一个需要值的地方
>
>   下面这些都是表达式
>
>   1. a
>   2. a+b
>   3. demo(1)
>   4. arr.map()
>   5. function test(){}
>
>2. 语句:不能放在创建虚拟dom语句中
>
>   1. if(){}
>   2. for(){}
>   3. switch(){}

## 三、两种组件定义区别、组件与模块理解

### Ⅰ-react中定义组件

##### ①函数式声明组件

> 执行了ReactDOM.render(<MyComponent/>.......之后，发生了什么？
>
> 1.React解析组件标签，找到了MyComponent组件。
>
> 2.发现组件是使用函数定义的，随后调用该函数，将返回的虚拟DOM转为真实DOM，随后呈现在页面中。

##### ②类式组件(下面的实例都是指类组件)

>执行了ReactDOM.render(<MyComponent/>.......之后，发生了什么？
>
>​	1.React解析组件标签，找到了MyComponent组件。
>
>​	2.发现组件是使用类定义的，随后new出来该类的实例，并通过该实例调用到原型上的render方法。
>
>​	3.将render返回的虚拟DOM转为真实DOM，随后呈现在页面中。
>
>组件中的render是放在哪里的？
>
>​	MyComponent的原型对象上，供实例使用。
>
>组件中的render中的this是谁？
>
> ​	MyComponent的实例对象 <=> MyComponent组件实例对象。

### Ⅱ-模块与模块化

##### ① 模块

>1. 理解:向外提供特定功能的js程序,一般就是一个js文件
>2. 为什么要拆成模块:随着业务逻辑增加,代码越来越多且复杂
>3. 作用:复用js,简化js的编写,提高js运行效率

##### ② 模块化

> 当应用的js都以模块来编写,这个应用就是一个模块化的应用

### Ⅲ-组件与组件化

##### ① 组件

>1. 理解:用来实现局部功能效果的代码和资源的集合(html/css/js/img等等)
>
>2. 为什么要用组件:一个界面的功能复杂
>3. 作用:复用编码,简化项目编码,提高运行效率

##### ② 组件化

>当应用是以多组件的方式实现,这个应用就是组件化的应用

## 四、React面向组件编程

>1. 使用React开发者工具调试
>
>   `React Developer Tools`
>
>2. 注意
>
>   a) 组件名必须是首字母大写
>
>   b) 虚拟DOM元素只能有一个根元素
>
>   c) 虚拟DOM元素必须有结束标签 < />
>
>3. 渲染类组件标签的基本流程
>
>   a) React内部会创建组件实例对象
>
>   b) 调用render()得到虚拟DOM,并解析为真实DOM
>
>   c) 插入到指定的页面元素内部

### 1、组件三大属性1:state

##### ① 理解

>1. state是组件对象最重要的属性,值是对象(可以包含多个key:value的组合)
>2. 组件被称为`状态机`,通过更新组件的state来更新对应的页面显示(重新渲染组件)

##### ② 强烈注意

>1. 组件中的render方法中的this为组件实例对象
>
>2. 组件自定义方法中this为undefined,如何解决?
>
>   a) 强制绑定this:通过函数对象的bind()
>
>   b) 箭头函数`推荐`
>
>3. 状态数据,不能直接修改或者更新

##### ③代码示例

###### Ⅰ-正常的用函数对象的bind()

```jsx
    //1.创建组件
		class Weather extends React.Component{
			//构造器调用几次？ ———— 1次
			constructor(props){
				console.log('constructor');
				super(props)
				//初始化状态
				this.state = {isHot:false,wind:'微风'}
				//解决changeWeather中this指向问题,也可以在调用出直接使用
				this.changeWeather = this.changeWeather.bind(this)
			}
			//render调用几次？ ———— 1+n次 1是初始化的那次 n是状态更新的次数
			render(){
				console.log('render');
				//读取状态
				const {isHot,wind} = this.state
				return <h1 onClick={this.changeWeather}>今天天气很{isHot ? '炎热' : '凉爽'}，{wind}</h1>
			}
			//changeWeather调用几次？ ———— 点几次调几次
			changeWeather(){
				//changeWeather放在哪里？ ———— Weather的原型对象上，供实例使用
				//由于changeWeather是作为onClick的回调，所以不是通过实例调用的，是直接调用
				//类中的方法默认开启了局部的严格模式，所以changeWeather中的this为undefined
				console.log('changeWeather');
				//获取原来的isHot值
				const isHot = this.state.isHot
				//严重注意：状态必须通过setState进行更新,且更新是一种合并，不是替换。
				this.setState({isHot:!isHot})
				console.log(this);

				//严重注意：状态(state)不可直接更改，下面这行就是直接更改！！！
				//this.state.isHot = !isHot //这是错误的写法
			}
		}
		//2.渲染组件到页面
		ReactDOM.render(<Weather/>,document.getElementById('test'))
```

###### Ⅱ-简写方式:赋值语句的形式+箭头函数

```jsx
	    //1.创建组件
		class Weather extends React.Component{
			//初始化状态
			state = {isHot:false,wind:'微风'}
			render(){
				const {isHot,wind} = this.state
				return <h1 onClick={this.changeWeather}>今天天气很{isHot ? '炎热' : '凉爽'}，{wind}</h1>
			}
			//自定义方法————要用赋值语句的形式+箭头函数
			changeWeather = ()=>{
				const isHot = this.state.isHot
				this.setState({isHot:!isHot})
			}
		}
		//2.渲染组件到页面
		ReactDOM.render(<Weather/>,document.getElementById('test'))
```



### 2、组件三大属性2:props

##### ①理解

>1. 每个组件对象都会有props(properties的简写)属性
>2. 组件标签的所有属性都保存在props中

##### ② 作用

>1. 通过标签属性从组件外向组件内传递变化的数据
>2. 注意:组件内部不要修改props数据

##### ③代码示例:

###### Ⅰ-类组件使用props

```jsx
	//创建组件
		class Person extends React.Component{
			render(){
				// console.log(this);
				const {name,age,sex} = this.props
				return (
					<ul>
						<li>姓名：{name}</li>
						<li>性别：{sex}</li>
						<li>年龄：{age+1}</li>
					</ul>
				)
			}
		}
		//渲染组件到页面
		ReactDOM.render(<Person name="jerry" age={19}  sex="男"/>,document.getElementById('test1'))
		ReactDOM.render(<Person name="tom" age={18} sex="女"/>,document.getElementById('test2'))
		const p = {name:'老刘',age:18,sex:'女'}
		// console.log('@',...p);
		// ReactDOM.render(<Person name={p.name} age={p.age} sex={p.sex}/>,document.getElementById('test3'))
        //此处使用赋值解构方式,使得代码更简洁
		ReactDOM.render(<Person {...p}/>,document.getElementById('test3'))
```

###### Ⅱ-函数组件使用props

```jsx
//创建组件
		function Person (props){
			const {name,age,sex} = props
			return (
					<ul>
						<li>姓名：{name}</li>
						<li>性别：{sex}</li>
						<li>年龄：{age}</li>
					</ul>
				)
		}
//此处限制可以换成typrScript
		Person.propTypes = {
			name:PropTypes.string.isRequired, //限制name必传，且为字符串
			sex:PropTypes.string,//限制sex为字符串
			age:PropTypes.number,//限制age为数值
		}

		//指定默认标签属性值
		Person.defaultProps = {
			sex:'男',//sex默认值为男
			age:18 //age默认值为18
		}
		//渲染组件到页面
		ReactDOM.render(<Person name="jerry"/>,document.getElementById('test1'))
	
```

### 3、组件三大属性3:refs

##### ① 理解

> 组件内的标签可以定义ref来标识自己

##### ② 代码示例:

###### 1、字符串形式的ref(`不推荐,将被淘汰`)

```jsx
//展示左侧输入框的数据
	showData = ()=>{
		const {input1} = this.refs
		alert(input1.value)
	}
	//展示右侧输入框的数据
	showData2 = ()=>{
		const {input2} = this.refs
		alert(input2.value)
	}
	render(){
		return(
			<div>
				<input ref="input1" type="text" placeholder="点击按钮提示数据"/>&nbsp;
				<button onClick={this.showData}>点我提示左侧的数据</button>&nbsp;
				<input ref="input2" onBlur={this.showData2} type="text" placeholder="失去焦点提示数据"/>
			</div>
		)
	}
}
```

###### 2、回调形式的ref

```jsx
/**下面的this指的是组件实例,我直接this.input1 = c 意思是给实例上的input1赋值,之后直接通过调用打印得到*/
//展示左侧输入框的数据
	showData = ()=>{
		const {input1} = this
		alert(input1.value)
	}
	//展示右侧输入框的数据
	showData2 = ()=>{
		const {input2} = this
		alert(input2.value)
	}
	render(){
		return(
			<div>
				<input ref={c => this.input1 = c } type="text" placeholder="点击按钮提示数据"/>&nbsp;
				<button onClick={this.showData}>点我提示左侧的数据</button>&nbsp;
				<input onBlur={this.showData2} ref={c => this.input2 = c } type="text" placeholder="失去焦点提示数据"/>&nbsp;
			</div>
		)
	}
}

```

###### 3、createRef创建ref容器`最推荐的`

```jsx
/*React.createRef调用后可以返回一个容器，该容器可以存储被ref所标识的节点,该容器是“专人专用”的*/
myRef = React.createRef()
myRef2 = React.createRef()
//展示左侧输入框的数据
showData = ()=>{
	alert(this.myRef.current.value);
}
//展示右侧输入框的数据
showData2 = ()=>{
	alert(this.myRef2.current.value);
}
render(){
	return(
		<div>
			<input ref={this.myRef} type="text" placeholder="点击按钮提示数据"/>&nbsp;
			<button onClick={this.showData}>点我提示左侧的数据</button>&nbsp;
			<input onBlur={this.showData2} ref={this.myRef2} type="text" placeholder="失去焦点提示数据"/>&nbsp;
		</div>
	)
}
}	
```

### 4、事件处理与收集表单数据

#### Ⅰ-事件处理

>1. 通过onXxx属性指定事件处理函数(注意大小写)
>
>   a)React使用的是自定义(合成事件,而不是使用的原生DOM事件) ----为了更好的兼容性
>
>   b)React中的事件是通过事件委托的方式处理的(委托给组件最外层的元素)----为了更高效
>
>2. 通过event.target得到发生事件的DOM元素对象 -----不要过度使用ref

#### Ⅱ-表单组件的分类

> 就形式上来说，**`受控组件`就是为某个form表单组件添加`value`属性；`非受控组件`就是没有添加`value`属性的组件**

##### 1、受控组件

```jsx
state = {//初始化状态
	username:'', //用户名
	password:'' //密码
}

//保存用户名到状态中
saveUsername = (event)=>{
	this.setState({username:event.target.value})
}

//保存密码到状态中
savePassword = (event)=>{
	this.setState({password:event.target.value})
}

//表单提交的回调
handleSubmit = (event)=>{
	event.preventDefault() //阻止表单提交
	const {username,password} = this.state
	alert(`你输入的用户名是：${username},你输入的密码是：${password}`)
}

render(){
	return(
		<form onSubmit={this.handleSubmit}>
			用户名：<input onChange={this.saveUsername} type="text" name="username"/>
			密码：<input onChange={this.savePassword} type="password" name="password"/>
			<button>登录</button>
		</form>
	)
}
}
```

##### 2、非受控组件

```jsx
handleSubmit = (event)=>{
		event.preventDefault() //阻止表单提交
		const {username,password} = this
		alert(`你输入的用户名是：${username.value},你输入的密码是：${password.value}`)
	}
	render(){
		return(
			<form onSubmit={this.handleSubmit}>
				用户名：<input ref={c => this.username = c} type="text" name="username"/>
				密码：<input ref={c => this.password = c} type="password" name="password"/>
				<button>登录</button>
			</form>
		)
	}
}
```

### 5、高阶函数与函数柯里化

##### ① 高阶函数:

>如果一个函数符合下面两个规范中的任何一个,那该函数就是高阶函数
>
>1. 若A函数,接受的参数是一个函数,那么A就可以称之为高阶函数
>2. 若A函数,调用的返回值依然是一个函数,那么A就可以称之为高阶函数
>
>常见的高阶函数有:Promise、setTimeout、arr.map()等等 

##### ② 函数的柯里化

>通过函数调用继续返回函数的方式,实现对此接受参数最后统一处理的函数编码形式
>
>```js
>function sum(a){ return (b)=>{return c=>{ return a+b+c} }}
>```

##### ③ 不用函数柯里化实现事件的绑定

>直接使用回调函数,因为他本身就是以一个函数为返回值
>
>```jsx
><input onChange={event => this.saveFormData('username',event) } type="text" name="username"/>
>```



## 五、生命周期

>1. 组件从创建到死亡它会经历一些特定的阶段
>2. React组件中包含一系列钩子函数(生命周期回调函数),会在特定的时刻调用
>3. 我们在定义组件时,会在特定的生命周期回调函数中,做特定的工作

### 1、React生命周期(旧)

>各个生命周期钩子调用顺序
>
>1. 初始化阶段:由ReactDOM.render()触发 --初次渲染
>
>      - constructor()
>
>      - compinentWillMount()
>
>      - render()
>
>      - componentDidMount() ==>`常用` 组件将要渲染
>
>    一般在这个钩子中做一些初始化的事情,如:开启定时器,发送网络请求,订阅消息等
>
>2. 更新阶段:由组件内部的this.setState()或者父组件的render触发
>
>      - shouldComponentUpdate() 组件应该更新
>      - componentWillUpdate() 组件将要更新
>      - render()   ===>`必须使用`的一个
>      - componentDidUpdate() 组件将要更新
>
>3. 卸载组件:由ReactDOM.unmountComponentAtNode(`卸载节点上的组件`)触发
>
>      - componentWillUnmount() ===>`常用` 组件将要卸载
>
>    一般在这个钩子中做一些首位的事情,如:关闭定时器,取消订阅等

### 2、React生命周期(新)

>1. 初始化阶段:由ReactDOM.render()触发 ---初次渲染
>
>      - constructor()
>      - getDerivedStateFromProps() 从Props获得派生状态
>      - render()
>      - componentDidMount() ====>`常用` 
>
>2. 更新阶段:由组件内部的this.setState()或者父组件的render触发
>
>      - getDerivedStateFromProps()  从Props获得派生状态
>      - shouldComponentUpdate() 组件应该更新
>      - render()
>      - getSnapshotBeforeUpdate() 在更新前获得快照
>      - componentDidUpdate()
>
>3. 卸载组件:由ReactDOM.unmountComponentAtNode()触发
>
>      - componentWillUnmount() ===>`常用`
>
>    一般在这个钩子中做一些收尾的事情,如:关闭定时器、取消订阅消息

### 3、重要的钩子

>1. render:初始化渲染或者更新渲染调用
>2. componentDidMount() :开启监听,发送ajax请求
>3. componentWillUnmount(): 做一些收尾工作,如:清理定时器

### 4、即将废弃的钩子

>1. componentWillMount
>2. componentWillReceiveProps
>3. componentWillUpdate
>
>`ps`:现在使用会出现警告,之后版本可能需要加上UNSAFE_前缀才能使用,以后可能会被彻底废弃,不建议使用
>
>推测React团队认为提高使用成本将会间接影响我们,让我们去适应新的钩子,所以加上这个



## 六、react/vue中的key

>经典面试题:
>
>   1). react/vue中的key有什么作用？（key的内部原理是什么？）
>
>   2). 为什么遍历列表时，key最好不要用index?

##### ① 虚拟DOM中key的作用:

>1. 简单的说:key是虚拟DOM对象的标识,在更新显示时key起着极其重要的作用
>
>2. 详细的说:当状态当中的数据发生变化时,react会根据`新数据`生成`新的虚拟DOM`,随后React进行`新虚拟DOM`与`旧虚拟DOM`的diff比较,比较规则如下:
>
>   1. 旧虚拟DOM中找到了与新虚拟DOM相同的key：
>
>      a)若虚拟DOM中内容没变,直接使用之前的真实DOM
>
>      b)若虚拟DON中的内容变了,则生成新的真实DOM,随后替换掉页面中之前的真实DOM
>
>   2. 旧虚拟DOM中未找到与新虚拟DOM相同的key
>
>      根据数据创建新的真实DOM,随后渲染到页面

##### ② 用index作为key可能会引发的问题:

>1. 若对数据进行:逆序添加,逆序删除等破坏顺序操作:
>
>   会产生没有必要的真实DOM更新 ==>界面效果没问题,但是效率低
>
>2. 如果结构中还包含输入类的DOM:
>
>   会产生错误DOM更新 ===>界面有问题
>
>3. 注意:
>
>   如果不存在对数据的逆序添加、逆序删除等破坏顺序操作,仅用于渲染列表用于展示,使用index作为key是没有问题的

##### ③  开发中如何选择key?

>1. 最好使用每条数据的唯一标识作为key,比如id,手机号,身份证号,学号等
>2. 如果确定只是简单的展示诗句,用index也是可以的

```json
//慢动作回放----使用index索引值作为key
		初始数据：
				{id:1,name:'小张',age:18},
				{id:2,name:'小李',age:19},
		初始的虚拟DOM：
				<li key=0>小张---18<input type="text"/></li>
				<li key=1>小李---19<input type="text"/></li>

		更新后的数据：
				{id:3,name:'小王',age:20},
				{id:1,name:'小张',age:18},
				{id:2,name:'小李',age:19},
		更新数据后的虚拟DOM：
				<li key=0>小王---20<input type="text"/></li>
				<li key=1>小张---18<input type="text"/></li>
				<li key=2>小李---19<input type="text"/></li>

-----------------------------------------------------------------

//慢动作回放----使用id唯一标识作为key

		初始数据：
				{id:1,name:'小张',age:18},
				{id:2,name:'小李',age:19},
		初始的虚拟DOM：
				<li key=1>小张---18<input type="text"/></li>
				<li key=2>小李---19<input type="text"/></li>

		更新后的数据：
				{id:3,name:'小王',age:20},
				{id:1,name:'小张',age:18},
				{id:2,name:'小李',age:19},
		更新数据后的虚拟DOM：
				<li key=3>小王---20<input type="text"/></li>
				<li key=1>小张---18<input type="text"/></li>
				<li key=2>小李---19<input type="text"/></li>
```



# Ⅱ-React脚手架

>1. xxx脚手架:用来帮助程序原快速创建一个基于xxx库的模板项目
>
>   a) 包含了所有需要的配置(语法检查,jsx编 译,devServer...)
>
>   b)下载好了所有相关的依赖
>
>   c) 可以直接运行一个简单效果
>
>2. react提供了一个用于创建react项目的脚手架库:create-react-app
>
>3. 项目的整体技术架构为:react+webpack+es6+eslint
>
>4. 使用脚手架开发的项目的特点:模块化,组件化,工程化
>
>此处需要webpack 相关知识点,我先去学习相关知识先(2-3晚)

### 1、创建项目并启动

>1. 全局安装:`npm i -g create-react-app`
>
>2. 切换到想创建项目的目录,使用命令:`create-react-arr hello-react`
>3. 进入项目文件夹
>4. 启动项目:`npm start`

### 2、react脚手架项目结构

> public ---- 静态资源文件夹
>
>​            favicon.icon ------ 网站页签图标
>
>​            **index.html --------** **主页面**
>
>​            logo192.png ------- logo图
>
>​            logo512.png ------- logo图
>
>​            manifest.json ----- 应用加壳的配置文件
>
>​            robots.txt -------- 爬虫协议文件
>
>src ---- 源码文件夹
>
>​            App.css -------- App组件的样式
>
>​            **App.js --------- App****组件**
>
>​            App.test.js ---- 用于给App做测试
>
>​            index.css ------ 样式
>
>​            **index.js -------** **入口文件**
>
>​            logo.svg ------- logo图
>
>​            reportWebVitals.js
>
>​                    --- 页面性能分析文件(需要web-vitals库的支持)
>
>​            setupTests.js
>
>​                    ---- 组件单元测试的文件(需要jest-dom库的支持)

### 3、功能界面的组件化编码流程

>1. 拆分组件: 拆分界面,抽取组件
>
>2. 实现静态组件: 使用组件实现静态页面效果
>
>3. 实现动态组件
>
>​	3.1 动态显示初始化数据
>
>​		3.1.1 数据类型
>
>​		3.1.2 数据名称
>
>​		3.1.2 保存在哪个组件?
>
>​	3.2 交互(从绑定事件监听开始)

### 4、TodoList部分代码

>1、更新时可以利用赋值解构后再传入重复字段会自动覆盖的方式进行更新数据
>
>​	-->if(todoObj.id === id) return `{...todoObj,done}`
>
>2、数组批量删除可以用filter过滤实现

```js
//updateTodo用于更新一个todo对象
updateTodo = (id,done)=>{
		//获取状态中的todos
		const {todos} = this.state
		//匹配处理数据
		const newTodos = todos.map((todoObj)=>{
			if(todoObj.id === id) return {...todoObj,done}
			else return todoObj
		})
		this.setState({todos:newTodos})
	}

	//deleteTodo用于删除一个todo对象
	deleteTodo = (id)=>{
		//获取原来的todos
		const {todos} = this.state
		//删除指定id的todo对象
		const newTodos = todos.filter((todoObj)=>{
			return todoObj.id !== id
		})
		//更新状态
		this.setState({todos:newTodos})
	}

	//checkAllTodo用于全选
	checkAllTodo = (done)=>{
		//获取原来的todos
		const {todos} = this.state
		//加工数据
		const newTodos = todos.map((todoObj)=>{
			return {...todoObj,done}
		})
		//更新状态
		this.setState({todos:newTodos})
}
```

# Ⅲ-React ajax

> 此部分需要预备技术栈:ajax、Axios,相关笔记已经记录在隔壁文件夹且学习完成

### 1、React中配置代理(`proxy`)

>1. `简单代理`:在package.json中追加如下配置 :`"proxy":http://localhost:5000`
>     - ps:当你请求`http://localhost:5000`产生跨域(本身在3000端口)时,添加此代码, 之后你请求时用`http://localhost:3000`进行请求,当其在`3000`端口中找不到资源时将会自动转发至`5000`端口进行请求,不产生跨域问题
>     - 优点：配置简单，前端请求资源时可以不加任何前缀。
>     - 缺点：不能配置多个代理
>     - 工作方式：上述方式配置代理，当请求了3000不存在的资源时，那么该请求会转发给5000 （优先匹配前端资源）
>2. 方法二: 在src下创建配置文件：`src/setupProxy.js`
>     - ps:必须是这个文件名,react项目运行的时候会自动查找这个文件,并将其加入webpack的配置中,所以当你修改此文件后,你需要重新启动项目
>     - 优点：可以配置多个代理，可以灵活的控制请求是否走代理。
>     - 缺点：配置繁琐，前端请求资源时必须加前缀。
>
>```js
>//代码示例
>const proxy = require('http-proxy-middleware')
>  module.exports = function(app) {
>    app.use(
>      proxy('/api1', {  //api1是需要转发的请求(所有带有/api1前缀的请求都会转发给5000)
>        target: 'http://localhost:5000', //配置转发目标地址(能返回数据的服务器地址)
>        changeOrigin: true, //控制服务器接收到的请求头中host字段的值
>        /*
>        	changeOrigin设置为true时，服务器收到的请求头中的host为：localhost:5000
>        	changeOrigin设置为false时，服务器收到的请求头中的host为：localhost:3000
>        	changeOrigin默认值为false，但我们一般将changeOrigin值设为true
>        */
>        pathRewrite: {'^/api1': ''} //去除请求前缀，保证交给后台服务器的是正常请求地址(必须配置)
>      }),
>      proxy('/api2', { 
>        target: 'http://localhost:5001',
>        changeOrigin: true,
>        pathRewrite: {'^/api2': ''}
>      })
>    )
>}
>```

### 2、补充知识点

#### Ⅰ-ES6小知识点:`连续赋值解构`+重命名

>```js
>let obj = {a:{b:1}}
>const {a} = obj; //传统解构赋值
>const {a:{b}} = obj; //连续解构赋值
>const {a:{b:value}} = obj; //连续解构赋值+重命名
>```

#### Ⅱ-消息订阅与发布机制 --->  工具库: PubSubJS

> 1.先订阅，再发布（理解：有一种隔空对话的感觉）
>
> 2.适用于任意组件间通信
>
> 3.要在组件的componentWillUnmount中取消订阅
>
> ```js
> //下载: npm install pubsub-js --save
> //使用举例
> 1)	import PubSub from 'pubsub-js' //引入
> 2)	PubSub.subscribe('delete', function(data){ }); //订阅
> 3)	PubSub.publish('delete', data) //发布消息
> //*------------------------------使用----------------------------------------------------
> 	componentDidMount(){
> 		this.token = PubSub.subscribe('atguigu',(_,stateObj)=>{
> 			this.setState(stateObj)
> 		})
> 	}
> 
> 	componentWillUnmount(){
> 		PubSub.unsubscribe(this.token)
> 	}
> //----------------------------------使用---------------------------------------------------
> 		//发送请求前通知List更新状态
> 		PubSub.publish('atguigu',{isFirst:false,isLoading:true})
> 		//发送网络请求---使用fetch发送（优化）
> 		try {
> 			const response= await fetch(`/api1/search/users2?q=${keyWord}`)
> 			const data = await response.json()
> 			console.log(data);
> 			PubSub.publish('atguigu',{isLoading:false,users:data.items})
> 		} catch (error) {
> 			console.log('请求出错',error);
> 			PubSub.publish('atguigu',{isLoading:false,err:error.message})
> 		}
> 	}
> ```

#### Ⅲ-消息订阅与发布机制 --->  工具库: mitt

>这是本人后来在githyb中找到并应用在项目代码中的,此工具库代码量特别少,可以阅读源码,会有很大好处
>
>此方法用的是[`mitt`]实现,其实本质上就是注册一个全局变量进行监听 --> [mitt源码地址](https://github.com/developit/mitt)
>
>可以自己实现,此处因为人家写的不错了,就以此作为例子
>
>1. 安装或者直接复制使用
>
>  ```sh
>npm install --save mitt
>  ```
>
>2. 使用示例
>
>  ```tsx
>//
>-------------- 首先要定义一个公用全局变量  --------------------------
>  //文件 utils/index.ts
>  import mitt from './mitt';
>  //此处声明,将其变为全局变量
>  const eventBus = mitt();
>  export { eventBus }
>  ---------------- 发送值的组件(要修改别人的组件)  ---------------------
>  //导入共有变量
>  import { eventBus } from '~/utils';
>    <a
>    onClick={() => {
>  	//延迟发送是本人此之前有一个跳转动作,跳转到接收方组件
>      // 防止修改了值的时候但是接收组件未注册  正常情况直接发送即可     
>      //setTimeout(() => {
>      // eventBus.emit('foo', data);
>      //}, 100);
>      eventBus.emit('foo', data);    
>     }}
>    />;
>
>  ------------------ 接受方组件(接受发送方的组件)  -------------------------------------
>
>  const Search: FC<IProps> = (props) => {
>    useEffect(() => {
>      //替换为mitt写法,此时已经接收到了
>      eventBus.on('foo', (searchParams) => {console.log('接受到值了',searchParams) }
>      });
>    }, []);
>  } 
>  ```
>
>3. mitt源码
>
>  ```ts
>  export type EventType = string | symbol;
>
>  // An event handler can take an optional event argument
>  // and should not return a value
>  export type Handler<T = unknown> = (event: T) => void;
>  export type WildcardHandler<T = Record<string, unknown>> = (
>    type: keyof T,
>    event: T[keyof T]
>  ) => void;
>
>  // An array of all currently registered event handlers for a type
>  export type EventHandlerList<T = unknown> = Array<Handler<T>>;
>  export type WildCardEventHandlerList<T = Record<string, unknown>> = Array<
>    WildcardHandler<T>
>  >;
>
>  // A map of event types and their corresponding event handlers.
>  export type EventHandlerMap<Events extends Record<EventType, unknown>> = Map<
>    keyof Events | '*',
>    EventHandlerList<Events[keyof Events]> | WildCardEventHandlerList<Events>
>  >;
>
>  export interface Emitter<Events extends Record<EventType, unknown>> {
>    all: EventHandlerMap<Events>;
>
>    on: (<Key extends keyof Events>(type: Key, handler: Handler<Events[Key]>) => void) & ((type: '*', handler: WildcardHandler<Events>) => void);
>
>    off: (<Key extends keyof Events>(
>      type: Key,
>      handler?: Handler<Events[Key]>
>    ) => void) & ((type: '*', handler: WildcardHandler<Events>) => void);
>
>    emit: (<Key extends keyof Events>(type: Key, event: Events[Key]) => void) & (<Key extends keyof Events>(
>      type: undefined extends Events[Key] ? Key : never
>    ) => void);
>  }
>
>  /**
>   * Mitt: Tiny (~200b) functional event emitter / pubsub.
>   * @name mitt
>   * @returns {Mitt}
>   */
>  export default function mitt<Events extends Record<EventType, unknown>>(
>    all?: EventHandlerMap<Events>
>  ): Emitter<Events> {
>    type GenericEventHandler =
>      | Handler<Events[keyof Events]>
>      | WildcardHandler<Events>;
>    all = all || new Map();
>
>    return {
>      /**
>       * A Map of event names to registered handler functions.
>       */
>      all,
>
>      /**
>       * Register an event handler for the given type.
>       * @param {string|symbol} type Type of event to listen for, or `'*'` for all events
>       * @param {Function} handler Function to call in response to given event
>       * @memberOf mitt
>       */
>      on<Key extends keyof Events>(type: Key, handler: GenericEventHandler) {
>        const handlers: Array<GenericEventHandler> | undefined = all!.get(type);
>        if (handlers) {
>          handlers.push(handler);
>        } else {
>          all!.set(type, [handler] as EventHandlerList<Events[keyof Events]>);
>        }
>      },
>
>      /**
>       * Remove an event handler for the given type.
>       * If `handler` is omitted, all handlers of the given type are removed.
>       * @param {string|symbol} type Type of event to unregister `handler` from, or `'*'`
>       * @param {Function} [handler] Handler function to remove
>       * @memberOf mitt
>       */
>      off<Key extends keyof Events>(type: Key, handler?: GenericEventHandler) {
>        const handlers: Array<GenericEventHandler> | undefined = all!.get(type);
>        if (handlers) {
>          if (handler) {
>            handlers.splice(handlers.indexOf(handler) >>> 0, 1);
>          } else {
>            all!.set(type, []);
>          }
>        }
>      },
>
>      /**
>       * Invoke all handlers for the given type.
>       * If present, `'*'` handlers are invoked after type-matched handlers.
>       *
>       * Note: Manually firing '*' handlers is not supported.
>       *
>       * @param {string|symbol} type The event type to invoke
>       * @param {Any} [evt] Any value (object is recommended and powerful), passed to each handler
>       * @memberOf mitt
>       */
>      emit<Key extends keyof Events>(type: Key, evt?: Events[Key]) {
>        let handlers = all!.get(type);
>        if (handlers) {
>          (handlers as EventHandlerList<Events[keyof Events]>)
>            .slice()
>            .map((handler) => {
>              handler(evt!);
>            });
>        }
>
>        handlers = all!.get('*');
>        if (handlers) {
>          (handlers as WildCardEventHandlerList<Events>)
>            .slice()
>            .map((handler) => {
>              handler(type, evt!);
>            });
>        }
>      },
>    };
>  }
>  ```

#### Ⅳ-defaultChecked 、 checked的区别

>注意defaultChecked 和 checked的区别，类似的还有：defaultValue 和 value

### 3、`fetch`发送请求

> 概念:`关注分离`的设计思想

>1. Fetch 是浏览器提供的原生 AJAX 接口。
>
> 由于原来的XMLHttpRequest`不符合关注分离原则`，且基于事件的模型在处理异步上已经没有现代的Promise等那么有优势。因此Fetch出现来解决这种问题。
>
>2. 特点:
>
>     - fetch: `原生函数`，不再使用XmlHttpRequest对象提交ajax请求
>
>     - `老版本浏览器可能不支持`
>
>     - 使用 fetch 无法`取消一个请求`。这是因为Fetch API`基于 Promise`，而Promise无法做到这一点。由于Fetch是典型的异步场景，所以大部分遇到的问题不是 Fetch 的，其实是 Promise 的。
>
>  4. 如果直接使用`fetch`,返回的并不是直接的结果它只是一个`HTTP响应`，而不是真的数据。想要获取数据,方法有二:
>
>     ① 使用async+await获取
>
>     ② 使用promise的链式调用,再第一个then中将其返回,再下个then中在使用
>
>3. 代码示例
>
>```js
>//代码示例
>----------------------------- 未优化:使用then链式调用 ---------------------------------------------------------
>fetch(`/api1/search/users2?q=${keyWord}`).then(
>			response => {
>				console.log('联系服务器成功了');
>				return response.json()
>			},
>			error => {
>				console.log('联系服务器失败了',error);
>				return new Promise(()=>{})
>			}
>		).then(
>			response => {console.log('获取数据成功了',response);},
>			error => {console.log('获取数据失败了',error);}
>) 
>----------------------------- 优化后:使用async+await ---------------------------------------------------------
>try {
>		const response= await fetch(`/api1/search/users2?q=${keyWord}`)
>		const data = await response.json()
>		console.log(data);
>		} catch (error) {
>		onsole.log('请求出错',error);
>		}
>}
>```

# Ⅳ-React 路由

## 1、相关理解

### Ⅰ-SPA的理解

>1. 单页Web应用（single page web application，SPA）。
>
>2. 整个应用只有**一个完整的页面**。
>
>3. 点击页面中的链接**不会刷新**页面，只会做页面的**局部更新。**
>
>4. 数据都需要通过ajax请求获取, 并在前端异步展现。

### Ⅱ-路由的理解

#### ① 什么是路由?

>1. 一个路由就是一个映射关系(key:value)
>
>2. key为路径, value可能是function或component

#### ② 路由分类

##### 1、后端路由

>1)   理解： value是function, 用来处理客户端提交的请求。
>
>2)   注册路由： router.get(path, function(req, res))
>
>3)   工作过程：当node接收到一个请求时, 根据请求路径找到匹配的路由, 调用路由中的函数来处理请求, 返回响应数据

##### 2、前端路由

>1)   浏览器端路由，value是component，用于展示页面内容。
>
>2)   注册路由: `<Route path="/test" component={Test}>`
>
>3)   工作过程：当浏览器的path变为/test时, 当前路由组件就会变为Test组件

### Ⅲ-react-router-dom的理解

#### ①相关概念

>1. react的一个插件库。
>
>2. 专门用来实现一个SPA应用。
>
>3. 基于react的项目基本都会用到此库。

#### ②相关api

##### 1、内置组件

>1. `<BrowserRouter>`
>
>2. `<HashRouter>`
>
>3. `<Route>`
>
>4. `<Redirect>`
>
>5. `<Link>`
>
>6. `<NavLink>`
>
>7. `<Switch>`

##### 2、其他

>1. history对象
>
>2. match对象
>
>3. withRouter函数

## 2、路由的基本使用

>1.明确好界面中的导航区、展示区
>
>2.导航区的a标签改为Link标签
>
>```js
>  <Link to="/xxxxx">Demo</Link>
>```
>
>3.展示区写Route标签进行路径的匹配 
>
>```js
><Route path='/xxxx' component={Demo}/>
>```
>
>4.`<App>`的最外侧包裹了一个`<BrowserRouter>或<HashRouter>`
>
>```js
>ReactDOM.render(
>	<BrowserRouter>
>		<App/>
>	</BrowserRouter>,
>	document.getElementById('root')
>)
>```

## 3、路由组件与一般组件

>1.写法不同：
>
>​      一般组件：`<Demo/>`
>
>​      路由组件：`<Route path="/demo" component={Demo}/>`
>
>2.存放位置不同：
>
>​      一般组件：components
>
>​      路由组件：pages
>
>3. 接收到的props不同：
>
>  一般组件：写组件标签时传递了什么，就能收到什么
>
>  路由组件：接收到三个固定的属性
>
>  ```json
>  //路由属性打印结果展示
>  history:
>  	go: ƒ go(n)
>  	goBack: ƒ goBack()
>  	goForward: ƒ goForward()
>  	push: ƒ push(path, state)
>  	replace: ƒ replace(path, state)
>  location:
>      pathname: "/about"
>  	search: ""
>  	state: undefined
>  	match:
>  params: { }
>  	path: "/about"
>  	url: "/about"
>  ```

## 4、NavLink使用与封装

>1. NavLink可以`实现路由链接的高亮`，通过`activeClassName指定样式名`
>
>2. 封装
>
>  ```jsx
>  //封装示例
>  export default class MyNavLink extends Component {
>  	render() {
>  		return (
>  			<NavLink activeClassName="atguigu" className="list-group-item" {...this.props}/>
>  		)
>  	}
>  }
>  ```
>
>3. 使用与调用
>
>  ```jsx
>//原生html中，靠<a>跳转不同的页面
>{/* <a className="list-group-item" href="./about.html">About</a>
><a className="list-group-item active" href="./home.html">Home</a> */}
>
>  {/* 在React中靠路由链接实现切换组件--编写路由链接 */}
>  	<MyNavLink to="/about">About</MyNavLink>
>  	<MyNavLink to="/home">Home</MyNavLink>
>  ```

## 5、Switch的使用

>1.通常情况下，path和component是一一对应的关系。
>
>2.Switch可以提高路由匹配效率(单一匹配) ---- 即匹配到一个后将不再往下匹配
>
>```jsx
><Switch>
>	<Route path="/about" component={About}/>
>	<Route path="/home" component={Home}/>
>	<Route path="/home" component={Test}/>
></Switch>
>```

## 6、解决多级路径刷新页面样式丢失的问题

>1.public/index.html 中 引入样式时不写 ./ 写 / （常用）
>
>2.public/index.html 中 引入样式时不写 ./ 写 `%PUBLIC_URL%` （常用,但`只在react中`有效果）
>
>3.使用HashRouter (不常用)
>
>```html
><!DOCTYPE html>
><html>
>	<head>
>		<meta charset="UTF-8" />
>		<title>react脚手架</title>
>        <!-- 方法二 -->
>		<link rel="icon" href="%PUBLIC_URL%/favicon.ico" />
>          <!-- 方法一 -->
>		<link rel="stylesheet" href="/css/bootstrap.css">
>	</head>
>	<body>
>		<div id="root"></div>
>	</body>
></html>
>```

## 7、路由的严格匹配与模糊匹配

>1. 默认使用的是模糊匹配（简单记：【输入的路径】必须包含要【匹配的路径】，且顺序要一致）
>
>2. 开启严格匹配：<Route `exact={true}`path="/about" component={About}/>  
>
>   可以省略`exact={true}`为`exact`
>
>3. `严格匹配不要随便开启`，需要再开，有些时候开启会导致无法继续匹配二级路由
>
>```jsx
>//编写路由链接
>	<MyNavLink to="/about">About</MyNavLink>
>	<MyNavLink to="/home/a/b">Home</MyNavLink>
>
>{/* 注册路由 */}
>	<Switch>
>		<Route exact path="/about" component={About}/>
>		<Route exact path="/home" component={Home}/>
>	</Switch>
>```

## 8、**Redirect的使用** 

>1. 一般写在所有路由注册的`最下方`，当所有路由都`无法匹配时`，跳转到Redirect指定的路由
>
>2. 具体编码：
>
>   ```jsx
>   	<Switch>
>   		<Route path="/about" component={About}/>
>   		<Route path="/home" component={Home}/>
>   		<Redirect to="/about"/>
>   	</Switch>
>   ```

## 9、嵌套路由

>1. 注册子路由时要写上父路由的path值
>
>2. 路由的匹配是按照注册路由的顺序进行的
>
>```jsx
>-------------------注册一级路由-----------------------------
>	{/* 在React中靠路由链接实现切换组件--编写路由链接 */}
>	<MyNavLink to="/about">About</MyNavLink>
>	<MyNavLink to="/home">Home</MyNavLink>
>    {/* 注册路由 */}
>	<Switch>
>		<Route path="/about" component={About}/>
>		<Route path="/home" component={Home}/>
>		<Redirect to="/about"/>
>	</Switch>
>----------------------注册二级路由 :Home组件-----------------------------------
>    <div>
>		<ul className="nav nav-tabs">
>			<li>
>				<MyNavLink to="/home/news">News</MyNavLink>
>			</li>
>			<li>
>				<MyNavLink to="/home/message">Message</MyNavLink>
>			</li>
>		</ul>
>		{/* 注册路由 */}
>		<Switch>
>			<Route path="/home/news" component={News}/>
>			<Route path="/home/message" component={Message}/>
>			<Redirect to="/home/news"/>
>		</Switch>
>	</div>
>```

## 10、向路由组件传递参数

### Ⅰ-params参数

>1. 路由链接(携带参数)：`<Link to='/demo/test/tom/18'}>详情</Link>`
>
>2. 注册路由(声明接收)：`<Route path="/demo/test/:name/:age" component={Test}/>`
>
>3. 接收参数：this.props.match.params
>
>```jsx
> 	-------------------------------发送参数:父组件----------------------------------------------
>	<div>
>        {/* 向路由组件传递params参数 */}
>        <Link to={`/home/message/detail/${msgObj.id}/${msgObj.title}`}>{msgObj.title}</Link>
>        <hr />
>        {/* 声明接收params参数 */}
>        <Route path="/home/message/detail/:id/:title" component={Detail} />
>   </div>
>	--------------------------------接受参数:子组件-----------------------------------------------------------
>     const {id,title} = this.props.match.params
>```

### Ⅱ-search参数

>1. 路由链接(携带参数)：`<Link to='/demo/test?name=tom&age=18'}>详情</Link>`
>2. 注册路由(`无需声明`，正常注册即可)：`<Route path="/demo/test" component={Test}/>`
>3. 接收参数：this.props.location.search
>4. 备注：获取到的search是`urlencoded编码字符串`，需要`借助querystring解析`
>
>```jsx
> 	-------------------------------发送参数:父组件----------------------------------------------
>	<div>
>       	{/* 向路由组件传递search参数 */}
>		<Link to={`/home/message/detail/?id=${msgObj.id}&title=${msgObj.title}`}>{msgObj.title}</Link>
>        <hr />
>      	{/* search参数无需声明接收，正常注册路由即可 */}
>		<Route path="/home/message/detail" component={Detail}/>
>   </div>
>	--------------------------------接受参数:子组件-----------------------------------------------------------
>     import qs from 'querystring'
>	// 接收search参数
>	const {search} = this.props.location
>	const {id,title} = qs.parse(search.slice(1))
>```

### Ⅲ-state参数

>1. 路由链接(携带参数)：[`<Link to={{pathname:'/demo/test',state:{name:'tom',age:18}}}>详情</Link>`]
>2. 注册路由(无需声明，正常注册即可)：[`<Route path="/demo/test" component={Test}/>`]
>3. 接收参数：this.props.location.state
>   - 备注：使用`BrowserRouter`刷新才可以`保留住参数`,使用`HashRouter`刷新后state将会没有`history`来保存参数
>   - 子组件接受参数时`const {id,title} = this.props.location.state || {}` ,后面添加`||{}`是防止使用`HashRouter`后state为undefined时报错
>
>```jsx
> 	-------------------------------发送参数:父组件----------------------------------------------
>	<div>
>       	{/* 向路由组件传递state参数 */}
>		<Link to={{pathname:'/home/message/detail',state:{id:msgObj.id,title:msgObj.title}}}>{msgObj.title}</Link>
>
>        <hr />
>      	{/* state参数无需声明接收，正常注册路由即可 */}
>		<Route path="/home/message/detail" component={Detail}/>
>   </div>
>	--------------------------------接受参数:子组件-----------------------------------------------------------
>     // 接收state参数,后面添加`||{}`是防止使用`HashRouter`后state为undefined时报错
>	const {id,title} = this.props.location.state || {}
>```

## 11、编程式路由导航

> `借助this.prosp.history对象上的API对`操作路由跳转、前进、后退  
>
>1. -this.prosp.history.push()
>
>   将历史记录压入栈
>
>2. -this.props.history.replace()
>
>   替代栈位置,即不会产生历史记录
>
>3. -this.props.history.goBack()
>
>   回退一格
>
>4. -this.props.history.goForward()
>
>   前进一格
>
>5. -this.props.history.go()
>
>   前进或者后退n格(根据传入的数字正负数)
>
>```jsx
>import React, { Component } from 'react'
>import { Link, Route } from 'react-router-dom'
>import Detail from './Detail'
>
>export default class Message extends Component {
>  state = {
>    messageArr: [
>      { id: '01', title: '消息1' },
>      { id: '02', title: '消息2' },
>      { id: '03', title: '消息3' },
>    ]
>  }
>
>  replaceShow = (id, title) => {
>    //replace跳转+携带params参数
>    //this.props.history.replace(`/home/message/detail/${id}/${title}`)
>
>    //replace跳转+携带search参数
>    // this.props.history.replace(`/home/message/detail?id=${id}&title=${title}`)
>
>    //replace跳转+携带state参数
>    this.props.history.replace(`/home/message/detail`, { id, title })
>  }
>
>  pushShow = (id, title) => {
>    //push跳转+携带params参数
>    // this.props.history.push(`/home/message/detail/${id}/${title}`)
>
>    //push跳转+携带search参数
>    // this.props.history.push(`/home/message/detail?id=${id}&title=${title}`)
>
>    //push跳转+携带state参数
>    this.props.history.push(`/home/message/detail`, { id, title })
>
>  }
>
>  back = () => {
>    this.props.history.goBack()
>  }
>
>  forward = () => {
>    this.props.history.goForward()
>  }
>
>  go = () => {
>    this.props.history.go(-2)
>  }
>
>  render() {
>    const { messageArr } = this.state
>    return (
>      <div>
>        <ul>
>          {
>            messageArr.map((msgObj) => {
>              return (
>                <li key={msgObj.id}>
>
>                  {/* 向路由组件传递params参数 */}
>                  {/* <Link to={`/home/message/detail/${msgObj.id}/${msgObj.title}`}>{msgObj.title}</Link> */}
>
>                  {/* 向路由组件传递search参数 */}
>                  {/* <Link to={`/home/message/detail/?id=${msgObj.id}&title=${msgObj.title}`}>{msgObj.title}</Link> */}
>
>                  {/* 向路由组件传递state参数 */}
>                  <Link to={{ pathname: '/home/message/detail', state: { id: msgObj.id, title: msgObj.title } }}>{msgObj.title}</Link>
>			&nbsp;<button onClick={() => this.pushShow(msgObj.id, msgObj.title)}>push查看</button>
>			&nbsp;<button onClick={() => this.replaceShow(msgObj.id, msgObj.title)}>replace查看</button>
>                </li>
>              )
>            })
>          }
>        </ul>
>        <hr />
>        {/* 声明接收params参数 */}
>        {/* <Route path="/home/message/detail/:id/:title" component={Detail}/> */}
>
>        {/* search参数无需声明接收，正常注册路由即可 */}
>        {/* <Route path="/home/message/detail" component={Detail}/> */}
>
>        {/* state参数无需声明接收，正常注册路由即可 */}
>        <Route path="/home/message/detail" component={Detail} />
>
>        <button onClick={this.back}>回退</button>&nbsp;
>        <button onClick={this.forward}>前进</button>&nbsp;
>        <button onClick={this.go}>go</button>
>      </div>
>    )
>  }
>}
>```

## 12、withRouter的使用

>1. withRouter可以加工一般组件，让一般组件具备路由组件所特有的API
>2. withRouter的返回值是一个新组件
>
>```jsx
>import React, { Component } from 'react'
>import { withRouter } from 'react-router-dom'
>class Header extends Component {
>  back = () => { this.props.history.goBack()}
>  forward = () => {this.props.history.goForward()}
>  go = () => { this.props.history.go(-2)}
>  render() {
>    console.log('Header组件收到的props是', this.props);
>    return (
>      <div className="page-header">
>        <h2>React Router Demo</h2>
>        <button onClick={this.back}>回退</button>&nbsp;
>        <button onClick={this.forward}>前进</button>&nbsp;
>        <button onClick={this.go}>go</button>
>      </div>
>    )
>  }
>}
>export default withRouter(Header)
>```

## 13、BrowserRouter与HashRouter的区别

> 备注：HashRouter可以用于解决一些路径错误相关的问题。即在`问题6`中引入文件时可以不进行路径修改

### Ⅰ-底层原理不一样：

>1. BrowserRouter使用的是H5的history API，不兼容IE9及以下版本。
>
>   `但一般来说都用的这个`
>
>2. HashRouter使用的是URL的哈希值。

### Ⅱ-path表现形式不一样

>1. BrowserRouter的路径中没有#,例如：localhost:3000/demo/test
>
>2. HashRouter的路径包含#,例如：localhost:3000/#/demo/test

### Ⅲ-刷新后对路由state参数的影响

>1. BrowserRouter没有任何影响，因为state保存在history对象中。
>
>2. HashRouter`刷新后会导致路由state参数的丢失！！！`



# Ⅴ-Ant Design

## 1、相关文档

>### ant-design(国内蚂蚁金服)
>
>1. 官网: https://ant.design/index-cn
>2. Github: https://github.com/ant-design/ant-design/
>
>### material-ui(国外)
>
>1. 官网: http://www.material-ui.com/#/
>
>2. github: https://github.com/callemall/material-ui

## 2、按需引入与自定义主题

### Ⅰ-安装依赖

> yarn add react-app-rewired customize-cra babel-plugin-import less less-loader

### Ⅱ-修改package.json

>```json
>	"scripts": {
>	"start": "react-app-rewired start",
>	"build": "react-app-rewired build",
>	"test": "react-app-rewired test",
>	"eject": "react-scripts eject"
>	},
>```

### Ⅲ-根目录下创建config-overrides.js

>注意:如果按照官方文档的自定义主题进行配置可能会报错,需要多加一层`lessOptions`
>
>```js
>//配置具体的修改规则
>const { override, fixBabelImports,addLessLoader} = require('customize-cra');
>module.exports = override(
>	fixBabelImports('import', {
>		libraryName: 'antd',
>		libraryDirectory: 'es',
>		style: true,
>	}),
>	addLessLoader({
>		lessOptions:{
>			javascriptEnabled: true,
>			modifyVars: { '@primary-color': 'green' },
>		}
>	}),
>-------------------官方方法,会报错-------------------------    
>+ addLessLoader({
>+   javascriptEnabled: true,
>+   modifyVars: { '@primary-color': '#1DA57A' },
>+ }),
>---------------------------------------------------------   
>);
>```

### Ⅳ-成功

> 备注：不用在组件里亲自引入样式了，即：import 'antd/dist/antd.css'应该删掉

# Ⅵ-Redux

## 1、redux理解

### Ⅰ-学习文档

>1. 英文文档: https://redux.js.org/
>
>2. 中文文档: http://www.redux.org.cn/
>
>3. Github: https://github.com/reactjs/redux

### Ⅱ-redux是什么

>1. redux是一个专门用于做`状态管理的JS库`(不是react插件库)。
>
>2. 它可以用在react, angular, vue等项目中, 但基本与react配合使用。
>
>3. 作用: 集中式管理react应用中多个组件`共享`的状态。

### Ⅲ-什么情况下需要使用redux

>1. 某个组件的状态，需要让其他组件可以随时拿到（共享）。
>
>2. 一个组件需要改变另一个组件的状态（通信）。
>
>3. 总体原则：能不用就不用, 如果不用比较吃力才考虑使用。

### Ⅳ-redux工作流程

>![React系统学习_Redux工作流程原理图](A_React系统学习笔记中的图片/React系统学习_Redux工作流程原理图.png)

## 2、redux的三个核心概念

### Ⅰ-action

>1. `动作的对象`
>
>2. 包含2个属性
>
>    type：标识属性, 值为字符串, 唯一, 必要属性
>
>    data：数据属性, 值类型任意, 可选属性
>
>3. 例子：{ type: 'ADD_STUDENT',data:{name: 'tom',age:18} }

### Ⅱ-reducer

>1. 用于初始化状态、加工状态。
>2. 加工时，根据旧的state和action， 产生新的state的`纯函数(以下为纯函数概念)``
>   - ``纯函数:`一类特别的函数: 只要是同样的输入(实参)，必定得到同样的输出(返回)
>   - 必须遵守以下一些约束 
>     1)   不得改写参数数据
>     2)   不会产生任何副作用，例如网络请求，输入和输出设备
>     3)   不能调用Date.now()或者Math.random()等不纯的方法 
>3. `redux的reducer函数必须是一个纯函数`
>



### Ⅲ-store

>1. 将state、action、reducer联系在一起的对象
>
>2. `如何得到此对象`?
>
>      - import {createStore} from 'redux'
>     - import reducer from './reducers'
>      - const store = createStore(reducer)
>
> 3. 此对象的功能?
>
>     - getState(): 得到state
>
>      - dispatch(action): 分发action, 触发reducer调用, 产生新的state
>
>      - subscribe(listener): 注册监听, 当产生了新的state时, 自动调用

## 3、redux的核心API

### Ⅰ-createstore()与applyMiddleware()

>createstore()作用：创建包含指定reducer的store对象
>
>applyMiddleware()作用：应用上基于redux的中间件(插件库)
>
>```js
>//代码示例
>---------------------------store.js 部分代码---------------------------------
>//引入createStore,专门用于创建redux中最为核心的store对象
>import {createStore,applyMiddleware} from 'redux'
>//暴露store
>export default createStore(reducer,composeWithDevTools(applyMiddleware(thunk)))
>```

### Ⅱ-store对象

>1. 作用: redux库最核心的管理对象
>
>2. 它内部维护着:
>
>     - state
>
>     - reducer
>
>3. 核心方法:
>
>     - getState()
>
>     - dispatch(action)
>
>     - subscribe(listener)
>
>4. 具体编码:
>
>     - store.getState()
>
>     - store.dispatch({type:'INCREMENT', number})
>
>     - store.subscribe(render)
>
>```jsx
>//代码示例
>---------------------------store.js---------------------------------
>/**
>* 该文件撰文用于暴露一个store对象,整个应用只有一个store对象
>*/
>//引入createStore,专门用于创建redux中最为核心的store对象
>import {createStore,applyMiddleware} from 'redux'
>//引入汇总后的reducer
>import reducer from './reducers'
>//引入redux-thunk，用于支持异步action
>import thunk from 'redux-thunk'
>//引入redux-devtools-extension
>import {composeWithDevTools} from 'redux-devtools-extension'
>//暴露store
>export default createStore(reducer,composeWithDevTools(applyMiddleware(thunk)))
>----------------------------index.js 引入store对象--------------------------------
>import React from 'react'
>import ReactDOM from "react-dom"
>import App from './App'
>import store from './redux/store'
>import {Provider} from 'react-redux'
>
>ReactDOM.render(
>	/* 此处需要用Provider包裹App，目的是让App所有的后代容器组件都能接收到store */
>	<Provider store={store}>
>		<App/>
>	</Provider>,
>	document.getElementById('root')
>)
>```

### Ⅲ-combineReducers()

> 作用：合并多个reducer函数
>
> ```jsx
> //代码示例
> ------------------ redux/reducers/index.js ------------------------------------
> /**
>  * 该文件用于汇总所有的reducer为一个总的reducer
>  */
> //引入combineReducers，用于汇总多个reducer
> import {combineReducers} from 'redux'
> //引入为Count组件服务的reducer
> import count from './count'
> import persons from './person'
> 
> //汇总所有的reducer变为一个总的reducer
> export default combineReducers({
>   count,persons
> })
> ```

## 4、redux 异步编程

### Ⅰ-理解

>1. redux默认是不能进行异步处理的,
>
>2. 某些时候应用中需要在`redux`中执行异步任务(ajax, 定时器)

### Ⅱ- 使用异步中间件

>1. 下载依赖`npm install --save redux-thunk`
>
>2. 使用
>
>  ```jsx
>  //代码示例
>  ---------------------------store.js---------------------------------
>  /**
>   * 该文件撰文用于暴露一个store对象,整个应用只有一个store对象
>   */
>  //引入createStore,专门用于创建redux中最为核心的store对象
>  import {createStore,applyMiddleware} from 'redux'
>  //引入汇总后的reducer
>  import reducer from './reducers'
>  //引入redux-thunk，用于支持异步action
>  import thunk from 'redux-thunk'
>  //引入redux-devtools-extension
>  import {composeWithDevTools} from 'redux-devtools-extension'
>  //暴露store
>  export default createStore(reducer,composeWithDevTools(applyMiddleware(thunk)))
>  ```

## 5、react-redux

### Ⅰ-理解

>1. 一个react插件库
>
>2. 专门用来简化react应用中使用redux

### Ⅱ-react-Redux将所有组件分成两大类

#### ①  UI组件

>1)   只负责 UI 的呈现，不带有任何业务逻辑
>
>2)   通过props接收数据(一般数据和函数)
>
>3)   不使用任何 Redux 的 API
>
>4)   一般保存在`components`文件夹下,也可以直接写在容器组件中直接加工成容器组件

#### ②   容器组件

>1)   负责管理数据和业务逻辑，不负责UI的呈现
>
>2)   使用 Redux 的 API
>
>3)   一般保存在`ontainers`文件夹下

### Ⅲ-相关API

#### ① Provider

>作用: 让所有组件都可以得到state数据
>
>```jsx
>import React from 'react'
>import ReactDOM from "react-dom"
>import App from './App'
>import store from './redux/store'
>import {Provider} from 'react-redux'
>
>ReactDOM.render(
>	/* 此处需要用Provider包裹App，目的是让App所有的后代容器组件都能接收到store */
>	<Provider store={store}>
>		<App/>
>	</Provider>,
>	document.getElementById('root')
>)
>```

#### ② `connect()()`

>1. 作用: 用于包装 UI 组件生成容器组件
>
>2. 使用connect(`mapDispatchToProps`,`mapDispatchToProps`)(UI组件)
>
>   注意点:
>
>   1. 该方法默认传入`state`与`dispatch`
>   2. 可以省略`dispatch`直接传入`action`方法,该api会自动帮你调用`dispatch`

##### Ⅰ-mapStateToProps

>作用:将外部的数据（即`state对象`）转换为UI组件的标签属性
>
> 1.mapStateToProps函数返回的是一个对象；
>
> 2.返回的对象中的key就作为传递给UI组件props的key,value就作为传递给UI组件props的value
>
> 3.mapStateToProps`用于传递状态`
>
>```jsx
>function mapStateToProps(state){
>	return {count:state}
>}
>```

##### Ⅱ-mapDispatchToProps

>作用:将`分发action的函数`转换为UI组件的标签属性
>
>1. mapDispatchToProps函数返回的是一个对象；
>2. 返回的对象中的key就作为传递给UI组件props的key,value就作为传递给UI组件props的value
>3. mapDispatchToProps`用于传递操作状态的方法`
>4. 可以省略`dispatch`,直接传入`action`,api将会`自动调用`dispatch

##### Ⅲ-代码示例

>```jsx
>------------------------------不简化代码-----------------------------------------------
>/* 
>	1.mapStateToProps函数返回的是一个对象；
>	2.返回的对象中的key就作为传递给UI组件props的key,value就作为传递给UI组件props的value
>	3.mapStateToProps用于传递状态
>*/
>function mapStateToProps(state){
>	return {count:state}
>}
>
>/* 
>	1.mapDispatchToProps函数返回的是一个对象；
>	2.返回的对象中的key就作为传递给UI组件props的key,value就作为传递给UI组件props的value
>	3.mapDispatchToProps用于传递操作状态的方法
>*/
>function mapDispatchToProps(dispatch){
>	return {
>		jia:number => dispatch(createIncrementAction(number)),
>		jian:number => dispatch(createDecrementAction(number)),
>		jiaAsync:(number,time) => dispatch(createIncrementAsyncAction(number,time)),
>	}
>}
>
>//使用connect()()创建并暴露一个Count的容器组件
>export default connect(mapStateToProps,mapDispatchToProps)(CountUI)
>
>----------------下面是简化代码-----------------------------
>//使用connect()()创建并暴露一个Count的容器组件
>//使用connect(传入状态,操作状态方法)(UI组件)
>export default connect(
>  state => ({
>    count: state.count,
>    personCount: state.persons.length
>  }),
>  {increment, decrement, incrementAsync}
>)(Count)
>```

## 6、使用redux调试工具

### Ⅰ- 安装chrome浏览器插件

> Redux DecTools

### Ⅱ-下载工具依赖包

> npm install --save-dev redux-devtools-extension

### Ⅲ-修改store.js

>`import {composeWithDevTools} from 'redux-devtools-extension'`
>
>```jsx
>/**
> * 该文件撰文用于暴露一个store对象,整个应用只有一个store对象
> */
>//引入createStore,专门用于创建redux中最为核心的store对象
>import {createStore,applyMiddleware} from 'redux'
>//引入汇总后的reducer
>import reducer from './reducers'
>//引入redux-thunk，用于支持异步action
>import thunk from 'redux-thunk'
>//引入redux-devtools-extension
>import {composeWithDevTools} from 'redux-devtools-extension'
>//暴露store
>export default createStore(reducer,composeWithDevTools(applyMiddleware(thunk)))
>```

# Ⅶ-Redux求和案例

> 将只展示最终代码
>
> `注意`:在`reducer`中如果preState是一个数组,不可以用`push、unshift`等方法进行修改,如此修改并不会修改其引用,所以`diff`并不会判定其发生改变,`导致页面无法自动重新渲染`
>
> ```js
> 	//preState.unshift(data) //此处不可以这样写，这样会导致preState被改写了，personReducer就不是纯函数了。
> 	return [data,...preState]
> ```

### 1、求和案例_redux精简版

> (1).去除Count组件自身的状态
>
> (2).src下建立:
>
>​      -redux
>
>​       -store.js
>
>​       -count_reducer.js
>
> (3).store.js：
>
>​     1).引入redux中的createStore函数，创建一个store
>
>​     2).createStore调用时要传入一个为其服务的reducer
>
>​     3).记得暴露store对象
>
> (4).count_reducer.js：
>
>​     1).reducer的本质是一个函数，接收：preState,action，返回加工后的状态
>
>​     2).reducer有两个作用：初始化状态，加工状态
>
>​     3).reducer被第一次调用时，是store自动触发的，
>
>​         传递的preState是undefined,
>
>​         传递的action是:{type:'@@REDUX/INIT_a.2.b.4}
>
> (5).在index.js中监测store中状态的改变，一旦发生改变重新渲染<App/>
>
>​    备注：redux只负责管理状态，至于状态的改变驱动着页面的展示，要靠我们自己写

### 2、求和案例_redux完整版

>  新增文件：
>
>   1.count_action.js 专门用于创建action对象
>
>   2.constant.js 放置容易写错的type值

### 3、求和案例_redux异步action版

>   (1).明确：延迟的动作不想交给组件自身，想交给action
>
>   (2).何时需要异步action：想要对状态进行操作，但是具体的数据靠异步任务返回。
>
>   (3).具体编码：
>
>​     1).yarn add redux-thunk，并配置在store中
>
>​     2).创建action的函数不再返回一般对象，而是一个函数，该函数中写异步任务。
>
>​     3).异步任务有结果后，分发一个同步的action去真正操作数据。
>
>   (4).备注：异步action不是必须要写的，完全可以自己等待异步任务的结果了再去分发同步action。

### 4、求和案例_react-redux基本使用

>   (1).明确两个概念：
>
>​      1).UI组件:不能使用任何redux的api，只负责页面的呈现、交互等。
>
>​      2).容器组件：负责和redux通信，将结果交给UI组件。
>
>   (2).如何创建一个容器组件————靠react-redux 的 connect函数
>
>​       connect(mapStateToProps,mapDispatchToProps)(UI组件)
>
>​        -mapStateToProps:映射状态，返回值是一个对象
>
>​        -mapDispatchToProps:映射操作状态的方法，返回值是一个对象
>
>   (3).备注1：容器组件中的store是靠props传进去的，而不是在容器组件中直接引入
>
>   (4).备注2：mapDispatchToProps，也可以是一个对象

### 5、求和案例_react-redux优化

>   (1).容器组件和UI组件整合一个文件
>
>   (2).无需自己给容器组件传递store，给<App/>包裹一个<Provider store={store}>即可。
>
>   (3).使用了react-redux后也不用再自己检测redux中状态的改变了，容器组件可以自动完成这个工作。
>
>   (4).mapDispatchToProps也可以简单的写成一个对象
>
>   (5).一个组件要和redux“打交道”要经过哪几步？
>
>​       (1).定义好UI组件---不暴露
>
>​       (2).引入connect生成一个容器组件，并暴露，写法如下         
>
>```jsx
>connect(
>       state => ({key:value}), //映射状态
>       {key:xxxxxAction} //映射操作状态的方法
>      )(UI组件)
>```
>
>​       (3).在UI组件中通过this.props.xxxxxxx读取和操作状态

### 6、求和案例_react-redux数据共享版

>   (1).定义一个Pserson组件，和Count组件通过redux共享数据。
>
>   (2).为Person组件编写：reducer、action，配置constant常量。
>
>   (3).重点：Person的reducer和Count的Reducer要使用combineReducers进行合并，合并后的总状态是一个对象！！！
>
>(4).交给store的是总reducer，最后注意在组件中取出状态的时候，记得“取到位”。

### 7、求和案例_react-redux开发者工具的使用

>   (1).yarn add redux-devtools-extension
>
>   (2).store中进行配置
>
>​     import {composeWithDevTools} from 'redux-devtools-extension'
>
>​     const store = createStore(allReducer,composeWithDevTools(applyMiddleware(thunk)))

### 8、求和案例_react-redux最终版

>   (1).所有变量名字要规范，尽量触发对象的简写形式。
>
>   (2).reducers文件夹中，编写index.js专门用于汇总并暴露所有的reducer

### 9、最终代码

#### Ⅰ-src文件目录

>src
>
>--`containers`
>
>​	--Count
>
>​		--index.jsx
>
>​	--Person
>
>​		--index.jsx
>
>--`redux`
>
>​	--actions
>
>​		--count.js
>
>​		--person.js
>
>​	--reducers
>
>​		--count.js
>
>​		--index.js
>
>​		--person.js
>
>​	--constant.js
>
>​	--store.js
>
>--`App.jsx`
>
>--`index.js`

#### Ⅱ-index.js

>```jsx
>import React from 'react'
>import ReactDOM from "react-dom"
>import App from './App'
>import store from './redux/store'
>import {Provider} from 'react-redux'
>
>ReactDOM.render(
>	/* 此处需要用Provider包裹App，目的是让App所有的后代容器组件都能接收到store */
>	<Provider store={store}>
>		<App/>
>	</Provider>,
>	document.getElementById('root')
>)
>```

#### Ⅲ-App.jsx

>```jsx
>import React, { Component } from 'react'
>import Count from './containers/Count' //引入的Count的容器组件
>import Person from './containers/Person' //引入的Person的容器组件
>
>export default class App extends Component {
>	render() {
>		return (
>			<div>
>				<Count/>
>				<hr/>
>				<Person/>
>			</div>
>		)
>	}
>}
>
>```

#### Ⅳ-redux文件

>1. `action`文件夹
>
>```jsx
>--------------------------------count.js------------------------------------------
>/**
> * 该文件专门未Count组件生成对象
> */
> import {INCREMENT,DECREMENT} from '../constant'
>
> //声明同步action,就是指action的值为Object类型的一般对象
> export const increment=data=>({type:INCREMENT,data})
> export const decrement=data=>({type:DECREMENT,data})
>
>
> //声明异步action,就是指action的值为函数,异步action中一般都会调用同步action
> //在外部调用该action方法时需要引入redux-thunk，用于支持异步action
> //该方法会自动传入dispatch
>  export const incrementAsync=(data,time)=>{
>    return (dispatch)=>{
>      setTimeout(()=>{
>        dispatch(increment(data))
>      },time)
>    }
>  }
>--------------------------------------person.js-------------------------------
>import {ADD_PERSON} from '../constant'
>//创建增加一个人的action动作对象
>export const addPerson=personObj=>({
>  type:ADD_PERSON,
>  data:personObj
>})
>```
>
>2. `reducers`文件夹
>
>```jsx
>--------------------------------count.js------------------------------------------
>/**
> * 1. 该文件时用于创建一个为Count组件服务的reducer.reducer的本质就是一个函数
> * 2. reducer函数会接到两个参数,分别为:之前状态(preState),动作对象(action)
> */
>import {
>  INCREMENT,
>  DECREMENT
>} from '../constant'
>const initState = 0 //初始化状态
>export default function countReducer(preState = initState, action) {
>  //从action对象中获取:type:data
>  const {
>    type,
>    data
>  } = action
>  //根据type决定如何加工数据
>  switch (type) {
>    case INCREMENT:
>      return preState + data
>    case DECREMENT:
>      return preState - data
>    default:
>      return preState
>  }
>}
>--------------------------------------person.js-------------------------------
>import {ADD_PERSON} from '../constant'
>//初始化人的列表
>const initState = [{id:'001',name:'tom',age:18}]
>export default function personReducer(preState=initState,action){
>	// console.log('personReducer@#@#@#');
>	const {type,data} = action
>	switch (type) {
>		case ADD_PERSON: //若是添加一个人
>			//preState.unshift(data) //此处不可以这样写，这样会导致preState被改写了，personReducer就不是纯函数了。
>			return [data,...preState]
>		default:
>			return preState
>	}
>}
>--------------------------------------index.js-------------------------------
> /**
> * 该文件用于汇总所有的reducer为一个总的reducer
> */
>//引入combineReducers，用于汇总多个reducer
>import {combineReducers} from 'redux'
>//引入为Count组件服务的reducer
>import count from './count'
>import persons from './person'
>
>//汇总所有的reducer变为一个总的reducer
>export default combineReducers({
>  count,persons
>})
>```
>
>3. `store.js`
>
>```js
>/**
> * 该文件撰文用于暴露一个store对象,整个应用只有一个store对象
> */
>//引入createStore,专门用于创建redux中最为核心的store对象
>import {createStore,applyMiddleware} from 'redux'
>//引入汇总后的reducer
>import reducer from './reducers'
>//引入redux-thunk，用于支持异步action
>import thunk from 'redux-thunk'
>//引入redux-devtools-extension
>import {composeWithDevTools} from 'redux-devtools-extension'
>//暴露store
>export default createStore(reducer,composeWithDevTools(applyMiddleware(thunk)))
>```
>
>4.`constant.js`
>
>```js
>/**
> * 该模块是用于定义action对象中的type类型的常量值,目的只有一个:
> *  便于管理的同事防止程序员单词写错
> */
> export const INCREMENT = 'increment'
> export const DECREMENT = 'decrement'
> export const ADD_PERSON = 'add_person'
>```

#### Ⅴ-containers

>1. `Count`文件夹的`index.jsx`
>
>   ```jsx
>   import React, { Component } from 'react'
>   
>   //引入action
>   import {
>     increment,
>     decrement,
>     incrementAsync
>   } from "../../redux/actions/count"
>   //引入connect用于链接UI组件与redux
>   import { connect } from 'react-redux'
>   
>   //定义UI组件,这个将再connect()()中加工成容器组件,就可以调用到其传入的redux状态与actions
>   class Count extends Component {
>     increment = () => {
>       //获取出入内容
>       const { value } = this.selectNumber
>       this.props.increment(value * 1)
>     }
>     //减法
>     decrement = () => {
>       const { value } = this.selectNumber
>       this.props.decrement(value * 1)
>     }
>     //奇数再加
>     incrementIfOdd = () => {
>       const { value } = this.selectNumber
>       if (this.props.count % 2 !== 0) {
>         this.props.increment(value * 1)
>       }
>     }
>     //异步加
>     incrementAsync = () => {
>       const { value } = this.selectNumber
>       this.props.incrementAsync(value * 1, 500)
>     }
>   
>     render() {
>       return (
>         <div>
>           <h2>我是Count组件,下方组件总人数为:{this.props.personCount}</h2>
>           <h4>当前求和为：{this.props.count}</h4>
>           <select ref={c => this.selectNumber = c}>
>             <option value="1">1</option>
>             <option value="2">2</option>
>             <option value="3">3</option>
>           </select>&nbsp;
>           <button onClick={this.increment}>+</button>&nbsp;
>           <button onClick={this.decrement}>-</button>&nbsp;
>           <button onClick={this.incrementIfOdd}>当前求和为奇数再加</button>&nbsp;
>           <button onClick={this.incrementAsync}>异步加</button>&nbsp;
>         </div>
>       )
>     }
>   
>   }
>   
>   
>   //使用connect()()创建并暴露一个Count的容器组件
>   //使用connect(传入状态,操作状态方法)(UI组件)
>   export default connect(
>     state => ({
>       count: state.count,
>       personCount: state.persons.length
>     }),
>     {increment, decrement, incrementAsync}
>   )(Count)
>   
>   ```
>
>2. `Person`文件夹下的jsx
>
>   ```jsx
>   import React, { Component } from 'react'
>   import { connect } from 'react-redux'
>   import { addPerson } from '../../redux/actions/person'
>   import { nanoid } from 'nanoid'
>   //创建UI组件
>   class Person extends Component {
>     addPerson = () => {
>       const name = this.nameNode.value
>       const age = this.ageNode.value * 1
>       const personObj = { id: nanoid(), name, age }
>       this.props.addPerson(personObj)
>       this.nameNode.value = ''
>       this.ageNode.value = ''
>     }
>   
>     render() {
>       return (
>         <div>
>           <h2>我是Person组件,上方组件求和为{this.props.count}</h2>
>           <input ref={c => this.nameNode = c} type="text" placeholder="输入名字" />
>           <input ref={c => this.ageNode = c} type="text" placeholder="输入年龄" />
>           <button onClick={this.addPerson}>添加</button>
>           <ul>
>             {
>               this.props.persons.map((p) => {
>                 return <li key={p.id}>{p.name}--{p.age}</li>
>               })
>             }
>           </ul>
>         </div>
>       )
>     }
>   }
>   export default connect(
>     state => ({
>       persons: state.persons,
>       count: state.count
>     }), { addPerson }
>   )(Person)
>   
>   ```

# Ⅷ-React 拓展

## 1、 setState

### setState更新状态的2种写法

>(1). setState(stateChange, [callback])------对象式的setState
>   1.stateChange为状态改变对象(该对象可以体现出状态的更改)
>   2.callback是可选的回调函数, 它在状态更新完毕、界面也更新后(render调用后)才被调用
>
>(2). setState(updater, [callback])------函数式的setState
>
>- updater为返回stateChange对象的函数。
>- updater可以接收到state和props。
>- callback是可选的回调函数, 它在状态更新、界面也更新后(render调用后)才被调用。
>
>总结:
>		1.对象式的setState是函数式的setState的简写方式(`语法糖`)
>		2.使用原则：
>				(1).如果新状态不依赖于原状态 ===> 使用对象方式
>				(2).如果新状态依赖于原状态 ===> 使用函数方式
>				(3).如果需要在setState()执行后获取最新的状态数据, 
>					要在第二个callback函数中读取
>
>```js
>import React, { Component } from 'react'
>export default class Demo extends Component {
>state = { count: 0 }
>add = () => {
>//对象式的setState
>/* //1.获取原来的count值
>const {count} = this.state
>//2.更新状态
>this.setState({count:count+1},()=>{ console.log(this.state.count); })
>//console.log('12行的输出',this.state.count); //0 */
>//函数式的setState
>this.setState(state => ({ count: state.count + 1 }))
>}
>render() {
>return (
> <div>
>   <h1>当前求和为：{this.state.count}</h1>
>   <button onClick={this.add}>点我+1</button>
> </div>
>)}}
>```



------



## 2、lazyLoad

### 路由组件的lazyLoad

>1. 懒加载中的组件,随用随调,不会提前加载
>2. 使用懒加载时需要给定一个`fallback`,用于请求过慢或者请求不到组件时显示,通常为`组件`(也可以直接为一个`虚拟DOM`)
>3. `fallback`如果是指定为一个组件,则该组件一定不能指定为`懒加载组件`,就正常引入的那种组件即可

```js
//	import Loading from './Loading' // 用于指定`fallback`
//1.通过React的lazy函数配合import()函数动态加载路由组件 ===> 路由组件代码会被分开打包
	const Login = lazy(()=>import('@/pages/Login'))
	//2.通过<Suspense>指定在加载得到路由打包文件前显示一个自定义loading界面
	<Suspense fallback={<h1>loading.....</h1>}>
    //<Suspense fallback={<Loading/>}>   指定为组件                 
        <Switch>
            <Route path="/xxx" component={Xxxx}/>
            <Redirect to="/login"/>
        </Switch>
    </Suspense>
```



------



## 3、Hooks

> 详见隔壁文件夹`React Hooks`笔记

#### 1. React Hook/Hooks是什么?

>(1). Hook是React 16.8.0版本增加的新特性/新语法
>(2). 可以让你在函数组件中使用 state 以及其他的 React 特性

#### 2. 三个常用的Hook

>(1). State Hook: React.useState()
>(2). Effect Hook: React.useEffect()
>(3). Ref Hook: React.useRef()

#### 3. State Hook

>(1). State Hook让函数组件也可以有state状态, 并进行状态数据的读写操作
>(2). 语法: const [xxx, setXxx] = React.useState(initValue)  
>(3). useState()说明:
>        参数: 第一次初始化指定的值在内部作缓存
>        返回值: 包含2个元素的数组, 第1个为内部当前状态值, 第2个为更新状态值的函数
>(4). setXxx()2种写法:
>        setXxx(newValue): 参数为非函数值, 直接指定新的状态值, 内部用其覆盖原来的状态值
>        setXxx(value => newValue): 参数为函数, 接收原本的状态值, 返回新的状态值, 内部用其覆盖原来的状态值

#### 4. Effect Hook

>(1). Effect Hook 可以让你在函数组件中执行副作用操作(用于模拟类组件中的生命周期钩子)
>(2). React中的副作用操作:
>        发ajax请求数据获取
>        设置订阅 / 启动定时器
>        手动更改真实DOM
>(3). 语法和说明: 
>        useEffect(() => { 
>          // 在此可以执行任何带副作用操作
>          return () => { // 在组件卸载前执行
>            // 在此做一些收尾工作, 比如清除定时器/取消订阅等
>          }
>        }, [stateValue]) // 如果指定的是[], 回调函数只会在第一次render()后执行
>    
>(4). 可以把 useEffect Hook 看做如下三个函数的组合
>        componentDidMount()
>        componentDidUpdate()
>    	componentWillUnmount() 

#### 5. Ref Hook

>(1). Ref Hook可以在函数组件中存储/查找组件内的标签或任意其它数据
>(2). 语法: const refContainer = useRef()
>(3). 作用:保存标签对象,功能与React.createRef()一样
>
>```js
>	myRef = React.createRef()
>	show = ()=>{
>		alert(this.myRef.current.value)
>	}
>```



------



## 4、 Fragment

>1. 作用:可以不用必须有一个真实的DOM根标签了
>
>2. 当你不得不使用一个`容器`去包裹dom元素--jsx语法要求,以往我们做法是直接包一层`div`
>
>   1. 使用`Fragment`后可以`取代div`,但是编译后会被react丢弃,所以不会造成没必要的层级嵌套
>
>   2. 效果等同于直接写一个`空标签<></>`,但是二者有区别
>
>      `区别`:`Fragment`可以添加`key`属性作为唯一标识,而空标签一点属性都不能加
>
>```jsx
>import React, { Component,Fragment } from 'react'
>
>export default class Demo extends Component {
>	render() {
>		return (
>			<Fragment key={1}> 
>				<input type="text"/>
>				<input type="text"/>
>			</Fragment>
>		)
>	}
>}
>```



## 5、Context

> 一种组件间通信方式, 常用于【祖组件】与【后代组件】间通信
>
> 1) 创建Context容器对象：
>
> ```jsx
> 	const XxxContext = React.createContext()  
> ```
>
> 2) 渲染子组时，外面包裹`xxxContext.Provider`, 通过value属性给后代组件传递数据：
>
> ```jsx
> <xxxContext.Provider value={数据}>
> 		子组件
>  </xxxContext.Provider>
> ```
>
> 3) 后代组件读取数据：`两种方法`
>
> ```jsx
> 	//第一种方式:仅适用于类组件 
> ​	  static contextType = xxxContext  // 声明接收context
> ​	  this.context // 读取context中的value数据
> 
> ​	//第二种方式: 函数组件与类组件都可以
> ​	  <xxxContext.Consumer>
> ​	    {
> ​	      value => ( // value就是context中的value数据
> ​	        要显示的内容
> ​	      )
> ​	    }
> ​	  </xxxContext.Consumer>
> ```
>
> 注意:在应用开发中`一般不用context`, 一般都用它的封装react插件
>
> 4)完整例子:
>
> ```jsx
> //------------------- 完整例子 ------------------------------------------------
> import React, { Component } from 'react'
> import './index.css'
> //创建Context对象
> const MyContext = React.createContext()
> const {Provider,Consumer} = MyContext
> export default class A extends Component {
> 
> 	state = {username:'tom',age:18}
> 
> 	render() {
> 		const {username,age} = this.state
> 		return (
> 			<div className="parent">
> 				<h3>我是A组件</h3>
> 				<h4>我的用户名是:{username}</h4>
> 				<Provider value={{username,age}}>
> 					<B/>
> 				</Provider>
> 			</div>
> 		)
> 	}
> }
> 
> class B extends Component {
> 	render() {
> 		return (
> 			<div className="child">
> 				<h3>我是B组件</h3>
> 				<C/>
> 			</div>
> 		)
> 	}
> }
> 
> /* class C extends Component {
> 	//声明接收context
> 	static contextType = MyContext
> 	render() {
> 		const {username,age} = this.context
> 		return (
> 			<div className="grand">
> 				<h3>我是C组件</h3>
> 				<h4>我从A组件接收到的用户名:{username},年龄是{age}</h4>
> 			</div>
> 		)
> 	}
> } */
> 
> function C(){
> 	return (
> 		<div className="grand">
> 			<h3>我是C组件</h3>
> 			<h4>我从A组件接收到的用户名:
> 			<Consumer>
> 				{value => `${value.username},年龄是${value.age}`} //也可以返回标签
> 			</Consumer>
> 			</h4>
> 		</div>
> 	)
> }
> ```

------



## 6、组件优化 --`PureComponent`

>**Ⅰ-`Component的2个问题`**
>
>1. 只要执行setState(),即使不改变状态数据, 组件也会重新render() ==> 效率低
>2. 只当前组件重新render(), 就会自动重新render子组件，纵使子组件没有用到父组件的任何数据 ==> 效率低
>
>**Ⅱ-效率高的做法:**
>
>只有当组件的state或props数据发生改变时才重新render()
>
>**Ⅲ-原因解析**
>
>Component中的shouldComponentUpdate()总是返回true

#### 优化解决

>办法1: 
>	`重写shouldComponentUpdate()`方法
>	比较新旧state或props数据, 如果有变化才返回true, 如果没有返回false
>办法2:  
>	使用`PureComponent`
>	PureComponent重写了shouldComponentUpdate(), 只有state或props数据有变化才返回true
>	注意: 
>		只是进行state和props数据的`浅比较`, 如果只是数据对象内部数据变了, 返回false  
>		不要直接修改state数据, 而是要`产生新数据`
>项目中一般使用PureComponent来优化
>
>**优化代码示例:**
>
>```jsx
>import React, { PureComponent } from 'react'
>import './index.css'
>export default class Parent extends PureComponent {
>  state = { carName: "奔驰c36", stus: ['小张', '小李', '小王'] }
>  addStu = () => {
>    /* const {stus} = this.state
>    stus.unshift('小刘')
>    this.setState({stus}) */
>    const { stus } = this.state
>    this.setState({ stus: ['小刘', ...stus] })
>  }
>
>  changeCar = () => {
>    //this.setState({carName:'迈巴赫'})
>
>    const obj = this.state
>    obj.carName = '迈巴赫'
>    console.log(obj === this.state);
>    this.setState(obj)
>  }
>
>  /* shouldComponentUpdate(nextProps,nextState){
>    // console.log(this.props,this.state); //目前的props和state
>    // console.log(nextProps,nextState); //接下要变化的目标props，目标state
>    return !this.state.carName === nextState.carName
>  } */
>
>  render() {
>    console.log('Parent---render');
>    const { carName } = this.state
>    return (
>      <div className="parent">
>        <h3>我是Parent组件</h3>
>        {this.state.stus}&nbsp;
>        <span>我的车名字是：{carName}</span><br />
>        <button onClick={this.changeCar}>点我换车</button>
>        <button onClick={this.addStu}>添加一个小刘</button>
>        <Child carName="奥拓" />
>      </div>
>    )
>  }
>}
>
>class Child extends PureComponent {
>  /* shouldComponentUpdate(nextProps,nextState){
>    console.log(this.props,this.state); //目前的props和state
>    console.log(nextProps,nextState); //接下要变化的目标props，目标state
>    return !this.props.carName === nextProps.carName
>  } */
>  render() {
>    console.log('Child---render');
>    return (
>      <div className="child">
>        <h3>我是Child组件</h3>
>        <span>我接到的车是：{this.props.carName}</span>
>      </div>
>    )
>  }
>}
>```

------

## 7、 render props  ---类似vue插槽

>1. 如何向组件内部动态传入带内容的结构(标签)?
>
>   Vue中: 
>   	使用slot技术, 也就是通过组件标签体传入结构  <A><B/></A>
>   React中:
>   	使用children props: 通过组件标签体传入结构
>   	使用render props: 通过组件标签属性传入结构,而且可以携带数据，一般用render函数属性
>
>2. children props
>
>   ```jsx
>   <A>
>     <B>xxxx</B>
>   </A>
>   {this.props.children}
>   问题: 如果B组件需要A组件内的数据, ==> 做不到 
>   ```
>
>3. render props
>
>   ```jsx
>   <A render={(data) => <C data={data}></C>}></A>
>   A组件: {this.props.render(内部state数据)}
>   C组件: 读取A组件传入的数据显示 {this.props.data}
>   ```
>
>4. 示例
>
>   ```jsx
>   import React, { Component } from 'react'
>   import './index.css'
>   import C from '../1_setState'
>   
>   export default class Parent extends Component {
>   	render() {
>   		return (
>   			<div className="parent">
>   				<h3>我是Parent组件</h3>
>   				<A render={(name)=><C name={name}/>}/>
>   			</div>
>   		)
>   	}
>   }
>   
>   class A extends Component {
>   	state = {name:'tom'}
>   	render() {
>   		console.log(this.props);
>   		const {name} = this.state
>   		return (
>   			<div className="a">
>   				<h3>我是A组件</h3>
>   				{this.props.render(name)}
>   			</div>
>   		)
>   	}
>   }
>   
>   class B extends Component {
>   	render() {
>   		console.log('B--render');
>   		return (
>   			<div className="b">
>   				<h3>我是B组件,{this.props.name}</h3>
>   			</div>
>   		)
>   	}
>   }
>   
>   ```

------

## 8、错误边界

>1. 理解：
>
>​	错误边界(Error boundary)：用来捕获后代组件错误，渲染出备用页面
>
>2. 特点：
>
>​	`只能捕获后代组件生命周期`产生的错误，`不能捕获自己组件`产生的错误和其他组件在合成事件、定时器中产生的错误
>
>3. getDerivedStateFromError配合componentDidCatch
>
>   ```jsx
>   // 生命周期函数，一旦后台组件报错，就会触发
>   static getDerivedStateFromError(error) {
>       console.log(error);
>       // 在render之前触发
>       // 返回新的state
>       return {
>           hasError: true,
>       };
>   }
>   
>   componentDidCatch(error, info) {
>       // 统计页面的错误。发送请求发送到后台去
>       console.log(error, info);
>   }
>   ```
>
>4. 代码示例
>
>   ```jsx
>   import React, { Component } from 'react'
>   import Child from './Child'
>   
>   export default class Parent extends Component {
>   
>     state = {
>       hasError: '' //用于标识子组件是否产生错误
>     }
>   
>     //当Parent的子组件出现报错时候，会触发getDerivedStateFromError调用，并携带错误信息
>     static getDerivedStateFromError(error) {
>       console.log('@@@', error);
>       return { hasError: error }
>     }
>   
>     componentDidCatch() {
>       console.log('此处统计错误，反馈给服务器，用于通知编码人员进行bug的解决');
>     }
>   
>     render() {
>       return (
>         <div>
>           <h2>我是Parent组件</h2>
>           {this.state.hasError ? <h2>当前网络不稳定，稍后再试</h2> : <Child />}
>         </div>
>       )
>     }
>   }
>   
>   ```
>
>   

## 9、 组件通信方式总结

>1. 组件间的关系：
>
>- 父子组件
>- 兄弟组件（非嵌套组件）
>- 祖孙组件（跨级组件）
>
>2. 几种通信方式：
>
>    ```js
>    - props：
>         1).children props
>         (2).render props
>    
>    - 消息订阅-发布：
>         ubs-sub、event等等
>    
>    - 集中式管理：
>         edux、dva等等
>    
>    - conText:
>         产者-消费者模式
>    ```
>
>3. 比较好的搭配方式
>
>    ```js
>    - 父子组件：props
>    - 兄弟组件：消息订阅-发布、集中式管理
>    - 祖孙组件(跨级组件)：消息订阅-发布、集中式管理、conText(开发用的少，封装插件用的多)
>    ```



# Ⅸ-组件间通信示例

## 1、兄弟间传值方式1 --> [子传父、父传子]

>1. 父组件定义一个[`状态`]或[`方法`],其中[方法]能修改[状态]
>
>   - 将[方法]传给要进行发送值的子组件,通过继承到的[方法],去修改父组件的[状态]
>   - 将[状态]传给要接受值的子组件,这样就能做到兄弟间传值
>
>2. 代码示例
>
>   ```jsx
>   ----------父组件------------------------
>   class Main extends React.Component<IProps> {
>     constructor(props) {
>       super(props);
>       this.state = { searchParams: {} };
>     }
>     handleIPSearch = (params) => {
>       this.setState({ searchParams: params });
>     };
>     render() {
>       <子组件1:要对组件2进行修改的 handleIPSearch={handleIPSearch}  />
>       <子组件2:要接受值的    searchParams={this.state.searchParams}/>
>     }
>   }
>   --------------子组件1----------------------
>   const ManageTable = (props: IProps) => {
>    const {  handleIPSearch } = props;
>    return(
>        //此处即可调用修改父组件状态的函数
>       <a onClick={() => {   handleIPSearch(data) }} >
>       对父组件值进行修改,间接改变组件2接收到的值
>     </a>)
>   }
>   --------------子组件2----------------------
>   const IPInfo: FC = (props) => {
>       //此处就能使用父组件的状态
>     const { searchParams } = props;
>       return( <span>searchParams</span> )    
>   }
>   ```



## 2、兄弟间传值方式2 -->[mitt(发布订阅者模式)]

>此方法用的是[`mitt`]实现,其实本质上就是注册一个全局变量进行监听 --> [mitt源码地址](https://github.com/developit/mitt)
>
>可以自己实现,此处因为人家写的不错了,就以此作为例子
>
>1. 安装或者直接复制使用
>
>   ```sh
>   npm install --save mitt
>   ```
>
>2. 使用示例
>
>   ```tsx
>   -------------- 首先要定义一个公用全局变量  --------------------------
>   //文件 utils/index.ts
>   import mitt from './mitt';
>   //此处声明,将其变为全局变量
>   const eventBus = mitt();
>   export { eventBus }
>   ---------------- 发送值的组件(要修改别人的组件)  ---------------------
>   //导入共有变量
>   import { eventBus } from '~/utils';
>     <a
>     onClick={() => {
>   	//延迟发送是本人此之前有一个跳转动作,跳转到接收方组件
>       // 防止修改了值的时候但是接收组件未注册  正常情况直接发送即可     
>       //setTimeout(() => {
>       // eventBus.emit('foo', data);
>       //}, 100);
>       eventBus.emit('foo', data);    
>      }}
>     />;
>       
>   ------------------ 接受方组件(接受发送方的组件)  -------------------------------------
>       
>   const Search: FC<IProps> = (props) => {
>     useEffect(() => {
>       //替换为mitt写法,此时已经接收到了
>       eventBus.on('foo', (searchParams) => {console.log('接受到值了',searchParams) }
>       });
>     }, []);
>   } 
>   ```
>
>3. mitt源码
>
>   ```ts
>   export type EventType = string | symbol;
>   
>   // An event handler can take an optional event argument
>   // and should not return a value
>   export type Handler<T = unknown> = (event: T) => void;
>   export type WildcardHandler<T = Record<string, unknown>> = (
>     type: keyof T,
>     event: T[keyof T]
>   ) => void;
>   
>   // An array of all currently registered event handlers for a type
>   export type EventHandlerList<T = unknown> = Array<Handler<T>>;
>   export type WildCardEventHandlerList<T = Record<string, unknown>> = Array<
>     WildcardHandler<T>
>   >;
>   
>   // A map of event types and their corresponding event handlers.
>   export type EventHandlerMap<Events extends Record<EventType, unknown>> = Map<
>     keyof Events | '*',
>     EventHandlerList<Events[keyof Events]> | WildCardEventHandlerList<Events>
>   >;
>   
>   export interface Emitter<Events extends Record<EventType, unknown>> {
>     all: EventHandlerMap<Events>;
>   
>     on: (<Key extends keyof Events>(type: Key, handler: Handler<Events[Key]>) => void) & ((type: '*', handler: WildcardHandler<Events>) => void);
>   
>     off: (<Key extends keyof Events>(
>       type: Key,
>       handler?: Handler<Events[Key]>
>     ) => void) & ((type: '*', handler: WildcardHandler<Events>) => void);
>   
>     emit: (<Key extends keyof Events>(type: Key, event: Events[Key]) => void) & (<Key extends keyof Events>(
>       type: undefined extends Events[Key] ? Key : never
>     ) => void);
>   }
>   
>   /**
>    * Mitt: Tiny (~200b) functional event emitter / pubsub.
>    * @name mitt
>    * @returns {Mitt}
>    */
>   export default function mitt<Events extends Record<EventType, unknown>>(
>     all?: EventHandlerMap<Events>
>   ): Emitter<Events> {
>     type GenericEventHandler =
>       | Handler<Events[keyof Events]>
>       | WildcardHandler<Events>;
>     all = all || new Map();
>   
>     return {
>       /**
>        * A Map of event names to registered handler functions.
>        */
>       all,
>   
>       /**
>        * Register an event handler for the given type.
>        * @param {string|symbol} type Type of event to listen for, or `'*'` for all events
>        * @param {Function} handler Function to call in response to given event
>        * @memberOf mitt
>        */
>       on<Key extends keyof Events>(type: Key, handler: GenericEventHandler) {
>         const handlers: Array<GenericEventHandler> | undefined = all!.get(type);
>         if (handlers) {
>           handlers.push(handler);
>         } else {
>           all!.set(type, [handler] as EventHandlerList<Events[keyof Events]>);
>         }
>       },
>   
>       /**
>        * Remove an event handler for the given type.
>        * If `handler` is omitted, all handlers of the given type are removed.
>        * @param {string|symbol} type Type of event to unregister `handler` from, or `'*'`
>        * @param {Function} [handler] Handler function to remove
>        * @memberOf mitt
>        */
>       off<Key extends keyof Events>(type: Key, handler?: GenericEventHandler) {
>         const handlers: Array<GenericEventHandler> | undefined = all!.get(type);
>         if (handlers) {
>           if (handler) {
>             handlers.splice(handlers.indexOf(handler) >>> 0, 1);
>           } else {
>             all!.set(type, []);
>           }
>         }
>       },
>   
>       /**
>        * Invoke all handlers for the given type.
>        * If present, `'*'` handlers are invoked after type-matched handlers.
>        *
>        * Note: Manually firing '*' handlers is not supported.
>        *
>        * @param {string|symbol} type The event type to invoke
>        * @param {Any} [evt] Any value (object is recommended and powerful), passed to each handler
>        * @memberOf mitt
>        */
>       emit<Key extends keyof Events>(type: Key, evt?: Events[Key]) {
>         let handlers = all!.get(type);
>         if (handlers) {
>           (handlers as EventHandlerList<Events[keyof Events]>)
>             .slice()
>             .map((handler) => {
>               handler(evt!);
>             });
>         }
>   
>         handlers = all!.get('*');
>         if (handlers) {
>           (handlers as WildCardEventHandlerList<Events>)
>             .slice()
>             .map((handler) => {
>               handler(type, evt!);
>             });
>         }
>       },
>     };
>   }
>   ```























