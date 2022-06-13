package com.dinydiny.obs.easy.config;

import com.obs.services.ObsClient;
import com.obs.services.model.ProgressListener;
import com.obs.services.model.ProgressStatus;
import com.obs.services.model.PutObjectRequest;

import java.io.*;
import java.net.URL;

/**
 * @author jamesjudd
 * @date 2022/6/13
 */
public class ObsEasyUtils {

    /**
     * 上传字符串（byte数组）
     */
    public static void uploadByte() {
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        String content = "Hello OBS";
        obsClient.putObject("bucketname", "objectname", new ByteArrayInputStream(content.getBytes()));
    }

    /**
     * 上传网络流
     */
    public static void uploadUrl() throws IOException {
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        InputStream inputStream = new URL("http://www.a.com").openStream();
        obsClient.putObject("bucketname", "objectname", inputStream);

    }

    /**
     * 上传文件流
     */
    public static void uploadFile() throws FileNotFoundException {
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        // 待上传的本地文件路径，需要指定到具体的文件名
        FileInputStream fis = new FileInputStream(new File("localfile"));
        obsClient.putObject("bucketname", "objectname", fis);

        // 待上传的本地文件路径，需要指定到具体的文件名
        FileInputStream fis2 = new FileInputStream(new File("localfile2"));
        PutObjectRequest request = new PutObjectRequest();
        request.setBucketName("bucketname");
        request.setObjectKey("objectname2");
        request.setInput(fis2);
        obsClient.putObject(request);

    }

    public static void uploadFileObj(){
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        // localfile为待上传的本地文件路径，需要指定到具体的文件名
        obsClient.putObject("bucketname", "objectname", new File("localfile"));

        // localfile2 为待上传的本地文件路径，需要指定到具体的文件名
        PutObjectRequest request = new PutObjectRequest();
        request.setBucketName("bucketname");
        request.setObjectKey("objectname2");
        request.setFile(new File("localfile2"));
        obsClient.putObject(request);

    }

    /**
     * 获取上传进度
     */
    public static void getProgress(){
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        PutObjectRequest request = new PutObjectRequest("bucketname", "objectname");
        request.setFile(new File("localfile"));
        request.setProgressListener(new ProgressListener() {

            @Override
            public void progressChanged(ProgressStatus status) {
                // 获取上传平均速率
                System.out.println("AverageSpeed:" + status.getAverageSpeed());
                // 获取上传进度百分比
                System.out.println("TransferPercentage:" + status.getTransferPercentage());
            }
        });
        // 每上传1MB数据反馈上传进度
        request.setProgressInterval(1024 * 1024L);
        obsClient.putObject(request);

    }

    /**
     * 创建文件夹
     */
    public static void makeDir(){
        String endPoint = "https://your-endpoint";
        String ak = "*** Provide your Access Key ***";
        String sk = "*** Provide your Secret Key ***";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        final String keySuffixWithSlash = "parent_directory/";
        obsClient.putObject("bucketname", keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));

        // 在文件夹下创建对象
        obsClient.putObject("bucketname", keySuffixWithSlash + "objectname", new ByteArrayInputStream("Hello OBS".getBytes()));

    }


}
