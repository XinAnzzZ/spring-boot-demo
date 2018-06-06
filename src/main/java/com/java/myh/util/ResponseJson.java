package com.java.myh.util;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 用于返回json数据
 *
 * @author 心安
 * @date 2018/5/29 17:08
 */
public class ResponseJson {

    /**
     * 请求状态，成功与否
     */
    private Boolean success;

    /**
     * 请求返回的状态码
     */
    private Integer returnCode;

    /**
     * 返回的消息
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
    private String returnMsg;

    /**
     * 返回的数据
     */
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
    private Object returnData;

    public static final Integer NORMAL = 200;
    public static final Integer NOT_FOUND = 404;
    public static final Integer UNKNOWN_REASON = 500;

    public ResponseJson() {
    }

    public ResponseJson(Boolean success, Integer returnCode, String returnMsg, Object returnData) {
        this.success = success;
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.returnData = returnData;
    }

    public static ResponseJson success(String msg) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setReturnMsg(msg);
        responseJson.setReturnCode(NORMAL);
        responseJson.setSuccess(true);
        return responseJson;
    }

    public static ResponseJson success(Object o) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setReturnCode(NORMAL);
        responseJson.setSuccess(true);
        responseJson.setReturnData(o);
        return responseJson;
    }

    public static ResponseJson success(String msg, Object o) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setReturnCode(NORMAL);
        responseJson.setSuccess(true);
        responseJson.setReturnMsg(msg);
        responseJson.setReturnData(o);
        return responseJson;
    }

    public static ResponseJson fail() {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setReturnCode(UNKNOWN_REASON);
        responseJson.setReturnMsg("unknown reason！未知错误，请联系管理员！");
        return responseJson;
    }

    public static ResponseJson fail(Integer returnCode, String returnMsg) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setReturnMsg(returnMsg);
        responseJson.setReturnCode(returnCode);
        responseJson.setSuccess(false);
        return responseJson;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public Object getReturnData() {
        return returnData;
    }

    public void setReturnData(Object returnData) {
        this.returnData = returnData;
    }
}
