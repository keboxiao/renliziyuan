<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>欢迎登录茂名外包管理系统</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}
-->
</style>
		<script type="text/JavaScript">
<!--
 

function isValid()
{
if(document.form.wnum.value=="")
	{
		window.alert("请填写用户名!");
        document.form.wnum.focus();
	return false;
	}
if(document.form.word.value=="")
	{
	window.alert("请填写密码！");
	document.form.word.focus();
	return false;
	}
}

//-->
</script>
	</head>

	<body>
		<form name="form" id="form" method="post" action="login.action"
			onSubmit="return isValid();">

			<table width="100%" height="100%" border="0" cellpadding="0"
				cellspacing="0">

				<tr>
					<td bgcolor="#02395f">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="607" align="center" background="images/login_02.gif">
						<table width="974" border="0" cellspacing="0" cellpadding="0">

							<tr>
								<td height="331" background="images/login_01.png">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td height="116">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="393" height="116" background="images/login_05.gif">
												&nbsp;
											</td>
											<td width="174">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="81" background="images/login_06.gif">
															<table width="100%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td width="24%">
																		<div align="center">
																			<font
																				style="height: 1; font-size: 9pt; color: #bfdbeb; filter: glow(color = #1070a3, strength = 1)">用户</font>
																		</div>
																	</td>
																	<td width="76%" height="25">
																		<input type="text" name="userAccount"
																			style="width: 125px; height: 20px; background: #32a2e3; font-size: 12px; border: solid 1px #0468a7; color: #14649f;">
																	</td>
																</tr>
																<tr>
																	<td>
																		<div align="center">
																			<font
																				style="height: 1; font-size: 9pt; color: #bfdbeb; filter: glow(color = #1070a3, strength = 1)">密码</font>
																		</div>
																	</td>
																	<td height="25">
																		<input type="password" name="password"
																			style="width: 125px; height: 20px; background: #32a2e3; font-size: 12px; border: solid 1px #0468a7; color: #14649f;">
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td height="35">
															<table width="100%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td width="50" height="35">
																		<img src="images/login_08.gif" width="50" height="35">
																	</td>
																	<td width="46">
																		<INPUT type=image src="images/login_09.gif" width="46"
																			height="35" border="0" value=Submit name=submit>
																	</td>

																	<td width="45">
																		<INPUT type=image src="images/login_10.gif" width="46"
																			height="35" border="0" value=reset name=reset>
																	</td>
																	<td width="33">
																		<img src="images/login_11.gif" width="33" height="35">
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
											<td width="407" background="images/login_07.gif">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>

							<tr>
								<td height="160" background="images/login_12.gif">
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td bgcolor="#02609c">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>

	</body>
</html>
