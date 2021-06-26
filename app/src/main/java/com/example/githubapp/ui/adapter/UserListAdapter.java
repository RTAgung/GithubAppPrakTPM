package com.example.githubapp.ui.adapter;

import android.content.Intent;
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
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ListViewHolder> {

    private final List<UserGithub> githubList = new ArrayList<>();

    public void setData(List<UserGithub> githubList) {
        this.githubList.clear();
        this.githubList.addAll(githubList);
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListViewHolder holder, int position) {
        holder.bind(githubList.get(position));
    }

    @Override
    public int getItemCount() {
        return githubList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivProfile;
        private final TextView tvUsername;

        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.iv_profil);
            tvUsername = itemView.findViewById(R.id.tv_username);
        }

        public void bind(UserGithub github) {
            Glide.with(itemView.getContext())
                    .load(github.getAvatar())
                    .centerCrop()
                    .into(ivProfile);

            tvUsername.setText(github.getUsername());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA_PARCEL, github);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
