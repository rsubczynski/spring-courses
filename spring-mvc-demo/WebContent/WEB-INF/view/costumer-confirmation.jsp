<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>
<title>Costumer Confirmation</title>
</head>

<body>
	The costumer is confirmed : ${costumer.firstName} ${costumer.lastName}

	<br>
	<br> Free passes : ${costumer.freePasses}

	<br>
	<br> Postal code : ${costumer.postalCode}
</body>



</html>