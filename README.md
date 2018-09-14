# Skin
效果图

![](https://raw.githubusercontent.com/xkdaq/Skin/master/app/img/skin.gif)

### 1. 集成步骤：

1. 添加依赖

```
implementation 'com.solid.skin:skinlibrary:2.0.0-beta3'
```

2. 让你的 Application 继承于 SkinBaseApplication

3. 让你的 Activity 继承于 SkinBaseActivity，如果使用了 Fragment 则继承于 SkinBaseFragment

4. 在需要换肤的根布局上添加`xmlns:skin="http://schemas.android.com/android/skin"`然后在需要换肤的View上加上`skin:enable="true"`

5. 新建一个项目模块（只包含有资源文件,例如本项目的skin模块），其中包含的资源文件的 name 一定要和原项目中有换肤需求的 View 所使用的资源name一致。  

6.通过打包skin正式包生成一个.apk文件,改名为.skin为后缀的文件(可以build.gradle直接设置生成文件后缀名)放入 assets 中的skin目录下（skin目录是自己新建的）

7. 调用换肤
```java
SkinManager.getInstance().loadSkin("theme-20180914.skin",
        new SkinLoaderListener() {
            @Override
            public void onStart() {
                Log.i("SkinLoaderListener", "正在切换中");
            }
    
            @Override
            public void onSuccess() {
                Log.i("SkinLoaderListener", "切换成功");
            }
    
            @Override
            public void onFailed(String errMsg) {
                Log.i("SkinLoaderListener", "切换失败:" + errMsg);
            }
    
            @Override
            public void onProgress(int progress) {
                Log.i("SkinLoaderListener", "皮肤文件下载中:" + progress);
    
            }
        }
);
```
