const urlCus = 'http://localhost:8080/api/customer';
const urlView = 'http://localhost:8080/api/customer/{id}/orders';
const addModalForm = document.querySelector('.form-customer');
const editModalForm = document.querySelector('#editCus .form-customer');
const viewModalForm = document.querySelector('#viewOrder .form-customer');
let id; // Khai báo biến id

fetch(urlCus)
    .then(res => res.json())
    .then(data => {
        data.forEach(customer => {
            renderCustomers(customer);
        });    
    });

const tableCustommers = document.querySelector('#table-customer');
const renderCustomers = (customer) => {
    const output = `
        <tr data-id="${customer.customerID}">
                <td>${customer.customerID}</td>
                <td>${customer.customerName}</td>
                <td>${customer.email}</td>
                <td>${customer.phoneNumber}</td>
                <td>${customer.address}</td>
                <td>
                    <a class="btn-edit btn btn-primary btn-sm">Edit</a> |
                    <a class="btn-del btn btn-danger btn-sm">Del</a> |
                    <a class="btn-view btn btn-danger btn-sm">View</a>
                </td>
        </tr>
    `;
    tableCustommers.insertAdjacentHTML('beforeend', output);

    // VIEW ORDER
    fetch(urlView.replace('{id}', customer.customerID))
        .then(res => res.json())
        .then(data => {
            data.forEach(order => {
                renderViews(order);
            });    
        });

    const tableViews = document.querySelector('#table-view');
    const renderViews = (order) => { // Đổi biến view thành order
        const output = `
            <tr data-id="${customer.customerID}">
            <td>${order.orderID}</td>
            <td>${order.orderDate}</td>
            <td>${order.deliveryDate}</td>
            <td>${order.totalAmount}</td>
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

            </tr>
        `;
        tableViews.insertAdjacentHTML('beforeend', output);
    }

    

    //delete
    const btndel = document.querySelector(`[data-id = '${customer.customerID}'] .btn-del`);
    btndel.addEventListener('click', (e) => {
        //console.log('delete!' + customer.customerName);
        fetch(`${urlCus}/${customer.customerID}`,{
            method: 'DELETE'
        })
        .then(res => res.json())
        .then(() => location.reload());
    });
    //edit
    const btnEdit = document.querySelector(`[data-id = '${customer.customerID}'] .btn-edit`);
    btnEdit.addEventListener('click', (e) => {
        e.preventDefault();
        id = customer.customerID;
        $("#editCus").modal('show');
        // console.log('edit');
        editModalForm.customerName.value = customer.customerName;
        editModalForm.email.value = customer.email;
        editModalForm.phoneNumber.value = customer.phoneNumber;
        editModalForm.address.value = customer.address;
    })
    //view
    const btnView = document.querySelector(`[data-id="${customer.customerID}"] .btn-view`);
    btnView.addEventListener('click', (e) => {
        e.preventDefault();
        const customerId = customer.customerID;
        fetch(urlView.replace('{id}', customerId))
            .then(res => res.json())
            .then(data => {
                const tableHeadHTML = tableViews.querySelector('thead').outerHTML; // Lưu trữ phần HTML của thead

                // Clear existing order rows
                 tableViews.innerHTML = '';
                 tableViews.innerHTML = tableHeadHTML; // Gán lại phần HTML của thead vào bảng

                data.forEach(order => {
                    renderViews(order);
                });
                $("#viewOrder").modal('show');
            });
    });
    
    }

addModalForm.addEventListener('submit', (e) => {
    e.preventDefault();
    // console.log('addModalForm' + addModalForm.customerName.value);
    fetch(urlCus, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            customerName: addModalForm.customerName.value,
            email: addModalForm.email.value,
            phoneNumber: addModalForm.phoneNumber.value,
            address: addModalForm.address.value
        })
    })
    .then(res => res.json())
    .then(data => {
        const dataArr = [];
        dataArr.push(data);
        renderCustomers(dataArr);
    })
    .then(() => location.reload());
}) 

editModalForm.addEventListener('submit', (e) => {
    e.preventDefault();
    // console.log('editModalForm');
    fetch(`${urlCus}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify({
            customerName: editModalForm.customerName.value,
            email: editModalForm.email.value,
            phoneNumber: editModalForm.phoneNumber.value,
            address: editModalForm.address.value
        })
    })
    .then(res => res.json())
    .then(() => location.reload())
    editModalForm.customerName.value = '';
    editModalForm.email.value = '';
    editModalForm.phoneNumber.value = '';
    editModalForm.address.value = '';
})

const handleSearch = () => {
    const searchQuery = searchInput.value.toLowerCase();
    const customerRows = document.querySelectorAll('#table-customer tr[data-id]');
    
    customerRows.forEach(row => {
        const customerName = row.querySelector('td:nth-child(2)').innerText.toLowerCase();
        
        if (customerName.includes(searchQuery)) {
            row.style.display = 'table-row';
        } else {
            row.style.display = 'none';
        }
    });
};

const searchInput = document.getElementById('searchInput');
searchInput.addEventListener('input', handleSearch);