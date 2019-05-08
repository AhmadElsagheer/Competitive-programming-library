package geometry;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class LineSweep 
{
	static final double EPS = 1e-9;
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		Scanner sc = new Scanner(System.in);
		TreeSet<Point> cands = new TreeSet<Point>();
				
		int n = sc.nextInt();
		Point[] points = new Point[n];
		for(int i = 0; i < n; i++)
			points[i] = new Point(sc.nextInt(), sc.nextInt());		
		Arrays.sort(points, new X());
		
		double d = 1e9;		
		for(int i = 0, left = 0; i < points.length; i++)
		{
			int px = points[i].x, py = points[i].y;
			while(left < i && px - points[left].x > d + EPS) cands.remove(points[left++]);

			Point down = new Point(px, py - (int)Math.ceil(d));
			Point up = new Point(px, py + (int)Math.floor(d));
			
			for(Point p: cands.subSet(down, up))
				if(p.dist(points[i]) + EPS < d)
					d = p.dist(points[i]);		//closest pair
			cands.add(points[i]);
		}
		sc.close();
	}	

	static class Point implements Comparable<Point>
	{
		int x,y;
		
		Point(int a, int b) {x = a; y = b;}
		
		public int compareTo(Point p) {	if(y != p.y) return y - p.y; return x - p.x; }
		
		double dist(Point p) { return Math.sqrt((long)(x - p.x) * (x - p.x) + (long)(y - p.y)  * (y - p.y)); }
	}
	
	static class X implements Comparator<Point>
	{
		public int compare(Point o1, Point o2) 	{ if(o1.x != o2.x) return o1.x - o2.x; return o1.y - o2.y; }
	}
}
