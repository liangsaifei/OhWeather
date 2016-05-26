package com.sf.weather.data.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/26 0026.
 */

public class Result implements Serializable{

    private int errNum;
    private String errMsg;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
