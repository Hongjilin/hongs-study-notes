# #说明

>本工具包是对`localStorage`与`sessionStorage`存取的简单封装,方便使用
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin) 

# 一、`localStorage`简单封装

>1. 实现效果:只是对存入取出时自动转换数据格式,减少代码中操作
>
>2. 代码示例
>
>   ```jsx
>   //LocalStorage.ts
>   const LocalStorage = {
>   set: (name: string, value) => {
>   if (!value) throw new Error('请传入正确的值');
>   if (typeof value === 'object') localStorage.setItem(name, JSON.stringify(value));
>    else localStorage.setItem(name, value);
>   },
> 
>   get: (name: string): any => {
>  	 let temp = localStorage.getItem(name);
>  	 if (temp) {
>  	 try {
>     		temp = JSON.parse(temp);
>   	} catch (err) {
>   		console.error(err);
>  	 }
>   }
>   return temp;
>   },
> 
>   remove: name => {
>   localStorage.removeItem(name);
>   }
>   };
>   
>   export default LocalStorage
>   export{ LocalStorage }
>   ```
> 
>   3. 使用示例
> 
>   ```jsx
>   import { LocalStorage } from '~/utils';
>   LocalStorage.set("KEY", data);//存
>   let data=LocalStorage.get('KEY') //取
>   ```



# 二、`SessionStorage`简单封装

>1. 实现效果:只是对存入取出时自动转换数据格式,减少代码中操作
>2. 代码示例
>
>  ```jsx
>  const SessionStorage = {
>  set: (name: string, value) => {
>  if (!value) throw new Error('请传入正确的值');
>  if (typeof value === 'object')  sessionStorage.setItem(name, JSON.stringify(value));
>   else sessionStorage.setItem(name, value);
>  },
> 
>  get: (name: string): any => {
>  	let temp = sessionStorage.getItem(name);
>  	if (temp) {
>  	try {
> 		temp = JSON.parse(temp);
>  	} catch (err) {
>  		console.error(err);
>  	}
>  }
>  return temp;
>  },
> 
>  remove: name => {
>  sessionStorage.removeItem(name);
>  }
>  };
> export{ SessionStorage }
>  ```
> 
> 2. 调用(同上`localStorage简单封装`)

# 三、利用命名空间封装-实现复杂存储

> 命名空间作用:在多人合作写脚本的时候，会发生方法名冲突的情况,用JS的命名空间能解决这个问题,若全局空间中已有同名对象，则不覆盖该对象；否则创建一个新的命名空间,具体效果可以看下面代码例子。
>
> 此js会将大部分需要的功能封装进来,功能更齐全,此封装函数会用到部分`lodash`函数,当然也只是类似防抖这种小功能,但是别人既然写好的而且写的不错就没必要都用自己写的,当然,类似功能我自己也有封装,详见本人[`自封装JavaScript工具包`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E8%87%AA%E5%B0%81%E8%A3%85utils%E6%88%96%E7%BB%84%E4%BB%B6%E6%95%B4%E5%90%88%E7%AC%94%E8%AE%B0/)
>
> 相关知识点详解请看本人[`前端-(html+css+js)笔记中的js部分`](https://gitee.com/hongjilin/hongs-study-notes/tree/master/%E7%BC%96%E7%A8%8B_%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0),内部本人对命名空间及闭包等概念进行了详细记录

## Ⅰ-需求场景分析

> 举个栗子:当我们同一项目有两个客户端,登录后我们要分别将其登录数据存入本地,如:token userData等,但明明都属于登录时的数据,为了方便归类也为了防止本地变量混乱,就可以使用此方法,这样我们可以有效区分本地存储数据,并且使用方便

## Ⅱ-功能实现

>本地存储的增删改查,并且通过命名空间,闭包的相关知识,可以很轻松的将不同常量直接添加到一个对象变量中并存到本地
>
>![image-20210521202047347](JavaScirpt工具封装中的图片/本地存储(LocalStorage、Session)相关封装中的图片.png)

## Ⅲ-封装代码实现

>```tsx
>import {
>//检查 value 是否是普通对象.也就是说该对象由 Object 构造函数创建，或者 [[Prototype]] 为 null 。
>isPlainObject,
>//检查 value 是否是 Array 类对象。
>isArray,
>//创建一个 debounced（防抖动）函数
>debounce
>} from 'lodash/fp';
>
>interface Params {
>key: any;
>value?: any;
>}
>
>interface StorageOperate {
>add?: ({ key, value }: Params) => void;
>remove?: ({ key }: Params) => void;
>get?: ({ key }: Params) => any;
>clear?: () => void;
>}
>//LocalStorage 类型
>const LOCALSTORAGE = 'LOCALSTORAGE';
>//Session Storage类型
>const SESSIONSTORAGE = 'SESSIONSTORAGE';
>//对象类型
>const OBJECTSTORAGE = 'OBJECTSTORAGE';
>
>//LocalStorage存储类型的操作函数重写
>const _localStorage: StorageOperate = (() => {
>//将window的localStorage赋值到_db上
>const _db = window.localStorage;
>return {
>//实际上只是二次封装,统一调用方式
>add({ key, value }) {
>// 当调用其add方法函数时,实际上是去调用其`setItem方法`
>_db?.setItem(key, value);
>},
>remove({ key }) {
>_db?.removeItem(key);
>},
>get({ key }) {
>return _db?.getItem(key) || null;
>},
>clear() {
>_db?.clear();
>},
>};
>})();
>//SessionStorage存储类型的操作函数重写
>const _sessionStorage: StorageOperate = (() => {
>const _db = window.sessionStorage;
>return {
>add({ key, value }) {
>_db?.setItem(key, value);
>},
>remove({ key }) {
>_db?.removeItem(key);
>},
>get({ key }) {
>return _db?.getItem(key) || null;
>},
>clear() {
>_db?.clear();
>},
>};
>})();
>//对象存储类型操作函数
>const _objectStorage: StorageOperate = (() => {
>let _db = {};
>return {
>add({ key, value }) {
>_db[key] = value;
>},
>remove({ key }) {
>delete _db[key];
>},
>get({ key }) {
>return _db[key];
>},
>clear() {
>_db = {};
>},
>};
>})();
>
>//声明私有变量_DB对象  此处`db`在构造函数中已经经过判断,转换为特定类型的存储对象了
>const _DB = {
>_get({ db, domain, type }) {
>//根据传入的已经转换的`db`对象调用其获取方法获取本地存储数据
>let _val = db.get({ key: domain });
>let _obj;
>try {
>//如果取得的_val数据是空的,或者获取的类别是对象存储,则赋予`_val(如果_val为空则赋予空对象)`
>//如果不为空,将得到的`_val`数据格式转换为json对象
>_obj = !_val || type === OBJECTSTORAGE ? _val || {} : JSON.parse(_val);
>} catch ($$) {//此处$$只是一个占位,无作用
>//如果发生异常,则直接赋予空对象
>_obj = {};
>}
>return _obj;//最后将处理好的json对象数据返回
>},
>//set写入方法
>_set(obj: any, { db, domain, type }) {
>//如果传入为空,则返回错误
>if (!obj) return false;
>//如果传入的是一个对象或者 是一个数组且类型不为对象存储时,就进行类型转换
>if (isPlainObject(obj) || (isArray(obj) && type !== OBJECTSTORAGE)) obj = JSON.stringify(obj);
>//根据传入的已经转换的`db`对象调用其写入方法写入本地存储数据
>db.add({ key: domain, value: obj });
>return true;
>},
>//删除方法
>_remove({ db, domain }) {
>//根据传入的已经转换的`db`对象调用其删除方法删除本地存储数据
>db.remove({ key: domain });
>},
>};
>
>
>//定义DB类,这里是对于_DB的调用
>class DB {
>source: any = {};
>option = null;
>backup = null;
>
>setOrigin = debounce(10)(function () {
>_DB._set(this.source, this.option);
>});
>
>/**构造函数
>*调用示例 const loginDB = new DB('LOGIN', DB.LOCALSTORAGE);
> * @param param0 {用作存储的key名 , 存储类型 }
> */
>constructor({ domain, storageType = OBJECTSTORAGE }) {
>  this.option = {
>    //用作后续存储的key名,可以省略后续输入
>    domain,
>    //存储类型
>    type: storageType,
>    //通过存储类型判断决定db使用上述什么类型的存储操作函数
>    //以达到同一函数根据不同参数做出不同反应的效果
>    db:
>      storageType === LOCALSTORAGE
>        ? _localStorage //如果是LocalStorage类型
>        : storageType === SESSIONSTORAGE
>          ? _sessionStorage//如果SessionStorage类型
>          : _objectStorage,//如果是其他类型,则用对象存储
>  };
>  //此处是`flag`作用-->当传入的存储类型不是对象存储时为`true`
>  this.backup = storageType !== OBJECTSTORAGE;
>  //当类别不为对象存储时 this.source以该配置信息获取数据,此处得到的数据应是json格式对象或者空对象
>  //此处将其提前存储,后续在构造函数get方法中可以直接调用,节省性能
>  if (this.backup) this.source = _DB._get(this.option);
>}
>
> /** 重新初始化函数
>   * 针对特殊场景防错方法:
>     1. 因为上面_update中调用的`setOrigin()`方法是防抖功能,延迟设置storage来达到防止频繁操作storage(异步操作)
>     2. 但也因为如此,在某些特定场景下导致初始化拿不到数据,举个栗子:
>   		1) 当你同一浏览器开两个本项目页面,当我将storage所有数据清空后或者第一次使用时,先登录一个页面账户,在登陆另一个页面账户
>		2) 登录账户的token是存在storage,那么我在登录第二个账户时,第一个账户的token就会被删除,导致不同账号却能挤下线
>	* 原因:
>	 1. 当你打开两个页面时,其实两个页面都初始化了,这时`this.source`都为undefined,但我在其中一个页面登录后写入,另外一个页面却不会监听到,
>	 2. 导致另一个页面按照storage为空处理,直接覆盖,导致上述情况发生
>	* 解决:
>	    调用时在重新初始化`this.source`即可	
>	* 该函数调用:如上述特殊情况时调用此方法(初始化使用),通常就是这种登录初始化渲染的极端情况
>   */
> syncSource() {
>    if (this.backup)  this.source = _DB._get(this.option);
>  }  
>  
>/**
> * 外部调用的获取函数
> * @param key  获取数据的KEY
> * @param getOriginal 是否强制重新获取 -->因为有可能在构造时传入的是对象存储类型,导致`this.source`为空
> * @returns 
> */
>get(key: string, getOriginal?: boolean ) {
>  //如果`getOriginal`为true时根据构造函数时传入的option获取该类型的Storage 否则直接用调用构造函数时取得的数据
>  //此处是必要的,因为删除后将其置空了,所以置空后再次get就需要此步,否则取不到值
>  const source = getOriginal ? _DB._get(this.option) : this.source
>  //这时候拿到的source其实是一个对象,里面存了多个json对象,这时候根据key获取其中具体的属性,详见运行示例截图
>  return key !== undefined ? source[key] : this.source;//如果key传入空,则直接返回所有
>}
>
>/**
> * 私有--更新方法,即重新写入this.source
> * @param imd 是否进行防抖更新
> */
>_update(imd?: boolean) {
>  if (!imd)  this.setOrigin(); //如果为false,则防抖
>  else  _DB._set(this.source, this.option);//为true则不防抖
>}
>/**
> * 外部调用的写入函数
> * 此处是给实例化后的该json对象写入特定key于value
> * @param key  写入的key
> * @param val  要写入的value
> * @param imd  是否防抖 默认false
> * @returns 
> */
>set(key: any, val: any, imd = false) {
>  //如果传入的key是空的,返回空字符串,并且不写入
>  if (key === undefined) return '';
>  this.source[key] = val; //将source对象中新创一个[key]属性并赋值val
>  this._update(imd); //调用更新,即将this.source重新写入到本地中
>  return true;
>}
>//复制,将传入的对象直接复制到 this.source上,随后直接写入
>assign(obj: any, imd?: boolean) {
>  if (!isPlainObject(obj) && !isArray(obj)) {
>    console.log('value 必须是 object 或 array 类型');
>    return false;
>  }
>  this.source = obj;
>  this._update(imd);
>  return true;
>}
>//删除本地存储
>remove(key?: any, imd?: boolean) {
>  //如果删除不传入key,则删除当前实例下的数据,然后通过调用` _DB._remove`进行删除
>  if (key === undefined) {
>    this.source = {};         //将 this.source置空
>    _DB._remove(this.option); //删除本地存储
>    return;
>  }
>  //如果当前删除特定属性的不为空
>  if (this.source[key] !== undefined) {
>    //如果为数组,且key为下标的话 使用`splice`删除
>    if (isArray(this.source) && /^([1-9]\d*)|0$/.test(key))  this.source?.splice(key, 1);
>    else  delete this.source[key];
>    //删除完后再写入本地
>    this._update(imd);
>  }
>  return true;
>}
>clear() {
>  return this.remove(); //调用上面的remove,不传值即使置空
>}
>}
>
>//导出  且此处使用一个自运行函数形成闭包,即命名空间
>export default (function () {
>//此处是利用闭包的原理,每次调用该实例操作的都是此数,可以理解为此数是盛放所有new DB() 类型的容器
>let store = {};
>let index = 0;
>
>const Storage = function (domain?: string, storageType?: string): void {
>  //如果不传入key 则默认随机生成key且不重复
>  if (!domain) {
>    domain = +new Date() + '-' + index;
>    index++;
>  }
>  //如果不存在该属性,则进行子实例创建,并挂载到store对象上
>  if (!store[domain])  store[domain] = new DB({ domain, storageType });
>  return store[domain];
>};
>//清理函数
>Storage.clear = function (domain?: string) {
>  //如果不传入参数,就将所有类型的全删除
>  if (!domain) {
>    _localStorage.clear();
>    _sessionStorage.clear();
>    _objectStorage.clear();
>    store = {};
>  } else {
>    if (store[domain]) {
>      store[domain].clear();
>      store[domain] = null;
>    }
>  }
>};
>
>Storage.LOCALSTORAGE = LOCALSTORAGE;
>Storage.SESSIONSTORAGE = SESSIONSTORAGE;
>Storage.OBJECTSTORAGE = OBJECTSTORAGE;
>//此处是环境变量配置,不需要
>// const __DEV__ = process.env.NODE_ENV == 'development';
>// if (__DEV__) {
>//   window['abs'] = store;
>// }
>return Storage;
>})();
>
>```

## Ⅳ-调用与使用

>1. 声明创建实例
>
>  ```tsx
>  import DB from '~/utils/DB';
>  //此处可以直接调用到内部的常量是因为有做返回处理
>  //此处可以 `new DB('PLATFORM', "常量名");`这样调用是因为命名空间的原因
>  export const platformDB = new DB('PLATFORM',"常量名");
>  ```
>
>  此处可以 `new DB('PLATFORM', DB.SESSIONSTORAGE);`这样调用是因为命名空间的原因
>
>2. 调用-->此间大写都是常量
>
>  ```tsx
>  //取
>  const tabPanes = platformDB.get("常量名");
>  const activeKey = platformDB.get("常量名");
>  //存
>  platformDB.set("常量名", this.tabPanes);
>  //删
>  platformDB.remove("常量名");
>  ```
>
>3. 重新初始化函数调用  --`针对特殊场景检查`
>
>   ```tsx
>    /**此处有一个BUG :
>         1. 使用同一浏览器,同时打开两个页面,清空LicalStrage后 
>         2. 先后登录 用户端后台和 运维端后台,先登录的那个用户的LicalStrage会被覆盖
>         3. 但是随后继续重新登录后就都不会出问题
>    */
>           if (isEmpty(loginDB.get())) {
>           // 因为loginDB使用对象保存key/value延迟设置storage来达到防止频繁操作storage，
>          //因此在另一个页面清空storage，另一个页面对象在不刷新情况无法初始化感知，针对特殊场景检查。
>           loginDB.syncSource();
>         }
>   ```
> 
>

## Ⅴ-函数概要截图

>![image-20210521202903681](JavaScirpt工具封装中的图片/本地存储(LocalStorage、Session)相关封装中的概要.png)

