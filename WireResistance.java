/**
* This class creates and stores a wire material object.
* Then if provided a length and gauge it will return the resistance.
*/
public class WireResistance {

    // the object stores the name and resistivity of the material
    private String name;
    private double resistivity;

    /**
    * Constructor Method
    * @param name this is the name of the material
    * @param resistivity this is the resistivity of the material
    */
    public WireResistance(String name, double resistivity){
        this.name = name;
        this.resistivity = resistivity;
    }

    /**
    * Setter method for the name
    * @param name this is the name of the wires material
    */
    public void setName(String name){
        this.name = name;
    }

    /**
    * Getter method for the name
    * @return the name of the wires material
    */
    public String getName(){
        return this.name;
    }

    /**
    * Setter method for the resistivity
    * @param resistivity this is the resistivity of the wires material
    */
    public void setResistivity(double resistivity){
        this.resistivity = resistivity;
    }

    /**
    * Getter method for the resistivity
    * @return the resistivity of the wires material
    */
    public double getResistivity(){
        return this.resistivity;
    }

    /**
    * Converts from inches to meters
    * @param value This is the value in inches to convert to meters
    * @return This is the value in meters
    */
    public double inchToMeter(double value){
        return value * 0.0254;
    }

    /** 
    * Takes the wire gauge and returns the corresponding wire diameter
    * @param wireGauge This is the gauge of the wire
    * @return This is the diameter of the wire in meters
    */
    public double computeDiameter(double wireGauge){
        double n = (36-wireGauge)/39;
        return (0.127 * Math.pow(92, n))/1000; // will get the diameter in meters
    }

    /** 
    * Takes the length and gauge of a piece of wire and returns the resistance of that wire. 
    * @param wireGauge This is the gauge of the wire to calculate the resistance of
    * @param length This is the length of the wire to calculate the resistance of
    * @return This is the resistance of the wire 
    */
    public double ComputeResistance (double wireGauge, double length){
        return (4*this.resistivity*inchToMeter(length))/(Math.PI*computeDiameter(wireGauge)*computeDiameter(wireGauge));
    }
}