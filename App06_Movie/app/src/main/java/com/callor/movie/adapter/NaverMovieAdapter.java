package com.callor.movie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movie.databinding.MovieItemViewBinding;
import com.callor.movie.model.MovieDTO;

import java.util.List;

public class NaverMovieAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // 리스트를 보이기 위한 데이터
    private List<MovieDTO> movieList;
    // 생성자 만들어줌
    public NaverMovieAdapter(List<MovieDTO> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater
                = LayoutInflater.from(parent.getContext());

        MovieItemViewBinding movieBinding
                = MovieItemViewBinding
                .inflate(layoutInflater,
                        parent,
                        false);
        return new NaverMovieViewHolder(movieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NaverMovieViewHolder movieViewHolder
                = (NaverMovieViewHolder) holder;
        // 현재 위치에 있는 아이템을 끄집어내서,
        MovieDTO movieDTO = movieList.get(position);
        MovieItemViewBinding binding
                = movieViewHolder.movieBinding;

        binding.movieItemTitle.setText(movieDTO.getTitle());
        binding.movieItemDirect.setText(movieDTO.getDirector());
        binding.movieItemActor.setText(movieDTO.getActor());
    }

    @Override
    public int getItemCount() {
        // 리스트가 없으면 null을 리턴하고 있으면 size를 리턴해라
        return movieList == null ? 0 : movieList.size();
    }


    public static class NaverMovieViewHolder extends RecyclerView.ViewHolder {
        public MovieItemViewBinding movieBinding;
        public NaverMovieViewHolder(@NonNull MovieItemViewBinding movieBinding) {
            super(movieBinding.getRoot());
            this.movieBinding = movieBinding;
        }
    }




}
