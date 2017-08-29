package com.ytc.dp.abstractFactory.eg1;

/**
 * Created by Administrator on 2017/8/29.
 */
public class AMDCPU implements ICPU {
    @Override
    public void caculate() {
        System.out.println("AMD的cpu，正在计算内容。。。");
    }
}
