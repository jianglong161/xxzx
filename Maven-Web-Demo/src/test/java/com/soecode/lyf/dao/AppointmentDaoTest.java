package com.soecode.lyf.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lfy.dao.AppointmentDao;
import com.soecode.lfy.entity.Appointment;
import com.soecode.lyf.BaseTest;

public class AppointmentDaoTest extends BaseTest{
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Test
	public void testInsertAppointment(){
		long bookId=1000;
		long studentId=12345678910L;
		int insert=appointmentDao.insertAppointment(bookId, studentId);
		System.out.println("insert"+insert);
	}
	
	@Test
	public void testQueryByKeyWithBook(){
		long bookId=1000;
		long studentId=12345678910L;
		Appointment appointment=appointmentDao.queryByKeyWithBook(bookId, studentId);
		System.out.println(appointment);
		System.out.println(appointment.getBookId());
	}
}
