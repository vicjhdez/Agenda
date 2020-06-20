package com.example.hernandez_victor_agenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder>implements View.OnClickListener{

    private List<ModelClass>modelClassList;
    private View.OnClickListener listener;

    public Adapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);


        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int resource = modelClassList.get(position).getImageIcon();
        String title = modelClassList.get(position).getTitle();
        String body = modelClassList.get(position).getBody();
        viewHolder.setData(resource, title, body);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!= null) {
            listener.onClick(view);
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;
        private TextView body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textTitle);
            body = itemView.findViewById(R.id.textBody);
        }
        private  void setData(int imageResource, String titleText, String bodyText){
            imageView.setImageResource(imageResource);
            title.setText(titleText);
            body.setText(bodyText);
        }

    }

}
