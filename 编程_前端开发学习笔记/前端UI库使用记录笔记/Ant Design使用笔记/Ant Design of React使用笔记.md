# #说明

>`antd` 是基于 Ant Design 设计体系的 React UI 组件库，主要用于研发企业级中后台产品。也是是本人目前实习公司所用框架技术之一
>
>本笔记主要记录工作中项目中遇到的`与官方文档有差异化的` 的使用方式、或者是自己对于文档记录的组件的使用,方便自己查阅
>
>此笔记持续更新
>
>本人笔记地址分享:[`全部笔记`](https://gitee.com/hongjilin/hongs-study-notes)

# #目录

>[TOC]

# Ant Design of React 文档

>1. [官方文档地址](https://ant.design/docs/react/introduce-cn)
>
>2. [组件](https://ant.design/components/overview-cn/)



# 一、数据录入

## 1、From表单

### Ⅰ-限制表单中输入框不能为空以及中文

>1. 通过[`From.Item`](https://ant.design/components/form-cn/#Form.Item) 中的 `normalize`属性进行处理对value的处理:组件获取值后进行转换，再放入 Form 中。不支持异步
>
>2. 通过正则替换,将键入的空格以及中文替换为空字符串
>
>3. 代码示例
>
>   ```jsx
>   <Form form={form} onFinish={handleFinish}>
>   <Item
>       label="密码"
>        name="password"
>        rules={[{ required: true, message: '密码不能为空' }]}
>        //密码框不允许为空格,且不允许输入中文
>        normalize={(value) => value.replace(/\s/g, '').replace(/[\u4E00-\u9FA5]|[\uFE30-\uFFA0]/gi, '')
>        }
>      >
>        <Input.Password
>          placeholder="请输入密码"
>          autoComplete="new-password"
>        />
>      </Item>
>    </From>
>   ```

### Ⅱ-自定义校验

>1. 详见[`Rule`](https://ant.design/components/form-cn/#Rule)属性中自定义`validator`
>
>2. 代码示例
>
>   ```jsx
>   <Form form={form} onFinish={handleFinish}>
>       <Item
>         label="用户名"
>         name="username"
>         validateTrigger="onBlur"
>         normalize={(value) => value.replace(/\s/g, '')}
>         rules={[
>          { required: true, message: '用户名不能为空' },
>           {
>             validator: async (_, value) => {
>               if (value == null || value == '')  return Promise.resolve();
>               else {
>                 const res: IResult<IExist> = await ChannelApi.isUserExist( value );
>                 if (res?.data.status) return Promise.reject('用户名已存在');
>                 else  return Promise.resolve();
>               }
>             },
>           },
>         ]}
>       >
>         <Input placeholder="请输入用户名" />
>       </Item>
>    </From>
>   ```

### Ⅲ-表单中动态修改数字输入框的value

>1. 出现场景:在 第一次对[`InputNumber`](https://ant.design/components/input-number-cn/#API)组件输入0时，就自动填充为设置的`min`了，这时我的需求是改成输入框失去焦点时再自动填充为min
>
>2. 用到的组件:`From`、[`InputNumber`](https://ant.design/components/input-number-cn/#API)
>
>3. 代码示例
>
>   ```jsx
>    //最小折扣,用于动态改变最小折扣
>     const [min, setMin] = useState(0);
>   
>   <Form form={form} onFinish={handleFinish}>
>     <Item
>         label="折扣数"
>         name="discount"
>         rules={[{ required: true, message: '推荐码折扣不能为空' }]}
>       >
>         <InputNumber
>           style={{ width: '100%' }}
>           placeholder={DISCOUNT_TIP}
>           // min={0.9}
>           min={min}
>          max={1}
>           step={0.01}
>           precision={2}
>           // 第一次输入推荐码折扣，输入0，就自动填充为0.9了，建议改成输入框失去焦点时再自动填充为0.9
>           //所以取消默认min,通过动态添加min实现第一次不会自动填充,唯有失去焦点时才会执行
>           onBlur={(e) => {
>             if (Number(e.target.value) < 0.9) form.setFieldsValue({ discount: 0.9 })
>             setMin(0.9)
>           }}
>         />
>       </Item>
>    </From>
>   ```

### Ⅳ-限制表单中输入框-不能只输入纯空格以及为空(保留value中间空格)

>1. 出现场景:详见截图
>
> <img src="Ant Design of React使用笔记中的图片/image-20210519174400852.png" alt="image-20210519174400852" style="zoom:80%;" />
>
>2. 代码示例:此处指举例第一个输入框,并在里面进行注释
>
> ```jsx
>   <Form {...FORM_LAYOUT} form={form} onFinish={handleFinish}>
>           <Item
>             label="xxx名"
>             name="name"
>             validateTrigger="onBlur"
>             // normalize={(value) => value.replace(/\s/g, '')} //此行代码是直接限制无法输入空格,不符需求所以废弃
>             rules={[
>               //1. 此处message要置空,因为下方`value == null `就是为空提示,不置空会出现提示两遍的错误
>               //2. 为何保留此处? 需要输入框前有*提示必填 如果不是必填项就不需要
>               { required: true, message: '' },
>               {
>                 validator: async (_, value) => {
>                   //此行是去除前后空格后为空字符串或者直接为空的话返回 不能为空提示
>                   if (value == null ||value.trim() == '') { 
>                     return Promise.reject('xxx名不能为空');
>                   } else {
>                     const res: IResult<IExist> = await ChannelApi.isChannelExist(
>                       value
>                     );
>                     if (res?.data.status) {
>                       return Promise.reject('xxx名已存在');
>                     } else {
>                       return Promise.resolve();
>                     }
>                   }
>                 },
>               },
>             ]}
>           >
>             <Input placeholder="请输入渠道商名" />
>           </Item>
>     	 //不是必须项的对比
>       	 <Item label="联系人" name="contactName">
>             <Input placeholder="请输入联系人" />
>           </Item>
> </Form>
> ```
>
>3. 解析
>
>    1. `rules`中`message`为什么要置空?
>
>       因为下方`value == null `就是为空提示,不置空会出现提示两遍的错误
>
>    2. 为什么下方`validator`中已经给出为空提示,为何还要保留`  { required: true, message: '' }`?
>
>       因为需要输入框前有*提示必填 如果不是必填项就不需要,此项会给你增加`*`号标识
>       
>    3. 为何不直接给输入内容`.trim()`去除前后空格?
>
>       因为输入监听导师value是单次输入,需要你在后面提交时将参数进行一次trim()去除前后空格







# 二、数据展示

## 1、[Table表格](https://ant.design/components/table-cn/)

### Ⅰ-列表渲染映射文字

>1. 场景:当你对下列表渲染时,服务端传送过来的`值是数字`(0,1,2),而你要`显示成相对应的文字时`
>
>2. 代码示例1:
>
>   ```jsx
>   <Table>
>         <Column
>           title="状态"
>           dataIndex="status"
>           render={(data) => {
>             const text = {
>               0: '已绑定',
>               1: '未绑定',
>               2: '已删除',
>             };
>             return text[data];
>           }}
>         />
>   </Table>
>   ```
>
>3. 代码示例2,写法不同效果相同,下面是本人喜欢的写法:
>
>   ```jsx
>   /**       数据字典 company-const.ts   **/
>   const SHOPSTATUSDICT = {
>     0: '已删除',
>     1: '正常',
>     2: '未绑定IP',
>   };
>   export{ SHOPSTATUSDICT }
>   
>   /**      页面调用出        */
>   import { SHOPSTATUSDICT } from '../common/company-const'//导入数据字典
>   const columns = [ {
>         title: '状态',
>         dataIndex: 'status',
>         ellipsis: true,  
>         render: text=>SHOPSTATUSDICT[text]//进行状态数据映射
>       },]
>   
>     return (
>       <Fragment>
>         <Table columns={columns} />
>       </Fragment>
>     );
>   ```

### Ⅱ-列表渲染映射-小数转百分比

>1. 当服务端给你的数据是小数,而你需要将其渲染成百分比进行展示   0.25-->25%
>
>2. 解析:应用的是`render`相关知识点
>
>3. 代码示例:
>
>    1. 转换函数代码
>    
>       ```jsx
>         /**
>          * 将小数转化为百分比
>          * @param point 
>          * @returns 
>          */
>          toPercent=(point:number)=>{
>           if (point==0)   return 0;
>           let str=Number(point*100).toFixed()+"%";
>           return str;
>         }
>       ```
>    
>    2. 列表table组件代码 
>    
>       ```jsx
>         //写法一
>         <Table>
>         <Column title="抽成比例" dataIndex="rate"
>               //将小数转换成百分比,当为数字时,进行转换
>                render={(data) => (typeof data =='number')?  tool.toPercent(data):data }
>          />
>         </Table>
>                                                                         
>         //写法二
>          const columns = [ {
>               title: '抽成比例',
>               dataIndex: 'rate',
>               width: 150,
>               ellipsis: true,
>               //将小数转换成百分比
>               render: data => (typeof data == 'number') ? tool.toPercent(data) : data
>                                                                         
>          },];
>         <Table columns={columns}></Table>
>       ```

### Ⅲ-表格列固定

>1. 需求场景:当你的列表过长时,使用滚轮进行拖动会导致用户体验感较差,这时就需要进行表格列固定
>
>   1. 未使用时效果
>
>      <img src="Ant Design of React使用笔记中的图片/image-20210519180836289.png" alt="image-20210519180836289" style="zoom:80%;" />
>
>         2. 使用后效果
>
>      <img src="Ant Design of React使用笔记中的图片/image-20210519180215667.png" alt="image-20210519180215667" style="zoom:80%;" />
>
>        `ps`:截图中展示的都是开发中的`测试假数据`
>
> 2. 代码示例:只给出必要部分
>
>     1. css样式代码(需要给定`width`,否则无法生效,给定高度,防止超出)
>
>        ```scss
>        .tableWidth{
>          width: 1600px;
>          height: calc(100% - 48px);
>          :global {
>            .ant-table-wrapper,
>            .ant-spin-nested-loading,
>            .ant-spin-container,
>            .ant-table-container {
>              height: 100%;
>            }
>            .ant-table {
>              height: calc(100% - 48px);
>            }
>            .ant-table-pagination.ant-pagination,
>            div.ant-typography,
>            .ant-typography p {
>              margin-bottom: 0;
>            }
>          }
>        }
>        ```
>
>    2. js调用代码示例1
>
>       ```jsx
>        const columns = [
>         {
>             title: '公司ID',  
>             fixed: 'left',  //这就是固定在左边写法
>             dataIndex: 'companyId',
>             width: 150,
>             ellipsis: true,
>           },
>        ]
>       return (
>           <Table
>             className={` ${style.tableWidth}`}
>             columns={columns}
>             scroll={{ x: 600 }}  
>           />
>         );
>       ```
>
>    3. js调用2:(都可实现,效果一样)
>
>       ```jsx
>        const columns = [
>           {
>           title: '名称',
>           dataIndex: 'name',
>           width: 150,
>           fixed: 'left' as const,
>         }, {
>           title: '操作',
>           dataIndex: 'agentId',
>           width: 400,
>           fixed: 'right' as const,
>         }
>        ]
>       return (
>           <div className={style.tableWidth}>
>             <Table
>               scroll={{ x: 600, y: 'calc(100% - 48px)' }}
>               columns={columns}
>             />
>           </div>
>         );
>       ```
>
>3. 注意:需要给定宽度,不然不会生效

