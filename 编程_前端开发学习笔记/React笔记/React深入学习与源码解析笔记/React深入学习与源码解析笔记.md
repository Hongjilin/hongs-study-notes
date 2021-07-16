# #说明

>本笔记为本人`洪`深入学习React并尝试阅读理解React源码所记录笔记
>
>建议预备知识:react基础
>
>学习过程及笔记记录时查阅借鉴的相关资料官方文档的[源码概览](https://zh-hans.reactjs.org/docs/codebase-overview.html);ILoveDevelop的[`React 源码解析`](https://react.jokcy.me/);知乎的神马翔[`React专栏`](https://www.zhihu.com/people/song-meng-xiang-95)、[全栈潇晨](https://www.zhihu.com/people/qbtqiuqiu)的React系列文章、[`万字长文+图文并茂+全面解析 React 源码 - render 篇`](https://segmentfault.com/a/1190000022105022);前端桃园的[`Deep In React之浅谈 React Fiber 架构`](https://mp.weixin.qq.com/s?__biz=MzAxODE2MjM1MA==&mid=2651556940&idx=1&sn=d40506db3d4d78da9a94ae6c7dc61af6&chksm=80255b8db752d29bbb8edc79eb40ce4122f3fddca121a53a5c3f859259cf4b1d7402ff676a84&scene=21#wechat_redirect);还有`公司前辈的技术分享`
>
>本人笔记地址分享:[`全部笔记`](https://gitee.com/hongjilin/hongs-study-notes)、**[`React笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)** 
>
>本人的React学习笔记分类(也是对应本人技术成长路程):[[`想快速入门看这部分`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React基础补充学习笔记)]、[[`想对React基础系统全面进行学习的同学看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/Scss%E7%AC%94%E8%AE%B0)]、[[`对基础学习完成且有了一定开发经验,想尝试解析源码的看这里`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记/React深入学习与源码解析笔记)]

# #目录	​

>[TOC]

# 一、React基础知识总结

> 在深入学习前,还是先捋一捋对于React基础知识的理解与总结
>
> 如果想看详细的React基础知识点笔记,可以看本人 **[React系统学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)** 

## 1、JSX

>这东西不用解释我为啥放在第一位说了吧,基本上我们大部分React开发者都是用jsx进行代码编写的
>
>这里不着重讲解基础语法,只是给出自己的理解与总结,有需要了解基础语法的同学  -->[点我跳转](https://zh-hans.reactjs.org/docs/jsx-in-depth.html)

### Ⅰ-我们认为的JSX是什么? 

> 我们认为的JSX是什么? ===>  ` 类HTML的语法?  React里面的模板语法?  语法糖?`
>
> - 其实应该都算是对的,但是有好像不是完全对.如果只讲里面的一点的话又有所欠缺的感觉
>
>  > JSX是(JavaScript XML)的缩写,其实他本质上还是属于JavaScript,`不一定用在React上`
>
> - 此处借用React中文官网的一句话:
>
>  >React不强制要求使用JSX,但是大多数人发现,在JS代码中将JSX与UI放在一起时,在视觉上会有辅助作用.它还可以使得React显示更多有用的错误和警告信息
>
> - 它本身可以理解为是一个规范,开发者在JSX的帮助下,避免重复地学习不同框架或者库,因为在JSX的规范中,他产生的结果是一致的.用React的思想来说,JSX最终的作用是把模板语法解析成Component、props、children....等等;而具体怎么利用这些产物,就是不同的框架或者库的特性了,比如下面的一个组件它被解析以后其实产生的是一段代码段,并且有固定的参数位置
>
>  > ![image-20210715165316019](React深入学习与源码解析笔记中的图片/image-20210715165316019.png)
>  >
>  > 由上图可以看出JSX的产物(h函数名称和h函数的参数),它很像虚拟DOM

### Ⅱ-JSX的产物

#### ① 简单的JSX产物

>以下是一个最简单的JSX编译后的结果
>
>![image-20210715171023093](React深入学习与源码解析笔记中的图片/image-20210715171023093.png) 
>
>JSX的产物可以理解是基于JSX代码,利用一个函数模板(如同[`Ⅰ`](#Ⅰ-我们认为的JSX是什么? )中图示的[h]函数),生成一段[`调用`]函数模板,然后里面的函数名可能在不同的框架或者库中是不一样的,他没有实现h函数,需要框架或者库自己实现
>
>可以得出一个大胆的结论:`JSX理论上是完全跨平台的,只要有人实现它在对应平台的[h]函数,它甚至可以在任何支持JS语言的平台上运行`

#### ② Rreact中的JSX产物

>- 作为React的官方指定语法,JSX允许用户在JS代码中插入HTML代码.但是这种写法`浏览器是无法解析的`,他们就需要一个转换器
>
>  >`Babel`就充当了这样一个角色，他在JSX代码编译时候将其转换成JS文件，这样浏览器就能解析了。
>
>- JSX有JS和HTMl两种写法，本身就是JS写法的其实是不需要转换的
>
>  >当然也不能说的这么绝对，有时候Babel会为了兼容性的缘故将高版本的语法翻译到低版本，这部分不在讨论范围。我们要关注的其实是HTMl的处理方式

##### 代码转换示例与解析

>1. 比如下面这行代码：
>
>   >```jsx
>   ><div id='name'>Tom and Jerry</div>
>   >
>   >---------------通过Babel转换后生成的代码是：-------------------------
>   >    
>   >React.createElement("div", {
>   >    id: "name"
>   >}, "Tom and Jerry");
>   >```
>   >
>   >HTML语法转变成了JS语法，简单来说，我们所写的JSX最终变成了JS。
>
>2. 复杂点的例子
>
>   >```jsx
>   ><div class='wrapper' id='id_wrapper'>
>   >    <span>Tom</span>
>   >    <span>Jerry</span>
>   ></div>
>   >----------- 通过Babel转换后生成的代码是： ---------------------
>   >    
>   >React.createElement("div", {
>   >    class: "wrapper",
>   >    id: "id_wrapper"
>   >}, React.createElement("span", null, "Tom"), React.createElement("span", null, "Jerry"));
>   >```
>   >
>   >转换规则是比较简单的，React.createElement的第一个参数是节点类型；第二个参数是该节点的属性，以key：value的形式作为一个对象，后面的所有参数都是该节点的子节点。
>
>3. 自定义组件
>
>   >```jsx
>   >function Comp() { return '<div>Tom and Jerry</div>' }
>   ><Comp></Comp>
>   >
>   >-------------- 通过Babel转换后生成的代码是：  ---------------------------------
>   >
>   >function Comp() {  return '<div>Tom and Jerry</div>'; }
>   >React.createElement(Comp, null);
>   >```
>   >
>   >可以看出，React.createElement的第一个参数变成了一个变量，而不是一个字符串，`尝试将函数Comp首字母小写`：
>   >
>   >```jsx
>   >function comp() { return '<div>Tom and Jerry</div>' }
>   ><comp></comp>
>   >
>   >--------------  通过Babel转换后生成的代码是：-------------------------------------------
>   >
>   >function comp() { return '<div>Tom and Jerry</div>'; }
>   >React.createElement("comp", null);
>   >```
>   >
>   >React.createElement的第一个参数又变成了一个字符串。
>   >这也就是我们在React中写组件的时候，`为什么会要求首字母大写的原因`，Babel在编译的时候会将首字母小写的组件视为原生的HTMl节点进行处理，如果我们将自定义组件首字母小写，后续的程序将无法识别这个组件，最终会报错。

### Ⅲ-React为什么选择JSX?

>- 对于一个人喜欢的事物,很多可以用一句话概括:`之所以选择X,是因为Y和Z不好,然后X有一个点能吸引你,那么X就是好的`
>
>- 但是放到技术上,要回答好这个问题,就需要先了解React可选的其他解决方案有什么不好的地方
>
>- 其实相关的方案很多,最直观的就是`模板`:
>
>  > 其实Vue与Angular都是用的模板语法,他们上手简单这是事实,但是`对于React团队来说它并不纯粹!!`
>  >
>  > 它引入了很多新的概念,需要去学习模板指令、模板语法等(如Vue需要理解v-if、v-for等),而JSX就没前者这么复杂,它不需要学习新的开发方式,虽然它也有模板的味道,但它本身能直接支持JS写法(如条件表达式和循环等)

## 2、ReactElement

> 为何这个放在JSX下方,因为此知识有jsx做铺垫就容易理解很多,有做对比更易理解

### Ⅰ-React.createElement函数

>通过Babel编译后的JS代码，频繁出现React.createElement这个函数。这个函数的返回值就是ReactElement，通过上面的示例可以看出，React.createElement函数的入参有三个，或者说三类

#### ① type 

>type指代这个`ReactElement的类型`
>
>1. 字符串比如div，p代表原生DOM，称为HostComponent
>2. Class类型是我们继承自Component或者PureComponent的组件，称为ClassComponent
>3. 方法就是functional Component
>4. 原生提供的Fragment、AsyncMode等是Symbol，会被特殊处理

#### ② config

>参照上面Babel编译后的代码，所有节点的属性都会以Key:Value的形式放到config对象中。

#### ③ children

>子节点不止会有一个，所以children不只有一个，从第二个参数以后的所有参数都是children，它是一个数组

### Ⅱ-ReactElement的结构

>1. [`$$typeof`] 是一个常量，所有通过React.createElement生成的元素都有这个值。一般使用 React 的组件都是挂到父组件的 this.props.children 上面，但是也有例外，比如要实现一个模态框，就需要将模态框挂载到body节点下，这个时候需要使用ReactDOM.createPortals(child, container)这个函数实现，这个函数生成的$$typeof值就是REACT_PORTAL_TYPE。 -->`用于确定是否属于ReactElement`
>2. [`type`]指代这个ReactElement的类型 -->`用作判断如何创建节点`
>3. [`key]`和[`ref`]都是从config对象中找到的特殊配置，将其单独抽取出来，放在ReactElement下
>4. [`props`]包含了两部分，第一部分是去除了key和ref的config，第二部分是children数组，数组的成员也是通过React.createElement生成的对象  -->`新的属性内容`
>5. _owner在16.7的版本上是Fiber，Fiber是react16+版本的核心,也是调度算法
>
>这些信息对于后期构建应用的树结构是非常重要的,**`而React通过提供这种类型的数据，来脱离平台的限制`**
>
>```js
>const element = {
>   // 这个标签允许我们唯一地将其标识为React元素  
>   $$typeof: REACT_ELEMENT_TYPE,
>
>   //属于元素的内置属性  
>   type: type,
>   key: key,
>   ref: ref,
>   props: props,
>
>   // 记录负责创建此元素的组件。
>   _owner: owner,
> };
>```
>
>它就是一个简单的对象，为了看清楚这个对象的创建规则，我们举个例子。 首先是我们写的JSX：
>
>```jsx
><div class='class_name' id='id_name' key='key_name' ref='ref_name'>
>   <span>Tom</span>
>   <span>Jerry</span>
></div>
>```
>
>它会被Babel编译为：
>
>```js
>React.createElement("div", {
>   class: "class_name",
>   id: "id_name",
>   key: "key_name",
>   ref: "ref_name"
>}, React.createElement("span", null, "Tom"), React.createElement("span", null, "Jerry"));
>```
>
>它会生成这样一个Element
>
>```js
>{
>   $$typeof: REACT_ELEMENT_TYPE,
>   type：'div'，
>   key: 'key_name',
>   ref: "ref_name",
>   props: {
>       class: "class_name",
>       id: "id_name",
>       children: [
>           React.createElement("span", null, "Tom"),
>           React.createElement("span", null, "Jerry")
>       ]
>   }
>    _owner: ReactCurrentOwner.current,
>}
>```



## X、对虚拟DOM的理解

### Ⅰ-什么是虚拟DOM

>- 在React、Vue还没有出现的时候,我们要操作页面上的元素,需要`先找到那个元素`,然后`再进行修改样式、内容或者结构等`-->这很明显性能特别差,也会特别消耗资源!
>
>- 于是就有人会这样思考:如果在操作DOM之前就知道这一次数据更新期望改变的[`节点和`]怎么修改的话,那么这很明显可以提升页面渲染效率
>
>  - > 举个栗子:渲染列表时比如有100条数据,我删除其中一条,那么我只是在`虚拟DOM数据`上删除此条数据,然后剩余的经过diff算法对比,其实只是删除了一条,其余的只是调整了在页面上的位置没有重新渲染;直接操作dom就会导致数据重绘(临时举例不够贴切勿怪)
>
>- 于是[`虚拟DOM`]出现了,`它其实是一个数据结构`,是针对当前DOM构建的一个数据结构
>
>- 以下是一个React的虚拟DOM结构
>
>  ![image-20210715180450728](React深入学习与源码解析笔记中的图片/image-20210715180450728.png) 

### Ⅱ-为什么需要虚拟DOM

>其实在上面说明[[什么是虚拟DOM](#Ⅰ-什么是虚拟DOM)]的时候就已经大概说明了为什么需要虚拟DOM了.因为`一个新事物只有被需要、能解决某一痛点的时候才会被创造`
>
>- 无脑的渲染是否真的必要?
>
>  - > 很明显不需要.但是在没有虚拟DOM之前,我们能依靠的只有直接操作DOM,尽管我们知道操作DOM而产生的`重绘`会对页面性能产生巨大影响
>
>- 当一个项目大到一种境界的时候,如果还是用查找元素然后进行修改的话,对代码的维护难度会呈现指数级飙升
>
>- 它是Diff算法的技术,也是数据驱动UI的前提
>
>个人理解的虚拟DOM大致流程图(公司前辈讲解的)
>
><img src="React深入学习与源码解析笔记中的图片/image-20210715182038527.png" alt="image-20210715182038527" style="zoom:80%;" /> 



### Ⅲ- 误区:虚拟DOM比直接操作DOM快?

>- 很多人有这个误区,甚至我在之前很长的一段时间中都是这样认为的.其实不然,通过上面的流程图其实可以很好理解:`直接操作DOM是最快的`.
>- 如果通过虚拟DOM计算出的更新策略是需要重绘10次,而直接操作DOM的次数也是重绘10次,那么直接操作应该是更快的,因为它省去了中间虚拟DOM构建、Diff算法、制定更新策略等;
>- 当然,正常情况下针对一个[`state`(状态)]变化后期望产生结果得出的`更新次数是远小于直接操作DOM`的,预知更新策略比直接无脑操作虽然会花费一部分内存,但是直接操作减少了,性能肯定会更好,做出来的应用的会更加健壮

#### 无图无真相

>网络上有人做了一个操作更新组件各种样式1000次的时间点对比(设定重绘次数一致):
>
>![image-20210715184238480](React深入学习与源码解析笔记中的图片/image-20210715184238480.png)
>
> 可以看出,直接操作DOM是最快的!`但是React需要的渲染时间可能是0`,下限更低,也正是因为计算出来某些[`state`(状态)]不需要更新DOM



## 3、React API 梳理

### Ⅰ-暴露出来的API

>```jsx
>// react\src\React.js
>const React = {
>  Children: {
>    map,
>    forEach,
>    count,
>    toArray,
>    only,
>  },
>
>  createRef,
>  Component,
>  PureComponent,
>
>  createContext,
>  forwardRef,
>  lazy,
>  memo,
>
>  useCallback,
>  useContext,
>  useEffect,
>  useImperativeHandle,
>  useDebugValue,
>  useLayoutEffect,
>  useMemo,
>  useReducer,
>  useRef,
>  useState,
>
>  Fragment: REACT_FRAGMENT_TYPE,
>  Profiler: REACT_PROFILER_TYPE,
>  StrictMode: REACT_STRICT_MODE_TYPE,
>  Suspense: REACT_SUSPENSE_TYPE,
>  unstable_SuspenseList: REACT_SUSPENSE_LIST_TYPE,
>
>  createElement: __DEV__ ? createElementWithValidation : createElement,
>  cloneElement: __DEV__ ? cloneElementWithValidation : cloneElement,
>  createFactory: __DEV__ ? createFactoryWithValidation : createFactory,
>  isValidElement: isValidElement,
>
>  version: ReactVersion,
>
>  unstable_withSuspenseConfig: withSuspenseConfig,
>
>  __SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED: ReactSharedInternals,
>};
>```
>
>挑一些常见的分析下用法和源码

### Ⅱ-createRef

>react获得ref的方式有三种
>
>- String ref 方式(被废弃)
>- callback ref 方式
>- `React.createRef` (16.3版本新增特性)
>
>代码举例:
>
>```jsx
>----------------------- string ref -------------------------
>class App extends React.Component {
>  componentDidMount() {
>    this.refs.myRef.focus();
>  }
>  render() {
>    return <input ref="myRef" />;
>  }
>}
>------------------------ callback ref-------------------------
>class App extends React.Component {
>  componentDidMount() {
>    this.myRef.focus();
>  }
>  render() {
>    return <input ref={(ele) => {
>      this.myRef = ele;
>    }} />;
>  }
>}
>---------------------- React.createRef ------------------------
>class App extends React.Component {
>  constructor(props) {
>    super(props);
>    this.myRef = React.createRef();
>  }
>  componentDidMount() {
>    this.myRef.current.focus();
>  }
>  render() {
>    return <input ref={this.myRef} />;
>  }
>}
>```
>
>查看 React.createRef 的源码，`发现只是生成了一个对象，用于保存 current 的值`。
>
>```js
>// react\src\ReactCreateRef.js
>export function createRef(): RefObject {
>  const refObject = {
>    current: null,
>  };
>  return refObject;
>}
>```
>
>`React.createRef 并不负责将 dom 节点绑定 current 上面，它只负责生成对应的结构`。
>
>`真正做事的是 react-dom`。react 这么拆分，将公共的部分放在 react 中，而与平台相关的单独抽离，比如在移动端，负责将页面元素挂在到 current 字段上的就不是 `react-dom` 了，而是`react-native`。

### Ⅲ-Component & PureComponent

#### ① Component:

>Component源码
>
>```jsx
>// react\src\ReactBaseClasses.js
>function Component(props, context, updater) {
>this.props = props;
>this.context = context;
>// 如果一个组件有字符串引用，我们将在以后分配一个不同的对象。  
>this.refs = emptyObject;
>// 初始化默认更新器，但真正的更新器由 renderer.
>this.updater = updater || ReactNoopUpdateQueue;
>}
>
>Component.prototype.setState = function(partialState, callback) {
>this.updater.enqueueSetState(this, partialState, callback, 'setState');
>};
>
>Component.prototype.forceUpdate = function(callback) {
>this.updater.enqueueForceUpdate(this, callback, 'forceUpdate');
>};
>```
>
>Component 中维护了4个变量，props，context，refs 以及 updater。前三者都是我们常见的，updater 是与平台相关的，他基本负责了 react 中的所有任务，包括数据更新，界面渲染等一系列的工作。
>
>以下是 Component 的数据结构，f 表示函数，省略号表示暂时不用关注
>
>```json
>{
>props: {},
>context: {},
>refs: {},
>updater: {...},
>state: null,
>__proto__: {
> constructor: class Demo，
> render: f
> __proto__: {
>   constructor: f,
>   setState: f,
>   forceUpdate: f,
>   isReactComponent: {}
> }}}
>```
>
>可以看到，`eact 中的声明周期不是在 Component 中定义的`，这一点在后续的章节会详细讲解。

#### ② PureComponent

>和 Component 是基本一致的，只是比 Component 多了一个属性
>
>```js
>pureComponentPrototype.isPureReactComponent = true;
>```
>
>以下是 PureComponent 的数据结构
>
>```json
>{
>props: {},
>context: {},
>refs: {},
>updater: {...},
>state: null,
>__proto__: {
> constructor: class Demo，
> render: f
> __proto__: {
>   constructor: f,
>   setState: f,
>   forceUpdate: f,
>   isReactComponent: {}，
>   isPureReactComponent: true  //多了这个
> }
>}
>}
>```

#### ③ 多出的[`isPureReactComponent`]有什么用?

>```js
>if (ctor.prototype && ctor.prototype.isPureReactComponent) {
>  return (
>    !shallowEqual(oldProps, newProps) || !shallowEqual(oldState, newState)
>  );
>}
>```
>
>这是检查组件是否需要更新的一个判断，`ctor`就是你声明的继承自`Component or PureComponent`的类，他会判断你是否继承自`PureComponent`，如果是的话就`shallowEqual`比较`state`和`props`。
>
>顺便说一下：**React中对比一个ClassComponent是否需要更新，只有两个地方。一是看有没有`shouldComponentUpdate`方法，二就是这里的`PureComponent`判断**

### Ⅳ-createContext

>createContext 是官方定稿的 context 方案，在这之前我们一直在用的老的 context API 都是 React 不推荐的 API，官方在17大版本会把老 API 去除。
>
>Context 通过`组件树`提供了一个传递数据的方法，从而避免了在每一个层级手动的传递 props 属性。下面的例子展示了在顶层组件通过 [`Provider`] 的方式提供了一个值，在下层组件可以通过 [`Consumer`] 拿到，中间不需要任何的 props 传参。
>
>```jsx
>const { Provider, Consumer } = React.createContext('default');
>
>class Top extends React.Component {
>  state = { contextValue: '123' };
>  render() {
>    return (
>      <Provider value={this.state.contextValue}>
>        {this.props.children}
>      </Provider>
>    )
>  }
>}
>
>class Bottom extends React.Component {
>  render() {
>    return (
>      <Consumer>
>        {value => <p>contextValue: {value}</p>}
>      </Consumer>
>    )    
>  }
>}
>
>export default () => (
>  <Top>
>    <Bottom />
>  </Top>
>)
>```
>
>查看React.createContext的源码，我摘出其中的重要代码:
>
>```js
>// react\src\ReactContext.js
>export function createContext<T>(
>  defaultValue: T,
>  calculateChangedBits: ?(a: T, b: T) => number,
>): ReactContext<T> {
>
>    const context: ReactContext<T> = {
>      $$typeof: REACT_CONTEXT_TYPE,
>      _calculateChangedBits: calculateChangedBits,
>      //作为支持多个并发渲染器的解决方案，我们将其分类  
>      //一些渲染器是主要的，另一些是次要的。 我们只希望  
>      //最多有两个并发渲染器:React Native (primary)和  
>      //面料(二级); React DOM(主要)和React ART(次要)。  
>      //二级渲染器将它们的上下文值存储在单独的字段中。  
>      _currentValue: defaultValue,
>      _currentValue2: defaultValue,
>      //用于跟踪当前有多少并发渲染此上下文  
>      //在单个渲染器中支持。 例如并行服务器呈现。  
>      _threadCount: 0,
>      // These are circular
>      Provider: (null: any),
>      Consumer: (null: any),
>  };
>
>  context.Provider = {
>    $$typeof: REACT_PROVIDER_TYPE,
>    _context: context,
>  };
>
>  context.Consumer = context;
>
>  return context;
>}
>```
>
>createContext接收的是一个 `defaultValue` ，还有一个是 `calculateChangedBits` 。这是一个方法，这个方法接受 newValue 与 oldValue 的函数，返回值作为 changedBits，在 Provider 中，当 changedBits = 0，将不再触发更新。
>
>方法里面声明了一个 context 对象，有一个 $$typeof 属性，需要注意的是，`这个 [$$typeof]` 跟 `ReactElement的 [$$typeof] 是不一样的`。
>
>下面列出了两个$$typeof的不同之处。
>
>```json
>{
>  $$typeof: REACT_ELEMENT_TYPE // 其实是一个Symbol类型的标志
>  type: {
>    $$typeof: REACT_PROVIDER_TYPE // 其实是一个Symbol类型的标志
>    _currentValue: "default",
>    ...
>  }
>}
>```
>
>_currentValue ， _currentValue2 这两个属性是一样的，只是用到的地方不一样。 _currentValue 这个 value 是用来记录 Provider 里面的这个 value 。 他有变化的情况下就会更新到这个 _currentValue 。是用来记录最新的 context 的值的。
>
>context.Provider 有个属性 _context ，这个属性会指向这个 context。context.Consumer = context。 `也就是说 Consumer 是等于自己的`。

### Ⅴ-forwardRef

>`forwardRef`是用来解决HOC组件传递`ref`的问题的，所谓HOC就是`Higher Order Component(高阶组件)`，比如使用`redux`的时候，我们用`connect`来给组件绑定需要的state，这其中其实就是给我们的组件在外部包了一层组件，然后通过`...props`的方式把外部的`props`传入到实际组件
>
>在低版本使用string ref的时候，ref 是不能加在 Component 上的。原因也很简单，ref 这个字段会被单独处理，不会传递到子组件上（[`详见ReactElement部分`](#2、ReactElement)）。React16之后，通过 forwardRef 就能实现父组件向子组件自动传递引用 ref。这种需求通常发生在需要处理焦点，动画，或者是集成第三方 Dom 库的时候。下面列举了一个处理输入框焦点的例子。
>
>```jsx
>import React, { Component, createRef, forwardRef } from 'react';
>//forwardRef使用方式举例
>const FocusInput = forwardRef((props, ref) => (
>  <input type="text" ref={ref} />
>));
>
>class ForwardRef extends Component {
>  constructor(props) {
>      super(props);
>      this.ref = createRef();
>  }
>
>  componentDidMount() {
>    const { current } = this.ref;
>    current.focus();
>  }
>
>  render() {
>    return (
>      <div>
>        <p>forward ref</p>
>        <FocusInput ref={this.ref} />
>      </div>
>    );
>  }
>}
>export default ForwardRef;
>```
>
>查看 forwardRef 源码。
>
>```js
>// react\src\forwardRef.js
>export default function forwardRef<Props, ElementType: React$ElementType>(
>   //render函数作为参数-->即包装的FunctionComponent
>  render: (props: Props, ref: React$Ref<ElementType>) => React$Node,
>) {
>  return {
>    $$typeof: REACT_FORWARD_REF_TYPE,
>    render,
>  };
>}
>```
>
>1. 被forwardRef包裹后，组件内部的$$typeof是`REACT_FORWARD_REF_TYPE`
>2. render即包装的FunctionComponent，ClassComponent是不用forwardRef的

### Ⅵ-四个类型

>1. Fragment: REACT_FRAGMENT_TYPE
>2. Profiler: REACT_PROFILER_TYPE
>3. StrictMode: REACT_STRICT_MODE_TYPE
>4. Suspense: REACT_SUSPENSE_TYPE
>
>这四个都是React提供的组件，但他们其实都只是占位符，都是一个Symbol，在React实际检测到他们的时候会做一些特殊的处理。

#### ① Fragment

>`Fragment 是我们使用最多的`，React 中一个常见模式是为一个组件返回多个元素。Fragments 可以让你聚合一个子元素列表，并且不在DOM中增加额外节点。 <> 是 的语法糖。
>
>```jsx
>render() {
>  return (
>    <> //<Fragment></Fragment> 等同
>      <ChildA />
>      <ChildB />
>    </>
>  );
>}
>```

#### ② Profiler

>Profiler是用来测量渲染性能的，几乎不用。

#### ③ StrictMode

>StrictMode 是一个用来突出显示应用程序中潜在问题的工具。与 Fragment 一样，StrictMode 不会渲染任何可见的 UI。它为其后代元素触发额外的检查和警告。
>
>```jsx
>import React from 'react';
>
>function ExampleApplication() {
>  return (
>    <div>
>      <Header />
>      <React.StrictMode>
>        <div>
>          <ComponentOne />
>          <ComponentTwo />
>        </div>
>      </React.StrictMode>
>      <Footer />
>    </div>
>  );
>}
>```
>
>在上述的示例中，不会对 Header 和 Footer 组件运行严格模式检查。但是，`ComponentOne` 和 `ComponentTwo` 以及`它们的所有后代元素`都将进行检查。

#### ④ Suspense

>```jsx
>const OtherComponent = React.lazy(() => import('./OtherComponent'));
>
>function MyComponent() {
>  return (
>    <div>
>      <Suspense fallback={<div>Loading...</div>}>
>        <OtherComponent />
>      </Suspense>
>    </div>
>  );
>}
>```
>
>OtherComponent是通过懒加载加载进来的，所以渲染页面的时候可能会有延迟，`但使用了Suspense之后，可优化交互`。 在外面使用Suspense标签，并在fallback中声明OtherComponent加载完成前做的事，即可优化整个页面的交互
>
>fallback 属性接受任何在组件加载过程中你想展示的 React 元素。你可以将 Suspense 组件置于懒加载组件之上的任何位置。你甚至可以用一个 Suspense 组件包裹多个懒加载组件。

### Ⅶ-四个Element API

#### ① createElement & 

>`createElement`可谓是React中最重要的API了，他是用来创建`ReactElement`的，但是很多同学却从没见过也没用过，这是为啥呢？因为你用了JSX，JSX并不是标准的js，所以要经过编译才能变成可运行的js，而编译之后，`createElement`就出现了：
>
>```js
>// jsx
><div id="app">content</div>
>
>// js
>React.createElement('div', { id: 'app' }, 'content')
>```

#### ② cloneElement 

>`cloneElement`就很明显了，是用来克隆一个`ReactElement`的

#### ③ createFactory 

> `createFactory`是用来创建专门用来创建某一类`ReactElement`的工厂的
>
> ```js
>export function createFactory(type) {
> const factory = createElement.bind(null, type);
> factory.type = type;
>   return factory;
>   }
>   ```
> 
> 他其实就是绑定了第一个参数的`createElement`，一般我们用JSX进行编程的时候不会用到这个API

#### ④ isValidElement

>`isValidElement`顾名思义就是用来验证是否是一个`ReactElement`的，基本也用不太到



## 4、React Children

> 此处为什么不放在`API梳理`中而是单独拿出来讲? [`同学们可以忽略不看此部分`]
>
> 一方面平时不怎么用，另一方面跟数组处理功能差不多，不深究实现是比较容易理解的.但是观阅许多相关资料后,觉得这个还是可以记录一下





















