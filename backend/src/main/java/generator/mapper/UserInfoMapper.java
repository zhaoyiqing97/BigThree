package generator.mapper;

import org.apache.ibatis.annotations.Param;

import generator.domain.UserInfo;

/**
 * @author HangZ
 * @description 针对表【user_info】的数据库操作Mapper
 * @createDate 2022-06-08 16:26:27 @Entity generator.domain.UserInfo
 */
public interface UserInfoMapper {

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    UserInfo selectByUserName(@Param("userName") String userName);
}
