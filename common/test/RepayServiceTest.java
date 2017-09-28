package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fujfu.service.repay.RepayServ;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring/spring-config.xml" })
public class RepayServiceTest {
	@Resource
	private RepayServ repayServ;
	@Test
	public void test1(){
//		System.out.println(repayServ.repayment(3067, 1));
	}
}
