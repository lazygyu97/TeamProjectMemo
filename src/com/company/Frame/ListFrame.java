package com.company.Frame;

import com.company.Memo.Memo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class ListFrame extends JFrame implements ListSelectionListener, ActionListener {

    int selected_num;
    MainFrame main = new MainFrame();
    Memo memo=new Memo();


    @Override
    public void valueChanged(ListSelectionEvent e) {

        if (!e.getValueIsAdjusting()) {
            JList source = (JList) e.getSource();
            if (source.getSelectedIndex() == -1) {
                // 선택이 되지 않은 경우
            } else {
                // 선택이 된 경우
                int num =Integer.valueOf(source.getSelectedIndex());
                System.out.println(source.getSelectedValue().toString());
                System.out.println(selected_num=num +1);

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String qut_data;

        if(e.getSource()==Element.search_btn){
            int num= Integer.valueOf(Element.number_txt.getText());
            System.out.println(num);
            System.out.println(memo.memo_list.containsKey(num));
            int sd=Integer.valueOf(memo.memo_list.get(num).password);
            System.out.println(sd);
            qut_data = JOptionPane.showInputDialog(Element.list_frame, "비밀번호를 입력해주세요","");
            System.out.println(Integer.valueOf(qut_data));
            if(sd == Integer.valueOf(qut_data)){
                System.out.println("인증성공");
            }else {
                System.out.println("인증 실패");
            }
        }
    }

    public void SetSampleData(){

        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
        Memo memo_1 =new Memo(1,"박현규","1205","이야 이게 담기네!1",date.format(today));
        Memo memo_2 =new Memo(2,"박현규","1205","이야 이게 담기네!2",date.format(today));
        Memo memo_3 =new Memo(3,"박현규","1205","이야 이게 담기네!3",date.format(today));
        memo.memo_list.put(1,memo_1);
        memo.memo_list.put(2,memo_2);
        memo.memo_list.put(3,memo_3);


        Element.memo_list= new JList();
        Element.memo_list.setBounds(90,320,520,530);
        DefaultListModel listModel=new DefaultListModel();
        for (Map.Entry<Integer, Memo> entry : memo.memo_list.entrySet()) {
            int key = entry.getKey();
            Memo memo_li = entry.getValue();

            int index = memo_li.index;
            String name = memo_li.name;
            String password = memo_li.password;
            String memoContent = memo_li.memo;
            String day = memo_li.day;
            System.out.println(String.format("Key is: %s, name  is : %s", entry.getKey(),name));
            listModel.addElement(index+".\t\t\t\t\t작성자 : "+name +"\t\t내용 : "+memoContent+"\t\t\t작성일 : "+day);
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
        Element.number_label.setBounds(136,263,58,19);
        Element.number_txt=new JTextField();
        Element.number_txt.setToolTipText("이름을 입력해주세요");
        Element.number_txt.setBounds(210,250,215,45);

        Element.search_btn= new JButton("검색");
        Element.search_btn.setBounds(440,250,105,45);
        Element.search_btn.setFont(new Font("고딕", Font.BOLD,16));
        Element.search_btn.addActionListener(this);


        SetSampleData();


        Element.list_frame.add(Element.logo);
        Element.list_frame.add(Element.notice);
        Element.list_frame.add(Element.number_label);
        Element.list_frame.add(Element.number_txt);

        Element.list_frame.add(Element.search_btn);
        Element.list_frame.add(Element.memo_list);

        Element.list_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Element.list_frame.setVisible(true);



    }



}
