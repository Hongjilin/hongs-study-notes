# Webpack

>本笔记为 观看[尚硅谷的webpack5入门到精通](https://www.bilibili.com/video/BV1e7411j7T5?p=7&spm_id_from=pageDriver) 教学视频整理而成
>
>仅为本人洪方便学习记录
>
>​			 

# 一、Webpack简介

### 1、webpack是什么?

> Webpack是一种前端资源构建工具,一个静态模块打包器(module bundler)
>
> 在 Webpack看来,前端的所有资源文件(js/json/css/img/less/...)都会作为模块处理
>
> 它将根据模块的依赖关系进行静态分析,打包生成对应的静态资源(bundle)

### 2、Webpack的五个核心概念

>1. Entry
>
>   入口指示 Webpack以哪个文件为入口七点开始打包,分析构建内部依赖图
>
>2. Output
>
>   输出指示 Webpack打包后的资源bundles输出到哪里去,以及如何命名
>
>3. Loader
>
>   Loader让Webpack 能够去处理那些非JavaScript文件(webpack自身只理解JavaScrpit)
>
>4. Plugins
>
>   插件可以用于执行范围更广的任务.插件的范围包括,从打包优化和压缩,一直到重新定义环境中的变量等
>
>5. Mode
>
>   模式指示Webpack使用相应模式的配置
>
>| 选项        | 描述                                                         | 特点                       |
>| ----------- | ------------------------------------------------------------ | -------------------------- |
>| development | 会将process.env.NODE_ENV的值设置为development.<br />启用NamedChunksPlugin和NamedModulesPlugin | 能让代码本地调试运行的环境 |
>| production  | 启动好多东西....                                             | 能让代码优化上线运行的环境 |



## 二、Webpack初体验

### 1、安装与使用

>1. 先安装全局webpack包(也可以不安装)
>
>  ```shell
>  npm i webpack webpack-cli -g 
>  ```
>
>2. 初始化项目npm包
>
>  ```shell
>  npm init
>  ```
>
>3. 安装当前项目webpack包
>
>  ```SHELL
>  npm i webpack webpack-cli -D
>  ```

### 2、编译打包应用

>1. 创建相关文件夹与文件(build与src文件加与index.js)
>
>2. 运行指令
>
>   a)开发环境指令:`webpack ./src/index.js -o ./build/built.js --mode=development`
>
>   webpack就会以`./src/index.js`为入口文件开始打包,打包后输出到`./build/built.js`整体打包环境,是开发环境
>
>   b)生产环境指令:`webpack ./src/index.js -o ./build/built.js --mode=production`
>
>   做的都是一样的,环境是生产环境

## 三、webpack.config.js基本配置

### Ⅰ-通用配置

```js
/*
  webpack.config.js  webpack的配置文件
    作用: 指示 webpack 干哪些活（当你运行 webpack 指令时，会加载里面的配置）
    所有构建工具都是基于nodejs平台运行的~模块化默认采用commonjs。
*/
// resolve用来拼接绝对路径的方法
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin'); //plugins需要引入这个插件

module.exports = {
  // webpack配置
  // 入口起点
  entry: './src/index.js',
  // 输出
  output: {
    // 输出文件名
    filename: 'built.js',
    // 输出路径
    // __dirname nodejs的变量，代表当前文件的目录绝对路径
    path: resolve(__dirname, 'build')
  },
  // loader的配置
  //loader: 1. 下载   2. 使用（配置loader）
  module: {
    rules: [
      // 详细loader配置,如样式打包修改这里

    ]
  },
  // plugins的配置
  //plugins: 1. 下载  2. 引入  3. 使用
  plugins: [
    // 详细plugins的配置 如:html打包配置这里
  ],
  // 模式
  mode: 'development', // 开发模式
  // mode: 'production'
}
```

### Ⅱ-打包样式资源

```js
// loader的配置,样式打包改这里
  module: {
    rules: [
      // 详细loader配置
      // 不同文件必须配置不同loader处理
      {
        // 匹配哪些文件
        test: /\.css$/,
        // 使用哪些loader进行处理
        use: [
          //需要下载style-loader与css-loader
          // use数组中loader执行顺序：从右到左，从下到上 依次执行
          // 创建style标签，将js中的样式资源插入进行，添加到head中生效
          'style-loader',
          // 将css文件变成commonjs模块加载js中，里面内容是样式字符串
          'css-loader'
        ]
      },
      {
        test: /\.less$/,
        use: [
          'style-loader',
          'css-loader',
          // 将less文件编译成css文件
          // 需要下载 less-loader和less
          'less-loader'
        ]
      }
    ]
  },

```

>1. `loader`的配置:rules执行顺序是从下往上,从右往左执行
>2. `css`需要下载依赖``npm i  style-loader css-loader -D` 
>3. 使用`less`的时候需要在上面css依赖基础上再下载`npm i less-loader less -D`

### Ⅲ-打包html

```js
 const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin'); //需要引入这个插件


plugins: [
    // plugins的配置
    // html-webpack-plugin
    // 功能：默认会创建一个空的HTML，自动引入打包输出的所有资源（JS/CSS）
    // 需求：需要有结构的HTML文件
    new HtmlWebpackPlugin({
      // 复制 './src/index.html' 文件，并自动引入打包输出的所有资源（JS/CSS）
      template: './src/index.html'
    })
  ],
```

>plugins打包html需要下载依赖:`npm i html-webpack-plugin -D`

### Ⅳ-打包图片资源

```js
  module: {
    rules: [
      {
        test: /\.less$/,
        // 要使用多个loader处理用use
        use: ['style-loader', 'css-loader', 'less-loader']
      },
      {
        // 问题：默认处理不了html中img图片
        // 处理图片资源
        test: /\.(jpg|png|gif)$/,
        // 使用一个loader
        // 下载 url-loader file-loader
        loader: 'url-loader',
        options: {
          // 图片大小小于8kb，就会被base64处理
          // 优点: 减少请求数量（减轻服务器压力）
          // 缺点：图片体积会更大（文件请求速度更慢）
          limit: 8 * 1024,
          // 问题：因为url-loader默认使用es6模块化解析，而html-loader引入图片是commonjs
          // 解析时会出问题：[object Module]
          // 解决：关闭url-loader的es6模块化，使用commonjs解析
          esModule: false,
          // 给图片进行重命名
          // [hash:10]取图片的hash的前10位
          // [ext]取文件原来扩展名
          name: '[hash:10].[ext]'
        }
      },
      {
        test: /\.html$/,
        // 处理html文件的img图片（负责引入img，从而能被url-loader进行处理）
        loader: 'html-loader'
      }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/index.html'
    })
  ],
```

>ps:`url-loader  file-loade`r与`html-loader`都需要下载依赖
>
>1. 问题一:只设置一个`test{/\.(jpg|png|gif)$/} ,loader:'url-loader'`,,默认处理不了html中img图片,html中仍然是`./src/img.jpg`
>
>   解: 需要再引入`test:{/\.html$/},才可以,但是这时候解析时会出问题：html的图片路径编程`[object Module]`
>
>2. 问题二:html的图片路径变成`[object Module]`
>
>   分析: 因为url-loader默认使用`es6模块化解析`，而html-loader引入图片是`commonjs`,所以解析时用的es6模块化解析,出现问题
>
>   解决:关闭`options`中的url-loader的es6模块化,使用commonjs解析 `options:{esModule: false}` 

### Ⅴ-打包其他资源

>`exclude`:指定除此之外的资源

```js
  module: {
    rules: [
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
      },
      // 打包其他资源(除了html/js/css资源以外的资源)
      {
        // 排除css/js/html资源
        exclude: /\.(css|js|html|less)$/,
        loader: 'file-loader',
        options: {
          name: '[hash:10].[ext]'
        }
      }
    ]
  },
```

### Ⅵ-热更新 devServer

>热更新需要下载依赖 : `npm i webpack-dev-server -D`
>
>启动devServer指令为：`npx webpack-dev-server`
>
>只会在内存中编译打包，不会有任何输出

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './src/index.js',
  output: {},
  module: {},
  plugins: [ ],
  mode: 'development',

  // 开发服务器 devServer：用来自动化（自动编译，自动打开浏览器，自动刷新浏览器~~）
  // 特点：只会在内存中编译打包，不会有任何输出
  // 启动devServer指令为：npx webpack-dev-server
  devServer: {
    // 项目构建后路径
    contentBase: resolve(__dirname, 'build'),
    // 启动gzip压缩
    compress: true,
    // 端口号
    port: 3000,
    // 自动打开浏览器
    open: true
  }
};
```











