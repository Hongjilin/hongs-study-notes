# #说明

>此处是杂项工具包,就各种零碎的工具函数整合
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin)



# 一、工具包1--`2020`

>该模块封装于2020疫情本人撰写 [nodejs+vue搭建校园疫情防控系统实战项目(全栈项目)](https://www.bilibili.com/video/BV1Z54y1y79p?share_source=copy_web)项目期间,
>
>当时编程习惯以及编程基础还不是很好,可以自行更正,如赋值解构等知识可以运用其中等

>```js
>/*杂项工具类*/
>
>/**
>* yyyyMMddhhmmss格式常量
>* @type {string}
>*/
>const f14 = "yyyyMMddhhmmss";
>
>/**
>* yyyy-MM-dd hh:mm:ss格式常量
>* @type {string}
>*/
>const f19 = "yyyy-MM-dd hh:mm:ss";
>
>/**
>* 创建一个id
>* 以当前的时间yyyyMMddhhmmss+5位随机数组成一个19位的id
>* @return {string}
>*/
>let newId = function () {
>   let c = new Date().format(f14);
>   let r = Math.round(Math.random()*(100000));
>   return c + r;
>}
>
>/**
>* 获取当前时间yyyyMMddhhmmss的字符串
>* @return {void | string | *}
>*/
>let getDate14 = function () {
>   return new Date().format(f14);
>}
>
>/**
>* 获取当前时间yyyy-MM-dd hh:mm:ss的字符串
>* @return {void | string | *}
>*/
>let getDate19 = function () {
>   return new Date().format(f19);
>}
>
>/**
>* 获取昨天的日期
>* @return {void | string | *}
>*/
>let getYestoday = ()=>{
>   let day1 = new Date();
>   day1.setDate(day1.getDate() - 1);
>   return day1.format("yyyy-MM-dd");
>}
>
>/**
>* 获取当前时间yyyy-MM-dd hh:mm:ss的字符串
>* @return {void | string | *}
>*/
>let getDate10 = function () {
>   return new Date().format('yyyy-MM-dd');
>}
>
>/**
>* 验证字符串长度是否在最大的长度范围内
>* @param str
>* @param maxLength
>* @return {boolean}
>*/
>let validLength = function (str, maxLength) {
>   // 判断字符串是否存在
>   if (!str) {
>       return false;
>   }
>
>   // 判断是否是字符串
>   if (typeof str != 'string') {
>       return false;
>   }
>
>   // 判断字符串长度
>   if (str.length <= maxLength) {
>       return true;
>   } else {
>       return false;
>   }
>}
>
>/**
>* 批量验证长度
>*
>* @param arr [{str:str,maxlength:length}]
>*/
>let validLengthBatch = function (arr) {
>   for (let i = 0, l = arr.length; i < l; i ++) {
>       let item = arr[i];
>       if (!validLength(item.str, item.maxLength)) {
>           console.log(item.str);
>           console.log(item.maxLength);
>           return false;
>       }
>   }
>   return true;
>}
>
>/**
>* 格式化分页页码格式 当pageNo不存在的时候就返回1；
>* @param pageNo
>* @returns {*}
>*/
>let formatPageNo = function (pageNo) {
>   if (pageNo && parseInt(pageNo) > 0) {
>       return parseInt(pageNo);
>   }
>   return 1;
>}
>
>/**
>* 格式化分页每页条数 当pageSize不存在的时候就返回10
>* @param pageSize
>*/
>let formatPageSize = function (pageSize) {
>   if (pageSize && parseInt(pageSize) > 0) {
>       return parseInt(pageSize);
>   }
>   return 10;
>}
>//判断是否为图片格式函数
>let  IsPicture =function(){
>   let strFilter=".jpeg|.gif|.jpg|.png|.svg|.pic|.bmp|"
>   if (this.indexOf('.')>-1){
>       let p=this.lastIndexOf(".")
>       let strPostfix=this.substring(p,this.length)+"|"
>       strPostfix=strPostfix.toLowerCase()
>       if (strPostfix.indexOf(strPostfix)>-1)  return true
>   }
>   return false;
>}
>//时间格式
>Date.prototype.format = function(fmt) {
>   var o = {
>       "M+" : this.getMonth()+1,                 //月份
>       "d+" : this.getDate(),                    //日
>       "h+" : this.getHours(),                   //小时
>       "m+" : this.getMinutes(),                 //分
>       "s+" : this.getSeconds(),                 //秒
>       "q+" : Math.floor((this.getMonth()+3)/3), //季度
>       "S"  : this.getMilliseconds()             //毫秒
>   };
>   if(/(y+)/.test(fmt)) {
>       fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
>   }
>   for(var k in o) {
>       if(new RegExp("("+ k +")").test(fmt)){
>           fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
>       }
>   }
>   return fmt;
>}
>/**
>*
>* @param req
>* @param resp
>*/
>let error=(resp,msg)=>{
>   resp.status(500);
>   resp.send(msg);
>}
>/*验证密码格式函数
>必须为字母加数字且长度不小于8位
>*/
>let CheckPassWord=(password) =>{
>    let str = password;
>    if (str == null || str.length <8) {
>        return false;
>    }
>    let reg1 = new RegExp(/^[0-9A-Za-z]+$/);
>    if (!reg1.test(str)) {
>        return false;
>    }
>    let reg = new RegExp(/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/);
>    if (reg.test(str)) {
>        return true;
>    } else {
>        return false;
>    }
>}
>
>module.exports = {
>   newId,
>   getDate14,
>   getDate19,
>   getDate10,
>   validLength,
>   validLengthBatch,
>   formatPageNo,
>   formatPageSize,
>   getYestoday,
>   error,
>   IsPicture,
>    CheckPassWord
>}
>```





# 二、工具包2-`2021`

>该部分记录于2021年4月,原因是经过半年学习,编程能力有所提升,所需技术不同,所阅读的代码量增加,当然,也有看到好的工具函数摘录
>加上之前的某些杂项工具函数都是`js`,如今多用的`typeScript`,有了不一样的需求与写法

## Ⅰ-代码

>```ts
>class Tool {
>isUndefined = (data: any) => {
>return data === undefined;
>};
>isDefined = (data: any) => {
>return !this.isUndefined(data);
>};
>// 传入一个可执行字符串，并且运行
>evalString = (string: string, needReturn?: boolean) => {
>let newString = string;
>if (needReturn) {
> newString = `return ${string}`;
>}
>let evalFunction = new Function(newString);
>return evalFunction();
>};
>
>/**
>  * 四舍五入保留n位小数
>  */
> roundNumber = (num: number, digits?: number): number => {
>   if (!digits) {
>     return Math.round(num);
>   } else {
>     let digitsPow = Math.pow(10, digits);
>     return Math.round(num * digitsPow) / digitsPow;
>   }
> };
>
> downloadFile = (url: string, filename?: string) => {
>   const a = document.createElement('a');
>  a.href = url;
>   if (filename)  a.download = filename;
>  document.body.appendChild(a);
>   a.click();
> };
>
>isProductionEnv = () => {
>   return process.env.API_ENV === 'prod';
> };
>
>//选中文本
> textSelect = (element) => {
>   const start = 0;
>   const end = element.value.length;
>  if (element.createTextRange) {
>     //IE浏览器
>     var range = element.createTextRange();
>     range.moveStart('character', -end);
>     range.moveEnd('character', -end);
>     range.moveStart('character', start);
>     range.moveEnd('character', end);
>     range.select();
>   } else {
>     element.setSelectionRange(start, end);
>     element.focus();
>   }
> };
> //公用排序方法
> setSorter = (field: string, order: string): Object => {
>   let sorter: Object;
>   if (order) {
>     sorter = {
>       field: field,
>       order: order.replace('end', ''),
>     };
>   }
>   return sorter;
> };
>
> // 节流
> throttle = (fn: Function, interval: number) => {
>   let canRun = true;
>   return () => {
>    if (!canRun) {
>       return;
>     }
>     canRun = false;
>     setTimeout(() => {
>       fn();
>       canRun = true;
>     }, interval);
>   };
> };
>
> // 防抖
> deBounce = (
>   fn: (...args: any[]) => any,
>   interval: number
>): ((...args: any[]) => any) => {
>   let timer = null;
>   return (e) => {
>     if (timer) {
>       clearTimeout(timer);
>       timer = null;
>     }
>     timer = setTimeout(() => {
>       fn(e);
>     }, interval);
>   };
> };
>/**
>  * 防抖1
>  * @param fnc 传入函数
>  * @param params 
>  * @param t 
>  * @returns 
>  调用示例:onClick={tool.DebounceSendSMSCode(sendSMSCode, [phoneItem, index], 300)}
>  */
>   DebounceSendSMSCode = (fnc,params, t) => {
>    let delay = t || 200; // 默认0.2s
>    let timer;
>    return function () {
>      if (timer) {
>        clearTimeout(timer);
>      }
>      timer = setTimeout(() => {
>        timer = null;
>        fnc(...params)
>      }, delay);
>    }
>  }
>
> 
> // 深拷贝
> deepClone = (obj) => {
>   const isObject = (args) =>
>     (typeof args === 'object' || typeof args === 'function') &&
>    typeof args !== null;
>   if (!isObject) throw new Error('Not Reference Types');
>   let newObj = Array.isArray(obj) ? [...obj] : { ...obj };
>   Reflect.ownKeys(newObj).map((key) => {
>     newObj[key] = isObject(obj[key]) ? this.deepClone(obj[key]) : obj[key];
>   });
>   return newObj;
> };
>}
>export const tool = new Tool();
>export default Tool;
>```
>
>