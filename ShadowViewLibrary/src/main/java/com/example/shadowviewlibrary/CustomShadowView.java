package com.example.shadowviewlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * 时 间: 2017/4/7
 * 作 者: 郑亮
 * Q  Q : 1023007219
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CustomShadowView extends View {
    private static final String TAG = "CustomShadowView";
    private Paint mPaint;
    /**
     * 模糊半径
     */
    private static final float fuzzyRadius = 25f;
    /**
     * 阴影颜色
     */
    private int shadow_color;
    /**
     * 阴影高度
     */
    private float shadow_height;
    /**
     * 阴影位置
     */
    private int shadow_position;
    /**
     * 位置
     */
    public static final int SHADOW_UP = 1;
    public static final int SHADOW_DOWN = 2;
    /**
     * 阴影的矩形
     */
    private RectF rect;
    private int left, top, right, bottom;
    /**
     * 显示阴影的控件id
     */
    private int view_id;
    private View view;


    public CustomShadowView(Context context) {
        super(context);
        init(null);
    }

    public CustomShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomShadowView);
        /*初始化自定义属性*/
        initAttrs(typedArray);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        this.setElevation(-1);
    }

    /**
     * 初始化自定义属性
     * @param typedArray
     */
    private void initAttrs(TypedArray typedArray) {
        if (typedArray != null) {
            shadow_color = typedArray.getColor(R.styleable.CustomShadowView_shadow_color, 0x5549c4fa);
            shadow_height = typedArray.getDimension(R.styleable.CustomShadowView_shadow_height, 25);
            shadow_position = typedArray.getInt(R.styleable.CustomShadowView_shadow_position, 2);
            view_id = typedArray.getResourceId(R.styleable.CustomShadowView_view_id, 0);
            typedArray.recycle();
        }
    }

    /**
     * Xml中定义的布局解析出来。
     */
    private void findView() {
        if (view_id == 0) {
            return;
        }
        Context context = getContext();
        if (context instanceof Activity) {
            Activity activity = (Activity) getContext();
            Log.e(TAG, "id是多少: " + view_id);
            View view = activity.findViewById(view_id);
            this.view = view;
            if (this.view != null) {

            }
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        findView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的阴影，param1：模糊半径；param2：x轴大小：param3：y轴大小；param4：阴影颜色
        if (shadow_position == SHADOW_UP) {//阴影在上面
            mPaint.setShadowLayer(fuzzyRadius, 0, -shadow_height, shadow_color);
            rect = new RectF(left, top, right, bottom-((bottom-top)/2));
        } else if (shadow_position == SHADOW_DOWN) {//阴影在下面
            mPaint.setShadowLayer(fuzzyRadius, 0, shadow_height, shadow_color);
            rect = new RectF(left, top+((bottom-top)/2), right, bottom);
        }
        canvas.drawRect(rect, mPaint);
    }

    /**
     * 获取View的属性
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (this.view != null) {

            this.left = this.view.getLeft();
            this.top = this.view.getTop();
            this.right = this.view.getRight();
            this.bottom = this.view.getBottom();
        }

    }
}
