# #说明

>各种对于网络请求的封装,不同时间会有不同需求,当然,写法也更简洁
>
>笔记分享：[hongjilin](https://gitee.com/hongjilin)
>转载请注明出处。



# 一、axios封装写法1 -`2020`

>该模块封装于2020疫情本人撰写 [nodejs+vue搭建校园疫情防控系统实战项目(全栈项目)](https://www.bilibili.com/video/BV1Z54y1y79p?share_source=copy_web)项目期间,主要用于项目中前端部分前后端交互功能实现中
>
>文件上传模块 [hongjilin](https://gitee.com/hongjilin) 2020年7月29日

## Ⅰ-代码示例

>该代码用于`Vue项目`中
>
>```js
>//main.js
>
>import axios from 'axios'
>axios.defaults.baseURL = 'http://localhost:3000';
>/**
> * //封装axios方法,为不需要登录操作时使用,也可以提前传入token
> * @param options 配置
> */
>let Axios= (options)=>{
>    axios({
>        url:options.url,
>        method:options.method||'POST',
>        data: options.data,
>        params: options.data
>    }).then(result=>{
>        if (options.success)  options.success(result.data)
>    }).catch(err=>{
>        let msg = err.response ? err.response.data:'请求异常'
>        if (options.error){
>            options.error(msg)
>            Message.error({message: msg, offset: 150});
>        }else {
>            Message.error({message: msg, offset: 150});
>        }
>    })
>}
>//不拦截的(不带token)往往用在vue创建前的生命周期中
>Vue.prototype.$Axios = Axios
>```

## Ⅱ-使用示例

>使用时因为是在main中将其挂载在了`Vue实例上`,所以可以直接`this`进行调用
>
>```js
>  this.$Axios({
>      url: "/students/gethealthNowDay",
>      method: "get",
>      data: {},
>      success: (result) => { ... },
>    });
>```

# 二、axios封装写法2-`2021`

> 本代码于2021年在`react`项目中进行使用

## 1、带token进行请求

### 代码示例

>默认带`token`进行请求
>
>1. `axios.defaults.withCredentials`:登录之后的请求会带登录用户信息，需要把登录时的cookie设置到之后的请求头里面。而跨域请求要想带上cookie，必须要请求属性withCredentials=true，这是浏览器的同源策略导致的问题：不允许JS访问跨域的Cookie。
>     withCredentials 属性是一个Boolean类型，它指示了是否该使用类似cookies,authorization，headers(头部授权)或者TLS客户端证书这一类资格证书来创建一个跨站点访问控制（cross-site Access-Control）请求。
>2. `cancelTokenSource`:取消ajax请求的
>
>```tsx
>import axios from 'axios';
>const cancelTokenSource = axios.CancelToken.source();
>const API_HOST='https://gitee.com/hongjilin/hongs-study-notes'
>axios.defaults.withCredentials = true; //允许跨域携带cookie信息
>function handleRequestToken(config: AxiosRequestConfig): void {
>  const { url = '' } = config;
>  const token = "从数据库得到的token";//此处需要从后台获取
>  if (token)  config.headers['Token'] = token;
>   else  cancelTokenSource.cancel();//如果token为空或者错误,取消请求
>}
>
>// 创建axios实例
>const Http = axios.create({
>  timeout: 1000 * 60 * 3,
>  withCredentials: true,   //前面已经设置默认为true,此处可以不设置
>  baseURL: `${API_HOST}`,   //设置基础路径
>  cancelToken: cancelTokenSource.token, //此处于前面存入token相互呼应
>});
>Http.interceptors.request.use(  //请求拦截器,发送请求前运行的代码,主要用来打印日志方便调错
>  (config) => {
>    config.headers['Content-Type'] = 'application/json';
>    config.data = JSON.stringify(config.data);
>    console.warn('--- Http request start ---');
>    console.log(config.method, config.url);
>    console.log(config.data || config.params);
>    console.warn('--- Http request end---');
>    handleRequestToken(config);
>    return config;
>  },
>  (error) => {
>    console.error(error);
>  }
>);
>Http.interceptors.response.use( //响应拦截器
>  (response) => {
>    const data = response.data;
>    // 打印结果
>    console.error('--- Http response start ---');
>    console.log(response.config);
>    console.log(response.config.url);
>    console.log(response.data);
>    console.error('--- Http response end ---');
>    return data;
>  },
>  (error) => {
>    console.info('网络异常');
>    return Promise.reject(error);
>  }
>);
>
>export default Http;
>
>```

## 2、不带token进行请求

### 代码示例

>```jsx
>import axios from 'axios';
>const cancelTokenSource = axios.CancelToken.source();
>const API_HOST='https://gitee.com/hongjilin/hongs-study-notes'
>axios.defaults.withCredentials = true;
>// 创建axios实例
>const NologinHttp = axios.create({
>  timeout: 1000 * 60 * 3,
>  withCredentials: true,
>  baseURL: `${API_HOST}`,
>  cancelToken: cancelTokenSource.token,
>});
>NologinHttp.interceptors.request.use(
>  (config) => {
>    config.headers['Content-Type'] = 'application/json';
>    config.data = JSON.stringify(config.data);
>    console.warn('--- NologinHttp request start ---');
>    console.log(config.method, config.url);
>    console.log(config.data || config.params);
>    console.warn('--- NologinHttp request end---');
>    return config;
>  },
>  (error) => {
>    console.error(error);
>  }
>);
>NologinHttp.interceptors.response.use(
>  (response) => {
>    const data = response.data;
>    // 打印结果
>    console.error('--- NologinHttp response start ---');
>    console.log(response.config);
>    console.log(response.config.url);
>    console.log(response.data);
>    console.error('--- NologinHttp response end ---');
>    return data;
>  },
>  (error) => {
>    console.info('网络异常');
>    return Promise.reject(error);
>  }
>);
>
>export default NologinHttp;
>```

## 3、使用示例

>此处分为两处代码,方便项目模块化开发,也可以直接在`2`处调用
>
>1. CompanyApi声明--即`调用`请求
>
>   ```tsx
>   import { Http } from '~/utils';
>   interface IsPage{
>     current:number,
>     pageSize:number
>   }
>   export const CompanyApi = {
>     /**
>      * 
>      * @param params 传入参数
>      * @param page {current,pageSize} 当前页码与页码数
>      * @returns 
>      */
>     getCompanyInfo(params, page:IsPage) {
>       // return Http({
>       // //服务端有要求: 将页数和页码拼接进url中 "/app/console/xxxx/1/10 ?name=" 这种格式
>       //   url: '/app/console/company/' + currentPage + '/' + pageSize,
>       //   method: 'GET',
>       //   params,
>       // });
>       return Http.get(`/app/console/xxxx/${page.current}/${page.pageSize}/`,{params})
>     },
>     getIpInfo(params: any,page:IsPage) {
>       return Http.get(`/app/console/xxxx/ip/${page.current}/${page.pageSize}/`,{params})
>     },
>     getShopInfo(params: any,page: IsPage) {
>       return Http.get(`/app/console/xxxx/store/${page.current}/${page.pageSize}/`,{params})
>     },
>   };
>   
>   ```
>
>2. 请求后对数据处理
>
>   ```tsx
>   import { CompanyApi } from '~/api';
>   const { getIpInfo } = CompanyApi;
>   getData = async () => {
>       try {
>         const params = getParams(this.searchParams);//获取用户输入参数
>         this.searchParams.loading = true; //加载中效果
>         let result: IResult = await getIpInfo(params, this.page);
>         if (result?.code !== 200) SuperNotification.error({ msg: result?.message });
>         this.datas = result?.data?.data || [] 
>         this.page.total = result?.data?.total || 0
>       }
>       catch (error) {
>         SuperNotification.error({ msg: error });
>       } finally {
>         this.searchParams.loading = false;
>       }
>     }
>   ```
>
>   