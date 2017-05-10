package xxzx;

import java.util.List;

import javax.annotation.Resource;
import javax.resource.spi.AuthenticationMechanism;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hysec.dao.QueryofficeSuppliesMapper;
import com.cn.hysec.entity.QueryofficeSupplies;
import com.cn.hysec.entity.UserPermission;
import com.cn.hysec.entity.UserRole;
import com.cn.hysec.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={
        "classpath:spring-mybatis.xml"
       
    })
public class TestQueryofficeSupplies {
	@Resource
	private QueryofficeSuppliesMapper oQueryofficeSupplies;
	@Resource
	private UserService userService;
	private static Logger logger = Logger.getLogger(TestMyBatis.class);  
	@Test
	public void testqueery(){
		List<QueryofficeSupplies> list=	oQueryofficeSupplies.queryOffice(12);
		System.out.println("------------" +list.toString());
	}
	@Test
	public void testRole(){
		String account="12";
		UserPermission roleName=userService.findPermissions(account);
		System.out.println("-------------------"+roleName);
	}
}
