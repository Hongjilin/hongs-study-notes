# A_ES6知识补充与所遇问题

## 一、补充知识

### Ⅰ-ES6小知识点:`连续赋值解构`+重命名

>```js
>	let obj = {a:{b:1}}
>	const {a} = obj; //传统解构赋值
>	const {a:{b}} = obj; //连续解构赋值
>	const {a:{b:value}} = obj; //连续解构赋值+重命名
>```



## 二、问题与解决

### Ⅰ-`import`动态导入图片时报错

>1. 问题一:使用`import a from "@/img/"+url`时报错
>
>   解决:使用const a = require(`@/img/${文件名}${后缀名}`)
>
>2. 问题而:问题一解决后用`require后发现出现警告`
>
>   解决:拼接时将后缀名用写死的方式拼接
>
>   ```js
>   requImg = require(`@/img/${url}.png)
>   ```

