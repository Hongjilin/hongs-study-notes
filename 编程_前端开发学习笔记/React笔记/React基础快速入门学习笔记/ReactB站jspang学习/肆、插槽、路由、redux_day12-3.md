>本人的React学习笔记分类(也是对应本人技术成长过程):[[`想快速入门看这部分`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React基础补充学习笔记)]、[[`想对React系统全面进行学习的同学看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/Scss%E7%AC%94%E8%AE%B0)]、[[`对基础学习完成且有了一定开发经验,想尝试解析源码的看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React深入学习与源码解析笔记)]

# 一、React插槽

>组建中写入内容，这些内容可以被识别和控制。React需要自己开发支持插槽功能。
>
>原理：组件中写入的HTML，可以传入到props中。

##### 1、组件中的HTML内容直接全部插入

```jsx
class ParentCom extends React.Component{
    
    render(){
        console.log(this.props)
        return (
            <div>
                <h1>组件插槽</h1>
                {this.props.children}
            </div>
        )
    }
}

```

##### 2、组件中根据HTML内容的不同，插入的位置不同。

```jsx
import React from 'react';
import ReactDOM from 'react-dom';

class ParentCom extends React.Component{
    
    render(){
        console.log(this.props)
        return (
            <div>
                <h1>组件插槽</h1>
                {this.props.children}
                <ChildCom>
                    <h1 data-position="header">这是放置到头部的内容</h1>
                    <h1 data-position="main">这是放置到主要的内容</h1>
                    <h1 data-position="footer">这是放置到尾部的内容</h1>
                </ChildCom>
            </div>
        )
    }
}

class ChildCom extends React.Component{
    render(){
        let headerCom,mainCom,footerCom;
        this.props.children.forEach((item,index)=>{
           if(item.props['data-position']==='header'){
            headerCom = item
           }else if(item.props['data-position']==='main'){
               mainCom = item
           }else{
               footerCom = item
           }
        })
        return (
            <div>
                <div className="header">
                    {headerCom}
                </div>
                <div className="main">
                    {mainCom}
                </div>
                <div className="footer">
                    {footerCom}
                </div>
            </div>
        )
    }
}

class RootCom extends React.Component{
    constructor(props){
        super(props)
        //console.log(props)
        this.state = {
            arr:[1,2,3]
        }
    }
    render(){
        return (
            <ParentCom>
                <h2 data-name="a" data-index={this.state.arr[0]}>子组件1</h2>
                <h2 data-name="b" data-index={this.state.arr[1]}>子组件2</h2>
                <h2 data-name="c" data-index={this.state.arr[2]}>子组件3</h2>
            </ParentCom>
        )
    }
}
ReactDOM.render(
    <RootCom></RootCom>
    ,
    document.querySelector("#root")
)
```

# 二、React路由

> 根据不同的路径，显示不同的组件（内容）；React使用的库react-router-dom;

##  1、安装

```cmd
Cnpm install react-router-dom --save  
```

## 2、ReactRouter三大组件：

1. Router：所有路由组件的根组件（底层组件），包裹路由规则的最外层容器。

   ​	  属性：basename->设置跟此路由根路径，router可以在1个组件中写多个。

2. Route:路由规则匹配组件，显示当前规则对应的组件

3. Link:路由跳转的组件

   1. > Link的replace属性：点击链接后，将新地址替换成历史访问记录的原地址。

> 注意：如果要精确匹配，那么可以在route上设置exact属性。

### 1、使用案例

```jsx
import React from 'react';
//hash模式
//import {HashRouter as Router,Link,Route} from 'react-router-dom'
//history模式/后端匹配使用
import {BrowserRouter as Router,Link,Route} from 'react-router-dom'

function Home(){
    return (
        <div>
            <h1>admini首页</h1>
        </div>
    )
}

function Me(){
    return (
        <div>
            <h1>admin个人中心</h1>
        </div>
    )
}

function Product(){
    return (
        <div>
            <h1>admin产品页面</h1>
        </div>
    )
}

class App extends React.Component{
    
    render(){
        return (
            <div id="app">
                {/* <div>所有页面普通内容</div> */}
                <Router>
                    <Route path="/" exact component={()=>(<div>首页</div>)}></Route>
                    <Route path="/me" component={()=>(<div>me</div>)}></Route>
                    <Route path="/product" component={()=>(<div>product</div>)}></Route>
                </Router>

                <Router>
                    {/* <div className="nav">
                        <Link to="/">Home</Link>
                        <Link to="/product">Product</Link>
                        <Link to="/me">个人中心</Link>
                    </div> */}
                    <Route path="/admin/" exact component={Home}></Route>
                    <Route path="/admin/product" component={Product}></Route>
                    <Route path="/admin/me" exact component={Me}></Route>
                </Router>
            </div>
        )
    }
}

export default App
```

Link组件可以设置to属性来进行页面的跳转，to属性可以直接写路径的字符串，也可以通过1个对象，进行路径的设置，如

```jsx
render(){
        let meObj = {
            pathname:"/me",//跳转的路径
            search:"?username=admin",//get请求参数
            hash:"#abc",//设置的HASH值
            state:{msg:'helloworld'}//传入组件的数据
        };
        return (
            <div id="app">
                

                <Router>
                    <div className="nav">
                        <Link to="/">Home</Link>
                        <Link to="/product">Product</Link>
                        <Link to={ meObj }>个人中心</Link>
                    </div>
                    <Route path="/" exact component={Home}></Route>
                    <Route path="/product" component={Product}></Route>
                    <Route path="/me" exact component={Me}></Route>
                </Router>
            </div>
        )
    }


```

Link的replace属性：点击链接后，将新地址替换成历史访问记录的原地址。

### 2、动态路由实现

```jsx
import React from 'react';
//hash模式
//import {HashRouter as Router,Link,Route} from 'react-router-dom'

//history模式/后端匹配使用
import {BrowserRouter as Router,Link,Route} from 'react-router-dom'

function Home(){
    return (
        <div>
            <h1>admini首页</h1>
        </div>
    )
}

function Me(props){
    console.log(props)
    return (
        <div>
            <h1>admin个人中心</h1>
        </div>
    )
}

function Product(){
    return (
        <div>
            <h1>admin产品页面</h1>
        </div>
    )
}

function News(props){
    console.log(props)
    return (
        <div>
            新闻页，新闻id：{props.match.params.id}
        </div>
    )
}

class App extends React.Component{
    
    render(){
        let meObj = {
            pathname:"/me",//跳转的路径
            search:"?username=admin",//get请求参数
            hash:"#abc",//设置的HASH值
            state:{msg:'helloworld'}//传入组件的数据
        };
        return (
            <div id="app">
                

                <Router>
                    <div className="nav">
                        <Link to="/">Home</Link>
                        <Link to="/product">Product</Link>
                        <Link to={ meObj }   replace>个人中心</Link>
                        <Link to="/news/4568789">新闻页</Link>
                    </div>
                    <Route path="/" exact component={Home}></Route>
                    <Route path="/product" component={Product}></Route>
                    <Route path="/me" exact component={Me}></Route>
                    <Route path="/news/:id" component={News}></Route>
                </Router>
            </div>
        )
    }
}
export default App
```



## 3、重定向组件--Redirect

> 如果访问某个组件时，如果有重定向组件，那么就会修改页面路径，使得页面内容显示为所定向路径的内容

```jsx
function LoginInfo(props){
    //props.loginState = 'success';
    //props.loginState = "fail"
    console.log(props)
    if(props.location.state.loginState === 'success'){
        return <Redirect to="/admin"></Redirect>
    }else{
        return <Redirect to="/login"></Redirect>
    }
}

```

## 4、Switch组件

> 让switch组件内容的route只匹配1个，只要匹配到了，剩余的路由规则将不再匹配

```jsx
class App extends React.Component{
    render(){
        return (
            <div>
                <Router>
                    <Switch>
                        <Route path="/" exact  component={()=>(<h1>首页</h1>)}></Route>
                        <Route path="/form" exact  component={FormCom}></Route>
                        <Route path="/login" exact  component={()=>(<h1>登录页</h1>)}></Route>
                        <Route path="/logininfo" exact component={LoginInfo}></Route>
                        <Route path="/admin" exact component={()=>(<h1>admin页,登录成功</h1>)}></Route>
                        <Route path="/abc" exact component={()=>(<h1>abc1页,登录成功</h1>)}></Route>
                        <Route path="/abc" exact component={()=>(<h1>abc2页,登录成功</h1>)}></Route>
                    </Switch>
                </Router>
            </div>
        )
    }
}


```





