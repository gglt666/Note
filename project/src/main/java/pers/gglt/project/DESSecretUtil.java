//package pers.gglt.project;
//
//import java.io.IOException;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//
//import sun.misc.BASE64Encoder;
//import sun.misc.BASE64Decoder;
//
///**
// * @author Luyong
// */
//public class DESSecretUtil {
//
//	/**
//	 * 使用DES对字符串加密
//	 *
//	 * @param str
//	 *            utf8编码的字符串
//	 * @param key
//	 *            密钥（56位，7字节）
//	 *
//	 */
//	public static byte[] desEncrypt(String str, String key) throws Exception {
//		if (str == null || key == null)
//			return null;
//		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "DES"));
//		byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
//		return bytes;
//	}
//
//	/**
//	 * 使用DES对数据解密
//	 *
//	 * @param bytes
//	 *            utf8编码的二进制数据
//	 * @param key
//	 *            密钥（16字节）
//	 * @return 解密结果
//	 * @throws Exception
//	 */
//	public static String desDecrypt(byte[] bytes, String key) throws Exception {
//		if (bytes == null || key == null)
//			return null;
//		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "DES"));
//		bytes = cipher.doFinal(bytes);
//		return new String(bytes, "utf-8");
//	}
//
//	/**
//	 * 使用base64解决乱码
//	 *
//	 * @param secretKey
//	 *            加密后的字节码
//	 */
//	public static String jdkBase64String(byte[] secretKey) {
//		BASE64Encoder encoder = new BASE64Encoder();
//		return encoder.encode(secretKey);
//	}
//
//	/**
//	 * 使用jdk的base64 解密字符串 返回为null表示解密失败
//	 *
//	 * @throws IOException
//	 */
//	public static byte[] jdkBase64Decoder(String str) throws IOException {
//		BASE64Decoder decoder = new BASE64Decoder();
//		return decoder.decodeBuffer(str);
//	}
//
//	public static void main(String[] args) throws Exception {
//
//		String openId = "sdn_" + jdkBase64String(desEncrypt("DDOS_7", "sdn_ddos"));
//		System.out.println(openId);
//
//		String s = openId.replace("sdn_", "");
//		String desDecrypt = desDecrypt(jdkBase64Decoder(s), "sdn_ddos");
//		System.out.println(desDecrypt);
//	}
//
//}