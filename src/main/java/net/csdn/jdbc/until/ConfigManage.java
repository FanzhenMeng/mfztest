package net.csdn.jdbc.until;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigManage {

    private static ConfigManage configManage;
    private static Properties properties;

    private ConfigManage() {
        InputStream inputStream = ConfigManage.class.getClassLoader().getResourceAsStream("datebase.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigManage getConfigManage() {
        if (configManage == null) {
            configManage = new ConfigManage();
        }
        return configManage;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
