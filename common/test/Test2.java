package test;

import java.util.Scanner;

import org.junit.Test;

public class Test2 {
	@Test
	public void testa() {
		double[] score = new double[4];
		for(int i=0;i<score.length;i++){
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入第"+ (i+1) +"个double类型的值：");
			score[i] = scanner.nextDouble();
		}
		for(double d : score){
			System.out.println(d);
		}
	}

}
