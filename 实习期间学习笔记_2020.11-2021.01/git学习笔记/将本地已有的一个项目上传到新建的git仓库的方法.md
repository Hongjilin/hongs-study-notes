# 将本地已有的一个项目上传到新建的git仓库的方法

将本地已有的一个非git项目上传到新建的git仓库的方法一共有两种。

## 一、 克隆+拷贝

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

## 二、 强行合并两个仓库

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

------

------

------

## 三、其他git命令

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