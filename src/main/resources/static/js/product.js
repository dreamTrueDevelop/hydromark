document.addEventListener('DOMContentLoaded', function () {
    document.querySelector('#productForm').addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission

        const form = event.target;
        if (form.checkValidity() === false) {
            event.stopPropagation();
            form.classList.add('was-validated');
            return;
        }

        const formData = new FormData(form);

        fetch('http://localhost:8080/v1/internal/addProduct', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            // Handle the response data
            console.log(data);
            if (data != null) {
                alert('Product added successfully!');
                form.reset();
                form.classList.remove('was-validated');
            } else {
                alert('Failed to add product: ' + data.message);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred. Please try again.');
        });
    });
});
