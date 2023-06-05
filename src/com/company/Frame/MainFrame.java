package com.company.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame implements ActionListener {


    // 메모장 시작화면
    public MainFrame() {

        //시작화면 기본설정
        Element.main_frame = new JFrame("메모장");
        Element.main_frame.setSize(700,1000);
        Element.main_frame.setLocationRelativeTo(null);
        Element.main_frame.getContentPane().setLayout(null);
        Element.main_frame.setResizable(false);

        //제목
        Element.logo=new JButton("메모장 프로그램");
        Element.logo.setBounds(215,220,270,50);
        Element.logo.setFont(new Font("고딕", Font.BOLD,30));
        Element.logo.setBorderPainted(false);

        //메모장 입력 창으로 가는 버튼
        Element.write_btn=new JButton("입력");
        Element.write_btn.setBounds(180,350,340,100);
        Element.write_btn.setFont(new Font("고딕", Font.BOLD,30));
        Element.write_btn.addActionListener(this);

        //메모장 목록 창으로 가는 버튼
        Element.list_btn=new JButton("목록");
        Element.list_btn.setBounds(180,485,340,100);
        Element.list_btn.setFont(new Font("고딕", Font.BOLD,30));
        Element.list_btn.addActionListener(this);

        Element.main_frame.add(Element.logo);
        Element.main_frame.add(Element.write_btn);
        Element.main_frame.add(Element.list_btn);

        Element.main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Element.main_frame.setVisible(true);

    }

    //버튼 이벤트 감지 함수
    @Override
    public void actionPerformed(ActionEvent e) {

        int qut_data;

        if(e.getSource()==Element.write_btn){
            Element.main_frame.setVisible(false);
            Element.main_frame.dispose();
            new WriteFrame().WriteFrame();
        }else if(e.getSource()==Element.list_btn){
            Element.main_frame.setVisible(false);
            Element.main_frame.dispose();
            new ListFrame().ListFrame();
        }else if(e.getSource()==Element.save_btn){
            qut_data = JOptionPane.showConfirmDialog(Element.write_frame, "저장하시겠습니까?","저장확인", JOptionPane.YES_NO_OPTION);

        }else if(e.getSource()==Element.cancle_btn){
            qut_data = JOptionPane.showConfirmDialog(Element.write_frame, "취소하시겠습니까?\n입력하신 내용이 모두 사라집니다.","취소", JOptionPane.YES_NO_OPTION);

            if (qut_data==0){
                Element.write_frame.dispose();
                Element.main_frame.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {

        //메모장 시작화면 실행
        new MainFrame();

    }

}