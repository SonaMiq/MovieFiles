package com.sona.movefile.movie;

import com.sona.movefile.fileiorepository.Repository;

import java.io.Serializable;
import java.util.Date;

public class Actors extends PeopleWorkedForFilm implements Serializable {

    private static final long serialVersionUID = 2L;
    public static Repository<Integer, Actors> repository = new Repository("actors.txt");
    private static int counter = Math.toIntExact(repository.getObjectCounts());

    public Actors() {

    }

    public Actors(String name, String surname, String nationality, Date dateOfBirth) {
        super(name, surname, nationality, dateOfBirth);
        counter++;
    }

    public boolean addActor(Actors actor) {
        try {
            repository.writeInFile(counter, actor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Actors searchActorByID(int id) {

        return repository.readFromFile(id);
    }
}


