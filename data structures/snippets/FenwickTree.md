Update 2D Binary-Indexed Tree
```java
	int ft[][], maxX, maxY;
	
	void update(int x, int y, int val)
	{
		int y1;
		while(x <= maxX)
		{
			y1 = y;
			while(y1 <= maxY)
			{
				ft[x][y1] += val;
				y1 += y1 & -y1;
			}
			x += x & -x;
		}
	}
```
