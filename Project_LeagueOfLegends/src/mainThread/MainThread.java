package mainThread;

import database.model.ConnectionDb;
import database.seeder.InitSeeder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;

public class MainThread extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        // DB
        ConnectionDb connectionDb = new ConnectionDb();
        connectionDb.ConnectionDbMysql();
        // Seeder
        InitSeeder seeder = new InitSeeder();
        seeder.initializableSeeder();

        Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("src\\asset_public\\css\\application.css").toExternalForm());
//        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Montserrat&subset=vietnamese");
        stage.setScene(scene);

        // Ẩn thanh công cụ mặc định của app (cái nút thu nhỏ, tắt chương trình).
        stage.initStyle(StageStyle.UNDECORATED);

        // Thêm icon cho app
        stage.getIcons().add(new Image(new FileInputStream("src\\asset_public\\image\\icon_application.png")));

        // Cho phép thay đổi kích thước
        stage.setResizable(true);


        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}