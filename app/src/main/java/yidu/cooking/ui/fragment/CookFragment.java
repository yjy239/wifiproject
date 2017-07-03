package yidu.cooking.ui.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;
import yidu.cooking.R;
import yidu.cooking.widget.adapter.CookPagerAdapter;
import yidu.cooking.widget.adapter.DishAdapter;
import yidu.cooking.widget.widget.AutoHeightViewPager;
import yidu.cooking.widget.widget.FullyGridLayoutManager;

/**
 * Created by Administrator on 2017/6/30.
 */
public class CookFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.banner_main_flip)
    BGABanner bannerMainFlip;
    @BindView(R.id.tvicon1)
    TextView tvicon1;
    @BindView(R.id.rl_icon1)
    RelativeLayout rlIcon1;
    @BindView(R.id.tv_icon2)
    TextView tvIcon2;
    @BindView(R.id.rl_icon2)
    RelativeLayout rlIcon2;
    @BindView(R.id.tv_icon3)
    TextView tvIcon3;
    @BindView(R.id.rl_icon3)
    RelativeLayout rlIcon3;
    @BindView(R.id.team_bottom_tab)
    LinearLayout teamBottomTab;
    @BindView(R.id.team_cursor)
    ImageView teamCursor;
    @BindView(R.id.pager)
    AutoHeightViewPager pager;

    private View onlinepager;
    private View editpager;
    private View mypager;
    private LayoutInflater inflater;
    private RecyclerView dishlist;
    private SwipeRefreshLayout refreshLayout;
    private DishAdapter dishAdapter;
    private List<String> list = new ArrayList<>();
    private FullyGridLayoutManager manager;
    private List<View> viewlist = new ArrayList<>();
    private CookPagerAdapter viewadapter;
    private List<TextView> txtlist = new ArrayList<>();
    private int currentPage;
    private int clickPage;

    @Override
    protected int setViewId() {
        return R.layout.cookfragment_layout;
    }

    @Override
    protected void findViews(View view) {
        ButterKnife.bind(this, view);
        tvicon1 = (TextView)view.findViewById(R.id.tvicon1);
        tvIcon2 = (TextView)view.findViewById(R.id.tv_icon2);
        tvIcon3 = (TextView)view.findViewById(R.id.tv_icon3);
        txtlist.add(tvicon1);
        txtlist.add(tvIcon2);
        txtlist.add(tvIcon3);
        pager = (AutoHeightViewPager)view.findViewById(R.id.pager);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        onlinepager = inflater.inflate(R.layout.pager_online, null);
        editpager = inflater.inflate(R.layout.pager_edit, null);
        mypager = inflater.inflate(R.layout.pager_mycook, null);
        viewlist.add(onlinepager);
        viewlist.add(editpager);
        viewlist.add(mypager);
        viewadapter = new CookPagerAdapter(viewlist);
        pager.setAdapter(viewadapter);
        pager.setOnPageChangeListener(this);


        dishlist = (RecyclerView) onlinepager.findViewById(R.id.dish_list);
        dishAdapter = new DishAdapter(getActivity(), list);
        manager = new FullyGridLayoutManager(getActivity(), 2);
        dishlist.setLayoutManager(manager);
        dishlist.setAdapter(dishAdapter);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position != currentPage) {
            for (int i = 0; i < txtlist.size(); i++) {
                txtlist.get(i).setTextColor(ContextCompat.getColor(getActivity(), R.color.colorHint));
//                ivList.get(i).setImageResource(iconDefaults[i]);
            }
            txtlist.get(position).setTextColor(ContextCompat.getColor(getActivity(), R.color.green));
//            ivList.get(position).setImageResource(iconClicks[position]);
        }
        currentPage = pager.getCurrentItem();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @OnClick({R.id.rl_icon1, R.id.rl_icon2, R.id.rl_icon3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_icon1:
                clickPage = 0;
                break;
            case R.id.rl_icon2:
                clickPage = 1;
                break;
            case R.id.rl_icon3:
                clickPage = 2;
                break;
        }
    }
}
