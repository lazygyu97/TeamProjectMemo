package com.company.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteFrame extends JFrame implements ActionListener {

    MainFrame main = new MainFrame();

    //메모장 입력화면
    public void WriteFrame(){

        //시작화면 기본설정
        Element.write_frame = new JFrame("메모장");
        Element.write_frame.setSize(700,1000);
        Element.write_frame.setLocationRelativeTo(null);
        Element.write_frame.getContentPane().setLayout(null);
        Element.write_frame.setResizable(false);

        //제목
        Element.logo=new JButton("메모장 입력");
        Element.logo.setBounds(250,80,200,50);
        Element.logo.setFont(new Font("고딕", Font.BOLD,30));
        Element.logo.setBorderPainted(false);

        //설명
        Element.notice=new JButton("이름, 비밀번호, 내용을 입력해주세요");
        Element.notice.setBounds(195,170,305,24);
        Element.notice.setFont(new Font("고딕", Font.BOLD,16));
        Element.notice.setBorderPainted(false);

        Element.name_label=new JLabel("이름 :");
        Element.name_label.setBounds(150,263,39,19);
        Element.name_txt=new JTextField();
        Element.name_txt.setToolTipText("이름을 입력해주세요");
        Element.name_txt.setBounds(200,250,215,45);

        Element.pw_label=new JLabel("비밀번호 :");
        Element.pw_label.setBounds(135,322,68,19);
        Element.pw_txt=new JTextField();
        Element.pw_txt.setToolTipText("비밀번호를 입력해주세요");
        Element.pw_txt.setBounds(200,310,215,45);

        Element.save_btn= new JButton("저장");
        Element.save_btn.setBounds(440,250,105,45);
        Element.save_btn.setFont(new Font("고딕", Font.BOLD,16));
        Element.save_btn.addActionListener(this);

        Element.cancle_btn= new JButton("취소");
        Element.cancle_btn.setBounds(440,310,105,45);
        Element.cancle_btn.setFont(new Font("고딕", Font.BOLD,16));
        Element.cancle_btn.addActionListener(this);

        Element.memo_txt= new JTextArea();
        Element.memo_txt.setBounds(90,400,520,490);
        Element.memo_txt.setLineWrap(true);

        Element.write_frame.add(Element.logo);
        Element.write_frame.add(Element.notice);
        Element.write_frame.add(Element.name_label);
        Element.write_frame.add(Element.name_txt);
        Element.write_frame.add(Element.pw_label);
        Element.write_frame.add(Element.pw_txt);
        Element.write_frame.add(Element.save_btn);
        Element.write_frame.add(Element.cancle_btn);
        Element.write_frame.add(Element.memo_txt);

        Element.write_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Element.write_frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd 'at' HH:mm:ss z");

        if(e.getSource()==Element.save_btn){
            int qut_data = JOptionPane.showConfirmDialog(Element.write_frame, "저장 하실래요?", "저장확인", JOptionPane.YES_NO_OPTION);

            if (qut_data == 0){
                String getName = Element.name_txt.getText();
                String getPassword = Element.pw_txt.getText();
                String getMemo = Element.memo_txt.getText();
                System.out.println(getName);
                System.out.println(getPassword);
                System.out.println(getMemo);
                System.out.println(date.format(today));

            }


       }

    }

}
