package com.iceOperatePlatform.provider.controller;

import com.auth.dto.common.Result;
import com.iceOperatePlatform.interfaces.interfaceX.IcePrivilegeService;
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
@Api(description = "权限配置接口")
public class IcePrivilegeController {

    @Autowired
    private IcePrivilegeService icePrivilegeService;

    @ApiOperation(value = "更新应用微服务接口权限", notes = "JAVA类:com.auth.service.PrivilegeService 函数签名:Result updateAppPrivilegeBatch(UpdateAppPrivilegesRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "formData", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "formData", name = "app_id", value = "app_id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "formData", name = "interface_id_list", value = "interface_id_list", required = true, dataType = "String")
    })

    @RequestMapping(value = "/privilege", method = {RequestMethod.PUT})
    @ResponseBody
    public Result updatePrivilege(String app_uuid, String app_secret, String corp_uuid, int app_id, String interface_id_list) {
        Result result = icePrivilegeService.updatePrivilege(app_uuid, app_secret, corp_uuid, app_id, interface_id_list);
        return result;
    }

    @ApiOperation(value = "搜索权限列表", notes = "JAVA类:com.auth.service.PrivilegeService 函数签名:Result searchPrivilege(SearchPrivilegeRequest request)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "app_uuid", value = "app_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_secret", value = "app_secret", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "corp_uuid", value = "corp_uuid", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "app_id", value = "app_id", required = true, dataType = "int"),
    })

    @RequestMapping(value = "/privilege/search", method = {RequestMethod.GET})
    @ResponseBody
    public Result getPrivilegeList(String app_uuid, String app_secret, String corp_uuid, int app_id) {
        Result result = icePrivilegeService.getPrivilegeList(app_uuid, app_secret, corp_uuid, app_id);
        return result;
    }
}
