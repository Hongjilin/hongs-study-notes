# #说明

>**console.log()** 对于我们程序员来说是一个非常常用的函数,特别是对于我这种初入前端的程序员来说更常用,而在某次打印输出时,发现console在chrome控制台输出的顺序似乎不符合自己评估的预期,有点颠覆自己的认知,所以认真的去查阅了一下资料.分享出来,有错误或者有不同见解欢迎指出
>
>查阅参考的资料:[console.log() shows the changed value of a variable before the value actually changes](https://stackoverflow.com/questions/11284663/console-log-shows-the-changed-value-of-a-variable-before-the-value-actually-ch)、[console.log() async or sync?](https://stackoverflow.com/questions/23392111/console-log-async-or-sync)、[How can I make console.log show the current state of an object?](https://stackoverflow.com/questions/7389069/how-can-i-make-console-log-show-the-current-state-of-an-object)、  [如何更改 Safari 中 console.log 的默认行为](https://stackoverflow.com/q/7389069/1048572)

# 一、问题场景复现与分析

### Ⅰ- 场景复现

>```html
><body>
><div id="id1">xxx</div>
></body>
><script>
>let el = document.querySelector('#id1')
>console.log(el)
>el.id = 'id2'
>console.log(el)
>el.id = 'id4'
>console.log(el)
>setTimeout(() => {
>el.id = 'id3'
>console.log(el)
>}, 1000)
></script> 
>```
>
>按照我们的猜想,正确的打印结果应该是 id1 、 id2 、 id4 、 id3 ,但实际上打印结果却如下:
>
>![image-20210910185337657](../../../梳理_专项练习及知识点梳理笔记/JavaScript专项练习/JavaScript专项练习中的图片/image-20210910185337657.png)  
>
>这是为什么呢?

### Ⅱ -出现问题的场景分析

>通过多次测试,对于控制台打印 **复杂的对象** 都可能会出现这个问题,在以前版本连简单对象都会出现,似乎现在已经修复大多数情况,但仍会有部分情况会出现上述场景的问题

### Ⅲ- 提出可能的猜想

>* console.log是同步还是异步的?
>* 是否因为打印的内容是引用对象,导致 **console.log** 进行了惰性求值,等到最后一起打印?
>* 示例中,放置在延时器的打印并没有影响,这与JS的宏任务微任务机制有关系吗? --> **[Ⅲ-宏任务macro-task与微任务micro-task](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记#Ⅲ-宏任务macro-task与微任务micro-task)**

# 二、尝试剖析

### Ⅰ- 整理的网上对于console.log的描述

>1. 首先:`console.log`没有标准化，所以行为是相当未定义的，并且可以很容易地随开发人员工具的发布而改变。
>2. 对于我们的代码，`console.log` **异步与否没有任何区别**，它不提供任何类型的回调等；并且您传递的值始终在您调用函数时被引用和计算。
>3. 我们真的不知道会发生什么（好吧，我们可以，因为 Firebug、Chrome Devtools 和 Opera Dragonfly 都是开源的）。
>   - 控制台需要将记录的值存储在某处，并将它们显示在屏幕上。渲染肯定会异步发生（受到速率限制更新的限制），未来与控制台中记录的对象的交互也会如此（例如扩展对象属性）。
>   - 因此，控制台可能会克隆（序列化）您记录的可变对象，或者存储对它们的引用。第一个不适用于深/大对象。此外，至少控制台中的初始渲染可能会显示对象的 “ **当前** ” 状态，即在上述示例中出现的问题

### Ⅱ -  console.log是同步还是异步的?

>我已经看到它发生在 Chrome 中。如果您 console.log 一个简单的对象，然后立即更改对象中的某些内容，`console.log()`则不会始终显示前一个值。如果发生这种情况，解决方法是将您尝试转换的任何内容转换`console.log()`为不可变的字符串，因此不受此问题的影响。因此，根据经验，`console.log()`有一些异步问题可能与跨进程边界封送数据有关。这不是预期的行为，而是`console.log()`内部工作方式的一些副作用（我个人认为这是一个错误）
>
>另请参见[console.log() 在值实际更改之前显示变量的更改值](http://stackoverflow.com/q/11284663/1048572) 

### Ⅲ - 示例中,放置在延时器的打印并没有影响,这与JS的宏任务微任务机制有关系吗?

> 实际上,打印结果不同主要是,定时器里面代码确实是推入了宏任务,所以前面三个打印结果都运行结束了,又过了一会儿才执行,这时候修改了打印的变量,但是已经打印出来的内容并不会重新打印(JS同步单线程)
>
> 但是上述情况是你刷新页面重新执行后会出现的情况,如果你直接打开网页,就可能会出现全部都变成 **id3**,很有意思.你也别觉得怎么这么多错误情况,别慌,下面有解决方案

### Ⅳ- 是否因为打印的内容是引用对象,导致 **console.log** 进行了惰性求值,等到最后一起打印?

>当您展开对象以进一步检查其属性时，控制台可能只会存储对您的对象及其属性的引用，现在显示它们将显示其当前（已发生变异）的状态。如果单击`+`，您应该能够`bar`在示例中看到该属性。
>
>- 因此，某些值可能会在它们被记录后很久才被引用，并且对这些值的评估相当*懒惰*（“需要时”）。这种差异最著名的例子是在问题[Chrome 的 JavaScript 控制台是否懒惰评估数组中处理的？](https://stackoverflow.com/questions/4057440/is-chromes-javascript-console-lazy-about-evaluating-arrays)

# 三、解决方案

> 实际上这并不算是JS的缺陷,而是开发者工具console的缺陷

### Ⅰ-  console.log(JSON.stringify(obj))

>一种解决方法是确保始终记录对象的序列化快照，例如通过执行`console.log(JSON.stringify(obj))`. 不过，这仅适用于非圆形和相当小的物体。另请参阅 [如何更改 Safari 中 console.log 的默认行为](https://stackoverflow.com/q/7389069/1048572)

### Ⅱ - 断点调试

>更好的解决方案是使用断点进行调试，在那里执行完全停止，您可以检查每个点的当前值。仅对可序列化和不可变数据使用日志记录
>
>![image-20210910190905653](../../../梳理_专项练习及知识点梳理笔记/JavaScript专项练习/JavaScript专项练习中的图片/image-20210910190905653.png)