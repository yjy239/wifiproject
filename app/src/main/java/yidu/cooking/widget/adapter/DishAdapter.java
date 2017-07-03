package yidu.cooking.widget.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import yidu.cooking.R;

/**
 * Created by Administrator on 2017/7/3.
 */
public class DishAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<String> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public DishAdapter(Context context, List<String> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DishViewHolder(inflater.inflate(R.layout.item_dish_layout, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class DishViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_dish)
        ImageView ivDish;
        @BindView(R.id.tv_dish)
        TextView tvDish;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.temp)
        TextView temp;
        public DishViewHolder(View itemView) {
            super(itemView);
        }
    }
}
