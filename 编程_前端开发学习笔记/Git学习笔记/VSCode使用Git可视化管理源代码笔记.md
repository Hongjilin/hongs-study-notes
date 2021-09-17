# #说明

>随着VS Code的功能和插件的不断强大和完善，它已经成为了我们日常开发中一个必不可缺的伙伴了,这篇笔记主要学习记录VS Code如何使用Git可视化管理我们的程序源代码
>
>查阅借鉴的资料:CSDN[徐余人](https://blog.csdn.net/zhaojun666)的[VScode的源代码管理简易使用](https://blog.csdn.net/zhaojun666/article/details/106163505) 博客园[allenxt](https://home.cnblogs.com/u/allenxt/)的[vs code 使用Git进行源代码管理](https://www.cnblogs.com/allenxt/p/8473686.html)、[git fatal: refusing to merge unrelated histories错误（git本地库与远程库历史不相关）](https://www.cnblogs.com/fei-yu9999/p/15115889.html); 简书[broccoli_d39c](https://www.jianshu.com/u/bb8ffcaec19b)的[vscode源代码管理器（git可视化操作）](https://www.jianshu.com/p/ef0438a8b941)、[如何利用VSCode优雅的使用Git提交至GitHub](https://www.jianshu.com/p/154322554d9d); 腾讯云追逐时光者的[VS Code使用Git可视化管理源代码详细教程](https://cloud.tencent.com/developer/article/1793472) ; 知乎[我想飞](https://www.zhihu.com/people/xdbcb8)的[Visual Studio Code第二弹：Vscode与Git的完美结合](https://zhuanlan.zhihu.com/p/34753075);程序员宅基地的[vscode 侧边栏源代码管理不见了](https://www.cxyzjd.com/article/z591102/107707197);[要推送当前分支并将远程分支设置为上游，请使用git push--set upstream origin master](https://www.5axxw.com/questions/content/pjdw93)
>
>除此笔记外大家可以看我其他笔记 :**[全栈笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master)**、**[数据结构与算法](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_算法及课程基础学习笔记/数据结构与算法)**、**[编程_前端开发学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记)**、**[编程_后台服务端学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记)** 、**[Java](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Java)** 、**[Nodejs](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_后台服务端学习笔记/Nodejs)** 、**[JavaScript笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/HTML+CSS+JS基础笔记/JavaScript笔记)**、**[编程工具使用笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端工具使用笔记)** 、**[ES6及后续版本学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/ES6及后续版本学习笔记)** 、**[Vue笔记整合](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Vue笔记整合)** 、**[React笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/React笔记)**、**[微信小程序学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/微信小程序学习笔记)**、**[Chrome开发使用及学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Chrome开发使用及学习笔记)** 以及许多其他笔记就不一一例举了
>
>想看GIT基础的同学可以看这里 :  **[Git学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Git学习笔记)** 
>
>想看VSCode使用学习笔记的同学看这里 : **[VSCode笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端工具使用笔记/VSCode笔记)** 

# #目录

>[TOC]

# 一、CLI 与 GUI

>实际上本人更喜欢于敲指令来进行git操作于提交,但是为何到最后还需要学GUI呢?下面举例以下CLI与GUI特点以及优劣

## Ⅰ - GUI

> 如果是想使用 VSCode的GUI推荐下载插件 **Git History** 

### 1、GUI是什么?

>Gui基于命令行开发，界内有不同的软件: Tortoist、gitg、SourceTree、Github Desktop等，用的比较多的貌似是sourceTree。
>
>* GUI其实就是帮你将命令行集成,比如你点击一个按钮,实际上是帮你执行了几句命令行
>* Gui对于**观察分支合并情况**会变得非常直观，这些图形界面都会把diff通过颜色标出来。
>* 但是这种多样性本身存在问题，它们都不能达到“在任何场景下方便操作”的程度。
>* 但不论是哪个客户端，想执行一些稍微高级点的操作都要点开层层菜单才能找到相应的按钮，更不用说这些客户端视图布局不一致，你根本不知道功能藏在哪。

### 2、优点

>在分支错综复杂的情况,就比如出现冲突，gui用来解决冲突、观察分支和分支合并关系是十分直观的
>
>1. 下面就是使用git的cli命令查看的,这样是不是看的很头疼,一点儿也不直观,在我初工作时真的看不懂这个界面
>
>   - ```sh
>     git log --graph --decorate --oneline --simplify-by-decoration --all
>     ```
>
>   - ![image-20210916164429988](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210916164429988.png) 
>
>2.  而这是使用GUI的效果,区别很明显不是吗?而且也能更直观地看到自己需要的信息
>
>   ![image-20210916165950240](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210916165950240.png)

### 3、 缺点

>并不是说GUI就很好,只能说在我们做某些工作的时候如虎添翼,是特殊情况的有力道具,但不一定是通用的
>
>* 一些简单的命令操作 **不够简洁**，有的命令菜单隐藏的很深，找找找找不一定能找得到，往往是降低程序员效率的一个点
>*  很多GUI的按钮文案是英文翻译过来的，例如rebase翻译中文是变基
>*  **gui无法操作自动化脚本**，比如一次 release中 ，我们可以要涉及到 build, test, bump , git add git commit, git tag, git push , npm publish. 等等独立命令的有序组合。

## Ⅱ - CLI

>git起源于命令行，命令行赋予了太多有用的功能，对于复杂的操作还是得需要命令行来完成。代码提交、合并、rebase等操作还是非常快的,本人也是更习惯于使用 **CLI** 
>
>* CLI 顾名思义就是命令行的意思

## Ⅲ - 取舍

>对于 **GUI** 和 **CLI** 的取舍问题其实并不是非黑即白的,主要看个人看法与习惯
>
>* 有人更倾向于使用CLI操作(比如本人):但是在查看分支、合并等相关信息的场景上,我仍是会专门学习并使用GUI来操作
>* 有人觉得开发中大多都是简单的重复操作(如 pull push)等,那么直接用GUI进行日常大部分命令键入是没问题的
>* 大家在漫长的 '搬砖' 生涯中,就会慢慢形成一套自己的工具使用情况,所以可以借鉴,但不比要我给定确切的答案
>
>但 **CLI** 还是必学的:
>
>* 工具只是辅助的一种,了解相关的git机制,才能更好地协助你学习开发
>* 举个栗子:当你想做一个前端页面,JS可以稍微掌握(甚至不用会DOM操作),只要会一些基础语法就可以学习使用VUE框架,开发出一般的网站了,但是我们也知道,当遇到一些复杂、特殊问题时,靠的还是我们的JS基础解决.
>
>想看GIT基础的同学可以看这里 :  **[Git学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Git学习笔记)** 

# 二、环境准备

> 此笔记基于 **我们已经掌握了以下两个工具的基本使用** 的基础上进行梳理记录的,如果对于这两个部分不熟悉的建议可以去学习或者看下本人梳理的笔记

## Ⅰ- VSCode下载以及基本使用学习

>本人梳理的VSCode使用学习笔记 : **[点我传送](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/A_前端工具使用笔记/VSCode笔记)** 

## Ⅱ - Git 环境安装以及基本使用学习

> 本人梳理的关于Git学习笔记 :  **[Git学习笔记](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Git学习笔记)** 
>
> 建议还是先学好基础指令再学GUI可视化管理工具,本人还是更喜欢敲命令.
> 但学GUI主要还是查看修改、冲突时更明了

## Ⅲ - 为什么要用VSCode进行源代码管理

> 还能为啥,用习惯了呗.就跟你玩游戏能用微信或者QQ登录的你会专门去注册其他的平台账号来登录吗?

## Ⅳ- 推荐的插件

> 使用VSCode进行Git操作建议安装如下插件,帮你们少走弯路,下面给出的截图示例都会基于我们安装了下面插件的基础上说

### 1、GitLens 

>我强烈建议你安装插件`GitLens`, 它是 VS Code 中我最推荐的一个插件, 简直是 Git 神器, 码农必备。
>
>GitLens 在 Git 管理上有很多强大的功能, 比如：
>
>- 将光标放置在代码的当前行, `可以看到这行代码的提交者是谁`, 以及提交时间。这一点, 是 GitLens 最便捷的功能。
>- 查看某个 commit 的代码改动记录
>- 查看不同的分支
>- 可以将两个 commit 进行代码对比
>- 甚至可以将两个 branch 分支进行整体的代码对比。这一点, 简直是 GitLens 最强大的功能。当我们在不同分支 review 代码的时候, 就可以用到这一招。

### 2、Chinese (Simplified) Language Pack for Visual Studio Code

> 中文包, 让软件显示为简体中文语言, 没啥好说的吧
>
> 当初在学校时傻傻的觉得直接用英文用习惯了就行了,不然以后工作了别人没用中文包怎么给人调试?事实证明,出来都用的中文包,你的英文编辑器别人给你调试时反而不习惯:dog:

### 3、Git History 

> 有些同学习惯使用编辑器中的 Git 管理工具, 而不太喜欢要打开另外一个 Git UI 工具的同学, 这一款插件满足你查询所有 Git 记录的需求。

### 4、Git Graph

>同 3 是另一款GUI插件

# 三、操作入口

>入口有两个,分别是:
>
>1. VSCode左侧类似弹弓的图标是它的 “**源代码管理器**”
>2. 使用ctrl+shift+P并输入git进行git操作。
>
>![image-20210916175300146](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210916175300146.png) 

# 四、进行Git操作 

## Ⅰ - 克隆仓库

>1. VSCode打开一个空的文件夹,点击 **左侧弹簧 --> 克隆储存库**
>
>   > ![image-20210916180855154](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210916180855154.png) 
>
>2. 直接**Shit+Ctrl+P**,命令行搜索**克隆**即可
>
>   > ![image-20210916181341241](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210916181341241.png) 
>
>然后输入要克隆的仓库地址,之后操作就与命令行无异,不懂得可以看本人git笔记 :  **[Git学习笔记的克隆操作部分](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Git学习笔记#1将本地已有的一个项目上传到新建的git仓库的方法)** 

## Ⅱ - 实际工作开发四步曲(添、提、拉、推)

### 1、首先要明白四步曲分别是哪四步，其作用分别是什么？

>* 添：将修改的内容添加到本地暂存区,实际上就是命令 [ **git add .** ]
>* 提：将本地暂存区中的内容提交到本地代码库,实际上就是命令 [ **git commit -m '提交信息'** ] 
>* 拉：同步，拉取远程代码库中的内容，在多人协同开发中十分的重要，因为假如事先没有同步更新到最新版本有可能会覆盖别人修改的东西，假如拉取后有冲突直接使用VS Code解决冲突即可,实际上就是命令 [ **git pull** ] 
>* 推：将本地代码库中的内容推送到远程代码仓库,实际上就是命令 [ **git push** ]

### 2、添加暂存、撤销暂存

>首先点击 [**弹簧图标**],进入源代码管理界面,当你仓库进行了修改的时候会出现下面内容
>
>![image-20210917113546148](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917113546148.png) 

### 3、提交至本地代码库

>此处实际上做的是执行命令 [ **git commit -m '提交信息'** ] ,注意,此处的提交还是操作本地文件,并没有推送至远端
>
>![image-20210917114331450](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917114331450.png) 

### 4、撤销上次提交

>撤销上次提交且将其放至暂存区中
>
>![image-20210917144918633](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917144918633.png) 
>
>实际上相当于 **CLI** 命令:[ `git reset --soft HEAD^` ]
>
>详情可以看本人GIT笔记中 : **[撤销与重置部分](https://gitee.com/hongjilin/hongs-study-notes/tree/master/编程_前端开发学习笔记/Git学习笔记#八撤销与重置)** 

### 5、推与拉 同步远端操作

>点击上面 **...** 就能出现下拉选项框
>
>![image-20210917114838890](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917114838890.png)
>
>验证
>
>![image-20210917115030332](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917115030332.png)  



## Ⅲ - 分支操作

### 1、查看分支、切换分支

>![image-20210917143949557](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917143949557.png)  
>

### 2、创建分支

>在上面查看、切换分支的操作基础上,点击创建新分支  **这里打错字了,应该是 hotfix ,但是截图不好修改,就将错就错了**
>
>![image-20210917144259926](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917144259926.png) 

### 3、推送分支及其修改至远端

>其实就跟普通的 **push** 操作无异,就重复操作上面,就不赘述直接上结果 [Ⅱ - 实际工作开发四步曲(添、提、拉、推)](#Ⅱ - 实际工作开发四步曲(添、提、拉、推))
>
>![image-20210917145359612](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917145359612.png) 
>
>切换到hotfix查看,内容修改成功
>
>![image-20210917145437061](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917145437061.png)  

### 4、合并分支

#### ① 合并操作

>当我们 **hotfix-9.17分支** 开发完成了,需要将其合并到 **master** 分支中,首先我们需要切换到 **master** 分支上,这点原因就不用我赘述了吧,如果不懂的去看看我的GIT学习笔记再来
>
>![image-20210917152753243](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917152753243.png) 

#### ② 可能出现的问题

###### a) 问题描述

>这个并不是必现的,也不是VSCode才会出现的问题,而是合并时都可能出现的问题
>
>![image-20210917152837343](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917152837343.png)  

##### b) 解决

>### fatal: refusing to merge unrelated histories  --> 致命的:拒绝合并不相关的历史。
>
>字面意思可见是历史原因不和造成的。
>
>原因是远程库和本地库两个分支是两个不同的版本，具有不同的提交历史，所以存在矛盾。
>
>解决办法：把两段不相干的 分支进行强行合并。输入后再次进行合并操作就可以了
>
>```sh
>$git pull origin master --allow-unrelated-histories
>```

##### c) 成功

>可以看到已经合并成功了,master分支的内容已经合并了hotfix分支的内容
>
>![image-20210917153235096](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917153235096.png) 

## Ⅳ - 冲突与解决

> 上述合并中之所以没有发生冲突,是因为hotfix是基于master分支创建,然后进行更改,然后master并没有进行修改,所以hotfix并不会与master发生冲突( **冲突对比的是更改的部分** )

### 1、 模拟冲突

>在master与hotfix修改同一处,再合并就能模拟冲突了

#### ① 分别在两个分支对同一文件进行修改并提交到暂存区

> ![image-20210917154550169](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917154550169.png) 

#### ② 将 **hotfix-9.17** 分支并入 **master** 分支

>![image-20210917154824921](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917154824921.png) 

#### ③ 出现冲突

>![image-20210917155223694](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917155223694.png)

### 2、 冲突发生的判断基准

>我们可以看到 **operate** 因为master与hotfix-9.17分支都发生了变更,所以git并不知道该听谁的,所以给你保留下来
>
>而 **name** 属性因为只有master分支进行了修改,hotfix-9.17没发生变更,所以git会保留变更,不会产生冲突

### 3、 冲突解决

#### ① 手动进入文件决定冲突保留部分

>![image-20210917155828696](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917155828696.png) 
>
>* **采用当前更改** :保留被合并的分支的更改 --> 此处是 `master` 分支
>
>  > ![image-20210917160117287](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917160117287.png) 
>
>* **采用传入的更改** : 保留合并进来的分支的更白 --> 此处是 `hotfix-9.17` 分支
>
>  > ![image-20210917160059159](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917160059159.png) 
>
>* **保留双方的更改** : 就是双方的变更都保留
>
>  > ![image-20210917160033549](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917160033549.png) 
>
>* **比较变更**:就是对比双方变更记录
>
>  > ![image-20210917160227135](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917160227135.png) 

#### ② 解决后标记解决且进行提交

> **CLI**操作中用 **git add .** 标记解决,VSCode中同样点击 **+** 号标记解决,随后直接 推送远端即可
>
>![image-20210917160908071](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917160908071.png) 

#### ③ 冲突解决成功

>可以看到,合并、冲突解决并提交成功:
>
>![image-20210917161255015](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917161255015.png) 
>
> master上查看文件修改也是正确的![image-20210917161303263](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917161303263.png) 



## Ⅴ - VSCode初始化仓库以及关联到远程仓库

> 也可以直接 **克隆仓库** ,克隆仓库操作在上面已经给出

### 1、操作

>在最后我还是用了 **CLI** 实在是说真的,很多操作还是直接命令行方便
>
>![image-20210917134424781](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917134424781.png)

### 2、第一次执行push时报错

>在上图的 **CLI** 命令行操作进行远程推送时报错,这是为什么?
>
>```sh
>To push the current branch and set the remote as upstream, use
>    git push --set-upstream origin master
>```
>
>* **CL** 其实做的已经仁至义尽了,这里已经提示你要输入的正确命令行,这是使用GUI难以比拟的优势
>* 当您使用 **git push** 时，意味着您正试图将本地存储库上载到托管在网上某处的远程存储库，它可以是github、gitlab等。
>* 为了将您的代码上传到远程存储库，您需要设置一个上游，也就是说，设置一个位置来推送您的存储库。您可以通过添加远程存储库的URL来实现这一点。

### 3、成功

>推送后,可以直接上远程仓库网站查看
>
>![image-20210917134559319](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917134559319.png) 

# 五、查看历史差异

## Ⅰ -  查看分支之间的差异

>1. 首先你要安装 **GitLens ** 拓展插件, 安装后左侧会出现如图选项
>2. 安装后左侧出现分支图标,点击进入就能查看
>
>![image-20210916183227838](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210916183650066.png)

## Ⅱ -  VSCode Git提交修改历史记录查看

>首先你要安装 **Git History** 或者 **Git Graph** 拓展插件

### 1、 查看分支 (GUI界面)

>首先你要安装 **Git History** 或者 **Git Graph** 拓展插件,才能有左侧两个按钮
>
>![image-20210917162800755](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917162800755.png) 

### 2、 查看某文件历史修改记录

>![image-20210917163625790](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917163625790.png)

### 3、查看文件修改时间线对比文件修改内容：

>选中某一文件后,展开其时间线,双击某一 **commit** 可以查看前后文件提交差异
>
>![image-20210917164716480](../A_前端工具使用笔记/VSCode使用Git可视化管理源代码笔记/VSCode使用Git可视化管理源代码笔记中的图片//image-20210917164716480.png) 
