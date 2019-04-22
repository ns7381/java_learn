package com.nathan.thrift;



import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;

import java.util.Date;

/**
 * @author qifuguang
 * @date 15/9/11 15:53
 */
public class HelloWordServiceImpl implements com.nathan.thrift.HelloWordService.Iface {
    // 实现这个方法完成具体的逻辑。
    public String doAction(com.nathan.thrift.Request request) throws com.nathan.thrift.RequestException, TException {
        System.out.println("Get request: " + request);
        if (StringUtils.isBlank(request.getName()) || request.getType() == null) {
            throw new com.nathan.thrift.RequestException();
        }
        String result = "Hello, " + request.getName();
        if (request.getType() == com.nathan.thrift.RequestType.SAY_HELLO) {
            result += ", Welcome!";
        } else {
            result += ", Now is " + new Date().toLocaleString();
        }
        return result;
    }
}
