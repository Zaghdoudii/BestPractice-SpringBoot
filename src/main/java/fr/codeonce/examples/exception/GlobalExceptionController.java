package fr.codeonce.examples.exception;

import javax.persistence.PersistenceException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(value = PersistenceException.class)
	public String uniqueCodeException(PersistenceException e) {
		String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
		log.error(rootCauseMessage, e);
		return rootCauseMessage;
	}

}