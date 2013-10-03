public static ArrayList<String> LCS(String s1,String s2){
	  int[][] arr=new int[s1.length()][s2.length()];
	  ArrayList<String> lcs=new ArrayList<String>();
	  int max=0;
	  for(int i=0;i<s1.length();i++){
	    for(int j=0;j<s2.length();j++){
	      if(s1.charAt(i)==s2.charAt(j)){
	        if(i==0||j==0) arr[i][j]=1;
	        else arr[i][j]=arr[i-1][j-1]+1;
	        if(max<arr[i][j]){
	        	max=arr[i][j];
	        	lcs.removeAll(lcs);
	        	lcs.add(s1.substring(i-max+1,i+1));
	        }
	        else if(max==arr[i][j]) {lcs.add(s1.substring(i-max+1,i+1));}
	      }
	    }
	  }
	  return lcs;
}
