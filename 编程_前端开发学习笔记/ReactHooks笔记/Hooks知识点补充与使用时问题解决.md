>本人笔记地址分享:[`全部笔记`](https://gitee.com/hongjilin/hongs-study-notes)、[`ReactHooks笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/ReactHooks%E7%AC%94%E8%AE%B0)、[`React笔记`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/React%E7%AC%94%E8%AE%B0))

# #目录

>[TOC]

# 一、知识点补充

## Ⅰ-React的React.FC与React.Component的初步认识

>1. 即`Hooks`与`Component`
>
>2. 正常来讲,尽量使用`	React.FC`

### 1、React.FC<>

>1. `React.FC`是函数式组件，是在TypeScript使用的一个泛型，FC就是FunctionComponent的缩写，事实上`React.FC`可以写成`React.FunctionComponent`：
>
>   ```js
>   const App: React.FunctionComponent<{ message: string }> = ({ message }) => (
>     <div>{message}</div>
>   );
>   ```
>
>2. React.FC 包含了 PropsWithChildren 的泛型，不用显式的声明 props.children 的类型。React.FC<> 对于返回类型是显式的，而普通函数版本是隐式的（否则需要附加注释）。
>
>3. React.FC提供了类型检查和自动完成的静态属性：displayName，propTypes和defaultProps（注意：defaultProps与React.FC结合使用会存在一些问题）。
>
>4. 我们使用React.FC来写 React 组件的时候，是`不能用setState`的，取而代之的是useState()、useEffect等 Hook API。
>
>   ```js
>   ----------------------- 使用方法1 ----------------------------------------
>   const SampleModel: React.FC<{}> = () =>{   //React.FC<>为typescript使用的泛型
>     	const [createModalVisible, handleModalVisible] = useState<boolean>(false); 
>     	return{
>     	{/** 触发模态框**/}
>     	<Button style={{fontSize:'25px'}}  onClick={()=>handleModalVisible(true)} >样例</Button>
>     	{/** 模态框组件**/}
>     	<Model onCancel={() => handleModalVisible(false)} ModalVisible={createModalVisible} /> 
>     }
>   ------------------------- 使用方法2 ----------------------------------------------
>   import React, { FC } from 'react';
>   import { observer, useLocalStore } from 'mobx-react'; //引入mobx状态管理器
>   //组件    
>   const ChannelManager: FC = () => {
>       const store = useLocalStore<Store>(() => new Store());
>       .....
>   }
>   export default observer(ChannelManager);
>   ```

### 2、class xx extends React.Component

>1. 如需定义 class 组件，需要继承 React.Component。React.Component是类组件，在TypeScript中，React.Component是通用类型（aka React.Component<PropType, StateType>），因此要为其提供（可选）prop和state类型参数：
>
>   ```js
>   class SampleModel extends React.Component {
>     state = {  createModalVisible:false, };
>     handleModalVisible =(cVisible:boolean)=>{ this.setState({createModalVisible:cVisible});};
>     return {
>     {/** 触发模态框**/}
>     	<Button onClick={()=>this.handleModalVisible(true)} >样例</Button>
>     	{/** 模态框组件**/}
>     	<Model onCancel={() => handleModalVisible(false)} ModalVisible={this.state.createModalVisible} /> 
>     }
>   ```



------



# 二、使用过程遇到的问题与解决

## Ⅰ-`mobx`中的inject,observer迁移至react Hooks写法

>1. 在package.json中检查依赖版本,是否^消失
>
>"mobx": "^5.15.4", "mobx-react": "^6.1.8",
>
>2. ```js
>    import { inject, observer } from 'mobx-react';
>    const Home:HomeType=({store})=>{
>    console.log(appStore.appName)
>    }
>    //声明函数组件类型
>    type HomeType=(store:any)=>any
>    export default inject('store')(observer(Home));
>  ```
>  ```
>
>  ```
>
>```
>
>```
>
>```
>
>```



