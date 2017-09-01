package com.ytc.dp.builder;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/1.
 */
public class ConcreteBuilder {
    private String constractId;

    private Date constractDate;

    private String constractName;

    private String companyName;

    public void setConstractId(String constractId) {
        this.constractId = constractId;
    }

    public ConcreteBuilder setConstractName(String constractName) {
        this.constractName = constractName;
        return this;
    }

    public ConcreteBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ConcreteBuilder(String constractId,Date constractDate) {
        this.constractId = constractId;
        this.constractDate = constractDate;
    }

    public InsuranceContract builder(){
        if(constractName != null && companyName != null){
            throw new IllegalArgumentException("constractName and ConstractCompany can't exist together！");
        }

        return new InsuranceContract(constractId,constractDate,constractName,companyName);
    }
}
