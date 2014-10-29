package me.hailu.controller.ajax;

import me.hailu.article.Article;
import me.hailu.article.ArticleDao;
import me.hailu.http.Constants;
import me.hailu.http.Response;
import me.hailu.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by firefly on 2014/10/9.
 */
@Controller
@RequestMapping(value = "/ajax/article")
public class ArticleAjaxController {

    @Autowired
    private javax.servlet.http.HttpServletRequest request;

    ArticleDao dao = new ArticleDao();

    @ResponseBody
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public Response publish(@RequestBody Article article){

        User user = (User) request.getAttribute(Constants.USER_INFO);
        if (user == null) {
            return Response.status(403).info("发表文章需先登录").build();
        }

        article.authorId = user.id;
        article.authorName = user.nickName;
        dao.save(article);

        return Response.status(200).info("发表成功").build();
    }

    @ResponseBody
    @RequestMapping(value = "/loadpage", method = RequestMethod.POST)
    public Response loadPage(
            @RequestParam(value = "title", required = true) String title,
            HttpServletResponse response){
        Article article = dao.loadArticleByTitle(title);
        if(article==null){
            return Response.status(400).info("文章不存在").build();
        }
        Map<String,String> result = new HashMap<String,String>();
        result.put("title",article.title);
        result.put("content",article.content);
        return Response.status(200).info("加载成功").entity(result).build();
    }
}