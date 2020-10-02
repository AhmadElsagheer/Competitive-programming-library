import java.io.*; 
import java.util.*; 

class Lcm{ 
	static int gcd(int x, int y){
        if (x == 0) return y; 
        return gcd(y % x, x); 
    }
     
    static int lcm(int x, int y){
        return (x / gcd(x, y)) * y;
    }
     
    public static void main(String[] args){
        int x = 15, y = 20;
        System.out.println("LCM of " + x + " and " + y + " is " + lcm(x, y));
    }
} 

