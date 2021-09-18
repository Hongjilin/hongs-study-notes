# #说明

>一般来说,我们使用变量前都会先声明变量:let const var function ... ; 但是JS中变量也可以不声明,直接使用,这是什么意思呢?他们之间有何区别呢?
>
>查阅借鉴的资料:MDN的[var 描述部分](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Statements/var);慕课网的[变量可以不声明直接使用?](https://www.imooc.com/qadetail/78057); CSDN的[js 变量声明 （var使用与不使用的区别](https://blog.csdn.net/muzidigbig/article/details/81075545);思否的 [JS函数中直接使用变量,不用VAR?](https://segmentfault.com/q/1010000007048076)
>
>除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[数据结构与算法](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_算法及课程基础学习笔记/数据结构与算法)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[编程_后台服务端学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记)** 、**[Java](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Java)** 、**[Nodejs](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Nodejs)** 、**[JavaScript笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记)**、**[编程工具使用笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端工具使用笔记)** 、**[ES6及后续版本学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记)** 、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了



## Ⅰ - 变量的声明分显式声明和隐式声明

>* **显示声明** 是程序中的一条说明语句，它列出一批变量名并指明这些变量的类型。
>
>  >```js
>  >// 显示声明 变量name，但不知其类型，也不知其占用空间大小
>  >var name ;
>  >```
>
>* **隐式声明** 指通过某种默认协定的方法将变量名与类型绑定。如在Fortain中，一个以字母I、J、K、L、M或者N（或其对应小写）开始，它们被隐式的声明为Integer类型。否则为Real类型。
>
>  >```js
>  >// 赋值语句其实隐式的声明了变量count，类型为数字，占用8个字节（64位浮点格式）
>  >// 所有隐式声明的变量默认都是全局变量，无论函数内外
>  >name = 'hongjilin';//隐式声明(为全局变量的一个属性) --> 注意:是属性
>  >```
>  >
>  >隐式声明带来了些许的方便，但却被认为有损于程序的可读性，因为它可能会带来隐藏的错误，Bug。