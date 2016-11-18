package com.joson.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.joson.bean.User;

/***
 ** @Author JosonLiu
 ** @Date 2016年9月10日
 ** @Version 1.0
 **/
@ContextConfiguration("classpath:spring/appContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {//
	@Autowired
	private UserMapper userMapper;
	@Test
	public void test_batchInsert(){
		List<User> list = Lists.newArrayList();
		for (int i = 0; i < 10; i++) {
			User record = new User();
			record.setUserId(genUid());
			record.setUserName("TestUser"+i);
			record.setUserSchool("华南师范");
			record.setUserAge(25+i);
			list.add(record);
		}
		int batchInsert = userMapper.batchInsert(list);
		assertTrue(batchInsert == 10 );
	}
	@Test
	public void test_insertUser(){//新增用户测试
		User record = new User();
		record.setUserId(genUid());
		record.setUserName("JosonLiu");
		record.setUserSchool("华南师范");
		record.setUserAge(25);
		int insertUser = userMapper.insertUser(record);
		assertTrue(insertUser == 1);
	}
	@Test 
	public void test_insertUserAndReturn(){//插入用户并返回用户自增主键的值
		User record1 = new User();
		record1.setUserId(genUid());
		record1.setUserName("record1");
		record1.setUserSchool("中山大学");
		record1.setUserAge(26);
		int result1 = userMapper.insertUserAndReturn(record1);
		assertTrue(result1 == 1);//表明插入成功
		assertTrue(record1.getId() > 0 );//表明ID回写成功
		User record2 = new User();
		record2.setUserId(genUid());
		record2.setUserName("record2");
		record2.setUserSchool("中山大学");
		record2.setUserAge(26);
		int result2 = userMapper.insertUserAndReturn(record2);
		assertTrue(result2 == 1);
		assertTrue(record2.getId() == record1.getId() + 1);//表明 ID是自增的
	}
	@Test 
	public void test_selectAll(){//获取全部纪录测试//
		List<User> selectAll = userMapper.selectAll();
		assertTrue(selectAll != null );
		assertTrue(selectAll.size() > 0);
		for (User each : selectAll) {
			System.out.println(each);
		}
	}
	@Test
	public void test_selectByPage(){//分页获取纪录测试 
		List<User> selectByPage = userMapper.selectByPage(0, 5);
		assertTrue(selectByPage != null );
		assertTrue(selectByPage.size() <= 5 && selectByPage.size() > 0);
		for (User each : selectByPage) {
			System.out.println(each);
		}
	}
	@Test
	public void test_selectByIdList(){// 根据主键 id 的列表 获取对应的用户纪录列表
		List<Integer> ids = Lists.newArrayList(1,2);
		List<User> selectByIdList = userMapper.selectByIdList(ids);
		assertTrue(selectByIdList != null );
		assertTrue(selectByIdList.size() == 2);
		for (User each : selectByIdList) {
			System.out.println(each);
		}
	}
	@Test
	public void test_multiCriteria(){//直接的多重条件查询 适合条件较少的情况  最多不要超过3个 超过3个建议用MAP
		String school = "%大学%";
		Integer age = 26 ;
		/**
		 * 根据学校模糊匹配 且 年龄为 26 的用户
		 */
		List<User> multiCriteria = userMapper.multiCriteria(school, age);
		assertTrue(multiCriteria != null );
		assertTrue(multiCriteria.size() > 1);
		for (User each : multiCriteria) {
			System.out.println(each);
		}
	}
	@Test
	public void test_multiCriteriaWithMap(){//多重条件查询 适合条件超过3个及以上的情况
		String school = "%华南%";
		Integer age = 25 ;
		/**
		 * 根据学校模糊匹配 且 年龄为 26 的用户
		 */
		Map<String, Object> map = Maps.newHashMap();
		map.put("school", school);
		map.put("age", age);
		List<User> multiCriteria = userMapper.multiCriteriaWithMap(map);
		assertTrue(multiCriteria != null );
		assertTrue(multiCriteria.size() > 1);
		for (User each : multiCriteria) {
			System.out.println(each);
		}
	}
	/**
	 * 随机生成唯一用户UID
	 * @return
	 */
	private String genUid(){
		return UUID.randomUUID().toString();
	}
}

