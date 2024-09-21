import java.util.*;
public class Q1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String word;
        int middleChar;
        char letter;

        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("Enter a string with odd number of characters: ");
            word = scanner.nextLine();

            if (word.length()%2 != 0) {

                middleChar = word.length()/2;
                letter = word.charAt(middleChar);
                System.out.println("The middle character is: " + letter);
                break;

            }
            else {
                System.out.println("Number of characters is not odd. Try again");
            }
        }

        scanner.close();
    }

}



//        System.out.println("Enter a string with odd number of characters: ");
//        String word = scanner.nextLine();

//        if(word.length()%2 == 0){
//            System.out.println("Number of characters is not odd. Try again");
//        } else {
//            int middleChar = word.length()/2;
//            char letter = word.charAt(middleChar);
//
//            System.out.println("The middle character is: " + letter);
//        }