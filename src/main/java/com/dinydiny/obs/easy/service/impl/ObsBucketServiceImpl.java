package com.dinydiny.obs.easy.service.impl;


import com.dinydiny.obs.easy.config.ObsTemplate;
import com.dinydiny.obs.easy.service.ObsBucketService;
import com.obs.services.model.ObsBucket;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jamesjudd
 * @date 2022/6/10
 */
@Service
public class ObsBucketServiceImpl implements ObsBucketService {
    @Resource
    private ObsTemplate obsTemplate;

    @Override
    public ObsBucket createBucket(String bucketName) {
        ObsBucket obsBucket=obsTemplate.createBucket(bucketName);
        obsTemplate.close();
        return obsBucket;
    }
}
