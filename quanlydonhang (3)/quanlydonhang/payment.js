//alert('hello');
const urlpay = 'http://localhost:8080/api/payment';
const addModalForm = document.querySelector('.form-customer');
const editModalForm = document.querySelector('#editCus .form-customer');
let id = '';

fetch(urlpay)
    .then(res => res.json())
    .then(data => {
        data.forEach(payment => {
            renderCustomers(payment);
        });
    });

const tableCustommers = document.querySelector('#table-customer');
const renderCustomers = (payment) => {
    const output = `
        <tr data-id= '${payment.paymentID}'>
                <td>${payment.paymentID}</td>
                <td>${payment.paymentMethod}</td>
                <td>${payment.paymentAmount}</td>
                <td>${payment.paymentDate}</td>
                <td>${payment.paymentStatus}</td>
                <td><a class="btn-edit btn btn-primary btn-sm">Edit</a> |
                    <a class="btn-del btn btn-danger btn-sm">Del</a>
                </td>
        </tr>
    `;
    tableCustommers.insertAdjacentHTML('beforeend', output);
    //delete
    const btndel = document.querySelector(`[data-id = '${payment.paymentID}'] .btn-del`);
    btndel.addEventListener('click', (e) => {
        //console.log('delete!' + customer.customerName);
        fetch(`${urlpay}/${payment.paymentID}`, {
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(() => location.reload());
    });
    //edit
    const btnEdit = document.querySelector(`[data-id = '${payment.paymentID}'] .btn-edit`);
    btnEdit.addEventListener('click', (e) => {
        e.preventDefault();
        id = payment.paymentID;
        $("#editCus").modal('show');
        // console.log('edit');
        editModalForm.paymentMethod.value = payment.paymentMethod;
        editModalForm.paymentAmount.value = payment.paymentAmount;

        editModalForm.paymentDate.value = payment.paymentDate;
        editModalForm.paymentStatus.value = payment.paymentStatus;
    })
}

addModalForm.addEventListener('submit', (e) => {
    e.preventDefault();
    // console.log('addModalForm' + addModalForm.customerName.value);
    fetch(urlpay, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                paymentMethod: addModalForm.paymentMethod.value,
                paymentAmount: addModalForm.paymentAmount.value,

                paymentDate: addModalForm.paymentDate.value,
                paymentStatus: addModalForm.paymentStatus.value

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
    fetch(`${urlpay}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                paymentMethod: editModalForm.paymentMethod.value,
                paymentAmount: editModalForm.paymentAmount.value,
                paymentDate: editModalForm.paymentDate.value,
                paymentStatus: editModalForm.paymentStatus.value,
            })
        })
        .then(res => res.json())
        .then(() => location.reload())
    editModalForm.paymentMethod.value = '';
    editModalForm.paymentAmount.value = '';
    editModalForm.paymentDate.value = '';
    editModalForm.paymentStatus.value = '';
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