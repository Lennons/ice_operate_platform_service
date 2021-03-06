package com.iceOperatePlatform.provider.exception;

import com.iceOperatePlatform.provider.entity.Result;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lennon on 17/4/13.
 */
@ControllerAdvice
public class CoreException extends RuntimeException{

    // common
    public static final String[] PARAMETER_INVALID = {"900", "param_error", "参数异常"};
    public static final String[] RESOURCE_NO_FOUND = {"404", "resource_not_found", "无法找到资源"};
    public static final String[] CONTENT_INCLUDE_SENSITIVE_WORDS = {"901", "content_include_sensitive_words", "内容包含敏感词汇"};
    public static final String[] OPERATING_FREQUENCY_FAST = {"904", "operating_frequency_fast", "操作过于频繁"};
    public static final String[] NETWORK_CONNECTION_ERROR = {"905", "network_connection_error", "网络连接出错"};

    // user 相关以 10 开头
    public static final String[] USER_NOT_LOGIN = {"1000", "user_not_login", "用户尚未登录"};

    // 底层微服务请求 相关以 20 开头
    public static final String[] ICE_REQUEST_ERROR = {"2000", "ice_request_error", "ice底层微服务请求异常"};
    public static final String[] ICE_GENERATE_SIGN_ERROR = {"2001", "ice_generate_sign_error", "ice底层微服务生成请求签名异常"};

    private String code = "1";//是否成功标志
    private String key = "";//错误key
    private String message = "";//错误消息

    private Map<String, String> map = new HashMap<String, String>();//用于传入参数validate错误

    public CoreException(String code, String key, String message) {
        this.code = code;
        this.key = key;
        this.message = message;
    }

    public CoreException() {
    }

    public CoreException(String code, Map<String, String> map) {
        this.code = code;
        this.map = map;
    }

    //通过字符串获取异常
    public static CoreException of(final String[] key, Object... args) {
        return new CoreException(key[0], key[1], key[2]);
    }

    public static Result handle(CoreException e) {
        if (e.map != null && e.map.size() > 0) {
            // Form表单的Errors形式
            return new Result(NumberUtils.toInt(e.code), "", null);
        }
        if (e.key == null) {
            return Result.failed();
        }
        //非表单异常
        String message = "";
        message = Result.message(e.message);
        int code = Integer.valueOf(e.code);
        return new Result(code, message);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(HttpServletRequest req, Exception ex) throws Exception {
        if (ex instanceof CoreException) {
            return CoreException.handle((CoreException) ex);
        } else if (ex instanceof NoHandlerFoundException) {
            return buildResult(HttpServletResponse.SC_NOT_FOUND, "Not Found");
        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
            return buildResult(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Method Not Allowed");
        } else if (ex instanceof HttpMediaTypeNotSupportedException) {
            return buildResult(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
        } else if (ex instanceof HttpMediaTypeNotAcceptableException) {
            return buildResult(HttpServletResponse.SC_NOT_ACCEPTABLE, "Not Acceptable");
        } else if (ex instanceof MissingServletRequestParameterException
                || ex instanceof ServletRequestBindingException
                || ex instanceof TypeMismatchException
                || ex instanceof HttpMessageNotReadableException
                || ex instanceof MethodArgumentNotValidException
                || ex instanceof MissingServletRequestPartException
                || ex instanceof InvalidPropertyException
                || ex instanceof BindException) {
            return buildResult(HttpServletResponse.SC_BAD_REQUEST, "Bad Request");
        } else {
            throw ex;
        }
    }

    private Result buildResult(int code, String message) {
//        String message = "";
//        message = message;
        return new Result(Result.CODE_FAILED, message, null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
