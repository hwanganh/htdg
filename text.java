import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class text{
    //1.
    @FXML
    private TableView<Product> table;

    //2.
    @FXML
    private TableColumn<Product, String> nameCol;

    private ObservableList<Product> productList = FXCollections.observableArrayList();
}