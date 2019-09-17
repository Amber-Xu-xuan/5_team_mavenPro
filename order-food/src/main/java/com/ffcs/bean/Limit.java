package com.ffcs.bean;
/**
 * 
* @ClassName: Limit 
* @Description: TODO(权限实体) 
* @author 黄青才 
* @date 2019年8月30日 下午4:19:25 
*
 */
public class Limit extends User{
	//权限
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
