import java.util.List;

import dao.LoginDAO;
import model.User;

public class selectLoginSample {
	public static void main(String[] args) {
		LoginDAO loginDAO = new LoginDAO();
		List<User> empList = loginDAO.findAll();
		for(User user : empList) {
			// ユーザーの情報を比較する
			if( user.getid().equals("YONGJUN@EXAMPLE.COM") && user.getPass().equals("1234")) {
				//ログイン成功
				System.out.println("aa");
			}else {
				//ログイン失敗
				System.out.println(String.format("userid:%10s pass:%10s", user.getid(), user.getPass()));
				System.out.println("failed");
			}

		}

	}
}
