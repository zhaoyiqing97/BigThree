package org.example;

import com.google.gson.Gson;
import org.example.mapper.ArticleTypeMapper;
import org.example.pojo.ArticleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("all")
@RestController
public class Controller {
    @Autowired
    ArticleTypeMapper ArticleTypeMapper;

    private  Gson gson = new Gson();
    @GetMapping("/Test")
    public String test(){
        List<ArticleType> articleTypeDOSList = ArticleTypeMapper.selectList(null);
        return gson.toJson(articleTypeDOSList);
    }

    @GetMapping("/update")
    public void update(){
            String ArticleType1 = "{\"create_user\":0,\"id\":4,\"power\":1,\"state\":0,\"typename\":\"公告\",\"update_user\":0}";
            ArticleType articleType1=gson.fromJson(ArticleType1,ArticleType.class);
            ArticleTypeMapper.updateById(articleType1);
    }

}
