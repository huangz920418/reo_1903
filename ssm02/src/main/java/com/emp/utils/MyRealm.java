package com.emp.utils;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.emp.entity.User;
import com.emp.service.UserService;
 

 
/**
 * ��֤����¼��
 * ��Ȩ
 * �ĺ���ҵ���߼�
 */
public class MyRealm extends AuthorizingRealm {
 
	@Autowired
	private UserService userService;
 
	/**
	 * ��Ȩ����
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		/**
		 * ע��principals.getPrimaryPrincipal()��Ӧ
		 * new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName())�ĵ�һ������
		 */
		
		//��ȡ��ǰ���
		String userName = (String) principals.getPrimaryPrincipal();
		//��Ȩ��֤������Ҫ��ǰ��¼�û����еĽ�ɫ��Ȩ����Ϣ
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//�����ݿ��в��Ҹ��û��кν�ɫ��Ȩ��
		Set<String> roles = userService.queryRoles(userName);
		Set<String> permissions = userService.queryPermissions(userName);
		
		//Ϊ��Ȩ��֤�������Ӧ��ɫ��Ȩ��
		info.setRoles(roles);
		info.setStringPermissions(permissions);
		//��infoȡ�ж��û��Ƿ��з���ĳ����Դ������ĳ�ֲ�����Ȩ��
		return info;

	}
 
	/**
	 * ��֤����
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//��ȡ�û���
		String username = (String) token.getPrincipal();
		
		//�����ݿ��в����û���Ϣ
		User user = userService.queryUser(username);
		if (user == null) {
			return null;			
		}
		AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		return info;
	}
 
}
