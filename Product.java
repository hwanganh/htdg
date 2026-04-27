import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product
{
    private String name, description; // tên và mô tả sản phẩm
    private double price; // giá sản phẩm
    private ObservableList<String> history = FXCollections.observableArrayList(); // Lưu dữ liệu như " Người A trả X".
    public Product(String name, double price, String description)
    {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //Hàm lấy tên sản phẩm
    public String getName()
    {
        return name;
    }

    //Hàm lấy giá sản phẩm
    public double getPrice()
    {
        return price;
    }

    //hàm lấy mô tả sản phẩm
    public String getDescription()
    {
        return description;
    }

    //hàm thiết lập giá cho sản phẩm
    public void setPrice(double price)
    {
        this.price = price;
    }

    // Hàm thêm lịch sử
    public void addHistory(String entry)
    {
        history.add(entry);
    }

    // Hàm lấy lịch sử
    public ObservableList<String> getHistory()
    {
        return history;
    }
}
