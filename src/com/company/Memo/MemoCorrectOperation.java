package com.company.Memo;

import java.util.ArrayList;
import java.util.HashMap;

import static com.company.Memo.Memo.memo_list;

public class MemoCorrectOperation extends MemoAbstractOperation{
    @Override
    public HashMap operate(int index, String name, String password, String memo, String day) {
        memo_list.replace(index,new Memo(index,name,password,memo,day));
        return memo_list;
    }

}
