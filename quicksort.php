<?php
function quicksort(&$arr,$left,$right){
	$index=partition($arr,$left,$right);
	if($left<$index-1) quicksort($arr,$left,$index-1);
	if($index<$right) quicksort($arr,$index,$right);
}

function partition(&$arr,$left,$right){
	$pivot=$arr[($left+$right)/2];
	while($left<=$right){
		while($pivot>$arr[$left]) $left++;
		while($pivot<$arr[$right]) $right--;
		if($left<=$right){
			$s=$arr[$left];
			$arr[$left]=$arr[$right];
			$arr[$right]=$s;
			$left++;
			$right--;
		}
	}
	return $left;
}
?>
