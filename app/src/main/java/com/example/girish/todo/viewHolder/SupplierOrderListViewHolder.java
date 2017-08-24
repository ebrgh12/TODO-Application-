package com.example.girish.todo.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.example.girish.todo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Girish on 8/18/2017.
 */
public class SupplierOrderListViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.product_image)
    public CircleImageView productImage;

    @InjectView(R.id.product_name)
    public TextView productName;

    @InjectView(R.id.product_quantity)
    public TextView productQuantity;

    public SupplierOrderListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this,itemView);
    }

}
