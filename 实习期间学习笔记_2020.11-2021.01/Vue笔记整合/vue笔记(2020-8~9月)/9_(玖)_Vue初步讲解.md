# -----------------------==(VUE玖)==-------------------------

# vue初步讲解

## 一.项目包与文件讲解

### 1.babel.config.js

> 有ES6 7高阶语法库和低阶语法库,可以将高阶语法转换成低阶语法

### 2.vue.config.js

> 创建vue.config.js来覆盖之前自带的配置

##### (2.1)发布时去掉.map

```js
module.exports={
    devServer:{
        port:80
    },
    //如果是发布的去掉.map
 productionSourceMap: process.env.NODE_ENV === 'production' ? false : true  
}
```

### 3.src中的assets

> 是被引用的静态

### 4.main.js

> 入口文件,相当于app.js

## 二、安装Express 插件(vscode插件) 

> 测试发布

##### (2.1)  使用自己的注册表修改文件(放在桌面运行,要修改路径)-->.reg文件

```reg
Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\*\shell\VSCode]
@="Open with Code"
"Icon"="E:\\VScode\\Microsoft VS Code\\Code.exe"

[HKEY_CLASSES_ROOT\*\shell\VSCode\command]
@="\"E:\\VScode\\Microsoft VS Code\\Code.exe\" \"%1\""

Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\Directory\shell\VSCode]
@="Open with Code"
"Icon"="E:\\VScode\\Microsoft VS Code\\Code.exe"

[HKEY_CLASSES_ROOT\Directory\shell\VSCode\command]
@="\"E:\\VScode\\Microsoft VS Code\\Code.exe\" \"%V\""

Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\Directory\Background\shell\VSCode]
@="Open with Code"
"Icon"="E:\\VScode\\Microsoft VS Code\\Code.exe"

[HKEY_CLASSES_ROOT\Directory\Background\shell\VSCode\command]
@="\"E:\\VScode\\Microsoft VS Code\\Code.exe\" \"%V\""
```

##### (2.2)使用

```js
 ctrl + shift +p
Epess Hot Curent Wrspac with Random or Number and Open in Bover
```

##### (2.3)关闭

```js
 关闭时候一定要通过 Stop express
```

## 三. (.VUE)文件讲解

#### (3.1)App.vue

> 根组件

#### (3.2) components

> 子组件包

## 四、vue-cli 3.x 的 views 和 components有什么区别？

> 1. components是小组件
> 	2.containers是容器级组件
> 	3.views是页面级组件
> 	
> 	4.也就是说，views是页面级组件，components是小组件，小组件可被引用在views中，一般views组件不被复用【containers是容器级组件（根据	项目大小决定是否使用）】
> 	
> 	5.从组件大小级别区分 components - （containers）- views







## 五、[vue-cli@3.0的vue.config.js最基本配置]

```js
const path = require('path')
module.exports = {
  // 基本路径
  publicPath: process.env.NODE_ENV === 'production'
    ? ''
    : '/',
  // 输出文件目录
  outputDir: process.env.NODE_ENV === 'production' ? 'dist' : 'devdist',
  // eslint-loader 是否在保存的时候检查
  lintOnSave: true,
  /**
   * webpack配置,see https://github.com/vuejs/vue-cli/blob/dev/docs/webpack.md
   **/
  chainWebpack: (config) => {
    // 修复HMR
    config.resolve.symlinks(true)
    const types = ['vue-modules', 'vue', 'normal-modules', 'normal']
    types.forEach(type => addStyleResource(config.module.rule('stylus').oneOf(type)))
  },
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
        'public': path.resolve(__dirname, 'public')
      }
    }
  },
  // 生产环境是否生成 sourceMap 文件
  productionSourceMap: false,
  // css相关配置
  css: {
    // 是否使用css分离插件 ExtractTextPlugin
    // extract: true,
    // 开启 CSS source maps?
    sourceMap: false,
    // css预设器配置项
    loaderOptions: {},
    // 启用 CSS modules for all css / pre-processor files.
    requireModuleExtension: false
  },
  // use thread-loader for babel & TS in production build
  // enabled by default if the machine has more than 1 cores
  parallel: require('os').cpus().length > 1,
  /**
   *  PWA 插件相关配置,see https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-pwa
   */
  pwa: {},
  // webpack-dev-server 相关配置
  devServer: {
    open: true, // 编译完成是否打开网页
    host: '0.0.0.0', // 指定使用地址，默认localhost,0.0.0.0代表可以被外界访问
    port: 8080, // 访问端口
    https: false, // 编译失败时刷新页面
    hot: true, // 开启热加载
    hotOnly: false,
    proxy: null, // 设置代理
    overlay: { // 全屏模式下是否显示脚本错误
      warnings: true,
      errors: true
    },
    before: app => {
    }
  },
  /**
   * 第三方插件配置
   */
  pluginOptions: {}
}

// 全局导入样式
function addStyleResource (rule) {
  rule.use('style-resource')
    .loader('style-resources-loader')
    .options({
      patterns: [
        path.resolve(__dirname, './src/common/stylus/index.styl')
      ]
    })
}
```













