// pages/posts/posts.js
const postData = require("../../data.js");
// const postData=require("/data.js");不可以用绝对路径,需要用相对路径
import {
  content
} from '../../data'
// console.log(postData)
// console.log(content)


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
  onLoad:async function (options) {
    //setData可以直接将数据加入data中;如果在data中已经有该值,则修改
    //它有着创建+更新功能  但正常是用来更新
    this.setData({
      posts: content
    })
    //前端的数据库
    wx.setStorageSync('flag',"xxxxxxxxxxxxx")
    // // wx.setStorageSync('flag', false)
    // const flag=wx.getStorageSync('flag')
    // console.log(flag)
    // const flag = await wx.getStorage({ key: 'flag'})
    // console.log(flag)
  },

  onGoDetail: (e) => {
    const pid = e.currentTarget.dataset.id
    wx.navigateTo({
      url: '/pages/post-detail/post-detail?pid=' + pid,
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