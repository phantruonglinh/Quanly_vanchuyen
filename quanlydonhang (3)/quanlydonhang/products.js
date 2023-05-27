//alert('hello');
const urlpro = 'http://localhost:8080/api/product';
const addModalForm = document.querySelector('.form-customer');
const editModalForm = document.querySelector('#editCus .form-customer');
let id = '';

fetch(urlpro)
    .then(res => res.json())
    .then(data => {
        data.forEach(product => {
            renderCustomers(product);
        });
    });

const tableCustommers = document.querySelector('#table-customer');
const renderCustomers = (product) => {
    const output = `
        <tr data-id= '${product.productID}'>
                <td>${product.productID}</td>
                <td>${product.productName}</td>
                <td>${product.unitPrice}</td>
                <td>${product.quantity}</td>
                <td>${product.category.categoryID}</td>
                <td>${product.category.categoryName}</td>
                <td>${product.category.description}</td>
                <td><a class="btn-edit btn btn-primary btn-sm">Edit</a> |
                    <a class="btn-del btn btn-danger btn-sm">Del</a>
                </td>
        </tr>
    `;
    tableCustommers.insertAdjacentHTML('beforeend', output);
    //delete
    const btndel = document.querySelector(`[data-id = '${product.productID}'] .btn-del`);
    btndel.addEventListener('click', (e) => {
        //console.log('delete!' + customer.customerName);
        fetch(`${urlpro}/${product.productID}`, {
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(() => location.reload());
    });
    //edit
    const btnEdit = document.querySelector(`[data-id = '${product.productID}'] .btn-edit`);
    btnEdit.addEventListener('click', (e) => {
        e.preventDefault();
        id = product.productID;
        $("#editCus").modal('show');
        // console.log('edit');
        editModalForm.productName.value = product.productName;
        editModalForm.unitPrice.value = product.unitPrice;

        editModalForm.quantity.value = product.quantity;
        editModalForm.categoryID.value = product.category.categoryID;

    })
}

addModalForm.addEventListener('submit', (e) => {
    e.preventDefault();
    // console.log('addModalForm' + addModalForm.customerName.value);
    fetch(urlpro, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                productName: addModalForm.productName.value,
                unitPrice: addModalForm.unitPrice.value,
                quantity: addModalForm.quantity.value,
                categoryID: addModalForm.categoryID.value,

            })
        })
        .then(res => res.json())
        .then(data => {
            const dataArr = [];
            dataArr.push(data);
            renderCustomers(dataArr);
        })
         location.reload() ;
})

editModalForm.addEventListener('submit', (e) => {
    e.preventDefault();
    // console.log('editModalForm');
    fetch(`${urlpro}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                productName: editModalForm.productName.value,
                unitPrice: editModalForm.unitPrice.value,
                quantity: editModalForm.quantity.value,
                categoryID: editModalForm.categoryID.value,
            })
        })
        .then(res => res.json())
        .then(() => location.reload())
    editModalForm.productName.value = '';
    editModalForm.unitPrice.value = '';

    editModalForm.quantity.value = '';
    editModalForm.categoryID.value = '';
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