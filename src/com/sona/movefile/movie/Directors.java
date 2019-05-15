package com.sona.movefile.movie;

import com.sona.movefile.fileiorepository.Repository;

import java.io.Serializable;
import java.util.Date;

public class Directors extends PeopleWorkedForFilm implements Serializable {

    private static final long serialVersionUID = 3L;
    public static Repository<Integer, Directors> repository = new Repository("directors.txt");
    private static int counter = Math.toIntExact(repository.getObjectCounts());

    public Directors() {

    }

    public Directors(String name, String surname, String nationality, Date dateOfBirth) {
        super(name, surname, nationality, dateOfBirth);
        counter++;
    }

    public boolean addDirector(Directors director) {
        try {
            repository.writeInFile(counter, director);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Directors searchDirectorByID(int id) {
        return repository.readFromFile(id);
    }
}
