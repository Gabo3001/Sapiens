/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Electel
 */
public class quiz {
    private JFrame frame;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label1;
    private Game game;
    private boolean visible;
    
    public quiz(Game game){
        this.game=game;
        
        this.visible=false;
        frame = new JFrame();
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel label1 = new JLabel();
        label1.setText("¿Donde se origino el ser humano? ");
        label1.setBounds(90,-15,200,200);
        frame.add(label1);
        
        button1 = new JButton ("Enviar");
        button1.setBounds(50,150,100,30);
        
        button1.addActionListener(new anwr(this));
        frame.add(button1);
        
        button2 = new JButton ("Enviar");
        button2.setBounds(250,150,100,30);
        frame.add(button2);
        
        button3 = new JButton ("Enviar");
        button3.setBounds(50,250,100,30);
        frame.add(button3);
        
        button4 = new JButton ("Enviar");
        button4.setBounds(250,250,100,30);
        frame.add(button4);
        
        frame.setTitle("QUIZ");
        frame.setVisible(true);
    }
    public void setButton1Color(){
        button1.setBackground(Color.yellow);
        button2.setBackground(Color.yellow);
        button3.setBackground(Color.yellow);
        button4.setBackground(Color.yellow);
    }
}

class anwr implements ActionListener{
    quiz quiz;
    public anwr(quiz q){
        quiz = q;
    }
    public void actionPerformed(ActionEvent ae) {
        quiz.setButton1Color();
    }
}
