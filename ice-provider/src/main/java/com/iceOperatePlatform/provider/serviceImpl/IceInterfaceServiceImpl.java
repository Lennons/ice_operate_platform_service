package com.iceOperatePlatform.provider.serviceImpl;

import com.auth.dto.common.Result;
import com.auth.dto.interfaces.AddInterfaceRequest;
import com.auth.dto.interfaces.CommonInterfaceRequest;
import com.auth.dto.interfaces.SearchInterfaceRequest;
import com.auth.dto.interfaces.UpdateInterfaceRequest;
import com.auth.service.InterfaceService;
import com.iceOperatePlatform.interfaces.interfaceX.IceInterfaceService;
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
public class IceInterfaceServiceImpl implements IceInterfaceService {

    @Autowired
    private InterfaceService interfaceService;

    @Autowired
    private Utils utils;

    @Override
    public Result addInterface(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("module_id") int module_id, @Param("service_id") int service_id, @Param("name") String name, @Param("url") String url, @Param("method") String method, @Param("memo") String memo) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid, name, url, memo);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        AddInterfaceRequest addInterfaceRequest = new AddInterfaceRequest();
        addInterfaceRequest.setAccessToken(access_token);
        addInterfaceRequest.setModuleId(module_id);
        addInterfaceRequest.setServiceId(service_id);
        addInterfaceRequest.setName(name);
        addInterfaceRequest.setUrl(url);
        addInterfaceRequest.setMethod(method);
        addInterfaceRequest.setMemo(memo);
        Result result = interfaceService.addInterface(addInterfaceRequest);
        return result;
    }

    @Override
    public Result updateInterface(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("interface_id") int interface_id, @Param("name") String name, @Param("url") String url, @Param("method") String method, @Param("memo") String memo) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        UpdateInterfaceRequest updateInterfaceRequest = new UpdateInterfaceRequest();
        updateInterfaceRequest.setAccessToken(access_token);
        updateInterfaceRequest.setInterfaceId(interface_id);
        updateInterfaceRequest.setName(name);
        updateInterfaceRequest.setUrl(url);
        updateInterfaceRequest.setMethod(method);
        updateInterfaceRequest.setMemo(memo);
        Result result = interfaceService.updateInterface(updateInterfaceRequest);
        return result;
    }

    @Override
    public Result forbidInterface(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("interface_id") int interface_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonInterfaceRequest commonInterfaceRequest = new CommonInterfaceRequest();
        commonInterfaceRequest.setAccessToken(access_token);
        commonInterfaceRequest.setInterfaceId(interface_id);
        Result result = interfaceService.forbidInterface(commonInterfaceRequest);
        return result;
    }

    @Override
    public Result recoverInterface(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("interface_id") int interface_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonInterfaceRequest commonInterfaceRequest = new CommonInterfaceRequest();
        commonInterfaceRequest.setAccessToken(access_token);
        commonInterfaceRequest.setInterfaceId(interface_id);
        Result result = interfaceService.recoverInterface(commonInterfaceRequest);
        return result;
    }

    @Override
    public Result getInterfaceList(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id, @Param("module_id") int module_id, @Param("search") String search, @Param("status") byte status, @Param("url") String url, @Param("method") String method, @Param("page_size") int page_size, @Param("page_num") int page_num) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        SearchInterfaceRequest searchInterfaceRequest = new SearchInterfaceRequest();
        searchInterfaceRequest.setAccessToken(access_token);
        searchInterfaceRequest.setServiceId(service_id);
        searchInterfaceRequest.setModuleId(module_id);
        searchInterfaceRequest.setSearch(search);
        searchInterfaceRequest.setStatus(status);
        searchInterfaceRequest.setUrl(url);
        searchInterfaceRequest.setMethod(method);
        searchInterfaceRequest.setPageNum(page_num);
        searchInterfaceRequest.setPageSize(page_size);
        Result result = interfaceService.searchInterface(searchInterfaceRequest);
        return result;
    }
}
