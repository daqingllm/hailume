package me.hailu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import me.hailu.controller.base.BaseController;
import me.hailu.weixin.AccessTokenServlet;
import me.hailu.weixin.CheckUtil;
import me.hailu.weixin.SignUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liming_liu on 16/6/18.
 */
@Controller
@RequestMapping(value = "/")
public class WeixinController extends BaseController {

    private static final String APP_ID = "wxd1609c7bf1125e78";
    private static final String APP_SECRET = "550ceaaaaa04e387e0c84f35620020e0";

    @ResponseBody
    @RequestMapping(value = "/weixin")
    public String serveWeixin(HttpServletRequest request, HttpServletResponse response) {
        try {
            StringWriter writer = new StringWriter();
            IOUtils.copy(request.getInputStream(), writer);
            System.out.println("/weixin request receive: " + writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // 接收微信服务器以Get请求发送的4个参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return null;
    }

    @RequestMapping(value = "/weixin/jssign", method = RequestMethod.GET)
    public ModelAndView showWeixinPage(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        Map<String, Object> ret = SignUtil.sign(AccessTokenServlet.getAccessToken(), url);
        ret.put("appId", APP_ID);
        ret.put("doMain", "hailu.me");
        return createMV("weixin", ret);
    }

    @RequestMapping(value = "/weixin/qrcode", method = RequestMethod.GET)
    public ModelAndView showWeixinPage(@RequestParam(value = "str")String str) {
        String body = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"" + str + "\"}}}";
        try {
            Response response = Request.Post("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + AccessTokenServlet.getAccessToken())
                    .bodyString(body, ContentType.APPLICATION_JSON).execute();
            QrcodeResponse qrcodeResponse = new ObjectMapper().readValue(response.returnContent().asBytes(), QrcodeResponse.class);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("url", qrcodeResponse.url);
            params.put("ticket", qrcodeResponse.ticket);
            return createMV("weixin/qrcode", params);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Data
    private static class QrcodeResponse {
        private String ticket;
        private int expire_seconds;
        private String url;
    }
}
