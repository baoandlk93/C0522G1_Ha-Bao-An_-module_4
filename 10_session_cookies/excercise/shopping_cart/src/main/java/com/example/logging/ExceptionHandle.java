package com.example.logging;

import com.example.exception.NoProductInCartException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(NoProductInCartException.class)
    public String showErrorEmpty(Model model) {
        model.addAttribute("message", "Sản phẩm đã được xóa khỏi giỏ hàng !");
        return "error";
    }
//    @ExceptionHandler(OutOfBoundsLimitException.class)
//    public String showErrorFull(Model model){
//        model.addAttribute("message","Số lượng sách của chúng tôi đã đủ, bạn có nhơ mình mượn ở đâu không ?");
//        return "errorPage";
//    }
}
