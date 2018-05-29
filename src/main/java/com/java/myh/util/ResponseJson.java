package com.java.myh.util;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 用于返回json数据的类
 *
 * @author 心安
 * @date 2018/5/29 17:08
 */
public class ResponseJson {

    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
    private String returnMsg;

    private Boolean returnResult;

    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
    private Object returnData;

    public ResponseJson() {
    }

    public ResponseJson(Boolean returnResult) {
        this.returnResult = returnResult;
    }

    public ResponseJson(String returnMsg, Boolean returnResult, Object returnData) {
        this.returnMsg = returnMsg;
        this.returnResult = returnResult;
        this.returnData = returnData;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public Boolean getReturnResult() {
        return returnResult;
    }

    public void setReturnResult(Boolean returnResult) {
        this.returnResult = returnResult;
    }

    public Object getReturnData() {
        return returnData;
    }

    public void setReturnData(Object returnData) {
        this.returnData = returnData;
    }
}
