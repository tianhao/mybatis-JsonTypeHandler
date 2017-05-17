package com.tianhaox.mybatis;

import com.tianhaox.mybatis.example.model.People;
import com.tianhaox.mybatis.example.model.Team;
import com.tianhaox.mybatis.example.service.TeamService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tianhaox.mybatis.example.model.People.Gender.FEMALE;
import static com.tianhaox.mybatis.example.model.People.Gender.MALE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created on 2017/5/15.
 */
public class MybatisJsonTest extends BaseBootTest {

    @Resource
    private TeamService teamService;

    @Test
    public void testReadWrite() {
        Team team = newTeam();
        teamService.insert(team);
        Team dbTeam = teamService.query(team.getId());
        assertEquals(team.getLeader(), dbTeam.getLeader());
        assertEquals(team.getMembers(), dbTeam.getMembers());
        assertTrue(samplingCheck(team.getEquipment()));
    }

    public boolean samplingCheck(Map<String, List<Map<String, Integer>>> equipment) {
        if (equipment == null || equipment.keySet().size() != 3) {
            return false;
        }
        // Office
        List<Map<String, Integer>> list = equipment.get("Office");
        if (list == null || list.size() != 2) {
            return false;
        }

        Map<String, Integer> map = list.get(1);
        if (map == null || map.keySet().size() != 2) {
            return false;
        }
        if (!map.get("Pen").equals(5)) {
            return false;
        }
        return true;
    }

    private Team newTeam() {
        Team team = new Team();
        People leader = new People();
        leader.setName("Jack");
        leader.setAge(20);
        leader.setGender(MALE);
        team.setLeader(leader);
        List<People> members = new ArrayList<People>();
        People member = new People();
        member.setName("John");
        member.setAge(18);
        member.setGender(MALE);
        members.add(member);
        member = new People();
        member.setAge(19);
        member.setGender(FEMALE);
        member.setName("Sara");
        members.add(member);
        team.setMembers(members);

        Map<String, List<Map<String, Integer>>> equipment = new HashMap<String, List<Map<String, Integer>>>();
        List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Mouse", 5);
        map.put("Keyboard", 8);
        list.add(map);
        map = new HashMap<String, Integer>();
        map.put("Pen", 5);
        map.put("Papery", 20);
        list.add(map);
        equipment.put("Office", list);

        list = new ArrayList<Map<String, Integer>>();
        map = new HashMap<String, Integer>();
        map.put("umbrella", 3);
        list.add(map);
        map = new HashMap<String, Integer>();
        map.put("rope", 10);
        list.add(map);
        equipment.put("Outdoor", list);

        list = new ArrayList<Map<String, Integer>>();
        equipment.put("X", list);
        team.setEquipment(equipment);
        return team;
    }

}
