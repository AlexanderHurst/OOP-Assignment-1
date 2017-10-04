/**
* The WoodenBeam class uses some basic information to
* calculate the max load on a wooden beam of desired proportions
* @author Alexander Hurst
*/

public class WoodenBeam{
    private double length;
    private double base;
    private double height;
    private double inertia;
    private double centroid;
    private double distance;

    /**
    * Constructor method
    * @param length The length in feet of the beam and where the weight will be
    * @param base The base or width in inches of the beam
    * @param height The height in inches of the beam
    */
    public WoodenBeam(double length, double base, double height){
        this.length=length;
        this.base=base;
        this.height=height;
        this.setInertia();
        this.setCentroid();
        this.setDistance();
    }

    /**
    * @param length The value in feet to set the new length to
    */
    public void setLength(double length){
        this.length=length;
        this.setDistance();
    }

    /**
    * @return The length in feet of the beam
    */
    public double getLength(){
        return this.length;
    }

    /**
    * @param base The value in inches to set the new base or width to
    */
    public void setBase(double base){
        this.base=base;
        this.setInertia();
    }

    /**
    * @return The base or width in inches of the beam
    */
    public double getBase(){
        return this.base;
    }

    /**
    * @param height The value in inches to set the new height to
    */
    public void setHeight(double height){
        this.height=height;
        this.setInertia();
        this.setCentroid();
    }

    /** 
    * @return The height in inches of the beam
    */
    public double getHeight(){
        return this.height;
    }

    private void setInertia(){
        this.inertia=(this.base*this.height*this.height*this.height)/12;
    }

    /**
    * @return The moment of inertia in in^4 of the beam
    */
    public double getInertia(){
        return this.inertia;
    }

    private void setCentroid(){
        this.centroid=this.height/2;
    }

    /**
    * @return The centroid in inches of the beam
    */
    public double getCentroid(){
        return this.centroid;
    }

    private void setDistance(){
        this.distance=this.length*12;
    }

    /**
    * @return The distance in inches to the weight on the beam
    */
    public double getDistance(){
        return this.distance;
    }
    
    /**
    * This method takes the desired maximum stress to the beam and
    * returns the max amount of load that can be placed on the end of the beam
    * @param stress The stress in lbs per square inch that the beam can maintain
    * @return the max load in lbs that the beam can hold at the end
    */
    double computeMaxLoad(double stress){
        return (stress * this.inertia)/(this.distance * this.centroid);
    }
}