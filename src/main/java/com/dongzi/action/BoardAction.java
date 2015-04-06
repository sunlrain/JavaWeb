package com.dongzi.action;

import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.dongzi.action.base.BaseAction;
import com.dongzi.pageModel.Json;
import com.dongzi.pageModel.Board;
import com.dongzi.service.BoardServiceI;
//import sy.util.IpUtil;
//import sy.util.ResourceUtil;

@ParentPackage("dongzi")
@Namespace("/")
@Action(value = "board", results = {@Result(type = "json") })
public class BoardAction extends BaseAction implements ModelDriven<Board> {
	private static final Logger logger = Logger.getLogger(BoardAction.class);
	Board board = new Board();

	public Board getModel() {
		return board;
	}

	@Autowired
	private BoardServiceI boardService;

	public BoardServiceI getBoardService() {
		return boardService;
	}

	public void setBoardService(BoardServiceI boardService) {
		this.boardService = boardService;
	}

	public void add() throws Exception {
		Json j = new Json();
		try {
			Board u = boardService.add(board);
			j.setSuccess(true);
			j.setMsg("Add Success");
			j.setObj(u);
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("Add Fail");
		}
		writeJson(j);
	}

	public void delete() {
		boardService.delete(board);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("Delete Success");
		writeJson(j);
	}

	public void edit() {
		Board u = boardService.edit(board);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("Edit success");
		j.setObj(u);
		writeJson(j);
	}

}
