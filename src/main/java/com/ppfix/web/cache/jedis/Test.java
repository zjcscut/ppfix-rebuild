package com.ppfix.web.cache.jedis;

import com.ppfix.web.cache.dao.Order;
import com.ppfix.web.cache.dao.OrderDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/10/30-11:42
 */
public class Test {

  public static void main(String[] args){
      ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:/jedis-config.xml");
      Order order=new Order();
      OrderDao orderDao= (OrderDao) ac.getBean("orderDao");
      order.setId("1");
      order.setOrderNo("no.1");
      order.setCreateDate(new Date());
      order.setPrice(0.11);
      orderDao.save(order);

      order= orderDao.read("1");
      System.out.println(order.getCreateDate());
 }

}
