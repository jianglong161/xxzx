package com.soecode.lfy.service;

import java.util.List;

import com.soecode.lfy.dto.AppointExecution;
import com.soecode.lfy.entity.Book;

/**
 * * ҵ��ӿڣ�վ��"ʹ����"�Ƕ���ƽӿ� �������棺�����������ȣ��������������ͣ�return ����/�쳣��
 * @author Still2Almost
 *
 */
public interface BookService {
	/**
	 * ��ѯһ����
	 * @param bookId
	 * @return
	 */
	Book getById(long bookId);
	/**
	 * ��ѯ����ͼ��
	 * 
	 * @return
	 */
	List<Book> getList();
	/**
	 * ԤԼͼ��
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	AppointExecution appointExecution(long BookId,long studentId);
}
