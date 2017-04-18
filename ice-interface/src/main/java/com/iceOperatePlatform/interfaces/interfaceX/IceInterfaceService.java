package com.iceOperatePlatform.interfaces.interfaceX;

import com.auth.dto.common.Result;
import com.shikonghulian.logicalhat.Param;

/**
 * Created by Lennon on 17/4/13.
 */
public interface IceInterfaceService {
    Result addInterface(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("module_id") int module_id, @Param("service_id") int service_id, @Param("name") String name, @Param("url") String url, @Param("method") String method, @Param("memo") String memo);

    Result updateInterface(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("interface_id") int interface_id, @Param("name") String name, @Param("url") String url, @Param("method") String method, @Param("memo") String memo);

    Result forbidInterface(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("interface_id") int interface_id);

    Result recoverInterface(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("interface_id") int interface_id);

    Result getInterfaceList(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id, @Param("module_id") int module_id, @Param("search") String search, @Param("status") byte status, @Param("url") String url, @Param("method") String method, @Param("page_size") int page_size, @Param("page_num") int page_num);
}
