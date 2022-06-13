package com.dinydiny.obs.easy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jamesjudd
 * @date 2021/11/19
 */
@Data
@Component
@ConfigurationProperties(prefix="obs")
public class ObsProperties {
	/**
	 * 服务地址
	 */
	private String endPoint;

	/**
	 * Access Key ID，接入键标识
	 */
	private String ak;

	/**
	 * Secret Access Key，安全接入键
	 */
	private String sk;

}
