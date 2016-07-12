package hcmuaf.edu.vn.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	private BufferedInputStream bis;
	private BufferedOutputStream bos;

	private static final String URL_SRC = "E:\\Pictures\\Chibi\\4s2m.png";
	private static final String URL_DES = "D:\\workspace(Luna)\\CDWeb-Spring\\Fast_Food\\src\\main\\webapp\\resources\\front_end\\image\\menu-slide";

	public boolean canCopy(File source, File dest) {
		if (source.compareTo(dest) <= 0) {
			return false;
		}
		if (dest.getPath().equals(source.getParent())) {
			return false;
		}
		return true;
	}

	private void copyFile(File source, File dest) throws FileNotFoundException,
			IOException {
		bis = new BufferedInputStream(new FileInputStream(source));
		bos = new BufferedOutputStream(new FileOutputStream(dest));
		byte[] bytes = new byte[1024];
		int byteRead;
		while ((byteRead = bis.read(bytes)) > -1) {
			bos.write(bytes, 0, byteRead);
		}
		bis.close();
		bos.close();
	}

	public void copy(File source, File dest) throws FileNotFoundException,
			IOException {
		if (source.exists()) {
			if (source.isDirectory()) {
				File fileTemp = new File(dest.getPath() + "\\"
						+ source.getName());
				fileTemp.mkdirs();
				File[] files = source.listFiles();
				for (File f : files) {
					copy(f, fileTemp);
				}
			} else {
				copyFile(source, new File(dest, source.getName()));
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		CopyFile test = new CopyFile();
		File fileSource = new File(URL_SRC);
		File fileDest = new File(URL_DES);
		if (test.canCopy(fileSource, fileDest)) {
			test.copy(fileSource, fileDest);
		} else {
			System.err.println("Khong the copy trung thu muc");
		}
	}
}
