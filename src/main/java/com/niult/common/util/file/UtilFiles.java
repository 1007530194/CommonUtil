package com.niult.common.util.file;

import com.niult.common.util.UtilList;

import java.io.*;
import java.util.List;

/**
 * @author Niu Liangtao
 * @create 2018/01/28 18:07
 */
public class UtilFiles {

    /**
     * 读取文件数据
     *
     * @param path 文件路径
     * @return 读取的数据
     */
    public static List<String> readData(String path) {
        List<String> list = UtilList.newArrayList();

        FileReader reader = null;
        BufferedReader br = null;
        try {
            reader = new FileReader(path);
            br = new BufferedReader(reader);

            String str;
            while((str = br.readLine()) != null) {
                list.add(str);
            }
            br.close();
            reader.close();
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(br != null) {
                    br.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
            try {
                if(reader != null) {
                    reader.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    /**
     * 写数据到指定文件
     *
     * @param filePath 文件路径
     * @param list     数据
     * @return 是否成功写入
     */
    public static boolean write(String filePath, List<String> list) {
        BufferedWriter br = null;
        try {
            br = new BufferedWriter(new FileWriter(new File(filePath)));
            for(String string : list) {
                br.write(string);
                br.write("\n");
            }

            br.close();
        }catch(IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if(br != null) {
                    br.close();
                    br = null;
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("成功写入到文件：" + filePath);
        return true;
    }
}
