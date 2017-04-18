package com.iceOperatePlatform.provider.controller;

import com.iceOperatePlatform.interfaces.interfaceX.IceAppService;
import com.auth.dto.common.Result;
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
 * Created by Lennon on 17/4/13.
 */

@RestController
@Api(description = "应用配置接口")
public class IceAppController {

    @Autowired
    private IceAppService iceAppService;

    @ApiOperation(value = "获取应用详细信息", notes = "JAVA类:com.auth.service.AppService 函数签名:Result getApp(CommonAppRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_id", value = "app_id", required = true, dataType = "int")
    })

    @RequestMapping(value = "/app", method = {RequestMethod.GET})
    @ResponseBody
    public Result getApp(String app_uuid, String app_secret, String corp_uuid, int app_id) {
        Result result = iceAppService.getApp(app_uuid, app_secret, corp_uuid, app_id);
        return result;
    }

    @ApiOperation(value = "添加应用", notes = "JAVA类:com.auth.service.AppService 函数签名:Result addApp(AddAppRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_id", value = "corp_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "name", value = "name", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "ip", value = "ip", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "url", value = "url", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "memo", value = "memo", required = false, dataType = "String")
    })

    @RequestMapping(value = "/app", method = {RequestMethod.POST})
    @ResponseBody
    public Result addApp(String app_uuid, String app_secret, String corp_uuid, int corp_id, String name, String ip, String url, String memo) {
        Result result = iceAppService.addApp(app_uuid, app_secret, corp_uuid, corp_id, name, ip, url, memo);
        return result;
    }

    @ApiOperation(value = "更新应用", notes = "JAVA类:com.auth.service.AppService 函数签名:Result updateApp(UpdateAppRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_id", value = "app_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "corp_id", value = "corp_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "name", value = "name", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "ip", value = "ip", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "url", value = "url", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "memo", value = "memo", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "status", value = "status", required = false, dataType = "byte")

    })

    @RequestMapping(value = "/app", method = {RequestMethod.PUT})
    @ResponseBody
    public Result updateApp(String app_uuid, String app_secret, String corp_uuid, int app_id, int corp_id, String name, String ip, String url, String memo, byte status) {
        Result result = iceAppService.updateApp(app_uuid, app_secret, corp_uuid, app_id, corp_id, name, ip, url, memo, status);
        return result;
    }

    @ApiOperation(value = "禁用应用", notes = "JAVA类:com.auth.service.AppService 函数签名:Result forbidApp(CommonAppRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_id", value = "app_id", required = true, dataType = "int")
    })

    @RequestMapping(value = "/app/forbid", method = {RequestMethod.PUT})
    @ResponseBody
    public Result forbidApp(String app_uuid, String app_secret, String corp_uuid, int app_id) {
        Result result = iceAppService.forbidApp(app_uuid, app_secret, corp_uuid, app_id);
        return result;
    }

    @ApiOperation(value = "恢复应用", notes = "JAVA类:com.auth.service.AppService 函数签名:Result recoverApp(CommonAppRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_id", value = "app_id", required = true, dataType = "int")
    })

    @RequestMapping(value = "/app/recover", method = {RequestMethod.PUT})
    @ResponseBody
    public Result recoverApp(String app_uuid, String app_secret, String corp_uuid, int app_id) {
        Result result = iceAppService.recoverApp(app_uuid, app_secret, corp_uuid, app_id);
        return result;
    }

    @ApiOperation(value = "刷新应用Secret", notes = "JAVA类:com.auth.service.AppService 函数签名:Result refreshSecret(CommonAppRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_id", value = "app_id", required = true, dataType = "int")
    })

    @RequestMapping(value = "/app/refreshSecret", method = {RequestMethod.PUT})
    @ResponseBody
    public Result refreshSecretApp(String app_uuid, String app_secret, String corp_uuid, int app_id) {
        Result result = iceAppService.refreshSecretApp(app_uuid, app_secret, corp_uuid, app_id);
        return result;
    }

    @ApiOperation(value = "获取应用列表", notes = "JAVA类:com.auth.service.AppService 函数签名:Result searchApp(SearchAppRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_id", value = "app_id", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "search", value = "search", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "status", required = false, dataType = "byte"),
            @ApiImplicitParam(paramType = "query", name = "page_size", value = "page_size", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "page_num", value = "page_num", required = false, dataType = "int")
    })

    @RequestMapping(value = "/app/search", method = {RequestMethod.GET})
    @ResponseBody
    public Result getAppList(String app_uuid, String app_secret, String corp_uuid, int app_id, String search, byte status, int page_size, int page_num) {
        Result result = iceAppService.getAppList(app_uuid, app_secret, corp_uuid, app_id, search, status, page_size, page_num);
        return result;
    }
}
