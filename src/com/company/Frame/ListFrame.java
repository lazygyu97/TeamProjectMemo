package com.company.Frame;

import com.company.Memo.Memo;
import com.company.Memo.MemoCorrectOperation;
import com.company.Memo.MemoDeleteOperation;
import com.company.Memo.MemoInsertOperation;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListFrame extends JFrame implements ListSelectionListener, ActionListener {

    Memo memoDelete= new Memo(new MemoDeleteOperation());
    Memo memoCorrect= new Memo(new MemoCorrectOperation());



    // SimpleDateFormat의 쓰레드 쪽 부분 검색 해보기
    Date today = new Date();
    SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
    String res_date= date.format(today)+time.format(today);

    @Override
    public void valueChanged(ListSelectionEvent e) {

        if (!e.getValueIsAdjusting()) {
            JList source = (JList) e.getSource();
            if (source.getSelectedIndex() == -1) {
                // 선택이 되지 않은 경우
                Element.selected_num.setText("없음");
            } else {
                // 선택이 된 경우
                int num =Integer.valueOf(source.getSelectedIndex())+1;
                Element.selected_num.setText(num+" 번");
                System.out.println(source.getSelectedValue().toString());

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String qut_data;


        if(e.getSource()==Element.search_btn){

            if (Element.number_txt.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "검색하실 글 번호를 입력해주세요.","글 검색 실패",JOptionPane.ERROR_MESSAGE);

            }else {
                int num= Integer.parseInt(Element.number_txt.getText());

                System.out.println(num);

                if(Memo.memo_list.containsKey(num)){
                    System.out.println(Memo.memo_list.get(num).password);

                    DefaultListModel listModel=new DefaultListModel();

                    for (Map.Entry<Integer, Memo> entry : Memo.memo_list.entrySet()) {
                        int key = entry.getKey();
                        Memo memo_li = entry.getValue();

                        int index = memo_li.index;
                        String name = memo_li.name;
                        String password = memo_li.password;
                        String memoContent = memo_li.memo;
                        String day = memo_li.day;

                        if (index == num){
                            System.out.println(String.format("Key is: %s, name  is : %s", key,name));
                            listModel.addElement(index+".\t작성자 : "+name +"\t\t\t\t\t\t\t\t\t\t내용 : "+memoContent.substring(0,7)+"...                 작성일 : "+day);
                        }
                    }

                    Element.number_txt.setText("");

                    Element.memo_list.setModel(listModel);
                    Element.memo_list.addListSelectionListener(this);
                    Element.memo_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    Element.memo_list.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

                }else {
                    JOptionPane.showMessageDialog(this, "입력하신 번호에 해당하는 글이 없습니다.\n확인후 다시 검색해주세요","글 검색",JOptionPane.ERROR_MESSAGE);
                    Element.number_txt.setText("");

                }
            }



        }else if(e.getSource()==Element.memo_edit){
            String res= (String) Element.memo_list.getSelectedValue();
            if(res!=null){

                int key=Integer.parseInt(res.substring(0,1));
                qut_data = JOptionPane.showInputDialog(Element.list_frame, "비밀번호를 입력해주세요","");
                if(qut_data==null){
                }else {
                String sd= Memo.memo_list.get(key).password;

                if(Integer.valueOf(sd) == Integer.valueOf(qut_data)){
                    JOptionPane.showMessageDialog(this, "비밀번호가 일치합니다.\n수정합니다.","비밀번호 확인",JOptionPane.PLAIN_MESSAGE);


                    qut_data = JOptionPane.showInputDialog(Element.list_frame, "글번호 "+Memo.memo_list.get(key).index+"번의 메모를 수정합니다.\n수정사항을 적어주세요","");
                    memoCorrect.operation.operate(key,Memo.memo_list.get(key).name,Memo.memo_list.get(key).password,qut_data,res_date);
                    SetListData();
                }else {
                    JOptionPane.showMessageDialog(this, "비밀번호가 다릅니다.\n수정 실패.","비밀번호 확인",JOptionPane.ERROR_MESSAGE);
                }
                }
            }else {
                JOptionPane.showMessageDialog(this, "글을 선택해주세요.","글선택",JOptionPane.ERROR_MESSAGE);

            }

        }
        else if(e.getSource() == Element.memo_delete){
            String res= (String) Element.memo_list.getSelectedValue();
            System.out.println("확인 : "+res);
            if(res!=null){
                int key=Integer.parseInt(res.substring(0,1));
                qut_data = JOptionPane.showInputDialog(Element.list_frame, "비밀번호를 입력해주세요","");
                String sd= Memo.memo_list.get(key).password;
                if(qut_data==null){
                }else {
                    if(Integer.valueOf(sd) == Integer.valueOf(qut_data)){
                        JOptionPane.showMessageDialog(this, "비밀번호가 일치합니다.\n삭제합니다.","삭제 성공",JOptionPane.PLAIN_MESSAGE);
                        memoDelete.operation.operate(key,Memo.memo_list.get(key).name,Memo.memo_list.get(key).password,qut_data,res_date);
                        SetListData();

                    }else {
                        JOptionPane.showMessageDialog(this, "비밀번호가 다릅니다.\n삭제실패","삭제 실패",JOptionPane.ERROR_MESSAGE);
                    }
                }

            }else {
                JOptionPane.showMessageDialog(this, "글을 선택해주세요.","글선택",JOptionPane.ERROR_MESSAGE);

            }


        }

        else if (e.getSource()==Element.back_btn){
            Element.list_frame.dispose();
            Element.main_frame.setVisible(true);
        }
    }

    public void SetListData(){


        DefaultListModel listModel=new DefaultListModel();

        for (Map.Entry<Integer, Memo> entry : Memo.memo_list.entrySet()) {
            int key = entry.getKey();
            Memo memo_li = entry.getValue();

            int index = memo_li.index;
            String name = memo_li.name;
            String password = memo_li.password;
            String memoContent = memo_li.memo;
            String day = memo_li.day;
            System.out.println(String.format("Key is: %s, name  is : %s", key,name));
            listModel.addElement(index+".\t작성자 : "+name +"\t\t\t\t\t\t\t\t\t\t내용 : "+memoContent.substring(0,7)+"...                 작성일 : "+day);
        }

        Element.memo_list.setModel(listModel);
        Element.memo_list.addListSelectionListener(this);
        Element.memo_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Element.memo_list.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));


    }

    public void ListFrame(){

        //시작화면 기본설정
        Element.list_frame = new JFrame("메모장");
        Element.list_frame.setSize(700,1000);
        Element.list_frame.setLocationRelativeTo(null);
        Element.list_frame.getContentPane().setLayout(null);
        Element.list_frame.setResizable(false);

        //제목
        Element.logo=new JButton("메모장 목록");
        Element.logo.setBounds(250,80,200,50);
        Element.logo.setFont(new Font("고딕", Font.BOLD,30));
        Element.logo.setBorderPainted(false);

        //설명
        Element.notice=new JButton("글 번호를 통해 검색이 가능합니다.");
        Element.notice.setBounds(195,170,305,24);
        Element.notice.setFont(new Font("고딕", Font.BOLD,16));
        Element.notice.setBorderPainted(false);


        Element.number_label=new JLabel("글 번호 :");
        Element.number_label.setBounds(150,240,58,19);
        Element.number_txt=new JTextField();
        Element.number_txt.setToolTipText("이름을 입력해주세요");
        Element.number_txt.setBounds(210,230,215,45);

        Element.search_btn= new JButton("검색");
        Element.search_btn.setBounds(440,230,105,45);
        Element.search_btn.setFont(new Font("고딕", Font.BOLD,16));
        Element.search_btn.addActionListener(this);

        Element.memo_list= new JList();
        Element.memo_list.setBounds(90,300,520,530);

        Element.selected_num_Label=new JLabel("선택된 글번호 :");
        Element.selected_num_Label.setBounds(205,845,110,20);
        Element.selected_num=new JLabel("없음");
        Element.selected_num.setBounds(325,845,50,20);

        Element.memo_edit=new JButton("수정");
        Element.memo_edit.setBounds(385,845,50,20);
        Element.memo_edit.addActionListener(this);

        Element.memo_delete=new JButton("삭제");
        Element.memo_delete.setBounds(445,845,50,20);
        Element.memo_delete.addActionListener(this);


        Element.back_btn=new JButton("홈으로");
        Element.back_btn.setBounds(297,880,100,45);
        Element.back_btn.addActionListener(this);

        SetListData();


        Element.list_frame.add(Element.logo);
        Element.list_frame.add(Element.notice);
        Element.list_frame.add(Element.number_label);
        Element.list_frame.add(Element.number_txt);

        Element.list_frame.add(Element.search_btn);
        Element.list_frame.add(Element.memo_list);


        Element.list_frame.add(Element.selected_num_Label);
        Element.list_frame.add(Element.selected_num);
        Element.list_frame.add(Element.memo_edit);
        Element.list_frame.add(Element.memo_delete);
        Element.list_frame.add(Element.back_btn);

        Element.list_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Element.list_frame.setVisible(true);



    }



}
