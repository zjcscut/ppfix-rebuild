package com.ppfix.web.test;



import com.ppfix.web.dao.UserInfoDAO;
import com.ppfix.web.model.UserInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/10/30-17:26
 */
@Transactional
public class HibernateTest {

    public static void main(String[] args) {
        ApplicationContext ac= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserInfoDAO userInfoDAO=(UserInfoDAO )ac.getBean("userInfoDAO");
        UserInfo u=new UserInfo();
        u.setUsername("ppfix");
        u.setPassword("1111111111111111111");
        userInfoDAO.save(u);

       Map<String , Object> param = new HashMap<>();
        param.put("username","ppfix");
        u=userInfoDAO.find("from UserInfo model where model.username=:username",param).get(0);

        System.out.println(u.getPassword());
    }


}
