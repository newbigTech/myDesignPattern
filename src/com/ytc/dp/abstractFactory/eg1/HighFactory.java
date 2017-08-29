package com.ytc.dp.abstractFactory.eg1;

/**
 * Created by Administrator on 2017/8/29.
 * ∏ﬂ≈‰∞Êπ§≥ß
 */
public class HighFactory extends IFactory {
    @Override
    public ICPU createCPU() {
        return new IntelCPU();
    }

    @Override
    public IHardware createHardware() {
        return new SugsangHardware();
    }
}
