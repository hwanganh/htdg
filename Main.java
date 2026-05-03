import util.ItemFactory;
import util.AuctionManager;
import entity.Item;

public class Main {
    public static void main(String[] args) {
        Item item1 = ItemFactory.createItem("art", "A01", "Bức tranh Nàng Mona Lisa", 5000, "Leonardo da Vinci");
        Item item2 = ItemFactory.createItem("electronics", "E01", "iPhone 15 Pro Max", 1200, "12");

        AuctionManager manager = AuctionManager.getInstance();
    
    
        manager.addItemToDatabase(item1);
        manager.addItemToDatabase(item2);

        manager.showAllItems();
    }
}