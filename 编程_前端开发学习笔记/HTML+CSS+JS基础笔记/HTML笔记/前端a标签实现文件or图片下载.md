# #说明

>参考资料:简书的 伴歌知行的[JS下载图片和文件，防止浏览器直接打开](https://www.jianshu.com/p/b9dd865b22f2) 、[夜半修仙](https://www.jianshu.com/p/f26bd8da174f),;CSDN的weixin_3791475的[使用a标签下载文件不跳转](https://blog.csdn.net/weixin_37914752/article/details/111902504);



# #目录

>[TOC]



# 前端利用a标签实现文件[图片]下载

> 利用`a标签`或者是`window.open()`实现下载



# 文件下载常用方式

>1. `<a href="http://127.0.0.1:3000/upload/hongjilin.png">下载</a>`  a标签访问文件地址
>2. `window.open('http://127.0.0.1:3000/upload/hongjilin.png')`  打开文件地址
>3. 后端提供一个接口 `/api/download` 通过接口返回文件流
>
>浏览器通过请求头`Content-Type`中的MIME类型（**媒体类型**，通常称为 **Multipurpose Internet Mail Extensions** 或 **MIME** 类型，如 ：`image/jpeg` `application/pdf`）识别数据类型，对相应的数据做出相应处理，对于图像文本等浏览器可以直接打开的文件，默认处理方式就是打开，为了避免浏览器直接打开文件我们需要做一些处理；`详情看下方实现部分`

# 总结分析

>1. 所有情况通用的方式： 后端设置下载请求的响应头 `Content-Disposition: attachment; filename="filename.jpg"`
>   - `attachment` 表示让浏览器强制下载
>   - `filename` 用于设置下载弹出框里预填的文件名
>2. **非跨域**情况下 给a标签加上 `download` 属性，如 `<a href="url" download="xxx.png"></a>`
>   - `download` 里写文件名 注意后缀 (值非必填)
>3. 通过请求解决跨域问题 动态创建a标签通过blob形式下载,`此部分在下方有体现`

------



# Ⅰ-后端设置下载请求的响应头 `Content-Disposition` 强制下载

>`这是最通用的一种方式 不受跨域和请求方式的影响`
>
>```json
>Content-Disposition: attachment; 
>filename="filename.jpg"
>```
>
>想使用`window.open`实现强制下载的可以用这种方式
>
>**在常规的 HTTP 应答中**，该响应头的值表示对响应内容的展现形式
>
>- inline 表示将响应内容作为页面的一部分进行展示
>- attachment 表示将响应内容作为附件下载，大多数浏览器会呈现一个“保存为”的对话框
>- filename(可选) 指定为保存框中预填的文件名



# Ⅱ-实现[HTMLCanvasElement]类型图片下载

>想对于`HTMLCanvasElement`更详细了解 -->[点我跳转](https://developer.mozilla.org/zh-CN/docs/Web/API/HTMLCanvasElement/toDataURL)
>
>1. 需求场景:
>
>   - 注意:此方法只适用[`HTMLCanvasElement`]类型,[img]不可用此方法
>   - 当你需要将如[`二维码`]之类的图片下载时
>
>2. 实现代码
>
>   ```js
>   //调用此函数即可
>   const downCode = (ref) => {
>     const canvas =  document.querySelector(`#${ref}`);
>     downLoad(saveAsPNG(canvas));
>   };
>   const saveAsPNG = (canvas) => {
>     return canvas.toDataURL('image/png');
>   };
>   const downLoad = (url) => {
>     var oA = document.createElement('a');
>     oA.download = '邀请二维码'; // 设置下载的文件名
>     oA.href = url;
>     document.body.appendChild(oA);
>     oA.click();
>     oA.remove(); // 下载之后把创建的元素删除
>   };
>   ```
>
>3. 调用示例:`二维码下载`
>
>   ```tsx
>    <div className={style.codeBox}>
>      <QRCode
>        id="qrid"
>        className={style.code}
>        value={'https://portrait.gitee.com/uploads/avatars/user/2858/8575316_hong-jilin_1611225712.png'}
>        size={165}
>      />
>      <div className={style.codeText}>h5二维码
>        <a onClick={() => downCode('qrid')}>
>          下载
>        </a>
>      </div>
>    </div>
>   ```
>
>4. 结果示例
>
>   ![image-20210720183515309](HTML笔记中的图片/image-20210720183515309.png)

# Ⅲ- a标签+download属性

>当`url`是同源（`同域名、同协议、同端口号`）时，这种情况用 a标签加download属性的方式即可，download属性指示浏览器该下载而不是打开该文件，同时该属性值即下载时的文件名；
>
>`注意`:此方法会导致一个问题,当你下载图片的URL是`远程图片url`时,`将不是下载该文件而是打开该文件`
>
>1. 错误示例代码-->(将远程`url`换成本地图片url即正确)
>
>   ```tsx
>     <div className={style.codeText}>小程序码
> 	<a download  target='_black' href='https://portrait.gitee.com/uploads/avatars/user/2858/8575316_hong-jilin_1611225712.png?response-content-type=application/octet-stream' >下载二维码</a>
>  </div>
>   ```
> 
>2. 结果:不是下载而是直接打开该url
>
>  ![image-20210720184318548](HTML笔记中的图片/image-20210720184318548.png) 
> 

# Ⅳ-通过接口跨域请求，动态创建a标签，以blob形式下载

>`当接口请求的跨域问题已经解决时`（如Nginx方式）,才可以直接通过请求的方式拿到文件流

### 1、`fetch`请求

>将文件流转为blob格式，再通过a标签的download属性下载
>
>```jsx
> onClick={() => {
>// 用fetch发送请求
>fetch('https://portrait.gitee.com/uploads/avatars/user/2858/8575316_hong-jilin_1611225712.png').then((res) => {
>res.blob().then((blob) => {
>const blobUrl = window.URL.createObjectURL(blob);
>// 这里的文件名根据实际情况从响应头或者url里获取
> const filename = 'hong.jpg';
>const a = document.createElement('a');
>a.href = blobUrl;
>a.download = filename;;
>a.click();
>window.URL.revokeObjectURL(blobUrl);
>});
>});
> }}
>```
>
>上面通过原生fetch请求，动态生成一个a标签实现文件下载
>
>`res.blob()` 该方法是`Fetch API`的response对象方法，该方法将后端返回的文件流转换为返回blob的Promise；`blob(Binary Large Object)`是一个二进制类型的对象，记录了原始数据信息
>
>`URL.createObjectURL(blob)` 该方法的返回值可以理解为一个 指向传入参数对象的`url` 可以通过该`url`访问 参数传入的对象
>
>- 该方法需要注意的是，即便传入同一个对象作为参数，每次返回的`url`对象都是不同的
>- 该`url`对象保存在内存中，只有在当前文档(document)被卸载时才会被清除，因此为了更好的性能，需要通过`URL.revokeObjectURL(blobUrl)` 主动释放

### 2、`xhr`请求

>模拟发送http请求，将文件链接转换成文件流，然后使用a标签download属性进行下载。
>
>```jsx
>/***************** 下载文件  ************************************** */
>function download() {
>  let url =
>    'https://portrait.gitee.com/uploads/avatars/user/2858/8575316_hong-jilin_1611225712.png';
>  let name = 'hong.jpg';
>  // 发送http请求，将文件链接转换成文件流
>  fileAjax(
>    url,
>    function (xhr) {
>      downloadFile(xhr.response, name);
>    },
>    {
>      responseType: 'blob',
>    }
>  );
>}
>
>function fileAjax(url, callback, options) {
>  let xhr = new XMLHttpRequest();
>  xhr.open('get', url, true);
>  if (options.responseType) {
>    xhr.responseType = options.responseType;
>  }
>  xhr.onreadystatechange = function () {
>    if (xhr.readyState === 4 && xhr.status === 200) {
>      callback(xhr);
>    }
>  };
>  xhr.send();
>}
>
>function downloadFile(content, filename) {
>  window.URL = window.URL || window.webkitURL;
>  let a = document.createElement('a');
>  let blob = new Blob([content]);
>  // 通过二进制文件创建url
>  let url = window.URL.createObjectURL(blob);
>  a.href = url;
>  a.download = filename;
>  a.click();
>  // 销毁创建的url
>  window.URL.revokeObjectURL(url);
>}
>----------- 调用 --------------
> <a onClick={() => { download();}}>
>下载二维码
></a>
>
>```

### 3、未跨域报错

>当你没解决跨域时使用此方法会有出现下方报错,所以此方法适用已经解决跨域问题的场景
>
>![image-20210721100056872](HTML笔记中的图片/image-20210721100056872.png)