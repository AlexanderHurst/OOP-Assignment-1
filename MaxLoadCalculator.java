import java.text.DecimalFormat;

public class MaxLoadCalculator{
    public static void main(String[] args) {
        // Create a beam object using it’s length, base and height  
        WoodenBeam wb1 = new WoodenBeam(8.0, 2.0, 4.0);
        WoodenBeam wb2 = new WoodenBeam(8.0, 3.0, 6.0);

        double stress = 3000;
        // print out details

        System.out.println("For Beam #1:");
        printBeamInfo(wb1, stress);
        System.out.println();
        System.out.println("For Beam #2: ");
        printBeamInfo(wb2, stress);
        System.out.println();
    }

    public static void printBeamInfo(WoodenBeam woodenBeam, double stress){
        DecimalFormat twoDecimals = new DecimalFormat();
        twoDecimals.setMaximumFractionDigits(2);
        //twoDecimals.setMinimumFractionDigits(2);
        System.out.println("The length of the beam is d = " + twoDecimals.format(woodenBeam.getLength()) + " feet which is equal to " + twoDecimals.format(woodenBeam.getDistance()) + " inches");
        System.out.println("The length of the base is b = " + twoDecimals.format(woodenBeam.getBase()) + " inches");
        System.out.println("The height of the beam is h = " + twoDecimals.format(woodenBeam.getHeight()) + " inches");
        System.out.println("The stress on the fixed end of the beam is S = " + twoDecimals.format(stress) + " lbs per square inch");
        System.out.println("The rectangular moment of inertia is I = " + twoDecimals.format(woodenBeam.getInertia()) + " in^4");
        System.out.println("The centroid of the beam is c = " + twoDecimals.format(woodenBeam.getCentroid()) + " inches");
        System.out.println("Using the formula L = (S*I)/(d*c) = (" + twoDecimals.format(stress) + "*" + twoDecimals.format(woodenBeam.getInertia()) + ")/(" + twoDecimals.format(woodenBeam.getDistance()) + "*" + twoDecimals.format(woodenBeam.getCentroid()) + 
                           "),\nthe maximum load that can be placed at the end of the beam is: " + twoDecimals.format(woodenBeam.computeMaxLoad(stress)) + " lbs");
    }
}