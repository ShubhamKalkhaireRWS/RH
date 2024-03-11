package Steps;

import java.util.ArrayList;
import java.util.List;

public class DataPojo {
	List<String> dataList = new ArrayList<>();

	public void addData(String data) {
		dataList.add(data);
	}
	
	public List<String> getDataList(){
		return dataList;
	}
	
	
}
