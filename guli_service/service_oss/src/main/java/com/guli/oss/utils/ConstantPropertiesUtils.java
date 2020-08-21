package com.guli.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtils implements InitializingBean {
    @Value(value = "${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value(value = "${aliyun.oss.file.keyid}")
    private String keyid;
    @Value(value = "${aliyun.oss.file.keysecret}")
    private String keysecret;
    @Value(value = "${aliyun.oss.file.bucketname}")
    private String bucketname;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public String getKeysecret() {
        return keysecret;
    }

    public void setKeysecret(String keysecret) {
        this.keysecret = keysecret;
    }

    public String getBucketname() {
        return bucketname;
    }

    public void setBucketname(String bucketname) {
        this.bucketname = bucketname;
    }

    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BACKET_NAME;
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = this.endpoint;
        KEY_ID = this.keyid;
        KEY_SECRET = this.keysecret;
        BACKET_NAME = this.bucketname;
    }
}
