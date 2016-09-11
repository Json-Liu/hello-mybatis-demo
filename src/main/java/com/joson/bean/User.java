package com.joson.bean;

public class User {
    /**
     *  自增主键,所属表字段为user.id
     */
    private Integer id;

    /**
     *  用户UID,所属表字段为user.user_id
     */
    private String userId;

    /**
     *  用户昵称,所属表字段为user.user_name
     */
    private String userName;

    /**
     *  毕业学校,所属表字段为user.user_school
     */
    private String userSchool;

    /**
     *  用户年龄,所属表字段为user.user_age
     */
    private Integer userAge;

    /**
     * 获取 自增主键,
     * @return  id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键,id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户UID,
     * @return  user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户UID,user_id
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取 用户昵称,
     * @return  user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户昵称,user_name
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 毕业学校,
     * @return  user_school
     */
    public String getUserSchool() {
        return userSchool;
    }

    /**
     * 设置毕业学校,user_school
     * @param userSchool
     */
    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool == null ? null : userSchool.trim();
    }

    /**
     * 获取 用户年龄,
     * @return  user_age
     */
    public Integer getUserAge() {
        return userAge;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userName="
				+ userName + ", userSchool=" + userSchool + ", userAge="
				+ userAge + "]";
	}

	/**
     * 设置用户年龄,user_age
     * @param userAge
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}