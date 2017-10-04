/**
* The Thermometer class uses PrintVoltageWater to calculate
* the voltage on a voltmeter or temperature of water
* @author Alexander Hurst
*/

public class Thermometer{
    public static void main(String[] args) {
        System.out.println("Hello and welcome to the Themometer demo!\n" +
                           "This program will demonstrate the ability to calculate the Voltage read by a voltmeter in water given a Temperature with some initial conditions");
        PrintVoltageWater VoltageWater = new PrintVoltageWater (20,75,50,0.5);
        System.out.println("T\tvm");
        System.out.println ("-----\t-----");
        for (double T = 0; T<=100; T+=10){
            System.out.println ((int)(T) + "\t" + roundDecimals(VoltageWater.calcVm(T), 2));
        }
    }

    /**
    * This method takes a number and rounds it to a desired number of decimal places
    * @param number The number to be rounded
    * @param places The number of desired decimal places
    * @return The rounded number 
    */
    public static double roundDecimals(double number, int places){
        return (Math.round(number * Math.pow(10,places))/Math.pow(10,places));
    }
}