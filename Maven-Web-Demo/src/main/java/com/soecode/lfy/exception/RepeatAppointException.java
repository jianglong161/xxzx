package com.soecode.lfy.exception;
/**
 * �ظ�ԤԼ�쳣
 * @author Still2Almost
 *
 */
public class RepeatAppointException extends RuntimeException{
	public RepeatAppointException(String message){
		super(message);
	}
	public RepeatAppointException(String message,Throwable cause){
		super(message,cause);
	}
}
