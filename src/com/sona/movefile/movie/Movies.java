package com.sona.movefile.movie;

import com.sona.movefile.fileiorepository.Repository;

import java.io.Serializable;
import java.util.Date;

public class Movies implements Serializable {

    private static final long serialVersionUID = 4L;
    public static Repository<Integer, Movies> repository = new Repository("movies.txt");
    private static int counter = Math.toIntExact(repository.getObjectCounts());
    int id;
    String title, description;
    double rating, sumRates;
    int ratersCount;
    Date premierDate;
    GanreType ganre;
    int[] actorsID, directorsID, writersID;

    public Movies() {

    }

    public Movies(String title, String description, Date premierDate, GanreType ganre, int[] actorsID, int[] directorsID, int[] writersID) {
        this.title = title;
        this.description = description;
        this.premierDate = premierDate;
        this.ganre = ganre;
        this.actorsID = actorsID;
        this.directorsID = directorsID;
        this.writersID = writersID;
        counter++;
    }

    public boolean addMovie(Movies movie) {

        try {
            repository.writeInFile(counter, movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Movies searchMovieByTitle(String title) {

        Movies movie = null;
        Movies nextMovie = null;
        for (int i = 1; i <= repository.getObjectCounts(); i++) {
            nextMovie = repository.readFromFile(i);
            if (nextMovie.title.equals(title))
                movie = nextMovie;
        }
        return movie;
    }

    public Movies[] searchMovieBetweenDate(Date firstDate, Date lastDate) {

        Movies nextMovie;
        int j = 0;
        for (int i = 1; i <= repository.getObjectCounts(); i++) {
            nextMovie = repository.readFromFile(i);
            if (nextMovie.premierDate.compareTo(firstDate) != -1 && nextMovie.premierDate.compareTo(lastDate) == -1) {
                j++;
            }
        }
        Movies[] movies = new Movies[j];
        j = 0;
        for (int i = 1; i <= repository.getObjectCounts(); i++) {
            nextMovie = repository.readFromFile(i);
            if (nextMovie.premierDate.compareTo(firstDate) != -1 && nextMovie.premierDate.compareTo(lastDate) == -1) {
                movies[j] = nextMovie;
                j++;
            }
        }
        return movies;


    }

    public String printMovie(Movies movie) {
        String mov = movie.title + " " + movie.description + " " + ganreTypePrint(movie.ganre) + " " + " " + movie.premierDate.toString() + " " + movie.rating;
        return mov;
    }

    private static String ganreTypePrint(GanreType ganreType) {
        String ganre = null;
        switch (ganreType) {
            case DRAMA:
                ganre = "Drama";
                break;
            case ACTION:
                ganre = "Action";
                break;
            case COMEDY:
                ganre = "Comedy";
                break;
            case FANTASY:
                ganre = "Fantasy";
                break;
            case HISTORICAL:
                ganre = "Historical";
                break;
            default:
                break;
        }
        return ganre;
    }
}

