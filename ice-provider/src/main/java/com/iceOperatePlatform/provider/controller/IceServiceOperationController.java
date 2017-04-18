package com.iceOperatePlatform.provider.controller;

import com.auth.dto.common.Result;
import com.iceOperatePlatform.interfaces.interfaceX.IceServiceOperationService;
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
@Api(description = "微服务配置接口")
public class IceServiceOperationController {

    @Autowired
    private IceServiceOperationService iceServiceOperationService;

    @ApiOperation(value = "获取服务", notes = "JAVA类:com.auth.service.ServiceOperationService 函数签名:Result getService(CommonServiceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "service_id", value = "service_id", required = true, dataType = "int")
    })

    @RequestMapping(value = "/service", method = {RequestMethod.GET})
    @ResponseBody
    public Result getService(String app_uuid, String app_secret, String corp_uuid, int service_id) {
        Result result = iceServiceOperationService.getService(app_uuid, app_secret, corp_uuid, service_id);
        return result;
    }

    @ApiOperation(value = "添加服务", notes = "JAVA类:com.auth.service.ServiceOperationService 函数签名:Result addService(AddServiceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_id", value = "corp_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "name", value = "name", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "gateway", value = "gateway", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "version", value = "version", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "ip", value = "ip", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "memo", value = "memo", required = false, dataType = "String")
    })

    @RequestMapping(value = "/service", method = {RequestMethod.POST})
    @ResponseBody
    public Result addService(String app_uuid, String app_secret, String corp_uuid, int corp_id, String name, String gateway, int version, String ip, String memo) {
        Result result = iceServiceOperationService.addService(app_uuid, app_secret, corp_uuid, corp_id, name, gateway, version, ip, memo);
        return result;
    }

    @ApiOperation(value = "更新服务", notes = "JAVA类:com.auth.service.ServiceOperationService 函数签名:Result updateService(UpdateServiceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "service_id", value = "service_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "corp_id", value = "corp_id", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "name", value = "name", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "ip", value = "ip", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "url", value = "url", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "memo", value = "memo", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "status", value = "status", required = false, dataType = "byte"),
    })

    @RequestMapping(value = "/service", method = {RequestMethod.PUT})
    @ResponseBody
    public Result updateService(String app_uuid, String app_secret, String corp_uuid, int service_id, int corp_id, String name, String ip, String url, String memo, byte status) {
        Result result = iceServiceOperationService.updateService(app_uuid, app_secret, corp_uuid, service_id, corp_id, name, ip, url, memo, status);
        return result;
    }

    @ApiOperation(value = "禁用服务", notes = "JAVA类:com.auth.service.ServiceOperationService 函数签名:Result forbidService(CommonServiceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "service_id", value = "service_id", required = true, dataType = "int")
    })

    @RequestMapping(value = "/service/forbid", method = {RequestMethod.PUT})
    @ResponseBody
    public Result forbidService(String app_uuid, String app_secret, String corp_uuid, int service_id) {
        Result result = iceServiceOperationService.forbidService(app_uuid, app_secret, corp_uuid, service_id);
        return result;
    }

    @ApiOperation(value = "恢复服务", notes = "JAVA类:com.auth.service.ServiceOperationService 函数签名:Result recoverService(CommonServiceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "service_id", value = "service_id", required = true, dataType = "int")
    })

    @RequestMapping(value = "/service/recover", method = {RequestMethod.PUT})
    @ResponseBody
    public Result recoverService(String app_uuid, String app_secret, String corp_uuid, int service_id) {
        Result result = iceServiceOperationService.recoverService(app_uuid, app_secret, corp_uuid, service_id);
        return result;
    }

    @ApiOperation(value = "刷新服务Secret", notes = "JAVA类:com.auth.service.ServiceOperationService 函数签名:Result refreshSecret(CommonServiceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "service_id", value = "service_id", required = true, dataType = "int")
    })

    @RequestMapping(value = "/service/refreshSecret", method = {RequestMethod.PUT})
    @ResponseBody
    public Result refreshSecret(String app_uuid, String app_secret, String corp_uuid, int service_id) {
        Result result = iceServiceOperationService.refreshSecret(app_uuid, app_secret, corp_uuid, service_id);
        return result;
    }

    @ApiOperation(value = "搜索服务", notes = "JAVA类:com.auth.service.ServiceOperationService 函数签名:Result searchService(SearchServiceRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "corp_id", value = "corp_id", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "search", value = "search", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "status", required = false, dataType = "byte"),
            @ApiImplicitParam(paramType = "query", name = "page_size", value = "page_size", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "page_num", value = "page_num", required = false, dataType = "int")
    })

    @RequestMapping(value = "/service/search", method = {RequestMethod.GET})
    @ResponseBody
    public Result getServiceList(String app_uuid, String app_secret, String corp_uuid, int corp_id, String search, byte status, int page_size, int page_num) {
        Result result = iceServiceOperationService.getServiceList(app_uuid, app_secret, corp_uuid, corp_id, search, status, page_size, page_num);
        return result;
    }
}
