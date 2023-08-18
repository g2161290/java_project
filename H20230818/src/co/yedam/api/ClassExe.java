package co.yedam.api;

import java.lang.reflect.Method;

public class ClassExe {
	public static void main(StringExe[] args) {
		try {
			Class cls = Class.forName("co.yedam.api.Member");
			Method[] methods = cls.getDeclaredMethods();
			for(Method meth : methods) {
				System.out.println(meth.getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
