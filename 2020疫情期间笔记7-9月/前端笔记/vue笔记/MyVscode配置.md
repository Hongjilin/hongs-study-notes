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
        "key": "ctrl+alt+down",
        "command": "editor.action.copyLinesDownAction",
        "when": "editorTextFocus && !editorReadonly"
    },
    {
        "key": "shift+alt+down",
        "command": "-editor.action.copyLinesDownAction",
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