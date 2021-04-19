# #目录

>[TOC]

## 1、箭头函数写法

```js
const jiantouhanshu : ()=>void =()=>{
    console.log("箭头函数")
}
```

## 2、剩余参数、type、类与继承实现 相关

```ts
const stringArr:string[]=["1","222"]
const undefinedArr:undefined[]=[undefined,undefined]
//开发过程中的代码,当编译成代码后这些代码将不存在
//接口的定义
interface  InterType{
    name:string;
    age:number;
    say():void;
    [propname:string]:any
    select?:number
}
//接口的继承
interface TeacherType extends InterType{
    teach():string
}
//接口的实现
// class implementsInter implements InterType  
class implementsInter implements TeacherType{
    name="洪jl"
    age=18
    select=666
    say(){
        console.log(this.name,"implementsInter")
    }
    teach(){
        return "实现接口升级成了老师 implementsInter"
    }
}
type arrs=(number|string)
//剩余参数声明方式   其中声明了say(),所以必须要有say()方法  这个声明方式并不是元组声明方式,与顺序不一样也可以
type Lady={name:string,age:number,say():void,[propname:string]:any}
let newPro=new implementsInter()

newPro.say()                                                       //1
console.log(newPro.teach())                                        //2

const arr :(arrs) []=[1,'string',111]
const ceshi:Lady[]=[
    {name:"xx",age:18,say(){console.log(this.name)}},
    {name:"第二个名字",age:18,x:20,say(){console.log(this.name)}},
    {name:"第三个名字",age:18,s:"zz",x:"aa",disan:true,say(){console.log(this.name)}}

]
const screenResume=(name:string,age:number,bust:number)=>{
    age<24&& bust >=90 ?console.log(name+"进入面试"):console.log(name+"你被淘汰了")
}

console.log(ceshi)													//3
ceshi[2].say()														//4
/**打印结果
1、 洪jl implementsInter
2、 实现接口升级成了老师 implementsInter
3、 [
  		{ name: 'xx', age: 18, say: [Function: say] },
  		{ name: '第二个名字', age: 18, x: 20, say: [Function: say] },
  		{
  		  name: '第三个名字',
   		 age: 18,
  		  s: 'zz',
   		 x: 'aa',
   		 disan: true,
   		 say: [Function: say]
 		 }
	]
4、 第三个名字
**/
```

## 3、public与private 

```ts
//类的内部和类的外部
//public private 
class Person{
   private name:string="私有的属性名字";
   public sayHello():void{
       console.log(this.name,"  公有打印私有属性方法")
   }
   public  setName(name:string):void{
       this.name=name
   }
}
class Teacher extends Person{
    public sayBye(){
        //只有父类的prblic公有属性才可以子类访问到,所以这里我直接调用父类的打印
        // console.log(super.name,"继承类的公有方法")
      console.log("  这是子类调用的")
        super.sayHello()
    }
}
const person = new Teacher()
person.sayHello()
person.sayBye()
person.setName("洪jl")
person.sayHello()
person.sayBye()
```

## 4、get set readonly 与静态方法  抽象类 

```ts
class Xiaojiejie{
    constructor(private _age:number){}
    /***********  get set  *************/
    get getage(){
        return this._age
    }
    set setage(age:number){
        this._age=age
    }
}
const lili=new Xiaojiejie(18)
lili.setage=18
console.log(lili.getage)
//************static后可以不声明对象直接调用*************/
class Girl{
    static sayLove(){
        return "I love you"
    }
}
console.log(Girl.sayLove())

/******       readonly    ******/
class Person{
    public readonly _name:string
    constructor( name:string){
        this._name=name
    }
    //报错 只读属性不能赋值,除了构造函数刚开始一次
    // set setname(name:string){
    //     this._name=name
    // }
}
/*********        抽象类     *******************/
abstract class Girls{
    abstract skill():void
}
class Waiter extends Girls{
    skill(){   console.log("继承抽象类")}

```

## 5、tsconfig相关

```json
{
    // "include":["demo1.ts"] //什么文件生效,而且只是编译这里面对应js文件
    // "files": ["demo.ts"],//与include相似功能
  // "exclude":["demo.ts"],//除了什么文件生效

  "compilerOptions": {
    // "sourceMap": true,                     /* 打开后t(true)生成.map文件   '.map' file. */
    "outFile": "./build/page.js",      //生成单个文件 但是这个选项一开 module不支持commonjs 需要改成amd
    // "outDir": ".build/",                     /*  输出文件路径 即生成的js文件*/
    // "rootDir": "./src",                        /* 入口文件路径,即ts文件夹 */
                 
    "removeComments": true,                   /*去掉注释*/
        "experimentalDecorators": true,        /* 装饰器开启, */
   /* 是否严格按照ts标准,如果为true,下面的配置将不生效 只有为false,下面的配置才可以生效 **/
    "strict": true,                           /* Enable all strict type-checking options. */
    // "noImplicitAny": false,                 /* 当你设置为false时允许你的注解类型any不用特意标明 */
    // "strictNullChecks": false,              /* 设为false允许所有类型赋值null. */

    // "noUnusedLocals": true,                /* 不与上面的strict相关  打开后,只要是出现没有使用的变量,会进行提示错误 */
  }
}
```

## 6、类型守护(断言)

```ts
interface Waiter {
    anjiao: boolean;
    says: () => {}
}
interface Teacher {
    anjiao: boolean;
    skill: () => {}
}
//类型守护 类型断言 
 function jushi(animal: Waiter | Teacher) {
     if (animal.anjiao) (animal as Teacher).skill()
     else (animal as Waiter).says()
 }
// 类型守护  类的断言  有错误
function jushi1(animal: (Waiter | Teacher)) {
    if ("skill" in animal) { animal.skill(); }
    else { animal.says(); }
}

jushi1({ 
    anjiao: true, 
    skill() {return {} }
 }
    )

//类型判断
function add(first: string | number, second: string | number) {
    if (typeof first === "string" || typeof second === "string") {
        return `${first}${second}`
    }
    return first + second
}
//传入类的类型守护
class NumberOgj {
    count: number=0;
}
function addObj(first: object | NumberOgj, second: object | NumberOgj) {
    if (first instanceof NumberOgj && second instanceof NumberOgj)
        return first.count + second.count
    return 0
}
```

## 7、枚举类型

```ts
//枚举类型用于使用0 1 2 此类状态标志
enum Status {
    hong=1, //可以改变开始的下标 默认从0开始
    ji,
    lin
}
function getName(status: any) {
    switch (status) {
        case Status.hong:
            return status
            break;
        case Status.ji:
            return status
            break;
        case Status.lin:
            return status
            break;
    }
}
console.log(getName(Status.hong))
console.log((Status.ji))
```

## 8、泛型

### 1、泛型基础使用

```ts
//泛型
function join<T>(firts: T, second: T) {
    return `${firts}${second}`
}
console.log(join<string>("x", "s"))
console.log(join<number>(1, 2))//尖括号定义的类型,后面将会使用这个类型
//泛型在数组中的使用
function myFun<T>(params: T[]) {
    return params
}
console.log(myFun<string>(["123","456x"]))
//多个泛型的定义
function join1<T,P>(firts: T, second: P) {
    return `${firts}${second}`
}
console.log(join1<string,number>("x", 1))
//泛型支持类型推断
console.log(join1("x", 1))
```

### 2、泛型使用 泛型继承 泛型约束

```ts
//普通泛型使用
class SelectGirl<T>{
    constructor(private girls: T[]) { }
    getGirl(index: number): T {
        return this.girls[index]
    }
}
const selectGirl = new SelectGirl(["aa", "bb", "cc"])
console.log(selectGirl.getGirl(0))


//泛型继承 这边的值需要有name
interface Girl {
      name: string;
    }
class SelectEx<T extends Girl>{
    constructor(private girls: T[]) { }
    getGirl(index: number): string {
        return this.girls[index].name
    }
}
const selectEx = new SelectEx([
    { name: "洪" },
    { name: "j" },
    { name: "l" }
])

console.log(selectEx.getGirl(0))

//泛型约束
class SelectGirl1<T extends number|string>{
    constructor(private girls: T[]) { }
    getGirl(index: number): T {
        return this.girls[index]
    }
}
const selectGirl1 = new SelectGirl1(["约束", "bb", "cc"])
console.log(selectGirl1.getGirl(0))

```

## 9、命名空间`namespace`

```ts
//命名空间
namespace Comments {
	//子命名空间
    export namespace Sub {
        export class Test { }
    }
	//暴露出去类
    export class Header {
        constructor() {
            const elem = document.createElement("div")
            elem.innerText = "This is Header"
            document.body.appendChild(elem)
        }
    }
    }
    Comments.sub.Test //使用
```

