package com.sona.movefile.movie;

import com.sona.movefile.fileiorepository.Repository;

import java.io.Serializable;
import java.util.Date;

public class PeopleWorkedForFilm implements Serializable{

    String name;
    String surname;
    String nationality;
    Date dateOfBirth;

    PeopleWorkedForFilm(){

    }
    PeopleWorkedForFilm(String name, String surname, String nationality, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
    }


    public String print(PeopleWorkedForFilm peopleWorkedForFilm) {
        String pwf = peopleWorkedForFilm.name + " " + peopleWorkedForFilm.surname + " " + peopleWorkedForFilm.nationality + " " + " " + peopleWorkedForFilm.dateOfBirth.toString();
        return pwf;
    }
}

