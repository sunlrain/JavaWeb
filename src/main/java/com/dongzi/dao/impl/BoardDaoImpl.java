package com.dongzi.dao.impl;

import com.dongzi.dao.BoardDaoI;
import com.dongzi.model.Tboard;
import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDaoImpl extends BaseDaoImpl<Tboard> implements BoardDaoI {

}
