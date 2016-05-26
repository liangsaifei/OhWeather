package com.sf.weather.data.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26 0026.
 */

public class CityListVo extends Result {


    /**
     * errNum : 0
     * errMsg : success
     * retData : [{"province_cn":"北京","district_cn":"北京","name_cn":"朝阳","name_en":"chaoyang","area_id":"101010300"},{"province_cn":"辽宁","district_cn":"朝阳","name_cn":"朝阳","name_en":"chaoyang","area_id":"101071201"},{"province_cn":"辽宁","district_cn":"朝阳","name_cn":"凌源","name_en":"lingyuan","area_id":"101071203"},{"province_cn":"辽宁","district_cn":"朝阳","name_cn":"喀左","name_en":"kazuo","area_id":"101071204"},{"province_cn":"辽宁","district_cn":"朝阳","name_cn":"北票","name_en":"beipiao","area_id":"101071205"},{"province_cn":"辽宁","district_cn":"朝阳","name_cn":"建平县","name_en":"jianpingxian","area_id":"101071207"}]
     */


    /**
     * province_cn : 北京
     * district_cn : 北京
     * name_cn : 朝阳
     * name_en : chaoyang
     * area_id : 101010300
     */

    private List<RetDataEntity> retData;


    public List<RetDataEntity> getRetData() {
        return retData;
    }

    public void setRetData(List<RetDataEntity> retData) {
        this.retData = retData;
    }

    public static class RetDataEntity implements Serializable {
        private String province_cn;
        private String district_cn;
        private String name_cn;
        private String name_en;
        private String area_id;

        public String getProvince_cn() {
            return province_cn;
        }

        public void setProvince_cn(String province_cn) {
            this.province_cn = province_cn;
        }

        public String getDistrict_cn() {
            return district_cn;
        }

        public void setDistrict_cn(String district_cn) {
            this.district_cn = district_cn;
        }

        public String getName_cn() {
            return name_cn;
        }

        public void setName_cn(String name_cn) {
            this.name_cn = name_cn;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }
    }
}
