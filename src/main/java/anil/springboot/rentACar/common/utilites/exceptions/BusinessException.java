package anil.springboot.rentACar.common.utilites.exceptions;

public class BusinessException extends RuntimeException {
	public BusinessException(String message) {
		super(message);
	}
}
