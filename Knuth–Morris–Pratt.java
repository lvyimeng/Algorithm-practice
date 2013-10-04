public static int KMP(String s,String sub){
		 int m=0,n=0;
		 int[] next=new int[sub.length()];
		 KMPtable(sub,next);
		 while(m+n<s.length()){
		   if(sub.charAt(n)==s.charAt(m+n)){
		     if(n==sub.length()-1) return m;
		     n++;
		   }else{
		     m=m+n-next[n];
		     if(next[n]>-1) n=next[n];
		     else n=0;
		   }
		 }
		 return -1;
}

private static void KMPtable(String sub,int[] next){
		int pos=2;
		int cnd=0;
		next[0]=-1;
		next[1]=0;
		while(pos<sub.length()){
		  if(sub.charAt(pos-1)==sub.charAt(cnd)){
		    cnd++;
		    next[pos]=cnd;
		    pos++;
		  }else if(cnd>0){
		    cnd=next[cnd];
		  }else{
		    next[pos]=0;
		    pos++;
		  }
		}
}
