package com.ytc.dp.builder;

import javafx.util.Builder;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/1.
 */
public class Client {
    public static void main(String[] args) {
        ConcreteBuilder bd = new ConcreteBuilder("htbh1234", new Date());
        InsuranceContract builder = bd.setConstractName("tiger").builder();
        System.out.println(builder);
    }
}
