import java.util.*;

public class Q3 {
    public static void main(String[] args) {

//        float inches;
//        float feets;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length in centimeters: ");
        double centimetres = scanner.nextFloat();

        double inches = centimetres / 2.54;
//        double roundedValueForInches = Double.parseDouble(String.format(".4%",inches));
//        double roughValueForInches = (int)Math.ceil(inches);

        double feets = inches / 12;
//        double roundedValueForFeets = Double.parseDouble(String.format(".4%",feets));
//        double roughValueForfeets = (int)Math.ceil(feets);

        System.out.println("Length in inches: " + inches + "\nLength in feets: " + feets);
        //System.out.println("Length in inches: " + roughValueForInches + "\nLength in feets:" + roughValueForfeets);

    }
}
