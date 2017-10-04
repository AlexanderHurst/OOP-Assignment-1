/**
* The Thermometer class uses PrintVoltageWater to calculate
* the voltage on a voltmeter or temperature of water
* @author Alexander Hurst
*/

public class Thermometer{
    public static void main(String[] args) {
        PrintVoltageWater VoltageWater = new PrintVoltageWater (20,75,50,0.5);
        System.out.println("T\tvm");
        System.out.println ("-----\t-----");
        for (double T = 0; T<=100; T+=10){
            System.out.println ((int)(T) + "\t" + twoDecimals(VoltageWater.calcVm(T)));
        }
    }
    public static double twoDecimals(double number){
        return (Math.round(number * 100.0))/100.0;
    }
}