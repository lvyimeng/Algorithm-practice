public static void quicksort(int[] array,int left,int right){
	int index=partition(array,left,right);
	if(left<index-1){
		quicksort(array,left,index-1);
	}
	if(index<right){
		quicksort(array,index,right);
	}
}

private static int partition(int[] array,int left,int right){
	int pivot=array[(left+right)/2];
	while(left<=right){
		while(array[left]<pivot) left++;
		while(array[right]>pivot) right--;
		if(left<=right){
			int i=array[left];
			array[left]=array[right];
			array[right]=i;
			left++;
			right--;
		}
	}
	return left;
}
