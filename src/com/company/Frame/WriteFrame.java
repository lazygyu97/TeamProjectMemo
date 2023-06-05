package com.company.Frame;

import javax.swing.*;
import java.awt.*;

public class WriteFrame extends JFrame {

    private MainFrame main = new MainFrame();

    //메모장 입력화면
    public WriteFrame(){
        writeFrame();
    }

    private void writeFrame(){
        //시작화면 기본설정
        Element.writeFrame = new JFrame("메모장");
        Element.writeFrame.setSize(700,1000);
        Element.writeFrame.setLocationRelativeTo(null);
        Element.writeFrame.getContentPane().setLayout(null);
        Element.writeFrame.setResizable(false);

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

        Element.nameLabel=new JLabel("이름 :");
        Element.nameLabel.setBounds(150,263,39,19);
        Element.nameTxt=new JTextField();
        Element.nameTxt.setToolTipText("이름을 입력해주세요");
        Element.nameTxt.setBounds(200,250,215,45);

        Element.pwLabel=new JLabel("비밀번호 :");
        Element.pwLabel.setBounds(135,322,68,19);
        Element.pwTxt=new JTextField();
        Element.pwTxt.setToolTipText("비밀번호를 입력해주세요");
        Element.pwTxt.setBounds(200,310,215,45);

        Element.saveBtn= new JButton("저장");
        Element.saveBtn.setBounds(440,250,105,45);
        Element.saveBtn.setFont(new Font("고딕", Font.BOLD,16));
        Element.saveBtn.addActionListener(main);

        Element.cancleBtn= new JButton("취소");
        Element.cancleBtn.setBounds(440,310,105,45);
        Element.cancleBtn.setFont(new Font("고딕", Font.BOLD,16));
        Element.cancleBtn.addActionListener(main);

        Element.memoTxt= new JTextArea();
        Element.memoTxt.setBounds(90,400,520,490);
        Element.memoTxt.setLineWrap(true);

        Element.writeFrame.add(Element.logo);
        Element.writeFrame.add(Element.notice);
        Element.writeFrame.add(Element.nameLabel);
        Element.writeFrame.add(Element.nameTxt);
        Element.writeFrame.add(Element.pwLabel);
        Element.writeFrame.add(Element.pwTxt);
        Element.writeFrame.add(Element.saveBtn);
        Element.writeFrame.add(Element.cancleBtn);
        Element.writeFrame.add(Element.memoTxt);

        Element.writeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Element.writeFrame.setVisible(true);
    }
}
