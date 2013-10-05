public Class Brute-Force{
	
public static int BruteForce(String source,String sub){
  int source_index=0,sub_index=0,index=-1;
  while((source_index<source.length())&&(sub_index<sub.length())){
    if(source.charAt(source_index)==sub.charAt(sub_index)){
      source_index++;
      sub_index++;
    }else{
      source_index=source_index-sub_index+1;
      sub_index=0;
    }
    if(sub_index==sub.length()) return source_index-sub_index;
  }
  return -1;
}

}
