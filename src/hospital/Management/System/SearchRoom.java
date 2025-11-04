package hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchRoom extends javax.swing.JFrame {
    Choice choice ;
    JTable table;

    SearchRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        JLabel sfr = new JLabel("Search For Room");
        sfr.setBounds(250,11,186,31);
        sfr.setForeground(Color.WHITE);
        sfr.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(sfr);

        JLabel status = new JLabel("Status");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Availabil");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90, 156, 163));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conn con = new conn();
            String query = "select * from room";
            ResultSet rs= con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel roomNo = new JLabel("Room Number");
        roomNo.setBounds(23,162,150,20);
        roomNo.setForeground(Color.WHITE);
        roomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomNo);

        JLabel avaliable = new JLabel("Availability");
        roomNo.setBounds(175,162,150,20);
        roomNo.setForeground(Color.WHITE);
        roomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomNo);

        JLabel price = new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(580,162,150,20);
        bed.setForeground(Color.WHITE);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bed);

        JButton search = new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setForeground(Color.WHITE);
        search.setBackground(Color.BLACK);
        panel.add(search);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String q="Select * from room where Avaliable = '"+choice.getSelectedItem()+"'";

                try{
                    conn con = new conn();
                    ResultSet rs = con.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(380,420,120,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);
    }
    public static void main(String[] args){
        new SearchRoom();
    }
}
