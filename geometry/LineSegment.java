package geometry;

public class LineSegment {

	Point p, q;
	
	LineSegment(Point a, Point b) { p = a; q = b; }
	

	boolean intersect(LineSegment ls)
	{
		Line l1 = new Line(p, q), l2 = new Line(ls.p, ls.q);
		if(l1.parallel(l2))
		{
			if(l1.same(l2))
				return p.between(ls.p, ls.q) || q.between(ls.p, ls.q) || ls.p.between(p, q) || ls.q.between(p, q);
			return false;
		}
		Point c = l1.intersect(l2);
		return c.between(p, q) && c.between(ls.p, ls.q);
	}

}
