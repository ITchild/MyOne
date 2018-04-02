package com.fei.myone.di.component;

import com.fei.myone.di.moudel.OneFragmentMoudel;
import com.fei.myone.mvp.view.fragment.OneFragment;

import dagger.Component;

/**
 * Created by fei on 2018/4/2.
 */
@Component(modules = OneFragmentMoudel.class)
public interface OneFragmentComponent {

    void Inject(OneFragment oneFragment);
}
