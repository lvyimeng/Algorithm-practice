public static int binarysearch(int[] arr,int n){
  int low=0;
  int high=arr.length-1;
  int mid;
  while(low<=high){
    mid=(low+high)/2;
    if(arr[mid]<n) low=mid+1;
    else if(arr[mid]>n) high=mid-1;
    else return mid;
  }
  return -1;
}

public static int binarysearch(int[] arr,int n,int low,int high){
  if(low>high) return -1;
  int mid=(low+high)/2;
  if(arr[mid]<n) return binarysearch(arr,n,mid+1,high);
  else if(arr[mid]>n) return binarysearch(arr,n,low,mid-1);
  else return mid;
}
