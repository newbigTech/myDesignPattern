package com.ytc.dp.abstractFactory.eg2;

/**
 * Created by Administrator on 2017/8/29.
 */
public class IntelCPU implements ICPU {

    @Override
    public void caculate() {
        System.out.println("Intel的cpu，正在计算内容。。。");
    }
}
