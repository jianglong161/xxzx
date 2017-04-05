package com.soecode.lfy.exception;
/**
 * ø‚¥Ê≤ªπª“Ï≥£
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
