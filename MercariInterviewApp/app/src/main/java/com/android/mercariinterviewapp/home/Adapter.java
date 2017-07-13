package com.android.mercariinterviewapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.mercariinterviewapp.R;
import com.android.mercariinterviewapp.data.Item;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import rx.Observable;
import timber.log.Timber;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.android.mercariinterviewapp.util.Constants.SOLD_OUT;

/**
 * Created by AbhishekKejriwal on 7/12/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ItemViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<Item> itemList;
    private String TAG = Adapter.class.getSimpleName();

    public Adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        itemList = new ArrayList<>();
    }

    public void setItemList(List<Item> list) {
        itemList.addAll(list);
        notifyItemRangeInserted(0, list.size());
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Observable.just(itemList.get(position))
                .subscribe(item -> {
                    Timber.e(TAG, item);
                    Glide.with(context).load(item.photo).bitmapTransform(new RoundedCornersTransformation(context, 15, 4)).into(holder.photoView);
                    holder.sold.setVisibility(item.status.equalsIgnoreCase(SOLD_OUT) ? VISIBLE : GONE);
                    holder.price.setText(context.getString(R.string.dollar, String.valueOf(item.price)));
                    holder.title.setText(item.name);
                });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.photo) ImageView photoView;
        @BindView(R.id.title) TextView title;
        @BindView(R.id.price) TextView price;
        @BindView(R.id.sold) ImageView sold;
        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
