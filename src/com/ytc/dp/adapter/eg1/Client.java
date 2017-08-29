package com.ytc.dp.adapter.eg1;

/**
 * Created by Administrator on 2017/8/19.
 */
public class Client {
    public static void main(String[] args) {
        AdapteeApi adaptee = new Adaptee();
        Target t = new Adapter(adaptee);
        t.targetMethod();

        //双向适配
        Target target = new TargetImpl();
        AdapteeApi adaptee2 = new TwoDirectAdapter(target,adaptee);
        adaptee2.adapteeMethod();

    }
}
