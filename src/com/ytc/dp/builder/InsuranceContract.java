package com.ytc.dp.builder;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/1.
 */
public class InsuranceContract {
    private String constractId;

    private String constractName;

    private String companyName;

    private Date constractDate;

    InsuranceContract(String constractId, Date constractDate, String constractName, String companyName) {
        this.constractId = constractId;
        this.constractDate = constractDate;
        this.constractName = constractName;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "InsuranceContract{" +
                "constractId='" + constractId + '\'' +
                ", constractName='" + constractName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
