// pages/posts/posts.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    posts: [],
    test: "测试数据",
    flag: true
  },

  /**
   * 生命周期函数--监听页面加载
   * 钩子函数 hook function
   */
  onLoad: function (options) {
    //setData可以直接将数据加入data中;如果在data中已经有该值,则修改
    //它有着创建+更新功能  但正常是用来更新
    this.setData({
      posts: content
    })

  },



  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    console.log("onHide")

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    console.log("onUnload")
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    console.log("页面上拉触底事件")
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    console.log("分享")
  }
})

//假数据
const content = [{
    title: "归墟之地",
    content: "传说程序员多写几年代码要秃头了,他的头就像这里的太阳一般闪亮",
    imgSrc: "/images/2.jpg",
    reading: 996,
    collection: 996,
    detail: "传说程序员多写几年代码要秃头了,他的头就像这里的太阳一般闪亮!!!",
    dateTime: "24小时前",
    headImgSrc: "/images/测试头像图片.jpg",
    author: "努力学习的汪",
    date: "Nov 20 2021",
    avatar: "/images/测试头像图片.jpg",
    postId: 3
  },
  {
    title: "漳浦屠宰场",
    content: "漳浦屠宰场像极了现在职场中的年轻人,美好可爱静谧,如梦如幻,编不下去了。",
    imgSrc: "/images/4.jpg",
    reading: 6,
    collection: 666,
    detail: "漳浦屠宰场像极了现在职场中的年轻人,美好可爱静谧,如梦如幻,编不下去了。",
    dateTime: "88小时前",
    headImgSrc: "/images/测试头像图片.jpg",
    author: "洪",
    date: "Nov 0 2019",
    avatar: "/images/1.jpg",
    postId: 4
  },
  {
    title: "惊了!某程序猿的头发竟然....",
    content: "陈某人没想到,工作多年后,自己不仅没有掉头发,反而涨势更加的好,而且带了点绿色...",
    imgSrc: "/images/1.jpg",
    reading: 888,
    collection: 999,
    detail: "陈某人没想到,工作多年后,自己不仅没有掉头发,反而涨势更加的好,而且带了点绿色...",
    dateTime: "88小时前",
    headImgSrc: "/images/测试头像图片.jpg",
    author: "晓",
    date: "Nov 0 2019",
    avatar: "/images/4.jpg",
    postId: 5
  }
]