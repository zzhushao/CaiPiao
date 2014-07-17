import data.Heima;
import data.MethodUtils;
import data.Numbers;
import ui.MainFrame;

public class Main {

	private static StringBuffer mBuffer = new StringBuffer();

	public static void main(String[] arg) {
//		Heima.test();
		
//		printFormatNumber(3);
		
		MainFrame mMainFrame = new MainFrame();
		mMainFrame.show();
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

		int lastTotal =	MethodUtils.getAddTotal(lastNumber, lengh);
		System.out.println(lastTotal);
		for (int i = 0; i < maxNumber; i++) {
			String number = getStringNumber(i, lengh);
			if (
					MethodUtils.hasRepeatCount(number) ||
					MethodUtils.isDeleteNumber(number, lengh, Numbers.mDeleteNumbers) ||
//					isDeleteGroup(number, Numbers.mDeleteGroups, lengh) ||
					MethodUtils.isHistoryNumber(number, Numbers.mDeleteHistories) ||
					MethodUtils.isAddNumberEquals(number, lastTotal, lengh) ||
//					isAddEqualsForBaiNumber(number) ||
//					isAddEqualsForGeNumber(number) ||
//					isTwoNumberAddEqualsLast(number, lastNumber, TYPE_QIAN2) ||
					MethodUtils.isTwoNumberAddEqualsLast(number, lastNumber, MethodUtils.TYPE_HOU2) ||
					MethodUtils.isDeleteGroup(number, deleteGroups2, lengh) || 
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
