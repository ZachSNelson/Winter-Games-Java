 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wintergames;


public class getData {
    private String name;
    private int[] scores;
    private int[] times;
  
 public getData(String cname){
    // Competitor name, scores for 2 events, times for 2 events.
    name = cname;
    scores = new int[3];
    times = new int[3];
 }

 public void setScore(int index, int score){
    // Index is between 0 and 2.
    if(index >= 0 && index < 3)
    scores[index] = score;
 }
  
 public void setTime(int index, int time){
    // index is between 0 and 1 for Time results.
    if(index >= 0 && index < 3)
    times[index] = time;
 }
  
 public String getName(){
    return name;
 }
  
 public int getScore(int index){
    // Returns scores the scores array.
    if(index >= 0 && index < 3)
    return scores[index];

    return -1;
 }
  
 public int getTime(int index){
    // Returns scores for the times array.
    if(index >= 0 && index < 3)
    return times[index];

    return -1;
 }
}
   
    
    

