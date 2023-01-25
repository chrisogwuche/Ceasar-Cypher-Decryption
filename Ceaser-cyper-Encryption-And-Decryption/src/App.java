import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<String> arrWord = new ArrayList<>();
        String [] Alphabet_to_Set_Encryption = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String [] Alphabet_to_Set_Decryption = {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        List<String> arrWord_Decrypt = new ArrayList<>();
        System.out.println("!!ENCRYPT YOUR MESSAGE!!\n");
        System.out.println("ENTER MESSAGE YOU WANT TO ENCRYPT BELOW: ");
        String Message = sc.nextLine();
        System.out.print("\nENTER DECREYPT KEY: ");
        int key = Integer.parseInt(sc.nextLine());

        String encryptMessage = "";
        arrWord = Arrays.asList(Message.split(" ")); // split word into an array
        
        for(String x: arrWord){
            String word_in_arrWord = x;
            List<String> wordInArray = Arrays.asList(word_in_arrWord.split(""));
            String xEncrypt = "";

            for(String a : wordInArray){
                // check if it is String "a" is a Capital letter
                boolean UpperCase = false;
                if(a.toLowerCase()!= a){
                    UpperCase = true;
                }
                // check if "a" is a special character and then add to indexDecrypt
                if(a.matches("[^a-zA-Z]+")){
                    xEncrypt += a.toString();
                }
                // loop through to know where String "a" matches with Aphabet
                for(int i = 0; i < Alphabet_to_Set_Encryption.length; i++){

                    if(a.toLowerCase().equals(Alphabet_to_Set_Encryption[i])){
                        int position = i - key;
                        if(position < 0 ){
                            int count2 = Alphabet_to_Set_Encryption.length - Math.abs(position);
                            if(UpperCase == true){
                                xEncrypt += Alphabet_to_Set_Encryption[count2].toUpperCase() ; 
                            }
                            else{
                                xEncrypt += Alphabet_to_Set_Encryption[count2] ; 
                            }
                        }
                        else {
                            if(UpperCase == true){
                                xEncrypt += Alphabet_to_Set_Encryption[position].toUpperCase() ; 
                            }
                            else{
                                xEncrypt += Alphabet_to_Set_Encryption[position];
                            }
                        }
                    }
                }
            }
            encryptMessage += xEncrypt + " ";
        }
        System.out.println("-----ENCRYPTED MESSAGE----\n" + encryptMessage +"\n\n");
         
       

        System.out.println("-----------------------------------------NEW MESSAGE ALERT!!-----------------------------------");
        System.out.println("---------------------------------DECRYPT MESSAGE??--------------------------");
        System.out.println("ENTER KEY TO DECRYPT: ");
        int Decrypt_key = Integer.parseInt(sc.nextLine());

        // String encrypted_Message = "Ocz Wzvpodapg Bdmg.";
        String decrypted_Message = "";
        arrWord_Decrypt = Arrays.asList(encryptMessage.split(" ")); // split word into an array

        for(String x: arrWord_Decrypt){
            String word_in_arrWord = x;
            List<String> wordInArray = Arrays.asList(word_in_arrWord.split(""));
            String xDecrypt = "";

            for(String a : wordInArray){
                // check if it is String "a" is a Capital letter
                boolean UpperCase = false;
                if(a.toLowerCase()!= a){
                    UpperCase = true;
                }
                // check if "a" is a special character and then add to indexDecrypt
                if(a.matches("[^a-zA-Z]+")){
                    xDecrypt += a.toString();
                }
                // loop through to know where String "a" matches with Aphabet
                for(int i = 0; i < Alphabet_to_Set_Decryption.length; i++){

                    if(a.toLowerCase().equals(Alphabet_to_Set_Decryption[i])){
                        int position = i + Decrypt_key;
                        if(position > 26 ){
                            int count2 = position - (Alphabet_to_Set_Decryption.length-1);
                            if(UpperCase == true){
                                xDecrypt += Alphabet_to_Set_Decryption[count2].toUpperCase() ; 
                            }
                            else{
                                xDecrypt += Alphabet_to_Set_Decryption[count2] ; 
                            }
                        }
                        else {
                            if(UpperCase == true){
                                xDecrypt += Alphabet_to_Set_Decryption[position].toUpperCase() ; 
                            }
                            else{
                                xDecrypt += Alphabet_to_Set_Decryption[position];
                            }
                            
                        }
                    }
                }
            }
            decrypted_Message += xDecrypt + " ";
        }
        System.out.println("-----MESSAGE----\n" + decrypted_Message);
        sc.close();
    }
}
