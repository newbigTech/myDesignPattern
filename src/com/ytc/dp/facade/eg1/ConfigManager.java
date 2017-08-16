package com.ytc.dp.facade.eg1;

/**
 * Created by Administrator on 2017/8/16.
 */
public class ConfigManager {
    private static ConfigManager configManager;
    private static ConfigModel configModel;

    private ConfigManager(){

    }

    public static ConfigManager getInstance(){
        if(configManager == null){
            configManager = new ConfigManager();
            configModel = new ConfigModel();
        }
        return configManager;
    }

    public ConfigModel getConfigModel(){
        return configModel;
    }
}
