package com.example.githubapp.ui.adapter;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.githubapp.R;
import com.example.githubapp.data.model.UserGithub;
import com.example.githubapp.ui.detail.DetailActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserGridAdapter extends RecyclerView.Adapter<UserGridAdapter.ViewHolder> {
    private final List<UserGithub> githubList = new ArrayList<>();

    public void setData(List<UserGithub> githubList) {
        this.githubList.clear();
        this.githubList.addAll(githubList);
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_grid, parent, false);
        return new UserGridAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.bind(githubList.get(position));
    }

    @Override
    public int getItemCount() {
        return githubList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivAvatar;
        private final TextView tvUsername;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvUsername = itemView.findViewById(R.id.tv_username);
        }

        public void bind(UserGithub github) {
            Glide.with(itemView.getContext())
                    .load(github.getAvatar())
                    .centerCrop()
                    .into(ivAvatar);

            tvUsername.setText(github.getUsername());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA_PARCEL, github);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
