public static String Manacher(String s){
	 String T=preProcess(s);
	 int n=T.length();
	 int[] cache=new int[n];
	 int C=0,R=0;
	 int maxLen = 0;
	 int centerIndex = 0;
	 for(int i=1;i<n-1;i++){
	   int mirror = 2*C-i; 
	   cache[i]=(R>i)?cache[mirror]:0;
	   while (T.charAt(i + 1 + cache[i])== T.charAt(i - 1 - cache[i]))
	     cache[i]++;
	   if (i+cache[i]>R) {
	     C=i;
	     R=i+cache[i];
	   }
	 }

	 for (int i = 1; i < n-1; i++) {
	   if (cache[i] > maxLen) {
	     maxLen = cache[i];
	     centerIndex = i;
	   }
	 } 
	 return s.substring((centerIndex-1-maxLen)/2,(centerIndex-1+maxLen)/2);
}
	
private static String preProcess(String s) {
		StringBuilder str=new StringBuilder();
		str.append('^');
		for(int i=0;i<s.length();i++)
		  str.append("#" + s.charAt(i));
		str.append("#$");
		return str.toString();
}
