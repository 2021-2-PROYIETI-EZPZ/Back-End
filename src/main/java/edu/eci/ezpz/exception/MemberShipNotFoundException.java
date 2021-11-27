package edu.eci.ezpz.exception;

import edu.eci.ezpz.error.ErrorCodeEnum;
import edu.eci.ezpz.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class MemberShipNotFoundException extends InternalServerErrorException {

    public MemberShipNotFoundException()
    {
        super( new ServerErrorResponseDto( "Membership not found", ErrorCodeEnum.MEMBERSHIP_NOT_FOUND, HttpStatus.NOT_FOUND ),
                HttpStatus.NOT_FOUND );
    }

}
