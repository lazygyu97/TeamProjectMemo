package com.company.Memo;

import java.util.HashMap;

public class MemoInsertOperation extends MemoAbstractOperation {
    @Override
    public HashMap operate(int index, String name, String password, String memo, String day) {


        Memo memo_form=new Memo(index,name,password,memo,day);
        Memo.memo_list.put(index,memo_form);
        System.out.println("여기까지옴");
        return  Memo.memo_list;
    }
}
