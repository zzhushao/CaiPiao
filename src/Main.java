import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import data.Heima;
import data.MethodUtils;
import data.Numbers;
import ui.MainFrame;

public class Main {

	private static StringBuffer mBuffer = new StringBuffer();

	public static void main(String[] arg) {
//		Heima.test();
		
//		printFormatNumber(3);
		System.out.println(Main.class.getResource("/"));
		System.out.println(System.getProperty("user.dir"));
		MainFrame mMainFrame = new MainFrame();
		mMainFrame.show();
//		System.out.println();
//		testReadFile();
	}

	private static void testReadFile(){
		String path = System.getProperty("user.dir") + "/res/history_numbers.txt";
		File file = new File(path);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
	}
	private static void printFormatNumber(int lengh){
		System.out.println();
		System.out.println();
		System.out.println();
		int maxNumber = (int)Math.pow(10, lengh);
		String lastNumber = Numbers.mDeleteHistories[Numbers.mDeleteHistories.length - 1];
		String lastNumber2 = Numbers.mDeleteHistories[Numbers.mDeleteHistories.length - 2];

		String[][] deleteGroups = MethodUtils.getGroupsForThreeNumber(lastNumber);
		String[][] deleteGroups2 = MethodUtils.getGroupsForThreeNumber(lastNumber2);
		String[][] de = MethodUtils.getRandomDeleteANumber(lastNumber);
	
		int lastTotal =	MethodUtils.getAddTotal(lastNumber, lengh);
		System.out.println(lastTotal);
		for (int i = 0; i < maxNumber; i++) {
			String number = getStringNumber(i, lengh);
			if (
					MethodUtils.hasRepeatCount(number) ||
					MethodUtils.isDeleteNumber(number, lengh, Numbers.mDeleteNumbers) ||
					MethodUtils.isDeleteNumber(number, lengh, de) ||
//					isDeleteGroup(number, Numbers.mDeleteGroups, lengh) ||
					MethodUtils.isHistoryNumber(number, Numbers.mDeleteHistories) ||
					MethodUtils.isAddNumberEquals(number, lastTotal, lengh) ||
//					isAddEqualsForBaiNumber(number) ||
//					isAddEqualsForGeNumber(number) ||
					MethodUtils.isTwoNumberAddEqualsLast(number, lastNumber, MethodUtils.TYPE_QIAN2) ||
//					MethodUtils.isTwoNumberAddEqualsLast(number, lastNumber, MethodUtils.TYPE_HOU2) ||
//					MethodUtils.isDeleteGroup(number, deleteGroups2, lengh) || 
					MethodUtils.isDeleteGroup(number, deleteGroups, lengh)
					) {

			}else{
				System.out.print(mBuffer.toString());
				System.out.print(" ");
			}
		}
	}

	public static String getStringNumber(int num, int lengh) {
		mBuffer.setLength(0);
		String numStr = String.valueOf(num);
		int l = lengh - numStr.length();
		for (int i = 0; i < lengh; i++) {
			if (i < l) {
				mBuffer.append("0");
			}
		}
		mBuffer.append(numStr);
		return mBuffer.toString();
	}
}
