package com.practice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.map.MultiValueMap;

public class Practice3 {
	
	
	public static void main(String[] args) {
		
		String[] list = new String[]{"aaa","bbb","cc","l","a","45ts","779"};
		
		MultiValueMap new_array= new MultiValueMap();
		List<String> list1 = new ArrayList<String>();
		for(int i=0;i<list.length;i++){
			/*System.out.println(list[i].length()+"-->>"+list[i]);*/
			new_array.put(list[i].length(), list[i]);
		}
		
		Set<Integer> keys = new_array.keySet();
		for(Integer k :keys){
			
			System.out.println(k+"-"+new_array.get(k));
		}
		System.out.println();
		
		String test = "home_skip_link=id->com.bigbasket.mobileapp:id/btnSkip";
		
		String t = test.split("->")[0];
		String s = test.split("->")[1];
		System.out.println(t);
		System.out.println(s);
	}

}
