package com.soecode.lfy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.soecode.lfy.entity.Book;

public interface BookDao {
	/**
	 * ͨ��id��ѯ����ͼ��
	 * @param bookId
	 * @return
	 */
	Book queryById(long bookId);
	/**
	 * ��ѯ����ͼ��
	 * @param offset ��ѯ������λ��
	 * @param limit ��ѯ������
	 * @return
	 */
	List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	/**
	 * ���ٹݲ�����
	 * @param bookId
	 * @return ���Ӱ����������>1����ʾ���µļ�¼����
	 */
	int reduceNumber(long bookId);
}
