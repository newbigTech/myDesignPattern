package com.ytc.guava;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class SkuInfoDTO implements Serializable {
    private static final long serialVersionUID = -9073862762439132008L;
    private String levelOneId;
    private String levelOneName;
    private String levelTwoId;
    private String levelTwoName;
    private String levelThreeId;
    private String levelThreeName;
    private String sku;
    private String englishName;
    private String name;
    private String describe;
    private String style;
    private String unit;
    private String colour;
    private String texture;
    private String volume;
    private String capacity;
    private String picurl;
    private String weight;
    private String version;
    private String system;
    private String costPrice;
    private String sellingPrice;
    private Date lastTime;
    private String isvirtual;
    private Integer packageSize;
    private Integer goodsDeleted;
    private String length;
    private String height;
    private String width;
    private String brandCode;
    private String brandCnName;
    private String brandEnName;
    private String mrp;
    private String eanCode;
    private String cnTaxCategoryCode;

    public SkuInfoDTO() {
    }

    public String getCnTaxCategoryCode() {
        return this.cnTaxCategoryCode;
    }

    public void setCnTaxCategoryCode(String cnTaxCategoryCode) {
        this.cnTaxCategoryCode = cnTaxCategoryCode;
    }

    public String getEanCode() {
        return this.eanCode;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }

    public String getMrp() {
        return this.mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getBrandCode() {
        return this.brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandCnName() {
        return this.brandCnName;
    }

    public void setBrandCnName(String brandCnName) {
        this.brandCnName = brandCnName;
    }

    public String getBrandEnName() {
        return this.brandEnName;
    }

    public void setBrandEnName(String brandEnName) {
        this.brandEnName = brandEnName;
    }

    public Integer getGoodsDeleted() {
        return this.goodsDeleted;
    }

    public void setGoodsDeleted(Integer goodsDeleted) {
        this.goodsDeleted = goodsDeleted;
    }

    public String getLevelOneId() {
        return this.levelOneId;
    }

    public void setLevelOneId(String levelOneId) {
        this.levelOneId = levelOneId;
    }

    public String getLevelOneName() {
        return this.levelOneName;
    }

    public void setLevelOneName(String levelOneName) {
        this.levelOneName = levelOneName;
    }

    public String getLevelTwoId() {
        return this.levelTwoId;
    }

    public void setLevelTwoId(String levelTwoId) {
        this.levelTwoId = levelTwoId;
    }

    public String getLevelTwoName() {
        return this.levelTwoName;
    }

    public void setLevelTwoName(String levelTwoName) {
        this.levelTwoName = levelTwoName;
    }

    public String getLevelThreeId() {
        return this.levelThreeId;
    }

    public void setLevelThreeId(String levelThreeId) {
        this.levelThreeId = levelThreeId;
    }

    public String getLevelThreeName() {
        return this.levelThreeName;
    }

    public void setLevelThreeName(String levelThreeName) {
        this.levelThreeName = levelThreeName;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getEnglishName() {
        return this.englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return this.describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getTexture() {
        return this.texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLength() {
        return this.length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return this.width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getCapacity() {
        return this.capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPicurl() {
        return this.picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getCostPrice() {
        return this.costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getSellingPrice() {
        return this.sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Date getLastTime() {
        return this.lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getIsvirtual() {
        return this.isvirtual;
    }

    public void setIsvirtual(String isvirtual) {
        this.isvirtual = isvirtual;
    }

    public Integer getPackageSize() {
        return this.packageSize;
    }

    public void setPackageSize(Integer packageSize) {
        this.packageSize = packageSize;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
