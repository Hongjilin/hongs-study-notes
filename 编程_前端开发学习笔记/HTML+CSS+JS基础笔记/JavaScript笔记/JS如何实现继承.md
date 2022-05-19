### #说明

>JS如何实现继承,也是前端面试中经常考察的,了解这个知识点对于巩固js基础是十分有帮助的
>
>本人JS进阶部分有详细分析 -->[点我跳转](https://gitee.com/hongjilin/hongs-study-notes/blob/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/HTML+CSS+JS%E5%9F%BA%E7%A1%80%E7%AC%94%E8%AE%B0/JavaScript%E7%AC%94%E8%AE%B0/A_JavaScript%E8%BF%9B%E9%98%B6%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0.md#1%E5%8E%9F%E5%9E%8B%E4%B8%8E%E5%8E%9F%E5%9E%8B%E9%93%BE)
>
>除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[数据结构与算法](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_算法及课程基础学习笔记/数据结构与算法)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[编程_后台服务端学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记)** 、**[Java](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Java)** 、**[Nodejs](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Nodejs)** 、**[JavaScript笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记)**、**[编程工具使用笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端工具使用笔记)** 、**[前端代码规范](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端代码规范)** 、**[Git学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Git学习笔记)** 、**[ES6及后续版本学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记)** 、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了

### 一、new关键字原理

>new 运算符创建一个用户定义的对象类型的实例 或者 具有构造函数的内置对象的实例
>
>1. 创建一个空的对象作为将要返回的对象实例
>2. 构造函数的prototype属性对象 指向 这个空的对象(原型对象)
>3. 将这个实例对象的值 赋值给 函数内部的this关键字
>4. 执行构造函数内的代码
>5. 如果该函数没有返回对象,则返回this

### 二、JS如何实现继承?

#### Ⅰ - 继承是什么?

>继承是面向对象软件技术中的一个概念:
>
>>如果一个类别B 继承自 另一个类别A ,那么就把这个B称为 'A的子类'; 而把A成为B的父类或者超类
>
>###### 继承的优点:
>
>>* 继承可以使得子类具有父类别的各种属性和方法,而不需要再次编写相同的代码
>>* 子类继承父类的同时,也能重新定义某些属性或者重写某些方法,即覆盖父类的原有属性与方法,使其获得与父类不同的功能
>
>常用的几个继承实现方式
>
>>1. ###### 组合继承
>
>>   - 原型链继承: `Child.prototype = new Panent()`  -->修改一个实例,另外一个实例也会变化
>>   - 构造函数继承: `Panent.call(this) `  -->只能继承父类属性与方法,而不能继承父类的原型上的
>>   - 组合继承: 结合上面两个写法,同时需要手动挂上构造器(Child),指向自己的构造函数 `Child.prototype.constructor = Child`
>
>>2. ###### 寄生组合式继承
>
>>   - 原型继承 : 利用解决普通对象继承问题的 `Object.create()`方法进行实现
>>   - 寄生式继承: 优化上面原型继承的写法,实际上也不好
>>   - 寄生组合式继承:在前面所有继承方式的基础上进行优化,**是最优解决方案**

#### Ⅱ - 组合继承

##### ① 原型链实现继承 (`bad`)

>原型链继承是比较常见的继承方式之一, 其中涉及的构造函数、原型和实例,三者之间存在着一定关系,即前方提到的:1. 每个构造函数都有一个原型对象,原型对象又包含一个指向构造函数的指针,而实例则包含一个原型对象的指针
>
>###### 举个栗子
>
>```js
>//父类原型对象
>function Parent() {
>this.name = 'parent1';
>this.play = [1, 2, 3]
>}
>//构造函数
>function Child() {
>this.type = 'child';
>}
>//将Child 的原型指向 Parent 的实例
>Child.prototype = new Parent();
>console.log(new Child())
>//实例化两个对象
>let s1 = new Child();
>let s2 = new Child();
>console.log(s1.play,s2.play) //[1, 2, 3]    [1, 2, 3]
>
>//修改其中一个的原型
>s1.play.push(4)
>console.log(s1.play,s2.play) //[1, 2, 3, 4]   [1, 2, 3, 4]
>```
>
>我们发现:当我们改变S1的属性时,另外一个实例也发生了改变,这是因为这两个实例使用的是同一个原型对象,**他们的内存空间是共享的**

##### ② 构造函数继承(`bad`)

>借助 `call` 调用`Parent` 函数
>
>```js
>function Parent(){
>this.name='努力学习的汪'
>}
>Parent.prototype.getName=function(){return this.name}
>
>//定义构造函数
>function Child(){
>Parent.call(this);
>this.type='child'
>}
>
>let child= new Child()
>let child1=new Child()
>
>console.log(child,child1)
>//Child {name: '努力学习的汪', type: 'child'} Child {name: '努力学习的汪', type: 'child'}
>
>child.name='hong'
>//Child {name: 'hong', type: 'child'} Child {name: '努力学习的汪', type: 'child'}
>child.getName() //报错
>```
>
>可以看到,父类原型对象中一旦存在父类之前自己已经定义的方法,那么子类将无法继承这些方法
>
>* 相比第一种原型链继承方式,父类的引用属性不会被共享,但他优化了第一种继承方式的弊端
>* 只能继承父类的实例属性和方法,不能继承其原型属性或方法

##### **组合继承**

>前面我们讲到两种继承方式,各有优缺点.组合继承则是将这两种方式结合起来:  **原型链继承+构造函数继承**
>
>* 利用原型链实现对父类对象的方法继承
>* 利用`super()`(实际上你只要写了constructor,那么默认就会给你调用一次super())接用父类构造函数初始化相同属性
>
>```js
>function Parent() {
>   this.name = '努力学习的汪';
>   this.play = [1,2,3]; 
>}
>Parent.prototype.getName = function(){return this.name}
>function Child(){
>   //实际上这里运行后是第二次调用Parent
>	Parent.call(this);
>   this.type = 'child' 
>}
>//第一次调用Parent()
>Child.prototype = new Parent();
>//手动挂上构造器(Child),指向自己的构造函数
>Child.prototype.constructor = Child;
>//实例化两个对象
>let s1 = new Child();
>let s2 = new Child();
>console.log(s1.play,s2.play) //[1, 2, 3]    [1, 2, 3]
>
>//修改其中一个的原型
>s1.play.push(4)
>console.log(s1.play,s2.play) ///[1, 2, 3, 4]    [1, 2, 3]  -->互不影响
>console.log(s1.getName(),s2.getName()) //正常调用
>```
>
>这种方式看起来没什么问题,但实际上 `Parent` 执行了两次,造成了多构造一次的性能开销

#### Ⅲ - **寄生组合式继承**

##### ① 原型继承(`bad`)

>这里主要借助`Object.create`的方法实现普通对象的继承
>
>* 因为`Object.create()`方法式浅拷贝,多个实例的引用类型属性指向相同的内存,存在篡改的可能
>
>```js
>let Parent ={
>   name:'努力学习的汪',
>   arr: ['1','2','3'],
>   getName: function(){return this.name}
>}
>//Object.create()方法创建一个新对象，使用现有的对象来提供新创建的对象的 __proto__
>let child = Object.create(Parent);
>child.name = 'hong';
>child.arr.push('4');
>//声明第二个实例
>let child1 = Object.create(Parent);
>child1.name='jilin';
>child1.arr.push('5')
>
>//调用
>console.log(child.name); //hong
>console.log(child1.name === child1.getName()); //true -->方法调用正常
>console.log(child1.name); // jilin -->名字这种属性修改正常且不会互相影响
>
>console.log(child.arr);  //['1', '2', '3', '4', '5']  -->被篡改了
>console.log(child1.arr); //['1', '2', '3', '4', '5']
>```

##### ② 寄生式继承(`bad`)

>寄生式继承在上面继承基础上进行优化,利用浅拷贝的能力再次进行加强,添加一些方法,但仍然存在一样的问题
>
>```js
>const Parent = {
>name:'努力学习的汪',
>arr: ['1','2','3'],
>getName:function(){return this.name}
>}
>
>//对浅拷贝进行优化增强
>function clone(preObj){
>let clone = Object.create(preObj);
>clone.getArr = function(){return this.arr};
>return clone;
>}
>
>let child = clone(Parent);
>child.name = 'hong';
>child.arr.push('4');
>let child1 = clone(Parent);
>child1.name='jilin';
>child1.arr.push('5');
>
>//调用
>console.log(child.name); //hong
>console.log(child1.name === child1.getName()); //true -->方法调用正常
>console.log(child1.name); // jilin -->名字这种属性修改正常且不会互相影响
>
>console.log(child.getArr());  //['1', '2', '3', '4', '5']  -->被篡改了
>console.log(child1.getArr()); //['1', '2', '3', '4', '5']
>```

##### 寄生组合式继承

>寄生组合式继承,借助解决普通对象继承问题的`Object.create()`方法,结合前面全部继承方法的优缺点的基础上进行改造,这也是所有继承方式里面相对最优的继承方式
>
>* 组合继承: 缺陷是 多调用了一次构造函数,存在性能问题
>* 寄生式继承: 缺陷是 引用类型属性指向相同内存,存在篡改问题
>
>```js
>//1. 定义父类
>function Parent(){
>   this.name = '努力学习的汪';
>   this.play = [1,2,3];
>}
>//在父类原型上定义一个方法或者属性
>Parent.prototype.getName = function(){return this.name}
>
>//2. 定义子类
>function Child(){
>   //构造函数继承部分  --> 这里会使得子类获得父类本身带有的属性与方法
>   Parent.call(this);
>   this.arr = [9, 8, 7];
>}
>
>//3. 定义一个寄生式继承方法
>function clone(parent,child){
>   //这里改用 Object.create 可以减少组合继承中那多余的一次构造过程
>   child.prototype = Object.create(parent.prototype) //将父类的原型赋给子类的原型
>   //组合继承中的,需要手动挂载构造函数给自身
>   child.prototype.constructor = child; 
>}
>
>//4. 调用一下寄生式继承方法,Parent与Child关联起来,到这步为止,实现了继承
>clone(Parent,Child)
>
>//5.注意:如果要在子类原型上添加属性或者方法,需要等步骤 4 运行完,因为 clone 有覆盖原型的步骤
>Child.prototype.getArr = function(){return this.arr}
>
>//调用
>let child = new Child();
>console.log(child);  //Child {name: '努力学习的汪', play: Array(3), arr: Array(3)}
>console.log(child.getName()); //努力学习的汪
>console.log(child.getArr()); //[9, 8, 7]
>```

#### Ⅳ - ES6的  `extends` 关键字直接实现

>实际上,如果通过转换我们会发现 `extends` 实际采用的也是寄生组合式继承