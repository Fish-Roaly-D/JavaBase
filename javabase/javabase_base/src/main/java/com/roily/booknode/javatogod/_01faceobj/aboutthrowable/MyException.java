package com.roily.booknode.javatogod._01faceobj.aboutthrowable;

/**
 * @Date: 2022/08/08/10:59
 * @Description:
 */
public class MyException  extends RuntimeException{

    private final String DEFAULT_ERROR_CODE = "5000";
    private final String DEFAULT_ERROR_MSG = "运行时异常";

    String code;
    String msg;
    //someMethod

    public MyException(Throwable cause, String code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public MyException(String s, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
