package com.example.boostan.Search;

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

import java.util.ArrayList;
import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.SearchViewHolder> {
    Context context;
    List<Products> products;
    SearchOnClickView searchOnClickView;

    public AdapterSearch(Context context,SearchOnClickView searchOnClickView) {
        this.context = context;
        products = new ArrayList<>();
        this.searchOnClickView = searchOnClickView;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recyclear_list,parent,false);
        return new SearchViewHolder(view);
    }

    public void onBind(List<Products>products){
        this.products.clear();
        this.products.addAll(products);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Products product=products.get(position);
        Picasso.get().load(product.getImage()).into(holder.imgIcon);
        holder.txtTitle.setText(product.getName());
        holder.txtIntroduction.setText(product.getIntroduction());
        holder.crvParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchOnClickView.onClickView(product.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon,imgLike,imgDisLike;
        TextView txtTitle,txtIntroduction;
        CardView crvParent;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon=itemView.findViewById(R.id.img_itemRecycler_icon);
            imgLike=itemView.findViewById(R.id.img_itemRecycler_like);
            imgDisLike=itemView.findViewById(R.id.img_itemRecycler_disLike);
            txtTitle=itemView.findViewById(R.id.txt_itemRecycler_title);
            txtIntroduction=itemView.findViewById(R.id.txt_itemRecycler_introduction);
            crvParent=itemView.findViewById(R.id.crv_itemRecycler_parent);


        }
    }
    public interface SearchOnClickView{
        void onClickView(String id);
    }
}
