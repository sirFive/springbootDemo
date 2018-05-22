package com.example.demo.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕获类
 */
@ControllerAdvice
public class XieExceptionHandler {

    public static final String ERROR_VIEW="thymeleaf/errorTest";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        if(isAjax(request)){
            return e.getMessage();
        }else {
            ModelAndView mav=new ModelAndView();
            mav.addObject("exception",e);
            mav.addObject("url",request.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    /**
     * 判断是否为ajax请求
     * @param request
     * @return
     */
    private static boolean isAjax(HttpServletRequest request){
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }

}
