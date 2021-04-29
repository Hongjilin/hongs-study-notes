# #说明

>本工具包是对`localStorage`与`sessionStorage`存取的简单封装,方便使用
>
>作者：[hongjilin ](https://gitee.com/hongjilin)  时间:2021年4月
>著作权归作者所有。转载请注明出处。

# Ⅰ-工具类代码-`2021`

>```tsx
>//LocalStorage.ts
>const LocalStorage = {
>set: (name: string, value) => {
>if (!value) {
> throw new Error('请传入正确的值');
>}
>if (typeof value === 'object') {
> localStorage.setItem(name, JSON.stringify(value));
>} else {
> localStorage.setItem(name, value);
>}
>},
>
>get: (name: string): any => {
>let temp = localStorage.getItem(name);
>if (temp) {
> try {
>   temp = JSON.parse(temp);
> } catch (err) {
>   console.error(err);
> }
>}
>return temp;
>},
>
>remove: name => {
>localStorage.removeItem(name);
>}
>};
>
> const SessionStorage = {
>set: (name: string, value) => {
>if (!value) {
> throw new Error('请传入正确的值');
>}
>if (typeof value === 'object') {
> sessionStorage.setItem(name, JSON.stringify(value));
>} else {
> sessionStorage.setItem(name, value);
>}
>},
>
>get: (name: string): any => {
>let temp = sessionStorage.getItem(name);
>if (temp) {
> try {
>   temp = JSON.parse(temp);
> } catch (err) {
>   console.error(err);
> }
>}
>return temp;
>},
>
>remove: name => {
>sessionStorage.removeItem(name);
>}
>};
>export default LocalStorage
>export{
>SessionStorage,LocalStorage
>}
>```

# Ⅱ-使用示例

>```tsx
>import { LocalStorage } from '~/utils';
> LocalStorage.set("KEY", data);//存
>let data=LocalStorage.get('KEY') //取
>```