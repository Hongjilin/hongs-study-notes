>本人笔记地址分享:[`全部笔记`](https://gitee.com/hongjilin/hongs-study-notes)

# #目录

>[TOC]

# `Mobx`使用与安装

## 一、安装

> 默认安装最新版,目前这是mobx6,这个版本中默认不支持装饰器了

```bash
安装: npm install mobx --save。 React 绑定库: npm install mobx-react --save
```

>这是mobx5安装,这版本默认支持装饰器 (在umi等框架中可能会出现问题,具体解决见踩坑部分的题解决)

```bash
npm i mobx@5.15.7  mobx-react@6.2.5
```

## 二、react中使用Mobx

> ①、使用两个babel插件

```bash
babel/plugin-proposal-decorators
babel/plugin-proposal-class-properties
```

> ②、package.json中的ESLint配置与babel配置

```json
   "parserOptions": { 
   "ecmaFeatures": { "lengacyDecorators": true} //开启检查处理
      },
```

> ③、package.json改动的配置

```json
 //package.json
 "eslintConfig": {
    "parserOptions": {
      "ecmaFeatures": {
        "lengacyDecorators": true
      }
    },
    "extends": [
      "react-app",
      "react-app/jest"
    ]
  },
    "babel": {
      "plugins": [
        ["@babel/plugin-proposal-decorators",
        {
          "legacy": true
        }],
        [
          "@babel/plugin-proposal-class-properties",
            {
              "loose":true
            }
        ]
      ],
      "presets": [
        "react-app"
      ]
    },
```



# `踩坑与解决`

## 问题一、使用@action后数据已经改变,但是页面并没有渲染

> 在新版本中提供了以下的方法

```tsx
class AppStore {
  @observable time = "2019年";
  @observable todos:string[] = ["xxx"]

  @action addTodo=(todo:string)=> {
    this.todos.push(todo)
  }
  @action deleteTodo() {
    this.todos.pop()
  }
  @action resetTodo() {
    this.todos=[]
  }
}
const store = new AppStore()
//监听
makeAutoObservable(store)
export default store
```

## 问题二、声明的computed调用报错

>`报错`Functions are not valid as a React child. This may happen if you return a Component instead of <Component /> from render. Or maybe you meant to call this function rather than return it.

```tsx
  @computed  getdesc(){//错误的
    return `${this.time} 还有${this.todos.length}条未完成`
  }
@computed get getdesc(){//正确的 需要加get定义
    return `${this.time} 还有${this.todos.length}条未完成`
  }
```

## 问题三、ts报错

>Experimental support for decorators is a feature that is subject to change in a future release. Set the `'experimentalDecorators'`option in your 'tsconfig' or 'jsconfig' to remove this warning.
>
>很明显 直接按照报错提示去ts配置文件加一段配置

```json
  "compilerOptions": {
      ...
	"experimentalDecorators":true,
      ...
  }
```

## 问题四、使用mobx5版本出错

> "export 'observerBatchingOptOut' was not found in 'mobx-react-lite'
>
> yarn start后报错  这里怀疑是版本问题

解决:

> 删除整个node_modules文件,并检查package.json文件中的版本,确定版本中有`^`,没有的话加上去,刚开始我就是没有,导致重新安装依赖后仍然报错
>
> ```json
>  "mobx": "^5.15.7",
>  "mobx-react": "^6.2.5",
> ```

