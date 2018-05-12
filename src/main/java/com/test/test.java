package com.test;

import com.serrvice.Service;
import com.serrvice.accountService;
import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableServer.Servant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//        //编程式的事务管理
//        accountService accountService=(accountService)applicationContext.getBean("account");
//        accountService.transfer("aaa","bbb",22.00);
          Service service=(Service)applicationContext.getBean("service");
          try {
              service.transfer("aaa", "bbb", 20.5);
          }catch (Exception e){
              System.out.println(e.getMessage());
          }
    }
}
