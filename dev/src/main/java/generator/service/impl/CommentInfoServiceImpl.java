package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.CommentInfo;
import generator.service.CommentInfoService;
import generator.mapper.CommentInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author HangZ
* @description 针对表【comment_info】的数据库操作Service实现
* @createDate 2022-06-08 16:26:18
*/
@Service
public class CommentInfoServiceImpl extends ServiceImpl<CommentInfoMapper, CommentInfo>
    implements CommentInfoService{

}




