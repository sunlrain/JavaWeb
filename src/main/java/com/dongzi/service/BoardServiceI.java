package com.dongzi.service;

//import com.dongzi.model.Tboard;
import com.dongzi.model.Tboard;
import com.dongzi.pageModel.Board;

import java.io.Serializable;

//import sy.pageModel.DataGrid;
//import sy.pageModel.User;

public interface BoardServiceI {
    public Serializable save(Tboard t);
    public Board add(Board t);
    public void delete(Board t);
    public Board edit(Board t);
    public Board find(Board t);
//public User save(User user);
//public User login(User user);
//public DataGrid datagrid(User user);
//public void remove(String ids);
//public User edit(User user);
//public void editUserInfo(User user);
}
