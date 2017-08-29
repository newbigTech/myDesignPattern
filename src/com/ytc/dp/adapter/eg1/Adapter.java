package com.ytc.dp.adapter.eg1;

/**
 * Created by Administrator on 2017/8/19.
 */
public class Adapter implements Target {

    private AdapteeApi adaptee = null;

    public Adapter(AdapteeApi adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void targetMethod() {
        adaptee.adapteeMethod();
    }
}
