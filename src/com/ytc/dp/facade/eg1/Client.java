package com.ytc.dp.facade.eg1;

/**
 * Created by Administrator on 2017/8/16.
 */
public class Client {
    public static void main(String [] args){
//        new Facade().run();
        FacadeApi facade = FacadeFactory.getFacade();//run();
        facade.run();
    }
}
