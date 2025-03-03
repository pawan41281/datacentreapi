package colt.net.datacentreapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import colt.net.datacentreapi.wrapper.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException ex){
		ApiResponse<Object> apiResponse = new ApiResponse<Object>("error", ex.getMessage(), null, null);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
	}
	
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<ApiResponse<?>> handleRecordAlreadyExistsException(ResourceAlreadyExistsException ex){
		ApiResponse<Object> apiResponse = new ApiResponse<Object>("error", ex.getMessage(), null, null);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
	}
}