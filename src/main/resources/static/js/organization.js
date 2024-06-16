document.addEventListener('DOMContentLoaded', function () {
    const productSelect = document.querySelector('#productSelect');

    // Fetch products and populate dropdown
    fetch('http://localhost:8080/v1/internal/getProducts')
        .then(response => response.json())
        .then(data => {
            data.forEach(product => {
                const option = document.createElement('option');
                option.textContent = product;
                productSelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Error fetching products:', error);
            alert('Failed to fetch products. Please try again.');
        });

    // Form submission handler
    document.querySelector('#organizationForm').addEventListener('submit', function (event) {
        event.preventDefault();

        const form = event.target;
        if (form.checkValidity() === false) {
            event.stopPropagation();
            form.classList.add('was-validated');
            return;
        }

        const formData = new FormData(form);

        fetch('http://localhost:8080/v1/addEnquiry', {
            method: 'POST',
            headers: new Headers({'content-type': 'application/json'}),
            body: formData
        })

        .then(response => {
            if (response.ok) {
                alert('Organization details submitted successfully!');
                window.location.href = '/'; // Redirect to home page
            } else {
                throw new Error('Failed to submit organization details');
            }
        })
        .catch(error => {
            console.error('Error submitting form:', error);
            alert('Failed to submit organization details. Please try again.');
        });
    });
});
