package util;
import entity.*;

public class ItemFactory {
    public static Item createItem(String type, String id, String name, double price, String extraInfo) {
        if (type == null) {
            return null;
        }
        
        switch (type.toLowerCase()) {
            case "art":
                return new Art(id, name, price, extraInfo); 
            case "electronics":
                int warranty = Integer.parseInt(extraInfo);
                return new Electronics(id, name, price, warranty);
            case "vehicle":
                int mnfyear = Integer.parseInt(extraInfo);
                return new Vehicle(id, name, price, mnfyear);
            default:
                throw new IllegalArgumentException("Loại sản phẩm không hợp lệ: " + type);
        }
    }
}