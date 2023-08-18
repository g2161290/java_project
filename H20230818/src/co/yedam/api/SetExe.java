package co.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class SetExe {
	public static void main(StringExe[] args) {
		// ArrayList, HashSet: 중복된 값 저장 불가
		
		Set<StringExe> set = new HashSet<>();
		set.add("Hong");
		set.add("Hwang");
		set.add("Kim");
		set.add("Hong");
		
		for(StringExe str : set) {
			System.out.println(str);
		}
		
		Set<Member> memberSet = new HashSet<>();
		memberSet.add(new Member(101,"Hong"));
		memberSet.add(new Member(102,"Hwang"));
		memberSet.add(new Member(103,"Kim"));
		for(Member str : memberSet) {
			System.out.println(str);
		}
	}
}
