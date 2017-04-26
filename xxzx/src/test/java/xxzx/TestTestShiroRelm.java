package xxzx;

import javax.security.auth.Subject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.springframework.cache.ehcache.EhCacheCache;

public class TestTestShiroRelm {
	@Test
	public void main(){
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<SecurityManager> factory=
				new IniSecurityManagerFactory("classpath:Shiro-realm.ini");
		//2、得到SecurityManager实例 并绑定给SecurityUtils
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		 //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("jack","123");
		try {
			subject.login(token);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(subject.isAuthenticated());
		subject.logout();
				
		
	}
	
}
