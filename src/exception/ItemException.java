package exception;

public class ItemException extends Exception {
	String msg;
	
	public ItemException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ItemException [msg=" + msg + "]";
	}
}
