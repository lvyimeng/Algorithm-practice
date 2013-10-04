public static void mergesort(int[] arr){
	int[] helper=new int[arr.length];
	mergesort(arr,helper,0,arr.length-1);
}

private static void mergesort(int[] arr,int[] helper,int low,int high){
	if(low<high){
		int mid=(low+high)/2;
		mergesort(arr,helper,low,mid);
		mergesort(arr,helper,mid+1,high);
		merge(arr,helper,low,mid,high);
	}
}

private static void merge(int[] arr,int[] helper,int low,int mid,int high){
	for(int i=low;i<=high;i++){
		helper[i]=arr[i];
	}
	int helpleft=low,helpright=mid+1,current=low;
	while(helpleft<=mid&&helpright<=high){
		if(helper[helpleft]<=helper[helpright]){
			arr[current]=helper[helpleft];
			helpleft++;
		}else{
			arr[current]=helper[helpright];
			helpright++;
		}
		current++;
	}
	int remaining=mid-helpleft;
	for(int i=0;i<=remaining;i++){
		arr[current+i]=helper[helpleft+i];
	}
}
