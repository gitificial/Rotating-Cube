/** 
 *  @author keyboardroaster@gmail.com
 *  @version 0.1
 * */

package com.boardremedy.rotatingcube;

public class Matrixoperation 
{
	double[] vectorMatrixMultiplication(double[] vector, double[][] matrix)
	{
		double[] result = new double[vector.length];
		double sum;
		
		for(int n = 0; n < matrix.length; n++)
		{
			sum = 0.0;
			for(int m = 0; m < matrix.length; m++)
			{
				sum += matrix[m][n] * vector[m];
			}
			result[n] = sum;
		}
		return result;
	}
}
