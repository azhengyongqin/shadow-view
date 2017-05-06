> ####<B> 请注明出处http://blog.csdn.net/qq_23179075/article/details/71244693
***
>###<B>描述:<font color="#FF4567">  一个控件阴影效果,支持阴影大小和颜色设置,可以设置控件上下的阴影;
###<B>使用方式:在build.gradle中加入以下代码
```java
compile 'com.zhengliang:shadow-view:1.0.1'
```

##<B> 顶部阴影效果
![Paste_Image.png](http://upload-images.jianshu.io/upload_images/2909848-9d2c92b06184e4ff.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
##<B> 底部阴影效果

![Paste_Image.png](http://upload-images.jianshu.io/upload_images/2909848-6aedc051ecfccc85.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##<B> 使用方式xml:
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
        <TextView
            android:id="@+id/tv_test"
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:background="#FF4567"
            android:gravity="center"
            android:text="Hello World!"
            android:layout_centerInParent="true"
            />
        <com.example.shadowviewlibrary.CustomShadowView
            android:id="@+id/shadow_view"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:shadow_color="@color/colorPrimary"
            app:shadow_fuzzy_radius="25"
            app:shadow_height="10dp"
            app:shadow_position="down"
            app:view_id="@id/tv_test" />
</RelativeLayout>
```
##<B> 如果要给某个控件加这个阴影效果,必须将要加的控件和该控件放在在`RelativeLayout`中
| <B>xml自定义属性| <B>java代码| <B>功能|
| ------------- |:-------------| -----:|
| <B>shadow_color | <B>setShadow_color | <B>设置阴影颜色 |
| <B>shadow_fuzzy_radius | <B>setShadow_fuzzy_radius| <B>设置阴影模糊半径 |
| <B>shadow_height | <B>setShadow_height | <B>设置阴影高度 |
| <B>shadow_position| <B>setShadow_position | <B>设置阴影位置(up上、down下) |
| <B>view_id | | <B>绑定需要设置阴影的控件 |
####<B>源码地址:https://github.com/azhengyongqin/shadow-view

