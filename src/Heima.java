
public class Heima {

	public static void test(){
		String[] arr = Numbers.DATA.split(" ");
		int lastTotal = Test.getAddTotal(Numbers.mDeleteHistories[Numbers.mDeleteHistories.length - 1], 3);
		String[][] deleteGroups = Test.getGroupsForThreeNumber(Numbers.mDeleteHistories[Numbers.mDeleteHistories.length - 1]);

		for(int i = 0; i < arr.length; i++){
			String number = arr[i];
			if (
//					Test.hasRepeatCount(number) ||
					Test.isDeleteNumber(number, 3, Numbers.mDeleteNumbers) ||
//					Test.isDeleteGroup(number, Numbers.mDeleteGroups, 3) ||
					Test.isAddNumberEquals(number, lastTotal, 3) ||
					Test.isDeleteGroup(number, deleteGroups, 3) ||
					Test.isHistoryNumber(number, Numbers.mDeleteHistories)
					) {

			}else{
				System.out.print(number);
				System.out.print(" ");
			}
			
		}
	}

	private static boolean containNumber(String[] array, String data, int index){
		for(int j = 0; j < array.length; j++){
			if(containNumber(data, index, array[j])){
				return true;
			}
		}
		return false;
	}

	private static boolean containNumber(String data, int index, String number){
		int lengh = data.length();
		int dex = lengh - index - 1;
		String str = data.substring(dex, dex + 1);
		if(str.equals(number)){
			return true;
		}
		return false;
	}
}
