package com.example.junghyun.mt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.junghyun.mt.App;

/**
 * Created by JungHyun on 2018-02-10.
 */

public class CanaroTextView extends android.support.v7.widget.AppCompatTextView {
    public CanaroTextView(Context context) {
        this(context, null);
    }

    public CanaroTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanaroTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(App.canaroExtraBold);
    }

}