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
>