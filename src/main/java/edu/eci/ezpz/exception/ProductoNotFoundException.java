package edu.eci.ezpz.exception;

import edu.eci.ezpz.error.ErrorCodeEnum;
import edu.eci.ezpz.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class ProductoNotFoundException extends InternalServerErrorException{
    public ProductoNotFoundException(){
        super(new ServerErrorResponseDto("Product not found", ErrorCodeEnum.PRODUCT_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}