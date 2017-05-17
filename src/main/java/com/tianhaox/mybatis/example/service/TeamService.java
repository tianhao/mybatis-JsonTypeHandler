package com.tianhaox.mybatis.example.service;

import com.tianhaox.mybatis.example.model.Team;

import java.util.List;

/**
 * Created on 2017/5/16.
 * authors tianhao
 */
public interface TeamService {

    int insert(Team record);

    Team query(Integer id);

    List<Team> queryAll();
}
