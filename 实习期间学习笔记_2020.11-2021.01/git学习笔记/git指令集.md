us

十分详细的git指令

https://juejin.im/post/5deb81b0e51d4557fd76f5f3

//克隆远程仓库

git clone <版本库的地址> <本地你认为合适的库名>

//初始化一个仓库

git init

//关联远程仓库

git remote add origin url

//将远程主机更新到本地

git fetch --all

拉取代码

git pull === git fetch + git merge

//拉取代码

git pull origin master

//提交代码

git push origin master

// 如果拉取不了

git pull origin master --allow-unrelated-histories

//跟踪远程分支

git branch --set-upstream-to=origin/master 

//创建新分支 跟踪远端分支

git checkout --track -b master origin/master

// 创建一个分支

git branch dev

//删除某一个分支

git branch -d dev

// 切换分支

git checkout dev

//把本地分支推送到远程

git push --set-upstream origin dev

//git 查看跟踪分支

git branch -vv

//合并分支到当前分支

git merge dev

//放弃解决冲突，撤销当前的 merge 操作

git merge --abort

//丢弃修改

git reset HEAD^

//找回代码

git stash apply

//强制推送

git push origin -u dev-new -f

//回滚到指定的版本

git reset --hard （指定的版本）