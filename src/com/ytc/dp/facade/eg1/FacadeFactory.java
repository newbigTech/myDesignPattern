package com.ytc.dp.facade.eg1;

/**
 * Created by Administrator on 2017/8/16.
 */
public class FacadeFactory {
    private static FacadeImpl facade = null;
    private FacadeFactory(){}

    public static FacadeApi getFacade(){
        if(facade == null) {
            facade =new FacadeImpl();
        }
        return facade;
    }
}
