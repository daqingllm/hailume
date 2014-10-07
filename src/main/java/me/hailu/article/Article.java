package me.hailu.article;

import me.hailu.mongo.Model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liming_liu
 * Date: 14-9-26
 * Time: 下午4:39
 * To change this template use File | Settings | File Templates.
 */
public class Article extends Model {

    //标题
    public String title;
    //摘要
    public String brief;
    //作者id
    public int authorId;


    //内容
    public String content;
    //标签
    public List<String> tags;
    //头图
    public ArticleImage image;
    //图片信息
    public List<ArticleImage> images;
}