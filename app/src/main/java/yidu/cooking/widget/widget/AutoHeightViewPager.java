package yidu.cooking.widget.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/7/3.
 */
public class AutoHeightViewPager extends ViewPager {

    private Context context;
    private AttributeSet attrs;


    public AutoHeightViewPager(Context context) {
        super(context);
        this.context = context;
    }

    public AutoHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        int height = 0;
        for(int i = 0;i<count;i++){
            View child = getChildAt(i);
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
//            child.measure(child.getMeasuredWidth(),MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED));
//            还要处理子view具体高度
//            int childheight = 0;
//            if(child instanceof ViewGroup){
//                ViewGroup childgroup = (ViewGroup)child;
//                int childcount = childgroup.getChildCount();
//                Log.e("childcount"+i,childcount+"");
//                for(int j = 0;j<childcount;j++){
//                    View grandchild = childgroup.getChildAt(i);
//                    if(grandchild !=null){
//                        measureChild(grandchild,childgroup.getMeasuredWidth(),childgroup.getMeasuredHeight());
////                    grandchild.measure(grandchild.getMeasuredWidth(),MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED));
//                        PagerMarginParams params = new PagerMarginParams((MarginLayoutParams) grandchild.getLayoutParams());
////                    MarginLayoutParams params =(MarginLayoutParams) grandchild.getLayoutParams();
//                        int marginbottom = params.bottomMargin;
//                        int margintop = params.topMargin;
//                        int paddingtop = grandchild.getPaddingTop();
//                        int paddingbottom = grandchild.getPaddingBottom();
//                        Log.e("margin","top:"+margintop+"bottom"+marginbottom);
//                        childheight += grandchild.getMeasuredHeight()+ marginbottom+margintop+paddingbottom+paddingtop;
//                        Log.e(""+i,childheight+"");
//                    }
//                }
//            }
//            Log.e("childheight",childheight+"");
            int h = child.getMeasuredHeight();
//            if(height<h){
//                height = h;
//            }

            Log.e("height",height+"");
//            height = childheight;
            if(h > height){
                height = h;
            }
        }

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);

    }

    private int measureHeight(int measureSpec, int viewGroupHeight) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                result = specSize;
                break;
            case MeasureSpec.AT_MOST:
                /* 将剩余高度和所有子View + padding的值进行比较，取小的作为ViewGroup的高度 */
                result = Math.min(viewGroupHeight, specSize);
                break;
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }

    private int measureWidth(int measureSpec, int viewGroupWidth) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                result = specSize;
                break;
            case MeasureSpec.AT_MOST:
                /* 将剩余宽度和所有子View + padding的值进行比较，取小的作为ViewGroup的宽度 */
                result = Math.min(viewGroupWidth, specSize);
                break;
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(context,attrs);
    }

    public class PagerMarginParams extends ViewGroup.MarginLayoutParams{

        public PagerMarginParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public PagerMarginParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public PagerMarginParams(MarginLayoutParams source) {
            super(source);
        }


    }
}
