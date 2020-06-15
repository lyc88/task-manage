package cn.org.dianjiu.security.dao;

import cn.org.dianjiu.security.model.Menu;
import cn.org.dianjiu.security.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuDao {

	/**
	 * 根据角色获取菜单列表
	 * @param roles
	 * @return
	 */
	List<Menu> getRoleMenuByRoles(@Param("roles")List<Role> roles);

}
