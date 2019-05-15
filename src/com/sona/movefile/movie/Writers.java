package com.sona.movefile.movie;

import com.sona.movefile.fileiorepository.Repository;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Writers extends PeopleWorkedForFilm implements Serializable {

    private static final long serialVersionUID = 1L;
    public static Repository<Integer, Writers> repository = new Repository("writers.txt");
    private static int counter= Math.toIntExact(repository.getObjectCounts());

    public Writers(){

    }
    public Writers(String name, String surname, String nationality, Date dateOfBirth) {
        super( name, surname, nationality, dateOfBirth);
        counter++;
    }

    public boolean addWriter(Writers writer) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            repository.writeInFile(counter, writer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public  Writers searchWritersByID(int id) {
        return repository.readFromFile(id);
    }
}

