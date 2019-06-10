package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**

* @Description:    静态资源读取文件、配置文件读取工具类

* @Author:         zhangtao

* @CreateDate:     2019/6/9 8:36

* @Version:        1.0

*/
@Slf4j
public class PropertiesUtil {
    private static Properties properties;

    static{
        loadProps();
    }

    synchronized static private void loadProps() {
        properties = new Properties();
        InputStream in = null;
        try {
            String path = PropertiesUtil.class.getResource("/").getPath();
            //获取web-info目录的路径
            //  path = path.substring(1,path.indexOf("classes"));
            in = new FileInputStream(path + "jdbc.properties");
            properties.load(in);
        } catch (FileNotFoundException e){
            log.error("文件找不到"+e.getMessage());
        } catch (IOException e) {
            log.error("IO异常"+e.getMessage());
        } finally {
            try {
                if (null !=in){
                    in.close();
                }
            }catch (IOException e){
                log.error("文件流关闭异常");
            }
        }
            log.info("加载properties文件内容正常");
    }

    /**
     * 适合代码中已经指定了配置文件名称
     * @param key
     * @return
     */
    public static String getProperty(String key){
        if (null == properties){
            loadProps();
        }
        return properties.getProperty(key);
    }

    public static String getProperty(String key,String filename){
        if (null == properties){
            loadProps();
        }
        return properties.getProperty(key,filename);
    }

    public static void main(String[] args) {
        log.info("输出为："+PropertiesUtil.getProperty("age","jdbc.properties"));
    }
}
