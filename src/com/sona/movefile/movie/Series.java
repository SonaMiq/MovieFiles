package com.sona.movefile.movie;

import com.sona.movefile.fileiorepository.Repository;

import java.io.Serializable;
import java.util.Date;

public class Series extends Movies implements Serializable {

    private static final long serialVersionUID = 5L;
    public static Repository<Integer, Series> repository = new Repository("series.txt");
    private static int counter = Math.toIntExact(repository.getObjectCounts());
    public int seasons;
    public int movieId;

    public Series() {

    }

    public Series(String title, String description, Date premierDate, GanreType ganre, int[] actorsID, int[] directorsID, int[] writersID, int seasons, int movieId) {
        super(title, description, premierDate, ganre, actorsID, directorsID, writersID);
        this.movieId = movieId;
        this.seasons = seasons;
        counter++;
    }

    public boolean addSeries(Series series) {

        try {
            repository.writeInFile(counter, series);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Series searchMovieByTitle(String title) {

    Series serie = null;
        Series nextSerie = null;
        for (int i = 1; i <= repository.getObjectCounts(); i++) {
            nextSerie = repository.readFromFile(i);
            if (nextSerie.title.equals(title))
                serie = nextSerie;
        }
        return serie;
    }
}
