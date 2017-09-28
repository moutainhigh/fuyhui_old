package test;

import javax.annotation.Resource;

import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fujfu.pojo.admin.AdminVO;
import com.fujfu.service.admin.AdminServ;
import com.fujfu.service.util.MD5Utils;

@RunWith(SpringJUnit4ClassRunner.class)  
//@ContextConfiguration(locations = { "classpath:spring/spring-config.xml" })
@ContextConfiguration(locations = { "file:resources/spring/spring-config.xml" })
public class AdminServiceTest {
@Resource
private AdminServ adminServ;
@Test
public void test(){
	AdminVO admin = adminServ.findAdminById(1);
	System.out.println(admin.getRealname());
}
@Test
public void testUpdatePwd(){
	AdminVO admin = new AdminVO();
	admin.setAdminId(79);
	admin.setPassword(MD5Utils.MD5Encrypt("12345678"));
	adminServ.updateAdmin(admin);
}
@Test
public void testAdd() throws Exception{
	AdminVO admin = new AdminVO();
	admin.setUsername("a");
	admin.setRealname("a");
	admin.setPassword(MD5Utils.MD5Encrypt("12345678"));
	admin.setCreated(0);
	adminServ.addAdmin(admin);
}
@Test
public void testTranscation(){
	AdminVO admin1 = new AdminVO();
	admin1.setUsername("admin1");
	admin1.setRealname("admin1");
	admin1.setPassword(MD5Utils.MD5Encrypt("12345678"));
	admin1.setCreated(0);
	
	adminServ.addtest(admin1);
}
}
