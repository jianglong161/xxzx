package xxzx;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hysec.dao.UserMapper;
import com.cn.hysec.entity.User;
@RunWith(SpringJUnit4ClassRunner.class)
//这里使用test/resources/里面的spring-dao-test.xml整入了事务的配置，用于回滚操作
@ContextConfiguration({"classpath:spring-mybatis.xml"})
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用

public class TestDao {
	@Resource
	private UserMapper userDao;
	
	
	@Test
	public void testFindUserBy(){
		String account ="12";
		User user=userDao.findPassByAccount(account);
		System.out.println("-------------------"+user.toString());
	}
	@Test
	public void testFindUserByac(){
		String account="12";
		User user=userDao.findUserByUserName(account);
		System.out.println("---------sdd--------"+user.toString());
	}
	@Test
	public void testRole(){
		String account="12";
		String roleName=userDao.findRoles(account);
		System.out.println(roleName);
	}
}
