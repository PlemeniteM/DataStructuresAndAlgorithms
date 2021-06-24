import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf,int count){
        if(str.length()==0){
            if(count>0)asf+=count;
            System.out.println(asf);
            return;
        }
        char c=str.charAt(0);

        if(count>=1)
           solution(str.substring(1),asf+count+c,0);
        else
           solution(str.substring(1),asf+c,count);
       
        solution(str.substring(1),asf,count+1);   
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0);
    }
    
    
}