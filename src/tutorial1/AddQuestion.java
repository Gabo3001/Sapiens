/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Electel
 */
public class AddQuestion {
     private JFrame frame;
    private JButton send;
    private JTextField question;
    private JTextField answer;
    private JTextField option2;
    private JTextField option3;
    private JTextField option4;
    private JComboBox combo1;
    private JButton preview;
    private JButton insert;
    private Game game;
    
    public AddQuestion(Game game){
        this.game = game;
        frame = new JFrame();
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel label1 = new JLabel();
        label1.setText("Pregunta: ");
        label1.setBounds(45,-15,100,100);
        frame.add(label1);
        
        JLabel label2 = new JLabel();
        label2.setText("Respuesta: ");
        label2.setBounds(45,35,100,100);
        frame.add(label2);
        
        JLabel label3 = new JLabel();
        label3.setText("Opcion 2: ");
        label3.setBounds(45,85,100,100);
        frame.add(label3);
        
        JLabel label4 = new JLabel();
        label4.setText("Opcion 3: ");
        label4.setBounds(45,135,100,100);
        frame.add(label4);
        
        JLabel label5 = new JLabel();
        label5.setText("Opcion 4: ");
        label5.setBounds(45,185,100,100);
        frame.add(label5);
        
        question = new JTextField();
        question.setBounds(115,20,250,30);
        frame.add(question);
        
        answer = new JTextField();
        answer.setBounds(115,70,250,30);
        frame.add(answer);
        
        option2 = new JTextField();
        option2.setBounds(115,120,250,30);
        frame.add(option2);
        
        option3 = new JTextField();
        option3.setBounds(115,170,250,30);
        frame.add(option3);
        
        option4 = new JTextField();
        option4.setBounds(115,220,250,30);
        frame.add(option4);
        
        combo1=new JComboBox();
        combo1.addItem("Cognitiva");
        combo1.addItem("Agricola");
        combo1.addItem("Scientifica");
        combo1.setBounds(115,270,250,30);
        frame.add(combo1);
        
        preview = new JButton ("Ver");
        preview.setBounds(80,320,100,30);
        preview.addActionListener(new preview(game,question,answer,option2,option3,option4));
        frame.add(preview);
        
        insert = new JButton ("Insertar");
        insert.setBounds(230,320,100,30);
        insert.addActionListener(new insert(game,question,answer,option2,option3,option4,combo1));
        frame.add(insert);
        
        
        frame.setVisible(true);
    }
}
class insert implements ActionListener{
    private JTextField question;
    private JTextField answer;
    private JTextField option2;
    private JTextField option3;
    private JTextField option4;
    private JComboBox revolution;
    private Game game;
    
    public insert(Game game,JTextField q,JTextField a,JTextField o2,JTextField o3,JTextField o4,JComboBox box){
        this.game=game;
        question=q;
        answer=a;
        option2=o2;
        option3=o3;
        option4=o4;
        revolution=box;
          
    }
    public void actionPerformed(ActionEvent ae) {
        //System.out.println(revolution.getSelectedItem().toString());
        try {
            game.getDB().createQuizTable();
        } catch (Exception ex) {
            Logger.getLogger(preview.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            game.getDB().addQuiz4Question(revolution.getSelectedItem().toString(),question.getText(),answer.getText(),option2.getText(),option3.getText(),option4.getText());
        } catch (Exception ex) {
            Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class preview implements ActionListener{
    private JTextField question;
    private JTextField answer;
    private JTextField option2;
    private JTextField option3;
    private JTextField option4;
    private quiz exampleQuiz;
    private Game game;
    
    public preview(Game game,JTextField q,JTextField a,JTextField o2,JTextField o3,JTextField o4){
    question=q;
    answer=a;
    option2=o2;
    option3=o3;
    option4=o4;
    this.game=game;
    }
    public void actionPerformed(ActionEvent ae) {
        
    exampleQuiz=new quiz(game,question.getText(),answer.getText(),option2.getText(),option3.getText(),option4.getText(),true);

    }
}


