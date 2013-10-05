public Class Heapsort{

public static void heapsort(int[] arr){
	heapify(arr);
	int n=arr.length-1;
	while(n>0){
	  int temp=arr[0];
	  arr[0]=arr[n];
	  arr[n]=temp;
	  shiftdown(arr,0,--n);
	}
}		

private static void heapify(int[] arr){
	int start=(arr.length-2)/2;
	while(start>=0){
		shiftdown(arr,start--,arr.length-1);
	}
}

private static void shiftdown(int[] arr,int start,int end){
	while(start*2+1<=end){
	  int swap=start;
	  int child=start*2+1;
	  if(arr[swap]<arr[child]) swap=child;
	  if(child+1<=end&&arr[swap]<arr[child+1]) swap=child+1;
	  if(swap!=start){
		  int temp=arr[swap];
		  arr[swap]=arr[start];
		  arr[start]=temp;
		  start=swap;
	  }else return;
    }
}

}
