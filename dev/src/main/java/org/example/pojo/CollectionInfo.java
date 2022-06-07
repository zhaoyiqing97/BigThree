package org.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class CollectionInfo {
    private int article_id; //收藏文章id        
    private int collection_id; //user id        
    private Date collection_time; //收藏时间
    private Date create_time; //               
    private int create_user; //                 
    private int id; //主键                      
    private int state; //0代表存在,1代表已经被删除 
    private Date update_time; //               
    private int update_user; //
}
