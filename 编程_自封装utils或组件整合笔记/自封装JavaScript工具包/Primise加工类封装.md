# #说明

>各种对于`Promise`操作的封装
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin)

# 一、对`Promise`返回值进行加工

> 传入Primise对象,然后对不同状态的返回值进行格式修改

## Ⅰ-代码示例

>```tsx
>/**
> * @param { Promise } thePromise --必选项:传入一个Promise对象
> * @param { Object= } errorExt - 可以传递给err对象的附加信息
> * @return { Promise }
> */
>export function resToArray<T, U = Error>(
>  thePromise: Promise<T>,
>  errorExt?: object
>): Promise<[U | null, T | undefined]> {
>  return thePromise  //此处是传入的promise对象
>    .then<[null, T]>((data: T) => [null, data]) //当成功时,将结果构造出数组的形式,第一个数据时错误信息
>    .catch<[U, undefined]>((err: U) => { //当失败时,将结果构造成数组的形式
>      if (errorExt)   Object.assign(err, errorExt);
>      return [err, undefined];
>    });
>}
>export default resToArray;
>```

## Ⅱ-使用示例

>```TSX
>import resToArray from '~/utils';
>const [err, response] = await resToArray<any>( axios({...}));                                
>```

