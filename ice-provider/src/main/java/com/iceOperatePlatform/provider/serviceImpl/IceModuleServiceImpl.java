package com.iceOperatePlatform.provider.serviceImpl;

import com.auth.dto.common.Result;
import com.auth.dto.moudle.AddMoudleRequest;
import com.auth.dto.moudle.CommonMoudleRequest;
import com.auth.dto.moudle.SearchMoudleRequest;
import com.auth.dto.moudle.UpdateMoudleRequest;
import com.auth.service.ModuleService;
import com.iceOperatePlatform.interfaces.interfaceX.IceModuleService;
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
public class IceModuleServiceImpl implements IceModuleService {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private Utils utils;

    @Override
    public Result addModule(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id, @Param("name") String name) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid, name);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        AddMoudleRequest addMoudleRequest = new AddMoudleRequest();
        addMoudleRequest.setAccessToken(access_token);
        addMoudleRequest.setServiceId(service_id);
        addMoudleRequest.setName(name);
        Result result = moduleService.addMoudle(addMoudleRequest);
        return result;
    }

    @Override
    public Result updateModule(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("module_id") int module_id, @Param("name") String name) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid, name);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        UpdateMoudleRequest updateMoudleRequest = new UpdateMoudleRequest();
        updateMoudleRequest.setAccessToken(access_token);
        updateMoudleRequest.setModuleId(module_id);
        updateMoudleRequest.setName(name);
        Result result = moduleService.updateMoudle(updateMoudleRequest);
        return result;
    }

    @Override
    public Result forbidModule(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("module_id") int module_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonMoudleRequest commonMoudleRequest = new CommonMoudleRequest();
        commonMoudleRequest.setAccessToken(access_token);
        commonMoudleRequest.setModuleId(module_id);
        Result result = moduleService.forbidMoudle(commonMoudleRequest);
        return result;
    }

    @Override
    public Result recoverModule(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("module_id") int module_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        CommonMoudleRequest commonMoudleRequest = new CommonMoudleRequest();
        commonMoudleRequest.setAccessToken(access_token);
        commonMoudleRequest.setModuleId(module_id);
        Result result = moduleService.recoverMoudle(commonMoudleRequest);
        return result;
    }

    @Override
    public Result getModuleList(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id, @Param("search") String search, @Param("status") byte status, @Param("page_size") int page_size, @Param("page_num") int page_num) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        SearchMoudleRequest searchMoudleRequest = new SearchMoudleRequest();
        searchMoudleRequest.setAccessToken(access_token);
        searchMoudleRequest.setServiceId(service_id);
        searchMoudleRequest.setSearch(search);
        searchMoudleRequest.setStatus(status);
        searchMoudleRequest.setPageSize(page_size);
        searchMoudleRequest.setPageNum(page_num);
        Result result = moduleService.searchMoudle(searchMoudleRequest);
        return result;
    }
}
