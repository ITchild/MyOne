package com.fei.myone.mvp.contract;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.fei.myone.BasePersenter;
import com.fei.myone.BaseView;
import com.fei.myone.mvp.view.fragment.adapter.OneViewPagerAdapter;

import java.util.List;

/**
 * Created by fei on 2018/4/2.
 */

public abstract class OneFragmentContract {

    public interface View extends BaseView{
        void getInitFragments(List<Fragment> fragments);
        void addFragment(List<Fragment> fragments);

    }

    public interface Persenter extends BasePersenter<View>{
        void getInitFragments();
        void addFragment(int position);
    }
}
