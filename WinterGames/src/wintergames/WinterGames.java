/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wintergames;
import javax.swing.JFrame;

/**
 *
 * @author nelsonz
 */
public class WinterGames {
    

    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
       MedalRank winner = new MedalRank();
    }

    public static void main(String[] args) {
       
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            
            
        @Override
    public void run() {
        Scores.Scores();
        runGUI();
    }
        });
    }
}  
    
    

