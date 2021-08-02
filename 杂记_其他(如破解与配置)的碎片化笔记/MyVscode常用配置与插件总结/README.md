# #目录

>[TOC]



# vscode

## 一.修改快捷键

File >> Preferences >> Keyboard Shprtcuts >>右上角+ 代码模式>>复制以下代码

```json
[
  {
      "key": " shift+j",
      "command": "editor.action.triggerSuggest",
      "when": "editorHasCompletionItemProvider && textInputFocus && !editorReadonly"
  },
  {
      "key": " alt+/",
      "command": "editor.action.triggerSuggest",
      "when": "editorHasCompletionItemProvider && textInputFocus && !editorReadonly"
  },
  {
      "key": "ctrl+space",
      "command": "-editor.action.triggerSuggest",
      "when": "editorHasCompletionItemProvider && textInputFocus && !editorReadonly"
  },
  {
      "key": "ctrl+d",
      "command": "editor.action.deleteLines",
      "when": "textInputFocus && !editorReadonly"
  },
  {
      "key": "ctrl+shift+k",
      "command": "-editor.action.deleteLines",
      "when": "textInputFocus && !editorReadonly"
  },
  {
    "key": "ctrl+down",
    "command": "editor.action.insertCursorBelow",
    "when": "editorTextFocus"
  },
  {
    "key": "ctrl+alt+down",
    "command": "editor.action.copyLinesDownAction",
    "when": "editorTextFocus && !editorReadonly"
}
]
```

## 二、常用插件

##### (1)Class autocomplete for HTML

> 自动重命名配对的HTML/XML标签(必备)

##### (2)**.Beautify**

> 格式化代码，值得注意的是，beautify插件支持自定义格式化代码规则

###### 1. 在工作目录下建立.jsbeautifyrc文件

```json
{
   "brace_style": "none,preserve-inline",
   "indent_size": 2,
   "indent_char": " ",
   "jslint_happy": true,
   "unformatted": [""],
   "css": {
     "indent_size": 2
   }
 }
```

> 注释
>
> - `brace_style`，格式风格，详见官方说明（为避免和eslint默认检查冲突，建议此属性设置为 none,preserve-inline）
> - `indent_size`，缩进长度（为避免和eslint默认检查冲突，建议此属性设置为 2）
> - `indent_char`，缩进填充的内容（充满♂）
> - `jslint_happy:true`，若你要搭配jslint使用，请开启此选项
> - `unformatted:["a","pre"]`，这里放不需要格式化的标签类型。注意 template 也是默认不格式化的，.vue 的template 标签如果需要格式化请在 .jsbeautifyrc 重新定义不带 template 的声明属性

###### 2. 启用保存时自动

> 在VSCode的配置文件里添加 `editor.formatOnSave:true` 即可实现保存时自动格式化

###### 3. 快捷键

> 在 VS Code 的键盘快捷方式文件里添加

```json
{
  "key": "cmd+b", // 自己定键位
  "command": "HookyQR.beautify",
  "when": "editorFocus"
}
```

#####  (3)**Debugger for Chrome**

> 映射vscode上的断点到chrome上，方便调试

#####  (4)**Courier New**

>一款好看字体

##### (5)**HTML CSS Support**

> 智能提示CSS类名以及id

##### (6)**HTML Snippets**

> 智能提示HTML标签，以及标签含义

##### (7)**JavaScript(ES6) code snippets**

> ES6语法智能提示，以及快速输入，不仅仅支持.js，还支持.ts，.jsx，.tsx，.html，.vue，省去了配置其支持各种包含js代码文件的时间

##### (8)**.open in browser**

> vscode不像IDE一样能够直接在浏览器中打开html，而该插件支持快捷键与鼠标右键快速在浏览器中打开html文件，支持自定义打开指定的浏览器，包括：Firefox，Chrome，Opera，IE以及Safari

##### (9)**fileheader**

> 顶部注释模板，可定义作者、时间等信息，并会自动更新最后修改时间，快捷键ctrl+alt+i在文件开头自动输入作者信息和修改信息等内容

##### (10)Path Intellisense

> 路径自动补全

##### (11)npm Intellisense

> require的包提示

##### (12)Live server

> 静态代码保存自动更新页面

##### (13)Simple React Snippets

> React代码提示与补全
>
> （2）安装完成后使用快捷键测试：
>
> | Snippet | Renders                          |
> | ------- | -------------------------------- |
> | imr     | Import React                     |
> | imrc    | Import React / Component         |
> | impt    | Import PropTypes                 |
> | impc    | Import React / PureCompnent      |
> | cc      | Class Component                  |
> | ccc     | Class Component With Constructor |
> | sfc     | Stateless Function Component     |
> | cdm     | componentDidMount                |
> | cwm     | componentWillMount               |
> | cwrp    | componentWillReceiveProps        |
> | gds     | getDerivedStateFromProps         |
> | scu     | shouldComponentUpdate            |
> | cwu     | componentWillUpdate              |
> | cdu     | componentDisUpdate               |
> | cwu     | componentWillUpdate              |
> | cdc     | componentDidCatch                |
> | gsbu    | getSnapshotBeforeUpdate          |
> | ss      | setState                         |
> | ssf     | Functional setState              |
> | ren     | render                           |
> | rprop   | Render Prop                      |
> | hoc     | Higher Order Component           |



##### (14) Markdown Shortcuts

> vscode`预览md`文件插件
>
> 安装完毕，重启VSCode，然后打开.md文件。Ctrl + Shift + V，即可预览。然后双击相应位置即可修改对应内容

##### (15)ES7 React/Redux/GraphQL/React-Native snippets

> react代码块提示插件
>
> ## Basic Methods
>
> | Prefix  | Method                                              |
> | :------ | :-------------------------------------------------- |
> | `imp→`  | `import moduleName from 'module'`                   |
> | `imn→`  | `import 'module'`                                   |
> | `imd→`  | `import { destructuredModule } from 'module'`       |
> | `ime→`  | `import * as alias from 'module'`                   |
> | `ima→`  | `import { originalName as aliasName} from 'module'` |
> | `exp→`  | `export default moduleName`                         |
> | `exd→`  | `export { destructuredModule } from 'module'`       |
> | `exa→`  | `export { originalName as aliasName} from 'module'` |
> | `enf→`  | `export const functionName = (params) => { }`       |
> | `edf→`  | `export default (params) => { }`                    |
> | `met→`  | `methodName = (params) => { }`                      |
> | `fre→`  | `arrayName.forEach(element => { }`                  |
> | `fof→`  | `for(let itemName of objectName { }`                |
> | `fin→`  | `for(let itemName in objectName { }`                |
> | `anfn→` | `(params) => { }`                                   |
> | `nfn→`  | `const functionName = (params) => { }`              |
> | `dob→`  | `const {propName} = objectToDescruct`               |
> | `dar→`  | `const [propName] = arrayToDescruct`                |
> | `sti→`  | `setInterval(() => { }, intervalTime`               |
> | `sto→`  | `setTimeout(() => { }, delayTime`                   |
> | `prom→` | `return new Promise((resolve, reject) => { }`       |
> | `cmmb→` | `comment block`                                     |
> | `cp→`   | `const { } = this.props`                            |
> | `cs→`   | `const { } = this.state`                            |
>
> ## React
>
> | Prefix      | Method                                                       |
> | :---------- | :----------------------------------------------------------- |
> | `imr→`      | `import React from 'react'`                                  |
> | `imrd→`     | `import ReactDOM from 'react-dom'`                           |
> | `imrc→`     | `import React, { Component } from 'react'`                   |
> | `imrcp→`    | `import React, { Component } from 'react' & import PropTypes from 'prop-types'` |
> | `imrpc→`    | `import React, { PureComponent } from 'react'`               |
> | `imrpcp→`   | `import React, { PureComponent } from 'react' & import PropTypes from 'prop-types'` |
> | `imrm→`     | `import React, { memo } from 'react'`                        |
> | `imrmp→`    | `import React, { memo } from 'react' & import PropTypes from 'prop-types'` |
> | `impt→`     | `import PropTypes from 'prop-types'`                         |
> | `imrr→`     | `import { BrowserRouter as Router, Route, NavLink} from 'react-router-dom'` |
> | `imbr→`     | `import { BrowserRouter as Router} from 'react-router-dom'`  |
> | `imbrc→`    | `import { Route, Switch, NavLink, Link } from react-router-dom'` |
> | `imbrr→`    | `import { Route } from 'react-router-dom'`                   |
> | `imbrs→`    | `import { Switch } from 'react-router-dom'`                  |
> | `imbrl→`    | `import { Link } from 'react-router-dom'`                    |
> | `imbrnl→`   | `import { NavLink } from 'react-router-dom'`                 |
> | `imrs→`     | `import React, { useState } from 'react'`                    |
> | `imrse→`    | `import React, { useState, useEffect } from 'react'`         |
> | `redux→`    | `import { connect } from 'react-redux'`                      |
> | `rconst→`   | `constructor(props) with this.state`                         |
> | `rconc→`    | `constructor(props, context) with this.state`                |
> | `est→`      | `this.state = { }`                                           |
> | `cwm→`      | `componentWillMount = () => { }` DEPRECATED!!!               |
> | `cdm→`      | `componentDidMount = () => { }`                              |
> | `cwr→`      | `componentWillReceiveProps = (nextProps) => { }` DEPRECATED!!! |
> | `scu→`      | `shouldComponentUpdate = (nextProps, nextState) => { }`      |
> | `cwup→`     | `componentWillUpdate = (nextProps, nextState) => { }` DEPRECATED!!! |
> | `cdup→`     | `componentDidUpdate = (prevProps, prevState) => { }`         |
> | `cwun→`     | `componentWillUnmount = () => { }`                           |
> | `gdsfp→`    | `static getDerivedStateFromProps(nextProps, prevState) { }`  |
> | `gsbu→`     | `getSnapshotBeforeUpdate = (prevProps, prevState) => { }`    |
> | `ren→`      | `render() { return( ) }`                                     |
> | `sst→`      | `this.setState({ })`                                         |
> | `ssf→`      | `this.setState((state, props) => return { })`                |
> | `props→`    | `this.props.propName`                                        |
> | `state→`    | `this.state.stateName`                                       |
> | `rcontext→` | `const ${1:contextName} = React.createContext()`             |
> | `cref→`     | `this.${1:refName}Ref = React.createRef()`                   |
> | `fref→`     | `const ref = React.createRef()`                              |
> | `bnd→`      | `this.methodName = this.methodName.bind(this)`               |
>
> ## React Hooks
>
> - All hooks from [official docs](https://reactjs.org/docs/hooks-reference.html) are added with hook name prefix.
>
> ## React Native
>
> | Prefix     | Method                                 |
> | :--------- | :------------------------------------- |
> | `imrn→`    | `import { $1 } from 'react-native'`    |
> | `rnstyle→` | `const styles = StyleSheet.create({})` |
>
> ## Redux
>
> | Prefix       | Method                    |
> | :----------- | :------------------------ |
> | `rxaction→`  | `redux action template`   |
> | `rxconst→`   | `export const $1 = '$1'`  |
> | `rxreducer→` | `redux reducer template`  |
> | `rxselect→`  | `redux selector template` |
> | `rxslice→`   | `redux slice template`    |
>
> ## PropTypes
>
> | Prefix    | Method                                   |
> | :-------- | :--------------------------------------- |
> | `pta→`    | `PropTypes.array`                        |
> | `ptar→`   | `PropTypes.array.isRequired`             |
> | `ptb→`    | `PropTypes.bool`                         |
> | `ptbr→`   | `PropTypes.bool.isRequired`              |
> | `ptf→`    | `PropTypes.func`                         |
> | `ptfr→`   | `PropTypes.func.isRequired`              |
> | `ptn→`    | `PropTypes.number`                       |
> | `ptnr→`   | `PropTypes.number.isRequired`            |
> | `pto→`    | `PropTypes.object`                       |
> | `ptor→`   | `PropTypes.object.isRequired`            |
> | `pts→`    | `PropTypes.string`                       |
> | `ptsr→`   | `PropTypes.string.isRequired`            |
> | `ptnd→`   | `PropTypes.node`                         |
> | `ptndr→`  | `PropTypes.node.isRequired`              |
> | `ptel→`   | `PropTypes.element`                      |
> | `ptelr→`  | `PropTypes.element.isRequired`           |
> | `pti→`    | `PropTypes.instanceOf(name)`             |
> | `ptir→`   | `PropTypes.instanceOf(name).isRequired`  |
> | `pte→`    | `PropTypes.oneOf([name])`                |
> | `pter→`   | `PropTypes.oneOf([name]).isRequired`     |
> | `ptet→`   | `PropTypes.oneOfType([name])`            |
> | `ptetr→`  | `PropTypes.oneOfType([name]).isRequired` |
> | `ptao→`   | `PropTypes.arrayOf(name)`                |
> | `ptaor→`  | `PropTypes.arrayOf(name).isRequired`     |
> | `ptoo→`   | `PropTypes.objectOf(name)`               |
> | `ptoor→`  | `PropTypes.objectOf(name).isRequired`    |
> | `ptsh→`   | `PropTypes.shape({ })`                   |
> | `ptshr→`  | `PropTypes.shape({ }).isRequired`        |
> | `ptany→`  | `PropTypes.any`                          |
> | `ptypes→` | `static propTypes = {}`                  |
>
> ## GraphQL
>
> | Prefix     | Method                                                  |
> | :--------- | :------------------------------------------------------ |
> | `graphql→` | `import { compose, graphql } from react-apollo'`        |
> | `expgql->` | `export default compose(graphql($1, { name: $2 }))($3)` |
>
> ## Console
>
> | Prefix | Method                              |
> | :----- | :---------------------------------- |
> | `clg→` | `console.log(object)`               |
> | `clo→` | `console.log("object", object)`     |
> | `ctm→` | `console.time("timeId")`            |
> | `cte→` | `console.timeEnd("timeId")`         |
> | `cas→` | `console.assert(expression,object)` |
> | `ccl→` | `console.clear()`                   |
> | `cco→` | `console.count(label)`              |
> | `cdi→` | `console.dir`                       |
> | `cer→` | `console.error(object)`             |
> | `cgr→` | `console.group(label)`              |
> | `cge→` | `console.groupEnd()`                |
> | `ctr→` | `console.trace(object)`             |
> | `cwa→` | `console.warn`                      |
> | `cin→` | `console.info`                      |

##### (16)GitLens — Git supercharged

>由于分支太多，开发人员太多，有时候合代码需要查看哪行代码谁写的。用 git blame太过繁琐，而且查看起来眼花缭乱，降低生产力。
>
>建议使用插件GitLens

##### (17)kiwi-linter

>kiwi 的 `VS Code`插件工具，主要用于检测代码中的中文，高亮出中文字符串，并一键提取中文字符串到对应的语言 Key 库。
>
>同时优化开发体验，在 `VS Code` 中提供搜索中文，`提示国际化值对应的中文功能`。
>
>![image-20210802182512649](README/image-20210802182512649.png)



## 三、格式化修改缩进2(4)格无效解决

>1. 打开文件——》首选——》设置
>2. 输入搜索 tabsize  改为2
>
>③ 如果仍然没有效果 在首选项->设置=>工作区设置=>搜索(Detect Indentation)  -->将勾选去掉

###### 

## 四、vscode终端使用命令时报错：因为在此系统上禁止运行脚本。有关详细信息..

>原因：百度后得知，无法运行脚本，应该是不被信任。
>执行命令:
>
>```csharp
>get-ExecutionPolicy
>```
>
>结果是Restricted，意思就是受限制的，说明确实是因为不被信任的缘故

解决：

>执行命令:
>
>```csharp
>set-ExecutionPolicy RemoteSigned
>```
>
>结果是RemoteSigned，意思就是远程签名，说明已经取得信任。

## 五、将VSCode添加至右键菜单(Windows下)

>`问题`:Windows上面安装Visual Studio Code编辑器后,常常会因为安装的时候忘记勾选等原因,没有将"Open with Code(右键快捷方式)"添加到鼠标右键菜单里,使用起来多有不便,所以需要我们手动将VSCode添加至鼠标右键菜单之中.

>`解决`:
>
>1.新建reg文件.在桌面上新建一个文本文件,然后将文件后缀改为:*.reg,文件名任意,例如:add_shortcut.reg.
>
>2.编写文本文件内容.将下面的内容Copy到刚才新建的*.reg文件中,文本内容如下:
>
>3.下面代码中的地址表示VSCode在电脑上的安装路径,如果不是默认安装的或者路径不一样,`需要改成和电脑上实际安装路径一致的`.
>
>4.文件编辑好了之后保存关闭.然后双击运行 add_shortcut.reg ,遇到提示点击 "确定"或"是".不出意外,便大功告成了!

```js
Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\*\shell\VSCode]
@="Open with Code"
"Icon"="C:\\Users\\Administrator\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe"

[HKEY_CLASSES_ROOT\*\shell\VSCode\command]
@="\"C:\\Users\\Administrator\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe\" \"%1\""

Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\Directory\shell\VSCode]
@="Open with Code"
"Icon"="C:\\Users\\Administrator\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe"

[HKEY_CLASSES_ROOT\Directory\shell\VSCode\command]
@="\"C:\\Users\\Administrator\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe\" \"%V\""

Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\Directory\Background\shell\VSCode]
@="Open with Code"
"Icon"="C:\\Users\\Administrator\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe"

[HKEY_CLASSES_ROOT\Directory\Background\shell\VSCode\command]
@="\"C:\\Users\\Administrator\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe\" \"%V\""
```

