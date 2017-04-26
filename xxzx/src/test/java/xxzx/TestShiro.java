package xxzx;


import javax.security.auth.Subject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.*;

public class TestShiro {
	public static void main(String[] args) {
		 //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<SecurityManager>  factory=
				new IniSecurityManagerFactory("classpath:shiro.ini");
		 //2、得到SecurityManager实例 并绑定给SecurityUtils
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token =new UsernamePasswordToken("jack","123");
		try{
			subject.login(token);
			//判断是否有角色，没有则会抛出一场 
			subject.checkRole("role1");
			////判断是否有权限,没有则会抛出异常
			subject.checkPermission("user:update:1");
			//判断是是否还有角色
			System.out.println(subject.hasRole("role1"));
			System.out.println(subject.hasRole("role2"));
			System.out.println(subject.hasRole("role3"));
			   //判断有权限
            System.out.println(subject.isPermitted("user:update:1"));
            System.out.println(subject.isPermitted("user:delete:2"));
		}catch (AuthenticationException e) {
			// TODO: handle exception
		}
		System.out.println(subject.isAuthenticated());
		subject.logout();
	}
}
