package com.ugJVMInternals.zad2.app;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.management.ObjectInstance;

import com.ugJVMInternals.zad2.app.exampleObj;

public class ObjToJsonConverter {

	public static void main(String[] args) {
		List<String> skills = new ArrayList<String>();
        skills.add("java");
        skills.add("python");
        skills.add("shell");
        
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
		
		exampleObj obj = new exampleObj("marJaN",10, "boczna", new BigDecimal("10000"),skills, numbers);
		String ans = "{\n";
		
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			ans += "\"";
			ans += field.getName();
			
			ans += "\"";
			System.out.println(field.toString());
			try {
				//ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
				
				
				if(field.getType().toString().contains("List")){
					ans += ": [";

					String lista = "" + field.get(obj);
					lista = lista.trim().replace(" ", "");
					Object[] objs = lista.substring(1, lista.length()-1).split(",");

					for (Object object : objs) {
						ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
				        Class<?> listClass = (Class<?>) stringListType.getActualTypeArguments()[0];
				        
						if(!listClass.toString().contains("String")){
							ans += object.toString() + ", ";
						}else
						ans += "\"" + object.toString() + "\", ";
					}
					ans = ans.substring(0, ans.length()-2) + "],\n";
				} else {
					ans += ": \"" + field.get(obj) + "\"";
					ans += ",\n";
				}

				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		ans = ans.substring(0, ans.length()-2);
		ans +="\n}";
		System.out.println(ans);

	}

}
