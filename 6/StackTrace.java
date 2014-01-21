public class StackTrace {
	public static String stackTraceToString(Throwable e) {
		String stackTrace = e.toString();
		for (StackTraceElement ste : e.getStackTrace()) {stackTrace += "\n\tat " + ste;}
		return stackTrace;
	}
}