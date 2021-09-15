# 好用的工具或者依赖

> 此笔记Mark觉得好的工具或者依赖,方便他人也是防止自己忘记

## 1、serve 前端依赖

> 让你免写nodejs服务器代码,直接将代码作为静态资源暴露出去
>
> `npm i serve -g` -->`serve -s build` 启动服务器，将build目录下所有资源作为静态资源暴露出去

## 2、Markdown Shortcuts

>`vscode`预览`md笔记文件`插件
>
>打开vscode商店,搜索`Markdown Shortcuts`,点击安装
>
>安装完毕，重启VSCode，然后打开.md文件。`Ctrl + Shift + V`，即可预览。然后双击相应位置即可修改对应内容

## 3、uTools 

> 官网链接:[官网链接](https://u.tools/)
>
> uTools 是一个极简、插件化、跨平台的现代桌面软件。通过自由选配丰富的插件，打造你得心应手的工具集合。
>
> 通过快捷键（默认 `alt + space` ）就可以快速呼出这个搜索框。它相当聪明，你可以往输入框内粘贴文本、图片、截图、文件、文件夹等等，能够处理此内容的插件也早已准备就绪，统一的设计风格和操作方式，助你高效的得到结果。
>
> 一旦你熟悉它后，除了能够为你节约大量时间，不中断、无干扰，让你可以更加专注地改变世界。
>
> 最简单的，uTools 可以作为一个程序快速启动器，支持英文、英文驼峰、中文拼音、拼音首字母来打开你的本地程序。除程序外， win10 和 macOS 用户还可以快速搜索并打开「控制面板」内的细项。总之，你只要还记得一个大概的名字，直接输入基本都能找到。

## 4、json-server

>1. 作为一个前端开发工程师，在后端还没有ready的时候，不可避免的要使用mock的数据。很多时候，我们并不想使用简单的静态数据，而是希望自己起一个本地的mock-server来完全模拟请求以及请求回来的过程。json-server是一个很好的可以替我们完成这一工作的工具。我们只需要提供一个json文件，或者写几行简单的js脚本就可以模拟出RESTful API的接口。
>2. 安装json-server
>    `npm install -g json-server`
>3. 创建db.json
>    在一个文件夹下新建一个db.json文件
>
>```json
>{
> "posts": [
>   { "id": 1, "title": "json-server", "author": "typicode" }
> ],
> "comments": [
>   { "id": 1, "body": "some comment", "postId": 1 }
> ],
> "profile": { "name": "typicode" }
>}
>```
>
>4. 启动json-server
>    在当前文件夹下输入如下命令：`json-server db.json`
>5. [文档](https://github.com/typicode/json-server)

## 5、Redis数据库免安装版

>1) REmote DIctionary Server(Redis) 是一个由 Salvatore Sanfilippo 写的 key-value 存储系统，是跨平台的非关系型数据库。2 ) Redis 是一个开源的使用 ANSI C 语言编写、遵守 BSD 协议、支持网络、可基于内存、分布式、可选持久性的键值对(Key-Value)存储数据库，并提供多种语言的 API。 3) 通常被称为数据结构服务器，因为值（value）可以是字符串(String)、哈希(Hash)、列表(list)、集合(sets)和有序集合(sorted sets)等类型。
>
>`很常用`,但是有时候项目有用到Redis,``但是临时用别人电脑运行项目无法运行``,重新去下载安装又很麻烦,所以我这里分享一下免安装版本的,只要下载压缩包后解压,双击运行其中的`redis-server.exe`即可运行此数据库
>
>下载地址[百度云下载](https://pan.baidu.com/s/1l6hVNELCkUB7bEpuCTk2ZQ ) 提取码：hjl6 

## 6、Postwoman(ApiDebug) http接口测试工具

>Postwoman（原apiDebug） 是一个完全免费的接口调试插件，该插件可独立使用，同时数据也能同步至云端，实现跨终端共享。Postwoman支持post、get、xml、josn等测试，支持环境切换（全局变量）。 相比于Postman等插件，Postwoman无需跨过长城即可安装使用，同时有完善的接口管理系统（postwoman.cn 可内网部署），Postwoman支持接口、文档等管理等。产品开发来着BAT，拥有丰富的接口开发、调试经验，产品不断更新迭代，更适合国内用户使用。
>
>这个是`chrome浏览器插件`,所以使用非常方便
>
>[视频介绍](https://www.bilibili.com/video/BV1kv411B7j5/) 下载地址:[插件](https://gitee.com/CrapApi/resources/blob/master/Postwoman%E6%8F%92%E4%BB%B6/postwoman.v.1.1.7.zip)



## 7、Infinity新标签页浏览器插件

>一款好看且带跨浏览器云同步的新标签页,可以收录整合你喜欢的一些网站,非常好用,强烈推荐
>
>可以直接浏览器拓展商店直接下载

