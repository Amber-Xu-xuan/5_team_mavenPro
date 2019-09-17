package com.ffcs.bean;
/**
 * 
* @ClassName: User 
* @Description: TODO(用户信息实体) 
* @author 黄青才 
* @date 2019年8月27日 上午11:35:58 
*
 */
public class User {
	//主键 
   private Integer id;
   //账号
   private String phoneNumber;
   //姓名
   private String userName;
   //密码
   private String password;
   //权限
   private String role;

   public String getRole() {
	   return role;
   }
   public void setRole(String role) {
	   this.role = role;
   }
   public Integer getId(){
	   return id;
   }
   public void setId(Integer id) {
	   this.id = id;
   }

   public String getPhoneNumber() {
	   return phoneNumber;
   }
   public void setPhoneNumber(String phoneNumber) {
	   this.phoneNumber = phoneNumber;
   }
   public String getUserName() {
	   return userName;
   }
   public void setUserName(String userName) {
	   this.userName = userName;
   }
   public String getPassword() {
	   return password;
   }
   public void setPassword(String password) {
	   this.password = password;
   }
   @Override
   public String toString() {
	   return "User [id=" + id + ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", password=" + password
			+ ", role=" + role + "]";
   }

}
