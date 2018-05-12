package com.serrvice;

import com.mapper.accountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class accountService {

    @Autowired
    private accountMapper account;

    @Autowired
    private TransactionTemplate transactionTemplate;

    //编程式事务管理
    public void transfer(final String in,final String out,final double money){
        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus status) {
                    try {
                        double In = account.selectByName(in).getMoney();
                        double total = In + money;
                        account.In(in, total);
                        int i=1/0;
                      double Out = account.selectByName(out).getMoney();
                        total = Out - money;
                        account.Out(out, total);
                    }
                    catch (Exception e) {

                        status.setRollbackOnly();

                        e.printStackTrace();

                        return false;

                    }
                    return true;
              }});
    }
}
