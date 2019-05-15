package com.sona.movefile.user;

import com.sona.movefile.fileiorepository.Repository;
import com.sona.movefile.movie.Movies;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 2L;
    public static Repository<Integer, User> repository = new Repository("users.txt");
    private static int counter = Math.toIntExact(repository.getObjectCounts());
    String password, username;

    public User(){

    }
    public User(String username, String password) {
        this.password = password;
        this.username = username;
        counter++;
    }

    public boolean addUser(User user) {
        try {
            repository.writeInFile(counter, user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean userRegister(User user) {
        User nextUser;
        for (int i = 1; i <= repository.getObjectCounts(); i++) {
            nextUser = repository.readFromFile(i);
            if (nextUser.username.equals(user.username))
                return false;
        }
        repository.writeInFile(counter, user);
        return true;

    }

    public boolean userLogin(User user) {
        User nextUser;
        for (int i = 1; i <= repository.getObjectCounts(); i++) {
            nextUser = repository.readFromFile(i);
            if (nextUser.username.equals(user.username))
                if (nextUser.password.equals(user.password))
                    return true;
        }
        return false;
    }
    public Movies[] searchMovieBetweenDate(String date1,String date2){
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        Movies movies=new Movies();
        Movies[] moviesResult=null;
        try {
           moviesResult=movies.searchMovieBetweenDate(format.parse(date1), format.parse(date2));
        }
        catch (Exception ex){

        }
       return moviesResult;
    }
}
