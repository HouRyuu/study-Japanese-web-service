package com.study.Japanese.constants;

public enum CommonErrResult implements IErrResult {

    OPERATE_FAIL(500, "啊哦，操作失败啦。重新操作下试试吧^_^");

    private int errCode;
    private String errMsg;

    CommonErrResult(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int errCode() {
        return 0;
    }

    @Override
    public String errMsg() {
        return null;
    }
}
