package com.joson.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.joson.bean.User;

public interface UserMapper {
    /**
    * 根据主键删除纪录：     表 user
    **/
    int deleteByPrimaryKey(Integer id);

    /**
    * 根据主键插入纪录：     表 user
    **/
    int insert(User record);

    /**
    * 根据主键获取纪录：     表 user
    **/
    User selectByPrimaryKey(Integer id);

    /**
    * 根据主键更新纪录：     表 user
    **/
    int updateByPrimaryKey(User record);
    /**
     * 批量插入
     * @param list
     * @return
     */
    int batchInsert(@Param("list") List<User> list );
    /**
     * 新增用户
     * @param record
     * @return 成功返回 1
     */
    int insertUser(User record );
    /**
     * 插入用户并返回用户的主键值
     * @param record
     * @return
     */
    int insertUserAndReturn(User record);
    /**
     * 获取所有用户信息
     * @return 用户信息列表
     */
    List<User> selectAll();
    /**
     * 分页获取用户信息
     * @param startIndex 起始索引
     * @param count 最大纪录数目
     * @return 返回 从 startIndex 起的最多 count 条纪录
     */
    List<User> selectByPage(@Param("startIndex") Integer startIndex,@Param("count") Integer count);
    /**
     * 根据主键ID 列表 获取对应的用户纪录 
     * @param ids ID 列表 
     * @return 用户信息列表 
     */
    List<User> selectByIdList(@Param("ids") List<Integer> ids);
    /**
     * 根据学校模糊查询 并结合年龄 进行多重查询
     * @param school 学校
     * @param age 年龄
     * @return 符合的用户列表
     */
    List<User> multiCriteria(@Param("school") String school,@Param("age") Integer age );
    /**
     * 多重条件查询 map 传递  
     * @param map  查询条件用 map 传递
     * @return 用户信息列表
     */
    List<User> multiCriteriaWithMap(Map<String, Object> map );
}