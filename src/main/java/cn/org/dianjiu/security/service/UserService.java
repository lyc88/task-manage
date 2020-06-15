package cn.org.dianjiu.security.service;


import cn.org.dianjiu.security.model.UserEntity;

public interface UserService {
	/**
	 * 保存用户
	 * @param user
	 */
	void saveUser(UserEntity user);

}
