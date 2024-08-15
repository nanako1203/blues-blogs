package com.example.bluesblogs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author nanako
 * @Date 2024/8/14
 * @Description 响应数据
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    /*
    操作成功响应数据
    * @param data
    */
    public static <E> Result<E> success(E data) {
        return new Result<>(200, "success", data);
    }

    /*
    操作失败响应数据
     */
    public static Result error(String message) {
        return new Result(400, message, null);
    }

    /*
    操作成功响应数据（无data）
     */
    public static Result success() {
        return new Result(200, "success", null);
    }
}
