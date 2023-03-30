var products=new Map();
var totalBillAmount=0;
//validate password
function validateLogin()
{
	var validEmail=validateEmail();
	var validPassword=validatePassword();
	return validEmail&&validPassword;
}
function validatePassword()
{
	var password=document.getElementById("password").value;
	var msg=document.getElementById("passwordWarning");
	if(password.length<8)
	{
		msg.innerHTML="**Enter a valid password.(length should be greater than 8).";
		return false;
	}
	return true;
}
//validate email
function validateEmail()
{
	var email=document.getElementById("email").value;
	var length=email.length;
	var msg=document.getElementById("emailWarning");
	if(email.includes('@')!=true||email.includes('.')!=true)
	{
		msg.innerHTML="**Enter a valid email.(It must include '@' and '.').";
		return false;
	}
	if(email.startsWith('@')||email.endsWith('@'))
	{
		msg.innerHTML="**Enter a valid email.(It cannot start with '@').";
		return false;
	}
	if((email.lastIndexOf('.')!=length-3)&&(email.lastIndexOf('.')!=length-4))
	{
		msg.innerHTML="**Enter a valid email.(Check position of '.').";
		return false;
	}
	return true;
}
function submitBillForm(billNumber)
{
	var formField=document.getElementById("billNumber");
	var form=document.getElementById("deleteBillForm");
	formField.value=billNumber;
	form.submit();
}
function submitUserForm(id)
{
	var formField=document.getElementById("userID");
	formField.value=id;
	var form=document.getElementById("deleteUserForm");
	form.submit();
}
function productFormSubmit(id)
{
	var formField=document.getElementById("pID");
	formField.value=id;
	var form=document.getElementById("deleteProductForm");
	form.submit();
}
function getProductID(id)
{
	var productIDField=document.getElementById("productID");
	productIDField.value=id;
}
function getOldCategoryName(oldname)
{
	var formField=document.getElementById("oldCatName");
	formField.value=oldname;
	console.log(formField.value);
}
function adminField()
{
	var area=document.getElementById("area");
	var type=document.getElementById("userType").value;
	var div=document.getElementById("adminDiv");
	if(type==="admin")
	{
		div.removeAttribute('hidden');
	}
	if(type==="normal")
	{
		div.setAttribute('hidden','');
	}
}

function productPrice()
{
	var select=document.getElementById("product");	
	var value=select.value;
	var pricefield=document.getElementById("price");
	pricefield.value=value;
}

function addProducts()
{
 var table=document.getElementById('addedProductsTable');
 var select=document.getElementById('product');
 var option=select.options[select.selectedIndex].text;
 var product=option;
 var price=document.getElementById('price').value;
 var quantity=document.getElementById('quantity').value;
 var total=parseInt(price)*parseInt(quantity);
 document.getElementById("totalAmountBtn").innerHTML=total;
 totalBillAmount+=total;
 document.getElementById("totalBillAmount").value=totalBillAmount;
 var row=table.insertRow(1);
 var col1=row.insertCell(0);
 var col2=row.insertCell(1);
 var col3=row.insertCell(2);
 var col4=row.insertCell(3);
 //var col5=row.insertCell(4);
 col1.innerHTML=product;
 col2.innerHTML=price;
 col3.innerHTML=quantity;
 col4.innerHTML=total;
 //col5.innerHTML="<a href='#' style='color:#493240;'><i class='fa fa-trash'></i></a>";  
 if(products.has(product))
 {
	products.set(product,parseInt(products.get(product))+parseInt(quantity));
 } 
 else
 {
	products.set(product,parseInt(quantity));
 }
 var obj=Object.fromEntries(products);
 var allProducts=document.getElementById("allProducts");
 allProducts.value=JSON.stringify(obj);
 resetItems();
 }
function resetItems()
{
	document.getElementById("quantity").value='';
	document.getElementById('product').value='';
	document.getElementById('total').value='';
	document.getElementById('price').value='';
}
function fun()
{
	console.log('button clicked');
}
function getTotal()
{
	var price=document.getElementById('price').value;
    var quantity=document.getElementById('quantity').value;
 	var total=document.getElementById('total');
 	var t=parseInt(price)*parseInt(quantity);
 	total.value=t;
}
function submitForm(id)
{
	var form=document.getElementById("deleteCategoryForm");
	var idField=document.getElementById("catID");
	idField.value=id;
	form.submit();
}
function downloadFile()
{
	
	var name=document.getElementById("name").value;
	var email=document.getElementById("custemail").value;
	var contactNumber=document.getElementById("contactNumber").value;
	var allProducts=document.getElementById("allProducts").value;
	var totalbill=document.getElementById("totalBillAmount").value;
	var table=document.getElementById("billTable");
	var row=table.insertRow(1);
	var col1=row.insertCell(0);
	var col2=row.insertCell(1);
	var col3=row.insertCell(2);
	var col4=row.insertCell(3);
	var col5=row.insertCell(4);
	col1.innerHTML=name;
	col2.innerHTML=email;
	col3.innerHTML=contactNumber;
	col4.innerHTML=allProducts;
	col5.innerHTML=totalbill;
	var element=document.getElementById("preview");
	html2pdf(element);
	var form=document.getElementById("orderForm");
	form.submit();
}
function showdetails()
{
}