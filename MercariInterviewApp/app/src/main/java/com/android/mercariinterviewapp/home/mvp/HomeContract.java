package com.android.mercariinterviewapp.home.mvp;

import com.android.mercariinterviewapp.base.BasePresenter;
import com.android.mercariinterviewapp.base.BaseView;
import com.android.mercariinterviewapp.data.Item;

import java.util.List;

/**
 * Created by AbhishekKejriwal on 7/12/2017.
 */

public interface HomeContract {

    interface View extends BaseView {
        void showRecyclerViewData(List<Item> itemList);
    }

    interface Presenter extends BasePresenter<View> {
        void setRecyclerViewData();
    }
}
