package com.serrvice;

import com.mapper.accountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class Service {

    @Autowired
    private accountMapper account;


    //注解方式的事务管理
    /**

     *@Transactional中的的属性
     *propagation	:事务的传播行为
     *isolation		:事务的隔离级别
     *readOnly		:只读
     *rollbackFor	:发生哪些异常回滚
     *noRollbackFor	:发生哪些异常不回滚
     *rollbackForClassName 根据异常类名回滚
     */
    @Transactional(rollbackFor = Exception.class)
    public void transfer( String in, String out,double money) throws Exception{
            double In = account.selectByName(in).getMoney();
            double total = In + money;
            account.In(in, total);
            double Out = account.selectByName(out).getMoney();
            total = Out - money;
            account.Out(out, total);
    }

}
