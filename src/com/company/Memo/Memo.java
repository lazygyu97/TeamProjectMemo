package com.company.Memo;

import java.util.HashMap;

//커밋을 위한 주석
public class Memo {

    //private getter setter ->
    //lombok-> 공부
    public MemoAbstractOperation operation;
    public Memo(MemoAbstractOperation operation){
        this.operation=operation;
    }

    public int index;
    public String name;
    public String password;
    public String memo;
    public String day;

    //쓰레드 세이프티 주의 ConcurrentHashMap
    public static HashMap<Integer,Memo> memo_list =new HashMap<>();

    public Memo(int index,String name, String password, String memo,String day){
        this.index=index;
        this.name=name;
        this.password=password;
        this.memo=memo;
        this.day=day;
    }


}
//이름 이랑 전화번호