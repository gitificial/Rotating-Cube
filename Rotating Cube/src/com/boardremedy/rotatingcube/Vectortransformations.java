/** 
 *  @author keyboardroaster@gmail.com
 *  @version 0.1
 * */

package com.boardremedy.rotatingcube;

import static java.lang.Math.sin;
import static java.lang.Math.cos;

public class Vectortransformations
{
	final Matrixoperation mo = new Matrixoperation();

	/**
	 * Scales a 3D vector.
	 *
	 * @param vector Vector3D object to scale
	 * @param x scale in x-direction
	 * @param y scale in y-direction
	 * 
	 * @return double scaled Vector3D object
	 */
	Vector3D scale3DVector(Vector3D vector, double x, double y)
	{
		double[] vectorarray = new double[] {0,0,0};
		
		vectorarray[0] = vector.x;
		vectorarray[1] = vector.y;
		vectorarray[2] = vector.z;
		
		double[][] matrix = new double[][]{
			{x, 0, 0},
			{0, x, 0},
			{0, 0, 1}
		}; 

		vectorarray = mo.vectorMatrixMultiplication(vectorarray, matrix);
		
		vector.x = vectorarray[0];
		vector.y = vectorarray[1];
		vector.z = vectorarray[2];
		
		return vector;
	}
	
	
	Vector3D translation3DVector(Vector3D vector, double dx, double dy)
	{
		double[] vectorarray = new double[] {0,0,0};
		
		vectorarray[0] = vector.x;
		vectorarray[1] = vector.y;
		vectorarray[2] = vector.z;
		
		double[][] matrix = new double[][]{
			{1, 0, dx},
			{0, 1, dy},
			{0, 0, 1}
		}; 
		
		vectorarray = mo.vectorMatrixMultiplication(vectorarray, matrix);
		
		vector.x = vectorarray[0];
		vector.y = vectorarray[1];
		vector.z = vectorarray[2];
		
		return vector;
	}
	
	
	
	Vector3D rotation3DVector(Vector3D vector, double angle)
	{ 
		double[] vectorarray = new double[] {0,0,0};
		
		vectorarray[0] = vector.x;
		vectorarray[1] = vector.y;
		vectorarray[2] = vector.z;
		
		double[][] matrix = new double[][]{
			{cos(Vectoroperations.degreeToRad(angle)), -sin(Vectoroperations.degreeToRad(angle)), 0},
			{sin(Vectoroperations.degreeToRad(angle)), cos(Vectoroperations.degreeToRad(angle)), 0},
			{0, 					0, 1}
		}; 
		
		vectorarray = mo.vectorMatrixMultiplication(vectorarray, matrix);
		
		vector.x = vectorarray[0];
		vector.y = vectorarray[1];
		vector.z = vectorarray[2];
		
		return vector;
	
	}
	
	/**
	 * Rotation of a 4DVector object around the x-axis.
	 *
	 * @param vector 4DVector object
	 * @param winkel rotation angle
	 * @return Vector4D rotated 4DVector object
	 */
	Vector4D rotation3DaxisX(Vector4D vector, double angle)
	{ 
		double[] vectorarray = new double[] {0,0,0,0};
		
		vectorarray[0] = vector.x;
		vectorarray[1] = vector.y;
		vectorarray[2] = vector.z;
		vectorarray[3] = vector.a;
		
		double[][] matrix = new double[][]{
			{1, 0, 0, 0},
			{0, cos(Vectoroperations.degreeToRad(angle)), -sin(Vectoroperations.degreeToRad(angle)), 0},
			{0, sin(Vectoroperations.degreeToRad(angle)),cos(Vectoroperations.degreeToRad(angle)), 0},
			{0, 0, 0, 1}
		}; 
		
		vectorarray = mo.vectorMatrixMultiplication(vectorarray, matrix);
		
		vector.x = vectorarray[0];
		vector.y = vectorarray[1];
		vector.z = vectorarray[2];
		vector.a = vectorarray[3];
		
		return vector;
	
	}
	
	/**
	 * Rotation of a 4DVector object around the y-axis.
	 *
	 * @param vector 4DVector object
	 * @param winkel rotation angle
	 * @return Vector4D rotated 4DVector object
	 */
	Vector4D rotation3DaxisY(Vector4D vector, double angle)
	{ 
		double[] vectorarray = new double[] {0,0,0,0};
		
		vectorarray[0] = vector.x;
		vectorarray[1] = vector.y;
		vectorarray[2] = vector.z;
		vectorarray[3] = vector.a;
		
		double[][] matrix = new double[][]{
			{cos(Vectoroperations.degreeToRad(angle)), 0,sin(Vectoroperations.degreeToRad(angle)), 0},
			{0, 1, 0, 0},
			{-sin(Vectoroperations.degreeToRad(angle)), 0,cos(Vectoroperations.degreeToRad(angle)), 0},
			{0, 0, 0, 1}
		}; 
		
		vectorarray = mo.vectorMatrixMultiplication(vectorarray, matrix);
		
		vector.x = vectorarray[0];
		vector.y = vectorarray[1];
		vector.z = vectorarray[2];
		vector.a = vectorarray[3];
		
		return vector;
	
	}
	
	/**
	 * Rotation of a 4DVector object around the z-axis.
	 *
	 * @param vector 4DVector object
	 * @param winkel rotation angle
	 * @return Vector4D rotated 4DVector object
	 */
	Vector4D rotation3DaxisZ(Vector4D vector, double angle)
	{ 
		double[] vectorarray = new double[] {0,0,0,0};
		
		vectorarray[0] = vector.x;
		vectorarray[1] = vector.y;
		vectorarray[2] = vector.z;
		vectorarray[3] = vector.a;
		
		double[][] matrix = new double[][]{
			{cos(Vectoroperations.degreeToRad(angle)), -sin(Vectoroperations.degreeToRad(angle)), 0, 0},
			{sin(Vectoroperations.degreeToRad(angle)), cos(Vectoroperations.degreeToRad(angle)), 0, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 1}
		}; 
		
		vectorarray = mo.vectorMatrixMultiplication(vectorarray, matrix);
		
		vector.x = vectorarray[0];
		vector.y = vectorarray[1];
		vector.z = vectorarray[2];
		vector.a = vectorarray[3];
		
		return vector;
	
	}
	
	
	
	Vector3D shear3DVector(Vector3D vector, double sx, double sy)
	{
		double[] vectorarray = new double[] {0,0,0};
		
		vectorarray[0] = vector.x;
		vectorarray[1] = vector.y;
		vectorarray[2] = vector.z;
		
		double[][] matrix = new double[][]{
			{1, sx, 0},
			{sy, 1, 0},
			{0, 0, 1}
		}; 
		
		vectorarray = mo.vectorMatrixMultiplication(vectorarray, matrix);
		
		vector.x = vectorarray[0];
		vector.y = vectorarray[1];
		vector.z = vectorarray[2];
		
		return vector;

	}
	
}
