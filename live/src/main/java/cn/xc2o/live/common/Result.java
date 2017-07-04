package cn.xc2o.live.common;

/**
 * Created by cc on 2017/7/4.
 */
public class Result<T> {
    private String result;
    private String error;
    private T data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.result = ResultConstant.Failure;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.result = ResultConstant.Success;
        this.data = data;
    }
}
