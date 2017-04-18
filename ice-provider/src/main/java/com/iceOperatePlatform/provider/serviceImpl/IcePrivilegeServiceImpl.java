package com.iceOperatePlatform.provider.serviceImpl;

import com.auth.dto.common.Result;
import com.auth.dto.privilege.SearchPrivilegeRequest;
import com.auth.dto.privilege.UpdateAppPrivilegesRequest;
import com.auth.service.PrivilegeService;
import com.iceOperatePlatform.interfaces.interfaceX.IcePrivilegeService;
import com.iceOperatePlatform.provider.exception.CoreException;
import com.iceOperatePlatform.provider.utils.Utils;
import com.shikonghulian.logicalhat.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lennon on 17/4/13.
 */
@Service
@Transactional
public class IcePrivilegeServiceImpl implements IcePrivilegeService {

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private Utils utils;

    @Override
    public Result updatePrivilege(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id, @Param("interface_id_list") String interface_id_list) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid, interface_id_list);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        UpdateAppPrivilegesRequest updateAppPrivilegesRequest = new UpdateAppPrivilegesRequest();
        updateAppPrivilegesRequest.setAccessToken(access_token);
        updateAppPrivilegesRequest.setAppId(app_id);

        Set<Integer> idSet = new HashSet<>();
        String[] ids = interface_id_list.split(",");
        for (int i = 0; i < ids.length; i++) {
            String id = ids[i];
            for (int j = 0; j < id.length(); j++) {
                if (!Character.isDigit(id.charAt(j))) {
                    throw CoreException.of(CoreException.PARAMETER_INVALID);
                }
            }
            int num = Integer.parseInt(id);
            idSet.add(num);
        }
        updateAppPrivilegesRequest.setInterfaceIds(idSet);
        Result result = privilegeService.updateAppPrivilegeBatch(updateAppPrivilegesRequest);
        return result;
    }

    @Override
    public Result getPrivilegeList(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        SearchPrivilegeRequest searchPrivilegeRequest = new SearchPrivilegeRequest();
        searchPrivilegeRequest.setAccessToken(access_token);
        searchPrivilegeRequest.setAppId(app_id);
        Result result = privilegeService.searchPrivilege(searchPrivilegeRequest);
        return result;
    }
}
