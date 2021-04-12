# MyIntelliJIDEA配置

## 一、修改快捷键

### Ⅰ-自动提示(代码补全)快捷键

>有时候希望使用自动补全，因为不偷懒的程序员不是好程序员。但是Idea的默认快捷键是 Ctrl + 空格。 对于安装中文输入法的普通人来说那就是杯具了，你懂的。
>
>修改方法如下：
>
>点击 文件菜单(File) –> 点击 设置(Settings… Ctrl+Alt+S), –> 打开设置对话框。
>
>在左侧的导航框中点击 KeyMap。
>
>接着在右边的树型框中选择 Main menu –> Code –> Completion.
>接着需要做两件事：
>
>1. 移除原来的Cycle Expand Word 的 Alt+/(正斜杠) 快捷键绑定。
>2. 在 Basic 上点击右键,去除原来的 Ctrl+空格 绑定,然后添加 Alt + 斜杠 快捷键。
>
>然后应用(Apply), OK.
>
>如果此组合键已被使用, 提示冲突时, 直接通过即可。

### Ⅱ-删除当前行与向下复制整行

>`Delete line` :删除整行(或者选中的全部的行)  -->`ctrl+d`
>
>`Duplicate Entire Lines` 向下复制整行(或者选中的) -->`ctrl+alt+向下`

### Ⅲ-设置类注释







## 二、IntelliJIDEA报错

### Ⅰ-Error:java: 无效的源发行版: 10(可一是其他数字)

>1. 问题场景:今天编译java程序时出现`Error:java: 无效的源发行版: 10`错误
>
>2. 原因:本机的`JDK`版本与项目的语言级别不同造成的
>
>3. 解决:
>
>   使用`Ctrl+Alt+Shift+s`打开`Project Structure`查看`Project Language Level`，发现是`10`
>
>   ![image-20210412133943838](MyIntelliJIDEA配置中的图片/image-20210412133943838.png)
>
>   改变`Project Language Level`,调整至同一版本
>
>   ![image-20210412134028166](MyIntelliJIDEA配置中的图片/image-20210412134028166.png)