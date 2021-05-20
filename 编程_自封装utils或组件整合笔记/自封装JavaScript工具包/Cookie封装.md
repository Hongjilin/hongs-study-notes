# #说明

>各种对于`Cookie`操作的简单封装
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin)

# 一、Cookie封装 -`2021`

## Ⅰ-代码示例

>```tsx
>const Cookie = {
>  delCookie: (name) => {
>    const Days = -1;
>    const exp = new Date();
>    const value = Cookie.getCookie(name);
>    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
>    document.cookie =
>      name + '=' + escape(value) + ';expires=' + exp.toUTCString();
>  },
>
>  setCookie: (name, value) => {
>    const Days = 30;
>    const exp = new Date();
>    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
>    document.cookie =
>      name + '=' + escape(value) + ';expires=' + exp.toUTCString();
>  },
>
>  getCookie: (name) => {
>    const reg = new RegExp('(^| )' + name + '=([^;]*)(;|$)');
>    const arr = document.cookie.match(reg);
>    if (arr != null) return unescape(arr[2]);
>    else return null;
>  },
>};
>export default Cookie;
>```