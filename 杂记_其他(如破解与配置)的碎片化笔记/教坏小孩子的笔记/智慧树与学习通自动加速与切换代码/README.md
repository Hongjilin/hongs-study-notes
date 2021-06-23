# #此文件为方便gitee网站观阅使用专门创建

> 此笔记文件于某一时间截取复制至此,容易存在更新不及时问题,建议观看同级目录下的笔记文件

# #说明

>1. 此代码仅供学习使用,对于前端学习有借鉴作用:dog:同学们还是要好好看网课的,别学坏
>
>2. 网站`节点id`在未来可能会更改,大家可以自己F12点击小蓝鼠标进行查找需要的节点进行修改代码中响应部分
>3. 网页打开相应的网站 F12 或者检查网页  -->Console(控制台)  将代码复制进去 -->`回车`即可

# 一、智慧树加速代码

>```js
>var ti = $("body");
>var video = $(".catalogue_ul1 li[id*=video-] .catalogue_title");
>var i = 1;
>var v = 1;
>video.css("color", "blue");
>console.log("已选取" + video.length + "个小节,并已用蓝色标明,请检查是否有遗漏,如有遗漏,概不负责");
>setTimeout(function () {
>$('.speedTab15').click();
>$('.volumeIcon').click();
>console.log("已进行静音和1.5倍加速");
>}, 3000);
>ti.on("DOMNodeInserted", function (e) {
>if (e.target.textContent == "关闭") {
>console.log("检测到第" + i + "个弹题窗口");
>window.setTimeout(function () {
>// document.getElementById("tmDialog_iframe").contentWindow.document.getElementsByClassName("answerOption")[0].getElementsByTagName("input")[0].click();
>$('#tmDialog_iframe')[0].contentWindow.$('.answerOption input[type="radio"]')[0].click();
>setTimeout(function () {
>$(".popbtn_cancel").click();
>console.log("已关闭");
>}, 1000);
>}, 2000);
>i++;
>} else if (e.target.textContent == "本节视频,累计观看时间『100%』") {
>console.log("检测到视频观看完成，准备跳到下一节");
>$('.next_lesson_bg').find('a').trigger('click');
>console.log("已跳转");
>setTimeout(function () {
>$('.volumeIcon').click();
>$('.speedTab15').click();
>console.log("已进行静音和1.5倍加速");
>}, 6000);
>v++;
>console.log("目前播放了" + v + "个视频");
>}
>});
>```

# 二、学习通加速代码

>```js
>function playVideo(){
>let iframe=$("#iframe").contents().find("iframe").contents();
>    let video=iframe.find("#video_html5_api")[0];//找到video对象
>    if(video == undefined){
>        console.log("没有找到视频播放器");
>        return;
>    }
>    video.play();//播放
>    video.muted=true;//静音
> video.playbackRate=16;//倍速播放 此处2速率播放
> let text=$(".ncells .currents .hideChapterNumber").text().trim();
>    var tid=window.setInterval(function(){
>        let ul=iframe.find(".ans-videoquiz-opts:visible");
>        if(ul){//有题目出现
>            iframe.find(".ans-videoquiz-opts input[value='true']").attr("checked",true);
>            iframe.find(".ans-videoquiz-submit").trigger("click");//ext-gen1045
>        }
>        if(video.ended){//视频播放完
>            console.log(text+"节已播放完")
>        if($(".ncells .currents .roundpointStudent").hasClass("blue")){
>console.log(text+"节任务点已完成")
>let curr=$('.ncells .jobCount').first().next();
>if(curr==undefined){
>console.log('课程已看完');
>clearInterval(tid);
>return;
>}
>curr.click();
>let fun=curr.attr('href').substr(11);
>eval(fun);
>window.setTimeout(function(){
>console.log("正在为你自动播放下一个视频");
>clearInterval(tid);
>playVideo();
>},5000);
>}
>        return;
>        }
>    }, 5000);
>
>    $("div").onmouseout=function(){
>video.play();
>return true;
>}
>}
>function start(){
>let curr=$('.ncells .jobCount').first().next();
>if(curr==undefined){
>console.log('课程已看完');
>clearInterval(tid);
>return;
>}
>curr.click();
>let fun=curr.attr('href').substr(11);
>eval(fun);
>window.setTimeout(function(){
>playVideo();
>},5000);
>}
>start();
>```

# 三、简单演示

> 再次强调,仅供同学们学习使用哈,别举报好人
>
> ![](智慧树与学习通自动加速与切换代码中的图片/代码加速演示1.gif)



