OAuth2示例代码流程说明：
1、启动：consumer和service-provider两个web项目，端口号分别为9002和9001；
2、初次访问：http://localhost:9002/consumer/request1.action，跳转到用户名密码输入界面，授权开始；
3、提交后，跳转到http://localhost:9001/oauth2/success.action?appKey=appKey1&appSecret=appSecret1&authorizedRequestToken=k1stz2，显示Access Token；
4、再次访问：http://localhost:9002/consumer/request2.action?access_token=x9ipw3，access_token填写上一步获得的Access Token；
5、跳转到http://localhost:9001/provider1.action?app_key=appKey1&app_secret=appSecret1&access_token=x9ipw3，正常访问成功。

示例代码存储token使用的是redis，所以需要安装redis。