public Class simplesort{

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

public static void selectionsort(int[] arr){
  for(int i=0;i<arr.length;i++){
    int min_index=i;
    for(int j=i+1;j<arr.length;j++){
      if(arr[j]<arr[min_index]){
        min_index=j;
      }
    }
    if(min_index!=i){
      int temp=arr[i];
      arr[i]=arr[min_index];
      arr[min_index]=temp;
    }
  }
}

}
