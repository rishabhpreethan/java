import java.util.*;
class Shop{
    private String name;
    private int nsold; 
    public Shop(String s, int ns){
	this.name = s;
	this.nsold = ns;
    }
    public String getName(){
	return name;
    }
    public int getItemSold(){
	return nsold;
    }
} 
public class MapTest {
	public static void printShopName(ArrayList<Shop> sList) {
	    Map<String, Integer> m = new LinkedHashMap<String, Integer>();
	    String shop = "";
	    int sold = 0;
// iterate through sList and add each shop object to map "m"
        for (Shop s : sList) {
            String shopName = s.getName();
            int currentSold = s.getItemSold();

            if (m.containsKey(shopName)) {
                int previousSold = m.get(shopName);
                m.put(shopName, previousSold + currentSold);
            } 
            else {
                m.put(shopName, currentSold);
            }
        }
        
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            if (entry.getValue() > sold){
                sold = entry.getValue();
                shop = entry.getKey();
            }
        }
        System.out.println(shop+" : "+sold);
    }
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	ArrayList<Shop> list = new ArrayList<Shop>();
	for (int i = 0; i < 4; i++) {
		list.add(new Shop(sc.next(), sc.nextInt()));
	}
	printShopName(list);
    }
}