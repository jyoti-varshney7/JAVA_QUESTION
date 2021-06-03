Accolite Coding question 
(Bucket Problem)
Solve the puzzle

apply condition -
1 - if add 1  in one bucket so operation add by 1
2 - multiple of 2 in all bucket so operation add by 1

test case-
[2 ,3]
no of operation - 4

[16 , 16 , 16]
no of operation - 7

import java.util.*;
public class MyClass {
    
    public static int func1(int []targ){
     int x = targ.length;
     
     int[] arr = new int[x];
     
     int count = 0;
     int max = targ[0];
     for(int i=1;i<x;i++){
         if(targ[i] > max)
            max = targ[i];
     }
     int sqrt = (int)Math.sqrt(max);
     
     for(int i=0;i<x;i++)
        arr[i]++;
        
    count = x;
     
     while(sqrt-- > 0){
         int counter = 0;
         for(int i=0;i<x;i++){
            if(arr[i]*2 <= targ[i])
                counter++;
         }
         if(counter == x){
             for(int i=0;i<x;i++)  
                arr[i] = arr[i]*2;
         
             count++;
         }
     }
     
     for(int i=0;i<x;i++){
         count += (targ[i] - arr[i]); 
     }
     //System.out.println(sqrt);
     return count;
    }
    public static void main(String args[]) {
      Scanner sc =new Scanner(System.in);
      int x=sc.nextInt();
      int []arr = new int[x];
      
      for(int i=0;i<x;i++)
        arr[i] = sc.nextInt();

      System.out.println(func1(arr));
    }
}
