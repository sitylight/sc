package com.dl.userserver.mapper;

import com.dl.userserver.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lcb 2019/9/14
 */
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {

}
