# Webpack高级进阶学习笔记

>这部分笔记是观看`尚硅谷webpack5高级进阶`进行记录
>
>应是webpack基础学习的进阶,分析react与vue脚手架中wenpack的配置
>
>​																		起始时间:2020_3/4晚

# 一、React中的配置分析

>1、使用`creact-react-app`命令创建react项目
>
>2、运行指令`npm run eject`:为了更好的`学习与观察`webpack在react中的配置,运行该命令
>
>​	该命令会将react脚手架中隐藏的webpack配置暴露出来,而且`是不可逆`的,并使项目根目录多出两个文件目录:`config`和`scripts`,同时`package.json`的启动命令发生改变

### Ⅰ-paths.js文件分析

>1、`appDirectory`:项目根目录
>
>2、`resolveApp`:生成绝对路径的方法
>
>3、`publicUrlOrPath`:所有资源的公共访问路径 -->参数为`/` 对应自己当前这个服务器的地址
>
>4、`moduleFileExtensions`:定义文件拓展名,在这里定义的拓展名会被react解析到
>
>5、`resolveModule`:拿到上面的文件拓展名,检查文件路径是否匹配,存在则解析
>
>部分代码与注释

```js
'use strict';
const path = require('path');
const fs = require('fs');
const getPublicUrlOrPath = require('react-dev-utils/getPublicUrlOrPath');
//项目根目录
const appDirectory = fs.realpathSync(process.cwd());
//生成绝对路径的方法
const resolveApp = relativePath => path.resolve(appDirectory, relativePath);
// 所有资源的公共访问路径: / -->`/`对应自己当前这个服务器的地址
const publicUrlOrPath = getPublicUrlOrPath(
  process.env.NODE_ENV === 'development',
   //当你需要修改路径的时候去`package.json`进行修改,通常是不需要的
  require(resolveApp('package.json')).homepage,
  process.env.PUBLIC_URL
);
const buildPath = process.env.BUILD_PATH || 'build';
//定义文件拓展名,在这里定义的拓展名会被react解析到
const moduleFileExtensions = [
  'web.mjs', 'mjs', 'web.js','js', 'web.ts','ts','web.tsx','tsx','json','web.jsx','jsx',
];
// 解析模块的方法:
//拿到上面的文件拓展名,检查文件路径是否匹配,存在则解析
const resolveModule = (resolveFn, filePath) => {
  const extension = moduleFileExtensions.find(extension =>
    fs.existsSync(resolveFn(`${filePath}.${extension}`))
  );
  if (extension) {return resolveFn(`${filePath}.${extension}`); }
  return resolveFn(`${filePath}.js`);
};
// 暴露出去的路径
module.exports = {
  dotenv: resolveApp('.env'),
  appPath: resolveApp('.'),
	...
};
//将拓展名加至暴露出去的对象上暴露出去
module.exports.moduleFileExtensions = moduleFileExtensions;
```

### Ⅱ-start.js分析

>用来运行`开发环境`配置
>
>1、`定义环境变量`: ① process.env.BABEL_ENV ② process.env.NODE_ENV
>
>2、`useYarn`:判断是否使用yarn
>
>3、`config = configFactory('development')`:引入webpack的开发环境配置
>
>4、`checkBrowsers`:检查当前使用的是什么浏览器
>
>部分代码与注释

```js
'use strict';
// 定义环境变量:开发环境
process.env.BABEL_ENV = 'development';
process.env.NODE_ENV = 'development';
// 捕获异常
process.on('unhandledRejection', err => { throw err;});
// 加载.env的环境变量:
require('../config/env');
//判断是否使用yarn
const useYarn = fs.existsSync(paths.yarnLockFile);
// 判断是否包含必要文件:publuc/index.html src/index.js 如果没有退出
if (!checkRequiredFiles([paths.appHtml, paths.appIndexJs])) {process.exit(1);}
// 定义默认端口号和域名
const DEFAULT_PORT = parseInt(process.env.PORT, 10) || 3000;
const HOST = process.env.HOST || '0.0.0.0';
const { checkBrowsers } = require('react-dev-utils/browsersHelper');
//检查当前使用的是什么浏览器
checkBrowsers(paths.appPath, isInteractive)
  .then(() => {
    // 检查端口号:检查当前端口号是否被占用,如果被占用自动加1
    return choosePort(HOST, DEFAULT_PORT);
  })
    //webpack的开发环境配置
    const config = configFactory('development');
    const protocol = process.env.HTTPS === 'true' ? 'https' : 'http';
    const appName = require(paths.appPackageJson).name;
	//判断是否使用typeScript
    const useTypeScript = fs.existsSync(paths.appTsConfig);
    const tscCompileOnError = process.env.TSC_COMPILE_ON_ERROR === 'true';
    // 创建编译器,将所有配置传进来
    const compiler = createCompiler({ appName,config, devSocket,urls,useYarn,useTypeScript,tscCompileOnError, webpack,});
    // 加载package.json中的prost配置
    const proxySetting = require(paths.appPackageJson).proxy;
    const proxyConfig = prepareProxy( proxySetting, paths.appPublic, paths.publicUrlOrPath );
    // 创建devServer的配置
    const serverConfig = createDevServerConfig(
      proxyConfig,
      urls.lanUrlForConfig
    );
    const devServer = new WebpackDevServer(compiler, serverConfig);
    // 启动服务
    devServer.listen(port, HOST, err => {
      if (err) {return console.log(err); }
      .....
```

### Ⅲ-build.js

> 大致与开发环境相同,但是运行`生产环境`的

### Ⅳ-webpack.config.js

>用来定义开发环境与生产环境的配置
>
>部分代码与注释

```js
// 是否生成map文件
// cross-env修改
const shouldUseSourceMap = process.env.GENERATE_SOURCEMAP !== "false";
// 是否内联runtime文件
const shouldInlineRuntimeChunk = process.env.INLINE_RUNTIME_CHUNK !== "false";
// 最小转化base64的图片大小
const imageInlineSizeLimit = parseInt(	process.env.IMAGE_INLINE_SIZE_LIMIT || "10000");
// 样式文件正则
const cssRegex = /\.css$/;
const cssModuleRegex = /\.module\.css$/;
const sassRegex = /\.(scss|sass)$/;
// 生成最终webpack开发或生产环境配置的函数
module.exports = function (webpackEnv) {
    // 获取环境变量的方法
	// 加载.env文件的环境变量，REACT_APP_开头
	const env = getClientEnvironment(paths.publicUrlOrPath.slice(0, -1));
    	// 获取处理样式文件loader的函数
	const getStyleLoaders = (cssOptions, preProcessor) => {}
   // webpack配置对象
	return {
		mode: isEnvProduction ? "production" : isEnvDevelopment && "development",
		// 如果该变量为true(生产环境),则代码出错终止打包
		bail: isEnvProduction,
		devtool: isEnvProduction? shouldUseSourceMap? "source-map" // 生产环境
				: false: isEnvDevelopment && "cheap-module-source-map", // 开发环境
    }
    // 添加 /* filename */ 注释到输出的文件中
	pathinfo: isEnvDevelopment,
    // 默认 / ，可以通过package.json.homepage.
	publicPath: paths.publicUrlOrPath,
         // 启用压缩
    optimization: {
		minimize: isEnvProduction,
		minimizer: [new TerserPlugin({})]// 压缩js
       }
    
	// 是否内联runtime文件：少发一个请求
	isEnvProduction &&
		shouldInlineRuntimeChunk &&
		new InlineChunkHtmlPlugin(HtmlWebpackPlugin, [/runtime-.+[.]js/]),
	// 解析index.html中 &PULBLIC_URL%
	new InterpolateHtmlPlugin(HtmlWebpackPlugin, env.raw),
	// 给ModuleNotFound更好提示
	new ModuleNotFoundPlugin(paths.appPath),
	// 定义环境变量
	new webpack.DefinePlugin(env.stringified),
	// 开发环境下：HMR功能
	isEnvDevelopment && new webpack.HotModuleReplacementPlugin(),
	// 文件路径：严格区分大小写
	isEnvDevelopment && new CaseSensitivePathsPlugin(),
	// 监视node_modules，一旦发生变化可以重启dev server
	// See https://github.com/facebook/create-react-app/issues/186
	isEnvDevelopment &&
		new WatchMissingNodeModulesPlugin(paths.appNodeModules),
		// 提取css成单独文件
	isEnvProduction &&
		new MiniCssExtractPlugin({})

}
```





# 二、Vue中的配置分析

>将基于脚手架4.x版本的vue2.x配置进行分析,大致内容与react无太大区别
>
>1、卸载老版本vuecli（1.x， 2.x）:`npm uninstall vue-cli -g`或者`yarn global remove vue-cli`
>
>2、安装最新的vuecli:`npm install -g @vue/cli`
>
>3、`vue create project-name`,选择创建vue2.x,vue2与3版本的weback配置差不多
>
>4、vue并没有提供将webpack配置直接暴露出来的命令,但是提供了另外一种方法让我们能审查vue里面的配置,通过指令将单独的配置单独打包成单独的文件
>
>​	Ⅰ-`vue inspect --mode=development > webpack.dev.js` :将webpack的开发环境单独打包
>
>​	Ⅱ-`vue inspect --mode=production > webpack.prod.js` :将webpack的生产环境单独打包
>
>​	Ⅲ-生成后的文件会报错,想要取消报错,在最前面用`module.exports=`将其暴露出去,就不会报错了





# 三、loader

### Ⅰ-编写一个简单的loader

>loader本质上是一种函数,此处创建一个js编写loader

```js
//loader1.js
module.exports = function (content, map, meta) {
  console.log(content,"------------------------------------");
  return content
}
```

> 1、如不配置loader解析规则,默认路径是`node_modules`,所以平时使用`style-loader`等都不用加路径
>
> webpack.config.js

```js
const path = require('path');
module.exports = {
  module: {
    rules: [
      {
        test: /\.js$/,
        loader: 'loader1',//当配置了liader解析规则后写法
        // loader:path.resolve(__dirname,'loaders','loader1') //不写resolveLoader配置的写法
      }
    ]
  },
  // 配置loader解析规则,默认路径是`node_modules`
  resolveLoader: {
    modules: [
      'node_modules',
      path.resolve(__dirname, 'loaders')
    ]
  }
}
```

### Ⅱ-loader的执行顺序

>1、loader是从上往下编译,编译结束后运行的顺序是`从下往上,从右往左 `执行
>
>2、当你有写loader想要先行运行的话,可以加在`pitch`方法上,这样在编译时就会调用,且`从上往下`执行

```js
module.exports = function (content, map, meta) {
  console.log(111111,"------------------------------------");
  return content
}
module.exports.pitch = function () {//编译时从上往下调用
  console.log('pitch 111');
}
```

### Ⅲ-同步&异步loader

> 1、`this.callback()`:同步的方法  -->可以替代`return`

```js
module.exports = function (content, map, meta) {
  console.log(111111,"------------------------------------");
  this.callback(null, content, map, meta);
	//是否有错误,需要传递的内容(处理后的内容) ,可选参数,可选参数
}
```

> 2、`this.async()`:异步的方法
>
> ​	使用`this.async()`方法会使整个loader停住,只有当你再次调用`callback`方法才会继续执行,整体性能会好过同步,`推荐使用`

```js
// 异步loader
module.exports = function (content, map, meta) {
  console.log(222);
  const callback = this.async();
  setTimeout(() => {
    callback(null, content);
  }, 1000)
}

```

### Ⅳ-获取&校验loader的options

> 1、需要下载依赖:`npm i loader-utils -D`
>
> 2、需要下载依赖:`schema-utils`

```js
//webpack.config.js传入
{	loader: 'loader3',
    options: {
        name: 'jack',
        age: 18 //当校验文件追加属性调为false,将会报错
    }
}
------------------------------------------------------------------------------------
//loader3.js
// loader本质上是一个函数
const { getOptions } = require('loader-utils');
const { validate } = require('schema-utils');
const schema = require('./schema');
module.exports = function (content, map, meta) {
  // 获取options
  const options = getOptions(this);
  console.log(333, options);
  // 校验options是否合法
  validate(schema, options, {
    name: 'loader3'
  })
  return content;
}
```

> 校验文件:定义校验规则

```json
{
  "type": "object",//指定options的类型
  "properties": { //定义options里面有什么属性
    "name": {	//定义有name类型
      "type": "string",	
      "description": "名称～"	//定义描述,可以随便写
    }
  },
  "additionalProperties": false //代表是否可以运行追加其他属性
}
```

### Ⅴ-自定义babel-loader

> webpack.config.js配置

```js
module.exports = {
  module: {
    rules: [{
      test: /\.js$/,
      loader:'babelLoader',
      options:{ presets:['@babel/preset-env'] }
    }]
  },
  // 配置loader解析规则,默认路径是`node_modules`
  resolveLoader: {  modules: [ 'node_modules',path.resolve(__dirname, 'loaders')]}
}
```

> babelLoader.js  -->中间大写是防止与自带的babelloader冲突

```js
const { getOptions } = require('loader-utils');
const { validate } = require('schema-utils');
const babel = require('@babel/core');
const util = require('util');
const babelSchema = require('./babelSchema.json');
//babel.transfrom用来编译代码的方法,是一个普通异步方法
//util.promisify会将普通异步方法转换成基于promise的异步方法
const transform=util.promisify(babel.transform)

module.exports = function (content, map, meta) {
  //获取loader的options配置
  const options = getOptions(this) || {};
  //校验babel的options的配置
  validate(babelSchema,options,{
    name:'Babel Loader'
  })
  //创建异步
  const callback=this.async();
  //使用babel编译代码
  transform(content,options)
  .then(({code,map})=>callback(null,code,map,meta))
  .catch((e)=>callback(e))
}
```

> 校验文件:babelSchema.json

```json
{
  "type": "object",
  "properties": {
    "presets": {
      "type": "array"
    }
  },
  "addtionalProperties": true
}
```









































