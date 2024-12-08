package classes.week7;

import classes.week6.Circle2D;

import java.util.Comparator;

public class CircleComp implements Comparator<Circle2D> {
    private int flag;
    public CircleComp(int f) {flag = f;}
    @Override
    public int compare(Circle2D o1, Circle2D o2) {
        int ans = 0;
        double a1 = o1.area();
        double a2 = o2.area();
        if(flag==0) {
            if(a1>a2) {ans=1;}
            if(a1<a2) {ans=-1;}
        }
        if(flag==1) {
            if(a1>a2) {ans=-1;}
            if(a1<a2) {ans=1;}
        }
        return ans;
    }
}
