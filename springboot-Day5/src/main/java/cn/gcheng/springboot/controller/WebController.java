package cn.gcheng.springboot.controller;

import cn.gcheng.springboot.entity.Dept;
import cn.gcheng.springboot.entity.Emp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class WebController {
    private List<Emp> emps = new ArrayList<>();
    private List<Dept> depts = new ArrayList<>();
    @Value("${app.upload.location}")
    private String path =null;


    public WebController() {
        emps.add(new Emp(7782, "CLARK", "DEVELOPER", "2017-01-02", 7780f, "RESEARCH"));
        emps.add(new Emp(7839, "KING", "CSO", "2018-03-04", 8820f, "SALES"));
        depts.add(new Dept(10,"RESEARCH" , "2017-10-07"));
        depts.add(new Dept(20,"SALES" , "2015-12-01"));
        depts.add(new Dept(30,"ACCOUNTING" , "2013-03-02"));
    }

    /**
     * RequestMethod.GET 只能get请求，如果非get请求405.
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        // 设置上下文数据，就是页面中读取的数据
        // SpringMVC中常用的设置上下文有三种：
        /*
         * 1. ModelAndView (推荐),相对于Model模式，ModelAndView更加符合高内聚，低耦合原则，因为在Model模式会创建一个Model对象当作参数。
         * 2. Model
         * 3. WebRequest或者原生的HttpServletRequest
         */
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("emps", emps);
        return mav;
    }


    /**
     * model 模式
     * 因为在Model模式会创建一个Model对象当作参数， 强耦合
     * @param model
     * @return
     */
    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("empsModel", emps);
        return "index";
    }


    /**
     * WebRequest 模式
     * 这两种与J2EE容易强耦合，为了拓展性需要，不推荐使用
     * @param req
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/Web", method = RequestMethod.GET)
    public String index(WebRequest req, HttpServletRequest httpServletRequest) {
        // setAttribute 在当前请求中放入对象，这种方式与web容器强耦合
        req.setAttribute("empsWeb", emps,0);
        httpServletRequest.setAttribute("empsHttp", emps);
        return "index";
    }

    // 序列化，springBoot 默认使用Jackson
    @GetMapping("/dept")
    @ResponseBody
    public List<Dept> obtainDept() {
        List<Dept> newDept = new ArrayList<>();
        newDept.add(new Dept(-1, "请选择", "2017-01-02"));
        newDept.addAll(depts);
        return newDept;
    }

    @GetMapping("/job")
    @ResponseBody
    public List<String> obtainJob(String dept) {
        List<String> jobs = new ArrayList<>();
        if ("RESEARCH".equals(dept)) {
            jobs.add("CTO");
            jobs.add("Programing");
        } else if ("SALES".equals(dept)) {
            jobs.add("CSO");
            jobs.add("Saler");
        } else if ("ACCOUNTING".equals(dept)) {
            jobs.add("CFO");
            jobs.add("Cashier");
        } else {

        }
        return jobs;
    }

    // @RequestParam("phone") 代表phone参数对应前端name="phone"的file框
    @PostMapping("/create")
    public ModelAndView create(Emp emp, @RequestParam("phone") MultipartFile phone) throws IOException {
        // 原始文件名，为了防止文件名相同，采用时间戳
        String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String suffix = phone.getOriginalFilename().substring(phone.getOriginalFilename().lastIndexOf("."));
        if (".jpg".equals(suffix)) {
            throw new RuntimeException("无效的图片格式!");
        }

        // 将临时文件夹中的文件复制到指定目录
        FileCopyUtils.copy(phone.getInputStream(), new FileOutputStream(path + fileName + suffix));
        emp.setPhotoFile(fileName + suffix);
        emps.add(emp);
        // 请求转发到根路径地址
        ModelAndView mav = new ModelAndView("redirect:/");
        return mav;
    }

    /*
        常规配置，环境变量
        Spring MVC + thymeleaf 上下文取值
        AJAX
        文件上传
        输入日期格式的转换
        更换tomcat配置->Jetty
        注册Filter 日志打印
        自动跳转 404、500
        启动时加载Listener
    */

}
