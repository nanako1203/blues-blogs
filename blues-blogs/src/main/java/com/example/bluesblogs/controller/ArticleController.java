package com.example.bluesblogs.controller;

import com.example.bluesblogs.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author nanako
 * @Date 2024/8/15
 * @Description 获取文章列表
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result<String> list() {
        return Result.success("文章列表");
    }
}
