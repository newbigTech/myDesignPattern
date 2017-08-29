package com.ytc.dp.abstractFactory.eg1;

/**
 * µÕ≈‰∞Êπ§≥ß
 * Created by Administrator on 2017/8/29.
 */
public class LowFactory extends IFactory {

    @Override
    public ICPU createCPU() {
        return new AMDCPU();
    }

    @Override
    public IHardware createHardware() {
        return new SegeatHardware();
    }
}
