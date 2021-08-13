package com.callor.oneday_movie.service;

import com.callor.oneday_movie.model.NaverMovieDTO;

public interface NaverMovieService {

    public NaverMovieDTO getMovies(String search);
}
