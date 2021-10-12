package per.kky.common.exception;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import per.kky.common.dto.R;

@ResponseBody
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ServiceException.class)
    public R handle(ServiceException e) {
        return R.fail(e.getMessage());
    }

}
