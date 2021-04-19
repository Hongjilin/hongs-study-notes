> 此笔记是观看B站技术胖的Hooks教学视频,各个博客,零碎知识点,官方文档整理而成,仅供本人洪学习记录使用
>
> [React 核心开发人员写的一篇文章，很不错](https://overreacted.io/a-complete-guide-to-useeffect/)
>
> [官方文档](https://react.docschina.org/docs/hooks-intro.html)   [官方视频](https://youtu.be/dpw9EHDh2bM)
>
> 本人[`React系统学习笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/React%E7%AC%94%E8%AE%B0)分享
>
> 本人笔记地址分享:[`全部笔记`](https://gitee.com/hongjilin/hongs-study-notes)、[`ReactHooks笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/ReactHooks%E7%AC%94%E8%AE%B0)、[`React笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/React%E7%AC%94%E8%AE%B0)

# #目录

>[TOC]

# 一、React Hook 介绍与环境搭建

> *Hook* 是 React 16.8 的新增特性。它可以让你在不编写 class 的情况下使用 state 以及其他的 React 特性
>
> 在 React Conf 2018 上，Sophie Alpert 和 Dan Abramov 介绍了 Hook[官方视频](https://youtu.be/dpw9EHDh2bM)
>
> 建议观看[官方文档](https://react.docschina.org/docs/hooks-intro.html),B站UP主其实也是照着官方文档敲了一遍,所以可以跟我一样,先看文档再去看UP敲一遍,自己在敲一遍,就基本会了
>
> ps:讲真的 里面小哥哥挺帅的,我一不懂英语的愣是看着他听了半小时(本人男哈哈),这里也吐槽一下,好不容易习惯了class写法,结果这里可以弃用,很裂开

## 1.1、使用`create-react-app`创建项目

> `create-react-app`它是React官方的脚手架，所以稳定性和使用率都是目前最好的，你可以大胆的进行使用。这里我在D盘新建一个`ReactHooksDemo`的文件夹，然后在文件夹中用`create-react-app`创建一个demo01的项目。我们这些动作全部在终端中进行。

```
D: // 进入D盘
mkdir ReactHooksDemo
cd ReactHooksDemo
create-react-app demo01
```

> 只留`/src/index.js`文件，因为本处只要对比原生写法与hooks,然后把里边的代码删减成下面的样子:

```js
import React from 'react';
import ReactDOM from 'react-dom';

ReactDOM.render(<App />, document.getElementById('root'));
```

> 这样就算开发环境搭建完成了，接下来我们对比一下原始的写法和现在有了React Hooks的写法。

## 1.2、React Hooks 编写形式对比

> 先来写一个最简单的有状体组件，点我们点击按钮时，点击数量不断增加。官方提供的示例

原始写法:

```js
import React, { Component } from 'react';

class Example extends Component {
    constructor(props) {
        super(props);
        this.state = { count:0 }
    }
    render() { 
        return (
            <div>
                <p>You clicked {this.state.count} times</p>
                <button onClick={this.addCount.bind(this)}>Chlick me</button>
            </div>
        );
    }
    addCount(){
        this.setState({count:this.state.count+1})
    }
}

export default Example;
```

React Hooks 写法：

```js
import React, { useState } from 'react';
function Example(){
    const [ count , setCount ] = useState(0);
    return (
        <div>
            <p>You clicked {count} times</p>
            <button onClick={()=>{setCount(count+1)}}>click me</button>
        </div>
    )
}
export default Example;
```

> 从这两个程序的对比上可以看出Hooks本质上就是一类特殊的函数，他们可以为你的函数型组件（function component）注入一些特殊的功能。这听起来有点像以前React中的`Mixins`差不多哦。其实是由很多不同，hooks的目的就是让你不再写`class`，让`function`一统江湖。
>
> ps:没错,前面学的class废了,^%$#^%$#^%$#^%$@^$#@^%$%)(*&(^$#^%))

# 二、useState 的介绍与多状态声明

## 2.1、useState的介绍

> `useState`是react自带的一个hook函数，它的作用是用来声明状态变量。

那我们从三个方面来看`useState`的用法，分别是声明、读取、使用（修改）。这三个方面掌握了，你基本也就会使用`useState`了.

先来看一下声明的方式，上节的代码如下：

```js
const [ count , setCount ] = useState(0);
```

这种方法是ES6语法中的数组解构，这样看起来代码变的简单易懂。现在ES6的语法已经在工作中频繁使用，所以如果你对ES6的语法还不熟悉，我觉的有必要拿出2天时间学习一下。 如果不写成数组解构，上边的语法要写成下面的三行:

```js
let _useState = userState(0)
let count = _useState[0]
let setCount = _useState[1]
```

`useState`这个函数接收的参数是状态的初始值(Initial state)，它返回一个数组，这个数组的第0位是当前的状态值，第1位是可以改变状态值的方法函数。 所以上面的代码的意思就是声明了一个状态变量为count，并把它的初始值设为0，同时提供了一个可以改变`count`的状态值的方法函数。

这时候你已经会声明一个状态了，接下来我们看看如何读取状态中的值。

```js
<p>You clicked {count} times</p>
```

你可以发现，我们读取是很简单的。只要使用`{count}`就可以，因为这时候的count就是JS里的一个变量，想在`JSX`中使用，值用加上`{}`就可以。

最后看看如果改变`State`中的值,看下面的代码:

```js
<button onClick={()=>{setCount(count+1)}}>click me</button>
```

直接调用setCount函数，这个函数接收的参数是修改过的新状态值。接下来的事情就交给`React`,他会重新渲染组件。`React`自动帮助我们记忆了组件的上一次状态值，但是这种记忆也给我们带来了一点小麻烦，但是这种麻烦你可以看成规则，只要准守规则，就可以愉快的进行编码。

## 2.2、多状态声明的注意事项

比如现在我们要声明多个状态，有年龄（age）、性别(sex)和工作(work)。代码可以这么写.

```js
import React, { useState } from 'react';
function Example2(){
    const [ age , setAge ] = useState(18)
    const [ sex , setSex ] = useState('男')
    const [ work , setWork ] = useState('前端程序员')
    return (
        <div>
            <p>JSPang 今年:{age}岁</p>
            <p>性别:{sex}</p>
            <p>工作是:{work}</p>
        </div>
    )
}
export default Example2;
```

其实细心的小伙伴一定可以发现，在使用`useState`的时候只赋了初始值，并没有绑定任何的`key`,那React是怎么保证这三个useState找到它自己对应的state呢？

**答案是：`React是根据useState出现的顺序来确定的`**

比如我们把代码改成下面的样子：

```js
import React, { useState } from 'react';

let showSex = true
function Example2(){
    const [ age , setAge ] = useState(18)
    if(showSex){
        const [ sex , setSex ] = useState('男')
        showSex=false
    }

    const [ work , setWork ] = useState('前端程序员')
    return (
        <div>
            <p>JSPang 今年:{age}岁</p>
            <p>性别:{sex}</p>
            <p>工作是:{work}</p>

        </div>
    )
}
export default Example2;
```

这时候控制台就会直接给我们报错，错误如下：

```bash
 React Hook "useState" is called conditionally. React Hooks must be called in the exact same order in every component render 
```

意思就是useState不能在`if...else...`这样的条件语句中进行调用，必须要按照相同的顺序进行渲染。如果你还是不理解，你可以记住这样一句话就可以了：**就是React Hooks不能出现在条件判断语句中，因为它必须有完全一样的渲染顺序**。



# 三、useEffect代替常用生命周期函数

> 在用`Class`制作组件时，经常会用生命周期函数，来处理一些额外的事情（副作用：和函数业务主逻辑关联不大，特定时间或事件中执行的动作，比如Ajax请求后端数据，添加登录监听和取消登录，手动修改`DOM`等等）。在`React Hooks`中也需要这样类似的生命周期函数，比如在每次状态（State）更新时执行，它为我们准备了`useEffect`。

## 3.1、用`Class`的方式为计数器增加生命周期函数

为了让你更好的理解`useEffect`的使用，先用原始的方式把计数器的Demo增加两个生命周期函数`componentDidMount`和`componentDidUpdate`。分别在组件第一次渲染后在浏览器控制台打印出计数器结果和在每次计数器状态发生变化后打印出结果。代码如下：

```js
import React, { Component } from 'react';

class Example3 extends Component {
    constructor(props) {
        super(props);
        this.state = { count:0 }
    }
    componentDidMount(){
        console.log(`ComponentDidMount=>You clicked ${this.state.count} times`)
    }
    componentDidUpdate(){
        console.log(`componentDidUpdate=>You clicked ${this.state.count} times`)
    }
    render() { 
        return (
            <div>
                <p>You clicked {this.state.count} times</p>
                <button onClick={this.addCount.bind(this)}>Chlick me</button>
            </div>
        );
    }
    addCount(){
        this.setState({count:this.state.count+1})
    }
}

export default Example3;
```

这就是在不使用Hooks情况下的写法，那如何用Hooks来代替这段代码，并产生一样的效果那。

## 3.2、用`useEffect`函数来代替生命周期函数

在使用`React Hooks`的情况下，我们可以使用下面的代码来完成上边代码的生命周期效果，代码如下（修改了以前的diamond）： 记得要先引入`useEffect`后，才可以正常使用。

```js
import React, { useState , useEffect } from 'react';
function Example(){
    const [ count , setCount ] = useState(0);
    //---关键代码---------start-------
    useEffect(()=>{
        console.log(`useEffect=>You clicked ${count} times`)
    })
    //---关键代码---------end-------

    return (
        <div>
            <p>You clicked {count} times</p>
            <button onClick={()=>{setCount(count+1)}}>click me</button>
        </div>
    )
}
export default Example;
```

> 写完后，可以到浏览器中进行预览一下，可以看出跟`class`形式的生命周期函数是完全一样的，这代表第一次组件渲染和每次组件更新都会执行这个函数。 那这段代码逻辑是什么？我们梳理一下:首先，我们生命了一个状态变量`count`,将它的初始值设为0，然后我们告诉react，我们的这个组件有一个副作用。给`useEffecthook`传了一个匿名函数，这个匿名函数就是我们的副作用。在这里我们打印了一句话，当然你也可以手动的去修改一个`DOM`元素。当React要渲染组件时，它会记住用到的副作用，然后执行一次。等Reat更新了State状态时，它再一词执行定义的副作用函数。

## 3.3、useEffect两个注意点

1. React首次渲染和之后的每次渲染都会调用一遍`useEffect`函数，而之前我们要用两个生命周期函数分别表示首次渲染(componentDidMonut)和更新导致的重新渲染(componentDidUpdate)。
2. useEffect中定义的函数的执行不会阻碍浏览器更新视图，也就是说这些函数时异步执行的，而`componentDidMonut`和`componentDidUpdate`中的代码都是同步执行的。个人认为这个有好处也有坏处吧，比如我们要根据页面的大小，然后绘制当前弹出窗口的大小，如果时异步的就不好操作了。

# 四、useEffect 实现 componentWillUnmount生命周期函数

> 在写React应用的时候，在组件中经常用到`componentWillUnmount`生命周期函数（组件将要被卸载时执行）。比如我们的定时器要清空，避免发生内存泄漏;比如登录状态要取消掉，避免下次进入信息出错。所以这个生命周期函数也是必不可少的，这节笔记就来用`useEffect`来实现这个生命周期函数,并记录`useEffect`容易踩的坑。

## 4.1、useEffect解绑副作用

> 学习`React Hooks` 时，我们要改掉生命周期函数的概念（人往往有先入为主的毛病，所以很难改掉），因为`Hooks`叫它副作用，所以`componentWillUnmount`也可以理解成解绑副作用。这里为了演示用`useEffect`来实现类似`componentWillUnmount`效果，先安装`React-Router`路由

```shell
npm install --save react-router-dom
```

然后打开`Example.js`文件(示例代码)，进行改写代码，先引入对应的`React-Router`组件。

```jsx
import { BrowserRouter as Router, Route, Link } from "react-router-dom"
```

在文件中编写两个新组件，因为这两个组件都非常的简单，所以就不单独建立一个新的文件来写了。

```jsx
function Index() {
    return <h2>JSPang.com</h2>;
}

function List() {
    return <h2>List-Page</h2>;
}
```

有了这两个组件后，接下来可以编写路由配置，在以前的计数器代码中直接增加就可以了。

```jsx
return (
    <div>
        <p>You clicked {count} times</p>
        <button onClick={()=>{setCount(count+1)}}>click me</button>

        <Router>
            <ul>
                <li> <Link to="/">首页</Link> </li>
                <li><Link to="/list/">列表</Link> </li>
            </ul>
            <Route path="/" exact component={Index} />
            <Route path="/list/" component={List} />
        </Router>
    </div>
)
```

然后到浏览器中查看一下，看看组件和路由是否可用。如果可用，我们现在可以调整`useEffect`了。在两个新组件中分别加入`useEffect()`函数:

```jsx
function Index() {
    useEffect(()=>{
        console.log('useEffect=>老弟，你来了！Index页面')
        )
    return <h2>JSPang.com</h2>;
}

function List() {
    useEffect(()=>{
        console.log('useEffect=>老弟，你来了！List页面')
    })

    return <h2>List-Page</h2>;
}
```

这时候我们点击`Link`进入任何一个组件，在浏览器中都会打印出对应的一段话。这时候可以用**返回一个函数的形式进行解绑**，代码如下：

```jsx
function Index() {
    useEffect(()=>{
        console.log('useEffect=>老弟你来了！Index页面')
        return ()=>{
            console.log('老弟，你走了!Index页面')
        }
    })
    return <h2>JSPang.com</h2>;
  }
```

> 这时候你在浏览器中预览，我们仿佛实现了`componentWillUnmount`方法。但这只是好像实现了，当点击计数器按钮时，你会发现`老弟，你走了!Index页面`，也出现了。这到底是怎么回事那？其实每次状态发生变化，`useEffect`都进行了解绑。

## 4.2、useEffect的第二个参数

> 那到底要如何实现类似`componentWillUnmount`的效果那?这就需要请出`useEffect`的第二个参数，它是一个数组，数组中可以写入很多状态对应的变量，意思是当状态值发生变化时，我们才进行解绑。但是当传空数组`[]`时，就是当组件将被销毁时才进行解绑，这也就实现了`componentWillUnmount`的生命周期函数。

```jsx
function Index() {
    useEffect(()=>{
        console.log('useEffect=>老弟你来了！Index页面')
        return ()=>{
            console.log('老弟，你走了!Index页面')
        }
    },[])
    return <h2>JSPang.com</h2>;
}
```

为了更加深入了解第二个参数的作用，把计数器的代码也加上`useEffect`和解绑方法，并加入第二个参数为空数组。代码如下：

```jsx
function Example(){
    const [ count , setCount ] = useState(0);

    useEffect(()=>{
        console.log(`useEffect=>You clicked ${count} times`)

        return ()=>{
            console.log('====================')
        }
    },[])

    return (
        <div>
            <p>You clicked {count} times</p>
            <button onClick={()=>{setCount(count+1)}}>click me</button>

            <Router>
                <ul>
                    <li> <Link to="/">首页</Link> </li>
                    <li><Link to="/list/">列表</Link> </li>
                </ul>
                <Route path="/" exact component={Index} />
                <Route path="/list/" component={List} />
            </Router>
        </div>
    )
}
```

这时候的代码是不能执行解绑副作用函数的。但是如果我们想每次`count`发生变化，我们都进行解绑，只需要在第二个参数的数组里加入`count`变量就可以了。代码如下：

```jsx
function Example(){
    const [ count , setCount ] = useState(0);

    useEffect(()=>{
        console.log(`useEffect=>You clicked ${count} times`)

        return ()=>{
            console.log('====================')
        }
    },[count])

    return (
        <div>
            <p>You clicked {count} times</p>
            <button onClick={()=>{setCount(count+1)}}>click me</button>

            <Router>
                <ul>
                    <li> <Link to="/">首页</Link> </li>
                    <li><Link to="/list/">列表</Link> </li>
                </ul>
                <Route path="/" exact component={Index} />
                <Route path="/list/" component={List} />
            </Router>
        </div>
    )
}
```

这时候只要`count`状态发生变化，都会执行解绑副作用函数，浏览器的控制台也就打印出了一串`=================`。

这节学完我们就对`useEffect`函数有了一个比较深入的了解，并且可以通过`useEffect`实现生命周期函数了，也完成了本节学习的目的，现在用`React Hooks`这种函数的方法编写组件，对比以前用`Class`编写组件几乎一样了。



# 五、useContext 让父子组件传值更简单

有了`useState`和`useEffect`已经可以实现大部分的业务逻辑了，但是`React Hooks`中还是有很多好用的`Hooks`函数的，比如`useContext`和`useReducer`。

> 在用类声明组件时，父子组件的传值是通过组件属性和`props`进行的，那现在使用方法(Function)来声明组件，已经没有了`constructor`构造函数也就没有了props的接收，那父子组件的传值就成了一个问题。`React Hooks` 为我们准备了`useContext`。这节课就学习一下`useContext`，它可以帮助我们跨越组件层级直接传递变量，实现共享。需要注意的是`useContext`和`redux`的作用是不同的，一个解决的是组件之间值传递的问题，一个是应用中统一管理状态的问题，但通过和`useReducer`的配合使用，可以实现类似`Redux`的作用。

这就好比玩游戏时有很多英雄，英雄的最总目的都是赢得比赛，但是作用不同，有负责输出的，有负责抗伤害的，有负责治疗的。

> `Context`的作用就是对它所包含的组件树提供全局共享数据的一种技术。

## 5.1、useContext 介绍与代码示例

直接在`src`目录下新建一个文件`Example4.js`,然后拷贝`Example.js`里的代码，并进行修改，删除路由部分和副作用的代码，只留计数器的核心代码就可以了。

```jsx
import React, { useState , useEffect } from 'react';

function Example4(){
    const [ count , setCount ] = useState(0);
    return (
        <div>
            <p>You clicked {count} times</p>
            <button onClick={()=>{setCount(count+1)}}>click me</button>
        </div>
    )
}
export default Example4;
```

然后修改一下`index.js`让它渲染这个`Example4.js`组件，修改的代码如下。

```jsx
import React from 'react';
import ReactDOM from 'react-dom';
import Example from './Example4'
ReactDOM.render(<Example />, document.getElementById('root'));
```

之后在`Example4.js`中引入`createContext`函数，并使用得到一个组件，然后在`return`方法中进行使用。先看代码，然后我再解释。

```jsx
import React, { useState , createContext } from 'react';
//===关键代码
const CountContext = createContext()

function Example4(){
    const [ count , setCount ] = useState(0);

    return (
        <div>
            <p>You clicked {count} times</p>
            <button onClick={()=>{setCount(count+1)}}>click me</button>
            {/*======关键代码 将其注入子组件 */}
            <CountContext.Provider value={count}> 
                
            </CountContext.Provider>
        </div>
    )
}
export default Example4;
```

这段代码就相当于把`count`变量允许跨层级实现传递和使用了（也就是实现了上下文），当父组件的`count`变量发生变化时，子组件也会发生变化。接下来我们就看看一个`React Hooks`的组件如何接收到这个变量。

## 5.2、useContext 接收上下文变量

已经有了上下文变量，剩下的就时如何接收了，接收这个直接使用useContext就可以，但是在使用前需要新进行引入`useContext`（不引入是没办法使用的）。

```jsx
import React, { useState , createContext , useContext } from 'react';
```

引入后写一个`Counter`组件，只是显示上下文中的`count`变量代码如下：

```jsx
function Counter(){
    const count = useContext(CountContext)  //一句话就可以得到count
    return (<h2>{count}</h2>)
}
```

得到后就可以显示出来了，但是要记得在`<CountContext.Provider>`的闭合标签中,代码如下。

```jsx
<CountContext.Provider value={count}>
    <Counter />
</CountContext.Provider>
```



# 六、useReducer介绍和简单使用

> 上节学习了`useContext`函数，那这节开始学习一下`useReducer`，因为他们两个很像，并且合作可以完成类似的Redux库的操作。在开发中使用`useReducer`可以让代码具有更好的可读性和可维护性，并且会给测试提供方便。

## 6.1、reducer到底是什么？

> 为了更好的理解`useReducer`，所以先要了解JavaScript里的`Redcuer`是什么。它的兴起是从`Redux`广泛使用开始的，但不仅仅存在`Redux`中，可以使用JavaScript来完成`Reducer`操作。那`reducer`其实就是一个函数，这个函数接收两个参数，一个是状态，一个用来控制业务逻辑的判断参数。我们举一个最简单的例子。

```js
function countReducer(state, action) {
    switch(action.type) {
        case 'add':
            return state + 1;
        case 'sub':
            return state - 1;
        default: 
            return state;
    }
}
```

上面的代码就是Reducer，你主要理解的就是这种形式和两个参数的作用，一个参数是状态，一个参数是如何控制状态。

## 6.2、useReducer的使用

了解reducer的含义后，就可以讲useReducer了，它也是React hooks提供的函数，可以增强我们的`Reducer`，实现类似Redux的功能。我们新建一个`Example5.js`的文件，然后用useReducer实现计数器的加减双向操作。

```js
import React, { useReducer } from 'react';

function ReducerDemo(){
    const [ count , dispatch ] =useReducer((state,action)=>{
        switch(action){
            case 'add':
                return state+1
            case 'sub':
                return state-1
            default:
                return state
        }
    },0)
    return (
       <div>
           <h2>现在的分数是{count}</h2>
           <button onClick={()=>dispatch('add')}>Increment</button>
           <button onClick={()=>dispatch('sub')}>Decrement</button>
       </div>
    )

}

export default ReducerDemo
```

这段代码是useReducer的最简单实现了，这时候可以在浏览器中实现了计数器的增加减少。

修改`index.js`文件，让`ReducerDemo`组件起作用。

```js
import React from 'react';
import ReactDOM from 'react-dom';
import Example from './Example5'


ReactDOM.render(<Example />, document.getElementById('root'));
```

# 七、useReducer代替Redux小案例

>  此处参考了掘金上缪宇的文章  --[参考文章](https://juejin.cn/post/6844903854807482382),此处将其整理下来,方便查阅
>
> 未来我将会`尝试使用useReducer替代Mobx`状态管理器,并记录区别,但现在只是学习阶段,Mark一下

## 7.1、为何使用useReducer

Redux 毫无疑问是众多 React 项目首选的状态管理方案，但 Redux 某些地方的开发体验并不好。

> 比如当你正在开发一个很复杂的功能，中途需要不断添加全局状态，每次添加都不得不重复如下步骤：
>
> 1. 去到管理 redux 的文件夹，思考把这个状态放到状态树的哪个位置，然后新建一个文件夹并命名 `myFeature`。
> 2. 创建三个文件 `my-feature/actions.js` 、`my-feature/reducer.js`、`my-feature/type.js`
> 3. combineReducer 和并 reduce
> 4. 将 action 引入到组件中
> 5. 通过 connect HOC 与你的组件相连
> 6. 增加两个方法 mapStateToProps 和 mapDispatchToProps
>
> 以上只是加个状态而已，写很多模板代码还是其次，最要命的是会打断你写代码的思路。
>
> 而且随着项目越来越大， redux 的状态树也会变大，维护也会变困难。

## 7.2、useContext + useReducer 如何替代 redux ？及可行性

> `useContext` 和 `useReducer` 是 React 16.8 引入的新 API。
>
> `useContext`：可访问全局状态，避免一层层的传递状态。这符合`Redux`其中的一项规则，就是状态全局化，并能统一管理。
>
> `useReducer`：通过action的传递，更新复杂逻辑的状态，主要是可以实现类似`Redux`中的`Reducer`部分，实现业务逻辑的可行性。

## 7.3、案例代码示例

##### Ⅰ、开始

> 首先用 create-react-app 创建一个项目

##### Ⅱ、创建颜色展示组件 ShowArea

```jsx
import React from 'react'

const ShowArea = (props) => {
  return (
    <div style={{color: "blue"}}>字体颜色展示为blue</div>
  )
}

export default ShowArea
```

##### Ⅲ、创建按钮组件 buttons

```jsx
import React from "react";

const Buttons = props => {
  return (
    <div>
      <button>红色</button>
      <button>黄色</button>
      </div>
  );
};

export default Buttons;

```

##### Ⅳ、将 ShowArea 和 Buttons 导入 index.js(等会写出color状态组件后将会改写)

```jsx
import React from "react";
import ReactDOM from "react-dom";
import ShowArea from './ShowArea'
import Buttons from './Buttons'

function App() {
  return (
    <div className="App">
      <ShowArea />
      <Button />
    </div>
  );
}

const rootElement = document.getElementById("root");
ReactDOM.render(<App />, rootElement);

```

##### Ⅴ、`状态管理`组件创建编写

> 很明显 ShowArea 组件需要一个颜色状态，所以我们创建 color.js 来处理状态。 `{props.children}`传值给子组件(多个)

```jsx
// color.js
import React, { createContext } from "react";

// 创建 context
export const ColorContext = createContext({});

/**
 * 创建一个 Color 组件
 * Color 组件包裹的所有子组件都可以通过调用 ColorContext 访问到 value
 */
export const Color = props => {
  return (
    <ColorContext.Provider value={{ color: "blue" }}>
      {props.children}
    </ColorContext.Provider>
  );
};

```

##### Ⅵ、引入状态

> 修改 index.js，让所有子组件都可以访问到颜色。

```jsx
// index.js

import { Color } from "./color";

function App() {
  return (
    <div className="App">
      <Color>
        <ShowArea />
        <Buttons />
      </Color>
    </div>
  );
}

```

##### Ⅶ、获取状态

> 在 ShowArea 组件中获取颜色 直接引入  然后使用`useContext`进行获取使用

```jsx
// ShowArea.js

import { ColorContext } from "./color";

const ShowArea = props => {
  const { color } = useContext(ColorContext);
  return <div style={{ color: color }}>字体颜色展示为{color}</div>;
};

```

##### Ⅷ、`创建 reducer`

接着在 color.js 中添加 reducer， 用于处理颜色更新的逻辑。 然后使用`useReducer`传入reducer进行处理

```jsx
import React, { createContext, useReducer } from "react";
// 创建 context
export const ColorContext = createContext({});
//声明常量是方便使用
export const UPDATE_COLOR = "UPDATE_COLOR"
// reducer方法 声明
const reducer = (state, action) => {
  switch(action.type) {
    case UPDATE_COLOR:
      return action.color
    default:
      return state  
  }
}

/**
 * 创建一个 Color 组件
 * Color 组件包裹的所有组件都可以访问到 value
 */
export const Color = props => {
  const [color, dispatch] = useReducer(reducer, 'blue')
  return (
    <ColorContext.Provider value={{color, dispatch}}>
      {props.children}
    </ColorContext.Provider>
  );
};

```

##### Ⅸ、更新状态

为按钮添加点击事件，调用 dispatch 就可以更新颜色了。

```jsx
// buttons.js

import React, { useContext } from "react";
import { colorContext, UPDATE_COLOR } from "./color";

const Buttons = props => {
  const { dispatch } = useContext(colorContext);
  return (
    <React.Fragment>
      <button
        onClick={() => {
          dispatch({ type: UPDATE_COLOR, color: "red" });
        }}
      >
        红色
      </button>
      <button
        onClick={() => {
          dispatch({ type: UPDATE_COLOR, color: "yellow" });
        }}
      >
        黄色
      </button>
    </React.Fragment>
  );
};

export default Buttons;

```

## 7.4、总结

>- useContext 创建全局状态，不用一层一层的传递状态。
>- useReducer 创建 reducer 根据不同的 dispatch 更新 state。
>- 代码写到哪里状态就加到哪里，不用打断思路跳到 redux 里面去写。
>- 全局状态分离，避免项目变大导致 Redux 状态树难以管理。
>
>所以 useContext + useReducer 完全可以替代 React 进行状态管理。但是目前绝大多数 React 项目仍在使用 Redux，所以深入学习 Redux 还是很有必要的。



# 八、useMemo优化React Hooks程序性能

>`useMemo`主要用来解决使用React hooks产生的无用渲染的性能问题。使用function的形式来声明组件，失去了`shouldCompnentUpdate`（在组件更新之前）这个生命周期，也就是说我们没有办法通过组件更新前条件来决定组件是否更新。而且在函数组件中，也不再区分`mount`和`update`两个状态，这意味着函数组件的每一次调用都会执行内部的所有逻辑，就带来了非常大的性能损耗。`useMemo`和`useCallback`都是解决上述性能问题的

## 8.1、性能问题展示案例

先编写一下刚才所说的性能问题，建立两个组件,一个父组件一个子组件，组件上由两个按钮，一个是小洪，一个是帅洪，点击哪个，那个就像我们走来了。在`/src`文件夹下，新建立一个`Example7`的文件夹，在文件夹下建立一个`Example7.js`文件.然后先写第一个父组件。

```jsx
import React , {useState,useMemo} from 'react';

function Example7(){
    const [xiaohong , setXiaohong] = useState('小洪待客状态')
    const [zhiling , setZhiling] = useState('帅洪待客状态')
    return (
        <>
            <button onClick={()=>{setXiaohong(new Date().getTime())}}>小洪</button>
            <button onClick={()=>{setZhiling(new Date().getTime()+',帅洪向我们走来了')}}>志玲</button>
            <ChildComponent name={xiaohong}>{zhiling}</ChildComponent>
        </>
    )
}
```

父组件调用了子组件，子组件我们输出两个人的状态，显示在界面上。代码如下：

```jsx
function ChildComponent({name,children}){
    function changeXiaohong(name){
        console.log('她来了，她来了。小洪向我们走来了')
        return name+',小洪向我们走来了'
    }

    const actionXiaohong = changeXiaohong(name)
    return (
        <>
            <div>{actionXiaohong}</div>
            <div>{children}</div>
        </>
    )
}
```

然后再导出父组件，让`index.js`可以渲染。

```js
export default Example7
```

> 这时候你会发现在浏览器中点击`帅洪`按钮，小红对应的方法都会执行，结果虽然没变，但是每次都执行，这就是性能的损耗。目前只有子组件，业务逻辑也非常简单，如果是一个后台查询，这将产生严重的后果。所以这个问题必须解决。当我们点击`帅洪`按钮时，小洪对应的`changeXiaohong`方法不能执行，只有在点击`小洪`按钮时才能执行。

## 8.2、useMemo 优化性能

其实只要使用`useMemo`，然后给她传递第二个参数，参数匹配成功，才会执行。代码如下：

```js
function ChildComponent({name,children}){
    function changeXiaohong(name){
        console.log('她来了，她来了。小洪向我们走来了')
        return name+',小洪向我们走来了'
    }

    const actionXiaohong = useMemo(()=>changeXiaohong(name),[name]) 
    return (
        <>
            <div>{actionXiaohong}</div>
            <div>{children}</div>
        </>
    )
}
```

这时在浏览器中点击一下`帅洪`按钮，`changeXiaohong`就不再执行了。也节省了性能的消耗。案例只是让你更好理解，你还要从程序本身看到优化的作用。好的程序员对自己写的程序都是会进行不断优化的，这种没必要的性能浪费也是绝对不允许的，所以`useMemo`的使用在工作中还是比较多的。

# 九、useRef获取DOM元素和保存变量

>`useRef`在工作中虽然用的不多，但是也不能缺少。它有两个主要的作用:
>
>- 用`useRef`获取React JSX中的DOM元素，获取后你就可以控制DOM的任何东西了。但是一般不建议这样来作，React界面的变化可以通过状态来控制。
>- 用`useRef`来保存变量，这个在工作中也很少能用到，我们有了`useContext`这样的保存其实意义不大

## 9.1、useRef获取DOM元素

> 比如一个案例,想象一下:界面上有一个文本框，在文本框的旁边有一个按钮，当我们点击按钮时，在控制台打印出`input`的DOM元素，并进行复制到DOM中的value上。这一切都是通过`useRef`来实现。

在`/src`文件夹下新建一个`Example8.js`文件，然后先引入useRef，编写业务逻辑代码如下:

```js
import React, { useRef} from 'react';
function Example8(){
    const inputEl = useRef(null)
    const onButtonClick=()=>{ 
        inputEl.current.value="Hello ,JSPang"
        console.log(inputEl) //输出获取到的DOM节点
    }
    return (
        <>
            {/*保存input的ref到inputEl */}
            <input ref={inputEl} type="text"/>
            <button onClick = {onButtonClick}>在input上展示文字</button>
        </>
    )
}
export default Example8
```

当点击按钮时，你可以看到在浏览器中的控制台完整的打印出了DOM的所有东西，并且界面上的`<input/>`框的value值也输出了我们写好的`Hello ,JSPang`。这一切说明我们可以使用useRef获取DOM元素，并且可以通过useRefu控制DOM的属性和值。

## 9.2、useRef保存普通变量

> 这个操作在实际开发中用的并不多，但我们还是要讲解一下。就是`useRef`可以保存React中的变量。我们这里就写一个文本框，文本框用来改变`text`状态。又用`useRef`把`text`状态进行保存，最后打印在控制台上。写这段代码你会觉的很绕，其实显示开发中没必要这样写，用一个state状态就可以搞定，这里只是为了展示知识点。

接着上面的代码来写，就没必要重新写一个文件了。先用`useState`声明了一个`text`状态和`setText`函数。然后编写界面，界面就是一个文本框。然后输入的时候不断变化。

```js
import React, { useRef ,useState,useEffect } from 'react';



function Example8(){
    const inputEl = useRef(null)
    const onButtonClick=()=>{ 
        inputEl.current.value="Hello ,useRef"
        console.log(inputEl)
    }
    const [text, setText] = useState('jspang')
    return (
        <>
            {/*保存input的ref到inputEl */}
            <input ref={inputEl} type="text"/>
            <button onClick = {onButtonClick}>在input上展示文字</button>
            <br/>
            <br/>
            <input value={text} onChange={(e)=>{setText(e.target.value)}} />

        </>
    )
}

export default Example8
```

这时想每次`text`发生状态改变，保存到一个变量中或者说是`useRef`中，这时候就可以使用`useRef`了。先声明一个`textRef`变量，他其实就是`useRef`函数。然后使用`useEffect`函数实现每次状态变化都进行变量修改，并打印。最后的全部代码如下。

```js
import React, { useRef ,useState,useEffect } from 'react';
function Example8(){
    const inputEl = useRef(null)
    const onButtonClick=()=>{ 
        inputEl.current.value="Hello ,useRef"
        console.log(inputEl)
    }
    //-----------关键代码--------start
    const [text, setText] = useState('jspang')
    const textRef = useRef()

    useEffect(()=>{
        textRef.current = text;
        console.log('textRef.current:', textRef.current)
    })
    //----------关键代码--------------end
    return (
        <>
            {/*保存input的ref到inputEl */}
            <input ref={inputEl} type="text"/>
            <button onClick = {onButtonClick}>在input上展示文字</button>
            <br/>
            <br/>
            <input value={text} onChange={(e)=>{setText(e.target.value)}} />
        </>
    )
}

export default Example8
```

这时候就可以实现每次状态修改，同时保存到`useRef`中了。也就是我们说的保存变量的功能。那`useRef`的主要功能就是获得DOM和变量保存，我们都已经讲过了。

# 十、自定义Hooks函数获取窗口大小

> 其实自定义Hooks函数和用Hooks创建组件很相似，跟我们平时用JavaScript写函数几乎一模一样，可能就是多了些`React Hooks`的特性，自定义Hooks函数偏向于功能，而组件偏向于界面和业务逻辑。由于差别不大，所以使用起来也是很随意的。如果是小型项目是可以的，但是如果项目足够复杂，这会让项目结构不够清晰。所以学习自定义Hooks函数还是很有必要的。

## 10.1、编写自定义函数

> 在实际开发中，为了界面更加美观。获取浏览器窗口的尺寸是一个经常使用的功能，这样经常使用的功能，就可以封装成一个自定义`Hooks`函数，记住一定要用use开头，这样才能区分出什么是组件，什么是自定义函数。

新建一个文件`Example9.js`,然后编写一个useWinSize,编写时我们会用到`useState`、`useEffect`和`useCallback`所以先用`import`进行引入。

```js
import React, { useState ,useEffect ,useCallback } from 'react';
```

> 然后编写函数，函数中先用useState设置`size`状态，然后编写一个每次修改状态的方法`onResize`，这个方法使用`useCallback`，目的是为了缓存方法(useMemo是为了缓存变量)。 然后在第一次进入方法时用`useEffect`来注册`resize`监听时间。为了防止一直监听所以在方法移除时，使用return的方式移除监听。最后返回size变量就可以了。
>
> `resize`  浏览器窗口被调整到一个新的高度或宽度时，就会触发resize事件,这是js监听事件

```js
function useWinSize(){
    const [ size , setSize] = useState({
        width:document.documentElement.clientWidth,
        height:document.documentElement.clientHeight
    })

    const onResize = useCallback(()=>{
        setSize({
            width: document.documentElement.clientWidth,
            height: document.documentElement.clientHeight
        })
    },[]) 
    useEffect(()=>{
        {/*  resize  浏览器窗口被调整到一个新的高度或宽度时，就会触发resize事件*/}
        window.addEventListener('resize',onResize)
        return ()=>{
            window.removeEventListener('resize',onResize)
        }
    },[])

    return size;

}
```

这就是一个自定义函数，其实和我们以前写的JS函数没什么区别，所以这里也不做太多的介绍。

## 10.2、编写组件并使用自定义函数

自定义`Hooks`函数已经写好了，可以直接进行使用，用法和`JavaScript`的普通函数用起来是一样的。直接在`Example9`组件使用`useWinSize`并把结果实时展示在页面上。

```js
function Example9(){

    const size = useWinSize()
    return (
        <div>页面Size:{size.width}x{size.height}</div>
    )
}

export default Example9 
```

之后就可以在浏览器中预览一下结果，可以看到当我们放大缩小浏览器窗口时，页面上的结果都会跟着进行变化。说明自定义的函数起到了作用。























