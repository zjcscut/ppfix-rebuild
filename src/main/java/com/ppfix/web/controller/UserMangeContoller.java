package com.ppfix.web.controller;

import com.ppfix.web.model.UserInfo;
import com.ppfix.web.service.UserManageService;
import com.ppfix.web.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * created by IntelliJ IDEA
 * @description hibernate演示
 * @author zjc
 * @time 2015/11/3-15:25
 */
@Controller
public class UserMangeContoller {

    @Autowired
    private UserManageService userManageService;

    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    public String getAllUserInfo() {
        List<UserInfo> list = userManageService.getAll();
        return JsonUtils.toJson(list);
    }
}
