package com;

public class SeatingArrangement {
	
	private void arrange(int rows, int columns, int firstRowIndex,int lastRowIndex){
		for(int currentRow=0;currentRow<rows;currentRow++){
			if(currentRow%2==0){//to check if it is first row or not
				for(int currentColumn=firstRowIndex;currentColumn<columns;){
					System.out.print("(" + currentRow +","+ currentColumn + ") ");
					currentColumn=currentColumn+3;
				}
			}else{
				for(int currentColumn=lastRowIndex;currentColumn<columns;){
					System.out.print("(" + currentRow +","+ currentColumn + ") ");
					currentColumn=currentColumn + 3;
				}
			}
		}
	}
	public static void main(String[] args) {
		int totalStudents = 12;
		int rows = 2;
		int columns = totalStudents/2;
		/**
		 * First Row will be like Maths Physics Chemistry.
		 * so the 3rd argument is for starting position in first row. 
		 * i.e Maths at 0th index, Physics at 1st index, Chemistry at 3rd index
		 * **
		 * Second Row will be like Physics Chemistry Maths.
		 * so the 4th argument is for starting in second row.
		 * i.e Physics at 0th index, Chemistry at 1st index, Maths at 3rd index
		 * *
		 * M P C M P C....
		 * P C M P C M...
		 * */
		SeatingArrangement sa = new SeatingArrangement();
		//Arrangement for Maths students
		System.out.print("Maths Students - ");
		sa.arrange(rows, columns, 0,2);
		System.out.println("");
		//Arrangement for Physics students
		System.out.print("Physics Students - ");
		sa.arrange(rows, columns, 1,0);
		System.out.println("");
		//Arrangement for Chemistry students
		System.out.print("Chemistry Students - ");
		sa.arrange(rows, columns, 2,1);
		System.out.println("");
		
		
	}

}
