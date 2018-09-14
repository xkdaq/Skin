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

详细的使用，请到示例项目中查看


### 2.换肤属性的扩展

本开源库默认支持 textColor 和 background 的换肤。如果你还需要对其他属性进行换肤，那么就需要去自定义了。

那么如何自定义呢？看下面这个例子：

TabLayout大家应该都用过吧。它下面会有一个指示器，当我们换肤的时候也希望这个指示器的颜色也跟着更改。

- 新建一个 TabLayoutIndicatorAttr 继承于 SkinAttr，然后重写 apply 方法。apply 方法在换肤的时候就会被调用

- 代码的详细实现
```html
public class TabLayoutIndicatorAttr extends SkinAttr {
    @Override
    public void apply(View view) {
        if (view instanceof TabLayout) {
            TabLayout tl = (TabLayout) view;
            if (RES_TYPE_NAME_COLOR.equals(attrValueTypeName)) {
                int color = SkinResourcesUtils.getColor(attrValueRefId);
                tl.setSelectedTabIndicatorColor(color);
            }
        }
    }
}
```

注：attrValueRefId：就是资源 id。SkinResourcesUtils 是用来获取皮肤包里的资源，这里设置color或者drawable一定要使用本工具类。

- 当上面的工作完成之后，就到我们自己的 Application 的 onCreate 方法中加入<code> SkinConfig.addSupportAttr("tabLayoutIndicator", new TabLayoutIndicatorAttr());</code>

- 最后我们就可以正常使用了，<code>dynamicAddSkinEnableView(tablayout, "tabLayoutIndicator", R.color.colorPrimaryDark);</code>

### 3. 关于字体切换

还是遵守本项目的约定大于配置的原则，所有的字体都放到 assets/fonts 文件夹下

如何切换字体:
<code> SkinManager.getInstance().loadFont("xx.ttf")</code>

关于切换字体需要配置的东西：
如果只是单纯的想要字体切换这个功能。只需<code>集成步骤</code>中的前三步就行了。

**注：字体切换功能默认不开启，需要字体切换功能请在你的Application中加入<code>SkinConfig.setCanChangeFont(true);</code>**

### 4. 其他一些重要的api

1. SkinConfig.isDefaultSkin(context):判断当前皮肤是否是默认皮肤

2. SkinManager.getInstance().restoreDefaultTheme(): 重置默认皮肤

3. dynamicAddView：当动态创建的View也需要换肤的时候,就可以调用 dynamicAddView


---
### 5. 使用注意事项：
1. 换肤默认只支持 android 的常用控件，对于支持库的控件和自定义控件的换肤需要动态添加（例如： <code>dynamicAddSkinEnableView(toolbar, "background", R.color.colorPrimaryDark);</code>），在布局文件中使用<code>skin:enable="true"</code>是无效的。

2. 默认不支持状态栏颜色的更改，如果需要换肤的同时也要更改状态栏颜色，请到您的Application文件中加入<code>SkinConfig.setCanChangeStatusColor(true);</code>，状态栏的颜色值来源于<code>colorPrimaryDark</code>

3. 本开源库使用的 Activity 是 AppCompatActivity，使用的 Fragment 是 android.support.v4.app.Fragment

4. 有换肤需求 View 所使用的资源一定要是引用值，例如：@color/red，而不是 #ff0000