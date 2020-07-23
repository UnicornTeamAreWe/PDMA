# PDMA
## Unicorn personal data management and analysis platform

指导老师：任锐  

助教：支晨曦  

成员：  
      赵嘉凯 518021910454  
      李宽野 518021910330  
      温家乐 518021910392  
      秦梁 518021911003

## 7.22
赵嘉凯: 运行Junit测试demo，解决测试demo中遇到的问题
      
## 7.21
秦梁: 成功用python连接本地mysql数据库,并且完成淘宝信息的爬虫之后自动写入数据库,准备将支付宝账单导入数据库但是由于账单还有除表之外的信息,所以需要用python处理,然而由于编码等问题,csv文件不能成功打开, 尚在研究解决方法.
赵嘉凯: 了解Junit使用方法

# 第三周计划

## 一、实现功能
### 1、获取数据处理格式并存入本地mysql数据库(秦梁)
### 2、获取数据的后端接口实现(秦梁)
### 3、分析数据(温家乐)
### 4、数据前端的展示
### (1)前端接口对接、数据获取(李宽野)
### (2)图表展示(秦梁)
## 二、后端安全性实现(李宽野)
## 三、单元测试(赵嘉凯)

## 7.20
秦梁: 完成获取支付宝数据、淘宝数据等后端功能的实现, 完成淘宝信息的爬虫.

## 7.16
秦梁: 完成后端框架搭建以及登陆、注册、软件授权等后端功能的实现, 开始着手淘宝信息的爬虫.

## 7.15
秦梁: 实现自动选择时间范围并下载支付宝账单.  
李宽野：实现通过手动验证码登陆获取美团酒店出行信息  

## 7.14
秦梁:尝试爬取支付宝的账单,发现反爬机制十分严重,许多以前可行的方法现在都不起作用, 而且有专门针对 Selenium 的时间监听,需要寻求新的方法.  
李宽野：基本确定API获取出行信息不太可能，使用爬虫获取美团，携程的个人信息或可行，正在实现  
赵嘉凯：配置远程Web服务器   
温家乐：申请微博API，选择网站接入的方式，但是仍在探寻如何申请公司身份以获得更多的数据服务

## 7.13
秦梁:尝试申请支付宝api,发现需要经营证书,通过api获取数据行不通, 参考一些记账软件的方法,发现需要用户自己登陆支付宝,然后下载账单.  
李宽野: 了解出行相关应用是否提供API，并尝试使用，发现API多为商户型，无法获取到个人订单信息   
温家乐：了解微博API，阅读相关文档，发现微博开发平台可行

### 第二周工作计划
1.爬虫获取数据  
      (1) 网易云(赵嘉凯)  
      (2) 支付宝(秦梁)  
      (3) 滴滴携程(李宽野)  
      (4) 微博(温家乐)  
2.储存数据（mysql、mongodb）  
      (1) 注册登陆 (李宽野)  
      (2) 软件授权——跳转到登陆界面或者获取用户账号密码(李宽野)  
      (3) 数据分析算法 (温家乐)  
      (4) plotly.js 展示图表 (秦梁)  
      (5) 单元测试 (赵嘉凯)  

## 7.10
秦梁: 下载了python3并且配好了环境, 了解到在 Python 3.x 版本后，ConfigParser.py 已经更名为 configparser.py, 解决了import ConfigParser 错误的问题; 进一步学习了爬虫知识并爬取了三条支付宝账单信息; 尝试了其他四种爬取支付宝账单的方法但是暂未成功.

## 7.9
秦梁: 学习爬虫知识并尝试爬取支付宝账单信息 
温家乐：学习了一些具体数据处理算法、爬虫知识

## 7.8
李宽野：基本完成Web框架，大致UI完成（除去需数据部分） 
秦梁: 在完成的Web框架中使用静态数据调试了plotly.js中的各种图表  
温家乐：学习了一些具体数据处理算法、爬虫知识

## 7.7 
赵嘉凯：了解并完成AWS申请和创建虚拟机和远程服务器  
李宽野：了解支付宝等开放平台的数据获取接口的使用方法  
温家乐：了解现有的类似个人数据分析产品，寻找可用的模板  
秦梁：了解数据分析和可视化的方法,决定采用plotly.js

## 7.6 第一次会议

### 任务：
1. Github Private Repo，把助教和我加进去，我的账号zilinglius(renrui@sjtu.edu.cn)
2. 确定大致的技术栈
3. 制定好四周的大致计划，以及本周的详细计划，可以用Github的Project
4. 如果还有时间，开始做计划里的第一项工作

### 内容:
#### 任务1已完成  
#### 技术栈
1. 前端后端, RN  
   react/vue + spring
2. 数据获取  
   支付宝/滴滴等公司的开发平台SDK  
   爬虫（或可）
3. 数据分析  
   ？？
4. 数据可视化  
   py词云
5. 性能测试 
   ？？ 
#### 四周计划
1. UI，数据获取， 框架搭建，需求分析
2. 实现功能
3. 测试
4. 完善
####   本周详细计划
1. 分析
2. UI设计
3. SDK用户授权获取信息
4. 框架搭建
