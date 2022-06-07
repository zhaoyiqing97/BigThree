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

}
