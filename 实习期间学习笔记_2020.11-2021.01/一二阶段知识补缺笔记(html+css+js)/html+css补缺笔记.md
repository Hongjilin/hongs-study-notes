## 1、图片不拉伸属性 ` object-fit`

```css
   width: 100%;
        height: 100%;
        object-fit: cover;
```

## 2、css鼠标点击的五种状态

```css
  1、a:link{color:#fff}  未访问时的状态（鼠标点击前显示的状态）
  2、a:hover{color:#fff}  鼠标悬停时的状态
  3、a:visited{color:#fff}  已访问过的状态（鼠标点击后的状态）
  4、a:active{color:#fff}  鼠标点击时的状态
  5、a:focus{color:#fff}  点击后鼠标移开保持鼠标点击时的状态（只有在<a href="#"></a>时标签中有效）
```

## 3、阴影效果

```css
box-shadow:2px 2px 5px #000; 	//正常
box-shadow:inset 2px 2px 5px #000; //内阴影
box-shadow:0px 0px 5px 10px #000;//拓展阴影长度
box-shadow:0px 0px 0px 3px #bb0a0a,
           0px 0px 0px 6px #2e56bf,
           0px 0px 0px 9px #ea982e;//多重阴影
```

> 逼真的阴影效果示例

```css
<div class="box11 shadow"></div>
/********************************************/
.box11 {
	width: 300px;
	height: 100px;
	background: #ccc;
	border-radius: 10px;
	margin: 10px;
}

.shadow {
	position: relative;
	max-width: 270px;
	box-shadow: 0px 1px 4px rgba(0,0,0,0.3),
				0px 0px 20px rgba(0,0,0,0.1) inset;
}

.shadow::before,
.shadow::after {
   content:"";
   position:absolute;
   z-index:-1;
}

.shadow::before,
.shadow::after {
   content:"";
   position:absolute;
   z-index:-1;
   bottom:15px;
   left:10px;
   width:50%;
   height:20%;
}

.shadow::before,
.shadow::after {
   content:"";
   position:absolute;
   z-index:-1;
   bottom:15px;
   left:10px;
   width:50%;
   height:20%;
   box-shadow:0 15px 10px rgba(0, 0, 0, 0.7);
   transform:rotate(-3deg);
}

.shadow::after{
   right:10px;
   left:auto;
   transform:rotate(3deg);
 }
```

