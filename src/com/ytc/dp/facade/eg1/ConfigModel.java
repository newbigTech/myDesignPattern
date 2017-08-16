package com.ytc.dp.facade.eg1;

/**
 * Created by Administrator on 2017/8/16.
 */
public class ConfigModel {
    private boolean needController = true;
    private boolean needService = true;
    private boolean needDAO = true;

    public boolean isNeedController() {
        return needController;
    }

    public void setNeedController(boolean needController) {
        this.needController = needController;
    }

    public boolean isNeedService() {
        return needService;
    }

    public void setNeedService(boolean needService) {
        this.needService = needService;
    }

    public boolean isNeedDAO() {
        return needDAO;
    }

    public void setNeedDAO(boolean needDAO) {
        this.needDAO = needDAO;
    }
}
