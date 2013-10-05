public static void bubblesort(int[] arr){
  for(int i=0;i<arr.length;i++){
    for(int j=arr.length-1;j>i;j--){
      if(arr[j]<arr[i]){
	int n=arr[j];
	arr[j]=arr[i];
	arr[i]=n;
       }
     }
   }
}
