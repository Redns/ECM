package sample;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class Set implements Initializable {
    public String old_path;
    public String new_path;
    public TextField path;
    public CheckBox limit;

    public void initialize(URL location, ResourceBundle resources) {
        path.setText(Main.path);
        path.setEditable(false);
    }

    public void Change_path() throws IOException {
        Stage stage = new Stage();
        DirectoryChooser directoryChooser = new DirectoryChooser();

        /**弹出路径选择窗口(Data\\)*/
        File file = directoryChooser.showDialog(stage);
        new_path = file.getPath();
        new_path = this.winToJava(new_path) + "\\\\Data\\\\";

        File file_new_Data = new File(new_path);
        if(!file_new_Data.exists()){
            file_new_Data.mkdir();
        }

        System.out.println("[选择的数据存储路径]" + new_path);
        stage.show();

        /**若新路径不为空，则进行处理*/
        if (new_path != "\\\\Data\\\\") {

            /**读取旧的路径*/
            old_path = Main.path;

            /**更新Main.path*/
            Main.path = new_path;

            /**写入新的路径*/
            File f = new File("location.cfg");
            FileWriter fw = new FileWriter(f);

            fw.write("");

            /**写入新路径*/
            fw.write(new_path);
            fw.flush();
            fw.close();

            /**将旧文件复制到新的存储位置*/
            Copy(old_path, new_path, limit.isSelected());
            path.setText(Main.path);
        }

        stage.close();
    }


    /*
    * @winToJava 将windows路径转换为Java可用的绝对路径
    * @para win_path windows下的路径
    * @return Java可识别的路径
    * */
    public static String winToJava(String win_path){
        win_path = win_path.replace("\\", "\\ ");
        win_path = win_path.replace(" ", "\\");

        return win_path;
    }

    /**
    * @Copy 复制文件
    * @param old_path 旧的文件所在地址
    * @param new_path 新的文件所在地址
    * @return 成功返回true，失败返回false
    * */
    private boolean Copy(String old_path, String new_path, boolean isDel) throws IOException {
        System.out.println("[开始迁移文件...]");

        /**查找旧路径下的所有文件夹*/
        HashMap<String, Object> old = Search_Files.getFilesName(old_path, null);
        List<String> old_folders = (List<String>) old.get("folderNameList");

        /**遍历旧的目录，复制到新的目录*/
        for(String old_folder_path : old_folders){
            HashMap<String, Object> hm = Search_Files.getFilesName(old_path + old_folder_path + "\\\\", null);
            List<String> old_files = (List<String>) hm.get("fileNameList");

            /**若新文件夹不存在则创建*/
            File file = new File(new_path + old_folder_path + "\\\\");
            if(!file.exists()){
                file.mkdir();
            }

            byte[] data = new byte[100];
            int len;

            for(String old_file : old_files){
                System.out.println("[正在迁移文件]" + old_path + old_folder_path + "\\\\" + old_file);
                File file_old = new File(old_path + old_folder_path + "\\\\" + old_file);
                File file_new = new File(new_path + old_folder_path + "\\\\" + old_file);

                if(!file_new.exists()){
                    file_new.createNewFile();
                }

                InputStream is = new FileInputStream(file_old);
                OutputStream os = new FileOutputStream(file_new);

                while ((len = is.read(data)) > 0){
                    os.write(data,0, len);
                }

                is.close();
                os.close();
            }
        }

        if(isDel){
            /**删除旧的Data文件夹*/
            File del = new File(old_path);
            boolean r = deleteFile(del);

            if(r){
                System.out.println("[迁移成功!]]");
            }

            else {
                System.out.println("[迁移失败!]");
            }

            return r;
        }

        System.out.println("[迁移成功!]");
        return true;
    }

    /**
     * 先根遍历序递归删除文件夹
     *
     * @param dirFile 要被删除的文件或者目录
     * @return 删除成功返回true, 否则返回false
     */
    public static boolean deleteFile(File dirFile) {
        // 如果dir对应的文件不存在，则退出
        if (!dirFile.exists()) {
            return false;
        }

        if (dirFile.isFile()) {
            return dirFile.delete();
        } else {

            for (File file : dirFile.listFiles()) {
                deleteFile(file);
            }
        }

        return dirFile.delete();
    }
}