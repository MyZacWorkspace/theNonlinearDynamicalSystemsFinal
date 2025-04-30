package edu.monmouth;

public class NDySysClient 
{

	public static void main(String[] args) 
	{
		//System.out.println("Nonlinear Systems are cool");
		//Nautical Simulator app
		
		final int MATRIXDIM = 2;
		//First make an arrayOf arrays. Let it be 2 x 2
		//Assume this is derived from some sort of approximation
		//Has already been achieved from a nonlinear system
		//(power series, Jacobian Matrix, term removal...)
		int[][] windMatrix = new int[MATRIXDIM][MATRIXDIM]; 
		//Use this linear system as an example
		//https://tutorial.math.lamar.edu/Classes/DE/PhasePlane.aspx
		windMatrix[0][0] = 1;
		windMatrix[0][1] = 2;
		windMatrix[1][0] = 3;
		windMatrix[1][1] = 2;
 		
		int[] location_1 = {-1 , -1};
		//the matrix operation will return a vector from the location representing
		//the current state of wind
		
		printComponentDirectionVector(getMatrixOutput(windMatrix, location_1));

	}
	
	//Given a matrix and vector, return the vector from 
	// the matrix-vector multiplication (a linear combination)
	//Assume the length of theVector is the same as the number of columns
	//for theMatrix
	//This represents the formula Matrix(input_vector) = new_vector
	public static int[] getMatrixOutput(int theMatrix[][], int theVector[])
	{
		int[] combination = new int[2];
		
		//Compute a linear combination
		//Use a nested for-loop
		for(int c = 0 ; c < theMatrix[0].length ; c++)
		{
			for(int r = 0 ; r < theMatrix[0].length ; r++)
			{
				combination[r] += theMatrix[r][c] * theVector[c];
			}
		}
			
		return combination;
	}
	
	//Show a vector as a pair of components of influence
	public static void printComponentDirectionVector(int[] colVect)
	{
		//First determine the direction of influence
		String[] influence = new String[colVect.length];
		
		System.out.print("{ ");
		for(int i = 0; i < colVect.length ; i++)
		{
			if(i == 0)
			{
				if(colVect[i] < 0)
				{
					System.out.print("WESTWARD: " + colVect[i]);
				}
				else if(colVect[i] > 0)
				{
					System.out.print("EASTWARD: " + colVect[i]);
				}
				else
					System.out.print("NIL: " + colVect[i]);
			}
			else if(i == 1)
			{
				if(colVect[i] < 0)
				{
					System.out.print("SOUTHWARD: " + colVect[i]);
				}
				else if(colVect[i] > 0)
				{
					System.out.print("NORTHWARD: " + colVect[i]);
				}
				else
					System.out.print("NIL: " + colVect[i]);
			}
				
			
			if(i < colVect.length - 1)
			{
				System.out.print(" , ");
			}
			else
				System.out.println(" }");
		}
		
		
	}
	
	public static void printLocation(int[] location)
	{
		System.out.println("@ coordinates [ " + location[0] + " , " + location[1] + " ]");
	}
	
	
	//Print the combined horizontal and vertical components of this vector
	//As a merged polar coordinate -- the combined value and angle.
	public static void printMergedDirectionVector(int[] colVect)
	{
		
	}

}
