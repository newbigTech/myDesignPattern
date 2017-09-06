package com.ytc.dp.builder.eg2;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/1.
 */
public class Client {
    public static void main(String[] args) {
        InsuranceContract.ConcreteBuilder pc = new InsuranceContract.ConcreteBuilder("htfk1234", new Date());
        InsuranceContract builder = pc
//                .setCompanyName("yungang")
                .setConstractName("Tom")
                .builder();
//        ic.ConcreteBuilder ic = new InsuranceContract.ConcreteBuilder();
        System.out.println(builder);
    }
}
