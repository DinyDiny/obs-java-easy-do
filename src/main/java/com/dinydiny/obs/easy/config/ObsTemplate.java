package com.dinydiny.obs.easy.config;


import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.ObsBucket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jamesjudd
 * @date 2021/11/19
 */
@Slf4j
@Component
public class ObsTemplate implements InitializingBean {
	@Resource
	private ObsProperties obsProperties;
	private ObsClient obsClient;

	public ObsBucket createBucket(String bucketName){
		ObsBucket bucket=null;
		try{
			// 创建桶成功
			bucket = obsClient.createBucket(bucketName);
			System.out.println(bucket.getRequestId());
		}
		catch (ObsException e) {
			// 创建桶失败
			log.error("HTTP Code: " + e.getResponseCode());
			log.error("Error Code:" + e.getErrorCode());
			log.error("Error Message: " + e.getErrorMessage());
			log.error("Request ID:" + e.getErrorRequestId());
			log.error("Host ID:" + e.getErrorHostId());
		}
		return bucket;
	}


	/**
	 * 关闭obsClient
	 */
	public void close(){
		try{
			obsClient.close();
		}catch (Exception e){
			log.error("OBS关闭失败！错误信息:",e);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.obsClient = new ObsClient(obsProperties.getAk(), obsProperties.getSk(), obsProperties.getEndPoint());
	}
}
