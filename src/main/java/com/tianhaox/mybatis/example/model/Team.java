package com.tianhaox.mybatis.example.model;

import java.util.List;
import java.util.Map;

public class Team {
    private Integer id;

    private People leader;

    private List<People> members;

    // Generic nesting type
    private Map<String, List<Map<String,Integer>>> equipment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public People getLeader() {
        return leader;
    }

    public void setLeader(People leader) {
        this.leader = leader;
    }

    public List<People> getMembers() {
        return members;
    }

    public void setMembers(List<People> members) {
        this.members = members;
    }

    public Map<String, List<Map<String,Integer>>> getEquipment() {
        return equipment;
    }

    public void setEquipment(Map<String, List<Map<String,Integer>>> equipment) {
        this.equipment = equipment;
    }
}