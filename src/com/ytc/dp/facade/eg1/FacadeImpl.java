package com.ytc.dp.facade.eg1;

/**
 * Created by Administrator on 2017/8/16.
 */
public class FacadeImpl implements FacadeApi {
    @Override
    public void run(){
        ConfigModel configModel = ConfigManager.getInstance().getConfigModel();
        if(configModel.isNeedController()){
            new ModuleA().generate();
        }
        if(configModel.isNeedService()){
            new ModuleB().generate();
        }
    }
}
