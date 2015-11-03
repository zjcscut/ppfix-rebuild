package com.ppfix.web.service.impl;

import com.ppfix.web.dao.UserInfoDAO;
import com.ppfix.web.model.UserInfo;
import com.ppfix.web.service.UserManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/11/3-15:26
 */
@Service("userManageServiceImpl")
public class UserManageServiceImpl implements UserManageService {

    @Resource
    private UserInfoDAO userInfoDAO;

    public  List<UserInfo>  getAll(){
        String hql="from UserInfo model";
        List<UserInfo> list= userInfoDAO.find(hql);
        return  list;
    }
}
