package yidu.cooking.widget.MuliTypeAdapter;

import android.content.Context;
import android.view.View;

//import testcom.onlineeducation.bean.EduBean;


/**
 * Created by Administrator on 2017/3/29 0029.
 */
public class TypeFactoryForList implements TypeFactory {

    private Context context;

    public TypeFactoryForList() {

    }

    public TypeFactoryForList(Context context) {
        this.context = context;
    }




    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {

        return null;
    }
}