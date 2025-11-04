package hospital.Management.System;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Patient_Info extends JFrame {

    public Patient_Info() {

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(5, 5, 890, 590);
        p.setBackground(new Color(90, 156, 163));
        add(p);

        JTable table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        table.setRowHeight(25);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setGridColor(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 20, 860, 500);
        p.add(scrollPane);

        try {
            conn con = new conn();
            String query = "SELECT * FROM patient_info";
            ResultSet resultSet = con.statement.executeQuery(query);

            // Convert SQL result into JTable model
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            // Set column widths for readability
            table.getColumnModel().getColumn(0).setPreferredWidth(120);
            table.getColumnModel().getColumn(1).setPreferredWidth(150);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(150);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton button=new JButton("Back");
        button.setBackground(Color.BLACK);
        button.setBounds(350,525,120,30);
        button.setFont(new Font("Tahoma",Font.BOLD,14));
        button.setForeground(Color.WHITE);
        p.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient_Info();
    }
}

