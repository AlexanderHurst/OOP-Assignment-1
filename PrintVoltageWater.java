/**
* The PrintVoltageWater program uses some basic information
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
    * @param Vs The double value of the voltage source
    * @param Rs The double value of the resistance source
    * @param R0 The double value of the resistance constant
    * @param k  The double value of the constant   
    */
    public PrintVoltageWater (double Vs, double Rs, double R0, double k){
        this.Vs=Vs;
        this.Rs=Rs;
        this.R0 = R0;
        this.k = k;
    }

    /**
    *@return Returns the double value of the voltage source
    */
    public double getVs(){
        return this.Vs;
    }

    /**
    * @param Vs Sets the voltage source to the desired double
    */
    public void setVs(double Vs){
        this.Vs=Vs;
    }

    /**
    *@return Returns the double value of the resistance souce
    */
    public double getRs(){
        return this.Rs;
    }

    /**
    * @param Rs Sets the resistance source to the desired double
    */
    public void setRs(double Rs){
        this.Rs=Rs;
    }

    /**
    *@return Returns the double value of the resistance constant
    */
    public double getR0(){
        return this.R0;
    }

    /**
    * @param R0 Sets the resistance constant to the desired double
    */
    public void setR0(double R0){
        this.R0 = R0;
    }

    /**
    *@return Returns the double value of the constant
    */
    public double getk(){
        return this.k;
    }

    /**
    * @param k Sets the constant to the desired double
    */
    public void setk(double k){
        this.k = k;
    }

    /**
    * This method recieves a temperature and calculates the
    * resulting resistance
    * @param T This is the temperature of the water
    * @return This is the resistance
    */
    public double calcR(double T){
        return R0 + (k * T);
    }

    /**
    * This method calculates the voltage that will be read by
    * the volt meter given a temperature
    * @param T The temperature of the water
    * @return The voltage that will be read by the volt meter
    */
    public double calcVm(double T){
        double R = calcR(T);
        return (R/(Rs+R))*Vs;
    }
    
    /**
    * This method takes the voltage read by the volt meter and
    * uses it to calculate the temperature of the water
    * @param Vm The voltage read by the volt meter
    * @return The temperature of the water
    */
    public double calcT(double Vm){
        return ( (((Rs/k) * Vm)/(Vs - Vm)) - (R0/k) );
    }
}