import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> LoginInfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		LoginInfo.put("Test", "TestPassword");
		LoginInfo.put("Mario", "Mushroom");
		LoginInfo.put("Donkey Kong", "Banana");
		
	}
	
	protected HashMap getLoginInfo() {
		return LoginInfo;
	}
}
