package com.iceOperatePlatform.interfaces.interfaceX;

import com.auth.dto.common.Result;
import com.shikonghulian.logicalhat.Param;

/**
 * Created by Lennon on 17/4/13.
 */
public interface IceInterfaceFieldService {
    Result getInterfaceField(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid,@Param("interface_id") int interface_id);

    Result batchUpdateInterfaceField(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("interface_id") int interface_id, @Param("vos") String vos);
}
