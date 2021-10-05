
import java.util.Scanner;
/**
 *
 * @author marvindelgado
 */
public class secretMessage 
{
   public static void main (String [] args)
   {
       int userChoice;
       String userText = "";
       Scanner userInput = new Scanner(System.in);
       Scanner txt = new Scanner(System.in);
       System.out.print("Enter 1 to encode, 2 to decode, 3 to quit: ");
        userChoice = userInput.nextInt();
        
       while(userChoice != 3)                                       //Loops choice while it is not 
       {                                                            //a 3 that they choose.
           if(userChoice == 1)
           {
               System.out.println("Enter the text to encode: ");
                userText = txt.nextLine();
                String messageEncoded = codeText(userText, true);   //After getting the string by
                System.out.println(messageEncoded);                 //the user, it is sent to the method
                
           }                                                        
           else if (userChoice == 2)
           {
               System.out.println("Enter the text to decode: ");    //Same as above.
                userText = txt.nextLine();
                String messageDecoded = codeText(userText, false);
                System.out.println(messageDecoded);
           }
           System.out.print("Enter 1 to encode, 2 to decode, 3 to quit: ");
                userChoice = userInput.nextInt();
       }
       System.out.println("Goodbye");
   }
   
   public static boolean isUpperCaseLetter(char i)                  //Check for uppercase
    {
       return i >= 'A' && i <= 'Z';
    }

   public static boolean isLowerCaseLetter(char i)                  //Check for lowercase
   {
       return i>= 'a' && i<= 'z';
   }

   public static boolean isLetter(char i)                           //Check for letter using
   {                                                                //above methods.
       return isLowerCaseLetter(i) || isUpperCaseLetter(i);
   }
   
   public static char toLowerCase(char i)                           //Changes to lower case letters
   {
       return (char) (i + 'a' - 'A');
   }
  
   public static char toUpperCase(char i)                           //Changes to Upper case letters
   {
       return (char) (i - 'a' + 'A');
   }
   
   public static char codeMes(char i, boolean enc)               //Codes the message
   {                                                             //"enc" stands for encode
      
     //String letters = "abcdefghijklmnopqrstuvwxyz";
       String encKey = "kngcadsxbvfhjtiumylzqropwe";
       String decKey = "eidfzkclomasqbwxuvgnpjyhrt";
      
       char newLet = i;                                          //New letters for message
      
       if(isLetter(i))                                           //Switches Characters back to 
       {                                                         //Uppercase if they were uppercase
           if(isUpperCaseLetter(i))                              //or back to lowercase if they were
           {                                                     //lowercase.
               if (enc)
                   newLet = encKey.charAt(i-'A');
               else
               {
                   newLet = decKey.charAt(i- 'A');
               }
               newLet = toUpperCase(newLet);
           }
           else
           {
               if (enc)
                   newLet = encKey.charAt(i-'a');
               else
                   newLet = decKey.charAt(i - 'a');
           }
       }
       return newLet;
   }
   
   public static String codeText(String userText, boolean enc)   //Checks each letter in the string input
   {                                                             //by the user.
       String newText= "";
       
       for (int index = 0; index < userText.length(); index++)
       {
           newText += codeMes(userText.charAt(index), enc);     //codeMes is the method above
       }                                                        //which is the method that encodes the text
       return newText;
   }
}
