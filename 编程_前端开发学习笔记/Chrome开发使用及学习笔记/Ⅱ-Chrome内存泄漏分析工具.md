

## #说明

>此笔记为截取上方`ChromeDevTools使用详解笔记`的 [ Chrome内存泄漏分析工具 ] 部分笔记的部分知识点至此,方便阅读
>
>> ###### 更多笔记看上方 ChromeDevTools 使用详解笔记
>
>除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[数据结构与算法](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_算法及课程基础学习笔记/数据结构与算法)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[编程_后台服务端学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记)** 、**[Java](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Java)** 、**[Nodejs](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Nodejs)** 、**[JavaScript笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记)**、**[编程工具使用笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端工具使用笔记)** 、**[ES6及后续版本学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记)** 、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了
>
>更多Chrome开发笔记: **[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 

## 二、Chrome内存泄漏分析工具

>内存分析使用的工具包括chrome任务管理器、chrome时间轴（低版本是Timeline，高版本对应performance）、chrome memory（低版本是chrome profiles，主要用JS堆快照、JS堆动态分配时间轴）。
>
>1. 使用Chrome任务管理器，了解网页使用的内存量。
>2. 使用时间轴(`Performance面板`)记录可视化内存使用。 -->[`点我跳转`](#5、Performance(Timeline) 面板)
>3. 使用堆快照(`Memory面板`)标识分离的DOM树（内存泄漏的常见原因）。 -->[`点我跳转`](#6、Memory(Profiles) 面板)
>4. 通过堆动态分配时间轴(`Memory面板`)记录了解在JS堆中分配及回收情况。  -->[`点我跳转`](#6、Memory(Profiles) 面板)

### 1、**chrome任务管理器**

>1. 按Shift + Esc打开任务管理器。或点击右上角菜单--更多工具---任务管理器。
>
>2. 主要关注`内存占用空间`、`Javascript使用的内存`。Javascript使用的内存默认不显示，可以点击右键添加![image-20210615175926101](../Chrome开发使用及学习笔记/Chrome_DevTools调试工具使用详解笔记/ChromeDevTools使用详解笔记中的图片/image-20210615175926101.png)
>
>3. 这两列是在用不同角度来告诉你，网页的内存使用情况︰
>
>  - 内存占用空间表示本机内存。DOM节点存储在本机内存中。如果这个值在增加，则说明正在创建DOM节点。
>  - JavaScript 使用的内存列 表示JS堆。这一列包含两个值。关注实际使用大小即可（括号中的数字）。跳动的数字表示您网页上的可获得的对象正在使用多少内存。如果这个数字在增加，那说明正在创建新对象，或现有对象正在增长。
>
>  ![image-20210615180249274](../Chrome开发使用及学习笔记/Chrome_DevTools调试工具使用详解笔记/ChromeDevTools使用详解笔记中的图片/image-20210615180249274.png) 
>
>4. 如何判断?
>
>  - 如果内存占用空间一直在增长但JS内存不增长
>
>    > 可能是浏览器还没有回收，不操作闲置一段时间看下是否会下降。遇到几种情况内存一直不释放（控制台关闭状态下放置三个小时左右），不确定是回收慢，还是浏览器本身存在内存泄露（测试了45、68、69版本）--([测试结果来自杭电茶娃的chrome内存泄露相关博客](https://blog.csdn.net/c11073138))：
>    >
>    > 含密码框（三个版本都有问题）
>    > 含输入框，且用户手动输入过值（三个版本都有问题）
>    > 含按钮，且用户手动点击过（只有68有问题）   
>
>  - 如果是内存占用空间在增长，但JS内存增长得很缓慢
>
>    >有可能是有JS变量引用了DOM，这个DOM节点本身不大，但影响了其他DOM节点(比如父级节点树)。

### 2、其他

>其他三个方法在上方`Performance面板`、`Memory面板`均有指出,不再赘述
>
>>1. 使用时间轴(`Performance面板`)记录可视化内存使用。 -->[`点我跳转`](#5、Performance(Timeline) 面板)
>>2. 使用堆快照(`Memory面板`)标识分离的DOM树（内存泄漏的常见原因）。 -->[`点我跳转`](#6、Memory(Profiles) 面板)
>>3. 通过堆动态分配时间轴(`Memory面板`)记录了解在JS堆中分配及回收情况。  -->[`点我跳转`](#6、Memory(Profiles) 面板)

------

# `更多知识点看上方具体笔记`