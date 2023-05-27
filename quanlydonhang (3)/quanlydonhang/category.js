//alert('hello');
const urlcate = 'http://localhost:8080/api/category';
const addModalForm = document.querySelector('.form-customer');
const editModalForm = document.querySelector('#editCus .form-customer');
let id = '';

fetch(urlcate)
    .then(res => res.json())
    .then(data => {
        data.forEach(category => {
            renderCustomers(category);
        });
    });

const tableCustommers = document.querySelector('#table-customer');
const renderCustomers = (category) => {
    const output = `
        <tr data-id= '${category.categoryID}'>
                <td>${category.categoryID}</td>
                <td>${category.categoryName}</td>
                <td>${category.description}</td>
                <td><a class="btn-edit btn btn-primary btn-sm">Edit</a> |
                    <a class="btn-del btn btn-danger btn-sm">Del</a>
                </td>
        </tr>
    `;
    tableCustommers.insertAdjacentHTML('beforeend', output);
    //delete
    const btndel = document.querySelector(`[data-id = '${category.categoryID}'] .btn-del`);
    btndel.addEventListener('click', (e) => {
        //console.log('delete!' + customer.customerName);
        fetch(`${urlcate}/${category.categoryID}`, {
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(() => location.reload());
    });
    //edit
    const btnEdit = document.querySelector(`[data-id = '${category.categoryID}'] .btn-edit`);
    btnEdit.addEventListener('click', (e) => {
        e.preventDefault();
        id = category.categoryID;
        $("#editCus").modal('show');
        // console.log('edit');
        editModalForm.categoryName.value = category.categoryName;
        editModalForm.description.value = category.description;
    })
}

addModalForm.addEventListener('submit', (e) => {
    e.preventDefault();
    // console.log('addModalForm' + addModalForm.customerName.value);
    fetch(urlcate, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                categoryName: addModalForm.categoryName.value,
                description: addModalForm.description.value,
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
    fetch(`${urlcate}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                categoryName: editModalForm.categoryName.value,
                description: editModalForm.description.value
            })
        })
        .then(res => res.json())
        .then(() => location.reload())
    editModalForm.categoryName.value = '';
    editModalForm.description.value = '';
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