>本人的React学习笔记分类(也是对应本人技术成长过程):[[`想快速入门看这部分`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React基础补充学习笔记)]、[[`想对React系统全面进行学习的同学看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/Scss%E7%AC%94%E8%AE%B0)]、[[`对基础学习完成且有了一定开发经验,想尝试解析源码的看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React深入学习与源码解析笔记)]

# 一、Props

> 父传递给子组件数据,单向流动,不能子传递给父亲
>
> props的传值,可以是任意的类型
>
> props 可以设置默认值
>
> ```jsx
> static defaultProps={name:”红吉林”，msg：“helloworld” }
> ```

注意：props可以传递函数，props可以传递父元素的函数，就可以去修改父元素的state,从而达到传递数据给父元素。

## 1、父传子数据传递案例

```jsx
//在父元素中使用state去控制子元素props的从而达到父元素数据传递给子元素
class ParentCom extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            isActive:true
        }
        this.changeShow = this.changeShow.bind(this)
    }

    render(){
        return (
            <div>
                <button onClick={this.changeShow}>控制子元素显示</button>
                <ChildCom isActive={this.state.isActive} />
            </div>
        )
    }

    changeShow(){
        this.setState({
            isActive:!this.state.isActive
        })
    }
}

//孩子类
class ChildCom extends React.Component{
    constructor(props){
        super(props)
 }
    render(){
        let strClass = null;
        // if(this.props.isActive){
        //     strClass = ' active'
        // }else{
        //     strClass = ""
        // }
        strClass = this.props.isActive?" active":"";

        return (
            <div className={"content"+strClass}>
                <h1>我是子元素</h1>
            </div>
        )
    }
}

ReactDOM.render(
    <ParentCom />,
    document.querySelector("#root")
)

```

## 2、React数据传递:子传父

> 调用父类的函数从而操作父元素的数据,从而实现数据从子元素传递至父元素

```jsx
import React from 'react';
import ReactDOM from 'react-dom';

//子传父
/*********  父类 ********************/
class ParentCom extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            childData:null
        }
    }

    render(){
       return (
           <div>
                <h1>子元素传递给父元素的数据：{this.state.childData}</h1>
               <ChildCom setChildData={this.setChildData} />
           </div>
       ) 
    }
    setChildData=(data)=>{
        this.setState({
            childData:data
        })
    }
}
/***   子类   **/
class ChildCom extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            msg:"helloworld"
        }
    }
    render(){
        return (
            <div>
                <button onClick={this.sendData}>传递helloworld给父元素</button>
                <button onClick={()=>{this.props.setChildData('直接调用props的函数')}}>传递helloworld给父元素</button>
            
            </div>
        )
    }
    sendData=()=>{
        //console.log(this.state.msg)
        //将子元素传递给到父元素，实际就是调用父元素传递进来的父元素函数
        this.props.setChildData(this.state.msg)
    }
}

ReactDOM.render(
    <ParentCom />,
    document.querySelector('#root')
)
```

# 二、React事件

## 1、事件特点:

> 特点: 1. react事件,绑定事件的命名,驼峰命名法
>
> ​	 2. {}传入一个函数,而不是一个字符串

```jsx
<button onClick={this.sendData}>传递helloworld给父元素</button>
```

## 2、**React 合成事件和原生 DOM 事件的主要区别:**

（1）React 组件上声明的事件没有绑定在 React 组件对应的原生 DOM 节点上。

（2）React 利用事件委托机制，将几乎所有事件的触发代理（delegate）在 document 节点上，事件对象(event)是合成对象(SyntheticEvent)，不是原生事件对象，但通过 nativeEvent 属性访问原生事件对象。

（3）由于 React 的事件委托机制，React 组件对应的原生 DOM 节点上的事件触发时机总是在 React 组件上的事件之前。

   (4)  React返回的事件对象是代理的原生事件对象,直接查看其实都是null 如果想要查看事件的具体值,必须直接输出事件的属性

## 3、阻止默认事件行为:e.preventDefault()

>原生，阻止默认行为时，可以直接返回return false；(比如from表单默认提交跳转页面 但我只要里面的按钮事件,而不触发外部from表单提交事件)
>
>React中，阻止默认必须e.preventDefault();

## 4、事件传参

> 利用es6箭头函数this指向特点绑定事件指向

```jsx
{/* 使用ES6箭头函数传递多个参数 */}
<button  onClick={(e)=>{this.parentEvent1('msg:helloworld',e)}}>提交</button>
{/* //不使用ES6箭头函数传递多个参数的方式 */}
<button  onClick={function(e){this.parentEvent1('不使用es6,msg:helloworld',e)}.bind(this)}>提交</button>
```

# 三、条件渲染

> React中的条件渲染即和JavaScript中的,条件运算,如if...else...三元运算符等
>
> 1. 直接通过条件运算返回要渲染的对象
> 2. 通过条件运算得出jsx对象,在将jsx对象渲染到模板中

## 1、案例一

```jsx
mport React from 'react';
import ReactDOM from 'react-dom';

function UserGreet(props){
    return (<h1>欢迎登陆</h1>)
}

function UserLogin(props){
    return (<h1>请先登录</h1>)
}

class ParentCom extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            isLogin:true
        }
    }
    render(){
        if(this.state.isLogin){
            return (<UserGreet></UserGreet>)
        }else{
            return (<UserLogin></UserLogin>)
        }
    }
}

ReactDOM.render(
    <ParentCom></ParentCom>,
    document.querySelector('#root')
)

```

## 2、案例二

```jsx
import React from 'react';
import ReactDOM from 'react-dom';

function UserGreet(props){
    return (<h1>欢迎登陆</h1>)
}

function UserLogin(props){
    return (<h1>请先登录</h1>)
}

class ParentCom extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            isLogin:false
        }
    }
    render(){
        let element = null;
        if(this.state.isLogin){
            element = <UserGreet></UserGreet>;
        }else{
            element = (<UserLogin></UserLogin>);
        }

      
        return (
            <div>
                <h1>这是头部</h1>
                {element}
                <h1>这是三元运算符的操作</h1>
                {this.state.isLogin?<UserGreet></UserGreet>:<UserLogin></UserLogin>}
                <h1>这是尾部</h1>
            </div>
        )
    }
}

ReactDOM.render(
    <ParentCom></ParentCom>,
    document.querySelector('#root')
)

```



# 四、列表渲染

> 将列表内容瓶装成数组放置到模板中,并将数据拼装成数组的jsx对象

## 1、简单案例一:

```jsx
import React from 'react';
import ReactDOM from 'react-dom';

class Welcome extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            list:[
                {
                    title:"第一节 React事件",
                    content:"事件内容"
                },
                {
                    title:"第二节 React数据传递",
                    content:"数据传递内容",
                },
                {
                    title:"第三节 条件渲染",
                    content:"条件渲染内容",
                }
            ]
        }
    }
    render(){
        let listArr = [];
        for(let i=0;i<this.state.list.length;i++){
            let item = (
                <li>
                    <h3>{this.state.list[i].title}</h3>
                    <p>{this.state.list[i].content}</p>
                </li>
            )
            listArr.push(item)
        }
        return (
            <div>
                <h1>
                    今天课程内容
                </h1>

                <ul>
           
                    {listArr}
                    <li>
                        <h3>这是标题</h3>
                        <p>内容</p>
                    </li>
                </ul>

            </div>
        )
    }
}
ReactDOM.render(
    <Welcome></Welcome>,
    document.query

```

## 2、复杂案例二: 

```jsx

import React from 'react';
import ReactDOM from 'react-dom';

function ListItem(props){
    return (
        <li>
            <h3>{props.index+1}:listItem:{props.data.title}</h3>
            <p>{props.data.content}</p>
        </li>
    )
}

class ListItem2 extends React.Component{
    constructor(props){
        super(props)
    }
    render(){
        return (
            <li onClick={(event)=>{this.clickEvent(
                this.props.index,
                this.props.data.title,
                event
                )}}>
                <h3>{this.props.index+1}:listItem:{this.props.data.title}</h3>
                <p>{this.props.data.content}</p>
            </li>
        )
    }
    clickEvent=(index,title,event)=>{
        alert((index+1)+"-"+title)
    }
}


class Welcome extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            list:[
                {
                    title:"第一节 React事件",
                    content:"事件内容"
                },
                {
                    title:"第二节 React数据传递",
                    content:"数据传递内容",
                },
                {
                    title:"第三节 条件渲染",
                    content:"条件渲染内容",
                }
            ]
        }
    }

    render(){
        let listArr = this.state.list.map((item,index)=>{
            return (
                <ListItem2 key={index} data={item} index={index}></ListItem2>
                
            )
        })
        
        return (
            <div>
                <h1>
                    今天课程内容
                </h1>

                <ul>
                    //这里调用了上面的map引用组件
                    {listArr}
                    <li>
                        <h3>这是标题</h3>
                        <p>内容</p>
                    </li>
                </ul>

                <h1>复杂没有用组件完成列表</h1>
                <ul>
                {
                    this.state.list.map((item,index)=>{
                        return (
                            <li key={index} onClick={(event)=>{this.clickFn(index,item.title,event)}}>
                                <h3>{index+1}-复杂-{item.title}</h3>
                                <p>{item.content}</p>
                            </li>
                        )
                    })
                }
                </ul>

            </div>
        )
    }

    clickFn=(index,title,event)=>{
        alert((index+1)+"-clickFn-"+title)
    }
}

ReactDOM.render(
    <Welcome></Welcome>,
    document.querySelector('#root')
)


```

# 五、疫情数据渲染

```jsx
import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './06style.css'
import App from './App';
import reportWebVitals from './reportWebVitals';
import jsonData from './feiyan'
//声明一个初始化疫情数据的对象
let provincesObj = {}
jsonData.data.list.forEach((item, index) => {
    //这里需要先初始化为0,因为后面疫情数据是要叠加的
    if (!provincesObj[item.province]) {
        provincesObj[item.province] = {
            confirm: 0,
            heal: 0,
            dead: 0,
        }
    }
    //将为空的对象属性赋值为0
    for (let key of Object.keys(item)) {
        item[key] = item[key] ? item[key] : 0
    }
    //进行同地区数据累加
    provincesObj[item.province] = {
        confirm: provincesObj[item.province].confirm + item.confirm,
        heal: provincesObj[item.province].heal + item.heal,
        dead: provincesObj[item.province].dead + item.dead
    }
})
//将其转换为数组 直接使用Array.from转换不行 因为这个对象没有length属性
//这里使用for..in写法  区别于之前的for...of  forin主要是遍历对象键名,of是元素值
let provincesList = []
for (let key in provincesObj) {
    provincesObj[key].province = key
    provincesList.push(provincesObj[key])
}
//进行数据大小排序
let provincesListSort = provincesList.sort(
    (a, b) => {
        if (a.confirm < b.confirm) return 1
        else return -1
    }
)

//写一个类组件
class Index extends Component {
    constructor() {
        super()
    }
    render() {
        return (
            <div>
                <ul>
                    <li>
                        <span>地区</span>
                        <span>确诊</span>
                        <span>死亡</span>
                        <span>治愈</span>
                    </li>
                    {/*列表数据渲染*/}
                    {
                        this.props.list.map((item, index) => {
                            return (
                                <li key={index}>
                                    <span>{item.province}</span>
                                    <span>{item.confirm}</span>
                                    <span>{item.dead}</span>
                                    <span>{item.heal}</span>
                                </li>
                            )
                        })
                    }
                </ul>
            </div>
        )
    }
}
ReactDOM.render(
    <Index list={provincesListSort}/>,
    document.querySelector('#root')
)
```

# 六、补充知识点:for循环方法



### 1、forEach

> 对数组直接进行循环,相当于直接for循环,没有返回值

### 2、map

> map,对数组每一项进行加工,加工完成后返回一个新的数组

### 3、filter过滤

>filter过滤,就是将想要的东西进行筛选,不要的内容去除,最终返回想要的结果
>
>//通过返回true还是false进行选择，true就是想要，false就是去除。

### 4、reduce整合

>reduce,是对整个数组进行整合，比如你要做一个将数组里所有的数字进行相加
>将数组每一项内容整合后，返回1个内容
>
>第一个参数是一个函数(三个内部参数前一位,当前位置,索引值),第二个参数是第一位的初始值

### 5、for...in和for...on

> for...in...主要用于遍历对象的(遍历对象的key)，不适用于遍历数组,for(key in obj),里面的每项是key
> for...of...可以用来遍历数组，类数组的对象(遍历对象的value,遍历其中的key可以搭配Object.keys(obj))，字符串，set/map,generator,

```js
	let arr = [1,2,3,4,5,6]
			//对数组直接进行循环，相当于直接for循环,没有返回值
			// let result = arr.forEach((item,index,arr)=>{
			// 	console.log(item)
			// 	console.log(index)
			// 	console.log(arr)
			// 	return item
			// })
			//console.log(result)
			
			let arr2 = ['香蕉',"苹果","雪梨"]
			//map,对数组每一项进行加工，加工完成之后返回1个新的数组
			// let result2 = arr2.map((item,index,arr)=>{
			// 	let str = index + item + index
			// 	return str
			// })
			// console.log(result2)
			
			
			let arr3 = [1,2,3,4,5,6,7,8,9];
			//filter过滤，就是讲想要的内容进行筛选，不要内容去除，最终返回想要的内容的数组。
			// let result3 = arr3.filter((item,index)=>{
			// 	if(item%2==0){
			// 		//通过返回true还是false进行选择，true就是想要，false就是去除。
			// 		return true;
			// 	}else{
			// 		return false;
			// 	}
			// })
			// console.log(result3)
			
			//reduce,是对整个数组进行整合，比如你要做一个将数组里所有的数字进行相加
			//将数组每一项内容整合后，返回1个内容
			let arr4 = [1,2,3,4,5,6,7,8,9];
			let result4 =arr4.reduce((pre,next,index)=>{
				console.log(pre);
				console.log(next);
				console.log(index)
				return pre+next
			},0)
			console.log(result4)
			
			
			//for...in...主要用于遍历对象的，不适用于遍历数组,for(key in obj),里面的每项是key
			//for...of...可以用来遍历数组，类数组的对象，字符串，set/map,generator,
			//for(item of arr),里面的是每一项
			
			let obj = {
				name:"老陈",
				type:"帅",
				content:"前端"
			}
			
			for(key in obj){
				console.log("key："+key+";value:"+obj[key])
			}
			
			
			let arr5 = ["范冰冰","李晨","鹿晗"]
			//for of循环的是每一项
			for(let item of arr5){
				console.log(item)
			}
```



















