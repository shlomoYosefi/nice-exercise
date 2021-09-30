package com.exercisenice;

public class ResponseServer {

    private Object result;

    private static ResponseServer responseServer = new ResponseServer();
    public static ResponseServer getInstance(){
        return responseServer;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseServer{" +
                "result=" + result +
                '}';
    }
}
