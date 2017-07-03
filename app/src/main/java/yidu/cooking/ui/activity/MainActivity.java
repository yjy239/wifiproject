package yidu.cooking.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yidu.cooking.R;
import yidu.cooking.ui.fragment.CookFragment;
import yidu.cooking.ui.fragment.MyFragment;
import yidu.cooking.ui.fragment.SetFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.iv_cook)
    ImageView ivCook;
    @BindView(R.id.tv_cook)
    TextView tvCook;
    @BindView(R.id.Cook)
    LinearLayout Cook;
    @BindView(R.id.iv_my)
    ImageView ivMy;
    @BindView(R.id.tv_my)
    TextView tvMy;
    @BindView(R.id.my)
    LinearLayout my;
    @BindView(R.id.iv_set)
    ImageView ivSet;
    @BindView(R.id.tv_set)
    TextView tvSet;
    @BindView(R.id.set)
    LinearLayout set;
    @BindView(R.id.bottom_tab)
    LinearLayout bottomTab;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private MyFragment myFragment;
    private SetFragment setFragment;
    private CookFragment cookFragment;
    int currentFragmentIndex = 0;
    private int clickIndex = 0;
    private Fragment[] fragments;
    private Fragment showFragment;
    private static final String COOK_TAG = "cook";
    private static final String MY_TAG = "my";
    private static final String SET_TAG = "set";
    private String[] tags = new String[]{COOK_TAG, SET_TAG, MY_TAG};
    private ArrayList<TextView> tvList = new ArrayList<>();
    private ArrayList<ImageView> ivList = new ArrayList<>();

    @Override
    protected int setViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        ButterKnife.bind(this);
        tvList.add(tvCook);
        tvList.add(tvMy);
        tvList.add(tvSet);

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {

    }

    @Override
    protected void handlerSaveInstanceState(Bundle savedInstanceState) {
        super.handlerSaveInstanceState(savedInstanceState);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        if (savedInstanceState != null) {
            cookFragment = (CookFragment) manager.findFragmentByTag(COOK_TAG);
            setFragment = (SetFragment) manager.findFragmentByTag(MY_TAG);
            myFragment = (MyFragment) manager.findFragmentByTag(MY_TAG);

            //初始化，主页界面
            if (cookFragment == null)
                cookFragment = new CookFragment();
            if (setFragment == null)
                setFragment = new SetFragment();
            if (myFragment == null)
                myFragment = new MyFragment();

            fragments = new Fragment[]{
                    cookFragment,
                    setFragment,
                    myFragment
            };
            for (int i = 0; i < fragments.length; i++) {
                if (!fragments[i].isAdded()) {
                    transaction.add(R.id.container, fragments[i], tags[i]);
                }
            }
            transaction.show(cookFragment).hide(setFragment).hide(myFragment).commit();
        } else {
            initFragment();
        }
    }

    public void initFragment() {
        try {
            //初始化，主页界面
            setFragment = new SetFragment();
            cookFragment = new CookFragment();
            myFragment = new MyFragment();

            fragments = new Fragment[]{
                    cookFragment,
                    setFragment,
                    myFragment
            };
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, cookFragment, COOK_TAG)
                    .add(R.id.container, myFragment, MY_TAG)
                    .add(R.id.container, setFragment, SET_TAG)
                    .show(cookFragment)
                    .hide(myFragment)
                    .hide(setFragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void loadData() {

    }

    public void changeFragment() {
        if (clickIndex != currentFragmentIndex) {
            // 单击别的按钮，显示另外一个fragment
            showFragment = fragments[clickIndex];
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!showFragment.isAdded()) {
                // 以前没有显示过
                transaction.add(R.id.container, showFragment, tags[clickIndex]);
            }
            transaction.hide(fragments[currentFragmentIndex])
                    .show(showFragment)
                    .commit();

            for (int i = 0; i < tvList.size(); i++) {
                tvList.get(i).setTextColor(ContextCompat.getColor(this, R.color.black));
//                ivList.get(i).setImageResource(iconDefaults[i]);
            }
            tvList.get(clickIndex).setTextColor(ContextCompat.getColor(this, R.color.green));
//            ivList.get(clickIndex).setImageResource(iconClicks[clickIndex]);
            currentFragmentIndex = clickIndex;
        }

    }


    @OnClick({R.id.Cook, R.id.my, R.id.set})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Cook:
                break;
            case R.id.my:
                break;
            case R.id.set:
                break;
        }
    }
}
