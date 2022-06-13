package com.dinydiny.obs.easy.config;

import com.obs.services.ObsClient;
import com.obs.services.model.ObjectMetadata;
import com.obs.services.model.StorageClassEnum;

import java.io.File;

/**
 * @author jamesjudd
 * @date 2022/6/13
 */
public class ObsEasySetUtils {

    /**
     * 设置对象长度
     */
    public static void setObjLength(){
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(1024 * 1024L);// 1MB
        obsClient.putObject("bucketname", "objectname", new File("localfile"), metadata);

    }

    /**
     * 设置对象MIME类型
     */
    public static void setObjMIME(){
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        // 上传图片
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/jpeg");
        obsClient.putObject("bucketname", "objectname.jpg", new File("localimage.jpg"), metadata);

    }

    /**
     * 设置对象MD5值
     */
    public static void setMD5(){
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
        // 上传图片
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentMd5("your md5 which should be encoded by base64");
        obsClient.putObject("bucketname", "objectname", new File("localimage.jpg"), metadata);

    }

    /**
     * 设置对象存储类型
     */
    public static void setStoreType(){
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";

        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        ObjectMetadata metadata = new ObjectMetadata();
        // 设置对象存储类型为低频访问存储
        metadata.setObjectStorageClass(StorageClassEnum.WARM);
        obsClient.putObject("bucketname", "objectname", new File("localfile"), metadata);

    }

    /**
     * 设置对象自定义元数据
     */
    public static void setSelfData(){
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.addUserMetadata("property1", "property-value1");
        metadata.getMetadata().put("property2", "property-value2");
        obsClient.putObject("bucketname", "objectname", new File("localfile"), metadata);

    }
}
