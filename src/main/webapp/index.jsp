<html>
<body>

	<div style="display: flex; justify-content: center; align-items: center; padding-top: 200px">
	<form action="sendMoney" style="text-align: right;">
	<h1>Add Recipient</h1>
		Recipent Id   : <input type="text" name="id"> <br><br>
		Recipent name : <input type="text" name="name"> <br><br>
		Amount        : <input type="text" name="amt"> <br><br>
		<input type="submit" value="SEND">
	</form>
	</div>

<!-- Delete recipient data -->
	<div>
		<form action="delete">
		<h3>Delete Recipient</h3>
			Recipient Id   : <input type="text" name="id"> <br><br>
			<input type="submit" value="Delete">
		</form>
	</div>
	
<!-- Update recipient amount based on id -->
	<div>
		<form action="update">
		<h3>Add Amount to Recipient</h3>
		Recipent Id   : <input type="text" name="id"> <br><br>
		Amount        : <input type="text" name="amt"> <br><br>
		<input type="submit" value="Update">
		</form>
	</div>	

<!-- Fetch button to display all the recipient data -->
	<div>
		<form action="fetchAll">
		<h3>Fetch all Recipient data</h3>
			<input type="submit" value="FETCH">
		</form>
	</div>

</body>
</html>
