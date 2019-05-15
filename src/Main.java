import com.sona.movefile.movie.*;
import com.sona.movefile.user.User;

import java.text.SimpleDateFormat;


public class Main {
    public static void main(String[] args) {

        User user=new User();
        Movies movie=new Movies();
        Movies[] movies;
    movies= user.searchMovieBetweenDate("01/01/2011","01/01/2015");//dd/MM/yyyy
        if(movies==null)
            System.out.println("Movies not found");
        else
            for (Movies mov:movies) {
                System.out.println(movie.printMovie(mov));
            }
    }
}
