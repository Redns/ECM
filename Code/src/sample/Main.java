package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main extends Application {
    public static String path;

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene menu = new Scene(root);

            primaryStage.setScene(menu);
            primaryStage.setTitle("ECM");
            primaryStage.getIcons().add(new Image("/icon/ECM.png"));


            /**读取location.txt获取Data所在绝对路径:包含\\*/
            File f = new File("location.cfg");

            InputStream is = new FileInputStream(f);
            byte[] path_bytes = new byte[100];

            int len = is.read(path_bytes);
            path = new String(path_bytes, 0, len);

            is.close();

            /**初始时location.txt内容为0*/
            if(path.equals("0")){
                /**设置路径为默认路径*/
                OutputStream os = new FileOutputStream(f);

                path = f.getAbsolutePath().replace("location.cfg", "");
                path = Set.winToJava(path) + "Data\\\\";

                os.write(path.getBytes(StandardCharsets.UTF_8));
                os.close();
            }

            System.out.println("[数据存储路径]" + path);

            primaryStage.show();
    }
}