# #说明

>React中 可以处理 setInterval 的 Hook, 此处为ahooks的摘录

# 一、直接上代码

```ts
import { useEffect, useRef } from 'react';

function useInterval(
  fn: () => void,
  delay: number | null | undefined,
  options?: {
    immediate?: boolean;
  },
): void {
  const immediate = options?.immediate;

  const fnRef = useRef<() => void >();
  fnRef.current = fn;

  useEffect(() => {
    if (delay === undefined || delay === null) return;
    if (immediate) {
      fnRef.current?.();
    }
    const timer = setInterval(() => {
      fnRef.current?.();
    }, delay);
    return () => {
      clearInterval(timer);
    };
  }, [delay]);
}

export default useInterval;
```

# 二、解释

### Ⅰ - useRef

>```tsx
>const refContainer = useRef(initialValue);
>```
>
>`useRef` 返回一个可变的 ref 对象，其 `.current` 属性被初始化为传入的参数（`initialValue`）。返回的 ref 对象在组件的整个生命周期内持续存在。
>
>一个常见的用例便是命令式地访问子组件：
>
>```tsx
>function TextInputWithFocusButton() {
>  const inputEl = useRef(null);
>  const onButtonClick = () => {
>    // `current` 指向已挂载到 DOM 上的文本输入元素
>    inputEl.current.focus();
>  };
>  return (
>    <>
>      <input ref={inputEl} type="text" />
>      <button onClick={onButtonClick}>Focus the input</button>
>    </>
>  );
>}
>```
>
>本质上，`useRef` 就像是可以在其 `.current` 属性中保存一个可变值的“盒子”。
>
>你应该熟悉 ref 这一种[访问 DOM](https://zh-hans.reactjs.org/docs/refs-and-the-dom.html) 的主要方式。如果你将 ref 对象以 `<div ref={myRef} />` 形式传入组件，则无论该节点如何改变，React 都会将 ref 对象的 `.current` 属性设置为相应的 DOM 节点。
>
>然而，`useRef()` 比 `ref` 属性更有用。它可以[很方便地保存任何可变值](https://zh-hans.reactjs.org/docs/hooks-faq.html#is-there-something-like-instance-variables)，其类似于在 class 中使用实例字段的方式。
>
>这是因为它创建的是一个普通 Javascript 对象。而 `useRef()` 和自建一个 `{current: ...}` 对象的唯一区别是，`useRef` 会在每次渲染时返回同一个 ref 对象。
>
>请记住，当 ref 对象内容发生变化时，`useRef` 并*不会*通知你。变更 `.current` 属性不会引发组件重新渲染。如果想要在 React 绑定或解绑 DOM 节点的 ref 时运行某些代码，则需要使用[回调 ref](https://zh-hans.reactjs.org/docs/hooks-faq.html#how-can-i-measure-a-dom-node) 来实现。

# 三、使用

>```tsx
>import React, { useState } from 'react';
>import { useInterval } from 'useInterval';
>
>export default () => {
>  const [count, setCount] = useState(0);
>  const [interval, setInterval] = useState(1000);
>
>  useInterval(
>    () => {
>      setCount(count + 1);
>    },
>    interval,
>    { immediate: true },
>  );
>
>  return (
>    <div>
>      <p> count: {count} </p>
>      <p style={{ marginTop: 16 }}> interval: {interval} </p>
>      <button onClick={() => setInterval(interval + 1000)} style={{ marginRight: 8 }}>
>        interval + 1000
>      </button>
>      <button
>        style={{ marginRight: 8 }}
>        onClick={() => {
>          setInterval(1000);
>        }}
>      >
>        reset interval
>      </button>
>      <button
>        onClick={() => {
>          setInterval(null);
>        }}
>      >
>        clear
>      </button>
>    </div>
>  );
>};
>```
>
>