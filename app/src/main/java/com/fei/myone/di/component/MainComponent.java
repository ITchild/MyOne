package com.fei.myone.di.component;

import com.fei.myone.di.moudel.MainMoudel;
import com.fei.myone.mvp.view.MainActivity;

import dagger.Component;

/**
 * Created by fei on 2018/3/29.
 */


@Component(modules = MainMoudel.class)
public interface MainComponent {

    void Inject(MainActivity mainActivity);

}
