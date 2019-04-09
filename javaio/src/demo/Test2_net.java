package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Test2_net {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec("ping www.baidu.com");
			br = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}