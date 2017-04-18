package com.iceOperatePlatform.provider.controller;

import com.auth.dto.common.Result;
import com.iceOperatePlatform.interfaces.interfaceX.IceInterfaceFieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lennon on 17/4/14.
 */
@RestController
@Api(description = "微服务接口配置接口")
public class IceInterfaceFieldController {

    @Autowired
    private IceInterfaceFieldService iceInterfaceFieldService;

    @ApiOperation(value = "获取服务接口所有参数", notes = "JAVA类:com.auth.service.InterfaceFieldService 函数签名:Result updateInterfaceFieldBatch(UpdateInterfaceFieldRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "interface_id", value = "interface_id", required = true, dataType = "int")
    })

    @RequestMapping(value = "/interface/field", method = {RequestMethod.GET})
    @ResponseBody
    public Result getInterfaceField(String app_uuid, String app_secret, String corp_uuid,int interface_id) {
        Result result = iceInterfaceFieldService.getInterfaceField(app_uuid, app_secret, corp_uuid, interface_id);
        return result;
    }

    @ApiOperation(value = "批量更新服务接口参数", notes = "JAVA类:com.auth.service.InterfaceFieldService 函数签名:Result updateInterfaceFieldBatch(UpdateInterfaceFieldRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "interface_id", value = "interface_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "body", name = "vos", value = "vos", required = true, dataType = "String")
    })

    @RequestMapping(value = "/interface/field/batch", method = {RequestMethod.POST})
    @ResponseBody
    public Result batchUpdateInterfaceField(String app_uuid, String app_secret, String corp_uuid, int interface_id, String vos) {
        Result result = iceInterfaceFieldService.batchUpdateInterfaceField(app_uuid, app_secret, corp_uuid, interface_id, vos);
        return result;
    }
}
