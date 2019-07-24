package cn.huajua.web.common;

import org.apache.commons.lang3.StringUtils;
/**
 * @author : huajuan
 * create at : 2019-07-19 20:27
 * description :
 * remark :
 * @program:
 **/
public class ResultDTO<T> {

    public static <T> ResultDTO<T> success() {
        return new ResultDTO<T>();
    }

    public static <T> ResultDTO<T> success(T module) {
        if (null == module) {
            throw new IllegalArgumentException("module不能为空");
        }
        ResultDTO<T> result = new ResultDTO<T>();
        result.module = module;
        return result;
    }

    public static <T> ResultDTO<T> success(T module, boolean allowEmpty) {
        if (null == module) {
            if (allowEmpty) {
                return success();
            } else {
                throw new IllegalArgumentException("module不能为空");
            }
        }
        ResultDTO<T> result = new ResultDTO<T>();
        result.module = module;
        return result;
    }

    public static <T> ResultDTO<T> error(String errorCode, String errorMsg) {
        if (StringUtils.isBlank(errorCode)) {
            throw new IllegalArgumentException("errorCode不能为空");
        }
        ResultDTO<T> result = new ResultDTO<T>();
        result.success = false;
        result.errorCode = errorCode;
        result.errorMsg = errorMsg;
        return result;
    }

    private static final long serialVersionUID = 9222484089767860158L;

    private T module;

    private boolean success = true;

    private String errorMsg;

    private String errorCode;

    public T getModule() {
        return module;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public boolean isSuccess() {
        return success;
    }
}
