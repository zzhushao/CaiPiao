package data;

public class DataModel {

	private String[][] mDeleteNumbers = { {""},
		 {""},
		 {""},
		 {""},
		 {""}
		 };

	private String[] mDefault= { "" };
	private String[] mResDataArray = null;

	public DataModel(){

	}

	public void setResoureData(String resData){
		mResDataArray = resData.split(" ");
	}

	public void setDeleteData(String ge, String shi, String bai, String qian, String wan){
		mDeleteNumbers[4] = getDeleteData(ge);
		mDeleteNumbers[3] = getDeleteData(shi);
		mDeleteNumbers[2] = getDeleteData(bai);
		mDeleteNumbers[1] = getDeleteData(qian);
		mDeleteNumbers[0] = getDeleteData(wan);
	}

	private String[] getDeleteData(String data){
		if(data != null && data.trim().length() > 1){
			return data.split(" ");
		}else if(data != null && data.trim().length() == 1){
			return new String[]{ data };
		}else{
			return mDefault;
		}
	}

	public String getResultData(){
		StringBuffer buffer = new StringBuffer();
		String space = " ";
		for(String number : mResDataArray){
			if(MethodUtils.isDeleteNumber(number, 3, mDeleteNumbers)){
				
			}else{
				buffer.append(number);
				buffer.append(space);
			}
		}
		return buffer.toString();
	}
}
