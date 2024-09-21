import java.util.*;

public class Q2 {
    public static void main(String[] args) {

        String fName;
        String mName;
        String sName;

        Scanner fullName = new Scanner(System.in);
        System.out.println("Enter your First name, Middle name and Sur name:");
        String sentence = fullName.nextLine();

        String[] nameSegmanets = sentence.split(" ");

        fName = nameSegmanets[0];
        mName = nameSegmanets[1];
        sName = nameSegmanets[2];

        char firstLetter = mName.charAt(0);

        System.out.println("Output: " + sName + ", " + fName + " " + firstLetter + ".");

        fullName.close();

    }
}
