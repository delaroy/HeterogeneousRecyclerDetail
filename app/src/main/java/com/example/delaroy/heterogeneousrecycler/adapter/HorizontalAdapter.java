package com.example.delaroy.heterogeneousrecycler.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.delaroy.heterogeneousrecycler.HorizontalDetailActivity;
import com.example.delaroy.heterogeneousrecycler.R;
import com.example.delaroy.heterogeneousrecycler.pojos.SingleHorizontal;

import java.util.ArrayList;

import static com.example.delaroy.heterogeneousrecycler.HorizontalDetailActivity.EXTRA_DESCRIPTION;
import static com.example.delaroy.heterogeneousrecycler.HorizontalDetailActivity.EXTRA_IMAGES;
import static com.example.delaroy.heterogeneousrecycler.HorizontalDetailActivity.EXTRA_PUBDATE;
import static com.example.delaroy.heterogeneousrecycler.HorizontalDetailActivity.EXTRA_TITLE;


public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    ArrayList<SingleHorizontal> data = new ArrayList<>();
    private Context mContext;

    public HorizontalAdapter(Context mContext, ArrayList<SingleHorizontal> data) {
        this.mContext = mContext;
        this.data = data;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_single_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.description.setText(data.get(position).getDesc());
        holder.title.setText(data.get(position).getTitle());
        holder.pubDate.setText(data.get(position).getPubDate());
        holder.image.setImageResource(data.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, pubDate;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            pubDate = (TextView) itemView.findViewById(R.id.published_date);
            image = (ImageView) itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        SingleHorizontal clickedDataItem = data.get(pos);
                        Intent intent = new Intent(mContext, HorizontalDetailActivity.class);
                        intent.putExtra(EXTRA_TITLE, clickedDataItem.getTitle() );
                        intent.putExtra(EXTRA_DESCRIPTION, clickedDataItem.getDesc() );
                        intent.putExtra(EXTRA_IMAGES, clickedDataItem.getImages() );
                        intent.putExtra(EXTRA_PUBDATE, clickedDataItem.getPubDate() );
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        //Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getOriginalTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
