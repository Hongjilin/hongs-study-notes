# -----------------------==(VUE拾)==-------------------------

# export、import、style、render、@自定义路径变量=>day8_18~19

## 一、 导出export

### 1. *export default* 

> *一个js里头只能用一次,且只能导出一个对象或者变量*



### 2.*export {}*

> *可以用多次,每次可以导出多个,导出的不是对象*

## 二、导入import 

### (3.1)export default导入

```js
 import 变量名 from 'js文件'
 变量名=导出的对象
```

### (3.2)*export {}*导入

```js
      类比结构赋值
                 import {变量名1(必须跟export里头的变量一样),变量名2} from 'js文件'
                可以给变量取别名 变量名 as 新的名字 
```

### (3.3)*import css*

> *直接把css的内容引进来*

### (3.4) *import html*

> *直接把内容引进来*

### (3.5) *import js*

> *引进来 export default export{}*

### (3.6)*import vue*

> 引进来的时一个vue组件对象*

## 三、*组件为何可以相互引用*

 *核心原理源于import vue文件 ,会将vue文件的三部曲转换成vue的组件对象*上的组件对象即

>  *1) template标签创建组件*
>
>  2) let login ={*
>
>​            *temolate:'#login'*
>
>​            *data:.....*
>
>​          *}*
>
>  3)*然后通过 components: { login}按需注册*

## 四、Style样式

### (4.1) *scoped 局部生效的原理*

>  *让style里头的css选择器对应的元素共同添加一个唯一的属性标识*

### (4.2)  *lang 指定语言*

>  *如果没有指定相应类型的语种,在低版本的vue-cli与h5中会报错*   



## 五、Main.js中的 *render* 

> *将一个组件完全的替代掉index.html里头的容器标签*
>
>  *替代的原理:*
>
> ​         *根据el指定的容器来进行替代*
>
> ​          旧版本在2.9.6里头仍然时使用el*
>
> ​          *只不过更新的版本使用的时$mount替代el*

### (5.1)*与router-view的区别:*

> *router-view 只是占位符,并不会消失*

### (5.2)rander: h =>h(APP)演变

```js
演变 :rander:function (h) {
                    return h(APP)
                }
                rander(h) {
                    return h(APP)
                }
                rander: (h) =>{
                    return h(APP)
                }
                rander: h =>{
                    return h(APP)
                }
                当函数体的代码只有一行return的代码,那么大括号和return可以省略
                rander : h =>h(APP)
                 =>返回一个渲染后的结果
```

### (5.3)h的含义:

> *h是一个draw的函数 vue提供的*
>
>​          *为什么是一个函数:*
>
>​            *因为h(APP),假如不是函数肯定不能带括号*



## 六、router

>*考虑到router里头在未来的业务拓展的场景*
>
>​      *路由可能会很多 可能会出现子路由的情况**所以借用export/import模块化编程*
>
>​      *-->高内聚低耦合的应用实例*
>
>​        *eg:内聚 :相同功能的聚集在一起   *耦合:不同功能强绑定*























