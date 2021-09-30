
import java.util.ArrayList;
import com.myproject.beans.Hunter;
import com.myproject.services.HunterService;
/**
 *
 * @author Amman Nega
 */
public class HunterDemo {
    private static HunterService dao = new HunterService();
    
    public static void main(String[] args) {
        System.out.println("Listing all Hunters:");
        ArrayList<Hunter> hunters = dao.findAll();
        displayAll(hunters);
    }
    
    private static void displayAll(ArrayList<Hunter> hunters) {
        for(Hunter hunter: hunters) {
            System.out.println(hunter);
        }
    }
}
