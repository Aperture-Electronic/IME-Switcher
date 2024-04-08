# IME Switcher
*IME Switcher*可用于在某些手机UI上（说的就是你，小米HyperOS）增加从消息栏快速切换输入法的功能。
它在后台提供一个常驻服务，服务提供一个消息栏入口，点击后就会调用系统自带的输入法切换功能，与MIUI原先的输入法切换功能比较像。

## 应用使用方法
1. 安装应用APK文件；  
2. 在“设置”中，向IME Switcher应用提供以下权限；  
    * 其它权限/后台弹出界面
    * 其它权限/显示悬浮窗
3. 同样在“设置”中，允许IME Switcher发送通知；
4. 同样在“设置”中，将IME Switcher的自启动打开；
5. 启动IME Switcher，应用将显示白屏后自动关闭；
6. 在“应用历史记录”中（小米手机全面屏手势为从底部上滑打开，按键为菜单键），可以找到白色屏幕的IME Switch应用，长按选择锁头将其锁定，防止请后台的时候误清理；
7. 此时，在系统通知栏就会出现IME Switcher的入口，在任意时候点击可以切换输入法

## 疑难解答 (Q&A)
Q: 为什么启动应用后，系统通知栏没有出现IME Switcher的入口？  
A: 这可能是因为系统通知推送有bug，你可以完整结束IME Switcher，然后重新打开试试。  
  
Q: 为什么切换输入法以后，输入法键盘迟迟不能打开？  
A: 一些输入法启动很慢，可以等以下，或切换几个不同的文本框再试试。  

## 自行编译
本作品开源，您可以根据需要自行修改代码重新编译程序。  
目前，本作品是在Android Studio上，利用Android 10 SDK开发的，开发语言是Kotlin。  
您可以通过Android Studio打开仓库目录，重新构建应用程序。

## 镜像仓库
本作品在其它代码托管平台拥有镜像仓库 [GitHub](https://github.com/Aperture-Electronic/IME-Switcher) [Gitee](https://gitee.com/apertureelectronic/ime-switcher)