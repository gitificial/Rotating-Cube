/** 
 *  @author keyboardroaster@gmail.com
 *  @version 0.1
 * */

package com.boardremedy.rotatingcube;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.acos;
import static java.lang.Math.abs;
import static java.lang.Math.PI;

public class Vectoroperations
{	
	
	/**
	 * Converts radian to degree.
	 * 
	 * @param rad  radian
	 * 
	 * @return double degree
	 */
	public static double radToDegree(double rad)
	{
		double degree = 0.0;
		degree = (180 / PI) * rad;
		return degree;
	}
	
	/**
	 * Converts degree to radian.
	 * 
	 * @param rad  degree
	 * 
	 * @return double rad
	 */
	public static double degreeToRad(double degree)
	{
		double rad = 0.0;
		
		rad = 2*PI * (degree/360);
		
		return rad;
	}
	
	/**
	 * Generates a Point2D object by the committed coordinates.
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * 
	 * @return Point2D Point2D object
	 */
	public static Point2D generatePoint2DFromCoordinates(double x, double y)
	{
		Point2D point = new Point2D();
		point.x = x;
		point.y = y;
		return point;
	}
	
	/**
	 * Creates a Vector2D object from a given Point2D object.
	 *
	 * @param p Point2D object
	 * 
	 * @return Vector2D Vector2D object
	 */
	public static Vector2D generateVector2DFromPoint2D(Point2D p)
	{
		Vector2D vector = new Vector2D();
		vector.x = p.x;
		vector.y = p.y;
		return vector;
	}
	
	/**
	 * Returns the sum of two Vector2D objects.
	 *
	 * @param a Vector2D object
	 * @param b Vector2D object
	 * 
	 * @return Vector2D Vector2D object
	 */
	public static Vector2D sumVector2D(Vector2D a, Vector2D b)
	{
		Vector2D vector = new Vector2D();
		vector.x = a.x + b.x;
		vector.y = a.y + b.y;
		return vector;
	}
	
	/**
	 * Returns the sum of two Vector3D objects.
	 *
	 * @param a Vector3D object
	 * @param b Vector3D object
	 * 
	 * @return Vector3D Vector3D object
	 */
	public static Vector3D sumVector3D(Vector3D a, Vector3D b)
	{
		Vector3D vector = new Vector3D();
		vector.x = a.x + b.x;
		vector.y = a.y + b.y;
		vector.z = a.z + b.z;
		return vector;
	}
	
	/**
	 * Returns the sum of two Vector4D objects.
	 *
	 * @param a Vector4D object
	 * @param b Vector4D object
	 * 
	 * @return Vector4D Vector4D object
	 */
	public static Vector4D sumVector4D(Vector4D a, Vector4D b)
	{
		Vector4D vector = new Vector4D();
		vector.x = a.x + b.x;
		vector.y = a.y + b.y;
		vector.z = a.z + b.z;
		return vector;
	}
	
	/**
	 * Returns the difference (a - b) of two Vector2D objects.
	 *
	 * @param a Vector2D object
	 * @param b Vector2D object
	 * 
	 * @return Vector2D Vector2D object
	 */
	public static Vector2D differenceVector2D(Vector2D a, Vector2D b) 
	{
		Vector2D vector = new Vector2D();
		vector.x = a.x - b.x;
		vector.y = a.y - b.y;
		return vector;
	}
	
	/**
	 * Returns a vector multiplied with a scalar. 
	 *
	 * @param scalar scalar
	 * @param a Vector2D object
	 * 
	 * @return Vector2D Vector2D object
	 */
	public static Vector2D getVector2DMultipliedWithScalar(double scalar, Vector2D a)
	{
		Vector2D vector = new Vector2D();
		
		vector.x = scalar * a.x;
		vector.y = scalar * a.y;
		
		return vector;
	}
	
	/**
	 * Returns the absolute value of a Vector2D object.
	 *
	 * @param vector Vector2D object
	 * 
	 * @return Vector2D Vector2D object
	 */
	public static double get2DAbsoluteValue(Vector2D vector)
	{
		double absval = sqrt(pow(vector.x, 2) + pow(vector.y, 2));
		return absval;
	}
	
	/**
	 * Returns the scalar product of two Vector2D objects.
	 *
	 * @param a Vector2D object
	 * @param b Vector2D object
	 * 
	 * @return Vector2D Vector2D object
	 */
	public static double get2DScalarProduct(Vector2D a, Vector2D b)
	{
		double product = (a.x * b.x) + (a.y * b.y); 
		return product;
	}
	
	/**
	 * Returns the determinant of two Vector2D objects.
	 *
	 * @param a Vector2D object
	 * @param b Vector2D object
	 * 
	 * @return double determinant
	 */
	public static double get2DDeterminant(Vector2D a, Vector2D b)	// cross product
	{
		double determinant = (a.x * b.y) - (a.y * b.x);
		return determinant;
	}
	
	/**
	 * Checks if two vectors are orthogonal to each other. 
	 *
	 * @param a Vector2D object
	 * @param b Vector2D object
	 * 
	 * @return boolean Returns true if the given vectors are orthogonal to each other.
	 */
	public static boolean testVectors2DOrthogonal(Vector2D a, Vector2D b)
	{
		double scalarproduct = get2DScalarProduct(a, b);
		
		if(scalarproduct == 0.0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Maps Vector b onto Vector a.
	 *
	 * @param a Vector2D object
	 * @param b Vector2D object
	 * 
	 * @return mapped Vector2D object
	 */
	public static Vector2D getMappedVector2D(Vector2D a, Vector2D b)
	{
		Vector2D vector = new Vector2D();
		
		try
		{
			vector = getVector2DMultipliedWithScalar((get2DScalarProduct(a, b) / pow(get2DAbsoluteValue(a),2)), a);
			return vector;
		}
		catch (ArithmeticException e) 
		{
		    System.out.println("Result is not valid!");
		}
		return vector;
	}
	
	/**
	 * Returns the angle between Vector a and Vector b.
	 *
	 * @param a Vector2D object
	 * @param b Vector2D object
	 * 
	 * @return double returns the enclosed angle in degrees
	 */
	public static double get2DEnclosedAngle(Vector2D a, Vector2D b)
	{
		double angle = 0.0;
		
		try
		{			
			angle = radToDegree(acos(get2DScalarProduct(a,b) / (get2DAbsoluteValue(a) * get2DAbsoluteValue(b))));
			
			return angle; 
		}
		catch (ArithmeticException e) 
		{
		    System.out.println("Result is not valid!");
		}
		return angle; 
	}
	
	/**
	 * Returns the distance between a point and a straight line.
	 *
	 * @param p Point2D object
	 * @param sv support vector
	 * @param dv direction vector 
	 * 
	 * @return double distance
	 */
	public static double get2DDistanceBetweenPointAndStraightLine(Point2D p, Vector2D sv, Vector2D dv)
	{
		double distance = 0.0;
		
		try
		{
			distance = get2DDeterminant(dv, differenceVector2D(generateVector2DFromPoint2D(p), sv)) / get2DAbsoluteValue(dv);
			return distance; 
		}
		catch (ArithmeticException e) 
		{
		    System.out.println("Result is not valid!");
		}
		return distance; 
	}
	
	/**
	 * Tests if a Point2D object (clickpos) lies within an acceptable distance range between a line and 
	 * a maximum distance from that line. A Point2D object on the line returns true as well. 
	 * The line is defined by two Point2D objects (a and b).
	 *
	 * @param range permissible vertical range from point to straight line
	 * @param a Point2D object
	 * @param b Point2D object
	 * @param clickpos Point2D object
	 * 
	 * @return boolean returns true if clickpos complies with criteria
	 */
	public static boolean checkIfVectorInRange(double range, Point2D a, Point2D b, Point2D clickpos)
	{
		Vector2D pv_a = generateVector2DFromPoint2D(a);		
		Vector2D pv_b = generateVector2DFromPoint2D(b);		
		Vector2D pv_clickpos = generateVector2DFromPoint2D(clickpos);
		
		double distance = abs(get2DDistanceBetweenPointAndStraightLine(clickpos, pv_a, differenceVector2D(pv_a, pv_b)));
		double angle_alpha = get2DEnclosedAngle(differenceVector2D(pv_a, pv_b), differenceVector2D(pv_clickpos, pv_b));
		double angle_beta = get2DEnclosedAngle(differenceVector2D(pv_b, pv_a), differenceVector2D(pv_clickpos, pv_a));
	
		if((distance <= range) && (angle_alpha <= 90.00) && (angle_beta <= 90.00)) 
		{
			return true;
		}
		return false;
	}
	
	
}
