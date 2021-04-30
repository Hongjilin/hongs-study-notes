# #说明

>此处记录是在以为应用场景在小程序上的、为方便开发而封装的工具包类
>
>[`本人小程序学习笔记分享`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/%E5%BE%AE%E4%BF%A1%E5%B0%8F%E7%A8%8B%E5%BA%8F%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0)

# 一、Primise相关 -`2021`

## 1、Promise 回调转换

>微信小程序的开发中虽然已经支持了ES6语法，但是在微信原生的API中仍然使用的还是ES5的回调函数。所以某些api不支持promise+async+await写法
>
>这个工具类是将其原生的回调函数进行转换

### Ⅰ-Promise 回调转换代码

>`该函数也通用于其他js为基础语言的项目`,但是在小程序中有所需求才写,于是分类至此
>
>相关知识点在[本人Promise系统学习笔记](https://gitee.com/hongjilin/hongs-study-notes/blob/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/Promise%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/A_Promise%E7%B3%BB%E7%BB%9F%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0.md)中的`第一章中的Promise的几个关键问题`内有所记录
>
>```js
>const toPromise = f => {
>    return (params = {}) => {
>      return new Promise((resolve, reject) => {
>        const s = Object.assign(params, {
>          success: v => resolve(v),
>          fail: e => reject(e)
>        });
>        f(s)
>      })
>    }
>  }
>
>export {
>  toPromise
>}; 
>```

### Ⅱ-使用示例

>ps:小程序中使用async、await需开启`增强编译`。
>
>1. 以`wx.request`为示例,本人初学小程序时写的demo,[`源码地址分享`](https://gitee.com/hongjilin/wechat-applet-demo-source-code)
>
>  ```js
>  import { toPromise } from '../../utils/index'
>  const {GbaseUrl} =getApp()
>  Page({
>    onLoad: async function (options) {
>       const params = {
>        inTheaters: {url: `${GbaseUrl}/in_theaters`, method:"get", data: {start: 5, count: 3}},//等同下面
>        comingSoon: {url: `${GbaseUrl}/coming_soon?start=19&count=3` },
>        Top250: {url: `${GbaseUrl}/top250?start=6&count=3`}
>      }
>      let result={}//声明一个对象是为了防止在循环中多次setData导致性能浪费
>      for (const key in params) { 
>        //1. 这个判断是用来防止传入参数错误导致乱加data
>        //2. (await toPromise(wx.request)(params[key]))外层一定要加(),因为我是要其结果的.data属性而不是其回调函数本身
>        if (this.data.hasOwnProperty(key)) result[key]=(await toPromise(wx.request)(params[key]))?.data?.subjects
>        //一般写法  let res=await toPromise(wx.request)(params)
>      }
>      this.setData({...result})
>    },
>  })
>  ```
>
>2. 以`wx.getStorage`为示例,用以展示不同写法的
>
>  ```js
>  import { toPromise } from '../../utils/index'
>  toPromise(wx.getStorage)().then(res=>{
>    console.log(res)
>  }).catch(err=>{
>    console.err(err)
>  })
>  ```