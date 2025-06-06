package com.cow.exception;

import com.cow.enums.BaseEnum;
import lombok.Getter;
import org.apache.poi.ss.formula.functions.T;

/**
 * 自定义异常
 * @author
 * @date
 */
@Getter
public class ServiceException extends RuntimeException {
    private int code;

    public ServiceException(int code,String message){
        super(message);
        this.code = code;
    }

    public ServiceException(BaseEnum<T> e){
        super(e.getMessage());
        this.code = e.getCode();
    }


}
