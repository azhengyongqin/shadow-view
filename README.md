> #### 请注明出处http://blog.csdn.net/qq_23179075/article/details/71123452
***
> ### 描述:  一个控件阴影效果,支持阴影大小和颜色设置,可以设置控件上下的阴影;

> #### 使用方式:在build.gradle中加入以下代码
```java
compile 'com.zhengliang:shadow-view:1.0.1'
```

### 顶部阴影效果
![Paste_Image.png](http://upload-images.jianshu.io/upload_images/2909848-9d2c92b06184e4ff.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
### 底部阴影效果

![Paste_Image.png](http://upload-images.jianshu.io/upload_images/2909848-6aedc051ecfccc85.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 使用方式xml:
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
### 如果要给某个控件加这个阴影效果,必须将要加的控件和该控件放在在`RelativeLayout`中
| xml自定义属性| java代码| 功能|
| ------------- |:-------------| -----:|
| shadow_color | setShadow_color | 设置阴影颜色 |
| shadow_fuzzy_radius | setShadow_fuzzy_radius| 设置阴影模糊半径 |
| shadow_height | setShadow_height | 设置阴影高度 |
| shadow_position| setShadow_position | 设置阴影位置(up上、down下) |
| view_id | | 绑定需要设置阴影的控件 |
##### 源码地址:https://github.com/azhengyongqin/shadow-view
