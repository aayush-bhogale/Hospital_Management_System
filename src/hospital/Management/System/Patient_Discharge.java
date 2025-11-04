package hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Patient_Discharge extends JFrame {
    Patient_Discharge(){


        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        JLabel label = new JLabel("CHECK OUT");
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setBounds(100,20,150,20);
        panel.add(label);

        JLabel label2 = new JLabel("Customer Id");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        label2.setBounds(30,80,150,20);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.addItem(resultSet.getString("number"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room No.");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        label3.setBounds(30,130,150,20);
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        RNo.setForeground(Color.white);
        RNo.setBounds(200,130,150,20);
        panel.add(RNo);

        JLabel label4 = new JLabel("In Time");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.white);
        label4.setBounds(30,180,150,20);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        INTime.setForeground(Color.white);
        INTime.setBounds(200,180,250,20);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.white);
        label5.setBounds(30,230,150,20);
        panel.add(label5);

        Date date = new Date();

        JLabel OUTTime = new JLabel(""+date);
        OUTTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        OUTTime.setForeground(Color.white);
        OUTTime.setBounds(200,230,250,20);
        panel.add(OUTTime);

        JButton Discharge = new JButton("Discharge");
        Discharge.setFont(new Font("Tahoma", Font.BOLD, 14));
        Discharge.setForeground(Color.white);
        Discharge.setBackground(Color.BLACK);
        Discharge.setBounds(30,300,120,30);
        panel.add(Discharge);
        Discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    c.statement.executeUpdate("delete from patient_info where number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Avaliable = 'Availabil' where room_no ='"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Discharge Successful");
                    setVisible(false);

                } catch (Exception ex) {
                   ex.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setFont(new Font("Tahoma", Font.BOLD, 14));
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        check.setBounds(170,300,120,30);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    ResultSet resultSet=c.statement.executeQuery("select * from patient_info where number='"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        RNo.setText(resultSet.getString("Room_No"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }

            }


        });

        JButton back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(300,300,120,30);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }
    public static void main(String args[]){
        new Patient_Discharge();
    }
}
