package com.ytc.testStr;

/**
 * Created by Administrator on 2017/9/6.
 */
public class Address implements Cloneable {
    private String addressName;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return addressName != null ? addressName.equals(address.addressName) : address.addressName == null;
    }

    @Override
    public int hashCode() {
        return addressName != null ? addressName.hashCode() : 0;
    }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
