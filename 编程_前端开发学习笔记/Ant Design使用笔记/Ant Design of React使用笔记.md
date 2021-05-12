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

### Ⅲ-表单中动态修改表单value

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

# 二、数据展示

## 1、[Table表格](https://ant.design/components/table-cn/)

### Ⅰ-列表渲染映射

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