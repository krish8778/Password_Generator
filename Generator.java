import java.util.Scanner;
import java.util.Random;

public class Generator {
    private final Scanner keyBoard;
    private Alphabet alphabet;

    Generator(){
        keyBoard = new Scanner(System.in);
    }

    public void mainLoop(){
        System.out.println("Welcome to Krish password service");
        int userInput = -1;
        while(userInput != 4){
            printMenu();
            userInput = keyBoard.nextInt();
            keyBoard.nextLine();
            switch (userInput){
                case 1 :
                    requestPassword();
                    break;
                case 2 :
                    checkPassword();
                    break;
                case 3 :
                    printUsefulInfo();
                    break;
                case 4 :
                    quitMessage();
                    break;
                default :
                    System.out.println("Enter valid input");
            }
        }
    }

    private void checkPassword() {
        System.out.print("Enter your password : ");
        String input = keyBoard.nextLine();
        Password password = new Password(input);
        System.out.println(password.calculateScore()+"\n");

    }

    private void requestPassword(){
        boolean includeLower = false;
        boolean includeUpper = false;
        boolean includeNumber = false;
        boolean includeSymbol = false;

        boolean correctParams = true;
        System.out.println("Welcome to password generator :)");
        System.out.println("Answer the following question by 'Yes' or 'No'");
        do{
            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
            String input = keyBoard.nextLine();
            try{
                if(isInclude(input)) includeLower = true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
            input = keyBoard.nextLine();
            try{
                if(isInclude(input)) includeUpper = true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("Do you want Numbers \"1234...\" to be used? ");
            input = keyBoard.nextLine();
            try{
                if(isInclude(input)) includeNumber = true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("Do you want Special characters \"!@#$...\" to be used? ");
            input = keyBoard.nextLine();
            try{
                if(isInclude(input)) includeSymbol = true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }

            if(includeSymbol || includeLower || includeUpper || includeNumber){
                correctParams = false;
                System.out.println("Great, Now enter the length of the password");
                int length = keyBoard.nextInt();
                alphabet = new Alphabet(includeUpper,includeLower,includeNumber,includeSymbol);
                String password = generatePassword(length);
                System.out.println(password);
            }

        }while(correctParams);

    }

    private String generatePassword(int length){
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++){
         int idx = random.nextInt(alphabet.getAlphabets().length());
         password.append(alphabet.getAlphabets().charAt(idx));
        }
        return password.toString();
    }

    private boolean isInclude(String input) throws IllegalArgumentException{
        if(input.equalsIgnoreCase("yes"))
            return true;
        else{
            if(!input.equalsIgnoreCase("no")){
                throw new IllegalArgumentException("You have entered something incorrect let's go over it again \n");
            }
            return false;
        }
    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components\n");
    }

    private void printMenu(){
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Check Password Strength");
        System.out.println("Enter 3 - Useful information");
        System.out.println("Enter 4 - Exit");
        System.out.print("Choice : ");
    }

    private void quitMessage(){
        keyBoard.close();
        System.out.println("Closing the program bye bye!!!");
    }
}
