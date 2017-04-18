package com.iceOperatePlatform.provider.controller;

import com.auth.dto.common.Result;
import com.iceOperatePlatform.interfaces.interfaceX.IceModuleService;
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
@Api(description = "微服务接口类目配置接口")
public class IceModuleController {

    @Autowired
    private IceModuleService iceModuleService;

    @ApiOperation(value = "添加服务接口类目", notes = "JAVA类:com.auth.service.ModuleService 函数签名:Result addMoudle(AddMoudleRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "service_id", value = "service_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "name", value = "name", required = true, dataType = "String")
    })

    @RequestMapping(value = "/module", method = {RequestMethod.POST})
    @ResponseBody
    public Result addModule(String app_uuid, String app_secret, String corp_uuid, int service_id, String name) {
        Result result = iceModuleService.addModule(app_uuid, app_secret, corp_uuid, service_id, name);
        return result;
    }

    @ApiOperation(value = "更新服务接口类目", notes = "JAVA类:com.auth.service.ModuleService 函数签名:Result updateMoudle(UpdateMoudleRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "module_id", value = "module_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "name", value = "name", required = true, dataType = "String")
    })

    @RequestMapping(value = "/module", method = {RequestMethod.PUT})
    @ResponseBody
    public Result updateModule(String app_uuid, String app_secret, String corp_uuid, int module_id, String name) {
        Result result = iceModuleService.updateModule(app_uuid, app_secret, corp_uuid, module_id, name);
        return result;
    }

    @ApiOperation(value = "禁用服务接口类目", notes = "JAVA类:com.auth.service.ModuleService 函数签名:Result forbidMoudle(CommonMoudleRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "module_id", value = "module_id", required = true, dataType = "int"),
    })

    @RequestMapping(value = "/module/forbid", method = {RequestMethod.PUT})
    @ResponseBody
    public Result forbidModule(String app_uuid, String app_secret, String corp_uuid, int module_id) {
        Result result = iceModuleService.forbidModule(app_uuid, app_secret, corp_uuid, module_id);
        return result;
    }

    @ApiOperation(value = "恢复服务接口类目", notes = "JAVA类:com.auth.service.ModuleService 函数签名:Result recoverMoudle(CommonMoudleRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "module_id", value = "module_id", required = true, dataType = "int"),
    })

    @RequestMapping(value = "/module/recover", method = {RequestMethod.PUT})
    @ResponseBody
    public Result recoverModule(String app_uuid, String app_secret, String corp_uuid, int module_id) {
        Result result = iceModuleService.recoverModule(app_uuid, app_secret, corp_uuid, module_id);
        return result;
    }

    @ApiOperation(value = "获取服务接口类目类别", notes = "JAVA类:com.auth.service.ModuleService 函数签名:Result searchMoudle(SearchMoudleRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "service_id", value = "service_id", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "search", value = "search", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "status", required = false, dataType = "byte"),
            @ApiImplicitParam(paramType = "query", name = "page_size", value = "page_size", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "page_num", value = "page_num", required = false, dataType = "int")
    })

    @RequestMapping(value = "/module/search", method = {RequestMethod.GET})
    @ResponseBody
    public Result getModuleList(String app_uuid, String app_secret, String corp_uuid, int service_id, String search, byte status, int page_size, int page_num) {
        Result result = iceModuleService.getModuleList(app_uuid, app_secret, corp_uuid, service_id, search, status, page_size, page_num);
        return result;
    }
}
