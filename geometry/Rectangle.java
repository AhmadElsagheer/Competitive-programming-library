package geometry;

public class Rectangle {

	static final double EPS = 1e-9;
	
	Point ll, ur;

	Rectangle(Point a, Point b) { ll = a; ur = b; }

	double area() { return (ur.x - ll.x) * (ur.y - ll.y); }

	boolean contains(Point p)
	{
		return p.x <= ur.x + EPS && p.x + EPS >= ll.x && p.y <= ur.y + EPS && p.y + EPS >= ll.y;
	}

	Rectangle intersect(Rectangle r)
	{
		Point ll = new Point(Math.max(this.ll.x, r.ll.x), Math.max(this.ll.y, r.ll.y));
		Point ur = new Point(Math.min(this.ur.x, r.ur.x), Math.min(this.ur.y, r.ur.y));
		if(Math.abs(ur.x - ll.x) > EPS && Math.abs(ur.y - ll.y) > EPS && this.contains(ll) && this.contains(ur) && r.contains(ll) && r.contains(ur))
			return new Rectangle(ll, ur);
		return null;
	}

}
