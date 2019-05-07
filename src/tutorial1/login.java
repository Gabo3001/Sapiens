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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Electel
 */
public class login{
    private JFrame frame;
    private JButton button;
    private JTextField usr;
    private JTextField password;
    private Game game;
    private boolean visible;
    
    public login(Game game){
        this.game=game;
        this.visible=false;
        frame = new JFrame();
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("ingreso");
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        usr = new JTextField();
        usr.setBounds(150,20,100,30);
        frame.add(usr);
        

        
        password = new JTextField();
        password.setBounds(150,50,100,30);
        frame.add(password);
        
        JLabel label1 = new JLabel();
        label1.setText("Usuario: ");
        label1.setBounds(90,-15,100,100);
        frame.add(label1);
        
        JLabel label2 = new JLabel();
        label2.setText("Contraseña: ");
        label2.setBounds(70,15,100,100);
        frame.add(label2);
        
        
        
        button = new JButton ("Enviar");
        button.setBounds(150,100,100,30);
        button.addActionListener(new Esp(usr,password,game,frame));
        frame.add(button);
        frame.setVisible(true);
    }
    
public boolean isVisible(){
    return visible;
}
public void setVisible(boolean b){
    frame.setVisible(b);
}

}

class Esp implements ActionListener{

    private JTextField uname;
    private JTextField pass;
    private Game game;
    private JFrame frame;
    
    public Esp(JTextField u,JTextField p,Game g,JFrame f){
        uname = u;
        pass = p;
        game = g;
        frame = f;
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        System.out.println(uname.getText());
        System.out.println(pass.getText());
        
        //if the table for users is not created it creates one
        try {
            game.getDB().createUsrTable();
        } catch (Exception ex) {
            Logger.getLogger(Esp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //if the table for scores isnt created yet it creates one
        try {//trouble with foreign key syntax
            game.getDB().createScoresTable();
        } catch (Exception ex) {
            Logger.getLogger(Esp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ads a user from the DatabaseManager Class
//        try {
//            game.getDB().Usr();
//        } catch (Exception ex) {
//            Logger.getLogger(Esp.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        //Sets the username for the sesion
        game.setUsername(uname.getText());
        
        //this gets the id of the user into the game
        try {
            game.setUserID(game.getDB().getUsrID(uname.getText(),pass.getText()));
        } catch (Exception ex) {
            Logger.getLogger(Esp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
            //creates a row in the score table for the user if hes on the user database
        if(game.getUserID()!=0){
            try {
                game.getDB().addScoreRow(game.getUserID());
                game.setScoreTableID(game.getDB().getScoreID());
                System.out.println(game.getScoreTableID());
            } catch (Exception ex) {
                Logger.getLogger(Esp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        //Prints the database in console
        try {
        game.getDB().get();
        } catch (Exception ex) {
            Logger.getLogger(Esp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //shows the score table
        try {
            game.getDB().getScoreBoard();
        } catch (Exception ex) {
            Logger.getLogger(Esp.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(game.getUserID()!=0){
            frame.dispose();
        }
        
    }
    
}