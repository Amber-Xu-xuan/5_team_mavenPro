package com.ffcs.bean;
/**
 * 
* @ClassName: Limit 
* @Description: TODO(Ȩ��ʵ��) 
* @author ����� 
* @date 2019��8��30�� ����4:19:25 
*
 */
public class Limit extends User{
	//Ȩ��
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Limit [role=" + role + "]";
	}
	

}
