package com.example.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Response<T> {
	private int status;
	private String message;
	@JsonInclude(value=Include.NON_NULL)
	private T data;
	
	public static final Response<?>SUCCESS=new Response<>(200,"Success");
	public static final Response<?>NOT_FOUND=new Response<>(404,"Not_found");
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Response(int status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public Response(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	

}
