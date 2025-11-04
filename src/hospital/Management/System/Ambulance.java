package hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ambulance extends javax.swing.JFrame {


    Ambulance() {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);
        try{
            conn con = new conn();
            String query = "select * from ambulance";
            ResultSet resultSet =con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JLabel l1 = new JLabel("Name");
        l1.setBounds(31,11,100,14);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(l1);

        JLabel l2 = new JLabel("Gender");
        l2.setBounds(200,11,100,14);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(l2);

        JLabel l3 = new JLabel("Car Name");
        l3.setBounds(370,11,100,14);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(l3);

        JLabel l4 = new JLabel("Availability");
        l4.setBounds(550,11,100,14);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(l4);

        JLabel l5 = new JLabel("Location");
        l5.setBounds(750,11,100,14);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(l5);

        setUndecorated(true);
        setSize(950,500);
        setVisible(true);
        setLayout(null);
        setLocation(400,250);
    }
    public static void main(String[] args) {
        new Ambulance();
    }
}
