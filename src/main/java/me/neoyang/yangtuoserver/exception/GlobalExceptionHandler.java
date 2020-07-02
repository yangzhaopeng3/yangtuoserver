package me.neoyang.yangtuoserver.exception;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * 异常拦截处理器
 *
 * @author chenmc
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //自定义错误
    @ExceptionHandler({MyException.class})
    public RespBean exception(MyException ex) {
        return ResultUtil.error(ex.getCode(), ex.getMessage());
    }

    //处理404 500异常
    @ExceptionHandler
    public RespBean defaultErrorHandler(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return ResultUtil.error(404, "找不到资源路径！");
        } else {
            return ResultUtil.error(500, "系统内部错误！");
        }
    }

    //运行时异常
    @ExceptionHandler({
            RuntimeException.class,
            HttpMessageNotReadableException.class,
            ConversionNotSupportedException.class,
            HttpMessageNotWritableException.class,
            StackOverflowError.class})
    public RespBean runtimeExceptionHandler(RuntimeException ex) {
        ex.printStackTrace();
        return ResultUtil.error(1, "系统错误，请联系管理员！");
    }

    /*//400错误
    @ExceptionHandler()
    public RespBean requestNotReadable(HttpMessageNotReadableException ex) {
        System.out.println("400..requestNotReadable");
        return ResultUtil.error(41, "系统错误，请联系管理员！");
    }*/

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public RespBean requestTypeMismatch(TypeMismatchException ex) {
        System.out.println("400..TypeMismatchException");
        return ResultUtil.error(42, "请求参数类型不匹配！");
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public RespBean requestMissingServletRequest(MissingServletRequestParameterException ex) {
        return ResultUtil.error(43, "缺少请求参数！");
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public RespBean request405(HttpRequestMethodNotSupportedException ex) {
        return ResultUtil.error(45, "HTTP请求方法异常！");
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public RespBean request406(HttpMediaTypeNotAcceptableException ex) {
        return ResultUtil.error(46, "不支持的数据类型！");
    }

    /*//500错误
    @ExceptionHandler({})
    public RespBean server500(RuntimeException ex) {
        return ResultUtil.error(5, "服务器异常，请联系管理员！");
    }
*/

    //栈溢出
    /*
    @ExceptionHandler({StackOverflowError.class})
    public RespBean requestStackOverflow(StackOverflowError ex) {
        return ResultUtil.error(6, "服务器炸了！");
    }
*/


}