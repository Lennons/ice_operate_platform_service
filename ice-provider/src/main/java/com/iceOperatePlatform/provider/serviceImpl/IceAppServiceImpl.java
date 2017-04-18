package com.iceOperatePlatform.provider.serviceImpl;

import com.auth.dto.app.AddAppRequest;
import com.auth.dto.app.SearchAppRequest;
import com.auth.dto.app.UpdateAppRequest;
import com.auth.service.AppService;
import com.auth.dto.common.Result;
import com.auth.dto.app.CommonAppRequest;
import com.iceOperatePlatform.interfaces.interfaceX.IceAppService;
import com.iceOperatePlatform.provider.utils.Utils;
import com.shikonghulian.logicalhat.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lennon on 17/4/13.
 */
@Service
@Transactional
public class IceAppServiceImpl implements IceAppService {

    @Autowired
    private AppService appService;

    @Autowired
    private Utils utils;

    @Override
    public Result getApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonAppRequest commonAppRequest = new CommonAppRequest();
        commonAppRequest.setAccessToken(access_token);
        commonAppRequest.setAppId(app_id);
        Result result = appService.getApp(commonAppRequest);
        return result;
    }

    @Override
    public Result addApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("corp_id") int corp_id, @Param("name") String name, @Param("ip") String ip, @Param("url") String url, @Param("memo") String memo) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid, name);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        AddAppRequest addAppRequest = new AddAppRequest();
        addAppRequest.setAccessToken(access_token);
        addAppRequest.setCorpId(corp_id);
        addAppRequest.setName(name);
        addAppRequest.setIp(ip);
        addAppRequest.setUrl(url);
        addAppRequest.setMemo(memo);
        Result result = appService.addApp(addAppRequest);
        return result;
    }

    @Override
    public Result updateApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id, @Param("corp_id") int corp_id, @Param("name") String name, @Param("ip") String ip, @Param("url") String url, @Param("memo") String memo, @Param("status") byte status) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid, name);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        UpdateAppRequest updateAppRequest = new UpdateAppRequest();
        updateAppRequest.setAccessToken(access_token);
        updateAppRequest.setAppId(app_id);
        updateAppRequest.setCorpId(corp_id);
        updateAppRequest.setName(name);
        updateAppRequest.setIp(ip);
        updateAppRequest.setUrl(url);
        updateAppRequest.setMemo(memo);
        updateAppRequest.setStatus(status);
        Result result = appService.updateApp(updateAppRequest);
        return result;
    }

    @Override
    public Result forbidApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonAppRequest commonAppRequest = new CommonAppRequest();
        commonAppRequest.setAccessToken(access_token);
        commonAppRequest.setAppId(app_id);
        Result result = appService.forbidApp(commonAppRequest);
        return result;
    }

    @Override
    public Result recoverApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonAppRequest commonAppRequest = new CommonAppRequest();
        commonAppRequest.setAccessToken(access_token);
        commonAppRequest.setAppId(app_id);
        Result result = appService.recoverApp(commonAppRequest);
        return result;
    }

    @Override
    public Result refreshSecretApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonAppRequest commonAppRequest = new CommonAppRequest();
        commonAppRequest.setAccessToken(access_token);
        commonAppRequest.setAppId(app_id);
        Result result = appService.refreshSecret(commonAppRequest);
        return result;
    }

    @Override
    public Result getAppList(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id, @Param("search") String search, @Param("status") byte status, @Param("page_size") int page_size, @Param("page_num") int page_num) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        SearchAppRequest searchAppRequest = new SearchAppRequest();
        searchAppRequest.setAccessToken(access_token);
        searchAppRequest.setAppId(app_id);
        searchAppRequest.setSearch(search);
        searchAppRequest.setStatus(status);
        searchAppRequest.setPageNum(page_num);
        searchAppRequest.setPageSize(page_size);
        Result result = appService.searchApp(searchAppRequest);
        return result;
    }
}
