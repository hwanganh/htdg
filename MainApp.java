import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application
{
    public void start(Stage stage) throws Exception
    {
        //1. Nạp file giao diện từ FXML
        Parent root = FXMLLoader.load(getClass().getResource("text.fxml"));

        //2. Tạo một cảnh chứa( Scene) chưa giao diện đó.
        Scene scene = new Scene(root);

        //3. Thiết lập của sổ hiển thị.
        stage.setTitle("Ứng dụng Bidding - Kết nối Scene Builder");
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
