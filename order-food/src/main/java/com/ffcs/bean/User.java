package com.ffcs.bean;
/**
 * 
* @ClassName: User 
* @Description: TODO(�û���Ϣʵ��) 
* @author ����� 
* @date 2019��8��27�� ����11:35:58 
*
 */
public class User {
	//���� 
   private Integer id;
   //�˺�
   private String phoneNumber;
   //����
   private String userName;
   //����
   private String password;
   //Ȩ��
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
