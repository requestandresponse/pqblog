package com.fb.pqBlog.common.restult;

import com.fb.pqBlog.common.constant.OpreationConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonRestult<T> {

    private String code;

    private String message;

    private List<T> list;

    public static CommonRestult getSuccess(){
        return new CommonRestult(OpreationConstant.successCode,OpreationConstant.successMessage,null);
    }

    public static CommonRestult getSuccess(String message){
        return new CommonRestult(OpreationConstant.successCode,message,null);
    }

    public static CommonRestult getFail(){
        return new CommonRestult(OpreationConstant.failCode,OpreationConstant.failCode,null);
    }

    public static CommonRestult getFail(String message){
        return new CommonRestult(OpreationConstant.failCode,message,null);
    }
}
