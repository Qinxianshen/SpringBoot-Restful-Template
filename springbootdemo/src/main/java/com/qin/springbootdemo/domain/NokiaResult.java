package com.qin.springbootdemo.domain;


/* author:Qinzijing
*  date: 2019/11/17
*  description:返回的值
*/
public class NokiaResult {
    /*
     * 200: 成功
     *
     *
     * */
    private Integer staus;
    private String Msg;

    public NokiaResult(Integer staus, String msg) {
        this.staus = staus;
        Msg = msg;
    }

    public Integer getStaus() {
        return staus;
    }

    public void setStaus(Integer staus) {
        this.staus = staus;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
