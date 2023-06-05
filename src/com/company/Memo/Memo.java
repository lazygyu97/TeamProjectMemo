package com.company.Memo;

import java.util.HashMap;

//커밋을 위한 주석
public class Memo {

    private MemoAbstractOperation operation;
    public Memo(MemoAbstractOperation operation){
        this.operation=operation;
    }

    public int index;
    public String name;
    public String password;
    public String memo;
    public String day;

    public HashMap<Integer,Memo> memo_list =new HashMap<>();


    public Memo(int index,String name, String password, String memo,String day){
        this.index=index;
        this.name=name;
        this.password=password;
        this.memo=memo;
        this.day=day;
    }

    public Memo() {


    }


    public String Memo(int index,String name, String password, String memo,String day){
        String result="";
        Memo memo_value =new Memo(index,name,password,memo,day);
        memo_list.put(index,memo_value);
        return result;
    }

}
