/**
* This program allows a user to enter the length and gauge of a wire.
* If the length and gauge of the wire are valid the program will print the
* resistance of the wire
*/
import java.util.Scanner;
public class CalcWireResistance{
    // constant values for the resistivities of the metals
    public static final double P_ALUMINUM = 2.82 * Math.pow(10,-8);
    public static final double P_COPPER = 1.678 * Math.pow(10,-8);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        
        boolean check;

        // create new wire material objects
        WireResistance aluminum = new WireResistance("aluminum", P_ALUMINUM);
        WireResistance copper = new WireResistance("copper", P_COPPER);

        double gauge = 0;
        double length = 0;

        System.out.println("Welcome to the wire resistance calculator!\n" +
                           "If you would like to quit at any time just enter the word \"quit\"");
        while (true) // this will loop until the user enters quit
        {
            check = false;
            // run until the user enters a valid gauge
            while (!check){
                System.out.print("Enter the wire gauge: ");
                input=sc.nextLine();
                if (checkInput(input)){
                    gauge = Double.parseDouble(input);
                    check = true;
                }
                else {
                    check = false;
                    System.out.println("Whoops something went wrong, make sure you enter a number above 0");
                }
            }
            
            check = false;
            // run until the user enters a valid length
            while (!check){
                System.out.print("Enter the wire length: ");
                input=sc.nextLine();
                if (checkInput(input)){
                    length = Double.parseDouble(input);
                    check = true;
                }
                else {
                    check = false;
                    System.out.println("Whoops something went wrong, make sure you enter a number above 0");
                }
            }
            
            // print the info for the two wire materials
            printInfo(aluminum, length, gauge);
            printInfo(copper, length, gauge);
        }
    }

    /**
    * This method checks to see if the user would like to exit the program.
    * If they do not want to exit it will return whether or not the input is
    * above 0 as only these values are valid
    * @param input The input to be checked
    * @return whether or not the input is above 0
    */    
    public static boolean checkInput(String input){
        double number = 0;
        if (input.equalsIgnoreCase("quit")){
                System.exit(0);
        }
        number = Double.parseDouble(input);
        return number > 0;
    }

    /**
    * This method prints out the info about the wire that the user would like to know about
    * @param wire this is the type of wire to check
    * @param length this is the length of the wire to check
    * @param gauge this is the gauge of the wire to check
    */
    public static void printInfo(WireResistance wire, double length, double gauge){
        System.out.println("The resistance of a " + length + " inch piece of " + gauge + " gauge " +wire.getName() + " wire is " + wire.ComputeResistance(gauge, length) + " Ohms");
    }
}
