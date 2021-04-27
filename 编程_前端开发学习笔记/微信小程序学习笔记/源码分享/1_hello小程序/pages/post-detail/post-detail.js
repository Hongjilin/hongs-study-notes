// pages/post-detail/post-detail.js
import {
  content
} from '../../data'
let con //用来保存this指向
Page({

  /**
   * 页面的初始数据
   */
  data: {
    postData: {}, //绑定数据需要渲染
    collected: false, //绑定当前收藏与否
    isPlaying:false,
    _pid: 1, //非绑定数据加下划线,节约性能,赋值的时候直接this.data._pid=xxx
    _postCollected: {}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    con = this //用来保存this指向
    let postData = {};
    content.map(item => {
      if (item.postId == options.pid) postData = item
    })
    this.data._pid = options.pid; //将传入的id暂时存进data中
    this.data._postCollected = wx.getStorageSync("posts_collected"); //将本地存储的文章状态数组拉下来
    let collected = this.data._postCollected[options.pid]
    if (!collected) collected = false //if(collected==undefined)就相当于if(collected)
    this.setData({
      postData,
      collected
    })


  },


  async onCollect(e) {
    const result = await wx.showModal({
      title: !this.data.collected ? '进行收藏' : '取消收藏',
    })
    if (!result.confirm) return;

    let postCollected = this.data._postCollected //将当前data中(相当于之前本地缓存的postCollected)拉去下来,防止被覆盖
    postCollected[this.data._pid] = !this.data.collected
    this.setData({
      collected: !this.data.collected
    })
    wx.setStorageSync('posts_collected', postCollected)
    wx.showToast({
      //此处其实已经被修改完状态,才开始提示,所以要反过来
      title: this.data.collected ? '收藏成功' : '取消收藏',
      duration: 1000
    })
  },
  // onCollect:async (e)=> {  箭头函数写法,需要保存this指向
  //   console.log(con)
  // const result = await wx.showModal({
  //   title:  !con.data.collected ? '进行收藏' : '取消收藏',
  // })
  // if (!result.confirm) return;

  // let postCollected = con.data._postCollected //将当前data中(相当于之前本地缓存的postCollected)拉去下来,防止被覆盖
  // postCollected[con.data._pid] = !con.data.collected
  // con.setData({
  //   collected: !con.data.collected
  // })
  // wx.setStorageSync('posts_collected', postCollected)
  // wx.showToast({
  //   //此处其实已经被修改完状态,才开始提示,所以要反过来
  //   title: con.data.collected ? '收藏成功' : '取消收藏',
  //   duration: 1000
  // })

  async onShare(e) {
    const result = await wx.showActionSheet({
      itemList: ['分享到QQ', '分享到微信', '分享到朋友圈'],
    })
    // if (!result.confirm) return;
    console.log(result)

  },

  onMusic() {
    const mgr=wx.getBackgroundAudioManager()
    mgr.src=this.data.postData.music.url
    mgr.title=this.data.postData.music.title
    if(this.data.isPlaying) mgr.stop()  //当前播放状态如果为true则暂停
    this.setData({
      isPlaying:!this.data.isPlaying
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

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

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

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})