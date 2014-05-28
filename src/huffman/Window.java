/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package huffman;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author santiago
 */
public class Window extends JFrame implements ActionListener{
    private final JButton btnin;
    private final JTextField txtin;
    private final Huffman hm = new Huffman();
    public Window(){
        super("Algoritmo de Huffman");
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(20,30,300,300);
        this.setResizable(false);
        
        //Btn
        
        btnin = new JButton("Codificar");
        btnin.addActionListener(this);
        btnin.setBounds(20,50,120,25);
        this.add(btnin);
        
        //Txt
        
        txtin = new JTextField("");
        txtin.addActionListener(this);
        txtin.setBounds(20,10,120,20);
        this.add(txtin);
        
    }

    /**
     * Overriding implemented method from interface ActionListener
     * @param e el ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnin){
            String txt = txtin.getText();
            String huffman = hm.execute(txt);
            JOptionPane.showMessageDialog(rootPane, huffman);
            txtin.setText("");
        }
    }
    public static void main(String[] args){
        Window window = new Window();
        window.setVisible(true);
    }
}
