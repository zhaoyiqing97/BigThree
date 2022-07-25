package generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import generator.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author HangZ
 * @description 针对表【user_info】的数据库操作Mapper
 * @createDate 2022-06-08 16:26:27 @Entity generator.domain.UserInfo
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    UserInfo selectByUserName(@Param("userName") String userName);
}
