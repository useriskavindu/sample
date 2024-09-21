import java.util.Scanner;

public class Circle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double ri, ro;

        while (true) {
            System.out.println("Enter the inner radius: ");
            ri = scanner.nextDouble();

            System.out.println("Enter the outer radius: ");
            ro = scanner.nextDouble();

            if (ro >= ri) {
                break;
            } else {
                System.out.println("Error! Inner radius is larger than the outer radius. Try again!");
                System.out.println("\n----------------------------------\n");
            }
        }


        computeArea(ro, ri);
        computeCircumference(ro, ri);

        scanner.close();
    }

    //--------------------------------------------------------------------------
    public static void computeArea(double ro, double ri) {

        double PI = 3.14;


        double outerArea = 2 * PI * ro * ro;
        double roundedOuterArea = (int)Math.ceil(outerArea);

        double innerArea = 2 * PI * ri * ri;
        double roundedInnerArea = (int)Math.ceil(innerArea);

        double coveredArea = outerArea - innerArea;
        double roundedCoveredArea = (int)Math.ceil(coveredArea);

        System.out.println("\nOuter Area: " + roundedOuterArea + " square units" + "\nInner Area: " + roundedInnerArea + " square units" + "\nCovered Area: " +  roundedCoveredArea + " square units");
        System.out.println("----------------------------------\n");
    }

    //--------------------------------------------------------------------------

    public static void computeCircumference(double ro, double ri) {

        double PI = 3.14;

        double outerCircumference = 2 * PI * ro;
        double roundedOuterCircumference = (int)Math.ceil(outerCircumference);

        double innerCircumference = 2 * PI * ri;
        double roundedInnerCircumference = (int)Math.ceil(innerCircumference);

        System.out.println("\nOuter Circumference: " + roundedOuterCircumference + " units"  + "\nInner Circumference: " + roundedInnerCircumference +  " units"  );
        System.out.println("----------------------------------\n");

        //scanner.close();
    }

}


//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter the inner radius: ");
//        double ri = scanner.nextDouble();
//
//        System.out.println("Enter the outer radius: ");
//        double ro = scanner.nextDouble();
//
//        if (ri >  ro) {
//            System.out.println("Error! Inner radius is larger than the outer radius.");
//            System.out.println("\n----------------------------------\n");
//        } else {
