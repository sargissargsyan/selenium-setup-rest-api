package api;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */

public class ApiException extends RuntimeException {
	private String exceptionClass;
	private String title;
	private String message;
	private String msgKey;
	private String[] attributes;
	private int code;

	public ApiException(String message, Throwable cause) {
		super(message, cause);
		setMessage(cause.getMessage());
		setExceptionClass(cause.getClass().getCanonicalName());
	}

	public ApiException(Throwable cause) {
		super(cause);
		setMessage(cause.getMessage());
		setExceptionClass(cause.getClass().getCanonicalName());
	}

	public ApiException(String message) {
		super(message);
		setMessage(message);
	}

	public String getExceptionClass() {
		return exceptionClass;
	}

	public void setExceptionClass(String exceptionClass) {
		this.exceptionClass = exceptionClass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
