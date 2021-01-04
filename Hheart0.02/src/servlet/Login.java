package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DpData;
import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		//UTF-8を利用

		String id =request.getParameter("id");
		String pass =request.getParameter("pass");
		//idとpassにリクエストパラメータを代入。

		User user = new User(id,pass);
		//userにidとpassを代入。

		LoginLogic loginlogic = new LoginLogic();
		boolean mailCheck = loginlogic.mailCheck(user);
		//loginlogicを作って、 boolean型のisLoginにtrue,falseを代入。


		if( mailCheck != false) {
		//mailaddressの型を確認。その後、dpdataでつなぐ。

			DpData dpdata =new DpData();
			String db_url = "jdbc:h2:~/example";
			String db_user = "sa";
			String db_pass = "";


			dpdata.init(db_url, db_user, db_pass);
			System.out.println(dpdata.dbConnect());

			String user_id = user.getid();
			String password = user.getPass();
			System.out.println("LoginResult...");
			System.out.println(dpdata.findSingleUser(user_id, password));
				if(dpdata.findSingleUser(user_id, password)) {
							//sessionスコープを sessionに保存。
							HttpSession session = request.getSession();
							session.setAttribute("loginUser", user);
							System.out.println(user.getid());
							//loginUser型でuserを保存
				}else {
					HttpSession session = request.getSession();
					if(session.getAttribute("loginUser") != null) {
						session.removeAttribute("loginUser");
					}
					System.out.println("ログインに失敗しました。");
				}

		}else {
			System.out.println("mailCheckの要件に適合しないです。");
		}

	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
	dispatcher.forward(request, response);
			//forward00 to Login
	}
}
