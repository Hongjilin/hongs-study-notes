# #说明

>本工具包是对`localStorage`与`sessionStorage`存取的简单封装,方便使用
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin) 时间:2021年4月

# 一、`localStorage`简单封装

>1. 实现效果:只是对存入取出时自动转换数据格式,减少代码中操作
>
>2. 代码示例
>
>   ```jsx
>   //LocalStorage.ts
>   const LocalStorage = {
>   set: (name: string, value) => {
>   if (!value) {
>   throw new Error('请传入正确的值');
>   }
>   if (typeof value === 'object') {
>   localStorage.setItem(name, JSON.stringify(value));
>   } else {
>   localStorage.setItem(name, value);
>   }
>   },
>   
>   get: (name: string): any => {
>   let temp = localStorage.getItem(name);
>   if (temp) {
>   try {
>   temp = JSON.parse(temp);
>   } catch (err) {
>   console.error(err);
>   }
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
>   export{
>   LocalStorage
>   }
>   ```
>
>3. 使用示例
>
>   ```jsx
>   import { LocalStorage } from '~/utils';
>   LocalStorage.set("KEY", data);//存
>   let data=LocalStorage.get('KEY') //取
>   ```



# 二、`SessionStorage`简单封装

>1. 实现效果:只是对存入取出时自动转换数据格式,减少代码中操作
>2. 代码示例
>
>  ```jsx
>  const SessionStorage = {
>  set: (name: string, value) => {
>  if (!value) {
>  throw new Error('请传入正确的值');
>  }
>  if (typeof value === 'object') {
>  sessionStorage.setItem(name, JSON.stringify(value));
>  } else {
>  sessionStorage.setItem(name, value);
>  }
>  },
>
>  get: (name: string): any => {
>  let temp = sessionStorage.getItem(name);
>  if (temp) {
>  try {
>  temp = JSON.parse(temp);
>  } catch (err) {
>  console.error(err);
>  }
>  }
>  return temp;
>  },
>
>  remove: name => {
>  sessionStorage.removeItem(name);
>  }
>  };
>  export{
>  SessionStorage
>  }
>  ```
>
>2. 调用(同上`localStorage简单封装`)

# 三、两者的全面封装

