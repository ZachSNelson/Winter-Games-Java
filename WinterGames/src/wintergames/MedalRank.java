
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wintergames;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;


public class MedalRank implements  ActionListener {
   JFrame frame;
   static JPanel contentPane;
   JComboBox eventNames;
   static JLabel eventListPrompt, medalResult1,medalResult2,medalResult3, eventType;
   static ArrayList<String> names = new ArrayList<>();
   
    
    public MedalRank(){
         //Create and set up the frame
        frame = new JFrame("Event Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane  */
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(50, 200, 200, 200));
   
         /* Create a combo box and a descriptive label */
        eventListPrompt = new JLabel("Select an event name: ");
        eventListPrompt.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        contentPane.add(eventListPrompt);
    
        // Winter game events
        names.add("Ice Hockey");
        names.add("Figure Skating");
        names.add("Bobsled");
        names.add("Speed Skating");
        
        eventNames = new JComboBox<>(new Vector<>(names));
        eventNames.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        eventNames.setSelectedIndex(0);
        eventNames.addActionListener(this);
        contentPane.add(eventNames);
    
        eventType = new JLabel();
        eventType.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        contentPane.add(eventType); 
    
        medalResult1 = new JLabel();
        medalResult1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        contentPane.add(medalResult1);
    
        medalResult2 = new JLabel();
        medalResult2.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        contentPane.add(medalResult2);
    
        medalResult3 = new JLabel();
        medalResult3.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        contentPane.add(medalResult3);
      
        /* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }
 
  
        //Handle a selection from the combo box.
        @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox)e.getSource();
        String eventNames = (String)comboBox.getSelectedItem();
    
    
            // display event when user clicks on the event
       
            if (eventNames.equals("Speed Skating")){
               for(int i = 0; i < Scores.TIMES; i++){
                   Scores.sortTimes(Scores.competitors, 1);
                   eventType.setText("Event: " + Scores.timedEvents.get(1));
                   medalResult1.setText(Scores.medals[0] + ": " + Scores.competitors[0].getName());
                   medalResult2.setText(Scores.medals[1] + ": " + Scores.competitors[1].getName());
                   medalResult3.setText(Scores.medals[2] + ": " + Scores.competitors[2].getName());
               }
            }else if (eventNames.equals("Bobsled")){
               for(int i = 0; i < Scores.TIMES; i++){
                   Scores.sortTimes(Scores.competitors, 0);
                   eventType.setText("Event: " + Scores.timedEvents.get(0));
                   medalResult1.setText(Scores.medals[0] + ": " + Scores.competitors[0].getName());
                   medalResult2.setText(Scores.medals[1] + ": " + Scores.competitors[1].getName());
                   medalResult3.setText(Scores.medals[2] + ": " + Scores.competitors[2].getName());
               } 
            }else if (eventNames.equals("Ice Hockey")){
               for(int i = 0; i < Scores.SCORES; i++){
                   Scores.sortScores(Scores.competitors, 0);
                   eventType.setText("Event: " + Scores.scoredEvents.get(0));
                   medalResult1.setText(Scores.medals[0] + ": " + Scores.competitors[0].getName());
                   medalResult2.setText(Scores.medals[1] + ": " + Scores.competitors[1].getName());
                   medalResult3.setText(Scores.medals[2] + ": " + Scores.competitors[2].getName());
               }
            }else if (eventNames.equals("Figure Skating")){
               for(int i = 0; i < Scores.SCORES; i++){
                   Scores.sortScores(Scores.competitors, 1);
                   eventType.setText("Event: " + Scores.scoredEvents.get(1));
                   medalResult1.setText(Scores.medals[0] + ": " + Scores.competitors[0].getName());
                   medalResult2.setText(Scores.medals[1] + ": " + Scores.competitors[1].getName());
                   medalResult3.setText(Scores.medals[2] + ": " + Scores.competitors[2].getName());
               }
            }else if (eventNames.equals(Scores.newEvent)){
                if(Scores.scoreType.equalsIgnoreCase("s")){
                    for(int i = 0; i < Scores.SCORES; i++){
                        Scores.sortScores(Scores.competitors, 2);
                        eventType.setText("Event: " + Scores.scoredEvents.get(2));
                        medalResult1.setText(Scores.medals[0] + ": " + Scores.competitors[0].getName());
                        medalResult2.setText(Scores.medals[1] + ": " + Scores.competitors[1].getName());
                        medalResult3.setText(Scores.medals[2] + ": " + Scores.competitors[2].getName());
                    }
                }else {
                    for(int i = 0; i < Scores.TIMES; i++){
                        Scores.sortTimes(Scores.competitors, 2);
                        eventType.setText("Event: " + Scores.timedEvents.get(2));
                        medalResult1.setText(Scores.medals[0] + ": " + Scores.competitors[0].getName());
                        medalResult2.setText(Scores.medals[1] + ": " + Scores.competitors[1].getName());
                        medalResult3.setText(Scores.medals[2] + ": " + Scores.competitors[2].getName());
                    }
                }
            }
    }
}
    