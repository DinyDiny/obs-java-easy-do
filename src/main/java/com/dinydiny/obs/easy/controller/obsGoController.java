package com.dinydiny.obs.easy.controller;



import com.dinydiny.obs.easy.service.ObsBucketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jamesjudd
 * @date 2022/6/10
 */
@RestController
@RequestMapping("/obs")
public class obsGoController {
    @Resource
    private ObsBucketService obsBucketService;


    @GetMapping("/go")
    public String createBucket(String bucketName) {
        String name=obsBucketService.createBucket(bucketName).getBucketName();
        return name;
    }

    public static void main(String[] args) {

    }
}
