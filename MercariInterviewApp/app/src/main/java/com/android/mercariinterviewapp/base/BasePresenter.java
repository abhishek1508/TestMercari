package com.android.mercariinterviewapp.base;

/**
 * Created by AbhishekKejriwal on 7/11/2017.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
}
