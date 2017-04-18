package com.iceOperatePlatform.provider.utils;

import com.auth.dto.auth.GetAppAuthRequest;
import com.auth.dto.common.Result;
import com.auth.service.AuthService;
import com.iceOperatePlatform.provider.exception.CoreException;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Lennon on 17/4/14.
 */
@Component(value = "utils")
public class Utils {

    @Autowired
    private AuthService authService;
    @Autowired
    private RedisUtil redisUtil;

    public static void verifyParams(String... objects) {
        for (String object : objects) {
            if (object == null || object.trim().isEmpty()) {
                throw CoreException.of(CoreException.PARAMETER_INVALID);
            }
        }
    }

    public String getAccessToken(String app_uuid, String app_secret, String corp_uuid) {
        GetAppAuthRequest getAppAuthRequest = new GetAppAuthRequest();
        long timestamp = new Date().getTime();
        String signature = DigestUtils.md5Hex(app_uuid + timestamp + app_secret);
        System.out.println("corpUuid:" + corp_uuid);
        System.out.println("appUuid:" + app_uuid);
        System.out.println("signature:" + signature);
        System.out.println("ts:" + timestamp);

        getAppAuthRequest.setAppUuid(app_uuid);
        getAppAuthRequest.setCorpUuid(corp_uuid);
        getAppAuthRequest.setSignature(signature);
        getAppAuthRequest.setTimestamp(timestamp);
        if (!redisUtil.exists("accessToken")) {
            System.out.println("redis中未存在accessToken,插入中");
            Result result = authService.getAppAuth(getAppAuthRequest);
            JSONObject jsonObject = JSONObject.fromObject(result);
            if ("0".equals(jsonObject.getString("code"))) {
                JSONObject content = jsonObject.getJSONObject("content");
                String access_token = content.getString("accessToken");
                redisUtil.set("accessToken", access_token, 3600l);
                return access_token;
            }
        }

        System.out.println("redis中存在accessToken,读取中");
        Object o = redisUtil.get("accessToken");
        return o.toString();
    }
}
