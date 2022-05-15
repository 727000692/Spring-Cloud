package com.zust.nie.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class CommonResult {
    private boolean success;
    private int code;
    private String msg;
    private Object data;
    public static CommonResult success(String msg,Object data){
        return new CommonResult(true,200,msg,data);
    }

    public static CommonResult fail(int code, String msg){
        return new CommonResult(false,code,msg,null);
    }
}
