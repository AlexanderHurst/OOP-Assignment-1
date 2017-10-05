public class WireResistance {

    private String name;
    private double resistivity;

    public WireResistance(String name, double resistivity){
        this.name = name;
        this.resistivity = resistivity;
    }

    // Takes the wire gauge and returns the corresponding wire diameter
    public double computeDiameter(double wireGauge){
        double n = (36-wireGauge)/39;
        return 0.127 * Math.pow(92, n);
    }

    // Takes the length and gauge of a piece of wire and returns the resistance of that wire. 
    public double ComputeResistance (double wireGauge, double length){
        return (4*this.resistivity*length)/(Math.PI*computeDiameter(wireGauge)*computeDiameter(wireGauge));
    }
}