package demo;

public class Test {

	public static void main(String[] args) {
		// windows控制台中执行chcp
		// GBK，别名windows-936，CP936，活动代码页: 936
		// chcp #查看当前cmd的编码格式
		// chcp 65001 #换成utf-8代码页（临时）
		// chcp 936 #换成默认的gbk（临时）
		// chcp 437 #美国英语（临时）

		// eclipse中右击项目Alt+Enter，Resource:Text file encoding

		System.out.println(System.getProperty("file.encoding"));

		OSExcecute.command("chcp");

		OSExcecute.command("dir e:");

	}

}
