public class Thermometer{
    public static void main(String[] args) {
        PrintVoltageWater VoltageWater = new PrintVoltageWater (20,75,50,0.5);
        System.out.println("T\tvm");
        for (double T = 0; T<=100; T+=10){
            System.out.println ((int)(T) + "\t" + twoDecimals(VoltageWater.calcVm(T)));
        }
    }
    public static double twoDecimals(double number){
        return (Math.round(number * 100.0))/100.0;
    }
}