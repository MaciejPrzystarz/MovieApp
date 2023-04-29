package db;

import exception.DuplicateException;
import model.Actor;
import model.Movie;
import model.TvSeries;

public class ApplicationDatabase {
    private final Movie[] movies = new Movie[5];
    private int numberOfMovies = 0;
    private final TvSeries[] tvSeries = new TvSeries[5];
    private int numberOfTvSeries = 0;
    private final Actor[] actors = new Actor[5];
    private int numberOfActors = 0;

    public Movie[] getMovies() {
        Movie[] withoutNulls = new Movie[numberOfMovies];
        System.arraycopy(movies, 0, withoutNulls, 0, numberOfMovies);
        return withoutNulls;
    }

    public TvSeries[] getTvSeries() {
        TvSeries[] withoutNulls = new TvSeries[numberOfTvSeries];
        System.arraycopy(tvSeries, 0, withoutNulls, 0, numberOfTvSeries);
        return withoutNulls;
    }

    public Actor[] getActors() {
        Actor[] withoutNulls = new Actor[numberOfActors];
        System.arraycopy(actors, 0, withoutNulls, 0, numberOfActors);
        return withoutNulls;
    }

    public void addActor(Actor actor) {
        for (Actor actorsFromArray : actors) {
            if (actor.equals(actorsFromArray)) {
                throw new DuplicateException("Actor cannot be duplicated.");
            }
        }
        if (actor != null) {
            actors[numberOfActors] = actor;
            numberOfActors++;
        }
    }

    public void addTvSeries(TvSeries tvSeries) {
        for (TvSeries seriesFromArray : getTvSeries()) {
            if (tvSeries.equals(seriesFromArray)) {
                throw new DuplicateException("TV Series cannot be duplicated.");
            }
        }
        if (tvSeries != null) {
            this.tvSeries[numberOfTvSeries] = tvSeries;
            numberOfTvSeries++;
        }
    }

    public void addMovie(Movie movie) {
        for (Movie movieFromArray : getMovies()) {
            if (movieFromArray.equals(movie)) {
                throw new DuplicateException("Movie cannot be duplicated.");
            }
        }
        if (movie != null) {
            movies[numberOfMovies] = movie;
            numberOfMovies++;
        }
    }
}