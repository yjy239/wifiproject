package yidu.cooking.widget.MuliTypeAdapter;

import android.view.View;

//import testcom.onlineeducation.bean.EduBean;

/**
 * Created by Administrator on 2017/3/29 0029.
 */
public interface TypeFactory {


    BaseViewHolder createViewHolder(int type, View itemView);
}
