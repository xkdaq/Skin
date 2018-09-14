# Skin
效果图  

![](https://raw.githubusercontent.com/xkdaq/Skin/master/app/img/skin.gif)

### 1. 集成步骤：

1. 添加依赖 <code> compile 'com.solid.skin:skinlibrary:latestVersion' </code>

2. 让你的 Application 继承于 SkinBaseApplication

3. 让你的 Activity 继承于 SkinBaseActivity，如果使用了 Fragment 则继承于 SkinBaseFragment

4. 在需要换肤的根布局上添加 <code>xmlns:skin="http://schemas.android.com/android/skin" </code>，然后在需要换肤的View上加上 <code>skin:enable="true" </code>

5. 新建一个项目模块（只包含有资源文件,例如本项目的 skinpackage 模块），其中包含的资源文件的 name 一定要和原项目中有换肤需求的 View 所使用的资源name一致。

6. 拿到上一步生成的文件( ×××.apk )，改名为 ×××.skin，放入 assets 中的 skin 目录下（ skin 目录是自己新建的）

7. 调用换肤

```html
   SkinManager.getInstance().loadSkin("Your skin file name in assets(eg:theme.skin)",
            new ILoaderListener() {
                @Override
                public void onStart() {
                    Toast.makeText(getApplicationContext(), "正在切换中", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSuccess() {
                    Toast.makeText(getApplicationContext(), "切换成功", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailed() {
                    Toast.makeText(getApplicationContext(), "切换失败", Toast.LENGTH_SHORT).show();
                }
            }

    );
```
