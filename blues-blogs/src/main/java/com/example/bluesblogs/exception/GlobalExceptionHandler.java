package com.example.bluesblogs.exception;

import com.example.bluesblogs.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author nanako
 * @Date 2024/8/15
 * @Description
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e)
    {
//        当异常发生时，这条语句会打印异常的堆栈跟踪信息到标准错误输出（通常是控制台）
        e.printStackTrace();
//        使用StringUtils类中的hasLength方法检查异常消息是否为空或仅包含空白字符。
//? e.getMessage() : "操作失败": 如果异常消息非空，则返回异常消息；否则返回默认的错误消息“操作失败”。
        return Result.error(StringUtils.hasLength(e.getMessage())? e.getMessage() : "操作失败");
    }
}
