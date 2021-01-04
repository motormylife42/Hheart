package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;


// DpData dp_data = new DpData(db_url,db_user,db_pass);
// dp_data.conn();
// db_data.findAll();
// db_data.findSingleUser();

public class DpData {

	private  String DB_URL=null;
	private  String DB_USER=null;
	private  String DB_PASS=null;
	// 接続情報
	private  Connection conn = null;
	//DB情報設定

	public void init(String db_url,String db_user,String db_pass) {
		/*
		 * DB設定情報を取得して設定するメソッド
		 */
		this.DB_URL = db_url;
		this.DB_USER = db_user;
		this.DB_PASS = db_pass;
	}

	public boolean dbConnect() {
		try {
			this.conn = DriverManager.getConnection(this.DB_URL,this.DB_USER,this.DB_PASS);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public List<User>findAll() {
		List<User> empList = new ArrayList<>();

			String sql ="SELECT MAIL,PASS FROM LOGININFO";

			PreparedStatement pStmt;
			try {
				pStmt = this.conn.prepareStatement(sql);
				ResultSet rs = pStmt.executeQuery();
				while(rs.next()) {
					String id = rs.getString("MAIL");
					String pass = rs.getString("PASS");
					User user = new User(id, pass);
					empList.add(user);

				}
				return empList;
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return null;
			}


	}

	public boolean findSingleUser(String user_id, String password) {
		String sql = String.format("SELECT * FROM LOGININFO WHERE MAIL='%s' AND PASS ='%s'",user_id,password);
		System.out.println(sql);
		System.out.println("form_user_id:"+user_id);
		System.out.println("form_password:"+password);
		PreparedStatement pStmt;
		try {
			pStmt = this.conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("MAIL");
				String pass = rs.getString("PASS");
				System.out.println("INFO..");
				System.out.println("LOGINID:"+rs.getString("MAIL"));
				System.out.println("PASS:"+rs.getString("PASS"));
				System.out.println("Result:True");
				return true;
			}
			System.out.println("Result:False");
			return false;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("Result:False");
			return false;
		}
	}

	}

/*
 * form → id,pass →　dao.findsingleset→true ログイン成功 ,false ログイン→失敗
 */

// 明日の目標
// 画面から入力されたメールアドレスのチェック
// →LoginLogicに新しくクラスを新設。正規表現を使い実装完了。
// 画面から入力された内容をデータベースにインサートして保存する(PrimaryKeyを保存する)
// →フロント側の登録ページを作成完了。servlet作成中
// executeQuryの実行結果を考慮してfindSingleUserの結果を取得
// →
// キムチキムチ高収入
// if rs is not None:
// Exception - 継承
// Exception
