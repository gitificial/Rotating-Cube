/** 
 *  @author keyboardroaster@gmail.com
 *  @version 0.1
 * */

package com.boardremedy.rotatingcube;

public class Vector4D 
{
	public double x;
	public double y;
	public double z;
	public double a;
	
	public Vector4D()
	{
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
		this.a = 0.0;
	}
	
	public Vector4D(double x, double y, double z, double a)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.a = a;
	}
}
