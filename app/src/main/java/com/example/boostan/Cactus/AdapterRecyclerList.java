package com.example.boostan.Cactus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boostan.Model.Products;
import com.example.boostan.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class AdapterRecyclerList extends RecyclerView.Adapter<AdapterRecyclerList.RecyclerListViewHolder> {
    Context context;
    List<Products> products;
    SetOnClickView setOnClickView;
    View view;

    public AdapterRecyclerList(Context context, List<Products> products, SetOnClickView setOnClickView) {
        this.products = products;
        this.setOnClickView = setOnClickView;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclear_list, parent, false);
        return new RecyclerListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerListViewHolder holder, int position) {
        // Set Data
        Products product = products.get(position);
        holder.id = product.getId();
        Picasso.get().load(product.getImage()).into(holder.imgIcon);
        holder.txtTitle.setText(product.getName());
        holder.txtIntroduction.setText(product.getIntroduction());
        holder.crvParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickView.onClickView(product.getId());
            }
        });

        holder.imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               holder.imgFav.setVisibility(View.GONE);
                holder.imgFavLike.setVisibility(View.VISIBLE);
                  // TODO: 1/10/2021 Favorite
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class RecyclerListViewHolder extends RecyclerView.ViewHolder {
        CardView crvParent;
        ImageView imgIcon, imgFav,imgFavLike;
        TextView txtTitle, txtIntroduction;
        String id;

        public RecyclerListViewHolder(@NonNull View itemView) {
            super(itemView);
            crvParent = itemView.findViewById(R.id.crv_itemRecycler_parent);
            imgIcon = itemView.findViewById(R.id.img_itemRecycler_icon);
            imgFav = itemView.findViewById(R.id.img_itemRecycler_disLike);
            imgFavLike = itemView.findViewById(R.id.img_itemRecycler_like);
            txtTitle = itemView.findViewById(R.id.txt_itemRecycler_title);
            txtIntroduction = itemView.findViewById(R.id.txt_itemRecycler_introduction);
        }
    }

    public interface SetOnClickView {
        void onClickView(String id);
    }
}
