## 1、说说你对代理模式的理解

### Ⅰ - 代理模式是什么?

>###### 代理模式(Proxy Patten)是为一个对象提供一个代用品或占位符,以便控制对它的访问
>
>**代理模式的关键是:**`当客户不方便直接访问一个对象或者不满足需求时,提供一个替身对象来控制这个对象的访问,客户实际上访问的是替身对象`
>
>![image-20211105092714965](README中的图片/image-20211105092714965.png) 
>
>在生活中代理模式的场景是十分常见的,例如我们现在租房买房都是去找中介机构而不是直接找出售出租的人

### Ⅱ -  使用

>在`ES6`中,存在`Proxy`构建函数能够让我们轻松使用代理模式: [相关详细知识点点我传送](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/ES6%E5%8F%8A%E5%90%8E%E7%BB%AD%E7%89%88%E6%9C%AC%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0)
>
>```js
>const proxy = new Proxy(target,handler)
>```
>
>而按照功能来划分,JS代理模式常用的有
>
>* 缓存代理
>* 虚拟代理

### Ⅲ - 缓存代理

>###### **缓存代理可以为一些开销大的运算结果提供暂时的存储.在下次运算时,如果传递进来的参数跟之前一致,则可以直接返回前面存储的运算结果**

#### ① 未使用缓存代理

>**正常运算函数举例:**
>
>```js
>const mult = (...rest) => {
>console.log('开始计算乘积',rest); //箭头函数不能用arguments,但是可以用rest代替
>let sum = 1;
>for(let i = 0, l = rest.length; i < l ; i++){
>   sum = sum * rest[i];
>}
>return sum;
>}       
>mult(1,2,3)       
>```
>

#### ② 使用缓存代理

>**现在加入缓存代理:**
>
>```js
>const proxyMult = (function(){  
>//利用闭包维护一个缓存变量
>let cache = {} 
>return function(){
>   //将类数组转换成字符串,准备用做缓存的key使用,注意arguments只是类数组,需要转换
>   //也可以这么写 let args = Array.prototype.join.call(arguments,',') 
>   let args = [...arguments].join(',')
>
>   //先检测,本次传入的参数,是否已经在缓存中(是否曾今运行过);如果有则直接返回结果
>   if(args in cache) return cache[args];
>
>   //如果参数未运算过,将几个参数运算返回,并且将参数存入缓存变量中
>   return cache[args] = mult(...arguments) //这里需要展开,将其再次拆分为多个参数
>}
>//这里为什么用自执行?问这个的小伙伴需要复习下闭包知识点,如果不用自执行,第一次调用时需要 proxyMult()(1,2,3,4,) ,所以是一样的,只是这里先运行了
>})() 
>proxyMult(1,2,3,4)
>proxyMult(1,2,3,4)
>```
>
>当第二次调用`proxyMult(1,2,3,4)`时,本体`mult`函数没有被调用计算,只是直接返回了之前缓存好的结果

### Ⅳ - 虚拟代理

>###### 虚拟代理把一些开销很大的对象,延迟到真正需要它的时候才去创建,常见的就是: 图片预加载

#### ① 未使用虚拟代理

>**未使用代理模式时如下:**
>
>```js
>let MyImage = (function(){
>    let imgNode = document.createElement('img');
>    document.body.appendChild(imgNode);
>    //1. 个IMG对象,用于加载真正需要设置的图片
>    let img = new Image;
>    //2. 到 img 加载完成,就执行函数内的代码
>    img.onload = function() {
>        //监听到图片加载完成后,设置src为加载完成后的图片
>        imgNode.src = img.src;
>    }
>    //3. 返回方法对象
>    return {
>        setSrc: function(src){
>            //设置图片的时候,设置为默认的loading图
>            imgNode.src = 'loding.gif';
>            //把真正需要设置的图片传给image对象,加载完成会触发onload()
>            img,src = src
>        }
>    }
>})()
>MyImage.setSrc('http://努力学习的汪.png')
>```
>
>* `MyImage`对象除了负责给`img`节点设置`src`外,还要负责预加载的图片,违反了面向对象设计的原则 -- **单一职责原则**
>* 上述过程`loading`则是耦合进`MyImage`对象里的,如果以后某个时候我们不需要预加载显示loading这个功能了,就只能在`MyImage`对象里面改动代码

#### ② 使用虚拟代理模式

>**使用代理模式:**
>
>```js
>//1. 图片本地对象,负责往页面中创建一个IMG标签,并且提供一个对外的 setSrc 接口
>const myImage = (function(){
>let imgNode = document.createElement('img');
>document.body.appendChild(imgNode);
>return {
>   //向外暴露一个接口,外部调用这个接口,可以给img设置图片
>   setSrc: function( src ){
>       imgNode.src = src;
>   }
>}
>})()
>//2. 代理对象,负责图片的预加载功能
>const proxyImage = (function(){
>	//2.1 创建一个Image对象,用于加载需要设置的图片
>    let img = new Image;
>    //2.2监听到img加载完成后,给被代理的图片本地对象设置src为加载完成后的图片
>    img.onload = function(){
>        myImage.setSrc(this.src)
>    }
>    //2.3 向外暴露一个接口,外部通过这个接口可以间接给img设置图片
>    return {
>        setSrc: function(src){
>            //设置图片时,在图片未被真正加载好时,以这张图作为loading,提示用户图片正在加载
>            myImage.setSrc('loading.git');
>            //设置真正的图片
>            img.src = src;
>        }
>    } 
>})()
>proxyImage.setSrc( 'https://努力学习的汪.jpg' )
>```
>
>* 使用代理模式后,图片本地对象负责往页面中创建一个`img`标签,并且提供一个对外的`setSrc`接口
>* 代理对象负责在图片未加载完成之前,引入预加载的`loading`图,负责了图片预加载的功能 
>* 上述并没有改变或者增加`MyImage`的接口,但是通过代理对象,实际上给系统添加了新的行为
>* 可以发现: 代理与本体接口的一致性,当某一天你不再需要预加载功能,那么就不需要代理对象,可以选择直接请求本体
>* 其中的关键词是 **代理对象** 和 **本体** 都对外提供了 `setSrc` 方法

### Ⅴ - 应用场景

>现在的很多前端框架或者状态管理框架都使用代理模式.用于监听变量的变化
>
>* 使用代理模式代理对象访问的方式,一般又称为`拦截器`
>* 例如我们项目中常用的 `Axios`的实例来进行HTTP请求,使用拦截器`interceptor`可以提前对请求、响应数据进行统一的预处理