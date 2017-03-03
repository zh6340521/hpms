package hpms.utils;

/**
 * @name ValidationTableException
 * @description 通过继承Exception类来实现的异常类
 * @author fuchun.hu@hand-china.com
 * @version 1.0
 */
public class ValidationTableException extends Exception {

	private static final long serialVersionUID = -5965533823913003472L;
	/**
	 * 错误消息Code
	 *
	 */
	private String code;
	/**
	 * 错误消息参数
	 *
	 */
	private Object args[];

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public ValidationTableException(String code, Object[] args) {
		super();
		this.code = code;
		this.args = args;
	}

	public ValidationTableException() {
	}
}
