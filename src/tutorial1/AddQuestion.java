/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import javax.swing.JButton;
import javax.swing.JFrame;
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
    private Game game;
    
    public AddQuestion(Game game){
        this.game = game;
        frame = new JFrame();
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
