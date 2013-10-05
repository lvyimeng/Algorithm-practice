public Class Radixsort{

public static void radixsort(int[] arr,int digit_num){
  int bucket_x=10;
  int[][] bucket=new int[bucket_x][arr.length];
  int[] helper=new int[bucket_x];
  for(int i=1;i<=Math.pow(bucket_x, digit_num);i*=10){
     for(int j=0;j<arr.length;j++){
       int lsd=arr[j]/i%bucket_x;
       bucket[lsd][helper[lsd]++]=arr[j];
     }
     int n=0;
     for(int j=0;j<bucket_x;j++){
       for(int k=0;k<helper[j];k++){
         arr[n]=bucket[j][k];
         n++;
       }
       helper[j]=0;
     }
  }
}

}
