

# -----------------------==(VUE伍)==-------------------------

# webpack安装与使用

## 一.webpack作用:

>   基于webpack *我们可以实现*
>
> ​      *1. 高阶语法转低阶语法*
>
> ​      *2. 模块化语法*
>
> ​      *3. 图片打包和压缩*
>
> ​      *4. css html js 压缩包*
>
> ​      *5.方便构建和打包 vue,react等框架的项目*

## 二.webpack安装需要的依赖

```js
 1.webpack
 2.webpack-cli
npm i webpack webpack-cli -g //最好全局安装,这样可以才可以使用命令行,其他的依赖最好局部
npm install html-webpack-plugin //重新打包我们的html,同时注入我们生成的js文件,文件名已经生成的文件的路径由配置决定
 npm i style-loader css-loader// 每次新增依赖需要重新link
```

## 三.webpack搭建顺序:

##### 1、优化命令使用

>  1)nom run 命令*           2)打包的命令靠过去 -->nom run 命令*
>
>  3)webpack.config.js+npm项目*   npm init -y ->生成package.json 修改*
>
>  *创建wenpack.config.js文件*
>
>  4) .json文件里头只能存储标准的json对象*
>
>     ① 有key 有value  *② key必须是带双引号的字符串*
>
>     *③ 不能出现除key 与 value之外的字符 注释,多余的符号*

###### (1.1)生成package.json文件并且创建webpack.config.js配置文件

```js
1.npm init -y // 生成package.json 用于优化命令行
2.在项目根目录创建webpack.config.js文件 这是配置文件
```

###### (1.2)修改package.json文件-->优化命令 调用时使用 npm run dev打包

```json
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "dev": "webpack --mode development",
    "build": "webpack --mode production",
    "link": "npm link webpack --save-dev"
  }
```

##### 2、完成export打包配置

```js
      //默认会去打包 项目根目录下的src下的inex.html  默认打包之后 dist main.js
      //  webpack --mode production   //开发 进行压缩可读性差
 		//		 webpack --mode development   //未压缩 需要指定打包文件用下面那行命令
        webpack 要打包的目标文件  --mode development
     //   牛刀小试:export的错误就没了
```

##### 3、完成打包html时更新导入路径

###### (3.1)安装依赖 html-webpack-plugin 

```js
  npm install html-webpack-plugin  		//并在配置文件做出相应修改
```

###### (3.2)在webpack.config.js 配置文件修改

```js
const HtmlWebpackPlugin = require('html-webpack-plugin');
```

##### 4、css文件打包

###### (4.1)安装css依赖文件

```js
   npm i style-loader  css-loader  //并在配置文件做出相应修改
```

##### 5、scss文件打包

###### (5.1)安装scss依赖文件

```js
 npm i sass-loader      npm i  node-sass
//如果安装出错,使用下面命令安装
npm install yarn -g
yarn config set sass-binary-site http://npm.taobao.org/mirrors/node-sass
```

###### (5.2)配置文件修改

```js
  {
         test:/\.scss$/,
         use:["style-loader","css-loader","sass-loader"]
     }
```



##### 6、自动删除打包后残存js

###### (6.1)安装clean依赖

```
  npm i  clean-webpack-plugin
```

###### (6.2)解释

> 新版本跟旧版本的使用不一样
>
>  新版本的构造器通过解构赋值得到
>
> 新版本的实例不需要指定参数.默认就是hong下面

###### (6.3)修改配置文件

```js
 const {CleanWebpackPlugin} =require('clean-webpack-plugin')
 //配置清除包
 new CleanWebpackPlugin(),
```

#####  7、热更新

###### (7.1)安装热更新

```js
 yarn add webpack-dev-server
```

###### (7.2)配置文件修改

```js
    //热更新配置
    devServer:{
        port:80,
        contentBase:__dirname+"/hong"
    },
```

###### (7.3)package文件修改

```js
  "dev": "webpack-dev-server",
```

##### 8、打包多个js和html文件

> 业务驱动       单页面 单js 多个页面 多个js
>
>  html-webpack-plugin ==>解决多个html问题    
>
> 升级entry -->js   升级output -->js

```js
    配合升级entry
    1.一个页面多个js(饿汉式)
       此处修改配置文件   entry: {  index: './index.js',//   hong:'./a.js' },
 2.一个页面可选多js(饱汉)
//指定打包的key,与entry绑定
chunks:['index']
 //指定除了某个之外
excludeChunks:['a']
```



##### 9、打包image和css里头的img

> 注意 : 并没有笼统的讲是图片
>
>  因为图片的引入的媒介不一样,那么处理的方式不一样

###### (9.1)下载依赖

```js
     file-loader =>css里头的background-image:url('./hong.png')
        html-loader => html 里头的<img src="./hong.png">
        yarn add html-loader file-loader
```

##### 10、最终配置文件 webpack.config.js示例与解释

```js
const HtmlWebpackPlugin = require('html-webpack-plugin');

const {CleanWebpackPlugin} =require('clean-webpack-plugin')

module.exports={
    //热更新配置
    devServer:{
      //端口
        port:80,
      //打包到哪个路径
        contentBase:__dirname+"/hong"
    },
    //配置入口,以当前文件目录作为开始目录
    entry: {
      //别名:要打包的js
      index: './index.js',
      hong:'./a.js'
    },

    output:{
        //配置打包的目录和文件名字
        path: __dirname + '/hong',
        filename:'[name]_[hash:9].js'
    } ,
    //s使用插件
    plugins:[
      
        //配置清除包
        new CleanWebpackPlugin(),
        new HtmlWebpackPlugin({
            //用来指定模板
            template:'./index.html',
            //文件名 再热更新后通过这个访问
            filename:'hongjilin.html',
            //当指定模板后,模板优先,没有指定的时候才生效
            title:'大家嗨起来',
         /*   minify:{ 这个命令会压缩html
            // /取出src后面的空格,
            // //    collapseWhitespace:'true'
             },*/
            //指定打包的key,与entry绑定
            // chunks:['index']
            //指定除了某个之外的js打包
            excludeChunks:['a']
        }),
        //打包第二个页面
        new HtmlWebpackPlugin({
            //用来指定模板
            template:'./copy.html',
            //文件名 再热更新后通过这个访问
            filename:'copyweb.html',
            //当指定模板后,模板优先,没有指定的时候才生效
            title:'大家起来',
            excludeChunks:['index']
        })
    ],
    
    module:{
        rules:[
            {       //规定什么文件使用这个规则
                   test:/\.css$/,
                   //使用什么加载器
                   use:['style-loader','css-loader'] 
            },
                 {
                    test:/\.scss$/,
                    use:["style-loader","css-loader","sass-loader"]
                 },
                 {  //图片打包
                     test: /\.png|jpe?g|gif|bmp|svg$/,
                     use:[
                         {
                             loader:'file-loader',
                             options:{
                               //[ext]是图片标准后缀名
                                 name:'[name]_[hash:9].[ext]',
                               //指定输出地址
                                 outputPath:'./images/'
                             }
                         }
                     ]
                 },
                 {
                     test:/\.(html)$/,
                     use:{
                         loader:'html-loader',
                     }
                 }
        ]
    },

}
```

##### 11、package文件修改

```js
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    //"dev": "webpack-dev-server", 使用热更新  文件内不能注释
     "dev": "webpack --mode development",
    "build": "webpack --mode production",
    "link": "npm link webpack --save-dev"
  },
```

## 四.webpack打包时报错与解决

##### (1)无法加载文件 D:\nodejs\node_global\webpack.ps1，因为在此系统上禁止运行脚本。

```js
 问题解决:
通过vs code 运行webpack进行打包时，报错webpack : 无法加载文件 D:\nodejs\node_global\webpack.ps1，因为在此系统上禁止运行脚本。
解决方案：
以管理员身份运行vs code
执行：get-ExecutionPolicy，显示Restricted，表示状态是禁止的
执行：set-ExecutionPolicy RemoteSigned
这时再执行get-ExecutionPolicy，就显示RemoteSigned
```

##### (2)*出现问题了:被打包的文件的方法或者变量没办法直接被页面访问*

>  2.1)webpack打包的精髓:局部作用域
>
>   *2.2)js的代码只能主动去操作html反之不行*
>
>   *2.3)这个思想跟vue很像*

##### (3) 注入时候出现找不到webpack错误

> 因为webpack我们是全局安装,所以先运行 npm run link生成webpack快捷键,使得我们能找到webpack
>
> 再运行  "dev": "webpack --mode development",运行

##### (4)运行报错 json-bett.....错误

> 这是因为安装了局部还有全局的webpack
>
> 卸载全部webpack再重新安装
>
>  npm remove webpack -g

##### (5)ERROR in ./index.js

> ERROR in ./index.jsModule not found: Error: Can't resolve 'sass-loader' in 'E:\fyVSCode\XK_VUE\VUE_webpack' @ ./index.js 2:0-21
>
> 缺少下载 sass-loader 





## 伍.创建新项目

```js
yarn add webpack-dev-server
yarn add clean-webpack-plugin
yarn add html-webpack-plugin
npm i css-loader style-loader sass-loader
yarn add node-sass
yarn add file-loader
yarn add html-loader
yarn add html-loader
------------------------------------------------------------------
 "clean-webpack-plugin": "^3.0.0",
    "css-loader": "^4.2.1",
    "html-loader": "^1.1.0",
    "html-webpack-plugin": "^4.3.0",
    "node-sass": "^4.14.1",
    "sass-loader": "^9.0.3",
    "style-loader": "^1.2.1",
    "webpack-dev-server": "^3.11.0"
```

