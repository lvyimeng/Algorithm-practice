public Class simplesort{

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

public static void bubblesort(int[] arr){
  for(int i=arr.length-1;i>0;i--){
    for(int j=0;j<i;j++){
      if(arr[j]>arr[j+1]){
	arr[j]=arr[j+1]^arr[j];
	arr[j+1]=arr[j+1]^arr[j];
	arr[j]=arr[j+1]^arr[j];
      }
    }
  }
}

public static void oddevensort(int[] arr){
  boolean sorted=false;
  while(!sorted){
    sorted=true;
    for(int i=0;i<arr.length-1;i+=2){
      if(arr[i]>arr[i+1]){
        arr[i]=arr[i]^arr[i+1];
        arr[i+1]=arr[i]^arr[i+1];
        arr[i]=arr[i]^arr[i+1];
        sorted=false;
      }
    }
    for(int i=1;i<arr.length-1;i+=2){
      if(arr[i]>arr[i+1]){
        arr[i]=arr[i]^arr[i+1];
        arr[i+1]=arr[i]^arr[i+1];
        arr[i]=arr[i]^arr[i+1];
        sorted=false;
      }
    }
  }
}

public static void cocktailsort(int[] arr){
  boolean sorted=false;
  int bot=0;
  int top=arr.length-1;
  while(!sorted){
    sorted=true;
    for(int i=0;i<top;i++){
      if(arr[i]>arr[i+1]){
        arr[i]=arr[i]^arr[i+1];
        arr[i+1]=arr[i]^arr[i+1];
        arr[i]=arr[i]^arr[i+1];
        sorted=false;
      }
    }
    top--;
    for(int i=top;i>bot;i--){
      if(arr[i-1]>arr[i]){
        arr[i]=arr[i]^arr[i-1];
        arr[i-1]=arr[i]^arr[i-1];
        arr[i]=arr[i]^arr[i-1];
        sorted=false;
      }
    }
    bot++;
  }
}

}
