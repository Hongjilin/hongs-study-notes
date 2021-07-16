>本人的React学习笔记分类(也是对应本人技术成长过程):[[`想快速入门看这部分`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React基础补充学习笔记)]、[[`想对React系统全面进行学习的同学看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/Scss%E7%AC%94%E8%AE%B0)]、[[`对基础学习完成且有了一定开发经验,想尝试解析源码的看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React深入学习与源码解析笔记)]

# **实战分析：评论功能（一）**

课程到这里大家已经掌握了 React.js 的基础知识和组件的基本写法了。现在可以把我们所学到的内容应用于实战当中。这里给大家提供一个实战的案例：一个评论功能。效果如下：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/2B86ED50-DDF5-4B3A-82A0-DECFD6767A8F.png)](http://huzidaha.github.io/static/assets/img/posts/2B86ED50-DDF5-4B3A-82A0-DECFD6767A8F.png)

[在线演示地址](https://huzidaha.github.io/react-naive-book-examples/comment-app/build/index.html)

接下来会带大家一起来学习如何分析、编写这个功能。在这个过程中会补充一些之前没有提及的知识点，虽然这些知识点之前没有单独拿出来讲解，但是这些知识点也很关键。

## 组件划分

React.js 中一切都是组件，用 React.js 构建的功能其实也就是由各种组件组合而成。所以拿到一个需求以后，我们要做的第一件事情就是理解需求、分析需求、划分这个需求由哪些组件构成。

组件的划分没有特别明确的标准。划分组件的目的性是为了代码可复用性、可维护性。只要某个部分有可能复用到别的地方，你都可以把它抽离出来当成一个组件；或者把某一部分抽离出来对代码的组织和管理会带来帮助，你也可以毫不犹豫地把它抽离出来。

对于上面这个评论功能，可以粗略地划分成以下几部分：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/1.003.png)](http://huzidaha.github.io/static/assets/img/posts/1.003.png)

`CommentApp`：评论功能的整体用一个叫 `CommentApp` 的组件包含起来。`CommentApp` 包含上部和下部两部分。

`CommentInput`：上面部分是负责用户输入可操作的输入区域，包括输入评论的用户名、评论内容和发布按钮，这一部分功能划分到一个单独的组件 `CommentInput` 中。

`CommentList`：下面部分是评论列表，用一个叫 `CommentList` 的组件负责列表的展示。

`Comment`：每个评论列表项由独立的组件 `Comment` 负责显示，这个组件被 `CommentList` 所使用。

所以这个评论功能划分成四种组件，`CommentApp`、`CommentInput`、`CommentList`、`Comment`。用组件树表示：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/DAFA784B-6AD3-474B-9A87-316E5741DED6.png)](http://huzidaha.github.io/static/assets/img/posts/DAFA784B-6AD3-474B-9A87-316E5741DED6.png)

现在就可以尝试编写代码了。

## 组件实现

在写代码之前，我们先用 `create-react-app` 构建一个新的工程目录。所有的评论功能在这个工程内完成：

```sheel
create-react-app comment-app
```

然后在工程目录下的 `src/` 目录下新建四个文件，每个文件对应的是上述的四个组件。

```bash
src/
  CommentApp.js
  CommentInput.js
  CommentList.js
  Comment.js
  ...
```

你可以注意到，这里的文件名的开头是大写字母。我们遵循一个原则：如果一个文件导出的是一个类，那么这个文件名就用大写开头。四个组件类文件导出都是类，所以都是大写字母开头。

我们先铺垫一些基础代码，让组件之间的关系清晰起来。遵循“自顶而下，逐步求精”的原则，我们从组件的顶层开始，再一步步往下构建组件树。先修改 `CommentApp.js` 如下：

```javascript
import React, { Component } from 'react'
import CommentInput from './CommentInput'
import CommentList from './CommentList'

class CommentApp extends Component {
  render() {
    return (
      <div>
        <CommentInput />
        <CommentList />
      </div>
    )
  }
}

export default CommentApp
```

`CommentApp` 现在暂时还很简单，文件顶部引入了 `CommentInput` 和 `CommentList` 。然后按照上面的需求，应用在了 `CommentApp` 返回的 JSX 结构中，上面是用户输入区域，下面是评论列表。

现在来修改 `CommentInput.js` 中的内容：

```javascript
import React, { Component } from 'react'

class CommentInput extends Component {
  render() {
    return (
      <div>CommentInput</div>
    )
  }
}

export default CommentInput
```

这里暂时让它只简单返回 `<div>` 结构，同样地修改 `CommentList.js` ：

```javascript
import React, { Component } from 'react'

class CommentList extends Component {
  render() {
    return (
      <div>CommentList</div>
    )
  }
}

export default CommentList
```

现在可以把这个简单的结构渲染到页面上看看什么效果，修改 `src/index.js`：

```javascript
import React from 'react'
import ReactDOM from 'react-dom'
import CommentApp from './CommentApp'
import './index.css'

ReactDOM.render(
  <CommentApp />,
  document.getElementById('root')
)
```

然后进入工程目录启动工程：

```
npm run start
```

在浏览器中可以看到，基本的结构已经渲染到了页面上了：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/F1DAEB81-6DE9-4031-8476-9AA7047E4DA6.png)](http://huzidaha.github.io/static/assets/img/posts/F1DAEB81-6DE9-4031-8476-9AA7047E4DA6.png)

## 添加样式

现在想让这个结构在浏览器中居中显示，我们就要给 `CommentApp` 里面的 `<div>` 添加样式。修改 `CommentApp` 中的`render` 方法，给它添加一个 `wrapper` 类名：

```javascript
...
class CommentApp extends Component {
  render() {
    return (
      <div className='wrapper'>
        <CommentInput />
        <CommentList />
      </div>
    )
  }
}
...
```

然后在 `index.css` 文件中添加样式：

```css
.wrapper {
  width: 500px;
  margin: 10px auto;
  font-size: 14px;
  background-color: #fff;
  border: 1px solid #f1f1f1;
  padding: 20px;
}
```

在浏览器中可以看到样式生效了：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/770AFFBC-852C-4770-965A-695B43B7BB65.png)](http://huzidaha.github.io/static/assets/img/posts/770AFFBC-852C-4770-965A-695B43B7BB65.png)

评论功能案例的所有样式都是通过这种方式进行添加。由于我们专注点在于 React.js，本案例后续不会在样式上过于纠缠。这里写好了一个样式文件（[index.css](https://github.com/huzidaha/react-naive-book-examples/blob/master/comment-app/src/index.css) ）提供给大家，可以复制到 `index.css` 当中。后续只需要在元素上加上类名就可以了。

> index.css

```css
body {
    margin: 0;
    padding: 0;
    font-family: sans-serif;
    background-color: #fbfbfb;
  }
  
  .wrapper {
    width: 500px;
    margin: 10px auto;
    font-size: 14px;
    background-color: #fff;
    border: 1px solid #f1f1f1;
    padding: 20px;
  }
  
  /* 评论框样式 */
  .comment-input {
    background-color: #fff;
    border: 1px solid #f1f1f1;
    padding: 20px;
    margin-bottom: 10px;
  }
  
  .comment-field {
    margin-bottom: 15px;
    display: flex;
  }
  
  .comment-field .comment-field-name {
    display: flex;
    flex-basis: 100px;
    font-size: 14px;
  }
  
  .comment-field .comment-field-input {
    display: flex;
    flex: 1;
  }
  
  .comment-field-input input,
  .comment-field-input textarea {
    border: 1px solid #e6e6e6;
    border-radius: 3px;
    padding: 5px;
    outline: none;
    font-size: 14px;
    resize: none;
    flex: 1;
  }
  
  .comment-field-input textarea {
    height: 100px;
  }
  
  .comment-field-button {
    display: flex;
    justify-content: flex-end;
  }
  
  .comment-field-button button {
    padding: 5px 10px;
    width: 80px;
    border: none;
    border-radius: 3px;
    background-color: #00a3cf;
    color: #fff;
    outline: none;
    cursor: pointer;
  }
  
  .comment-field-button button:active {
    background: #13c1f1;
  }
  
  /* 评论列表样式 */
  .comment-list {
    background-color: #fff;
    border: 1px solid #f1f1f1;
    padding: 20px;
  }
  
  /* 评论组件样式 */
  .comment {
    position: relative;
    display: flex;
    border-bottom: 1px solid #f1f1f1;
    margin-bottom: 10px;
    padding-bottom: 10px;
    min-height: 50px;
  }
  
  .comment .comment-user {
    flex-shrink: 0;
  }
  
  .comment-username {
    color: #00a3cf;
    font-style: italic;
  }
  
  .comment-createdtime {
    padding-right: 5px;
    position: absolute;
    bottom: 0;
    right: 0;
    padding: 5px;
    font-size: 12px;
  }
  
  .comment:hover .comment-delete {
    color: #00a3cf;
  }
  
  .comment-delete {
    position: absolute;
    right: 0;
    top: 0;
    color: transparent;
    font-size: 12px;
    cursor: pointer;
  }
  
  .comment p {
    margin: 0;
    /*text-indent: 2em;*/
  }
  
  code {
    border: 1px solid #ccc;
    background: #f9f9f9;
    padding: 0px 2px;
  }
```

# 实战分析：评论功能（二）

## 处理用户输入

我们从 `ComponentInput` 组件开始，学习 React.js 是如何处理用户输入的。首先修改 `ComponentInput.js`，完善 `ComponentInput` 的 `render` 函数中的 HTML 结构：

```javascript
import React, { Component } from 'react'

class CommentInput extends Component {
  render () {
    return (
      <div className='comment-input'>
        <div className='comment-field'>
          <span className='comment-field-name'>用户名：</span>
          <div className='comment-field-input'>
            <input />
          </div>
        </div>
        <div className='comment-field'>
          <span className='comment-field-name'>评论内容：</span>
          <div className='comment-field-input'>
            <textarea />
          </div>
        </div>
        <div className='comment-field-button'>
          <button>
            发布
          </button>
        </div>
      </div>
    )
  }
}

export default CommentInput
```

在浏览器中可以看到 `ComponentInput` 的结构和样式都已经生效：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/E384080A-1876-4C76-B2B8-940D3EB2E774.png)](http://huzidaha.github.io/static/assets/img/posts/E384080A-1876-4C76-B2B8-940D3EB2E774.png)

因为还没有加入处理逻辑，所以你输入内容，然后点击发布是不会有什么效果的。用户可输入内容一个是用户名（username），一个是评论内容（content），我们在组件的构造函数中初始化一个 `state` 来保存这两个状态：

```javascript
...
class CommentInput extends Component {
  constructor () {
    super()
    this.state = {
      username: '',
      content: ''
    }
  }
  ...
}
...
```

然后给输入框设置 `value` 属性，让它们的 `value` 值等于 `this.state` 里面相应的值：

```javascript
...
        <div className='comment-field'>
          <span className='comment-field-name'>用户名：</span>
          <div className='comment-field-input'>
            <input value={this.state.username} />
          </div>
        </div>
        <div className='comment-field'>
          <span className='comment-field-name'>评论内容：</span>
          <div className='comment-field-input'>
            <textarea value={this.state.content} />
          </div>
        </div>
...
```

可以看到接受用户名输入的 `<input />` 和接受用户评论内容的 `<textarea />` 的 `value` 值分别由 `state.username` 和 `state.content` 控制。这时候你到浏览器里面去输入内容看看，你会发现你什么都输入不了。

这是为什么呢？React.js 认为所有的状态都应该由 React.js 的 state 控制，只要类似于 `<input />`、`<textarea />`、`<select />` 这样的输入控件被设置了 `value` 值，那么它们的值永远以被设置的值为准。值不变，`value` 就不会变化。

例如，上面设置了 `<input />` 的 `value` 为 `this.state.username`，`username` 在 `constructor` 中被初始化为空字符串。即使用户在输入框里面尝试输入内容了，还是没有改变 `this.state.username` 是空字符串的事实。

所以应该怎么做才能把用户内容输入更新到输入框当中呢？在 React.js 当中必须要用 `setState` 才能更新组件的内容，所以我们需要做的就是：监听输入框的 `onChange` 事件，然后获取到用户输入的内容，再通过 `setState` 的方式更新 `state` 中的 `username`，这样 `input` 的内容才会更新。

```html
...
    <div className='comment-field-input'>
      <input
        value={this.state.username}
        onChange={this.handleUsernameChange.bind(this)} />
    </div>
...
```

上面的代码给 `input` 加上了 `onChange` 事件监听，绑定到 `this.handleUsernameChange` 方法中，该方法实现如下：

```javascript
...
  handleUsernameChange (event) {
    this.setState({
      username: event.target.value
    })
  }
...
```

在这个方法中，我们通过 `event.target.value` 获取 `<input />` 中用户输入的内容，然后通过 `setState` 把它设置到 `state.username` 当中，这时候组件的内容就会更新，`input` 的 `value` 值就会得到更新并显示到输入框内。这时候输入已经没有问题了：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/10C463F1-26E4-4E05-8945-9B56D5F68CDD.png)](http://huzidaha.github.io/static/assets/img/posts/10C463F1-26E4-4E05-8945-9B56D5F68CDD.png)

类似于 `<input />`、`<select />`、`<textarea>` 这些元素的 `value` 值被 React.js 所控制、渲染的组件，在 React.js 当中被称为受控组件（Controlled Component）。对于用户可输入的控件，一般都可以让它们成为受控组件，这是 React.js 所推崇的做法。另外还有非受控组件，这里暂时不提及。

同样地，让 `<textarea />` 成为受控组件：

```javascript
...
  handleContentChange (event) {
    this.setState({
      content: event.target.value
    })
  }
...
      <div className='comment-field'>
        <span className='comment-field-name'>评论内容：</span>
        <div className='comment-field-input'>
          <textarea
            value={this.state.content}
            onChange={this.handleContentChange.bind(this)} />
        </div>
      </div>
...
```

## 向父组件传递数据

当用户在 `CommentInput` 里面输入完内容以后，点击发布，内容其实是需要显示到 `CommentList` 组件当中的。但这两个组件明显是单独的、分离的组件。我们再回顾一下之前是怎么划分组件的：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/DAFA784B-6AD3-474B-9A87-316E5741DED6.png)](http://huzidaha.github.io/static/assets/img/posts/DAFA784B-6AD3-474B-9A87-316E5741DED6.png)

可以看到，`CommentApp` 组件将 `CommentInput` 和 `CommentList` 组合起来，它是它们俩的父组件，可以充当桥接两个子组件的桥梁。*所以当用户点击发布按钮的时候，我们就将 `CommentInput` 的 state 当中最新的评论数据传递给父组件 `CommentApp` ，然后让父组件把这个数据传递给 `CommentList` 进行渲染。*

`CommentInput` 如何向 `CommentApp` 传递的数据？父组件 `CommentApp` 只需要通过 `props` 给子组件 `CommentInput` 传入一个回调函数。当用户点击发布按钮的时候，`CommentInput` 调用 `props` 中的回调函数并且将 `state` 传入该函数即可。

先给发布按钮添加事件：

```javascript
...
      <div className='comment-field-button'>
        <button
          onClick={this.handleSubmit.bind(this)}>
          发布
        </button>
      </div>
...
```

用户点击按钮的时候会调用 `this.handleSubmit` 方法：

```javascript
...
  handleSubmit () {
    if (this.props.onSubmit) {
      const { username, content } = this.state
      this.props.onSubmit({username, content})
    }
    this.setState({ content: '' })
  }
...
```

`handleSubmit` 方法会判断 `props` 中是否传入了 `onSubmit` 属性。有的话就调用该函数，并且把用户输入的用户名和评论数据传入该函数。然后再通过 `setState` 清空用户输入的评论内容（但为了用户体验，保留输入的用户名）。

修改 `CommentApp.js` ，让它可以通过传入回调来获取到新增评论数据：

```javascript
class CommentApp extends Component {
  handleSubmitComment (comment) {
    console.log(comment)
  }

  render() {
    return (
      <div className='wrapper'>
        <CommentInput
          onSubmit={this.handleSubmitComment.bind(this)} />
        <CommentList />
      </div>
    )
  }
}
```

在 `CommentApp` 中给 `CommentInput` 传入一个 `onSubmit` 属性，这个属性值是 `CommentApp` 自己的一个方法 `handleSubmitComment`。这样 `CommentInput` 就可以调用 `this.props.onSubmit(…)` 把数据传给 `CommenApp`。

现在在 `CommentInput` 中输入完评论内容以后点击发布，就可以看到 `CommentApp` 在控制台打印的数据：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/7F15DF0A-1DC8-436A-98F4-E6072DCD78BE.png)](http://huzidaha.github.io/static/assets/img/posts/7F15DF0A-1DC8-436A-98F4-E6072DCD78BE.png)

这样就顺利地把数据传递给了父组件，接下来我们开始处理评论列表相关的逻辑。

# 实战分析：评论功能（三）

接下来的代码比较顺理成章了。修改 `CommentList` 可以让它可以显示评论列表：

```javascript
// CommentList.js
import React, { Component } from 'react'

class CommentList extends Component {
  render() {
    const comments = [
      {username: 'Jerry', content: 'Hello'},
      {username: 'Tomy', content: 'World'},
      {username: 'Lucy', content: 'Good'}
    ]

    return (
      <div>{comments.map((comment, i) => {
        return (
          <div key={i}>
            {comment.username}：{comment.content}
          </div>
        )
      })}</div>
    )
  }
}

export default CommentList
```

这里的代码没有什么新鲜的内容，只不过是建立了一个 `comments` 的数组来存放一些测试数据的内容，方便我们后续测试。然后把 `comments` 的数据渲染到页面上，这跟我们之前讲解的章节的内容一样——使用 map 构建一个存放 JSX 的数组。就可以在浏览器看到效果：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/4EFF52CA-B573-4DBB-A313-8ADD90F65F24.png)](http://huzidaha.github.io/static/assets/img/posts/4EFF52CA-B573-4DBB-A313-8ADD90F65F24.png)

修改 `Comment.js` 让它来负责具体每条评论内容的渲染：

```javascript
import React, { Component } from 'react'

class Comment extends Component {
  render () {
    return (
      <div className='comment'>
        <div className='comment-user'>
          <span>{this.props.comment.username} </span>：
        </div>
        <p>{this.props.comment.content}</p>
      </div>
    )
  }
}

export default Comment
```

这个组件可能是我们案例里面最简单的组件了，它只负责每条评论的具体显示。你只需要给它的 `props` 中传入一个 `comment` 对象，它就会把该对象中的 `username` 和 `content` 渲染到页面上。

马上把 `Comment` 应用到 `CommentList` 当中，修改 `CommentList.js` 代码：

```javascript
import React, { Component } from 'react'
import Comment from './Comment'

class CommentList extends Component {
  render() {
    const comments = [
      {username: 'Jerry', content: 'Hello'},
      {username: 'Tomy', content: 'World'},
      {username: 'Lucy', content: 'Good'}
    ]

    return (
      <div>
        {comments.map((comment, i) => <Comment comment={comment} key={i} />)}
      </div>
    )
  }
}

export default CommentList
```

可以看到测试数据显示到了页面上：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/6A3B65A1-0CEA-4F98-B2E7-DC1D9B4CED83.png)](http://huzidaha.github.io/static/assets/img/posts/6A3B65A1-0CEA-4F98-B2E7-DC1D9B4CED83.png)

之前我们说过 `CommentList` 的数据应该是由父组件 `CommentApp` 传进来的，现在我们删除测试数据，改成从 `props` 获取评论数据：

```javascript
import React, { Component } from 'react'
import Comment from './Comment'

class CommentList extends Component {
  render() {
    return (
      <div>
        {this.props.comments.map((comment, i) =>
          <Comment comment={comment} key={i} />
        )}
      </div>
    )
  }
}

export default CommentList
```

这时候可以看到浏览器报错了：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/2B73DDBA-0D90-473A-BC2A-DB9C8E132458.png)](http://huzidaha.github.io/static/assets/img/posts/2B73DDBA-0D90-473A-BC2A-DB9C8E132458.png)

这是因为`CommentApp` 使用 `CommentList` 的时候并没有传入 `comments`。我们给 `CommentList` 加上 `defaultProps` 防止 `comments` 不传入的情况：

```javascript
class CommentList extends Component {
  static defaultProps = {
    comments: []
  }
...
```

这时候代码就不报错了。但是 `CommentInput` 给 `CommentApp` 传递的评论数据并没有传递给 `CommentList`，所以现在发表评论时没有反应的。

我们在 `CommentApp` 的 `state` 中初始化一个数组，来保存所有的评论数据，并且通过 `props` 把它传递给 `CommentList`。修改 `CommentApp.js`：

```javascript
import React, { Component } from 'react'
import CommentInput from './CommentInput'
import CommentList from './CommentList'

class CommentApp extends Component {
  constructor () {
    super()
    this.state = {
      comments: []
    }
  }

  handleSubmitComment (comment) {
    console.log(comment)
  }

  render() {
    return (
      <div className='wrapper'>
        <CommentInput onSubmit={this.handleSubmitComment.bind(this)} />
        <CommentList comments={this.state.comments}/>
      </div>
    )
  }
}

export default CommentApp
```

接下来，修改 `handleSubmitComment` ：每当用户发布评论的时候，就把评论数据插入 `this.state.comments` 中，然后通过 `setState` 把数据更新到页面上：

```javascript
...
  handleSubmitComment (comment) {
    this.state.comments.push(comment)
    this.setState({
      comments: this.state.comments
    })
  }
...
```

> 小提示：这里的代码直接往 `state.comments` 数组里面插入数据其实违反了 React.js 的 [`state` 不可直接修改的原则](https://facebook.github.io/react/tutorial/tutorial.html#why-immutability-is-important) 。但其实这个原则是为了 `shouldComponentUpdate` 的优化和变化的跟踪，而这种目的在使用 React-redux 的时候其实会自然而然达到，我们很少直接手动地优化，这时候这个原则就会显得有点鸡肋。所以这里为了降低大家的理解成本就不强制使用这个原则，有兴趣的朋友可以参考： [Tutorial: Intro To React - React](https://facebook.github.io/react/tutorial/tutorial.html#why-immutability-is-important)。

现在代码应该是可以按照需求正常运作了，输入用户名和评论内容，然后点击发布：

[![React.js 小书实战之评论功能图片](http://huzidaha.github.io/static/assets/img/posts/62C055E7-F668-4C70-A0C0-B8989A5E3B58.png)](http://huzidaha.github.io/static/assets/img/posts/62C055E7-F668-4C70-A0C0-B8989A5E3B58.png)

为了让代码的健壮性更强，给 `handleSubmitComment` 加入简单的数据检查：

```javascript
...
  handleSubmitComment (comment) {
    if (!comment) return
    if (!comment.username) return alert('请输入用户名')
    if (!comment.content) return alert('请输入评论内容')
    this.state.comments.push(comment)
    this.setState({
      comments: this.state.comments
    })
  }
...
```

到这里，我们的第一个实战案例——评论功能已经完成了！完整的案例代码可以在这里 [comment-app](https://github.com/huzidaha/react-naive-book-examples/tree/master/comment-app) 找到， [在线演示](https://huzidaha.github.io/react-naive-book-examples/comment-app/build/index.html) 体验。

## 总结

在这个案例里面，我们除了复习了之前所学过的内容以外还学习了新的知识点。包括：

1. 实现功能之前先理解、分析需求，划分组件。并且掌握划分组件的基本原则——可复用性、可维护性。
2. 受控组件的概念，React.js 中的 `<input />` 、`<textarea />`、`<select />` 等元素的 `value` 值如果是受到 React.js 的控制，那么就是受控组件。
3. 组件之间使用 `props` 通过父元素传递数据的技巧。

当然，在真实的项目当中，这个案例很多地方是可以优化的。包括组件可复用性方面（有没有发现其实 `CommentInput` 中有重复的代码？）、应用的状态管理方面。但在这里为了给大家总结和演示，实现到这个程度也就足够了。

到此为止，React.js 小书的第一阶段已经结束，你可以利用这些知识点来构建简单的功能模块了。但是在实际项目如果要构建比较系统和完善的功能，还需要更多的 React.js 的知识还有关于前端开发的一些认知来协助我们。接下来我们会开启新的一个阶段来学习更多关于 React.js 的知识，以及如何更加灵活和熟练地使用它们。让我们进入第二阶段吧！

# 实战分析：评论功能（四）

目前为止，第二阶段知识已经基本介绍完，我们已经具备了项目上手实战必备的 React.js 知识，现在可以把这些知识应用起来。接下来是实战环节，我们会继续上一阶段的例子，把评论功能做得更加复杂一点。

我们在上一阶段的评论功能基础上加上以下功能需求：

1. 页面加载完成自动聚焦到评论输入框。
2. 把用户名持久化，存放到浏览器的 LocalStorage 中。页面加载时会把用户名加载出来显示到输入框，用户就不需要重新输入用户名了。
3. 把已经发布的评论持久化，存放到浏览器的 LocalStorage 中。页面加载时会把已经保存的评论加载出来，显示到页面的评论列表上。
4. 评论显示发布日期，如“1 秒前”，”30 分钟前”，并且会每隔 5 秒更新发布日期。
5. 评论可以被删除。
6. 类似 Markdown 的行内代码块显示功能，用户输入的用 `` 包含起来的内容都会被处理成用 `<code>` 元素包含。例如输入 `console.log` 就会处理成 `<code>console.log</code>` 再显示到页面上。

[![React.js 小书实战评论功能图片](http://huzidaha.github.io/static/assets/img/posts/E01D3698-F041-4149-9626-849F023E5638.png)](http://huzidaha.github.io/static/assets/img/posts/E01D3698-F041-4149-9626-849F023E5638.png)

[在线演示地址](https://huzidaha.github.io/react-naive-book-examples/comment-app2/build/index.html)。

大家可以在原来的第一阶段代码的基础上进行修改，第一、二阶段评论功能代码可以在这里找到： [react-naive-book-examples](https://github.com/huzidaha/react-naive-book-examples)。可以直接使用最新的样式文件 [index.css](https://github.com/huzidaha/react-naive-book-examples/blob/master/comment-app2/src/index.css) 覆盖原来的 index.css。

接下来可以分析如何利用第二阶段的知识来构建这些功能，在这个过程里面可能会穿插一些小技巧，希望对大家有用。我们回顾一下这个页面的组成：

[![React.js 小书实战评论功能图片](http://huzidaha.github.io/static/assets/img/posts/1.003.png)](http://huzidaha.github.io/static/assets/img/posts/1.003.png)

我们之前把页面分成了四种不同的组件：分别是 `CommentApp` 、`CommentInput`、`CommentList`、`Comment`。我们开始修改这个组件，把上面的需求逐个完成。

## 自动聚焦到评论框

这个功能是很简单的，我们需要获取 `textarea` 的 DOM 元素然后调用 `focus()` API 就可以了。我们给输入框元素加上 `ref` 以便获取到 DOM 元素，修改 `src/CommentInput.js` 文件：

```javascript
...
    <textarea
      ref={(textarea) => this.textarea = textarea}
      value={this.state.content}
      onChange={this.handleContentChange.bind(this)} />
...
```

组件挂载完以后完成以后就可以调用 `this.textarea.focus()`，给 `CommentInput` 组件加上 `ComponentDidMount` 生命周期：

```javascript
class CommentInput extends Component {
  static propTypes = {
    onSubmit: PropTypes.func
  }

  constructor () {
    super()
    this.state = {
      username: '',
      content: ''
    }
  }

  componentDidMount () {
    this.textarea.focus()
  }
...
```

这个功能就完成了。现在体验还不是很好，接下来我们把用户名持久化一下，体验就会好很多。

大家可以注意到我们给原来的 `props.onSubmit` 参数加了组件参数验证，在这次实战案例中，我们都会给评论功能的组件加上 `propTypes` 进行参数验证，接下来就不累述。

## 持久化用户名

用户输入用户名，然后我们把用户名保存到浏览器的 LocalStorage 当中，当页面加载的时候再从 LocalStorage 把之前保存的用户名显示到用户名输入框当中。这样用户就不用每次都输入用户名了，并且评论框是自动聚焦的，用户的输入体验就好很多。

我们监听用户名输入框失去焦点的事件 `onBlur`：

```javascript
...
    <input
      value={this.state.username}
      onBlur={this.handleUsernameBlur.bind(this)}
      onChange={this.handleUsernameChange.bind(this)} />
...
```

在 `handleUsernameBlur` 中我们把用户的输入内容保存到 LocalStorage 当中：

```javascript
class CommentInput extends Component {
  constructor () {
    super()
    this.state = {
      username: '',
      content: ''
    }
  }

  componentDidMount () {
    this.textarea.focus()
  }

  _saveUsername (username) {
    localStorage.setItem('username', username)
  }

  handleUsernameBlur (event) {
    this._saveUsername(event.target.value)
  }
...
```

在 `handleUsernameBlur` 中我们把用户输入的内容传给了 `_saveUsername` 私有方法（所有私有方法都以 `_` 开头）。`_saveUsername` 会设置 LocalStorage 中的 `username` 字段，用户名就持久化了。这样就相当于每当用户输入完用户名以后（输入框失去焦点的时候），都会把用户名自动保存一次。

输入用户名，然后到浏览器里里面看看是否保存了：

[![React.js 小书实战评论功能图片](http://huzidaha.github.io/static/assets/img/posts/04093DE1-B4C0-4CBD-B3F8-DF924C9F6799.png)](http://huzidaha.github.io/static/assets/img/posts/04093DE1-B4C0-4CBD-B3F8-DF924C9F6799.png)

然后我们组件挂载的时候把用户名加载出来。这是一种数据加载操作，我们说过，不依赖 DOM 操作的组件启动的操作都可以放在 `componentWillMount` 中进行，所以给 `CommentInput` 添加 `componentWillMount` 的组件生命周期：

```javascript
...
  componentWillMount () {
    this._loadUsername()
  }

  _loadUsername () {
    const username = localStorage.getItem('username')
    if (username) {
      this.setState({ username })
    }
  }

  _saveUsername (username) {
    localStorage.setItem('username', username)
  }
...
```

`componentWillMount` 会调用 `_loadUsername` 私有方法，`_loadUsername` 会从 LocalStorage 加载用户名并且 `setState` 到组件的 `state.username` 中。那么组件在渲染的时候（`render` 方法）挂载的时候就可以用上用户名了。

这样体验就好多了，刷新页面，不需要输入用户名，并且自动聚焦到了输入框。我们 1、 2 需求都已经完成。

## 小贴士

这里插入一些小贴示，大家可以注意到我们组件的命名和方法的摆放顺序其实有一定的讲究，这里可以简单分享一下个人的习惯，仅供参考。

组件的私有方法都用 `_` 开头，所有事件监听的方法都用 `handle` 开头。把事件监听方法传给组件的时候，属性名用 `on` 开头。例如：

```javascript
<CommentInput
  onSubmit={this.handleSubmitComment.bind(this)} />
```

这样统一规范处理事件命名会给我们带来语义化组件的好处，监听（`on`）`CommentInput` 的 `Submit` 事件，并且交给 `this` 去处理（`handle`）。这种规范在多人协作的时候也会非常方便。

另外，组件的内容编写顺序如下：

1. static 开头的类属性，如 `defaultProps`、`propTypes`。
2. 构造函数，`constructor`。
3. getter/setter（还不了解的同学可以暂时忽略）。
4. 组件生命周期。
5. `_` 开头的私有方法。
6. 事件监听方法，`handle*`。
7. `render*`开头的方法，有时候 `render()` 方法里面的内容会分开到不同函数里面进行，这些函数都以 `render*` 开头。
8. `render()` 方法。

如果所有的组件都按这种顺序来编写，那么维护起来就会方便很多，多人协作的时候别人理解代码也会一目了然。

# 实战分析：评论功能（五）

- 作者：[胡子大哈](https://www.zhihu.com/people/hu-zi-da-ha)
- 原文链接：[ http://huziketang.com/books/react/lesson26](http://huziketang.com/books/react/lesson26)
- 转载请注明出处，保留原文链接和作者信息。

（本文未审核）

## 持久化评论

同样地，可以通过类似于用户名持久化的方式对评论列表内容进行持久化，让用户发布的评论在刷新页面以后依然可以存在。修改 `src/CommentApp.js`：

```javascript
class CommentApp extends Component {
  constructor () {
    super()
    this.state = {
      comments: []
    }
  }

  componentWillMount () {
    this._loadComments()
  }

  _loadComments () {
    let comments = localStorage.getItem('comments')
    if (comments) {
      comments = JSON.parse(comments)
      this.setState({ comments })
    }
  }

  _saveComments (comments) {
    localStorage.setItem('comments', JSON.stringify(comments))
  }

  handleSubmitComment (comment) {
    if (!comment) return
    if (!comment.username) return alert('请输入用户名')
    if (!comment.content) return alert('请输入评论内容')
    const comments = this.state.comments
    comments.push(comment)
    this.setState({ comments })
    this._saveComments(comments)
  }
...
```

我们增加了 `_loadComments` 和 `_saveComments` 分别用于加载和保存评论列表数据。用户每次提交评论都会把评论列表数据保存一次，所以我们在 `handleSubmitComment` 调用 `_saveComments` 方法；而在 `componentWillMount` 中调用 `_loadComments` 方法，在组件开始挂载的时候把评论列表数据加载出来 `setState` 到 `this.state` 当中，组件就可以渲染从 LocalStorage 从加载出来的评论列表数据了。

现在发布评论，然后刷新可以看到我们的评论并不会像以前一样消失。非常的不错，持久化评论的功能也完成了。

## 显示评论发布时间

现在我们给每条评论都加上发布的日期，并且在评论列表项上显示已经发表了多久，例如“1 秒前”、“30分钟前”，并且会每隔 5 秒进行更新。修改 `src/CommentInput.js` 当用户点击发布按钮的时候，传出去的评论数据带上评论发布的时间戳：

```javascript
...
  handleSubmit () {
    if (this.props.onSubmit) {
      this.props.onSubmit({
        username: this.state.username,
        content: this.state.content,
        createdTime: +new Date()
      })
    }
    this.setState({ content: '' })
  }
...
```

在评论列表项上显示评论，修改 `src/comment.js`：

```javascript
class Comment extends Component {
  static propTypes = {
    comment: PropTypes.object.isRequired
  }

  constructor () {
    super()
    this.state = { timeString: '' }
  }

  componentWillMount () {
    this._updateTimeString()
  }

  _updateTimeString () {
    const comment = this.props.comment
    const duration = (+Date.now() - comment.createdTime) / 1000
    this.setState({
      timeString: duration > 60
        ? `${Math.round(duration / 60)} 分钟前`
        : `${Math.round(Math.max(duration, 1))} 秒前`
    })
  }

  render () {
    return (
      <div className='comment'>
        <div className='comment-user'>
          <span>{this.props.comment.username} </span>：
        </div>
        <p>{this.props.comment.content}</p>
        <span className='comment-createdtime'>
          {this.state.timeString}
        </span>
      </div>
    )
  }
}
```

每个 `Comment` 组件实例会保存一个 `timeString` 状态，用于该评论显示发布了多久。`_updateTimeString` 这个私有方法会根据 `props.comment` 里面的 `createdTime` 来更新这个 `timeString`：计算当前时间和评论发布时间的时间差，如果已经发布 60 秒以上就显示分钟，否则就显示秒。然后 `componentWillMount` 会在组件挂载阶段调用 `_updateTimeString` 更新一下这个字符串，`render()` 方法就把这个显示时间差的字符串渲染到一个 `<span>` 上。

再看看页面显示：

[![React.js 小书实战评论功能图片](http://huzidaha.github.io/static/assets/img/posts/209D576F-45A1-42A7-ADDB-A01AE03BB3D5.png)](http://huzidaha.github.io/static/assets/img/posts/209D576F-45A1-42A7-ADDB-A01AE03BB3D5.png)

这时候的时间是不会自动更新的。除非你手动刷新页面，否则永远显示“1 秒前”。我们可以在 `componentWillMount` 中启动一个定时器，每隔 5 秒调用一下 `_updateTimeString`，让它去通过 `setState` 更新 `timeString`：

```javascript
...
  componentWillMount () {
    this._updateTimeString()
    this._timer = setInterval(
      this._updateTimeString.bind(this),
      5000
    )
  }
...
```

这样就可以做到评论的发布时间自动刷新了，到这里前 4 个需求都已经完成了。

# 实战分析：评论功能（六）

- 作者：[胡子大哈](https://www.zhihu.com/people/hu-zi-da-ha)
- 原文链接：[ http://huziketang.com/books/react/lesson27](http://huziketang.com/books/react/lesson27)
- 转载请注明出处，保留原文链接和作者信息。

（本文未审核）

## 删除评论

现在发布评论，评论不会消失，评论越来越多并不是什么好事。所以我们给评论组件加上删除评论的功能，这样就可以删除不想要的评论了。修改 `src/Comment.js` 的 `render` 方法，新增一个删除按钮：

```javascript
...
  render () {
    const { comment } = this.props
    return (
      <div className='comment'>
        <div className='comment-user'>
          <span className='comment-username'>
            {comment.username}
          </span>：
        </div>
        <p>{comment.content}</p>
        <span className='comment-createdtime'>
          {this.state.timeString}
        </span>
        <span className='comment-delete'>
          删除
        </span>
      </div>
    )
  }
... 
```

我们在后面加了一个删除按钮，因为 `index.css` 定义了样式，所以鼠标放到特定的评论上才会显示删除按钮，让用户体验好一些。

我们知道评论列表数据是放在 `CommentApp` 当中的，而这个删除按钮是在 `Comment` 当中的，现在我们要做的事情是用户点击某条评论的删除按钮，然后在 `CommentApp` 中把相应的数据删除。但是 `CommentApp` 和 `Comment` 的关系是这样的：

[![React.js 小书实战评论功能图片](http://huzidaha.github.io/static/assets/img/posts/DAFA784B-6AD3-474B-9A87-316E5741DED6.png)](http://huzidaha.github.io/static/assets/img/posts/DAFA784B-6AD3-474B-9A87-316E5741DED6.png)

`Comment` 和 `CommentApp` 之间隔了一个 `CommentList`，`Comment` 无法直接跟 `CommentApp` 打交道，只能通过 `CommentList` 来转发这种删除评论的消息。修改 `Comment` 组件，让它可以把删除的消息传递到上一层：

```javascript
class Comment extends Component {
  static propTypes = {
    comment: PropTypes.object.isRequired,
    onDeleteComment: PropTypes.func,
    index: PropTypes.number
  }
...
  handleDeleteComment () {
    if (this.props.onDeleteComment) {
      this.props.onDeleteComment(this.props.index)
    }
  }

  render () {
    ...
        <span
          onClick={this.handleDeleteComment.bind(this)}
          className='comment-delete'>
          删除
        </span>
      </div>
    )
  }
```

现在在使用 `Comment` 的时候，可以传入 `onDeleteComment` 和 `index` 两个参数。`index` 用来标志这个评论在列表的下标，这样点击删除按钮的时候我们才能知道你点击的是哪个评论，才能知道怎么从列表数据中删除。用户点击删除会调用 `handleDeleteComment` ，它会调用从上层传入的 `props. onDeleteComment` 函数告知上一层组件删除的消息，并且把评论下标传出去。现在修改 `src/CommentList.js` 让它把这两个参数传进来：

```javascript
class CommentList extends Component {
  static propTypes = {
    comments: PropTypes.array,
    onDeleteComment: PropTypes.func
  }

  static defaultProps = {
    comments: []
  }

  handleDeleteComment (index) {
    if (this.props.onDeleteComment) {
      this.props.onDeleteComment(index)
    }
  }

  render() {
    return (
      <div>
        {this.props.comments.map((comment, i) =>
          <Comment
            comment={comment}
            key={i}
            index={i}
            onDeleteComment={this.handleDeleteComment.bind(this)} />
        )}
      </div>
    )
  }
}
```

当用户点击按钮的时候，`Comment` 组件会调用 `props.onDeleteComment`，也就是 `CommentList` 的 `handleDeleteComment` 方法。而 `handleDeleteComment` 会调用 `CommentList` 所接受的配置参数中的 `props.onDeleteComment`，并且把下标传出去。

也就是说，我们可以在 `CommentApp` 给 `CommentList` 传入一个 `onDeleteComment` 的配置参数来接受这个删除评论的消息，修改 `CommentApp.js`：

```javascript
...
  handleDeleteComment (index) {
    console.log(index)
  }

  render() {
    return (
      <div className='wrapper'>
        <CommentInput onSubmit={this.handleSubmitComment.bind(this)} />
        <CommentList
          comments={this.state.comments}
          onDeleteComment={this.handleDeleteComment.bind(this)} />
      </div>
    )
  }
}
...
```

现在点击删除按钮，可以在控制台看到评论对应的下标打印了出来。其实这就是这么一个过程：`CommentList` 把下标 `index` 传给 `Comment`。点击删除按钮的时候，`Comment` 把 `index` 传给了 `CommentList`，`CommentList` 再把它传给 `CommentApp`。现在可以在 `CommentApp` 中删除评论了：

```javascript
...
  handleDeleteComment (index) {
    const comments = this.state.comments
    comments.splice(index, 1)
    this.setState({ comments })
    this._saveComments(comments)
  }
...
```

我们通过 `comments.splice` 删除特定下标的评论，并且通过 `setState` 重新渲染整个评论列表；当然了，还需要把最新的评论列表数据更新到 LocalStorage 中，所以我们在删除、更新以后调用了 `_saveComments` 方法把数据同步到 LocalStorage 中。

现在就可以愉快地删除评论了。但是，你删除评论以后 5 秒钟后就会在控制台中看到报错了：

[![React.js 小书实战评论功能图片](http://huzidaha.github.io/static/assets/img/posts/83C3CDDD-F8C5-4C37-B848-852E98E0E464.png)](http://huzidaha.github.io/static/assets/img/posts/83C3CDDD-F8C5-4C37-B848-852E98E0E464.png)

这是因为我们忘了清除评论的定时器，修改 `src/Comment.js`，新增生命周期 `commentWillUnmount` 在评论组件销毁的时候清除定时器：

```javascript
...
  componentWillUnmount () {
    clearInterval(this._timer)
  }
...
```

这才算完成了第 5 个需求。

## 显示代码块

用户在的输入内容中任何以 `` 包含的内容都会用 `<code>` 包含起来显示到页面上。`<code>` 这是一个 HTML 结构，需要往页面动态插入 HTML 结构我们只能用 `dangerouslySetInnerHTML` 了，修改 `src/Comment.js`，把原来 `render()` 函数中的：

```javascript
<p>{comment.content}</p>
```

修改成：

```javascript
<p dangerouslySetInnerHTML={{
  __html: this._getProcessedContent(comment.content)
}} />
```

我们把经过 `this._getProcessedContent` 处理的评论内容以 HTML 的方式插入到 `<p>` 元素中。`this._getProcessedContent` 要把 `` 包含的内容用 `<code>` 包裹起来，一个正则表达式就可以做到了：

```javascript
...
  _getProcessedContent (content) {
    return content
      .replace(/`([\S\s]+?)`/g, '<code>$1</code>')
  }
...
```

但是这样做会有严重的 XSS 漏洞，用户可以输入任意的 HTML 标签，用 `<script>` 执行任意的 JavaScript 代码。所以在替换代码之前，我们要手动地把这些 HTML 标签进行转义：

```javascript
...
  _getProcessedContent (content) {
    return content
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;")
      .replace(/'/g, "&#039;")
      .replace(/`([\S\s]+?)`/g, '<code>$1</code>')
  }
...
```

前 5 个 `replace` 实际上是把类似于 `<`、`>` 这种内容替换转义一下，防止用户输入 HTML 标签。最后一行代码才是实现功能的代码。

这时候在评论框中输入：

> 这是代码块 `console.log`，这是 <h1>正常内容</h1>。

然后点击发布，看看效果：

[![React.js 小书实战评论功能图片](http://huzidaha.github.io/static/assets/img/posts/5C18C820-E406-4D38-95DC-B4FEA70E34EE.png)](http://huzidaha.github.io/static/assets/img/posts/5C18C820-E406-4D38-95DC-B4FEA70E34EE.png)

我们安全地完成了第 6 个需求。到目前为止，第二阶段的实战已经全部完成，你可以在[这里](https://github.com/huzidaha/react-naive-book-examples)找到完整的代码。

## 总结

到这里第二阶段已经全部结束，我们已经掌握了全部 React.js 实战需要的入门知识。接下来我们会学习两个相对比较高级的 React.js 的概念，然后进入 React-redux 的世界，让它们配合 React.js 来构建更成熟的前端页面。