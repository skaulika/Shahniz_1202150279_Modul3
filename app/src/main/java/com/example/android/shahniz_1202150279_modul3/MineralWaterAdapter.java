package com.example.android.shahniz_1202150279_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Shahniz on 25/02/2018.
 */

public class MineralWaterAdapter extends RecyclerView.Adapter<MineralWaterAdapter.ViewHolder> {
    //Member variables
    private ArrayList<MineralWater> mMineralData;
    private Context mContext;

    /**
     * Constructor that passes in the mineral data and the context
     * @param mineralData ArrayList containing the mineral data
     * @param context Context of the application
     */
    MineralWaterAdapter(Context context, ArrayList<MineralWater> mineralData) {
        this.mMineralData = mineralData;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly create ViewHolder.
     */
    @Override
    public MineralWaterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(MineralWaterAdapter.ViewHolder holder, int position) {
        //Get current mineral
        MineralWater currentMineral = mMineralData.get(position);
        //Populate the textviews with data
        holder.bindTo(currentMineral);

        Glide.with(mContext).load(currentMineral.getImageResource()).into(holder.mMineralImage);
    }


    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mMineralData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mMineralImage;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file
         */
        ViewHolder(View itemView) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mMineralImage = (ImageView) itemView.findViewById(R.id.mineralImage);

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(MineralWater currentMineral){
            //Populate the textviews with data
            mTitleText.setText(currentMineral.getTitle());
            mInfoText.setText(currentMineral.getInfo());

        }

        @Override
        public void onClick(View view) {
            MineralWater currentMineral = mMineralData.get(getAdapterPosition());

            //Set up the detail intent
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentMineral.getTitle());
            detailIntent.putExtra("image_resource", currentMineral.getImageResource());

            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}
