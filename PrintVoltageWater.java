public class PrintVoltageWater {
    private double Vs;
    private double Rs;
    private double R0;
    private double k;

    public PrintVoltageWater (double Vs, double Rs, double R0, double k){
        this.Vs=Vs;
        this.Rs=Rs;
        this.R0 = R0;
        this.k = k;
    }

    public double getVs(){
        return this.Vs;
    }

    public void setVs(double Vs){
        this.Vs=Vs;
    }

    public double getRs(){
        return this.Rs;
    }

    public void setRs(double Rs){
        this.Rs=Rs;
    }

    public double getR0(){
        return this.R0;
    }

    public void setR0(double R0){
        this.R0 = R0;
    }

    public double getk(){
        return this.k;
    }

    public void setk(double k){
        this.k = k;
    }

    public double calcR(double T){
        return R0 + (k * T);
    }

    public double calcVm(double T){
        double R = calcR(T);
        return (R/(Rs+R))*Vs;
    }
    
    public double calcT(double Vm){
        return ( (((Rs/k) * Vm)/(Vs - Vm)) - (R0/k) );
    }
}