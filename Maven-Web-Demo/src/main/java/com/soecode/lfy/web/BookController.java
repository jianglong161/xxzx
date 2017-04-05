package com.soecode.lfy.web;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soecode.lfy.dto.AppointExecution;
import com.soecode.lfy.dto.Result;
import com.soecode.lfy.entity.Book;
import com.soecode.lfy.enums.AppointStateEnum;
import com.soecode.lfy.exception.NoNumberException;
import com.soecode.lfy.exception.RepeatAppointException;
import com.soecode.lfy.service.BookService;

@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/细分 /seckill/list
public class BookController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	private String list(Model model){
		List<Book> list=bookService.getList();
		model.addAttribute("list",list);
		// list.jsp + model = ModelAndView
		return "list";// WEB-INF/jsp/"list".jsp
	}
	//ajax json
	@RequestMapping(value="/{bookId}/detail",method=RequestMethod.GET)
	@ResponseBody
	private String detiail(@PathVariable("bookId") Long bookId,Model model){
		if(bookId==null){
			return "redirect:/book/list";
		}
		Book book=bookService.getById(bookId);
		if (book==null) {
			return "forward:/book/list";
		}
		model.addAttribute("book",book);
		return "detail";
		
	}
	@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
	"application/json; charset=utf-8" })
	private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @Param("studentId") Long studentId) {
		if (studentId == null || studentId.equals("")) {
			return new Result<AppointExecution>(false, "学号不能为空");
		}
		AppointExecution execution = null;
		try {
			execution = bookService.appointExecution(bookId, studentId);
		} catch (NoNumberException e1) {
			execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
		} catch (RepeatAppointException e2) {
			execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
		} catch (Exception e) {
			execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
		}
		return new Result<AppointExecution>(true, execution);
	}
	
	
}
