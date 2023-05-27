//alert('hello');
const urlOr = 'http://localhost:8080/api/order';
const addModalForm = document.querySelector('.form-order');
const editModalForm = document.querySelector('#editOr .form-order');
let id = '';

fetch(urlOr)
    .then(res => res.json())
    .then(data => {
        data.forEach(order => {
            renderOrders(order);
        });
    });

const tableOrders = document.querySelector('#table-order');

const renderOrders = (order) => {
    const output = `
        <tr data-id="${order.orderID}">
                <td>${order.orderID}</td>
                <td>${order.orderDate}</td>
                <td>${order.deliveryDate}</td>
                <td>${order.totalAmount}</td>
                <td>${order.customer.customerID}</td>
                <td>${order.customer.customerName}</td>
                <td>${order.customer.phoneNumber}</td>
                <td>${order.customer.address}</td>
                <td>${order.transportVehicle.transportVehicleID}</td>
                <td>${order.transportVehicle.transportVehicleName}</td>
                <td>${order.warehouse.warehouseID}
                <td>${order.warehouse.warehouseName}</td>
                <td>${order.warehouse.address}</td>
                <td>${order.products.productID}</td>
                <td>${order.products.productName}</td>
                <td>${order.products.unitPrice}</td>
                <td>${order.products.quantity}</td>
                <td>${order.payment.paymentID}</td>
                <td>${order.payment.paymentMethod}</td>
                <td>${order.payment.paymentAmount}</td>
                <td>${order.payment.paymentDate}</td>
                <td>${order.payment.paymentStatus}</td>
                <td><a class="btn-edit btn btn-primary btn-sm">Edit</a> |
                    <a class="btn-del btn btn-danger btn-sm">Del</a>
                </td>
        </tr>
    `;
    tableOrders.insertAdjacentHTML('beforeend', output);

    // Xóa order
    const btndel = document.querySelector(`[data-id='${order.orderID}'] .btn-del`);
    btndel.addEventListener('click', (e) => {
        fetch(`${urlOr}/${order.orderID}`, {
            method: 'DELETE'
        })
        .then(res => res.json())
        .then(() => {
            // Xóa row từ bảng
            tableOrders.querySelector(`[data-id='${order.orderID}']`).remove();
        });
    });
 
    // Edit order
    const btnEdit = document.querySelector(`[data-id='${order.orderID}'] .btn-edit`);
    btnEdit.addEventListener('click', (e) => {
        e.preventDefault();
        id = order.orderID;
        $("#editOr").modal('show');
        // console.log('edit');
        editModalForm.deliveryDate.value = order.deliveryDate;
        editModalForm.orderDate.value = order.orderDate;
    
        editModalForm.totalAmount.value = order.totalAmount;
        editModalForm.customerID.value = order.customer.customerID;
        editModalForm.productID.value = order.products.productID;
        editModalForm.transportVehicleID.value = order.transportVehicle.transportVehicleID;
        editModalForm.wareHouseID.value = order.warehouse.warehouseID;
        editModalForm.paymentID.value = order.payment.paymentID;
    
    });
}
// add order

addModalForm.addEventListener('submit', (e) => {
    e.preventDefault();
    // console.log('addModalForm' + addModalForm.customerName.value);
    fetch(urlOr, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                deliveryDate: addModalForm.deliveryDate.value,
                orderDate: addModalForm.orderDate.value,
                
                totalAmount: addModalForm.totalAmount.value,
                customerID: addModalForm.customerID.value,
                productID: addModalForm.productID.value,
                transportVehicleID: addModalForm.transportVehicleID.value,
                wareHouseID: addModalForm.wareHouseID.value,
                paymentID: addModalForm.paymentID.value,
                
            
            })
        })
        .then(res => res.json())
        .then(data => {
            const dataArr = [];
            dataArr.push(data);
            renderOrders(dataArr);
        })
        location.reload();
})

editModalForm.addEventListener('submit', (e) => {
    e.preventDefault();
    // console.log('editModalForm');
    fetch(`${urlOr}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                deliveryDate: editModalForm.deliveryDate.value,
                orderDate: editModalForm.orderDate.value,
               
                totalAmount: editModalForm.totalAmount.value,
                customerID: editModalForm.customerID.value,
                productID: editModalForm.productID.value,
                transportVehicleID: editModalForm.transportVehicleID.value,
                wareHouseID:editModalForm.wareHouseID.value,
                paymentID: editModalForm.paymentID.value,
                
            
            })
        })
        .then(res => res.json())
        .then(() => location.reload())
    // editModalForm.customerName.value = '';
    // editModalForm.email.value = '';
    // editModalForm.phoneNumber.value = '';
    // editModalForm.address.value = '';
     editModalForm.deliveryDate.value = '';
    editModalForm.orderDate.value= '';
    editModalForm.totalAmount.value= '';
    editModalForm.customerID.value= '';
     editModalForm.productID.value= '';
     editModalForm.transportVehicleID.value= '';
     editModalForm.wareHouseID.value= '';
     editModalForm.paymentID.value= '';
})
const handleSearch = () => {
    const searchQuery = searchInput.value.toLowerCase();
    const customerRows = document.querySelectorAll('#table-order tr[data-id]');
    
    customerRows.forEach(row => {
        const customerName = row.querySelector('td:nth-child(6)').innerText.toLowerCase();
        
        if (customerName.includes(searchQuery)) {
            row.style.display = 'table-row';
        } else {
            row.style.display = 'none';
        }
    });
};

const searchInput = document.getElementById('searchInput');
searchInput.addEventListener('input', handleSearch);