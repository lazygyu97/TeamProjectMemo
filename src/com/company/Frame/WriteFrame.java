package com.company.Frame;

import com.company.Memo.Memo;
import com.company.Memo.MemoInsertOperation;
import com.company.Memo.MemoListOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteFrame extends JFrame implements ActionListener {

    int index=Memo.memo_list.size();
    Memo memoAdd= new Memo(new MemoInsertOperation());

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
        int qut_data;
        if (e.getSource()==Element.save_btn){

            String getName=Element.name_txt.getText();
            String getPassword=Element.pw_txt.getText();
            String getMemo=Element.memo_txt.getText();

            if(getMemo.isEmpty() || getName.isEmpty() || getPassword.isEmpty()){
                System.out.println("메모값이 없습니다.");
                JOptionPane.showMessageDialog(this, "이름,비밀번호,내용을 모두 입력해주세요.","저장 실패",JOptionPane.ERROR_MESSAGE);
            }else {

                qut_data = JOptionPane.showConfirmDialog(Element.write_frame, "저장하시겠습니까?","저장확인", JOptionPane.YES_NO_OPTION);
                if (qut_data==0){
                    index +=1;
                    Date today = new Date();
                    SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
                    SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
                    memoAdd.operation.operate(index,getName,getPassword,getMemo,date.format(today)+" "+time.format(today));
                    Element.name_txt.setText("");
                    Element.pw_txt.setText("");
                    Element.memo_txt.setText("");
                }else {
                    System.out.println("저장하지 않습니다.");
                }
            }

        }else if(e.getSource()==Element.cancle_btn){
            qut_data = JOptionPane.showConfirmDialog(Element.write_frame, "취소하시겠습니까?\n입력하신 내용이 모두 사라집니다.","취소", JOptionPane.YES_NO_OPTION);

            if (qut_data==0){
                Element.write_frame.dispose();
                Element.main_frame.setVisible(true);
            }
        }

    }
}
