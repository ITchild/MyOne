package com.fei.myone;

import android.support.annotation.NonNull;

/**
 * Created by fei on 2018/3/20.
 */

public interface BasePersenter <T extends BaseView> {

    //绑定View
    void attachView(@NonNull T view);
    //解绑view
    void detachView ();

}
