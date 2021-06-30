package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class Controller_Search implements Initializable {
    public ComboBox<String> species;
    public TextField type;
    public Button Search;
    public TableView<Component> Data_Table;
    public TableColumn col_type;
    public TableColumn col_num;
    public TableColumn col_footprint;
    public TableColumn col_location;

    /*
     * @File_Rename_Flag 用于确定文件命名的格式
     * @0 电阻
     * @1 电容
     * @2 电感
     * @3 变压器
     * @4 继电器
     * @5 IC
     * @6 二极管
     * @7 保险元件
     * @8 三极管
     * @9 开关
     * @10接插件
     * @11晶振
     * @12发光元件
     * @13电声器件
     * @14传感器
     * @15其它
     * */
    int search_species = 65535;

    /**
     * 绑定相应属性
     */
    String search_type;
    String search_path;


    /*
     * @setSpecies 响应类别选择按钮，设置标志位
     * @return none
     * */
    public void setSpecies() {
        String spe = species.getSelectionModel().getSelectedItem().toString();
        Search.setDisable(false);

        if (spe.equals("电阻")) {
            search_species = 0;
            search_path = "R\\";
        } else if (spe.equals("电容")) {
            search_species = 1;
            search_path = "C\\";
        } else if (spe.equals("电感")) {
            search_species = 2;
            search_path = "L\\";
        } else if (spe.equals("变压器")) {
            search_species = 3;
            search_path = "Transformer\\";
        } else if (spe.equals("继电器")) {
            search_species = 4;
            search_path = "Relay\\";
        } else if (spe.equals("IC")) {
            search_species = 5;
            search_path = "IC\\";
        } else if (spe.equals("二极管")) {
            search_species = 6;
            search_path = "Diode\\";
        } else if (spe.equals("保险元件")) {
            search_species = 7;
            search_path = "Protection\\";
        } else if (spe.equals("三极管")) {
            search_species = 8;
            search_path = "BJT\\";
        } else if (spe.equals("开关")) {
            search_species = 9;
            search_path = "Switch\\";
        } else if (spe.equals("接插件")) {
            search_species = 10;
            search_path = "Connector\\";
        } else if (spe.equals("石英晶体")) {
            search_species = 11;
            search_path = "Crystal\\";
        } else if (spe.equals("发光元件")) {
            search_species = 12;
            search_path = "Lighter\\";
        } else if (spe.equals("电声器件")) {
            search_species = 13;
            search_path = "Electroacoustic\\";
        } else if (spe.equals("传感器")) {
            search_species = 14;
            search_path = "Sensor\\";
        } else {
            search_species = 15;
            search_path = "Other\\";
        }
    }


    /*
     * @Search 响应搜索按钮
     * @return none
     * */
    public void Search() throws ParserConfigurationException, SAXException, IOException {
        /**绑定属性*/
        search_type = type.getText();
        List<Component> components = new ArrayList<>();
        HashMap<String, Object> search_file;

        /**case 1:未选择型号，显示文件夹全部元器件*/
        if (search_type.equals("")) {
            search_file = Search_Files.getFilesName(Main.path + search_path, null);
        }

        /**case 2:支持模糊匹配，显示匹配到的元件*/
        else {
            search_file = Search_Files.getFilesName(Main.path + search_path, type.getText());
        }

        /**根据retType判断是否有文件，只有当retType为3时处理数据*/
        if (search_file.get("retType").equals("3")) {
            List<String> fileNameList = (List<String>) search_file.get("fileNameList");

            /**开始逐个解析文件*/
            for (String file_path : fileNameList) {
                SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

                File fs = new File(Main.path + search_path + file_path);
                InputStream in = new FileInputStream(fs);

                SAXParseXML saxParseXML = new SAXParseXML();
                parser.parse(in, saxParseXML);
                components.add(saxParseXML.getComponent());
                in.close();
            }
        }

        /**显示所有的器件*/
        ObservableList<Component> data = FXCollections.observableArrayList(components);
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_num.setCellValueFactory(new PropertyValueFactory<>("num"));
        col_footprint.setCellValueFactory(new PropertyValueFactory<>("footprint"));
        col_location.setCellValueFactory(new PropertyValueFactory<>("location"));
        Data_Table.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**初始化查找按钮无效，选择元件类型后恢复*/
        Search.setDisable(true);
    }
}
