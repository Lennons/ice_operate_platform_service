package com.iceOperatePlatform.interfaces.interfaceX;

import com.auth.dto.common.Result;
import com.shikonghulian.logicalhat.Param;

/**
 * Created by Lennon on 17/4/13.
 */
public interface IceModuleService {
    Result addModule(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id, @Param("name") String name);

    Result updateModule(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("module_id") int module_id, @Param("name") String name);

    Result forbidModule(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("module_id") int module_id);

    Result recoverModule(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("module_id") int module_id);

    Result getModuleList(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id, @Param("search") String search, @Param("status") byte status, @Param("page_size") int page_size, @Param("page_num") int page_num);
}
