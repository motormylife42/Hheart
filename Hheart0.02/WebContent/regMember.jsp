<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録ページへようこそ！</title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="static/css/index.css">

    <!-- BootstrapのCSS読み込み -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>h-Heart</title>
</head>
<body>
<h3>Half-Heart,出会っていないあなたの半分</h3>
<h6>スレッド型の掲示板で話ながらあなたのハート見つけてください！</h6>
    <!-- ↓会員情報のinputページ -->

    <div class="form-group">
    メールアドレス
    <input type="text" name="id" class="form-control" placeholder="hHeart@example.com" >

    パスワード
    <input type="password" name="pass" class="form-control">


    ユーザネーム
    <div class="input-group mb-3">
  	<span class="input-group-text" id="basic-addon1">@</span>
  	<input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
  	</div>


	性別
	<div class="form-check">
	  <input class="form-check-input" type="radio" name="sex" value ="male" id="man">
	  <label class="form-check-label" for="man">男性</label>
	</div>
	<div class="form-check">
	  <input class="form-check-input" type="radio" name="sex" id="woman" checked>
	  <label class="form-check-label" for="woman">女性</label>
	</div>



    <div class="input-group mb-3">
  		<label class="input-group-text" for="inputGroupSelect01">学歴</label>
 		 <select class="form-select" id="inputGroupSelect01">
    <option selected>選択してください</option>
    <option value="1">高卒</option>
    <option value="2">専門学校卒業</option>
    <option value="3">大学卒業</option>
    <option value="4">大学院卒業</option>
  </select>
	</div>
    年齢
    <div class="input-group">
  		<input type="text" class="form-control">
	    <span class="input-group-text">歳</span>
	</div>
    仕事<input type="text" name="id" class="form-control" >
    年収
        <div class="input-group">
		  <input type="text" class="form-control">
		  <span class="input-group-text">万円</span>
		</div>
    自己紹介
    <div class="mb-3">
    <label for="PR" class="form-label"></label>
     <textarea class="form-control" id="PR" rows="3" ></textarea>
     </div>
    <input type="submit" class="btn btn-primary" value="提出" placeholder="アピールポイントを書いてください。">
    </div>



</body>
</html>