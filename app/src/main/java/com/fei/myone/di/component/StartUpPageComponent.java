package com.fei.myone.di.component;

import com.fei.myone.di.moudel.StartUpPageMoudel;
import com.fei.myone.mvp.view.StartUpPageActivity;

import dagger.Component;

/**
 * Created by fei on 2018/3/29.
 * 用来注入对象
 */

@Component(modules = StartUpPageMoudel.class)
public interface StartUpPageComponent {

    void Inject(StartUpPageActivity startUpPageActivity);

}
