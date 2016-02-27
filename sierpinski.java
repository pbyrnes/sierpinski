import java.awt.*;
import java.applet.*;

public class sierpinski extends Applet
{
	public void drawTri(int x1,int y1,int x2,int y2,int x3,int y3,Graphics g)
	{
		int[] xa = new int[3];
		int[] ya = new int[3];
		xa[0] = x1;
		xa[1] = x2;
		xa[2] = x3;
		ya[0] = y1;
		ya[1] = y2;
		ya[2] = y3;
		g.fillPolygon(xa,ya,3);
	}
	
	public void drawSierpinski(int x1,int y1,int x2,int y2,int x3,int y3,int n,Graphics g)
	{
		if(n==1)
			drawTri(x1,y1,x2,y2,x3,y3,g);
		else
		{
			drawSierpinski(x1,y1,(x1+x2)/2,(y1+y2)/2,(x1+x3)/2,(y1+y3)/2,n-1,g);
			drawSierpinski(x2,y2,(x1+x2)/2,(y1+y2)/2,(x2+x3)/2,(y2+y3)/2,n-1,g);
			drawSierpinski(x3,y3,(x3+x2)/2,(y3+y2)/2,(x1+x3)/2,(y1+y3)/2,n-1,g);
		}
	}
	
	public void paint(Graphics g)
	{
		drawSierpinski(300,80,0,600,600,600,6,g);
	}
}