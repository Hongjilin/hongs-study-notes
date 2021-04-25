>该笔记是本人整理的面向倾向实习生面试的HTML基础笔记(本人遇到的或者是面试过程、学习过程觉得会问的),进行分享,有需要的小伙伴应该可以得到帮助
>
>本人笔记地址分享:[`全部笔记`](https://gitee.com/hongjilin/hongs-study-notes)、[`前端学习笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0)、[`数据结构与算法学习笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E7%AE%97%E6%B3%95%E5%8F%8A%E8%AF%BE%E7%A8%8B%E5%9F%BA%E7%A1%80%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95)、[`LeetCode笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E7%AE%97%E6%B3%95%E5%8F%8A%E8%AF%BE%E7%A8%8B%E5%9F%BA%E7%A1%80%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95/LeetCode)
>
>​											整理时间:2020/10

# #目录

>[TOC]

## 1、HTML5 有哪些新特性(稍微了解)

HTML5 标准提供了哪些新的 API？

这个问题可以聊的东西特别多，下面是我搜集的以及一些扩展知识；

## 一、声明方式

### 核心

HTML4 规定了三种声明方式，分别是：``严格模式、过渡模式 和 框架集模式``；

而HTML5因为不是`SGML`(一般指标准通用置标语言)的子集，只需要`<!DOCTYPE>`就可以了：

### HTML4声明方式

HTML4 规定了三种不同的 `<!DOCTYPE>` 声明，分别是：Strict、Transitional 和 Frameset;

**HTML4 Strict** / 严格

```html
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN""http://www.w3.org/TR/html4/strict.dtd">
```

**HTML4 Transitional** /过渡

```
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
```

**HTML4 Frameset**/框架集

```
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN""http://www.w3.org/TR/html4/frameset.dtd">
```

### HTML5声明方式

HTML5 现在已经不是 SGML 的子集，从最开始的声明方式就不一样了，改为了`<!DOCTYPE>`；

```html
<!DOCTYPE html>
```

关于声明方式的更改，这个可以参考

- [HTML  标签](https://www.axihe.com/api/html/basic/tag-doctype.html)
- [网站 HTML 标准](https://www.axihe.com/edu/quality/elements.html#doctype-元素)
- [HTML4和HTML5的区别](https://www.axihe.com/anbang/js/edu/html-document-tag.html#html4和html5的区别)

HTML5 主要是关于图像，位置，存储，多任务等功能的增加，下面是具体的

## 二、语义化更好的内容标签

- [header](https://www.axihe.com/api/html/styles-semantics/tag-header.html)
- [footer](https://www.axihe.com/api/html/styles-semantics/tag-footer.html)
- [article](https://www.axihe.com/api/html/styles-semantics/tag-article.html)
- [aside](https://www.axihe.com/api/html/styles-semantics/tag-aside.html)
- [section](https://www.axihe.com/api/html/styles-semantics/tag-section.html)
- [details](https://www.axihe.com/api/html/styles-semantics/tag-details.html)
- [summary](https://www.axihe.com/api/html/styles-semantics/tag-summary.html)
- [dialog](https://www.axihe.com/api/html/styles-semantics/tag-dialog.html)

### 核心

为了规范HTML页面，有利于搜索引擎；

**对前端开发人员的好处**：可以根据这些语义化标签，更好的进行模块化处理；我们可以在写React/Vue等项目的时候，根据这些来做模块区分；

**对外的好处**：我们可以和设计师沟通，按照这种模块进行页面设计，如果是PS设计的页面，还可以参考这个进行图层编组

## 三、音频、视频

音频、视频 API(audio,video)

- [audio](https://www.axihe.com/api/html/audio-video/tag-audio.html)
- [video](https://www.axihe.com/api/html/audio-video/tag-video.html)

可以在标签内查看用法

### 核心

通过 `audio`/`video` 实现音频和视频的操作；

使用时候需要注意几种数据源格式的支持；

还有一些辅助标签来精细的做多媒体，比如可以通过`<track>`做歌词和字幕。

## 四、表单控件

HTML5 拥有多个新的表单输入类型。这些新特性提供了更好的输入控制和验证。

- color
- date
- datetime
- datetime-local
- email
- month
- number
- range
- search
- tel
- time
- url
- week

具体参考：[HTML5 新的 Input 类型](https://www.axihe.com/edu/html5/form/input-types.html)

### 核心

更有利于移动端做表单时候，比如电话号码，email，输入类型的限制；

> **但是**：我们真正做项目的时候，不能光靠这个来做校验，不仅我们前端要做校验，一个合格的后端不应该相信前端传入的任何数据；

## 五、5个API

### 5.1-本地存储

### 核心

长期存储数据的 `localStorage`，**比较常用**

临时存储的 `sessionStorage`，浏览器关闭后自动删除，**实际工作中使用的场景不多**

### localStorage

本地离线存储 localStorage 长期存储数据，浏览器关闭后数据不丢失；

只读的 localStorage 属性允许你访问一个 Document 源（origin）的对象 Storage；存储的数据将保存在浏览器会话中。

localStorage 类似 sessionStorage，但其区别在于：存储在 localStorage 的数据可以长期保留；而当页面会话结束——也就是说，当页面被关闭时，存储在 sessionStorage 的数据会被清除 。

具体参考：https://developer.mozilla.org/zh-CN/docs/Web/API/Window/localStorage

阿西河前端教程的夜间模式，就是根据`localStorage`来实现的；

### sessionStorage

sessionStorage 的数据在浏览器关闭后自动删除

sessionStorage 属性允许你访问一个 session Storage 对象。它与 localStorage 相似，不同之处在于 localStorage 里面存储的数据没有过期时间设置，而存储在 sessionStorage 里面的数据在页面会话结束时会被清除。页面会话在浏览器打开期间一直保持，并且重新加载或恢复页面仍会保持原来的页面会话。在新标签或窗口打开一个页面时会复制顶级浏览会话的上下文作为新会话的上下文，这点和 session cookies 的运行方式不同。

具体参考：https://developer.mozilla.org/zh-CN/docs/Web/API/Window/sessionStorage

### 5.2-画布/Canvas

- [canvas](https://www.axihe.com/api/html/images/tag-canvas.html)
- [figure](https://www.axihe.com/api/html/images/tag-figure.html)
- [figcaption](https://www.axihe.com/api/html/images/tag-figcaption.html)

演示：https://wow.techbrood.com/fiddle/30964

### 5.3-地理/Geolocation

地理位置 API 允许用户向 Web 应用程序提供他们的位置。出于隐私考虑，报告地理位置前会先请求用户许可。

具体参考：[HTML5 Geolocation（地理定位）](https://www.axihe.com/edu/html5/api/geolocation.html)

类似Google搜索页面，底部显示位置的样子,还有点餐的，我的位置相关的；

延伸：如果我们打算根据不同的地理位置加载不同的资源，可以借助第三方的IP库；参考 [JavaScript 获取用户客户端的 ip 地址，邮编，城市名](https://www.axihe.com/anbang/blog/javascript/js-get-user-clients-ip-address-zip-code-city-name.html);

### 5.4-拖拽释放

HTML拖拽释放 (Drag and drop) 接口使应用程序能够在浏览器中使用拖放功能。

例如，通过这些功能，用户可以使用鼠标选择可拖动元素，将元素拖动到可放置元素，并通过释放鼠标按钮来放置这些元素。

可拖动元素的一个半透明表示在拖动操作期间跟随鼠标指针。

详情参考 [HTML 拖放 API](https://www.axihe.com/web/api/html-drag-and-drop-api.html)

在线浏览拖拽效果：https://mdn.github.io/dom-examples/drag-and-drop/copy-move-DataTransfer.html

### 核心

功能：可以把一个元素拖动放到目标区域，并且可以定义它的中间效果；

它的实现过程有：

- 1.确定什么是可拖动的源
- 2.定义拖动元源
  - 定义拖动数据
  - 定义拖动图像
  - 定义拖动效果
- 3.定义一个放置区
- 4.处理放置效果
- 5.拖动结束

### 5.5-Web Workers

webworker, websocket, Geolocation

当在 HTML 页面中执行脚本时，页面的状态是不可响应的，直到脚本已完成。

web worker 是运行在后台的 JavaScript，独立于其他脚本，不会影响页面的性能。您可以继续做任何愿意做的事情：点击、选取内容等等，而此时 web worker 在后台运行。

具体参考：[HTML5 Web Workers](https://www.axihe.com/edu/html5/edu/webworkers.html)

### 核心

Web Worker 的作用，就是为 JavaScript 创造多线程环境，允许主线程创建 Worker 线程，将一些任务分配给后者运行。

在主线程运行的同时，Worker 线程在后台运行，两者互不干扰。等到 Worker 线程完成计算任务，再把结果返回给主线程。

这样的好处是，一些计算密集型或高延迟的任务，被 Worker 线程负担了，主线程（通常负责 UI 交互）就会很流畅，不会被阻塞或拖慢。

## 六、HTML4和HTML5的区别

最重要的标志，就是看类型声明；

- HTML5是用 `<!DOCTYPE html>` 这种的声明
- HTML4是用 `<! DOCTYPE html PUBLIC “-//W3C//DTD XHTML 4.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>` 这种的声明；

`<!DOCTYPE>` 声明推荐是放在 HTML 文档的第一行，位于 `<html>` 标签之前。

#### 为什么HTML和HTML5声明的类型不同？

- 在 HTML4 中，`<!DOCTYPE>` 声明引用 DTD，因为 HTML4 基于 SGML。DTD 规定了标记语言的规则，这样浏览器才能正确地呈现内容。
- HTML5 不基于 SGML，所以不需要引用 DTD。

**注释**：`<!DOCTYPE>` 声明没有结束标签，并且对大小写不敏感。

因为这里是告诉浏览器的渲染方式，所以这里决定此文件是HTML4还是5，不过并没有什么软用，现在一般都是HTML5的声明格式；记住第一个就可以了；这些都不是重点

另外HTML5为了更好的符合语义化和升级，新增了 `header`、`footer`、`section`、`audio`、`video` 等标签；