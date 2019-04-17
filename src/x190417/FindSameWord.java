package x190417;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class FindSameWord {
	public static String[] getWords(String filePath) throws Exception {
		Reader in = new FileReader(filePath);
		BufferedReader br = new BufferedReader(in);
		StringBuffer str = new StringBuffer("");
		String s;
		while((s=br.readLine())!=null) {
			str.append(s);
		}
		String[] strs=str.toString().split("[^a-zA-Z]+");
		return strs;
	}
	public static String[] getSame(String[] s1,String[] s2) {
		int length=Math.max(s1.length, s2.length);
		int index=0;
		String[] sames = new String[length];
		for(int i=0;i<s1.length;i++) {
			for(int j=0;j<s2.length;j++) {
				if(s1[i].equals(s2[j])) {
					sames[index]=s1[i];
					index++;
				}
			}
		}
		int i=0;
		for(int j=0;j<length;j++) {
			if(sames[j]==null) {
				i=j;
				break;
			}
		}
		String [] same = new String[i];
		for (int j = 0; j < same.length; j++) {
			same[j]=sames[j];
		}
		return same;
	}
	public static String getSameString(String[] s) {
		return Arrays.toString(s);
	}
	public static void main(String[] args) {
		try {
			String[] strs1=FindSameWord.getWords("D:"+File.separator+"1.txt");
			String[] strs2=FindSameWord.getWords("D:"+File.separator+"2.txt");
			String[] sames=FindSameWord.getSame(strs1, strs2);
			String s = FindSameWord.getSameString(sames);
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
