# -----------------------==(VUE拾壹)==-------------------------

# VUEX=day8_19

## 一、VUEX初认知

> *是vue提供的一个跨组件的缓存的组件      *像是服务端的redis*

### (1.1) *如何工作:*

> *与redis基本相同,但它是全局的,因此可以定义方法供全局调用,拿来操作缓存用的*

### (1.2) *什么地方用到*

*在vue-cli的store里存储*

> *数据需要在多个组件(页面)间共享的数据*
>
>   比如token 用户信息 window.localStorage*

### (1.3) *@/store进行引用*

>​     *@是什么?*
>
>​             *是vue定义的路径变量*
>
>​            *为什么定义?*
>
>​            *代码位置变了 引用路径不用变*
>
>​            *因为我们引用的方法是通过相对路径,所以只要使用绝对路径,那么不管他怎么便*
>
>​           *都可以找到*

## 二、自定义vue路径变量

```js
const path = require("path");
module.exports={
    devServer:{
        port:80
    },
    //如果是发布的去掉.map
 productionSourceMap: process.env.NODE_ENV === 'production' ? false : true,
    configureWebpack: (config) => {
        config.resolve = { // 配置解析别名
          extensions: ['.js', '.json', '.vue'],
          alias: {
            '@': path.resolve(__dirname, './src'),
            'components': path.resolve(__dirname, './src/components'),
            'common': path.resolve(__dirname, './src/common'),
            'api': path.resolve(__dirname, './src/api'),
            'router': path.resolve(__dirname, './src/router'),
            'views': path.resolve(__dirname, './src/views'),
            'data': path.resolve(__dirname, './src/data'),
            'public': path.resolve(__dirname, 'public'),
            'static': path.resolve(__dirname, 'static'),
          }
        }
      },
}
```

## 三、为什么用VUEX

> *1. 因为组件之间,兄弟组件和父子组件之间需要传递,我们是同过绑定的方式进行传值*
>
>​            *但是如果没有父子关系,传值十分麻烦*
>
> *2.考虑使用redis*
>
>3.*共享数据区域:所有的组件包括实例都可以直接访问的一块数据区域*
>
>​    *特点:*
>
>​		牵一发而动全身 A=> a=1 <= B C D (a=1)*
>
>​            *B=> a=2 <= A C D (a=2)*

## 四、UVEX使用

### 1.在main.js中注册

```js
import Vue from 'vue'
import App from './App.vue'
import router from './router'
//注册
import store from './store'

window.vm= new Vue({
  //注册
  store,
}).$mount('#app')
//我们指定了替代#app标签
```

### 2.在store文件下的index.js注册与定义

```js
import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    a:1,
    b:2
  },
  mutations: {
    setA(state,...value){
      console.log(value)
      state.a=value
    }
  },
  getters:{
    //state不是我们定义的实参,是vue给我们的
   getA:state=> state.a
  },
})
```

#### (2.1) *state  变量存储的容器*

#### (2.2) *getters 定义用来获取state的值的方法,避免直接获取state*

####  (2.3)*mutations 定义用来操作state的值的方法,避免直接操作state*



### 3.使用

#### (3.1)script导入

```js
<script>
//mapState与mapMutations对应store下面的mutations与state
import {mapState,mapMutations} from 'vuex'
export default {
methods:{
  //后面是别名 前面才是store中定义的setA
  ...mapMutations({setA:'setA'})
      // ...mapMutations(['setA'])
}
  ,computed:{
    // ...mapState({a:'a',b:'b'})
    ...mapState(['a','b'])
  }
}
</script>
```

#### (3.2)组件中直接使用

```html
<template>
  <div id="app">
    <fieldset>
      <legend>VUEX</legend>
      <!-- $代表某些实例 -->
      {{$store.state}}
      {{$store.getters.getA}}
     <button type="button" @click="$store.commit('setA',{a:1,a:2})">修改X</button>
     <button type="button" @click='setA(Date.now())'>修改X1</button>
     <!-- <button type="button" @click="$store.commit('setA',{a:1,a:2})">修改X1</button> -->
    </fieldset>

    <router-view/>
  </div>
</template>

```













