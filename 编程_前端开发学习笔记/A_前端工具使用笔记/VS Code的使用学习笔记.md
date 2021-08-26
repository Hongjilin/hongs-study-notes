# #说明

> 原本我用的是 WebStrom(写前端代码时) ,但作为前端转投 VSCode 是再正常不过了,即使当初 WebStrom 用的再久在接触 VSCode 后也不得不说一句真香,而当初我进入编程,只能靠自己摸索以及百度上零零散散地拼凑,回想起来真是非常吃力,所以此处我将梳理整合网上资料再结合自己理解形成笔记,分享给大家,也希望大家能少走弯路
>
> 俗话说,`工欲善其事,必先利其器`,当你刚入门编程时第一件要做的就是去了解并学习编辑器的使用
>
> 查阅借鉴的资料: 知乎的 [King的VSCode新手入门教程](https://zhuanlan.zhihu.com/p/73577624)  、[韩骏的如何学习 Visual Studio Code？](https://zhuanlan.zhihu.com/p/162544477)、[千古壹号的第一次使用VS Code时你应该知道的一切配置](https://zhuanlan.zhihu.com/p/62913725);CSDN的 [猫科龙的「VS Code」Visual Studio Code 菜鸟教程：从入门到精通](https://blog.csdn.net/maokelong95/article/details/88805589);极客教程的 [VSCode 是什么](https://geek-docs.com/vscode/vscode-tutorials/what-is-vscode.html) ;思否的 [hyangteng的宇宙最强vscode教程（基础篇）](https://segmentfault.com/a/1190000017949680); [思考问题的熊的VScode入门学习路径](https://kaopubear.top/blog/2019-09-11-howtolearnvscode/); 简书的 [破晓霜林的VsCode使用教程](https://www.jianshu.com/p/11554732b323);还有一部分因为VSCode在很早之前就已在使用,当时有做部分笔记但是未注明其中引用出处(小部分),现在也无法查找,但本人笔记主要还是为了方便大家学习,所以仍会把当初笔记并入,发现出处的小伙伴可以私聊我
>
> 除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、 **[JavaScript笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记)**、**[ES6及后续版本学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记)** 、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、 **[ReactHooks笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ReactHooks笔记)** 、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了

# 绪论

>有一点你可能会感到惊讶：VS Code 这款软件本身，是用 JavaScript 语言编写的（具体请自行查阅基于 JS 的 PC 客户端开发框架 `Electron`）。Jeff Atwood ( Stack Overflow 网站的联合创始人 ) 在 2007 年提出了著名的 Atwood 定律：
>
>> **任何能够用 JavaScript 实现的应用系统，最终都必将用 JavaScript 实现**。
>
>引用网上看到的一段话: "** `前端目前是处在春秋战国时代，各路英雄豪杰成为后浪，各种框架工具层出不穷，VS Code 软件无疑是大前端时代最骄傲的工具` **"
>
>- 如果你是做前端开发（JavaScript 编程语言为主），则完全可以将 VS Code 作为「**主力开发工具**」。这款软件是为前端同学量身定制的。
>
>- 如果你是做其他语言方向的开发，并且不需要太复杂的集成开发环境，那么，你可以把 VS Code 作为「**代码编辑器**」来使用，纵享丝滑。
>
>- 甚至是一些写文档、写作的同学，也经常把 VS Code 作为 markdown **写作工具**，毫无违和感。
>
>- 退而求其次，即便你不属于以上任何范畴，你还可以把 VS Code 当作最简单的**文本编辑器**来使用，完胜 Windows 系统自带的记事本。

# 一、VSCode的使用学习

## Ⅰ- VSCode的介绍

>VS Code 的全称是 Visual Studio Code，是一款开源的、免费的、跨平台的、高性能的、轻量级的代码编辑器。它在性能、语言支持、开源社区方面，都做得很不错。
>

### 1、 IDE与编辑器的区别

>IDE 和编辑器是有区别的：
>
>- **IDE**（Integrated Development Environment，集成开发环境）：对代码有较好的智能提示和相互跳转，同时侧重于工程项目，对项目的开发、调试工作有较好的图像化界面的支持，简单来说,IDE中除了编辑器,还把你可能用到的大多数东西都塞进去了,因此比较笨重。比如 Eclipse、`WebStrom` 的定位就是 IDE。
>
>- **编辑器**：要相对轻量许多，侧重于文本的编辑。比如 Sublime Text 的定位就是编辑器。再比如 Windows 系统自带的「记事本」就是最简单的编辑器。
>
>需要注意的是，VS Code 的定位是**编辑器**，而非 IDE ，但 VS Code 又比一般的编辑器的功能要丰富许多。可以这样理解：VS Code 的体量是介于编辑器和 IDE 之间。

### 2、VS Code 的特点

>- VS Code 的使命，是让开发者在编辑器里拥有 IDE 那样的开发体验，比如代码的智能提示、语法检查、图形化的调试工具、插件扩展、版本管理等。
>
>- 跨平台支持 MacOS、Windows 和 Linux 等多个平台。
>
>- VS Code 的源代码以 MIT 协议开源。
>
>- 支持第三方插件，功能强大，生态系统完善。VSCode相较于WebStrom更轻就是因为它自带的东西少,而我们有时候需要用到其没有自带的东西就可以用第三方插件进行下载补充
>
>- VS Code 自带了 JavaScript、TypeScript 和 Node.js 的支持。也就是说，你在书写 JS 和 TS 时，是自带智能提示的。当然，其他的语言，你可以安装相应的**扩展包**插件，也会有智能提示。

### 3、前端利器之争： VS Code 与 WebStorm

#### a) 哪个编辑器/IDE 好用？

>前端小白最喜欢问的一个问题是：哪个编辑器/IDE 好用？是 VS Code 还是 WebStorm(WebStorm 其实是 IntelliJ IDEA 的定制版)?
>
>> 在我刚踏入前端时,我选择了WebStrom :
>>
>> 因为当时听老师说 WebStrom 装好了你就不用再装东西,啥都有!!!  VsCode 比如你的HTML、CSS提示都要自己装第三方插件.当时我身为一个萌新小白啥都不懂,肯定选择了WebStrom了,当时写的也都是小demo,除了初次启动速度慢其他的感觉用的很舒服
>> 后来出来工作,实在坚持不住用了VSCode :
>>
>> 并不是说 WebStrom 不适用于工作,在开发中除了稍微笨重点其他的都是用的很顺畅的,但是耐不住身边同事前辈都用VSCode啊!他们过来调试就各种不适,我身为萌新不得 '迁就' 他们? 其次,用了一段时间后,确实发现 [ 顺畅 ] 与 [ 丝滑 ] 差距还是有的,就像是你打游戏帧率 80 跟 120 肯定是感受的出来的(也许是我电脑卡,就显得明显),而且VSCode明显更酷

#### b) 对比

>- **哪个更酷**：显然 VS Code 更酷! WebStrom虽然考虑很周全什么都给你了,但是就像是照顾小孩子一样,填鸭式地给你.VSCode也是给你更多地信任
>
>- **内存占用情况**：根据我的观察，VS Code 是很占内存的（尤其是当你打开多个窗口的时候），但如果你的内存条够用，使用起来是不会有任何卡顿的感觉的。相比之下，SwbStrom 不仅非常占内存，而且还非常卡顿。如果你想换个既轻量级、又不占内存的编辑器，最好还是使用「Sublime Text」编辑器。
>
>- **使用比例**：这个就不用说了吧,我就是因为别人都使用VSCode才被同化的
