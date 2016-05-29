package geometry;

import java.util.Arrays;

public class Polygon { 
	// Cases to handle: collinear points, polygons with n < 3

	static final double EPS = 1e-9;
	
	Point[] g; 			//first point = last point, counter-clockwise representation
	
	Polygon(Point[] o) { g = o; }

	double perimeter()
	{
		double sum = 0.0;
		for(int i = 0; i < g.length - 1; ++i)
			sum += g[i].dist(g[i+1]);
		return sum;
	}
	
	double area() 		//clockwise/anti-clockwise check, for convex/concave polygons
	{
		double area = 0.0;
		for(int i = 0; i < g.length - 1; ++i)
			area += g[i].x * g[i+1].y - g[i].y * g[i+1].x;
		return Math.abs(area) / 2.0;			//negative value in case of clockwise
	}

	boolean isConvex()
	{
		if(g.length <= 3) // point or line
			return false;
		boolean ccw = Point.ccw(g[g.length - 2], g[0], g[1]);		//edit ccw check to accept collinear points
		for(int i = 1; i < g.length - 1; ++i)
			if(Point.ccw(g[i-1], g[i], g[i+1]) != ccw)
				return false;
		return true;
	}
	
	boolean inside(Point p)	//for convex/concave polygons - winding number algorithm 
	{
		double sum = 0.0;
		for(int i = 0; i < g.length - 1; ++i)
		{
			double angle = Point.angle(g[i], p, g[i+1]);
			if((Math.abs(angle) < EPS || Math.abs(angle - Math.PI) < EPS) && p.between(g[i], g[i+1]))
				return true;
			if(Point.ccw(p, g[i], g[i+1]))
				sum += angle;
			else
				sum -= angle;
		}

		return Math.abs(2 * Math.PI - Math.abs(sum)) < EPS;		//abs makes it work for clockwise
	}
	/*
	 * Another way if the polygon is convex
	 * 1. Triangulate the poylgon through p
	 * 2. Check if sum areas == poygon area
	 * 3. Handle empty polygon
	 */
	
	Polygon cutPolygon(Point a, Point b)	//returns the left part of the polygon, swap a & b for the right part
	{
		Point[] ans = new Point[g.length<<1];
		Line l = new Line(a, b);
		Vector v = new Vector(a, b);
		
		int size = 0;
		for(int i = 0; i < g.length; ++i)
		{
			double left1 = v.cross(new Vector(a, g[i]));
			double left2 = i == g.length - 1 ? 0 : v.cross(new Vector(a, g[i+1]));

			if(left1 + EPS > 0)	
				ans[size++] = g[i];
			if(left1 * left2 + EPS < 0)
				ans[size++] = l.intersect(new Line(g[i], g[i+1]));
		}
		
		if(size != 0 && ans[0] != ans[size-1])	//necessary in case g[0] is not in the new polygon
			ans[size++] = ans[0];
		return new Polygon(Arrays.copyOf(ans, size));
	}

	static Polygon convexHull(Point[] points)	//all points are unique, remove duplicates, edit ccw to accept collinear points
	{
		int n = points.length;
		Arrays.sort(points);
		Point[] ans = new Point[n<<1];
		int size = 0, start = 0;

		for(int i = 0; i < n; i++)
		{
			Point p = points[i];
			while(size - start >= 2 && !Point.ccw(ans[size-2], ans[size-1], p))	--size;
			ans[size++] = p;
		}
		start = --size;

		for(int i = n-1 ; i >= 0 ; i--)
		{
			Point p = points[i];
			while(size - start >= 2 && !Point.ccw(ans[size-2], ans[size-1], p))	--size;
			ans[size++] = p; 
		}
		//			if(size < 0) size = 0			for empty set of points
		return new Polygon(Arrays.copyOf(ans, size));			
	}

	Point centroid()		//center of mass
	{
		double cx = 0.0, cy = 0.0;
		for(int i = 0; i < g.length - 1; i++)
		{
			double x1 = g[i].x, y1 = g[i].y;
			double x2 = g[i+1].x, y2 = g[i+1].y;

			double f = x1 * y2 - x2 * y1;
			cx += (x1 + x2) * f;
			cy += (y1 + y2) * f;
		}
		double area = area();		//remove abs
		cx /= 6.0 * area;
		cy /= 6.0 * area;
		return new Point(cx, cy);
	}
}