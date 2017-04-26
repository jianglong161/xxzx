package xxzx;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class TestShiroRelm implements Realm{

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String) token.getPrincipal();
		String passworld=new String( (char[])token.getCredentials());
		if (!"jack".equals(userName)) {
			throw new UnknownAccountException();
		}
		if (!"123".equals(passworld)) {
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(userName,passworld,getName());
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "zhanglong";
	}

	public boolean supports(AuthenticationToken token) {
		// 仅支持UserNamePassworldToken类型的Token
		return token instanceof UsernamePasswordToken;
	}

}
