package store.itpick.backend.common.response.status;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum BaseExceptionResponseStatus implements ResponseStatus {

    /**
     * 1000: 요청 성공 (OK)
     */
    SUCCESS(1000, HttpStatus.OK.value(), "요청에 성공하였습니다."),

    /**
     * 2000: Request 오류 (BAD_REQUEST)
     */
    BAD_REQUEST(2000, HttpStatus.BAD_REQUEST.value(), "유효하지 않은 요청입니다."),
    URL_NOT_FOUND(2001, HttpStatus.BAD_REQUEST.value(), "유효하지 않은 URL 입니다."),
    METHOD_NOT_ALLOWED(2002, HttpStatus.METHOD_NOT_ALLOWED.value(), "해당 URL에서는 지원하지 않는 HTTP Method 입니다."),
//    WRONG_DATE(2003, HttpStatus.BAD_REQUEST.value(), "date 형식이 올바르지 않습니다."),

    /**
     * 3000: Server, Database 오류 (INTERNAL_SERVER_ERROR)
     */
    SERVER_ERROR(3000, HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버에서 오류가 발생하였습니다."),
    DATABASE_ERROR(3001, HttpStatus.INTERNAL_SERVER_ERROR.value(), "데이터베이스에서 오류가 발생하였습니다."),
    BAD_SQL_GRAMMAR(3002, HttpStatus.INTERNAL_SERVER_ERROR.value(), "SQL에 오류가 있습니다."),

    /**
     * 4000: Authorization 오류
     */
    JWT_ERROR(4000, HttpStatus.UNAUTHORIZED.value(), "JWT에서 오류가 발생하였습니다."),
    TOKEN_NOT_FOUND(4001, HttpStatus.BAD_REQUEST.value(), "토큰이 HTTP Header에 없습니다."),
    UNSUPPORTED_TOKEN_TYPE(4002, HttpStatus.BAD_REQUEST.value(), "지원되지 않는 토큰 형식입니다."),
    INVALID_TOKEN(4003, HttpStatus.UNAUTHORIZED.value(), "유효하지 않은 토큰입니다."),
    MALFORMED_TOKEN(4004, HttpStatus.UNAUTHORIZED.value(), "토큰이 올바르게 구성되지 않았습니다."),
    EXPIRED_TOKEN(4005, HttpStatus.UNAUTHORIZED.value(), "만료된 토큰입니다."),
    TOKEN_MISMATCH(4006, HttpStatus.UNAUTHORIZED.value(), "회원 정보가 토큰 정보와 일치하지 않습니다."),
    EXPIRED_REFRESH_TOKEN(4007, HttpStatus.UNAUTHORIZED.value(), "다시 로그인 해주세요."),


    /**
     * 5000: User 오류
     */
    INVALID_USER_VALUE(5000, HttpStatus.BAD_REQUEST.value(), "요청에서 잘못된 값이 존재합니다."),
    DUPLICATE_EMAIL(5001, HttpStatus.BAD_REQUEST.value(), "이미 존재하는 이메일입니다."),
    DUPLICATE_NICKNAME(5002, HttpStatus.BAD_REQUEST.value(), "이미 존재하는 닉네임입니다."),
    USER_NOT_FOUND(5003, HttpStatus.BAD_REQUEST.value(), "존재하지 않는 회원입니다."),
    PASSWORD_NO_MATCH(5004, HttpStatus.BAD_REQUEST.value(), "비밀번호가 일치하지 않습니다."),
    INVALID_USER_STATUS(5005, HttpStatus.BAD_REQUEST.value(), "잘못된 회원 status 값입니다."),
    EMAIL_NOT_FOUND(5006, HttpStatus.BAD_REQUEST.value(), "존재하지 않는 이메일입니다."),
    INVALID_PASSWORD(5007, HttpStatus.BAD_REQUEST.value(), "유효하지 않는 password입니다."),
    INVALID_REFRESHTOKEN(5008, HttpStatus.BAD_REQUEST.value(), "유효하지 않는 토큰입니다."),
    UNABLE_TO_SEND_EMAIL(5012,HttpStatus.BAD_REQUEST.value(),"메일을 전송할 수 없습니다."),
    NO_SUCH_ALGORITHM(5009, HttpStatus.BAD_REQUEST.value(), "인증 번호 생성을 위한 알고리즘을 찾을 수 없습니다."),
    AUTH_CODE_IS_NOT_SAME(5010, HttpStatus.BAD_REQUEST.value(), "인증 번호가 일치하지 않습니다."),
    MEMBER_EXISTS(5011,HttpStatus.BAD_REQUEST.value(), "이미 존재하는 회원입니다."),
    INVALID_PROFILE_IMG(5012,HttpStatus.BAD_REQUEST.value(), "잘못된 이미지 파일입니다."),
    UPLOAD_FAIL(5013,HttpStatus.BAD_REQUEST.value(), "파일 업로드에 실패했습니다. 인터넷 연결을 확인하거나, 나중에 다시 시도해 주세요."),
    INVALID_USER_DB_VALUE(5014,HttpStatus.BAD_REQUEST.value(), "유저 정보에 오류가 발생했습니다. 관리자에게 문의해주세요."),

    /**
     * 6000: Debate 오류
     */
    INVALID_DEBATE_VALUE(6000, HttpStatus.BAD_REQUEST.value(), "토론 생성 요청에서 잘못된 값이 존재합니다."),
    INVALID_COMMENT_VALUE(6001,HttpStatus.BAD_REQUEST.value(), "댓글 생성 요청에서 잘못된 값이 존재합니다."),
    DEBATE_NOT_FOUND(6002,HttpStatus.BAD_REQUEST.value(), "해당 토론이 존재하지 않습니다."),
    COMMENT_PARENT_NOT_FOUND(6003,HttpStatus.BAD_REQUEST.value(), "부모 댓글이 존재하지 않습니다."),
    INVALID_COMMENT_HEART_VALUE(6004,HttpStatus.BAD_REQUEST.value(), "댓글 좋아요 생성 요청에서 잘못된 값이 존재합니다."),
    COMMENT_NOT_FOUND(6005,HttpStatus.BAD_REQUEST.value(), "해당 댓글이 존재하지 않습니다."),
    KEYWORD_NOT_FOUND(6006,HttpStatus.BAD_REQUEST.value(), "해당 키워드가 존재하지 않습니다."),


    /**
     * 7000: Vote 오류
     */

    INVALID_DEBATE_ID(7000,HttpStatus.BAD_REQUEST.value(), "유효하지 않은 DEBATE ID입니다."),
    INVALID_VOTE_VALUE(7001,HttpStatus.BAD_REQUEST.value(), "투표 요청에서 잘못된 값이 존재합니다."),
    VOTE_OPTION_NOT_FOUND(7002,HttpStatus.BAD_REQUEST.value(), "해당 투표 옵션이 존재하지 않습니다."),
    INVALID_VOTE_DELETE_VALUE(7003,HttpStatus.BAD_REQUEST.value(), "투표 취소 요청에서 잘못된 값이 존재합니다."),
    USER_VOTE_CHOICE_NOT_FOUND(7004,HttpStatus.BAD_REQUEST.value(), "투표하지 않았기 때문에 취소할 수 없습니다."),



    /**
     * 8000: Reference 오류
     */
    INVALID_REFERENCE(8000,HttpStatus.BAD_REQUEST.value(),"잘못된 관련자료 요청입니다"),
    NO_Search_REFERENCE(8001,HttpStatus.BAD_REQUEST.value(),"관련자료를 뉴스에서 검색하지 못하였습니다"),

    EMPTY_REFERENCE(8002,HttpStatus.BAD_REQUEST.value(),"해당 키워드의 관련자료를 찾지 못하였습니다");






    private final int code;
    private final int status;
    private final String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
