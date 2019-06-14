package com.example.common.domain;

import java.io.Serializable;

public class ResultMap implements Serializable {
    private static final long serialVersionUID = 7776646698575187370L;
    private String code = "1";
    private String msg = "操作成功！";
    private Object transport;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getTransport() {
        return transport;
    }

    public void setTransport(Object transport) {
        this.transport = transport;
    }

    public static ResultMap createResultMap() {
        return new ResultMap();
    }

}
