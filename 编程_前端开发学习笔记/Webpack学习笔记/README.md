# #此文件为方便gitee网站观阅使用专门创建

> 此笔记文件于某一时间截取复制至此,容易存在更新不及时问题,建议观看同级目录下的笔记文件
>
> 此部分为上面的`webpack基础学习笔记`部分,复制到此方便网站中阅读
>
> 除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、 **[ReactHooks笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ReactHooks笔记)** 、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了

# #说明

>本笔记为 观看 `尚硅谷的webpack5入门到精通` 教学视频整理而成
>
>说明:
>
>​	个人认为虽然这个视频名字是`从webpack5入门到精通` ,但是学下来内容应该是基于`webpack4`讲解,学完感觉刚入门webpack,只会简单使用webpack罢了,所以这部分我归类于`webpack的基础学习`. 真要精通,需要看官网以及其他学习资源,再多动手才行.所以接下去我将直接进入`webpack高级进阶阶段`学习,这部分应该是`webpack5`,介于本笔记已经内容过长,将新开高阶笔记,这里说一句,尚硅谷的视频还真的挺不错的,建议可以去看看
>
>​	本知识点配置代码多,为了节约空间,后面的`配置部分`的配置代码,默认是基于上一个代码增加修改(`优化`部分基于`生产或者开发环境配置`代码进行优化),只写出新增或者修改部分(最后会在每部分最后一章写出完整配置在`代码),如有其他情况将在其代码示例或其上方注释指出
>
>
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



### 3、Webpack初体验

#### Ⅰ、安装与使用

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

#### Ⅱ、编译打包应用

>1. 创建相关文件夹与文件(build与src文件加与index.js)
>
>2. 运行指令
>
>  a)开发环境指令:`webpack ./src/index.js -o ./build/built.js --mode=development`
>
>  webpack就会以`./src/index.js`为入口文件开始打包,打包后输出到`./build/built.js`整体打包环境,是开发环境
>
>  b)生产环境指令:`webpack ./src/index.js -o ./build/built.js --mode=production`
>
>  做的都是一样的,环境是生产环境
>
>  c)当配置文件写好后,可以直接使用`webpack`指令进行打包

------



------



# 二、Webpack配置详解

> 1、在学习过程中这部分本是最后学习的,但本人认为可先放前面,先了解后再去使用.
>
> ​	建议:`二`--> `三` --> `四` --> `二`  顺序翻阅,先粗略过一遍`二`,有不懂的留着疑惑看二、三,最后再回头看这里
>
> 2、webpack配置实际是创建一个对象,所以里面的属性并没有执行顺序,即使你将`entry`写在`output`下面都可以执行,因为到时候执行的时候是webpack通过调用对象属性进行实现顺序的

### Ⅰ- entry

>entry:`入口起点`,有三种形式写法
>
>1、`string` --> './src/index.js'
>
>​	单入口:打包形成一个chunk(模块),输出一个bundle(包)文件
>
>​	此时默认的chunk名称是main
>
>2、`array` --> ['./src/index.js','./src/add.js']
>
>​	多入口:所有入口文件最终只会形成一个chunk,输出出去只有一个bundle文件(类似将add.js打包进index.js中)
>
>​	-->通常只有在`HMR功能中使用`, 让html热更新生效使用
>
>3、`object` --> {index:'./src/index.js',add:'./src/add.js'}
>
>​	多入口:有几个入口文件就形成几个chunk,输出几个bundle文件
>
>​	此时chunk名称是 key

> 4、特殊用法(混合使用)  
>
> ​	通常在`dll`优化功能中使用

```js
module.exports = {
  entry: {
      // 所有入口文件最终只会形成一个chunk, 输出出去只有一个bundle文件。
    index: ['./src/index.js', './src/count.js'], 
       // 形成一个chunk，输出一个bundle文件。
    add: './src/add.js'
  },
  output: {
    filename: '[name].js',
    path: resolve(__dirname, 'build')
  },
  plugins: [new HtmlWebpackPlugin()],
  mode: 'development'
};

```

### Ⅱ- output

>使用entry为`单入口`为例讲解
>
>1、`filename`:文件名称（指定名称+目录）
>
>2、`chunkFilename`:非入口chunk的名称,如未指定这项,在入口文件中导入的js打包也会用上`filename`的文件名称进行命名,但是名字与入口文件冲突,就会使用0~∞数字命名,不容易区分
>
>3、`path`:输出文件目录(将来所有资源输出的公共目录)
>
>4、`publicPath`:所有资源引入公共路径的前缀 -- 'img/a.jpg'-->'/img/a.jpg'  这个适合`生产环境使用`
>
>​	这两者变化区别:前者是将`imgs`目录跟在当前目录路径后面,后者是将imgs跟在服务器地址后面
>
>5、`library:'[name]'`  //整个库向外暴露的变量名 实际上使用`var声明`
>
>6、`libraryTarget`:将变量名添加到哪个对象上
>
>​	a) libraryTarget: 'window' 适合浏览器端
>
>​	b) libraryTarget: 'global' 适合node
>
>​	c) libraryTarget: 'commonjs' 使用commonjs方式进行模块导出

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './src/index.js',
  output: {
    // 文件名称（指定名称+目录）
    filename: 'js/[name].js',
    // 输出文件目录（将来所有资源输出的公共目录）
    path: resolve(__dirname, 'build'),
    // 所有资源引入公共路径前缀 --> 'imgs/a.jpg' --> '/imgs/a.jpg' 适合生产环境使用, 
     // 这两者地址区别:前者是将imgs目录跟在当前目录后面 ,后者是将imgs跟在服务器地址后面
    publicPath: '/',
    chunkFilename: 'js/[name]_chunk.js', // 非入口chunk的名称
    // library: '[name]', // 整个库向外暴露的变量名  定义为var
    // libraryTarget: 'window' // 变量名添加到哪个上 browser(适用浏览器端)
    // libraryTarget: 'global' // 变量名添加到哪个上 node(适用node服务端)
    // libraryTarget: 'commonjs' //使用commonjs的方式模块导出
  },
  plugins: [new HtmlWebpackPlugin()],
  mode: 'development'
};

```

### Ⅲ- module

>1、`test`:文件名匹配规则,后面参数是一个正则
>
>2、`exclude`:排除匹配某个目录下的内容 -->  exclude: /node_modules/ ->排除node_modules下的文件
>
>3、`include`:只检查 某个目录下的文件 --> include: resolve(__dirname, 'src') ->只检查 src 下的js文件
>
>4、`loader`与`use`:单个loader使用`loader`,多个loader用`use`
>
>5、`enforce`:指定该配置的执行顺序:  enforce:'`pre`'(优先执行) > 默认 > enforce:'`post`'(延后执行)
>
>6、`options`:指定这个loader的配置选项
>
>7、` oneOf: []`:里面的配置只会生效一次,即里面有100个配置,当我一个文件进入这里检测,可能第10个配置匹配到了就生效,然后该文件就不会进行下面90次匹配,如果是不放` oneOf`里面的配置,就会完全执行100次匹配,性能优化使用
>
>​	该部分知识在`优化`部分:当你使用enlint与babel两种配置进行对于js文件的匹配的情景下会使用

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './src/index.js',
  output: {
    filename: 'js/[name].js',
    path: resolve(__dirname, 'build')
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        // 排除node_modules下的js文件
        exclude: /node_modules/,
        // 只检查 src 下的js文件
        include: resolve(__dirname, 'src'),
        // 单个loader用loader
        loader: 'eslint-loader',
        // 多个loader用use
        //use: ['style-loader', 'css-loader']
        // 优先执行
        enforce: 'pre',
        // 延后执行
        // enforce: 'post',
        //指定这个loader的配置选项
        options: {}
      },
      {
        // 以下配置只会生效一个
        oneOf: []
      }
    ]
  },
  plugins: [new HtmlWebpackPlugin()],
  mode: 'development'
};
```

### Ⅳ- resolve

>该resolve`并不是path`的relove,而是配置中的resolve配置项:`解析模块的规则`
>
>1、`alias`:配置解析模块路径别名: 优点简写路径 缺点路径没有提示
>
>2、`extensions`:配置省略文件路径的后缀名
>
>3、`modules`:告诉webpack解析模块是去哪个目录 -->如果不指定会webpack会一层一层往外找,造成不必要的性能浪费

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './src/js/index.js',
  output: {},
  module: {
    rules: [ ]
  },
  plugins: [new HtmlWebpackPlugin()],
  mode: 'development',
  // 解析模块的规则
  resolve: {
    // 配置解析模块路径别名: 优点简写路径 缺点路径没有提示
    alias: {
      $css: resolve(__dirname, 'src/css')
    },
    // 配置省略文件路径的后缀名
    extensions: ['.js', '.json', '.jsx', '.css'],
    // 告诉 webpack 解析模块是去找哪个目录
    modules: [resolve(__dirname, '../../node_modules'), 'node_modules']
  }
};
```

> 配置后js引用示例代码

```js
import '$css/index';
```

### Ⅴ- devServer

>这部分配置很多,只抽出我觉得比较重要的部分
>
>1、`proxy`:服务器代理 -->解决开发环境跨域问题
>
>​	① target: 一旦devserver服务器接收到`/接口名/xxx`,就会把请求转发到`target`后面的参数url服务器上
>
>​	② pathRewrite:发送请求时,请求路径重写 --> 如:将/api/xxx ->/xxx(去掉前面的/api)
>
>2、`contentBase`:指定运行代码的目录
>
>3、`hot`:开启`HMR模块热替换`,这是优化部分功能
>
>4、`overlay`:当设置为`false`时,如果代码错误,不要进行全屏提示
>
>5、`watchContentBase`:当设置为`true`时,监听contentBase目录下的所有文件 一旦文件变化就会reload
>
>6、`watchOptions`:内部设置监听的忽略文件,通常与`5`搭配使用
>
>7、`compress`:是否开启`gzip`压缩

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  devServer: {
    // 运行代码的目录
    contentBase: resolve(__dirname, 'build'),
    // 监视 contentBase 目录下的所有文件，一旦文件变化就会 reload
    watchContentBase: true,
    watchOptions: {
      // 忽略文件
      ignored: /node_modules/
    },
    // 启动gzip压缩
    compress: true,
    // 端口号
    port: 5000,
    // 域名
    host: 'localhost',
    // 自动打开浏览器
    open: true,
    // 开启HMR功能
    hot: true,
    // 不要显示启动服务器日志信息
    clientLogLevel: 'none',
    // 除了一些基本启动信息以外，其他内容都不要显示
    quiet: true,
    // 如果出错了，不要全屏提示~
    overlay: false,
    // 服务器代理 --> 解决开发环境跨域问题
    proxy: {
      // 一旦devServer(5000)服务器接受到 /api/xxx 的请求，就会把请求转发到另外一个服务器(3000)
      '/api': {
        target: 'http://localhost:3000',
        // 发送请求时，请求路径重写：将 /api/xxx --> /xxx （去掉/api）
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
};
```

### Ⅵ- optimization

>主要用于优化部分的`code split` -->代码分割,这个需要先看优化部分的代码分割后再翻阅
>
>1、`splitChunks`:开启代码分割
>
>2、`runtimeChunk`:将当前模块的记录其他模块的hash单独打包为一个文件 runtime
>
>​	解决的问题:当你修改a文件后,因为你使用的是`contenthash`作为文件名,它根据内容会生成不同的哈希值,所以你a文件文件名将会变化.而如果你在b文件中导入a文件,b文件就会因为a文件的文件名变化导致b文件自己内容也跟着变化(即使你对b文件无任何修改),导致b文件也会`重新打包,缓存失效`
>
>​	解决原理:将当前模块的记录其他模块的hash单独打包为一个文件
>
>3、`terser-webpack-plugin`:当你的webpack版本在4.26以上,它使用的是`terser`的库进行压缩,要使用的时候需要`下载依赖`,且如果要优化压缩速度,需要修改里面配置,否则会使用默认配置

```js
const TerserWebpackPlugin = require('terser-webpack-plugin')
module.exports = {
    entry: './src/js/index.js',
  output: {
    filename: 'js/[name].[contenthash:10].js',
    path: resolve(__dirname, 'build'),
    chunkFilename: 'js/[name].[contenthash:10]_chunk.js'
  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
      }
    ]
  },
  plugins: [new HtmlWebpackPlugin()],
  mode: 'production',
  resolve: {
    alias: {
      $css: resolve(__dirname, 'src/css')
    },
    extensions: ['.js', '.json', '.jsx', '.css'],
    modules: [resolve(__dirname, '../../node_modules'), 'node_modules']
  },
    
  optimization: {
    splitChunks: {
      chunks: 'all'
        
      // 下面的是默认值，当你启用上面哪个`all`后,可以不写、一般也不进行修改
    ---------------------------------------------------------------------------    
       minSize: 30 * 1024, // 分割的chunk最小为30kb
      maxSize: 0, // 最大没有限制
      minChunks: 1, // 要提取的chunk最少被引用1次,如果少于1次,就不提取了
      maxAsyncRequests: 5, // 按需加载时并行加载的文件的最大数量
      maxInitialRequests: 3, // 入口js文件最大并行请求数量
      automaticNameDelimiter: '~', // 名称连接符
      name: true, // 可以使用命名规则
      cacheGroups: {
        // 分割chunk的组
        // node_modules文件会被打包到 vendors 组的chunk中。--> vendors~xxx.js
        // 满足上面的公共规则，如：大小超过30kb，至少被引用一次。
        vendors: {
          test: /[\\/]node_modules[\\/]/,
          // 优先级
          priority: -10
        },
        default: {
          // 要提取的chunk最少被引用2次
          minChunks: 2,
          // 优先级
          priority: -20,
          // 如果当前要打包的模块，和之前已经被提取的模块是同一个，就会复用，而不是重新打包模块
          reuseExistingChunk: true
        } 
  --------------------------------------------------------------------------------------------    
      }
    },
    // 将当前模块的记录其他模块的hash单独打包为一个文件 runtime
    // 解决：修改a文件导致b文件的contenthash变化
    runtimeChunk: {
      name: entrypoint => `runtime-${entrypoint.name}`
    },
    minimizer: [
      // 配置生产环境的压缩方案：js和css
      new TerserWebpackPlugin({
        // 开启缓存
        cache: true,
        // 开启多进程打包
        parallel: true,
        // 启动source-map
        sourceMap: true
      })
    ]
  }
};
```



------



------



# 三、Webpack.config.js基本配置学习

> 详细参数部分见下面内容的`webpack配置详解`
>
> 1、module:moudle对应loader（加载器 ）的配置，主要对指定类型的文件进行操作
>
> ​     `举例`：js类型的文件和css文件需要不同的loader来处理。最常用的加载器是eslint-loader和babel-loader。
>
> 2、Plugin: plugins用于扩展webpack的功能，相比着loader更加灵活，不用指定文件类型
>
> ​	 `举例`:html-webpack-plugin、commonChunkPlugin和ExtractTextPlugin
>
> 3、Output: 指定输出编译后代码的位置。 
>
> ​	 `注意`：即使指定了多个入口点（entry points），Ouput配置项也只能设置一个。
>
> 4、mode:指定模式:`开发模式(development)` 和`生产模式(production)`
>
> ​     `注意`:生产模式`默认会压缩js文件`
>
> 5、loader:当引用多个loader时,使用`use["loader名1","loader名2"]`形式引入,单个时使用`loader:'loader名'`形式

> 注意:
>
>  1、`loader`的配置:rules执行顺序是从`下往上,从右往左`执行
>
>  2、对于rules中的loader，webpack还定义了一个属性 enforce，可取值有 `pre`（为pre loader）、`post`（为post loader），如果没有值则 
>
> 为（normal loader）。**所以loader在webpack中有4种:normal，inline，pre，post**。



## 1、开发环境配置部分

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

### Ⅶ-开发环境配置

```js
const { resolve} = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')

module.exports = {
  entry: './src/js/index.js',
  output: {
    filename: 'js/built.js',
    path: resolve(__dirname, 'build')
  },
  
  module: {
    rules: [{
        //1.1 处理less资源
        test: /\.less$/,
        use: [ 'style-loader','css-loader', 'less-loader' ]
      },
      {
        //1.2 处理css资源
        test: /\.css$/,
        use: [ 'style-loader', 'css-loader' ]
      },
      {
        //2.1 处理图片资源
        test: /\.(jpg|png|gif)$/,
        loader: 'url-loader',
        options: {
          limit: 8 * 1024,
          //压缩后的文件名   压缩后保留后缀名
          name: '[hash:10].[ext]',
          //关闭es6模块化
          esModule: false,
          //在built文件中输入位置,这里是放在build中的imgs文件夹中
          outputPath: 'imgs'
        }
      },
      {
        //2.2 处理html中的图片资源
        test: /\.html$/,
        loader: 'html-loader',
      },
      {
        //处理其他资源 先排除以下几个
        exclude: /\.(html|js|css|less|jpg|png|gif)/,
        loader: 'file-loader',
        options: { name: '[hash:10].[ext]', outputPath: 'media' }
      }
    ]
  },
  plugins: [
    //插件的配置
    new HtmlWebpackPlugin({//打包HTML文件
      template: './src/index.html'
    })
  ],
  //指定开发模式
  mode: 'development',
  //热更新配置
  devServer: {
    contentBase: resolve(__dirname, 'build'),
    compress: true,
    port: 3000,
    open: true
  }

}
```



## 2、生产环境配置部分

### Ⅰ-提取css成单独文件

>1、抽出成css文件: `防止闪屏现象`
>
>​			因为之前是压缩到js中,当页面加载完后用js进行渲染,当性能不够好时可能出现闪屏现象
>
>​			抽出成css后用link引入,就不会出现这个现象
>
>2、需要下载依赖:`npm i mini-css-extract-plugin`
>
>3、使用` mini-css-extract-plugin`插件,然后用使用这个插件的`loader`取代`style-loader`

```js
const HtmlWebpackPlugin = require('html-webpack-plugin');
const {resolve}=require('path');
//下载依赖mini-css-extract-plugin
//将css提取为单独插件
const MiniCssExtractPlugin=require('mini-css-extract-plugin')
module.exports={
  entry:'./src/js/index.js',
  output:{
    filename:'js/built.js',
    path:resolve(__dirname,'build')
  },
  module:{
    rules:[{
        test:/\.css$/,
        use:[
        //创建style标签 'style-loader',
        //使用这个插件的loader取代style-loader 作用:提取js中的css成单独文件
         MiniCssExtractPlugin.loader,
          //将css文件整合到js文件中
          'css-loader']
  }]},
  mode:'development',
  plugins:[
    new HtmlWebpackPlugin({ template:'./src/index.html' }),
    //对输出的文件进行重命名
    new MiniCssExtractPlugin({ filename:'css/built.css'})
  ]
}
```

### Ⅱ-css兼容性处理

>1、需要依赖postcss-->`postcss-loader`和 `postcss-preset-env`
>
>2、需要修改package.json文件
>
>3、需要设置`nodejs的环境变量`
>
>4、此处有可能出现问题,问题记载于`下方问题解决部分`

```js
const HtmlWebpackPlugin = require('html-webpack-plugin')
const MiniCssExtractPlugin = require('mini-css-extract-plugin')
const {
  resolve
} = require('path')
//设置nodejs环境变量
process.env.NODE_ENV='development'
module.exports = {
  entry: './src/js/index.js',
  output: {
    filename: 'js/built.js',
    path: resolve(__dirname, 'build')
  },
  module: {
    rules: [{
      test: /\.css$/,
      use: [MiniCssExtractPlugin.loader, 'css-loader',
        {
          // 1、使用loader的默认配置写法  --> 'postcss-loader'
          // 2、修改loader的配置写法 
          loader: 'postcss-loader',
          options: {
            ident: 'postcss',
            plugins: () => [
              //使用postcss的插件进行兼容性处理
              require('postcss-preset-env')()
            ]
           //如果没效果用下面的   postcssOptions: {  plugins: [【'postcss-preset-env',{}】] }
           //如果{}中不需要再传入options,可以这样 plugins: 【'postcss-preset-env'】 
          }
        }
      ]
    }]
  },
  mode: 'development',
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/index.html'
    }),
    new MiniCssExtractPlugin({
      filename: 'css/built.css'
    })
  ]
}
```

> `默认是生产环境`,所以使用开发环境的时候需要设置nodejs环境

```json
  "browserslist": {
    "development": [
      "last 1 chrome version",
      "last 1 firefox version",
      "last 1 safari version"
    ],
    "production": [
      ">0.2%",
      "not dead",
      "not op_mini all"
    ]
  },
```

### Ⅲ-css压缩

>1、压缩通常用的插件`plugins`,而兼容性处理之类的都使用`loader`来做
>
>2、下载依赖:`optimize-css-assets-webpack-plugin`

```js
 const OptimizeCssAssetsWebpackPlugin = require('optimize-css-assets-webpack-plugin')
 // 压缩css
  plugins: [
     // 压缩css
     new OptimizeCssAssetsWebpackPlugin()
  ]
```

### Ⅳ-js代码检查 _`eslint`

>1、语法检查依赖 `eslint-loader`和`eslint`
>
>2、airbnb规则依赖:`eslint-config-airbnb-base`和 `eslint-plugin-import`
>
>3、 `注意`：只检查自己写的源代码，第三方的库是不用检查的
>
>4、设置`package.json`中eslintConfig
>
>5、当某些地方代码只是测试使用,不想被eslint检测 :下一行eslint所有规则都失效（下一行不进行eslint检查）
>
>​	使用注释`//eslint-disable-next-line`

> webpack.config.js配置

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
module.exports = {
  entry: './src/js/index.js',
  output: { },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: 'eslint-loader',
        options: {
          // 自动修复eslint的错误
          fix: true
        }
      }
    ]
  },
  plugins: [ ],
  mode: 'development'
};
```

>package.json配置
>
>`airbnb`是相对热门的模板

```json
  "eslintConfig": {
    "extends": "airbnb-base",
    "env": {
      "browser": true
    }
  },
```

> 当你想在文件中`跳过检测`时 :下一行eslint所有规则都失效（下一行不进行eslint检查）

```js
// eslint-disable-next-line
console.log(add(2, 5));
```

### Ⅴ-js兼容性处理_`babel`

>js兼容性处理的三种方式:
>
> 1、基本js兼容性处理 -->`@babel/preset-env`
>
>   问题:只能转换基本语法,比如promise等高级语法不能转换
>
> 2、全部js兼容性处理 -->`@babel/polyfill ` 
>
>   使用: js代码中直接导入:`import '@babel/polyfill';`
>
>   问题: 我只要解决部分的兼容性问题,但是将所有兼容性代码全部引入,体积太大了
>
> 3、需要做兼容性处理的就做:按需加载:`core-js`  --------> `最为推荐`
>
>依赖四个下载:`babel-loader`、 `@babel/core`、 `@babel/polyfill` 、`core-js`

```js
const {
  resolve
} = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')

module.exports = {
  entry: './src/js/index.js',
  output: {
    filename: 'js/built.js',
    path: resolve(__dirname, 'build')
  },
  module:{
    rules:[
      {
        test:/\.js$/,
        exclude:/node_modules/,
        loader:'babel-loader',
        options:{
          //预设,存放的是数组,而不是对象,所以里面第一层是[]而不是{}
         presets:[[
           //预设用什么模板
          '@babel/preset-env',
          {
            //使用内置对象:按需加载
            useBuiltIns:'usage',
            //指定core-js版本
            corejs:{
              version:3
            },
            //指定兼容性做到哪个版本浏览器 
            targets:{
              chrome:'60',
              firefox:'60',
              ie:'9',
              safari:'10',
              edge:'17'
            }
          }
         ]]
        }
      }
    ]
  },
  plugins:[
    new HtmlWebpackPlugin({
      template:'./src/index.html'
    })
  ],
  mode:'development'
}
```

### Ⅵ-Js与HTML压缩

>1、在生产环境下,会自动进行`Js代码压缩`
>
>2、HTML压缩需要在`HtmlWebpackPlugin`插件的配置中编写要求,如下面代码的`去除空格与注释`

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './src/js/index.js',
  output: {
    filename: 'js/built.js',
    path: resolve(__dirname, 'build')
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/index.html',
      minify:{
        //移除空格
        collapseWhitespace:true,
        //移除注释
        removeComments:true
      }
    })
  ],
  // 生产环境下会自动压缩js代码
  mode: 'production'
};
```

### Ⅶ-生产环境配置

> 完整配置文件以及相应注解
>
> `注意`:
>
>  1、正常来讲,一个文件只能被一个loader处理.但当一个文件要被多个loader处理,那么一定要指定loader执行的先后顺序:
>        *    如:先执行eslint 再执行babel 
>               *    -->因为babel会将es6的语法转为低阶语法如(let->var),如果先转babel的话eslint就会报错

```json
const HtmlWebpackPlugin = require('html-webpack-plugin'); //引入html打包插件
const MiniCssExtractPlugin = require('mini-css-extract-plugin'); //引入css提取打包插件
const OptimizeCssAssetsWebpackPlugin = require('optimize-css-assets-webpack-plugin') //引入css压缩插件
const { resolve } = require('path'); //引入路径插件
//复用loader配置  这里因为css与less配置大部分相同,所以抽出
const commonCssLoader = [
  MiniCssExtractPlugin.loader, //使用这个插件的loader取代style-loader 作用:提取css为单独的文件
  'css-loader',
  {
    loader: 'postcss-loader', //还需要在packahe.json中定义browserslist
    options: {
      ident: 'postcss',
      plugins: () => [require('postcss-preset-env')] //使用postcss插件进行兼容性处理
    }
  }
]

module.exports = {
  entry: './src/js/index.js',
  output: {
    filename: 'js/built.js',
    path: resolve(__dirname, 'built')
  },
  /*一、引用 */
  module: {
    rules: [
      /**1、css与less规则配置 提取单独文件与css兼容性处理 */
      {
        test: /\.css$/,
        use: [...commonCssLoader]
      },
      {
        test: /\.less$/,
        use: [...commonCssLoader, 'less-loader']
      },
      /**2、js处理规则配置 
       *    正常来讲,一个文件只能被一个loader处理.但当一个文件要被多个loader处理,那么一定要指定loader执行的先后顺序:
       *    如:先执行eslint 再执行babel 
       *    -->因为babel会将es6的语法转为低阶语法如(let->var),如果先转babel的话eslint就会报错
       */
      {
        test: /\.js$/,
        exclude: /node_modules/, //使用eslint不检查依赖库里面的js
        enforce: "pre", //下面的babel处理js的loader应该在eslint检查后再执行,设置优先执行当前loader
        loader: 'eslint-loader',
        options: {
          fix: true // 自动修复eslint的错误,比如补全分号
        }
      },
      {
        test: /\.js$/,
        exclude: /node_modules/, //使用babel不转换依赖库里面的js
        loader: 'babel-loader',
        options: {
          presets: [
            [ //注意 这里两个[]
              '@babel/preset-env', //预设指定用的什么babel模板
              {
                useBuiltIns: 'usage', //使用内置对象:按需加载
                corejs: { //指定core-js版本
                  version: 3
                },
                targets: { //指定babel转换js兼容性做到哪个版本浏览器兼容
                  chrome: '60',
                  firefox: '60',
                  ie: '9'
                }
              }
            ]
          ]
        }
      },
      /**3、图片压缩*/
      {
        //图片打包,但是默认处理不了html中的图片,需要另外配置一个loader处理
        test: /\.(jpg|png|gif)$/,
        loader: 'url-loader',
        options: {
          limit: 8 * 1024, //当图片
          name: '[hash:10].[ext]', //限制打包后的哈希文件名长度,保留后缀名
          outputPath: 'imgs', //执行打包后放在哪个位置
          //url-loader默认使用的是es6的模块化解析,而html-loader引入图片是commonjs
          //所以需要关闭`url-loader`的es6模块化解析,使用commonjs模块化解析
          esModule: false
        }
      },
      {
        test: /\.html$/,
        loader: 'html-loader' //需要使用html插件
      },
      /**4、 其他资源打包 */
      {
        exclude: /\.(js|css|less|scss|html|jpg|png|gif)$/, //先排除自己配置过的文件
        loader: 'file-loader',
        options: {
          outputPath: 'media', //执行打包后放在哪个位置
          name: '[hash:10].[ext]' //限制打包后的哈希文件名长度,保留后缀名
        }
      }
    ]
  },
  //插件
  plugins: [
    //1、html打包插件,在html打包图片,以及打包html文件时候用到
    new HtmlWebpackPlugin({
      template: './src/index.html',
      minify: { //指定`minify`该属性后,将会根据里面配置进行html文件压缩
        collapseWhitespace: true, //去除文件中的空格
        removeComments: true //去除文件中的注释
      }
    }),
    //2、css提取打包插件
    new MiniCssExtractPlugin({
      filename: 'css/built.css' //指定提取打包后的css文件位置与名字
    }),
    //3、css压缩插件  默认配置即可达到正常的打包要求
    new OptimizeCssAssetsWebpackPlugin()
  ],
  //指定模式为生产模式
  mode: 'production' //指定为生产模式后,js将会默认压缩
}
```

> package.json

```json
{
  "name": "webpack_code",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC",
  "devDependencies": {
    "@babel/core": "^7.8.4",
    "@babel/polyfill": "^7.8.3",
    "@babel/preset-env": "^7.8.4",
    "add-asset-html-webpack-plugin": "^3.1.3",
    "babel": "^6.23.0",
    "babel-loader": "^8.0.6",
    "core-js": "^3.6.4",
    "css-loader": "^3.4.2",
    "eslint": "^6.8.0",
    "eslint-config-airbnb-base": "^14.0.0",
    "eslint-loader": "^3.0.3",
    "eslint-plugin-import": "^2.20.1",
    "file-loader": "^5.0.2",
    "html-loader": "^0.5.5",
    "html-webpack-plugin": "^3.2.0",
    "less": "^3.11.1",
    "less-loader": "^5.0.0",
    "mini-css-extract-plugin": "^0.9.0",
    "optimize-css-assets-webpack-plugin": "^5.0.3",
    "postcss-loader": "^3.0.0",
    "postcss-preset-env": "^6.7.0",
    "style-loader": "^1.1.3",
    "terser-webpack-plugin": "^2.3.5",
    "thread-loader": "^2.1.3",
    "url-loader": "^3.0.0",
    "webpack": "^4.46.0",
    "webpack-cli": "^3.3.12",
    "webpack-dev-server": "^3.10.3",
    "workbox-webpack-plugin": "^5.0.0"
  },
  "dependencies": {
    "jquery": "^3.4.1"
  },
  "browserslist": {
    "development": [
      "last 1 chrome version",
      "last 1 firefox version",
      "last 1 safari version"
    ],
    "production": [
      ">0.2%",
      "not dead",
      "not op_mini all"
    ]
  },
  "eslintConfig": {
    "extends": "airbnb-base",
    "env": {
      "browser": true //支持浏览器端的bian'l,比如 window 
    }
  },
  "sideEffects": [
    "*.css" //这是在优化部分的树摇配置
  ]
}

```

------



------



# 四、Webpack优化

### Ⅰ- HMR优化

> `HMR`: hot module replacement` 热模块替换`/模块热替换
>
> 作用:一个模块发生变化,指挥重新打包这一个模块(而不是打包所有模块)  极大的提升构建速度,主要是在`开发模式中使用`,方便调试
>
> 1、样式文件:可以使用HMR功能:因为`style-loader`内部实现了
>
> 2、js文件:默认不能使用HMR功能 
>  使用方法-->需要`修改js代码`,添加支持HMR功能的代码
>  注意:HMR功能对js的处理,只能处理`非入口js文件`的其他文件
>
> 3、html文件:默认不能使用HMR功能,同事会导致问题:html文件不能热更新了
>  解决:`修改entry入口`,将html文件引入(不用做HMR功能,毕竟现在流行单页面应用)
>
> 基于前面的`开发环境配置部分`代码进行优化

```js
  const {resolve}=require('path');
  const HtmlWebpackPlugin=require('html-webpack-plugin');

  module.exports={
    entry:['./src/js/index.js','./src/index.html'],
    output:{
      filename:'js/built.js',
      path:resolve(__dirname,'build')
    },
    module:{
      rules:[
        {
          test:/\.less$/,
          //此处开发环境使用的是style-loader,因为它自己实现了HMR功能
          use:['style-loader','css-loader','less-loader']
        },
        {
          test:/\.css$/,
          use:['style-loader','css-loader']
        },
        {//处理图片资源
          test:/\.(jpg|png|gif)$/,
          loader:'url-loader',
          options:{
            limit:8*1024,
            name:'[hash:10].[ext]',
            //关闭es6模块
            esModule:false,
            outputPath:'imgs'
          }
        },
        {//处理html中的img资源
          test:/\.html$/,
          loader:'html-loader'
        },
        {//处理其他资源
          exclude:/\.(html|js|css|less|jpg|png|gif)$/,
          loader:'file-loader',
          options:{
            name:'[hash:10].[ext]',
            outputPath:'media'
          }
        }
      ]
    },
    plugins:[
      new HtmlWebpackPlugin({
        template:'./src/index.html'
      })
    ],
    mode:'development',
    devServer:{
      contentBase:resolve(__dirname,'build'),//项目构建后路径
      compress:true, //启动gzip压缩
      port:3000,
      open:true,//自动打开浏览器
      hot:true//开启HMR功能,注意:当修改了webpack功能,新配置想要生效,必须重新启动webpack服务
    }
  }
```

> js进行HMR优化,在入口文件写下监听代码
>
> 注意:你要监听进行`热模块替换`,前提是你这个js要`在入口文件中导入`,然后入口文件中才能监听得到变化

```js
import print from './print';
import test from './test';
if (module.hot) {
  // 一旦 module.hot 为true，说明开启了HMR功能。 --> 让HMR功能代码生效
  module.hot.accept(['./print.js','./test.js'], function() {//只有一个js文件需要监听打包就直接输入url字符串,不用数组
    // 方法会监听 print.js 文件的变化，一旦发生变化，其他模块不会重新打包构建。
    // 会执行后面的回调函数
      console.log("前提是你要在入口文件上导入,才能监听得到变化")
  });
}
```

### Ⅱ- source-map 优化

>1、`source-map`: 一种 提供源代码到构建后代码映射 技术 （如果构建后代码出错了，通过映射可以追踪源代码错误）分为`内联`与`外部`:
>
>2、内联和外部的区别：1. 外部生成了文件，内联没有 2. 内联构建速度更快
>
>3、不同环境选择:
>
> `开发环境`：考虑 速度快，调试更友好
>    ① 速度快(eval>inline>cheap>...):  eval-cheap-souce-map > eval-source-map
>
>​    ② 调试更友好: souce-map > cheap-module-souce-map > cheap-souce-map
>
>​    ③ 最优选--> `eval-source-map`  > eval-cheap-module-souce-map
>
> `生产环境`:考虑 源代码要不要隐藏? 调试要不要更友好
>
>​	 ① 内联会让代码体积变大，所以在生产环境不用内联
>
>​     ② 考虑隐藏:nosources-source-map 全部隐藏 >hidden-source-map 只隐藏源代码，会提示构建后代码错误信息
>
>​     ③ 综合考虑:source-map `or` cheap-module-souce-map

```js
module.exports = {
  entry: [],
  output: { },
  module: { rules: [] },
  plugins: [],
  mode: 'development',
  devServer: {},
   //选定映射模式
  devtool: 'eval-source-map'
};
```

>`不同映射模式的区别`:感觉记住结论就好了,真的需要的时候再来翻阅
>
>[inline-|hidden-|eval-] [nosources-] [cheap-[module-]]source-map
>
>​	1、source-map：外部
>​      错误代码准确信息 和 源代码的错误位置
>​    2、inline-source-map：内联
>​      只生成一个内联source-map
>​      错误代码准确信息 和 源代码的错误位置
>​    3、hidden-source-map：外部
>​      错误代码错误原因，但是没有错误位置
>​      不能追踪源代码错误，只能提示到构建后代码的错误位置
>​    4、eval-source-map：内联
>​      每一个文件都生成对应的source-map，都在eval
>​      错误代码准确信息 和 源代码的错误位置
>​    5、nosources-source-map：外部
>​      错误代码准确信息, 但是没有任何源代码信息
>​    6、cheap-source-map：外部
>​      错误代码准确信息 和 源代码的错误位置 
>​      只能精确的行
>​    7、cheap-module-source-map：外部
>​      错误代码准确信息 和 源代码的错误位置 
>​      module会将loader的source map加入

### Ⅲ- oneOf

>正常来说,一个文件会被所有的loader过滤处理一遍,如果我有100个loader配置,那么我一个文件就要被100个loader匹配,而使用`oneOf`后,而如果放在`oneOf`中的loader规则有一个匹配到了,`oneOf`中的其他规则就不会再对这文件进行匹配
>
>`注意`:oneOf中不能有两个loader规则配置处理同一种文件,否则只能生效一个 例如:对于js进行eslint检测后再进行babel转换
>
>​	解决:将eslint抽出到外部,然后优先执行,这样在外部检测完后`oneOf`内部配置就会再进行检测匹配

```js
module.exports = {
  entry: './src/js/index.js',
  output: {},
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/, enforce: 'pre', loader: 'eslint-loader',
      },
      {
        // 以下loader只会匹配一个
        // 注意：不能有两个配置处理同一种类型文件
        oneOf: [
          {
            test: /\.css$/,
            use: [...commonCssLoader]
          },
          {
            test: /\.less$/,
            use: [...commonCssLoader, 'less-loader']
          },
          {
            test: /\.js$/,
            exclude: /node_modules/,
            loader: 'babel-loader',
            options: {
              presets: [
                [
                  '@babel/preset-env',
                  {
                    useBuiltIns: 'usage',
                    corejs: {version: 3},
                    targets: {
                      chrome: '60',
                      firefox: '50'
                    }
                  }
                ]
              ]
            }
          }
     
        ]
      }
    ]
  },
  plugins: [],
  mode: 'production'
};
```

### Ⅳ-缓存

>缓存需要在`server环境`中才有效果 
>
>1、babel缓存:
>
>  在`babel`的loader选项部分添加 `cacheDirectory: true` -->让第二次打包构建速度更快
>
>2、文件资源缓存:
>
>  文件资源当你文件名不变时会默认读取本地缓存,所以当你修改某个文件内容后,并不能实时更新到线上项目中,所以解决方法是在每次webpack构建时生成一个唯一的hash值加在文件名中,每次修改便改动文件名,达到更新效果.而不同的hash也有不同效果,其中需要选用`contenthash`
>
>  ① hash:每次webpack构建时会生成一个唯一的hash值
>
>​	问题:因为js和css同时使用`同一个hash值`,如果重新打包,会导致所有缓存失效(即使你只改动了一个文件)
>
>  ② chunkhash:根据chunk生成的hash值,如果打包来源于同一个chunk,那么hash值就一样
>
>​    问题:js和css的hash值还是一样, 因为css时在js中被引入的,所以属于同一个chunk
>
>  ③ `contenthash`:根据文件的内容生成hash值,不同的文件hash一定不一样
>
>​	-->让代码上线运行缓存更好使用(当你线上项目出现紧急BUG时,可以更快的修改)		  

```js
const { resolve } = require('path');
module.exports = {
  entry: './src/js/index.js',
  output: {
      //使用contenthash哈希值
    filename: 'js/built.[contenthash:10].js',
    path: resolve(__dirname, 'build')
  },
  module: {
    rules: [
      {
        oneOf: [
          {
            test: /\.js$/,
            exclude: /node_modules/,
            loader: 'babel-loader',
            options: {
              presets: [
                ['@babel/preset-env',
                 { useBuiltIns: 'usage', corejs: { version: 3 }, targets: {chrome: '60',firefox: '50'}} ]
              ],
              // 开启babel缓存
              // 第二次构建时，会读取之前的缓存
              cacheDirectory: true
            }
          },
          
          }
        ]
      }
    ]
  },
  plugins: [   new MiniCssExtractPlugin({ filename: 'css/built.[contenthash:10].css' }), ],
  mode: 'production',
  devtool: 'source-map'
};
```

> server.js代码

```js
/*
  服务器代码
  启动服务器指令：npm i nodemon -g
   `` nodemon server.js`   or   `node server.js`
  访问服务器地址：
    http://localhost:3000
*/
const express = require('express');
const app = express();
// express.static向外暴露静态资源
// maxAge 资源缓存的最大时间，单位ms
app.use(express.static('build', { maxAge: 1000 * 3600 }));
app.listen(3000);
```

### Ⅴ-tree shaking 树摇

> 1、`tree shaking`：去除无用代码 
>
>  前提：1. 必须使用ES6模块化 2. 开启production环境 3.webpack4中,对于嵌套的代码,无法去除 
>
>  作用: 减少代码体积

>   2、在package.json中配置 
>
>    "sideEffects": false 所有代码都没有副作用（都可以进行tree shaking）
>
> ​    问题：可能会把css / @babel/polyfill （副作用）文件干掉
>
>    解决:"sideEffects": ["*.css", "*.less"]

```json
"sideEffects": [
    "*.css" 
  ]
```

### Ⅵ-code split 代码分割

>1、多入口与单入口文件打包 (通常不使用这个方法,一般使用2、3的方法)
>
>  ① 多入口：有一个入口，最终输出就有一个bundle
>
>  ② `[name]`：取文件名

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  // 单入口
  // entry: './src/js/index.js',
  entry: {
    // 多入口：有一个入口，最终输出就有一个bundle
    index: './src/js/index.js',
    test: './src/js/test.js'
  },
  output: {
    // [name]：取文件名
    filename: 'js/[name].[contenthash:10].js',
    path: resolve(__dirname, 'build')
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/index.html',
      minify: {
        collapseWhitespace: true,
        removeComments: true
      }
    })
  ],
  mode: 'production'
};

```

>2、`optimization: {splitChunks: {chunks: 'all'}}`配置 
>
>  ① 可以将node_modules中代码单独打包一个chunk最终输出
>  ② 自动分析多入口chunk中，有没有公共的文件。如果有会打包成单独一个chunk(多入口文件)

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  // 单入口
  // entry: './src/js/index.js',
  entry: {
    index: './src/js/index.js',
    test: './src/js/test.js'
  },
  output: {
    // [name]：取文件名
    filename: 'js/[name].[contenthash:10].js',
    path: resolve(__dirname, 'build')
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/index.html',
      minify: {
        collapseWhitespace: true,
        removeComments: true
      }
    })
  ],
  /*
    1. 可以将node_modules中代码单独打包一个chunk最终输出
    2. 自动分析多入口chunk中，有没有公共的文件。如果有会打包成单独一个chunk
  */
  optimization: {
    splitChunks: {
      chunks: 'all'
    },
   // 将当前模块的记录其他模块的hash单独打包为一个文件 runtime
    // 解决：修改a文件导致b文件的contenthash变化
     runtimeChunk: {
      name: entrypoint => `runtime-${entrypoint.name}`
    },
  },
  mode: 'production'
};

```

>3、单入口文件,且想打包特定js文件为单独文件,在`2`的配置基础上再写js代码(入口改为单入口)
>
>` 通过js代码`，让某个文件被单独打包成一个chunk,该代码写在入口js文件中
>`import动态导入语法`：能将某个文件单独打包
>`通过注释`,可以让js生成的打包文件带上这个名字,
>
> 	在`webpack5`中的`开发模式中可以不用注释加名字`,内部有 chunk 命名规则，不再是以 id(0, 1, 2)命名了,当然生产模式还是有必要的

```js
//通过注释,可以让js生成的打包文件带上这个名字
import(/* webpackChunkName: 'test' */'./test')
  .then(({ mul, count }) => {
    // 文件加载成功~
    // eslint-disable-next-line
    console.log(mul(2, 5));
  })
  .catch(() => {
    // eslint-disable-next-line
    console.log('文件加载失败~');
  });

// eslint-disable-next-line
console.log(sum(1, 2, 3, 4));

```

### Ⅶ- 懒加载 (lazy loading) 和预加载

>应用场景:当我们模块很多时,导入的js太多,或者说有的js只有使用的时候才有用,而我一开始便加载,就可能造成一些不必要的性能浪费
>
> 1、懒加载:当文件需要使用时才加载
>
>​    `可能的问题`:当用户第一次使用时,如果js文件过大,可能造成加载时间过长(有延迟),但是第二次就不会了,因为懒加载第二次是从缓存中读取文件
>
> 2、预加载 prefetch:等其他资源加载完毕,浏览器空闲了,再偷偷加载
>
>​    正常加载可以认为时并行加载(同一时间加载多个文件,但是同一时间有上限)
>
>​	就例如下面例子,有预加载的代码运行效果,是页面刷新后,但是还未进行使用时,该文件其实已经加载好了
>
>`注意`:预加载虽然性能很不错,但是需要浏览器版本较高,兼容性较差,`慎用预加载`

```js
console.log('index.js文件被加载了~');
// import { mul } from './test';
//懒加载
document.getElementById('btn').onclick = function() {
    //懒加载其实也是需要前面Ⅵ代码分割功能,将我的需要加载的文件打包成单独文件
  import(/* webpackChunkName: 'test'*/'./test').then(({ mul }) => {
    console.log(mul(4, 5));
  });
};
//预加载
//在注释参数上添加 webpackPrefetch: true 
  import(/* webpackChunkName: 'test', webpackPrefetch: true */'./test').then(({ mul }) => {
    console.log(mul(4, 5));
  });
```

### Ⅷ- PWA  (离线访问)

>PWA: 渐进式网络开发应用程序(离线可访问) workbox -->下载依赖: `workbox-webpack-plugin`
>
>1、在配置中使用该插件 :① 帮助serviceworker快速启动 ② 删除旧的 serviceworker
>
>2、在入口文件js中添加代码
>
>3、eslint不认识 window、navigator全局变量
>
>   解决：需要修改package.json中eslintConfig配置
>
>4、代码必须运行在服务器上才有效果 
>
>  ① node.js
>
>  ② `npm i serve -g` -->`serve -s build` 启动服务器，将build目录下所有资源作为静态资源暴露出去

> webpack.config.js新增配置

```js
 const WorkboxWebpackPlugin = require('workbox-webpack-plugin');
plugins: [
    new WorkboxWebpackPlugin.GenerateSW({
      /*生成一个 serviceworker 配置文件~*/
      //1. 帮助serviceworker快速启动
      clientsClaim: true,
      //2. 删除旧的 serviceworker
      skipWaiting: true
    })
  ],
```

>入口文件js -->index.js

```js
// 注册serviceWorker
// 处理兼容性问题
if ('serviceWorker' in navigator) {
  window.addEventListener('load', () => {
    navigator.serviceWorker
      .register('/service-worker.js')
      .then(() => {
        console.log('sw注册成功了~');
      })
      .catch(() => {
        console.log('sw注册失败了~');
      });
  });
}
```

> package.json新增配置

```json
 "eslintConfig": {
    "extends": "airbnb-base",
    "env": {
      "browser": true //开启为eslint支持浏览器端的bian'l,比如 window 
    }
  },
```

### Ⅸ-多线程打包

> 1、下载`thread-loader`依赖
>
> 2、使用`loader: 'thread-loader'`开启多线程打包 
>
> 注意点:进程启动大约为600ms,进程通信也有开销,只有工作消耗时间较长,才需要多进程打包 比如:`babel`转换可以使用多线程

```js
const { resolve } = require('path');
module.exports = {
  module: {
    rules: [
        oneOf: [
          {
            test: /\.js$/,
            exclude: /node_modules/,
            use: [
              /* 
                开启多进程打包。 
                进程启动大概为600ms，进程通信也有开销。
                只有工作消耗时间比较长，才需要多进程打包
              */
              {
                loader: 'thread-loader',
                options: {
                  workers: 2 //设置 进程2个
                }
              },
              {
                loader: 'babel-loader',
                options: {
                  presets: [
                    [
                      '@babel/preset-env',
                      {
                        useBuiltIns: 'usage',
                        corejs: { version: 3 },
                        targets: {
                          chrome: '60',
                          firefox: '50'
                        }
                      }
                    ]
                  ],
                  // 开启babel缓存
                  // 第二次构建时，会读取之前的缓存
                  cacheDirectory: true
                }
              }
            ]
          }
        ]
      }
    ]
  }
};
```

### Ⅹ-externals

> 当你使用外部引入代码时:如`CDN引入`,不想他将我引入的模块也打包,就需要添加这个配置
>
> 即:声明哪些库是不进行打包的
>
>  -->`externals`: {}

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './src/js/index.js',
  output: {
    filename: 'js/built.js',
    path: resolve(__dirname, 'build')
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/index.html'
    })
  ],
  mode: 'production',
  externals: {
    // 拒绝jQuery被打包进来
    jquery: 'jQuery'
  }
};
```

### Ⅺ-dll

>使用dll技术，对某些库（`第三方库`：jquery、react、vue...）`进行单独打包`
>
> 作用:如果不是cdn引入,而是使用第三方库,想要打包后暴露出去,使用该方法
>
>1、首先你需要写一个新的配置文件,因为使用`dll`技术,所以命名为webpack.dll.js
>
>   当你运行 webpack 时，默认查找 webpack.config.js 配置文件  需求：需要`先运行 webpack.dll.js` 文件
>
> -->` webpack --config webpack.dll.js`  在这个文件中进行对某些库的单独打包
>
>2、在webpack.config.js中,需要告诉webpack哪些库不需要再次打包(即在dll.js中打包后生成的文件)
>
>3、这里需要使用到`add-asset-html-webpack-plugin`与`webpack`插件
>
>4、运行`webpack.dll.js`对第三方库进行单独打包后,除非你要加新的库,不然不用再重新打包这个,直接`webpack`打包其他的即可

> webpack.dll.js配置文件

```js
const { resolve } = require('path');
const webpack = require('webpack');

module.exports = {
  entry: {
    // 最终打包生成的[name] --> jquery
    // ['jquery'] --> 要打包的库是jquery
    jquery: ['jquery'],
   //  react:['react','react-dom' ]
  },
  output: {
    filename: '[name].js',
    path: resolve(__dirname, 'dll'),
    library: '[name]_[hash]' // 打包的库里面向外暴露出去的内容叫什么名字
  },
  plugins: [
    // 打包生成一个 manifest.json --> 提供和jquery映射
    new webpack.DllPlugin({
      name: '[name]_[hash]', // 映射库的暴露的内容名称
      path: resolve(__dirname, 'dll/manifest.json') // 输出文件路径
    })
  ],
  mode: 'production'
};
```

> webpack.config.js配置文件

```js
const { resolve } = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require('webpack');
const AddAssetHtmlWebpackPlugin = require('add-asset-html-webpack-plugin');

module.exports = {
  entry: './src/index.js',
  output: {
    filename: 'built.js',
    path: resolve(__dirname, 'build')
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/index.html'
    }),
    // 告诉webpack哪些库不参与打包，同时使用时的名称也得变~
    new webpack.DllReferencePlugin({
      manifest: resolve(__dirname, 'dll/manifest.json')
    }),
    // 将某个文件打包输出去，并在html中自动引入该资源
    new AddAssetHtmlWebpackPlugin({
      filepath: resolve(__dirname, 'dll/jquery.js')
    })
  ],
  mode: 'production'
};
```

### XII-性能优化总结

>1、**# webpack性能优化**
>
>​	① 开发环境性能优化
>
>​	② 生产环境性能优化
>
>2、**# 开发环境性能优化**
>
>​	① 优化打包构建速度:HMR	
>
>​	② 优化代码调试:source-map
>
>3、**# 生产环境性能优化**
>
>​	① 优化打包构建速度
>
>​		Ⅰ- oneOf
>
> 	   Ⅱ- babel缓存
>
>​	    Ⅲ- 多进程打包
>
> 	   Ⅳ- externals
>												
> 	   Ⅴ- dll   这个技术加上代码拆分code split可以做出更加细度化拆分
>
>​	② 优化代码运行的性能
>
>​		Ⅰ- 缓存(hash-chunkhash-contenthash)
>
>​		Ⅱ- tree shaking
>
>​		Ⅲ-code split
>
>​		Ⅳ- 懒加载/预加载
>
>​		Ⅴ- pwa

------



------



# 五、Webpack5的介绍与预学习

>此版本重点关注以下内容:
>
>- 通过持久缓存提高构建性能.
>- 使用更好的算法和默认值来改善长期缓存.
>- 通过更好的树摇和代码生成来改善捆绑包大小.
>- 清除处于怪异状态的内部结构，同时在 v4 中实现功能而不引入任何重大更改.
>- 通过引入重大更改来为将来的功能做准备，以使我们能够尽可能长时间地使用 v5.

### Ⅰ-下载

> `npm i webpack@next webpack-cli -D`

### Ⅱ-自动删除 Node.js Polyfills

>早期，webpack 的目标是允许在浏览器中运行大多数 node.js 模块，但是模块格局发生了变化，许多模块用途现在主要是为前端目的而编写的。webpack <= 4 附带了许多 node.js 核心模块的 polyfill，一旦模块使用任何核心模块（即 crypto 模块），这些模块就会自动应用。
>
>尽管这使使用为 node.js 编写的模块变得容易，但它会将这些巨大的 polyfill 添加到包中。在许多情况下，这些 polyfill 是不必要的。
>
>webpack 5 会自动停止填充这些核心模块，并专注于与前端兼容的模块。
>
>迁移：
>
>- 尽可能尝试使用与前端兼容的模块。
>- 可以为 node.js 核心模块手动添加一个 polyfill。错误消息将提示如何实现该目标。

### Ⅲ-Chunk 和模块 ID

> 添加了用于长期缓存的新算法。在生产模式下默认情况下启用这些功能。

```
chunkIds: "deterministic", moduleIds: "deterministic"
```

### Ⅳ-Chunk ID

> 你可以不用使用 `import(/* webpackChunkName: "name" */ "module")` 在开发环境来为 chunk 命名，生产环境还是有必要的
>
> webpack 内部有 chunk 命名规则，不再是以 id(0, 1, 2)命名了
>
> 这部分在`import动态导入语法`中会用到,如代码分割与懒加载

### Ⅴ-Tree Shaking 树摇优化

> 1、webpack 现在`能够处理对嵌套模块`的 tree shaking
>
> 在生产环境中, inner 模块暴露的 `b` 会被删除,原本的webpack4无法判断中间这个被引用的内容是否有所被引用,无法删除

```js
// inner.js
export const a = 1;
export const b = 2;

// module.js
import * as inner from './inner';
export { inner };

// user.js
import * as module from './module';
console.log(module.inner.a);
```

> 2、webpack 现在能够判断多个模块之前的关系

```js
import { something } from './something';

function usingSomething() {
  return something;
}

export function test() {
  return usingSomething();
}
```

当设置了`"sideEffects": false`时，一旦发现`test`方法没有使用，不但删除`test`，还会删除`"./something"`

> 3、webpack 现在能处理对 Commonjs 的 tree shaking

### Ⅵ-Output

webpack 4 默认只能输出 ES5 代码

webpack 5 开始新增一个属性 output.ecmaVersion, 可以生成 ES5 和 ES6 / ES2015 代码.

如：`output.ecmaVersion: 2015`

### Ⅶ-SplitChunk

> 之前webpack4只能指定最小文件大小,现在能对不同文件进行最小大小判断
>
> 此属性在代码分割的`optimization`配置中

```js
// webpack4
minSize: 30000;
// webpack5
minSize: {
  javascript: 30000,
  style: 50000,
}
```

### Ⅷ-Caching

```js
// 配置缓存
cache: {
  // 磁盘存储
  type: "filesystem",
  buildDependencies: {
    // 当配置修改时，缓存失效
    config: [__filename]
  }
}
```

缓存将存储到 `node_modules/.cache/webpack`

### Ⅸ-监视输出文件

之前 webpack 总是在第一次构建时输出全部文件，但是监视重新构建时会只更新修改的文件。

此次更新在第一次构建时会找到输出文件看是否有变化，从而决定要不要输出全部文件。

### Ⅹ-默认值

> webpack5将部分配置赋予默认值,当你使用如下配置,在webpack5中可以不进行代码编写

- `entry: "./src/index.js`
- `output.path: path.resolve(__dirname, "dist")`
- `output.filename: "[name].js"`

[更多内容](https://github.com/webpack/changelog-v5)

------



------



# ###、出现的问题与解决

### Ⅰ-如果开启了 eslint 再进行懒加载会报错 无法再非顶层使用import

>解决：
> 1、新建 .eslintrc 文件
>
> 2、配置
>
>```js
>{
>"parser": "babel-eslint",
>"parserOptions": {
>  "sourceType": "module",
>  "allowImportExportEverywhere": true
>}
>}
>```

### Ⅱ-css兼容性配置没效果

>可能是版本问题,`换个写法`试试

> 问题代码

```js
 use: [MiniCssExtractPlugin.loader, 'css-loader',
        {
          loader: 'postcss-loader',
          options: {
            ident: 'postcss',
            plugins: () => [
              require('postcss-preset-env')()
            ]
          }
        }
    ]   
```

> 解决代码
>
> 如果{}不需要继续传入options，可以直接这样`plugins: ['postcss-preset-env']` 效果同上

```js
{
  loader: 'postcss-loader',
  options: {
    postcssOptions: {
      plugins: [['postcss-preset-env', {}]]
    }
  }
}
```

