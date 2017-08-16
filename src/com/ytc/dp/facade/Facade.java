package com.ytc.dp.facade;

/**
 * Created by Administrator on 2017/8/16.
 */
public class Facade {
    public void run(){
        new ModuleA().generate();
        new ModuleB().generate();
    }
}
