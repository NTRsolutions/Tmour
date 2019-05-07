package com.sismatix.tmour.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import com.sismatix.tmour.Fregment.Strore_info_freg;
import com.sismatix.tmour.Model.Store_image_model;
import com.sismatix.tmour.R;


public class Store_image_adapter extends RecyclerView.Adapter<Store_image_adapter.MyViewHolder> {

        private List<Store_image_model> model;
        private Context context;
        LayoutInflater inflater;
        public static String name, image;
        int selectedposition = 0;
        int pageno = 1;
        private int selectedItem;




        public Store_image_adapter(Context context, List<Store_image_model> model) {
            this.context = context;
            this.model = model;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public Store_image_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.store_image_row, parent, false);
            return new Store_image_adapter.MyViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {

            final Store_image_model store_model = model.get(position);
            holder.lv_store_image_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Fragment myFragment = new Strore_info_freg();
                    // myFragment.setArguments(b);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fram_layout, myFragment).addToBackStack(null).commit();

                }
            });




        }

        @Override
        public int getItemCount() {
            return model.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public ImageView iv_store_image;
            LinearLayout lv_store_image_click;


            public MyViewHolder(View itemView) {
                super(itemView);


                iv_store_image = (ImageView) itemView.findViewById(R.id.iv_store_image);
                lv_store_image_click = (LinearLayout) itemView.findViewById(R.id.lv_store_image_click);


            }
        }
    }






