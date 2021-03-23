>本笔记为本人`洪`系统学习React阶段笔记-观看`尚硅谷2021版React技术全家桶全套完整版` 整理而成
>
>
>
>始于:2021-2-3  暂停于:2021-2-4(补充webpack、ajax、Promise、axios知识以及过年放假)~3-22  3-22~`更新中`	 

# React系统学习笔记(`更新中 `)

------

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
/**
下面的this指的是组件实例,我直接this.input1 = c 意思是给实例上的input1赋值,之后直接通过调用打印得到
*/
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
	/* 
				React.createRef调用后可以返回一个容器，该容器可以存储被ref所标识的节点,该容器是“专人专用”的
			 */
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
		//初始化状态
			state = {
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
>      1. constructor()
>
>      2. compinentWillMount()
>
>      3. render()
>
>      4. componentDidMount() ==>`常用` 组件将要渲染
>
>    一般在这个钩子中做一些初始化的事情,如:开启定时器,发送网络请求,订阅消息等
>
>2. 更新阶段:由组件内部的this.setState()或者父组件的render触发
>
>      1. shouldComponentUpdate() 组件应该更新
>      2. componentWillUpdate() 组件将要更新
>      3. render()   ===>`必须使用`的一个
>      4. componentDidUpdate() 组件将要更新
>
>3. 卸载组件:由ReactDOM.unmountComponentAtNode(`卸载节点上的组件`)触发
>
>      1. componentWillUnmount() ===>`常用` 组件将要卸载
>
>    一般在这个钩子中做一些首位的事情,如:关闭定时器,取消订阅等

### 2、React生命周期(新)

>1. 初始化阶段:由ReactDOM.render()触发 ---初次渲染
>
>      1. constructor()
>      2. getDerivedStateFromProps() 从Props获得派生状态
>      3. render()
>      4. componentDidMount() ====>`常用` 
>
>2. 更新阶段:由组件内部的this.setState()或者父组件的render触发
>
>      1. getDerivedStateFromProps()  从Props获得派生状态
>      2. shouldComponentUpdate() 组件应该更新
>      3. render()
>      4. getSnapshotBeforeUpdate() 在更新前获得快照
>      5. componentDidUpdate()
>
>3. 卸载组件:由ReactDOM.unmountComponentAtNode()触发
>
>      1. componentWillUnmount() ===>`常用`
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

```js
	慢动作回放----使用index索引值作为key

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

	慢动作回放----使用id唯一标识作为key

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

>\1. 拆分组件: 拆分界面,抽取组件
>
>\2. 实现静态组件: 使用组件实现静态页面效果
>
>\3. 实现动态组件
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
>​	--》if(todoObj.id === id) return `{...todoObj,done}`
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
>      1. ps:当你请求`http://localhost:5000`产生跨域(本身在3000端口)时,添加此代码, 之后你请求时用`http://localhost:3000`进行请求,当其在`3000`端口中找不到资源时将会自动转发至`5000`端口进行请求,不产生跨域问题
>      2. 优点：配置简单，前端请求资源时可以不加任何前缀。
>      3. 缺点：不能配置多个代理
>      4. 工作方式：上述方式配置代理，当请求了3000不存在的资源时，那么该请求会转发给5000 （优先匹配前端资源）
>2. 方法二: 在src下创建配置文件：`src/setupProxy.js`
>      1. ps:必须是这个文件名,react项目运行的时候会自动查找这个文件,并将其加入webpack的配置中,所以当你修改此文件后,你需要重新启动项目
>      2. 优点：可以配置多个代理，可以灵活的控制请求是否走代理。
>      3. 缺点：配置繁琐，前端请求资源时必须加前缀。
>
>```JS
> const proxy = require('http-proxy-middleware')
>   module.exports = function(app) {
>     app.use(
>       proxy('/api1', {  //api1是需要转发的请求(所有带有/api1前缀的请求都会转发给5000)
>         target: 'http://localhost:5000', //配置转发目标地址(能返回数据的服务器地址)
>         changeOrigin: true, //控制服务器接收到的请求头中host字段的值
>         /*
>         	changeOrigin设置为true时，服务器收到的请求头中的host为：localhost:5000
>         	changeOrigin设置为false时，服务器收到的请求头中的host为：localhost:3000
>         	changeOrigin默认值为false，但我们一般将changeOrigin值设为true
>         */
>         pathRewrite: {'^/api1': ''} //去除请求前缀，保证交给后台服务器的是正常请求地址(必须配置)
>       }),
>       proxy('/api2', { 
>         target: 'http://localhost:5001',
>         changeOrigin: true,
>         pathRewrite: {'^/api2': ''}
>       })
>     )
>   }
>```
>

### 2、补充知识点

#### Ⅰ-ES6小知识点:`连续赋值解构`+重命名

>```js
>	let obj = {a:{b:1}}
>	const {a} = obj; //传统解构赋值
>	const {a:{b}} = obj; //连续解构赋值
>	const {a:{b:value}} = obj; //连续解构赋值+重命名
>```

#### Ⅱ-消息订阅与发布机制 --->  工具库: PubSubJS

> 1.先订阅，再发布（理解：有一种隔空对话的感觉）
>
> 2.适用于任意组件间通信
>
> 3.要在组件的componentWillUnmount中取消订阅
>
> ```js
> 下载: npm install pubsub-js --save
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

#### Ⅲ-defaultChecked 、 checked的区别

>注意defaultChecked 和 checked的区别，类似的还有：defaultValue 和 value

### 3、`fetch`发送请求

> 概念:`关注分离`的设计思想

>1. Fetch 是浏览器提供的原生 AJAX 接口。
>
>  由于原来的XMLHttpRequest`不符合关注分离原则`，且基于事件的模型在处理异步上已经没有现代的Promise等那么有优势。因此Fetch出现来解决这种问题。
>
>2. 特点:
>
>   1. fetch: `原生函数`，不再使用XmlHttpRequest对象提交ajax请求
>
>   2. 老版本浏览器可能不支持
>
>   3. 使用 fetch 无法`取消一个请求`。这是因为Fetch API`基于 Promise`，而Promise无法做到这一点。由于Fetch是典型的异步场景，所以大部分遇到的问题不是 Fetch 的，其实是 Promise 的。
>
>   4. 如果直接使用`fetch`,返回的并不是直接的结果它只是一个`HTTP响应`，而不是真的数据。想要获取数据,方法有二:
>
>      ① 使用async+await获取
>
>      ② 使用promise的链式调用,再第一个then中将其返回,再下个then中在使用
>
>3. 代码示例
>
>```js
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















