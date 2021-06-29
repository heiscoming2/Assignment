package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.ABoardBiz;
import com.mvc.upgrade.model.dto.ABoardDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ABoardBiz biz;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		logger.info("SELECT LIST");
		model.addAttribute("list", biz.selectList());
		return "mvclist";
	}
	
	@RequestMapping("/detail.do")
	public String detail(Model model, int bno) {
		logger.info("SELECT ONE");
		
		model.addAttribute("dto", biz.selectOne(bno));
		return "mvcdetail";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("INSERT FORM");
		return "mvcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(ABoardDto dto) {
		logger.info("INSERT RES");
		int res =biz.insert(dto);
		
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:insertform.do";
		}
				
	}
	
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int bno) {
		logger.info("UPDATE FORM");
		
		model.addAttribute("dto", biz.selectOne(bno));
		
		return "mvcupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(ABoardDto dto) {
		logger.info("UPDATE RES");
		
		int res=biz.update(dto);
		
		if(res>0) {
			return "redirect:detail.do?bno="+dto.getBno();
		}else {
			return "redirect:updateform.do?bno="+dto.getBno();
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(int bno) {
		logger.info("DELETE");
		
		int res=biz.delete(bno);
		
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:detail.do?bno="+bno;
		}
	}
	
	
	
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
