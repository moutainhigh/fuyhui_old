package test;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;

import com.fujfu.common.util.PropertyFileUtil;


public class Test1 {
	@Test
	public void test1(){
//		System.out.println(Test1.class.getClassLoader().getResourceAsStream("config/filePath.properties"));
		String recordPath1=PropertyFileUtil.getProperty("fkdApplyFilePath");
		File file = new File(recordPath1);
		System.out.println(file);
	}
	
	@Test
	public void test2(){
		String s ="13245678956".substring("13245678956".length()-6,"13245678956".length());
		System.out.println(s);
	}
	
	@Test
	public void test3(){
		BigDecimal bd = new BigDecimal(1000);  
	    BigDecimal bd1 = new BigDecimal(12);
		System.out.println(bd.divide(bd1,4,BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	public void test4(){
		BigDecimal bd = new BigDecimal(0.0045);  
		System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_UP));
	}

	@Test
	public void test5(){
		int i = 0;
		if(0==i){
			System.out.println("xxxx");
		}
	}
}
