package com.company.Memo;

import java.util.HashMap;

//커밋을 위한 주석
public class Memo {

    private MemoAbstractOperation operation;
    public Memo(MemoAbstractOperation operation){
        this.operation=operation;
    }

    public int index; //글번호
    public String name;
    public String password;
    public String memo;
    public String day;

    private final HashMap<Integer,Memo> memoList =new HashMap<>();

    public HashMap<Integer,Memo> getMemoList() {
        return memoList;
    }

    public Memo() {}
    public Memo(int index,String name, String password, String memo,String day){
        this.index=index;
        this.name=name;
        this.password=password;
        this.memo=memo;
        this.day=day;
    }

    //Memo 인스턴스의 자료구조를 map 으로 설정
    public void addMemo(int index,String name, String password, String memo,String day){
        Memo memo_value =new Memo();
        memoList.put(index,memo_value);
    }
}
