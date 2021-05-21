# #说明

>本工具包是对`localStorage`与`sessionStorage`存取的简单封装,方便使用
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin) 

# 一、`localStorage`简单封装

>1. 实现效果:只是对存入取出时自动转换数据格式,减少代码中操作
>
>2. 代码示例
>
>   ```jsx
>   //LocalStorage.ts
>   const LocalStorage = {
>   set: (name: string, value) => {
>   if (!value) throw new Error('请传入正确的值');
>   if (typeof value === 'object') localStorage.setItem(name, JSON.stringify(value));
>    else localStorage.setItem(name, value);
>   },
> 
>   get: (name: string): any => {
>  	 let temp = localStorage.getItem(name);
>  	 if (temp) {
>  	 try {
>     		temp = JSON.parse(temp);
>   	} catch (err) {
>   		console.error(err);
>  	 }
>   }
>   return temp;
>   },
> 
>   remove: name => {
>   localStorage.removeItem(name);
>   }
>   };
>   
>   export default LocalStorage
>   export{ LocalStorage }
>   ```
> 
>   3. 使用示例
> 
>   ```jsx
>   import { LocalStorage } from '~/utils';
>   LocalStorage.set("KEY", data);//存
>   let data=LocalStorage.get('KEY') //取
>  ```



# 二、`SessionStorage`简单封装

>1. 实现效果:只是对存入取出时自动转换数据格式,减少代码中操作
>2. 代码示例
>
>  ```jsx
>  const SessionStorage = {
>  set: (name: string, value) => {
>  if (!value) throw new Error('请传入正确的值');
>  if (typeof value === 'object')  sessionStorage.setItem(name, JSON.stringify(value));
>   else sessionStorage.setItem(name, value);
>  },
> 
>  get: (name: string): any => {
>  	let temp = sessionStorage.getItem(name);
>  	if (temp) {
>  	try {
> 		temp = JSON.parse(temp);
>  	} catch (err) {
>  		console.error(err);
>  	}
>  }
>  return temp;
>  },
> 
>  remove: name => {
>  sessionStorage.removeItem(name);
>  }
>  };
> export{ SessionStorage }
>  ```
> 
> 2. 调用(同上`localStorage简单封装`)

# 三、两者的全面详细封装

> 此js会将大部分需要的功能封装进来,功能更齐全,此封装函数会用到部分`lodash`函数,当然也只是类似防抖这种小功能,但是别人既然写好的而且写的不错就没必要都用自己写的,当然,类似功能我自己也有封装,详见本人[`自封装JavaScript工具包`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E8%87%AA%E5%B0%81%E8%A3%85utils%E6%88%96%E7%BB%84%E4%BB%B6%E6%95%B4%E5%90%88%E7%AC%94%E8%AE%B0/)

## Ⅰ-实现功能

>
>
>
