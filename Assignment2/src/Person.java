import java.util.ArrayList;
import java.util.List;
public class Person {
    private String name;
    private List<Watch> watchList;

    public Person(){
        watchList = new ArrayList<Watch>();
    }

    public void addWatch(Watch watch){
        watchList.add(watch);
    }

    public List<Movie> getMovie(){
    List<Movie> movies = new ArrayList<>();
    for(Watch watch : watchList){
        movies.add(watch.getMovie());
    }
    return movies;
    }
}
