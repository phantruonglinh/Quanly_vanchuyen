//alert('hello');
const urlware = 'http://localhost:8080/api/warehouse';
const addModalForm = document.querySelector('.form-customer');
const editModalForm = document.querySelector('#editCus .form-customer');
let id = '';

fetch(urlware)
    .then(res => res.json())
    .then(data => {
        data.forEach(warehouse => {
            renderCustomers(warehouse);
        });
    });

const tableCustommers = document.querySelector('#table-customer');
const renderCustomers = (warehouse) => {
    const output = `
        <tr data-id= '${warehouse.warehouseID}'>
                <td>${warehouse.warehouseID}</td>
                <td>${warehouse.warehouseName}</td>
                <td>${warehouse.address}</td>
                <td><a class="btn-edit btn btn-primary btn-sm">Edit</a> |
                    <a class="btn-del btn btn-danger btn-sm">Del</a>
                </td>
        </tr>
    `;
    tableCustommers.insertAdjacentHTML('beforeend', output);
    //delete
    const btndel = document.querySelector(`[data-id = '${warehouse.warehouseID}'] .btn-del`);
    btndel.addEventListener('click', (e) => {
        //console.log('delete!' + customer.customerName);
        fetch(`${urlware}/${warehouse.warehouseID}`, {
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(() => location.reload());
    });
    //edit
    const btnEdit = document.querySelector(`[data-id = '${warehouse.warehouseID}'] .btn-edit`);
    btnEdit.addEventListener('click', (e) => {
        e.preventDefault();
        id = warehouse.warehouseID;
        $("#editCus").modal('show');
        // console.log('edit');
        editModalForm.warehouseName.value = warehouse.warehouseName;
        editModalForm.address.value = warehouse.address;
    })
}

addModalForm.addEventListener('submit', (e) => {
    e.preventDefault();
    // console.log('addModalForm' + addModalForm.customerName.value);
    fetch(urlware, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                warehouseName: addModalForm.warehouseName.value,
                address: addModalForm.address.value,
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
    fetch(`${urlware}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                warehouseName: editModalForm.warehouseName.value,
                address: editModalForm.address.value
            })
        })
        .then(res => res.json())
        .then(() => location.reload())
    editModalForm.warehouseName.value = '';
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