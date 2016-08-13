package threadpool;

/**
 * Created by hjy on 16/7/14.
 */
public class BaseBussinessException extends Exception {
    private int code = 0;
    private String msg = "";

    public BaseBussinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseBussinessException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
