>本人的React学习笔记分类(也是对应本人技术成长过程):[[`想快速入门看这部分`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React基础补充学习笔记)]、[[`想对React系统全面进行学习的同学看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/Scss%E7%AC%94%E8%AE%B0)]、[[`对基础学习完成且有了一定开发经验,想尝试解析源码的看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React深入学习与源码解析笔记)]

# 壹、React的JSX、组件、state与setState_day11-2

# 一、React入门

## 1、安装与创建项目

> 通过react脚手架创建项目并进行开发部署
>
> ​	①安装脚手架 [Create React App](https://react.docschina.org/docs/create-a-new-react-app.html#create-react-app)
>
> ```
> cnpm i -g create-react-app
> ```
>
> ​	②创建
>
> ```
> create-react-app xxxx(项目名)
> ```

## 2、React元素渲染

```jsx
let h1=<h1>helloworld</h1>
```

> 注意:jsx元素对象,或者组件对象,必须只有一个根节点(根元素)

# 二、React Jsx

## 1、优点

>1. JSX执行更快,编译炜JavaScript代码时进行优化
>2. 类型更安全,编译过程如果出错就不能编译,及时发现错误
>3. JSX编写模板更加简单快捷()
>
>注意点:
>
>1. JSX必须要有根节点
>2. 正常的普通HTML元素要小写,如果是大写,默认是组件

## 2、JSX表达式

1. 由HTML元素构成
2. 中间如果需要插入变量用{}
3. {}中间可以使用表达式
4. {}中间表达式可以使用JSX对象
5. 属性和html内容一样都是用{}来插入内容的

```jsx
import React from 'react';
import ReactDOM from 'react-dom';
import './App.css'

let time = new Date().toLocaleTimeString()
let str = '当前时间是：'
let element = (
    <div>
        <h1>helloworld</h1>
        <h2>{str+time}</h2>
    </div>
)

console.log(element)
let man = '发热';
let element2 = (
    <div>
        <h1>今天是否隔离</h1>
        <h2>{man=="发热"?<button>隔离</button>:"躺床上"}</h2>
    </div>
)

//let man = '发热';
let element4 = (
    <div>
        <span>横着躺</span>
        <span>竖着躺</span>
    </div>
)
man = '正常'
let element3 = (
    <div>
        <h1>今天是否隔离</h1>
        <h2>{man=="发热"?<button>隔离</button>:element4}</h2>
    </div>
)

let color = 'bgRed'
let logo = 'https://www.baidu.com/img/pc_1c6e30772d5e4103103bd460913332f9.png'
//HTML的样式类名要写className,因为class在js当中是关键词
let element5 = (
    <div className={color}>
        <img src={logo} />
        红色的背景颜色
    </div>

)

ReactDOM.render(
    element5,
    document.getElementById('root')

)


```

## 3、JSX_style 样式

### 	1. class,style中,不可以存在多个class属性

```jsx
<div class=’abc’  class={‘active’}> 错误的表示
```

### 	2. stylez样式中,如果存在多个单词的属性组合,第二个单词开始,首字母大写,或者用引号引起来,否则会报错

```jsx
let exampleStyle = {
    background:"skyblue",
    borderBottom:"4px solid red",
    'background-image':"url(https://www.baidu.com/img/pc_1c6e30772d5e4103103bd460913332f9.png)"
}
```

###  	3. 多个类共存的操作

```jsx
let element2 = (
    <div>
        <h1 className={"abc "+classStr}>helloworld</h1>
    </div>
)
let classStr2 = ['abc2','redBg2'].join(" ")
let element3 = (
    <div>
        {/* 这里写注释 */}
        <h1 className={classStr2} style={exampleStyle}>helloworld</h1>
    </div>
)
```

## 	4. 注释

> 必须在括号的表达式内书写，否则报错：{/* 这里写注释 */}

## 5、遇到的问题与解决

##### 1、为什么插值表达式中不能用for...of?

> 报错:必须为插值表达式
>
> 解:for不是插值表达式,是运算表达式

##### 2、下面代码item.item打印出来发现是obj,准备转为数组,结果仍是obj

> 解:这里犯了一个基础的错误,array不是基础数据类型,Array也是obj类型,所以一开始其实就是数组,不用转换

##### 3、由第一个问题引申出来的,for..of不是表达式 那么我要用怎么办?

> 虽然不能直接在插值表达式中使用,但是可以在外部定义函数,然后内部调用

```jsx
function Forof (){
    for( ... of ...)
} 
{
                            this.state.content.map((item,index)=>
                                <div className='item fl' key={index}>
                                    <div className='item-title'>{item.title}</div>
                                    {
                                        item.item.map((item,index)=>
                                        <div className='item-value-fixed' key={index}><a>{item}</a></div>    
                                        ) 
                                        // console.log(typeof Array.from(item.item))
                                        // console.log(typeof item.item)
                                       //问题一：为什么不能直接用forof，报错应为表达式 里面多加一个｛｝就可以   
                                       //问题二：Array.from()转化出来类型还是obj
                                       //typeof [] //object js数据类型本身就是object
                                    }
                                </div>)
                        }
```



# 三、React组件

> 函数组件与类组件的区别和使用,函数式组件比较简单,一般用于静态没有交互时间内容的组件页面.类组件,一般又称为动态组件,那么一般会有交互或者数据修改的操作

## 	1、函数式组件

```jsx
//函数式组件
function Childcom(props){
    console.log(props)
    let title = <h2>我是副标题</h2>
    let weather = props.weather
    //条件判断 
    let isGo = weather=='下雨' ?"不出门":"出门"

    return (
        <div>
            <h1>函数式组件helloworld</h1>
            {title}

            <div>
                是否出门？
                <span>{isGo}</span>
            </div>
        </div>
    )
}
```

## 	2、类组件

```jsx
//类组件定义
class HelloWorld extends React.Component{
    render(){
        console.log(this)
        return (
            <div>
                <h1>类组件定义HELLOWORLD</h1>
                <h1>hello:{this.props.name}</h1>
                <Childcom weather={this.props.weather} />
            </div>
        )
    }
}
```

## 	3、复合组件

> 组件中又有其他的组件,符合组件中既可以有类组件又可以有函数组件

```jsx
import React from 'react';
import ReactDOM from 'react-dom';
import './04style.css';
//函数式组件
function Childcom(props){
    console.log(props)

    let title = <h2>我是副标题</h2>
    let weather = props.weather
    //条件判断 
    let isGo = weather=='下雨' ?"不出门":"出门"

    return (
        <div>
            <h1>函数式组件helloworld</h1>
            {title}

            <div>
                是否出门？
                <span>{isGo}</span>
            </div>
        </div>
    )
}
//类组件定义
class HelloWorld extends React.Component{
    render(){
        console.log(this)
//返回的都是JSX对象
        return (
            <div>
                <h1>类组件定义HELLOWORLD</h1>
                <h1>hello:{this.props.name}</h1>
                <Childcom weather={this.props.weather} />
            </div>
        )
    }


}
ReactDOM.render(
    <HelloWorld name="老陈" weather="下雨" />,
    document.querySelector('#root')
)


```





# 四、React 的 state 和setState()

> 切勿直接修改state数据,直接state重新渲染内容,需要使用setState
>
> 通过this.setState修改玩数据后,并不会立即修改DOM里面的内容,react会在在这个函数内容所有设置状态改变后,同意对比虚拟DOM对象,然后再同意修改,提升性能

```jsx
this.state.time=new Date().toLocaleTimeString()//这个方法是错误的

this.setState({
    time:new Date().toLocaleTimeString()
})
```







