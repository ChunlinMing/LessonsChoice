package com.mcl.bysj.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * RSA 工具类。提供加密，解密等方法。
 * Created by mingchunlin on 17/4/13.
 */
public class RSAUtils {

	/**
	 * * 加密 *
	 * 
	 * @param key
	 *            加密的密钥 *
	 * @param data
	 *            待加密的明文数据 *
	 * @return 加密后的数据 *
	 * @throws Exception
	 */
	private static byte[] encrypt(PublicKey pk, byte[] data) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
			cipher.init(Cipher.ENCRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();// 获得加密块大小，如：加密前数据为128个byte，而key_size=1024
			// 加密块大小为127
			// byte,加密后为128个byte;因此共有2个加密块，第一个127
			// byte第二个为1个byte
			int outputSize = cipher.getOutputSize(data.length);// 获得加密块加密后块大小
			int leavedSize = data.length % blockSize;
			int blocksSize = leavedSize != 0 ? data.length / blockSize + 1 : data.length / blockSize;
			byte[] raw = new byte[outputSize * blocksSize];
			int i = 0;
			while (data.length - i * blockSize > 0) {
				if (data.length - i * blockSize > blockSize)
					cipher.doFinal(data, i * blockSize, blockSize, raw, i * outputSize);
				else
					cipher.doFinal(data, i * blockSize, data.length - i * blockSize, raw, i * outputSize);
				// 这里面doUpdate方法不可用，查看源代码后发现每次doUpdate后并没有什么实际动作除了把byte[]放到
				// ByteArrayOutputStream中，而最后doFinal的时候才将所有的byte[]进行加密，可是到了此时加密块大小很可能已经超出了
				// OutputSize所以只好用dofinal方法。

				i++;
			}
			return raw;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * * 解密 *
	 * 
	 * @param key
	 *            解密的密钥 *
	 * @param raw
	 *            已经加密的数据 *
	 * @return 解密后的明文 *
	 * @throws Exception
	 */
	private static byte[] decrypt(PrivateKey pk, byte[] raw) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
			cipher.init(Cipher.DECRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();
			ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
			int j = 0;

			while (raw.length - j * blockSize > 0) {
				bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
				j++;
			}
			return bout.toByteArray();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * 将二进制转为16进制字符串
	 * @param byte[]
	 * @return
	 * String @throws
	 */
	private static String b2hex(byte[] buff) {
		StringBuilder sb = new StringBuilder();
		for (int i:buff) {
			int z = i;
			if (z < 0) {
				z += 256;
			}
			if (z < 16) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(z));
		}
		return sb.toString();
	}

	/**
	 * byte[]转PublicKey对象
	 * 
	 * @param byte[]
	 * @return PublicKey
	 */
	private static PublicKey byteToPublicKey(byte[] bytes) {
		PublicKey pk = null;
		try {
			// bytearray to object
			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			ObjectInputStream oi = new ObjectInputStream(bi);

			pk = (PublicKey) oi.readObject();
			bi.close();
			oi.close();
		} catch (Exception e) {
			System.out.println("translation " + e.getMessage());
			e.printStackTrace();
		}
		return pk;
	}

	/**
	 * byte[]转PrivateKey对象
	 * @param byte[]
	 * @return PrivateKey
	 */
	private static PrivateKey byteToPrivateKey(byte[] bytes) {
		PrivateKey pk = null;
		try {
			// bytearray to object
			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			ObjectInputStream oi = new ObjectInputStream(bi);

			pk = (PrivateKey) oi.readObject();
			bi.close();
			oi.close();
		} catch (Exception e) {
			System.out.println("translation " + e.getMessage());
			e.printStackTrace();
		}
		return pk;
	}

	/**
	 * 利用MD5进行加密
	 * @param str 待加密的字符串
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException 没有这种产生消息摘要的算法
	 * @throws UnsupportedEncodingException 不支持指定的字符集
	 */
	private static String EncodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 确定计算方法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		// 加密后的字符串
		return new String(md5.digest(str.getBytes("utf-8")));
	}

	/**
	 * @param String[]
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// System.out.println(new
		// String(Base64.encodeBase64((byteToPublicKey(Base64.decodeBase64(PropReadUtil.getInstance().getResources("PUBLIC_KEY_BYTES"))).getEncoded()))));

		String test = "Adminofcqupt";
		byte[] en_test = encrypt(
				byteToPublicKey(Base64.decodeBase64(PropReadUtil.getInstance().getResources("PUBLIC_KEY_BYTES"))),
				test.getBytes());
		System.out.println("密文：" + b2hex(EncodeByMd5(new String(Base64.encodeBase64(en_test))).getBytes("utf-8")));
		// byte[] de_test = decrypt(getKeyPair().getPrivate(), en_test);
		byte[] de_test = decrypt(
				byteToPrivateKey(Base64.decodeBase64(PropReadUtil.getInstance().getResources("PRIVATE_KEY_BYTES"))),
				Base64.decodeBase64(
						"nMxK1i544YOTl4Auc/8PcrmZw79T9ppNhnIz23TsZPtloTm0uErbKc8p24chrREkSn2qE+mXSCeXEJLSbL1hVybo0Flq+r76ZLqD187GpCT6kl5CLumMdgT8rvG1TA0BPZYL3GIK7R3DIn4MwZdUYrhp929p0pfx0zccwZO5o14="));
		System.out.println("解密：" + new String(de_test) + "长度：" + new String(de_test).length());
		System.out.println(new String(de_test).substring(99, 120));
	}
}