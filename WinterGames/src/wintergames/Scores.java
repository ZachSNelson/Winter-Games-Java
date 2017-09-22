/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wintergames;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nelsonz
 */
public class Scores {
     //We need 5 names with 2 scored events and 2 timed events
    
     static String newEvent;
     static String scoreType;
     static int SCORES = 2;
     static int TIMES = 2;
     static int NAMES = 5;
     static ArrayList<String> scoredEvents = new ArrayList<>();
     static ArrayList<String> timedEvents = new ArrayList<>();
     static String[] medals = {"Gold", "Silver", "Bronze"};
     static String[] cnames = {"John", "Mike", "Steve", "Kate", "James"};
     static getData[] competitors = new getData[NAMES];
     
    public static void Scores(){
      
        String addEvent;
        int compScore = 0;
        int compTime = 0;
  
        Scanner input = new Scanner(System.in);

        //Events for the winter games below.
        
        scoredEvents.add("Ice Hockey");
        scoredEvents.add("Figure Skating");
        
        timedEvents.add("Bobsled");
        timedEvents.add("Speed Skating");
        
        //scored event scores / add set scores to array list
        ArrayList<Integer> cs1List = new ArrayList<>();// Competitor 1 scores
        cs1List.add(4);
        cs1List.add(5);
       
        ArrayList<Integer> cs2List = new ArrayList<>();// Competitor 2 scores
        cs2List.add(8);
        cs2List.add(2);
       
        ArrayList<Integer> cs3List = new ArrayList<>();// Competitor 3 scores
        cs3List.add(9);
        cs3List.add(8);  
       
        ArrayList<Integer> cs4List = new ArrayList<>();// Competitor 4 scores
        cs4List.add(2);
        cs4List.add(6);

        ArrayList<Integer> cs5List = new ArrayList<>();// Competitor 5 scores
        cs5List.add(3);
        cs5List.add(9);
        
        
         //Timed event scores / add set scores to array list
        ArrayList<Integer> ct1List = new ArrayList<>();// Competitor 1 times
        ct1List.add(26);
        ct1List.add(12);
        
        ArrayList<Integer> ct2List = new ArrayList<>();// Competitor 2 times
        ct2List.add(18);
        ct2List.add(45);
       
        ArrayList<Integer> ct3List = new ArrayList<>();// Competitor 3 times
        ct3List.add(63);
        ct3List.add(36);
       
        ArrayList<Integer> ct4List = new ArrayList<>();// Competitor 4 times
        ct4List.add(29);
        ct4List.add(63);
       
        ArrayList<Integer> ct5List = new ArrayList<>();// Competitor 5 times
        ct5List.add(19);
        ct5List.add(19);

        //See if user wants to add another winter game event
        System.out.println("Would you like to add another event? (yes or no) ");
        addEvent = input.nextLine();
        
        if(addEvent.equalsIgnoreCase("yes")){
            // Add newEvent to the gui dropdown list
            System.out.println("Enter what type of event: ");
            newEvent = input.nextLine();
            MedalRank.names.add(newEvent);
             
            System.out.println("Is this a scored or timed event? (s or t) ");
            scoreType = input.nextLine();
            //determines scored or timed event
            if(scoreType.equalsIgnoreCase("s")){
                scoredEvents.add(newEvent);
                SCORES = SCORES + 1;
                
                for(int x = 1; x<6; x++){
                System.out.println("Enter Competitor " + x + " Score") ;
                compScore = input.nextInt();
                
                switch(x){
                    case 1: cs1List.add(compScore);
                        break;
                    case 2: cs2List.add(compScore);
                        break;
                    case 3: cs3List.add(compScore);
                        break;
                    case 4: cs4List.add(compScore);
                        break;
                    case 5: cs5List.add(compScore);
                        
                }
                }
                
            } else{
                timedEvents.add(newEvent);
                TIMES = TIMES + 1;
                
                for(int x = 1; x<6; x++){
                System.out.println("Enter Competitor " + x + " Time") ;
                compTime = input.nextInt();
                
                switch(x){
                    case 1: ct1List.add(compTime);
                        break;
                    case 2: ct2List.add(compTime);
                        break;
                    case 3: ct3List.add(compTime);
                        break;
                    case 4: ct4List.add(compTime);
                        break;
                    case 5: ct5List.add(compTime);
                        
                }
                }
            }
            
        }
        
        //scored arrays for the values of the scored arraylist
        Integer[] cs1 = cs1List.toArray(new Integer[cs1List.size()]);
        Integer[] cs2 = cs2List.toArray(new Integer[cs2List.size()]);
        Integer[] cs3 = cs3List.toArray(new Integer[cs3List.size()]);
        Integer[] cs4 = cs4List.toArray(new Integer[cs4List.size()]);
        Integer[] cs5 = cs5List.toArray(new Integer[cs5List.size()]);
        

        //timed arrays for the values of the timed arraylist
        Integer[] ct1 = ct1List.toArray(new Integer[ct1List.size()]);
        Integer[] ct2 = ct2List.toArray(new Integer[ct2List.size()]);
        Integer[] ct3 = ct3List.toArray(new Integer[ct3List.size()]);
        Integer[] ct4 = ct4List.toArray(new Integer[ct4List.size()]);
        Integer[] ct5 = ct5List.toArray(new Integer[ct5List.size()]);
        
        
        //Sets data to a chart below.
        setData(competitors, 0, cnames[0], cs1, ct1);
        setData(competitors, 1, cnames[1], cs2, ct2);
        setData(competitors, 2, cnames[2], cs3, ct3);
        setData(competitors, 3, cnames[3], cs4, ct4);
        setData(competitors, 4, cnames[4], cs5, ct5);

    }
    //Stores data for later use for both scores and times.
    public static void setData(getData[] competitors, int index, String cname, Integer[] cs, Integer[] ct){
        competitors[index] = new getData(cname);
  
        for(int i = 0; i < cs.length; i++)
        competitors[index].setScore(i, cs[i]);

        for(int j = 0; j < ct.length; j++)
        competitors[index].setTime(j, ct[j]);
        }
    
     // Sorts scores from highest to lowest.  
    public static void sortScores(getData[] competitors, int index){
        for(int i = 0; i < competitors.length - 1; i++){
        int minPos = i;
        for(int j = i + 1; j < competitors.length; j++){
        if(competitors[j].getScore(index) > competitors[minPos].getScore(index)){
        minPos = j;
        }
        }
        if(minPos != i){
        getData temp = competitors[minPos];
        competitors[minPos] = competitors[i];
        competitors[i] = temp;
       
        }
        }
    }
    
    // Sorts scores from lowest to highest.
    public static void sortTimes(getData[] competitors, int index){
        for(int i = 0; i < competitors.length - 1; i++){
        int minPos = i;
        for(int j = i + 1; j < competitors.length; j++){
        if(competitors[j].getTime(index) < competitors[minPos].getTime(index)){
        minPos = j;
        }
        }
        if(minPos != i){
        getData temp = competitors[minPos];
        competitors[minPos] = competitors[i];
        competitors[i] = temp;
       
        }
        }

    }
    
}
