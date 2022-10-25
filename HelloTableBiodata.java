import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HelloTableBiodata extends JFrame {

    public HelloTableBiodata(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama");
        labelInput.setBounds(15, 20, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15,40,350,30);

        JLabel labelRadio = new JLabel ("Jenis Kelamin");
        labelRadio.setBounds(15,70,350,20);

        JRadioButton radioButton1 = new JRadioButton("Laki -Laki");
        radioButton1.setBounds(15,100,350,30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15,130,350,30);

        JLabel labelInput2 = new JLabel("Nomor HP");
        labelInput2.setBounds(15, 150, 350, 50);

        JTextField textField2 = new JTextField();
        textField2.setBounds(15,190,350,30);

        JLabel labelinput3 = new JLabel("Alamat");
        labelinput3.setBounds(15,225,350,30);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,250,500,200);

        
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JButton button = new JButton("simpan");
        button.setBounds(15,500,100,40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,550,600,200);

        MyTableModel2 tableModel = new MyTableModel2();
        table.setModel(tableModel);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String jenisKelamin = "";
                if(radioButton1.isSelected()){
                    jenisKelamin = radioButton1.getText();
                }
                if(radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                }
                int confirmation2 = JOptionPane.showConfirmDialog(HelloTableBiodata.this,
                "apakah Anda Yakin?", "konfirmasi",JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirmation2 == JOptionPane.YES_OPTION)
                 {
                   JOptionPane.showMessageDialog(null,"Nama Tidak Boleh Kosong");
                } else if(confirmation2 == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(HelloTableBiodata.this, "Anda Menekan tombol no");
                } else if (confirmation2 == JOptionPane.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(HelloTableBiodata.this, "Anda Menekan tombol Cancel");

                }
            
                String nama              = textField.getText();
                String NomorHP           = textField2.getText();
                String Alamat            = txtOutput.getText();
                tableModel.add(new ArrayList<>(Arrays.asList(nama, jenisKelamin, NomorHP, Alamat)));
            }
        });

        this.add(button);
        this.add(textField);
        this.add(labelInput2);
        this.add(txtOutput);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelInput);
        this.add(textField2);
        this.add(labelinput3);
        this.add(scrollableTable);

        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable (){
            public void run (){
                HelloTableBiodata h = new HelloTableBiodata();
                h.setVisible(true);
            }
        });

    }
}