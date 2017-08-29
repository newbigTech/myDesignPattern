package com.ytc.dp.adapter.eg1;

/**
 * Created by Administrator on 2017/8/19.
 */
public class TwoDirectAdapter implements Target,AdapteeApi {
    private Target target;

    private AdapteeApi adaptee;

    public TwoDirectAdapter(Target target,AdapteeApi adaptee){
        this.target = target;
        this.adaptee = adaptee;
    }

    @Override
    public void targetMethod() {
        adaptee.adapteeMethod();
    }

    @Override
    public void adapteeMethod() {
        target.targetMethod();
    }
}
