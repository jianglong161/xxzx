package com.soecode.lfy.service.impl;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.soecode.lfy.dao.AppointmentDao;
import com.soecode.lfy.dao.BookDao;
import com.soecode.lfy.dto.AppointExecution;
import com.soecode.lfy.entity.Appointment;
import com.soecode.lfy.entity.Book;
import com.soecode.lfy.enums.AppointStateEnum;
import com.soecode.lfy.exception.AppointException;
import com.soecode.lfy.exception.NoNumberException;
import com.soecode.lfy.exception.RepeatAppointException;
import com.soecode.lfy.service.BookService;

import sun.util.logging.resources.logging;

public class BookServiceImpl implements BookService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// 注入Service依赖
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	
	public Book getById(long bookId) {
		
		return bookDao.queryById(bookId);
	}

	public List<Book> getList() {
		return bookDao.queryAll(0, 1000);
	}
	@Transactional
	public AppointExecution appointExecution(long BookId, long studentId) {
		try {
			int update=bookDao.reduceNumber(BookId);
			if(update<=0){
				throw new NoNumberException("no mumber");
			}else{
				//执行预约操作
				int insert=appointmentDao.insertAppointment(BookId, studentId);
				if(insert<=0){//重复预约
					throw new RepeatAppointException("repeat appoint");
				}else{
					Appointment appointment=appointmentDao.queryByKeyWithBook(BookId, studentId);
					return new AppointExecution(BookId,AppointStateEnum.SUCCESS,appointment);
				}
			}
		} catch (NoNumberException e1) {
			// TODO: handle exception
			throw e1;
		}catch (RepeatAppointException  e2) {
			// TODO: handle exception
			throw e2;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new AppointException("appoint inner error:" + e.getMessage());
		}
		
	}
	
}
