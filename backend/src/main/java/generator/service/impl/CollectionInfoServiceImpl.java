package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import generator.domain.CollectionInfo;
import generator.mapper.CollectionInfoMapper;
import generator.service.CollectionInfoService;

/**
 * @author HangZ
 * @description 针对表【collection_info】的数据库操作Service实现
 * @createDate 2022-06-08 16:26:12
 */
@Service
public class CollectionInfoServiceImpl extends ServiceImpl<CollectionInfoMapper, CollectionInfo>
    implements CollectionInfoService {}
