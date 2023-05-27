//alert('hello');
const urltransport = 'http://localhost:8080/api/transportvehicle';
const addModalForm = document.querySelector('.form-customer');
const editModalForm = document.querySelector('#editCus .form-customer');
let id = '';

fetch(urltransport)
    .then(res => res.json())
    .then(data => {
        data.forEach(transportvehicle => {
            renderCustomers(transportvehicle);
        });
    });

const tableCustommers = document.querySelector('#table-customer');
const renderCustomers = (transportvehicle) => {
    const output = `
        <tr data-id= '${transportvehicle.transportVehicleID}'>
                <td>${transportvehicle.transportVehicleID}</td>
                <td>${transportvehicle.transportVehicleName}</td>
                <td>${transportvehicle.status}</td>
                <td>${transportvehicle.capacity}</td>
                <td><a class="btn-edit btn btn-primary btn-sm">Edit</a> |
                    <a class="btn-del btn btn-danger btn-sm">Del</a>
                </td>
        </tr>
    `;
    tableCustommers.insertAdjacentHTML('beforeend', output);
    //delete
    const btndel = document.querySelector(`[data-id = '${transportvehicle.transportVehicleID}'] .btn-del`);
    btndel.addEventListener('click', (e) => {
        //console.log('delete!' + customer.customerName);
        fetch(`${urltransport}/${transportvehicle.transportVehicleID}`, {
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(() => location.reload());
    });
    //edit
    const btnEdit = document.querySelector(`[data-id = '${transportvehicle.transportVehicleID}'] .btn-edit`);
    btnEdit.addEventListener('click', (e) => {
        e.preventDefault();
        id = transportvehicle.transportVehicleID;
        $("#editCus").modal('show');
        // console.log('edit');
        editModalForm.transportVehicleName.value = transportvehicle.transportVehicleName;
        editModalForm.status.value = transportvehicle.status;
        editModalForm.capacity.value = transportvehicle.capacity;
    })
}

addModalForm.addEventListener('submit', (e) => {
    e.preventDefault();
    // console.log('addModalForm' + addModalForm.customerName.value);
    fetch(urltransport, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                transportVehicleName: addModalForm.transportVehicleName.value,
                status: addModalForm.status.value,
                capacity: addModalForm.capacity.value
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
    fetch(`${urltransport}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                transportVehicleName: editModalForm.transportVehicleName.value,
                status: editModalForm.status.value,
                capacity: editModalForm.capacity.value
            })
        })
        .then(res => res.json())
        .then(() => location.reload())
    editModalForm.transportVehicleName.value = '';
    editModalForm.status.value = '';
    editModalForm.capacity.value = '';
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