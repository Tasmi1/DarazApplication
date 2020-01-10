package com.example.darazapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.darazapplication.R;
import com.example.darazapplication.modalClass.Products;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context mContext;
    List<Products> productsList;

    public ProductAdapter(Context mContext, List<Products> productsList)
    {
        this.mContext = mContext;
        this.productsList = productsList;

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flashproduct_layout,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position)
    {
        Products products = productsList.get(position);
        holder.tvname.setText(products.getName());
        holder.tvprice.setText(products.getPrice());

    }

    @Override
    public int getItemCount(){return productsList.size();}




    public class ProductViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgname;
        TextView tvname, tvprice;

        public ProductViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgname = itemView.findViewById(R.id.img_flash);
            tvname = itemView.findViewById(R.id.txtSold);
            tvprice = itemView.findViewById(R.id.txtAmount);

        }


    }
}
