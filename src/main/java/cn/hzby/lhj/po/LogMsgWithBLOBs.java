package cn.hzby.lhj.po;

public class LogMsgWithBLOBs extends LogMsg {
    private String msg;

    private String param;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }
}