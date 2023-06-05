package com.company.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame implements ActionListener {


    public MainFrame() {
        mainFrame();
    }

    // 메모장 시작화면
    private void mainFrame(){

        //시작화면 기본설정
        Element.mainFrame = new JFrame("메모장");
        Element.mainFrame.setSize(700,1000);
        Element.mainFrame.setLocationRelativeTo(null);
        Element.mainFrame.getContentPane().setLayout(null);
        Element.mainFrame.setResizable(false);

        //제목
        Element.logo=new JButton("메모장 프로그램");
        Element.logo.setBounds(215,220,270,50);
        Element.logo.setFont(new Font("고딕", Font.BOLD,30));
        Element.logo.setBorderPainted(false);

        //메모장 입력 창으로 가는 버튼
        Element.writeBtn=new JButton("입력");
        Element.writeBtn.setBounds(180,350,340,100);
        Element.writeBtn.setFont(new Font("고딕", Font.BOLD,30));
        Element.writeBtn.addActionListener(this);

        //메모장 목록 창으로 가는 버튼
        Element.listBtn=new JButton("목록");
        Element.listBtn.setBounds(180,485,340,100);
        Element.listBtn.setFont(new Font("고딕", Font.BOLD,30));
        Element.listBtn.addActionListener(this);

        Element.mainFrame.add(Element.logo);
        Element.mainFrame.add(Element.writeBtn);
        Element.mainFrame.add(Element.listBtn);

        Element.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Element.mainFrame.setVisible(true);

    }

    //버튼 이벤트 감지 함수
    @Override
    public void actionPerformed(ActionEvent e) {

        int qut_data;

        if(e.getSource()==Element.writeBtn){
            Element.mainFrame.setVisible(false);
            Element.mainFrame.dispose();
            new WriteFrame();
        }else if(e.getSource()==Element.listBtn){
            Element.mainFrame.setVisible(false);
            Element.mainFrame.dispose();
            new ListFrame();
        }else if(e.getSource()==Element.saveBtn){
            qut_data = JOptionPane.showConfirmDialog(Element.writeFrame, "저장하시겠습니까?","저장확인", JOptionPane.YES_NO_OPTION);

        }else if(e.getSource()==Element.cancleBtn){
            qut_data = JOptionPane.showConfirmDialog(Element.writeFrame, "취소하시겠습니까?\n입력하신 내용이 모두 사라집니다.","취소", JOptionPane.YES_NO_OPTION);

            if (qut_data==0){
                Element.writeFrame.dispose();
                Element.mainFrame.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {

        //메모장 시작화면 실행
        new MainFrame();
    }
}