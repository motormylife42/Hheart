package model;

import java.util.regex.Pattern;

public class LoginLogic {
	public boolean execute (User user) {

		if(user.getPass().equals("1234")) {return true;}
		//passが1234ならtrueを返す。
		return false;
	}

	public boolean mailCheck (User user) {

	    String pattern = "^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$";
	    Pattern p = Pattern.compile(pattern);

		if(p.matcher(user.getid()).find()) {return true;}
		return false;

	}


}




//0.01update emailのチェック実装 追加でパスワードの値も実装可能かも？

//0.02ではDBのSELECT文でとって来た情報と一致したら返すのように。
//mailaddressとパスワード値をDBと照らし合わせるlogicの作成
