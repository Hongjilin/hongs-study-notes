# #目录

>[TOC]

# 本人笔记提交标准

```jsx
docs: 新建知识点笔记
feat：新增知识点（feature)。
update:对于某部分知识点的更新修改(不是勘误,如更新目录索引、某正确知识点补全等操作)
fix:勘误,修正知识点错误等操作
style:如文档内样式调整,格式调整等不影响笔记内容的操作 (如删除多余资源,如无用的图片,无用语句删除等)
refactor：笔记重构与优化（主要就是目录变动、笔记文件结构调整、文件名更改等操作)
//举例
docs(算法):新建数据结构与算法知识点笔记
feat(前端-promise): 新增笔记中async+await+promise知识点笔记
fix(前端-微信小程序):更正笔记中对于自定义组件描述的不恰当处
refactor(前端):对于前端笔记部分文件目录进行重构调整
style(后台-java):进行对该笔记中笔记格式与样式调整 或 进行对该笔记中多余图片展示资源的删除
update:(README):笔记目录索引更新-新增小程序自封装组件笔记索引
```



# 你可能会忽略的 Git 提交规范

一直是 ESLint 的忠实用户，深知规范的重要性。然而，在新项目交接中，我被 Git Commit 规范逼疯了。才意识到自己的疏忽，于是便有了一探究竟的想法。

#### 一、为什么需要规范？

无规矩不成方圆，编程也一样。

如果你有一个项目，从始至终都是自己写，那么你想怎么写都可以，没有人可以干预你。可是如果在团队协作中，大家都张扬个性，那么代码将会是一团糟，好好的项目就被糟践了。不管是开发还是日后维护，都将是灾难。

这时候，有人提出了何不统一标准，大家都按照这个标准来。于是 `ESLint`，`JSHint` 等代码工具如雨后春笋般涌现，成为了项目构建的必备良品。

`Git Commit` 规范可能并没有那么夸张，但如果你在版本回退的时候看到一大段糟心的 `Commit`，恐怕会懊恼不已吧。所以，严格遵守规范，利人利己。

#### 二、具体规则

先来看看公式：

```
<type>(<scope>): <subject>
```



- type

  - 用于说明

     

    ```
    commit
    ```

     

    的类别，只允许使用下面7个标识。

    ```jsx
    feat：新功能（feature）。
    fix/to：修复bug，可以是QA发现的BUG，也可以是研发自己发现的BUG。
    fix：产生diff并自动修复此问题。适合于一次提交直接修复问题
    to：只产生diff不自动修复此问题。适合于多次提交。最终修复问题提交时使用fix
    docs：文档（documentation）。
    style：格式（不影响代码运行的变动）。
    refactor：重构（即不是新增功能，也不是修改bug的代码变动）。
    perf：优化相关，比如提升性能、体验。
    test：增加测试。
    chore：构建过程或辅助工具的变动。
    revert：回滚到上一个版本。
    merge：代码合并。
    sync：同步主线或分支的Bug。
    ```

- scope

  - 用于说明 `commit` 影响的范围，比如数据层、控制层、视图层等等，视项目不同而不同。

- subject

  - 是

     

    ```
    commit
    ```

     

    目的的简短描述，不超过50个字符。

    ```
    1.以动词开头，使用第一人称现在时，比如change，而不是changed或changes
    2.第一个字母小写
    3.结尾不加句号（.）
    ```

规范参考自阮一峰老师的文章：[Commit message 和 Change log 编写指南](http://www.ruanyifeng.com/blog/2016/01/commit_message_change_log.html)。

#### 三、异常处理

我们先来看看这个异常提醒：

```
INVALID COMMIT MSG: does not match "<type>(<scope>): <subject>" !
jartto:fix bug
```



这里之所以报出这个警告，是因为我的提交出现了两个问题：
其一，使用了规范外的关键字；
其二，很细节的问题，jartto：后少了空格；

这时候我才回忆起来，当时提交一直失败，情急之下直接强制提交，所以以后的提交都会抱出这个异常。大致意思就是：

你的之前的 Commit 不合格～你的之前的 Commit 不合格～你的之前的 Commit 不合格

这时候就很烦了，我们只能去将之前的错误修正，那么如何操作呢？

#### 四、如何修改之前的 commit 信息？

其实并不复杂，我们只需要这样做:
1、将当前分支无关的工作状态进行暂存

```
git stash
```



2、将 `HEAD` 移动到需要修改的 `commit` 上

```
git rebase 9633cf0919^ --interactive
```



3、找到需要修改的 `commit` ,将首行的 `pick` 改成 `edit`
4、开始着手解决你的 `bug`
5、 `git add` 将改动文件添加到暂存
6、 `git commit –amend` 追加改动到提交
7、`git rebase –continue` 移动 `HEAD` 回最新的 `commit`
8、恢复之前的工作状态

```
git stash pop
```



大功告成，是不是想把整个 Commit 都修改一遍，逃～

此处参考自：[修改 Commit 日志和内容](https://www.aliyun.com/jiaocheng/125261.html)

#### 五、项目中使用

这时候问题又来了，为什么我提交的时候会有警告，这个又是如何做到的呢？

这时候，我们需要一款 `Node` 插件 `validate-commit-msg` 来检查项目中 `Commit message` 是否规范。

1.首先，安装插件：

```
npm install --save-dev validate-commit-msg
```



2.使用方式一，建立 `.vcmrc` 文件：

```
{
  "types": ["feat", "fix", "docs", "style", "refactor", "perf", "test", "build", "ci", "chore", "revert"],
  "scope": {
    "required": false,
    "allowed": ["*"],
    "validate": false,
    "multiple": false
  },
  "warnOnFail": false,
  "maxSubjectLength": 100,
  "subjectPattern": ".+",
  "subjectPatternErrorMsg": "subject does not match subject pattern!",
  "helpMessage": "",
  "autoFix": false
}
```



3.使用方式二：写入 `package.json`

```
{
  "config": {
    "validate-commit-msg": {
      /* your config here */
    }
  }
}
```



4.可是我们如果想自动使用 [`ghooks`](https://www.npmjs.com/package/ghooks) 钩子函数呢？

```
{
  …
  "config": {
    "ghooks": {
      "pre-commit": "gulp lint",
      "commit-msg": "validate-commit-msg",
      "pre-push": "make test",
      "post-merge": "npm install",
      "post-rewrite": "npm install",
      …
    }
  }
  …
}
```



在 `ghooks` 中我们可以做很多事情，当然不只是 `validate-commit-msg` 哦。

更多细节请参考：[validate-commit-msg](https://github.com/conventional-changelog-archived-repos/validate-commit-msg)

#### 六、Commit 规范的作用

1.提供更多的信息，方便排查与回退；
2.过滤关键字，迅速定位；
3.方便生成文档；

#### 七、生成 Change log

正如[上文](http://jartto.wang/2018/07/08/git-commit/)提到的生成文档，如果我们的提交都按照规范的话，那就很简单了。生成的文档包括以下三个部分：

- New features
- Bug fixes
- Breaking changes.

每个部分都会罗列相关的 `commit` ，并且有指向这些 `commit` 的链接。当然，生成的文档允许手动修改，所以发布前，你还可以添加其他内容。

这里需要使用工具 [Conventional Changelog](https://github.com/conventional-changelog/conventional-changelog) 生成 `Change log` ：

```
npm install -g conventional-changelog
cd jartto-domo
conventional-changelog -p angular -i CHANGELOG.md -w
```



为了方便使用，可以将其写入 `package.json` 的 `scripts` 字段。

```
{
  "scripts": {
    "changelog": "conventional-changelog -p angular -i CHANGELOG.md -w -r 0"
  }
}
```



这样，使用起来就很简单了：

```
npm run changelog
```



到这里，我们所有的问题都搞明白了，🍻Cheers～

#### 八、总结

看完文章，你还会如此放荡不羁吗？你还会随心所欲的编写 `Commit` 吗？你还会如此 `git commit -m "hello jartto"`提交吗？

答案是否定的，因为使用了钩子函数，你没有机会了，否则将是无穷无尽的恢复 `Commit`。这倒可以养成良好的提交习惯，🙈～