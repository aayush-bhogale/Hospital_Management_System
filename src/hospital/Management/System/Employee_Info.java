package hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_Info extends javax.swing.JFrame {

    Employee_Info(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            conn c= new conn();
            String query="select * from EMP_INFO";
            ResultSet resultSet = conn.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
           e.printStackTrace();
        }

        JLabel label1=new JLabel("Name");
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setBounds(41,9,70,20);
        panel.add(label1);

        JLabel label2=new JLabel("Age");
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setBounds(185,9,70,20);
        panel.add(label2);

        JLabel label3=new JLabel("Phone No.");
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setBounds(350,9,150,20);
        panel.add(label3);

        JLabel label4=new JLabel("Salary");
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setBounds(550,9,150,20);
        panel.add(label4);

        JLabel label5=new JLabel("Gmail");
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setBounds(700,9,150,20);
        panel.add(label5);

        JLabel label6=new JLabel("Aadhar No");
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setBounds(830,9,150,20);
        panel.add(label6);

        JButton button=new JButton("Back");
        button.setBackground(Color.BLACK);
        button.setBounds(350,500,120,30);
        button.setFont(new Font("Tahoma",Font.BOLD,14));
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(500*2,600);
        setLocation(350,230);
        setLayout(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Employee_Info();
    }
}
