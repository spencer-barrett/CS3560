import java.util.ArrayList;
import java.util.List;
public class Team {
    private int code;
    private List<Player> players;

    public Team(){
        players = new ArrayList<Player>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }
}
