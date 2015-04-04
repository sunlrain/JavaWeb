package com.dongzi.dao.impl;

import org.springframework.stereotype.Repository;
import com.dongzi.dao.UserDaoI;
import com.dongzi.model.Tuser;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Tuser> implements UserDaoI {

}
