# #说明

>本笔记为`尚硅谷axios入门与源码解析`的学习笔记
>
>该课程主要讲述 axios的API、源码分析、模拟实现重要功能
>
>课程预备知识点: `HTTP` ajax promise  
>
>`ps`:大学时候的课程一定要好好学,不然迟早要还的,留下了不学无术的眼泪:cry:
>
>仅供本人`洪`学习使用
>
>​												记录时间: 2021-3-15晚启

## 预备工具

>1. 作为一个前端开发工程师，在后端还没有ready的时候，不可避免的要使用mock的数据。很多时候，我们并不想使用简单的静态数据，而是希望自己起一个本地的mock-server来完全模拟请求以及请求回来的过程。json-server是一个很好的可以替我们完成这一工作的工具。我们只需要提供一个json文件，或者写几行简单的js脚本就可以模拟出RESTful API的接口。
>2. 安装json-server
>   `npm install -g json-server`
>3. 创建db.json
>   在一个文件夹下新建一个db.json文件
>
>```json
>{
>  "posts": [
>    { "id": 1, "title": "json-server", "author": "typicode" }
>  ],
>  "comments": [
>    { "id": 1, "body": "some comment", "postId": 1 }
>  ],
>  "profile": { "name": "typicode" }
>}
>```
>
>4. 启动json-server
>   在当前文件夹下输入如下命令：`json-server db.json`