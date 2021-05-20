# #说明

>该部分为文件操作类工具包记录整理 
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin)
>转载请注明出处。

# 一、文件上传 -`2020`

>该模块封装于2020疫情本人撰写 [nodejs+vue搭建校园疫情防控系统实战项目(全栈项目)](https://www.bilibili.com/video/BV1Z54y1y79p?share_source=copy_web)项目期间,主要用于项目中`文件上传,头像上传`等功能
>
>文件上传模块 [hongjilin](https://gitee.com/hongjilin) 2020年7月29日
>
>当时编程习惯还不是很好,如类名命名规范等,可以自行更正

## Ⅰ-封装的工具类代码

>```js
>// 文件工具类
>const fs = require("fs");
>const formidable = require("formidable");
>const tools = require("./tools");  //本人杂项工具类,各种零碎函数封装-->在本工具类中只用到一处,随即生成唯一ID
>
>/**
> * 上传文件
> * @param req
> * @param options 配置formidable和文件路径的相关参数
> *  eg:{
> *      fileDir:"public/file", 文件存放路径 相对于被引用的位置的相对位置，也可以使用绝对路径
> *      maxFileSize :200 * 1024 * 1024， 文件最大的大小 单位byte
> *      fileName:"userIcon.png"
> *  }
> */
>function upload(req, options) {
>    if (!options) {
>        options = {};
>    }
>    // 文件存放目录  该目录是以被引用的位置作为相对位置。
>    var cacheFolder = options.fileDir || 'public/file';
>    if (!fs.existsSync(cacheFolder)) {
>        fs.mkdirSync(cacheFolder);
>    }
>    let form = new formidable.IncomingForm(); //创建上传表单
>    form.encoding = 'utf-8'; //设置编辑
>    form.uploadDir = cacheFolder; //设置上传目录
>    form.keepExtensions = true; //保留后缀
>    form.maxFileSize = options.maxFileSize || 200 * 1024 * 1024; //文件大小
>    form.type = true;
>    return new Promise(function(resolve, reject){
>        form.parse(req, function(err, fields, files) {
>            console.log(`接受到的参数${fields}`)
>            if (err) {
>                // 遗留问题：上传文件异常，不会马上返回，会卡在这边，直到超时
>                console.log(`文件上传异常：${err.message}`);
>                reject({error: err.message});
>            } else {
>                // 重命名
>                let avatarName = options.fileName;
>                if (!avatarName) {
>                    //后缀名
>                    let extName = '';
>                    let fileOriginName = files.file.name;
>                    // 判断是否有后缀名
>                    if (fileOriginName.indexOf(".") > -1) {
>                        let nameArray = fileOriginName.split(".");
>                        extName = '.' + nameArray[nameArray.length - 1];
>                    }
>                    avatarName = tools.newId() + extName;  
>                }
>
>                let newPath = form.uploadDir + '/' + avatarName;
>                fs.renameSync(files.file.path, newPath); //重命名
>                console.log(`文件上传成功：${avatarName}`);
>                resolve(avatarName);
>            }
>        });
>    });
>};
>module.exports = {
>    upload
>};
>
>```

## Ⅱ-使用实例1-上传头像图片

>
>
>```js
>const  fileUp=require('../utils/fileUtils')
>router.post('/upicon',async function (req,res) {
>        let head_imgUrl=await fileUp.upload(req)  //上传成功
>        req.head_imgUrl=head_imgUrl
>         let isPicture= head_imgUrl.IsPicture(); //判断图片格式函数,在别处声明的
>        if (!isPicture) res.send("没有选择图片或者选择的不是图片")
>       ...省略
>})
>```



## Ⅲ-使用示例2-上传`xlsx`文件

>上传`xlsx文件`并进行解析
>
>```js
>var express = require('express');
>var router = express.Router();
>
>let fs=require('fs')
>let formidable =require('formidable')
>let xlsx=require('node-xlsx')
>const  redisUtils=require('../utils/redisUtils')
>
>router.post('/upload',function (req,res) {
>    console.log("############# POST / UPLOAD   ##############")
>    let fileTypeError = false;
>    let target_path =".\\public\\upload";
>    let form = new formidable.IncomingForm();
>    form.encoding = 'utf-8';
>    form.keepExtensions = true;
>    form.maxFieldsSize = 10 * 1024 * 1024;
>    form.uploadDir = target_path;
>
>    let files=[];
>    let fields=[]
>
>    form.on('field',function (field,value) {
>        fields.push([field,value])
>    })
>    form.on('file',function (field,file) {
>        console.log("fileName:"+ file.name)
>     let filext=file.name.substring(file.name.lastIndexOf("."),file.name.length)
>        if (filext!='.xlsx'){
>            redisUtils.set('xlsxData','err',3600)
>            fileTypeError=true
>        }else{
>            fileTypeError= false
>            return
>        }
>        files.push([field,file])
>    });
>    form.on('end',async function () {
>        //遍历上传的文件
>        let fileName=''
>        let obj=''
>        let exfalg=true
>        let folder_exists=await fs.existsSync(target_path)
>        if (folder_exists) {
>            let dirList=await fs.readdirSync(target_path)
>            console.log("dirList:",dirList)
>            dirList.forEach(item=>{
>                if (!fs.statSync(target_path + '\\' + item).isDirectory()){
>                    fileName=target_path+'\\'+item;
>                    if (!fileTypeError){
>                        obj=xlsx.parse(fileName)
>                        redisUtils.set("xlsxData",JSON.stringify(obj),3600)
>                        res.send({"rtnCode":"1","rtnInfo":"成功导入数据","data":obj})
>                    }else {
>                        //解析失败的
>                        res.send({"rtnCode":"1","rtnInfo":"文件格式不对"})
>                        exfalg=false
>                    }
>                    fs.unlinkSync(fileName)
>                }else{
>                    res.send({"rtnCode":"1","rtnInfo":"系统错误"})
>                    return
>                }
>            })
>        }
>    })
>    form.on('error',function (err) {
>        res.send({"rtnCode":"1","rtnInfo":"上传出错"})
>    })
>    form.on('aborted', function() {
>        res.send({"rtnCode": "1", "rtnInfo": "放弃上传"});
>    });
>    form.parse(req)
>})
>module.exports = router;
>```
>
>