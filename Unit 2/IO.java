// The "ReadLib " class by R.Parteno February 2001
// Updated by T. Campos, Sept. 2013.
// Converted to "InputBox" by T. Campos to support Swing dialog boxes, Sept. 2013.
// Updated by S. Buchanan-Bruce, April 2016.

// IO is a library class of read routines all based upon pressing the enter key
// IO provides methods for reading int, long, double, boolean, char and String types

// Methods:
// readInt(String prompt) // uses a Tokenizer and Integer wrapper class
// readLong(String prompt) // uses a Tokenizer and Long wrapper class
// readDouble (String prompt) // uses a Tokenizer and Double wrapper class
// readBoolean (String prompt) // reads a boolean, looks for true or false
// readChar (String prompt) // reads the first character of the stream
// readString(String prompt) // simply reads the string
// readString(String prompt, ImageIcon image) // simply reads the string, allows program to specify an icon
//
// display (String prompt)  // displays message
// display (String prompt, ImageIcon image)  // displays message with an icon
// display (String prompt, String title, ImageIcon image)  // displays message with an icon and title
// display (String prompt, String title, int msgOption)  // displays message with a title and JOptionPane message option
// displayInt (int prompt) // displays integer
// displayLong (long prompt) // displays long
// displayDouble (double prompt) // displays double
// displayChar (char prompt) // displays char


import java.io.*;
import java.util.*;
import javax.swing.*;

public class IO
{
   // the Tokenizer is used to get the first item typed on a line, used with
   //  readInt(), readDouble(), and readBoolean()
   static private StringTokenizer stok;
   
   // the BufferedReader opens the connection to the keyboard
   static private String prompt;
   
   public IO (String prompt)
   {
      //constructor
      this.prompt = prompt;
   }
   
   
   //
   
   
   public static int readInt (String prompt)   // uses a Tokenizer and Integer wrapper class
   { //  to get a true int value
      int i;
      try
      {
         String str = JOptionPane.showInputDialog (prompt);
         StringTokenizer stok = new StringTokenizer (str);
         i = new Integer (stok.nextToken ()).intValue ();
      }
      catch (NumberFormatException nfe)  // invalid keyboard entry
      {
         JOptionPane.showMessageDialog (null, "Your variable has been given value of 0.",
                                        "Warning: A non-numeric value was entered.",
                                        JOptionPane.INFORMATION_MESSAGE);
         i = 0;
      }
      catch (NoSuchElementException nfe)
      {
         JOptionPane.showMessageDialog (null, "Your variable has been given value of 0.",
                                        "Warning: A non-numeric value was entered.",
                                        JOptionPane.INFORMATION_MESSAGE);
         i = 0;
      }
      catch (NullPointerException npe)
      {
         JOptionPane.showMessageDialog (null, "You have pressed CANCEL. Aborting operation.",
                                        "ABORT",
                                        JOptionPane.INFORMATION_MESSAGE);
         i = 0;
      }
      
      return i;
   }
   
   
   public static long readLong (String prompt)   // uses a Tokenizer and Long wrapper class
   { //  to get a true long value
      long l;
      try
      {
         String str = JOptionPane.showInputDialog (prompt);
         StringTokenizer stok = new StringTokenizer (str);
         l = new Long (stok.nextToken ()).longValue ();
      }
      catch (NumberFormatException nfe)  // invalid keyboard entry
      {
         JOptionPane.showMessageDialog (null, "Your variable has been given value of 0.",
                                        "Warning: A non-numeric value was entered.",
                                        JOptionPane.INFORMATION_MESSAGE);
         l = 0;
      }
      catch (NoSuchElementException nfe)
      {
         JOptionPane.showMessageDialog (null, "Your variable has been given value of 0.",
                                        "Warning: A non-numeric value was entered.",
                                        JOptionPane.INFORMATION_MESSAGE);
         l = 0;
      }
      catch (NullPointerException npe)
      {
         JOptionPane.showMessageDialog (null, "You have pressed CANCEL. Aborting operation.",
                                        "ABORT",
                                        JOptionPane.INFORMATION_MESSAGE);
         l = 0;
      }
      
      return l;
   }
   
   
   public static double readDouble (String prompt)  // uses a Tokenizer and Double wrapper class
   { //  to get a true double value
      double d = 0;
      try
      {
         String str = JOptionPane.showInputDialog (prompt);
         stok = new StringTokenizer (str);
         d = new Double (stok.nextToken ()).doubleValue ();
      }
      catch (NumberFormatException nfe)
      {
         JOptionPane.showMessageDialog (null, "Your variable has been given value of 0.",
                                        "Warning: A non-numeric value was entered.",
                                        JOptionPane.INFORMATION_MESSAGE);
         d = 0;
      }
      catch (NoSuchElementException nfe)
      {
         JOptionPane.showMessageDialog (null, "Your variable has been given value of 0.",
                                        "Warning: A non-numeric value was entered.",
                                        JOptionPane.INFORMATION_MESSAGE);
         d = 0;
      }
      
      catch (NullPointerException npe)
      {
         JOptionPane.showMessageDialog (null, "You have pressed CANCEL. Aborting operation.",
                                        "ABORT",
                                        JOptionPane.INFORMATION_MESSAGE);
         d = 0;
      }
      return d;
   }
   
   
   public static boolean readBoolean (String prompt)   // reads a boolean, looks for true or false
   { // assumes false otherwise
      boolean result = false;
      try
      {
         String str = JOptionPane.showInputDialog (prompt);
         stok = new StringTokenizer (str);
         String answer = stok.nextToken ();
         if (answer.equals ("true"))   // valid true entry
         {
            result = true;
         }
         else
         {
            if (!answer.equals ("false"))  // invalid entry
               JOptionPane.showMessageDialog (null, "False is assumed.",
                                              "Warning: An invalid value was entered.",
                                              JOptionPane.INFORMATION_MESSAGE);
            result = false;
         }
      }
      catch (NullPointerException npe)
      {
         JOptionPane.showMessageDialog (null, "You have pressed CANCEL. Aborting operation.",
                                        "ABORT",
                                        JOptionPane.INFORMATION_MESSAGE);
         result = false;
      }
      return result;
   }
   
   
   public static char readChar (String prompt)
   {
      char oneChar = ' ';
      
      try
      {
         
         String str = JOptionPane.showInputDialog (prompt);
         oneChar = str.charAt (0);   // oneChar is first character of keyboard entry
      }
      
      catch (StringIndexOutOfBoundsException se)  // enter key only, no character
      {
         JOptionPane.showMessageDialog (null, "Blank assumed.",
                                        "Warning: There was no character entered.",
                                        JOptionPane.INFORMATION_MESSAGE);
      }
      
      catch (NullPointerException npe)
      {
         JOptionPane.showMessageDialog (null, "You have pressed CANCEL. Aborting operation.",
                                        "ABORT",
                                        JOptionPane.INFORMATION_MESSAGE);
         oneChar = '0';
      }
      return oneChar;
   }
   
   
   public static String readString (String prompt)
   {
      String str = "";
      try
      {
         str = JOptionPane.showInputDialog (prompt);   // returns null if no characters typed
      }
      catch (NullPointerException npe)
      {
         JOptionPane.showMessageDialog (null, "You have pressed CANCEL. Aborting operation.",
                                        "ABORT",
                                        JOptionPane.INFORMATION_MESSAGE);
      }
      return str;
   }
   
   
   public static String readString (String prompt, ImageIcon image)  // overloaded readString method allowing an icon
   {
      String str = "";
      try
      { // returns null if no characters typed
         str = (String) JOptionPane.showInputDialog (null,
                                                     prompt,
                                                     null,
                                                     JOptionPane.QUESTION_MESSAGE,
                                                     image,
                                                     null,
                                                     null);
         
      }
      catch (NullPointerException npe)
      {
         JOptionPane.showMessageDialog (null,
                                        "You have pressed CANCEL. Aborting operation.",
                                        "ABORT",
                                        JOptionPane.INFORMATION_MESSAGE);
      }
      return str;
   }
   
   
   //
   
   
   public static void display (String prompt)  // displays String
   {
      JOptionPane.showMessageDialog (null,
                                     prompt);
   }
   
   
   public static void display (String prompt, ImageIcon image)  // displays String with icon
   {
      JOptionPane.showMessageDialog (null,
                                     prompt,
                                     null,
                                     JOptionPane.PLAIN_MESSAGE,
                                     image);
   }
   
   public static void display (String prompt, String title, ImageIcon image)  // displays String with title and icon
   {
      JOptionPane.showMessageDialog (null,
                                     prompt,
                                     title,
                                     JOptionPane.PLAIN_MESSAGE,
                                     image);
   }
   
   public static void display (String prompt, String title, int msgOption)  // displays String with JOptionPane message option
   {
      JOptionPane.showMessageDialog (null,
                                     prompt,
                                     title,                       
                                     msgOption);
   }
   
   
   public static void displayInt (int prompt)  // displays int
   {
      JOptionPane.showMessageDialog (null,
                                     String.valueOf (prompt));
   }
   
   
   public static void displayLong (long prompt)  // displays long
   {
      JOptionPane.showMessageDialog (null,
                                     String.valueOf (prompt));
   }
   
   
   public static void displayDouble (double prompt)  // displays double
   {
      JOptionPane.showMessageDialog (null,
                                     String.valueOf (prompt));
   }
   
   
   public static void displayChar (char prompt)  // displays char
   {
      JOptionPane.showMessageDialog (null,
                                     String.valueOf (prompt));
   }
} // IO class

