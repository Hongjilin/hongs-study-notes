# #目录

>[TOC]

# 一、将本地已有的一个项目上传到新建的git仓库的方法

将本地已有的一个非git项目上传到新建的git仓库的方法一共有两种。

### 1、 克隆+拷贝

第一种方法比较简单，直接用把远程仓库拉到本地，然后再把自己本地的项目拷贝到仓库中去。然后push到远程仓库上去即可。**此方法适用于本地项目不是一个git仓库的情况。**

具体步骤如下：

#### 1、首先克隆

```
git clone git@github.com:yuanmingchen/tensorflow_study.git
1
```

#### 2、然后复制自己项目的所有文件到刚刚克隆下来的仓库中

#### 3、最后push到远程仓库上面去：

```
git push -u origin master
1
```

### 2、 强行合并两个仓库

第二种方法就是先将本地的项目初始化为一个git仓库，然后再强行合并本地仓库和远程仓库，由于这两个仓库是完全不同的两个仓库，所以直接pull都会报错，需要在pull的时候假加上–allow-unrelated-histories才可以pull成功。**此方法适用于本地项目已经是一个git仓库的情况。**

具体步骤如下：

#### 1、新建git仓库，将本地项目设置为一个git仓库。如果本地项目已经是一个git仓库了，请跳过这一步。在项目根目录下：

```
git init
1
```

#### 2、把当前目录下的已有文件全部加到刚刚新建的git仓库中：

```
git add .
1
```

#### 3、保存刚刚加入的文件，并书写保存信息：

```
git commit -m "push current files"
1
```

#### 4、将本地仓库与远程仓库关联起来：

```
git remote add origin git@github.com:yuanmingchen/tensorflow_study.git
1
```

#### 5、pull远程仓库的内容，更新本地仓库，使用–allow-unrelated-histories忽略本地仓库和远程仓库的无关性，强行合并（关键）：

```
git pull origin master --allow-unrelated-histories
1
```

#### 6、把本地仓库的内容push到远程仓库：

```
git push -u origin master
1
```

然后就ok了。

### 3、其他git命令

最后附上git的一些其他命令：
1、删除已将关联的远程主机

```
git remote rm origin
1
```

2、查看所有本地分支

```
git branch -a
1
```

3、新建一个分支，名字叫xf

```
git branch xf
1
```

4、切换分支到xf分支

```
git checkout xf
1
```

5、把远程分支的代码pull到本地分支：git pull <远程主机名> <远程分支名>:<本地分支名>
如：取回origin主机的master分支，与本地的xf分支合并，输入命令：

```
git pull origin master:xf
1
```

6、推送当前的分支，git push <远程主机名> <本地分支名>:<远程分支名>
PS:注意，分支推送顺序的写法是<来源地>:<目的地>，所以git pull是<远程分支>:<本地分支>，而git push是<本地分支>:<远程分支>。
如：把本地的xf分支推送到origin主机的master分支，输入命令：

```
git push origin xf:master
```





------





# 二、解决同一台电脑生成两份或多份ssh密钥、公钥映射两个或多个GitHub账号

> 此解决方案由百度多个方案结合而来,截取对我有用部分

### 1、需求分析

> 本人注册一个GitHub账户，用来分享本人自己的开源项目或者代码，同时，公司注册了一个GitHub账户，用来分享公司的开源项目。如果按照单个ssh公钥生成的方法则会把之前的公钥覆盖掉，这样将导致其中一方在下一次上传代码，本机和GitHub无法映射成功。
>
> 解决这个问题首先要明确如何生成单个ssh公钥。
> ssh生成单个公钥命令：`ssh-keygen -t rsa -b 4096 -C "your_email@example.com"`。[如何生成ssh公钥](https://blog.csdn.net/mynameissls/article/details/50528048)
> 上述命令会在当前`~/.ssh`目录下生成`id_rsa`和`id_rsa.pub`两个文件。其中`id_rsa`是私钥文件，`id_rsa_.pub`是公钥文件。
> `id_rsa`和`id_rsa_.pub`文件都是通过一个邮箱号生成的，同一个公钥文件不可以配置两个不同GitHub账户（已测试）。
> 那么两个GitHub账户就需要两个不同的邮箱号，来生成两组不同的公钥文件。

### 2、解决方案思路

>命令：`ssh-keygen -t rsa -C "your_email@example.com" -f ~/.ssh/id_rsa_example`
>示例：分别以791815567@qq.com和galaxysoft@sina.cn两个邮箱在`~/.ssh`目录下生成两级不同的公钥文件。
>791815567@qq.com邮箱：`ssh-keygen -t rsa -C "791815567@qq.com" -f ~/.ssh/id_rsa_me`
>galaxysoft@sina.cn邮箱：`ssh-keygen -t rsa -C "galaxysoft@sina.cn" -f ~/.ssh/id_rsa_galaxysoft`
>生成过程可参考[如何生成单个ssh公钥](https://blog.csdn.net/mynameissls/article/details/50528048) 这篇文章。
>执行完成后，会以`~/.ssh`目录下看791815567@qq.com邮箱对应的私钥文件`id_rsa_me`、公钥文件`id_rsa_me.pub`和galaxysoft@sina.cn邮箱对应的私钥文件`id_rsa_galaxysoft`、公钥文件`id_rsa_galaxysoft.pub`
>分别在两个GitHub账户中添加对应的公钥信息即可，可参考[如何生成单个ssh公钥](https://blog.csdn.net/mynameissls/article/details/50528048) 这篇文章

### 3、生成新ssh key

如果我们电脑上已经存在了一个ssh key，那么我们需要在我们电脑上生成第二个你想在本电脑上使用的id_rsa，使用命令：`ssh-keygen -t rsa -C "你的github注册邮箱"`。

下图红色标注部分会提示你把新生成的id_rsa存放到哪里，此处默认会存放在c盘的用户名下的.ssh文件夹下（即你第一个github用户ssh key存放的目录），因此我们需要输入路径/c/Users/DodoMonster/.ssh（注意此路径是你的系统盘下用户目录安放ssh密钥的目录，请使用自己电脑上相对应的目录），最后我以“id_rsa_me”重新命名了ssh key防止默认与已有的ssh key重复。

> 在输入了路径后，会提示你输入提交项目时输入的验证密码，不输则表示不用密码，这是为了防止别人随便在你的项目上push东西，所以最好还是输入以下你的密码。回车，再重复输入确认回车即可。

### 4、添加新ssh key

默认SSH只会读取id_rsa，所以为了让SSH识别新的私钥，需要将其添加到SSH agent
使用命令：`ssh-add ~/.ssh/id_rsa_me`(后面的是自己取的名字)

如果报错：Could not open a connection to your authentication agent.无法连接到ssh agent
可执行`ssh-agent bash`命令后再执行`ssh-add`命

然后将公钥添加到git账号中 https://github.com/settings/keys

### 5、配置config文件

查看.ssh文件中是否存在config文件

如果已存在则直接编辑config文件，命令：`vim config` #这是linux的命令，进入了vim界面后按`a或i或A或I`进入编辑模式，编辑完成后按esc键输入`:wq` 保存文件退出

如果不存在则需要创建config文件，命令：`touch config`，再对config文件进行编辑

对config文件进行配置填写：

```bash
#Default 第一个账号(123456@xxxx.com)

Host gsgit
    HostName gitee.com
    PreferredAuthentications publickey
    IdentityFile ~/.ssh/id_rsa_me
    
   
#second 第二个账号（38894403@xxxx.com）
    
Host mygit
     HostName gitee.com
    PreferredAuthentications publickey
    IdentityFile ~/.ssh/id_rsa
```

> 其中Host 后的名字可以随意方便自己记忆，但HostName必须为`github.com(或者其它git地址)。`

### 6、测试是否配置成功

使用命令：

```
ssh -T git@zc
```

出现欢迎语则为配置成功。

注意：配置完成后，在连接Host不是github.com的github仓库时，远程库的地址要对应地做一些修改：

而并非原来的git@github.com

```shell
git clone git@gitee.com:hongjilin/cx.git
//改为
git clone git@mygit:hongjilin/cx.git
```

这样每次连接都会使用id_rsa_me与服务器进行连接。

配置至此，大功告成！

###  7、问题Mark

> 当我切换到另外一个账号提交时 commit的提交者仍寻找全局配置中的username作为签名 而不是当前本地库绑定提交账号的用户名
>
> 询问老师后老师的回答是:目前切换账号后就只有 去修改配置文件的信息 这个解决办法
>
> 所以此处`Mark`,留待后续学习生活解决

# 三、commit报错无法提交

```shell
> running pre-commit hook: lint-staged
[STARTED] Preparing...
[FAILED] warning: LF will be replaced by CRLF in sh.exe.stackdump.
[FAILED] The file will have its original line endings in your working directory.
[STARTED] Running tasks...
[SKIPPED] Skipped because of previous git error.
[STARTED] Applying modifications...
[SKIPPED]
[SKIPPED]   × lint-staged failed due to a git error.

  × lint-staged failed due to a git error.
[STARTED] Cleaning up...
[SKIPPED]   × lint-staged failed due to a git error.
  Any lost modifications can be restored from a git stash:


pre-commit hook failed (add --no-verify to bypass)
```

解决方式

```shell
执行npm run lint， 根据提示修改错误（推荐）
git commit -m "" --no-verify 绕过了lint的检查
```



# 四、Git提交时出现Merge branch 'master' of ...之解决方法

多人协作开发项目，在上传代码时通常会先pull一下远程代码，使本地与远程同步更新，但是如果远程此时与自己代码存在冲突，在解决冲突后提交有时会出现“Merge branch ‘master’ of …”这条信息。这是因为pull其本质是fetch+Merge的结合。通常会分为以下两种情况：

1.如果远程分支超前于本地分支，并且本地也没有commit操作，此时pull会采用’fast-forward’模式，该模式不会产生合并节点，也即不产生"Merge branch ‘master’ of …"信息。

2.如果本地有commit提交，此时若存在冲突，pull拉取代码时远程和本地会出现分叉，会进行分支合并，就会产生"Merge branch ‘master’ of …"信息。

**解决方法**

使用git pull --rebase命令，如果没有冲突,则会直接合并，如果存在冲突，手动解决冲突即可，不会再产生那条多余的信息。如果你不想每次都rebase，可以在git bash里执行

```shell
git config --global pull.rebase true
```

这个配置就是告诉git在每次pull前先进行rebase操作。