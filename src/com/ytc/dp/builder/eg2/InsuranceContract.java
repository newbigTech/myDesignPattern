package com.ytc.dp.builder.eg2;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/1.
 */
public class InsuranceContract {
    private String constractId;

    private String constractName;

    private String companyName;

    private Date constractDate;

    private InsuranceContract(String constractId, Date constractDate, String constractName, String companyName) {
        this.constractId = constractId;
        this.constractDate = constractDate;
        this.constractName = constractName;
        this.companyName = companyName;
    }

//    public InsuranceContract(){
//
//    }

    @Override
    public String toString() {
        return "InsuranceContract{" +
                "constractId='" + constractId + '\'' +
                ", constractName='" + constractName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public static class ConcreteBuilder {
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
}
