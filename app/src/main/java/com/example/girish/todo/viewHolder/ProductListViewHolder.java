package com.example.girish.todo.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.girish.todo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Girish on 8/19/2017.
 */
public class ProductListViewHolder extends RecyclerView.ViewHolder {
    @InjectView(R.id.product_name)
    public TextView ProductName;

    @InjectView(R.id.product_price)
    public TextView ProductPrice;

    @InjectView(R.id.product_quantity)
    public TextView productQuantity;

    @InjectView(R.id.product_image)
    public ImageView productImage;

    @InjectView(R.id.make_sale)
    public TextView makeSale;

    public ProductListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this,itemView);
    }

}
