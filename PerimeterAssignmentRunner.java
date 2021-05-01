import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
    int count=0;
     for (Point currPt : s.getPoints()) {
    count+=1;
    }
            // Put code here
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double total= 0.0;
        int count=0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            count+=1;
            total= total + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return total/count;
        
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double max1=0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
                 // Update prevPt to be currPt
                 if(currDist>max1)
                 {
                  max1=currDist;  
                    }
            prevPt = currPt;
        }
        
        return max1;
    }

    public double getLargestX(Shape s) {
        int x_max=-99999;
         Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            //double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
                 // Update prevPt to be currPt
                 int x1=currPt.getX();
                 if(x1>x_max)
                 {
                  x_max=x1;  
                    }
            prevPt = currPt;
        }
       
        // Put code here
        return x_max;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double max=0;
        //FileResource fr = new FileResource();    


        for (File f : dr.selectedFiles()) {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        if(length>max)
        {
        max=length;
        }
    }

        return max;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int count=getNumPoints( s);
        double avg=getAverageLength(s);
        double largeside=getLargestSide(s);
        double max_x=getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("count = " + count);
        System.out.println("Average Length = " + avg);
        System.out.println("Largest side = " + largeside);
        System.out.println("The largest x value is = " +max_x);

    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
