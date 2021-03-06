package com.xuke.skin.view.widget.bottombarlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xuke.skin.R;
import com.xuke.skin.util.UIUtils;

/**
 * @author xuke
 * @description: 底部tab条目(带未读数)
 * @date 2017/6/23  9:14
 */
public class BottomBarItem extends LinearLayout {

    private Context mContext;
    private Drawable mIconNormalDrawable;           //普通状态图标的资源id
    private Drawable mIconSelectedDrawable;         //选中状态图标的资源id
    private String mText;                           //文本
    private int mTextSize = 12;                     //文字大小 默认为12sp
    private int mTextColorNormal = 0xFF999999;      //描述文本的默认显示颜色
    private int mTextColorSelected = 0xFF46C01B;    //述文本的默认选中显示颜色
    private int mMarginTop = 0;                     //文字和图标的距离,默认0dp
    private boolean mOpenTouchBg = false;           //是否开启触摸背景，默认关闭
    private Drawable mTouchDrawable;                //触摸时的背景
    private int mIconWidth;                         //图标的宽度
    private int mIconHeight;                        //图标的高度
    private int mItemPadding;                       //BottomBarItem的padding


    public void setmIconNormalDrawable(Drawable mIconNormalDrawable) {
        this.mIconNormalDrawable = mIconNormalDrawable;
    }

    public void setmIconSelectedDrawable(Drawable mIconSelectedDrawable) {
        this.mIconSelectedDrawable = mIconSelectedDrawable;
    }

    public void setmTextColorSelected(int mTextColorSelected) {
        this.mTextColorSelected = mTextColorSelected;
    }

    public void setStatus(boolean isSelected) {
        mImageView.setImageDrawable(isSelected ? mIconSelectedDrawable : mIconNormalDrawable);
        mTextView.setTextColor(isSelected ? mTextColorSelected : mTextColorNormal);
    }

    private ImageView mImageView;
    private TextView mTextView;



    public BottomBarItem(Context context) {
        this(context, null);
    }

    public BottomBarItem(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomBarItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BottomBarItem);

        mIconNormalDrawable = ta.getDrawable(R.styleable.BottomBarItem_iconNormalDrawable);
        mIconSelectedDrawable = ta.getDrawable(R.styleable.BottomBarItem_iconSelectedDrawable);

        mText = ta.getString(R.styleable.BottomBarItem_itemText);
        mTextSize = ta.getDimensionPixelSize(R.styleable.BottomBarItem_itemTextSize, UIUtils.sp2px(mContext, mTextSize));

        mTextColorNormal = ta.getColor(R.styleable.BottomBarItem_textColorNormal, mTextColorNormal);
        mTextColorSelected = ta.getColor(R.styleable.BottomBarItem_textColorSelected, mTextColorSelected);

        mMarginTop = ta.getDimensionPixelSize(R.styleable.BottomBarItem_itemMarginTop, UIUtils.dip2Px(mContext, mMarginTop));

        mOpenTouchBg = ta.getBoolean(R.styleable.BottomBarItem_openTouchBg, mOpenTouchBg);
        mTouchDrawable = ta.getDrawable(R.styleable.BottomBarItem_touchDrawable);

        mIconWidth = ta.getDimensionPixelSize(R.styleable.BottomBarItem_iconWidth, 0);
        mIconHeight = ta.getDimensionPixelSize(R.styleable.BottomBarItem_iconHeight, 0);
        mItemPadding = ta.getDimensionPixelSize(R.styleable.BottomBarItem_itemPadding, 0);
        ta.recycle();
        checkValues();
        init();
    }

    /**
     * 检查传入的值是否完善
     */
    private void checkValues() {
        if (mOpenTouchBg && mTouchDrawable == null) {
            //如果有开启触摸背景效果但是没有传对应的drawable
            throw new IllegalStateException("开启了触摸效果，但是没有指定touchDrawable");
        }
    }

    private void init() {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);

        View view = View.inflate(mContext, R.layout.item_bottom_bar, null);
        if (mItemPadding != 0) {
            //如果有设置item的padding
            view.setPadding(mItemPadding, mItemPadding, mItemPadding, mItemPadding);
        }
        mImageView = (ImageView) view.findViewById(R.id.iv_icon);
        mTextView = (TextView) view.findViewById(R.id.tv_text);

        if (mIconNormalDrawable != null) {
            mImageView.setImageDrawable(mIconNormalDrawable);
        }

        if (mIconWidth != 0 && mIconHeight != 0) {
            //如果有设置图标的宽度和高度，则设置ImageView的宽高
            FrameLayout.LayoutParams imageLayoutParams = (FrameLayout.LayoutParams) mImageView.getLayoutParams();
            imageLayoutParams.width = mIconWidth;
            imageLayoutParams.height = mIconHeight;
            mImageView.setLayoutParams(imageLayoutParams);
        }

        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);//设置底部文字字体大小

        mTextView.setTextColor(mTextColorNormal);//设置底部文字字体颜色
        mTextView.setText(mText);//设置标签文字

        LayoutParams textLayoutParams = (LayoutParams) mTextView.getLayoutParams();
        textLayoutParams.topMargin = mMarginTop;
        mTextView.setLayoutParams(textLayoutParams);

        if (mOpenTouchBg) {
            //如果有开启触摸背景
            //setBackground(mTouchDrawable);
        }

        addView(view);
    }
}
