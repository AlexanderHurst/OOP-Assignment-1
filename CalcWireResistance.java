import java.util.Scanner;
public class CalcWireResistance{

    public static final double P_ALUMINUM = 2.82 * Math.pow(10,-8);
    public static final double P_COPPER = 1.678 * Math.pow(10,-8);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        
        boolean check;

        WireResistance aluminum = new WireResistance("aluminum", P_ALUMINUM);
        WireResistance copper = new WireResistance("copper", P_COPPER);

        int gauge = 0;
        int length = 0;

        System.out.println("Welcome to the wire resistance calculator!\n" +
                           "If you would like to quit at any time just enter the word \"quit\"");
        while (true)
        {
            check = false;
            while (!check){
                System.out.print("Enter the wire gauge: ");
                input=sc.nextLine();
                if (checkInput(input)){
                    gauge = Integer.parseInt(input);
                    check = true;
                }
                else {
                    check = false;
                    System.out.println("Whoops something went wrong, make sure you enter a number above 0");
                }
            }
            
            check = false;
            while (!check){
                System.out.print("Enter the wire length: ");
                input=sc.nextLine();
                if (checkInput(input)){
                    length = Integer.parseInt(input);
                    check = true;
                }
                else {
                    check = false;
                    System.out.println("Whoops something went wrong, make sure you enter a number above 0");
                }
            }
            
            System.out.println(aluminum.ComputeResistance(gauge, length));
            System.out.println(copper.ComputeResistance(gauge, length));
        }
    }
    
    public static boolean checkInput(String input){
        int number = 0;
        if (input.equalsIgnoreCase("quit")){
                System.exit(0);
        }
        else{
            number = Integer.parseInt(input);
        }
        if (number > 0){
            return true;
        }
        return false;
    }
}
