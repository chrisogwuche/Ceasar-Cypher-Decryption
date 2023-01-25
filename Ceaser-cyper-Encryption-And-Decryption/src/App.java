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
        arrWord = Arrays.asList(Message.split("")); // split word into an array

        for(String a : arrWord){
            // check if it is String "a" is a Capital letter
            boolean UpperCase = false;
            if(a.toLowerCase()!= a){
                UpperCase = true;
            }
            // check if "a" is a special character and then add to indexDecrypt
            if(a.matches("[^a-zA-Z]+")){
                encryptMessage += a.toString();
            }
            if(Alphabet_to_Set_Encryption.contains(a.toLowerCase())){
                int i = Alphabet_to_Set_Encryption.indexOf(a);
                int position = i - key;

                if(position < 0 )
                {
                    int shift = Alphabet_to_Set_Encryption.size() - Math.abs(position);
                    if(UpperCase == true){
                        encryptMessage += Alphabet_to_Set_Encryption.get(shift).toUpperCase() ; 
                    }
                    else{
                        encryptMessage += Alphabet_to_Set_Encryption.get(shift); 
                    }
                }
                else {
                    if(UpperCase == true){
                        encryptMessage += Alphabet_to_Set_Encryption.get(position).toUpperCase() ; 
                    }
                    else{
                        encryptMessage += Alphabet_to_Set_Encryption.get(position);
                    }
                }
            }
        }
        System.out.println("-----ENCRYPTED MESSAGE----\n" +encryptMessage +"\n\n");
         
       

        System.out.println("-----------------------------------------NEW MESSAGE ALERT!!-----------------------------------");
        System.out.println("---------------------------------DECRYPT MESSAGE??--------------------------");
        System.out.println("ENTER KEY TO DECRYPT: ");
        int Decrypt_key = Integer.parseInt(sc.nextLine());

        String decrypted_Message = "";
        arrWord_Decrypt = Arrays.asList(encryptMessage.split("")); // split word into an array

        for(String a : arrWord_Decrypt){
            // check if it is String "a" is a Capital letter
            boolean UpperCase = false;
            if(a.toLowerCase()!= a){
                UpperCase = true;
            }
            // check if "a" is a special character and then add to indexDecrypt
            if(a.matches("[^a-zA-Z]+")){
                decrypted_Message += a.toString();
            }
            if(Alphabet_to_Set_Decryption.contains(a.toLowerCase())){
                int i = Alphabet_to_Set_Decryption.indexOf(a);
                int position = i + Decrypt_key;

                if(position > 26 ){
                    int shift = position - (Alphabet_to_Set_Decryption.size()-1);
                    if(UpperCase == true){
                        decrypted_Message += Alphabet_to_Set_Decryption.get(shift).toUpperCase() ; 
                    }
                    else{
                        decrypted_Message += Alphabet_to_Set_Decryption.get(shift); 
                    }
                }
                else {
                    if(UpperCase == true){
                        decrypted_Message += Alphabet_to_Set_Decryption.get(position).toUpperCase() ; 
                    }
                    else{
                        decrypted_Message += Alphabet_to_Set_Decryption.get(position);
                    }
                }
            }
        }

        System.out.println("-----MESSAGE----\n" + decrypted_Message);
        sc.close();
    }
}
