package com.example.girish.todo.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.girish.todo.R;
import com.example.girish.todo.activity.MainActivity;
import com.example.girish.todo.database.MainDataBase;
import com.example.girish.todo.model.parsingModel.ProductModel;
import com.example.girish.todo.serviceAndGeneralInterface.CustomItemClickListener;
import com.example.girish.todo.viewHolder.ProductListViewHolder;

import java.util.ArrayList;

/**
 * Created by Girish on 8/15/2017.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListViewHolder> {

    ArrayList<ProductModel> productModelArrayList = new ArrayList<ProductModel>();
    CustomItemClickListener customItemClickListener;
    Activity activity;
    MainActivity mainActivity;

    public ProductListAdapter(Activity activity,
                              ArrayList<ProductModel> productModelArrayList,
                              MainActivity mainActivity, CustomItemClickListener customItemClickListener) {
        this.activity = activity;
        this.productModelArrayList = productModelArrayList;
        this.mainActivity = mainActivity;
        this.customItemClickListener = customItemClickListener;
    }

    @Override
    public ProductListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_design,parent,false);
        final ProductListViewHolder productListViewHolder = new ProductListViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customItemClickListener.onItemClick(v,productListViewHolder.getPosition());
            }
        });
        return productListViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductListViewHolder holder, final int position) {
        holder.ProductName.setText(productModelArrayList.get(position).getProductName());
        holder.ProductPrice.setText(productModelArrayList.get(position).getProductPrice()+" $");
        holder.productQuantity.setText(productModelArrayList.get(position).getProductQuantity());

        byte[] decodeString = Base64.decode(productModelArrayList.get(position).getProductImage(), Base64.DEFAULT);
        Bitmap decodedByte = null;
        decodedByte = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);

        holder.productImage.setImageBitmap(decodedByte);

        holder.makeSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer productQuantity = Integer.valueOf(productModelArrayList.get(position).getProductQuantity());
                if(productQuantity != 0){
                    productQuantity = productQuantity - 1;

                    MainDataBase mainDataBase = new MainDataBase(activity);
                    mainDataBase.open();
                    mainDataBase.updateProductQuantity(productModelArrayList.get(position).getId(),
                            String.valueOf(productQuantity));
                    mainDataBase.close();

                    mainActivity.UpdateProductQuantity();

                }else {
                    Toast.makeText(activity,"You dont have enough quantity to make a sale", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productModelArrayList.size();
    }
}
