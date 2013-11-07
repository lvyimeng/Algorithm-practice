import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Triangle {

	public static void main(String[] args) throws FileNotFoundException{
		File input=new File("./triangle.txt");//the path of the input file
		int max=maxvalue(input);
		System.out.println("the maximum total from top to bottom "+max);
	}
	
	public static int maxvalue(File input) throws FileNotFoundException{
		Scanner in=new Scanner(input);
		int[] helper1=new int[100];
		int[] helper2=new int[100];
		int line_num=0;//the number of the lines in the file
		while(in.hasNextLine()){
			String[] arr=in.nextLine().split(" ");
			caculate(arr,helper1,helper2);
			line_num++;
		}
		if(line_num%2==0) helper1=helper2;
		int max=helper1[0];
		for(int i=0;i<helper1.length;i++){
			if(helper1[i]>max) max=helper1[i];
		}
		return max;
	}
	
	private static void caculate(String[] arr,int[] helper1,int[] helper2){
		int n=arr.length;
		if(n%2==0) helper2[0]=Integer.parseInt(arr[0])+helper1[0]; 
		else helper1[0]=Integer.parseInt(arr[0])+helper2[0];
		for(int i=1;i<n;i++){
			if(n%2==0){
			  if(helper1[i-1]>=helper1[i]) helper2[i]=Integer.parseInt(arr[i])+helper1[i-1];
			  else helper2[i]=Integer.parseInt(arr[i])+helper1[i];
		    }else{
		      if(helper2[i-1]>=helper2[i]) helper1[i]=Integer.parseInt(arr[i])+helper2[i-1];
			  else helper1[i]=Integer.parseInt(arr[i])+helper2[i];
		    }
		}
	}
	

}
