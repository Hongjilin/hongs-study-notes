# 一、mobx中的inject,observer迁移至react Hooks写法

## 依赖库

"mobx": "^5.15.4",
 "mobx-react": "^6.1.8",

## 方法一:

```jsx
import { inject, observer } from 'mobx-react';
const Home:HomeType=({store})=>{
  console.log(appStore.appName)
}
//声明函数组件类型
type HomeType=(store:any)=>any
export default inject('store')(observer(Home));
```

