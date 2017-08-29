package com.ytc.dp.abstractFactory.eg2;

/**
 * µÕ≈‰∞Êπ§≥ß
 * Created by Administrator on 2017/8/29.
 */
public class LowFactory extends IFactory {

    @Override
    public Object createProduct(int type) {
        if(new Integer(1).equals(type)){
            return new Computer(new AMDCPU(),new SegeatHardware());
        } else if(new Integer(2).equals(type)){
            return new Computer(new IntelCPU(),new SugsangHardware());
        } else {
            return null;
        }
    }
}
