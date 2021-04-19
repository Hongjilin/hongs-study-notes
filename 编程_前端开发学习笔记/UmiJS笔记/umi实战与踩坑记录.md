>本人笔记地址分享:[`全部笔记`](https://gitee.com/hongjilin/hongs-study-notes)、[`UmiJs学习笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/UmiJS%E7%AC%94%E8%AE%B0)

# #目录

>[TOC]

# 一、创建Umi项目

## 1、创建文件夹,并且进入

```bash
mkdir (文件夹名字) && cd (文件夹名字)
```

## 2、创建umi项目

```bash
$ yarn create @umijs/umi-app // if use yarn  
$ npx @umijs/create-umi-app // if use npm
```

> `踩坑`创建不可以直接选择创建` yarn create umi` 否则默认版本是2+的 
>
> 这时候会发现 使用@关键字等会报错

## 3、项目结构构建成功后输入yarn进行安装依赖

```bash
$ yarn //or   npm i
```

## 4、安装完成后，输入yarn start启动项目。

> 配置成功则出现 http://localhost:8000/ 

# 二、Umi中使用scss

## 1、安装scss依赖

>① 在umi中可以直接使用css，但是并不支持scss，我们需要加两个loader，
>  直接安装 `node-sass和sass-loader` 即可，剩余的事情umi已经帮我们做好了。

```bash
yarn add node-sass sass-loader
```

>② 安装 `@umijs/plugin-sass`

```bash
yarn add  @umijs/plugin-sass
```

>③ 配置`.umirc.ts`

```json
export default defineConfig({
  nodeModulesTransform: {
    type: 'none',
  },
  routes: [
    { path: '/', component: '@/pages/index' },
  ],
  "sass": { }, ///配这里
});
```

>④ 修改`tsconfig.json`  

```json
 开启" jsx"：" react"，
```



## 2、引用方式

##### 2.1、在src/assets下新建文件夹

```
- assets
 +  - img
 +  - css
  +   -style.scss  // 这个样式文件一般来说存放全局的样式
```

在src/pages/index.js 引用style.scss

```ts
import ``'../assets/css/style.scss'``;
```

##### 2.2、在home.js同级新建home.scss 文件

```scss
.home-container{
    .red{
        color:red;
    }
} 
```

在home.js引用，并修改render

```ts
// 第一种使用scss方法
// 使用这种方法的时候样式名称不能用 "-" ，不然在使用的时候会报错
...
import homeStyle from './home.scss';

  render() {
        return (
            <div className={homeStyle.home_container}>
                <p className={homeStyle.red}>Home 页面</p>
            </div>
        );
    }
...
```



# 三、问题与解决

## 1、Ts报错`无法使用 JSX，除非提供了 "--jsx" 标志`

##### ① 解决方法一:(`有坑`)

> 百度到的一个解决方案,可以选择工作区的ts版本 需要4.1之后版本
>
> 但是 他随后提供的npm install --save-dev typescript@next方法有坑 将会安装的同时删除包 
>
> 会导致随后的npm start错误 

```jsx
 npm install --save-dev typescript@next //错误
 //错误解决  删除整个node_modules文件重新yarn(或者npm都可)
```

##### ②解决方法二:

```ts
 修改tsconfig.json  
 开启" jsx"：" react"，
​ 如果仍是报错 重新启动IDE。有时tsconfig.json的更改不会立即生效
```

##### ③ 解决方法三:(本人使用的解决方法)

> 当前两步都做了之后还不生效(第一步切换版本可以不试)
>
> 我发现仍然报错 , 在github查了相关的issue 后发现一个解决方案:
>
> 你可以往项目里面加一个.d.ts文件，代码如下?：

```tsx
    declare module '*.scss';
```

## 2、路由配置报错

> 正确配置代码示例

```tsx
routes: [
    { exact: true, path: '/', redirect: "/index" },
    { exact: true, path: '/index', component: '../pages/index' },
    { exact: true, path: '/users', component: '../pages/components/hometest' },

    {
      path: '/user', component: '../layouts/index', routes: [
        { exact: true, path: '/user/index', component: '../pages/components/test', 
         routes: [{ path: '/user', component: '../layouts/index' }] },
        { exact: true, path: '/user/users', component: '../pages/components/test' }
      ]
    },

    {
      path: '/mag', component: '../layouts/index',
      routes: [
        { exact: true, path: '/mag/index', component: '../pages/index', },
        { exact: true, path: '/mag/users', component: '../pages/components/hometest' }
      ]
    }
  ]
```

## 3、使用scss报错

##### ①问题一:You may need an appropriate loader to handle this file type, currently no loaders are configured to process this file.

> 引入scss后运行yarn start 报错,

##### ②问题二:**Invalid config key: sass**

> 当去百度搜索时提到的解决方案提到需要安装 `node-sass` 和 `sass-loader` 然后再`.umirc.ts`中配置
>
> ```tsx
> {
>   "sass":{ }
> }
> ```
>
> 但是配置完后出现新的问题`Invalid config key: sass`

#### 正确解决方案

> 后来在 github 上 的 umi 下看了几个别人提的 关于 sass配置无效的 issue ,下面有大牛们给出解决方案：
>
> 需要先安装 `@umijs/plugin-sass` 插件

所以，最终的解决方案是：

##### 1.首先，安装 `@umijs/plugin-sass`  命令如下：

```bash
npm install --save @umijs/plugin-sass
```

>注意：
>
>- 安装的必须是 @umijs/plugin-sass, 不要直接写 plugin-sass ,这样的结果不对；
>- 如果安装完后，出现以下这个指令：`npm audit fix` 请`一定要运行下`，不然大概率还会出问题

###### 1.1如果仍报错(忘了运行或者运行后仍报错,可以用yarn)

> ①
>
> ```bash
> npm audit fix
> npm audit fix --force
> npm audit
> ```
>
> ②
>
> ```bash
> 删除已经安装的：node_modules 和 package-lock.json
> 修改 package.json 格式如下
> npm audit fix --force
> npm install
> ```
>
> ③本人使用发现的
>
> ```bash
> //将提示的缺少的包下载  本人出现`Cannot find module 'react'`报错
> yarn add react
> ```

##### 2.如果没有安装请安装

```bash
npm install --save node-sass sass-loader
```

##### 3.最后配置`.umirc.ts`

```ts
export default defineConfig({
  nodeModulesTransform: {
    type: 'none',
  },
  routes: [
    { path: '/', component: '@/pages/index' },
  ],
  "sass": { }, ///配这里
});
```

## 4、获取回调函数的返回值`非umi知识`

>在做react路由鉴权时,我需要进行jwt解密,但是同步解密返回值在回调函数中,所以我将其外部包了一层新的函数,在里面声明变量,通过赋值的方式获得

```tsx
interface resultType{
  err?:string,
  msg?:string,
  decode?:any,
  isLogin?:boolean
}
  
JWT.verify= (token:any,secretkey:any,success:any,error:any)=>{
  let result:resultType={}
  jwt.verify(token,secretkey,(err:any,decode:any)=>{
    if (err) {
        result= ({err:'error',msg:'该token已过期',isLogin:false})
    }else{
        result=({decode,msg:'解密成功',isLogin:true})
    }
})
  return result
}

```

