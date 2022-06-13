package com.dinydiny.obs.easy.service;

import com.obs.services.model.ObsBucket;

/**
 * @author jamesjudd
 * @date 2022/6/10
 */
public interface ObsBucketService {

    /**
     * 简单创建桶
     * @param bucketName 桶名
     * @return
     */
    ObsBucket createBucket(String bucketName);
}
