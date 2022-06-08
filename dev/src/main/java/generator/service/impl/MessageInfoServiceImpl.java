package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.MessageInfo;
import generator.service.MessageInfoService;
import generator.mapper.MessageInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author HangZ
* @description 针对表【message_info】的数据库操作Service实现
* @createDate 2022-06-08 16:26:20
*/
@Service
public class MessageInfoServiceImpl extends ServiceImpl<MessageInfoMapper, MessageInfo>
    implements MessageInfoService{

}




