import java.util.ArrayList;
import java.util.List;
public class Dog {
    private String breed;
    private String name;
    private List<Paw> paws;

    public Dog(){
        paws = new ArrayList<Paw>();
    }
}
