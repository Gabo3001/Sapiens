/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private String question;
    private String answer;
    private String option2;
    private String option3;
    private String option4;
    private LinkedList<String> response;
    
    private int range;
    private int n;
    private int quizScore;
    
    public quiz(Game game,String q,String a,String o2,String o3,String o4){
        this.game=game;
        this.quizScore=0;
        this.question = q;
        this.answer = a;
        this.option2 = o2;
        this.option3 = o3;
        this.option4 = o4;
        response=new LinkedList<String>();
        
        frame = new JFrame();
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("QUIZ");
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //LinkedList
        response.add(answer);
        response.add(option2);
        if(option3!=null||option4!=null){
        response.add(option3);
        response.add(option4);
        }
        range = (4);//max-min
        n = (int) (Math.random() * range);
        System.out.println(n);
        
        //QUESTION TEXT 
        JLabel label1 = new JLabel();
        label1.setText(question);
        label1.setBounds(90,-15,200,200);
        frame.add(label1);
        
        //BUTTON1 UI and behaviour
        button1 = new JButton (response.get(n));
        button1.setBounds(25,150,150,30);
        button1.setBackground(Color.decode("#00aaff"));
        button1.addActionListener(new anwr(answer,response.get(n),this));
        frame.add(button1);
        n++;
        rollN();
        
        //BUTTON2 UI and behaviour
        button2 = new JButton (response.get(n));
        button2.setBounds(225,150,150,30);
        button2.setBackground(Color.decode("#aaff00"));
        button2.addActionListener(new anwr(answer,response.get(n),this));
        frame.add(button2);
        n++;
        rollN();
        
        //BUTTON3 UI and behaviour
        button3 = new JButton (response.get(n));
        button3.setBounds(25,250,150,30);
        button3.setBackground(Color.decode("#ff00aa"));
        button3.addActionListener(new anwr(answer,response.get(n),this));
        frame.add(button3);
        n++;
        rollN();
        
        //BUTTON4 UI and behaviour
        button4 = new JButton (response.get(n));
        button4.setBounds(225,250,150,30);
        button4.setBackground(Color.decode("#ffaa00"));
        button4.addActionListener(new anwr(answer,response.get(n),this));
        frame.add(button4);
        n++;
        rollN();
        
        frame.setVisible(true);

    }
    public void setButton1Color(){
        if(response.get(n)==answer){
            button1.setBackground(Color.green);
        }else{
            button1.setBackground(Color.red);
        }
        n++;
        rollN();
        if(response.get(n)==answer){
            button2.setBackground(Color.green);
        }else{
            button2.setBackground(Color.red);
        }
        n++;
        rollN();
        if(response.get(n)==answer){
            button3.setBackground(Color.green);
        }else{
            button3.setBackground(Color.red);
        }
        n++;
        rollN();
        if(response.get(n)==answer){
            button4.setBackground(Color.green);
        }else{
            button4.setBackground(Color.red);
        }
        n++;
        rollN();
    }
    public void setScore(int score){
        this.quizScore=score;
    }
    
    public int getScore(){
        return quizScore;
    }
    
    private void rollN(){
        if(n==4){
            n=0;
        }
    }
    public JFrame getFrame(){
        
        return frame;
    }
}

class anwr implements ActionListener{
    String ans;
    String res;
    quiz quiz;
    public anwr(String a,String r,quiz b){
        ans = a;
        res = r;
        quiz = b;
    }
    public void actionPerformed(ActionEvent ae) {
        quiz.setButton1Color();
        if(quiz.getScore()==100||quiz.getScore()==50){
           quiz.getFrame().dispose(); 
        }
        if(quiz.getScore()==0){
            if(ans==res){
                quiz.setScore(100);
            }else{
                quiz.setScore(50);
            }
        }
        System.out.println(quiz.getScore());
        quiz.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
}
