package com.dongzi.service.impl;

import com.dongzi.dao.BaseDaoI;
import com.dongzi.model.Tboard;
import com.dongzi.pageModel.Board;
import com.dongzi.service.BoardServiceI;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

//import sy.pageModel.DataGrid;
//import sy.pageModel.User;
//import sy.util.Encrypt;

@Service("boardService")
@Transactional
public class BoardServiceImpl implements BoardServiceI {
	private static final Logger logger = Logger.getLogger(BoardServiceImpl.class);
	private DateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	private BaseDaoI<Tboard> boardDao;

	public BaseDaoI<Tboard> getBoardDao() {
		return boardDao;
	}

	@Autowired
	public void setBoardDao(BaseDaoI<Tboard> boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Serializable save(Tboard t) {
		return boardDao.save(t);
	}

	@Override
	public Board add(Board board) {
		Tboard tb = new Tboard();
		BeanUtils.copyProperties(board, tb);
		tb.setId(UUID.randomUUID().toString());
//		t.setPwd(Encrypt.e(user.getPwd()));
//		t.setCreatedatetime(new Date());
		boardDao.save(tb);
		BeanUtils.copyProperties(tb, board);
		return board;
//		return null;
	}

	@Override
	public void delete(Board t) {
		return ;
	}

	@Override
	public Board edit(Board t) {
		return null;
	}

	@Override
	public Board find(Board t) {
		return t;
	}
}
