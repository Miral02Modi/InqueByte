package com.main.string;

public class StringCalculator {

	public static int add(String s1) {
		int sum = 0;
		if (s1 == null)
			return -1;
		s1 = s1.isEmpty() ? String.valueOf(0) : s1;
		char numbers[] = s1.toCharArray();
		boolean skip = false;
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			try {
				char ch = numbers[i];
				if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
					continue;
				}
				if (ch == '-' && (numbers[i + 1] <= '9' && numbers[i + 1] >= '1')) {
					skip = true;
					i = Integer.parseInt(getNumbers(numbers, i).split(",")[1]);
					throw new Exception("Invalid Number");
				}
				if ((ch == '\n' && numbers[i + 1] == ',') || (ch == ',' && numbers[i] == '\n'))
					return -1;
				if (ch >= '0' && ch <= '9') {
					if (!skip) {
						int number = Integer.parseInt(getNumbers(numbers, i).split(",")[0]);
						i = Integer.parseInt(getNumbers(numbers, i).split(",")[1]);
						if (number <= 1000) {
							count++;
							sum += Integer.parseInt(String.valueOf(ch));
						}
					} else {
						skip = false;
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Number of count is" + count);
		return sum;
	}

	public static String getNumbers(char[] numbers, int index) {
		StringBuilder num = new StringBuilder();
		for (; index < numbers.length; index++) {
			char ch = numbers[index];
			if (ch >= '0' && ch <= '9') {
				num.append(ch);
			} else {
				break;
			}
		}
		num.append(",");
		num.append(index - 1);
		return num.toString();
	}

	public static void main(String[] args) {
		System.out.println(add("//[**][%%]\n1**2%%3"));
	}
	public int div(){
		int a=20;
		int b=10;
		return(a/b);
	}
	// add new sub fun
	public int sub(){
		int a=20;
		int b=10;
		return(a-b);
	}
}
