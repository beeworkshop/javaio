package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExcecute {
	public static void command(String cmd) {
		boolean err = false;
		try {
			Process p = new ProcessBuilder(cmd.split(" ")).start();

			BufferedReader results = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));

//			BufferedReader results = new BufferedReader(
//					new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));

			String s;
			while ((s = results.readLine()) != null) {
				System.out.println(s);
			}

//			BufferedReader errs = new BufferedReader(new InputStreamReader(p.getErrorStream(), Charset.forName("GBK")));
			BufferedReader errs = new BufferedReader(new InputStreamReader(p.getErrorStream(), "GBK"));

			while ((s = errs.readLine()) != null) {
				System.err.println(s);
				err = true;
			}
		} catch (Exception e) {
			// Windows2K在命令执行失败后会执行如下默认命令
			if (!cmd.startsWith("CMD /C" + cmd))
				command("CMD /C" + cmd);
			else
				throw new RuntimeException(e);
		}

		if (err) {
			throw new OSExecuteException("Errors executing" + cmd);
		}
	}
}
