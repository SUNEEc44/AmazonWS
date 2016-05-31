import java.io.*;
import java.util.*;
import java.util.Scanner;

public class compute {
  
  private static LinkedList<Integer> firstNumber = new LinkedList<Integer>();
  private static LinkedList<Integer> secondNumber = new LinkedList<Integer>();
  private static LinkedList<Integer> thirdNumber = new LinkedList<Integer>();
  
  private static void readInput() throws IOException{
    Scanner in = new Scanner(System.in);
    String arrayStrInput = in.nextLine();
	String[] strArray = arrayStrInput.split("->");
	for(int i = 0; i < strArray.length; i++) {
    	firstNumber.add(Integer.parseInt(strArray[i]));
	}
    
    arrayStrInput = in.nextLine();
	strArray = arrayStrInput.split("->");
	for(int i = 0; i < strArray.length; i++) {
    	secondNumber.add(Integer.parseInt(strArray[i]));
	}
    
    arrayStrInput = in.nextLine();
	strArray = arrayStrInput.split("->");
	for(int i = 0; i < strArray.length; i++) {
    	thirdNumber.add(Integer.parseInt(strArray[i]));
	}
    
  }
  
  private static void printOutput(LinkedList<Integer> sumOfThreeList){
    for(int i = 0 ; i < sumOfThreeList.size() ; i++){
      if( i+1 == sumOfThreeList.size())
      	System.out.print(sumOfThreeList.get(i));
      else{
      	System.out.print(sumOfThreeList.get(i)+"->");
      }
    }
  }
  
  /**
  * Compute sum of given three number stored in form of linked lists.
  *
  * @param firstNumber  : Linked list representation of first number.
  * @param secondNumber : Linked list representation of second number.
  * @param thirdNumber  : Linked list representation of third number.
  * 
  * return a likned list containing sum of three linked list.
  */
  private static LinkedList<Integer> sumOfThreeLinkedList(LinkedList<Integer> firstNumber, LinkedList<Integer> secondNumber, LinkedList<Integer> thirdNumber){
    /* Write your code here */
	  
	long iFirst=getNumber(firstNumber);
	long iSecond=getNumber(secondNumber);
	long iThird=getNumber(thirdNumber);
	
	long lCount=iFirst+iSecond+iThird;
	
	LinkedList<Integer> numbers=convertNumberToLinkedList(lCount);
	
	return numbers;
  }
  
  
  private static LinkedList<Integer> convertNumberToLinkedList(final long number){
	  
	  LinkedList<Integer> numbers=new LinkedList<Integer>();
	  
	  long moduleNumber=number;
	  
	  do{
		  numbers.add((int)(moduleNumber%10));
		  moduleNumber=moduleNumber/10;
	  }while(moduleNumber!=0);
	  
	  Collections.reverse(numbers);
	  
	  return numbers;
	  
  }
  
  
  private static long getNumber(LinkedList<Integer> number)
  {
	  long computedNumber=-999;
	  
	  if(number!=null && !number.isEmpty())
 {

			Iterator<Integer> firstNumberIterator = number.iterator();

			int iValue = 0;

			while (firstNumberIterator.hasNext()) {
				iValue = firstNumberIterator.next();

				if (computedNumber == -999) {
					computedNumber = iValue;
				} else {
					computedNumber = computedNumber * 10 + iValue;
				}

			}
		}
	  
	  return computedNumber==-999?0:computedNumber;
  }
  public static void main(String args[]) throws IOException {
//    readInput();
    firstNumber.add(4);
    firstNumber.add(5);
    firstNumber.add(1);
    firstNumber.add(4);
    
    
    
    secondNumber.add(5);
    secondNumber.add(0);
    
    
    thirdNumber.add(9);
    thirdNumber.add(5);
    thirdNumber.add(6);
    thirdNumber.add(8);
    thirdNumber.add(9);
    
    
    
    
    
    LinkedList<Integer> outputList = sumOfThreeLinkedList(firstNumber, secondNumber, thirdNumber);
    printOutput(outputList);
  }
}