package com.soecode.lfy.exception;
/**
 * ��治���쳣
 * @author Still2Almost
 *
 */
public class NoNumberException extends RuntimeException{
	public NoNumberException(String message){
		super(message);
	}
	public NoNumberException(String message,Throwable cause){
		super(message,cause);
	}
}
