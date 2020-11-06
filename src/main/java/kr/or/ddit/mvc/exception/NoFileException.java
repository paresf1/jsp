package kr.or.ddit.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//사용자에게 500에러 대신 404응답 코드로 응답기 가게끔 설정

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFileException extends Exception {
	
}















