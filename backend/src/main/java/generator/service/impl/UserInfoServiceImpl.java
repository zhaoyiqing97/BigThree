package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import generator.domain.UserInfo;
import generator.mapper.UserInfoMapper;
import generator.service.UserInfoService;

/**
 * @author HangZ
 * @description 针对表【user_info】的数据库操作Service实现
 * @createDate 2022-06-08 16:26:27
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {}
