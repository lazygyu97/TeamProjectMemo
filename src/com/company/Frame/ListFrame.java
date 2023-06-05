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

import static com.company.Frame.Element.*;

public class ListFrame extends JFrame implements ListSelectionListener, ActionListener {
    private final Memo memo = new Memo();

    public ListFrame(){
        listFrame();
    }

    private void listFrame(){

        //시작화면 기본설정
        listFrame = new JFrame("메모장");
        listFrame.setSize(700,1000);
        listFrame.setLocationRelativeTo(null);
        listFrame.getContentPane().setLayout(null);
        listFrame.setResizable(false);

        //제목
        logo=new JButton("메모장 목록");
        logo.setBounds(250,80,200,50);
        logo.setFont(new Font("고딕", Font.BOLD,30));
        logo.setBorderPainted(false);

        //설명
        notice=new JButton("글 번호를 통해 검색이 가능합니다.");
        notice.setBounds(195,170,305,24);
        notice.setFont(new Font("고딕", Font.BOLD,16));
        notice.setBorderPainted(false);


        numberLabel=new JLabel("글 번호 :");
        numberLabel.setBounds(136,263,58,19);
        numberTxt=new JTextField();
        numberTxt.setToolTipText("이름을 입력해주세요");
        numberTxt.setBounds(210,250,215,45);

        searchBtn= new JButton("검색");
        searchBtn.setBounds(440,250,105,45);
        searchBtn.setFont(new Font("고딕", Font.BOLD,16));
        searchBtn.addActionListener(this);

        setSampleData();

        listFrame.add(logo);
        listFrame.add(notice);
        listFrame.add(numberLabel);
        listFrame.add(numberTxt);

        listFrame.add(searchBtn);
        listFrame.add(memoList);

        listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listFrame.setVisible(true);
    }

    @Override
    //메서드가 두번 호출될 경우 내부 코드를 한번만 실행하기
    public void valueChanged(ListSelectionEvent e) {
        int selectedNum; //인스턴스 변수에서 지역변수로 바꿈

        if (!e.getValueIsAdjusting()) {
            JList source = (JList) e.getSource();
            if (source.getSelectedIndex() == -1) {
                // 선택이 되지 않은 경우
            } else {
                // 선택이 된 경우
                int num = source.getSelectedIndex();
                System.out.println(source.getSelectedValue().toString());
                System.out.println(selectedNum =num +1);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String qut_data;

        if(e.getSource()== searchBtn){
            //valueOf 메서드는 캐스팅을 추가로 해줘야 하므로 parseInt 메서드를 사용하는 것이 나음
            int num= Integer.parseInt(numberTxt.getText());
            System.out.println(num);
            System.out.println(memo.getMemoList().containsKey(num));
            int sd=Integer.parseInt(memo.getMemoList().get(num).password);
            System.out.println(sd);
            qut_data = JOptionPane.showInputDialog(listFrame, "비밀번호를 입력해주세요","");
            System.out.println(Integer.valueOf(qut_data));
            if(sd == Integer.parseInt(qut_data)){
                System.out.println("인증성공");
            }else {
                System.out.println("인증실패");
            }
        }
    }

    public void setSampleData(){

        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

        //list 에 더미 찍어두기
        Memo memo_1 =new Memo(1,"박현규","1205","이야 이게 담기네!1",date.format(today));
        Memo memo_2 =new Memo(2,"박현규","1205","이야 이게 담기네!2",date.format(today));
        Memo memo_3 =new Memo(3,"박현규","1205","이야 이게 담기네!3",date.format(today));
        memo.getMemoList().put(1,memo_1);
        memo.getMemoList().put(2,memo_2);
        memo.getMemoList().put(3,memo_3);


        memoList= new JList();
        memoList.setBounds(90,320,520,530);

        //DefaultListModel 클래스 : swing 에서 제공하는 JList 모델로, swing 은 컴포넌트에 데이터를 추가/삭제하기 위해서는 모델 필요하기 때문에 사용
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        //Entry : Map 에 키만 필요한 경우 사용
        for (Map.Entry<Integer, Memo> entry : memo.getMemoList().entrySet()) {
            int key = entry.getKey();
            Memo memo_li = entry.getValue();

            int index = memo_li.index;
            String name = memo_li.name;
            String password = memo_li.password;
            String memoContent = memo_li.memo;
            String day = memo_li.day;
            System.out.printf("Key is: %s, name  is : %s%n", entry.getKey(),name);
            listModel.addElement(index+".\t\t\t\t\t작성자 : "+name +"\t\t내용 : "+memoContent+"\t\t\t작성일 : "+day);
        }
        memoList.setModel(listModel);
        memoList.addListSelectionListener(this);
        memoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        memoList.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    }
}
