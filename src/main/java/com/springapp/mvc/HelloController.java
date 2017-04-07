package com.springapp.mvc;

import com.springapp.pojo.BookInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.Reader;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.print("");
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
                .build(reader);
        session = sqlMapper.openSession();
        BookInfo bookInfo = session.selectOne("findById", 1);

        System.out.println(bookInfo.getName());
        session.close();
        model.addAttribute("message",bookInfo.getName());
		return "hello";
	}
}