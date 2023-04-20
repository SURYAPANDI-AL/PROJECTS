//old elements
var addProductPageDisplay = document.getElementById("addProductPage");
var purchase = document.getElementById("billingPage");

//new elements
var addProductInventory = document.getElementById("add-new-product-to-inventory");
var newBillInventory = document.getElementById("bill-inventory");
var productTableInventory = document.getElementById("ProductTableInventory");
var searchBillInventory = document.getElementById("SearchBillInventory");
var searchBillTableInventory = document.getElementById("searchBillTableInventory");

var obj = new XMLHttpRequest();



//find the bills inbetween specific dates();
function fetchCustomerDetails() {
	let startDate = document.getElementById("start-date-input").value;
	let endDate = document.getElementById("end-date-input").value;

	let today = new Date();

	searchBillTableInventory.classList.remove("d-none");

	var date1 = new Date(startDate);
	var date2 = new Date(endDate);

	if (date1 > date2 || startDate == "" || endDate == "" || date1 > today) {
		window.alert("Invalid date");
	} else {
		obj.onreadystatechange = function() {
			if (obj.readyState == 4) {
				console.log(obj.responseText);
				var billArray = JSON.parse(obj.responseText);
				console.log(billArray);
				searchBillTableInventory.innerHTML = "";
				searchBillTableInventory.innerHTML += `
				<tr>
				 	<th scope="col">#</th>
				 	<th scope="col" >BILL ID</th>
				 	<th scope="col" >CUSTOMER NAME</th>
				 	<th scope="col" >DATE</th>
				 	<th scope="col" >TIME</th>
				 	<th scope="col" >PHONE NUMBER</th>
				 	<th scope="col" >VIEW BILL</th> 	
				 </tr>
				 `;
				for (var i = 0; i < billArray.length; i++) {
					var billObj = billArray[i];
					//log
					console.log(billObj.customerName);

					searchBillTableInventory.innerHTML += `
				 <tr>
				 	<th scope="row">${i + 1}</th>
				 	<td>${billObj.billId}</td>
				 	<td>${billObj.customerName}</td>
				 	<td>${billObj.date}</td>
				 	<td>${billObj.time}</td>
				 	<td>${billObj.phoneNumber}</td>
				 	<td ><input type="button" id="${billObj.billId}"  class="btn mb-3 mx-auto btn-outline-info" data-bs-toggle="modal" data-bs-target="#inventoryModalCustomerBill"ssss  onclick="showBillProductDetails(${billObj.billId})" value="VIEW"/></td>
				 </tr>
				 `;
				}
			}
		}
		obj.open("POST", "http://localhost:8080/InventoryManagement/FetchBillTableServlet");
		obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		obj.send("startDate=" + startDate + "&endDate=" + endDate );
	}

}

//showBillProductDetails

function showBillProductDetails(billId) {

	obj.onreadystatechange = function() {
		if (obj.readyState == 4) {

			var resultInfo = JSON.parse(obj.responseText);

			var viewParticularBillProducts = document.getElementById("viewParticularBillProducts");
			
			viewParticularBillProducts.innerHTML = `	      
        
          <thead>
            <tr>
              <th>Item</th>
              <th>Quantity</th>
              <th>Price</th>
              <th>Total</th>
            </tr>
          </thead>
			`;
			let totalAmountSpent=0;
			for (var i = 0; i < resultInfo.length; i++) {
				var result = resultInfo[i];
				//log
				console.log(result.productName);
				viewParticularBillProducts.innerHTML += `
									<tr>
										<td>${result.productName}</td>
										<td>${result.quantity}</td>
										<td>${result.price}</td>
										<td>${result.totalprice}</td>
									</tr>
								 `;
								totalAmountSpent+=result.totalprice;
			}
			let totalSpent=document.getElementById("totalAmountSpent");
			totalSpent.innerHTML = `
        			<p>TOTAL AMOUNT :<span class="font-weight-bold">${totalAmountSpent}</span></p>
      			
			`;

		}

	}
	obj.open("GET", "http://localhost:8080/InventoryManagement/ParticularBillServlet?billId=" + billId);
	obj.setRequestHeader("Content-Type", "application/x-www-from-urlencoded");
	obj.send();



}
//show the div for search through date;
function findSalesBill() {

	searchBillInventory.classList.remove("d-none");

	if (addProductInventory.classList.add("d-none"))
		addProductInventory.classList.add("d-none");
	if (!newBillInventory.classList.contains("d-none"))
		newBillInventory.classList.add("d-none");
	if (!productTableInventory.classList.contains("d-none"))
		productTableInventory.classList.add("d-none");
	if (!searchBillTableInventory.classList.contains("d-none"))
		searchBillTableInventory.classList.add("d-none");
}


//removeProduct
function removeProduct() {
	showProductsInList();

	var removeProductInventory = document.getElementById("removeProductInventory");
	removeProductInventory.innerHTML = `
				<div class="container ">
				<div class="row justify-content-center ">
					

									<div class="input-group mb-3 mt-3">
										<span class="input-group-text " id="inputGroup-sizing-default">Product ID</span>
										<input type="number"  class="form-control" id="removeProductIdInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
								
				
				</div>
		</div>
		<div class="modal-footer">
		  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		  <button type="button"onclick="remove()" class="btn btn-danger">Remove</button>
			`;

}

function remove() {
	var removeProductIdInput = document.getElementById("removeProductIdInput").value;
	//log
	console.log(removeProductIdInput);
	if (removeProductIdInput == "") {
		window.alert("Invalid input data");
	} else {
		obj.onreadystatechange = function() {
			if (obj.readyState == 4) {
				if (obj.responseText == 1) {
					window.alert("product removed");
					removeProduct();
				} else {
					window.alert("product not found");
				}
			}
		}
		obj.open("POST", "http://localhost:8080/InventoryManagement/RemoveProductServlet");
		obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		obj.send("productId=" + removeProductIdInput);
	}
}

//addProduct
function addProduct() {
	addProductInventory.classList.remove("d-none");

	if (!newBillInventory.classList.contains("d-none"))
		newBillInventory.classList.add("d-none");
	if (!productTableInventory.classList.contains("d-none"))
		productTableInventory.classList.add("d-none");
	if (!searchBillInventory.classList.contains("d-none"))
		searchBillInventory.classList.add("d-none");
	if (!searchBillTableInventory.classList.contains("d-none"))
		searchBillTableInventory.classList.add("d-none");
}

//add bill
function billing() {
	newBillInventory.classList.remove("d-none");

	if (!addProductInventory.classList.contains("d-none"))
		addProductInventory.classList.add("d-none");
	if (!productTableInventory.classList.contains("d-none"))
		productTableInventory.classList.add("d-none");
	if (!searchBillInventory.classList.contains("d-none"))
		searchBillInventory.classList.add("d-none");
	if (!searchBillTableInventory.classList.contains("d-none"))
		searchBillTableInventory.classList.add("d-none");
}

//show products
function showProductsInList() {

	productTableInventory.classList.remove("d-none");

	if (!addProductInventory.classList.contains("d-none"))
		addProductInventory.classList.add("d-none");
	if (!newBillInventory.classList.contains("d-none"))
		newBillInventory.classList.add("d-none");
	if (!searchBillInventory.classList.contains("d-none"))
		searchBillInventory.classList.add("d-none");
	if (!searchBillTableInventory.classList.contains("d-none"))
		searchBillTableInventory.classList.add("d-none");

	productTableInventory.innerHTML = "";
	obj.onreadystatechange = function() {
		if (obj.readyState == 4) {

			var products = JSON.parse(obj.responseText);

			productTableInventory.innerHTML += `
				 <tr>
				 	<th scope="col">#</th>
				 	<th scope="col" >productId</th>
				 	<th scope="col" >productName</th>
				 	<th scope="col" >actualPrice</th>
				 	<th scope="col" >gstPrice</th>
				 	<th scope="col" >stock</th>
				 	<th scope="col" >retailPrice</th> 	
				 	<th scope="col" >gstPercent</th>
				 </tr>
				 `;
			for (var i = 0; i < products.length; i++) {
				var productObj = products[i];
				//log
				console.log(productObj.productId);
				productTableInventory.innerHTML += `
				 <tr>
				 	<th scope="row">${i + 1}</th>
				 	<td>${productObj.productId}</td>
				 	<td>${productObj.productName}</td>
				 	<td>${productObj.actualPrice}</td>
				 	<td>${productObj.gstPrice}</td>
				 	<td>${productObj.stock}</td>
				 	<td>${productObj.retailPrice}</td>
				 	<td>${productObj.gstPercent}</td>
				 </tr>
				 `;
			}
		}
	}
	obj.open("POST", "http://localhost:8080/InventoryManagement/ShowProductServlet");
	obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	obj.send();
}


function add() {

	var name = document.getElementById("product_name_input").value;
	var actualprice = document.getElementById("actualprice_input").value;
	var retailprice = document.getElementById("retail_price_input").value;
	var gstprice = document.getElementById("gst_price_input").value;
	var gstpercent = document.getElementById("gst_percent_input").value;
	var stock = document.getElementById("stock_input").value;
	if(name=="" || actualprice=="" || retailprice=="" || gstprice=="" || gstpercent=="" || stock==""){
		window.alert("invalid data");
		return;
	}
	obj.onreadystatechange = function() {
		debugger;
		if (obj.readyState == 4) {
			var added = obj.responseText;
			console.log(added);
			if (added != 0) {
				window.alert("Product Added Successfully");
				document.getElementById("product_name_input").value="";
				document.getElementById("actualprice_input").value="";
				document.getElementById("retail_price_input").value="";
				document.getElementById("gst_price_input").value="";
				document.getElementById("gst_percent_input").value="";
				document.getElementById("stock_input").value="";				
			} else {
				window.alert("enter valid data");
			}
			addProduct();
		}
	}
	obj.open("POST", "http://localhost:8080/InventoryManagement/AddProductServlet");
	obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	obj.send("name=" + name + "&actualprice=" + actualprice + "&retailprice=" + retailprice + "&gstprice=" + gstprice + "&gstpercent=" + gstpercent + "&stock=" + stock);
}



//update product in the list
function updateProduct() {
	productTableInventory.classList.remove("d-none");

	if (!addProductInventory.classList.contains("d-none"))
		addProductInventory.classList.add("d-none");
	if (!newBillInventory.classList.contains("d-none"))
		newBillInventory.classList.add("d-none");
	if (!searchBillInventory.classList.contains("d-none"))
		searchBillInventory.classList.add("d-none");
	if (!searchBillTableInventory.classList.contains("d-none"))
		searchBillTableInventory.classList.add("d-none");

	productTableInventory.innerHTML = "";
	obj.onreadystatechange = function() {
		if (obj.readyState == 4) {
			var products = JSON.parse(obj.responseText);
			productTableInventory.innerHTML += `
				 <tr>
				 	<th scope="col">#</th>
				 	<th scope="col" >productId</th>
				 	<th scope="col" >productName</th>
				 	<th scope="col" >actualPrice</th>
				 	<th scope="col" >gstPrice</th>
				 	<th scope="col" >stock</th>
				 	<th scope="col" >retailPrice</th>
				 	<th scope="col" >userId</th>
				 	<th scope="col" >gstPercent</th>
				 	<th scope="col" >Edit here</th>
				 </tr>
				 `;
			for (var i = 0; i < products.length; i++) {
				var productObj = products[i];
				productTableInventory.innerHTML += `
				 <tr >
				 	<th scope="row">${i + 1}</th>
				 	<td>${productObj.productId}</td>
				 	<td>${productObj.productName}</td>
				 	<td>${productObj.actualPrice}</td>
				 	<td>${productObj.gstPrice}</td>
				 	<td>${productObj.stock}</td>
				 	<td>${productObj.retailPrice}</td>
				 	<td>${productObj.userId}</td>
				 	<td>${productObj.gstPercent}</td>
				 	<td ><input type="button" id="${productObj.productId}" data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn mb-3 mx-auto btn-outline-secondary" onclick="editProduct(${productObj.productId})" value="EDIT"/></td>
				 </tr>
				 `;
			}
		}
	}
	obj.open("POST", "http://localhost:8080/InventoryManagement/ShowProductServlet");
	obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	obj.send();
}

function editProduct(productId) {
	//log
	console.log(productId);
	obj.onreadystatechange = function() {
		if (obj.readyState == 4) {

			var result = JSON.parse(obj.responseText);

			var productUpdateInventory = document.getElementById("ProductUpdateInventory");
			productUpdateInventory.innerHTML = `
				<div class="container ">
				<div class="row justify-content-center ">
					

									<div class="input-group mb-3 mt-3">
										<span class="input-group-text " id="inputGroup-sizing-default">Name</span>
										<input type="text" value=${result.productName} class="form-control" id="updateProductNameInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
									  <div class="input-group mb-3">
										<span class="input-group-text" id="inputGroup-sizing-default"> Actual Price</span>
										<input type="number" value=${result.actualPrice} class="form-control" id="updateActualPriceInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
									  <div class="input-group mb-3">
										<span class="input-group-text" id="inputGroup-sizing-default"> MRP</span>
										<input type="number" value=${result.retailPrice} class="form-control" id="updateRetailPriceInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
									  <div class="input-group mb-3">
										<span class="input-group-text" id="inputGroup-sizing-default"> GST</span>
										<input type="number" value=${result.gstPrice} class="form-control" id="updateGSTPriceInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
									  <div class="input-group mb-3">
										<span class="input-group-text" id="inputGroup-sizing-default"> GST%</span>
										<input type="number" value=${result.gstPercent} class="form-control" id="updateGSTPercentInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
									  <div class="input-group mb-3">
										<span class="input-group-text" id="inputGroup-sizing-default"> Stock</span>
										<input type="number" value=${result.stock} class="form-control" id="updateStockInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
								
				
				</div>
		</div>
		<div class="modal-footer">
		  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		  <button type="button"onclick="update(${productId})" class="btn btn-primary">Save changes</button>
			`;
		}

	}
	obj.open("GET", "http://localhost:8080/InventoryManagement/UpdateProductServlet?pid=" + productId);
	obj.setRequestHeader("Content-Type", "application/x-www-from-urlencoded");
	obj.send();


}


function update(pId) {
	var updatedName = document.getElementById("updateProductNameInput");
	var updatedActualprice = document.getElementById("updateActualPriceInput");
	var updatedRetailprice = document.getElementById("updateRetailPriceInput");
	var updatedGstprice = document.getElementById("updateGSTPriceInput");
	var updatedGstpercent = document.getElementById("updateGSTPercentInput");
	var updatedStock = document.getElementById("updateStockInput");
	obj.onreadystatechange = function() {
		if (obj.readyState == 4) {
			var updatedValue = obj.responseText;
			if (updatedValue != 0) {
				var x = document.getElementById("toast")
				x.innerHTML = `<div id="img" ><img style="width:25px; height:25px" src="https://cdn-icons-png.flaticon.com/512/686/686339.png"/></div><div id="desc">Successfully Updated..</div>`;
				x.className = "show";
				setTimeout(function() { x.className = x.className.replace("show", ""); }, 5000);
				updateProduct();
			} else {
				window.alert("enter valid credentials");
			}
		}
	}
	obj.open("POST", "http://localhost:8080/InventoryManagement/UpdateFunctionServlet");
	obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	obj.send("name=" + updatedName.value + "&actualprice=" + updatedActualprice.value + "&retailprice=" + updatedRetailprice.value + "&gstprice=" + updatedGstprice.value + "&gstpercent=" + updatedGstpercent.value + "&stock=" + updatedStock.value + "&productId=" + pId);
}



var productNameList = [];
var actualPriceList = [];
var gstPriceList = [];
var retailPriceList = [];
var gstPercentList = [];
var QtyList = [];
var PriceList = [];
var productIdList = [];
var curPrice = 0;
var n = 1;
var x = 0;
function addToBill() {
	var pid = document.getElementById("productIdInput").value;
	if(pid==""){
		window.alert("Enter valid data");
		return;
	}
	obj.onreadystatechange = function() {
		if (obj.readyState == 4) {
			var addRown = document.getElementById("showProductData");
			var newRow = addRown.insertRow(n);
			var resultToBill = JSON.parse(obj.responseText);
			if (resultToBill.stock < document.getElementById("countInput").value) {
				window.alert("Out Of Stock");
			} else {
				productIdList[x] = resultToBill.productId;
				productNameList[x] = resultToBill.productName;
				actualPriceList[x] = resultToBill.actualPrice;
				gstPriceList[x] = resultToBill.gstPrice;
				retailPriceList[x] = resultToBill.retailPrice;
				gstPercentList[x] = resultToBill.gstPercent;
				QtyList[x] = document.getElementById("countInput").value;
				PriceList[x] = document.getElementById("countInput").value * resultToBill.retailPrice;

				var cel1 = newRow.insertCell(0);
				var cel2 = newRow.insertCell(1);
				var cel3 = newRow.insertCell(2);
				var cel4 = newRow.insertCell(3);
				var cel5 = newRow.insertCell(4);
				var cel6 = newRow.insertCell(5);
				var cel7 = newRow.insertCell(6);

				cel1.innerHTML = productNameList[x];
				cel2.innerHTML = actualPriceList[x];
				cel3.innerHTML = gstPriceList[x];
				cel4.innerHTML = retailPriceList[x];
				cel5.innerHTML = gstPercentList[x];
				cel6.innerHTML = QtyList[x];
				cel7.innerHTML = PriceList[x];
				curPrice = curPrice + PriceList[x];
				n++;
				x++;
			}
			var totalPrice = document.getElementById("totalPrice");
			totalPrice.innerHTML = "";
			totalPrice.innerHTML = `<span class="input-group-text" id="inputGroup-sizing-default">TOTAL AMOUNT-${curPrice}</span>`;
		}
	}
	obj.open("GET", "http://localhost:8080/InventoryManagement/UpdateProductServlet?pid=" + pid);
	obj.setRequestHeader("Content-Type", "application/x-www-from-urlencoded");
	obj.send();
}

var customerName;
var customerPhoneNumber;
function validateInfo() {
	customerName = document.getElementById("customerNameInput").value;
	customerPhoneNumber = document.getElementById("phoneNumberInput").value;
	var namePattern = /^[a-zA-Z]+[ a-zA-Z]*$/;
	var contactPattern = /^[6-9]\d{9}$/;

	if (!namePattern.test(customerName))
		alert("Please enter a valid name.");
	else if (!contactPattern.test(customerPhoneNumber))
		alert("Please enter valid mobile number");
	else
		submitBillAjaxCall();
}

//to submit bill for the customer

function submitBillAjaxCall() {

	console.log(productNameList);
	var productNames = "";
	var actualPricesString = "";
	var gstPriceString = "";
	var retailPriceString = "";
	var gstPercentString = "";
	var qtyString = "";
	var priceString = "";
	var productIdString = "";
	for (let i = 0; i < productNameList.length; i++) {
		productNames += productNameList[i] + ",";
		actualPricesString += actualPriceList[i] + ",";
		gstPriceString += gstPriceList[i] + ",";
		retailPriceString += retailPriceList[i] + ",";
		gstPercentString += gstPercentList[i] + ",";
		qtyString += QtyList[i] + ",";
		priceString += PriceList[i] + ",";
		productIdString += productIdList[i] + ",";
	}
	if (qtyString === "") {
		window.alert("null values found!");
		return;
	}
	obj.onreadystatechange = function() {
		if (obj.readyState == 4) {
			var returnBillStatus = obj.responseText;
			if (returnBillStatus == 0) {
				window.alert("Invaild data please check");
			} else {
				window.alert("values added successfully");
				showBill();
				//window.open("home.html");
			}
		}
	}
	obj.open("POST", "http://localhost:8080/InventoryManagement/CreateBillServlet");
	obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	obj.send("productIdString=" + productIdString + "&customerName=" + customerName + "&customerPhoneNumber=" + customerPhoneNumber + "&productNames=" + productNames + "&actualPricesString=" + actualPricesString + "&gstPriceString=" + gstPriceString + "&retailPriceString=" + retailPriceString + "&gstPercentString=" + gstPercentString + "&qtyString=" + qtyString + "&priceString=" + priceString);
}

function billingReset() {
	location.reload();
	window.onload = function() { billing() }
}
function showBill() {
	addProductPageDisplay.style.display = "none";
	purchase.style.display = "none";
	productUpdate.style.display = "none";
	let customerBill = document.getElementById("customerBill");


	customerBill.innerHTML = `<h1>values added successfully</h1>`;
}

function logOut(){
	obj.onreadystatechange=function(){
		if(obj.readyState==4){
			window.open("http://localhost:8080/InventoryManagement/login.html","_self");
		}
	}
	obj.open("POST","http://localhost:8080/InventoryManagement/LogOutServlet");
	obj.setRequestHeader("content-Type","application/x-www-form-urlencoded");
	obj.send();
}