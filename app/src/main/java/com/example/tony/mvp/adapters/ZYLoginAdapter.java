package com.example.tony.mvp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tony on 7/11/16.
 */
public class ZYLoginAdapter extends RecyclerView.Adapter<ZYLoginAdapter.ZYLoginAdapterHolder> {


    @Override
    public ZYLoginAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ZYLoginAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ZYLoginAdapterHolder extends RecyclerView.ViewHolder {

        public ZYLoginAdapterHolder(View itemView) {
            super(itemView);
        }
    }
}
