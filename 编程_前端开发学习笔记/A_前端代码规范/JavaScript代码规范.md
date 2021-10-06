# #说明

>实际上,网络上关于 **JavaScript** 代码规范的好文章有很多,大家大可自行去查阅,此处将为本人梳理摘录的规范笔记,仅供本人学习使用
>
>查阅借鉴的资料: 首先分享个很多前辈推荐我去阅读学习的 **JavaScript** 代码规范文章: [clean-code-javascript ](https://github.com/ryanmcdermott/clean-code-javascript) 大家大可直接阅读这个文章.
>
>除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[数据结构与算法](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_算法及课程基础学习笔记/数据结构与算法)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[编程_后台服务端学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记)** 、**[Java](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Java)** 、**[Nodejs](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Nodejs)** 、**[JavaScript笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记)**、**[编程工具使用笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端工具使用笔记)** 、**[前端代码规范](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端代码规范)** 、**[ES6及后续版本学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记)** 、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了

# 干净的代码

## 前言

>此处引用一下  [clean-code-javascript ](https://github.com/ryanmcdermott/clean-code-javascript)  中的一张图片能更形象的形容干净的代码与不干净的代码的区别:
>
>![image-20211006143142868](JavaScript代码规范中的图片/image-20211006143142868.png) 
>
>这个文章中有一段话我觉得说的特别好:
>
>>* 了解这些不会立即使您成为更好的软件开发人员，与他们一起工作多年并不意味着您不会犯错误。每一段代码都是从初稿开始的，就像湿粘土被塑造成最终形式一样。
>>* 最后，当我们与同行一起回顾时，我们会剔除不完美之处。
>>* `不要为需要改进的初稿而自责。而是打败代码！`
>
>##### **不要为需要改进的初稿而自责。而是打败代码！** 

## 1、变量

>使用有意义且可发音的变量名  
>
>```js
>//坏的
>const yyyymmdstr = moment().format("YYYY/MM/DD");
>//好的
>const currentDate = moment().format("YYYY/MM/DD");
>```
