# #说明介绍

>Lodash 是一个一致性、模块化、高性能的 JavaScript 实用工具库。
>
>此笔记将放置本人对于Lodash的使用笔记,主要做个索引,防止自己遗忘,对同学们来说也能当是应用示例



# #目录

>[TOC]

# 一、数组相关

### Ⅰ-数组对象去重

>1. 代码:
>
>   ```js
>   import { isEqual, uniqWith, uniqBy } from 'lodash'
>   let arr = [
>         {id: 1, name: 'sli', year: 2012},
>         {id: 2, name: 'ap', year: 2015},
>         {id: 1, name: 'alslion', year: 2012},
>         {id: 3, name: 'pose', year: 2012},
>         {id: 3, name: 'pose', year: 2012},
>       ]
>   console.log('原数组:', arr);
>   console.log('根据id去掉相同的元素:', uniqBy(arr, 'id'));
>   console.log('深检查数组每一项进行去重:', uniqWith(arr, isEqual));
>   ```
>
>2. 效果截图:
>     ![image-20210712173110937](README中的图片/image-20210712173110937.png) 