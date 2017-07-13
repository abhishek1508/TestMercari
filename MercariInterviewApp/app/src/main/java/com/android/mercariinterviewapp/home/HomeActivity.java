package com.android.mercariinterviewapp.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.mercariinterviewapp.MercariApp;
import com.android.mercariinterviewapp.R;
import com.android.mercariinterviewapp.data.Item;
import com.android.mercariinterviewapp.dependencyinjection.components.DaggerHomeComponent;
import com.android.mercariinterviewapp.dependencyinjection.modules.HomeModule;
import com.android.mercariinterviewapp.home.mvp.HomeContract;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    @Inject Adapter adapter;
    @Inject HomeContract.Presenter presenter;
    @Inject GridLayoutManager manager;
    //@Inject Retrofit retrofit;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setDagger();
        initData();
    }

    private void setDagger() {
        DaggerHomeComponent
                .builder()
                .appComponent(((MercariApp)getApplication()).getAppComponent())
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    private void initData() {
        presenter.attachView(this);
        presenter.setRecyclerViewData();
    }

    @Override
    public void showRecyclerViewData(List<Item> itemList) {
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemList(itemList);
    }
}