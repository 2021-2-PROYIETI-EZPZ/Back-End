package edu.eci.ezpz.exception;

import edu.eci.ezpz.error.ErrorCodeEnum;
import edu.eci.ezpz.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class EmptyMembershipField extends InternalServerErrorException {

    public EmptyMembershipField()
    {
        super( new ServerErrorResponseDto( "There are one or more empty membership fields", ErrorCodeEnum.EMPTY_MEMBERSHIP_FIELD, HttpStatus.INTERNAL_SERVER_ERROR ),
                HttpStatus.INTERNAL_SERVER_ERROR );
    }
}