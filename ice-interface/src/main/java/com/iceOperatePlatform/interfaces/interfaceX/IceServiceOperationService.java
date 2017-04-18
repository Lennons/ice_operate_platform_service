package com.iceOperatePlatform.interfaces.interfaceX;

import com.auth.dto.common.Result;
import com.shikonghulian.logicalhat.Param;

/**
 * Created by Lennon on 17/4/13.
 */
public interface IceServiceOperationService {
    Result getService(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id);

    Result addService(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("corp_id") int corp_id, @Param("name") String name, @Param("gateway") String gateway, @Param("version") int version, @Param("ip") String ip, @Param("memo") String memo);

    Result updateService(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id, @Param("corp_id") int corp_id, @Param("name") String name, @Param("ip") String ip, @Param("url") String url, @Param("memo") String memo, @Param("status") byte status);

    Result forbidService(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id);

    Result recoverService(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id);

    Result refreshSecret(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("service_id") int service_id);

    Result getServiceList(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("corp_id") int corp_id, @Param("search") String search, @Param("status") byte status, @Param("page_size") int page_size, @Param("page_num") int page_num);
}
