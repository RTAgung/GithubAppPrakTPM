package com.example.githubapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.githubapp.R;
import com.example.githubapp.data.model.UserReposGithub;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.ViewHolder> {
    private final List<UserReposGithub> reposList = new ArrayList<>();

    public void setData(List<UserReposGithub> githubList) {
        this.reposList.clear();
        this.reposList.addAll(githubList);
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_list, parent, false);
        return new RepoListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.bind(reposList.get(position));
    }

    @Override
    public int getItemCount() {
        return reposList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvLang;
        private final TextView tvUpdate;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.det_nama);
            tvLang = itemView.findViewById(R.id.det_bahasa);
            tvUpdate = itemView.findViewById(R.id.det_update);
        }

        public void bind(UserReposGithub repos) {
            tvName.setText(repos.getName());
            tvLang.setText(repos.getLanguage());
            tvUpdate.setText(repos.getUpdate());
        }
    }
}
