package com.dongzi.service.impl;

import com.dongzi.model.Tboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dongzi.dao.BaseDaoI;
//import sy.model.Tauth;
//import sy.model.Tmenu;
//import sy.model.Troletauth;
import com.dongzi.model.Tuser;
import com.dongzi.service.RepairServiceI;
//import sy.util.Encrypt;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("repairService")
public class RepairServiceImpl implements RepairServiceI {
//	private BaseDaoI<Tauth> authDao;
//	private BaseDaoI<Troletauth> roleauthDao;
//	private BaseDaoI<Tmenu> menuDao;
//
//	public BaseDaoI<Tauth> getAuthDao() {
//		return authDao;
//	}
//
//	@Autowired
//	public void setAuthDao(BaseDaoI<Tauth> authDao) {
//		this.authDao = authDao;
//	}
//
//	public BaseDaoI<Troletauth> getRoleauthDao() {
//		return roleauthDao;
//	}
//
//	@Autowired
//	public void setRoleauthDao(BaseDaoI<Troletauth> roleauthDao) {
//		this.roleauthDao = roleauthDao;
//	}
//
//	public BaseDaoI<Tmenu> getMenuDao() {
//		return menuDao;
//	}
//
//	@Autowired
//	public void setMenuDao(BaseDaoI<Tmenu> menuDao) {
//		this.menuDao = menuDao;
//	}

	@Autowired
	private BaseDaoI<Tuser> userDao;

	public BaseDaoI<Tuser> getUserDao() {
		return userDao;
	}

	public void setUserDao(BaseDaoI<Tuser> userDao) {
		this.userDao = userDao;
	}

	@Autowired
	private BaseDaoI<Tboard> boardDao;

	public BaseDaoI<Tboard> getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(BaseDaoI<Tboard> boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public void repair() {
		repairUser();
		repairBoard();
//		repairAuth();
	}

	private void repairBoard() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "admin");
		Tboard t = boardDao.getObject("from Tboard t where t.name=:name and t.id !='0'", params);
		if (t != null) {
			t.setName(UUID.randomUUID().toString());
		}
		Tboard board = new Tboard();
		board.setId("0");
		board.setName("844G-1");
//		admin.setPwd(Encrypt.e("admin"));
		board.setFsan("CXNK12345678");
		board.setMac("000631010203");
		board.setSn("2614020112340000");
		board.setOwner("Kevin");
		board.setNote("Test first board");
		boardDao.saveOrUpdate(board);
	}

	private void repairUser() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "admin");
		Tuser t = userDao.getObject("from Tuser t where t.name=:name and t.id !='0'", params);
		if (t != null) {
			t.setName(UUID.randomUUID().toString());
		}
		Tuser admin = new Tuser();
		admin.setId("0");
		admin.setName("admin");
//		admin.setPwd(Encrypt.e("admin"));
		admin.setPwd("admin");
		admin.setCreatedatetime(new Date());
		userDao.saveOrUpdate(admin);
	}

}
