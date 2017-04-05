package com.soecode.lfy.exception;
/**
 * ÷ÿ∏¥‘§‘º“Ï≥£
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
