package com.ytc.dp.abstractFactory.eg1;

/**
 * Created by Administrator on 2017/8/29.
 */
public class SegeatHardware implements IHardware {
    @Override
    public void save() {
        System.out.println("希捷硬盘，正在存储东西。。。");
    }
}
