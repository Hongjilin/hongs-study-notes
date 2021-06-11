# #说明

> 作为开发人员，平时用的最多的就是[`Chrome devtools`](https://developer.chrome.com/docs/devtools)了此笔记将整理平时用的比较多的一些调试小技巧、网上或者别人教的好用的技巧
>
> 这个真的很有必要,对于此工具的使用从侧面也体现了一个前端程序员的经验(本人看到前辈流畅的使用这个工具的时候内心独白:6啊老铁,还能这样的?),对于前端来说会使用DevTools真的是一项必备技能了
>
> 此笔记将结合 [官方文档](https://developer.chrome.com/docs/devtools/javascript/)、查阅的博客如:segmentfault中`CompileYouth`、简书的`澄澄真可爱`、CSDN的`@Demi`、[`精致灰`](https://blog.csdn.net/qq_26858401)等包括但不仅限此的博客或资料、以及自己的理解进行整理与撰写,不是文档翻译哦
>
> 测试页面截图也都直接按照本人gitee为模板,本部分知识点实践占比很重,`所以我会画大量示例图`,可以对照操作.所以还是建议下载笔记后使用[`Typora`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E6%9D%82%E8%AE%B0_%E5%85%B6%E4%BB%96(%E5%A6%82%E7%A0%B4%E8%A7%A3%E4%B8%8E%E9%85%8D%E7%BD%AE)%E7%9A%84%E7%A2%8E%E7%89%87%E5%8C%96%E7%AC%94%E8%AE%B0/Typora%E7%AC%94%E8%AE%B0%E8%BD%AF%E4%BB%B6%E5%88%86%E4%BA%AB),我就是按照这个软件排版写的,图片缩放什么的都设置了,从网页上看的话图片排版很乱(可能很大)且难以观阅的
>
> 本人[全部笔记地址](https://gitee.com/hongjilin/hongs-study-notes)
>
> 说明:本人此笔记记录于2021年,用的是如今最新版本的chrome

# #目录

>[TOC]

# Chrome DevTools 使用详解

>Chrome DevTools（Chrome 开发者工具） 是内嵌在 Chrome 浏览器里的一组用于网页制作和调试的工具。官网还推荐一款叫做 [Chrome 金丝雀版本（Chrome Canary）](https://www.google.com/intl/en/chrome/browser/canary.html)的 Chrome 浏览器，从这里你可以获得最新版本的 DevTools。为什么 Google 称之为金丝雀呢，因为金丝雀早期在矿井中被用来预警，而该版本的 Chrome 一定程度上也能起到该作用。不用担心 Chrome Canary 会覆盖原本的 Chrome,它们是两个不同的软件

## 一、九大功能模块

>DevTools 是很多功能的集合，而在窗口顶部的工具栏是对这些功能的分组。最新的 Chrome 主要有 9 个功能组，分别对应了 9 个面板：
>
>- **Elements**：在 Elements 面板中可以通过 DOM 树的形式查看所有页面元素，同时也能对这些页面元素进行所见即所得的编辑
>- **Console**：一方面用来记录页面在执行过程中的信息（一般通过各种 console 语句来实现），另一方面用来当做 shell 窗口来执行脚本以及与页面文档、DevTools等进行交互
>- **Sources**：Sources 面板主要用来调试页面中的 JavaScript
>- **Network**：在 Network 面板中可以查看通过网络来请求来的资源的详细信息以及请求这些资源的耗时
>- **Performance**：在 Performance 面板可以查看页面加载过程中的详细信息，比如在什么时间开始做什么事情，耗时多久等等。有人会问，这个跟上面的 Network 有什么区别呢，上面也能显示耗时信息。在 Performance 面板中，你不仅可以看到通过网络加载资源的信息，还能看到解析 JS、计算样式、重绘等页面加载的方方面面的信息
>- **Memory**：Memory 面板主要显示页面 JS 对象和相关联的 DOM 节点的内存分布情况
>- **Application**：记录网页加载的所有资源，包括存储信息、缓存信息以及页面用到的图片、字体、脚本、样式等信息
>- **Security**：用于检测当面页面的安全性
>- **Audits**：审计面板会对页面的加载进行分析，然后给出提高页面性能的建议，官网建议查看 [PageSpeed Insights](https://developers.google.com/speed/pagespeed/insights/) 来获得更多的页面加载建议。
>
>`ps`:有的 Chrome 上面没有 Performance 和 Memory，而是 Timeline 和 Profiles，是不是我写错了呢？不是的，而是 Chrome 到 v57 后，便将 Timeline 更名为 Performance，将 Profiles 更名为 Memory。目前来看，Google 仅仅是更名以及调整了部分功能所属的面板而已，并没有功能上的增删

### 1、Elements 面板

>Elements 面板主要用于对页面 HTML 和 CSS 的检查以及可视化编辑。
>
>这是本人gitee的Elements面板
>
>![image-20210609144357487](ChromeDevTools使用详解笔记中的图片/image-20210609144357487.png)
>
>可以看到整个面板被分成 3 个部分(`截图上看是4个,但实际上3个部分`,中右两个同是样式)，左边主体为`DOM树`,左下角为选中的元素节点,(中间为选中节点的样式,最右边也是样式(*是内置的Computed面板*)--此处也是后面点即内置面板出现内容的地方),当你界面较小时可以合并至同一处视图

#### Ⅰ- DOM树

##### 	1)  检查页面元素

>- 右击页面任意一处，选择检查 / 审查元素，查看选中页面对应的 DOM 元素
>- 点击 ![toolbar-1.png](ChromeDevTools使用详解笔记中的图片/toolbar-1.png)，当图标显示为蓝色时，鼠标点击页面任意一处，可以查看选中页面对应的 DOM 元素
>- 鼠标悬停 DOM 树上的任意一个节点，页面会用淡蓝色的蒙板在页面上标记 DOM 节点对应的页面
>- 按键盘的向上向下键可以在展开的节点之间进行切换，向左向右键可以收缩和展开节点

##### 	2)  编辑 DOM

>你可以任意修改 DOM 树上的任意信息，比如修改节点的类型、属性，或者改变 DOM 节点的所属关系等等。不过需要注意的是，这些修改都是临时的，不会得到保存，当刷新页面时所有修改都将重置。

###### 	① ***常见的几个操作***

>- 双击元素标签，修改 DOM 节点类型，比如将 div 改成 ul
>- 双击元素属性，修改 DOM 节点属性，比如修改节点的 id
>- 选择一个 DOM 节点，按 enter 键，然后按 tab 键选择想修改的属性或标签
>- 选择一个 DOM 节点，并将其拖到目标位置，可以改变页面元素的结构
>- 选择一个 DOM 节点，按 delete 键删除
>- Ctrl + Z / Cmd + Z，撤回操作

###### 	② *选中后右键更多操作详解*

>1. 选中后右键更多操作截图:<img src="ChromeDevTools使用详解笔记中的图片/image-20210609145621990.png" alt="image-20210609145621990" style="zoom:67%;" />
>
>2. 更多的操作详解
>
>   - `Add Attribute`：为选中节点添加一个属性
>
>   - `Edit Attribute`：修改选中节点中选中属性
>
>   - `Edit as HTML`：将选中节点当做 HTML 进行编辑
>
>   - `Delete element`：删除节点
>
>   - `Copy→`:复制选中的节点，可以复制选中节点的选择器、XPath、元素本身、outerHTML 等，也能剪切、粘贴节点，我们一般选择复制节点的选择器
>
>   - `Hide element`：隐藏节点
>
>   - `Force state→`:4个伪类-选中则表示所选节点处于相应的状态，比如选中 `er` 则表示所选节点当前正处于鼠标悬停的状态
>
>   - `Expand all`：展开所选节点下的所有子节点
>
>   - `Collapse all`：收缩所选节点下的所有子节点，包括自己
>
>   - `Scroll into View`：如果所选的 DOM 节点对应的页面元素不在可视区域内的话，点击这个选项则会将页面滚动到可以显示对应的页面元素的位置
>
>   - `Break on`：给 DOM 节点设置断点，主要用来调试 JavaScript 代码，这段代码的作用是用来修改所加断点的 DOM 节点，这一般用在比较复杂的网页应用当中。可以给所选的 DOM 节点添加 3 种类型的断点：
>
>     - subtree modifications：所选节点的子节点被添加、删除、移动的话，则会触发
>
>     - attribute modifications：所选节点的属性被修改的话，则会触发
>
>     - node removal：所选节点被删除的话，则会触发
>
>     - 这 3 种断点可以同时作用在一个节点上。为了便于大家理解，我们举个例子:我给本人gitee页面上的节点加一个 "attribute modifications" 的断点，如下图所示：
>
>       ![image-20210609151828033](ChromeDevTools使用详解笔记中的图片/image-20210609151828033.png)

#### Ⅱ- elements的内置面板

> ![image-20210609152836698](ChromeDevTools使用详解笔记中的图片/image-20210609152836698.png)
>
> 分别是：
>
> - Style：实时编辑与所选元素相关的样式
> - Computed：检查编辑所选元素的盒模型
> - Event Listeners：查看所选元素相关的 JS 事件监听
> - DOM Breakpoints: DOM 断点
> - Properties：所选节点对应的对象及父类们
> - Layout:本人理解主要用来看页面网格参数的,不详细赘述,感觉没啥用  --有些版本没有
> - Accessibility:你可以查看整个页面中的Accessibility Tree，该 Tree 是DOM tree 的子集，对应节点是由对屏幕阅读器（screen reader）有关和有用的展示内容。 --有些版本没有

##### 	1) Styles面板

>Styles 面板可以允许你通过各种方式来修改元素的样式，并且会想方设法使得你调试时简单方便。
>
>下方按照图中标注的序号进行描述：
>![image-20210609155354802](ChromeDevTools使用详解笔记中的图片/image-20210609155354802.png)

###### 	① *element.style：*

> 代表所选元素的内联样式。比如我选择的是 Git 的 header 块，如果我直接修改其 HTML 为 `<div class="header" style="background: red"></div>`，那么 element.style 中就会出现 `background: red;`，相反，如果我在 element.style 块中点击任意空白处，添加 CSS 样式，那么你会在对应的元素节点上看到 style 属性，值就是你写在 element.style 内的内容

###### 	②*鼠标悬浮在*![element-style-6.png](ChromeDevTools使用详解笔记中的图片/element-style-6.png)上:

> 鼠标悬浮在![element-style-6.png](ChromeDevTools使用详解笔记中的图片/element-style-6.png)上会出现 ![element-style-5.png](ChromeDevTools使用详解笔记中的图片/element-style-5.png)(有些版本没有)，可以帮助你通过可视化界面的形式调试 text-shadow、 box-shadow、 color、 background。另外，最后一个 "+" 的符号代表可以添加新的 CSS 规则

###### 	③ *单击属性或者属性值*

> 单击属性或者属性值，进行修改，按 tab 键修改下一个属性或值，按 tab + shift 修改上一个属性或值。当值是数字类型时，按上下键可以以 1 为单位递增或递减，按 alt + 上下键以 0.1 为单位递增或递减，shift + 上下键以 10 为单位递增或递减，记不得这些快捷键就老老实实手动输入吧；点击空白处，添加新的样式

###### 	④ *取色器*

> Style 面板对 color 非常友好，点击色块可以打开取色器（color picker，取色器功能非常强大，大家自行感受），然后对颜色进行可视化编辑。同样的，shadow 属性也能如此

###### 	⑤ *继承的样式*

> 以 "Inherited from ..." 为分界，上面的样式都是作用于元素本身的，下面的都是其继承而来的，继承的对象一般不止一个，可能是父元素，父元素的父元素...

###### 	⑥ *查看该选择器影响的元素*

> 将鼠标悬停在一个选择器上时，可以看到这个选择器所影响的所有页面元素（不包括可视区域外的元素）

###### 	⑦ *三个选项:`:hov`、`cls`、`+`*

>1. 点击"`:hov`":可以强制所选元素处于某个状态，这个也能通过右击元素，选择一个状态来实现
>
>   <img src="ChromeDevTools使用详解笔记中的图片/image-20210608161110741.png" alt="image-20210608161110741" style="zoom:80%;" />
>
>2. "`cls`":查看所有与当前元素直接相关的样式规则，你可以禁止/允许某个类作用于所选元素，也可以添加新的类(可以与隔壁`+`功能搭配使用)
>
>   ![image-20210609161540168](ChromeDevTools使用详解笔记中的图片/image-20210609161540168.png)
>
>3. "`+`":默认给选中元素新建一个样式规则类(可以与`cls`搭配),上面的`span.aaa`就是此功能创建出来的

###### 	总结

> 现在的 CSS 文件基本上都是编译后的结果，而保存的文件一般也是编译后的 CSS 文件，所以这么做的作用不大。所以我们一般将 Styles 面板当做一个所见即所得的调试工具。当然,这时我同查阅到的学习资料博主一样发出呼吁:如果有可以直接保存原始样式文件的方法,请留言谢谢:dog:

##### 	2) Computed面板

>Computed 面板显示了如下内容：
>
>- 所选元素的盒模型
>- 所选元素的 CSS 样式以及值，不仅显示最终所采用的值，也显示被覆盖了的值
>- 每个属性值所在的文件
>
>鼠标悬停在盒模型上的 margin、border、padding 以及内容区域，可以在网页中看到与之相对应的区域。你还可以双击盒模型上的数字来修改它。如果所选元素的 position 属性的值为 absolute 或者 fixed 的话，还可以在 margin 的外围设置 position。
>
>![image-20210609164044139](ChromeDevTools使用详解笔记中的图片/image-20210609164044139.png)

##### 	3) Event Listeners

>查看所选元素相关的 JS 事件监听--此处直接举例
>
>1. 应用场景举例:当你想要查找某个元素绑定的点击事件,就可以通过该方法直接定位到代码中
>2. 操作:
>
>  1) 切换 “Elements" 元素面板,点击文档节点
>
>  2) 选择 “Event Listeners” 页签
>
>  3) 展开相应的事件名,如“click”
>
>  4) 对 “handler” 点击右键,选择 “Show funciton definition”
>
>  5) 点击后就会自动定位
>
>3. 示例图
>
>  <img src="ChromeDevTools使用详解笔记中的图片/image-20210608162406603.png" alt="image-20210608162406603" style="zoom: 67%;" />

##### 	4) DOM Breakpoints

>查看、操作DOM断点
>
>当把鼠标悬停在节点标识符上时可以在网页相应区域显示对应的页面元素，勾选前面的复选框代表断点有效，不勾选代表断点虽然存在，但无法使用。
>
><img src="ChromeDevTools使用详解笔记中的图片/image-20210609170200907.png" alt="image-20210609170200907" style="zoom:80%;" />
>
>

##### 	5) Properties

>这是所选 DOM 节点对应的对象以及这个对象的父类、父类的父类...的集合。
>
>![image-20210609170750848](ChromeDevTools使用详解笔记中的图片/image-20210609170750848.png)

### 2、Console 面板

>Chrome DevTools 的 Console 主要提供两类功能：
>
>- 在开发过程中记录代码诊断信息
>- 与文档和 DevTools 交互的命令行工具

#### Ⅰ- 打开 Console

>1. 首先，先提一下打开 Console 的方法。第一种是之前提到过的：`Ctrl + Shift + J / Cmd + Opt + J`，打开 DevTools，并且直接定位到控制台面板。
>
>2. `Console drawer`:这种比较特殊，如果你想打开其他功能面板的同时，还想打开 Console 的话，[详见本笔记常用操作第17点](#17、打开控制台抽屉)

#### Ⅱ- Console 中的内置菜单详解

> 我们先看一下 Console 的界面，看看这个曾经很熟悉的界面是否真的熟悉![image-20210609181850152](ChromeDevTools使用详解笔记中的图片/image-20210609181850152.png)
>
> 上下结构，上面是功能按钮或选项，下面是信息展示或交互的面板。先看上面，从左往右，依次是：
>
> - ![image-20210609182042261](ChromeDevTools使用详解笔记中的图片/image-20210609182042261.png):显示/隐藏侧边栏的按钮，其功能是进行控制台面板的显示信息过滤。
> - ![image-20210609182028915](ChromeDevTools使用详解笔记中的图片/image-20210609182028915.png):清空 Console控制台打印内容
> - ![image-20210609182234858](ChromeDevTools使用详解笔记中的图片/image-20210609182234858.png):执行环境选择器,比如切换成`vue-devtools`
> - ![image-20210609182327170](ChromeDevTools使用详解笔记中的图片/image-20210609182327170.png):监听变量,点击后输入某变量,就会将其置顶显示在console顶部,每次变量值改变都会同步上去
> - ![image-20210609182136699](ChromeDevTools使用详解笔记中的图片/image-20210609182136699.png):过滤 Console 中的信息,可以用正则,也可以直接输入变量名
> - ![image-20210609182826833](ChromeDevTools使用详解笔记中的图片/image-20210609182826833.png):也是对消息的过滤-分为**Verbose（详细）,Info（信息），Warnings（警告）,Error（错误)**四个等级类型
> - ![image-20210609182447874](ChromeDevTools使用详解笔记中的图片/image-20210609182447874.png):其他的隐藏功能-如`Preserve log`刷新时保存当前console的变量等

##### 	1)	 过滤信息

>上面按钮中过滤信息的为
>
>1. ![image-20210609182042261](ChromeDevTools使用详解笔记中的图片/image-20210609182042261.png)、![image-20210609182826833](ChromeDevTools使用详解笔记中的图片/image-20210609182826833.png):显示侧边栏时其右边的`Default levels`下拉菜单会被禁止使用，因为它的作用也是过滤信息并且侧边栏的过滤功能包含它![image-20210609184500891](ChromeDevTools使用详解笔记中的图片/image-20210609184500891.png)
>
>   **共有四种选项，按照严重级别排序分别为：Verbose（详细）,Info（信息），Warnings（警告）,Error（错误）。**
>   **在侧边栏的信息过滤功能中，除了上述四种过滤方式外还可以根据具体的messages进行过滤**
>
>   
>
>2. ![image-20210609182136699](ChromeDevTools使用详解笔记中的图片/image-20210609182136699.png):**过滤框主要能按照以下三种类型的输入进行信息过滤：**
>
>   1) URL
>
>   2) 上下文
>
>   3) 正则表达式
>
>   示例图
>
>   ![image-20210609185937713](ChromeDevTools使用详解笔记中的图片/image-20210609185937713.png)

##### 	2) 清空标志:清空控制台信息

>1. ![image-20210609182028915](ChromeDevTools使用详解笔记中的图片/image-20210609182028915.png):清空 Console控制台打印内容
>2. 在控制台中键入clear()，然后运行
>3. Ctrl+L清空

##### 	3) top下拉标志:切换执行环境

>1. ![image-20210609182234858](ChromeDevTools使用详解笔记中的图片/image-20210609182234858.png)此下拉菜单称为 Execution Context Selector,通常，您会看到此环境设置为 `top`（页面的顶部框架)。
>
>2. 其他框架和扩展程序在其自身的环境中运行。要使用这些其他环境，您需要从下拉菜单中选中它们。 例如，如果您要查看 `<iframe>` 元素的日志输出，并修改该环境中存在的某个变量，您需要从 Execution Context Selector 下拉菜单中选中该元素。
>
>3. 当您在 `top` 以外的环境中操作时，DevTools 将 Execution Context Selector 突出显示为红色，如下面的屏幕截图中所示。 这是因为开发者很少需要在 `top` 以外的任意环境中操作。 输入一个变量，期待返回一个值，只是为了查看该变量是否为 `undefined`（因为该变量是在不同环境中定义的），这会非常令人困惑
>
>4. 示例图
>
>   ![image-20210609191945880](ChromeDevTools使用详解笔记中的图片/image-20210609191945880.png)

##### 	4) 眼睛标志:监听变量

>![image-20210609182327170](ChromeDevTools使用详解笔记中的图片/image-20210609182327170.png):**用于创建一个Live表达式，此表达式的值可实时更新。**
>
>![image-20210609193128590](ChromeDevTools使用详解笔记中的图片/image-20210609193128590.png)

##### 	5) **settings按钮具备显示信息的控制功能，其里面有八个选择项**

>内部挺多功能就稍微说常用的
>
>1. `Preserve log`:默认是不勾选的，所以当刷新页面时，Console 中的信息会被清空掉。如果勾选了的话，那么刷新页面之后，信息还会被保留。
>2. 其他的我不常用谢谢
>
>![image-20210609193539202](ChromeDevTools使用详解笔记中的图片/image-20210609193539202.png)

#### Ⅲ- Console 能干什么事

##### 	1) 执行表达式

>你可以输入任何表达式，按回车执行。在输入过程中，可能会出现智能提醒，你可以按 tab 或者 → 键来完成自动补全。另外，还可以按 ↑ 和 ↓ 键来翻阅历史表达式

##### 	2) Chrome DevTools 自带了哪些常用的表达式?

>下面描述的都是 Chrome DevTools 自带的方法或者变量，需要注意一下的是，当页面暴露相同的方法或变量的话，DevTools `自带的会被覆盖`，比如 jQuery 官网下的 Console 中的 $() 就是自己的方法。

###### 	① *选择元素*

>- $()：是 `document.querySelector()` 的缩写
>- $$()：是 `document.querySelectorAll()` 的缩写
>- $x()：通过 XPath 的方式查看元素，注意是 "XPath" 中的 "x"，而不是 `+-*/` 中的 `*`
>- 示例图![image-20210609194732798](ChromeDevTools使用详解笔记中的图片/image-20210609194732798.png)

###### ② *inspect*

>在 Console 中输入 `inspect()` 参数是 DOM 元素或者 JS 引用，可以跳转到 Elements 面板并且定位到你选择的那个 DOM 节点那。
>
>![image-20210609201540829](ChromeDevTools使用详解笔记中的图片/image-20210609201540829.png)

###### 	③ **$0-4*

>$0， $1...$4，代表 5 个最近访问过的 DOM 或者堆对象（Heap Object），$0 是最近访问的。那访问的意思是什么？就是在 Elements 面板被审查或者在 Memory 面板被选择的 DOM 元素或者堆对象
>
>![image-20210609201830754](ChromeDevTools使用详解笔记中的图片/image-20210609201830754.png)

###### 	④ *$_*

>`$_` 返回上一次表达式执行的结果。举个栗子：
>
>![image-20210609202055771](ChromeDevTools使用详解笔记中的图片/image-20210609202055771.png) 

###### 	⑤ *Event*

>在 Chrome DevTools 里你可以给 DOM 绑定事件、解绑事件，也能查看 DOM 注册了哪些事件
>
>- `monitorEvents(DOM_element, event)`，如果 event 为空的话，那会给选定的 DOM 元素加上所有事件；如果想监听多个事件的话，event 还可以是 Array 类型的变量
>
>- `unmonitorEvents(DOM_element)`，为某个 DOM 元素解绑事件
>
>- `getEventListeners(DOM_element)`，查看某个 DOM 元素绑定了哪些事件
>
>  ![image-20210609202813407](ChromeDevTools使用详解笔记中的图片/image-20210609202813407.png)
>
>  在上面例子中,我为`<p>本人是2021届毕业生</p>`注册了一个点击事件并解绑

###### 	⑥ *debug(function) 与 undebug(function)*

>在 Console 中调用 debug() 方法，当调用这个方法的时候，就会开启 debug 模式。用 `undebug` 方法来关闭。
>
>![image-20210609203225834](ChromeDevTools使用详解笔记中的图片/image-20210609203225834.png)

###### 	⑥ *monitor(function) 与 unmonitor(function)*

>当调用某个 function 时，Console 会输出这个 function 的名字和参数。

###### 	⑦ *dir(object) 与 dirxml(object)*

>dir() 与 console.dir() 一样，dirxml() 与 console.dirxml() 一样。
>
>dir() 将选中元素以对象的形式输出，而 dirxml() 将元素以 xml 的形式输出。

#### Ⅳ- Console drawer状态查看与修改你的值

>ps:[`Console drawer`](#Ⅰ- 打开 Console)其实就是在别的面板打开控制台
>
>如果你以为 Chrome DevTools 就简单看看这些值那就太小瞧她了，在中断状态下，还能动态修改变量的值。比如中断处有个变量叫 v，值是 1，如果我直接按 "Resume script execution" 的话，那么下一次的 v 也是 1，但如果我在按恢复执行按钮之前，我在 Console drawer 中输入 `v = 2` 回车，那么，下一处的 v 就是 2 了。
>
>还有更厉害的，你不仅可以修改变量的值，你还可以修改代码！当程序中断时，你可以在 [`Sources`](#Ⅰ- Sources 面板图解)(断点调试) 面板修改你的代码

### 3、Sources 面板

> 在 Chrome 中调试 JS 代码，那你不得不与 Chrome DevTools 的 Sources 面板打交道,使用谷歌控制台Sources面板可以:
>
> - 查看文件
> - 编辑 Css 和 JavaScript。
> - 创建和保存 JavaScript 的**代码段**，您可以在任何页面上运行此代码段。 **代码段**与小书签相似。
> - 调试 JavaScript。
> - 设置工作区，以将您在 DevTools 中作出的更改保存到文件系统的代码中。

#### Ⅰ- Sources 面板图解

>![image-20210610162606051](ChromeDevTools使用详解笔记中的图片/image-20210610162606051.png)

#### Ⅱ-左侧面板详解

##### 	1) `Page`:

> 已加载的全部资源，以域名划分文件夹。

##### 	2) `Content Scripts`:

>浏览器扩展工具的脚本，比如我安装了`Vue.js devtools`、`React Developer Tools`、[`PostWoman接口调试工具(挺好用的,点我传送)`](https://gitee.com/hongjilin/hongs-study-notes/blob/master/%E6%9D%82%E8%AE%B0_%E5%85%B6%E4%BB%96(%E5%A6%82%E7%A0%B4%E8%A7%A3%E4%B8%8E%E9%85%8D%E7%BD%AE)%E7%9A%84%E7%A2%8E%E7%89%87%E5%8C%96%E7%AC%94%E8%AE%B0/%E5%A5%BD%E7%94%A8%E7%9A%84%E5%B7%A5%E5%85%B7Mark.md/#6、Postwoman(ApiDebug)%20http接口测试工具)等插件都会显示出来
>
><img src="ChromeDevTools使用详解笔记中的图片/image-20210610165221422.png" alt="image-20210610165221422" style="zoom:80%;" /> 

##### 	3) `Snippets`

>代码片段，可以在这里添加一小段程序，这个一小段程序`可以访问这个页面中的变量和函数等`。不会因为刷新丢失，使用：添加=>保存(ctrl+s)=>运行(`Run`)=>不用则移除(`Remove`)
>
>![image-20210610170040085](ChromeDevTools使用详解笔记中的图片/image-20210610170040085.png)

##### 	4) `Filesystem&Overrides`

> 可以加载本地文件夹,就是可以将整个项目加载到此进行调试

#### Ⅲ-中间代码展示面板详解

##### 	1) `添加断点`

> 1. 断点:代码行号所在的位置叫做行号槽，点击行号槽，为相应的行添加断点，并在相应的行号上面加上一个类似肩章的五边形图标(蓝色的)。
>
>    ![image-20210610173049623](ChromeDevTools使用详解笔记中的图片/image-20210610173049623.png) 
>
> 2. 条件断点:右键一个没有添加断点的行号，选择 "Add conditional breakpoint"或者 右键行号选择`Edit已有断点`输入你的条件，当条件满足时，断点才会生效。回车后效果如下
>
>    ![image-20210610173249169](ChromeDevTools使用详解笔记中的图片/image-20210610173249169.png) 
>
> 3. 行内断点:当你将代码打在某些js语句上是,与上述例子不同的是同一行出现了 3 处标红的位置(也可能是2行,这得看你标注的代码具体情况)，表示 3 处断点。但第1个断点跟后2个不一样的是，第1个断点是默认处于激活状态，而后2个则不是，`只有点击激活后才能生效`
>
>    ![image-20210610174041549](ChromeDevTools使用详解笔记中的图片/image-20210610174041549.png)

##### 	2)` 右键行号` 及 `右键断点`

>1. 右键行号
>
>   - **Add breakpoint** 添加断点
>   - **Add conditional breakpoint** 添加条件断点
>   - **Never pause here** 永不停顿
>
>2. 右键断点
>
>   - **Remove breakpoint** 删除断点
>   - **Edit breakpoint** 修改断点
>   - **Disable breakpoint** 忽略断点
>   - Deactivate breakpoints：暂时忽略所有断点 (暗淡断点标志和断点列表，右键列表某个断点选择 Activate all breakpoints可恢复所有断点)
>   - Disable all breakpoints： 暂时忽略所有断点 (暗淡断点标志和断点列表，右键列表某个断点选择 Enable all breakpoints可恢复所有断点)
>   - Remove all breakpoints：删除所有断点
>     
>
>3. 比较奇怪的是我在网上看到的很多文章会写到右键有`Blackbox script (黑盒脚本)`,但本人无,所以推测可能是浏览器版本问题
>
>   > 这里另外指出并给出原文描述:我们写项目时，很多时候是要引用第三方库或框架的，当我们调试时，调试的对象应该是我们自己写的代码，但很多时候，我们经常在焦灼地进行下一步下一步时，突然代码跳到了第三方库或框架的源码上去，这让我们焦灼的内心更添了一把柴火。黑盒脚本就是用来解决这个问题的。它能够将一个脚本文件标记为 "Blackbox Script"，那么我们就永远不可能进入这个文件内部，这个文件对我们来讲就是一个黑盒子。为什么要强调“永远”呢？因为不仅普通的断点不能访问这个被标记了的脚本，其他的，比如说 DOM 断点、事件断点等等都无法访问那个脚本文件内部。

#### Ⅳ-右侧断点调试按钮组详解

> 首先我们先介绍右侧功能按钮组的各个作用
> ![image-20210610175433702](ChromeDevTools使用详解笔记中的图片/image-20210610175433702.png)
>
> - ![sources-debug-btn-1.png](ChromeDevTools使用详解笔记中的图片/sources-debug-btn-1.png)：当程序中断在断点处时，点击去往下一个断点
> - ![sources-debug-btn-2.png](ChromeDevTools使用详解笔记中的图片/sources-debug-btn-2.png)：当程序中断在断点处时，`长按上面的按钮出现此标志(还有一个方形按钮为中断)`，点击这个按钮可以在 0.5s 内忽略任何中断，当中断出现在循环内部时一般比较有用
> - ![sources-debug-btn-3.png](ChromeDevTools使用详解笔记中的图片/sources-debug-btn-3.png)：执行下一条语句.按正常步骤，应该会一行一行的执行相关代码，以便深入探索哪些代码影响着正在更新的变量。如果你的代码中调用了另一个函数，点击此按钮将不会进入该函数，而是直接略过，将焦点留在当前函数上
> - ![sources-debug-btn-4.png](ChromeDevTools使用详解笔记中的图片/sources-debug-btn-4.png)：当中断停留在一个函数调用处时，点击这个按钮会进入函数内部，而上面的按钮则会执行函数调用的下一句，不会进入函数内部
> - ![sources-debug-btn-5.png](ChromeDevTools使用详解笔记中的图片/sources-debug-btn-5.png)：当中断停留在函数内部时，点击这个按钮则会跳出函数内部，停留在函数调用的下一个语句
> - ![img](ChromeDevTools使用详解笔记中的图片/sources-debug-btn-6.png)：在不取消断点标记的情况下，使得所有断点失效

#### Ⅴ- 右侧面板详解

> 此处用到上面[`左侧面板的Snippets相关知识`](#Ⅱ-左侧面板详解)插入了一个`代码块`模拟断点调试,方便展示

##### 	1) `Watch` (变量监听):

>正如名字所表示的，观察，观察什么呢？`主要观察变量`。
>
>示例图如下
>
>![image-20210610182432191](ChromeDevTools使用详解笔记中的图片/image-20210610182432191.png)

##### 	2) `BreakPoints `(断点列表)：

>展示断点列表，将每个断点所在文件/行数/该行简略内容展示
>
>![image-20210610182855822](ChromeDevTools使用详解笔记中的图片/image-20210610182855822.png)

##### 	3) `Scope` (作用域):

>Scope 面板显示了你当前断点所在函数所有属性的值。Scope 会显示2种类型的值： Script和 Global。如下图，当前作用域里的对象是本地参数Script
>
>![image-20210610185055065](ChromeDevTools使用详解笔记中的图片/image-20210610185055065.png)
>
>注:在网上查阅资料时很多都说`Scope 会显示三种类型的值： Local、Closure 和 Global`。但是本人没有,仍是推测版本问题,所以我仍是以本人所见为主,备注出此资料

##### 	4) `Call Stack `(函数调用堆栈):

>Call Stack 面板会显示代码的执行路径

##### 	5) `XHR Breakpoints` (请求断点列表)

>对达到满足过滤条件的请求进行断点拦截，点击该面板右侧加号按钮，会跳出"Break when URL contains"以填写过滤条件。如下图，我们对请求URL包含字母`/console/querycentre....`的内容进行断点
>
>下方示例图为了不影响观看体验打码无用部分
>
>![image-20210610191827642](ChromeDevTools使用详解笔记中的图片/image-20210610191827642.png)

##### 	6) `DOM Breakpoints `(DOM断点列表)

>给DOM加断点，在达到规定条件时触发断点，截断javascript的执行并且定位到断点处。例如：在[Elements](#Ⅱ- elements的内置面板)面板，右键 body 元素→Break on→ modifications，在DOM Breakpoints面板中会显示DOM元素名

##### 	7) `Event Listener Breakpoints` (可断点的事件监听列表)

>打开这个列表，可以在监听事件并且在触发该事件时进入断点，调试器会停留在触发事件代码行。只需要展开事件列表，选择要监听的事件打上勾即可
>
>举个栗子,勾选键盘按下事件:![image-20210610192527599](ChromeDevTools使用详解笔记中的图片/image-20210610192527599.png)

#### Ⅵ- 源码调试小贴士

>现在的项目几乎都是经过编译过的，所以当我们调试时会与编译后的代码打交道，但那并不是我们想要的。不要急，Chrome DevTools 提供了预处理过的代码与源码的映射，主要表现在两点：
>
>- 在 console 上，源链接指向的是源码，而不是编译后的文件
>- 在 debug 时，在 Call Stack 面板上的源链接指向的也是源码，不是编译后的文件
>
>不过需要注意的是，上面所讲的能查看源码的前提是 Chrome DevTools 在设置中提供了相应权限，具体是：Settings - Sources - Enable Javascript source maps / Enable CSS source maps，勾选这两项即可。不过，默认情况下就是勾选。



### 4、Network 面板

>Chrome DevTools 的 Network 面板主要用于度量当前网页的网络性能状况，其记录了当前网页每个网络操作的信息，包括时间数据、HTTP 请求、返回数据等等。
>
>国际惯例,先看完整截图概览
>
>![image-20210611163234495](ChromeDevTools使用详解笔记中的图片/image-20210611163234495.png)

#### Ⅰ- Control 面板

>![image-20210611163316092](ChromeDevTools使用详解笔记中的图片/image-20210611163316092.png)
>
>> 

##### 	1)  `开始/停止记录`

>**![network-3.png](ChromeDevTools使用详解笔记中的图片/network-3.png)** 表示正常记录网络的请求状况，点击，当图标变成 ![img](ChromeDevTools使用详解笔记中的图片/network-4.png) 时，代表停止记录请求状况,此时页面上不会对后续请求进行记录(保留点击前的记录)。

##### 	2) `清除记录`

> 点击 ![img](ChromeDevTools使用详解笔记中的图片/network-5.png) 可以清除请求表格内的内容。

##### 	3)  `截取加载的瞬间`

>本人`Control 面板`中没有录制图标,但其实是收置在了设置面板中,详见下方 `9)右侧设置图标`部分
>
>1. 仍是推测为版本区别,此处给出网上对于其功能描述:
>
>> 点击 ![img](ChromeDevTools使用详解笔记中的图片/network-6.png)，当图标变成 ![img](ChromeDevTools使用详解笔记中的图片/network-7.png) 时，代表开启截屏模式，即截取网页在加载过程中的瞬间，这些瞬间显示了网页在什么时间加载出了哪些部分。
>
>2. 本人操作
>
>   >出现下面的结果(`放出本人示例图`)：
>   >
>   >![image-20210611172334006](ChromeDevTools使用详解笔记中的图片/image-20210611172334006.png)

##### 	4) `过滤`

>点击 ![img](ChromeDevTools使用详解笔记中的图片/network-10.png) 可以显示/隐藏过滤面板，如下：
>
>![image-20210611163316092](ChromeDevTools使用详解笔记中的图片/image-20210611163316092.png)
>
>1. 可以把过滤面板看成由三个部分组成的面板，从左到右分别是：过滤文本域、隐藏 Data URLs 和请求资源类型选择。
>
>2. 对 Data URLs 不理解的可以看：[Data URLs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/Data_URIs)。在这里主要就是为了隐藏这些用 Data URLs 来展示的资源,此处不赘述
>3. 在 "Hide data URLs" 后面有一组文件类型，选择一个可以在下面的请求表格中只显示相应类型的文件请求，当然你还可以在选择的同时按着 `ctrl / cmd`，那么就可以多选

###### 	① *请求资源类型选择*

>在 "Hide data URLs" 后面有一组文件类型，选择一个可以在下面的请求表格中只显示相应类型的文件请求，当然你还可以在选择的同时按着 `ctrl / cmd`，那么就可以多选

###### 	②  *过滤文本域*

>下面来说过滤文本域，就是过滤面板最左边的输入框
>
>1. 首先，最简单的用法就是我们输入一个字符串，然后可以过滤出那些资源名称中包含相应字符串的资源。这是我们一般使用的，除此以外，文本域还支持一些关键词，举个栗子：
>
>   ![image-20210611165236991](ChromeDevTools使用详解笔记中的图片/image-20210611165236991.png)
>
>   上面的例子就用到了 `status-code` 关键词，后面跟的参数是状态码，可以刷选出 `状态码为304` 的请求
>
>2. 常用关键词有哪些
>
>   - domain：刷选来自特定域的请求
>   - has-response-header：刷选 HTTP 返回值包含特定头部信息的请求
>   - is：可以用 `is:running` 查看 WebSocket 资源
>   - larger-than：筛选文件大小超过特定数字的请求，默认单位是 byte
>   - method：刷选特定 HTTP 请求方法的请求
>   - mime-type：刷选特定 MIME 类型的请求
>   - mixed-content：有 `mixed-content:all` 和 `mixed-content:displayed` 两种
>   - scheme：刷选特定 scheme 的请求
>   - set-cookie-domain：刷选特定的 HTTP 返回头部的 set-cookie 属性的请求
>   - set-cookie-name：也是对返回的 HTTP 头部中某个属性进行刷选的关键词
>   - set-cookie-value：同上
>   - status-code：对请求的状态值进行刷选
>
>3. 注意点
>
>   >1) 冒号后面不能有空格；2) 大小写敏感。

##### 	5) `搜索`

>第4个搜索图标，可以打开search面板。search与filter的区别在于，filter只能按照请求URL来筛选请求，但search可以搜索到请求和响应中的内容。“Aa”表示是否匹配大小写，“.*”表示根据某种格式匹配。
>
>![image-20210611170207544](ChromeDevTools使用详解笔记中的图片/image-20210611170207544.png)

##### 	6)  `preserve log`

>preserve log表示保留log。如果不勾选，当切换页面时，上个页面的log将被清除掉；勾选后，切换页面时，上个页面的log依然存在。

##### 	7) ` Disable cache`

> Disable cache表示禁止缓存，勾选后，页面将不再从缓存中获取文件。

##### 	8) `模拟网络状况`

> 点击online，打开模拟网络选项，可以调试网页在不同网络状况下的表现情况。这对移动端的调试非常有用
>
> 1. 具体操作见下方常用操作:[切换网络模式及限制网速方式](#13、切换网络模式及限制网速)
>
> 2. 除了在 Network 面板可以设置网络状况，还可以在 Drawer 中看见。具体有两种方法：
>
>    1) [![img](https://github.com/CompileYouth/front-end-study/raw/master/tool/devtools/res/toolbar-3.png)]-> More tools -> Network conditions
>
>    2) 按 esc 键调出 Console Drawer，在 Console Tab 旁边也有 [![img](https://github.com/CompileYouth/front-end-study/raw/master/tool/devtools/res/toolbar-3.png)]，点击，选择 Network conditions

##### 	9) `右侧设置图标`

> 点击右侧设置图标后会出现几个选项
>
> ![image-20210611171729978](ChromeDevTools使用详解笔记中的图片/image-20210611171729978.png)



#### Ⅱ- 时间刻度表

>我一开始跟很多人一样，看到这个图时觉得头晕，感觉上是显示加载情况的，但又说不出具体什么意思，下面就跟大家一起了解一下这张图的含义。
>
>![image-20210611172936963](ChromeDevTools使用详解笔记中的图片/image-20210611172936963.png)
>
>首先从水平方向上从左看到右，你会看见：
>
>- 刻度：代表时间
>
>- 一条条水平线：一条水平线代表一项资源，这条水平线上的不同的颜色段代表这项资源在加载过程中处于什么阶段
>
>- 有两条竖线：前面一条是蓝色，代表 DOMContentLoaded 事件被触发；后面一条是红色，代表 load 事件被触发。`从概览面板也能看到`这两个信息：
>
>  ![image-20210611173031807](ChromeDevTools使用详解笔记中的图片/image-20210611173031807.png)
>
>然后从垂直方向看，这些五彩斑斓的水平线有的有重叠有的没有重叠，具有重叠部分说明这些资源是在同一时间被加载的。
>
>`ps`:筛选不同时间的请求
>
>![image-20210611173524970](ChromeDevTools使用详解笔记中的图片/image-20210611173524970.png)



#### Ⅲ- 概况面板

>![image-20210611174207620](ChromeDevTools使用详解笔记中的图片/image-20210611174207620.png)
>
>网络面板的最下方，展示了整个页面的请求概况，下图可以看出，本人[`gitee`](https://gitee.com/hongjilin)首页共发起了57个请求，网络传输38.9KB，一共加载资源5.2MB，所有请求完成的时间是2.0min，DOM构建完成的时间是1.61s，所有外部资源加载完成的时间是2.00s。
>
>ps:`红蓝字部分的时间差大致是外部资源的加载时间`



#### Ⅳ- 请求列表操作面板

>  使用Network面板最多的地方莫过于调试aJax请求了。点开一个请求，可以看到几个标签。
>
>![image-20210611180024944](ChromeDevTools使用详解笔记中的图片/image-20210611180024944.png)
>
>

##### 	1) `Headers`

>Headers里面展示了一些请求的基本信息，包括请求头、响应头等。里面展示了一些请求的基本信息，包括请求头、响应头、`请求参数(常用)`等。

##### 	2) `Preview`和`Response`

> Preview和Response都是对返回信息的展示。区别是Response展示的是请求返回的原始内容；Preview是根据原始内容的不同类型进行的直观展示。
>
> 可以看到其实数据是一样的,但是格式不同
>
> ![image-20210611180602561](ChromeDevTools使用详解笔记中的图片/image-20210611180602561.png) 

##### 	3)  `Timing`查看请求参数

> Timing里面列举了一些请求的参数,也可以在请求列表的Waterfall中看到请求的参数。
>
>![image-20210611180940478](ChromeDevTools使用详解笔记中的图片/image-20210611180940478.png)
>
>应用场景: Queued表示队列时间，由于单个域名最多只能并发6个请求，所以不是所有的请求都是在页面初始就开始加载的。Started表示开始请求的时间。可以根据每个请求各阶段花费的时间来制定优化方案

##### 	4)  修改想展示的请求列表参数

> ![image-20210611181859716](ChromeDevTools使用详解笔记中的图片/image-20210611181859716.png)



### 5、Performance

> Performance 一个在前端开发领域中，无法被忽视的存在。使用Chrome DevTools的performance面板可以记录和分析页面在运行时的所有活动。本文将详细介绍如何使用performance面板解决性能瓶颈
>
>![image-20210611184508312](ChromeDevTools使用详解笔记中的图片/image-20210611184508312.png)

##### 	1)  工具栏功能

>- 录制: 点击 Record （按Ctrl+E），这时候Devtools就开始录制各种性能指标。记录时，Record 按钮会变成红色。然后按 Record 按钮或再次键入键盘快捷键停止记录；
>- 刷新: 刷新页面分析；
>- 清除: 清除页面分析结果；
>- 上下箭头: 用来上传和下载每一次性能检测报告；
>- Screendshots:  显示屏幕快照，是用来查看在每个时间段界面的变化；
>- Memory: 存储调用栈的大小，在不同时间段的不同大小；
>- Disable Javascript samples:  禁用 JavaScript 调用栈；
>- Enable advanced paint instrumentation(slow):  记录渲染事件的细节；
>- Network: 模拟不同的网络环境；
>- CPU: 模拟不同的CPU运行速度

​	2) 





------



## 二、常用操作及快捷键

### 1、打开 Chrome DevTools

>1. 鼠标点击
>
>- 选择右上角Chome 菜单，然后选择更多工具 -> 开发者工具
>- 右键，选择检查/审查元素
>
>2. 当然，比较推荐利用快捷键来打开：
>
>- `Ctrl + Shift + I, F12 / Cmd + Opt + I`，打开 DevTools
>- `Ctrl + Shift + J / Cmd + Opt + J`，打开 DevTools，并且定位到控制台面板
>
>3. 上面两种方式不仅可以打开 DevTools，还可以关闭 DevTools。当然，还有一种方式可以打开 DevTools。
>
>- `Ctrl + Shift + C / Cmd + Opt + C`，打开 DevTools，并且开启审查元素模式（相当于点击了 DevTools 左上角的图标： ![img](ChromeDevTools使用详解笔记中的图片/20180319215106122))

### 2、刷新页面与强制刷新

>- `F5, Ctrl + R / Cmd + R`，刷新页面
>- `Ctrl + F5, Ctrl + Shift + R / Cmd + Shift + R`，刷新页面并忽略缓存

### 3、缩放DevTools

>- `Ctrl + '+' / Cmd + Shift + '+'`，放大 DevTools
>- `Ctrl + '-' / Cmd + Shift + '-'`，缩小 DevTools
>- `Ctrl + 0 / Cmd + 0`，DevTools 恢复大小

### 4、切换设备

>`Ctrl+Shift+M`切换设备 或者直接点击机身图标
>
>具体操作如下:
><img src="ChromeDevTools使用详解笔记中的图片/image-20210608153745991.png" alt="image-20210608153745991" style="zoom: 80%;" />

### 5、禁用缓存

>1. 应用场景:如有时要多次查看第一次进入该网页时加载的资源时会用到,防止有的数据走缓存导致下次刷新查看不到
>2. 操作:切换到“Network”网络面板,勾选“Disable cache”项
>
><img src="ChromeDevTools使用详解笔记中的图片/image-20210608154516531.png" alt="image-20210608154516531" style="zoom:80%;" />

### 6、手动清理网站缓存

>1. 应用场景:此操作能清空Cookies、WebSQL、Service Workers、Cache Storage、IndexedDB、Local Storage、Application Cache
>
>2. 操作:
>
>   1) 按 command + shift + p （windows 按 Ctrl + shift + p），弹出命令输入框
>
>   2) 输入 “clear site data” 敲回车
>
>3. 效果图
>
>   <img src="ChromeDevTools使用详解笔记中的图片/image-20210608155141634.png" alt="image-20210608155141634" style="zoom:80%;" />

### 7、强制设置元素的状态

>1. 应用场景:当我要看如点击状态下的某个元素的样式,可以勾选点击状态,那么页面上该元素就会呈现此状态下的样式
>
>2. 操作:
>
>   1) 选中元素
>
>   2) 点击Style面板下的`:hov`按钮
>
>   3) 勾选要设置的状态,那么页面该元素就会呈现该选中状态下的样式
>
><img src="ChromeDevTools使用详解笔记中的图片/image-20210608161110741.png" alt="image-20210608161110741" style="zoom:80%;" />

### 8、查找某元素绑定的事件

>1. 应用场景举例:当你想要查找某个元素绑定的点击事件,就可以通过该方法直接定位到代码中
>
>2. 操作:
>
>   1) 切换 “Elements" 元素面板,点击文档节点
>
>   2) 选择 “Event Listeners” 页签
>
>   3) 展开相应的事件名,如“click”
>
>   4) 对 “handler” 点击右键,选择 “Show funciton definition”
>
>   5) 点击后就会自动定位
>
>3. 示例图
>
>   <img src="ChromeDevTools使用详解笔记中的图片/image-20210608162406603.png" alt="image-20210608162406603" style="zoom: 67%;" />

### 9、打开某个资源文件及定位源代码行数

>1. 打开某个资源文件
>
>   1) 按 command p (windows 按 Ctrl p),弹出文件搜索框,输入文件名回车即可定位
>
>   2) 效果图<img src="ChromeDevTools使用详解笔记中的图片/image-20210608163035973.png" alt="image-20210608163035973" style="zoom:80%;" />
>
>2. 快速定位源代码行数
>
>   1) 按 command p (windows 按 Ctrl p),弹出文件搜索框
>
>   2) 输入 :行数,如 “:480”,回车即可
>
>   3) 效果图:![image-20210608163332015](ChromeDevTools使用详解笔记中的图片/image-20210608163332015.png)

### 10、格式化代码

>1. 应用场景:当你打开的源码是压缩过或者格式很乱的,影响阅读时可以使用
>2. 操作:点击已打开文件的`左下角花括号`
>3. 效果图:![image-20210608164044091](ChromeDevTools使用详解笔记中的图片/image-20210608164044091.png)

### 11、查找加载图片的代码-(其他资源同理)

>1. 应用场景:当你要查找加载图片(其他资源)的代码时
>
>2. 操作
>
>   1) 切换 “`Network`” 网络面板,选中`Img`
>
>   2) 点击 “Initiator” 列下的文件名即会跳转至代码处
>
>3. 效果图![image-20210608165025868](ChromeDevTools使用详解笔记中的图片/image-20210608165025868.png)

### 12、全局查询请求头和响应体

>1. 应用场景:
>
>2. 操作:
>
>   1) 切换 “Network” 页签
>
>   2) 点击左上角的“放大镜”按钮
>
>   3) 在弹出的搜索框中输入要查询的内容,敲回车键
>
>   4) 选择想要查看的请求点击,就能查阅其请求头与响应体
>
>3. 效果图
>
>   ![image-20210608165747119](ChromeDevTools使用详解笔记中的图片/image-20210608165747119.png)
>
>

### 13、切换网络模式及限制网速

>1. 应用场景:当你想要测试`无网络`、`快速的3G`、`卡顿的3G`、`限速的网络`环境时自己软件的表现时
>
>2. 切换网络模式操作:
>
>   1) 切换 Network 网络面板,点击 “ online ” 下拉面板,选择想要的模式
>
>   2) 效果图
>
>   <img src="ChromeDevTools使用详解笔记中的图片/image-20210608171012060.png" alt="image-20210608171012060" style="zoom: 67%;" />
>
>3. 限制网速操作:
>
>   1) 切换 Network 网络面板 点击 “ online ” 下拉面板 选择 “ add.. ” 选项
>
>   2) 点击 “ Add custom profile… ” 按钮 依次输入“Profile Name”、“Download”、“Upload”等输入项设置网速,再点击 “Add” 按钮
>
>   3) 回到 Network 网络面板切换所新增的网络模式
>
>   4) 效果图:第一步操作同上切换网络操作
>
>   ![image-20210608184929873](ChromeDevTools使用详解笔记中的图片/image-20210608184929873.png)

### 14、在Console控制台查找DOM及多行输入

> 1. 在Console控制台查找DOM:
>
>    切换到Console控制台面板 输入:`document.querySelector("#id")`或`documen.querySelector("className")`敲回车键,很简单就不演示了
>
> 2. 在控制台中输入多行代码
>
>    输入时,按住Shift键敲回车即可换行

### 15、将DOM、打印结果、处理函数等存成全局变量在 console 面板使用

> 很多地方的右键上下文菜单上有这个`Store as global variable`这个选项--作用是`在 console 面板存成全局变量`,因为对象的引用类型,修改这个全局变量,`其实就是改变原对象的值`,很强大。
>
> 注:刷新后保存的变量会重置

#### Ⅰ-将DOM变成全局变量

>1. 应用场景:当你想从控制台进行对DOM节点的操作时,也可以变相等同于进行了一步`let temp2=document.querySelector("#id")`操作
>
>2. 操作:
>
>   1) devtools的Elements面板中选中要操作的DOM节点
>
>   2) 右键选择`Store object as global variable`,就会自动保存成全局变量
>
>   3) 可以如同js般对其进行操作
>
>3. 示例图:
>
>   <img src="ChromeDevTools使用详解笔记中的图片/image-20210609114057156.png" alt="image-20210609114057156" style="zoom:67%;" />

#### Ⅱ-打断点时候的任意一个局部变量

>1. 应用场景:当你需要保留观察或者进行操作调试过程中某个时期的变量时
>
>2. 操作:
>
>  1) 在代码中写`debugger`或者在控制台代码出打上断点,运行
>
>  2) 选中任意想要保存的局部变量,右键存储即可
>
>3. 示例图
>
>  ![image-20210609120022864](ChromeDevTools使用详解笔记中的图片/image-20210609120022864.png)

#### Ⅲ-消息的响应体预览界面

>1. 应用场景:通常就是保留下某些请求变量用作对比罢了,方便开发
>
><img src="ChromeDevTools使用详解笔记中的图片/image-20210609140306767.png" alt="image-20210609140306767" style="zoom: 67%;" />

#### Ⅳ-保存控制台输出内容

>1. 应用场景:当你不用`debugger`而只是使用`console.log`简单打印出变量时,可以将控制台打印出来的变量保存下来使用
>
>2. 操作:
>
>   1) 代码中进行打印或者控制台输入代码`console`打印出需要的变量
>
>   2) 右键选择`Store object as global variable`,就会自动保存成全局变量
>
>3. 示例图:
>
>   ![image-20210609141027576](ChromeDevTools使用详解笔记中的图片/image-20210609141027576.png)

### 16、截图操作

>首先你需要`F12`打开devtools,下面操作才会生效
>
>1. 按 command + shift + p （windows 按 Ctrl + shift + p），弹出命令输入框
>2. 输入：screenshot
>3. 如下图选择相应的截图方式：
>
>- Capture area screenshot：截取某个区域（需要选择某个标签）
>- Capture full size screenshot：截取整个网页
>- Capture node screenshot：截取某个标签节点
>- Capture screenshot：截取当前可视区域
>
>![image-20210609141545657](ChromeDevTools使用详解笔记中的图片/image-20210609141545657.png)

### 17、打开控制台抽屉

>1. 应用场景:当你在如Network、elements界面要用要console控制台时,就如我上面的例子截图,
>2. 下面举例在`Elements`面板打开抽屉
>
><img src="ChromeDevTools使用详解笔记中的图片/image-20210609143711131.png" alt="image-20210609143711131" style="zoom:67%;" />
>
>3. 更简单的:直接点击`esc`就可以在别的地方打开
>
>关掉的方法同理

### 18、重新发起某请求

>在与后端联调过程中，若需要重新发起请求，除了刷新页面或重新触发请求事件外，还可以使用更简单的方式。右击需要重新发起的请求，选择Replay XHR，就可以重新发起请求了
>
>![image-20210611181403919](ChromeDevTools使用详解笔记中的图片/image-20210611181403919.png)



