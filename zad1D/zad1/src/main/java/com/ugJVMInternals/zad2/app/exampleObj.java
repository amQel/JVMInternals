package com.ugJVMInternals.zad2.app;

import java.math.BigDecimal;
import java.util.List;

public class exampleObj {

		private String name;
		private int age;
		private String position;
		private BigDecimal salary;
		private List<String> skills;
		private List<Integer> numbers;
		
		public exampleObj(String name, int age, String position, BigDecimal salary, List<String> skills, List<Integer> numbers) {
			super();
			this.name = name;
			this.age = age;
			this.position = position;
			this.salary = salary;
			this.skills = skills;
			this.numbers = numbers;
		}
		
		public List<Integer> getNumbers() {
			return numbers;
		}

		public void setNumbers(List<Integer> numbers) {
			this.numbers = numbers;
		}

		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public BigDecimal getSalary() {
			return salary;
		}
		public void setSalary(BigDecimal salary) {
			this.salary = salary;
		}
		public List<String> getSkills() {
			return skills;
		}
		public void setSkills(List<String> skills) {
			this.skills = skills;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		
}
