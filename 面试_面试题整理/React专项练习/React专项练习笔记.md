



## 一、问答题

### 1、React事件绑定原理

>可以去看官方解释 --> [点我传送](https://reactjs.org/docs/events.html) 
>
>如果对于React事件绑定原理有兴趣的同学可以看这个,写的不错 --> [`【长文慎入】一文吃透 react 事件机制原理`](https://cloud.tencent.com/developer/article/1516369)

#### Ⅰ - **标准要点**

>* React中 **event** 事件并不是原生事件,而是对原生**event** 进行了封装的新类 **SyntheticBaseEvent**,模拟出DOM事件的所有功能
>* 如果你需要原生事件,可以通过 `event.nativeEvent` 属性就能获取到
>* React17版本开始所有事件都绑定在 **root** 根组件上,之前都是绑定在 **document** 上
>* React中 event 和 DOM 事件是不一样的,与Vue也不一样

#### Ⅱ - 结合实例回答

>###### 以一个点击事件为例
>
>* React 并不是将 **cilck** 事件绑定在该div的 **真实DOM** 上,而是在 **root** 处监听所有支持的事件
>* 当事件发生并冒泡至 **root** 处时,React将事件内容封装并交由真正的处理函数处理
>* **这样的方式不仅减少了内存消耗,还能在组件挂载销毁时统一订阅和移除事件**
>* 另外,冒泡到 **root** 上的事件也不是原生浏览器事件,而是 React 自己实现的合成事件( **SyntheticBaseEvent** )
>* 因此如果我们不想要事件冒泡的话,调用 [event.stopPropagation](https://developer.mozilla.org/zh-CN/docs/Web/API/Event/stopPropagation) 是无效的,应该调用 [event.preventDefault](https://developer.mozilla.org/zh-CN/docs/Web/API/Event/preventDefault)



