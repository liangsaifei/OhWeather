package com.sf.weather.data.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/26 0026.
 */

public class CityInfoVo extends Result {


    @Override
    public String toString() {
        return "CityInfoVo{" +
                "retData=" + retData +
                '}';
    }

    /**
     * cityName : 北京
     * provinceName : 北京
     * cityCode : 101010100
     * zipCode : 100000
     * telAreaCode : 010
     */

    private RetDataEntity retData;


    public RetDataEntity getRetData() {
        return retData;
    }

    public void setRetData(RetDataEntity retData) {
        this.retData = retData;
    }

    public static class RetDataEntity implements Serializable {
        private String cityName;
        private String provinceName;
        private String cityCode;
        private String zipCode;
        private String telAreaCode;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getTelAreaCode() {
            return telAreaCode;
        }

        public void setTelAreaCode(String telAreaCode) {
            this.telAreaCode = telAreaCode;
        }

        @Override
        public String toString() {
            return "RetDataEntity{" +
                    "cityName='" + cityName + '\'' +
                    ", provinceName='" + provinceName + '\'' +
                    ", cityCode='" + cityCode + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", telAreaCode='" + telAreaCode + '\'' +
                    '}';
        }
    }
}
