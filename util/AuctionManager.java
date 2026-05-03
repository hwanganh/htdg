package util;
import entity.Item;
import java.util.ArrayList;
import java.util.List;

public class AuctionManager {
    private static AuctionManager instance;
    
    private List<Item> tempdb;

    private AuctionManager() {
        tempdb = new ArrayList<>();
        System.out.println("Hệ thống đấu giá đã được khởi động!");
    }

    public static AuctionManager getInstance() {
        if (instance == null) {
            instance = new AuctionManager();
        }
        return instance; // Những lần sau gọi sẽ trả về cái đã tạo
    }
    
    public void addItemToDatabase(Item item) {
        tempdb.add(item);
        System.out.println("Đã lưu vào kho: " + item.getName());
    }

    public void showAllItems() {
        System.out.println("--- DANH SÁCH SẢN PHẨM ĐANG ĐẤU GIÁ ---");
        for (Item item : tempdb) {
            System.out.println(item.getDetails());
        }
    }
}