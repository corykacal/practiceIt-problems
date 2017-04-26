//Java recurssion practice problems from Basics of Java Programming 4th edition

/*  write a method starString that accepts an integer parameter n and returns a string of stars (asterisks) 2n long (i.e., 2 to the nth power). For example:
 *	Call 	        Output 				Reason
 *	starString(0); 	"*" 	   			2^0 = 1
 *	starString(1); 	"**" 	     		2^1 = 2
 *	starString(2); 	"****" 				2^2 = 4
 *	starString(3); 	"********" 			2^3 = 8
 *	starString(4); 	"****************" 	2^4 = 16
 */
public static String starString(int n) {
    if(n < 0) {
    	throw new IllegalArgumentException("Must enter value equal to or greater than 0. Cannot print 2^" + n + " stars.");
    }
    if(n == 0) {
        return "*";
    } else {
        return starString(n - 1) + starString(n - 1);
    }
}

/*  Write a method writeNums that accepts an integer parameter n and prints the first n integers starting with 1 
 *	in sequential order, separated by commas. For example, the following calls produce the following output:
 *	Call 			Output
 *	writeNums(5); 	1, 2, 3, 4, 5
 *	writeNums(12); 	1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
 */
public static void writeNums(int n) {
    if(n<1) {
    	throw new IllegalArgumentException("Must enter a value equal to or greater than 1. " + n + " is not a valid integer.");
    }
    if(n == 1) {
        System.out.print("1");
    } else {
        writeNums(n - 1);
        System.out.print(", " + n);
    }
}

/*  Write a method writeSequence that accepts an integer n as a parameter and prints a
* symmetric sequence of n numbers with descending integers ending in 1 followed by ascending *integers beginning with 1, as in the table below:
* Call 	Output
* writeSequence(1); 	1
* writeSequence(2); 	1 1
* writeSequence(3); 	2 1 2
* writeSequence(4); 	2 1 1 2
* writeSequence(5); 	3 2 1 2 3
* writeSequence(6); 	3 2 1 1 2 3
* writeSequence(7); 	4 3 2 1 2 3 4
* writeSequence(8); 	4 3 2 1 1 2 3 4
* writeSequence(9); 	5 4 3 2 1 2 3 4 5
* writeSequence(10); 	5 4 3 2 1 1 2 3 4 5
*/
public static void writeSequence(int n) {
    if(n < 1) {
        throw new IllegalArgumentException("Passed value is not greater than or equal to 1");
    }
    if(n == 1) {
        System.out.print("1");
    } else if (n == 2) {
        System.out.print("1 1");
    } else {
        int writeNumber = (n + 1) / 2;
        System.out.print(writeNumber + " ");
        writeSequence(n - 2);
        System.out.print(" " + writeNumber);
    }
}

/*  Write a method writeSquares that accepts an integer parameter n and prints the first n squares separated by commas, with the odd squares in descending order followed by the even squares * in ascending order. The following table shows several calls to the method and their expected output:
* Call 	Valued Returned
* writeSquares(5); 	25, 9, 1, 4, 16
* writeSquares(1); 	1
* writeSquares(8); 	49, 25, 9, 1, 4, 16, 36, 64
*/
public static void writeSquares(int n) {
    if(n < 1) {
        throw new IllegalArgumentException("Passed in value must not be less than 1");
    }
    if(n==1) {
        System.out.print("1");
    } else {
          if(n%2 == 1) {
              System.out.print(n*n + ", ");
              writeSquares(n-1);
          } else {
              writeSquares(n-1);
              System.out.print(", " + n*n);
          }
    }
}

/*  Write a method multiplyEvens that returns the product of the first n even integers. For example:
* Call 	Output 	Reason
* multiplyEvens(1); 	2 	2 = 2
* multiplyEvens(2); 	8 	2 * 4 = 8
* multiplyEvens(3); 	48 	2 * 4 * 6 = 48
* multiplyEvens(4); 	384 	2 * 4 * 6 * 8 = 384
*/
public static int multiplyEvens(int n) {
    if(n <= 0) {
        throw new IllegalArgumentException("value must be greater than 0.");
    } else if(n == 1) {
        return n*2;
    } else {
        return multiplyEvens(n-1) * n*2;
    }
}

/*  Write a method sumTo that accepts an integer parameter n and returns the sum of the first n reciprocals. In other words:
*
*            sumTo(n) returns: 1 + 1/2 + 1/3 + 1/4 + ... + 1/n 
*/
public static double sumTo(double n) {
    if(n<0) {
        throw new IllegalArgumentException("Value must be greater than 0.");
    }
    if(0<=n && n<=1) {
        return n;
    } else {
        return sumTo(n-1) + 1/n;
    }
}

/*  Write a recursive method digitMatch that accepts two non-negative integers as parameters and that returns the number of digits that match between them. Two digits match if they are equal
* and have the same position relative to the end of the number (i.e. starting with the ones digit). In other words, the method should compare the last digits of each number, the second-to-last
* digits of each number, the third-to-last digits of each number, and so forth, counting how many pairs match. For example, for the call of digitMatch(1072503891, 62530841), the method would
* compare as follows:
*
* 1 0 7 2 5 0 3 8 9 1
*           |   |         |     |
*        6 2 5 3 0 8 4 1
*
* The method should return 4 in this case because 4 of these pairs match (2-2, 5-5, 8-8, and 1-1). 
*/
public static int digitMatch(int n, int m) {
    int count=0;
    if(n<0 || m<0)
        throw new IllegalArgumentException("wiwiww");
    if(n%10 == m%10) {
        count = 1;
    } 
    if(n>10 && m>10) {
        count += digitMatch(n/10, m/10);
    }
    return count;
}

/*  Write a recursive method repeat that accepts a string s and an integer n as parameters and that returns a String consisting of n copies of s. For example:
* Call 	Value Returned
* input:				   result:
* repeat("hello", 3) 	   "hellohellohello"
* repeat("this is fun", 1)   "this is fun"
* repeat("wow", 0) 	   ""
* repeat("hi ho! ", 5) 	   "hi ho! hi ho! hi ho! hi ho! hi ho! "
*/
public static String repeat(String text, int repeatCount) {
    if(repeatCount < 0) {
        throw new IllegalArgumentException("The number of times repeated must not be negetive");
    }
    if(repeatCount == 0) {
        return "";
    } else {
        return text + repeat(text, repeatCount-1);
    }
}

/* Write a recursive method isReverse that accepts two strings as a parameter and returns true if the two strings contain the same sequence of characters as each other but in the opposing order
* (ignoring capitalization), and false otherwise. For example, the string "hello" backwards is "olleh", so a call of isReverse("hello", "olleh") would return true. Since the method is case-insensitive, 
* you would also get a true result from a call of isReverse("Hello", "oLLEh"). The empty string, as well as any one-letter string, is considered to be its own reverse. The string could contain 
* characters other than letters, such as numbers, spaces, or other punctuation; you should treat these like any other character. The key aspect is that the first string has the same sequence of 
* characters as the second string, but in the opposite order, ignoring case. 
*/
public boolean isReverse(String foward, String reverse) {
    if(foward.length()!=reverse.length()) {
        return false;
    } else if(foward.length()==0&&reverse.length()==0) {
        return true;
    } else {
        return checkReverse(foward.toLowerCase(), reverse.toLowerCase());
    }
}

private boolean checkReverse(String foward, String reverse) {
    char front = foward.charAt(0);
    char back = reverse.charAt(reverse.length()-1);
    if(front!=back) {
        return false;
    } else if(foward.length()==1 && reverse.length()==1) {
        return true;
    } else {
        String newFoward = foward.substring(1, foward.length());
        String newReverse = reverse.substring(0, reverse.length()-1);
        return checkReverse(newFoward, newReverse);
    }
}

/* Write a recursive method indexOf that accepts two Strings as parameters and that returns the starting index of the first occurrence of the second String inside the first String (or -1 if not found). 
* The table below lists several calls to your method and their expected return values. Notice that case matters, as in the last example that returns -1. 
*/
public static int indexOf(String source, String target) {
    int startingIndex = 0;
    return findIndex(source, target, startingIndex);
}

private static int findIndex(String source, String target, int index) {
    if(source.length() < target.length()) {
        return -1;
    } else if(source.substring(0,target.length()).equals(target)) {
        return index;
    } else {
        return findIndex(source.substring(1), target, index+1);
    }
}

/* Write a method evenDigits that accepts an integer parameter n and that returns the integer formed by removing the odd digits from n. The following table shows several calls and their 
* expected return values: 
*/
public static int evenDigits(int n) {
    if (n == 0) {
        return 0;
    } else {
        int endNum = n % 10;
        if (endNum % 2 == 0) {
            return endNum + evenDigits(n / 10) * 10;
        } else {
            return evenDigits(n / 10);
        }
    }
}

/*  Write a method countBinary that accepts an integer n as a parameter and that prints all binary numbers that have n digits in ascending order, printing each value on a separate line. All n digits 
* should be shown for all numbers, including leading zeros if necessary. You may assume that n is non-negative. If n is 0, a blank line of output should be produced. Do not use a loop in your 
* solution; implement it recursively.
* Call followed by Output
*
*  countBinary(1);
*
* 0
* 1
*
* countBinary(2);
*
* 00
* 01
* 10
* 11
*
* countBinary(3);
*
* 000
* 001
* 010
* 011
* 100
* 101
* 110
* 111
*/
public static void countBinary(int n) {
    String startString = "";
    printBinary(n, startString);
}

private static void printBinary(int n, String binaryString) {
    if(n!=0) {
        printBinary(n-1, binaryString + "0");
        printBinary(n-1, binaryString + "1");
    } else {
        System.out.println(binaryString);
    }
}


