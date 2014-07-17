package data;

public class MethodUtils {

	public static final int TYPE_QIAN2 = 1;
	public static final int TYPE_HOU2 = 2;

	public static boolean isHistoryNumber(String number, String[] deleteHistories){
		if(deleteHistories == null || deleteHistories.length == 0){
			return false;
		}
		for(String hStr : deleteHistories){
			if(hStr != null && hStr.endsWith(number)){
				return true;
			}
		}
		return false;
	}

	public static boolean isDeleteGroup(String number, String[][] deleteGroups, int lengh){
		if(deleteGroups != null && deleteGroups.length > 0){
			for(int i = 0; i < deleteGroups.length; i++){
				String[] garr = deleteGroups[i];
				if(garr != null && garr.length > 0 && isDeleteGroup(number, garr, lengh)){
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isDeleteGroup(String number, String[] deleteGroups, int lengh){
		for(int j = 0; j < lengh; j ++){
			String str = deleteGroups[deleteGroups.length - j - 1];
			if (str != null && str.length() > 0 && !containString(number, j, str)){
				return false;
			}
		}
		return true;
	}

	public static boolean isDeleteNumber(String number, int lengh, String[][] deleteNumbers){
		for(int i = 0; i < lengh; i++){
			if(containString(number, i, deleteNumbers[deleteNumbers.length - i - 1])){
				return true;
			}
		}
		return false;
	}

	public static boolean hasRepeatCount(String number){
		int lengh = number.length();
		for (int i = 0; i < lengh; i++) {
			for (int j = 0; j < lengh; j++) {
				if (i == j) {
					continue;
				}
				if (number.substring(i, i + 1).equals(number.substring(j, j + 1))) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean containString(String number, int index, String[] strArr){
		if(strArr == null || strArr.length < 1){
			return false;
		}
		for(int i = 0; i < strArr.length; i++){
			if(containString(number, index, strArr[i])){
				return true;
			}
		}
		return false;
	}

	public static boolean containString(String number, String str){
		if(number.contains(str)){
			return true;
		}
		return false;
	}

	public static boolean containString(String number, int index, String str){
		int lengh = number.length();
		int dex = lengh - index - 1;
		String temp = number.substring(dex, dex + 1);
		if(temp.equals(str)){
			return true;
		}
		return false;
	}

	public static boolean isAddNumberEquals(String number, int lastTotal, int lengh){
		int totalN = getAddTotal(number, lengh);
		if(totalN == lastTotal){
			return true;
		}
		return false;
	}

	public static int getAddTotal(String number, int lengh){
		int total = 0;
		for(int i = 0; i < lengh; i++){
			int index = number.length() - i;
			int iN = Integer.valueOf(number.substring(index - 1, index));
			total += iN;
		};
		return total;
	}

	public static String[][] getGroupsForThreeNumber(String number){
		String geStr = number.substring(number.length() - 1, number.length());
		String shiStr = number.substring(number.length() - 2, number.length() - 1);
		String baiStr = number.substring(number.length() - 3, number.length() - 2);
		String qianStr = number.substring(number.length() - 4, number.length() - 3);
		String wanStr = number.substring(number.length() - 4, number.length() - 3);

		String [][] groups = {
			{"", "", baiStr, shiStr, ""},
			{"", "", ""  ,shiStr, geStr},
			{"", "", baiStr  ,"", geStr},

			{"", "", shiStr, baiStr, ""},
			{"", "", "", geStr, shiStr},
			{"", "", geStr, "", baiStr},
		
			{"", "", shiStr, geStr, ""},
			{"", "", "", baiStr, shiStr},
			
			{"", "", geStr, shiStr, ""},
			{"", "", "", shiStr, baiStr},
			
			{"", "", baiStr, geStr, shiStr},
			{"", "", shiStr, geStr, shiStr},
			{"", "", geStr, shiStr, baiStr},

			{"", "", qianStr, baiStr, shiStr},
			{"", "", baiStr, qianStr, shiStr},
			{"", "", shiStr, baiStr, qianStr},
			
			{"", "", wanStr, qianStr, baiStr},
			{"", "", qianStr, wanStr, baiStr},
			{"", "", baiStr, qianStr, wanStr},
		};
		return groups;
	}

	private static boolean isAddEqualsForBaiNumber(String number){
		int total = getAddTotalForType(number, TYPE_HOU2);
		String baiStr = number.substring(number.length() - 3, number.length() - 2);
		int iB = Integer.parseInt(baiStr);
		if(total == iB){
			return true;
		}
		return false;
	}

	private static boolean isAddEqualsForGeNumber(String number){
		int total = getAddTotalForType(number, TYPE_QIAN2);
		String geStr = number.substring(number.length() - 1, number.length());
		int iG = Integer.parseInt(geStr);
		if(total == iG){
			return true;
		}
		return false;
	}

	public static boolean isTwoNumberAddEqualsLast(String number, String lastNumber, int type){
		int totalN = getAddTotalForType(number, type);
		int totalL = getAddTotalForType(lastNumber, type);
		if(totalN == totalL){
			return true;
		}
		return false;
	}

	private static int getAddTotalForType(String number, int type){
		String geStr = number.substring(number.length() - 1, number.length());
		String shiStr = number.substring(number.length() - 2, number.length() - 1);
		String baiStr = number.substring(number.length() - 3, number.length() - 2);
		int iG = Integer.parseInt(geStr);
		int iS = Integer.parseInt(shiStr);
		int iB = Integer.parseInt(baiStr);
		if(type == TYPE_QIAN2){
			return (iB + iS);
		}else if(type == TYPE_HOU2){
			return (iS + iG);
		}
		return -1;
	}

	public static String getAllNumber(int lengh){
		StringBuffer buffer = new StringBuffer();
		int maxNumber = (int)Math.pow(10, lengh);
		String space = " ";
		for (int i = 0; i < maxNumber; i++) {
			addFormatNumber(buffer, i, lengh);
			if(i < maxNumber -1){
				buffer.append(space);
			}
		}
		return buffer.toString();
	}

	private static void addFormatNumber(StringBuffer buffer, int num, int lengh) {
		String numStr = String.valueOf(num);
		int l = lengh - numStr.length();
		for (int i = 0; i < lengh; i++) {
			if (i < l) {
				buffer.append("0");
			}
		}
		buffer.append(numStr);
	}
}
