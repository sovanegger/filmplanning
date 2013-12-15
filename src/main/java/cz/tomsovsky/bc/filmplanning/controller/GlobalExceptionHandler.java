package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Třída, jejíž metody se volají v případě, že v některém controlleru
 * dojde k vyhození výjimky.
 * 
 * @author Martin Tomšovský
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * Tato metoda se vykoná, dojde-li k jakékoliv výjimce v controllerech.
	 * 
	 * @param e výjimka
	 * @return message vrátí chybovou zprávu
	 */
	@ExceptionHandler({Exception.class})
	public @ResponseBody String handleException(Exception e) {
		e.printStackTrace();
		return e.getMessage();
	}
}
