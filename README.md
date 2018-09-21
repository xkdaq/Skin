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

### 10.遇到问题

1. recyclerview的adapter根据数据的类型 设置TextView的背景为shape文件时 在xml里面不要设置默认的shape文件 否则换肤之后列表的该TextView所有背景全是默认设置的shape颜色

2. 版本号"implementation 'com.solid.skin:skinlibrary:2.0.0-beta3'" 这个版本里面,设置夜间模式的时候,没有考虑到资源文件放在mipmap的情况,具体文件SkinManager.java的getNightDrawable()方法,如果将换肤的图片放在mipmap文件夹就会找不到文件报错

```
android.view.InflateExceptception: Binary XML file line #0: Binary XML file line #0: Error inflating class LinearLayout
android.content.res.Resources.getDrawable(Rle(le(Resources.java:833))
android.content.res.Resources.getDrawable(Rle(le(Resources.java:805))
solid.ren.skinlibrary.loader.SkinManager.getNightDrawarawable(le(SkinManager.java:341)
solid.ren.skinlibrary.utils.SkinResourcesUtils.getNightDrawarawable(le(SkinResourcesUtils.java:29)
....
```
解决: 
   1.依赖lirbrary,修改getNightDrawable()方法里面的判断,如果取drawable值取不到就取mipmap的
   2.或者就将mipmap的图片移到drawable






