public Class InsertSort{

public static void insertionsort(int[] arr){
  for(int i=0;i<arr.length;i++){
    int valuetoinsert=arr[i];
    int pos=i;
    while(pos>0&&valueinsert<arr[pos-1]){
      arr[pos]=arr[pos-1];
      pos--;
    }
    arr[pos]=valuetoinsert;
  }
}

public static void shellsort(int[] arr){
  int[] gaps={701,301,132,57,23,10,4,1};  
  for(int gap:gaps){
    for(int i=gap;i<arr.length;i++){
      int valuetoinsert=arr[i];
      int pos=i;
      while(pos>=gap&&valuetoinsert<arr[pos-gap]){
        arr[pos]=arr[pos-gap];
        pos-=gap;
      }
      arr[pos]=valuetoinsert;
    }
  }
}

}
