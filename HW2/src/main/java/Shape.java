import java.util.*;
/*
 Shape data for ShapeClient:
 "0 0  0 1  1 1  1 0"
 "10 10  10 11  11 11  11 10"
 "0.5 0.5  0.5 -10  1.5 0"
 "0.5 0.5  0.75 0.75  0.75 0.2"
*/

public class Shape {
    private Point center;
//    private List<Point> p;
    private double radius;
    private int pointcnt;

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public Shape(String s) {
        String[] nums = s.split(" ");
        this.pointcnt = nums.length/2;
        double sumx = 0;
        double sumy = 0;
        for(int i = 0; i < nums.length; i = i + 2){
            sumx += Double.parseDouble(nums[i]);
            sumy += Double.parseDouble(nums[i+1]);
            Point pp = new Point(Double.parseDouble(nums[i]),Double.parseDouble(nums[i+1]));
            //this.p.add(pp);
        }

        this.center = new Point((sumx)/(double)this.pointcnt,(sumx)/(double)this.pointcnt);
        Point pp = new Point(Double.parseDouble(nums[0]),Double.parseDouble(nums[1]));
        this.radius = center.distance(pp);
    }

    public boolean cross(Shape other){
        double dis = this.getCenter().distance(other.getCenter());
        double tr = this.getRadius();
        double or = other.getRadius();
        if(dis>(tr+or)){
            return false;
        }
        if(tr>(dis+or)){
            return false;
        }
        if(or>(dis+tr)){
            return false;
        }
        return true;
    }

    public int encircle(Shape other){
        double dis = this.getCenter().distance(other.getCenter());
        double tr = this.getRadius();
        if(dis<=tr){
            return 2;
        }
        if(this.cross(other)==true){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
//        String s = "0.5 0.5 0.75 0.75 0.75 0.2";
//        String[] nums = s.split(" ");
//        for(int i = 0; i < nums.length; i = i + 2){
//            System.out.println(nums[i]);
//            System.out.println(nums[i+1]);
//        }
        Shape a = new Shape("0.5 0.5 0.75 0.75 0.75 0.2");
    }
}

