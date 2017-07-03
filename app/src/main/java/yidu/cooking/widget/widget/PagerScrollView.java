package yidu.cooking.widget.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2017/7/3.
 */
public class PagerScrollView extends ScrollView {

    public PagerScrollView(Context context) {
        super(context);
    }

    public PagerScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PagerScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int xDown = 0;
        int yDown = 0;
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                xDown = (int)ev.getX();
                yDown = (int)ev.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                int x = (int)ev.getX();
                int y = (int)ev.getY();
                int deltaX = x - xDown;
                int deltaY = y - yDown;
                if(Math.abs(deltaX) >Math.abs(deltaY) ){
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
