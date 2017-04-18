package com.iceOperatePlatform.provider.controller;

import com.auth.dto.common.Result;
import com.iceOperatePlatform.interfaces.interfaceX.IceInterfaceService;
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
public class IceInterfaceController {

    @Autowired
    private IceInterfaceService iceInterfaceService;

    @ApiOperation(value = "添加接口", notes = "JAVA类:com.auth.service.InterfaceService 函数签名:Result addInterface(AddInterfaceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "module_id", value = "module_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "service_id", value = "service_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "name", value = "name", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "url", value = "url", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "method", value = "method", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "memo", value = "memo", required = false, dataType = "String")
    })

    @RequestMapping(value = "/interface", method = {RequestMethod.POST})
    @ResponseBody
    public Result addInterface(String app_uuid, String app_secret, String corp_uuid, int module_id, int service_id, String name, String url, String method, String memo) {
        Result result = iceInterfaceService.addInterface(app_uuid, app_secret, corp_uuid, module_id, service_id, name, url, method, memo);
        return result;
    }

    @ApiOperation(value = "更新服务接口", notes = "JAVA类:com.auth.service.InterfaceService 函数签名:Result updateInterface(UpdateInterfaceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "interface_id", value = "interface_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "name", value = "name", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "url", value = "url", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "method", value = "method", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "memo", value = "memo", required = false, dataType = "String")
    })

    @RequestMapping(value = "/interface", method = {RequestMethod.PUT})
    @ResponseBody
    public Result updateInterface(String app_uuid, String app_secret, String corp_uuid, int interface_id, String name, String url, String method, String memo) {
        Result result = iceInterfaceService.updateInterface(app_uuid, app_secret, corp_uuid, interface_id, name, url, method, memo);
        return result;
    }

    @ApiOperation(value = "禁用服务接口", notes = "JAVA类:com.auth.service.InterfaceService 函数签名:Result forbidInterface(CommonInterfaceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "interface_id", value = "interface_id", required = true, dataType = "int"),
    })

    @RequestMapping(value = "/interface/forbid", method = {RequestMethod.PUT})
    @ResponseBody
    private Result forbidInterface(String app_uuid, String app_secret, String corp_uuid, int interface_id) {
        Result result = iceInterfaceService.forbidInterface(app_uuid, app_secret, corp_uuid, interface_id);
        return result;
    }

    @ApiOperation(value = "恢复服务接口", notes = "JAVA类:com.auth.service.InterfaceService 函数签名:Result recoverInterface(CommonInterfaceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "interface_id", value = "interface_id", required = true, dataType = "int"),
    })

    @RequestMapping(value = "/interface/recover", method = {RequestMethod.PUT})
    @ResponseBody
    public Result recoverInterface(String app_uuid, String app_secret, String corp_uuid, int interface_id) {
        Result result = iceInterfaceService.recoverInterface(app_uuid, app_secret, corp_uuid, interface_id);
        return result;
    }

    @ApiOperation(value = "获取服务接口列表", notes = "JAVA类:com.auth.service.InterfaceService 函数签名:Result searchInterface(SearchInterfaceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "module_id", value = "module_id", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "service_id", value = "service_id", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "search", value = "search", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "status", required = false, dataType = "byte"),
            @ApiImplicitParam(paramType = "query", name = "url", value = "url", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "method", value = "method", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page_size", value = "page_size", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "page_num", value = "page_num", required = false, dataType = "int")
    })

    @RequestMapping(value = "/interface/search", method = {RequestMethod.GET})
    @ResponseBody
    public Result getInterfaceList(String app_uuid, String app_secret, String corp_uuid,int service_id, int module_id, String search, byte status, String url, String method, int page_size, int page_num) {
        Result result = iceInterfaceService.getInterfaceList(app_uuid, app_secret, corp_uuid, service_id, module_id, search, status, url, method, page_size, page_num);
        return result;
    }
}
