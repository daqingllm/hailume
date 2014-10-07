package me.hailu.controller;

import me.hailu.http.Constants;
import me.hailu.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by firefly on 2014/9/3.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private javax.servlet.http.HttpServletRequest request;

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("headerText1","KANKAN");
        params.put("content1","有人撸吗？");
        params.put("headerText2","Strong");
        params.put("content2","撸起!");
        params.put("headerText3","Troy");
        params.put("content3","还撸么？");
        params.put("headerText4","Firefly");
        params.put("content4","你们撸吧，我先不撸了。");

        User user = (User) request.getAttribute(Constants.USER_INFO);
        if (user != null) {
            params.put("userNickName", user.nickName);
        }

        model.addAllObjects(params);
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/n", method = RequestMethod.GET)
    public ModelAndView newpage() {
        ModelAndView model = new ModelAndView();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("newvalue", "http://image.qtv.com.cn/0/11/53/57/11535780_842371.jpg");
        model.addAllObjects(params);
        model.setViewName("newpage");
        return model;
    }

    @RequestMapping(value = "/newpage", method = RequestMethod.GET)
    public String helloworld(Model model) {
        model.addAttribute("newvalue", "http://image.qtv.com.cn/0/11/53/57/11535780_842371.jpg");
        return "newpage";
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ModelAndView page(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page");
        return modelAndView;
    }
    @RequestMapping(value = "/publish",method = RequestMethod.GET)
    public ModelAndView publish(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("publish");
        return modelAndView;
    }
//    @Override
//    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
//                                      HttpServletResponse httpServletResponse) throws Exception {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("newvalue", "http://image.qtv.com.cn/0/11/53/57/11535780_842371.jpg");
//        model.setViewName("newpage");
//        return model;
//    }
}