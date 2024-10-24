package com.springbootdemo.api.apiResponse;

public class ApiResponse {
    public boolean success;
    public Object data;
    public Object error;

    public ApiResponse(boolean success,Object data,Object error){
        this.success=success;
        this.data=data;
        this.error=error;
    }

    public boolean isSuccess(){
        return success;
    }

    public Object getData(){
        return data;
    }

    public Object getError(){

        return error;
    }
}
