package com.tianhaox.mybatis.example.service;

import com.tianhaox.mybatis.example.mapper.TeamMapper;
import com.tianhaox.mybatis.example.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2017/5/16.
 * authors tianhao
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public int insert(Team record) {
        return teamMapper.insert(record);
    }

    @Override
    public Team query(Integer id) {
        return teamMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Team> queryAll() {
        return teamMapper.selectAll();
    }
}
