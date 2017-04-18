package com.iceOperatePlatform.provider.serviceImpl;

import com.auth.dto.common.Result;
import com.auth.dto.interfaceField.GetInterfaceFieldsRequest;
import com.auth.dto.interfaceField.UpdateInterfaceFieldRequest;
import com.auth.dto.interfaceField.UpdateInterfaceFieldRequestField;
import com.auth.service.InterfaceFieldService;
import com.iceOperatePlatform.interfaces.interfaceX.IceInterfaceFieldService;
import com.iceOperatePlatform.provider.utils.Utils;
import com.shikonghulian.logicalhat.Param;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lennon on 17/4/13.
 */
@Service
@Transactional
public class IceInterfaceFieldServiceImpl implements IceInterfaceFieldService {

    @Autowired
    private InterfaceFieldService interfaceFieldService;

    @Autowired
    private Utils utils;

    @Override
    public Result getInterfaceField(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("interface_id") int interface_id) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        GetInterfaceFieldsRequest getInterfaceFieldsRequest = new GetInterfaceFieldsRequest();
        getInterfaceFieldsRequest.setAccessToken(access_token);
        getInterfaceFieldsRequest.setInterfaceId(interface_id);
        Result result = interfaceFieldService.getInterfaceFields(getInterfaceFieldsRequest);
        return result;
    }

    @Override
    public Result batchUpdateInterfaceField(@Param("app_uuid") String app_uuid, @Param("app_secret") String app_secret, @Param("corp_uuid") String corp_uuid, @Param("interface_id") int interface_id, @Param("vos") String vos) {
        Utils.verifyParams(app_uuid, app_secret, corp_uuid, vos);
        String access_token = utils.getAccessToken(app_uuid, app_secret, corp_uuid);
        System.out.println("access_token:" + access_token);

        UpdateInterfaceFieldRequest updateInterfaceFieldRequest = new UpdateInterfaceFieldRequest();
        updateInterfaceFieldRequest.setAccessToken(access_token);
        updateInterfaceFieldRequest.setInterfaceId(interface_id);

        JSONArray jsonArray = JSONArray.fromObject(vos);
        List<UpdateInterfaceFieldRequestField> fieldList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String dataType = jsonObject.getString("data_type");
            String requestMode = jsonObject.getString("request_mode");
            String required = jsonObject.getString("required");
            String defaultValue = jsonObject.getString("default_value");
            String parameter = jsonObject.getString("parameter");
            String fieldDesc = jsonObject.getString("field_desc");

            UpdateInterfaceFieldRequestField field = new UpdateInterfaceFieldRequestField();
            field.setDataType(dataType);
            field.setRequestMode(requestMode);
            field.setRequired(required);
            field.setDefaultValue(defaultValue);
            field.setParameter(parameter);
            field.setFieldDesc(fieldDesc);
            fieldList.add(field);
        }

        updateInterfaceFieldRequest.setFields(fieldList);
        Result result = interfaceFieldService.updateInterfaceFieldBatch(updateInterfaceFieldRequest);
        return result;
    }
}
