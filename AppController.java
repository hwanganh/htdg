import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.io.*;


public class AppController {
    // Save data
    private void addProductToDatabase(){
        // Câu lệnh SQL: Chèn dữ liệu vào 4 cột tương ứng
        String sql = "INSERT INTO products(name, price, discription) VALUES(?,?,?) ";
        try ()
    }
    private void loadData(){
        File file = new File("data.txt");
        if(!file.exists())
        {
            return;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split("\\|");
                String name = parts[0];
                Double price = Double.parseDouble(parts[1]);
                String description = parts[2];

                Product p = new Product(name, price, description);
                productList.add(p);
            }
        }
        catch(IOException e)
        {
            System.out.println("Error: loadData");
        }
    }
    // 1. Kết nối với fx:id="table" trong scene builder
    @FXML
    private TableView<Product> table;
    @FXML
    private ListView<String> historyList;

    //2. Kết nối với fx:id="namCol" và fx:id="priceCol"
    @FXML
    private TableColumn<Product, String> nameCol;
    @FXML
    private TableColumn<Product, Double> priceCol;
    @FXML
    private TableColumn<Product, String> descrip;

    //Kết nối vói txtName và txtPrice
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField des;
    @FXML
    private Label label;
    @FXML
    private TextField txtBidStep;
    @FXML
    private TextField txtSearch;
    @FXML
    private Label nameProduct;

    //Danh sách lưu trữ sản phẩm ( tự động cập nhật lên giao diện)
    private ObservableList<Product> productList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        // Thiết lập các cột biết lấy dữ liệu từ thuộc tính nào của Product
        //"name" tương ứng với getName() trong Product.java
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        //"price" tương ứng với getPrice trong Product.java
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        //"description" tương tác với geDescription trong Product.java
        descrip.setCellValueFactory(new PropertyValueFactory<>("description"));
        //Create Filter
        FilteredList<Product> listData = new FilteredList<>(productList, p -> true);
        //listen change in search box
        txtSearch.textProperty().addListener((observable,oldValue,newValue)->
        {
            listData.setPredicate(product ->
            {
               if( newValue == null)
                   return true;
               String lowercasefilter = newValue.toLowerCase();
               return product.getName().toLowerCase().contains(lowercasefilter);
            });
        });
        // Gán danh sách đã lọc vào bảng thay vì productList
        table.setItems(listData);
        table.refresh();
        loadData();
    }
    //3 Hàm chạy khi bấm Button ( Khớp với OnAction : handleDauGia)
    @FXML
    private void handleDauGia()
    {
        try
        {
            String name = txtName.getText();
            double price = Double.parseDouble(txtPrice.getText());
            String de = des.getText();
            if(name.isEmpty())
            {
                label.setText("Vui lòng nhập tên đăng nhập");
                label.setTextFill(Color.RED);
            } else if (price <= 0.0) {
                label.setText("Mức giá không hợp lệ.");
            } else
            {
                productList.add(new Product(name, price, de));
                label.setText("Đã thêm sản phẩm mới vào danh sách.");
                label.setTextFill(Color.GREEN);
                txtName.clear();
                txtPrice.clear();
                des.clear();
            }
        }
        catch(NumberFormatException e)
        {
            label.setText("Vui lòng nhập dữ liệu hợp lệ.");
            label.setTextFill(Color.RED);
        }
    }
    // Tạo filteredList từ danh sách gốc.

    // Hàm xử lý tìm kiếm sản phẩm
    @FXML
    private void handleBid()
    {
        // Lấy sản phẩm đang được user bôi chọn trên bảng sản phẩm
        Product selectedProduct = table.getSelectionModel().getSelectedItem();

        if(selectedProduct != null)
        {
            // Tăng giá thêm 100 và tăng lượt đánh giá thêm 1
            double currentPrice = selectedProduct.getPrice();
            try{
                double bidStep = Double.parseDouble(txtBidStep.getText());
                if(bidStep <= 0)
                {
                    label.setText("Mức trả giá không hợp lệ.");
                    label.setTextFill(Color.RED);
                    txtBidStep.clear();
                }
                else {
                    selectedProduct.setPrice(currentPrice + bidStep);
                    table.refresh();
                    label.setText("Đã trả giá cho sản phẩm: "+selectedProduct.getName()+" thêm "+bidStep);
                    label.setTextFill(Color.GREEN);
                    selectedProduct.addHistory(" Người "+selectedProduct.getName()+" trả giá "+selectedProduct.getPrice());
                    saveData();
                    return;
                }
            }
            catch(NumberFormatException e)
            {
                label.setText("Mức trả giá không hợp lệ.");
                label.setTextFill(Color.RED);
                txtBidStep.clear();
            }
            //Làm mới bảng để hiển thị giá mới

        }else{
            label.setText("Vui lòng chọn sản phẩm để đấu giá.");
            label.setTextFill(Color.RED);
        }
    }
    @FXML
    private void handleHistory()
    {
        Product selectionProduct = table.getSelectionModel().getSelectedItem();
        if (selectionProduct == null)
        {
            label.setText("Vui lòng chọn sản phẩm muốn xem lịch sử.");
            label.setTextFill(Color.RED);
        }
        else {
            nameProduct.setText("Sản phẩm: "+selectionProduct.getName());
            //Kết nối listview với danh sách lịch sử;
            historyList.setItems(selectionProduct.getHistory());
        }
    }
}