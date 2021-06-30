package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Search_Files {
    public static HashMap<String, Object> getFilesName(String folderPath, String queryStr) {
        HashMap<String, Object> map = new HashMap<>();
        List<String> fileNameList = new ArrayList<>();
        List<String> folderNameList = new ArrayList<>();
        File f = new File(folderPath);
        if (!f.exists()) {
            map.put("retType", "1");
        } else {
            boolean flag = f.isDirectory();
            if (!flag) {
                map.put("retType", "2");
                map.put("fileName", f.getName());
            } else {
                map.put("retType", "3");
                File[] fa = f.listFiles();
                queryStr = (queryStr == null) ? "" : queryStr;
                for (int i = 0; i < fa.length; i++) {
                    File fs = fa[i];
                    if (fs.getName().indexOf(queryStr) != -1)
                        if (fs.isDirectory()) {
                            folderNameList.add(fs.getName());
                        } else {
                            fileNameList.add(fs.getName());
                        }
                }
                map.put("fileNameList", fileNameList);
                map.put("folderNameList", folderNameList);
            }
        }
        return map;
    }
}