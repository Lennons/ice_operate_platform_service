package com.iceOperatePlatform.interfaces.interfaceX;

import com.auth.dto.common.Result;
import com.shikonghulian.logicalhat.Param;

/**
 * Created by Lennon on 17/4/13.
 */
public interface IceAppService {
    Result getApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id);

    Result addApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("corp_id") int corp_id, @Param("name") String name, @Param("ip") String ip, @Param("url") String url, @Param("memo") String memo);

    Result updateApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id, @Param("corp_id") int corp_id, @Param("name") String name, @Param("ip") String ip, @Param("url") String url, @Param("memo") String memo, @Param("status") byte status);

    Result forbidApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id);

    Result recoverApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id);

    Result refreshSecretApp(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id);

    Result getAppList(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("app_id") int app_id, @Param("search") String search, @Param("status") byte status, @Param("page_size") int page_size, @Param("page_num") int page_num);
}
