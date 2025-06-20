import java.util.ArrayList;
import java.util.List;
public class Movie {
    private String name;
    private String genre;

    private List<Watch> watchList;

    public Movie(){
        watchList = new ArrayList<Watch>();
    }

    public void addWatch(Watch watch){
        watchList.add(watch);
    }

    public List<Person> getPersons(){
        List<Person> persons = new ArrayList<>();
        for(Watch watch : watchList){
            persons.add(watch.getPerson());
        }
        return persons;

    }

}
