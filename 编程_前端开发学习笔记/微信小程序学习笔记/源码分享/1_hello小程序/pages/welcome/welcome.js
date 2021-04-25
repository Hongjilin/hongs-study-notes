// pages/welcome/welcome.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  //跳转页面
  onTap: (params) => {

    console.log("跳转")
    //这个方法跳转相当于变成子页面
    wx.navigateTo({
      url: '/pages/posts/posts',
    })
    // //关闭这个
    // wx.redirectTo({
    //   url: '/pages/posts/posts',
    // })
/**
 wx.navigateTo() 没有关闭当前的是将页面压入页面站
 redirectTo() 
 */
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
console.log("页面加载welcome")
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