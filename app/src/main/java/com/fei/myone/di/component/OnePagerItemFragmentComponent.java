package com.fei.myone.di.component;

import com.fei.myone.di.moudel.OnePagerItemFragmentMoudel;
import com.fei.myone.mvp.view.fragment.OnePagerItemFragment;

import dagger.Component;

/**
 * Created by fei on 2018/4/2.
 */
@Component(modules = OnePagerItemFragmentMoudel.class)
public interface OnePagerItemFragmentComponent {

    void Inject(OnePagerItemFragment onePagerItemFragment);
}
