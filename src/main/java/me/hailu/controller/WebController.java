package me.hailu.controller;

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
public class WebController {
    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("newvalue", "http://image.qtv.com.cn/0/11/53/57/11535780_842371.jpg");
        model.addAllObjects(params);
        model.setViewName("newpage");
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