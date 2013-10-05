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

}
