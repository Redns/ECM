package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class Controller_Add implements Initializable {

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
    int File_Rename_Flag = 65535;

    /**获取控件*/
    public TextField Add_name;
    public TextField Add_num;
    public ComboBox<String> Add_package;
    public TextField Add_location;

    /**相关属性*/
    String File_Path;
    String type;
    String num;
    String footprint;
    String location;

    /*
     * @Add_save 响应保存事件，写入xml文件
     * @return null
     */
    public void Add_save() throws IOException, TransformerConfigurationException, SAXException {
        /**获取相关属性*/
        type = Add_name.getText();
        num = Add_num.getText();
        location = Add_location.getText();

        /**判断命名是否规范*/
        boolean ismatch = true;
        switch (File_Rename_Flag){

            /**电阻*/
            case 0:
                ismatch = Pattern.matches("(\\d+)R(\\d+)?", type) || Pattern.matches("(\\d+)K(\\d+)?", type) || Pattern.matches("(\\d+)M(\\d+)?", type);
                break;

            /**电容*/
            case 1:
                ismatch = Pattern.matches("(\\d+)(.)?(\\d+)?p", type) || Pattern.matches("(\\d+)(.)?(\\d+)?n", type) || Pattern.matches("(\\d+)(.)?(\\d+)?u", type);
                break;

            /**电感*/
            case 2:
                ismatch = Pattern.matches("(\\d+)(.)?(\\d+)?n", type) || Pattern.matches("(\\d+)(.)?(\\d+)?u", type);
                break;

            /**其它类别不检查*/
            default:
                ismatch = true;
                break;
        }

        /**若不满足则弹窗警告*/
        if(!ismatch){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setContentText("");
            alert.setHeaderText("类型格式有误！");
            alert.showAndWait();
        }

        /**若满足则写文件*/
        else {
            /**创建一个SAXTransformerFactory一个对象*/
            SAXTransformerFactory sf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();

            /**通过SAXTransformerFactory创建一个TransformerHandler对象*/
            TransformerHandler handler = sf.newTransformerHandler();

            /**用于设置xml输出的样式和头*/
            Transformer transformer = handler.getTransformer();

            /**设置换行*/
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            /**创建输出流*/
            File file = new File(Main.path + File_Path + "Data.xml");
            FileOutputStream os = new FileOutputStream(file, false);

            /**创建流Result对象*/
            Result result = new StreamResult(os);

            /**关联Result*/
            handler.setResult(result);


            /**打开文档*/
            handler.startDocument();

            /**属性设置*/
            AttributesImpl attr = new AttributesImpl();

            /**开始创建元素*/
            handler.startElement("", "", "component", attr);

            /**添加型号*/
            handler.startElement("", "", "type", attr);
            handler.characters(type.toCharArray(), 0, type.toCharArray().length);
            handler.endElement("", "", "type");

            /**添加数量*/
            handler.startElement("", "", "num", attr);
            handler.characters(num.toCharArray(), 0, num.toCharArray().length);
            handler.endElement("", "", "num");

            /**添加封装*/
            handler.startElement("", "", "footprint", attr);
            handler.characters(footprint.toCharArray(), 0, footprint.toCharArray().length);
            handler.endElement("", "", "footprint");

            /**添加位置*/
            handler.startElement("", "", "location", attr);
            handler.characters(location.toCharArray(), 0, location.toCharArray().length);
            handler.endElement("", "", "location");

            handler.endElement("", "", "component");

            /**关闭文档*/
            handler.endDocument();

            /**关闭流*/
            os.getFD().sync();
            os.close();

            /**修改文件名称*/
            File file_new = new File(Main.path + File_Path + type + "_" + footprint + ".xml");
            file.renameTo(file_new);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setContentText("");
            alert.setHeaderText("添加成功！");
            alert.showAndWait();
        }

    }


    /*
     * @setFootprint 响应封装按钮，修改footprint
     * */
    public void setFootprint(){
        footprint = Add_package.getSelectionModel().getSelectedItem().toString();
    }


    public ComboBox<String> species;

    /*初始化界面**/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
         * @setFile_path 响应ComboBox，根据选择的元件类别设置路径
         * @para none
         * @return none
         */
        species.setOnAction(event -> {

            String spe = species.getSelectionModel().getSelectedItem().toString();
            if(spe.equals("电阻")){
                File_Rename_Flag = 0;
                File_Path = "R\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("电容")){
                File_Rename_Flag = 1;
                File_Path = "" + "C\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("电感")){
                File_Rename_Flag = 2;
                File_Path = "" + "L\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("变压器")){
                File_Rename_Flag = 3;
                File_Path = "" + "Transformer\\";
                Add_package.setDisable(true);
            }

            else if(spe.equals("继电器")){
                File_Rename_Flag = 4;
                File_Path = "" + "Relay\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("IC")){
                File_Rename_Flag = 5;
                File_Path = "" + "IC\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("二极管")){
                File_Rename_Flag = 6;
                File_Path = "" + "Diode\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("保险元件")){
                File_Rename_Flag = 7;
                File_Path = "" + "Protection\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("三极管")){
                File_Rename_Flag = 8;
                File_Path = "" + "BJT\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("开关")){
                File_Rename_Flag = 9;
                File_Path = "" + "Switch\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("接插件")){
                File_Rename_Flag = 10;
                File_Path = "" + "Connector\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("石英晶体")){
                File_Rename_Flag = 11;
                File_Path = "" + "Crystal\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("发光元件")){
                File_Rename_Flag = 12;
                File_Path = "" + "Lighter\\";
                Add_package.setDisable(false);
            }

            else if(spe.equals("电声器件")){
                File_Rename_Flag = 13;
                File_Path = "" + "Electroacoustic\\";
                Add_package.setDisable(true);
            }

            else if(spe.equals("传感器")){
                File_Rename_Flag = 14;
                File_Path = "" + "Sensor\\";
                Add_package.setDisable(true);
            }

            else {
                File_Rename_Flag = 15;
                File_Path = "" + "Other\\";
                Add_package.setDisable(false);
            }
        });
    }

    private String getPath(){
        String path = this.getClass().getResource("").toString();

        /**对path做相应处理*/
        path = path.replace("file:/", "");
        path = path.replace("/", "\\ ");
        path = path.replace(" ", "\\");

        return path;
    }
}