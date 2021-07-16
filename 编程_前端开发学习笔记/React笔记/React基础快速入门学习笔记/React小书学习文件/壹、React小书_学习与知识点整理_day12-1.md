> -本笔记来自学习 作者:胡子大哈 原文链接：[ http://huziketang.com/books/react/lesson5](http://huziketang.com/books/react/lesson5) 的小书 而记录,仅本人洪学习使用
>
> 本人[笔记地址](https://gitee.com/hongjilin/hongs-study-notes)
>
> 本人的React学习笔记分类(也是对应本人技术成长过程):[[`想快速入门看这部分`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React基础补充学习笔记)]、[[`想对React系统全面进行学习的同学看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/Scss%E7%AC%94%E8%AE%B0)]、[[`对基础学习完成且有了一定开发经验,想尝试解析源码的看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React深入学习与源码解析笔记)]

# `小书一阶段`

# 一、**React.js 简介**

>React.js 是一个帮助你构建页面 UI 的库。如果你熟悉 MVC 概念的话，那么 React 的组件就相当于 MVC 里面的 View。如果你不熟悉也没关系，你可以简单地理解为，React.js 将帮助我们将界面分成了各个独立的小块，每一个块就是组件，这些组件之间可以组合、嵌套，就成了我们的页面。
>
>一个组件的显示形态和行为有可能是由某些数据决定的。而数据是可能发生改变的，这时候组件的显示形态就会发生相应的改变。而 React.js 也提供了一种非常高效的方式帮助我们做到了数据和组件显示形态之间的同步。
>
>React.js 不是一个框架，它只是一个库。它只提供 UI （view）层面的解决方案。在实际的项目当中，它并不能解决我们所有的问题，需要结合其它的库，例如 Redux、React-router 等来协助提供完整的解决方法。

# 二、React前端组件化实例与总结

## 1、**前端组件化（一）：从一个简单的例子讲起**

> 先来探讨一下是什么样的问题导致了我们需要前端页面进行组件化，前端页面的组件化需要解决什么样的问题。后续再来看 React.js 是怎么解决这些问题的。

### 一个简单的点赞功能

我们会从一个简单的点赞功能讲起。 假设现在我们需要实现一个点赞、取消点赞的功能。

如果你对前端稍微有一点了解，你就顺手拈来：

HTML:

```javascript
  <body>
    <div class='wrapper'>
      <button class='like-btn'>
        <span class='like-text'>点赞</span>
        <span>👍</span>
      </button>
    </div>
  </body>
```

为了模拟现实当中的实际情况，所以这里特意把这个 `button` 里面的 HTML 结构搞得稍微复杂一些。有了这个 HTML 结构，现在就给它加入一些 JavaScript 的行为：

JavaScript：

```javascript
  const button = document.querySelector('.like-btn')
  const buttonText = button.querySelector('.like-text')
  let isLiked = false
  button.addEventListener('click', () => {
    isLiked = !isLiked
    if (isLiked) {
      buttonText.innerHTML = '取消'
    } else {
      buttonText.innerHTML = '点赞'
    }
  }, false)
```

功能和实现都很简单，按钮已经可以提供点赞和取消点赞的功能。这时候你的同事跑过来了，说他很喜欢你的按钮，他也想用你写的这个点赞功能。这时候问题就来了，你就会发现这种实现方式很致命：你的同事要把整个 `button` 和里面的结构复制过去，还有整段 JavaScript 代码也要复制过去。这样的实现方式没有任何可复用性。

### 结构复用

现在我们来重新编写这个点赞功能，让它具备一定的可复用。这次我们先写一个类，这个类有 render 方法，这个方法里面直接返回一个表示 HTML 结构的字符串：

```javascript
  class LikeButton {
    render () {
      return `
        <button id='like-btn'>
          <span class='like-text'>赞</span>
          <span>👍</span>
        </button>
      `
    }
  }
```

然后可以用这个类来构建不同的点赞功能的实例，然后把它们插到页面中。

```javascript
  const wrapper = document.querySelector('.wrapper')
  const likeButton1 = new LikeButton()
  wrapper.innerHTML = likeButton1.render()

  const likeButton2 = new LikeButton()
  wrapper.innerHTML += likeButton2.render()
```

这里非常暴力地使用了 innerHTML ，把两个按钮粗鲁地插入了 wrapper 当中。虽然你可能会对这种实现方式非常不满意，但我们还是勉强了实现了结构的复用。我们后面再来优化它。

### 实现简单的组件化

你一定会发现，现在的按钮是死的，你点击它它根本不会有什么反应。因为根本没有往上面添加事件。但是问题来了，`LikeButton` 类里面是虽然说有一个 `button`，但是这玩意根本就是在字符串里面的。你怎么能往一个字符串里面添加事件呢？DOM 事件的 API 只有 DOM 结构才能用。

我们需要 DOM 结构，准确地来说：*我们需要这个点赞功能的 HTML 字符串表示的 DOM 结构*。假设我们现在有一个函数 `createDOMFromString` ，你往这个函数传入 HTML 字符串，但是它会把相应的 DOM 元素返回给你。这个问题就可以解决了。

```javascript
// ::String => ::Document
const createDOMFromString = (domString) => {
  const div = document.createElement('div')
  div.innerHTML = domString
  return div
}
```

先不用管这个函数应该怎么实现，先知道它是干嘛的。拿来用就好，这时候用它来改写一下 `LikeButton` 类：

```javascript
  class LikeButton {
    render () {
      this.el = createDOMFromString(`
        <button class='like-button'>
          <span class='like-text'>点赞</span>
          <span>👍</span>
        </button>
      `)
      this.el.addEventListener('click', () => console.log('click'), false)
      return this.el
    }
  }
```

现在 `render()` 返回的不是一个 html 字符串了，而是一个由这个 html 字符串所生成的 DOM。在返回 DOM 元素之前会先给这个 DOM 元素上添加事件再返回。

因为现在 `render` 返回的是 DOM 元素，所以不能用 `innerHTML` 暴力地插入 wrapper。而是要用 DOM API 插进去。

```javascript
  const wrapper = document.querySelector('.wrapper')

  const likeButton1 = new LikeButton()
  wrapper.appendChild(likeButton1.render())

  const likeButton2 = new LikeButton()
  wrapper.appendChild(likeButton2.render())
```

现在你点击这两个按钮，每个按钮都会在控制台打印 `click`，说明事件绑定成功了。但是按钮上的文本还是没有发生改变，只要稍微改动一下 `LikeButton` 的代码就可以完成完整的功能：

```javascript
  class LikeButton {
    constructor () {
      this.state = { isLiked: false }
    }

    changeLikeText () {
      const likeText = this.el.querySelector('.like-text')
      this.state.isLiked = !this.state.isLiked
      likeText.innerHTML = this.state.isLiked ? '取消' : '点赞'
    }

    render () {
      this.el = createDOMFromString(`
        <button class='like-button'>
          <span class='like-text'>点赞</span>
          <span>👍</span>
        </button>
      `)
      this.el.addEventListener('click', this.changeLikeText.bind(this), false)
      return this.el
    }
  }
```

这里的代码稍微长了一些，但是还是很好理解。只不过是在给 `LikeButton` 类添加了构造函数，这个构造函数会给每一个 `LikeButton` 的实例添加一个对象 `state`，`state` 里面保存了每个按钮自己是否点赞的状态。还改写了原来的事件绑定函数：原来只打印 `click`，现在点击的按钮的时候会调用 `changeLikeText` 方法，这个方法会根据 `this.state` 的状态改变点赞按钮的文本。

现在这个组件的可复用性已经很不错了，你的同事们只要实例化一下然后插入到 DOM 里面去就好了。

下一节我们继续优化这个例子，让它更加通用。

## 2、前端组件化（二）：优化 DOM 操作

看看上一节我们的代码，仔细留意一下 `changeLikeText` 函数，这个函数包含了 DOM 操作，现在看起来比较简单，那是因为现在只有 `isLiked` 一个状态。由于数据状态改变会导致需要我们去更新页面的内容，所以假想一下，如果你的组件依赖了很多状态，那么你的组件基本全部都是 DOM 操作。

一个组件的显示形态由多个状态决定的情况非常常见。代码中混杂着对 DOM 的操作其实是一种不好的实践，手动管理数据和 DOM 之间的关系会导致代码可维护性变差、容易出错。所以我们的例子这里还有优化的空间：如何尽量减少这种手动 DOM 操作？

### 状态改变 -> 构建新的 DOM 元素更新页面

这里要提出的一种解决方案：*一旦状态发生改变，就重新调用 `render` 方法，构建一个新的 DOM 元素*。这样做的好处是什么呢？好处就是你可以在 `render` 方法里面使用最新的 `this.state` 来构造不同 HTML 结构的字符串，并且通过这个字符串构造不同的 DOM 元素。页面就更新了！听起来有点绕，看看代码怎么写，修改原来的代码为：

```javascript
  class LikeButton {
    constructor () {
      this.state = { isLiked: false }
    }

    setState (state) {
      this.state = state
      this.el = this.render()
    }

    changeLikeText () {
      this.setState({
        isLiked: !this.state.isLiked
      })
    }

    render () {
      this.el = createDOMFromString(`
        <button class='like-btn'>
          <span class='like-text'>${this.state.isLiked ? '取消' : '点赞'}</span>
          <span>👍</span>
        </button>
      `)
      this.el.addEventListener('click', this.changeLikeText.bind(this), false)
      return this.el
    }
  }
```

其实只是改了几个小地方：

1. `render` 函数里面的 HTML 字符串会根据 `this.state` 不同而不同（这里是用了 ES6 的模版字符串，做这种事情很方便）。
2. 新增一个 `setState` 函数，这个函数接受一个对象作为参数；它会设置实例的 `state`，然后重新调用一下 `render` 方法。
3. 当用户点击按钮的时候， `changeLikeText` 会构建新的 `state` 对象，这个新的 `state` ，传入 `setState` 函数当中。

这样的结果就是，用户每次点击，`changeLikeText` 都会调用改变组件状态然后调用 `setState` ；`setState` 会调用 `render` ，`render` 方法会根据 `state` 的不同重新构建不同的 DOM 元素。

也就是说，*你只要调用 `setState`，组件就会重新渲染*。我们顺利地消除了手动的 DOM 操作。

### 重新插入新的 DOM 元素

上面的改进不会有什么效果，因为你仔细看一下就会发现，其实重新渲染的 DOM 元素并没有插入到页面当中。所以在这个组件外面，你需要知道这个组件发生了改变，并且把新的 DOM 元素更新到页面当中。

重新修改一下 `setState` 方法：

```javascript
...
    setState (state) {
      const oldEl = this.el
      this.state = state
      this.el = this.render()
      if (this.onStateChange) this.onStateChange(oldEl, this.el)
    }
...
```

使用这个组件的时候：

```javascript
const likeButton = new LikeButton()
wrapper.appendChild(likeButton.render()) // 第一次插入 DOM 元素
likeButton.onStateChange = (oldEl, newEl) => {
  wrapper.insertBefore(newEl, oldEl) // 插入新的元素
  wrapper.removeChild(oldEl) // 删除旧的元素
}
```

这里每次 `setState` 都会调用 `onStateChange` 方法，而这个方法是实例化以后时候被设置的，所以你可以自定义 `onStateChange` 的行为。*这里做的事是，每当 `setState` 中构造完新的 DOM 元素以后，就会通过 `onStateChange` 告知外部插入新的 DOM 元素，然后删除旧的元素，页面就更新了*。这里已经做到了进一步的优化了：现在不需要再手动更新页面了。

非一般的暴力，因为每次 `setState` 都重新构造、新增、删除 DOM 元素，会导致浏览器进行大量的重排，严重影响性能。不过没有关系，这种暴力行为可以被一种叫 Virtual-DOM 的策略规避掉，但这不是本文所讨论的范围。

这个版本的点赞功能很不错，我可以继续往上面加功能，而且还不需要手动操作DOM。但是有一个不好的地方，如果我要重新另外做一个新组件，譬如说评论组件，那么里面的这些 `setState` 方法要重新写一遍，其实这些东西都可以抽出来，变成一个通用的模式。[下一节](http://react.huziketang.com/blog/lesson4)我们把这个通用模式抽离到一个类当中。

## 3、前端组件化（三）：抽象出公共组件类

为了让代码更灵活，可以写更多的组件，我们把这种模式抽象出来，放到一个 `Component` 类当中：

```javascript
  class Component {
    setState (state) {
      const oldEl = this.el
      this.state = state
      this._renderDOM()
      if (this.onStateChange) this.onStateChange(oldEl, this.el)
    }

    _renderDOM () {
      this.el = createDOMFromString(this.render())
      if (this.onClick) {
        this.el.addEventListener('click', this.onClick.bind(this), false)
      }
      return this.el
    }
  }
```

这个是一个组件父类 `Component`，所有的组件都可以继承这个父类来构建。它定义的两个方法，一个是我们已经很熟悉的 `setState`；一个是私有方法 `_renderDOM`。`_renderDOM` 方法会调用 `this.render` 来构建 DOM 元素并且监听 `onClick` 事件。所以，组件子类继承的时候只需要实现一个返回 HTML 字符串的 `render` 方法就可以了。

还有一个额外的 `mount` 的方法，其实就是把组件的 DOM 元素插入页面，并且在 `setState` 的时候更新页面：

```javascript
  const mount = (component, wrapper) => {
    wrapper.appendChild(component._renderDOM())
    component.onStateChange = (oldEl, newEl) => {
      wrapper.insertBefore(newEl, oldEl)
      wrapper.removeChild(oldEl)
    }
  }
```

这样的话我们重新写点赞组件就会变成：

```javascript
  class LikeButton extends Component {
    constructor () {
      super()
      this.state = { isLiked: false }
    }

    onClick () {
      this.setState({
        isLiked: !this.state.isLiked
      })
    }

    render () {
      return `
        <button class='like-btn'>
          <span class='like-text'>${this.state.isLiked ? '取消' : '点赞'}</span>
          <span>👍</span>
        </button>
      `
    }
  }

  mount(new LikeButton(), wrapper)
```

这样还不够好。在实际开发当中，你可能需要给组件传入一些自定义的配置数据。例如说想配置一下点赞按钮的背景颜色，如果我给它传入一个参数，告诉它怎么设置自己的颜色。那么这个按钮的定制性就更强了。所以我们可以给组件类和它的子类都传入一个参数 `props`，作为组件的配置参数。修改 `Component` 的构造函数为：

```javascript
...
    constructor (props = {}) {
      this.props = props
    }
...
```

继承的时候通过 `super(props)` 把 `props` 传给父类，这样就可以通过 `this.props` 获取到配置参数：

```javascript
  class LikeButton extends Component {
    constructor (props) {
      super(props)
      this.state = { isLiked: false }
    }

    onClick () {
      this.setState({
        isLiked: !this.state.isLiked
      })
    }

    render () {
      return `
        <button class='like-btn' style="background-color: ${this.props.bgColor}">
          <span class='like-text'>
            ${this.state.isLiked ? '取消' : '点赞'}
          </span>
          <span>👍</span>
        </button>
      `
    }
  }

  mount(new LikeButton({ bgColor: 'red' }), wrapper)
```

这里我们稍微修改了一下原有的 `LikeButton` 的 `render` 方法，让它可以根据传入的参数 `this.props.bgColor` 来生成不同的 `style` 属性。这样就可以自由配置组件的颜色了。

只要有了上面那个 `Component` 类和 `mount` 方法加起来不足40行代码就可以做到组件化。如果我们需要写另外一个组件，只需要像上面那样，简单地继承一下 `Component` 类就好了：

```javascript
  class RedBlueButton extends Component {
    constructor (props) {
      super(props)
      this.state = {
        color: 'red'
      }
    }

    onClick () {
      this.setState({
        color: 'blue'
      })
    }

    render () {
      return `
        <div style='color: ${this.state.color};'>${this.state.color}</div>
      `
    }
  }
```

## 4、总结

> 组件化可以帮助我们解决前端结构的复用性问题，整个页面可以由这样的不同的组件组合、嵌套构成。
>
> 一个组件有自己的显示形态（上面的 HTML 结构和内容）行为，组件的显示形态和行为可以由数据状态（state）和配置参数（props）共同决定。数据状态和配置参数的改变都会影响到这个组件的显示形态。
>
> 当数据变化的时候，组件的显示需要更新。所以如果组件化的模式能提供一种高效的方式自动化地帮助我们更新页面，那也就可以大大地降低我们代码的复杂度，带来更好的可维护性。

# 三、**React.js 基本环境安装**

> React.js 单独使用基本上是不可能的事情。不要指望着类似于 jQuery 下载放到 `<head />` 标签就开始使用。使用 React.js 不管在开发阶段生产阶段都需要一堆工具和库辅助，编译阶段你需要借助 Babel；需要 Redux 等第三方的状态管理工具来组织代码；如果你要写单页面应用那么你需要 React-router。这就是所谓的“React.js全家桶”。

### 1、安装下载依赖

> ①安装好node npm环境以后，只需要按照官网的指引安装 `create-react-app` 即可。

```
npm install -g create-react-app
```

> ②这条命令会往我们的机器上安装一条叫 `create-react-app` 的命令，安装好以后就可以直接使用它来构建一个 react 的前端工程：
>
> 这条命令会帮我们构建一个叫 `hello-react` 的工程，并且会自动地帮助我们安装所需要的依赖，现在只需要安静地等待它安装完。

```
create-react-app hello-react
```

> 注：
>
> 如果安装过程比较慢，那是很有可能是因为 npm 下载的时候是从国外的源下载的缘故。所以可以把 npm 的源改成国内的 taobao 的源，这样会加速下载过程。在执行上面的命令之前可以先修改一下 npm 的源：

```
npm config set registry https://registry.npm.taobao.org
```

> 下载完以后我们就可以启动工程了，进入工程目录然后通过 npm 启动工程：

```
cd hello-react
npm start
```



# 四、**使用 JSX 描述 UI 信息**



通过一个简单的例子讲解 React.js 描述页面 UI 的方式。把 `src/index.js` 中的代码改成：

```javascript
import React, { Component } from 'react'
import ReactDOM from 'react-dom'
import './index.css'

class Header extends Component {
  render () {
    return (
      <div>
        <h1>React 小书</h1>
      </div>
    )
  }
}

ReactDOM.render(
  <Header />,
  document.getElementById('root')
)
```

我们在文件头部从 `react` 的包当中引入了 `React` 和 React.js 的组件父类 `Component`。记住，只要你要写 React.js 组件，那么就必须要引入这两个东西。

`ReactDOM` 可以帮助我们把 React 组件渲染到页面上去，没有其它的作用了。你可以发现它是从 `react-dom` 中引入的，而不是从 `react` 引入。有些朋友可能会疑惑，为什么不把这些东西都包含在 `react` 包当中呢？我们稍后会回答这个问题。

接下来的代码你看起来会比较熟悉，但又会有点陌生。你看其实它跟我们前几节里面讲的内容其实很类似，一个组件继承 `Component` 类，有一个 `render` 方法，并且把这个组件的 HTML 结构返回；这里 return 的东西就比较奇怪了，它并不是一个字符串，看起来像是纯 HTML 代码写在 JavaScript 代码里面。你也许会说，这不就有语法错误了么？这完全不是合法的 JavaScript 代码。这种看起来“在 JavaScript 写的标签的”语法叫 JSX。

## 1、JSX 原理

为了让大家深刻理解 JSX 的含义。有必要简单介绍了一下 JSX 稍微底层的运作原理，这样大家可以更加深刻理解 JSX 到底是什么东西，为什么要有这种语法，它是经过怎么样的转化变成页面的元素的。

思考一个问题：如何用 JavaScript 对象来表现一个 DOM 元素的结构，举个例子：

```html
<div class='box' id='content'>
  <div class='title'>Hello</div>
  <button>Click</button>
</div>
```

每个 DOM 元素的结构都可以用 JavaScript 的对象来表示。你会发现一个 DOM 元素包含的信息其实只有三个：标签名，属性，子元素。

所以其实上面这个 HTML 所有的信息我们都可以用合法的 JavaScript 对象来表示：

```javascript
{
  tag: 'div',
  attrs: { className: 'box', id: 'content'},
  children: [
    {
      tag: 'div',
      arrts: { className: 'title' },
      children: ['Hello']
    },
    {
      tag: 'button',
      attrs: null,
      children: ['Click']
    }
  ]
}
```

你会发现，HTML 的信息和 JavaScript 所包含的结构和信息其实是一样的，我们可以用 JavaScript 对象来描述所有能用 HTML 表示的 UI 信息。但是用 JavaScript 写起来太长了，结构看起来又不清晰，用 HTML 的方式写起来就方便很多了。

于是 React.js 就把 JavaScript 的语法扩展了一下，让 JavaScript 语言能够支持这种直接在 JavaScript 代码里面编写类似 HTML 标签结构的语法，这样写起来就方便很多了。编译的过程会把类似 HTML 的 JSX 结构转换成 JavaScript 的对象结构。

上面的代码：

```javascript
import React, { Component } from 'react'
import ReactDOM from 'react-dom'
import './index.css'

class Header extends Component {
  render () {
    return (
      <div>
        <h1 className='title'>React 小书</h1>
      </div>
    )
  }
}

ReactDOM.render(
  <Header />,
  document.getElementById('root')
)
```

经过编译以后会变成：

```javascript
import React, { Component } from 'react'
import ReactDOM from 'react-dom'
import './index.css'

class Header extends Component {
  render () {
    return (
     React.createElement(
        "div",
        null,
        React.createElement(
          "h1",
          { className: 'title' },
          "React 小书"
        )
      )
    )
  }
}

ReactDOM.render(
  React.createElement(Header, null), 
  document.getElementById('root')
);
```

`React.createElement` 会构建一个 JavaScript 对象来描述你 HTML 结构的信息，包括标签名、属性、还有子元素等。这样的代码就是合法的 JavaScript 代码了。所以使用 React 和 JSX 的时候一定要经过编译的过程。

这里再重复一遍：*所谓的 JSX 其实就是 JavaScript 对象*。每当在 JavaScript 代码中看到这种 JSX 结构的时候，脑子里面就可以自动做转化，这样对你理解 React.js 的组件写法很有好处。

有了这个表示 HTML 结构和信息的对象以后，就可以拿去构造真正的 DOM 元素，然后把这个 DOM 元素塞到页面上。这也是我们最后一段代码中 `ReactDOM.render` 所干的事情：

```javascript
ReactDOM.render(
  <Header />,
  document.getElementById('root')
)
```

`ReactDOM.render` 功能就是把组件渲染并且构造 DOM 树，然后插入到页面上某个特定的元素上（在这里是 id 为 `root` 的 `div` 元素）。

所以可以总结一下从 JSX 到页面到底经过了什么样的过程：

[![JSX 描述 React.js 组件图片](http://huzidaha.github.io/static/assets/img/posts/44B5EC06-EAEB-4BA2-B3DC-325703E4BA45.png)](http://huzidaha.github.io/static/assets/img/posts/44B5EC06-EAEB-4BA2-B3DC-325703E4BA45.png)

有些人可能会问，为什么不直接从 JSX 直接渲染构造 DOM 结构，而是要经过中间这么一层呢？

第一个原因是，当我们拿到一个表示 UI 的结构和信息的对象以后，不一定会把元素渲染到浏览器的普通页面上，我们有可能把这个结构渲染到 canvas 上，或者是手机 App 上。所以这也是为什么会要把 `react-dom` 单独抽离出来的原因，可以想象有一个叫 `react-canvas` 可以帮我们把 UI 渲染到 canvas 上，或者是有一个叫 `react-app` 可以帮我们把它转换成原生的 App（实际上这玩意叫 `ReactNative`）。

第二个原因是，有了这样一个对象。当数据变化，需要更新组件的时候，就可以用比较快的算法操作这个 JavaScript 对象，而不用直接操作页面上的 DOM，这样可以尽量少的减少浏览器重排，极大地优化性能。这个在以后的章节中我们会提到。

## 2、总结

要记住几个点：

1. JSX 是 JavaScript 语言的一种语法扩展，长得像 HTML，但并不是 HTML。
2. React.js 可以用 JSX 来描述你的组件长什么样的。
3. JSX 在编译的时候会变成相应的 JavaScript 对象描述。
4. `react-dom` 负责把这个用来描述 UI 信息的 JavaScript 对象变成 DOM 元素，并且渲染到页面上。

# 五、**组件的 render 方法**

React.js 中一切皆组件，用 React.js 写的其实就是 React.js 组件。我们在编写 React.js 组件的时候，一般都需要继承 React.js 的 `Component`（还有别的编写组件的方式我们后续会提到）。一个组件类必须要实现一个 `render` 方法，这个 `render` 方法必须要返回一个 JSX 元素。但这里要注意的是，必须要用一个外层的 JSX 元素把所有内容包裹起来。返回并列多个 JSX 元素是不合法的，下面是错误的做法：

```javascript
...
render () {
  return (
    <div>第一个</div>
    <div>第二个</div>
  )
}
...
```

必须要用一个外层元素把内容进行包裹：

```javascript
...
render () {
  return (
    <div>
      <div>第一个</div>
      <div>第二个</div>
    </div>
  )
}
...
```

## 1、表达式插入

在 JSX 当中你可以插入 JavaScript 的表达式，表达式返回的结果会相应地渲染到页面上。表达式用 `{}` 包裹。例如：

```javascript
...
render () {
  const word = 'is good'
  return (
    <div>
      <h1>React 小书 {word}</h1>
    </div>
  )
}
...
```

页面上就显示“React 小书 is good”。你也可以把它改成 `{1 + 2}`，它就会显示 “React 小书 3”。你也可以把它写成一个函数表达式返回：

```javascript
...
render () {
  return (
    <div>
      <h1>React 小书 {(function () { return 'is good'})()}</h1>
    </div>
  )
}
...
```

简而言之，`{}` 内可以放任何 JavaScript 的代码，包括变量、表达式计算、函数执行等等。 `render` 会把这些代码返回的内容如实地渲染到页面上，非常的灵活。

表达式插入不仅仅可以用在标签内部，也可以用在标签的属性上，例如：

```javascript
...
render () {
  const className = 'header'
  return (
    <div className={className}>
      <h1>React 小书</h1>
    </div>
  )
}
...
```

这样就可以为 `div` 标签添加一个叫 `header` 的类名。

注意，直接使用 `class` 在 React.js 的元素上添加类名如 `<div class=“xxx”>` 这种方式是不合法的。因为 `class` 是 JavaScript 的关键字，所以 React.js 中定义了一种新的方式：`className` 来帮助我们给元素添加类名。

还有一个特例就是 `for` 属性，例如 `<label for='male'>Male</label>`，因为 `for` 也是 JavaScript 的关键字，所以在 JSX 用 `htmlFor` 替代，即 `<label htmlFor='male'>Male</label>`。而其他的 HTML 属性例如 `style` 、`data-*` 等就可以像普通的 HTML 属性那样直接添加上去。

## 2、条件返回

`{}` 上面说了，JSX 可以放置任何表达式内容。所以也可以放 JSX，实际上，我们可以在 `render` 函数内部根据不同条件返回不同的 JSX。例如：

```javascript
...
render () {
  const isGoodWord = true
  return (
    <div>
      <h1>
        React 小书
        {isGoodWord
          ? <strong> is good</strong>
          : <span> is not good</span>
        }
      </h1>
    </div>
  )
}
...
```

上面的代码中定义了一个 `isGoodWord` 变量为 `true`，下面有个用 `{}` 包含的表达式，根据 `isGoodWord` 的不同返回不同的 JSX 内容。现在页面上是显示 `React 小书 is good`。如果你把 `isGoodWord` 改成 `false` 然后再看页面上就会显示 `React 小书 is not good`。

如果你在表达式插入里面返回 `null` ，那么 React.js 会什么都不显示，相当于忽略了该表达式插入。结合条件返回的话，我们就做到显示或者隐藏某些元素：

```javascript
...
render () {
  const isGoodWord = true
  return (
    <div>
      <h1>
        React 小书
        {isGoodWord
          ? <strong> is good</strong>
          : null
        }
      </h1>
    </div>
  )
}
...
```

这样就相当于在 `isGoodWord` 为 `true` 的时候显示 `<strong>is good</strong>`，否则就隐藏。

条件返回 JSX 的方式在 React.js 中很常见，组件的呈现方式随着数据的变化而不一样，你可以利用 JSX 这种灵活的方式随时组合构建不同的页面结构。

## 3、JSX 元素变量

同样的，如果你能理解 JSX 元素就是 JavaScript 对象。那么你就可以联想到，JSX 元素其实可以像 JavaScript 对象那样自由地赋值给变量，或者作为函数参数传递、或者作为函数的返回值。

```javascript
...
render () {
  const isGoodWord = true
  const goodWord = <strong> is good</strong>
  const badWord = <span> is not good</span>
  return (
    <div>
      <h1>
        React 小书
        {isGoodWord ? goodWord : badWord}
      </h1>
    </div>
  )
}
...
```

这里给把两个 JSX 元素赋值给了 `goodWord` 和 `badWord` 两个变量，然后把它们作为表达式插入的条件返回值。达到效果和上面的例子一样，随机返回不同的页面效果呈现。

再举一个例子：

```javascript
...
renderGoodWord (goodWord, badWord) {
  const isGoodWord = true
  return isGoodWord ? goodWord : badWord
}

render () {
  return (
    <div>
      <h1>
        React 小书
        {this.renderGoodWord(
          <strong> is good</strong>,
          <span> is not good</span>
        )}
      </h1>
    </div>
  )
}
...
```

这里我们定义了一个 `renderGoodWord` 函数，这个函数接受两个 JSX 元素作为参数，并且随机返回其中一个。在 `render` 方法中，我们把上面例子的两个 JSX 元素传入 `renderGoodWord` 当中，通过表达式插入把该函数返回的 JSX 元素插入到页面上。

# 六、**组件的组合、嵌套和组件树**

继续拓展前面的例子，现在我们已经有了 `Header` 组件了。假设我们现在构建一个新的组件叫 `Title`，它专门负责显示标题。你可以在 `Header` 里面使用 `Title`组件：

```javascript
class Title extends Component {
  render () {
    return (
      <h1>React 小书</h1>
    )
  }
}

class Header extends Component {
  render () {
    return (
      <div>
        <Title />
      </div>
    )
  }
}
```

我们可以直接在 `Header` 标签里面直接使用 `Title` 标签。就像是一个普通的标签一样。React.js 会在 `<Title />` 所在的地方把 `Title` 组件的 `render` 方法表示的 JSX 内容渲染出来，也就是说 `<h1>React 小书</h1>` 会显示在相应的位置上。如果现在我们在 `Header` 里面使用三个 `<Title />` ，那么就会有三个 `<h1 />` 显示在页面上。

```html
<div>
  <Title />
  <Title />
  <Title />
</div>
```

这样可复用性非常强，我们可以把组件的内容封装好，然后灵活在使用在任何组件内。另外这里要注意的是，*自定义的组件都必须要用大写字母开头，普通的 HTML 标签都用小写字母开头*。

现在让组件多起来。我们来构建额外的组件来构建页面，假设页面是由 `Header` 、`Main` 、`Footer` 几个部分组成，由一个 `Index` 把它们组合起来。

```javascript
import React, { Component } from 'react';
import ReactDOM from 'react-dom';

class Title extends Component {
  render () {
    return (
      <h1>React 小书</h1>
    )
  }
}

class Header extends Component {
  render () {
    return (
    <div>
      <Title />
      <h2>This is Header</h2>
    </div>
    )
  }
}

class Main extends Component {
  render () {
    return (
    <div>
      <h2>This is main content</h2>
    </div>
    )
  }
}

class Footer extends Component {
  render () {
    return (
    <div>
      <h2>This is footer</h2>
    </div>
    )
  }
}

class Index extends Component {
  render () {
    return (
      <div>
        <Header />
        <Main />
        <Footer />
      </div>
    )
  }
}

ReactDOM.render(
  <Index />,
  document.getElementById('root')
)
```

组件可以和组件组合在一起，组件内部可以使用别的组件。就像普通的 HTML 标签一样使用就可以。这样的组合嵌套，最后构成一个所谓的组件树，就正如上面的例子那样，`Index` 用了 `Header`、`Main`、`Footer`，`Header` 又使用了 `Title` 。这样用这样的树状结构表示它们之间的关系：

[![React.js 小书组件嵌套](http://huzidaha.github.io/static/assets/img/posts/19BBE4E2-A12E-4657-BA6A-61484F67FA60.png)](http://huzidaha.github.io/static/assets/img/posts/19BBE4E2-A12E-4657-BA6A-61484F67FA60.png)

这里的结构还是比较简单，因为我们的页面结构并不复杂。当页面结构复杂起来，有许多不同的组件嵌套组合的话，组件树会相当的复杂和庞大。理解组件树的概念对后面理解数据是如何在组件树内自上往下流动过程很重要。

# 七、**事件监听**

在 React.js 里面监听事件是很容易的事情，你只需要给需要监听事件的元素加上属性类似于 `onClick`、`onKeyDown` 这样的属性，例如我们现在要给 `Title` 加上点击的事件监听：

```javascript
class Title extends Component {
  handleClickOnTitle () {
    console.log('Click on title.')
  }

  render () {
    return (
      <h1 onClick={this.handleClickOnTitle}>React 小书</h1>
    )
  }
}
```

只需要给 `h1` 标签加上 `onClick` 的事件，`onClick` 紧跟着是一个表达式插入，这个表达式返回一个 `Title` 自己的一个实例方法。当用户点击 `h1` 的时候，React.js 就会调用这个方法，所以你在控制台就可以看到 `Click on title.` 打印出来。

在 React.js 不需要手动调用浏览器原生的 `addEventListener` 进行事件监听。React.js 帮我们封装好了一系列的 `on*` 的属性，当你需要为某个元素监听某个事件的时候，只需要简单地给它加上 `on*` 就可以了。而且你不需要考虑不同浏览器兼容性的问题，React.js 都帮我们封装好这些细节了。

React.js 封装了不同类型的事件，这里就不一一列举，有兴趣的同学可以参考官网文档： [SyntheticEvent - React](https://facebook.github.io/react/docs/events.html#supported-events)，多尝试不同的事件。另外要注意的是，这些事件属性名都必须要用驼峰命名法。

没有经过特殊处理的话，*这些 `on\*` 的事件监听只能用在普通的 HTML 的标签上，而不能用在组件标签上*。也就是说，`<Header onClick={…} />` 这样的写法不会有什么效果的。这一点要注意，但是有办法可以做到这样的绑定，以后我们会提及。现在只要记住一点就可以了：这些 `on*` 的事件监听只能用在普通的 HTML 的标签上，而不能用在组件标签上。

## 1、event 对象

和普通浏览器一样，事件监听函数会被自动传入一个 `event` 对象，这个对象和普通的浏览器 `event` 对象所包含的方法和属性都基本一致。不同的是 React.js 中的 `event` 对象并不是浏览器提供的，而是它自己内部所构建的。React.js 将浏览器原生的 `event` 对象封装了一下，对外提供统一的 API 和属性，这样你就不用考虑不同浏览器的兼容性问题。这个 `event` 对象是符合 W3C 标准（ [W3C UI Events](https://www.w3.org/TR/DOM-Level-3-Events/) ）的，它具有类似于`event.stopPropagation`、`event.preventDefault` 这种常用的方法。

我们来尝试一下，这次尝试当用户点击 `h1` 的时候，把 `h1` 的 `innerHTML` 打印出来：

```javascript
class Title extends Component {
  handleClickOnTitle (e) {
    console.log(e.target.innerHTML)
  }

  render () {
    return (
      <h1 onClick={this.handleClickOnTitle}>React 小书</h1>
    )
  }
}
```

再看看控制台，每次点击的时候就会打印”React 小书“。

## 2、关于事件中的 this

一般在某个类的实例方法里面的 `this` 指的是这个实例本身。但是你在上面的 `handleClickOnTitle` 中把 `this` 打印出来，你会看到 `this` 是 `null` 或者 `undefined`。

```javascript
...
  handleClickOnTitle (e) {
    console.log(this) // => null or undefined
  }
...
```

这是因为 React.js 调用你所传给它的方法的时候，并不是通过对象方法的方式调用（`this.handleClickOnTitle`），而是直接通过函数调用 （`handleClickOnTitle`），所以事件监听函数内并不能通过 `this` 获取到实例。

如果你想在事件函数当中使用当前的实例，你需要手动地将实例方法 `bind` 到当前实例上再传入给 React.js。

```javascript
class Title extends Component {
  handleClickOnTitle (e) {
    console.log(this)
  }

  render () {
    return (
      <h1 onClick={this.handleClickOnTitle.bind(this)}>React 小书</h1>
    )
  }
}
```

`bind` 会把实例方法绑定到当前实例上，然后我们再把绑定后的函数传给 React.js 的 `onClick` 事件监听。这时候你再看看，点击 `h1` 的时候，就会把当前的实例打印出来

你也可以在 `bind` 的时候给事件监听函数传入一些参数：

```javascript
class Title extends Component {
  handleClickOnTitle (word, e) {
    console.log(this, word)
  }

  render () {
    return (
      <h1 onClick={this.handleClickOnTitle.bind(this, 'Hello')}>React 小书</h1>
    )
  }
}
```

这种 `bind` 模式在 React.js 的事件监听当中非常常见，`bind` 不仅可以帮我们把事件监听方法中的 `this` 绑定到当前组件实例上；还可以帮助我们在在渲染列表元素的时候，把列表元素传入事件监听函数当中——这个将在以后的章节提及。

bind是JavaScript 的 [this](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/this) 和 [bind](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Function/bind) 相关的知识

## 3、总结

> 为 React 的组件添加事件监听是很简单的事情，你只需要使用 React.js 提供了一系列的 `on*` 方法即可。
>
> React.js 会给每个事件监听传入一个 `event` 对象，这个对象提供的功能和浏览器提供的功能一致，而且它是兼容所有浏览器的。
>
> React.js 的事件监听方法需要手动 `bind` 到当前实例，这种模式在 React.js 中非常常用。

# 八、**组件的 state 和 setState**

## 1、state

我们前面提到过，一个组件的显示形态是可以由它数据状态和配置参数决定的。一个组件可以拥有自己的状态，就像一个点赞按钮，可以有“已点赞”和“未点赞”状态，并且可以在这两种状态之间进行切换。React.js 的 `state` 就是用来存储这种可变化的状态的。

我们还是拿点赞按钮做例子，它具有已点赞和未点赞两种状态。那么就可以把这个状态存储在 state 中。修改 `src/index.js` 为：

```javascript
import React, { Component } from 'react'
import ReactDOM from 'react-dom'
import './index.css'

class LikeButton extends Component {
  constructor () {
    super()
    this.state = { isLiked: false }
  }

  handleClickOnLikeButton () {
    this.setState({
      isLiked: !this.state.isLiked
    })
  }

  render () {
    return (
      <button onClick={this.handleClickOnLikeButton.bind(this)}>
        {this.state.isLiked ? '取消' : '点赞'} 👍
      </button>
    )
  }
}
...
```

`isLiked` 存放在实例的 `state` 对象当中，这个对象在构造函数里面初始化。这个组件的 `render` 函数内，会根据组件的 `state` 的中的`isLiked`不同显示“取消”或“点赞”内容。并且给 `button` 加上了点击的事件监听。

最后构建一个 `Index` ，在它的 `render` 函数内使用 `LikeButton` 。然后把 `Index` 渲染到页面上：

```javascript
...
class Index extends Component {
  render () {
    return (
      <div>
        <LikeButton />
      </div>
    )
  }
}

ReactDOM.render(
  <Index />,
  document.getElementById('root')
)
```

## 2、setState 接受对象参数

在 `handleClickOnLikeButton` 事件监听函数里面，大家可以留意到，我们调用了 `setState` 函数，每次点击都会更新 `isLiked` 属性为 `!isLiked`，这样就可以做到点赞和取消功能。

`setState` 方法由父类 `Component` 所提供。*当我们调用这个函数的时候，React.js 会更新组件的状态 `state` ，并且重新调用 `render` 方法，然后再把 `render` 方法所渲染的最新的内容显示到页面上*。

注意，当我们要改变组件的状态的时候，不能直接用 `this.state = xxx` 这种方式来修改，如果这样做 React.js 就没办法知道你修改了组件的状态，它也就没有办法更新页面。所以，一定要使用 React.js 提供的 `setState` 方法，*它接受一个对象或者函数作为参数*。

传入一个对象的时候，这个对象表示该组件的新状态。但你只需要传入需要更新的部分就可以了，而不需要传入整个对象。例如，假设现在我们有另外一个状态 `name` ：

```javascript
...
  constructor (props) {
    super(props)
    this.state = {
      name: 'Tomy',
      isLiked: false
    }
  }

  handleClickOnLikeButton () {
    this.setState({
      isLiked: !this.state.isLiked
    })
  }
...
```

因为点击的时候我们并不需要修改 `name`，所以只需要传入 `isLiked` 就行了。Tomy 还是那个 Tomy，而 `isLiked` 已经不是那个 `isLiked` 了。

## 3、setState 接受函数参数

这里还有要注意的是，当你调用 `setState` 的时候，*React.js 并不会马上修改 state*。而是把这个对象放到一个更新队列里面，稍后才会从队列当中把新的状态提取出来合并到 `state` 当中，然后再触发组件更新。这一点要好好注意。可以体会一下下面的代码：

```javascript
...
  handleClickOnLikeButton () {
    console.log(this.state.isLiked)
    this.setState({
      isLiked: !this.state.isLiked
    })
    console.log(this.state.isLiked)
  }
...
```

你会发现两次打印的都是 `false`，即使我们中间已经 `setState` 过一次了。这并不是什么 bug，只是 React.js 的 `setState` 把你的传进来的状态缓存起来，稍后才会帮你更新到 `state` 上，所以你获取到的还是原来的 `isLiked`。

所以如果你想在 `setState` 之后使用新的 `state` 来做后续运算就做不到了，例如：

```javascript
...
  handleClickOnLikeButton () {
    this.setState({ count: 0 }) // => this.state.count 还是 undefined
    this.setState({ count: this.state.count + 1}) // => undefined + 1 = NaN
    this.setState({ count: this.state.count + 2}) // => NaN + 2 = NaN
  }
...
```

上面的代码的运行结果并不能达到我们的预期，我们希望 `count` 运行结果是 `3` ，可是最后得到的是 `NaN`。但是这种后续操作依赖前一个 `setState` 的结果的情况并不罕见。

这里就自然地引出了 `setState` 的第二种使用方式，可以接受一个函数作为参数。React.js 会把上一个 `setState` 的结果传入这个函数，你就可以使用该结果进行运算、操作，然后返回一个对象作为更新 `state` 的对象：

```javascript
...
  handleClickOnLikeButton () {
    this.setState((prevState) => {
      return { count: 0 }
    })
    this.setState((prevState) => {
      return { count: prevState.count + 1 } // 上一个 setState 的返回是 count 为 0，当前返回 1
    })
    this.setState((prevState) => {
      return { count: prevState.count + 2 } // 上一个 setState 的返回是 count 为 1，当前返回 3
    })
    // 最后的结果是 this.state.count 为 3
  }
...
```

这样就可以达到上述的*利用上一次 `setState` 结果进行运算*的效果。

## 4、setState 合并

上面我们进行了三次 `setState`，但是实际上组件只会重新渲染一次，而不是三次；这是因为在 React.js 内部会把 JavaScript 事件循环中的消息队列的同一个消息中的 `setState` 都进行合并以后再重新渲染组件。

深层的原理并不需要过多纠结，你只需要记住的是：在使用 React.js 的时候，并不需要担心多次进行 `setState` 会带来性能问题。

# 九、**配置组件的 props**

组件是相互独立、可复用的单元，一个组件可能在不同地方被用到。但是在不同的场景下对这个组件的需求可能会根据情况有所不同，例如一个点赞按钮组件，在我这里需要它显示的文本是“点赞”和“取消”，当别的同事拿过去用的时候，却需要它显示“赞”和“已赞”。如何让组件能适应不同场景下的需求，我们就要让组件具有一定的“可配置”性。

React.js 的 `props` 就可以帮助我们达到这个效果。每个组件都可以接受一个 `props` 参数，它是一个对象，包含了所有你对这个组件的配置。就拿我们点赞按钮做例子

下面的代码可以让它达到上述的可配置性：

```javascript
class LikeButton extends Component {
  constructor () {
    super()
    this.state = { isLiked: false }
  }

  handleClickOnLikeButton () {
    this.setState({
      isLiked: !this.state.isLiked
    })
  }

  render () {
    const likedText = this.props.likedText || '取消'
    const unlikedText = this.props.unlikedText || '点赞'
    return (
      <button onClick={this.handleClickOnLikeButton.bind(this)}>
        {this.state.isLiked ? likedText : unlikedText} 👍
      </button>
    )
  }
}
```

从 `render` 函数可以看出来，组件内部是通过 `this.props` 的方式获取到组件的参数的，如果 `this.props` 里面有需要的属性我们就采用相应的属性，没有的话就用默认的属性。

那么怎么把 `props` 传进去呢？*在使用一个组件的时候，可以把参数放在标签的属性当中，所有的属性都会作为 `props` 对象的键值*：

```javascript
class Index extends Component {
  render () {
    return (
      <div>
        <LikeButton likedText='已赞' unlikedText='赞' />
      </div>
    )
  }
}
```

就像你在用普通的 HTML 标签的属性一样，可以把参数放在表示组件的标签上，组件内部就可以通过 `this.props` 来访问到这些配置参数了。

前面的章节我们说过，JSX 的表达式插入可以在标签属性上使用。所以其实可以把任何类型的数据作为组件的参数，包括字符串、数字、对象、数组、甚至是函数等等。例如现在我们把一个对象传给点赞组件作为参数：

```javascript
class Index extends Component {
  render () {
    return (
      <div>
        <LikeButton wordings={{likedText: '已赞', unlikedText: '赞'}} />
      </div>
    )
  }
}
```

现在我们把 `likedText` 和 `unlikedText` 这两个参数封装到一个叫 `wordings` 的对象参数内，然后传入点赞组件中。大家看到 `{{likedText: '已赞', unlikedText: '赞'}}` 这样的代码的时候，不要以为是什么新语法。之前讨论过，JSX 的 `{}` 内可以嵌入任何表达式，`{{}}` 就是在 `{}` 内部用对象字面量返回一个对象而已。

这时候，点赞按钮的内部就要用 `this.props.wordings` 来获取到到参数了：

```javascript
class LikeButton extends Component {
  constructor () {
    super()
    this.state = { isLiked: false }
  }

  handleClickOnLikeButton () {
    this.setState({
      isLiked: !this.state.isLiked
    })
  }

  render () {
    const wordings = this.props.wordings || {
      likedText: '取消',
      unlikedText: '点赞'
    }
    return (
      <button onClick={this.handleClickOnLikeButton.bind(this)}>
        {this.state.isLiked ? wordings.likedText : wordings.unlikedText} 👍
      </button>
    )
  }
}
```

甚至可以往组件内部传入函数作为参数：

```javascript
class Index extends Component {
  render () {
    return (
      <div>
        <LikeButton
          wordings={{likedText: '已赞', unlikedText: '赞'}}
          onClick={() => console.log('Click on like button!')}/>
      </div>
    )
  }
}
```

这样可以通过 `this.props.onClick` 获取到这个传进去的函数，修改 `LikeButton `的 `handleClickOnLikeButton` 方法：

```javascript
...
  handleClickOnLikeButton () {
    this.setState({
      isLiked: !this.state.isLiked
    })
    if (this.props.onClick) {
      this.props.onClick()
    }
  }
...
```

当每次点击按钮的时候，控制台会显示 `Click on like button!` 。但这个行为不是点赞组件自己实现的，而是我们传进去的。所以，一个组件的行为、显示形态都可以用 `props` 来控制，就可以达到很好的可配置性。

## 1、默认配置 defaultProps

上面的组件默认配置我们是通过 `||` 操作符来实现。这种需要默认配置的情况在 React.js 中非常常见，所以 React.js 也提供了一种方式 `defaultProps`，可以方便的做到默认配置。

```javascript
class LikeButton extends Component {
  static defaultProps = {
    likedText: '取消',
    unlikedText: '点赞'
  }

  constructor () {
    super()
    this.state = { isLiked: false }
  }

  handleClickOnLikeButton () {
    this.setState({
      isLiked: !this.state.isLiked
    })
  }

  render () {
    return (
      <button onClick={this.handleClickOnLikeButton.bind(this)}>
        {this.state.isLiked
          ? this.props.likedText
          : this.props.unlikedText} 👍
      </button>
    )
  }
}
```

注意，我们给点赞组件加上了以下的代码：

```javascript
  static defaultProps = {
    likedText: '取消',
    unlikedText: '点赞'
  }
```

`defaultProps` 作为点赞按钮组件的类属性，里面是对 `props` 中各个属性的默认配置。这样我们就不需要判断配置属性是否传进来了：如果没有传进来，会直接使用 `defaultProps` 中的默认属性。 所以可以看到，在 `render` 函数中，我们会直接使用 `this.props` 而不需要再做判断。

## 2、props 不可变

`props` 一旦传入进来就不能改变。修改上面的例子中的 `handleClickOnLikeButton` ：

```javascript
...
  handleClickOnLikeButton () {
    this.props.likedText = '取消'
    this.setState({
      isLiked: !this.state.isLiked
    })
  }
...
```

我们尝试在用户点击按钮的时候改变 `this.props.likedText` ，然后你会看到控制台报错了

你不能改变一个组件被渲染的时候传进来的 `props`。React.js 希望一个组件在输入确定的 `props` 的时候，能够输出确定的 UI 显示形态。如果 `props` 渲染过程中可以被修改，那么就会导致这个组件显示形态和行为变得不可预测，这样会可能会给组件使用者带来困惑。

但这并不意味着由 `props` 决定的显示形态不能被修改。组件的使用者可以*主动地通过重新渲染的方式*把新的 `props` 传入组件当中，这样这个组件中由 `props` 决定的显示形态也会得到相应的改变。

修改上面的例子的 `Index` 组件：

```javascript
class Index extends Component {
  constructor () {
    super()
    this.state = {
      likedText: '已赞',
      unlikedText: '赞'
    }
  }

  handleClickOnChange () {
    this.setState({
      likedText: '取消',
      unlikedText: '点赞'
    })
  }

  render () {
    return (
      <div>
        <LikeButton
          likedText={this.state.likedText}
          unlikedText={this.state.unlikedText} />
        <div>
          <button onClick={this.handleClickOnChange.bind(this)}>
            修改 wordings
          </button>
        </div>
      </div>
    )
  }
}
```

在这里，我们把 `Index` 的 `state` 中的 `likedText` 和 `unlikedText` 传给 `LikeButton` 。`Index` 还有另外一个按钮，点击这个按钮会通过 `setState` 修改 `Index` 的 `state` 中的两个属性。

由于 `setState` 会导致 `Index` 重新渲染，所以 `LikedButton` 会接收到新的 `props`，并且重新渲染，于是它的显示形态也会得到更新。这就是通过重新渲染的方式来传入新的 `props` 从而达到修改 `LikedButton` 显示形态的效果。

## 3、总结

1. 为了使得组件的可定制性更强，在使用组件的时候，可以在标签上加属性来传入配置参数。
2. 组件可以在内部通过 `this.props` 获取到配置参数，组件可以根据 `props` 的不同来确定自己的显示形态，达到可配置的效果。
3. 可以通过给组件添加类属性 `defaultProps` 来配置默认参数。
4. `props` 一旦传入，你就不可以在组件内部对它进行修改。但是你可以通过父组件主动重新渲染的方式来传入新的 `props`，从而达到更新的效果。

# 十、**state vs props的总结**

我们来一个关于 `state` 和 `props` 的总结。

`state` 的主要作用是用于组件保存、控制、修改*自己*的可变状态。`state` 在组件内部初始化，可以被组件自身修改，而外部不能访问也不能修改。你可以认为 `state` 是一个局部的、只能被组件自身控制的数据源。`state` 中状态可以通过 `this.setState` 方法进行更新，`setState` 会导致组件的重新渲染。

`props` 的主要作用是让使用该组件的父组件可以传入参数来配置该组件。它是外部传进来的配置参数，组件内部无法控制也无法修改。除非外部组件主动传入新的 `props`，否则组件的 `props` 永远保持不变。

`state` 和 `props` 有着千丝万缕的关系。它们都可以决定组件的行为和显示形态。一个组件的 `state` 中的数据可以通过 `props` 传给子组件，一个组件可以使用外部传入的 `props` 来初始化自己的 `state`。但是它们的职责其实非常明晰分明：*`state` 是让组件控制自己的状态，`props` 是让外部对组件自己进行配置*。

如果你觉得还是搞不清 `state` 和 `props` 的使用场景，那么请记住一个简单的规则：尽量少地用 `state`，尽量多地用 `props`。

没有 `state` 的组件叫无状态组件（stateless component），设置了 state 的叫做有状态组件（stateful component）。因为状态会带来管理的复杂性，我们尽量多地写无状态组件，尽量少地写有状态的组件。这样会降低代码维护的难度，也会在一定程度上增强组件的可复用性。前端应用状态管理是一个复杂的问题，我们后续会继续讨论。

React.js 非常鼓励无状态组件，在 0.14 版本引入了函数式组件——一种定义不能使用 `state` 组件，例如一个原来这样写的组件：

```javascript
class HelloWorld extends Component {
  constructor() {
    super()
  }

  sayHi () {
    alert('Hello World')
  }

  render () {
    return (
      <div onClick={this.sayHi.bind(this)}>Hello World</div>
    )
  }
}
```

用函数式组件的编写方式就是：

```javascript
const HelloWorld = (props) => {
  const sayHi = (event) => alert('Hello World')
  return (
    <div onClick={sayHi}>Hello World</div>
  )
}
```

以前一个组件是通过继承 `Component` 来构建，一个子类就是一个组件。而用函数式的组件编写方式是一个函数就是一个组件，你可以和以前一样通过 `<HellWorld />` 使用该组件。不同的是，函数式组件只能接受 `props` 而无法像跟类组件一样可以在 `constructor` 里面初始化 `state`。你可以理解函数式组件就是一种只能接受 `props` 和提供 `render` 方法的类组件。

但胡子大哈的小书全书不采用这种函数式的方式来编写组件，统一通过继承 `Component` 来构建组件。其他写法我将在官方文档的学习笔记中指出

# 十一、**渲染列表数据**

列表数据在前端非常常见，我们经常要处理这种类型的数据，例如文章列表、评论列表、用户列表…一个前端工程师几乎每天都需要跟列表数据打交道。

React.js 当然也允许我们处理列表数据，但在使用 React.js 处理列表数据的时候，需要掌握一些规则。我们这一节会专门讨论这方面的知识。

## 1、渲染存放 JSX 元素的数组

假设现在我们有这么一个用户列表数据，存放在一个数组当中：

```javascript
const users = [
  { username: 'Jerry', age: 21, gender: 'male' },
  { username: 'Tomy', age: 22, gender: 'male' },
  { username: 'Lily', age: 19, gender: 'female' },
  { username: 'Lucy', age: 20, gender: 'female' }
]
```

如果现在要把这个数组里面的数据渲染页面上要怎么做？开始之前要补充一个知识。之前说过 JSX 的表达式插入 `{}` 里面可以放任何数据，如果我们往 `{}` 里面放一个存放 JSX 元素的数组会怎么样？

```javascript
...

class Index extends Component {
  render () {
    return (
      <div>
        {[
          <span>React.js </span>,
          <span>is </span>,
          <span>good</span>
        ]}
      </div>
    )
  }
}

ReactDOM.render(
  <Index />,
  document.getElementById('root')
)
```

我们往 JSX 里面塞了一个数组，这个数组里面放了一些 JSX 元素（其实就是 JavaScript 对象）。到浏览器中，你在页面上会看到：

[![React.js 小书渲染列表数据图片](http://huzidaha.github.io/static/assets/img/posts/3ADE3817-7D91-4462-830D-1802D8345326.png)](http://huzidaha.github.io/static/assets/img/posts/3ADE3817-7D91-4462-830D-1802D8345326.png)

审查一下元素，看看会发现什么：

[![React.js 小书渲染列表数据图片](http://huzidaha.github.io/static/assets/img/posts/05FD6746-FEF5-4253-9802-EB563643DEDC.png)](http://huzidaha.github.io/static/assets/img/posts/05FD6746-FEF5-4253-9802-EB563643DEDC.png)

React.js 把插入表达式数组里面的每一个 JSX 元素一个个罗列下来，渲染到页面上。所以这里有个关键点：*如果你往 `{}` 放一个数组，React.js 会帮你把数组里面一个个元素罗列并且渲染出来*。

## 2、使用 map 渲染列表数据

知道这一点以后你就可以知道怎么用循环把元素渲染到页面上：循环上面用户数组里面的每一个用户，为每个用户数据构建一个 JSX，然后把 JSX 放到一个新的数组里面，再把新的数组插入 `render` 方法的 JSX 里面。看看代码怎么写：

```javascript
const users = [
  { username: 'Jerry', age: 21, gender: 'male' },
  { username: 'Tomy', age: 22, gender: 'male' },
  { username: 'Lily', age: 19, gender: 'female' },
  { username: 'Lucy', age: 20, gender: 'female' }
]

class Index extends Component {
  render () {
    const usersElements = [] // 保存每个用户渲染以后 JSX 的数组
    for (let user of users) {
      usersElements.push( // 循环每个用户，构建 JSX，push 到数组中
        <div>
          <div>姓名：{user.username}</div>
          <div>年龄：{user.age}</div>
          <div>性别：{user.gender}</div>
          <hr />
        </div>
      )
    }

    return (
      <div>{usersElements}</div>
    )
  }
}

ReactDOM.render(
  <Index />,
  document.getElementById('root')
)
```

这里用了一个新的数组 `usersElements`，然后循环 `users` 数组，为每个 `user` 构建一个 JSX 结构，然后 push 到 `usersElements` 中。然后直接用表达式插入，把这个 `userElements` 插到 return 的 JSX 当中。因为 React.js 会自动化帮我们把数组当中的 JSX 罗列渲染出来，所以可以看到页面上显示：

[![React.js 小书渲染列表数据图片](http://huzidaha.github.io/static/assets/img/posts/AABC1755-55EA-4E42-8763-A15234DB1F02.png)](http://huzidaha.github.io/static/assets/img/posts/AABC1755-55EA-4E42-8763-A15234DB1F02.png)

但我们一般不会手动写循环来构建列表的 JSX 结构，可以直接用 ES6 自带的 `map`（不了解 `map` 函数的同学可以先了解相关的知识再来回顾这里），代码可以简化成：

```javascript
class Index extends Component {
  render () {
    return (
      <div>
        {users.map((user) => {
          return (
            <div>
              <div>姓名：{user.username}</div>
              <div>年龄：{user.age}</div>
              <div>性别：{user.gender}</div>
              <hr />
            </div>
          )
        })}
      </div>
    )
  }
}
```

这样的模式在 JavaScript 中非常常见，一般来说，在 React.js 处理列表就是用 `map` 来处理、渲染的。现在进一步把渲染单独一个用户的结构抽离出来作为一个组件，继续优化代码：

```javascript
const users = [
  { username: 'Jerry', age: 21, gender: 'male' },
  { username: 'Tomy', age: 22, gender: 'male' },
  { username: 'Lily', age: 19, gender: 'female' },
  { username: 'Lucy', age: 20, gender: 'female' }
]

class User extends Component {
  render () {
    const { user } = this.props
    return (
      <div>
        <div>姓名：{user.username}</div>
        <div>年龄：{user.age}</div>
        <div>性别：{user.gender}</div>
        <hr />
      </div>
    )
  }
}

class Index extends Component {
  render () {
    return (
      <div>
        {users.map((user) => <User user={user} />)}
      </div>
    )
  }
}

ReactDOM.render(
  <Index />,
  document.getElementById('root')
)
```

这里把负责展示用户数据的 JSX 结构抽离成一个组件 `User` ，并且通过 `props` 把 `user` 数据作为组件的配置参数传进去；这样改写 `Index` 就非常清晰了，看一眼就知道负责渲染 `users` 列表，而用的组件是 `User`。

## 3、key! key! key!

现在代码运作正常，好像没什么问题。打开控制台看看：

[![React.js 小书渲染列表数据图片](http://huzidaha.github.io/static/assets/img/posts/85CA5037-99C1-422C-99A4-AADA978C6801.png)](http://huzidaha.github.io/static/assets/img/posts/85CA5037-99C1-422C-99A4-AADA978C6801.png)

React.js 报错了。如果需要详细解释这里报错的原因，估计要单独写半本书。但可以简单解释一下。

React.js 的是非常高效的，它高效依赖于所谓的 Virtual-DOM 策略。简单来说，能复用的话 React.js 就会尽量复用，没有必要的话绝对不碰 DOM。对于列表元素来说也是这样，但是处理列表元素的复用性会有一个问题：元素可能会在一个列表中改变位置。例如：

```html
<div>a</div>
<div>b</div>
<div>c</div>
```

假设页面上有这么3个列表元素，现在改变一下位置：

```html
<div>a</div>
<div>c</div>
<div>b</div>
```

`c` 和 `b` 的位置互换了。但其实 React.js 只需要交换一下 DOM 位置就行了，但是它并不知道其实我们只是改变了元素的位置，所以它会重新渲染后面两个元素（再执行 Virtual-DOM 策略），这样会大大增加 DOM 操作。但如果给每个元素加上唯一的标识，React.js 就可以知道这两个元素只是交换了位置：

```html
<div key='a'>a</div>
<div key='b'>b</div>
<div key='c'>c</div>
```

这样 React.js 就简单的通过 `key` 来判断出来，这两个列表元素只是交换了位置，可以尽量复用元素内部的结构。

这里没听懂没有关系，后面有机会会继续讲解这部分内容。现在只需要记住一个简单的规则：*对于用表达式套数组罗列到页面上的元素，都要为每个元素加上 `key` 属性，这个 `key` 必须是每个元素唯一的标识*。一般来说，`key` 的值可以直接后台数据返回的 `id`，因为后台的 `id` 都是唯一的。

在上面的例子当中，每个 `user` 没有 `id` 可以用，可以直接用循环计数器 `i` 作为 `key`：

```javascript
...
class Index extends Component {
  render () {
    return (
      <div>
        {users.map((user, i) => <User key={i} user={user} />)}
      </div>
    )
  }
}
...
```

再看看，控制台已经没有错误信息了。但这是不好的做法，这只是掩耳盗铃（具体原因大家可以自己思考一下）。记住一点：在实际项目当中，如果你的数据顺序可能发生变化，标准做法是最好是后台数据返回的 `id` 作为列表元素的 `key`。



# `小书二阶段`



# 一、前端应用状态管理 —— 状态提升

上一个评论功能的案例中，可能会有些同学会对一个地方感到疑惑： `CommentList` 中显示的评论列表数据为什么要通过父组件 `CommentApp` 用 `props` 传进来？为什么不直接存放在 `CommentList` 的 `state` 当中？例如这样做也是可以的：

```javascript
class CommentList extends Component {
  constructor () {
    this.state = { comments: [] }
  }

  addComment (comment) {
    this.state.comments.push(comment)
    this.setState({
      comments: this.state.comments
    })
  }

  render() {
    return (
      <div>
        {this.state.comments.map((comment, i) =>
          <Comment comment={comment} key={i} />
        )}
      </div>
    )
  }
}
```

如果把这个 `comments` 放到 `CommentList` 当中，*当有别的组件也依赖这个 `comments` 数据或者有别的组件会影响这个数据*，那么就带来问题了。举一个数据依赖的例子：例如，现在我们有另外一个和 `CommentList` 同级的 `CommentList2` ，也是需要显示同样的评论列表数据。

[![React.js 小书实战之状态管理图片](http://huzidaha.github.io/static/assets/img/posts/85B8A2B7-288F-4FC2-A0AB-C4E153BB3854.png)](http://huzidaha.github.io/static/assets/img/posts/85B8A2B7-288F-4FC2-A0AB-C4E153BB3854.png)

`CommentList2` 和 `CommentList` 并列为 `CommentApp` 的子组件，它也需要依赖 `comments` 显示评论列表。但是因为 `comments` 数据在 `CommentList` 中，它没办法访问到。

遇到这种情况，我们*将这种组件之间共享的状态交给组件最近的公共父节点保管*，然后通过 `props` 把状态传递给子组件，这样就可以在组件之间共享数据了。

[![React.js 小书实战之状态管理图片](http://huzidaha.github.io/static/assets/img/posts/C547BD3E-F923-4B1D-96BC-A77966CDFBEF.png)](http://huzidaha.github.io/static/assets/img/posts/C547BD3E-F923-4B1D-96BC-A77966CDFBEF.png)

在我们的例子当中，如果把 `comments` 交给父组件 `CommentApp` ，那么 `CommentList` 和 `CommentList2` 都可以通过 `props` 获取到 `comments`，React.js 把这种行为叫做“状态提升”。

但是这个 `CommentList2` 是我们临时加上去的，在实际案例当中并没有涉及到这种组件之间依赖 `comments` 的情况，为什么还需要把 `comments` 提升到 `CommentApp`？那是因为有个组件会影响到 `comments` ，那就是 `CommentInput`。`CommentInput` 产生的新的评论数据是会插入 `comments` 当中的，所以我们遇到这种情况也会把状态提升到父组件。

总结一下：当某个状态被多个组件*依赖*或者*影响*的时候，就把该状态提升到这些组件的最近公共父组件中去管理，用 `props` 传递*数据或者函数*来管理这种*依赖*或着*影响*的行为。

我们来看看状态提升更多的例子，假设现在我们的父组件 `CommentApp` 只是属于更大的组件树 `PostApp` 的一部分：

[![React.js 小书实战之状态管理图片](http://huzidaha.github.io/static/assets/img/posts/5.007.png)](http://huzidaha.github.io/static/assets/img/posts/5.007.png)

而这个更大的组件树的另外的子树的 `CommentsCount` 组件也需要依赖 `comments` 来显示评论数，那我们就只能把 `comments` 继续提升到这些依赖组件的最近公共父组件 `PostApp` 当中。

现在继续让我们的例子极端起来。假设现在 `PostApp` 只是另外一个更大的父组件 `Index` 的子树。而 `Index` 的某个子树的有一个按钮组件可以一键清空所有 `comments`（也就是说，这个按钮组件可以影响到这个数据），我们只能继续 `commenets` 提升到 `Index` 当中。

你会发现这种无限制的提升不是一个好的解决方案。一旦发生了提升，你就需要修改原来保存这个状态的组件的代码，也要把整个数据传递路径经过的组件都修改一遍，好让数据能够一层层地传递下去。这样对代码的组织管理维护带来很大的问题。到这里你可以抽象一下问题：

> 如何更好的管理这种被多个组件所依赖或影响的状态？

你可以看到 React.js 并没有提供好的解决方案来管理这种组件之间的共享状态。在实际项目当中状态提升并不是一个好的解决方案，所以我们后续会引入 Redux 这样的状态管理工具来帮助我们来管理这种共享状态，但是在讲解到 Redux 之前，我们暂时采取状态提升的方式来进行管理。

对于不会被多个组件依赖和影响的状态（例如某种下拉菜单的展开和收起状态），一般来说只需要保存在组件内部即可，不需要做提升或者特殊的管理。

# 二、挂载阶段的组件生命周期（一）

我们在[讲解 JSX 的章节](http://react.huziketang.com/blog/lesson6)中提到，下面的代码：

```javascript
ReactDOM.render(
 <Header />, 
  document.getElementById('root')
)
```

会编译成：

```javascript
ReactDOM.render(
  React.createElement(Header, null), 
  document.getElementById('root')
)
```

其实我们把 `Header` 组件传给了 `React.createElement` 函数，又把函数返回结果传给了 `ReactDOM.render`。我们可以简单猜想一下它们会干什么事情：

```javascript
// React.createElement 中实例化一个 Header
const header = new Header(props, children)
// React.createElement 中调用 header.render 方法渲染组件的内容
const headerJsxObject = header.render()

// ReactDOM 用渲染后的 JavaScript 对象来来构建真正的 DOM 元素
const headerDOM = createDOMFromObject(headerJsxObject)
// ReactDOM 把 DOM 元素塞到页面上
document.getElementById('root').appendChild(headerDOM)
```

上面过程其实很简单，看代码就能理解。

我们把 *React.js 将组件渲染，并且构造 DOM 元素然后塞入页面的过程称为组件的挂载*（这个定义请好好记住）。其实 React.js 内部对待每个组件都有这么一个过程，也就是初始化组件 -> 挂载到页面上的过程。所以你可以理解一个组件的方法调用是这么一个过程：

```
-> constructor()
-> render()
// 然后构造 DOM 元素插入页面
```

这当然是很好理解的。React.js 为了让我们能够更好的掌控组件的挂载过程，往上面插入了两个方法：

```
-> constructor()
-> componentWillMount()
-> render()
// 然后构造 DOM 元素插入页面
-> componentDidMount()
```

`componentWillMount` 和 `componentDidMount` 都是可以像 `render` 方法一样自定义在组件的内部。挂载的时候，React.js 会在组件的 `render` 之前调用 `componentWillMount`，在 DOM 元素塞入页面以后调用 `componentDidMount`。

我们给 `Header` 组件加上这两个方法，并且打一些 Log：

```javascript
class Header extends Component {
  constructor () {
    super()
    console.log('construct')
  }

  componentWillMount () {
    console.log('component will mount')
  }

  componentDidMount () {
    console.log('component did mount')
  }

  render () {
    console.log('render')
    return (
      <div>
        <h1 className='title'>React 小书</h1>
      </div>
    )
  }
}
```

在控制台你可以看到依次输出：

[![null](http://huzidaha.github.io/static/assets/img/posts/69676213-FDED-4E60-8142-07599BA10696.png)](http://huzidaha.github.io/static/assets/img/posts/69676213-FDED-4E60-8142-07599BA10696.png)

可以看到，React.js 确实按照我们上面所说的那样调用了定义的两个方法 `componentWillMount` 和 `componentDidMount`。

机灵的同学可以想到，一个组件可以插入页面，当然也可以从页面中删除。

```
-> constructor()
-> componentWillMount()
-> render()
// 然后构造 DOM 元素插入页面
-> componentDidMount()
// ...
// 从页面中删除
```

React.js 也控制了这个组件的删除过程。在组件删除之前 React.js 会调用组件定义的 `componentWillUnmount`：

```
-> constructor()
-> componentWillMount()
-> render()
// 然后构造 DOM 元素插入页面
-> componentDidMount()
// ...
// 即将从页面中删除
-> componentWillUnmount()
// 从页面中删除
```

看看什么情况下会把组件从页面中删除，继续使用上面例子的代码，我们再定义一个 `Index` 组件：

```javascript
class Index extends Component {
  constructor() {
    super()
    this.state = {
      isShowHeader: true
    }
  }

  handleShowOrHide () {
    this.setState({
      isShowHeader: !this.state.isShowHeader
    })
  }

  render () {
    return (
      <div>
        {this.state.isShowHeader ? <Header /> : null}
        <button onClick={this.handleShowOrHide.bind(this)}>
          显示或者隐藏标题
        </button>
      </div>
    )
  }
}

ReactDOM.render(
  <Index />,
  document.getElementById('root')
)
```

`Index` 组件使用了 `Header` 组件，并且有一个按钮，可以控制 `Header` 的显示或者隐藏。下面这行代码：

```javascript
...a
{this.state.isShowHeader ? <Header /> : null}
...
```

相当于 `state.isShowHeader` 为 `true` 的时候把 `Header` 插入页面，`false` 的时候把 `Header` 从页面上删除。这时候我们给 `Header` 添加 `componentWillUnmount` 方法：

```javascript
...
  componentWillUnmount() {
    console.log('component will unmount')
  }
...
```

这时候点击页面上的按钮，你会看到页面的标题隐藏了，并且控制台打印出来下图的最后一行，说明 `componentWillUnmount` 确实被 React.js 所调用了：

[![null](http://huzidaha.github.io/static/assets/img/posts/B396B6CF-50F1-4C4E-9D16-4E746F15F91F.png)](http://huzidaha.github.io/static/assets/img/posts/B396B6CF-50F1-4C4E-9D16-4E746F15F91F.png)

你可以多次点击按钮，随着按钮的显示和隐藏，上面的内容会按顺序重复地打印出来，可以体会一下这几个方法的调用过程和顺序。

## 总结

React.js 将组件渲染，并且构造 DOM 元素然后塞入页面的过程称为组件的挂载。这一节我们学习了 React.js 控制组件在页面上挂载和删除过程里面几个方法：

- `componentWillMount`：组件挂载开始之前，也就是在组件调用 `render` 方法之前调用。
- `componentDidMount`：组件挂载完成以后，也就是 DOM 元素已经插入页面后调用。
- `componentWillUnmount`：组件对应的 DOM 元素从页面中删除之前调用。

但这一节并没有讲这几个方法到底在实际项目当中有什么作用，下一节我们通过例子来讲解一下这几个方法的用途。

# 三、挂载阶段的组件生命周期（二）

这一节我们来讨论一下对于一个组件来说，`constructor` 、`componentWillMount`、`componentDidMount`、`componentWillUnmount` 这几个方法在一个组件的出生到死亡的过程里面起了什么样的作用。

一般来说，所有关于组件自身的状态的初始化工作都会放在 `constructor` 里面去做。你会发现本书所有组件的 `state` 的初始化工作都是放在 `constructor` 里面的。假设我们现在在做一个时钟应用：

[![React.js 小书组件的生命周期图片](http://huzidaha.github.io/static/assets/img/posts/FECF7A01-5C87-4E03-AA98-03BB30538C66.png)](http://huzidaha.github.io/static/assets/img/posts/FECF7A01-5C87-4E03-AA98-03BB30538C66.png)

我们会在 `constructor` 里面初始化 `state.date`，当然现在页面还是静态的，等下一会让时间动起来。

```javascript
class Clock extends Component {
  constructor () {
    super()
    this.state = {
      date: new Date()
    }
  }

  render () {
    return (
      <div>
        <h1>
          <p>现在的时间是</p>
          {this.state.date.toLocaleTimeString()}
        </h1>
      </div>
    )
  }
}
```

一些组件启动的动作，包括像 Ajax 数据的拉取操作、一些定时器的启动等，就可以放在 `componentWillMount` 里面进行，例如 Ajax：

```javascript
...
  componentWillMount () {
    ajax.get('http://json-api.com/user', (userData) => {
      this.setState({ userData })
    })
  }
...
```

当然在我们这个例子里面是定时器的启动，我们给 `Clock` 启动定时器：

```javascript
class Clock extends Component {
  constructor () {
    super()
    this.state = {
      date: new Date()
    }
  }

  componentWillMount () {
    this.timer = setInterval(() => {
      this.setState({ date: new Date() })
    }, 1000)
  }
  ...
}
```

我们在 `componentWillMount` 中用 `setInterval` 启动了一个定时器：每隔 1 秒更新中的 `state.date`，这样页面就可以动起来了。我们用一个 `Index` 把它用起来，并且插入页面：

```javascript
class Index extends Component {
  render () {
    return (
      <div>
        <Clock />
      </div>
    )
  }
}

ReactDOM.render(
  <Index />,
  document.getElementById('root')
)
```

像上一节那样，我们修改这个 `Index` 让这个时钟可以隐藏或者显示：

```javascript
class Index extends Component {
  constructor () {
    super()
    this.state = { isShowClock: true }
  }

  handleShowOrHide () {
    this.setState({
      isShowClock: !this.state.isShowClock
    })
  }

  render () {
    return (
      <div>
        {this.state.isShowClock ? <Clock /> : null }
        <button onClick={this.handleShowOrHide.bind(this)}>
          显示或隐藏时钟
        </button>
      </div>
    )
  }
}
```

现在页面上有个按钮可以显示或者隐藏时钟。你试一下显示或者隐藏时钟，虽然页面上看起来功能都正常，在控制台你会发现报错了：

[![React.js 小书组件的生命周期图片](http://huzidaha.github.io/static/assets/img/posts/340BBCEA-35CC-4B35-B352-267F381477EF.png)](http://huzidaha.github.io/static/assets/img/posts/340BBCEA-35CC-4B35-B352-267F381477EF.png)

这是因为，*当时钟隐藏的时候，我们并没有清除定时器*。时钟隐藏的时候，定时器的回调函数还在不停地尝试 `setState`，由于 `setState` 只能在已经挂载或者正在挂载的组件上调用，所以 React.js 开始疯狂报错。

多次的隐藏和显示会让 React.js 重新构造和销毁 `Clock` 组件，每次构造都会重新构建一个定时器。而销毁组件的时候没有清除定时器，所以你看到报错会越来越多。而且因为 JavaScript 的闭包特性，这样会导致严重的内存泄漏。

这时候`componentWillUnmount` 就可以派上用场了，它的作用就是在组件销毁的时候，做这种清场的工作。例如清除该组件的定时器和其他的数据清理工作。我们给 `Clock` 添加 `componentWillUnmount`，在组件销毁的时候清除该组件的定时器：

```javascript
...
  componentWillUnmount () {
    clearInterval(this.timer)
  }
...
```

这时候就没有错误了。

## 总结

我们一般会把组件的 `state` 的初始化工作放在 `constructor` 里面去做；在 `componentWillMount` 进行组件的启动工作，例如 Ajax 数据拉取、定时器的启动；组件从页面上销毁的时候，有时候需要一些数据的清理，例如定时器的清理，就会放在 `componentWillUnmount` 里面去做。

说一下本节没有提到的 `componentDidMount` 。一般来说，有些组件的启动工作是依赖 DOM 的，例如动画的启动，而 `componentWillMount` 的时候组件还没挂载完成，所以没法进行这些启动工作，这时候就可以把这些操作放在 `componentDidMount` 当中。`componentDidMount` 的具体使用我们会在接下来的章节当中结合 DOM 来讲。

# 四、更新阶段的组件生命周期

从之前的章节我们了解到，组件的挂载指的是将组件渲染并且构造 DOM 元素然后插入页面的过程。*这是一个从无到有的过程*，React.js 提供一些生命周期函数可以给我们在这个过程中做一些操作。

除了挂载阶段，还有一种“更新阶段”。说白了就是 `setState` 导致 React.js 重新渲染组件并且把组件的变化应用到 DOM 元素上的过程，*这是一个组件的变化过程*。而 React.js 也提供了一系列的生命周期函数可以让我们在这个组件更新的过程执行一些操作。

这些生命周期在深入项目开发阶段是非常重要的。而要完全理解更新阶段的组件生命周期是一个需要经验和知识积累的过程，你需要对 Virtual-DOM 策略有比较深入理解才能完全掌握，但这超出了本书的目的。*本书的目的是为了让大家快速掌握 React.js 核心的概念，快速上手项目进行实战*。所以对于组件更新阶段的组件生命周期，我们简单提及并且提供一些资料给大家。

这里为了知识的完整，补充关于更新阶段的组件生命周期：

1. `shouldComponentUpdate(nextProps, nextState)`：你可以通过这个方法控制组件是否重新渲染。如果返回 `false` 组件就不会重新渲染。这个生命周期在 React.js 性能优化上非常有用。
2. `componentWillReceiveProps(nextProps)`：组件从父组件接收到新的 `props` 之前调用。
3. `componentWillUpdate()`：组件开始重新渲染之前调用。
4. `componentDidUpdate()`：组件重新渲染并且把更改变更到真实的 DOM 以后调用。

大家对这更新阶段的生命周期比较感兴趣的话可以查看[官网文档](https://facebook.github.io/react/docs/react-component.html)。

*但这里建议大家可以先简单了解 React.js 组件是有更新阶段的，并且有这么几个更新阶段的生命周期即可*。然后在深入项目实战的时候逐渐地掌握理解他们，现在并不需要对他们放过多的精力。

有朋友对 Virtual-DOM 策略比较感兴趣的话，可以参考这篇博客：[深度剖析：如何实现一个 Virtual DOM 算法 ](https://github.com/livoras/blog/issues/13)。对深入理解 React.js 核心算法有一定帮助。

# 五、ref 和 React.js 中的 DOM 操作

在 React.js 当中你基本不需要和 DOM 直接打交道。React.js 提供了一系列的 `on*` 方法帮助我们进行事件监听，所以 React.js 当中不需要直接调用 `addEventListener` 的 DOM API；以前我们通过手动 DOM 操作进行页面更新（例如借助 jQuery），而在 React.js 当中可以直接通过 `setState` 的方式重新渲染组件，渲染的时候可以把新的 `props` 传递给子组件，从而达到页面更新的效果。

React.js 这种重新渲染的机制帮助我们免除了绝大部分的 DOM 更新操作，也让类似于 jQuery 这种以封装 DOM 操作为主的第三方的库从我们的开发工具链中删除。

但是 React.js 并不能完全满足所有 DOM 操作需求，有些时候我们还是需要和 DOM 打交道。比如说你想进入页面以后自动 focus 到某个输入框，你需要调用 `input.focus()` 的 DOM API，比如说你想动态获取某个 DOM 元素的尺寸来做后续的动画，等等。

React.js 当中提供了 `ref` 属性来帮助我们获取已经挂载的元素的 DOM 节点，你可以给某个 JSX 元素加上 `ref`属性：

```javascript
class AutoFocusInput extends Component {
  componentDidMount () {
    this.input.focus()
  }

  render () {
    return (
      <input ref={(input) => this.input = input} />
    )
  }
}

ReactDOM.render(
  <AutoFocusInput />,
  document.getElementById('root')
)
```

可以看到我们给 `input` 元素加了一个 `ref` 属性，这个属性值是一个函数。当 `input` 元素在页面上挂载完成以后，React.js 就会调用这个函数，并且把这个挂载以后的 DOM 节点传给这个函数。在函数中我们把这个 DOM 元素设置为组件实例的一个属性，这样以后我们就可以通过 `this.input` 获取到这个 DOM 元素。

然后我们就可以在 `componentDidMount` 中使用这个 DOM 元素，并且调用 `this.input.focus()` 的 DOM API。整体就达到了页面加载完成就自动 focus 到输入框的功能（大家可以注意到我们用上了 `componentDidMount` 这个组件生命周期）。

我们可以给任意代表 HTML 元素标签加上 `ref` 从而获取到它 DOM 元素然后调用 DOM API。但是记住一个原则：*能不用 `ref` 就不用*。特别是要避免用 `ref` 来做 React.js 本来就可以帮助你做到的页面自动更新的操作和事件监听。多余的 DOM 操作其实是代码里面的“噪音”，不利于我们理解和维护。

顺带一提的是，其实可以给组件标签也加上 `ref` ，例如：

```javascript
<Clock ref={(clock) => this.clock = clock} />
```

这样你获取到的是这个 `Clock` 组件在 React.js 内部初始化的实例。但这并不是什么常用的做法，而且也并不建议这么做，所以这里就简单提及，有兴趣的朋友可以自己学习探索。

# 六、props.children 和容器类组件

有一类组件，充当了容器的作用，它定义了一种外层结构形式，然后你可以往里面塞任意的内容。这种结构在实际当中非常常见，例如这种带卡片组件：

[![React.js 小书容器组件图片](http://huzidaha.github.io/static/assets/img/posts/45A7AD7E-CC88-4957-B1EF-09DFE7755590.png)](http://huzidaha.github.io/static/assets/img/posts/45A7AD7E-CC88-4957-B1EF-09DFE7755590.png)

组件本身是一个不带任何内容的方形的容器，我可以在用这个组件的时候给它传入任意内容：

[![React.js 小书容器组件图片](http://huzidaha.github.io/static/assets/img/posts/6BD73C14-60FE-44BA-A93C-B637BD07DE59.png)](http://huzidaha.github.io/static/assets/img/posts/6BD73C14-60FE-44BA-A93C-B637BD07DE59.png)

基于我们目前的知识储备，可以迅速写出这样的代码：

```javascript
class Card extends Component {
  render () {
    return (
      <div className='card'>
        <div className='card-content'>
          {this.props.content}
        </div>
      </div>
    )
  }
}

ReactDOM.render(
  <Card content={
    <div>
      <h2>React.js 小书</h2>
       <div>开源、免费、专业、简单</div>
      订阅：<input />
    </div>
  } />,
  document.getElementById('root')
)
```

我们通过给 `Card` 组件传入一个 `content` 属性，这个属性可以传入任意的 JSX 结构。然后在 `Card` 内部会通过 `{this.props.content}` 把内容渲染到页面上。

这样明显太丑了，如果 `Card` 除了 `content` 以外还能传入其他属性的话，那么这些 JSX 和其他属性就会混在一起。很不好维护，如果能像下面的代码那样使用 `Card` 那想必也是极好的：

```javascript
ReactDOM.render(
  <Card>
    <h2>React.js 小书</h2>
    <div>开源、免费、专业、简单</div>
    订阅：<input />
  </Card>,
  document.getElementById('root')
)
```

如果组件标签也能像普通的 HTML 标签那样编写内嵌的结构，那么就方便很多了。实际上，React.js 默认就支持这种写法，所有嵌套在组件中的 JSX 结构都可以在组件内部通过 `props.children` 获取到：

```javascript
class Card extends Component {
  render () {
    return (
      <div className='card'>
        <div className='card-content'>
          {this.props.children}
        </div>
      </div>
    )
  }
}
```

把 `props.children` 打印出来，你可以看到它其实是个数组：

[![React.js 小书容器组件图片](http://huzidaha.github.io/static/assets/img/posts/4CD84934-5A7F-4942-A5F5-3C935E113499.png)](http://huzidaha.github.io/static/assets/img/posts/4CD84934-5A7F-4942-A5F5-3C935E113499.png)

React.js 就是把我们嵌套的 JSX 元素一个个都放到数组当中，然后通过 `props.children` 传给了 `Card`。

由于 JSX 会把插入表达式里面数组中的 JSX 一个个罗列下来显示。所以其实就相当于在 `Card` 中嵌套了什么 JSX 结构，都会显示在 `Card` 的类名为 `card-content` 的 `div` 元素当中。

这种嵌套的内容成为了 `props.children` 数组的机制使得我们编写组件变得非常的灵活，我们甚至可以在组件内部把数组中的 JSX 元素安置在不同的地方：

```javascript
class Layout extends Component {
  render () {
    return (
      <div className='two-cols-layout'>
        <div className='sidebar'>
          {this.props.children[0]}
        </div>
        <div className='main'>
          {this.props.children[1]}
        </div>
      </div>
    )
  }
}
```

这是一个两列布局组件，嵌套的 JSX 的第一个结构会成为侧边栏，第二个结构会成为内容栏，其余的结构都会被忽略。这样通过这个布局组件，就可以在各个地方高度复用我们的布局。

## 总结

使用自定义组件的时候，可以在其中嵌套 JSX 结构。嵌套的结构在组件内部都可以通过 `props.children` 获取到，这种组件编写方式在编写容器类型的组件当中非常有用。而在实际的 React.js 项目当中，我们几乎每天都需要用这种方式来编写组件。

# 七、dangerouslySetHTML 和 style 属性

## 1、dangerouslySetHTML

出于安全考虑的原因（XSS 攻击），在 React.js 当中所有的表达式插入的内容都会被自动转义，就相当于 jQuery 里面的 `text(…)` 函数一样，任何的 HTML 格式都会被转义掉：

```javascript
class Editor extends Component {
  constructor() {
    super()
    this.state = {
      content: '<h1>React.js 小书</h1>'
    }
  }

  render () {
    return (
      <div className='editor-wrapper'>
        {this.state.content}
      </div>
    )
  }
}
```

假设上面是一个富文本编辑器组件，富文本编辑器的内容是动态的 HTML 内容，用 `this.state.content` 来保存。我希望在编辑器内部显示这个动态 HTML 结构，但是因为 React.js 的转义特性，页面上会显示：

[![React.js 小书教程图片](http://huzidaha.github.io/static/assets/img/posts/A67A4660-604A-4F42-A743-A059A96344C8.png)](http://huzidaha.github.io/static/assets/img/posts/A67A4660-604A-4F42-A743-A059A96344C8.png)

表达式插入并不会把一个 `<h1>` 渲染到页面，而是把它的文本形式渲染了。那要怎么才能做到设置动态 HTML 结构的效果呢？React.js 提供了一个属性 `dangerouslySetInnerHTML`，可以让我们设置动态设置元素的 innerHTML：

```javascript
...
  render () {
    return (
      <div
        className='editor-wrapper'
        dangerouslySetInnerHTML={{__html: this.state.content}} />
    )
  }
...
```

需要给 `dangerouslySetInnerHTML` 传入一个对象，这个对象的 `__html` 属性值就相当于元素的 `innerHTML`，这样我们就可以动态渲染元素的 `innerHTML` 结构了。

有写朋友会觉得很奇怪，为什么要把一件这么简单的事情搞得这么复杂，名字又长，还要传入一个奇怪的对象。那是因为设置 `innerHTML` 可能会导致跨站脚本攻击（XSS），所以 React.js 团队认为把事情搞复杂可以防止（警示）大家滥用这个属性。这个属性不必要的情况就不要使用。

## 2、style

React.js 中的元素的 `style` 属性的用法和 DOM 里面的 `style` 不大一样，普通的 HTML 中的：

```html
<h1 style='font-size: 12px; color: red;'>React.js 小书</h1>
```

在 React.js 中你需要把 CSS 属性变成一个对象再传给元素：

```html
<h1 style={{fontSize: '12px', color: 'red'}}>React.js 小书</h1>
```

`style` 接受一个对象，这个对象里面是这个元素的 CSS 属性键值对，原来 CSS 属性中带 `-` 的元素都必须要去掉 `-` 换成驼峰命名，如 `font-size` 换成 `fontSize`，`text-align` 换成 `textAlign`。

用对象作为 `style` 方便我们动态设置元素的样式。我们可以用 `props` 或者 `state` 中的数据生成样式对象再传给元素，然后用 `setState` 就可以修改样式，非常灵活：

```html
<h1 style={{fontSize: '12px', color: this.state.color}}>React.js 小书</h1>
```

只要简单地 `setState({color: 'blue'})` 就可以修改元素的颜色成蓝色。

# 八、PropTypes 和组件参数验证

我们来了到了一个非常尴尬的章节，很多初学的朋友可能对这一章的知识点不屑一顾，觉得用不用对程序功能也没什么影响。但其实这一章节的知识在你构建多人协作、大型的应用程序的时候也是非常重要的，不可忽视。

都说 JavaScript 是一门灵活的语言 —— 这就是像是说“你是个好人”一样，凡事都有背后没有说出来的话。JavaScript 的灵活性体现在弱类型、高阶函数等语言特性上。而语言的弱类型一般来说确实让我们写代码很爽，但是也很容易出 bug。

变量没有固定类型可以随意赋值，在我们构建大型应用程序的时候并不是什么好的事情。你写下了 `let a = {}` ，如果这是个共享的状态并且在某个地方把 `a = 3`，那么 `a.xxx` 就会让程序崩溃了。而这种非常隐晦但是低级的错误在强类型的语言例如 C/C++、Java 中是不可能发生的，这些代码连编译都不可能通过，也别妄图运行。

大型应用程序的构建其实更适合用强类型的语言来构建，它有更多的规则，可以帮助我们在编写代码阶段、编译阶段规避掉很多问题，让我们的应用程序更加的安全。JavaScript 早就脱离了玩具语言的领域并且投入到大型的应用程序的生产活动中，因为它的弱类型，常常意味着不是很安全。所以近年来出现了类似 TypeScript 和 Flow 等技术，来弥补 JavaScript 这方面的缺陷。

React.js 的组件其实是为了构建大型应用程序而生。但是因为 JavaScript 这样的特性，你在编写了一个组件以后，根本不知道别人会怎么使用你的组件，往里传什么乱七八糟的参数，例如评论组件：

```javascript
class Comment extends Component {
  const { comment } = this.props
  render () {
    return (
      <div className='comment'>
        <div className='comment-user'>
          <span>{comment.username} </span>：
        </div>
        <p>{comment.content}</p>
      </div>
    )
  }
}
```

但是别人往里面传一个数字你拿他一点办法都没有：

```javascript
<Comment comment={1} />
```

JavaScript 在这种情况下是不会报任何错误的，但是页面就是显示不正常，然后我们踏上了漫漫 debug 的路程。这里的例子还是过于简单，容易 debug，但是对于比较复杂的成因和情况是比较难处理的。

于是 React.js 就提供了一种机制，让你可以*给组件的配置参数加上类型验证*，就用上述的评论组件例子，你可以配置 `Comment` 只能接受对象类型的 `comment` 参数，你传个数字进来组件就强制报错。我们这里先安装一个 React 提供的第三方库 `prop-types`：

```
npm install --save prop-types
```

它可以帮助我们验证 `props` 的参数类型，例如：

```javascript
import React, { Component } from 'react'
import PropTypes from 'prop-types'

class Comment extends Component {
  static propTypes = {
    comment: PropTypes.object
  }

  render () {
    const { comment } = this.props
    return (
      <div className='comment'>
        <div className='comment-user'>
          <span>{comment.username} </span>：
        </div>
        <p>{comment.content}</p>
      </div>
    )
  }
}
```

注意我们在文件头部引入了 `PropTypes`，并且给 `Comment` 组件类添加了类属性 `propTypes`，里面的内容的意思就是你传入的 `comment` 类型必须为 `object`（对象）。

这时候如果再往里面传入数字，浏览器就会报错：

[![React.js 小书组件参数验证图片](http://huzidaha.github.io/static/assets/img/posts/BFC94736-56D0-42C2-B1A4-088334397D4D.png)](http://huzidaha.github.io/static/assets/img/posts/BFC94736-56D0-42C2-B1A4-088334397D4D.png)

出错信息明确告诉我们：你给 `Comment` 组件传了一个数字类型的 `comment`，而它应该是 `object`。你就清晰知道问题出在哪里了。

虽然 `propTypes` 帮我们指定了参数类型，但是并没有说这个参数一定要传入，事实上，这些参数默认都是可选的。可选参数我们可以通过配置 `defaultProps`，让它在不传入的时候有默认值。但是我们这里并没有配置 `defaultProps`，所以如果直接用 `<Comment />` 而不传入任何参数的话，`comment` 就会是 `undefined`，`comment.username` 会导致程序报错：

[![React.js 小书组件参数验证图片](http://huzidaha.github.io/static/assets/img/posts/CCDCBB39-A469-4EE7-9D85-F32AA7C9F4E0.png)](http://huzidaha.github.io/static/assets/img/posts/CCDCBB39-A469-4EE7-9D85-F32AA7C9F4E0.png)

这个出错信息并不够友好。我们可以通过 `isRequired` 关键字来强制组件某个参数必须传入：

```javascript
...
static propTypes = {
  comment: PropTypes.object.isRequired
}
...
```

那么会获得一个更加友好的出错信息，查错会更方便：

[![React.js 小书组件参数验证图片](http://huzidaha.github.io/static/assets/img/posts/E1896DA9-0ED6-4A99-B7B5-EEC260FB9814.png)](http://huzidaha.github.io/static/assets/img/posts/E1896DA9-0ED6-4A99-B7B5-EEC260FB9814.png)

React.js 提供的 `PropTypes` 提供了一系列的数据类型可以用来配置组件的参数：

```
PropTypes.array
PropTypes.bool
PropTypes.func
PropTypes.number
PropTypes.object
PropTypes.string
PropTypes.node
PropTypes.element
...
```

更多类型及其用法可以参看官方文档： [Typechecking With PropTypes - React](https://facebook.github.io/react/docs/typechecking-with-proptypes.html)。

组件参数验证在构建大型的组件库的时候相当有用，可以帮助我们迅速定位这种类型错误，让我们组件开发更加规范。另外也起到了一个说明文档的作用，如果大家都约定都写 `propTypes` ，那你在使用别人写的组件的时候，只要看到组件的 `propTypes` 就清晰地知道这个组件到底能够接受什么参数，什么参数是可选的，什么参数是必选的。

## 总结

通过 `PropTypes` 给组件的参数做类型限制，可以在帮助我们迅速定位错误，这在构建大型应用程序的时候特别有用；另外，给组件加上 `propTypes`，也让组件的开发、使用更加规范清晰。

这里建议大家写组件的时候尽量都写 `propTypes`，有时候有点麻烦，但是是值得的