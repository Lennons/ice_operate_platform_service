package com.iceOperatePlatform.provider.serviceImpl;

import com.auth.dto.common.Result;
import com.auth.dto.service.AddServiceRequest;
import com.auth.dto.service.CommonServiceRequest;
import com.auth.dto.service.SearchServiceRequest;
import com.auth.dto.service.UpdateServiceRequest;
import com.auth.service.ServiceOperationService;
import com.iceOperatePlatform.interfaces.interfaceX.IceServiceOperationService;
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
public class IceServiceOperationServiceImp implements IceServiceOperationService {

    @Autowired
    private ServiceOperationService serviceOperationService;

    @Autowired
    private Utils utils;

    @Override
    public Result getService(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonServiceRequest commonServiceRequest = new CommonServiceRequest();
        commonServiceRequest.setAccessToken(access_token);
        commonServiceRequest.setServiceId(service_id);
        Result result = serviceOperationService.getService(commonServiceRequest);
        return result;
    }

    @Override
    public Result addService(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("corp_id") int corp_id, @Param("name") String name, @Param("gateway") String gateway, @Param("version") int version, @Param("ip") String ip, @Param("memo") String memo) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid, name, gateway);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        AddServiceRequest addServiceRequest = new AddServiceRequest();
        addServiceRequest.setAccessToken(access_token);
        addServiceRequest.setCorpId(corp_id);
        addServiceRequest.setName(name);
        addServiceRequest.setGateway(gateway);
        addServiceRequest.setVersion(version);
        addServiceRequest.setIp(ip);
        addServiceRequest.setMemo(memo);
        Result result = serviceOperationService.addService(addServiceRequest);
        return result;
    }

    @Override
    public Result updateService(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id, @Param("corp_id") int corp_id, @Param("name") String name, @Param("ip") String ip, @Param("url") String url, @Param("memo") String memo, @Param("status") byte status) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        UpdateServiceRequest updateServiceRequest = new UpdateServiceRequest();
        updateServiceRequest.setAccessToken(access_token);
        updateServiceRequest.setServiceId(service_id);
        updateServiceRequest.setCorpId(corp_id);
        updateServiceRequest.setName(name);
        updateServiceRequest.setIp(ip);
        updateServiceRequest.setUrl(url);
        updateServiceRequest.setMemo(memo);
        updateServiceRequest.setStatus(status);
        Result result = serviceOperationService.updateService(updateServiceRequest);
        return result;
    }

    @Override
    public Result forbidService(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonServiceRequest commonServiceRequest = new CommonServiceRequest();
        commonServiceRequest.setAccessToken(access_token);
        commonServiceRequest.setServiceId(service_id);
        Result result = serviceOperationService.forbidService(commonServiceRequest);
        return result;
    }

    @Override
    public Result recoverService(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonServiceRequest commonServiceRequest = new CommonServiceRequest();
        commonServiceRequest.setAccessToken(access_token);
        commonServiceRequest.setServiceId(service_id);
        Result result = serviceOperationService.recoverService(commonServiceRequest);
        return result;
    }

    @Override
    public Result refreshSecret(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonServiceRequest commonServiceRequest = new CommonServiceRequest();
        commonServiceRequest.setAccessToken(access_token);
        commonServiceRequest.setServiceId(service_id);
        Result result = serviceOperationService.refreshSecret(commonServiceRequest);
        return result;
    }

    @Override
    public Result getServiceList(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("corp_id") int corp_id, @Param("search") String search, @Param("status") byte status, @Param("page_size") int page_size, @Param("page_num") int page_num) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        SearchServiceRequest searchServiceRequest = new SearchServiceRequest();
        searchServiceRequest.setAccessToken(access_token);
        searchServiceRequest.setCorpId(corp_id);
        searchServiceRequest.setSearch(search);
        searchServiceRequest.setStatus(status);
        searchServiceRequest.setPageNum(page_num);
        searchServiceRequest.setPageSize(page_size);
        Result result = serviceOperationService.searchService(searchServiceRequest);
        return result;
    }
}
