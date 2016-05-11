package Spring.com.spring.manoj.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "Spittles Not Found")
public class SpittleNotFoundException  extends RuntimeException{

}
