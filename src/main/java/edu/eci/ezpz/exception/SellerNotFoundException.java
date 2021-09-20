package edu.eci.ezpz.exception;

import edu.eci.ezpz.error.ErrorCodeEnum;
import edu.eci.ezpz.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class SellerNotFoundException extends InternalServerErrorException {

    public SellerNotFoundException(){
        super(new ServerErrorResponseDto("Seller not found", ErrorCodeEnum.CLIENT_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
