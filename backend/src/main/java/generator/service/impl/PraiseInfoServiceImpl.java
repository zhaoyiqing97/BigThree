package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import generator.domain.PraiseInfo;
import generator.mapper.PraiseInfoMapper;
import generator.service.PraiseInfoService;

/**
 * @author HangZ
 * @description 针对表【praise_info】的数据库操作Service实现
 * @createDate 2022-06-08 16:26:24
 */
@Service
public class PraiseInfoServiceImpl extends ServiceImpl<PraiseInfoMapper, PraiseInfo>
    implements PraiseInfoService {}
