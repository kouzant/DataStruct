package business;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utilities {
	//Convert to Hexadecimal
	private String convertToHex(byte[] data){
		StringBuffer buf=new StringBuffer();
		for(int i=0;i<data.length;i++){
			int halfByte=(data[i] >>> 4) & 0x0F;
			int twoHalfs=0;
			do{
				if((0<=halfByte) && (halfByte<=9)){
					buf.append((char) ('0'+halfByte));
				}else{
					buf.append((char) ('a'+(halfByte-10)));
				}
				halfByte=data[i] & 0x0F;
			}while(twoHalfs++<1);
		}
		
		return buf.toString();
	}
	//implementation of md5sum hash function 
	public String MD5(String text){
		byte[] md5Hash=new byte[32];
		try{
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(text.getBytes("UTF-8"),0,text.length());
			md5Hash=md.digest();
		}catch(NoSuchAlgorithmException e0){
			e0.printStackTrace();
		}catch(UnsupportedEncodingException e1){
			e1.printStackTrace();
		}
		
		return convertToHex(md5Hash);
	}
}
