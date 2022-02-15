/**
 * Date: November 2017
 * Author: Bheesham Ramkissoon
 * Description: Takes an initialized phrase and then displays it in manipulated forms
 */
public class StringFun {
     
     
     public static void main(String[] args) { 
          String text = "I'm too cool for this stuff, Mr. Campos!";
          int fCount = 0; // variable to count the amount of f's there are in the phrase
          
          // a)
          System.out.println(text.substring(0, text.length() / 4));          
          
          // b)
          System.out.println(text.substring(text.length () - 2));
          
          // c)
          System.out.println(text.substring(0, 8));
          
          // d)    
          System.out.println(text.toLowerCase());
          
          // e)
          System.out.println(text.indexOf('c'));
          
          // f)
          System.out.println(text.indexOf('t', 5));
          
          // g)
          System.out.println(text.replace("o", "i"));
          
          // h)
          for (int i = 0; i < text.length(); i++){
               if (text.charAt (i) == 'f'){
                    fCount++;
               } // end if (increments the f counter if the character value of i is an f)
          } // end for (this runs for the enitrety of the phrase)
          System.out.println("This phrase has " + fCount + " 'f' letters");
          
               
               
     } // ends main     

     
} // end class
