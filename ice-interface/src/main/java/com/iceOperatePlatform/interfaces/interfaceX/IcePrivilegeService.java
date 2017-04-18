package com.iceOperatePlatform.interfaces.interfaceX;

import com.auth.dto.common.Result;
import com.shikonghulian.logicalhat.Param;

/**
 * Created by Lennon on 17/4/13.
 */
public interface IcePrivilegeService {
    Result updatePrivilege(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id, @Param("interface_id_list") String interface_id_list);

    Result getPrivilegeList(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id);
}
