/**
* The PrintVoltageWater class uses some basic information
* to calculate voltage on a voltmeter or temperature of water
* @author Alexander Hurst
*/

public class PrintVoltageWater {
    private double Vs;
    private double Rs;
    private double R0;
    private double k;

    /**
    * Constructor Method
    * @param Vs The value of the voltage source (Volts)
    * @param Rs The value of the resistance source (Ohms)
    * @param R0 The value of the resistance constant (Ohms)
    * @param k  The value of the constant (Ohms/Degrees Celsius)
    */
    public PrintVoltageWater (double Vs, double Rs, double R0, double k){
        this.Vs=Vs;
        this.Rs=Rs;
        this.R0 = R0;
        this.k = k;
    }

    /**
    *@return The value of the voltage source (Volts)
    */
    public double getVs(){
        return this.Vs;
    }

    /**
    * @param Vs Sets the voltage source to the desired value (Volts)
    */
    public void setVs(double Vs){
        this.Vs=Vs;
    }

    /**
    *@return The value of the resistance souce (Ohms)
    */
    public double getRs(){
        return this.Rs;
    }

    /**
    * @param Rs Sets the resistance source to the desired value (Ohms)
    */
    public void setRs(double Rs){
        this.Rs=Rs;
    }

    /**
    *@return The value of the resistance constant (Ohms)
    */
    public double getR0(){
        return this.R0;
    }

    /**
    * @param R0 Sets the resistance constant to the desired value (Ohms)
    */
    public void setR0(double R0){
        this.R0 = R0;
    }

    /**
    *@return The value of the constant (Ohms/Degrees Celsius)
    */
    public double getk(){
        return this.k;
    }

    /**
    * @param k Sets the constant to the desired value (Ohms/Degrees Celsius)
    */
    public void setk(double k){
        this.k = k;
    }

    /**
    * This method recieves a temperature and calculates the
    * resulting resistance
    * @param T The temperature of the water (Degrees Celsius)
    * @return The resistance (Ohms)
    */
    public double calcR(double T){
        return R0 + (k * T);
    }

    /**
    * This method calculates the voltage that will be read by
    * the voltmeter given a temperature
    * @param T The temperature of the water (Degrees Celsius)
    * @return The voltage that will be read by the voltmeter (Volts)
    */
    public double calcVm(double T){
        double R = calcR(T);
        return (R/(Rs+R))*Vs;
    }
    
    /**
    * This method takes the voltage read by the voltmeter and
    * uses it to calculate the temperature of the water
    * @param Vm The voltage read by the volt meter (Volts)
    * @return The temperature of the water (Degrees Celsius)
    */
    public double calcT(double Vm){
        return ( (((Rs/k) * Vm)/(Vs - Vm)) - (R0/k) );
    }
}