package com.iceOperatePlatform.provider.test;

import com.auth.dto.common.Result;
import com.iceOperatePlatform.interfaces.interfaceX.IceAppService;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lennon on 17/4/17.
 */
public class TestAppService extends BaseTestService{

    @Autowired
    private IceAppService iceAppService;

    @Test
    public void getApp() {
        Result result = iceAppService.getApp("6ff664da900c4967855cbc75b743bb01","83ed43c7330042beab2acc7cc8128127","988d7a7b94ab4d27b2eb62c784afe680", 1121);
        System.out.println(JSONObject.fromObject(result));
    }
}
